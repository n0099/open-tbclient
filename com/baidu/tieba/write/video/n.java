package com.baidu.tieba.write.video;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements TextWatcher {
    final /* synthetic */ m epZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.epZ = mVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        long aTM;
        TextView textView;
        int i5;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        i4 = m.epS;
        aTM = this.epZ.aTM();
        long j = i4 - aTM;
        if (j >= 0) {
            textView4 = this.epZ.epX;
            ar.j((View) textView4, t.d.cp_cont_e);
        } else {
            textView = this.epZ.epX;
            ar.j((View) textView, t.d.cp_cont_h);
        }
        i5 = m.epT;
        if (j <= i5) {
            textView3 = this.epZ.epX;
            textView3.setText(aw.wf());
        } else {
            textView2 = this.epZ.epX;
            textView2.setText(String.valueOf(j));
        }
        this.epZ.aTL();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
