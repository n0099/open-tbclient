package com.baidu.tieba.yuyinala.liveroom.turntable;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.graphics.ColorUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.utils.t;
import com.baidu.live.view.web.g;
import com.baidu.tieba.yuyinala.liveroom.turntable.a;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes11.dex */
public class b {
    private CustomMessageListener bXd;
    private Activity mContext;
    private a.InterfaceC0911a owU;
    private a owW;

    public b(Activity activity) {
        this.mContext = activity;
        aaf();
    }

    public void b(String str, long j, long j2, long j3) {
        this.owW = new a(this.mContext);
        this.owW.a(this.owU);
        this.owW.getWebView().setBackgroundColor(ih(str));
        g gVar = new g();
        gVar.w(this.mContext).a(this.owW).a(this.owW.getWebView().getSchemeCallback());
        com.baidu.live.view.web.a[] aae = gVar.aae();
        for (com.baidu.live.view.web.a aVar : aae) {
            this.owW.getWebView().addJavascriptInterface(aVar, aVar.getName());
        }
        this.owW.GB(c(str, j, j2, j3));
    }

    public void dismiss() {
        if (this.owW != null) {
            this.owW.aag();
        }
    }

    private void aaf() {
        this.bXd = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.turntable.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.owW != null && b.this.owW.isShowing()) {
                    b.this.owW.dismiss();
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

    private String c(String str, long j, long j2, long j3) {
        StringBuilder sb = new StringBuilder(str);
        if (str.contains("?")) {
            sb.append(ETAG.ITEM_SEPARATOR);
        } else {
            sb.append("?");
        }
        sb.append("live_id=");
        sb.append(j);
        sb.append("&user_id=");
        sb.append(j2);
        sb.append("&anchor_id=");
        sb.append(j3);
        sb.append("&subapp_type=");
        sb.append(TbConfig.getSubappType());
        sb.append("&client_type=");
        sb.append("2");
        sb.append("&_sdk_version=");
        sb.append(TbConfig.SDK_VERSION);
        sb.append("&scene_from=");
        sb.append(t.XF());
        return sb.toString();
    }
}
