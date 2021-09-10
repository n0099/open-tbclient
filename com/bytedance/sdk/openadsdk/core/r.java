package com.bytedance.sdk.openadsdk.core;

import android.os.Build;
import android.os.Environment;
import android.os.FileObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes9.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f66995a;

    /* renamed from: b  reason: collision with root package name */
    public static String f66996b;

    /* renamed from: c  reason: collision with root package name */
    public static String f66997c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f66998d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f66999e;

    /* renamed from: f  reason: collision with root package name */
    public static b f67000f;

    /* renamed from: g  reason: collision with root package name */
    public static long f67001g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface a {
        void a(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(210335044, "Lcom/bytedance/sdk/openadsdk/core/r;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(210335044, "Lcom/bytedance/sdk/openadsdk/core/r;");
                return;
            }
        }
        f66995a = Environment.DIRECTORY_DCIM;
        f66996b = Environment.DIRECTORY_PICTURES;
        f66997c = "Screenshots";
        f66998d = false;
        f66999e = false;
        f67001g = 0L;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            f66999e = true;
            if (f66998d) {
                return;
            }
            if (Build.VERSION.SDK_INT < 23 || o.a().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                com.bytedance.sdk.component.d.e.c(new com.bytedance.sdk.component.d.g(AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO) { // from class: com.bytedance.sdk.openadsdk.core.r.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r7);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {r7};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((String) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            r.e();
                        }
                    }
                });
            }
        }
    }

    public static long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f67001g : invokeV.longValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) || f66998d) {
            return;
        }
        com.bytedance.sdk.component.utils.k.a("SSO start");
        File f2 = f();
        if (f2 == null) {
            return;
        }
        f67000f = b.a(f2, new a() { // from class: com.bytedance.sdk.openadsdk.core.r.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.r.a
            public void a(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                    long unused = r.f67001g = System.currentTimeMillis();
                    com.bytedance.sdk.component.utils.k.a("Update sso");
                }
            }
        });
        f66998d = true;
        StringBuilder sb = new StringBuilder();
        sb.append("SSO File exist: ");
        sb.append(f2.exists());
        sb.append(", has started: ");
        sb.append(f67000f != null);
        com.bytedance.sdk.component.utils.k.a(sb.toString());
        b bVar = f67000f;
        if (bVar != null) {
            bVar.startWatching();
        }
    }

    public static File f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            File file = null;
            if (Environment.getExternalStorageState().equals("mounted") && Build.VERSION.SDK_INT < 29) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (externalStorageDirectory == null) {
                    return null;
                }
                file = new File(externalStorageDirectory, f66996b + File.separator + f66997c);
                if (file.exists()) {
                    com.bytedance.sdk.component.utils.k.a("SSO use pic");
                    return file;
                }
                File file2 = new File(externalStorageDirectory, f66995a + File.separator + f66997c);
                if (file2.exists()) {
                    com.bytedance.sdk.component.utils.k.a("SSO use dc");
                    return file2;
                } else if (!com.bytedance.sdk.openadsdk.q.l.b() && !com.bytedance.sdk.openadsdk.q.l.t()) {
                    com.bytedance.sdk.component.utils.k.a("SSO use rom dc");
                    return file2;
                } else {
                    com.bytedance.sdk.component.utils.k.a("SSO use rom pic");
                }
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public static final class b extends FileObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public a f67002a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, int i2, a aVar) {
            super(str, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), aVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f67002a = aVar;
        }

        public static b a(@NonNull File file, a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, file, aVar)) == null) {
                if (file == null || aVar == null) {
                    return null;
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    return new b(file, 256, aVar);
                }
                return new b(file.getAbsolutePath(), 256, aVar);
            }
            return (b) invokeLL.objValue;
        }

        @Override // android.os.FileObserver
        public void onEvent(int i2, @Nullable String str) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) || (aVar = this.f67002a) == null) {
                return;
            }
            aVar.a(str);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NonNull File file, int i2, a aVar) {
            super(file, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {file, Integer.valueOf(i2), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((File) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67002a = aVar;
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && f66999e && !f66998d) {
            b();
        }
    }
}
