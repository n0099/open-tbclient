package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class c {
    private AdvertAppInfo eQK;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.eQK = advertAppInfo;
    }

    public void aRQ() {
        pI("click");
        com.baidu.tieba.recapp.report.c.bqQ().a(com.baidu.tieba.recapp.report.f.c(this.eQK, 2, 0));
    }

    public void aRR() {
        pI(SmsLoginView.StatEvent.LOGIN_SHOW);
        com.baidu.tieba.recapp.report.c.bqQ().a(com.baidu.tieba.recapp.report.f.c(this.eQK, 3, 0));
    }

    public void aRS() {
    }

    public void pH(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void pI(String str) {
        com.baidu.tbadk.distribute.a.Iv().a(this.eQK, this.mForumId, com.baidu.adp.lib.g.b.d(this.mPostId, 0L), "PB", str, 1);
    }
}
