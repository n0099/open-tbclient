package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.v1.f.b;
import d.a.q0.v1.f.f;
/* loaded from: classes4.dex */
public class MemberPayFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f18691e;

    /* renamed from: f  reason: collision with root package name */
    public String f18692f;

    /* renamed from: g  reason: collision with root package name */
    public String f18693g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18694h;

    /* renamed from: i  reason: collision with root package name */
    public int f18695i;
    public b j;
    public f k;
    public View l;

    public MemberPayFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
    }

    public int M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f18691e : invokeV.intValue;
    }

    public void N0(Boolean bool) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) || (bVar = this.j) == null) {
            return;
        }
        bVar.q(bool.booleanValue());
    }

    public void O0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.k = fVar;
            b bVar = this.j;
            if (bVar != null) {
                bVar.s(fVar);
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
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            b bVar = this.j;
            if (bVar != null) {
                bVar.p(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            this.f18691e = arguments.getInt("member_type");
            this.f18692f = arguments.getString("member_refer_page");
            this.f18693g = arguments.getString("member_click_zone");
            this.f18694h = arguments.getBoolean("member_is_pay_dialog");
            this.f18695i = arguments.getInt("member_from_type");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            this.l = layoutInflater.inflate(R.layout.member_pay_fragment_view, viewGroup, false);
            b bVar = new b(getPageContext(), this.l, this.f18691e, this.f18692f, this.f18693g, this.f18694h, this.f18695i);
            this.j = bVar;
            bVar.s(this.k);
            return this.l;
        }
        return (View) invokeLLL.objValue;
    }
}
