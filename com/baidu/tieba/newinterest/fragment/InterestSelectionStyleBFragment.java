package com.baidu.tieba.newinterest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
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
import com.repackage.cp7;
import com.repackage.fp7;
import com.repackage.gs4;
import com.repackage.mi;
import com.repackage.mp7;
import com.repackage.xu4;
/* loaded from: classes3.dex */
public class InterestSelectionStyleBFragment extends BaseInterestSelectionFragment implements cp7.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View g;
    public View h;
    public LinearLayout i;
    public TextView j;
    public TextView k;
    public NoScrollGridView l;
    public mp7 m;

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
            this.g = this.d.findViewById(R.id.obfuscated_res_0x7f090f26);
            this.h = this.d.findViewById(R.id.obfuscated_res_0x7f090f28);
            this.i = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090f27);
            this.l = (NoScrollGridView) this.d.findViewById(R.id.obfuscated_res_0x7f090f2a);
            this.b = (TBSpecificationBtn) this.d.findViewById(R.id.obfuscated_res_0x7f090f25);
            this.j = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090f2e);
            this.k = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090f29);
            String[] strArr = this.f;
            if (strArr != null && strArr.length == 3) {
                this.j.setText(strArr[0]);
                this.k.setText(this.f[1]);
            }
            xu4 xu4Var = new xu4();
            this.b.setTextSize(R.dimen.T_X06);
            this.b.setConfig(xu4Var);
            this.b.setText(getResources().getString(R.string.obfuscated_res_0x7f0f10e8));
            this.b.setEnabled(false);
            this.b.setOnClickListener(this);
            int k = mi.k(getContext());
            int f = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            int f2 = mi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X006);
            this.l.setColumnWidth((k / 4) + f);
            this.l.setVerticalSpacing(f2);
            this.l.setAdapter((ListAdapter) this.c);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            gs4.d(this.d).f(R.color.CAM_X0206);
            gs4 d = gs4.d(this.j);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X03);
            d.A(R.string.F_X02);
            gs4 d2 = gs4.d(this.k);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.T_X07);
            d2.A(R.string.F_X01);
            gs4.d(this.i).f(R.color.CAM_X0206);
            gs4.d(this.g).o(new int[]{R.color.CAM_X0206, R.color.CAM_X0612});
            gs4.d(this.h).o(new int[]{R.color.CAM_X0612, R.color.CAM_X0206});
            this.c.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            fp7 fp7Var = new fp7(null, getContext());
            this.c = fp7Var;
            this.m = new mp7(this, fp7Var);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) {
            this.d = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d02db, viewGroup, false);
            if (getArguments() != null) {
                this.e = getArguments().getInt("scene");
                this.f = getArguments().getStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE);
            }
            H0();
            showLoadingView(this.d);
            C0();
            return this.d;
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
            hideNetRefreshView(this.d);
            this.m.c();
            showLoadingView(this.d);
        }
    }
}
