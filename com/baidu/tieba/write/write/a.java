package com.baidu.tieba.write.write;

import android.widget.EditText;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity cwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.cwI = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        AtListActivity atListActivity = this.cwI;
        editText = this.cwI.mEditText;
        atListActivity.jg(com.baidu.adp.lib.util.m.a(editText.getText(), ""));
    }
}
