package com.baidu.tieba.write.video;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements TextWatcher {
    final /* synthetic */ m fNz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.fNz = mVar;
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
        long bnw = m.fNr - this.fNz.bnw();
        if (bnw >= 0) {
            textView4 = this.fNz.fNw;
            aq.i((View) textView4, w.e.cp_cont_e);
        } else {
            textView = this.fNz.fNw;
            aq.i((View) textView, w.e.cp_cont_h);
        }
        i4 = m.fNs;
        if (bnw <= i4) {
            textView3 = this.fNz.fNw;
            textView3.setText(au.vC());
            return;
        }
        textView2 = this.fNz.fNw;
        textView2.setText(String.valueOf(bnw));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
