package com.baidu.ufosdk;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
/* loaded from: classes8.dex */
public class p0 implements TextWatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final /* synthetic */ FeedbackEditActivity b;

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
        }
    }

    public p0(FeedbackEditActivity feedbackEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackEditActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = feedbackEditActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            int length = this.b.l.getText().toString().trim().length();
            if (editable.length() <= 8) {
                TextView textView = this.b.n;
                textView.setText("8-200字");
            } else {
                TextView textView2 = this.b.n;
                textView2.setText(String.valueOf(editable.length()) + "-200字");
            }
            if (length > 200) {
                this.b.n.setTextColor(-568497);
            } else {
                this.b.n.setTextColor(-5131855);
            }
            int i = this.a;
            if (i != 0) {
                if (i == 1 && this.b.l.getText().toString().trim().length() < 8) {
                    this.b.i.setAlpha(0.3f);
                }
            } else if (this.b.l.getText().toString().trim().length() >= 8) {
                this.b.i.setAlpha(1.0f);
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            if (this.b.l.getText().toString().trim().length() < 8) {
                this.a = 0;
            } else {
                this.a = 1;
            }
        }
    }
}
