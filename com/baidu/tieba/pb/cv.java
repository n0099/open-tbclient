package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f1265a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cr crVar) {
        this.f1265a = crVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        View.OnLongClickListener onLongClickListener;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.f1265a.J;
        if (onLongClickListener != null) {
            onLongClickListener2 = this.f1265a.J;
            onLongClickListener2.onLongClick(view);
            return false;
        }
        return false;
    }
}
