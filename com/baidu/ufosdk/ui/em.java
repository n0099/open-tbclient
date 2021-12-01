package com.baidu.ufosdk.ui;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public final class em implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ FeedbackInputActivity a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f51697b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ej f51698c;

    public em(ej ejVar, FeedbackInputActivity feedbackInputActivity, String str) {
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
        this.f51698c = ejVar;
        this.a = feedbackInputActivity;
        this.f51697b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.baidu.ufosdk.e.a.c(this.a.getApplicationContext(), this.a.f51608f, this.f51697b);
        }
    }
}
