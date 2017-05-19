package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements TextWatcher {
    private int eKk;
    final /* synthetic */ WriteActivity fSV;
    private EditText dbN = null;
    private TextView mTextView = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity) {
        this.fSV = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.fSV.bcJ();
        z = this.fSV.fSr;
        if (z) {
            this.eKk = this.dbN.getSelectionStart();
            this.dbN.setSelection(this.eKk);
            this.fSV.b(this.mTextView, this.dbN);
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
        z = this.fSV.fSr;
        if (z) {
            z3 = this.fSV.fSs;
            if (z3) {
                EditText editText5 = this.dbN;
                editText3 = this.fSV.fSm;
                if (editText5 == editText3) {
                    TextView textView5 = this.mTextView;
                    textView4 = this.fSV.fSn;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.fSV.fSm;
                this.dbN = editText4;
                textView3 = this.fSV.fSn;
                this.mTextView = textView3;
                return;
            }
        }
        z2 = this.fSV.fSr;
        if (z2) {
            EditText editText6 = this.dbN;
            editText = this.fSV.fSi;
            if (editText6 == editText) {
                TextView textView6 = this.mTextView;
                textView2 = this.fSV.fSo;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.fSV.fSi;
            this.dbN = editText2;
            textView = this.fSV.fSo;
            this.mTextView = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
