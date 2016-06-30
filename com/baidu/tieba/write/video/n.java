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
    final /* synthetic */ m fGo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.fGo = mVar;
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
        long bld = m.fGg - this.fGo.bld();
        if (bld >= 0) {
            textView4 = this.fGo.fGl;
            av.j((View) textView4, u.d.cp_cont_e);
        } else {
            textView = this.fGo.fGl;
            av.j((View) textView, u.d.cp_cont_h);
        }
        i4 = m.fGh;
        if (bld <= i4) {
            textView3 = this.fGo.fGl;
            textView3.setText(ba.ue());
            return;
        }
        textView2 = this.fGo.fGl;
        textView2.setText(String.valueOf(bld));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
