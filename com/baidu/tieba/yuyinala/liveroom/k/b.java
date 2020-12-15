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
    private CustomMessageListener bRw;
    private Activity beD;
    private PopupWindow.OnDismissListener gBn;
    private c oow;

    public b(Activity activity) {
        this.beD = activity;
        YP();
    }

    public void ir(String str) {
        this.oow = new c(this.beD);
        this.oow.setOnDismissListener(this.gBn);
        this.oow.getWebView().setBackgroundColor(iu(str));
        g gVar = new g();
        gVar.x(this.beD).a(this.oow).a(this.oow.getWebView().getSchemeCallback());
        com.baidu.live.view.web.a[] YO = gVar.YO();
        for (com.baidu.live.view.web.a aVar : YO) {
            this.oow.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.oow.GD(str);
    }

    public void resume() {
        if (this.oow != null && this.oow.isShowing() && this.oow.getWebView() != null) {
            this.oow.getWebView().onResume();
        }
    }

    public void pause() {
        if (this.oow != null && this.oow.isShowing() && this.oow.getWebView() != null) {
            this.oow.getWebView().onPause();
        }
    }

    public void dismiss() {
        if (this.oow != null) {
            this.oow.YQ();
        }
    }

    public void IB() {
        dismiss();
    }

    public void release() {
        IB();
        MessageManager.getInstance().unRegisterListener(this.bRw);
    }

    private void YP() {
        this.bRw = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.k.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.oow != null && b.this.oow.isShowing()) {
                    b.this.oow.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bRw);
    }

    private int iu(String str) {
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
