package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class c {
    private AdvertAppInfo gRh;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.gRh = advertAppInfo;
    }

    public void bFQ() {
        yY("click");
        com.baidu.tieba.recapp.report.c.cfG().a(com.baidu.tieba.recapp.report.f.c(this.gRh, 2, 0));
    }

    public void bFR() {
        yY("click");
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(this.gRh, 2, 0);
        c.Dn("title");
        com.baidu.tieba.recapp.report.c.cfG().a(c);
    }

    public void bFS() {
        yY(SmsLoginView.StatEvent.LOGIN_SHOW);
        com.baidu.tieba.recapp.report.c.cfG().a(com.baidu.tieba.recapp.report.f.c(this.gRh, 3, 0));
    }

    public void bFT() {
    }

    public void yX(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void yY(String str) {
        com.baidu.tbadk.distribute.a.aqF().a(this.gRh, this.mForumId, com.baidu.adp.lib.g.b.c(this.mPostId, 0L), "PB", str, 1);
    }
}
