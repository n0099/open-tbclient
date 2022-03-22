package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.p0.j2.f.b;
import c.a.p0.j2.f.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
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

    /* renamed from: b  reason: collision with root package name */
    public String f34496b;

    /* renamed from: c  reason: collision with root package name */
    public String f34497c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34498d;

    /* renamed from: e  reason: collision with root package name */
    public int f34499e;

    /* renamed from: f  reason: collision with root package name */
    public b f34500f;

    /* renamed from: g  reason: collision with root package name */
    public f f34501g;

    /* renamed from: h  reason: collision with root package name */
    public View f34502h;

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
        this.f34501g = null;
    }

    public void C0(Boolean bool) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bool) == null) || (bVar = this.f34500f) == null) {
            return;
        }
        bVar.q(bool.booleanValue());
    }

    public void D0(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            this.f34501g = fVar;
            b bVar = this.f34500f;
            if (bVar != null) {
                bVar.s(fVar);
            }
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : invokeV.intValue;
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
            b bVar = this.f34500f;
            if (bVar != null) {
                bVar.p(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            this.a = arguments.getInt("member_type");
            this.f34496b = arguments.getString("member_refer_page");
            this.f34497c = arguments.getString("member_click_zone");
            this.f34498d = arguments.getBoolean("member_is_pay_dialog");
            this.f34499e = arguments.getInt("member_from_type");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f34502h = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0544, viewGroup, false);
            b bVar = new b(getPageContext(), this.f34502h, this.a, this.f34496b, this.f34497c, this.f34498d, this.f34499e);
            this.f34500f = bVar;
            bVar.s(this.f34501g);
            return this.f34502h;
        }
        return (View) invokeLLL.objValue;
    }
}
