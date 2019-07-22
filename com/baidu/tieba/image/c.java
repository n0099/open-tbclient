package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class c {
    private AdvertAppInfo gXt;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.gXt = advertAppInfo;
    }

    public void bIy() {
        zL("click");
        com.baidu.tieba.recapp.report.c.ciy().a(com.baidu.tieba.recapp.report.f.c(this.gXt, 2, 0));
    }

    public void bIz() {
        zL("click");
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(this.gXt, 2, 0);
        c.Ec("title");
        com.baidu.tieba.recapp.report.c.ciy().a(c);
    }

    public void bIA() {
        zL(SmsLoginView.StatEvent.LOGIN_SHOW);
        com.baidu.tieba.recapp.report.c.ciy().a(com.baidu.tieba.recapp.report.f.c(this.gXt, 3, 0));
    }

    public void bIB() {
    }

    public void zK(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void zL(String str) {
        com.baidu.tbadk.distribute.a.arL().a(this.gXt, this.mForumId, com.baidu.adp.lib.g.b.c(this.mPostId, 0L), "PB", str, 1);
    }
}
