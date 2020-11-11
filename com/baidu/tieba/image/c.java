package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes21.dex */
public class c {
    private AdvertAppInfo kwX;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void c(AdvertAppInfo advertAppInfo) {
        this.kwX = advertAppInfo;
    }

    public void Nv(String str) {
        Nx("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.kwX, 2, 0);
        c.RN(str);
        com.baidu.tieba.recapp.report.d.dBp().a(c);
    }

    public void Nw(String str) {
        Nx("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.kwX, 706, 0);
        c.RN(str);
        com.baidu.tieba.recapp.report.d.dBp().a(c);
    }

    public void amU() {
        Nx("show");
        com.baidu.tieba.recapp.report.d.dBp().a(com.baidu.tieba.recapp.report.g.c(this.kwX, 3, 0));
    }

    public void Nx(String str) {
        com.baidu.tbadk.distribute.a.bzk().a(this.kwX, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PIC_PAGE", str, 1);
    }
}
