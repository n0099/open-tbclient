package com.baidu.tieba.person;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements TextWatcher {
    final /* synthetic */ PersonChangeActivity dwD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PersonChangeActivity personChangeActivity) {
        this.dwD = personChangeActivity;
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
        editText = this.dwD.dwo;
        Editable text = editText.getText();
        String replaceAll = text.toString().replaceAll("\\s*", "");
        int length = replaceAll.length();
        textView = this.dwD.dwq;
        textView.setText(String.valueOf(length));
        linearLayout = this.dwD.dwp;
        linearLayout.setVisibility(0);
        this.dwD.mp(0);
        this.dwD.aBN();
        if (length > 50) {
            this.dwD.showToast(t.j.over_limit_tip);
            int selectionEnd = Selection.getSelectionEnd(text);
            String substring = replaceAll.substring(0, 50);
            editText2 = this.dwD.dwo;
            editText2.setText(substring);
            editText3 = this.dwD.dwo;
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
        TextView textView;
        TextView textView2;
        if (!editable.toString().replaceAll("\\s*", "").equals(this.dwD.dwu.aBS().getIntro())) {
            this.dwD.bKq = true;
            if (TbadkCoreApplication.m11getInst().getSkinType() == 2) {
                textView2 = this.dwD.ckh;
                com.baidu.tbadk.core.util.at.c(textView2, t.d.navi_op_text, 1);
                return;
            }
            textView = this.dwD.ckh;
            com.baidu.tbadk.core.util.at.c(textView, t.d.cp_link_tip_a, 1);
        }
    }
}
