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
    private EditText cfX;
    private int eqE;
    private boolean eqF = false;

    public a(int i, EditText editText) {
        this.eqE = 0;
        this.cfX = null;
        this.eqE = i;
        this.cfX = editText;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Editable text;
        if (this.cfX != null && (text = this.cfX.getText()) != null) {
            int length = this.cfX.getText().toString().trim().length();
            if (length > 0 && !this.eqF) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TEXT_CHANGED));
                this.eqF = true;
            }
            if (length > this.eqE) {
                int selectionEnd = Selection.getSelectionEnd(text);
                this.cfX.setText(text.toString().substring(0, this.eqE));
                Editable text2 = this.cfX.getText();
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
