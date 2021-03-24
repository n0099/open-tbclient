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
    public String f23765a;

    /* renamed from: b  reason: collision with root package name */
    public int f23766b;

    /* renamed from: c  reason: collision with root package name */
    public int f23767c;

    /* renamed from: d  reason: collision with root package name */
    public Context f23768d;

    /* renamed from: e  reason: collision with root package name */
    public int f23769e;

    /* renamed from: f  reason: collision with root package name */
    public List<IEditTextPasteFilter> f23770f;

    /* renamed from: g  reason: collision with root package name */
    public ShowDropDownListener f23771g;

    /* loaded from: classes5.dex */
    public interface ShowDropDownListener {
        void showDisplayTranslucent();
    }

    public CustomAutoTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23765a = CustomAutoTextView.class.getSimpleName();
        this.f23766b = 13;
        this.f23767c = 3;
        this.f23768d = null;
        this.f23770f = new ArrayList();
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter == null || parseEditTextPasteFilter.size() <= 0) {
            return;
        }
        this.f23770f.addAll(parseEditTextPasteFilter);
    }

    public void addEditTextPasteFilter(IEditTextPasteFilter iEditTextPasteFilter) {
        if (iEditTextPasteFilter != null) {
            this.f23770f.add(iEditTextPasteFilter);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public boolean enoughToFilter() {
        return true;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            if (getAdapter() == null) {
                return;
            }
            performFiltering(getText(), 0);
            return;
        }
        GlobalUtils.hideInputMethod(this.f23768d, this);
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        String str;
        if (i == 16908322) {
            String applyEditTextPasteFilters = EditTextPasteFilterUtils.applyEditTextPasteFilters(getContext(), this.f23770f);
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
                return super.onTextContextMenuItem(i);
            } catch (Exception e2) {
                LogUtil.d(this.f23765a, e2.getMessage());
                return super.onTextContextMenuItem(i);
            }
        }
        return super.onTextContextMenuItem(i);
    }

    public void setShowDropDownListener(ShowDropDownListener showDropDownListener) {
        this.f23771g = showDropDownListener;
    }

    public void setViewType(int i) {
        this.f23766b = i;
        this.f23767c = i == 13 ? 3 : 4;
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (getText().length() == 13 || getAdapter() == null || getAdapter().getCount() == 0) {
            return;
        }
        ShowDropDownListener showDropDownListener = this.f23771g;
        if (showDropDownListener != null) {
            showDropDownListener.showDisplayTranslucent();
        }
        super.showDropDown();
    }

    public CustomAutoTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23765a = CustomAutoTextView.class.getSimpleName();
        this.f23766b = 13;
        this.f23767c = 3;
        this.f23768d = null;
        this.f23770f = new ArrayList();
        this.f23768d = context;
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter != null && parseEditTextPasteFilter.size() > 0) {
            this.f23770f.addAll(parseEditTextPasteFilter);
        }
        addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.base.widget.CustomAutoTextView.1

            /* renamed from: g  reason: collision with root package name */
            public char[] f23778g;

            /* renamed from: a  reason: collision with root package name */
            public int f23772a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f23773b = 0;

            /* renamed from: c  reason: collision with root package name */
            public boolean f23774c = false;

            /* renamed from: d  reason: collision with root package name */
            public int f23775d = 0;

            /* renamed from: h  reason: collision with root package name */
            public StringBuffer f23779h = new StringBuffer();

            /* renamed from: e  reason: collision with root package name */
            public int f23776e = 0;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i;
                if (this.f23774c) {
                    this.f23775d = CustomAutoTextView.this.getSelectionEnd();
                    int i2 = CustomAutoTextView.this.f23766b == 13 ? 3 : 100;
                    int i3 = 0;
                    loop0: while (true) {
                        boolean z = true;
                        while (i3 < this.f23779h.length()) {
                            if (i3 == i2 && this.f23779h.charAt(i3) != ' ' && this.f23773b == this.f23772a - 1 && z) {
                                i3--;
                                this.f23779h.deleteCharAt(i3);
                                this.f23775d--;
                                z = false;
                            }
                            if (this.f23779h.charAt(i3) == ' ') {
                                break;
                            }
                            i3++;
                        }
                        this.f23779h.deleteCharAt(i3);
                        i2 = i3 + 4;
                    }
                    if (CustomAutoTextView.this.f23766b != 13) {
                        if (CustomAutoTextView.this.f23766b == 24) {
                            i = 0;
                            for (int i4 = 0; i4 < this.f23779h.length(); i4++) {
                                if (i4 == 4 || i4 == 9 || i4 == 14 || i4 == 19) {
                                    this.f23779h.insert(i4, ' ');
                                    i++;
                                }
                            }
                        } else {
                            i = 0;
                        }
                    } else {
                        i = 0;
                        for (int i5 = 0; i5 < this.f23779h.length(); i5++) {
                            if (i5 == 3 || i5 == 8) {
                                this.f23779h.insert(i5, ' ');
                                i++;
                            }
                        }
                    }
                    int i6 = this.f23776e;
                    if (i > i6) {
                        this.f23775d += i - i6;
                    }
                    this.f23778g = new char[this.f23779h.length()];
                    StringBuffer stringBuffer = this.f23779h;
                    stringBuffer.getChars(0, stringBuffer.length(), this.f23778g, 0);
                    String stringBuffer2 = this.f23779h.toString();
                    if (stringBuffer2.length() > CustomAutoTextView.this.f23766b) {
                        stringBuffer2 = stringBuffer2.substring(0, CustomAutoTextView.this.f23766b);
                    }
                    if (this.f23775d > stringBuffer2.length()) {
                        this.f23775d = stringBuffer2.length();
                    } else if (this.f23775d < 0) {
                        this.f23775d = 0;
                    }
                    CustomAutoTextView.this.setText(stringBuffer2);
                    Editable text = CustomAutoTextView.this.getText();
                    Selection.setSelection(text, this.f23775d);
                    if (CustomAutoTextView.this.f23766b == 13 && text.length() == 13) {
                        Selection.setSelection(text, 13);
                    }
                    this.f23774c = false;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f23772a = charSequence.length();
                if (this.f23779h.length() > 0) {
                    StringBuffer stringBuffer = this.f23779h;
                    stringBuffer.delete(0, stringBuffer.length());
                }
                this.f23776e = 0;
                for (int i4 = 0; i4 < charSequence.length(); i4++) {
                    if (charSequence.charAt(i4) == ' ') {
                        this.f23776e++;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.f23773b = charSequence.length();
                this.f23779h.append(charSequence.toString());
                int i4 = this.f23773b;
                if (i4 != this.f23772a && i4 >= CustomAutoTextView.this.f23767c && !this.f23774c) {
                    this.f23774c = true;
                } else {
                    this.f23774c = false;
                }
            }
        });
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.wallet.base.widget.CustomAutoTextView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                GlobalUtils.showInputMethod(CustomAutoTextView.this.f23768d, view);
                int[] iArr = new int[2];
                CustomAutoTextView.this.getLocationInWindow(iArr);
                int paddingLeft = CustomAutoTextView.this.getPaddingLeft();
                int action = motionEvent.getAction();
                Layout layout = CustomAutoTextView.this.getLayout();
                if (action == 0) {
                    int lineForVertical = layout.getLineForVertical(CustomAutoTextView.this.getScrollY() + ((int) motionEvent.getY()));
                    CustomAutoTextView.this.f23769e = layout.getOffsetForHorizontal(lineForVertical, (int) ((motionEvent.getX() - iArr[0]) - paddingLeft));
                    Selection.setSelection(CustomAutoTextView.this.getEditableText(), CustomAutoTextView.this.f23769e);
                } else if (action == 1 || action == 2) {
                    Selection.setSelection(CustomAutoTextView.this.getEditableText(), CustomAutoTextView.this.f23769e, layout.getOffsetForHorizontal(layout.getLineForVertical(CustomAutoTextView.this.getScrollY() + ((int) motionEvent.getY())), (((int) motionEvent.getX()) - iArr[0]) - paddingLeft));
                }
                return false;
            }
        });
    }

    public CustomAutoTextView(Context context) {
        this(context, null);
    }
}
