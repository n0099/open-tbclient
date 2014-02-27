package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ei implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ ed a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ei(ed edVar) {
        this.a = edVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.a.K != null) {
            this.a.K.onLongClick(view);
            return false;
        }
        return false;
    }
}
