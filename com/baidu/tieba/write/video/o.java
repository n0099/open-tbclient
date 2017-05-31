package com.baidu.tieba.write.video;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements TextWatcher {
    final /* synthetic */ n fXA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.fXA = nVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextView textView;
        int i4;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        long boH = n.fXs - this.fXA.boH();
        if (boH >= 0) {
            textView4 = this.fXA.fXx;
            aq.i(textView4, w.e.cp_cont_e);
        } else {
            textView = this.fXA.fXx;
            aq.i(textView, w.e.cp_cont_h);
        }
        i4 = n.fXt;
        if (boH <= i4) {
            textView3 = this.fXA.fXx;
            textView3.setText(au.vk());
            return;
        }
        textView2 = this.fXA.fXx;
        textView2.setText(String.valueOf(boH));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
