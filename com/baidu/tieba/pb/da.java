package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cu f1519a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(cu cuVar) {
        this.f1519a = cuVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.write.m mVar;
        EditText editText;
        EditText editText2;
        mVar = this.f1519a.B;
        String a2 = mVar.a(i);
        if (a2 != null) {
            editText = this.f1519a.F;
            int selectionStart = editText.getSelectionStart();
            editText2 = this.f1519a.F;
            editText2.getText().insert(selectionStart, a2);
        }
    }
}
