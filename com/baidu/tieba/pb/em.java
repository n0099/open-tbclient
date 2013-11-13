package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class em implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ eb f2169a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public em(eb ebVar) {
        this.f2169a = ebVar;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f2169a.H != null) {
            this.f2169a.H.onLongClick(view);
            return false;
        }
        return false;
    }
}
