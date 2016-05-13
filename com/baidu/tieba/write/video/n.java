package com.baidu.tieba.write.video;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements TextWatcher {
    final /* synthetic */ m faL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.faL = mVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        long bcG;
        TextView textView;
        int i5;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        i4 = m.faE;
        bcG = this.faL.bcG();
        long j = i4 - bcG;
        if (j >= 0) {
            textView4 = this.faL.faJ;
            at.j((View) textView4, t.d.cp_cont_e);
        } else {
            textView = this.faL.faJ;
            at.j((View) textView, t.d.cp_cont_h);
        }
        i5 = m.faF;
        if (j <= i5) {
            textView3 = this.faL.faJ;
            textView3.setText(ay.uf());
        } else {
            textView2 = this.faL.faJ;
            textView2.setText(String.valueOf(j));
        }
        this.faL.bcF();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
