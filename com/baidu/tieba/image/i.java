package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class i {
    private com.baidu.tbadk.core.data.b cfq;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public i(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void c(com.baidu.tbadk.core.data.b bVar) {
        this.cfq = bVar;
    }

    public void adV() {
        jl("area_download");
    }

    public void adW() {
        jl("btn_click");
    }

    public void adX() {
        jl("show");
    }

    public void adY() {
        jl("btn_download");
    }

    public void adZ() {
        jl("area_click");
    }

    public void jk(String str) {
        TiebaStatic.eventStat(this.mContext, "frs_dl_app", null, 1, "app_name", str);
    }

    public void jl(String str) {
        com.baidu.tbadk.distribute.a.Bf().a(this.mContext, this.cfq, str, "pb", this.mForumId, com.baidu.adp.lib.h.b.c(this.mPostId, 0L));
    }
}
