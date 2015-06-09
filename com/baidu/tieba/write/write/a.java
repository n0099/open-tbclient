package com.baidu.tieba.write.write;

import android.widget.EditText;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity cBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.cBu = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        AtListActivity atListActivity = this.cBu;
        editText = this.cBu.mEditText;
        atListActivity.kc(com.baidu.adp.lib.util.m.a(editText.getText(), ""));
    }
}
