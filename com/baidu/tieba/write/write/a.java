package com.baidu.tieba.write.write;

import android.widget.EditText;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity cxb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.cxb = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        AtListActivity atListActivity = this.cxb;
        editText = this.cxb.mEditText;
        atListActivity.jj(com.baidu.adp.lib.util.m.a(editText.getText(), ""));
    }
}
