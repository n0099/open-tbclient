package com.baidu.tieba.write.vote;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class a implements TextWatcher {
    private EditText bIr;
    private int dpj;
    private boolean dpk = false;

    public a(int i, EditText editText) {
        this.dpj = 0;
        this.bIr = null;
        this.dpj = i;
        this.bIr = editText;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Editable text;
        if (this.bIr != null && (text = this.bIr.getText()) != null) {
            int length = this.bIr.getText().toString().trim().length();
            if (length > 0 && !this.dpk) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TEXT_CHANGED));
                this.dpk = true;
            }
            if (length > this.dpj) {
                int selectionEnd = Selection.getSelectionEnd(text);
                this.bIr.setText(text.toString().substring(0, this.dpj));
                Editable text2 = this.bIr.getText();
                if (selectionEnd > text2.length()) {
                    selectionEnd = text2.length();
                }
                Selection.setSelection(text2, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
