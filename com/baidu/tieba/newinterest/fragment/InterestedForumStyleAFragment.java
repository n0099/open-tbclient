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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.ka9;
import com.baidu.tieba.newinterest.model.InterestedForumModel;
import com.baidu.tieba.w95;
import com.baidu.tieba.y95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class InterestedForumStyleAFragment extends BaseInterestedForumFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView e;
    public TBSpecificationBtn f;
    public TextView g;
    public TextView h;
    public TBSpecificationBtn i;
    public View j;
    public LinearLayout k;
    public View l;
    public ka9 m;

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
            this.m.h(this.c);
            showLoadingView(this.d);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            this.i.setOnClickListener(null);
            ka9 ka9Var = this.m;
            if (ka9Var != null) {
                ka9Var.f();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            hideNetRefreshView(this.d);
            this.m.h(this.c);
            showLoadingView(this.d);
        }
    }

    public static InterestedForumStyleAFragment N1(int i, String[] strArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, strArr)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("scene", i);
            bundle.putStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE, strArr);
            InterestedForumStyleAFragment interestedForumStyleAFragment = new InterestedForumStyleAFragment();
            interestedForumStyleAFragment.setArguments(bundle);
            return interestedForumStyleAFragment;
        }
        return (InterestedForumStyleAFragment) invokeIL.objValue;
    }

    public final int M1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            Context context = getContext();
            if (context == null) {
                context = TbadkCoreApplication.getInst();
            }
            return BdUtilHelper.getDimens(context, i);
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
            this.h = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091158);
            TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091166);
            this.g = textView;
            String[] strArr = this.b;
            if (strArr != null && strArr.length == 3) {
                textView.setText(strArr[0]);
                this.h.setText(this.b[2]);
            }
            w95 w95Var = new w95();
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.d.findViewById(R.id.obfuscated_res_0x7f091145);
            this.i = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.T_X06);
            this.i.setConfig(w95Var);
            this.i.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0ad1));
            this.i.setEnabled(false);
            y95 y95Var = new y95();
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.d.findViewById(R.id.obfuscated_res_0x7f092142);
            this.f = tBSpecificationBtn2;
            tBSpecificationBtn2.setTextSize(R.dimen.T_X06);
            y95Var.t(R.color.CAM_X0105);
            this.f.setConfig(y95Var);
            this.f.setText(getString(R.string.obfuscated_res_0x7f0f0ad9));
            this.j = this.d.findViewById(R.id.obfuscated_res_0x7f091146);
            this.k = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091147);
            this.l = this.d.findViewById(R.id.obfuscated_res_0x7f091148);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.d.findViewById(R.id.obfuscated_res_0x7f09115d);
            this.e = bdTypeRecyclerView;
            bdTypeRecyclerView.getRecycledViewPool().setMaxRecycledViews(1, 12);
            ((DefaultItemAnimator) this.e.getItemAnimator()).setSupportsChangeAnimations(false);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.e;
            bdTypeRecyclerView2.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView2.getContext()));
            View view2 = new View(this.e.getContext());
            view2.setLayoutParams(new LinearLayout.LayoutParams(-2, M1(R.dimen.tbds78)));
            this.e.addHeaderView(view2);
            this.m = new ka9(this, this.e, this.i, this.f, getPageContext(), new InterestedForumModel(getUniqueId()), this.a);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            EMManager.from(this.g).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X03).setTextStyle(R.string.F_X02);
            EMManager.from(this.h).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X01);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
            EMManager.from(this.k).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.j).setGradientColor(new int[]{R.color.CAM_X0201, R.color.CAM_X0612});
            EMManager.from(this.l).setGradientColor(new int[]{R.color.CAM_X0612, R.color.CAM_X0201});
            this.f.k();
            ka9 ka9Var = this.m;
            if (ka9Var != null) {
                ka9Var.l(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, layoutInflater, viewGroup, bundle)) == null) {
            if (getArguments() != null) {
                this.a = getArguments().getInt("scene");
                this.b = getArguments().getStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE);
            }
            this.d = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0329, viewGroup, false);
            O1();
            initData();
            return this.d;
        }
        return (View) invokeLLL.objValue;
    }
}
