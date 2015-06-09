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
    final /* synthetic */ PersonChangeActivity bSO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PersonChangeActivity personChangeActivity) {
        this.bSO = personChangeActivity;
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
        editText = this.bSO.mEdit;
        Editable text = editText.getText();
        String replaceAll = text.toString().replaceAll("\\s*", "");
        int length = replaceAll.length();
        textView = this.bSO.bSB;
        textView.setText(String.valueOf(length));
        linearLayout = this.bSO.bSA;
        linearLayout.setVisibility(0);
        this.bSO.hQ(0);
        this.bSO.aeu();
        if (length > 50) {
            this.bSO.showToast(com.baidu.tieba.t.over_limit_tip);
            int selectionEnd = Selection.getSelectionEnd(text);
            String substring = replaceAll.substring(0, 50);
            editText2 = this.bSO.mEdit;
            editText2.setText(substring);
            editText3 = this.bSO.mEdit;
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
        fVar = this.bSO.bSF;
        if (!replaceAll.equals(fVar.wI().getIntro())) {
            view = this.bSO.bSu;
            view.setEnabled(true);
            textView = this.bSO.bjS;
            com.baidu.tbadk.core.util.ay.b(textView, com.baidu.tieba.n.cp_link_tip_a, 1);
        }
    }
}
