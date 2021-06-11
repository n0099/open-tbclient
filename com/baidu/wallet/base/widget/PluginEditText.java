package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.wallet.base.widget.textfilter.IEditTextPasteFilter;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PluginEditText extends EditText implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public String f23602a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f23603b;

    /* renamed from: c  reason: collision with root package name */
    public List<IEditTextPasteFilter> f23604c;
    public boolean isAlwaysShow;
    public int off;

    public PluginEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23602a = getClass().getSimpleName();
        this.isAlwaysShow = false;
        this.f23603b = true;
        this.f23604c = new ArrayList();
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter == null || parseEditTextPasteFilter.size() <= 0) {
            return;
        }
        this.f23604c.addAll(parseEditTextPasteFilter);
    }

    public void addEditTextPasteFilter(IEditTextPasteFilter iEditTextPasteFilter) {
        if (iEditTextPasteFilter != null) {
            this.f23604c.add(iEditTextPasteFilter);
        }
    }

    public List<IEditTextPasteFilter> getEditTextPasteFilters() {
        return this.f23604c;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (z || this.isAlwaysShow) {
            return;
        }
        GlobalUtils.hideInputMethod(getContext(), this);
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i2) {
        String str;
        if (i2 == 16908322) {
            String applyEditTextPasteFilters = EditTextPasteFilterUtils.applyEditTextPasteFilters(getContext(), this.f23604c);
            try {
                int selectionStart = getSelectionStart();
                int selectionEnd = getSelectionEnd();
                LogUtil.d(this.f23602a, "\tstart:" + selectionStart + "\tend:" + selectionEnd);
                Editable editableText = getEditableText();
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
                LogUtil.d(this.f23602a, e2.getMessage());
                return super.onTextContextMenuItem(i2);
            }
        }
        return super.onTextContextMenuItem(i2);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        Layout layout = getLayout();
        if (action == 0) {
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(getScrollY() + ((int) motionEvent.getY())), (int) motionEvent.getX());
            this.off = offsetForHorizontal;
            if (offsetForHorizontal >= 0 && offsetForHorizontal <= getEditableText().length()) {
                Selection.setSelection(getEditableText(), this.off);
            }
        } else if (action == 1 || action == 2) {
            int offsetForHorizontal2 = layout.getOffsetForHorizontal(layout.getLineForVertical(getScrollY() + ((int) motionEvent.getY())), (int) motionEvent.getX());
            int i2 = this.off;
            if (i2 >= 0 && i2 <= getEditableText().length() && offsetForHorizontal2 >= 0 && offsetForHorizontal2 <= getEditableText().length()) {
                Selection.setSelection(getEditableText(), this.off, offsetForHorizontal2);
            }
        }
        if (this.f23603b) {
            GlobalUtils.showInputMethod(getContext(), view);
        }
        return true;
    }

    public void setMyHint(CharSequence charSequence, String str) {
        SpannableString spannableString = new SpannableString(charSequence.toString());
        spannableString.setSpan(new AbsoluteSizeSpan(getContext().getResources().getDimensionPixelSize(ResUtils.dimen(getContext(), str))), 0, spannableString.length(), 33);
        setHint(new SpannedString(spannableString));
    }

    public void setMyHintTextSize(String str) {
        setMyHint(getHint(), str);
    }

    public void setShowInputMethod(boolean z) {
        this.isAlwaysShow = z;
    }

    public void setShowSystemMethodFlag(boolean z) {
        this.f23603b = z;
    }

    public PluginEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23602a = getClass().getSimpleName();
        this.isAlwaysShow = false;
        this.f23603b = true;
        this.f23604c = new ArrayList();
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter == null || parseEditTextPasteFilter.size() <= 0) {
            return;
        }
        this.f23604c.addAll(parseEditTextPasteFilter);
    }

    public PluginEditText(Context context) {
        this(context, null);
    }
}
