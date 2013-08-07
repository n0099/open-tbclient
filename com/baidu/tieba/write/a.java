package com.baidu.tieba.write;

import android.widget.EditText;
/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f1868a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.f1868a = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        AtListActivity atListActivity = this.f1868a;
        editText = this.f1868a.f1854a;
        atListActivity.c(editText.getText().toString());
    }
}
