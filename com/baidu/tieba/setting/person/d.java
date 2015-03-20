package com.baidu.tieba.setting.person;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.s;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements TextWatcher {
    final /* synthetic */ PersonChangeActivity ccF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonChangeActivity personChangeActivity) {
        this.ccF = personChangeActivity;
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
        editText = this.ccF.mEdit;
        Editable text = editText.getText();
        String replaceAll = text.toString().replaceAll("\\s*", "");
        int length = replaceAll.length();
        textView = this.ccF.ccs;
        textView.setText(String.valueOf(length));
        linearLayout = this.ccF.ccr;
        linearLayout.setVisibility(0);
        this.ccF.hW(0);
        this.ccF.ahX();
        if (length > 50) {
            this.ccF.showToast(y.over_limit_tip);
            int selectionEnd = Selection.getSelectionEnd(text);
            String substring = replaceAll.substring(0, 50);
            editText2 = this.ccF.mEdit;
            editText2.setText(substring);
            editText3 = this.ccF.mEdit;
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
        fVar = this.ccF.ccw;
        if (!replaceAll.equals(fVar.vR().getIntro())) {
            view = this.ccF.ccl;
            view.setEnabled(true);
            textView = this.ccF.bgV;
            ba.b(textView, s.cp_link_tip_a, 1);
        }
    }
}
