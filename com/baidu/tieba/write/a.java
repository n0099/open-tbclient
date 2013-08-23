package com.baidu.tieba.write;

import android.widget.EditText;
/* loaded from: classes.dex */
class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f1899a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.f1899a = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        AtListActivity atListActivity = this.f1899a;
        editText = this.f1899a.b;
        atListActivity.c(editText.getText().toString());
    }
}
