package com.baidu.tieba.write;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements TextWatcher {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AtListActivity atListActivity) {
        this.a = atListActivity;
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
            str = this.a.l;
            if (!editable2.equals(str)) {
                handler = this.a.g;
                runnable = this.a.q;
                handler.removeCallbacks(runnable);
                handler2 = this.a.g;
                runnable2 = this.a.q;
                handler2.postDelayed(runnable2, 300L);
            }
            if (editable2.length() > 0) {
                button2 = this.a.d;
                button2.setVisibility(0);
                return;
            }
            button = this.a.d;
            button.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText;
        AtListActivity atListActivity = this.a;
        editText = this.a.c;
        atListActivity.l = editText.getText().toString();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
