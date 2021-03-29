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
    public boolean f23796a;

    /* renamed from: b  reason: collision with root package name */
    public int f23797b;

    /* renamed from: c  reason: collision with root package name */
    public int f23798c;

    public DivisionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23796a = true;
        this.f23797b = 0;
        this.f23798c = 3;
        setUseSafeKeyBoard(false);
    }

    public String getRealText() {
        return getText().toString().replace(" ", "").trim();
    }

    public boolean isFormatEnabled() {
        return this.f23796a;
    }

    public void setFormatEnable(boolean z) {
        this.f23796a = z;
    }

    public void setViewType(int i) {
        this.f23797b = i;
        if (i == 13) {
            this.f23798c = 3;
        } else if (i == 25) {
            this.f23798c = 4;
        } else if (i == 20) {
            this.f23798c = 6;
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
        this.f23796a = true;
        this.f23797b = 0;
        this.f23798c = 3;
        setUseSafeKeyBoard(false);
        addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.base.widget.DivisionEditText.1

            /* renamed from: g  reason: collision with root package name */
            public char[] f23805g;

            /* renamed from: a  reason: collision with root package name */
            public int f23799a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f23800b = 0;

            /* renamed from: c  reason: collision with root package name */
            public boolean f23801c = false;

            /* renamed from: d  reason: collision with root package name */
            public int f23802d = 0;

            /* renamed from: h  reason: collision with root package name */
            public StringBuffer f23806h = new StringBuffer();

            /* renamed from: e  reason: collision with root package name */
            public int f23803e = 0;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i;
                if (this.f23801c && DivisionEditText.this.isFormatEnabled()) {
                    this.f23802d = DivisionEditText.this.getSelectionEnd();
                    int i2 = 0;
                    while (i2 < this.f23806h.length()) {
                        if (this.f23806h.charAt(i2) == ' ') {
                            this.f23806h.deleteCharAt(i2);
                        } else {
                            i2++;
                        }
                    }
                    if (DivisionEditText.this.f23797b != 13) {
                        if (DivisionEditText.this.f23797b != 25) {
                            if (DivisionEditText.this.f23797b == 20) {
                                i = 0;
                                for (int i3 = 0; i3 < this.f23806h.length(); i3++) {
                                    if (i3 == 6 || i3 == 15) {
                                        this.f23806h.insert(i3, ' ');
                                        i++;
                                    }
                                }
                            } else {
                                i = 0;
                            }
                        } else {
                            i = 0;
                            for (int i4 = 0; i4 < this.f23806h.length(); i4++) {
                                if (i4 == 4 || i4 == 9 || i4 == 14 || i4 == 19) {
                                    this.f23806h.insert(i4, ' ');
                                    i++;
                                }
                            }
                        }
                    } else {
                        i = 0;
                        for (int i5 = 0; i5 < this.f23806h.length(); i5++) {
                            if (i5 == 3 || i5 == 8) {
                                this.f23806h.insert(i5, ' ');
                                i++;
                            }
                        }
                    }
                    int i6 = this.f23803e;
                    if (i > i6) {
                        if (i - i6 > 1) {
                            this.f23802d += i - i6;
                        } else {
                            int i7 = this.f23802d;
                            if (i7 - 1 >= 0 && this.f23806h.charAt(i7 - 1) == ' ') {
                                this.f23802d += i - this.f23803e;
                            }
                        }
                    }
                    this.f23805g = new char[this.f23806h.length()];
                    StringBuffer stringBuffer = this.f23806h;
                    stringBuffer.getChars(0, stringBuffer.length(), this.f23805g, 0);
                    String stringBuffer2 = this.f23806h.toString();
                    if (stringBuffer2.length() > DivisionEditText.this.f23797b) {
                        stringBuffer2 = stringBuffer2.substring(0, DivisionEditText.this.f23797b);
                    }
                    DivisionEditText.this.setText(stringBuffer2);
                    Editable text = DivisionEditText.this.getText();
                    if (this.f23802d > text.length()) {
                        this.f23802d = text.length();
                    } else if (this.f23802d < 0) {
                        this.f23802d = 0;
                    }
                    Selection.setSelection(text, this.f23802d);
                    if (DivisionEditText.this.f23797b == 13 && this.f23799a < editable.length()) {
                        if (!DivisionEditText.this.isFormatEnabled() && text.length() == 11) {
                            Selection.setSelection(text, 11);
                        } else if (text.length() == 13) {
                            Selection.setSelection(text, 13);
                        }
                    }
                    this.f23801c = false;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f23799a = charSequence.length();
                if (this.f23806h.length() > 0) {
                    StringBuffer stringBuffer = this.f23806h;
                    stringBuffer.delete(0, stringBuffer.length());
                }
                this.f23803e = 0;
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (charSequence.charAt(i4) == ' ') {
                        this.f23803e++;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f23800b = charSequence.length();
                if (DivisionEditText.this.f23797b == 13 && this.f23800b >= 11 && !DivisionEditText.this.isFormatEnabled()) {
                    DivisionEditText.this.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
                }
                this.f23806h.append(charSequence.toString());
                int i4 = this.f23800b;
                if (i4 != this.f23799a && i4 >= DivisionEditText.this.f23798c && !this.f23801c) {
                    this.f23801c = true;
                } else {
                    this.f23801c = false;
                }
            }
        });
    }

    public DivisionEditText(Context context) {
        this(context, null);
    }
}
