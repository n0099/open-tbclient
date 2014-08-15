package com.baidu.tieba.write;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements TextWatcher {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AtListActivity atListActivity) {
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
        String a = com.baidu.adp.lib.util.i.a(editable, (String) null);
        if (a != null) {
            str = this.a.m;
            if (!a.equals(str)) {
                handler = this.a.h;
                runnable = this.a.x;
                handler.removeCallbacks(runnable);
                handler2 = this.a.h;
                runnable2 = this.a.x;
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
        this.a.m = com.baidu.adp.lib.util.i.a(charSequence, (String) null);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
