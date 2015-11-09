package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class i {
    private com.baidu.tbadk.core.data.b bPd;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public i(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void c(com.baidu.tbadk.core.data.b bVar) {
        this.bPd = bVar;
    }

    public void aap() {
        iR("area_download");
    }

    public void aaq() {
        iR("btn_click");
    }

    public void aar() {
        iR("show");
    }

    public void aas() {
        iR("btn_download");
    }

    public void aat() {
        iR("area_click");
    }

    public void iQ(String str) {
        TiebaStatic.eventStat(this.mContext, "frs_dl_app", null, 1, "app_name", str);
    }

    public void iR(String str) {
        com.baidu.tbadk.distribute.a.Ai().a(this.mContext, this.bPd, str, "pb", this.mForumId, com.baidu.adp.lib.g.b.c(this.mPostId, 0L));
    }
}
