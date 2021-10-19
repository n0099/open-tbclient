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
public final class ef implements TextWatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f60040a;

    public ef(FeedbackReportActivity feedbackReportActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackReportActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60040a = feedbackReportActivity;
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
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            z = this.f60040a.E;
            if (!z) {
                com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f60040a);
                dVar.b(dVar.b() + 1);
                this.f60040a.E = true;
            }
            editText = this.f60040a.u;
            if (editText != null) {
                editText4 = this.f60040a.u;
                if (editText4.getText().toString().trim().length() > 30) {
                    editText5 = this.f60040a.u;
                    str = this.f60040a.M;
                    editText5.setText(str);
                    Toast.makeText(this.f60040a, com.baidu.ufosdk.f.s.a(EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS), 1).show();
                    editText6 = this.f60040a.u;
                    str2 = this.f60040a.M;
                    editText6.setSelection(str2.length());
                }
            }
            editText2 = this.f60040a.u;
            if (editText2 != null) {
                FeedbackReportActivity feedbackReportActivity = this.f60040a;
                editText3 = feedbackReportActivity.u;
                feedbackReportActivity.M = editText3.getText().toString();
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
