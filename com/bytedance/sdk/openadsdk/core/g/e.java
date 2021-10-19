package com.bytedance.sdk.openadsdk.core.g;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public abstract class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f66950a = "e";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Set<String> f66951b;

    /* renamed from: c  reason: collision with root package name */
    public Looper f66952c;

    /* renamed from: com.bytedance.sdk.openadsdk.core.g.e$5  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass5 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f66959a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(21316008, "Lcom/bytedance/sdk/openadsdk/core/g/e$5;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(21316008, "Lcom/bytedance/sdk/openadsdk/core/g/e$5;");
                    return;
                }
            }
            int[] iArr = new int[c.values().length];
            f66959a = iArr;
            try {
                iArr[c.f66940a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f66959a[c.f66941b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f66959a[c.f66942c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(268178329, "Lcom/bytedance/sdk/openadsdk/core/g/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(268178329, "Lcom/bytedance/sdk/openadsdk/core/g/e;");
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f66951b = new HashSet(1);
        this.f66952c = Looper.getMainLooper();
    }

    public abstract void a();

    public abstract void a(String str);

    public final synchronized boolean a(@NonNull String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i2)) == null) {
            synchronized (this) {
                if (i2 == 0) {
                    return a(str, c.f66940a);
                }
                return a(str, c.f66941b);
            }
        }
        return invokeLI.booleanValue;
    }

    public synchronized boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            synchronized (this) {
                String str2 = "Permission not found: " + str;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final synchronized boolean a(@NonNull String str, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, cVar)) == null) {
            synchronized (this) {
                this.f66951b.remove(str);
                int i2 = AnonymousClass5.f66959a[cVar.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        new Handler(this.f66952c).post(new Runnable(this, str) { // from class: com.bytedance.sdk.openadsdk.core.g.e.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ String f66954a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ e f66955b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, str};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f66955b = this;
                                this.f66954a = str;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    this.f66955b.a(this.f66954a);
                                }
                            }
                        });
                        return true;
                    } else if (i2 == 3) {
                        if (b(str)) {
                            if (this.f66951b.isEmpty()) {
                                new Handler(this.f66952c).post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.g.e.3
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ e f66956a;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f66956a = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                            this.f66956a.a();
                                        }
                                    }
                                });
                                return true;
                            }
                        } else {
                            new Handler(this.f66952c).post(new Runnable(this, str) { // from class: com.bytedance.sdk.openadsdk.core.g.e.4
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ String f66957a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ e f66958b;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, str};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f66958b = this;
                                    this.f66957a = str;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        this.f66958b.a(this.f66957a);
                                    }
                                }
                            });
                            return true;
                        }
                    }
                } else if (this.f66951b.isEmpty()) {
                    new Handler(this.f66952c).post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.g.e.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ e f66953a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f66953a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.f66953a.a();
                            }
                        }
                    });
                    return true;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final synchronized void a(@NonNull String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr) == null) {
            synchronized (this) {
                Collections.addAll(this.f66951b, strArr);
            }
        }
    }
}
