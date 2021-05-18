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
    public boolean f23460a;

    /* renamed from: b  reason: collision with root package name */
    public int f23461b;

    /* renamed from: c  reason: collision with root package name */
    public int f23462c;

    public DivisionEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23460a = true;
        this.f23461b = 0;
        this.f23462c = 3;
        setUseSafeKeyBoard(false);
    }

    public String getRealText() {
        return getText().toString().replace(" ", "").trim();
    }

    public boolean isFormatEnabled() {
        return this.f23460a;
    }

    public void setFormatEnable(boolean z) {
        this.f23460a = z;
    }

    public void setViewType(int i2) {
        this.f23461b = i2;
        if (i2 == 13) {
            this.f23462c = 3;
        } else if (i2 == 25) {
            this.f23462c = 4;
        } else if (i2 == 20) {
            this.f23462c = 6;
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
        this.f23460a = true;
        this.f23461b = 0;
        this.f23462c = 3;
        setUseSafeKeyBoard(false);
        addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.base.widget.DivisionEditText.1

            /* renamed from: g  reason: collision with root package name */
            public char[] f23469g;

            /* renamed from: a  reason: collision with root package name */
            public int f23463a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f23464b = 0;

            /* renamed from: c  reason: collision with root package name */
            public boolean f23465c = false;

            /* renamed from: d  reason: collision with root package name */
            public int f23466d = 0;

            /* renamed from: h  reason: collision with root package name */
            public StringBuffer f23470h = new StringBuffer();

            /* renamed from: e  reason: collision with root package name */
            public int f23467e = 0;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i2;
                if (this.f23465c && DivisionEditText.this.isFormatEnabled()) {
                    this.f23466d = DivisionEditText.this.getSelectionEnd();
                    int i3 = 0;
                    while (i3 < this.f23470h.length()) {
                        if (this.f23470h.charAt(i3) == ' ') {
                            this.f23470h.deleteCharAt(i3);
                        } else {
                            i3++;
                        }
                    }
                    if (DivisionEditText.this.f23461b != 13) {
                        if (DivisionEditText.this.f23461b != 25) {
                            if (DivisionEditText.this.f23461b == 20) {
                                i2 = 0;
                                for (int i4 = 0; i4 < this.f23470h.length(); i4++) {
                                    if (i4 == 6 || i4 == 15) {
                                        this.f23470h.insert(i4, ' ');
                                        i2++;
                                    }
                                }
                            } else {
                                i2 = 0;
                            }
                        } else {
                            i2 = 0;
                            for (int i5 = 0; i5 < this.f23470h.length(); i5++) {
                                if (i5 == 4 || i5 == 9 || i5 == 14 || i5 == 19) {
                                    this.f23470h.insert(i5, ' ');
                                    i2++;
                                }
                            }
                        }
                    } else {
                        i2 = 0;
                        for (int i6 = 0; i6 < this.f23470h.length(); i6++) {
                            if (i6 == 3 || i6 == 8) {
                                this.f23470h.insert(i6, ' ');
                                i2++;
                            }
                        }
                    }
                    int i7 = this.f23467e;
                    if (i2 > i7) {
                        if (i2 - i7 > 1) {
                            this.f23466d += i2 - i7;
                        } else {
                            int i8 = this.f23466d;
                            if (i8 - 1 >= 0 && this.f23470h.charAt(i8 - 1) == ' ') {
                                this.f23466d += i2 - this.f23467e;
                            }
                        }
                    }
                    this.f23469g = new char[this.f23470h.length()];
                    StringBuffer stringBuffer = this.f23470h;
                    stringBuffer.getChars(0, stringBuffer.length(), this.f23469g, 0);
                    String stringBuffer2 = this.f23470h.toString();
                    if (stringBuffer2.length() > DivisionEditText.this.f23461b) {
                        stringBuffer2 = stringBuffer2.substring(0, DivisionEditText.this.f23461b);
                    }
                    DivisionEditText.this.setText(stringBuffer2);
                    Editable text = DivisionEditText.this.getText();
                    if (this.f23466d > text.length()) {
                        this.f23466d = text.length();
                    } else if (this.f23466d < 0) {
                        this.f23466d = 0;
                    }
                    Selection.setSelection(text, this.f23466d);
                    if (DivisionEditText.this.f23461b == 13 && this.f23463a < editable.length()) {
                        if (!DivisionEditText.this.isFormatEnabled() && text.length() == 11) {
                            Selection.setSelection(text, 11);
                        } else if (text.length() == 13) {
                            Selection.setSelection(text, 13);
                        }
                    }
                    this.f23465c = false;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                this.f23463a = charSequence.length();
                if (this.f23470h.length() > 0) {
                    StringBuffer stringBuffer = this.f23470h;
                    stringBuffer.delete(0, stringBuffer.length());
                }
                this.f23467e = 0;
                for (int i5 = 0; i5 < charSequence.length(); i5++) {
                    if (charSequence.charAt(i5) == ' ') {
                        this.f23467e++;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                this.f23464b = charSequence.length();
                if (DivisionEditText.this.f23461b == 13 && this.f23464b >= 11 && !DivisionEditText.this.isFormatEnabled()) {
                    DivisionEditText.this.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
                }
                this.f23470h.append(charSequence.toString());
                int i5 = this.f23464b;
                if (i5 != this.f23463a && i5 >= DivisionEditText.this.f23462c && !this.f23465c) {
                    this.f23465c = true;
                } else {
                    this.f23465c = false;
                }
            }
        });
    }

    public DivisionEditText(Context context) {
        this(context, null);
    }
}
