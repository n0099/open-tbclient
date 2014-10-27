package com.baidu.tieba.write;

import android.widget.EditText;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity bSE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.bSE = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        AtListActivity atListActivity = this.bSE;
        editText = this.bSE.mEditText;
        atListActivity.hI(com.baidu.adp.lib.util.l.a(editText.getText(), ""));
    }
}
