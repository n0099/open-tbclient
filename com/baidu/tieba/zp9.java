package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.payment.PayVcodeActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class zp9 extends BdBaseView<PayVcodeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PayVcodeActivity a;
    public ViewGroup b;
    public View c;
    public ViewGroup d;
    public TextView e;
    public TbWebView f;
    public TextView g;
    public ProgressBar h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zp9(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payVcodeActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.obfuscated_res_0x7f0d07a1);
        C(payVcodeActivity);
    }

    public TbWebView A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (TbWebView) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public TextView x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return (TextView) invokeV.objValue;
    }

    public ViewGroup z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final void C(PayVcodeActivity payVcodeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, payVcodeActivity) == null) {
            this.b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f091b0a);
            TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091b04);
            this.e = textView;
            SkinManager.setBackgroundResource(textView, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0101, 1);
            this.f = (TbWebView) payVcodeActivity.findViewById(R.id.obfuscated_res_0x7f0928fe);
            this.g = (TextView) payVcodeActivity.findViewById(R.id.obfuscated_res_0x7f092a74);
            this.c = payVcodeActivity.findViewById(R.id.obfuscated_res_0x7f091b08);
            this.d = (ViewGroup) payVcodeActivity.findViewById(R.id.obfuscated_res_0x7f091b09);
            this.h = (ProgressBar) payVcodeActivity.findViewById(R.id.obfuscated_res_0x7f091b0b);
            this.f.setHorizontalScrollBarEnabled(false);
            this.f.setScrollBarStyle(33554432);
        }
    }

    public void D(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            TextView textView = this.g;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
        }
    }

    public void E(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            ProgressBar progressBar = this.h;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            progressBar.setVisibility(i);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            wp5.a(this.a.getPageContext(), this.b);
            SkinManager.setBgColor(this.g, i);
            SkinManager.setBackgroundResource(this.e, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0101, 1);
        }
    }
}
