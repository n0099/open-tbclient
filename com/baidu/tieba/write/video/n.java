package com.baidu.tieba.write.video;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements TextWatcher {
    final /* synthetic */ m fRE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.fRE = mVar;
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
        long bph = m.fRw - this.fRE.bph();
        if (bph >= 0) {
            textView4 = this.fRE.fRB;
            aq.i(textView4, w.e.cp_cont_e);
        } else {
            textView = this.fRE.fRB;
            aq.i(textView, w.e.cp_cont_h);
        }
        i4 = m.fRx;
        if (bph <= i4) {
            textView3 = this.fRE.fRB;
            textView3.setText(au.vZ());
            return;
        }
        textView2 = this.fRE.fRB;
        textView2.setText(String.valueOf(bph));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
