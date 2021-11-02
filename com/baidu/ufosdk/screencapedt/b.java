package com.baidu.ufosdk.screencapedt;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.f.m;
/* loaded from: classes10.dex */
public final class b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f56721a;

    public b(ScreenCapEditActivity screenCapEditActivity) {
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
        this.f56721a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        boolean z2;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            ScreenCapEditActivity screenCapEditActivity = this.f56721a;
            z = screenCapEditActivity.H;
            screenCapEditActivity.H = !z;
            z2 = this.f56721a.H;
            if (z2) {
                relativeLayout2 = this.f56721a.Q;
                relativeLayout2.setBackgroundColor(-16777216);
                return;
            }
            relativeLayout = this.f56721a.Q;
            this.f56721a.getApplicationContext();
            relativeLayout.setBackgroundDrawable(m.a(-16777216));
        }
    }
}
