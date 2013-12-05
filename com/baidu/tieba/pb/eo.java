package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eo implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ed f2261a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(ed edVar) {
        this.f2261a = edVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f2261a.H != null) {
            this.f2261a.H.onLongClick(view);
            return false;
        }
        return false;
    }
}
