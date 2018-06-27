package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class c {
    private AdvertAppInfo eFF;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.eFF = advertAppInfo;
    }

    public void aOG() {
        oZ("click");
        com.baidu.tieba.recapp.report.b.bpD().a(com.baidu.tieba.recapp.report.e.c(this.eFF, 2, 0));
    }

    public void aOH() {
        oZ(SmsLoginView.StatEvent.LOGIN_SHOW);
        com.baidu.tieba.recapp.report.b.bpD().a(com.baidu.tieba.recapp.report.e.c(this.eFF, 3, 0));
    }

    public void aOI() {
    }

    public void oY(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void oZ(String str) {
        com.baidu.tbadk.distribute.a.Hj().a(this.eFF, this.mForumId, com.baidu.adp.lib.g.b.c(this.mPostId, 0L), "PB", str, 1);
    }
}
