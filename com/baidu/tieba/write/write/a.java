package com.baidu.tieba.write.write;

import android.widget.EditText;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity cBt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.cBt = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        AtListActivity atListActivity = this.cBt;
        editText = this.cBt.mEditText;
        atListActivity.kc(com.baidu.adp.lib.util.m.a(editText.getText(), ""));
    }
}
