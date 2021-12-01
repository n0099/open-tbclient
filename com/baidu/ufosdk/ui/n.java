package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public final class n implements TextWatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ FeedbackEditActivity a;

    /* renamed from: b  reason: collision with root package name */
    public long f51749b;

    public n(FeedbackEditActivity feedbackEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackEditActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = feedbackEditActivity;
        this.f51749b = 0L;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean z;
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        EditText editText5;
        String str;
        EditText editText6;
        EditText editText7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            z = this.a.x;
            if (!z) {
                com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.a);
                dVar.b(dVar.b() + 1);
                this.a.x = true;
            }
            try {
                editText = this.a.n;
                if (editText != null) {
                    editText4 = this.a.n;
                    if (editText4.getText().toString().length() > 30) {
                        if (System.currentTimeMillis() - this.f51749b > 3000) {
                            Toast.makeText(this.a, com.baidu.ufosdk.f.s.a("32"), 0).show();
                            this.f51749b = System.currentTimeMillis();
                        }
                        editText5 = this.a.n;
                        str = this.a.R;
                        editText5.setText(str);
                        editText6 = this.a.m;
                        editText7 = this.a.n;
                        FeedbackEditActivity.b(editText6, editText7.getText().length());
                    }
                }
                editText2 = this.a.n;
                if (editText2 != null) {
                    FeedbackEditActivity feedbackEditActivity = this.a;
                    editText3 = this.a.n;
                    feedbackEditActivity.R = editText3.getText().toString().trim();
                }
            } catch (Exception e2) {
                com.baidu.ufosdk.f.c.a("联系方式输入有误", e2);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
        }
    }
}
