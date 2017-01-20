package com.baidu.tieba.write.video;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements TextWatcher {
    final /* synthetic */ m fJg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.fJg = mVar;
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
        long bnJ = m.fIY - this.fJg.bnJ();
        if (bnJ >= 0) {
            textView4 = this.fJg.fJd;
            ap.i((View) textView4, r.e.cp_cont_e);
        } else {
            textView = this.fJg.fJd;
            ap.i((View) textView, r.e.cp_cont_h);
        }
        i4 = m.fIZ;
        if (bnJ <= i4) {
            textView3 = this.fJg.fJd;
            textView3.setText(at.vf());
            return;
        }
        textView2 = this.fJg.fJd;
        textView2.setText(String.valueOf(bnJ));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
