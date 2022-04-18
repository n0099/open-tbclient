package com.baidu.tieba.newinterest.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
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
import com.repackage.kp7;
import com.repackage.ku4;
/* loaded from: classes3.dex */
public class InterestedForumFragment extends BaseInterestedForumFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public BdRecyclerView g;
    public TBSpecificationBtn h;
    public TextView i;
    public TextView j;
    public kp7 k;
    public FrameLayout l;
    public TBSpecificationBtn m;

    public InterestedForumFragment() {
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

    public static InterestedForumFragment F0(int i, boolean z, String[] strArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), strArr})) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("scene", i);
            bundle.putBoolean(InterestGuideActivityConfig.KEY_ONLY_SHOW_INTERESTED_FORUM, z);
            bundle.putStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE, strArr);
            InterestedForumFragment interestedForumFragment = new InterestedForumFragment();
            interestedForumFragment.setArguments(bundle);
            return interestedForumFragment;
        }
        return (InterestedForumFragment) invokeCommon.objValue;
    }

    public static InterestedForumFragment G0(int i, String[] strArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, strArr)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("scene", i);
            bundle.putStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE, strArr);
            InterestedForumFragment interestedForumFragment = new InterestedForumFragment();
            interestedForumFragment.setArguments(bundle);
            return interestedForumFragment;
        }
        return (InterestedForumFragment) invokeIL.objValue;
    }

    @Override // com.baidu.tieba.newinterest.fragment.BaseInterestedForumFragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hideLoadingView(this.f);
        }
    }

    @Override // com.baidu.tieba.newinterest.fragment.BaseInterestedForumFragment
    public void D0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            hideLoadingView(this.f);
            showNetRefreshView(this.f, str, false);
        }
    }

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.j = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090f23);
            TextView textView = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090f32);
            this.i = textView;
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0107);
            this.g = (BdRecyclerView) this.f.findViewById(R.id.obfuscated_res_0x7f090f28);
            this.l = (FrameLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0903e3);
            ku4 ku4Var = new ku4();
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.f.findViewById(R.id.obfuscated_res_0x7f090f0e);
            this.m = tBSpecificationBtn;
            tBSpecificationBtn.setTextSize(R.dimen.tbds42);
            this.m.setConfig(ku4Var);
            this.m.setText(getResources().getString(R.string.obfuscated_res_0x7f0f142c));
            this.m.setEnabled(false);
            this.m.setOnClickListener(this);
            TBSpecificationBtn tBSpecificationBtn2 = (TBSpecificationBtn) this.f.findViewById(R.id.obfuscated_res_0x7f091c5a);
            this.h = tBSpecificationBtn2;
            tBSpecificationBtn2.setText(getString(R.string.obfuscated_res_0x7f0f10c1));
            this.k = new kp7(this, this.g, this.m, this.h, getPageContext(), new InterestedForumModel(getUniqueId()), this.a, this.b);
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.h.setOnClickListener(this);
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.k.f(this.d);
            showLoadingView(this.f);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0107);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view2) == null) && view2 == this.h) {
            this.k.j();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            if (getArguments() != null) {
                this.a = getArguments().getInt("scene");
                this.b = getArguments().getBoolean(InterestGuideActivityConfig.KEY_ONLY_SHOW_INTERESTED_FORUM);
                this.c = getArguments().getStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE);
            }
            this.f = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d02e5, viewGroup, false);
            H0();
            I0();
            initData();
            return this.f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            hideNetRefreshView(this.f);
            this.k.f(this.d);
            showLoadingView(this.f);
        }
    }
}
