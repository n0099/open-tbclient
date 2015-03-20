package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ AtListActivity cwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AtListActivity atListActivity) {
        this.cwI = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.cwI.mEditText;
        editText.getText().clear();
    }
}
