package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements TextWatcher {
    private int eSV;
    final /* synthetic */ WriteActivity gaR;
    private EditText dhk = null;
    private TextView mTextView = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.gaR.bed();
        z = this.gaR.gan;
        if (z) {
            this.eSV = this.dhk.getSelectionStart();
            this.dhk.setSelection(this.eSV);
            this.gaR.b(this.mTextView, this.dhk);
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
        z = this.gaR.gan;
        if (z) {
            z3 = this.gaR.gao;
            if (z3) {
                EditText editText5 = this.dhk;
                editText3 = this.gaR.gai;
                if (editText5 == editText3) {
                    TextView textView5 = this.mTextView;
                    textView4 = this.gaR.gaj;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.gaR.gai;
                this.dhk = editText4;
                textView3 = this.gaR.gaj;
                this.mTextView = textView3;
                return;
            }
        }
        z2 = this.gaR.gan;
        if (z2) {
            EditText editText6 = this.dhk;
            editText = this.gaR.gae;
            if (editText6 == editText) {
                TextView textView6 = this.mTextView;
                textView2 = this.gaR.gak;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.gaR.gae;
            this.dhk = editText2;
            textView = this.gaR.gak;
            this.mTextView = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
