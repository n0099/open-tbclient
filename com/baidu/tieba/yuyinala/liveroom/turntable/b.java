package com.baidu.tieba.yuyinala.liveroom.turntable;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.graphics.ColorUtils;
import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.utils.s;
import com.baidu.live.view.web.g;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tieba.yuyinala.liveroom.turntable.a;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes4.dex */
public class b {
    private Activity bIs;
    private CustomMessageListener bIu;
    private a.InterfaceC0899a nSY;
    private a nTa;

    public b(Activity activity) {
        this.bIs = activity;
        Uy();
    }

    public void a(String str, long j, long j2, long j3) {
        this.nTa = new a(this.bIs);
        this.nTa.a(this.nSY);
        this.nTa.Uz().setBackgroundColor(hP(str));
        g gVar = new g();
        gVar.x(this.bIs).a(this.nTa).a(this.nTa.Uz().getSchemeCallback());
        com.baidu.live.view.web.a[] Ux = gVar.Ux();
        for (com.baidu.live.view.web.a aVar : Ux) {
            this.nTa.Uz().addJavascriptInterface(aVar, aVar.getName());
        }
        this.nTa.FZ(b(str, j, j2, j3));
    }

    public void dismiss() {
        if (this.nTa != null) {
            this.nTa.UA();
        }
    }

    private void Uy() {
        this.bIu = new CustomMessageListener(2913123) { // from class: com.baidu.tieba.yuyinala.liveroom.turntable.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (b.this.nTa != null && b.this.nTa.isShowing()) {
                    b.this.nTa.dismiss();
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

    private String b(String str, long j, long j2, long j3) {
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
        sb.append(s.Sc());
        return sb.toString();
    }
}
