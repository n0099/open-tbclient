package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eo implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ed f2262a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eo(ed edVar) {
        this.f2262a = edVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f2262a.H != null) {
            this.f2262a.H.onLongClick(view);
            return false;
        }
        return false;
    }
}
