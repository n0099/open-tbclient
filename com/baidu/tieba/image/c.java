package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class c {
    private AdvertAppInfo eYr;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.eYr = advertAppInfo;
    }

    public void aVe() {
        qk(AiAppsUBCStatistic.TYPE_CLICK);
        com.baidu.tieba.recapp.report.c.buf().a(com.baidu.tieba.recapp.report.f.c(this.eYr, 2, 0));
    }

    public void aVf() {
        qk("show");
        com.baidu.tieba.recapp.report.c.buf().a(com.baidu.tieba.recapp.report.f.c(this.eYr, 3, 0));
    }

    public void aVg() {
    }

    public void qj(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, AiAppsApsUtils.APP_NAME, str);
    }

    public void qk(String str) {
        com.baidu.tbadk.distribute.a.Ku().a(this.eYr, this.mForumId, com.baidu.adp.lib.g.b.d(this.mPostId, 0L), "PB", str, 1);
    }
}
