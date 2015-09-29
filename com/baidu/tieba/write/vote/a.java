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
    private EditText bHL;
    private int dmU;
    private boolean dmV = false;

    public a(int i, EditText editText) {
        this.dmU = 0;
        this.bHL = null;
        this.dmU = i;
        this.bHL = editText;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Editable text;
        if (this.bHL != null && (text = this.bHL.getText()) != null) {
            int length = this.bHL.getText().toString().trim().length();
            if (length > 0 && !this.dmV) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_TEXT_CHANGED));
                this.dmV = true;
            }
            if (length > this.dmU) {
                int selectionEnd = Selection.getSelectionEnd(text);
                this.bHL.setText(text.toString().substring(0, this.dmU));
                Editable text2 = this.bHL.getText();
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
