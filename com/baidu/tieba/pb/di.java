package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class di implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dd f2122a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(dd ddVar) {
        this.f2122a = ddVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.write.p pVar;
        EditText editText;
        EditText editText2;
        pVar = this.f2122a.C;
        String a2 = pVar.a(i);
        if (a2 != null) {
            editText = this.f2122a.E;
            int selectionStart = editText.getSelectionStart();
            editText2 = this.f2122a.E;
            editText2.getText().insert(selectionStart, a2);
        }
    }
}
