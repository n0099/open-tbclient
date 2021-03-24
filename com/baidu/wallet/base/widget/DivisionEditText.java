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
    public boolean f23795a;

    /* renamed from: b  reason: collision with root package name */
    public int f23796b;

    /* renamed from: c  reason: collision with root package name */
    public int f23797c;

    public DivisionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23795a = true;
        this.f23796b = 0;
        this.f23797c = 3;
        setUseSafeKeyBoard(false);
    }

    public String getRealText() {
        return getText().toString().replace(" ", "").trim();
    }

    public boolean isFormatEnabled() {
        return this.f23795a;
    }

    public void setFormatEnable(boolean z) {
        this.f23795a = z;
    }

    public void setViewType(int i) {
        this.f23796b = i;
        if (i == 13) {
            this.f23797c = 3;
        } else if (i == 25) {
            this.f23797c = 4;
        } else if (i == 20) {
            this.f23797c = 6;
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
        this.f23795a = true;
        this.f23796b = 0;
        this.f23797c = 3;
        setUseSafeKeyBoard(false);
        addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.base.widget.DivisionEditText.1

            /* renamed from: g  reason: collision with root package name */
            public char[] f23804g;

            /* renamed from: a  reason: collision with root package name */
            public int f23798a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f23799b = 0;

            /* renamed from: c  reason: collision with root package name */
            public boolean f23800c = false;

            /* renamed from: d  reason: collision with root package name */
            public int f23801d = 0;

            /* renamed from: h  reason: collision with root package name */
            public StringBuffer f23805h = new StringBuffer();

            /* renamed from: e  reason: collision with root package name */
            public int f23802e = 0;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i;
                if (this.f23800c && DivisionEditText.this.isFormatEnabled()) {
                    this.f23801d = DivisionEditText.this.getSelectionEnd();
                    int i2 = 0;
                    while (i2 < this.f23805h.length()) {
                        if (this.f23805h.charAt(i2) == ' ') {
                            this.f23805h.deleteCharAt(i2);
                        } else {
                            i2++;
                        }
                    }
                    if (DivisionEditText.this.f23796b != 13) {
                        if (DivisionEditText.this.f23796b != 25) {
                            if (DivisionEditText.this.f23796b == 20) {
                                i = 0;
                                for (int i3 = 0; i3 < this.f23805h.length(); i3++) {
                                    if (i3 == 6 || i3 == 15) {
                                        this.f23805h.insert(i3, ' ');
                                        i++;
                                    }
                                }
                            } else {
                                i = 0;
                            }
                        } else {
                            i = 0;
                            for (int i4 = 0; i4 < this.f23805h.length(); i4++) {
                                if (i4 == 4 || i4 == 9 || i4 == 14 || i4 == 19) {
                                    this.f23805h.insert(i4, ' ');
                                    i++;
                                }
                            }
                        }
                    } else {
                        i = 0;
                        for (int i5 = 0; i5 < this.f23805h.length(); i5++) {
                            if (i5 == 3 || i5 == 8) {
                                this.f23805h.insert(i5, ' ');
                                i++;
                            }
                        }
                    }
                    int i6 = this.f23802e;
                    if (i > i6) {
                        if (i - i6 > 1) {
                            this.f23801d += i - i6;
                        } else {
                            int i7 = this.f23801d;
                            if (i7 - 1 >= 0 && this.f23805h.charAt(i7 - 1) == ' ') {
                                this.f23801d += i - this.f23802e;
                            }
                        }
                    }
                    this.f23804g = new char[this.f23805h.length()];
                    StringBuffer stringBuffer = this.f23805h;
                    stringBuffer.getChars(0, stringBuffer.length(), this.f23804g, 0);
                    String stringBuffer2 = this.f23805h.toString();
                    if (stringBuffer2.length() > DivisionEditText.this.f23796b) {
                        stringBuffer2 = stringBuffer2.substring(0, DivisionEditText.this.f23796b);
                    }
                    DivisionEditText.this.setText(stringBuffer2);
                    Editable text = DivisionEditText.this.getText();
                    if (this.f23801d > text.length()) {
                        this.f23801d = text.length();
                    } else if (this.f23801d < 0) {
                        this.f23801d = 0;
                    }
                    Selection.setSelection(text, this.f23801d);
                    if (DivisionEditText.this.f23796b == 13 && this.f23798a < editable.length()) {
                        if (!DivisionEditText.this.isFormatEnabled() && text.length() == 11) {
                            Selection.setSelection(text, 11);
                        } else if (text.length() == 13) {
                            Selection.setSelection(text, 13);
                        }
                    }
                    this.f23800c = false;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f23798a = charSequence.length();
                if (this.f23805h.length() > 0) {
                    StringBuffer stringBuffer = this.f23805h;
                    stringBuffer.delete(0, stringBuffer.length());
                }
                this.f23802e = 0;
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (charSequence.charAt(i4) == ' ') {
                        this.f23802e++;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f23799b = charSequence.length();
                if (DivisionEditText.this.f23796b == 13 && this.f23799b >= 11 && !DivisionEditText.this.isFormatEnabled()) {
                    DivisionEditText.this.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
                }
                this.f23805h.append(charSequence.toString());
                int i4 = this.f23799b;
                if (i4 != this.f23798a && i4 >= DivisionEditText.this.f23797c && !this.f23800c) {
                    this.f23800c = true;
                } else {
                    this.f23800c = false;
                }
            }
        });
    }

    public DivisionEditText(Context context) {
        this(context, null);
    }
}
