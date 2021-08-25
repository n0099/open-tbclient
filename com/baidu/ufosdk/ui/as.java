package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes8.dex */
public final class as implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackFacePageActivity f59549a;

    public as(FeedbackFacePageActivity feedbackFacePageActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackFacePageActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59549a = feedbackFacePageActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Context applicationContext = this.f59549a.getApplicationContext();
            String str = UfoSDK.clientid;
            String c2 = com.baidu.ufosdk.e.a.c(applicationContext);
            if (c2 != null) {
                handler = this.f59549a.v;
                handler.obtainMessage(0, c2).sendToTarget();
            }
        }
    }
}
