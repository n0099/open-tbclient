package com.baidu.tieba.write;

import android.widget.EditText;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity bST;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.bST = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        AtListActivity atListActivity = this.bST;
        editText = this.bST.mEditText;
        atListActivity.hI(com.baidu.adp.lib.util.l.a(editText.getText(), ""));
    }
}
