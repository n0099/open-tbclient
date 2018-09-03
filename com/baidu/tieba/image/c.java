package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class c {
    private AdvertAppInfo eJu;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.eJu = advertAppInfo;
    }

    public void aPD() {
        pd("click");
        com.baidu.tieba.recapp.report.c.boj().a(com.baidu.tieba.recapp.report.f.c(this.eJu, 2, 0));
    }

    public void aPE() {
        pd(SmsLoginView.StatEvent.LOGIN_SHOW);
        com.baidu.tieba.recapp.report.c.boj().a(com.baidu.tieba.recapp.report.f.c(this.eJu, 3, 0));
    }

    public void aPF() {
    }

    public void pc(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void pd(String str) {
        com.baidu.tbadk.distribute.a.Hf().a(this.eJu, this.mForumId, com.baidu.adp.lib.g.b.c(this.mPostId, 0L), "PB", str, 1);
    }
}
