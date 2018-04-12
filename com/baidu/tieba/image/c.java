package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class c {
    private AdvertAppInfo ept;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.ept = advertAppInfo;
    }

    public void aJg() {
        oi("click");
        com.baidu.tieba.recapp.report.b.bke().a(com.baidu.tieba.recapp.report.e.c(this.ept, 2, 0));
    }

    public void aJh() {
        oi("show");
        com.baidu.tieba.recapp.report.b.bke().a(com.baidu.tieba.recapp.report.e.c(this.ept, 3, 0));
    }

    public void aJi() {
    }

    public void oh(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void oi(String str) {
        com.baidu.tbadk.distribute.a.Dq().a(this.ept, this.mForumId, com.baidu.adp.lib.g.b.c(this.mPostId, 0L), "PB", str, 1);
    }
}
