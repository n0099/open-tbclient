package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class c {
    private AdvertAppInfo haf;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.haf = advertAppInfo;
    }

    public void bJz() {
        Al("click");
        com.baidu.tieba.recapp.report.c.cjE().a(com.baidu.tieba.recapp.report.f.c(this.haf, 2, 0));
    }

    public void bJA() {
        Al("click");
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(this.haf, 2, 0);
        c.ED("title");
        com.baidu.tieba.recapp.report.c.cjE().a(c);
    }

    public void bJB() {
        Al(SmsLoginView.StatEvent.LOGIN_SHOW);
        com.baidu.tieba.recapp.report.c.cjE().a(com.baidu.tieba.recapp.report.f.c(this.haf, 3, 0));
    }

    public void bJC() {
    }

    public void Ak(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, DpStatConstants.KEY_APP_NAME, str);
    }

    public void Al(String str) {
        com.baidu.tbadk.distribute.a.arZ().a(this.haf, this.mForumId, com.baidu.adp.lib.g.b.e(this.mPostId, 0L), "PB", str, 1);
    }
}
