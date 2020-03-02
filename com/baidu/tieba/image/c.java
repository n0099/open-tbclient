package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes8.dex */
public class c {
    private AdvertAppInfo hQV;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.hQV = advertAppInfo;
    }

    public void cag() {
        DM("click");
        com.baidu.tieba.recapp.report.c.cDp().a(com.baidu.tieba.recapp.report.f.c(this.hQV, 2, 0));
    }

    public void cah() {
        DM("click");
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(this.hQV, 2, 0);
        c.Ij("title");
        com.baidu.tieba.recapp.report.c.cDp().a(c);
    }

    public void cai() {
        DM("show");
        com.baidu.tieba.recapp.report.c.cDp().a(com.baidu.tieba.recapp.report.f.c(this.hQV, 3, 0));
    }

    public void caj() {
    }

    public void DL(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void DM(String str) {
        com.baidu.tbadk.distribute.a.aOh().a(this.hQV, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PB", str, 1);
    }
}
