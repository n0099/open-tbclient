package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements TextWatcher {
    private int cxE;
    final /* synthetic */ WriteActivity dpI;
    private EditText bHL = null;
    private TextView mTextView = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity) {
        this.dpI = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.dpI.aBZ();
        z = this.dpI.dpA;
        if (z) {
            this.cxE = this.bHL.getSelectionStart();
            this.bHL.setSelection(this.cxE);
            this.dpI.b(this.mTextView, this.bHL);
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
        z = this.dpI.dpA;
        if (z) {
            z3 = this.dpI.dpB;
            if (z3) {
                EditText editText5 = this.bHL;
                editText3 = this.dpI.dpv;
                if (editText5 == editText3) {
                    TextView textView5 = this.mTextView;
                    textView4 = this.dpI.dpw;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.dpI.dpv;
                this.bHL = editText4;
                textView3 = this.dpI.dpw;
                this.mTextView = textView3;
                return;
            }
        }
        z2 = this.dpI.dpA;
        if (z2) {
            EditText editText6 = this.bHL;
            editText = this.dpI.dpr;
            if (editText6 == editText) {
                TextView textView6 = this.mTextView;
                textView2 = this.dpI.dpx;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.dpI.dpr;
            this.bHL = editText2;
            textView = this.dpI.dpx;
            this.mTextView = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
