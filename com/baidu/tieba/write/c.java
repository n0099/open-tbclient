package com.baidu.tieba.write;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements TextWatcher {
    final /* synthetic */ AtListActivity bST;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AtListActivity atListActivity) {
        this.bST = atListActivity;
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
        String a = com.baidu.adp.lib.util.l.a(editable, null);
        if (a != null) {
            str = this.bST.bSN;
            if (!a.equals(str)) {
                handler = this.bST.mHandler;
                runnable = this.bST.bSS;
                handler.removeCallbacks(runnable);
                handler2 = this.bST.mHandler;
                runnable2 = this.bST.bSS;
                handler2.postDelayed(runnable2, 300L);
            }
            if (a.length() > 0) {
                textView2 = this.bST.bSH;
                textView2.setVisibility(0);
                return;
            }
            textView = this.bST.bSH;
            textView.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.bST.bSN = com.baidu.adp.lib.util.l.a(charSequence, null);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
