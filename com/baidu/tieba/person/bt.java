package com.baidu.tieba.person;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements TextWatcher {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
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
        editText = this.a.p;
        Editable text = editText.getText();
        String replaceAll = text.toString().replaceAll("\\s*", "");
        int length = replaceAll.length();
        textView = this.a.r;
        textView.setText(String.valueOf(length));
        linearLayout = this.a.q;
        linearLayout.setVisibility(0);
        this.a.a(0);
        this.a.e();
        if (length > 50) {
            this.a.showToast(R.string.over_limit_tip);
            int selectionEnd = Selection.getSelectionEnd(text);
            String substring = replaceAll.substring(0, 50);
            editText2 = this.a.p;
            editText2.setText(substring);
            editText3 = this.a.p;
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
    }
}
