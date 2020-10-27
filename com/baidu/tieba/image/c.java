package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes21.dex */
public class c {
    private AdvertAppInfo krb;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void c(AdvertAppInfo advertAppInfo) {
        this.krb = advertAppInfo;
    }

    public void Ne(String str) {
        Ng("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.krb, 2, 0);
        c.Rw(str);
        com.baidu.tieba.recapp.report.d.dyN().a(c);
    }

    public void Nf(String str) {
        Ng("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.krb, 706, 0);
        c.Rw(str);
        com.baidu.tieba.recapp.report.d.dyN().a(c);
    }

    public void aku() {
        Ng("show");
        com.baidu.tieba.recapp.report.d.dyN().a(com.baidu.tieba.recapp.report.g.c(this.krb, 3, 0));
    }

    public void Ng(String str) {
        com.baidu.tbadk.distribute.a.bwL().a(this.krb, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PIC_PAGE", str, 1);
    }
}
