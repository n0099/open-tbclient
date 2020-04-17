package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes8.dex */
public class c {
    private AdvertAppInfo iCy;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.iCy = advertAppInfo;
    }

    public void clb() {
        Fv("click");
        com.baidu.tieba.recapp.report.d.cOl().a(com.baidu.tieba.recapp.report.g.c(this.iCy, 2, 0));
    }

    public void clc() {
        Fv("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.iCy, 2, 0);
        c.JO("title");
        com.baidu.tieba.recapp.report.d.cOl().a(c);
    }

    public void cld() {
        Fv("show");
        com.baidu.tieba.recapp.report.d.cOl().a(com.baidu.tieba.recapp.report.g.c(this.iCy, 3, 0));
    }

    public void cle() {
    }

    public void Fu(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void Fv(String str) {
        com.baidu.tbadk.distribute.a.aWD().a(this.iCy, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PB", str, 1);
    }
}
