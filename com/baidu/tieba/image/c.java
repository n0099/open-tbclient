package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes15.dex */
public class c {
    private AdvertAppInfo jGW;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void c(AdvertAppInfo advertAppInfo) {
        this.jGW = advertAppInfo;
    }

    public void Lo(String str) {
        Lq("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.jGW, 2, 0);
        c.PK(str);
        com.baidu.tieba.recapp.report.d.doi().a(c);
    }

    public void Lp(String str) {
        Lq("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.jGW, 706, 0);
        c.PK(str);
        com.baidu.tieba.recapp.report.d.doi().a(c);
    }

    public void aff() {
        Lq("show");
        com.baidu.tieba.recapp.report.d.doi().a(com.baidu.tieba.recapp.report.g.c(this.jGW, 3, 0));
    }

    public void Lq(String str) {
        com.baidu.tbadk.distribute.a.bri().a(this.jGW, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PIC_PAGE", str, 1);
    }
}
