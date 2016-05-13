package com.baidu.tieba.write.write;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ AtListActivity fcp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AtListActivity atListActivity) {
        this.fcp = atListActivity;
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
        String a = com.baidu.adp.lib.util.j.a(editable, null);
        if (a != null) {
            str = this.fcp.fci;
            if (!a.equals(str)) {
                handler = this.fcp.mHandler;
                runnable = this.fcp.fcn;
                handler.removeCallbacks(runnable);
                handler2 = this.fcp.mHandler;
                runnable2 = this.fcp.fcn;
                handler2.postDelayed(runnable2, 300L);
            }
            if (a.length() > 0) {
                textView2 = this.fcp.fcc;
                textView2.setVisibility(0);
                return;
            }
            textView = this.fcp.fcc;
            textView.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.fcp.fci = com.baidu.adp.lib.util.j.a(charSequence, null);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
