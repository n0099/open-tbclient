package com.baidu.tieba.memberCenter.memberpay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.r0.x1.f.b;
import c.a.r0.x1.f.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class MemberPayFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MEMBER_CLICK_ZONE = "member_click_zone";
    public static final String MEMBER_FROM_TYPE = "member_from_type";
    public static final String MEMBER_IS_PAY_DIALOG = "member_is_pay_dialog";
    public static final String MEMBER_REFER_PAGE = "member_refer_page";
    public static final String MEMBER_TYPE = "member_type";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f54321e;

    /* renamed from: f  reason: collision with root package name */
    public String f54322f;

    /* renamed from: g  reason: collision with root package name */
    public String f54323g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54324h;

    /* renamed from: i  reason: collision with root package name */
    public int f54325i;

    /* renamed from: j  reason: collision with root package name */
    public b f54326j;
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

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54321e : invokeV.intValue;
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
            b bVar = this.f54326j;
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
            this.f54321e = arguments.getInt("member_type");
            this.f54322f = arguments.getString(MEMBER_REFER_PAGE);
            this.f54323g = arguments.getString(MEMBER_CLICK_ZONE);
            this.f54324h = arguments.getBoolean(MEMBER_IS_PAY_DIALOG);
            this.f54325i = arguments.getInt(MEMBER_FROM_TYPE);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            this.l = layoutInflater.inflate(R.layout.member_pay_fragment_view, viewGroup, false);
            b bVar = new b(getPageContext(), this.l, this.f54321e, this.f54322f, this.f54323g, this.f54324h, this.f54325i);
            this.f54326j = bVar;
            bVar.s(this.k);
            return this.l;
        }
        return (View) invokeLLL.objValue;
    }

    public void refreshAutoPayItemUI(Boolean bool) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bool) == null) || (bVar = this.f54326j) == null) {
            return;
        }
        bVar.q(bool.booleanValue());
    }

    public void setDataAndRefreshUI(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.k = fVar;
            b bVar = this.f54326j;
            if (bVar != null) {
                bVar.s(fVar);
            }
        }
    }
}
