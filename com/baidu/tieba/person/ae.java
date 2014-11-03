package com.baidu.tieba.person;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements TextWatcher {
    final /* synthetic */ PersonChangeActivity bCA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PersonChangeActivity personChangeActivity) {
        this.bCA = personChangeActivity;
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
        editText = this.bCA.bCl;
        Editable text = editText.getText();
        String replaceAll = text.toString().replaceAll("\\s*", "");
        int length = replaceAll.length();
        textView = this.bCA.bCn;
        textView.setText(String.valueOf(length));
        linearLayout = this.bCA.bCm;
        linearLayout.setVisibility(0);
        this.bCA.gX(0);
        this.bCA.ZW();
        if (length > 50) {
            this.bCA.showToast(com.baidu.tieba.y.over_limit_tip);
            int selectionEnd = Selection.getSelectionEnd(text);
            String substring = replaceAll.substring(0, 50);
            editText2 = this.bCA.bCl;
            editText2.setText(substring);
            editText3 = this.bCA.bCl;
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
        com.baidu.tieba.model.au auVar;
        TextView textView;
        String replaceAll = editable.toString().replaceAll("\\s*", "");
        auVar = this.bCA.bCr;
        if (!replaceAll.equals(auVar.TW().getIntro())) {
            textView = this.bCA.bCf;
            textView.setEnabled(true);
        }
    }
}
