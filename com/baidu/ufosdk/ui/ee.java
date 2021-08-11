package com.baidu.ufosdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class ee implements TextWatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f59492a;

    /* renamed from: b  reason: collision with root package name */
    public int f59493b;

    public ee(FeedbackReportActivity feedbackReportActivity) {
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
        this.f59492a = feedbackReportActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean z;
        EditText editText;
        TextView textView;
        TextView textView2;
        a aVar;
        Button button;
        Button button2;
        a aVar2;
        Button button3;
        Button button4;
        TextView textView3;
        TextView textView4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            z = this.f59492a.E;
            if (!z) {
                com.baidu.ufosdk.f.d dVar = new com.baidu.ufosdk.f.d(this.f59492a);
                dVar.b(dVar.b() + 1);
                this.f59492a.E = true;
            }
            editText = this.f59492a.t;
            int length = editText.getText().toString().trim().length();
            if (editable.length() <= 4) {
                textView4 = this.f59492a.v;
                textView4.setText("4-" + com.baidu.ufosdk.b.aa + "字");
            } else {
                textView = this.f59492a.v;
                textView.setText(String.valueOf(editable.length()) + "-" + com.baidu.ufosdk.b.aa + "字");
            }
            if (length > com.baidu.ufosdk.b.aa) {
                textView3 = this.f59492a.v;
                textView3.setTextColor(-568497);
                this.f59492a.H = true;
            } else {
                textView2 = this.f59492a.v;
                textView2.setTextColor(-5131855);
                this.f59492a.H = false;
            }
            int i2 = this.f59493b;
            if (i2 == 0) {
                aVar = this.f59492a.U;
                if (aVar.c().size() <= 0) {
                    button = this.f59492a.m;
                    button.setTextColor(com.baidu.ufosdk.b.y);
                    return;
                }
                button2 = this.f59492a.m;
                int i3 = com.baidu.ufosdk.b.v;
                int i4 = com.baidu.ufosdk.b.y;
                int i5 = com.baidu.ufosdk.b.v;
                button2.setTextColor(com.baidu.ufosdk.f.i.a(i3, i4, i5, i5));
            } else if (i2 != 1) {
            } else {
                aVar2 = this.f59492a.U;
                if (aVar2.c().size() <= 0) {
                    button3 = this.f59492a.m;
                    button3.setTextColor(com.baidu.ufosdk.b.y);
                    return;
                }
                button4 = this.f59492a.m;
                int i6 = com.baidu.ufosdk.b.v;
                int i7 = com.baidu.ufosdk.b.y;
                int i8 = com.baidu.ufosdk.b.v;
                button4.setTextColor(com.baidu.ufosdk.f.i.a(i6, i7, i8, i8));
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            editText = this.f59492a.t;
            this.f59493b = editText.getText().toString().trim().length() < 4 ? 0 : 1;
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
        }
    }
}
