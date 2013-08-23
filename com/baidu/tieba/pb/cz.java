package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cv f1554a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cv cvVar) {
        this.f1554a = cvVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        View.OnLongClickListener onLongClickListener;
        View.OnLongClickListener onLongClickListener2;
        onLongClickListener = this.f1554a.J;
        if (onLongClickListener != null) {
            onLongClickListener2 = this.f1554a.J;
            onLongClickListener2.onLongClick(view);
            return false;
        }
        return false;
    }
}
