package com.baidu.turbonet.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes10.dex */
public class JavaHandlerThread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HandlerThread f56371a;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f56372e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f56373f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JavaHandlerThread f56374g;

        public a(JavaHandlerThread javaHandlerThread, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {javaHandlerThread, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56374g = javaHandlerThread;
            this.f56372e = j;
            this.f56373f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56374g.nativeInitializeThread(this.f56372e, this.f56373f);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f56375e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f56376f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f56377g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JavaHandlerThread f56378h;

        public b(JavaHandlerThread javaHandlerThread, long j, long j2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {javaHandlerThread, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56378h = javaHandlerThread;
            this.f56375e = j;
            this.f56376f = j2;
            this.f56377g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56378h.nativeStopThread(this.f56375e, this.f56376f);
                if (this.f56377g) {
                    return;
                }
                this.f56378h.f56371a.quit();
            }
        }
    }

    public JavaHandlerThread(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56371a = new HandlerThread(str);
    }

    @CalledByNative
    public static JavaHandlerThread create(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? new JavaHandlerThread(str) : (JavaHandlerThread) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeInitializeThread(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeStopThread(long j, long j2);

    @CalledByNative
    private void start(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.f56371a.start();
            new Handler(this.f56371a.getLooper()).post(new a(this, j, j2));
        }
    }

    @CalledByNative
    @TargetApi(18)
    private void stop(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            boolean z = Build.VERSION.SDK_INT >= 18;
            new Handler(this.f56371a.getLooper()).post(new b(this, j, j2, z));
            if (z) {
                this.f56371a.quitSafely();
            }
        }
    }
}
