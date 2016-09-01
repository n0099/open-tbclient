package com.baidu.tieba.write.write;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements TextWatcher {
    private int eOz;
    final /* synthetic */ WriteActivity gfs;
    private EditText dlt = null;
    private TextView Wb = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity) {
        this.gfs = writeActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z;
        this.gfs.bfa();
        z = this.gfs.geZ;
        if (z) {
            this.eOz = this.dlt.getSelectionStart();
            this.dlt.setSelection(this.eOz);
            this.gfs.b(this.Wb, this.dlt);
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
        z = this.gfs.geZ;
        if (z) {
            z3 = this.gfs.gfa;
            if (z3) {
                EditText editText5 = this.dlt;
                editText3 = this.gfs.geU;
                if (editText5 == editText3) {
                    TextView textView5 = this.Wb;
                    textView4 = this.gfs.geV;
                    if (textView5 == textView4) {
                        return;
                    }
                }
                editText4 = this.gfs.geU;
                this.dlt = editText4;
                textView3 = this.gfs.geV;
                this.Wb = textView3;
                return;
            }
        }
        z2 = this.gfs.geZ;
        if (z2) {
            EditText editText6 = this.dlt;
            editText = this.gfs.geQ;
            if (editText6 == editText) {
                TextView textView6 = this.Wb;
                textView2 = this.gfs.geW;
                if (textView6 == textView2) {
                    return;
                }
            }
            editText2 = this.gfs.geQ;
            this.dlt = editText2;
            textView = this.gfs.geW;
            this.Wb = textView;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
