package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.wallet.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.wallet.base.widget.textfilter.IEditTextPasteFilter;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class CustomAutoTextView extends AutoCompleteTextView {
    public static final int VIEW_TYPE_BANKCARD = 24;
    public static final int VIEW_TYPE_PHONE = 13;

    /* renamed from: a  reason: collision with root package name */
    public String f23359a;

    /* renamed from: b  reason: collision with root package name */
    public int f23360b;

    /* renamed from: c  reason: collision with root package name */
    public int f23361c;

    /* renamed from: d  reason: collision with root package name */
    public Context f23362d;

    /* renamed from: e  reason: collision with root package name */
    public int f23363e;

    /* renamed from: f  reason: collision with root package name */
    public List<IEditTextPasteFilter> f23364f;

    /* renamed from: g  reason: collision with root package name */
    public ShowDropDownListener f23365g;

    /* loaded from: classes5.dex */
    public interface ShowDropDownListener {
        void showDisplayTranslucent();
    }

    public CustomAutoTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23359a = CustomAutoTextView.class.getSimpleName();
        this.f23360b = 13;
        this.f23361c = 3;
        this.f23362d = null;
        this.f23364f = new ArrayList();
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter == null || parseEditTextPasteFilter.size() <= 0) {
            return;
        }
        this.f23364f.addAll(parseEditTextPasteFilter);
    }

    public void addEditTextPasteFilter(IEditTextPasteFilter iEditTextPasteFilter) {
        if (iEditTextPasteFilter != null) {
            this.f23364f.add(iEditTextPasteFilter);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public boolean enoughToFilter() {
        return true;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z) {
            if (getAdapter() == null) {
                return;
            }
            performFiltering(getText(), 0);
            return;
        }
        GlobalUtils.hideInputMethod(this.f23362d, this);
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i2) {
        String str;
        if (i2 == 16908322) {
            String applyEditTextPasteFilters = EditTextPasteFilterUtils.applyEditTextPasteFilters(getContext(), this.f23364f);
            Editable editableText = getEditableText();
            try {
                int selectionStart = getSelectionStart();
                int selectionEnd = getSelectionEnd();
                if (editableText != null) {
                    String obj = editableText.toString();
                    if (!TextUtils.isEmpty(obj)) {
                        int length = obj.length();
                        String substring = obj.substring(0, selectionStart);
                        String substring2 = obj.substring(selectionEnd, length);
                        if (TextUtils.isEmpty(substring)) {
                            str = "";
                        } else {
                            str = "" + substring;
                        }
                        if (!TextUtils.isEmpty(applyEditTextPasteFilters)) {
                            str = str + applyEditTextPasteFilters;
                        }
                        if (TextUtils.isEmpty(substring2)) {
                            applyEditTextPasteFilters = str;
                        } else {
                            applyEditTextPasteFilters = str + substring2;
                        }
                    }
                    if (!TextUtils.isEmpty(applyEditTextPasteFilters)) {
                        applyEditTextPasteFilters = applyEditTextPasteFilters.replace(" ", "");
                    }
                    setText("");
                    setText(applyEditTextPasteFilters);
                    setSelection(getEditableText().length());
                    requestFocus();
                    return true;
                }
                return super.onTextContextMenuItem(i2);
            } catch (Exception e2) {
                LogUtil.d(this.f23359a, e2.getMessage());
                return super.onTextContextMenuItem(i2);
            }
        }
        return super.onTextContextMenuItem(i2);
    }

    public void setShowDropDownListener(ShowDropDownListener showDropDownListener) {
        this.f23365g = showDropDownListener;
    }

    public void setViewType(int i2) {
        this.f23360b = i2;
        this.f23361c = i2 == 13 ? 3 : 4;
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (getText().length() == 13 || getAdapter() == null || getAdapter().getCount() == 0) {
            return;
        }
        ShowDropDownListener showDropDownListener = this.f23365g;
        if (showDropDownListener != null) {
            showDropDownListener.showDisplayTranslucent();
        }
        super.showDropDown();
    }

    public CustomAutoTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23359a = CustomAutoTextView.class.getSimpleName();
        this.f23360b = 13;
        this.f23361c = 3;
        this.f23362d = null;
        this.f23364f = new ArrayList();
        this.f23362d = context;
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter != null && parseEditTextPasteFilter.size() > 0) {
            this.f23364f.addAll(parseEditTextPasteFilter);
        }
        addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.base.widget.CustomAutoTextView.1

            /* renamed from: g  reason: collision with root package name */
            public char[] f23372g;

            /* renamed from: a  reason: collision with root package name */
            public int f23366a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f23367b = 0;

            /* renamed from: c  reason: collision with root package name */
            public boolean f23368c = false;

            /* renamed from: d  reason: collision with root package name */
            public int f23369d = 0;

            /* renamed from: h  reason: collision with root package name */
            public StringBuffer f23373h = new StringBuffer();

            /* renamed from: e  reason: collision with root package name */
            public int f23370e = 0;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i2;
                if (this.f23368c) {
                    this.f23369d = CustomAutoTextView.this.getSelectionEnd();
                    int i3 = CustomAutoTextView.this.f23360b == 13 ? 3 : 100;
                    int i4 = 0;
                    loop0: while (true) {
                        boolean z = true;
                        while (i4 < this.f23373h.length()) {
                            if (i4 == i3 && this.f23373h.charAt(i4) != ' ' && this.f23367b == this.f23366a - 1 && z) {
                                i4--;
                                this.f23373h.deleteCharAt(i4);
                                this.f23369d--;
                                z = false;
                            }
                            if (this.f23373h.charAt(i4) == ' ') {
                                break;
                            }
                            i4++;
                        }
                        this.f23373h.deleteCharAt(i4);
                        i3 = i4 + 4;
                    }
                    if (CustomAutoTextView.this.f23360b != 13) {
                        if (CustomAutoTextView.this.f23360b == 24) {
                            i2 = 0;
                            for (int i5 = 0; i5 < this.f23373h.length(); i5++) {
                                if (i5 == 4 || i5 == 9 || i5 == 14 || i5 == 19) {
                                    this.f23373h.insert(i5, ' ');
                                    i2++;
                                }
                            }
                        } else {
                            i2 = 0;
                        }
                    } else {
                        i2 = 0;
                        for (int i6 = 0; i6 < this.f23373h.length(); i6++) {
                            if (i6 == 3 || i6 == 8) {
                                this.f23373h.insert(i6, ' ');
                                i2++;
                            }
                        }
                    }
                    int i7 = this.f23370e;
                    if (i2 > i7) {
                        this.f23369d += i2 - i7;
                    }
                    this.f23372g = new char[this.f23373h.length()];
                    StringBuffer stringBuffer = this.f23373h;
                    stringBuffer.getChars(0, stringBuffer.length(), this.f23372g, 0);
                    String stringBuffer2 = this.f23373h.toString();
                    if (stringBuffer2.length() > CustomAutoTextView.this.f23360b) {
                        stringBuffer2 = stringBuffer2.substring(0, CustomAutoTextView.this.f23360b);
                    }
                    if (this.f23369d > stringBuffer2.length()) {
                        this.f23369d = stringBuffer2.length();
                    } else if (this.f23369d < 0) {
                        this.f23369d = 0;
                    }
                    CustomAutoTextView.this.setText(stringBuffer2);
                    Editable text = CustomAutoTextView.this.getText();
                    Selection.setSelection(text, this.f23369d);
                    if (CustomAutoTextView.this.f23360b == 13 && text.length() == 13) {
                        Selection.setSelection(text, 13);
                    }
                    this.f23368c = false;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                this.f23366a = charSequence.length();
                if (this.f23373h.length() > 0) {
                    StringBuffer stringBuffer = this.f23373h;
                    stringBuffer.delete(0, stringBuffer.length());
                }
                this.f23370e = 0;
                for (int i5 = 0; i5 < charSequence.length(); i5++) {
                    if (charSequence.charAt(i5) == ' ') {
                        this.f23370e++;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                this.f23367b = charSequence.length();
                this.f23373h.append(charSequence.toString());
                int i5 = this.f23367b;
                if (i5 != this.f23366a && i5 >= CustomAutoTextView.this.f23361c && !this.f23368c) {
                    this.f23368c = true;
                } else {
                    this.f23368c = false;
                }
            }
        });
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.base.widget.CustomAutoTextView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                GlobalUtils.showInputMethod(CustomAutoTextView.this.f23362d, view);
                int[] iArr = new int[2];
                CustomAutoTextView.this.getLocationInWindow(iArr);
                int paddingLeft = CustomAutoTextView.this.getPaddingLeft();
                int action = motionEvent.getAction();
                Layout layout = CustomAutoTextView.this.getLayout();
                if (action == 0) {
                    int lineForVertical = layout.getLineForVertical(CustomAutoTextView.this.getScrollY() + ((int) motionEvent.getY()));
                    CustomAutoTextView.this.f23363e = layout.getOffsetForHorizontal(lineForVertical, (int) ((motionEvent.getX() - iArr[0]) - paddingLeft));
                    Selection.setSelection(CustomAutoTextView.this.getEditableText(), CustomAutoTextView.this.f23363e);
                } else if (action == 1 || action == 2) {
                    Selection.setSelection(CustomAutoTextView.this.getEditableText(), CustomAutoTextView.this.f23363e, layout.getOffsetForHorizontal(layout.getLineForVertical(CustomAutoTextView.this.getScrollY() + ((int) motionEvent.getY())), (((int) motionEvent.getX()) - iArr[0]) - paddingLeft));
                }
                return false;
            }
        });
    }

    public CustomAutoTextView(Context context) {
        this(context, null);
    }
}
