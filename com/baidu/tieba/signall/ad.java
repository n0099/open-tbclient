package com.baidu.tieba.signall;

import android.content.Context;
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.base.e {
    private af bLO;
    private ae bLP;
    private String mForumId;
    private String mForumName;

    public ad(Context context) {
        super(context);
        this.mForumName = null;
        this.mForumId = null;
        this.bLO = null;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void adj() {
        if (this.bLO != null) {
            this.bLO.cancel();
            this.bLO = null;
        }
    }

    public void az(String str, String str2) {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && this.bLO == null) {
            this.mForumName = str;
            this.mForumId = str2;
            this.bLO = new af(this, null);
            this.bLO.setPriority(2);
            this.bLO.execute(new Object[0]);
        }
    }

    public void a(ae aeVar) {
        this.bLP = aeVar;
    }
}
