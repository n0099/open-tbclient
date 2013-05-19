package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cr crVar) {
        this.a = crVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        View.OnLongClickListener onLongClickListener;
        onLongClickListener = this.a.K;
        onLongClickListener.onLongClick(view);
        return false;
    }
}
