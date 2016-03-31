package com.baidu.tieba.person;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements TextWatcher {
    final /* synthetic */ PersonChangeActivity dth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PersonChangeActivity personChangeActivity) {
        this.dth = personChangeActivity;
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
        editText = this.dth.dsS;
        Editable text = editText.getText();
        String replaceAll = text.toString().replaceAll("\\s*", "");
        int length = replaceAll.length();
        textView = this.dth.dsU;
        textView.setText(String.valueOf(length));
        linearLayout = this.dth.dsT;
        linearLayout.setVisibility(0);
        this.dth.mz(0);
        this.dth.aBo();
        if (length > 50) {
            this.dth.showToast(t.j.over_limit_tip);
            int selectionEnd = Selection.getSelectionEnd(text);
            String substring = replaceAll.substring(0, 50);
            editText2 = this.dth.dsS;
            editText2.setText(substring);
            editText3 = this.dth.dsS;
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
        TextView textView2;
        if (!editable.toString().replaceAll("\\s*", "").equals(this.dth.dsY.aBt().getIntro())) {
            view = this.dth.dsM;
            view.setEnabled(true);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                textView2 = this.dth.cjl;
                com.baidu.tbadk.core.util.at.b(textView2, t.d.navi_op_text, 1);
                return;
            }
            textView = this.dth.cjl;
            com.baidu.tbadk.core.util.at.b(textView, t.d.cp_link_tip_a, 1);
        }
    }
}
