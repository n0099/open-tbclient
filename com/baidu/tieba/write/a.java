package com.baidu.tieba.write;

import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f2774a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AtListActivity atListActivity) {
        this.f2774a = atListActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditText editText;
        AtListActivity atListActivity = this.f2774a;
        editText = this.f2774a.b;
        atListActivity.a(editText.getText().toString());
    }
}
