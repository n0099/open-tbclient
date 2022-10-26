package com.baidu.ufosdk;

import android.view.View;
import android.widget.Button;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.screencapedt.ScreenCapEditActivity;
import java.util.Map;
/* loaded from: classes6.dex */
public class z implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Button a;
    public final /* synthetic */ ScreenCapEditActivity b;

    public z(ScreenCapEditActivity screenCapEditActivity, Button button) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {screenCapEditActivity, button};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = screenCapEditActivity;
        this.a = button;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
            return;
        }
        this.b.a(false);
        for (Map.Entry entry : this.b.q.entrySet()) {
            this.b.i.drawRect(((x) entry.getValue()).a, ((x) entry.getValue()).b, ((x) entry.getValue()).c, ((x) entry.getValue()).d, this.b.j);
        }
        this.a.setClickable(false);
        ScreenCapEditActivity screenCapEditActivity = this.b;
        if (screenCapEditActivity.G) {
            ScreenCapEditActivity.a(screenCapEditActivity);
        } else if (screenCapEditActivity.F) {
            if (!screenCapEditActivity.J) {
                ScreenCapEditActivity.a(screenCapEditActivity);
            } else {
                ScreenCapEditActivity.a(screenCapEditActivity, screenCapEditActivity.K);
            }
        } else {
            ScreenCapEditActivity.a(screenCapEditActivity, screenCapEditActivity.K);
        }
    }
}
