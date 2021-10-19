package com.baidu.ufosdk.screencapedt;

import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import java.io.ByteArrayOutputStream;
/* loaded from: classes8.dex */
public final class h implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f59802a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f59803b;

    public h(ScreenCapEditActivity screenCapEditActivity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {screenCapEditActivity, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59803b = screenCapEditActivity;
        this.f59802a = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Intent intent = new Intent();
            intent.setClass(this.f59803b, FeedbackEditActivity.class);
            byteArrayOutputStream = this.f59803b.J;
            intent.putExtra("shot", byteArrayOutputStream.toByteArray());
            intent.putExtra("extend_feedback_channel", this.f59802a);
            intent.putExtra("feedback_channel", this.f59802a);
            this.f59803b.startActivity(intent);
            this.f59803b.finish();
        }
    }
}
