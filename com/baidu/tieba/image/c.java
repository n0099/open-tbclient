package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class c {
    private AdvertAppInfo eBP;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.eBP = advertAppInfo;
    }

    public void aOa() {
        oY("click");
        com.baidu.tieba.recapp.report.b.bpc().a(com.baidu.tieba.recapp.report.e.c(this.eBP, 2, 0));
    }

    public void aOb() {
        oY("show");
        com.baidu.tieba.recapp.report.b.bpc().a(com.baidu.tieba.recapp.report.e.c(this.eBP, 3, 0));
    }

    public void aOc() {
    }

    public void oX(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void oY(String str) {
        com.baidu.tbadk.distribute.a.GR().a(this.eBP, this.mForumId, com.baidu.adp.lib.g.b.c(this.mPostId, 0L), "PB", str, 1);
    }
}
