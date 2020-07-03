package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes8.dex */
public class c {
    private AdvertAppInfo jjr;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.jjr = advertAppInfo;
    }

    public void cvy() {
        HJ("click");
        com.baidu.tieba.recapp.report.d.cZQ().a(com.baidu.tieba.recapp.report.g.c(this.jjr, 2, 0));
    }

    public void cvz() {
        HJ("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.jjr, 2, 0);
        c.Mf("title");
        com.baidu.tieba.recapp.report.d.cZQ().a(c);
    }

    public void cko() {
        HJ("show");
        com.baidu.tieba.recapp.report.d.cZQ().a(com.baidu.tieba.recapp.report.g.c(this.jjr, 3, 0));
    }

    public void cvA() {
    }

    public void HI(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void HJ(String str) {
        com.baidu.tbadk.distribute.a.beN().a(this.jjr, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PB", str, 1);
    }
}
