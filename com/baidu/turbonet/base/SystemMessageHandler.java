package com.baidu.turbonet.base;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.repackage.n09;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes4.dex */
public class SystemMessageHandler extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final c a;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.turbonet.base.SystemMessageHandler$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0254a implements c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Method a;

            public C0254a() {
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
                try {
                    this.a = Class.forName("android.os.Message").getMethod("setAsynchronous", Boolean.TYPE);
                } catch (ClassNotFoundException e) {
                    n09.c("cr.SysMessageHandler", "Failed to find android.os.Message class", e);
                } catch (NoSuchMethodException e2) {
                    n09.c("cr.SysMessageHandler", "Failed to load Message.setAsynchronous method", e2);
                } catch (RuntimeException e3) {
                    n09.c("cr.SysMessageHandler", "Exception while loading Message.setAsynchronous method", e3);
                }
            }

            @Override // com.baidu.turbonet.base.SystemMessageHandler.a.c
            public void a(Message message, boolean z) {
                Method method;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLZ(1048576, this, message, z) == null) || (method = this.a) == null) {
                    return;
                }
                try {
                    method.invoke(message, Boolean.valueOf(z));
                } catch (IllegalAccessException unused) {
                    n09.c("cr.SysMessageHandler", "Illegal access to async message creation, disabling.", new Object[0]);
                    this.a = null;
                } catch (IllegalArgumentException unused2) {
                    n09.c("cr.SysMessageHandler", "Illegal argument for async message creation, disabling.", new Object[0]);
                    this.a = null;
                } catch (RuntimeException unused3) {
                    n09.c("cr.SysMessageHandler", "Runtime exception during async message creation, disabling.", new Object[0]);
                    this.a = null;
                } catch (InvocationTargetException unused4) {
                    n09.c("cr.SysMessageHandler", "Invocation exception during async message creation, disabling.", new Object[0]);
                    this.a = null;
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                a = new b();
            } else {
                a = new C0254a();
            }
        }

        public static void a(Message message, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65537, null, message, z) == null) {
                a.a(message, z);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0L;
        this.b = 0L;
        this.a = j;
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
            if (this.b != 0) {
                removeMessages(2);
            }
            this.b = j;
            sendMessageDelayed(a(2), j2);
        }
    }

    @CalledByNative
    private void scheduleWork() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            sendMessage(a(1));
        }
    }

    public final Message a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            Message obtain = Message.obtain();
            obtain.what = i;
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
                this.b = 0L;
            }
            nativeDoRunLoopOnce(this.a, this.b);
        }
    }
}
