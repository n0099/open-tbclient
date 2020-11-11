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
    private Activity bNY;
    private CustomMessageListener bOa;
    private PopupWindow.OnDismissListener gtk;
    private c nXR;

    public b(Activity activity) {
        this.bNY = activity;
        WY();
    }

    public void hT(String str) {
        this.nXR = new c(this.bNY);
        this.nXR.setOnDismissListener(this.gtk);
        this.nXR.WZ().setBackgroundColor(hW(str));
        g gVar = new g();
        gVar.y(this.bNY).a(this.nXR).a(this.nXR.WZ().getSchemeCallback());
        com.baidu.live.view.web.a[] WX = gVar.WX();
        for (com.baidu.live.view.web.a aVar : WX) {
            this.nXR.WZ().addJavascriptInterface(aVar, aVar.getName());
        }
        this.nXR.Gn(str);
    }

    public void resume() {
        if (this.nXR != null && this.nXR.isShowing() && this.nXR.WZ() != null) {
            this.nXR.WZ().onResume();
        }
    }

    public void pause() {
        if (this.nXR != null && this.nXR.isShowing() && this.nXR.WZ() != null) {
            this.nXR.WZ().onPause();
        }
    }

    public void dismiss() {
        if (this.nXR != null) {
            this.nXR.Xa();
        }
    }

    public void Ht() {
        dismiss();
    }

    public void release() {
        Ht();
        MessageManager.getInstance().unRegisterListener(this.bOa);
    }

    private void WY() {
        this.bOa = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.k.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.nXR != null && b.this.nXR.isShowing()) {
                    b.this.nXR.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bOa);
    }

    private int hW(String str) {
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
