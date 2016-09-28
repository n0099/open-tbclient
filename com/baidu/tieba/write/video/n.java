package com.baidu.tieba.write.video;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements TextWatcher {
    final /* synthetic */ m geE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.geE = mVar;
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
        long bsU = m.gew - this.geE.bsU();
        if (bsU >= 0) {
            textView4 = this.geE.geB;
            av.j((View) textView4, r.d.cp_cont_e);
        } else {
            textView = this.geE.geB;
            av.j((View) textView, r.d.cp_cont_h);
        }
        i4 = m.gex;
        if (bsU <= i4) {
            textView3 = this.geE.geB;
            textView3.setText(az.vx());
            return;
        }
        textView2 = this.geE.geB;
        textView2.setText(String.valueOf(bsU));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
