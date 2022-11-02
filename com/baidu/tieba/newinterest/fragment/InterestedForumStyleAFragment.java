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
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.iz4;
import com.baidu.tieba.kw4;
import com.baidu.tieba.kz4;
import com.baidu.tieba.mu7;
import com.baidu.tieba.newinterest.model.InterestedForumModel;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class InterestedForumStyleAFragment extends BaseInterestedForumFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView f;
    public TBSpecificationBtn g;
    public TextView h;
    public TextView i;
    public TBSpecificationBtn j;
    public View k;
    public LinearLayout l;
    public View m;
    public mu7 n;

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

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.n.g(this.d);
            showLoadingView(this.e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            hideNetRefreshView(this.e);
            this.n.g(this.d);
            showLoadingView(this.e);
        }
    }

    public static InterestedForumStyleAFragment v1(int i, boolean z, String[] strArr) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) {
            if (getArguments() != null) {
                this.a = getArguments().getInt("scene");
                this.b = getArguments().getBoolean(InterestGuideActivityConfig.KEY_ONLY_SHOW_INTERESTED_FORUM);
                this.c = getArguments().getStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE);
            }
            this.e = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d02de, viewGroup, false);
            y1();
            initData();
            return this.e;
        }
        return (View) invokeLLL.objValue;
    }

    public static InterestedForumStyleAFragment x1(int i, String[] strArr) {
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            kw4 d = kw4.d(this.h);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X03);
            d.A(R.string.F_X02);
            kw4 d2 = kw4.d(this.i);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.T_X07);
            d2.A(R.string.F_X01);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0201);
            kw4.d(this.l).f(R.color.CAM_X0201);
            kw4.d(this.k).o(new int[]{R.color.CAM_X0201, R.color.CAM_X0612});
            kw4.d(this.m).o(new int[]{R.color.CAM_X0612, R.color.CAM_X0201});
            this.g.k();
            mu7 mu7Var = this.n;
            if (mu7Var != null) {
                mu7Var.k(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    public final int u1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            Context context = getContext();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            return xi.g(context, i);
        }
        return invokeI.intValue;
    }

    public final void y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.i = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f090f84);
            TextView textView = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f090f92);
            this.h = textView;
            String[] strArr = this.c;
            if (strArr != null && strArr.length == 3) {
                textView.setText(strArr[0]);
                this.i.setText(this.c[2]);
            }
            iz4 iz4Var = new iz4();
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.e.findViewById(R.id.obfuscated_res_0x7f090f71);
            this.j = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.T_X06);
            this.j.setConfig(iz4Var);
            this.j.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0964));
            this.j.setEnabled(false);
            kz4 kz4Var = new kz4();
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.e.findViewById(R.id.obfuscated_res_0x7f091e7e);
            this.g = tBSpecificationBtn2;
            tBSpecificationBtn2.setTextSize(R.dimen.T_X06);
            kz4Var.r(R.color.CAM_X0105);
            this.g.setConfig(kz4Var);
            this.g.setText(getString(R.string.obfuscated_res_0x7f0f096c));
            this.k = this.e.findViewById(R.id.obfuscated_res_0x7f090f72);
            this.l = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f090f73);
            this.m = this.e.findViewById(R.id.obfuscated_res_0x7f090f74);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.e.findViewById(R.id.obfuscated_res_0x7f090f89);
            this.f = bdTypeRecyclerView;
            bdTypeRecyclerView.getRecycledViewPool().setMaxRecycledViews(1, 12);
            ((DefaultItemAnimator) this.f.getItemAnimator()).setSupportsChangeAnimations(false);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.f;
            bdTypeRecyclerView2.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView2.getContext()));
            View view2 = new View(this.f.getContext());
            view2.setLayoutParams(new LinearLayout.LayoutParams(-2, u1(R.dimen.tbds78)));
            this.f.s(view2);
            this.n = new mu7(this, this.f, this.j, this.g, getPageContext(), new InterestedForumModel(getUniqueId()), this.a, this.b);
        }
    }
}
