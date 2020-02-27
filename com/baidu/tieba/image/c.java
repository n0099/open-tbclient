package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes8.dex */
public class c {
    private AdvertAppInfo hQT;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.hQT = advertAppInfo;
    }

    public void cae() {
        DM("click");
        com.baidu.tieba.recapp.report.c.cDn().a(com.baidu.tieba.recapp.report.f.c(this.hQT, 2, 0));
    }

    public void caf() {
        DM("click");
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(this.hQT, 2, 0);
        c.Ij("title");
        com.baidu.tieba.recapp.report.c.cDn().a(c);
    }

    public void cag() {
        DM("show");
        com.baidu.tieba.recapp.report.c.cDn().a(com.baidu.tieba.recapp.report.f.c(this.hQT, 3, 0));
    }

    public void cah() {
    }

    public void DL(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void DM(String str) {
        com.baidu.tbadk.distribute.a.aOf().a(this.hQT, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PB", str, 1);
    }
}
