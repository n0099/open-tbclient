package com.baidu.tieba;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class om8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;
    public BaseActivity<?> b;
    public NavigationBar c;
    public View d;
    public NoNetworkView e;
    public TextView f;
    public TextView g;

    public om8(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = baseActivity;
        this.d = baseActivity.findViewById(R.id.obfuscated_res_0x7f09229f);
        this.a = (BdListView) baseActivity.findViewById(R.id.obfuscated_res_0x7f09229b);
        NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.obfuscated_res_0x7f09229c);
        this.c = navigationBar;
        navigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f1453));
        this.f = this.c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.b.getString(R.string.obfuscated_res_0x7f0f038d), onClickListener);
        TextView addTextButton = this.c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0563), onClickListener);
        this.g = addTextButton;
        addTextButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams.leftMargin = ii.g(this.b, R.dimen.obfuscated_res_0x7f0701be);
        this.f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.g.getLayoutParams();
        layoutParams2.rightMargin = ii.g(this.b, R.dimen.obfuscated_res_0x7f0701be);
        this.g.setLayoutParams(layoutParams2);
        int g = ii.g(this.b, R.dimen.tbds27);
        this.g.setPadding(g, 0, g, 0);
        this.e = (NoNetworkView) baseActivity.findViewById(R.id.obfuscated_res_0x7f0922ae);
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f070266)));
        View view3 = new View(baseActivity.getPageContext().getPageActivity());
        view3.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701f9)));
        this.a.addFooterView(view2);
        this.a.addHeaderView(view3);
    }

    public TextView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return (TextView) invokeV.objValue;
    }

    public void c(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            iv4 layoutMode = this.b.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.b.getLayoutMode().k(this.d);
            this.e.d(this.b.getPageContext(), i);
            this.c.onChangeSkinType(this.b.getPageContext(), i);
            SkinManager.setViewTextColor(this.g, (int) R.color.navbar_btn_color);
            SkinManager.setViewTextColor(this.f, (int) R.color.navi_back_text_color);
            SkinManager.setBackgroundResource(this.g, R.drawable.s_navbar_button_bg);
        }
    }

    public void d(km8 km8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, km8Var) == null) {
            this.a.setAdapter((ListAdapter) km8Var);
        }
    }

    public void e(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                this.g.setText(this.b.getPageContext().getString(R.string.obfuscated_res_0x7f0f0530));
                return;
            }
            this.g.setText(this.b.getPageContext().getString(R.string.obfuscated_res_0x7f0f0563));
            this.g.setEnabled(!z2);
        }
    }
}
