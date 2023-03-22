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
import com.baidu.tieba.hi;
import com.baidu.tieba.j45;
import com.baidu.tieba.l45;
import com.baidu.tieba.n15;
import com.baidu.tieba.newinterest.model.InterestedForumModel;
import com.baidu.tieba.yf8;
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
    public yf8 n;

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

    public static InterestedForumStyleAFragment J1(int i, boolean z, String[] strArr) {
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
            this.e = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d02f9, viewGroup, false);
            L1();
            initData();
            return this.e;
        }
        return (View) invokeLLL.objValue;
    }

    public static InterestedForumStyleAFragment K1(int i, String[] strArr) {
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

    public final int I1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            Context context = getContext();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            return hi.g(context, i);
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

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.i = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f0910c0);
            TextView textView = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f0910d1);
            this.h = textView;
            String[] strArr = this.c;
            if (strArr != null && strArr.length == 3) {
                textView.setText(strArr[0]);
                this.i.setText(this.c[2]);
            }
            j45 j45Var = new j45();
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.e.findViewById(R.id.obfuscated_res_0x7f0910ad);
            this.j = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.T_X06);
            this.j.setConfig(j45Var);
            this.j.setText(getResources().getString(R.string.obfuscated_res_0x7f0f09fa));
            this.j.setEnabled(false);
            l45 l45Var = new l45();
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.e.findViewById(R.id.obfuscated_res_0x7f091ffc);
            this.g = tBSpecificationBtn2;
            tBSpecificationBtn2.setTextSize(R.dimen.T_X06);
            l45Var.s(R.color.CAM_X0105);
            this.g.setConfig(l45Var);
            this.g.setText(getString(R.string.obfuscated_res_0x7f0f0a02));
            this.k = this.e.findViewById(R.id.obfuscated_res_0x7f0910ae);
            this.l = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f0910af);
            this.m = this.e.findViewById(R.id.obfuscated_res_0x7f0910b0);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.e.findViewById(R.id.obfuscated_res_0x7f0910c5);
            this.f = bdTypeRecyclerView;
            bdTypeRecyclerView.getRecycledViewPool().setMaxRecycledViews(1, 12);
            ((DefaultItemAnimator) this.f.getItemAnimator()).setSupportsChangeAnimations(false);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.f;
            bdTypeRecyclerView2.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView2.getContext()));
            View view2 = new View(this.f.getContext());
            view2.setLayoutParams(new LinearLayout.LayoutParams(-2, I1(R.dimen.tbds78)));
            this.f.addHeaderView(view2);
            this.n = new yf8(this, this.f, this.j, this.g, getPageContext(), new InterestedForumModel(getUniqueId()), this.a, this.b);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            n15 d = n15.d(this.h);
            d.w(R.color.CAM_X0105);
            d.A(R.dimen.T_X03);
            d.B(R.string.F_X02);
            n15 d2 = n15.d(this.i);
            d2.w(R.color.CAM_X0108);
            d2.A(R.dimen.T_X07);
            d2.B(R.string.F_X01);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0201);
            n15.d(this.l).f(R.color.CAM_X0201);
            n15.d(this.k).p(new int[]{R.color.CAM_X0201, R.color.CAM_X0612});
            n15.d(this.m).p(new int[]{R.color.CAM_X0612, R.color.CAM_X0201});
            this.g.k();
            yf8 yf8Var = this.n;
            if (yf8Var != null) {
                yf8Var.k(i);
            }
        }
    }
}
