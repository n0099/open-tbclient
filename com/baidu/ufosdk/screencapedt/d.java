package com.baidu.ufosdk.screencapedt;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.widget.Button;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public final class d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f56723a;

    public d(ScreenCapEditActivity screenCapEditActivity) {
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
        this.f56723a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        HashMap hashMap;
        Button button;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        Canvas canvas;
        Paint paint;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f56723a.a(false);
            hashMap = this.f56723a.t;
            for (Map.Entry entry : hashMap.entrySet()) {
                canvas = this.f56723a.m;
                float b2 = ((a) entry.getValue()).b();
                float c2 = ((a) entry.getValue()).c();
                float d2 = ((a) entry.getValue()).d();
                float e2 = ((a) entry.getValue()).e();
                paint = this.f56723a.n;
                canvas.drawRect(b2, c2, d2, e2, paint);
            }
            button = this.f56723a.T;
            button.setClickable(false);
            z = this.f56723a.I;
            if (!z) {
                ScreenCapEditActivity.j(this.f56723a);
                ScreenCapEditActivity screenCapEditActivity = this.f56723a;
                i2 = screenCapEditActivity.M;
                ScreenCapEditActivity.a(screenCapEditActivity, i2);
                return;
            }
            z2 = this.f56723a.L;
            if (!z2) {
                ScreenCapEditActivity.i(this.f56723a);
                return;
            }
            ScreenCapEditActivity.j(this.f56723a);
            ScreenCapEditActivity screenCapEditActivity2 = this.f56723a;
            i3 = screenCapEditActivity2.M;
            ScreenCapEditActivity.a(screenCapEditActivity2, i3);
        }
    }
}
