package com.baidu.tieba.newinterest.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.p0.s2.a.a;
import c.a.p0.s2.a.b;
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
/* loaded from: classes5.dex */
public class InterestSelectionFragment extends BaseInterestSelectionFragment implements a.InterfaceC1374a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f34764g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f34765h;
    public TextView i;
    public c.a.p0.s2.g.a j;
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

    public static InterestSelectionFragment G0(int i, String[] strArr) {
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

    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k = (NoScrollGridView) this.f34757d.findViewById(R.id.obfuscated_res_0x7f090f22);
            this.f34755b = (TBSpecificationBtn) this.f34757d.findViewById(R.id.obfuscated_res_0x7f090f1d);
            TextView textView = (TextView) this.f34757d.findViewById(R.id.obfuscated_res_0x7f090f26);
            this.f34765h = textView;
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            this.i = (TextView) this.f34757d.findViewById(R.id.obfuscated_res_0x7f090f21);
            this.f34764g = (FrameLayout) this.f34757d.findViewById(R.id.obfuscated_res_0x7f0903d9);
            c.a.o0.r.l0.n.a aVar = new c.a.o0.r.l0.n.a();
            this.f34755b.setTextSize(R.dimen.tbds42);
            this.f34755b.setConfig(aVar);
            this.f34755b.setText(getResources().getString(R.string.obfuscated_res_0x7f0f10c8));
            this.f34755b.setEnabled(false);
            this.f34755b.setOnClickListener(this);
            this.k.setAdapter((ListAdapter) this.f34756c);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBackgroundColor(this.f34757d, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f34765h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.f34764g, R.color.CAM_X0201);
            this.f34756c.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            this.j = new c.a.p0.s2.g.a(getContext());
            this.f34756c = new b(this.j.c(), getContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, layoutInflater, viewGroup, bundle)) == null) {
            this.f34757d = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d02e1, viewGroup, false);
            H0();
            C0();
            if (getArguments() != null) {
                this.f34758e = getArguments().getInt("scene");
                this.f34759f = getArguments().getStringArray(InterestGuideActivityConfig.KEY_CUSTOM_TITLE);
            }
            return this.f34757d;
        }
        return (View) invokeLLL.objValue;
    }
}
