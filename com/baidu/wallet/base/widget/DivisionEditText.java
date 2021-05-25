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
    public boolean f23389a;

    /* renamed from: b  reason: collision with root package name */
    public int f23390b;

    /* renamed from: c  reason: collision with root package name */
    public int f23391c;

    public DivisionEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23389a = true;
        this.f23390b = 0;
        this.f23391c = 3;
        setUseSafeKeyBoard(false);
    }

    public String getRealText() {
        return getText().toString().replace(" ", "").trim();
    }

    public boolean isFormatEnabled() {
        return this.f23389a;
    }

    public void setFormatEnable(boolean z) {
        this.f23389a = z;
    }

    public void setViewType(int i2) {
        this.f23390b = i2;
        if (i2 == 13) {
            this.f23391c = 3;
        } else if (i2 == 25) {
            this.f23391c = 4;
        } else if (i2 == 20) {
            this.f23391c = 6;
            if (isFormatEnabled()) {
                setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
                return;
            } else {
                setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2 - 2)});
                return;
            }
        }
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    public DivisionEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23389a = true;
        this.f23390b = 0;
        this.f23391c = 3;
        setUseSafeKeyBoard(false);
        addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.base.widget.DivisionEditText.1

            /* renamed from: g  reason: collision with root package name */
            public char[] f23398g;

            /* renamed from: a  reason: collision with root package name */
            public int f23392a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f23393b = 0;

            /* renamed from: c  reason: collision with root package name */
            public boolean f23394c = false;

            /* renamed from: d  reason: collision with root package name */
            public int f23395d = 0;

            /* renamed from: h  reason: collision with root package name */
            public StringBuffer f23399h = new StringBuffer();

            /* renamed from: e  reason: collision with root package name */
            public int f23396e = 0;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i2;
                if (this.f23394c && DivisionEditText.this.isFormatEnabled()) {
                    this.f23395d = DivisionEditText.this.getSelectionEnd();
                    int i3 = 0;
                    while (i3 < this.f23399h.length()) {
                        if (this.f23399h.charAt(i3) == ' ') {
                            this.f23399h.deleteCharAt(i3);
                        } else {
                            i3++;
                        }
                    }
                    if (DivisionEditText.this.f23390b != 13) {
                        if (DivisionEditText.this.f23390b != 25) {
                            if (DivisionEditText.this.f23390b == 20) {
                                i2 = 0;
                                for (int i4 = 0; i4 < this.f23399h.length(); i4++) {
                                    if (i4 == 6 || i4 == 15) {
                                        this.f23399h.insert(i4, ' ');
                                        i2++;
                                    }
                                }
                            } else {
                                i2 = 0;
                            }
                        } else {
                            i2 = 0;
                            for (int i5 = 0; i5 < this.f23399h.length(); i5++) {
                                if (i5 == 4 || i5 == 9 || i5 == 14 || i5 == 19) {
                                    this.f23399h.insert(i5, ' ');
                                    i2++;
                                }
                            }
                        }
                    } else {
                        i2 = 0;
                        for (int i6 = 0; i6 < this.f23399h.length(); i6++) {
                            if (i6 == 3 || i6 == 8) {
                                this.f23399h.insert(i6, ' ');
                                i2++;
                            }
                        }
                    }
                    int i7 = this.f23396e;
                    if (i2 > i7) {
                        if (i2 - i7 > 1) {
                            this.f23395d += i2 - i7;
                        } else {
                            int i8 = this.f23395d;
                            if (i8 - 1 >= 0 && this.f23399h.charAt(i8 - 1) == ' ') {
                                this.f23395d += i2 - this.f23396e;
                            }
                        }
                    }
                    this.f23398g = new char[this.f23399h.length()];
                    StringBuffer stringBuffer = this.f23399h;
                    stringBuffer.getChars(0, stringBuffer.length(), this.f23398g, 0);
                    String stringBuffer2 = this.f23399h.toString();
                    if (stringBuffer2.length() > DivisionEditText.this.f23390b) {
                        stringBuffer2 = stringBuffer2.substring(0, DivisionEditText.this.f23390b);
                    }
                    DivisionEditText.this.setText(stringBuffer2);
                    Editable text = DivisionEditText.this.getText();
                    if (this.f23395d > text.length()) {
                        this.f23395d = text.length();
                    } else if (this.f23395d < 0) {
                        this.f23395d = 0;
                    }
                    Selection.setSelection(text, this.f23395d);
                    if (DivisionEditText.this.f23390b == 13 && this.f23392a < editable.length()) {
                        if (!DivisionEditText.this.isFormatEnabled() && text.length() == 11) {
                            Selection.setSelection(text, 11);
                        } else if (text.length() == 13) {
                            Selection.setSelection(text, 13);
                        }
                    }
                    this.f23394c = false;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                this.f23392a = charSequence.length();
                if (this.f23399h.length() > 0) {
                    StringBuffer stringBuffer = this.f23399h;
                    stringBuffer.delete(0, stringBuffer.length());
                }
                this.f23396e = 0;
                for (int i5 = 0; i5 < charSequence.length(); i5++) {
                    if (charSequence.charAt(i5) == ' ') {
                        this.f23396e++;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                this.f23393b = charSequence.length();
                if (DivisionEditText.this.f23390b == 13 && this.f23393b >= 11 && !DivisionEditText.this.isFormatEnabled()) {
                    DivisionEditText.this.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
                }
                this.f23399h.append(charSequence.toString());
                int i5 = this.f23393b;
                if (i5 != this.f23392a && i5 >= DivisionEditText.this.f23391c && !this.f23394c) {
                    this.f23394c = true;
                } else {
                    this.f23394c = false;
                }
            }
        });
    }

    public DivisionEditText(Context context) {
        this(context, null);
    }
}
