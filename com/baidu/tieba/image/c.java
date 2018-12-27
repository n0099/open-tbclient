package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class c {
    private AdvertAppInfo fjs;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.fjs = advertAppInfo;
    }

    public void aXg() {
        qQ(AiAppsUBCStatistic.TYPE_CLICK);
        com.baidu.tieba.recapp.report.c.bwf().a(com.baidu.tieba.recapp.report.f.c(this.fjs, 2, 0));
    }

    public void aXh() {
        qQ("show");
        com.baidu.tieba.recapp.report.c.bwf().a(com.baidu.tieba.recapp.report.f.c(this.fjs, 3, 0));
    }

    public void aXi() {
    }

    public void qP(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, AiAppsApsUtils.APP_NAME, str);
    }

    public void qQ(String str) {
        com.baidu.tbadk.distribute.a.LL().a(this.fjs, this.mForumId, com.baidu.adp.lib.g.b.d(this.mPostId, 0L), "PB", str, 1);
    }
}
