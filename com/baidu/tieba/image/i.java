package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class i {
    private com.baidu.tbadk.core.data.c cnU;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public i(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void d(com.baidu.tbadk.core.data.c cVar) {
        this.cnU = cVar;
    }

    public void ain() {
        jD("area_click");
        jE("click");
        com.baidu.tieba.recapp.report.b.aEK().a(com.baidu.tieba.recapp.report.e.a(this.cnU, "click", 0));
    }

    public void aio() {
        jD("show");
        jE("show");
        com.baidu.tieba.recapp.report.b.aEK().a(com.baidu.tieba.recapp.report.e.a(this.cnU, "show", 0));
    }

    public void aip() {
        jD("area_download");
    }

    public void jC(String str) {
        TiebaStatic.eventStat(this.mContext, "pb_dl_app", null, 1, "app_name", str);
    }

    public void jD(String str) {
        com.baidu.tbadk.distribute.a.Cl().a(this.mContext, this.cnU, str, "pb", this.mForumId, com.baidu.adp.lib.h.b.c(this.mPostId, 0L));
    }

    public void jE(String str) {
        com.baidu.tbadk.distribute.a.Cl().a(this.cnU, this.mForumId, com.baidu.adp.lib.h.b.c(this.mPostId, 0L), "PB", str, 1);
    }
}
