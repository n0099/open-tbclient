package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ AtListActivity cBt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AtListActivity atListActivity) {
        this.cBt = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.cBt.mEditText;
        editText.getText().clear();
    }
}
