package com.baidu.ufosdk.ui;

import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes13.dex */
public final class cd implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ FeedbackInputActivity a;

    public cd(FeedbackInputActivity feedbackInputActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackInputActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String d2;
        Handler handler;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            str = this.a.ar;
            if (str != null) {
                str3 = this.a.ar;
                if (str3.length() > 0) {
                    str2 = this.a.ar;
                    d2 = com.baidu.ufosdk.e.a.d(this.a.getApplicationContext(), this.a.f52156e, str2);
                    if (d2 != null || d2.length() == 0) {
                    }
                    handler = this.a.aK;
                    handler.obtainMessage(5, d2).sendToTarget();
                    return;
                }
            }
            str2 = UfoSDK.appid;
            d2 = com.baidu.ufosdk.e.a.d(this.a.getApplicationContext(), this.a.f52156e, str2);
            if (d2 != null) {
            }
        }
    }
}
