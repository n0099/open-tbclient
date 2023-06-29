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
/* loaded from: classes8.dex */
public class wf {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean e = true;
    public transient /* synthetic */ FieldHolder $fh;
    public zf a;
    public vf b;
    public int c;
    public long d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448320702, "Lcom/baidu/tieba/wf;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448320702, "Lcom/baidu/tieba/wf;");
        }
    }

    public final boolean l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? (i == 502 || i == 503 || i == 504 || i == 404) ? false : true : invokeI.booleanValue;
    }

    public wf(zf zfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zfVar};
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
        this.a = zfVar;
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
        vf vfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (vfVar = this.b) != null) {
            vfVar.b();
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            vf vfVar = this.b;
            if (vfVar == null) {
                return -1L;
            }
            return vfVar.e();
        }
        return invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            vf vfVar = this.b;
            if (vfVar == null) {
                return -1L;
            }
            return vfVar.h();
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
            vf vfVar = this.b;
            if (vfVar == null) {
                return -1L;
            }
            return vfVar.i();
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            vf vfVar = this.b;
            if (vfVar == null) {
                return -1L;
            }
            return vfVar.l();
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            vf vfVar = this.b;
            if (vfVar == null) {
                return -1L;
            }
            return vfVar.j();
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
            zf zfVar = this.a;
            if (zfVar == null) {
                return false;
            }
            return zfVar.c().a;
        }
        return invokeV.booleanValue;
    }

    public void p() {
        zf zfVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || (zfVar = this.a) == null) {
            return;
        }
        zfVar.c().a = true;
    }

    public boolean c(String str, dg dgVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        int i7;
        yf yfVar;
        int i8;
        int i9;
        String str2;
        int i10;
        yf yfVar2;
        String str3;
        StringBuilder sb;
        StringBuilder sb2;
        yf yfVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, dgVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String str4 = "responseCode:";
            if (i3 <= 0) {
                i5 = tb.d().b().b();
            } else {
                i5 = i3;
            }
            if (i <= 0) {
                i6 = tb.d().a();
            } else {
                i6 = i;
            }
            if (i4 <= 0) {
                i7 = tb.d().c().b();
            } else {
                i7 = i4;
            }
            vf vfVar = new vf(this.a);
            this.b = vfVar;
            vfVar.r(e);
            int i11 = 0;
            boolean z3 = false;
            while (i11 < i6) {
                yf yfVar4 = new yf();
                this.a.c().c = -1;
                this.b.q(i11);
                int i12 = i11 + 1;
                try {
                    try {
                        yfVar4.e = i12;
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
                            yfVar2 = yfVar4;
                            i8 = i11;
                            i9 = i6;
                        } catch (ConnectException e3) {
                            e = e3;
                            str2 = str4;
                            i10 = i12;
                            yfVar2 = yfVar4;
                            i8 = i11;
                            i9 = i6;
                        } catch (SocketException e4) {
                            e = e4;
                            str2 = str4;
                            i10 = i12;
                            yfVar2 = yfVar4;
                            i8 = i11;
                            i9 = i6;
                        } catch (SocketTimeoutException e5) {
                            e = e5;
                            str2 = str4;
                            i10 = i12;
                            yfVar2 = yfVar4;
                            i8 = i11;
                            i9 = i6;
                        }
                    } catch (IllegalStateException e6) {
                        e = e6;
                        str3 = str4;
                        i10 = i12;
                        yfVar2 = yfVar4;
                        i8 = i11;
                        i9 = i6;
                    } catch (ConnectException e7) {
                        e = e7;
                        str3 = str4;
                        i10 = i12;
                        yfVar2 = yfVar4;
                        i8 = i11;
                        i9 = i6;
                    } catch (SocketException e8) {
                        e = e8;
                        str3 = str4;
                        i10 = i12;
                        yfVar2 = yfVar4;
                        i8 = i11;
                        i9 = i6;
                    } catch (SocketTimeoutException e9) {
                        e = e9;
                        str3 = str4;
                        i10 = i12;
                        yfVar2 = yfVar4;
                        i8 = i11;
                        i9 = i6;
                    }
                } catch (FileNotFoundException e10) {
                    e = e10;
                    str2 = str4;
                    i10 = i12;
                    yfVar2 = yfVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (UnknownHostException e11) {
                    e = e11;
                    str2 = str4;
                    i10 = i12;
                    yfVar = yfVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (SSLException e12) {
                    e = e12;
                    str2 = str4;
                    i10 = i12;
                    yfVar = yfVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (IOException e13) {
                    e = e13;
                    str2 = str4;
                    i10 = i12;
                    yfVar = yfVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (Exception e14) {
                    e = e14;
                    str2 = str4;
                    i10 = i12;
                    yfVar = yfVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (Throwable th) {
                    th = th;
                    yfVar = yfVar4;
                    i8 = i11;
                    i9 = i6;
                }
                try {
                    z3 = this.b.d(str, dgVar, i5, i7, z, yfVar4, z2);
                    if (!z3 && this.a.c().a) {
                        this.a.c().c = -14;
                    }
                    if (!z3 && i8 == i9 - 1) {
                        StringBuilder sb3 = new StringBuilder();
                        yfVar3 = yfVar4;
                        sb3.append(yfVar3.h);
                        sb3.append("|netAvailable:");
                        sb3.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        yfVar3.h = sb3.toString();
                    } else {
                        yfVar3 = yfVar4;
                    }
                    this.a.e(yfVar3);
                    return z3;
                } catch (FileNotFoundException e15) {
                    e = e15;
                    yfVar2 = yfVar4;
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
                    yfVar2.h = sb4.toString();
                    this.a.c().c = -100;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(yfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        yfVar2.h = sb2.toString();
                    }
                    this.a.e(yfVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (IllegalStateException e16) {
                    e = e16;
                    yfVar2 = yfVar4;
                    str3 = str2;
                    yfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                    this.a.c().c = -19;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(yfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        yfVar2.h = sb2.toString();
                    }
                    this.a.e(yfVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (ConnectException e17) {
                    e = e17;
                    yfVar2 = yfVar4;
                    str3 = str2;
                    yfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -22;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(yfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        yfVar2.h = sb2.toString();
                    }
                    this.a.e(yfVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SocketException e18) {
                    e = e18;
                    yfVar2 = yfVar4;
                    str3 = str2;
                    yfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -12;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(yfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        yfVar2.h = sb2.toString();
                    }
                    this.a.e(yfVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SocketTimeoutException e19) {
                    e = e19;
                    yfVar2 = yfVar4;
                    str3 = str2;
                    yfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -13;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(yfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        yfVar2.h = sb2.toString();
                    }
                    this.a.e(yfVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (UnknownHostException e20) {
                    e = e20;
                    yfVar = yfVar4;
                    yfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -21;
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(yfVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        yfVar.h = sb.toString();
                    }
                    this.a.e(yfVar);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SSLException e21) {
                    e = e21;
                    yfVar = yfVar4;
                    if (this.a.b().e() && i8 < i9 - 1) {
                        BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                    } else {
                        yfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -20;
                    }
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(yfVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        yfVar.h = sb.toString();
                    }
                    this.a.e(yfVar);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (IOException e22) {
                    e = e22;
                    yfVar = yfVar4;
                    yfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -19;
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(yfVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        yfVar.h = sb.toString();
                    }
                    this.a.e(yfVar);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (Exception e23) {
                    e = e23;
                    yfVar = yfVar4;
                    try {
                        yfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -10;
                        BdLog.e(e.getMessage());
                        if (!z3 && i8 == i9 - 1) {
                            sb = new StringBuilder();
                            sb.append(yfVar.h);
                            sb.append("|netAvailable:");
                            sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                            yfVar.h = sb.toString();
                        }
                        this.a.e(yfVar);
                        str3 = str2;
                        str4 = str3;
                        i11 = i10;
                        i6 = i9;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!z3 && i8 == i9 - 1) {
                            yfVar.h += "|netAvailable:" + BdNetTypeUtil.isNetworkAvailableForImmediately();
                        }
                        this.a.e(yfVar);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    yfVar = yfVar4;
                    if (!z3) {
                        yfVar.h += "|netAvailable:" + BdNetTypeUtil.isNetworkAvailableForImmediately();
                    }
                    this.a.e(yfVar);
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
        gg ggVar;
        yf yfVar;
        int i9;
        vf vfVar;
        vf vfVar2;
        vf vfVar3;
        vf vfVar4;
        boolean z3;
        boolean z4;
        vf vfVar5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i4 = tb.d().b().b();
            } else {
                i4 = i2;
            }
            if (i <= 0) {
                i5 = tb.d().a();
            } else {
                i5 = i;
            }
            if (i3 <= 0) {
                i6 = tb.d().c().b();
            } else {
                i6 = i3;
            }
            if (((tf) ServiceManager.getService(tf.a)).isSwitchOn()) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if (((uf) ServiceManager.getService(uf.a)).qaHttpsTest()) {
                i8 = 0;
            } else {
                i8 = i7;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i10 = 1;
            int i11 = 0;
            boolean z5 = true;
            while (!this.a.c().a && z5 && i11 < i5 + i8) {
                yf yfVar2 = new yf();
                this.a.e(yfVar2);
                gg ggVar2 = new gg();
                ag b = this.a.b();
                if (i11 < i8) {
                    z = true;
                } else {
                    z = false;
                }
                ggVar2.a = b.k(z);
                if (i11 < i8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ggVar2.d = z2;
                try {
                    this.c = i11;
                    yfVar2.e = i11 + 1;
                    yfVar2.v = i10;
                    a(i11);
                    vf vfVar6 = new vf(this.a);
                    this.b = vfVar6;
                    vfVar6.q(i11);
                    this.b.r(e);
                    vf vfVar7 = this.b;
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
                        vfVar7.k(z3, z4, i4, i6, yfVar2, ggVar2);
                    } catch (SocketException e2) {
                        e = e2;
                        ggVar = ggVar2;
                        yfVar = yfVar2;
                    } catch (SocketTimeoutException e3) {
                        e = e3;
                        ggVar = ggVar2;
                        yfVar = yfVar2;
                    } catch (IOException e4) {
                        e = e4;
                        ggVar = ggVar2;
                        yfVar = yfVar2;
                    } catch (Exception e5) {
                        e = e5;
                        ggVar = ggVar2;
                        yfVar = yfVar2;
                    } catch (Throwable th) {
                        th = th;
                        ggVar = ggVar2;
                        yfVar = yfVar2;
                    }
                } catch (SocketException e6) {
                    e = e6;
                    ggVar = ggVar2;
                    yfVar = yfVar2;
                    i9 = i11;
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    ggVar = ggVar2;
                    yfVar = yfVar2;
                    i9 = i11;
                } catch (IOException e8) {
                    e = e8;
                    ggVar = ggVar2;
                    yfVar = yfVar2;
                    i9 = i11;
                } catch (Exception e9) {
                    e = e9;
                    ggVar = ggVar2;
                    yfVar = yfVar2;
                    i9 = i11;
                } catch (Throwable th2) {
                    th = th2;
                    ggVar = ggVar2;
                    yfVar = yfVar2;
                }
                if (this.a.c().b != 200) {
                    yfVar = yfVar2;
                    try {
                        yfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9;
                        z5 = l(this.a.c().b);
                        ggVar = ggVar2;
                        try {
                            try {
                                try {
                                    ggVar.b = this.a.c().b;
                                    ggVar.c = "faild";
                                    if (this.d <= 0 && (vfVar5 = this.b) != null) {
                                        this.d = vfVar5.i();
                                    }
                                    yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.f(yfVar);
                                    ggVar.a();
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (this.d <= 0 && (vfVar4 = this.b) != null) {
                                        this.d = vfVar4.i();
                                    }
                                    yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.f(yfVar);
                                    ggVar.a();
                                    throw th;
                                }
                            } catch (Exception e10) {
                                e = e10;
                            }
                        } catch (SocketException e11) {
                            e = e11;
                            yfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -12;
                            ggVar.b = -12;
                            ggVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(yfVar);
                            ggVar.a();
                            z5 = true;
                            i11 = i9 + 1;
                            i10 = 1;
                        } catch (SocketTimeoutException e12) {
                            e = e12;
                            yfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -13;
                            ggVar.b = -13;
                            ggVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(yfVar);
                            ggVar.a();
                            z5 = true;
                            i11 = i9 + 1;
                            i10 = 1;
                        } catch (IOException e13) {
                            e = e13;
                            this.a.c().c = -19;
                            yfVar.h = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            ggVar.b = -19;
                            ggVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                this.d = vfVar.i();
                            }
                            yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(yfVar);
                            ggVar.a();
                            i11 = i9 + 1;
                            i10 = 1;
                        }
                    } catch (SocketException e14) {
                        e = e14;
                        ggVar = ggVar2;
                    } catch (SocketTimeoutException e15) {
                        e = e15;
                        ggVar = ggVar2;
                    } catch (IOException e16) {
                        e = e16;
                        ggVar = ggVar2;
                    } catch (Exception e17) {
                        e = e17;
                        ggVar = ggVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        ggVar = ggVar2;
                    }
                    i11 = i9 + 1;
                    i10 = 1;
                } else {
                    ggVar = ggVar2;
                    yfVar = yfVar2;
                    this.a.f(yfVar);
                    try {
                        ggVar.b = 0;
                        ggVar.c = DnsModel.MSG_OK;
                        if (this.d <= 0) {
                            vfVar3 = this.b;
                        }
                        yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(yfVar);
                        ggVar.a();
                        return;
                    } catch (SocketException e18) {
                        e = e18;
                        yfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.c().c = -12;
                        ggVar.b = -12;
                        ggVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                            vfVar2 = this.b;
                        }
                        yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(yfVar);
                        ggVar.a();
                        z5 = true;
                        i11 = i9 + 1;
                        i10 = 1;
                    } catch (SocketTimeoutException e19) {
                        e = e19;
                        yfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.c().c = -13;
                        ggVar.b = -13;
                        ggVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                            vfVar2 = this.b;
                        }
                        yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(yfVar);
                        ggVar.a();
                        z5 = true;
                        i11 = i9 + 1;
                        i10 = 1;
                    } catch (IOException e20) {
                        e = e20;
                        this.a.c().c = -19;
                        yfVar.h = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        ggVar.b = -19;
                        ggVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0 && (vfVar = this.b) != null) {
                            this.d = vfVar.i();
                        }
                        yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(yfVar);
                        ggVar.a();
                        i11 = i9 + 1;
                        i10 = 1;
                    }
                }
                e = e10;
                yfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                this.a.c().c = -10;
                BdLog.e(e.getMessage());
                ggVar.b = -10;
                ggVar.c = Log.getStackTraceString(e);
                if (this.d <= 0) {
                    vfVar3 = this.b;
                }
                yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                this.a.f(yfVar);
                ggVar.a();
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
        gg ggVar;
        yf yfVar;
        int i10;
        int i11;
        int i12;
        int i13;
        vf vfVar;
        vf vfVar2;
        boolean z3;
        vf vfVar3;
        boolean z4;
        boolean z5;
        vf vfVar4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048589, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i4 = tb.d().b().b();
            } else {
                i4 = i2;
            }
            if (i <= 0) {
                i5 = tb.d().a();
            } else {
                i5 = i;
            }
            if (i3 <= 0) {
                i6 = tb.d().c().b();
            } else {
                i6 = i3;
            }
            if (((tf) ServiceManager.getService(tf.a)).isSwitchOn()) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if (((uf) ServiceManager.getService(uf.a)).qaHttpsTest()) {
                i8 = 0;
            } else {
                i8 = i7;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i14 = 1;
            boolean z6 = true;
            int i15 = 0;
            while (!this.a.c().a && z6 && i15 < i5 + i8) {
                yf yfVar2 = new yf();
                gg ggVar2 = new gg();
                ag b = this.a.b();
                if (i15 < i8) {
                    z = true;
                } else {
                    z = false;
                }
                ggVar2.a = b.k(z);
                if (i15 < i8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ggVar2.d = z2;
                this.c = i15;
                int i16 = i15 + 1;
                yfVar2.e = i16;
                a(i15);
                try {
                    try {
                        try {
                            vf vfVar5 = new vf(this.a);
                            this.b = vfVar5;
                            vfVar5.q(i15);
                            this.b.r(e);
                            vf vfVar6 = this.b;
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
                                vfVar6.p(z4, z5, i4, i6, yfVar2, ggVar2);
                            } catch (UnsupportedOperationException e2) {
                                e = e2;
                                ggVar = ggVar2;
                                yfVar = yfVar2;
                            } catch (SocketException e3) {
                                e = e3;
                                ggVar = ggVar2;
                                yfVar = yfVar2;
                            } catch (SocketTimeoutException e4) {
                                e = e4;
                                ggVar = ggVar2;
                                yfVar = yfVar2;
                            } catch (Throwable th) {
                                th = th;
                                ggVar = ggVar2;
                                yfVar = yfVar2;
                            }
                        } catch (UnsupportedOperationException e5) {
                            e = e5;
                            i9 = i16;
                            ggVar = ggVar2;
                            yfVar = yfVar2;
                            i12 = i15;
                        } catch (SocketException e6) {
                            e = e6;
                            i9 = i16;
                            ggVar = ggVar2;
                            yfVar = yfVar2;
                        } catch (SocketTimeoutException e7) {
                            e = e7;
                            i9 = i16;
                            ggVar = ggVar2;
                            yfVar = yfVar2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i9 = i16;
                        ggVar = ggVar2;
                        yfVar = yfVar2;
                        i12 = i15;
                    }
                } catch (UnsupportedOperationException e8) {
                    e = e8;
                    i9 = i16;
                    ggVar = ggVar2;
                    yfVar = yfVar2;
                    i12 = i15;
                    i13 = R.string.obfuscated_res_0x7f0f0e0f;
                } catch (SocketException e9) {
                    e = e9;
                    i9 = i16;
                    ggVar = ggVar2;
                    yfVar = yfVar2;
                    i11 = R.string.obfuscated_res_0x7f0f0e0f;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                    i9 = i16;
                    ggVar = ggVar2;
                    yfVar = yfVar2;
                    i10 = R.string.obfuscated_res_0x7f0f0e0f;
                }
                if (this.a.c().b != 200) {
                    yfVar = yfVar2;
                    try {
                        yfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i12;
                        z6 = l(this.a.c().b);
                        this.a.e(yfVar);
                        ggVar = ggVar2;
                        try {
                            try {
                                ggVar.b = this.a.c().b;
                                ggVar.c = "faild";
                                if (this.d <= 0 && (vfVar4 = this.b) != null) {
                                    this.d = vfVar4.i();
                                }
                                yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(yfVar);
                                ggVar.a();
                            } catch (UnsupportedOperationException e11) {
                                e = e11;
                                i13 = R.string.obfuscated_res_0x7f0f0e0f;
                                if (i12 >= i8) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                this.a.c().c = -14;
                                bg c = this.a.c();
                                c.g = e.getMessage() + Log.getStackTraceString(e);
                                yfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                                this.a.e(yfVar);
                                ggVar.b = -14;
                                ggVar.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    vfVar3 = this.b;
                                }
                                yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(yfVar);
                                ggVar.a();
                                z6 = z3;
                                i15 = i9;
                                i14 = 1;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    this.a.c().c = -10;
                                    bg c2 = this.a.c();
                                    c2.g = th.getMessage() + Log.getStackTraceString(th);
                                    if (i12 >= i8) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    yfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0e0f);
                                    BdLog.e(th.getMessage());
                                    this.a.e(yfVar);
                                    ggVar.b = -10;
                                    ggVar.c = Log.getStackTraceString(th);
                                    if (this.d <= 0) {
                                        vfVar3 = this.b;
                                    }
                                    yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(yfVar);
                                    ggVar.a();
                                    z6 = z3;
                                    i15 = i9;
                                    i14 = 1;
                                } finally {
                                    if (this.d <= 0 && (vfVar2 = this.b) != null) {
                                        this.d = vfVar2.i();
                                    }
                                    yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(yfVar);
                                    ggVar.a();
                                }
                            }
                        } catch (SocketException e12) {
                            e = e12;
                            i11 = R.string.obfuscated_res_0x7f0f0e0f;
                            this.a.c().c = -12;
                            bg c3 = this.a.c();
                            c3.g = e.getMessage() + Log.getStackTraceString(e);
                            yfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i11);
                            BdLog.e(e.getMessage());
                            this.a.e(yfVar);
                            ggVar.b = -12;
                            ggVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                vfVar = this.b;
                            }
                            yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(yfVar);
                            ggVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        } catch (SocketTimeoutException e13) {
                            e = e13;
                            i10 = R.string.obfuscated_res_0x7f0f0e0f;
                            this.a.c().c = -13;
                            bg c4 = this.a.c();
                            c4.g = e.getMessage() + Log.getStackTraceString(e);
                            yfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i10);
                            BdLog.e(e.getMessage());
                            this.a.e(yfVar);
                            ggVar.b = -13;
                            ggVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                vfVar = this.b;
                            }
                            yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(yfVar);
                            ggVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        }
                    } catch (UnsupportedOperationException e14) {
                        e = e14;
                        ggVar = ggVar2;
                    } catch (SocketException e15) {
                        e = e15;
                        ggVar = ggVar2;
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        ggVar = ggVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        ggVar = ggVar2;
                    }
                    i15 = i9;
                    i14 = 1;
                } else {
                    ggVar = ggVar2;
                    yfVar = yfVar2;
                    try {
                        ggVar.b = 0;
                        ggVar.c = DnsModel.MSG_OK;
                        return;
                    } catch (UnsupportedOperationException e17) {
                        e = e17;
                        i13 = R.string.obfuscated_res_0x7f0f0e0f;
                        if (i12 >= i8) {
                        }
                        this.a.c().c = -14;
                        bg c5 = this.a.c();
                        c5.g = e.getMessage() + Log.getStackTraceString(e);
                        yfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                        this.a.e(yfVar);
                        ggVar.b = -14;
                        ggVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                        }
                        yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(yfVar);
                        ggVar.a();
                        z6 = z3;
                        i15 = i9;
                        i14 = 1;
                    } catch (Throwable th5) {
                        th = th5;
                        this.a.c().c = -10;
                        bg c22 = this.a.c();
                        c22.g = th.getMessage() + Log.getStackTraceString(th);
                        if (i12 >= i8) {
                        }
                        yfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0e0f);
                        BdLog.e(th.getMessage());
                        this.a.e(yfVar);
                        ggVar.b = -10;
                        ggVar.c = Log.getStackTraceString(th);
                        if (this.d <= 0) {
                        }
                        yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(yfVar);
                        ggVar.a();
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
        gg ggVar;
        yf yfVar;
        int i10;
        int i11;
        int i12;
        int i13;
        vf vfVar;
        vf vfVar2;
        boolean z3;
        vf vfVar3;
        boolean z4;
        boolean z5;
        vf vfVar4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048590, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i4 = tb.d().b().b();
            } else {
                i4 = i2;
            }
            if (i <= 0) {
                i5 = tb.d().a();
            } else {
                i5 = i;
            }
            if (i3 <= 0) {
                i6 = tb.d().c().b();
            } else {
                i6 = i3;
            }
            if (((tf) ServiceManager.getService(tf.a)).isSwitchOn()) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if (((uf) ServiceManager.getService(uf.a)).qaHttpsTest()) {
                i8 = 0;
            } else {
                i8 = i7;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i14 = 1;
            boolean z6 = true;
            int i15 = 0;
            while (!this.a.c().a && z6 && i15 < i5 + i8) {
                yf yfVar2 = new yf();
                gg ggVar2 = new gg();
                ag b = this.a.b();
                if (i15 < i8) {
                    z = true;
                } else {
                    z = false;
                }
                ggVar2.a = b.k(z);
                if (i15 < i8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ggVar2.d = z2;
                int i16 = i15 + 1;
                yfVar2.e = i16;
                this.c = i15;
                a(i15);
                try {
                    try {
                        try {
                            vf vfVar5 = new vf(this.a);
                            this.b = vfVar5;
                            vfVar5.q(i15);
                            this.b.r(e);
                            vf vfVar6 = this.b;
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
                                vfVar6.o(z4, z5, i4, i6, yfVar2, ggVar2);
                            } catch (UnsupportedOperationException e2) {
                                e = e2;
                                ggVar = ggVar2;
                                yfVar = yfVar2;
                            } catch (SocketException e3) {
                                e = e3;
                                ggVar = ggVar2;
                                yfVar = yfVar2;
                            } catch (SocketTimeoutException e4) {
                                e = e4;
                                ggVar = ggVar2;
                                yfVar = yfVar2;
                            } catch (Throwable th) {
                                th = th;
                                ggVar = ggVar2;
                                yfVar = yfVar2;
                            }
                        } catch (UnsupportedOperationException e5) {
                            e = e5;
                            i9 = i16;
                            ggVar = ggVar2;
                            yfVar = yfVar2;
                            i12 = i15;
                        } catch (SocketException e6) {
                            e = e6;
                            i9 = i16;
                            ggVar = ggVar2;
                            yfVar = yfVar2;
                        } catch (SocketTimeoutException e7) {
                            e = e7;
                            i9 = i16;
                            ggVar = ggVar2;
                            yfVar = yfVar2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i9 = i16;
                        ggVar = ggVar2;
                        yfVar = yfVar2;
                        i12 = i15;
                    }
                } catch (UnsupportedOperationException e8) {
                    e = e8;
                    i9 = i16;
                    ggVar = ggVar2;
                    yfVar = yfVar2;
                    i12 = i15;
                    i13 = R.string.obfuscated_res_0x7f0f0e0f;
                } catch (SocketException e9) {
                    e = e9;
                    i9 = i16;
                    ggVar = ggVar2;
                    yfVar = yfVar2;
                    i11 = R.string.obfuscated_res_0x7f0f0e0f;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                    i9 = i16;
                    ggVar = ggVar2;
                    yfVar = yfVar2;
                    i10 = R.string.obfuscated_res_0x7f0f0e0f;
                }
                if (this.a.c().b != 200) {
                    yfVar = yfVar2;
                    try {
                        yfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i12;
                        z6 = l(this.a.c().b);
                        this.a.e(yfVar);
                        ggVar = ggVar2;
                        try {
                            try {
                                ggVar.b = this.a.c().b;
                                ggVar.c = "faild";
                                if (this.d <= 0 && (vfVar4 = this.b) != null) {
                                    this.d = vfVar4.i();
                                }
                                yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(yfVar);
                                ggVar.a();
                            } catch (UnsupportedOperationException e11) {
                                e = e11;
                                i13 = R.string.obfuscated_res_0x7f0f0e0f;
                                if (i12 >= i8) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                this.a.c().c = -14;
                                bg c = this.a.c();
                                c.g = e.getMessage() + Log.getStackTraceString(e);
                                yfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                                this.a.e(yfVar);
                                ggVar.b = -14;
                                ggVar.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    vfVar3 = this.b;
                                }
                                yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(yfVar);
                                ggVar.a();
                                z6 = z3;
                                i15 = i9;
                                i14 = 1;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    this.a.c().c = -10;
                                    bg c2 = this.a.c();
                                    c2.g = th.getMessage() + Log.getStackTraceString(th);
                                    if (i12 >= i8) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    yfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0e0f);
                                    BdLog.e(th.getMessage());
                                    this.a.e(yfVar);
                                    ggVar.b = -10;
                                    ggVar.c = Log.getStackTraceString(th);
                                    if (this.d <= 0) {
                                        vfVar3 = this.b;
                                    }
                                    yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(yfVar);
                                    ggVar.a();
                                    z6 = z3;
                                    i15 = i9;
                                    i14 = 1;
                                } finally {
                                    if (this.d <= 0 && (vfVar2 = this.b) != null) {
                                        this.d = vfVar2.i();
                                    }
                                    yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(yfVar);
                                    ggVar.a();
                                }
                            }
                        } catch (SocketException e12) {
                            e = e12;
                            i11 = R.string.obfuscated_res_0x7f0f0e0f;
                            this.a.c().c = -12;
                            bg c3 = this.a.c();
                            c3.g = e.getMessage() + Log.getStackTraceString(e);
                            yfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i11);
                            BdLog.e(e.getMessage());
                            this.a.e(yfVar);
                            ggVar.b = -12;
                            ggVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                vfVar = this.b;
                            }
                            yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(yfVar);
                            ggVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        } catch (SocketTimeoutException e13) {
                            e = e13;
                            i10 = R.string.obfuscated_res_0x7f0f0e0f;
                            this.a.c().c = -13;
                            bg c4 = this.a.c();
                            c4.g = e.getMessage() + Log.getStackTraceString(e);
                            yfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i10);
                            BdLog.e(e.getMessage());
                            this.a.e(yfVar);
                            ggVar.b = -13;
                            ggVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                vfVar = this.b;
                            }
                            yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(yfVar);
                            ggVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        }
                    } catch (UnsupportedOperationException e14) {
                        e = e14;
                        ggVar = ggVar2;
                    } catch (SocketException e15) {
                        e = e15;
                        ggVar = ggVar2;
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        ggVar = ggVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        ggVar = ggVar2;
                    }
                    i15 = i9;
                    i14 = 1;
                } else {
                    ggVar = ggVar2;
                    yfVar = yfVar2;
                    try {
                        ggVar.b = 0;
                        ggVar.c = DnsModel.MSG_OK;
                        return;
                    } catch (UnsupportedOperationException e17) {
                        e = e17;
                        i13 = R.string.obfuscated_res_0x7f0f0e0f;
                        if (i12 >= i8) {
                        }
                        this.a.c().c = -14;
                        bg c5 = this.a.c();
                        c5.g = e.getMessage() + Log.getStackTraceString(e);
                        yfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                        this.a.e(yfVar);
                        ggVar.b = -14;
                        ggVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                        }
                        yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(yfVar);
                        ggVar.a();
                        z6 = z3;
                        i15 = i9;
                        i14 = 1;
                    } catch (Throwable th5) {
                        th = th5;
                        this.a.c().c = -10;
                        bg c22 = this.a.c();
                        c22.g = th.getMessage() + Log.getStackTraceString(th);
                        if (i12 >= i8) {
                        }
                        yfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0e0f);
                        BdLog.e(th.getMessage());
                        this.a.e(yfVar);
                        ggVar.b = -10;
                        ggVar.c = Log.getStackTraceString(th);
                        if (this.d <= 0) {
                        }
                        yfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(yfVar);
                        ggVar.a();
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
