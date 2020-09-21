package com.baidu.tieba.newdetail.adapter.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.af.a;
/* loaded from: classes20.dex */
public abstract class a<T, V extends af.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    private boolean kuj;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public void st(boolean z) {
        this.kuj = z;
    }

    public boolean cWg() {
        return this.kuj;
    }
}
