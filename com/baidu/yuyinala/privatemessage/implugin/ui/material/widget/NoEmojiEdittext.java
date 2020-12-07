package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget;

import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
/* loaded from: classes4.dex */
public class NoEmojiEdittext extends EditText {
    private Context mContext;
    private int oSC;
    private String oSD;
    private boolean oSE;

    public NoEmojiEdittext(Context context) {
        super(context);
        this.mContext = context;
        dxr();
    }

    public NoEmojiEdittext(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        dxr();
    }

    public NoEmojiEdittext(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        dxr();
    }

    private void dxr() {
        addTextChangedListener(new TextWatcher() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.NoEmojiEdittext.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!NoEmojiEdittext.this.oSE) {
                    NoEmojiEdittext.this.oSC = NoEmojiEdittext.this.getSelectionEnd();
                    NoEmojiEdittext.this.oSD = charSequence.toString();
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                try {
                    if (NoEmojiEdittext.this.oSE) {
                        NoEmojiEdittext.this.oSE = false;
                    } else if (i3 >= 2 && NoEmojiEdittext.this.oSC + i3 <= charSequence.length() && NoEmojiEdittext.containsEmoji(charSequence.subSequence(NoEmojiEdittext.this.oSC, NoEmojiEdittext.this.oSC + i3).toString())) {
                        NoEmojiEdittext.this.oSE = true;
                        NoEmojiEdittext.this.setText(NoEmojiEdittext.this.oSD);
                        Editable text = NoEmojiEdittext.this.getText();
                        if (text instanceof Spannable) {
                            Selection.setSelection(text, text.length());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public static boolean containsEmoji(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!isEmojiCharacter(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEmojiCharacter(char c) {
        return c == 0 || c == '\t' || c == '\n' || c == '\r' || (c >= ' ' && c <= 55295) || ((c >= 57344 && c <= 65533) || (c >= 0 && c <= 65535));
    }
}
