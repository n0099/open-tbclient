package com.bytedance.sdk.component.b.b.a.e;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes9.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f64381a;

    /* renamed from: b  reason: collision with root package name */
    public long f64382b;

    /* renamed from: c  reason: collision with root package name */
    public long f64383c;

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64381a = new CountDownLatch(1);
        this.f64382b = -1L;
        this.f64383c = -1L;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f64382b == -1) {
                this.f64382b = System.nanoTime();
                return;
            }
            throw new IllegalStateException();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f64383c == -1 && this.f64382b != -1) {
                this.f64383c = System.nanoTime();
                this.f64381a.countDown();
                return;
            }
            throw new IllegalStateException();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f64383c == -1) {
                long j2 = this.f64382b;
                if (j2 != -1) {
                    this.f64383c = j2 - 1;
                    this.f64381a.countDown();
                    return;
                }
            }
            throw new IllegalStateException();
        }
    }
}
