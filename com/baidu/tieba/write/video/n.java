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
    final /* synthetic */ m faM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.faM = mVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        long bcz;
        TextView textView;
        int i5;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        i4 = m.faF;
        bcz = this.faM.bcz();
        long j = i4 - bcz;
        if (j >= 0) {
            textView4 = this.faM.faK;
            at.j((View) textView4, t.d.cp_cont_e);
        } else {
            textView = this.faM.faK;
            at.j((View) textView, t.d.cp_cont_h);
        }
        i5 = m.faG;
        if (j <= i5) {
            textView3 = this.faM.faK;
            textView3.setText(ay.ue());
        } else {
            textView2 = this.faM.faK;
            textView2.setText(String.valueOf(j));
        }
        this.faM.bcy();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
