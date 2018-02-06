package com.baidu.tieba.write.vote;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class a implements TextWatcher {
    private int hIM;
    private boolean hIN = false;
    private EditText rE;

    public a(int i, EditText editText) {
        this.hIM = 0;
        this.rE = null;
        this.hIM = i;
        this.rE = editText;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Editable text;
        if (this.rE != null && (text = this.rE.getText()) != null) {
            int length = this.rE.getText().toString().trim().length();
            if (length > 0 && !this.hIN) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001357));
                this.hIN = true;
            }
            if (length > this.hIM) {
                int selectionEnd = Selection.getSelectionEnd(text);
                this.rE.setText(text.toString().substring(0, this.hIM));
                Editable text2 = this.rE.getText();
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
