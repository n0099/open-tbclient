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
/* loaded from: classes11.dex */
public class b {
    private CustomMessageListener bXd;
    private PopupWindow.OnDismissListener gMZ;
    private Activity mContext;
    private c orO;

    public b(Activity activity) {
        this.mContext = activity;
        aaf();
    }

    public void ie(String str) {
        this.orO = new c(this.mContext);
        this.orO.setOnDismissListener(this.gMZ);
        this.orO.getWebView().setBackgroundColor(ih(str));
        g gVar = new g();
        gVar.w(this.mContext).a(this.orO).a(this.orO.getWebView().getSchemeCallback());
        com.baidu.live.view.web.a[] aae = gVar.aae();
        for (com.baidu.live.view.web.a aVar : aae) {
            this.orO.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.orO.GB(str);
    }

    public void resume() {
        if (this.orO != null && this.orO.isShowing() && this.orO.getWebView() != null) {
            this.orO.getWebView().onResume();
        }
    }

    public void pause() {
        if (this.orO != null && this.orO.isShowing() && this.orO.getWebView() != null) {
            this.orO.getWebView().onPause();
        }
    }

    public void dismiss() {
        if (this.orO != null) {
            this.orO.aag();
        }
    }

    public void Id() {
        dismiss();
    }

    public void release() {
        Id();
        MessageManager.getInstance().unRegisterListener(this.bXd);
    }

    private void aaf() {
        this.bXd = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.m.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.orO != null && b.this.orO.isShowing()) {
                    b.this.orO.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bXd);
    }

    private int ih(String str) {
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
