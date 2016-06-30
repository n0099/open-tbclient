package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements TextWatcher {
    private int evE;
    final /* synthetic */ WriteActivity fJw;
    private EditText cWP = null;
    private TextView SD = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.fJw = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.fJw.bkL();
        z = this.fJw.fJd;
        if (z) {
            this.evE = this.cWP.getSelectionStart();
            this.cWP.setSelection(this.evE);
            this.fJw.b(this.SD, this.cWP);
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
        z = this.fJw.fJd;
        if (z) {
            z3 = this.fJw.fJe;
            if (z3) {
                EditText editText5 = this.cWP;
                editText3 = this.fJw.fIY;
                if (editText5 == editText3) {
                    TextView textView5 = this.SD;
                    textView4 = this.fJw.fIZ;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.fJw.fIY;
                this.cWP = editText4;
                textView3 = this.fJw.fIZ;
                this.SD = textView3;
                return;
            }
        }
        z2 = this.fJw.fJd;
        if (z2) {
            EditText editText6 = this.cWP;
            editText = this.fJw.fIU;
            if (editText6 == editText) {
                TextView textView6 = this.SD;
                textView2 = this.fJw.fJa;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.fJw.fIU;
            this.cWP = editText2;
            textView = this.fJw.fJa;
            this.SD = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
