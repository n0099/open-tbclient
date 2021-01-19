package com.baidu.tieba.yuyinala.liveroom.m;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.PopupWindow;
import androidx.core.graphics.ColorUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.view.web.g;
/* loaded from: classes10.dex */
public class b {
    private CustomMessageListener bSr;
    private PopupWindow.OnDismissListener gIt;
    private Activity mContext;
    private c onh;

    public b(Activity activity) {
        this.mContext = activity;
        Wn();
    }

    public void gT(String str) {
        this.onh = new c(this.mContext);
        this.onh.setOnDismissListener(this.gIt);
        this.onh.getWebView().setBackgroundColor(gW(str));
        g gVar = new g();
        gVar.w(this.mContext).a(this.onh).a(this.onh.getWebView().getSchemeCallback());
        com.baidu.live.view.web.a[] Wm = gVar.Wm();
        for (com.baidu.live.view.web.a aVar : Wm) {
            this.onh.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.onh.Fp(str);
    }

    public void resume() {
        if (this.onh != null && this.onh.isShowing() && this.onh.getWebView() != null) {
            this.onh.getWebView().onResume();
        }
    }

    public void pause() {
        if (this.onh != null && this.onh.isShowing() && this.onh.getWebView() != null) {
            this.onh.getWebView().onPause();
        }
    }

    public void dismiss() {
        if (this.onh != null) {
            this.onh.Wo();
        }
    }

    public void Ei() {
        dismiss();
    }

    public void release() {
        Ei();
        MessageManager.getInstance().unRegisterListener(this.bSr);
    }

    private void Wn() {
        this.bSr = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.m.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.onh != null && b.this.onh.isShowing()) {
                    b.this.onh.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bSr);
    }

    private int gW(String str) {
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
            return (parseInt < 0 || parseInt > 255) ? 0 : ColorUtils.setAlphaComponent(Color.parseColor('#' + queryParameter.substring(0, 6)), parseInt);
        } catch (Exception e) {
            return 0;
        }
    }
}
