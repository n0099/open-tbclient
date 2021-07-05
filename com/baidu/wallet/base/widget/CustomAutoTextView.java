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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.GlobalUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.wallet.base.widget.textfilter.IEditTextPasteFilter;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class CustomAutoTextView extends AutoCompleteTextView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int VIEW_TYPE_BANKCARD = 24;
    public static final int VIEW_TYPE_PHONE = 13;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f24087a;

    /* renamed from: b  reason: collision with root package name */
    public int f24088b;

    /* renamed from: c  reason: collision with root package name */
    public int f24089c;

    /* renamed from: d  reason: collision with root package name */
    public Context f24090d;

    /* renamed from: e  reason: collision with root package name */
    public int f24091e;

    /* renamed from: f  reason: collision with root package name */
    public List<IEditTextPasteFilter> f24092f;

    /* renamed from: g  reason: collision with root package name */
    public ShowDropDownListener f24093g;

    /* loaded from: classes6.dex */
    public interface ShowDropDownListener {
        void showDisplayTranslucent();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomAutoTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f24087a = CustomAutoTextView.class.getSimpleName();
        this.f24088b = 13;
        this.f24089c = 3;
        this.f24090d = null;
        this.f24092f = new ArrayList();
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter == null || parseEditTextPasteFilter.size() <= 0) {
            return;
        }
        this.f24092f.addAll(parseEditTextPasteFilter);
    }

    public void addEditTextPasteFilter(IEditTextPasteFilter iEditTextPasteFilter) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, iEditTextPasteFilter) == null) || iEditTextPasteFilter == null) {
            return;
        }
        this.f24092f.add(iEditTextPasteFilter);
    }

    @Override // android.widget.AutoCompleteTextView
    public boolean enoughToFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), rect}) == null) {
            super.onFocusChanged(z, i2, rect);
            if (z) {
                if (getAdapter() == null) {
                    return;
                }
                performFiltering(getText(), 0);
                return;
            }
            GlobalUtils.hideInputMethod(this.f24090d, this);
        }
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i2) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 == 16908322) {
                String applyEditTextPasteFilters = EditTextPasteFilterUtils.applyEditTextPasteFilters(getContext(), this.f24092f);
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
                    LogUtil.d(this.f24087a, e2.getMessage());
                    return super.onTextContextMenuItem(i2);
                }
            }
            return super.onTextContextMenuItem(i2);
        }
        return invokeI.booleanValue;
    }

    public void setShowDropDownListener(ShowDropDownListener showDropDownListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, showDropDownListener) == null) {
            this.f24093g = showDropDownListener;
        }
    }

    public void setViewType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f24088b = i2;
            this.f24089c = i2 == 13 ? 3 : 4;
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || getText().length() == 13 || getAdapter() == null || getAdapter().getCount() == 0) {
            return;
        }
        ShowDropDownListener showDropDownListener = this.f24093g;
        if (showDropDownListener != null) {
            showDropDownListener.showDisplayTranslucent();
        }
        super.showDropDown();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomAutoTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f24087a = CustomAutoTextView.class.getSimpleName();
        this.f24088b = 13;
        this.f24089c = 3;
        this.f24090d = null;
        this.f24092f = new ArrayList();
        this.f24090d = context;
        List<IEditTextPasteFilter> parseEditTextPasteFilter = EditTextPasteFilterUtils.parseEditTextPasteFilter(attributeSet);
        if (parseEditTextPasteFilter != null && parseEditTextPasteFilter.size() > 0) {
            this.f24092f.addAll(parseEditTextPasteFilter);
        }
        addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.base.widget.CustomAutoTextView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f24094a;

            /* renamed from: b  reason: collision with root package name */
            public int f24095b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f24096c;

            /* renamed from: d  reason: collision with root package name */
            public int f24097d;

            /* renamed from: e  reason: collision with root package name */
            public int f24098e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ CustomAutoTextView f24099f;

            /* renamed from: g  reason: collision with root package name */
            public char[] f24100g;

            /* renamed from: h  reason: collision with root package name */
            public StringBuffer f24101h;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f24099f = this;
                this.f24094a = 0;
                this.f24095b = 0;
                this.f24096c = false;
                this.f24097d = 0;
                this.f24101h = new StringBuffer();
                this.f24098e = 0;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i4;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) && this.f24096c) {
                    this.f24097d = this.f24099f.getSelectionEnd();
                    int i5 = this.f24099f.f24088b == 13 ? 3 : 100;
                    int i6 = 0;
                    loop0: while (true) {
                        boolean z = true;
                        while (i6 < this.f24101h.length()) {
                            if (i6 == i5 && this.f24101h.charAt(i6) != ' ' && this.f24095b == this.f24094a - 1 && z) {
                                i6--;
                                this.f24101h.deleteCharAt(i6);
                                this.f24097d--;
                                z = false;
                            }
                            if (this.f24101h.charAt(i6) == ' ') {
                                break;
                            }
                            i6++;
                        }
                        this.f24101h.deleteCharAt(i6);
                        i5 = i6 + 4;
                    }
                    if (this.f24099f.f24088b != 13) {
                        if (this.f24099f.f24088b == 24) {
                            i4 = 0;
                            for (int i7 = 0; i7 < this.f24101h.length(); i7++) {
                                if (i7 == 4 || i7 == 9 || i7 == 14 || i7 == 19) {
                                    this.f24101h.insert(i7, ' ');
                                    i4++;
                                }
                            }
                        } else {
                            i4 = 0;
                        }
                    } else {
                        i4 = 0;
                        for (int i8 = 0; i8 < this.f24101h.length(); i8++) {
                            if (i8 == 3 || i8 == 8) {
                                this.f24101h.insert(i8, ' ');
                                i4++;
                            }
                        }
                    }
                    int i9 = this.f24098e;
                    if (i4 > i9) {
                        this.f24097d += i4 - i9;
                    }
                    this.f24100g = new char[this.f24101h.length()];
                    StringBuffer stringBuffer = this.f24101h;
                    stringBuffer.getChars(0, stringBuffer.length(), this.f24100g, 0);
                    String stringBuffer2 = this.f24101h.toString();
                    if (stringBuffer2.length() > this.f24099f.f24088b) {
                        stringBuffer2 = stringBuffer2.substring(0, this.f24099f.f24088b);
                    }
                    if (this.f24097d > stringBuffer2.length()) {
                        this.f24097d = stringBuffer2.length();
                    } else if (this.f24097d < 0) {
                        this.f24097d = 0;
                    }
                    this.f24099f.setText(stringBuffer2);
                    Editable text = this.f24099f.getText();
                    Selection.setSelection(text, this.f24097d);
                    if (this.f24099f.f24088b == 13 && text.length() == 13) {
                        Selection.setSelection(text, 13);
                    }
                    this.f24096c = false;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i4, i5, i6) == null) {
                    this.f24094a = charSequence.length();
                    if (this.f24101h.length() > 0) {
                        StringBuffer stringBuffer = this.f24101h;
                        stringBuffer.delete(0, stringBuffer.length());
                    }
                    this.f24098e = 0;
                    for (int i7 = 0; i7 < charSequence.length(); i7++) {
                        if (charSequence.charAt(i7) == ' ') {
                            this.f24098e++;
                        }
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i4, i5, i6) == null) {
                    this.f24095b = charSequence.length();
                    this.f24101h.append(charSequence.toString());
                    int i7 = this.f24095b;
                    if (i7 != this.f24094a && i7 >= this.f24099f.f24089c && !this.f24096c) {
                        this.f24096c = true;
                    } else {
                        this.f24096c = false;
                    }
                }
            }
        });
        setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.wallet.base.widget.CustomAutoTextView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CustomAutoTextView f24102a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f24102a = this;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                    GlobalUtils.showInputMethod(this.f24102a.f24090d, view);
                    int[] iArr = new int[2];
                    this.f24102a.getLocationInWindow(iArr);
                    int paddingLeft = this.f24102a.getPaddingLeft();
                    int action = motionEvent.getAction();
                    Layout layout = this.f24102a.getLayout();
                    if (action == 0) {
                        this.f24102a.f24091e = layout.getOffsetForHorizontal(layout.getLineForVertical(this.f24102a.getScrollY() + ((int) motionEvent.getY())), (int) ((motionEvent.getX() - iArr[0]) - paddingLeft));
                        Selection.setSelection(this.f24102a.getEditableText(), this.f24102a.f24091e);
                    } else if (action == 1 || action == 2) {
                        Selection.setSelection(this.f24102a.getEditableText(), this.f24102a.f24091e, layout.getOffsetForHorizontal(layout.getLineForVertical(this.f24102a.getScrollY() + ((int) motionEvent.getY())), (((int) motionEvent.getX()) - iArr[0]) - paddingLeft));
                    }
                    return false;
                }
                return invokeLL.booleanValue;
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomAutoTextView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }
}
