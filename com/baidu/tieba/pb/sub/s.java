package com.baidu.tieba.pb.sub;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(m mVar) {
        this.a = mVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.a.L != null) {
            this.a.L.onLongClick(view);
            return false;
        }
        return false;
    }
}
