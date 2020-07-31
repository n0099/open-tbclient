package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes15.dex */
public class c {
    private AdvertAppInfo jrW;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.jrW = advertAppInfo;
    }

    public void czx() {
        Iy("click");
        com.baidu.tieba.recapp.report.d.dcY().a(com.baidu.tieba.recapp.report.g.c(this.jrW, 2, 0));
    }

    public void czy() {
        Iy("click");
        com.baidu.tieba.recapp.report.c c = com.baidu.tieba.recapp.report.g.c(this.jrW, 2, 0);
        c.MN("title");
        com.baidu.tieba.recapp.report.d.dcY().a(c);
    }

    public void YW() {
        Iy("show");
        com.baidu.tieba.recapp.report.d.dcY().a(com.baidu.tieba.recapp.report.g.c(this.jrW, 3, 0));
    }

    public void czz() {
    }

    public void Ix(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void Iy(String str) {
        com.baidu.tbadk.distribute.a.biw().a(this.jrW, this.mForumId, com.baidu.adp.lib.f.b.toLong(this.mPostId, 0L), "PB", str, 1);
    }
}
