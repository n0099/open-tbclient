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
    private EditText bXx;
    private int dOm;
    private boolean dOn = false;

    public a(int i, EditText editText) {
        this.dOm = 0;
        this.bXx = null;
        this.dOm = i;
        this.bXx = editText;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Editable text;
        if (this.bXx != null && (text = this.bXx.getText()) != null) {
            int length = this.bXx.getText().toString().trim().length();
            if (length > 0 && !this.dOn) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TEXT_CHANGED));
                this.dOn = true;
            }
            if (length > this.dOm) {
                int selectionEnd = Selection.getSelectionEnd(text);
                this.bXx.setText(text.toString().substring(0, this.dOm));
                Editable text2 = this.bXx.getText();
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
