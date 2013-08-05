package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f1484a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bn bnVar) {
        this.f1484a = bnVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.write.m mVar;
        mVar = this.f1484a.I;
        String a2 = mVar.a(i);
        if (a2 != null) {
            this.f1484a.f1482a.getText().insert(this.f1484a.f1482a.getSelectionStart(), a2);
        }
    }
}
