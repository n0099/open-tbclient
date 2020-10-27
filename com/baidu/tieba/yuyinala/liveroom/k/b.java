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
    private Activity bIs;
    private CustomMessageListener bIu;
    private PopupWindow.OnDismissListener gnx;
    private c nQH;

    public b(Activity activity) {
        this.bIs = activity;
        Uy();
    }

    public void hM(String str) {
        this.nQH = new c(this.bIs);
        this.nQH.setOnDismissListener(this.gnx);
        this.nQH.Uz().setBackgroundColor(hP(str));
        g gVar = new g();
        gVar.x(this.bIs).a(this.nQH).a(this.nQH.Uz().getSchemeCallback());
        com.baidu.live.view.web.a[] Ux = gVar.Ux();
        for (com.baidu.live.view.web.a aVar : Ux) {
            this.nQH.Uz().addJavascriptInterface(aVar, aVar.getName());
        }
        this.nQH.FZ(str);
    }

    public void resume() {
        if (this.nQH != null && this.nQH.isShowing() && this.nQH.Uz() != null) {
            this.nQH.Uz().onResume();
        }
    }

    public void pause() {
        if (this.nQH != null && this.nQH.isShowing() && this.nQH.Uz() != null) {
            this.nQH.Uz().onPause();
        }
    }

    public void dismiss() {
        if (this.nQH != null) {
            this.nQH.UA();
        }
    }

    public void GS() {
        dismiss();
    }

    public void release() {
        GS();
        MessageManager.getInstance().unRegisterListener(this.bIu);
    }

    private void Uy() {
        this.bIu = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.k.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.nQH != null && b.this.nQH.isShowing()) {
                    b.this.nQH.dismiss();
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bIu);
    }

    private int hP(String str) {
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
