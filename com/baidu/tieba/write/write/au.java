package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements TextWatcher {
    private int eQC;
    final /* synthetic */ WriteActivity ghD;
    private EditText dmQ = null;
    private TextView Wl = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.ghD = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.ghD.bfL();
        z = this.ghD.ghi;
        if (z) {
            this.eQC = this.dmQ.getSelectionStart();
            this.dmQ.setSelection(this.eQC);
            this.ghD.b(this.Wl, this.dmQ);
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
        z = this.ghD.ghi;
        if (z) {
            z3 = this.ghD.ghj;
            if (z3) {
                EditText editText5 = this.dmQ;
                editText3 = this.ghD.ghd;
                if (editText5 == editText3) {
                    TextView textView5 = this.Wl;
                    textView4 = this.ghD.ghe;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.ghD.ghd;
                this.dmQ = editText4;
                textView3 = this.ghD.ghe;
                this.Wl = textView3;
                return;
            }
        }
        z2 = this.ghD.ghi;
        if (z2) {
            EditText editText6 = this.dmQ;
            editText = this.ghD.ggZ;
            if (editText6 == editText) {
                TextView textView6 = this.Wl;
                textView2 = this.ghD.ghf;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.ghD.ggZ;
            this.dmQ = editText2;
            textView = this.ghD.ghf;
            this.Wl = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
