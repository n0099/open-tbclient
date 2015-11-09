package com.baidu.tieba.person;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements TextWatcher {
    final /* synthetic */ PersonChangeActivity cry;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PersonChangeActivity personChangeActivity) {
        this.cry = personChangeActivity;
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
        editText = this.cry.mEdit;
        Editable text = editText.getText();
        String replaceAll = text.toString().replaceAll("\\s*", "");
        int length = replaceAll.length();
        textView = this.cry.crl;
        textView.setText(String.valueOf(length));
        linearLayout = this.cry.crk;
        linearLayout.setVisibility(0);
        this.cry.jt(0);
        this.cry.ajc();
        if (length > 50) {
            this.cry.showToast(i.h.over_limit_tip);
            int selectionEnd = Selection.getSelectionEnd(text);
            String substring = replaceAll.substring(0, 50);
            editText2 = this.cry.mEdit;
            editText2.setText(substring);
            editText3 = this.cry.mEdit;
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
        if (!editable.toString().replaceAll("\\s*", "").equals(this.cry.crp.ajg().getIntro())) {
            view = this.cry.cre;
            view.setEnabled(true);
            if (TbadkCoreApplication.m411getInst().getSkinType() == 2) {
                textView2 = this.cry.bBR;
                com.baidu.tbadk.core.util.an.b(textView2, i.c.navi_op_text, 1);
                return;
            }
            textView = this.cry.bBR;
            com.baidu.tbadk.core.util.an.b(textView, i.c.cp_link_tip_a, 1);
        }
    }
}
