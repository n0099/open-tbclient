package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes8.dex */
public class c {
    private AdvertAppInfo iCE;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.iCE = advertAppInfo;
    }

    public void ckZ() {
        Fy("click");
        com.baidu.tieba.recapp.report.d.cOi().a(com.baidu.tieba.recapp.report.g.c(this.iCE, 2, 0));
    }

    public void cla() {
        Fy("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.iCE, 2, 0);
        c.JR("title");
        com.baidu.tieba.recapp.report.d.cOi().a(c);
    }

    public void clb() {
        Fy("show");
        com.baidu.tieba.recapp.report.d.cOi().a(com.baidu.tieba.recapp.report.g.c(this.iCE, 3, 0));
    }

    public void clc() {
    }

    public void Fx(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void Fy(String str) {
        com.baidu.tbadk.distribute.a.aWB().a(this.iCE, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PB", str, 1);
    }
}
