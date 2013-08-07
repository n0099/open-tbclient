package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cu f1516a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cu cuVar) {
        this.f1516a = cuVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        View.OnLongClickListener onLongClickListener;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.f1516a.J;
        if (onLongClickListener != null) {
            onLongClickListener2 = this.f1516a.J;
            onLongClickListener2.onLongClick(view);
            return false;
        }
        return false;
    }
}
