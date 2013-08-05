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
    final /* synthetic */ AtListActivity f1899a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AtListActivity atListActivity) {
        this.f1899a = atListActivity;
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
        String editable2 = editable.toString();
        if (editable2 != null) {
            str = this.f1899a.l;
            if (!editable2.equals(str)) {
                handler = this.f1899a.e;
                runnable = this.f1899a.q;
                handler.removeCallbacks(runnable);
                handler2 = this.f1899a.e;
                runnable2 = this.f1899a.q;
                handler2.postDelayed(runnable2, 300L);
            }
            if (editable2.length() > 0) {
                button2 = this.f1899a.b;
                button2.setVisibility(0);
                return;
            }
            button = this.f1899a.b;
            button.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText;
        AtListActivity atListActivity = this.f1899a;
        editText = this.f1899a.f1856a;
        atListActivity.l = editText.getText().toString();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
