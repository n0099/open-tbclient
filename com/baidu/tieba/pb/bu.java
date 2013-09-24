package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1566a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(br brVar) {
        this.f1566a = brVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.write.o oVar;
        oVar = this.f1566a.N;
        String a2 = oVar.a(i);
        if (a2 != null) {
            this.f1566a.f1563a.getText().insert(this.f1566a.f1563a.getSelectionStart(), a2);
        }
    }
}
