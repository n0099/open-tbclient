package com.baidu.tieba.write.video;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements TextWatcher {
    final /* synthetic */ m gcu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.gcu = mVar;
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
        long bso = m.gcm - this.gcu.bso();
        if (bso >= 0) {
            textView4 = this.gcu.gcr;
            av.j((View) textView4, t.d.cp_cont_e);
        } else {
            textView = this.gcu.gcr;
            av.j((View) textView, t.d.cp_cont_h);
        }
        i4 = m.gcn;
        if (bso <= i4) {
            textView3 = this.gcu.gcr;
            textView3.setText(ba.vj());
            return;
        }
        textView2 = this.gcu.gcr;
        textView2.setText(String.valueOf(bso));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
