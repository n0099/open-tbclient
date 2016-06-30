package com.baidu.tieba.person;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements TextWatcher {
    final /* synthetic */ PersonChangeActivity eeV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(PersonChangeActivity personChangeActivity) {
        this.eeV = personChangeActivity;
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
        editText = this.eeV.eeG;
        Editable text = editText.getText();
        String replaceAll = text.toString().replaceAll("\\s*", "");
        int length = replaceAll.length();
        textView = this.eeV.eeI;
        textView.setText(String.valueOf(length));
        linearLayout = this.eeV.eeH;
        linearLayout.setVisibility(0);
        this.eeV.nQ(0);
        this.eeV.aKF();
        if (length > 50) {
            this.eeV.showToast(u.j.over_limit_tip);
            int selectionEnd = Selection.getSelectionEnd(text);
            String substring = replaceAll.substring(0, 50);
            editText2 = this.eeV.eeG;
            editText2.setText(substring);
            editText3 = this.eeV.eeG;
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
        if (!editable.toString().replaceAll("\\s*", "").equals(this.eeV.eeM.aKK().getIntro())) {
            this.eeV.civ = true;
            if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
                textView2 = this.eeV.cPx;
                com.baidu.tbadk.core.util.av.c(textView2, u.d.navi_op_text, 1);
                return;
            }
            textView = this.eeV.cPx;
            com.baidu.tbadk.core.util.av.c(textView, u.d.cp_link_tip_a, 1);
        }
    }
}
