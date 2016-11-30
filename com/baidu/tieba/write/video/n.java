package com.baidu.tieba.write.video;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements TextWatcher {
    final /* synthetic */ m gmi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.gmi = mVar;
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
        long bvp = m.glZ - this.gmi.bvp();
        if (bvp >= 0) {
            textView4 = this.gmi.gmf;
            at.j((View) textView4, r.d.cp_cont_e);
        } else {
            textView = this.gmi.gmf;
            at.j((View) textView, r.d.cp_cont_h);
        }
        i4 = m.gma;
        if (bvp <= i4) {
            textView3 = this.gmi.gmf;
            textView3.setText(ax.vB());
            return;
        }
        textView2 = this.gmi.gmf;
        textView2.setText(String.valueOf(bvp));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
