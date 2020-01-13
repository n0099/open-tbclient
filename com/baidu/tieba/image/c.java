package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes6.dex */
public class c {
    private AdvertAppInfo hOV;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.hOV = advertAppInfo;
    }

    public void bYD() {
        Dw("click");
        com.baidu.tieba.recapp.report.c.cBP().a(com.baidu.tieba.recapp.report.f.c(this.hOV, 2, 0));
    }

    public void bYE() {
        Dw("click");
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(this.hOV, 2, 0);
        c.HV("title");
        com.baidu.tieba.recapp.report.c.cBP().a(c);
    }

    public void bYF() {
        Dw("show");
        com.baidu.tieba.recapp.report.c.cBP().a(com.baidu.tieba.recapp.report.f.c(this.hOV, 3, 0));
    }

    public void bYG() {
    }

    public void Dv(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void Dw(String str) {
        com.baidu.tbadk.distribute.a.aLJ().a(this.hOV, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PB", str, 1);
    }
}
