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
/* loaded from: classes8.dex */
public class JavaHandlerThread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HandlerThread f59437a;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f59438e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f59439f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JavaHandlerThread f59440g;

        public a(JavaHandlerThread javaHandlerThread, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {javaHandlerThread, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59440g = javaHandlerThread;
            this.f59438e = j2;
            this.f59439f = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59440g.nativeInitializeThread(this.f59438e, this.f59439f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f59441e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f59442f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f59443g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JavaHandlerThread f59444h;

        public b(JavaHandlerThread javaHandlerThread, long j2, long j3, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {javaHandlerThread, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59444h = javaHandlerThread;
            this.f59441e = j2;
            this.f59442f = j3;
            this.f59443g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59444h.nativeStopThread(this.f59441e, this.f59442f);
                if (this.f59443g) {
                    return;
                }
                this.f59444h.f59437a.quit();
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
        this.f59437a = new HandlerThread(str);
    }

    @CalledByNative
    public static JavaHandlerThread create(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? new JavaHandlerThread(str) : (JavaHandlerThread) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeInitializeThread(long j2, long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeStopThread(long j2, long j3);

    @CalledByNative
    private void start(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.f59437a.start();
            new Handler(this.f59437a.getLooper()).post(new a(this, j2, j3));
        }
    }

    @CalledByNative
    @TargetApi(18)
    private void stop(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            boolean z = Build.VERSION.SDK_INT >= 18;
            new Handler(this.f59437a.getLooper()).post(new b(this, j2, j3, z));
            if (z) {
                this.f59437a.quitSafely();
            }
        }
    }
}
