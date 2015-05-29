package com.baidu.tieba.person;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements TextWatcher {
    final /* synthetic */ PersonChangeActivity bSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PersonChangeActivity personChangeActivity) {
        this.bSN = personChangeActivity;
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
        editText = this.bSN.mEdit;
        Editable text = editText.getText();
        String replaceAll = text.toString().replaceAll("\\s*", "");
        int length = replaceAll.length();
        textView = this.bSN.bSA;
        textView.setText(String.valueOf(length));
        linearLayout = this.bSN.bSz;
        linearLayout.setVisibility(0);
        this.bSN.hQ(0);
        this.bSN.aet();
        if (length > 50) {
            this.bSN.showToast(com.baidu.tieba.t.over_limit_tip);
            int selectionEnd = Selection.getSelectionEnd(text);
            String substring = replaceAll.substring(0, 50);
            editText2 = this.bSN.mEdit;
            editText2.setText(substring);
            editText3 = this.bSN.mEdit;
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
        View view;
        TextView textView;
        String replaceAll = editable.toString().replaceAll("\\s*", "");
        fVar = this.bSN.bSE;
        if (!replaceAll.equals(fVar.wH().getIntro())) {
            view = this.bSN.bSt;
            view.setEnabled(true);
            textView = this.bSN.bjR;
            com.baidu.tbadk.core.util.ay.b(textView, com.baidu.tieba.n.cp_link_tip_a, 1);
        }
    }
}
