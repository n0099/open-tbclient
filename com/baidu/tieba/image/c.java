package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class c {
    private AdvertAppInfo gXr;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.gXr = advertAppInfo;
    }

    public void bGh() {
        yD("click");
        com.baidu.tieba.recapp.report.c.cgG().a(com.baidu.tieba.recapp.report.f.c(this.gXr, 2, 0));
    }

    public void bGi() {
        yD("click");
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(this.gXr, 2, 0);
        c.CY("title");
        com.baidu.tieba.recapp.report.c.cgG().a(c);
    }

    public void bGj() {
        yD("show");
        com.baidu.tieba.recapp.report.c.cgG().a(com.baidu.tieba.recapp.report.f.c(this.gXr, 3, 0));
    }

    public void bGk() {
    }

    public void yC(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void yD(String str) {
        com.baidu.tbadk.distribute.a.atL().a(this.gXr, this.mForumId, com.baidu.adp.lib.g.b.toLong(this.mPostId, 0L), "PB", str, 1);
    }
}
