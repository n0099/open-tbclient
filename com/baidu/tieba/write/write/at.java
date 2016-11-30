package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements TextWatcher {
    private int eWZ;
    final /* synthetic */ WriteActivity gpp;
    private EditText dsz = null;
    private TextView WJ = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteActivity writeActivity) {
        this.gpp = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.gpp.bih();
        z = this.gpp.goN;
        if (z) {
            this.eWZ = this.dsz.getSelectionStart();
            this.dsz.setSelection(this.eWZ);
            this.gpp.b(this.WJ, this.dsz);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        boolean z2;
        EditText editText;
        EditText editText2;
        TextView textView;
        TextView textView2;
        boolean z3;
        EditText editText3;
        EditText editText4;
        TextView textView3;
        TextView textView4;
        z = this.gpp.goN;
        if (z) {
            z3 = this.gpp.goO;
            if (z3) {
                EditText editText5 = this.dsz;
                editText3 = this.gpp.goI;
                if (editText5 == editText3) {
                    TextView textView5 = this.WJ;
                    textView4 = this.gpp.goJ;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.gpp.goI;
                this.dsz = editText4;
                textView3 = this.gpp.goJ;
                this.WJ = textView3;
                return;
            }
        }
        z2 = this.gpp.goN;
        if (z2) {
            EditText editText6 = this.dsz;
            editText = this.gpp.goE;
            if (editText6 == editText) {
                TextView textView6 = this.WJ;
                textView2 = this.gpp.goK;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.gpp.goE;
            this.dsz = editText2;
            textView = this.gpp.goK;
            this.WJ = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
