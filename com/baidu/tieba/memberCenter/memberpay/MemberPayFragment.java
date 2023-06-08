package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.uv8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class MemberPayFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public int f;
    public int g;
    public String h;
    public uv8 i;
    public MemberPayResult j;
    public View k;

    public MemberPayFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public void H1(Boolean bool) {
        uv8 uv8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bool) == null) && (uv8Var = this.i) != null) {
            uv8Var.v(bool.booleanValue());
        }
    }

    public void I1(MemberPayResult memberPayResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, memberPayResult) == null) {
            this.j = memberPayResult;
            uv8 uv8Var = this.i;
            if (uv8Var != null) {
                uv8Var.x(memberPayResult);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.onChangeSkinType(i);
            uv8 uv8Var = this.i;
            if (uv8Var != null) {
                uv8Var.u(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.a = arguments.getInt(MemberPayActivityConfig.MEMBER_TYPE);
                this.b = arguments.getString("member_refer_page");
                this.d = arguments.getString("member_click_zone");
                this.e = arguments.getBoolean("member_is_pay_dialog");
                this.f = arguments.getInt("member_from_type");
                this.g = arguments.getInt("member_from_scene");
                this.h = arguments.getString("member_fid");
                this.c = arguments.getString("member_pay_show_price");
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            this.k = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d05f6, viewGroup, false);
            uv8 uv8Var = new uv8(getPageContext(), this.k, this.a, this.b, this.d, this.e, this.f, this.g, this.h, this.c);
            this.i = uv8Var;
            uv8Var.x(this.j);
            return this.k;
        }
        return (View) invokeLLL.objValue;
    }
}
