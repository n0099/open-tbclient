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
    private EditText cbx;
    private int dVL;
    private boolean dVM = false;

    public a(int i, EditText editText) {
        this.dVL = 0;
        this.cbx = null;
        this.dVL = i;
        this.cbx = editText;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Editable text;
        if (this.cbx != null && (text = this.cbx.getText()) != null) {
            int length = this.cbx.getText().toString().trim().length();
            if (length > 0 && !this.dVM) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TEXT_CHANGED));
                this.dVM = true;
            }
            if (length > this.dVL) {
                int selectionEnd = Selection.getSelectionEnd(text);
                this.cbx.setText(text.toString().substring(0, this.dVL));
                Editable text2 = this.cbx.getText();
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
