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
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
/* loaded from: classes8.dex */
public final class n implements TextWatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f60088a;

    /* renamed from: b  reason: collision with root package name */
    public long f60089b;

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
        this.f60088a = feedbackEditActivity;
        this.f60089b = 0L;
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
            z = this.f60088a.x;
            if (!z) {
                com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f60088a);
                dVar.b(dVar.b() + 1);
                this.f60088a.x = true;
            }
            try {
                editText = this.f60088a.n;
                if (editText != null) {
                    editText4 = this.f60088a.n;
                    if (editText4.getText().toString().length() > 30) {
                        if (System.currentTimeMillis() - this.f60089b > 3000) {
                            Toast.makeText(this.f60088a, com.baidu.ufosdk.f.s.a(EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS), 0).show();
                            this.f60089b = System.currentTimeMillis();
                        }
                        editText5 = this.f60088a.n;
                        str = this.f60088a.R;
                        editText5.setText(str);
                        editText6 = this.f60088a.m;
                        editText7 = this.f60088a.n;
                        FeedbackEditActivity.b(editText6, editText7.getText().length());
                    }
                }
                editText2 = this.f60088a.n;
                if (editText2 != null) {
                    FeedbackEditActivity feedbackEditActivity = this.f60088a;
                    editText3 = this.f60088a.n;
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
