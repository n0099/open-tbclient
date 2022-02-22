package com.bun.miitmdid;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.core.CertChecker;
import com.bun.miitmdid.core.InfoCode;
import com.bun.miitmdid.interfaces.IIdProvider;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f53096b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f53097c;
    public transient /* synthetic */ FieldHolder $fh;
    public IIdentifierListener a;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2135478975, "Lcom/bun/miitmdid/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2135478975, "Lcom/bun/miitmdid/e$a;");
                    return;
                }
            }
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.f53093i.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.p.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.f53087c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c.s.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[c.f53092h.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[c.f53091g.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[c.k.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[c.l.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[c.f53090f.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[c.n.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[c.r.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[c.f53094j.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[c.f53089e.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[c.f53088d.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[c.o.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[c.m.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[c.q.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[c.t.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2134063330, "Lcom/bun/miitmdid/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2134063330, "Lcom/bun/miitmdid/e;");
        }
    }

    public e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        e0.a(z);
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return 20210301;
        }
        return invokeV.intValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        boolean verifyCert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            synchronized (e.class) {
                verifyCert = CertChecker.a().verifyCert(context, str);
                f53096b = verifyCert;
                f53097c = true;
            }
            return verifyCert;
        }
        return invokeLL.booleanValue;
    }

    public final int a(int i2, IdSupplier idSupplier) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, idSupplier)) == null) {
            e0.c("MainMdidSdk", "initResult: infoCode:" + i2);
            if (idSupplier instanceof IIdProvider) {
                ((IIdProvider) idSupplier).shutDown();
            }
            return i2;
        }
        return invokeIL.intValue;
    }

    public int a(Context context, IIdentifierListener iIdentifierListener) {
        InterceptResult invokeLL;
        IIdProvider iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, iIdentifierListener)) == null) {
            if (f53097c && f53096b) {
                this.a = iIdentifierListener;
                Context applicationContext = context.getApplicationContext();
                com.bun.miitmdid.a.a(applicationContext);
                StringBuilder sb = new StringBuilder();
                sb.append("OnInit: manufacturer: ");
                String str = Build.MANUFACTURER;
                sb.append(str);
                e0.c("MainMdidSdk", sb.toString());
                c a2 = c.a(str);
                c cVar = c.f53086b;
                if (a2 == cVar && (a2 = d.a(applicationContext)) == cVar) {
                    e0.d("MainMdidSdk", "OnInit: manufacturer not support");
                    return a(InfoCode.INIT_ERROR_MANUFACTURER_NOSUPPORT, (IdSupplier) null);
                }
                e0.c("MainMdidSdk", "OnInit: final manufacturer: " + a2);
                int a3 = f.a().a(applicationContext);
                if (a3 != 0) {
                    e0.d("MainMdidSdk", "OnInit: manufacturer (emulator " + a3 + " ) not support");
                    return a(InfoCode.INIT_ERROR_MANUFACTURER_NOSUPPORT, (IdSupplier) null);
                }
                b a4 = b.a(applicationContext);
                if (a4 == null) {
                    e0.d("MainMdidSdk", "OnInit: config file not loaded");
                    return a(InfoCode.INIT_ERROR_LOAD_CONFIGFILE, (IdSupplier) null);
                }
                switch (a.a[a2.ordinal()]) {
                    case 1:
                        iVar = new i(applicationContext);
                        break;
                    case 2:
                        iVar = new k(applicationContext);
                        break;
                    case 3:
                    case 4:
                        iVar = new o(applicationContext);
                        break;
                    case 5:
                    case 6:
                        iVar = new p(applicationContext);
                        break;
                    case 7:
                        iVar = new q(applicationContext);
                        break;
                    case 8:
                        iVar = new r(applicationContext);
                        break;
                    case 9:
                    case 10:
                    case 11:
                        iVar = new s(applicationContext);
                        break;
                    case 12:
                        iVar = new u(applicationContext);
                        break;
                    case 13:
                        iVar = new w(applicationContext, a4.getVivoAppID());
                        break;
                    case 14:
                    case 15:
                        iVar = new x(applicationContext);
                        break;
                    case 16:
                        iVar = new b0(applicationContext);
                        break;
                    case 17:
                        iVar = new t(applicationContext);
                        break;
                    case 18:
                        iVar = new j(applicationContext);
                        break;
                    default:
                        iVar = null;
                        break;
                }
                if (iVar == null) {
                    e0.d("MainMdidSdk", "OnInit: device not support");
                    return a(InfoCode.INIT_ERROR_DEVICE_NOSUPPORT, (IdSupplier) null);
                } else if (iVar.isSync()) {
                    e0.c("MainMdidSdk", "OnInit: " + iVar.getClass().getSimpleName() + ": Sync mode");
                    iVar.doStartSync(iIdentifierListener);
                    e0.c("MainMdidSdk", "OnInit: result ok");
                    return a(InfoCode.INIT_INFO_RESULT_OK, iVar);
                } else {
                    e0.c("MainMdidSdk", "OnInit: " + iVar.getClass().getSimpleName() + ": Async mode");
                    iVar.doStartInThreadPool(iIdentifierListener);
                    e0.c("MainMdidSdk", "OnInit: result delay");
                    return a(InfoCode.INIT_INFO_RESULT_DELAY, (IdSupplier) null);
                }
            }
            return a(InfoCode.INIT_ERROR_CERT_ERROR, (IdSupplier) null);
        }
        return invokeLL.intValue;
    }
}
