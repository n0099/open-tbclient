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
    private c orN;

    public b(Activity activity) {
        this.mContext = activity;
        aag();
    }

    public void ie(String str) {
        this.orN = new c(this.mContext);
        this.orN.setOnDismissListener(this.gMZ);
        this.orN.getWebView().setBackgroundColor(ih(str));
        g gVar = new g();
        gVar.w(this.mContext).a(this.orN).a(this.orN.getWebView().getSchemeCallback());
        com.baidu.live.view.web.a[] aaf = gVar.aaf();
        for (com.baidu.live.view.web.a aVar : aaf) {
            this.orN.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.orN.GA(str);
    }

    public void resume() {
        if (this.orN != null && this.orN.isShowing() && this.orN.getWebView() != null) {
            this.orN.getWebView().onResume();
        }
    }

    public void pause() {
        if (this.orN != null && this.orN.isShowing() && this.orN.getWebView() != null) {
            this.orN.getWebView().onPause();
        }
    }

    public void dismiss() {
        if (this.orN != null) {
            this.orN.aah();
        }
    }

    public void Id() {
        dismiss();
    }

    public void release() {
        Id();
        MessageManager.getInstance().unRegisterListener(this.bXd);
    }

    private void aag() {
        this.bXd = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.m.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.orN != null && b.this.orN.isShowing()) {
                    b.this.orN.dismiss();
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
