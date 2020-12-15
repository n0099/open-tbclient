package com.baidu.tieba.newdetail.adapter.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.af.a;
/* loaded from: classes21.dex */
public abstract class a<T, V extends af.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    private boolean lpJ;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public void uf(boolean z) {
        this.lpJ = z;
    }

    public boolean dkj() {
        return this.lpJ;
    }
}
