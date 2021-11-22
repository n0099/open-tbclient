package com.baidu.wallet.base.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class DivisionEditText extends SafeKeyBoardEditText {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int VIEW_TYPE_BANKCARD = 25;
    public static final int VIEW_TYPE_ID = 20;
    public static final int VIEW_TYPE_PHONE = 13;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f58435a;

    /* renamed from: b  reason: collision with root package name */
    public int f58436b;

    /* renamed from: c  reason: collision with root package name */
    public int f58437c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivisionEditText(Context context, AttributeSet attributeSet, int i2) {
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
        this.f58435a = true;
        this.f58436b = 0;
        this.f58437c = 3;
        setUseSafeKeyBoard(false);
    }

    public String getRealText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getText().toString().replace(" ", "").trim() : (String) invokeV.objValue;
    }

    public boolean isFormatEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58435a : invokeV.booleanValue;
    }

    public void setFormatEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f58435a = z;
        }
    }

    public void setViewType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f58436b = i2;
            if (i2 == 13) {
                this.f58437c = 3;
            } else if (i2 == 25) {
                this.f58437c = 4;
            } else if (i2 == 20) {
                this.f58437c = 6;
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DivisionEditText(Context context, AttributeSet attributeSet) {
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
        this.f58435a = true;
        this.f58436b = 0;
        this.f58437c = 3;
        setUseSafeKeyBoard(false);
        addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.base.widget.DivisionEditText.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f58438a;

            /* renamed from: b  reason: collision with root package name */
            public int f58439b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f58440c;

            /* renamed from: d  reason: collision with root package name */
            public int f58441d;

            /* renamed from: e  reason: collision with root package name */
            public int f58442e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ DivisionEditText f58443f;

            /* renamed from: g  reason: collision with root package name */
            public char[] f58444g;

            /* renamed from: h  reason: collision with root package name */
            public StringBuffer f58445h;

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
                this.f58443f = this;
                this.f58438a = 0;
                this.f58439b = 0;
                this.f58440c = false;
                this.f58441d = 0;
                this.f58445h = new StringBuffer();
                this.f58442e = 0;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i4;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) && this.f58440c && this.f58443f.isFormatEnabled()) {
                    this.f58441d = this.f58443f.getSelectionEnd();
                    int i5 = 0;
                    while (i5 < this.f58445h.length()) {
                        if (this.f58445h.charAt(i5) == ' ') {
                            this.f58445h.deleteCharAt(i5);
                        } else {
                            i5++;
                        }
                    }
                    if (this.f58443f.f58436b != 13) {
                        if (this.f58443f.f58436b != 25) {
                            if (this.f58443f.f58436b == 20) {
                                i4 = 0;
                                for (int i6 = 0; i6 < this.f58445h.length(); i6++) {
                                    if (i6 == 6 || i6 == 15) {
                                        this.f58445h.insert(i6, ' ');
                                        i4++;
                                    }
                                }
                            } else {
                                i4 = 0;
                            }
                        } else {
                            i4 = 0;
                            for (int i7 = 0; i7 < this.f58445h.length(); i7++) {
                                if (i7 == 4 || i7 == 9 || i7 == 14 || i7 == 19) {
                                    this.f58445h.insert(i7, ' ');
                                    i4++;
                                }
                            }
                        }
                    } else {
                        i4 = 0;
                        for (int i8 = 0; i8 < this.f58445h.length(); i8++) {
                            if (i8 == 3 || i8 == 8) {
                                this.f58445h.insert(i8, ' ');
                                i4++;
                            }
                        }
                    }
                    int i9 = this.f58442e;
                    if (i4 > i9) {
                        if (i4 - i9 > 1) {
                            this.f58441d += i4 - i9;
                        } else {
                            int i10 = this.f58441d;
                            if (i10 - 1 >= 0 && this.f58445h.charAt(i10 - 1) == ' ') {
                                this.f58441d += i4 - this.f58442e;
                            }
                        }
                    }
                    this.f58444g = new char[this.f58445h.length()];
                    StringBuffer stringBuffer = this.f58445h;
                    stringBuffer.getChars(0, stringBuffer.length(), this.f58444g, 0);
                    String stringBuffer2 = this.f58445h.toString();
                    if (stringBuffer2.length() > this.f58443f.f58436b) {
                        stringBuffer2 = stringBuffer2.substring(0, this.f58443f.f58436b);
                    }
                    this.f58443f.setText(stringBuffer2);
                    Editable text = this.f58443f.getText();
                    if (this.f58441d > text.length()) {
                        this.f58441d = text.length();
                    } else if (this.f58441d < 0) {
                        this.f58441d = 0;
                    }
                    Selection.setSelection(text, this.f58441d);
                    if (this.f58443f.f58436b == 13 && this.f58438a < editable.length()) {
                        if (!this.f58443f.isFormatEnabled() && text.length() == 11) {
                            Selection.setSelection(text, 11);
                        } else if (text.length() == 13) {
                            Selection.setSelection(text, 13);
                        }
                    }
                    this.f58440c = false;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i4, i5, i6) == null) {
                    this.f58438a = charSequence.length();
                    if (this.f58445h.length() > 0) {
                        StringBuffer stringBuffer = this.f58445h;
                        stringBuffer.delete(0, stringBuffer.length());
                    }
                    this.f58442e = 0;
                    for (int i7 = 0; i7 < charSequence.length(); i7++) {
                        if (charSequence.charAt(i7) == ' ') {
                            this.f58442e++;
                        }
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i4, i5, i6) == null) {
                    this.f58439b = charSequence.length();
                    if (this.f58443f.f58436b == 13 && this.f58439b >= 11 && !this.f58443f.isFormatEnabled()) {
                        this.f58443f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
                    }
                    this.f58445h.append(charSequence.toString());
                    int i7 = this.f58439b;
                    if (i7 != this.f58438a && i7 >= this.f58443f.f58437c && !this.f58440c) {
                        this.f58440c = true;
                    } else {
                        this.f58440c = false;
                    }
                }
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DivisionEditText(Context context) {
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
