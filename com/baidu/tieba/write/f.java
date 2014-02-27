package com.baidu.tieba.write;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
/* loaded from: classes.dex */
final class f implements TextWatcher {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AtListActivity atListActivity) {
        this.a = atListActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        String str;
        Button button;
        Button button2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        String editable2 = editable.toString();
        if (editable2 != null) {
            str = this.a.m;
            if (!editable2.equals(str)) {
                handler = this.a.h;
                runnable = this.a.x;
                handler.removeCallbacks(runnable);
                handler2 = this.a.h;
                runnable2 = this.a.x;
                handler2.postDelayed(runnable2, 300L);
            }
            if (editable2.length() > 0) {
                button2 = this.a.c;
                button2.setVisibility(0);
                return;
            }
            button = this.a.c;
            button.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText;
        AtListActivity atListActivity = this.a;
        editText = this.a.b;
        atListActivity.m = editText.getText().toString();
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
