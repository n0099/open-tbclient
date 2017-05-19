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
    final /* synthetic */ n fPE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.fPE = nVar;
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
        long bni = n.fPw - this.fPE.bni();
        if (bni >= 0) {
            textView4 = this.fPE.fPB;
            aq.i(textView4, w.e.cp_cont_e);
        } else {
            textView = this.fPE.fPB;
            aq.i(textView, w.e.cp_cont_h);
        }
        i4 = n.fPx;
        if (bni <= i4) {
            textView3 = this.fPE.fPB;
            textView3.setText(au.vn());
            return;
        }
        textView2 = this.fPE.fPB;
        textView2.setText(String.valueOf(bni));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
