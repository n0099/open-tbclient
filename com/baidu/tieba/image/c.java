package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes5.dex */
public class c {
    private AdvertAppInfo hLs;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.hLs = advertAppInfo;
    }

    public void bXu() {
        Dm("click");
        com.baidu.tieba.recapp.report.c.cAJ().a(com.baidu.tieba.recapp.report.f.c(this.hLs, 2, 0));
    }

    public void bXv() {
        Dm("click");
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(this.hLs, 2, 0);
        c.HL("title");
        com.baidu.tieba.recapp.report.c.cAJ().a(c);
    }

    public void bXw() {
        Dm("show");
        com.baidu.tieba.recapp.report.c.cAJ().a(com.baidu.tieba.recapp.report.f.c(this.hLs, 3, 0));
    }

    public void bXx() {
    }

    public void Dl(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void Dm(String str) {
        com.baidu.tbadk.distribute.a.aLq().a(this.hLs, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PB", str, 1);
    }
}
