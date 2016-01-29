package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements TextWatcher {
    private int doM;
    final /* synthetic */ WriteActivity ets;
    private EditText cfX = null;
    private TextView YG = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.ets = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.ets.aTx();
        z = this.ets.etk;
        if (z) {
            this.doM = this.cfX.getSelectionStart();
            this.cfX.setSelection(this.doM);
            this.ets.b(this.YG, this.cfX);
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
        z = this.ets.etk;
        if (z) {
            z3 = this.ets.etl;
            if (z3) {
                EditText editText5 = this.cfX;
                editText3 = this.ets.etf;
                if (editText5 == editText3) {
                    TextView textView5 = this.YG;
                    textView4 = this.ets.etg;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.ets.etf;
                this.cfX = editText4;
                textView3 = this.ets.etg;
                this.YG = textView3;
                return;
            }
        }
        z2 = this.ets.etk;
        if (z2) {
            EditText editText6 = this.cfX;
            editText = this.ets.eta;
            if (editText6 == editText) {
                TextView textView6 = this.YG;
                textView2 = this.ets.eth;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.ets.eta;
            this.cfX = editText2;
            textView = this.ets.eth;
            this.YG = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
