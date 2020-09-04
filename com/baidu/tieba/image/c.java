package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes15.dex */
public class c {
    private AdvertAppInfo jHc;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void c(AdvertAppInfo advertAppInfo) {
        this.jHc = advertAppInfo;
    }

    public void Lp(String str) {
        Lr("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.jHc, 2, 0);
        c.PK(str);
        com.baidu.tieba.recapp.report.d.dol().a(c);
    }

    public void Lq(String str) {
        Lr("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.jHc, 706, 0);
        c.PK(str);
        com.baidu.tieba.recapp.report.d.dol().a(c);
    }

    public void aff() {
        Lr("show");
        com.baidu.tieba.recapp.report.d.dol().a(com.baidu.tieba.recapp.report.g.c(this.jHc, 3, 0));
    }

    public void Lr(String str) {
        com.baidu.tbadk.distribute.a.brj().a(this.jHc, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PIC_PAGE", str, 1);
    }
}
