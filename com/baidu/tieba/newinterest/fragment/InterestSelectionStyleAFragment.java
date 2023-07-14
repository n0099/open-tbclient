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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.d85;
import com.baidu.tieba.gb5;
import com.baidu.tieba.gc9;
import com.baidu.tieba.hc9;
import com.baidu.tieba.nc9;
import com.baidu.tieba.view.NoScrollGridView;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class InterestSelectionStyleAFragment extends BaseInterestSelectionFragment implements gc9.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View g;
    public View h;
    public LinearLayout i;
    public TextView j;
    public TextView k;
    public NoScrollGridView l;
    public nc9 m;

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

    public static InterestSelectionStyleAFragment L1(int i, String[] strArr) {
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

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g = this.d.findViewById(R.id.obfuscated_res_0x7f09113d);
            this.h = this.d.findViewById(R.id.obfuscated_res_0x7f09113f);
            this.i = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09113e);
            this.l = (NoScrollGridView) this.d.findViewById(R.id.obfuscated_res_0x7f091141);
            this.b = (TBSpecificationBtn) this.d.findViewById(R.id.obfuscated_res_0x7f09113c);
            this.j = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091143);
            this.k = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091140);
            String[] strArr = this.f;
            if (strArr != null && strArr.length == 3) {
                this.j.setText(strArr[0]);
                this.k.setText(this.f[1]);
            }
            gb5 gb5Var = new gb5();
            this.b.setTextSize(R.dimen.T_X06);
            this.b.setConfig(gb5Var);
            this.b.setText(getResources().getString(R.string.obfuscated_res_0x7f0f133b));
            this.b.setEnabled(false);
            this.b.setOnClickListener(this);
            this.l.setColumnWidth(yi.l(getContext()) / 5);
            this.l.setAdapter((ListAdapter) this.c);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            d85.d(this.d).f(R.color.CAM_X0201);
            d85 d = d85.d(this.j);
            d.x(R.color.CAM_X0105);
            d.C(R.dimen.T_X03);
            d.D(R.string.F_X02);
            d85 d2 = d85.d(this.k);
            d2.x(R.color.CAM_X0108);
            d2.C(R.dimen.T_X07);
            d2.D(R.string.F_X01);
            d85.d(this.i).f(R.color.CAM_X0201);
            d85.d(this.g).p(new int[]{R.color.CAM_X0201, R.color.CAM_X0612});
            d85.d(this.h).p(new int[]{R.color.CAM_X0612, R.color.CAM_X0201});
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
            hc9 hc9Var = new hc9(null, getContext());
            this.c = hc9Var;
            this.m = new nc9(this, hc9Var);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, layoutInflater, viewGroup, bundle)) == null) {
            this.d = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0325, viewGroup, false);
            if (getArguments() != null) {
                this.e = getArguments().getInt("scene");
                this.f = getArguments().getStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE);
            }
            M1();
            showLoadingView(this.d);
            H1();
            return this.d;
        }
        return (View) invokeLLL.objValue;
    }
}
