package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cr f1267a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cr crVar) {
        this.f1267a = crVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.write.m mVar;
        EditText editText;
        EditText editText2;
        mVar = this.f1267a.B;
        String a2 = mVar.a(i);
        if (a2 != null) {
            editText = this.f1267a.F;
            int selectionStart = editText.getSelectionStart();
            editText2 = this.f1267a.F;
            editText2.getText().insert(selectionStart, a2);
        }
    }
}
