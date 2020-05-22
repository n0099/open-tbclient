package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes8.dex */
public class c {
    private AdvertAppInfo iRs;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.iRs = advertAppInfo;
    }

    public void crz() {
        Hh("click");
        com.baidu.tieba.recapp.report.d.cVk().a(com.baidu.tieba.recapp.report.g.c(this.iRs, 2, 0));
    }

    public void crA() {
        Hh("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.iRs, 2, 0);
        c.LD("title");
        com.baidu.tieba.recapp.report.d.cVk().a(c);
    }

    public void crB() {
        Hh("show");
        com.baidu.tieba.recapp.report.d.cVk().a(com.baidu.tieba.recapp.report.g.c(this.iRs, 3, 0));
    }

    public void crC() {
    }

    public void Hg(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void Hh(String str) {
        com.baidu.tbadk.distribute.a.bcK().a(this.iRs, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PB", str, 1);
    }
}
