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
/* loaded from: classes5.dex */
public class JavaHandlerThread {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HandlerThread f22904a;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f22905e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f22906f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JavaHandlerThread f22907g;

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
            this.f22907g = javaHandlerThread;
            this.f22905e = j;
            this.f22906f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22907g.nativeInitializeThread(this.f22905e, this.f22906f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f22908e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f22909f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f22910g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JavaHandlerThread f22911h;

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
            this.f22911h = javaHandlerThread;
            this.f22908e = j;
            this.f22909f = j2;
            this.f22910g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22911h.nativeStopThread(this.f22908e, this.f22909f);
                if (this.f22910g) {
                    return;
                }
                this.f22911h.f22904a.quit();
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
        this.f22904a = new HandlerThread(str);
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
            this.f22904a.start();
            new Handler(this.f22904a.getLooper()).post(new a(this, j, j2));
        }
    }

    @CalledByNative
    @TargetApi(18)
    private void stop(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            boolean z = Build.VERSION.SDK_INT >= 18;
            new Handler(this.f22904a.getLooper()).post(new b(this, j, j2, z));
            if (z) {
                this.f22904a.quitSafely();
            }
        }
    }
}
