package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f1520a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bo boVar) {
        this.f1520a = boVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.write.m mVar;
        mVar = this.f1520a.J;
        String a2 = mVar.a(i);
        if (a2 != null) {
            this.f1520a.f1518a.getText().insert(this.f1520a.f1518a.getSelectionStart(), a2);
        }
    }
}
