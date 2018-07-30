package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class c {
    private AdvertAppInfo eJz;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public c(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(AdvertAppInfo advertAppInfo) {
        this.eJz = advertAppInfo;
    }

    public void aPG() {
        pb("click");
        com.baidu.tieba.recapp.report.c.boi().a(com.baidu.tieba.recapp.report.f.c(this.eJz, 2, 0));
    }

    public void aPH() {
        pb(SmsLoginView.StatEvent.LOGIN_SHOW);
        com.baidu.tieba.recapp.report.c.boi().a(com.baidu.tieba.recapp.report.f.c(this.eJz, 3, 0));
    }

    public void aPI() {
    }

    public void pa(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void pb(String str) {
        com.baidu.tbadk.distribute.a.Hf().a(this.eJz, this.mForumId, com.baidu.adp.lib.g.b.c(this.mPostId, 0L), "PB", str, 1);
    }
}
