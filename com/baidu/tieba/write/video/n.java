package com.baidu.tieba.write.video;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements TextWatcher {
    final /* synthetic */ m fSp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.fSp = mVar;
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
        long bnZ = m.fSh - this.fSp.bnZ();
        if (bnZ >= 0) {
            textView4 = this.fSp.fSm;
            av.j((View) textView4, u.d.cp_cont_e);
        } else {
            textView = this.fSp.fSm;
            av.j((View) textView, u.d.cp_cont_h);
        }
        i4 = m.fSi;
        if (bnZ <= i4) {
            textView3 = this.fSp.fSm;
            textView3.setText(ba.ud());
            return;
        }
        textView2 = this.fSp.fSm;
        textView2.setText(String.valueOf(bnZ));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
