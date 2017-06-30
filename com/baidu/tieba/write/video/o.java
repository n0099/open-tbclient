package com.baidu.tieba.write.video;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements TextWatcher {
    final /* synthetic */ n giA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.giA = nVar;
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
        long btf = n.gis - this.giA.btf();
        if (btf >= 0) {
            textView4 = this.giA.gix;
            as.i(textView4, w.e.cp_cont_e);
        } else {
            textView = this.giA.gix;
            as.i(textView, w.e.cp_cont_h);
        }
        i4 = n.git;
        if (btf <= i4) {
            textView3 = this.giA.gix;
            textView3.setText(aw.vz());
            return;
        }
        textView2 = this.giA.gix;
        textView2.setText(String.valueOf(btf));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
