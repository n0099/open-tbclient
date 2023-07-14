package com.baidu.tieba;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(16)
/* loaded from: classes8.dex */
public class wt5 implements Choreographer.FrameCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public long c;
    public int d;
    public int e;
    public boolean f;

    public wt5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.d = 0;
        this.e = -1;
        this.f = false;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.c = currentTimeMillis;
            this.b = currentTimeMillis + 1000;
            this.a = 0L;
            this.d = 0;
            this.e = -1;
            this.f = false;
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f = true;
            Choreographer.getInstance().removeFrameCallback(this);
            a(System.currentTimeMillis());
            this.d = 0;
            this.c = 0L;
        }
    }

    public final void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            long j2 = this.c;
            if (j2 <= 0) {
                return;
            }
            long j3 = j - j2;
            if (j3 > 0 && this.e <= 0) {
                this.e = (int) (60 - ((this.d * 1000) / j3));
            }
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            long j2 = this.a;
            if (j2 != 0) {
                long j3 = (j - j2) / 1000000;
                if (j3 > 16 && j3 < 960) {
                    this.d = (int) (this.d + (j3 / 16));
                }
            }
            this.a = j;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < this.b && !this.f) {
                Choreographer.getInstance().postFrameCallback(this);
                return;
            }
            a(currentTimeMillis);
            this.d = 0;
            this.c = 0L;
        }
    }
}
