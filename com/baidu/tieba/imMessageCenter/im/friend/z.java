package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ t btl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(t tVar) {
        this.btl = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.btl.mEditText;
        editText.getText().clear();
    }
}
