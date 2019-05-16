package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class c {
    private AdvertAppInfo gRe;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.gRe = advertAppInfo;
    }

    public void bFN() {
        yY("click");
        com.baidu.tieba.recapp.report.c.cfE().a(com.baidu.tieba.recapp.report.f.c(this.gRe, 2, 0));
    }

    public void bFO() {
        yY("click");
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(this.gRe, 2, 0);
        c.Dn("title");
        com.baidu.tieba.recapp.report.c.cfE().a(c);
    }

    public void bFP() {
        yY(SmsLoginView.StatEvent.LOGIN_SHOW);
        com.baidu.tieba.recapp.report.c.cfE().a(com.baidu.tieba.recapp.report.f.c(this.gRe, 3, 0));
    }

    public void bFQ() {
    }

    public void yX(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void yY(String str) {
        com.baidu.tbadk.distribute.a.aqF().a(this.gRe, this.mForumId, com.baidu.adp.lib.g.b.c(this.mPostId, 0L), "PB", str, 1);
    }
}
