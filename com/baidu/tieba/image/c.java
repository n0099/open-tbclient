package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes8.dex */
public class c {
    private AdvertAppInfo hSH;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.hSH = advertAppInfo;
    }

    public void caA() {
        DM("click");
        com.baidu.tieba.recapp.report.c.cDK().a(com.baidu.tieba.recapp.report.f.c(this.hSH, 2, 0));
    }

    public void caB() {
        DM("click");
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(this.hSH, 2, 0);
        c.Ij("title");
        com.baidu.tieba.recapp.report.c.cDK().a(c);
    }

    public void caC() {
        DM("show");
        com.baidu.tieba.recapp.report.c.cDK().a(com.baidu.tieba.recapp.report.f.c(this.hSH, 3, 0));
    }

    public void caD() {
    }

    public void DL(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void DM(String str) {
        com.baidu.tbadk.distribute.a.aOm().a(this.hSH, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PB", str, 1);
    }
}
