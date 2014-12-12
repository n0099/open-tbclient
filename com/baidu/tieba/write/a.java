package com.baidu.tieba.write;

import android.widget.EditText;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ AtListActivity cdZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.cdZ = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        AtListActivity atListActivity = this.cdZ;
        editText = this.cdZ.mEditText;
        atListActivity.iu(com.baidu.adp.lib.util.k.a(editText.getText(), ""));
    }
}
