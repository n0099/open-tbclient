package com.baidu.tieba.write;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements TextWatcher {
    final /* synthetic */ AtListActivity cfy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AtListActivity atListActivity) {
        this.cfy = atListActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        TextView textView;
        TextView textView2;
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        String a = com.baidu.adp.lib.util.k.a(editable, null);
        if (a != null) {
            str = this.cfy.cfs;
            if (!a.equals(str)) {
                handler = this.cfy.mHandler;
                runnable = this.cfy.cfx;
                handler.removeCallbacks(runnable);
                handler2 = this.cfy.mHandler;
                runnable2 = this.cfy.cfx;
                handler2.postDelayed(runnable2, 300L);
            }
            if (a.length() > 0) {
                textView2 = this.cfy.cfm;
                textView2.setVisibility(0);
                return;
            }
            textView = this.cfy.cfm;
            textView.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.cfy.cfs = com.baidu.adp.lib.util.k.a(charSequence, null);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
