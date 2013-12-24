package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eo implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ ed a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(ed edVar) {
        this.a = edVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.a.H != null) {
            this.a.H.onLongClick(view);
            return false;
        }
        return false;
    }
}
