package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class c {
    private AdvertAppInfo gAf;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.gAf = advertAppInfo;
    }

    public void byj() {
        xM("click");
        com.baidu.tieba.recapp.report.c.bXC().a(com.baidu.tieba.recapp.report.f.c(this.gAf, 2, 0));
    }

    public void byk() {
        xM("click");
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(this.gAf, 2, 0);
        c.BU("title");
        com.baidu.tieba.recapp.report.c.bXC().a(c);
    }

    public void byl() {
        xM(SmsLoginView.StatEvent.LOGIN_SHOW);
        com.baidu.tieba.recapp.report.c.bXC().a(com.baidu.tieba.recapp.report.f.c(this.gAf, 3, 0));
    }

    public void bym() {
    }

    public void xL(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void xM(String str) {
        com.baidu.tbadk.distribute.a.alG().a(this.gAf, this.mForumId, com.baidu.adp.lib.g.b.d(this.mPostId, 0L), "PB", str, 1);
    }
}
