package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes21.dex */
public class c {
    private AdvertAppInfo keD;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void c(AdvertAppInfo advertAppInfo) {
        this.keD = advertAppInfo;
    }

    public void MG(String str) {
        MI("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.keD, 2, 0);
        c.QY(str);
        com.baidu.tieba.recapp.report.d.dvG().a(c);
    }

    public void MH(String str) {
        MI("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.keD, 706, 0);
        c.QY(str);
        com.baidu.tieba.recapp.report.d.dvG().a(c);
    }

    public void aiA() {
        MI("show");
        com.baidu.tieba.recapp.report.d.dvG().a(com.baidu.tieba.recapp.report.g.c(this.keD, 3, 0));
    }

    public void MI(String str) {
        com.baidu.tbadk.distribute.a.buS().a(this.keD, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PIC_PAGE", str, 1);
    }
}
