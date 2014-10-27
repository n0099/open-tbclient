package com.baidu.tieba.topRec;

import android.content.Context;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.e {
    private boolean avc;
    k bPP;
    l bPQ;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(Context context) {
        super(context);
        this.avc = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        this.bPP = new k(this, null);
        this.bPP.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bPP != null) {
            this.bPP.cancel();
            return false;
        }
        return false;
    }

    public void a(l lVar) {
        this.bPQ = lVar;
    }
}
