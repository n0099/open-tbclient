package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.sp7;
import com.baidu.tieba.vp7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
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
    public sp7 i;
    public vp7 j;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            sp7 sp7Var = this.i;
            if (sp7Var != null) {
                sp7Var.r(i);
            }
        }
    }

    public void q1(Boolean bool) {
        sp7 sp7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bool) == null) && (sp7Var = this.i) != null) {
            sp7Var.s(bool.booleanValue());
        }
    }

    public void r1(vp7 vp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vp7Var) == null) {
            this.j = vp7Var;
            sp7 sp7Var = this.i;
            if (sp7Var != null) {
                sp7Var.u(vp7Var);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            this.k = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d058f, viewGroup, false);
            sp7 sp7Var = new sp7(getPageContext(), this.k, this.a, this.b, this.d, this.e, this.f, this.g, this.h, this.c);
            this.i = sp7Var;
            sp7Var.u(this.j);
            return this.k;
        }
        return (View) invokeLLL.objValue;
    }
}
