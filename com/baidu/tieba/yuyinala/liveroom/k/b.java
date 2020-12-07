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
    private PopupWindow.OnDismissListener gBl;
    private c oou;

    public b(Activity activity) {
        this.beD = activity;
        YP();
    }

    public void ir(String str) {
        this.oou = new c(this.beD);
        this.oou.setOnDismissListener(this.gBl);
        this.oou.getWebView().setBackgroundColor(iu(str));
        g gVar = new g();
        gVar.x(this.beD).a(this.oou).a(this.oou.getWebView().getSchemeCallback());
        com.baidu.live.view.web.a[] YO = gVar.YO();
        for (com.baidu.live.view.web.a aVar : YO) {
            this.oou.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.oou.GD(str);
    }

    public void resume() {
        if (this.oou != null && this.oou.isShowing() && this.oou.getWebView() != null) {
            this.oou.getWebView().onResume();
        }
    }

    public void pause() {
        if (this.oou != null && this.oou.isShowing() && this.oou.getWebView() != null) {
            this.oou.getWebView().onPause();
        }
    }

    public void dismiss() {
        if (this.oou != null) {
            this.oou.YQ();
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
                if (b.this.oou != null && b.this.oou.isShowing()) {
                    b.this.oou.dismiss();
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
