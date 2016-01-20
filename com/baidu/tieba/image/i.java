package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class i {
    private com.baidu.tbadk.core.data.b cju;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public i(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(com.baidu.tbadk.core.data.b bVar) {
        this.cju = bVar;
    }

    public void afe() {
        jz("area_click");
        jA("click");
        com.baidu.tieba.recapp.report.b.axN().a(com.baidu.tieba.recapp.report.e.a(this.cju, "click", 0));
    }

    public void aff() {
        jz("show");
        jA("show");
        com.baidu.tieba.recapp.report.b.axN().a(com.baidu.tieba.recapp.report.e.a(this.cju, "show", 0));
    }

    public void afg() {
        jz("area_download");
    }

    public void jy(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void jz(String str) {
        com.baidu.tbadk.distribute.a.AV().a(this.mContext, this.cju, str, "pb", this.mForumId, com.baidu.adp.lib.h.b.c(this.mPostId, 0L));
    }

    public void jA(String str) {
        com.baidu.tbadk.distribute.a.AV().a(this.cju, this.mForumId, com.baidu.adp.lib.h.b.c(this.mPostId, 0L), "PB", str, 1);
    }
}
