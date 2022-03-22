package com.baidu.tieba.newinterest.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import c.a.d.f.p.n;
import c.a.o0.r.l0.n.a;
import c.a.o0.r.l0.n.c;
import c.a.p0.s2.b.b;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.model.InterestedForumModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class InterestedForumStyleAFragment extends BaseInterestedForumFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f34773f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f34774g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f34775h;
    public TextView i;
    public TBSpecificationBtn j;
    public View k;
    public LinearLayout l;
    public View m;
    public b n;

    public InterestedForumStyleAFragment() {
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

    public static InterestedForumStyleAFragment H0(int i, boolean z, String[] strArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), strArr})) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("scene", i);
            bundle.putBoolean(InterestGuideActivityConfig.KEY_ONLY_SHOW_INTERESTED_FORUM, z);
            bundle.putStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE, strArr);
            InterestedForumStyleAFragment interestedForumStyleAFragment = new InterestedForumStyleAFragment();
            interestedForumStyleAFragment.setArguments(bundle);
            return interestedForumStyleAFragment;
        }
        return (InterestedForumStyleAFragment) invokeCommon.objValue;
    }

    public static InterestedForumStyleAFragment I0(int i, String[] strArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, strArr)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("scene", i);
            bundle.putStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE, strArr);
            InterestedForumStyleAFragment interestedForumStyleAFragment = new InterestedForumStyleAFragment();
            interestedForumStyleAFragment.setArguments(bundle);
            return interestedForumStyleAFragment;
        }
        return (InterestedForumStyleAFragment) invokeIL.objValue;
    }

    public final int G0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            Context context = getContext();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            return n.f(context, i);
        }
        return invokeI.intValue;
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.i = (TextView) this.f34763e.findViewById(R.id.obfuscated_res_0x7f090f28);
            TextView textView = (TextView) this.f34763e.findViewById(R.id.obfuscated_res_0x7f090f37);
            this.f34775h = textView;
            String[] strArr = this.f34761c;
            if (strArr != null && strArr.length == 3) {
                textView.setText(strArr[0]);
                this.i.setText(this.f34761c[2]);
            }
            a aVar = new a();
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f34763e.findViewById(R.id.obfuscated_res_0x7f090f13);
            this.j = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.T_X06);
            this.j.setConfig(aVar);
            this.j.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0919));
            this.j.setEnabled(false);
            c cVar = new c();
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.f34763e.findViewById(R.id.obfuscated_res_0x7f091c6b);
            this.f34774g = tBSpecificationBtn2;
            tBSpecificationBtn2.setTextSize(R.dimen.T_X06);
            cVar.r(R.color.CAM_X0105);
            this.f34774g.setConfig(cVar);
            this.f34774g.setText(getString(R.string.obfuscated_res_0x7f0f0921));
            this.k = this.f34763e.findViewById(R.id.obfuscated_res_0x7f090f14);
            this.l = (LinearLayout) this.f34763e.findViewById(R.id.obfuscated_res_0x7f090f15);
            this.m = this.f34763e.findViewById(R.id.obfuscated_res_0x7f090f16);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.f34763e.findViewById(R.id.obfuscated_res_0x7f090f2d);
            this.f34773f = bdTypeRecyclerView;
            bdTypeRecyclerView.getRecycledViewPool().setMaxRecycledViews(1, 12);
            ((DefaultItemAnimator) this.f34773f.getItemAnimator()).setSupportsChangeAnimations(false);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.f34773f;
            bdTypeRecyclerView2.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView2.getContext()));
            View view = new View(this.f34773f.getContext());
            view.setLayoutParams(new LinearLayout.LayoutParams(-2, G0(R.dimen.tbds78)));
            this.f34773f.s(view);
            this.n = new b(this, this.f34773f, this.j, this.f34774g, getPageContext(), new InterestedForumModel(getUniqueId()), this.a, this.f34760b);
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.n.g(this.f34762d);
            showLoadingView(this.f34763e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f34775h);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X03);
            d2.A(R.string.F_X02);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.i);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X07);
            d3.A(R.string.F_X01);
            if (UbsABTestHelper.isInterestGuideStyleA()) {
                SkinManager.setBackgroundColor(this.f34763e, R.color.CAM_X0201);
                c.a.o0.r.v.c.d(this.l).f(R.color.CAM_X0201);
                c.a.o0.r.v.c.d(this.k).o(new int[]{R.color.CAM_X0201, R.color.CAM_X0612});
                c.a.o0.r.v.c.d(this.m).o(new int[]{R.color.CAM_X0612, R.color.CAM_X0201});
            } else if (UbsABTestHelper.isInterestGuideStyleB()) {
                SkinManager.setBackgroundColor(this.f34763e, R.color.CAM_X0206);
                c.a.o0.r.v.c.d(this.l).f(R.color.CAM_X0206);
                c.a.o0.r.v.c.d(this.k).o(new int[]{R.color.CAM_X0206, R.color.CAM_X0612});
                c.a.o0.r.v.c.d(this.m).o(new int[]{R.color.CAM_X0612, R.color.CAM_X0206});
            }
            this.f34774g.k();
            b bVar = this.n;
            if (bVar != null) {
                bVar.k(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            if (getArguments() != null) {
                this.a = getArguments().getInt("scene");
                this.f34760b = getArguments().getBoolean(InterestGuideActivityConfig.KEY_ONLY_SHOW_INTERESTED_FORUM);
                this.f34761c = getArguments().getStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE);
            }
            if (UbsABTestHelper.isInterestGuideStyleA()) {
                this.f34763e = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d02e5, viewGroup, false);
            } else if (UbsABTestHelper.isInterestGuideStyleB()) {
                this.f34763e = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d02e6, viewGroup, false);
            }
            J0();
            initData();
            return this.f34763e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            hideNetRefreshView(this.f34763e);
            this.n.g(this.f34762d);
            showLoadingView(this.f34763e);
        }
    }
}
