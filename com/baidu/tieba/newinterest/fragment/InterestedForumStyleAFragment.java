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
import com.baidu.tieba.c19;
import com.baidu.tieba.ka5;
import com.baidu.tieba.ma5;
import com.baidu.tieba.newinterest.model.InterestedForumModel;
import com.baidu.tieba.o75;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
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
    public c19 n;

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
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.n.g(this.d);
            showLoadingView(this.e);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            this.j.setOnClickListener(null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            hideNetRefreshView(this.e);
            this.n.g(this.d);
            showLoadingView(this.e);
        }
    }

    public static InterestedForumStyleAFragment M1(int i, boolean z, String[] strArr) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            if (getArguments() != null) {
                this.a = getArguments().getInt("scene");
                this.b = getArguments().getBoolean(InterestGuideActivityConfig.KEY_ONLY_SHOW_INTERESTED_FORUM);
                this.c = getArguments().getStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE);
            }
            this.e = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d031c, viewGroup, false);
            O1();
            initData();
            return this.e;
        }
        return (View) invokeLLL.objValue;
    }

    public static InterestedForumStyleAFragment N1(int i, String[] strArr) {
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

    public final int L1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            Context context = getContext();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            return vi.g(context, i);
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.i = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f091122);
            TextView textView = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f091130);
            this.h = textView;
            String[] strArr = this.c;
            if (strArr != null && strArr.length == 3) {
                textView.setText(strArr[0]);
                this.i.setText(this.c[2]);
            }
            ka5 ka5Var = new ka5();
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.e.findViewById(R.id.obfuscated_res_0x7f09110f);
            this.j = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.T_X06);
            this.j.setConfig(ka5Var);
            this.j.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0abc));
            this.j.setEnabled(false);
            ma5 ma5Var = new ma5();
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.e.findViewById(R.id.obfuscated_res_0x7f092087);
            this.g = tBSpecificationBtn2;
            tBSpecificationBtn2.setTextSize(R.dimen.T_X06);
            ma5Var.s(R.color.CAM_X0105);
            this.g.setConfig(ma5Var);
            this.g.setText(getString(R.string.obfuscated_res_0x7f0f0ac4));
            this.k = this.e.findViewById(R.id.obfuscated_res_0x7f091110);
            this.l = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f091111);
            this.m = this.e.findViewById(R.id.obfuscated_res_0x7f091112);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.e.findViewById(R.id.obfuscated_res_0x7f091127);
            this.f = bdTypeRecyclerView;
            bdTypeRecyclerView.getRecycledViewPool().setMaxRecycledViews(1, 12);
            ((DefaultItemAnimator) this.f.getItemAnimator()).setSupportsChangeAnimations(false);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.f;
            bdTypeRecyclerView2.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView2.getContext()));
            View view2 = new View(this.f.getContext());
            view2.setLayoutParams(new LinearLayout.LayoutParams(-2, L1(R.dimen.tbds78)));
            this.f.addHeaderView(view2);
            this.n = new c19(this, this.f, this.j, this.g, getPageContext(), new InterestedForumModel(getUniqueId()), this.a, this.b);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            o75 d = o75.d(this.h);
            d.w(R.color.CAM_X0105);
            d.B(R.dimen.T_X03);
            d.C(R.string.F_X02);
            o75 d2 = o75.d(this.i);
            d2.w(R.color.CAM_X0108);
            d2.B(R.dimen.T_X07);
            d2.C(R.string.F_X01);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0201);
            o75.d(this.l).f(R.color.CAM_X0201);
            o75.d(this.k).p(new int[]{R.color.CAM_X0201, R.color.CAM_X0612});
            o75.d(this.m).p(new int[]{R.color.CAM_X0612, R.color.CAM_X0201});
            this.g.k();
            c19 c19Var = this.n;
            if (c19Var != null) {
                c19Var.k(i);
            }
        }
    }
}
