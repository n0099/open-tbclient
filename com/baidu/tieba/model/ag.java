package com.baidu.tieba.model;

import android.content.Context;
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.base.e {
    private String bpo;
    private ah bpp;
    private String from;
    private String mForumId;
    private String mForumName;

    public ag(Context context) {
        super(context);
        this.mForumName = null;
        this.mForumId = null;
        this.bpo = null;
        this.bpp = null;
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

    public void TI() {
        if (this.bpp != null) {
            this.bpp.cancel();
            this.bpp = null;
        }
    }

    public void o(String str, String str2, String str3) {
        ay(str, str2);
        this.bpo = str3;
    }

    public void ay(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.bpp == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.bpp = new ah(this, null);
            this.bpp.setPriority(2);
            this.bpp.execute(new Object[0]);
        }
    }

    public boolean TJ() {
        return this.bpp != null;
    }
}
