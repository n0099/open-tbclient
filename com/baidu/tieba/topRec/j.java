package com.baidu.tieba.topRec;

import android.content.Context;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.e {
    private boolean avl;
    k bQe;
    l bQf;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(Context context) {
        super(context);
        this.avl = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        this.bQe = new k(this, null);
        this.bQe.execute(new Object[0]);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bQe != null) {
            this.bQe.cancel();
            return false;
        }
        return false;
    }

    public void a(l lVar) {
        this.bQf = lVar;
    }
}
