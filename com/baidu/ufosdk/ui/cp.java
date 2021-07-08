package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class cp implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ co f23518a;

    public cp(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {coVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23518a = coVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        Handler handler;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            FeedbackInputActivity feedbackInputActivity = this.f23518a.f23515b.f23503a;
            feedbackInputActivity.B = false;
            Context applicationContext = feedbackInputActivity.getApplicationContext();
            String str4 = UfoSDK.clientid;
            FeedbackInputActivity feedbackInputActivity2 = this.f23518a.f23515b.f23503a;
            String str5 = feedbackInputActivity2.f23404e;
            str = feedbackInputActivity2.ar;
            str2 = this.f23518a.f23517d;
            str3 = this.f23518a.f23515b.f23503a.aA;
            handler = this.f23518a.f23515b.f23503a.aK;
            i2 = this.f23518a.f23516c;
            feedbackInputActivity.a(applicationContext, str4, str5, str, str2, str3, (String) null, handler, i2);
        }
    }
}
