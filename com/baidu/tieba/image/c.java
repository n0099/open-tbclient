package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes20.dex */
public class c {
    private AdvertAppInfo jPE;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void c(AdvertAppInfo advertAppInfo) {
        this.jPE = advertAppInfo;
    }

    public void LR(String str) {
        LT("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.jPE, 2, 0);
        c.Qk(str);
        com.baidu.tieba.recapp.report.d.drV().a(c);
    }

    public void LS(String str) {
        LT("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.jPE, 706, 0);
        c.Qk(str);
        com.baidu.tieba.recapp.report.d.drV().a(c);
    }

    public void afP() {
        LT("show");
        com.baidu.tieba.recapp.report.d.drV().a(com.baidu.tieba.recapp.report.g.c(this.jPE, 3, 0));
    }

    public void LT(String str) {
        com.baidu.tbadk.distribute.a.bsi().a(this.jPE, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PIC_PAGE", str, 1);
    }
}
