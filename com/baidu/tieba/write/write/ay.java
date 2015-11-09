package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements TextWatcher {
    private int czl;
    final /* synthetic */ WriteActivity dsa;
    private EditText bIr = null;
    private TextView mTextView = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(WriteActivity writeActivity) {
        this.dsa = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.dsa.aCV();
        z = this.dsa.drS;
        if (z) {
            this.czl = this.bIr.getSelectionStart();
            this.bIr.setSelection(this.czl);
            this.dsa.b(this.mTextView, this.bIr);
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
        z = this.dsa.drS;
        if (z) {
            z3 = this.dsa.drT;
            if (z3) {
                EditText editText5 = this.bIr;
                editText3 = this.dsa.drN;
                if (editText5 == editText3) {
                    TextView textView5 = this.mTextView;
                    textView4 = this.dsa.drO;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.dsa.drN;
                this.bIr = editText4;
                textView3 = this.dsa.drO;
                this.mTextView = textView3;
                return;
            }
        }
        z2 = this.dsa.drS;
        if (z2) {
            EditText editText6 = this.bIr;
            editText = this.dsa.drJ;
            if (editText6 == editText) {
                TextView textView6 = this.mTextView;
                textView2 = this.dsa.drP;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.dsa.drJ;
            this.bIr = editText2;
            textView = this.dsa.drP;
            this.mTextView = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
