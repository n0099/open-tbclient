package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bt f2109a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(bt btVar) {
        this.f2109a = btVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.write.p pVar;
        pVar = this.f2109a.N;
        String a2 = pVar.a(i);
        if (a2 != null) {
            this.f2109a.f2081a.getText().insert(this.f2109a.f2081a.getSelectionStart(), a2);
        }
    }
}
