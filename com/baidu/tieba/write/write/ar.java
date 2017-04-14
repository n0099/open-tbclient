package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements TextWatcher {
    private int eLU;
    final /* synthetic */ WriteActivity fSq;
    private EditText dfv = null;
    private TextView mTextView = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(WriteActivity writeActivity) {
        this.fSq = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.fSq.bee();
        z = this.fSq.fRP;
        if (z) {
            this.eLU = this.dfv.getSelectionStart();
            this.dfv.setSelection(this.eLU);
            this.fSq.b(this.mTextView, this.dfv);
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
        z = this.fSq.fRP;
        if (z) {
            z3 = this.fSq.fRQ;
            if (z3) {
                EditText editText5 = this.dfv;
                editText3 = this.fSq.fRK;
                if (editText5 == editText3) {
                    TextView textView5 = this.mTextView;
                    textView4 = this.fSq.fRL;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.fSq.fRK;
                this.dfv = editText4;
                textView3 = this.fSq.fRL;
                this.mTextView = textView3;
                return;
            }
        }
        z2 = this.fSq.fRP;
        if (z2) {
            EditText editText6 = this.dfv;
            editText = this.fSq.fRG;
            if (editText6 == editText) {
                TextView textView6 = this.mTextView;
                textView2 = this.fSq.fRM;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.fSq.fRG;
            this.dfv = editText2;
            textView = this.fSq.fRM;
            this.mTextView = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
