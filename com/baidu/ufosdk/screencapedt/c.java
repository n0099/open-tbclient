package com.baidu.ufosdk.screencapedt;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.f.m;
/* loaded from: classes8.dex */
public final class c implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f59451a;

    public c(ScreenCapEditActivity screenCapEditActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {screenCapEditActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59451a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            ScreenCapEditActivity screenCapEditActivity = this.f59451a;
            z = screenCapEditActivity.H;
            screenCapEditActivity.H = !z;
            z2 = this.f59451a.H;
            if (z2) {
                relativeLayout = this.f59451a.Q;
                relativeLayout.setBackgroundColor(-16777216);
                return;
            }
            relativeLayout2 = this.f59451a.Q;
            this.f59451a.getApplicationContext();
            relativeLayout2.setBackgroundDrawable(m.a(-16777216));
        }
    }
}
