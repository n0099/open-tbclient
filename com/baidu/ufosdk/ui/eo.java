package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes10.dex */
public final class eo implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f56974a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f56975b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f56976c;

    public eo(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ejVar, feedbackInputActivity, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56976c = ejVar;
        this.f56974a = feedbackInputActivity;
        this.f56975b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Context applicationContext = this.f56974a.getApplicationContext();
            String str = UfoSDK.clientid;
            com.baidu.ufosdk.e.a.b(applicationContext, this.f56974a.f56764f, this.f56975b);
        }
    }
}
