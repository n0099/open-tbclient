package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dd f2126a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(dd ddVar) {
        this.f2126a = ddVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        View.OnLongClickListener onLongClickListener;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.f2126a.I;
        if (onLongClickListener != null) {
            onLongClickListener2 = this.f2126a.I;
            onLongClickListener2.onLongClick(view);
            return false;
        }
        return false;
    }
}
