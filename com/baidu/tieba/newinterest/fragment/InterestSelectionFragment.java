package com.baidu.tieba.newinterest.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.InterestGuideActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NoScrollGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ap7;
import com.repackage.lu4;
import com.repackage.wp7;
import com.repackage.zo7;
/* loaded from: classes3.dex */
public class InterestSelectionFragment extends BaseInterestSelectionFragment implements zo7.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout g;
    public TextView h;
    public TextView i;
    public wp7 j;
    public NoScrollGridView k;

    public InterestSelectionFragment() {
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

    public static InterestSelectionFragment F0(int i, String[] strArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, strArr)) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("scene", i);
            bundle.putStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE, strArr);
            InterestSelectionFragment interestSelectionFragment = new InterestSelectionFragment();
            interestSelectionFragment.setArguments(bundle);
            return interestSelectionFragment;
        }
        return (InterestSelectionFragment) invokeIL.objValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k = (NoScrollGridView) this.d.findViewById(R.id.obfuscated_res_0x7f090f1c);
            this.b = (TBSpecificationBtn) this.d.findViewById(R.id.obfuscated_res_0x7f090f17);
            TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090f20);
            this.h = textView;
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            this.i = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090f1b);
            this.g = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0903e3);
            lu4 lu4Var = new lu4();
            this.b.setTextSize(R.dimen.tbds42);
            this.b.setConfig(lu4Var);
            this.b.setText(getResources().getString(R.string.obfuscated_res_0x7f0f10d0));
            this.b.setEnabled(false);
            this.b.setOnClickListener(this);
            this.k.setAdapter((ListAdapter) this.c);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0201);
            this.c.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            this.j = new wp7(getContext());
            this.c = new ap7(this.j.c(), getContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) {
            this.d = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d02e2, viewGroup, false);
            G0();
            B0();
            if (getArguments() != null) {
                this.e = getArguments().getInt("scene");
                this.f = getArguments().getStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE);
            }
            return this.d;
        }
        return (View) invokeLLL.objValue;
    }
}
