package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class bt implements TextWatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f59380a;

    public bt(FeedbackInputActivity feedbackInputActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackInputActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59380a = feedbackInputActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            z = this.f59380a.au;
            if (!z) {
                com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f59380a);
                dVar.b(dVar.b() + 1);
                this.f59380a.au = true;
            }
            FeedbackInputActivity feedbackInputActivity = this.f59380a;
            int i2 = feedbackInputActivity.I;
            if (i2 != 0) {
                if (i2 == 1 && feedbackInputActivity.E.getText().toString().trim().length() <= 0) {
                    this.f59380a.J.setTextColor(com.baidu.ufosdk.b.y);
                }
            } else if (feedbackInputActivity.E.getText().toString().trim().length() > 0) {
                TextView textView = this.f59380a.J;
                int i3 = com.baidu.ufosdk.b.v;
                int i4 = com.baidu.ufosdk.b.y;
                int i5 = com.baidu.ufosdk.b.v;
                textView.setTextColor(com.baidu.ufosdk.f.i.a(i3, i4, i5, i5));
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        FeedbackInputActivity feedbackInputActivity;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            if (this.f59380a.E.getText().toString().trim().length() <= 0) {
                feedbackInputActivity = this.f59380a;
                i5 = 0;
            } else {
                feedbackInputActivity = this.f59380a;
                i5 = 1;
            }
            feedbackInputActivity.I = i5;
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
        }
    }
}
