package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements TextWatcher {
    private int cxP;
    final /* synthetic */ WriteActivity dqi;
    private EditText bHW = null;
    private TextView mTextView = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity) {
        this.dqi = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.dqi.aCj();
        z = this.dqi.dqa;
        if (z) {
            this.cxP = this.bHW.getSelectionStart();
            this.bHW.setSelection(this.cxP);
            this.dqi.b(this.mTextView, this.bHW);
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
        z = this.dqi.dqa;
        if (z) {
            z3 = this.dqi.dqb;
            if (z3) {
                EditText editText5 = this.bHW;
                editText3 = this.dqi.dpV;
                if (editText5 == editText3) {
                    TextView textView5 = this.mTextView;
                    textView4 = this.dqi.dpW;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.dqi.dpV;
                this.bHW = editText4;
                textView3 = this.dqi.dpW;
                this.mTextView = textView3;
                return;
            }
        }
        z2 = this.dqi.dqa;
        if (z2) {
            EditText editText6 = this.bHW;
            editText = this.dqi.dpR;
            if (editText6 == editText) {
                TextView textView6 = this.mTextView;
                textView2 = this.dqi.dpX;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.dqi.dpR;
            this.bHW = editText2;
            textView = this.dqi.dpX;
            this.mTextView = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
