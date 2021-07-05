package com.baidu.ufosdk.screencapedt;

import android.content.Intent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import java.io.ByteArrayOutputStream;
/* loaded from: classes6.dex */
public final class h implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f23258a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f23259b;

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
        this.f23259b = screenCapEditActivity;
        this.f23258a = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Intent intent = new Intent();
            intent.setClass(this.f23259b, FeedbackEditActivity.class);
            byteArrayOutputStream = this.f23259b.J;
            intent.putExtra("shot", byteArrayOutputStream.toByteArray());
            intent.putExtra("extend_feedback_channel", this.f23258a);
            intent.putExtra("feedback_channel", this.f23258a);
            this.f23259b.startActivity(intent);
            this.f23259b.finish();
        }
    }
}
