package com.baidu.tieba.write.video;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements TextWatcher {
    final /* synthetic */ m fAL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.fAL = mVar;
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
        long bml = m.fAC - this.fAL.bml();
        if (bml >= 0) {
            textView4 = this.fAL.fAI;
            ar.j((View) textView4, r.d.cp_cont_e);
        } else {
            textView = this.fAL.fAI;
            ar.j((View) textView, r.d.cp_cont_h);
        }
        i4 = m.fAD;
        if (bml <= i4) {
            textView3 = this.fAL.fAI;
            textView3.setText(av.vl());
            return;
        }
        textView2 = this.fAL.fAI;
        textView2.setText(String.valueOf(bml));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
