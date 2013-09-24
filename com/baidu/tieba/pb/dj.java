package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ db f1607a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(db dbVar) {
        this.f1607a = dbVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.write.o oVar;
        EditText editText;
        EditText editText2;
        oVar = this.f1607a.C;
        String a2 = oVar.a(i);
        if (a2 != null) {
            editText = this.f1607a.E;
            int selectionStart = editText.getSelectionStart();
            editText2 = this.f1607a.E;
            editText2.getText().insert(selectionStart, a2);
        }
    }
}
