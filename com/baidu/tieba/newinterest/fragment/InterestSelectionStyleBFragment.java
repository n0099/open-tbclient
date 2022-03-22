package com.baidu.tieba.newinterest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.s2.a.a;
import c.a.p0.s2.a.d;
import c.a.p0.s2.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NoScrollGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class InterestSelectionStyleBFragment extends BaseInterestSelectionFragment implements a.InterfaceC1374a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public View f34768g;

    /* renamed from: h  reason: collision with root package name */
    public View f34769h;
    public LinearLayout i;
    public TextView j;
    public TextView k;
    public NoScrollGridView l;
    public c m;

    public InterestSelectionStyleBFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static InterestSelectionStyleBFragment G0(int i, String[] strArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, strArr)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("scene", i);
            bundle.putStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE, strArr);
            InterestSelectionStyleBFragment interestSelectionStyleBFragment = new InterestSelectionStyleBFragment();
            interestSelectionStyleBFragment.setArguments(bundle);
            return interestSelectionStyleBFragment;
        }
        return (InterestSelectionStyleBFragment) invokeIL.objValue;
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f34768g = this.f34757d.findViewById(R.id.obfuscated_res_0x7f090f1e);
            this.f34769h = this.f34757d.findViewById(R.id.obfuscated_res_0x7f090f20);
            this.i = (LinearLayout) this.f34757d.findViewById(R.id.obfuscated_res_0x7f090f1f);
            this.l = (NoScrollGridView) this.f34757d.findViewById(R.id.obfuscated_res_0x7f090f22);
            this.f34755b = (TBSpecificationBtn) this.f34757d.findViewById(R.id.obfuscated_res_0x7f090f1d);
            this.j = (TextView) this.f34757d.findViewById(R.id.obfuscated_res_0x7f090f26);
            this.k = (TextView) this.f34757d.findViewById(R.id.obfuscated_res_0x7f090f21);
            String[] strArr = this.f34759f;
            if (strArr != null && strArr.length == 3) {
                this.j.setText(strArr[0]);
                this.k.setText(this.f34759f[1]);
            }
            c.a.o0.r.l0.n.a aVar = new c.a.o0.r.l0.n.a();
            this.f34755b.setTextSize(R.dimen.T_X06);
            this.f34755b.setConfig(aVar);
            this.f34755b.setText(getResources().getString(R.string.obfuscated_res_0x7f0f10c8));
            this.f34755b.setEnabled(false);
            this.f34755b.setOnClickListener(this);
            int k = n.k(getContext());
            int f2 = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            int f3 = n.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
            this.l.setColumnWidth((k / 4) + f2);
            this.l.setVerticalSpacing(f3);
            this.l.setAdapter((ListAdapter) this.f34756c);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            c.a.o0.r.v.c.d(this.f34757d).f(R.color.CAM_X0206);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.j);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X03);
            d2.A(R.string.F_X02);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.k);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X07);
            d3.A(R.string.F_X01);
            c.a.o0.r.v.c.d(this.i).f(R.color.CAM_X0206);
            c.a.o0.r.v.c.d(this.f34768g).o(new int[]{R.color.CAM_X0206, R.color.CAM_X0612});
            c.a.o0.r.v.c.d(this.f34769h).o(new int[]{R.color.CAM_X0612, R.color.CAM_X0206});
            this.f34756c.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            d dVar = new d(null, getContext());
            this.f34756c = dVar;
            this.m = new c(this, dVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f34757d = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d02e3, viewGroup, false);
            if (getArguments() != null) {
                this.f34758e = getArguments().getInt("scene");
                this.f34759f = getArguments().getStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE);
            }
            H0();
            showLoadingView(this.f34757d);
            C0();
            return this.f34757d;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            this.m.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            hideNetRefreshView(this.f34757d);
            this.m.c();
            showLoadingView(this.f34757d);
        }
    }
}
