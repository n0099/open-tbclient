package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
/* loaded from: classes7.dex */
public class zf {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean e = true;
    public transient /* synthetic */ FieldHolder $fh;
    public cg a;
    public yf b;
    public int c;
    public long d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448323585, "Lcom/baidu/tieba/zf;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448323585, "Lcom/baidu/tieba/zf;");
        }
    }

    public final boolean l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? (i == 502 || i == 503 || i == 504 || i == 404) ? false : true : invokeI.booleanValue;
    }

    public zf(cg cgVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cgVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = 0;
        this.d = 0L;
        this.a = cgVar;
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            try {
                if (this.a != null && i > 0) {
                    this.a.b().a("Retry-Count", String.valueOf(i));
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void b() {
        yf yfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (yfVar = this.b) != null) {
            yfVar.b();
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            yf yfVar = this.b;
            if (yfVar == null) {
                return -1L;
            }
            return yfVar.e();
        }
        return invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            yf yfVar = this.b;
            if (yfVar == null) {
                return -1L;
            }
            return yfVar.h();
        }
        return invokeV.longValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long j = this.d;
            if (j > 0) {
                return j;
            }
            yf yfVar = this.b;
            if (yfVar == null) {
                return -1L;
            }
            return yfVar.i();
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            yf yfVar = this.b;
            if (yfVar == null) {
                return -1L;
            }
            return yfVar.l();
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            yf yfVar = this.b;
            if (yfVar == null) {
                return -1L;
            }
            return yfVar.j();
        }
        return invokeV.longValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            cg cgVar = this.a;
            if (cgVar == null) {
                return false;
            }
            return cgVar.c().a;
        }
        return invokeV.booleanValue;
    }

    public void p() {
        cg cgVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || (cgVar = this.a) == null) {
            return;
        }
        cgVar.c().a = true;
    }

    public boolean c(String str, gg ggVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        int i7;
        bg bgVar;
        int i8;
        int i9;
        String str2;
        int i10;
        bg bgVar2;
        String str3;
        StringBuilder sb;
        StringBuilder sb2;
        bg bgVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, ggVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String str4 = "responseCode:";
            if (i3 <= 0) {
                i5 = ac.d().b().b();
            } else {
                i5 = i3;
            }
            if (i <= 0) {
                i6 = ac.d().a();
            } else {
                i6 = i;
            }
            if (i4 <= 0) {
                i7 = ac.d().c().b();
            } else {
                i7 = i4;
            }
            yf yfVar = new yf(this.a);
            this.b = yfVar;
            yfVar.r(e);
            int i11 = 0;
            boolean z3 = false;
            while (i11 < i6) {
                bg bgVar4 = new bg();
                this.a.c().c = -1;
                this.b.q(i11);
                int i12 = i11 + 1;
                try {
                    try {
                        bgVar4.e = i12;
                        try {
                            this.c = i11;
                            a(i11);
                            str2 = str4;
                            i10 = i12;
                            i8 = i11;
                            i9 = i6;
                        } catch (IllegalStateException e2) {
                            e = e2;
                            str2 = str4;
                            i10 = i12;
                            bgVar2 = bgVar4;
                            i8 = i11;
                            i9 = i6;
                        } catch (ConnectException e3) {
                            e = e3;
                            str2 = str4;
                            i10 = i12;
                            bgVar2 = bgVar4;
                            i8 = i11;
                            i9 = i6;
                        } catch (SocketException e4) {
                            e = e4;
                            str2 = str4;
                            i10 = i12;
                            bgVar2 = bgVar4;
                            i8 = i11;
                            i9 = i6;
                        } catch (SocketTimeoutException e5) {
                            e = e5;
                            str2 = str4;
                            i10 = i12;
                            bgVar2 = bgVar4;
                            i8 = i11;
                            i9 = i6;
                        }
                    } catch (IllegalStateException e6) {
                        e = e6;
                        str3 = str4;
                        i10 = i12;
                        bgVar2 = bgVar4;
                        i8 = i11;
                        i9 = i6;
                    } catch (ConnectException e7) {
                        e = e7;
                        str3 = str4;
                        i10 = i12;
                        bgVar2 = bgVar4;
                        i8 = i11;
                        i9 = i6;
                    } catch (SocketException e8) {
                        e = e8;
                        str3 = str4;
                        i10 = i12;
                        bgVar2 = bgVar4;
                        i8 = i11;
                        i9 = i6;
                    } catch (SocketTimeoutException e9) {
                        e = e9;
                        str3 = str4;
                        i10 = i12;
                        bgVar2 = bgVar4;
                        i8 = i11;
                        i9 = i6;
                    }
                } catch (FileNotFoundException e10) {
                    e = e10;
                    str2 = str4;
                    i10 = i12;
                    bgVar2 = bgVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (UnknownHostException e11) {
                    e = e11;
                    str2 = str4;
                    i10 = i12;
                    bgVar = bgVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (SSLException e12) {
                    e = e12;
                    str2 = str4;
                    i10 = i12;
                    bgVar = bgVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (IOException e13) {
                    e = e13;
                    str2 = str4;
                    i10 = i12;
                    bgVar = bgVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (Exception e14) {
                    e = e14;
                    str2 = str4;
                    i10 = i12;
                    bgVar = bgVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (Throwable th) {
                    th = th;
                    bgVar = bgVar4;
                    i8 = i11;
                    i9 = i6;
                }
                try {
                    z3 = this.b.d(str, ggVar, i5, i7, z, bgVar4, z2);
                    if (!z3 && this.a.c().a) {
                        this.a.c().c = -14;
                    }
                    if (!z3 && i8 == i9 - 1) {
                        StringBuilder sb3 = new StringBuilder();
                        bgVar3 = bgVar4;
                        sb3.append(bgVar3.h);
                        sb3.append("|netAvailable:");
                        sb3.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bgVar3.h = sb3.toString();
                    } else {
                        bgVar3 = bgVar4;
                    }
                    this.a.e(bgVar3);
                    return z3;
                } catch (FileNotFoundException e15) {
                    e = e15;
                    bgVar2 = bgVar4;
                    StringBuilder sb4 = new StringBuilder();
                    str3 = str2;
                    sb4.append(str3);
                    sb4.append(String.valueOf(this.a.c().b));
                    sb4.append("|retryCount:");
                    sb4.append(i8);
                    sb4.append("|");
                    sb4.append(e.getClass().getName());
                    sb4.append("|");
                    sb4.append(e.getMessage());
                    bgVar2.h = sb4.toString();
                    this.a.c().c = -100;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(bgVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bgVar2.h = sb2.toString();
                    }
                    this.a.e(bgVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (IllegalStateException e16) {
                    e = e16;
                    bgVar2 = bgVar4;
                    str3 = str2;
                    bgVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                    this.a.c().c = -19;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(bgVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bgVar2.h = sb2.toString();
                    }
                    this.a.e(bgVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (ConnectException e17) {
                    e = e17;
                    bgVar2 = bgVar4;
                    str3 = str2;
                    bgVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -22;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(bgVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bgVar2.h = sb2.toString();
                    }
                    this.a.e(bgVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SocketException e18) {
                    e = e18;
                    bgVar2 = bgVar4;
                    str3 = str2;
                    bgVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -12;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(bgVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bgVar2.h = sb2.toString();
                    }
                    this.a.e(bgVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SocketTimeoutException e19) {
                    e = e19;
                    bgVar2 = bgVar4;
                    str3 = str2;
                    bgVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -13;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(bgVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bgVar2.h = sb2.toString();
                    }
                    this.a.e(bgVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (UnknownHostException e20) {
                    e = e20;
                    bgVar = bgVar4;
                    bgVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -21;
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(bgVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bgVar.h = sb.toString();
                    }
                    this.a.e(bgVar);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SSLException e21) {
                    e = e21;
                    bgVar = bgVar4;
                    if (this.a.b().e() && i8 < i9 - 1) {
                        BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                    } else {
                        bgVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -20;
                    }
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(bgVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bgVar.h = sb.toString();
                    }
                    this.a.e(bgVar);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (IOException e22) {
                    e = e22;
                    bgVar = bgVar4;
                    bgVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -19;
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(bgVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bgVar.h = sb.toString();
                    }
                    this.a.e(bgVar);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (Exception e23) {
                    e = e23;
                    bgVar = bgVar4;
                    try {
                        bgVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -10;
                        BdLog.e(e.getMessage());
                        if (!z3 && i8 == i9 - 1) {
                            sb = new StringBuilder();
                            sb.append(bgVar.h);
                            sb.append("|netAvailable:");
                            sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                            bgVar.h = sb.toString();
                        }
                        this.a.e(bgVar);
                        str3 = str2;
                        str4 = str3;
                        i11 = i10;
                        i6 = i9;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!z3 && i8 == i9 - 1) {
                            bgVar.h += "|netAvailable:" + BdNetTypeUtil.isNetworkAvailableForImmediately();
                        }
                        this.a.e(bgVar);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bgVar = bgVar4;
                    if (!z3) {
                        bgVar.h += "|netAvailable:" + BdNetTypeUtil.isNetworkAvailableForImmediately();
                    }
                    this.a.e(bgVar);
                    throw th;
                }
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0226, code lost:
        if (r0 != null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x02eb, code lost:
        if (r0 != null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0343, code lost:
        if (r0 != null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0345, code lost:
        r22.d = r0.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0178, code lost:
        if (r0 != null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x017a, code lost:
        r22.d = r0.i();
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0341  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        boolean z2;
        jg jgVar;
        bg bgVar;
        int i9;
        yf yfVar;
        yf yfVar2;
        yf yfVar3;
        yf yfVar4;
        boolean z3;
        boolean z4;
        yf yfVar5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i4 = ac.d().b().b();
            } else {
                i4 = i2;
            }
            if (i <= 0) {
                i5 = ac.d().a();
            } else {
                i5 = i;
            }
            if (i3 <= 0) {
                i6 = ac.d().c().b();
            } else {
                i6 = i3;
            }
            if (((wf) ServiceManager.getService(wf.a)).isSwitchOn()) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if (((xf) ServiceManager.getService(xf.a)).qaHttpsTest()) {
                i8 = 0;
            } else {
                i8 = i7;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i10 = 1;
            int i11 = 0;
            boolean z5 = true;
            while (!this.a.c().a && z5 && i11 < i5 + i8) {
                bg bgVar2 = new bg();
                this.a.e(bgVar2);
                jg jgVar2 = new jg();
                dg b = this.a.b();
                if (i11 < i8) {
                    z = true;
                } else {
                    z = false;
                }
                jgVar2.a = b.k(z);
                if (i11 < i8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                jgVar2.d = z2;
                try {
                    this.c = i11;
                    bgVar2.e = i11 + 1;
                    bgVar2.v = i10;
                    a(i11);
                    yf yfVar6 = new yf(this.a);
                    this.b = yfVar6;
                    yfVar6.q(i11);
                    this.b.r(e);
                    yf yfVar7 = this.b;
                    if (i11 < i8) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (i11 < i10) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    i9 = i11;
                    try {
                        yfVar7.k(z3, z4, i4, i6, bgVar2, jgVar2);
                    } catch (SocketException e2) {
                        e = e2;
                        jgVar = jgVar2;
                        bgVar = bgVar2;
                    } catch (SocketTimeoutException e3) {
                        e = e3;
                        jgVar = jgVar2;
                        bgVar = bgVar2;
                    } catch (IOException e4) {
                        e = e4;
                        jgVar = jgVar2;
                        bgVar = bgVar2;
                    } catch (Exception e5) {
                        e = e5;
                        jgVar = jgVar2;
                        bgVar = bgVar2;
                    } catch (Throwable th) {
                        th = th;
                        jgVar = jgVar2;
                        bgVar = bgVar2;
                    }
                } catch (SocketException e6) {
                    e = e6;
                    jgVar = jgVar2;
                    bgVar = bgVar2;
                    i9 = i11;
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    jgVar = jgVar2;
                    bgVar = bgVar2;
                    i9 = i11;
                } catch (IOException e8) {
                    e = e8;
                    jgVar = jgVar2;
                    bgVar = bgVar2;
                    i9 = i11;
                } catch (Exception e9) {
                    e = e9;
                    jgVar = jgVar2;
                    bgVar = bgVar2;
                    i9 = i11;
                } catch (Throwable th2) {
                    th = th2;
                    jgVar = jgVar2;
                    bgVar = bgVar2;
                }
                if (this.a.c().b != 200) {
                    bgVar = bgVar2;
                    try {
                        bgVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9;
                        z5 = l(this.a.c().b);
                        jgVar = jgVar2;
                        try {
                            try {
                                try {
                                    jgVar.b = this.a.c().b;
                                    jgVar.c = "faild";
                                    if (this.d <= 0 && (yfVar5 = this.b) != null) {
                                        this.d = yfVar5.i();
                                    }
                                    bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.f(bgVar);
                                    jgVar.a();
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (this.d <= 0 && (yfVar4 = this.b) != null) {
                                        this.d = yfVar4.i();
                                    }
                                    bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.f(bgVar);
                                    jgVar.a();
                                    throw th;
                                }
                            } catch (Exception e10) {
                                e = e10;
                            }
                        } catch (SocketException e11) {
                            e = e11;
                            bgVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -12;
                            jgVar.b = -12;
                            jgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(bgVar);
                            jgVar.a();
                            z5 = true;
                            i11 = i9 + 1;
                            i10 = 1;
                        } catch (SocketTimeoutException e12) {
                            e = e12;
                            bgVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -13;
                            jgVar.b = -13;
                            jgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(bgVar);
                            jgVar.a();
                            z5 = true;
                            i11 = i9 + 1;
                            i10 = 1;
                        } catch (IOException e13) {
                            e = e13;
                            this.a.c().c = -19;
                            bgVar.h = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            jgVar.b = -19;
                            jgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                this.d = yfVar.i();
                            }
                            bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(bgVar);
                            jgVar.a();
                            i11 = i9 + 1;
                            i10 = 1;
                        }
                    } catch (SocketException e14) {
                        e = e14;
                        jgVar = jgVar2;
                    } catch (SocketTimeoutException e15) {
                        e = e15;
                        jgVar = jgVar2;
                    } catch (IOException e16) {
                        e = e16;
                        jgVar = jgVar2;
                    } catch (Exception e17) {
                        e = e17;
                        jgVar = jgVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        jgVar = jgVar2;
                    }
                    i11 = i9 + 1;
                    i10 = 1;
                } else {
                    jgVar = jgVar2;
                    bgVar = bgVar2;
                    this.a.f(bgVar);
                    try {
                        jgVar.b = 0;
                        jgVar.c = DnsModel.MSG_OK;
                        if (this.d <= 0) {
                            yfVar3 = this.b;
                        }
                        bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(bgVar);
                        jgVar.a();
                        return;
                    } catch (SocketException e18) {
                        e = e18;
                        bgVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.c().c = -12;
                        jgVar.b = -12;
                        jgVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                            yfVar2 = this.b;
                        }
                        bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(bgVar);
                        jgVar.a();
                        z5 = true;
                        i11 = i9 + 1;
                        i10 = 1;
                    } catch (SocketTimeoutException e19) {
                        e = e19;
                        bgVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.c().c = -13;
                        jgVar.b = -13;
                        jgVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                            yfVar2 = this.b;
                        }
                        bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(bgVar);
                        jgVar.a();
                        z5 = true;
                        i11 = i9 + 1;
                        i10 = 1;
                    } catch (IOException e20) {
                        e = e20;
                        this.a.c().c = -19;
                        bgVar.h = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        jgVar.b = -19;
                        jgVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0 && (yfVar = this.b) != null) {
                            this.d = yfVar.i();
                        }
                        bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(bgVar);
                        jgVar.a();
                        i11 = i9 + 1;
                        i10 = 1;
                    }
                }
                e = e10;
                bgVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                this.a.c().c = -10;
                BdLog.e(e.getMessage());
                jgVar.b = -10;
                jgVar.c = Log.getStackTraceString(e);
                if (this.d <= 0) {
                    yfVar3 = this.b;
                }
                bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                this.a.f(bgVar);
                jgVar.a();
                return;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CMP_L]}, finally: {[IGET, CMP_L, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, INVOKE, IPUT, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF, IGET, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0241, code lost:
        if (r0 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02a9, code lost:
        if (r0 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02ab, code lost:
        r20.d = r0.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0328, code lost:
        if (r0 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0390, code lost:
        if (r0 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0392, code lost:
        r20.d = r0.i();
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        boolean z2;
        int i9;
        jg jgVar;
        bg bgVar;
        int i10;
        int i11;
        int i12;
        int i13;
        yf yfVar;
        yf yfVar2;
        boolean z3;
        yf yfVar3;
        boolean z4;
        boolean z5;
        yf yfVar4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048589, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i4 = ac.d().b().b();
            } else {
                i4 = i2;
            }
            if (i <= 0) {
                i5 = ac.d().a();
            } else {
                i5 = i;
            }
            if (i3 <= 0) {
                i6 = ac.d().c().b();
            } else {
                i6 = i3;
            }
            if (((wf) ServiceManager.getService(wf.a)).isSwitchOn()) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if (((xf) ServiceManager.getService(xf.a)).qaHttpsTest()) {
                i8 = 0;
            } else {
                i8 = i7;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i14 = 1;
            boolean z6 = true;
            int i15 = 0;
            while (!this.a.c().a && z6 && i15 < i5 + i8) {
                bg bgVar2 = new bg();
                jg jgVar2 = new jg();
                dg b = this.a.b();
                if (i15 < i8) {
                    z = true;
                } else {
                    z = false;
                }
                jgVar2.a = b.k(z);
                if (i15 < i8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                jgVar2.d = z2;
                this.c = i15;
                int i16 = i15 + 1;
                bgVar2.e = i16;
                a(i15);
                try {
                    try {
                        try {
                            yf yfVar5 = new yf(this.a);
                            this.b = yfVar5;
                            yfVar5.q(i15);
                            this.b.r(e);
                            yf yfVar6 = this.b;
                            if (i15 < i8) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (i15 < i14) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            i9 = i16;
                            i12 = i15;
                            try {
                                yfVar6.p(z4, z5, i4, i6, bgVar2, jgVar2);
                            } catch (UnsupportedOperationException e2) {
                                e = e2;
                                jgVar = jgVar2;
                                bgVar = bgVar2;
                            } catch (SocketException e3) {
                                e = e3;
                                jgVar = jgVar2;
                                bgVar = bgVar2;
                            } catch (SocketTimeoutException e4) {
                                e = e4;
                                jgVar = jgVar2;
                                bgVar = bgVar2;
                            } catch (Throwable th) {
                                th = th;
                                jgVar = jgVar2;
                                bgVar = bgVar2;
                            }
                        } catch (UnsupportedOperationException e5) {
                            e = e5;
                            i9 = i16;
                            jgVar = jgVar2;
                            bgVar = bgVar2;
                            i12 = i15;
                        } catch (SocketException e6) {
                            e = e6;
                            i9 = i16;
                            jgVar = jgVar2;
                            bgVar = bgVar2;
                        } catch (SocketTimeoutException e7) {
                            e = e7;
                            i9 = i16;
                            jgVar = jgVar2;
                            bgVar = bgVar2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i9 = i16;
                        jgVar = jgVar2;
                        bgVar = bgVar2;
                        i12 = i15;
                    }
                } catch (UnsupportedOperationException e8) {
                    e = e8;
                    i9 = i16;
                    jgVar = jgVar2;
                    bgVar = bgVar2;
                    i12 = i15;
                    i13 = R.string.obfuscated_res_0x7f0f0cd1;
                } catch (SocketException e9) {
                    e = e9;
                    i9 = i16;
                    jgVar = jgVar2;
                    bgVar = bgVar2;
                    i11 = R.string.obfuscated_res_0x7f0f0cd1;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                    i9 = i16;
                    jgVar = jgVar2;
                    bgVar = bgVar2;
                    i10 = R.string.obfuscated_res_0x7f0f0cd1;
                }
                if (this.a.c().b != 200) {
                    bgVar = bgVar2;
                    try {
                        bgVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i12;
                        z6 = l(this.a.c().b);
                        this.a.e(bgVar);
                        jgVar = jgVar2;
                        try {
                            try {
                                jgVar.b = this.a.c().b;
                                jgVar.c = "faild";
                                if (this.d <= 0 && (yfVar4 = this.b) != null) {
                                    this.d = yfVar4.i();
                                }
                                bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(bgVar);
                                jgVar.a();
                            } catch (UnsupportedOperationException e11) {
                                e = e11;
                                i13 = R.string.obfuscated_res_0x7f0f0cd1;
                                if (i12 >= i8) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                this.a.c().c = -14;
                                eg c = this.a.c();
                                c.g = e.getMessage() + Log.getStackTraceString(e);
                                bgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                                this.a.e(bgVar);
                                jgVar.b = -14;
                                jgVar.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    yfVar3 = this.b;
                                }
                                bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(bgVar);
                                jgVar.a();
                                z6 = z3;
                                i15 = i9;
                                i14 = 1;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    this.a.c().c = -10;
                                    eg c2 = this.a.c();
                                    c2.g = th.getMessage() + Log.getStackTraceString(th);
                                    if (i12 >= i8) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    bgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0cd1);
                                    BdLog.e(th.getMessage());
                                    this.a.e(bgVar);
                                    jgVar.b = -10;
                                    jgVar.c = Log.getStackTraceString(th);
                                    if (this.d <= 0) {
                                        yfVar3 = this.b;
                                    }
                                    bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(bgVar);
                                    jgVar.a();
                                    z6 = z3;
                                    i15 = i9;
                                    i14 = 1;
                                } finally {
                                    if (this.d <= 0 && (yfVar2 = this.b) != null) {
                                        this.d = yfVar2.i();
                                    }
                                    bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(bgVar);
                                    jgVar.a();
                                }
                            }
                        } catch (SocketException e12) {
                            e = e12;
                            i11 = R.string.obfuscated_res_0x7f0f0cd1;
                            this.a.c().c = -12;
                            eg c3 = this.a.c();
                            c3.g = e.getMessage() + Log.getStackTraceString(e);
                            bgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i11);
                            BdLog.e(e.getMessage());
                            this.a.e(bgVar);
                            jgVar.b = -12;
                            jgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                yfVar = this.b;
                            }
                            bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(bgVar);
                            jgVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        } catch (SocketTimeoutException e13) {
                            e = e13;
                            i10 = R.string.obfuscated_res_0x7f0f0cd1;
                            this.a.c().c = -13;
                            eg c4 = this.a.c();
                            c4.g = e.getMessage() + Log.getStackTraceString(e);
                            bgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i10);
                            BdLog.e(e.getMessage());
                            this.a.e(bgVar);
                            jgVar.b = -13;
                            jgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                yfVar = this.b;
                            }
                            bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(bgVar);
                            jgVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        }
                    } catch (UnsupportedOperationException e14) {
                        e = e14;
                        jgVar = jgVar2;
                    } catch (SocketException e15) {
                        e = e15;
                        jgVar = jgVar2;
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        jgVar = jgVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        jgVar = jgVar2;
                    }
                    i15 = i9;
                    i14 = 1;
                } else {
                    jgVar = jgVar2;
                    bgVar = bgVar2;
                    try {
                        jgVar.b = 0;
                        jgVar.c = DnsModel.MSG_OK;
                        return;
                    } catch (UnsupportedOperationException e17) {
                        e = e17;
                        i13 = R.string.obfuscated_res_0x7f0f0cd1;
                        if (i12 >= i8) {
                        }
                        this.a.c().c = -14;
                        eg c5 = this.a.c();
                        c5.g = e.getMessage() + Log.getStackTraceString(e);
                        bgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                        this.a.e(bgVar);
                        jgVar.b = -14;
                        jgVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                        }
                        bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(bgVar);
                        jgVar.a();
                        z6 = z3;
                        i15 = i9;
                        i14 = 1;
                    } catch (Throwable th5) {
                        th = th5;
                        this.a.c().c = -10;
                        eg c22 = this.a.c();
                        c22.g = th.getMessage() + Log.getStackTraceString(th);
                        if (i12 >= i8) {
                        }
                        bgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0cd1);
                        BdLog.e(th.getMessage());
                        this.a.e(bgVar);
                        jgVar.b = -10;
                        jgVar.c = Log.getStackTraceString(th);
                        if (this.d <= 0) {
                        }
                        bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(bgVar);
                        jgVar.a();
                        z6 = z3;
                        i15 = i9;
                        i14 = 1;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CMP_L]}, finally: {[IGET, CMP_L, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, INVOKE, IPUT, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF, IGET, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0241, code lost:
        if (r0 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02a9, code lost:
        if (r0 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02ab, code lost:
        r20.d = r0.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0328, code lost:
        if (r0 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0390, code lost:
        if (r0 != null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0392, code lost:
        r20.d = r0.i();
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        boolean z2;
        int i9;
        jg jgVar;
        bg bgVar;
        int i10;
        int i11;
        int i12;
        int i13;
        yf yfVar;
        yf yfVar2;
        boolean z3;
        yf yfVar3;
        boolean z4;
        boolean z5;
        yf yfVar4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048590, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i4 = ac.d().b().b();
            } else {
                i4 = i2;
            }
            if (i <= 0) {
                i5 = ac.d().a();
            } else {
                i5 = i;
            }
            if (i3 <= 0) {
                i6 = ac.d().c().b();
            } else {
                i6 = i3;
            }
            if (((wf) ServiceManager.getService(wf.a)).isSwitchOn()) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if (((xf) ServiceManager.getService(xf.a)).qaHttpsTest()) {
                i8 = 0;
            } else {
                i8 = i7;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i14 = 1;
            boolean z6 = true;
            int i15 = 0;
            while (!this.a.c().a && z6 && i15 < i5 + i8) {
                bg bgVar2 = new bg();
                jg jgVar2 = new jg();
                dg b = this.a.b();
                if (i15 < i8) {
                    z = true;
                } else {
                    z = false;
                }
                jgVar2.a = b.k(z);
                if (i15 < i8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                jgVar2.d = z2;
                int i16 = i15 + 1;
                bgVar2.e = i16;
                this.c = i15;
                a(i15);
                try {
                    try {
                        try {
                            yf yfVar5 = new yf(this.a);
                            this.b = yfVar5;
                            yfVar5.q(i15);
                            this.b.r(e);
                            yf yfVar6 = this.b;
                            if (i15 < i8) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (i15 < i14) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            i9 = i16;
                            i12 = i15;
                            try {
                                yfVar6.o(z4, z5, i4, i6, bgVar2, jgVar2);
                            } catch (UnsupportedOperationException e2) {
                                e = e2;
                                jgVar = jgVar2;
                                bgVar = bgVar2;
                            } catch (SocketException e3) {
                                e = e3;
                                jgVar = jgVar2;
                                bgVar = bgVar2;
                            } catch (SocketTimeoutException e4) {
                                e = e4;
                                jgVar = jgVar2;
                                bgVar = bgVar2;
                            } catch (Throwable th) {
                                th = th;
                                jgVar = jgVar2;
                                bgVar = bgVar2;
                            }
                        } catch (UnsupportedOperationException e5) {
                            e = e5;
                            i9 = i16;
                            jgVar = jgVar2;
                            bgVar = bgVar2;
                            i12 = i15;
                        } catch (SocketException e6) {
                            e = e6;
                            i9 = i16;
                            jgVar = jgVar2;
                            bgVar = bgVar2;
                        } catch (SocketTimeoutException e7) {
                            e = e7;
                            i9 = i16;
                            jgVar = jgVar2;
                            bgVar = bgVar2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i9 = i16;
                        jgVar = jgVar2;
                        bgVar = bgVar2;
                        i12 = i15;
                    }
                } catch (UnsupportedOperationException e8) {
                    e = e8;
                    i9 = i16;
                    jgVar = jgVar2;
                    bgVar = bgVar2;
                    i12 = i15;
                    i13 = R.string.obfuscated_res_0x7f0f0cd1;
                } catch (SocketException e9) {
                    e = e9;
                    i9 = i16;
                    jgVar = jgVar2;
                    bgVar = bgVar2;
                    i11 = R.string.obfuscated_res_0x7f0f0cd1;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                    i9 = i16;
                    jgVar = jgVar2;
                    bgVar = bgVar2;
                    i10 = R.string.obfuscated_res_0x7f0f0cd1;
                }
                if (this.a.c().b != 200) {
                    bgVar = bgVar2;
                    try {
                        bgVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i12;
                        z6 = l(this.a.c().b);
                        this.a.e(bgVar);
                        jgVar = jgVar2;
                        try {
                            try {
                                jgVar.b = this.a.c().b;
                                jgVar.c = "faild";
                                if (this.d <= 0 && (yfVar4 = this.b) != null) {
                                    this.d = yfVar4.i();
                                }
                                bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(bgVar);
                                jgVar.a();
                            } catch (UnsupportedOperationException e11) {
                                e = e11;
                                i13 = R.string.obfuscated_res_0x7f0f0cd1;
                                if (i12 >= i8) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                this.a.c().c = -14;
                                eg c = this.a.c();
                                c.g = e.getMessage() + Log.getStackTraceString(e);
                                bgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                                this.a.e(bgVar);
                                jgVar.b = -14;
                                jgVar.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    yfVar3 = this.b;
                                }
                                bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(bgVar);
                                jgVar.a();
                                z6 = z3;
                                i15 = i9;
                                i14 = 1;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    this.a.c().c = -10;
                                    eg c2 = this.a.c();
                                    c2.g = th.getMessage() + Log.getStackTraceString(th);
                                    if (i12 >= i8) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    bgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0cd1);
                                    BdLog.e(th.getMessage());
                                    this.a.e(bgVar);
                                    jgVar.b = -10;
                                    jgVar.c = Log.getStackTraceString(th);
                                    if (this.d <= 0) {
                                        yfVar3 = this.b;
                                    }
                                    bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(bgVar);
                                    jgVar.a();
                                    z6 = z3;
                                    i15 = i9;
                                    i14 = 1;
                                } finally {
                                    if (this.d <= 0 && (yfVar2 = this.b) != null) {
                                        this.d = yfVar2.i();
                                    }
                                    bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(bgVar);
                                    jgVar.a();
                                }
                            }
                        } catch (SocketException e12) {
                            e = e12;
                            i11 = R.string.obfuscated_res_0x7f0f0cd1;
                            this.a.c().c = -12;
                            eg c3 = this.a.c();
                            c3.g = e.getMessage() + Log.getStackTraceString(e);
                            bgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i11);
                            BdLog.e(e.getMessage());
                            this.a.e(bgVar);
                            jgVar.b = -12;
                            jgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                yfVar = this.b;
                            }
                            bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(bgVar);
                            jgVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        } catch (SocketTimeoutException e13) {
                            e = e13;
                            i10 = R.string.obfuscated_res_0x7f0f0cd1;
                            this.a.c().c = -13;
                            eg c4 = this.a.c();
                            c4.g = e.getMessage() + Log.getStackTraceString(e);
                            bgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i10);
                            BdLog.e(e.getMessage());
                            this.a.e(bgVar);
                            jgVar.b = -13;
                            jgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                yfVar = this.b;
                            }
                            bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(bgVar);
                            jgVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        }
                    } catch (UnsupportedOperationException e14) {
                        e = e14;
                        jgVar = jgVar2;
                    } catch (SocketException e15) {
                        e = e15;
                        jgVar = jgVar2;
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        jgVar = jgVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        jgVar = jgVar2;
                    }
                    i15 = i9;
                    i14 = 1;
                } else {
                    jgVar = jgVar2;
                    bgVar = bgVar2;
                    try {
                        jgVar.b = 0;
                        jgVar.c = DnsModel.MSG_OK;
                        return;
                    } catch (UnsupportedOperationException e17) {
                        e = e17;
                        i13 = R.string.obfuscated_res_0x7f0f0cd1;
                        if (i12 >= i8) {
                        }
                        this.a.c().c = -14;
                        eg c5 = this.a.c();
                        c5.g = e.getMessage() + Log.getStackTraceString(e);
                        bgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                        this.a.e(bgVar);
                        jgVar.b = -14;
                        jgVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                        }
                        bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(bgVar);
                        jgVar.a();
                        z6 = z3;
                        i15 = i9;
                        i14 = 1;
                    } catch (Throwable th5) {
                        th = th5;
                        this.a.c().c = -10;
                        eg c22 = this.a.c();
                        c22.g = th.getMessage() + Log.getStackTraceString(th);
                        if (i12 >= i8) {
                        }
                        bgVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0cd1);
                        BdLog.e(th.getMessage());
                        this.a.e(bgVar);
                        jgVar.b = -10;
                        jgVar.c = Log.getStackTraceString(th);
                        if (this.d <= 0) {
                        }
                        bgVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(bgVar);
                        jgVar.a();
                        z6 = z3;
                        i15 = i9;
                        i14 = 1;
                    }
                }
            }
        }
    }

    public void m(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048588, this, i, i2, i3) == null) {
            if (this.a.b().l()) {
                o(i, i2, i3);
            } else {
                n(i, i2, i3);
            }
        }
    }
}
