package com.baidu.tieba.write.vote;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class a implements TextWatcher {
    private int hIX;
    private boolean hIY = false;
    private EditText rD;

    public a(int i, EditText editText) {
        this.hIX = 0;
        this.rD = null;
        this.hIX = i;
        this.rD = editText;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Editable text;
        if (this.rD != null && (text = this.rD.getText()) != null) {
            int length = this.rD.getText().toString().trim().length();
            if (length > 0 && !this.hIY) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001357));
                this.hIY = true;
            }
            if (length > this.hIX) {
                int selectionEnd = Selection.getSelectionEnd(text);
                this.rD.setText(text.toString().substring(0, this.hIX));
                Editable text2 = this.rD.getText();
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
