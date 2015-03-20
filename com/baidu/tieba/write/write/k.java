package com.baidu.tieba.write.write;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements TextWatcher {
    final /* synthetic */ AtListActivity cwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(AtListActivity atListActivity) {
        this.cwI = atListActivity;
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
        String a = com.baidu.adp.lib.util.m.a(editable, null);
        if (a != null) {
            str = this.cwI.cwC;
            if (!a.equals(str)) {
                handler = this.cwI.mHandler;
                runnable = this.cwI.cwH;
                handler.removeCallbacks(runnable);
                handler2 = this.cwI.mHandler;
                runnable2 = this.cwI.cwH;
                handler2.postDelayed(runnable2, 300L);
            }
            if (a.length() > 0) {
                textView2 = this.cwI.cww;
                textView2.setVisibility(0);
                return;
            }
            textView = this.cwI.cww;
            textView.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.cwI.cwC = com.baidu.adp.lib.util.m.a(charSequence, null);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
