package com.baidu.turbonet.base;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.annotations.CalledByNative;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class SystemMessageHandler extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f23027a;

    /* renamed from: b  reason: collision with root package name */
    public long f23028b;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final c f23029a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.turbonet.base.SystemMessageHandler$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0247a implements c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public Method f23030a;

            public C0247a() {
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
                try {
                    this.f23030a = Class.forName("android.os.Message").getMethod("setAsynchronous", Boolean.TYPE);
                } catch (ClassNotFoundException e2) {
                    d.a.q0.a.a.c("cr.SysMessageHandler", "Failed to find android.os.Message class", e2);
                } catch (NoSuchMethodException e3) {
                    d.a.q0.a.a.c("cr.SysMessageHandler", "Failed to load Message.setAsynchronous method", e3);
                } catch (RuntimeException e4) {
                    d.a.q0.a.a.c("cr.SysMessageHandler", "Exception while loading Message.setAsynchronous method", e4);
                }
            }

            @Override // com.baidu.turbonet.base.SystemMessageHandler.a.c
            public void a(Message message, boolean z) {
                Method method;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLZ(1048576, this, message, z) == null) || (method = this.f23030a) == null) {
                    return;
                }
                try {
                    method.invoke(message, Boolean.valueOf(z));
                } catch (IllegalAccessException unused) {
                    d.a.q0.a.a.c("cr.SysMessageHandler", "Illegal access to async message creation, disabling.", new Object[0]);
                    this.f23030a = null;
                } catch (IllegalArgumentException unused2) {
                    d.a.q0.a.a.c("cr.SysMessageHandler", "Illegal argument for async message creation, disabling.", new Object[0]);
                    this.f23030a = null;
                } catch (RuntimeException unused3) {
                    d.a.q0.a.a.c("cr.SysMessageHandler", "Runtime exception during async message creation, disabling.", new Object[0]);
                    this.f23030a = null;
                } catch (InvocationTargetException unused4) {
                    d.a.q0.a.a.c("cr.SysMessageHandler", "Invocation exception during async message creation, disabling.", new Object[0]);
                    this.f23030a = null;
                }
            }
        }

        /* loaded from: classes4.dex */
        public static class b implements c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.turbonet.base.SystemMessageHandler.a.c
            @SuppressLint({"NewApi"})
            public void a(Message message, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLZ(1048576, this, message, z) == null) {
                    message.setAsynchronous(z);
                }
            }
        }

        /* loaded from: classes4.dex */
        public interface c {
            void a(Message message, boolean z);
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1878788560, "Lcom/baidu/turbonet/base/SystemMessageHandler$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1878788560, "Lcom/baidu/turbonet/base/SystemMessageHandler$a;");
                    return;
                }
            }
            if (Build.VERSION.SDK_INT >= 22) {
                f23029a = new b();
            } else {
                f23029a = new C0247a();
            }
        }

        public static void a(Message message, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65537, null, message, z) == null) {
                f23029a.a(message, z);
            }
        }
    }

    public SystemMessageHandler(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f23027a = 0L;
        this.f23028b = 0L;
        this.f23027a = j;
    }

    @CalledByNative
    public static SystemMessageHandler create(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) ? new SystemMessageHandler(j) : (SystemMessageHandler) invokeJ.objValue;
    }

    private native void nativeDoRunLoopOnce(long j, long j2);

    @CalledByNative
    private void removeAllPendingMessages() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            removeMessages(1);
            removeMessages(2);
        }
    }

    @CalledByNative
    private void scheduleDelayedWork(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (this.f23028b != 0) {
                removeMessages(2);
            }
            this.f23028b = j;
            sendMessageDelayed(a(2), j2);
        }
    }

    @CalledByNative
    private void scheduleWork() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            sendMessage(a(1));
        }
    }

    public final Message a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            Message obtain = Message.obtain();
            obtain.what = i2;
            a.a(obtain, true);
            return obtain;
        }
        return (Message) invokeI.objValue;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
            if (message.what == 2) {
                this.f23028b = 0L;
            }
            nativeDoRunLoopOnce(this.f23027a, this.f23028b);
        }
    }
}
