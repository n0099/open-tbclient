package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.t0.f2.f.b;
import c.a.t0.f2.f.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class MemberPayFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MEMBER_CLICK_ZONE = "member_click_zone";
    public static final String MEMBER_FROM_TYPE = "member_from_type";
    public static final String MEMBER_IS_PAY_DIALOG = "member_is_pay_dialog";
    public static final String MEMBER_REFER_PAGE = "member_refer_page";
    public static final String MEMBER_TYPE = "member_type";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f47703e;

    /* renamed from: f  reason: collision with root package name */
    public String f47704f;

    /* renamed from: g  reason: collision with root package name */
    public String f47705g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47706h;

    /* renamed from: i  reason: collision with root package name */
    public int f47707i;

    /* renamed from: j  reason: collision with root package name */
    public b f47708j;

    /* renamed from: k  reason: collision with root package name */
    public f f47709k;
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
        this.f47709k = null;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f47703e : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            b bVar = this.f47708j;
            if (bVar != null) {
                bVar.p(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            this.f47703e = arguments.getInt("member_type");
            this.f47704f = arguments.getString(MEMBER_REFER_PAGE);
            this.f47705g = arguments.getString(MEMBER_CLICK_ZONE);
            this.f47706h = arguments.getBoolean(MEMBER_IS_PAY_DIALOG);
            this.f47707i = arguments.getInt(MEMBER_FROM_TYPE);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            this.l = layoutInflater.inflate(R.layout.member_pay_fragment_view, viewGroup, false);
            b bVar = new b(getPageContext(), this.l, this.f47703e, this.f47704f, this.f47705g, this.f47706h, this.f47707i);
            this.f47708j = bVar;
            bVar.s(this.f47709k);
            return this.l;
        }
        return (View) invokeLLL.objValue;
    }

    public void refreshAutoPayItemUI(Boolean bool) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bool) == null) || (bVar = this.f47708j) == null) {
            return;
        }
        bVar.q(bool.booleanValue());
    }

    public void setDataAndRefreshUI(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.f47709k = fVar;
            b bVar = this.f47708j;
            if (bVar != null) {
                bVar.s(fVar);
            }
        }
    }
}
