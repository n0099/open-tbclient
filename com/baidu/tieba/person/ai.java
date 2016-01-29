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
    final /* synthetic */ PersonChangeActivity cYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PersonChangeActivity personChangeActivity) {
        this.cYF = personChangeActivity;
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
        editText = this.cYF.cYq;
        Editable text = editText.getText();
        String replaceAll = text.toString().replaceAll("\\s*", "");
        int length = replaceAll.length();
        textView = this.cYF.cYs;
        textView.setText(String.valueOf(length));
        linearLayout = this.cYF.cYr;
        linearLayout.setVisibility(0);
        this.cYF.lq(0);
        this.cYF.atI();
        if (length > 50) {
            this.cYF.showToast(t.j.over_limit_tip);
            int selectionEnd = Selection.getSelectionEnd(text);
            String substring = replaceAll.substring(0, 50);
            editText2 = this.cYF.cYq;
            editText2.setText(substring);
            editText3 = this.cYF.cYq;
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
        if (!editable.toString().replaceAll("\\s*", "").equals(this.cYF.cYw.atN().getIntro())) {
            view = this.cYF.cYk;
            view.setEnabled(true);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                textView2 = this.cYF.bYI;
                com.baidu.tbadk.core.util.ar.b(textView2, t.d.navi_op_text, 1);
                return;
            }
            textView = this.cYF.bYI;
            com.baidu.tbadk.core.util.ar.b(textView, t.d.cp_link_tip_a, 1);
        }
    }
}
