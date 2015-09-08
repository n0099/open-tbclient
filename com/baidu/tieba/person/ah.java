package com.baidu.tieba.person;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements TextWatcher {
    final /* synthetic */ PersonChangeActivity cko;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PersonChangeActivity personChangeActivity) {
        this.cko = personChangeActivity;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText;
        TextView textView;
        LinearLayout linearLayout;
        EditText editText2;
        EditText editText3;
        editText = this.cko.mEdit;
        Editable text = editText.getText();
        String replaceAll = text.toString().replaceAll("\\s*", "");
        int length = replaceAll.length();
        textView = this.cko.ckb;
        textView.setText(String.valueOf(length));
        linearLayout = this.cko.cka;
        linearLayout.setVisibility(0);
        this.cko.iV(0);
        this.cko.agB();
        if (length > 50) {
            this.cko.showToast(i.h.over_limit_tip);
            int selectionEnd = Selection.getSelectionEnd(text);
            String substring = replaceAll.substring(0, 50);
            editText2 = this.cko.mEdit;
            editText2.setText(substring);
            editText3 = this.cko.mEdit;
            Editable text2 = editText3.getText();
            int length2 = text2.length();
            if (selectionEnd <= length2) {
                length2 = selectionEnd;
            }
            Selection.setSelection(text2, length2);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        View view;
        TextView textView;
        if (!editable.toString().replaceAll("\\s*", "").equals(this.cko.ckf.xY().getIntro())) {
            view = this.cko.cjU;
            view.setEnabled(true);
            textView = this.cko.byj;
            com.baidu.tbadk.core.util.al.b(textView, i.c.cp_link_tip_a, 1);
        }
    }
}
