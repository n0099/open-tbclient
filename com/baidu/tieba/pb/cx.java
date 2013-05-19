package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements AdapterView.OnItemClickListener {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cr crVar) {
        this.a = crVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.write.m mVar;
        EditText editText;
        EditText editText2;
        mVar = this.a.B;
        String a = mVar.a(i);
        if (a != null) {
            editText = this.a.F;
            int selectionStart = editText.getSelectionStart();
            editText2 = this.a.F;
            editText2.getText().insert(selectionStart, a);
        }
    }
}
