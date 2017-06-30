package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements TextWatcher {
    private int fdl;
    final /* synthetic */ WriteActivity glP;
    private EditText dpg = null;
    private TextView mTextView = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.glP.bis();
        z = this.glP.gll;
        if (z) {
            this.fdl = this.dpg.getSelectionStart();
            this.dpg.setSelection(this.fdl);
            this.glP.b(this.mTextView, this.dpg);
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
        z = this.glP.gll;
        if (z) {
            z3 = this.glP.glm;
            if (z3) {
                EditText editText5 = this.dpg;
                editText3 = this.glP.glg;
                if (editText5 == editText3) {
                    TextView textView5 = this.mTextView;
                    textView4 = this.glP.glh;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.glP.glg;
                this.dpg = editText4;
                textView3 = this.glP.glh;
                this.mTextView = textView3;
                return;
            }
        }
        z2 = this.glP.gll;
        if (z2) {
            EditText editText6 = this.dpg;
            editText = this.glP.glc;
            if (editText6 == editText) {
                TextView textView6 = this.mTextView;
                textView2 = this.glP.gli;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.glP.glc;
            this.dpg = editText2;
            textView = this.glP.gli;
            this.mTextView = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
