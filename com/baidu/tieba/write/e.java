package com.baidu.tieba.write;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements TextWatcher {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AtListActivity atListActivity) {
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
        String obj = editable.toString();
        if (obj != null) {
            str = this.a.j;
            if (!obj.equals(str)) {
                handler = this.a.e;
                runnable = this.a.r;
                handler.removeCallbacks(runnable);
                handler2 = this.a.e;
                runnable2 = this.a.r;
                handler2.postDelayed(runnable2, 300L);
            }
            if (obj.length() > 0) {
                button2 = this.a.c;
                button2.setVisibility(0);
                return;
            }
            button = this.a.c;
            button.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText;
        AtListActivity atListActivity = this.a;
        editText = this.a.b;
        atListActivity.j = editText.getText().toString();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
