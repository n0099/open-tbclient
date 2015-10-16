package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class i {
    private com.baidu.tbadk.core.data.b bOI;
    private Context mContext;
    private String mForumId;
    private String mPostId;

    public i(Context context, String str, String str2) {
        this.mContext = context;
        this.mForumId = str;
        this.mPostId = str2;
    }

    public void c(com.baidu.tbadk.core.data.b bVar) {
        this.bOI = bVar;
    }

    public void ZY() {
        iP("area_download");
    }

    public void ZZ() {
        iP("btn_click");
    }

    public void aaa() {
        iP("show");
    }

    public void aab() {
        iP("btn_download");
    }

    public void aac() {
        iP("area_click");
    }

    public void iO(String str) {
        TiebaStatic.eventStat(this.mContext, "frs_dl_app", null, 1, "app_name", str);
    }

    public void iP(String str) {
        com.baidu.tbadk.distribute.a.Ag().a(this.mContext, this.bOI, str, "pb", this.mForumId, com.baidu.adp.lib.g.b.c(this.mPostId, 0L));
    }
}
