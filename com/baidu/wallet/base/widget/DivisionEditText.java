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
/* loaded from: classes8.dex */
public class DivisionEditText extends SafeKeyBoardEditText {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int VIEW_TYPE_BANKCARD = 25;
    public static final int VIEW_TYPE_ID = 20;
    public static final int VIEW_TYPE_PHONE = 13;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f60446a;

    /* renamed from: b  reason: collision with root package name */
    public int f60447b;

    /* renamed from: c  reason: collision with root package name */
    public int f60448c;

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
        this.f60446a = true;
        this.f60447b = 0;
        this.f60448c = 3;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60446a : invokeV.booleanValue;
    }

    public void setFormatEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f60446a = z;
        }
    }

    public void setViewType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f60447b = i2;
            if (i2 == 13) {
                this.f60448c = 3;
            } else if (i2 == 25) {
                this.f60448c = 4;
            } else if (i2 == 20) {
                this.f60448c = 6;
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
        this.f60446a = true;
        this.f60447b = 0;
        this.f60448c = 3;
        setUseSafeKeyBoard(false);
        addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.base.widget.DivisionEditText.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public int f60449a;

            /* renamed from: b  reason: collision with root package name */
            public int f60450b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f60451c;

            /* renamed from: d  reason: collision with root package name */
            public int f60452d;

            /* renamed from: e  reason: collision with root package name */
            public int f60453e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ DivisionEditText f60454f;

            /* renamed from: g  reason: collision with root package name */
            public char[] f60455g;

            /* renamed from: h  reason: collision with root package name */
            public StringBuffer f60456h;

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
                this.f60454f = this;
                this.f60449a = 0;
                this.f60450b = 0;
                this.f60451c = false;
                this.f60452d = 0;
                this.f60456h = new StringBuffer();
                this.f60453e = 0;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int i4;
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) && this.f60451c && this.f60454f.isFormatEnabled()) {
                    this.f60452d = this.f60454f.getSelectionEnd();
                    int i5 = 0;
                    while (i5 < this.f60456h.length()) {
                        if (this.f60456h.charAt(i5) == ' ') {
                            this.f60456h.deleteCharAt(i5);
                        } else {
                            i5++;
                        }
                    }
                    if (this.f60454f.f60447b != 13) {
                        if (this.f60454f.f60447b != 25) {
                            if (this.f60454f.f60447b == 20) {
                                i4 = 0;
                                for (int i6 = 0; i6 < this.f60456h.length(); i6++) {
                                    if (i6 == 6 || i6 == 15) {
                                        this.f60456h.insert(i6, ' ');
                                        i4++;
                                    }
                                }
                            } else {
                                i4 = 0;
                            }
                        } else {
                            i4 = 0;
                            for (int i7 = 0; i7 < this.f60456h.length(); i7++) {
                                if (i7 == 4 || i7 == 9 || i7 == 14 || i7 == 19) {
                                    this.f60456h.insert(i7, ' ');
                                    i4++;
                                }
                            }
                        }
                    } else {
                        i4 = 0;
                        for (int i8 = 0; i8 < this.f60456h.length(); i8++) {
                            if (i8 == 3 || i8 == 8) {
                                this.f60456h.insert(i8, ' ');
                                i4++;
                            }
                        }
                    }
                    int i9 = this.f60453e;
                    if (i4 > i9) {
                        if (i4 - i9 > 1) {
                            this.f60452d += i4 - i9;
                        } else {
                            int i10 = this.f60452d;
                            if (i10 - 1 >= 0 && this.f60456h.charAt(i10 - 1) == ' ') {
                                this.f60452d += i4 - this.f60453e;
                            }
                        }
                    }
                    this.f60455g = new char[this.f60456h.length()];
                    StringBuffer stringBuffer = this.f60456h;
                    stringBuffer.getChars(0, stringBuffer.length(), this.f60455g, 0);
                    String stringBuffer2 = this.f60456h.toString();
                    if (stringBuffer2.length() > this.f60454f.f60447b) {
                        stringBuffer2 = stringBuffer2.substring(0, this.f60454f.f60447b);
                    }
                    this.f60454f.setText(stringBuffer2);
                    Editable text = this.f60454f.getText();
                    if (this.f60452d > text.length()) {
                        this.f60452d = text.length();
                    } else if (this.f60452d < 0) {
                        this.f60452d = 0;
                    }
                    Selection.setSelection(text, this.f60452d);
                    if (this.f60454f.f60447b == 13 && this.f60449a < editable.length()) {
                        if (!this.f60454f.isFormatEnabled() && text.length() == 11) {
                            Selection.setSelection(text, 11);
                        } else if (text.length() == 13) {
                            Selection.setSelection(text, 13);
                        }
                    }
                    this.f60451c = false;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i4, i5, i6) == null) {
                    this.f60449a = charSequence.length();
                    if (this.f60456h.length() > 0) {
                        StringBuffer stringBuffer = this.f60456h;
                        stringBuffer.delete(0, stringBuffer.length());
                    }
                    this.f60453e = 0;
                    for (int i7 = 0; i7 < charSequence.length(); i7++) {
                        if (charSequence.charAt(i7) == ' ') {
                            this.f60453e++;
                        }
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i4, i5, i6) == null) {
                    this.f60450b = charSequence.length();
                    if (this.f60454f.f60447b == 13 && this.f60450b >= 11 && !this.f60454f.isFormatEnabled()) {
                        this.f60454f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
                    }
                    this.f60456h.append(charSequence.toString());
                    int i7 = this.f60450b;
                    if (i7 != this.f60449a && i7 >= this.f60454f.f60448c && !this.f60451c) {
                        this.f60451c = true;
                    } else {
                        this.f60451c = false;
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
