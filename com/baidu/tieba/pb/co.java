package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements AdapterView.OnItemClickListener {
    final /* synthetic */ bl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(bl blVar) {
        this.a = blVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.write.m mVar;
        mVar = this.a.J;
        String a = mVar.a(i);
        if (a != null) {
            this.a.a.getText().insert(this.a.a.getSelectionStart(), a);
        }
    }
}
