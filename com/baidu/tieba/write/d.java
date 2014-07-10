package com.baidu.tieba.write;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
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
        String a = com.baidu.adp.lib.util.i.a(editable, null);
        if (a != null) {
            str = this.a.j;
            if (!a.equals(str)) {
                handler = this.a.h;
                runnable = this.a.v;
                handler.removeCallbacks(runnable);
                handler2 = this.a.h;
                runnable2 = this.a.v;
                handler2.postDelayed(runnable2, 300L);
            }
            if (a.length() > 0) {
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
        this.a.j = com.baidu.adp.lib.util.i.a(charSequence, null);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
