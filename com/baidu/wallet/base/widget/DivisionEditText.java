package com.baidu.wallet.base.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
/* loaded from: classes5.dex */
public class DivisionEditText extends SafeKeyBoardEditText {
    public static final int VIEW_TYPE_BANKCARD = 25;
    public static final int VIEW_TYPE_ID = 20;
    public static final int VIEW_TYPE_PHONE = 13;

    /* renamed from: a  reason: collision with root package name */
    public boolean f23481a;

    /* renamed from: b  reason: collision with root package name */
    public int f23482b;

    /* renamed from: c  reason: collision with root package name */
    public int f23483c;

    public DivisionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23481a = true;
        this.f23482b = 0;
        this.f23483c = 3;
        setUseSafeKeyBoard(false);
    }

    public String getRealText() {
        return getText().toString().replace(" ", "").trim();
    }

    public boolean isFormatEnabled() {
        return this.f23481a;
    }

    public void setFormatEnable(boolean z) {
        this.f23481a = z;
    }

    public void setViewType(int i) {
        this.f23482b = i;
        if (i == 13) {
            this.f23483c = 3;
        } else if (i == 25) {
            this.f23483c = 4;
        } else if (i == 20) {
            this.f23483c = 6;
            if (isFormatEnabled()) {
                setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
                return;
            } else {
                setFilters(new InputFilter[]{new InputFilter.LengthFilter(i - 2)});
                return;
            }
        }
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
    }

    public DivisionEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23481a = true;
        this.f23482b = 0;
        this.f23483c = 3;
        setUseSafeKeyBoard(false);
        addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.base.widget.DivisionEditText.1

            /* renamed from: g  reason: collision with root package name */
            public char[] f23490g;

            /* renamed from: a  reason: collision with root package name */
            public int f23484a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f23485b = 0;

            /* renamed from: c  reason: collision with root package name */
            public boolean f23486c = false;

            /* renamed from: d  reason: collision with root package name */
            public int f23487d = 0;

            /* renamed from: h  reason: collision with root package name */
            public StringBuffer f23491h = new StringBuffer();

            /* renamed from: e  reason: collision with root package name */
            public int f23488e = 0;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i;
                if (this.f23486c && DivisionEditText.this.isFormatEnabled()) {
                    this.f23487d = DivisionEditText.this.getSelectionEnd();
                    int i2 = 0;
                    while (i2 < this.f23491h.length()) {
                        if (this.f23491h.charAt(i2) == ' ') {
                            this.f23491h.deleteCharAt(i2);
                        } else {
                            i2++;
                        }
                    }
                    if (DivisionEditText.this.f23482b != 13) {
                        if (DivisionEditText.this.f23482b != 25) {
                            if (DivisionEditText.this.f23482b == 20) {
                                i = 0;
                                for (int i3 = 0; i3 < this.f23491h.length(); i3++) {
                                    if (i3 == 6 || i3 == 15) {
                                        this.f23491h.insert(i3, ' ');
                                        i++;
                                    }
                                }
                            } else {
                                i = 0;
                            }
                        } else {
                            i = 0;
                            for (int i4 = 0; i4 < this.f23491h.length(); i4++) {
                                if (i4 == 4 || i4 == 9 || i4 == 14 || i4 == 19) {
                                    this.f23491h.insert(i4, ' ');
                                    i++;
                                }
                            }
                        }
                    } else {
                        i = 0;
                        for (int i5 = 0; i5 < this.f23491h.length(); i5++) {
                            if (i5 == 3 || i5 == 8) {
                                this.f23491h.insert(i5, ' ');
                                i++;
                            }
                        }
                    }
                    int i6 = this.f23488e;
                    if (i > i6) {
                        if (i - i6 > 1) {
                            this.f23487d += i - i6;
                        } else {
                            int i7 = this.f23487d;
                            if (i7 - 1 >= 0 && this.f23491h.charAt(i7 - 1) == ' ') {
                                this.f23487d += i - this.f23488e;
                            }
                        }
                    }
                    this.f23490g = new char[this.f23491h.length()];
                    StringBuffer stringBuffer = this.f23491h;
                    stringBuffer.getChars(0, stringBuffer.length(), this.f23490g, 0);
                    String stringBuffer2 = this.f23491h.toString();
                    if (stringBuffer2.length() > DivisionEditText.this.f23482b) {
                        stringBuffer2 = stringBuffer2.substring(0, DivisionEditText.this.f23482b);
                    }
                    DivisionEditText.this.setText(stringBuffer2);
                    Editable text = DivisionEditText.this.getText();
                    if (this.f23487d > text.length()) {
                        this.f23487d = text.length();
                    } else if (this.f23487d < 0) {
                        this.f23487d = 0;
                    }
                    Selection.setSelection(text, this.f23487d);
                    if (DivisionEditText.this.f23482b == 13 && this.f23484a < editable.length()) {
                        if (!DivisionEditText.this.isFormatEnabled() && text.length() == 11) {
                            Selection.setSelection(text, 11);
                        } else if (text.length() == 13) {
                            Selection.setSelection(text, 13);
                        }
                    }
                    this.f23486c = false;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f23484a = charSequence.length();
                if (this.f23491h.length() > 0) {
                    StringBuffer stringBuffer = this.f23491h;
                    stringBuffer.delete(0, stringBuffer.length());
                }
                this.f23488e = 0;
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (charSequence.charAt(i4) == ' ') {
                        this.f23488e++;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f23485b = charSequence.length();
                if (DivisionEditText.this.f23482b == 13 && this.f23485b >= 11 && !DivisionEditText.this.isFormatEnabled()) {
                    DivisionEditText.this.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
                }
                this.f23491h.append(charSequence.toString());
                int i4 = this.f23485b;
                if (i4 != this.f23484a && i4 >= DivisionEditText.this.f23483c && !this.f23486c) {
                    this.f23486c = true;
                } else {
                    this.f23486c = false;
                }
            }
        });
    }

    public DivisionEditText(Context context) {
        this(context, null);
    }
}
