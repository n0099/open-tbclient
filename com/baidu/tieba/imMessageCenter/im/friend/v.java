package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ p cwm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(p pVar) {
        this.cwm = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.cwm.cqC;
        editText.getText().clear();
    }
}
