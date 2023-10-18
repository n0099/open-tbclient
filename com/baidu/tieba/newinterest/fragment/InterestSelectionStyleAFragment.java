package com.baidu.tieba.newinterest.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.jb9;
import com.baidu.tieba.kb9;
import com.baidu.tieba.qb9;
import com.baidu.tieba.view.NoScrollGridView;
import com.baidu.tieba.z45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class InterestSelectionStyleAFragment extends BaseInterestSelectionFragment implements jb9.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View g;
    public View h;
    public LinearLayout i;
    public TextView j;
    public TextView k;
    public NoScrollGridView l;
    public qb9 m;

    public InterestSelectionStyleAFragment() {
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            this.m.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            hideNetRefreshView(this.d);
            this.m.c();
            showLoadingView(this.d);
        }
    }

    public static InterestSelectionStyleAFragment g2(int i, String[] strArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, strArr)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("scene", i);
            bundle.putStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE, strArr);
            InterestSelectionStyleAFragment interestSelectionStyleAFragment = new InterestSelectionStyleAFragment();
            interestSelectionStyleAFragment.setArguments(bundle);
            return interestSelectionStyleAFragment;
        }
        return (InterestSelectionStyleAFragment) invokeIL.objValue;
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g = this.d.findViewById(R.id.obfuscated_res_0x7f091172);
            this.h = this.d.findViewById(R.id.obfuscated_res_0x7f091174);
            this.i = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091173);
            this.l = (NoScrollGridView) this.d.findViewById(R.id.obfuscated_res_0x7f091176);
            this.b = (TBSpecificationBtn) this.d.findViewById(R.id.obfuscated_res_0x7f091171);
            this.j = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091178);
            this.k = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091175);
            String[] strArr = this.f;
            if (strArr != null && strArr.length == 3) {
                this.j.setText(strArr[0]);
                this.k.setText(this.f[1]);
            }
            z45 z45Var = new z45();
            this.b.setTextSize(R.dimen.T_X06);
            this.b.setConfig(z45Var);
            this.b.setText(getResources().getString(R.string.obfuscated_res_0x7f0f1375));
            this.b.setEnabled(false);
            this.b.setOnClickListener(this);
            this.l.setColumnWidth(BdUtilHelper.getEquipmentWidth(getContext()) / 5);
            this.l.setAdapter((ListAdapter) this.c);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            EMManager.from(this.d).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.j).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X03).setTextStyle(R.string.F_X02);
            EMManager.from(this.k).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X01);
            EMManager.from(this.i).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.g).setGradientColor(new int[]{R.color.CAM_X0201, R.color.CAM_X0612});
            EMManager.from(this.h).setGradientColor(new int[]{R.color.CAM_X0612, R.color.CAM_X0201});
            this.c.notifyDataSetChanged();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (this.l != null && this.c != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (getActivity() != null) {
                    getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    this.c.d(false);
                    this.l.setColumnWidth(displayMetrics.widthPixels / 5);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            kb9 kb9Var = new kb9(null, getContext());
            this.c = kb9Var;
            this.m = new qb9(this, kb9Var);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            this.d = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0332, viewGroup, false);
            if (getArguments() != null) {
                this.e = getArguments().getInt("scene");
                this.f = getArguments().getStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE);
            }
            h2();
            showLoadingView(this.d);
            c2();
            return this.d;
        }
        return (View) invokeLLL.objValue;
    }
}
