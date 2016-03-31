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
    private EditText cqC;
    private boolean eKA = false;
    private int eKz;

    public a(int i, EditText editText) {
        this.eKz = 0;
        this.cqC = null;
        this.eKz = i;
        this.cqC = editText;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Editable text;
        if (this.cqC != null && (text = this.cqC.getText()) != null) {
            int length = this.cqC.getText().toString().trim().length();
            if (length > 0 && !this.eKA) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TEXT_CHANGED));
                this.eKA = true;
            }
            if (length > this.eKz) {
                int selectionEnd = Selection.getSelectionEnd(text);
                this.cqC.setText(text.toString().substring(0, this.eKz));
                Editable text2 = this.cqC.getText();
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
