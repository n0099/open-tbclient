package com.baidu.tieba.newinterest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NoScrollGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iq7;
import com.repackage.jq7;
import com.repackage.ms4;
import com.repackage.ov4;
import com.repackage.pq7;
import com.repackage.qi;
/* loaded from: classes3.dex */
public class InterestSelectionStyleAFragment extends BaseInterestSelectionFragment implements iq7.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View g;
    public View h;
    public LinearLayout i;
    public TextView j;
    public TextView k;
    public NoScrollGridView l;
    public pq7 m;

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

    public static InterestSelectionStyleAFragment v1(int i, String[] strArr) {
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            ms4.d(this.d).f(R.color.CAM_X0201);
            ms4 d = ms4.d(this.j);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X03);
            d.A(R.string.F_X02);
            ms4 d2 = ms4.d(this.k);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.T_X07);
            d2.A(R.string.F_X01);
            ms4.d(this.i).f(R.color.CAM_X0201);
            ms4.d(this.g).o(new int[]{R.color.CAM_X0201, R.color.CAM_X0612});
            ms4.d(this.h).o(new int[]{R.color.CAM_X0612, R.color.CAM_X0201});
            this.c.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            jq7 jq7Var = new jq7(null, getContext());
            this.c = jq7Var;
            this.m = new pq7(this, jq7Var);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater, viewGroup, bundle)) == null) {
            this.d = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d02d6, viewGroup, false);
            if (getArguments() != null) {
                this.e = getArguments().getInt("scene");
                this.f = getArguments().getStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE);
            }
            w1();
            showLoadingView(this.d);
            r1();
            return this.d;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            this.m.b();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            hideNetRefreshView(this.d);
            this.m.c();
            showLoadingView(this.d);
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.g = this.d.findViewById(R.id.obfuscated_res_0x7f090f33);
            this.h = this.d.findViewById(R.id.obfuscated_res_0x7f090f35);
            this.i = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090f34);
            this.l = (NoScrollGridView) this.d.findViewById(R.id.obfuscated_res_0x7f090f37);
            this.b = (TBSpecificationBtn) this.d.findViewById(R.id.obfuscated_res_0x7f090f32);
            this.j = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090f39);
            this.k = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090f36);
            String[] strArr = this.f;
            if (strArr != null && strArr.length == 3) {
                this.j.setText(strArr[0]);
                this.k.setText(this.f[1]);
            }
            ov4 ov4Var = new ov4();
            this.b.setTextSize(R.dimen.T_X06);
            this.b.setConfig(ov4Var);
            this.b.setText(getResources().getString(R.string.obfuscated_res_0x7f0f10f0));
            this.b.setEnabled(false);
            this.b.setOnClickListener(this);
            this.l.setColumnWidth(qi.k(getContext()) / 5);
            this.l.setAdapter((ListAdapter) this.c);
        }
    }
}
