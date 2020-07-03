package com.baidu.tieba.newdetail.adapter.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.ad.a;
/* loaded from: classes8.dex */
public abstract class a<T, V extends ad.a> extends com.baidu.adp.widget.ListView.a<T, V> {
    private boolean jNH;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public void qY(boolean z) {
        this.jNH = z;
    }

    public boolean cEc() {
        return this.jNH;
    }
}
