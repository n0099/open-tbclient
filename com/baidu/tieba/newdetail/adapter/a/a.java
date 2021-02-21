package com.baidu.tieba.newdetail.adapter.a;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
/* loaded from: classes8.dex */
public abstract class a<T, V extends TypeAdapter.ViewHolder> extends com.baidu.adp.widget.ListView.a<T, V> {
    private boolean lyE;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
    }

    public void up(boolean z) {
        this.lyE = z;
    }

    public boolean dik() {
        return this.lyE;
    }
}
