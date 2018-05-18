package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class c {
    private AdvertAppInfo eqy;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.eqy = advertAppInfo;
    }

    public void aJf() {
        ol("click");
        com.baidu.tieba.recapp.report.b.bkd().a(com.baidu.tieba.recapp.report.e.c(this.eqy, 2, 0));
    }

    public void aJg() {
        ol("show");
        com.baidu.tieba.recapp.report.b.bkd().a(com.baidu.tieba.recapp.report.e.c(this.eqy, 3, 0));
    }

    public void aJh() {
    }

    public void ok(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void ol(String str) {
        com.baidu.tbadk.distribute.a.Do().a(this.eqy, this.mForumId, com.baidu.adp.lib.g.b.c(this.mPostId, 0L), "PB", str, 1);
    }
}
