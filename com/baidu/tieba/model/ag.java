package com.baidu.tieba.model;

import android.content.Context;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.base.e {
    private String bpa;
    private ah bpb;
    private String from;
    private String mForumId;
    private String mForumName;

    public ag(Context context) {
        super(context);
        this.mForumName = null;
        this.mForumId = null;
        this.bpa = null;
        this.bpb = null;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void TF() {
        if (this.bpb != null) {
            this.bpb.cancel();
            this.bpb = null;
        }
    }

    public void o(String str, String str2, String str3) {
        ay(str, str2);
        this.bpa = str3;
    }

    public void ay(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.bpb == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.bpb = new ah(this, null);
            this.bpb.setPriority(2);
            this.bpb.execute(new Object[0]);
        }
    }

    public boolean TG() {
        return this.bpb != null;
    }
}
