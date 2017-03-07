package com.baidu.tieba.write.write;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ AtListActivity fOT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AtListActivity atListActivity) {
        this.fOT = atListActivity;
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
            str = this.fOT.fON;
            if (!a.equals(str)) {
                handler = this.fOT.mHandler;
                runnable = this.fOT.fOS;
                handler.removeCallbacks(runnable);
                handler2 = this.fOT.mHandler;
                runnable2 = this.fOT.fOS;
                handler2.postDelayed(runnable2, 300L);
            }
            if (a.length() > 0) {
                textView2 = this.fOT.fOH;
                textView2.setVisibility(0);
                return;
            }
            textView = this.fOT.fOH;
            textView.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.fOT.fON = com.baidu.adp.lib.util.j.a(charSequence, null);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
