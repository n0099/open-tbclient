package com.baidu.tieba.signall;

import android.content.Context;
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.base.e {
    private af bMd;
    private ae bMe;
    private String mForumId;
    private String mForumName;

    public ad(Context context) {
        super(context);
        this.mForumName = null;
        this.mForumId = null;
        this.bMd = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void adm() {
        if (this.bMd != null) {
            this.bMd.cancel();
            this.bMd = null;
        }
    }

    public void az(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.bMd == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.bMd = new af(this, null);
            this.bMd.setPriority(2);
            this.bMd.execute(new Object[0]);
        }
    }

    public void a(ae aeVar) {
        this.bMe = aeVar;
    }
}
