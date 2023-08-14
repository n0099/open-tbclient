package com.baidu.tieba;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdPageContext a;
    public NavigationBarCoverTip b;
    public TextView c;
    public int d;

    public nh9(BdPageContext bdPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, navigationBarCoverTip};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bdPageContext;
        this.b = navigationBarCoverTip;
        b();
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || this.b == null) {
            return;
        }
        if (!bi.isEmpty(str) && this.d <= 0) {
            this.b.setVisibility(0);
            this.d++;
            this.c.setText(str);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0101);
            this.b.removeAllViews();
            this.b.addView(this.c);
            this.b.k(this.a.getPageActivity(), 5000);
            return;
        }
        c();
        this.b.setVisibility(8);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = new TextView(this.a.getPageActivity());
            this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            this.c.setMinHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds112));
            this.c.setPadding(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f), 0, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07020f), 0);
            this.c.setGravity(19);
            this.c.setTextSize(0, this.a.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
            this.c.setLineSpacing(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4), 1.0f);
        }
    }

    public void c() {
        NavigationBarCoverTip navigationBarCoverTip;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (navigationBarCoverTip = this.b) != null) {
            navigationBarCoverTip.i();
        }
    }
}
