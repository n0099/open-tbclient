package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class c {
    private AdvertAppInfo gYl;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.gYl = advertAppInfo;
    }

    public void bIM() {
        zM("click");
        com.baidu.tieba.recapp.report.c.ciQ().a(com.baidu.tieba.recapp.report.f.c(this.gYl, 2, 0));
    }

    public void bIN() {
        zM("click");
        com.baidu.tieba.recapp.report.b c = com.baidu.tieba.recapp.report.f.c(this.gYl, 2, 0);
        c.Ed("title");
        com.baidu.tieba.recapp.report.c.ciQ().a(c);
    }

    public void bIO() {
        zM(SmsLoginView.StatEvent.LOGIN_SHOW);
        com.baidu.tieba.recapp.report.c.ciQ().a(com.baidu.tieba.recapp.report.f.c(this.gYl, 3, 0));
    }

    public void bIP() {
    }

    public void zL(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void zM(String str) {
        com.baidu.tbadk.distribute.a.arN().a(this.gYl, this.mForumId, com.baidu.adp.lib.g.b.c(this.mPostId, 0L), "PB", str, 1);
    }
}
