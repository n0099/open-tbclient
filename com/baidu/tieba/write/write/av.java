package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements TextWatcher {
    private int dJp;
    final /* synthetic */ WriteActivity eNd;
    private EditText cqC = null;
    private TextView WY = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity) {
        this.eNd = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.eNd.aZX();
        z = this.eNd.eMU;
        if (z) {
            this.dJp = this.cqC.getSelectionStart();
            this.cqC.setSelection(this.dJp);
            this.eNd.b(this.WY, this.cqC);
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
        z = this.eNd.eMU;
        if (z) {
            z3 = this.eNd.eMV;
            if (z3) {
                EditText editText5 = this.cqC;
                editText3 = this.eNd.eMP;
                if (editText5 == editText3) {
                    TextView textView5 = this.WY;
                    textView4 = this.eNd.eMQ;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.eNd.eMP;
                this.cqC = editText4;
                textView3 = this.eNd.eMQ;
                this.WY = textView3;
                return;
            }
        }
        z2 = this.eNd.eMU;
        if (z2) {
            EditText editText6 = this.cqC;
            editText = this.eNd.eML;
            if (editText6 == editText) {
                TextView textView6 = this.WY;
                textView2 = this.eNd.eMR;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.eNd.eML;
            this.cqC = editText2;
            textView = this.eNd.eMR;
            this.WY = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
