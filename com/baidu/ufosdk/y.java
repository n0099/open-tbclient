package com.baidu.ufosdk;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.screencapedt.ScreenCapEditActivity;
/* loaded from: classes8.dex */
public class y implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ScreenCapEditActivity a;

    public y(ScreenCapEditActivity screenCapEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {screenCapEditActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            ScreenCapEditActivity screenCapEditActivity = this.a;
            screenCapEditActivity.E = !screenCapEditActivity.E;
            ScreenCapEditActivity screenCapEditActivity2 = this.a;
            if (!screenCapEditActivity2.E) {
                screenCapEditActivity2.P.setBackgroundDrawable(p1.a(screenCapEditActivity2.getApplicationContext(), -15066598, -16777216));
            } else {
                screenCapEditActivity2.P.setBackgroundColor(-16777216);
            }
        }
    }
}
