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
    final /* synthetic */ PersonChangeActivity bCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PersonChangeActivity personChangeActivity) {
        this.bCm = personChangeActivity;
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
        editText = this.bCm.bBX;
        Editable text = editText.getText();
        String replaceAll = text.toString().replaceAll("\\s*", "");
        int length = replaceAll.length();
        textView = this.bCm.bBZ;
        textView.setText(String.valueOf(length));
        linearLayout = this.bCm.bBY;
        linearLayout.setVisibility(0);
        this.bCm.gX(0);
        this.bCm.ZU();
        if (length > 50) {
            this.bCm.showToast(com.baidu.tieba.y.over_limit_tip);
            int selectionEnd = Selection.getSelectionEnd(text);
            String substring = replaceAll.substring(0, 50);
            editText2 = this.bCm.bBX;
            editText2.setText(substring);
            editText3 = this.bCm.bBX;
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
        auVar = this.bCm.bCd;
        if (!replaceAll.equals(auVar.TT().getIntro())) {
            textView = this.bCm.bBR;
            textView.setEnabled(true);
        }
    }
}
