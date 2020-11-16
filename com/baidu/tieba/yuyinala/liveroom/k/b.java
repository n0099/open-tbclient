package com.baidu.tieba.yuyinala.liveroom.k;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import android.widget.PopupWindow;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.g;
import com.baidu.searchbox.ugc.model.UgcConstant;
/* loaded from: classes4.dex */
public class b {
    private Activity bMo;
    private CustomMessageListener bMq;
    private PopupWindow.OnDismissListener gsR;
    private c nZu;

    public b(Activity activity) {
        this.bMo = activity;
        Wp();
    }

    public void hN(String str) {
        this.nZu = new c(this.bMo);
        this.nZu.setOnDismissListener(this.gsR);
        this.nZu.Wq().setBackgroundColor(hQ(str));
        g gVar = new g();
        gVar.x(this.bMo).a(this.nZu).a(this.nZu.Wq().getSchemeCallback());
        com.baidu.live.view.web.a[] Wo = gVar.Wo();
        for (com.baidu.live.view.web.a aVar : Wo) {
            this.nZu.Wq().addJavascriptInterface(aVar, aVar.getName());
        }
        this.nZu.FO(str);
    }

    public void resume() {
        if (this.nZu != null && this.nZu.isShowing() && this.nZu.Wq() != null) {
            this.nZu.Wq().onResume();
        }
    }

    public void pause() {
        if (this.nZu != null && this.nZu.isShowing() && this.nZu.Wq() != null) {
            this.nZu.Wq().onPause();
        }
    }

    public void dismiss() {
        if (this.nZu != null) {
            this.nZu.Wr();
        }
    }

    public void GK() {
        dismiss();
    }

    public void release() {
        GK();
        MessageManager.getInstance().unRegisterListener(this.bMq);
    }

    private void Wp() {
        this.bMq = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.k.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.nZu != null && b.this.nZu.isShowing()) {
                    b.this.nZu.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bMq);
    }

    private int hQ(String str) {
        int indexOf;
        String queryParameter = Uri.parse(str).getQueryParameter("background");
        if ((TextUtils.isEmpty(queryParameter) || queryParameter.length() != 8) && (indexOf = str.indexOf("background=")) >= 0 && indexOf + 19 <= str.length()) {
            queryParameter = str.substring(indexOf + 11, indexOf + 19);
        }
        if (TextUtils.isEmpty(queryParameter) || queryParameter.length() != 8) {
            return 0;
        }
        try {
            int parseInt = Integer.parseInt(queryParameter.substring(6, 8), 16);
            return (parseInt < 0 || parseInt > 255) ? 0 : ColorUtils.setAlphaComponent(Color.parseColor(UgcConstant.TOPIC_PATTERN_TAG + queryParameter.substring(0, 6)), parseInt);
        } catch (Exception e) {
            return 0;
        }
    }
}
