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
/* loaded from: classes4.dex */
public class JavaHandlerThread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HandlerThread f23172a;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f23173e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f23174f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JavaHandlerThread f23175g;

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
            this.f23175g = javaHandlerThread;
            this.f23173e = j;
            this.f23174f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23175g.nativeInitializeThread(this.f23173e, this.f23174f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f23176e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f23177f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f23178g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JavaHandlerThread f23179h;

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
            this.f23179h = javaHandlerThread;
            this.f23176e = j;
            this.f23177f = j2;
            this.f23178g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f23179h.nativeStopThread(this.f23176e, this.f23177f);
                if (this.f23178g) {
                    return;
                }
                this.f23179h.f23172a.quit();
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
        this.f23172a = new HandlerThread(str);
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
            this.f23172a.start();
            new Handler(this.f23172a.getLooper()).post(new a(this, j, j2));
        }
    }

    @CalledByNative
    @TargetApi(18)
    private void stop(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            boolean z = Build.VERSION.SDK_INT >= 18;
            new Handler(this.f23172a.getLooper()).post(new b(this, j, j2, z));
            if (z) {
                this.f23172a.quitSafely();
            }
        }
    }
}
