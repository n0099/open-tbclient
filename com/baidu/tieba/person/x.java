package com.baidu.tieba.person;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TextWatcher {
    final /* synthetic */ PersonChangeActivity bGa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PersonChangeActivity personChangeActivity) {
        this.bGa = personChangeActivity;
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
        editText = this.bGa.mEdit;
        Editable text = editText.getText();
        String replaceAll = text.toString().replaceAll("\\s*", "");
        int length = replaceAll.length();
        textView = this.bGa.bFN;
        textView.setText(String.valueOf(length));
        linearLayout = this.bGa.bFM;
        linearLayout.setVisibility(0);
        this.bGa.hg(0);
        this.bGa.aan();
        if (length > 50) {
            this.bGa.showToast(com.baidu.tieba.z.over_limit_tip);
            int selectionEnd = Selection.getSelectionEnd(text);
            String substring = replaceAll.substring(0, 50);
            editText2 = this.bGa.mEdit;
            editText2.setText(substring);
            editText3 = this.bGa.mEdit;
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
        com.baidu.tbadk.coreExtra.c.f fVar;
        TextView textView;
        String replaceAll = editable.toString().replaceAll("\\s*", "");
        fVar = this.bGa.bFR;
        if (!replaceAll.equals(fVar.sl().getIntro())) {
            textView = this.bGa.ben;
            textView.setEnabled(true);
        }
    }
}
