package com.baidu.tieba.write;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f2656a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AtListActivity atListActivity) {
        this.f2656a = atListActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        Button button;
        Button button2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        String obj = editable.toString();
        if (obj != null) {
            str = this.f2656a.m;
            if (!obj.equals(str)) {
                handler = this.f2656a.f;
                runnable = this.f2656a.v;
                handler.removeCallbacks(runnable);
                handler2 = this.f2656a.f;
                runnable2 = this.f2656a.v;
                handler2.postDelayed(runnable2, 300L);
            }
            if (obj.length() > 0) {
                button2 = this.f2656a.c;
                button2.setVisibility(0);
                return;
            }
            button = this.f2656a.c;
            button.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText;
        AtListActivity atListActivity = this.f2656a;
        editText = this.f2656a.b;
        atListActivity.m = editText.getText().toString();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
