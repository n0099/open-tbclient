package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements TextWatcher {
    private int crE;
    final /* synthetic */ WriteActivity ddQ;
    private EditText bEI = null;
    private TextView mTextView = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity) {
        this.ddQ = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.ddQ.ayQ();
        z = this.ddQ.ddI;
        if (z) {
            this.crE = this.bEI.getSelectionStart();
            this.bEI.setSelection(this.crE);
            this.ddQ.b(this.mTextView, this.bEI);
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
        z = this.ddQ.ddI;
        if (z) {
            z3 = this.ddQ.ddJ;
            if (z3) {
                EditText editText5 = this.bEI;
                editText3 = this.ddQ.ddD;
                if (editText5 == editText3) {
                    TextView textView5 = this.mTextView;
                    textView4 = this.ddQ.ddE;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.ddQ.ddD;
                this.bEI = editText4;
                textView3 = this.ddQ.ddE;
                this.mTextView = textView3;
                return;
            }
        }
        z2 = this.ddQ.ddI;
        if (z2) {
            EditText editText6 = this.bEI;
            editText = this.ddQ.ddz;
            if (editText6 == editText) {
                TextView textView6 = this.mTextView;
                textView2 = this.ddQ.ddF;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.ddQ.ddz;
            this.bEI = editText2;
            textView = this.ddQ.ddF;
            this.mTextView = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
