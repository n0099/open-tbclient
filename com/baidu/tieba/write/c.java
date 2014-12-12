package com.baidu.tieba.write;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements TextWatcher {
    final /* synthetic */ AtListActivity cdZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AtListActivity atListActivity) {
        this.cdZ = atListActivity;
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
            str = this.cdZ.cdT;
            if (!a.equals(str)) {
                handler = this.cdZ.mHandler;
                runnable = this.cdZ.cdY;
                handler.removeCallbacks(runnable);
                handler2 = this.cdZ.mHandler;
                runnable2 = this.cdZ.cdY;
                handler2.postDelayed(runnable2, 300L);
            }
            if (a.length() > 0) {
                textView2 = this.cdZ.cdN;
                textView2.setVisibility(0);
                return;
            }
            textView = this.cdZ.cdN;
            textView.setVisibility(8);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.cdZ.cdT = com.baidu.adp.lib.util.k.a(charSequence, null);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
