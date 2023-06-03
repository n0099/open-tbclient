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
public class uf {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean e = true;
    public transient /* synthetic */ FieldHolder $fh;
    public xf a;
    public tf b;
    public int c;
    public long d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448318780, "Lcom/baidu/tieba/uf;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448318780, "Lcom/baidu/tieba/uf;");
        }
    }

    public final boolean l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? (i == 502 || i == 503 || i == 504 || i == 404) ? false : true : invokeI.booleanValue;
    }

    public uf(xf xfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xfVar};
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
        this.a = xfVar;
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
        tf tfVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (tfVar = this.b) != null) {
            tfVar.b();
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            tf tfVar = this.b;
            if (tfVar == null) {
                return -1L;
            }
            return tfVar.e();
        }
        return invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            tf tfVar = this.b;
            if (tfVar == null) {
                return -1L;
            }
            return tfVar.h();
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
            tf tfVar = this.b;
            if (tfVar == null) {
                return -1L;
            }
            return tfVar.i();
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            tf tfVar = this.b;
            if (tfVar == null) {
                return -1L;
            }
            return tfVar.l();
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            tf tfVar = this.b;
            if (tfVar == null) {
                return -1L;
            }
            return tfVar.j();
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
            xf xfVar = this.a;
            if (xfVar == null) {
                return false;
            }
            return xfVar.c().a;
        }
        return invokeV.booleanValue;
    }

    public void p() {
        xf xfVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || (xfVar = this.a) == null) {
            return;
        }
        xfVar.c().a = true;
    }

    public boolean c(String str, bg bgVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        int i7;
        wf wfVar;
        int i8;
        int i9;
        String str2;
        int i10;
        wf wfVar2;
        String str3;
        StringBuilder sb;
        StringBuilder sb2;
        wf wfVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, bgVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String str4 = "responseCode:";
            if (i3 <= 0) {
                i5 = sb.d().b().b();
            } else {
                i5 = i3;
            }
            if (i <= 0) {
                i6 = sb.d().a();
            } else {
                i6 = i;
            }
            if (i4 <= 0) {
                i7 = sb.d().c().b();
            } else {
                i7 = i4;
            }
            tf tfVar = new tf(this.a);
            this.b = tfVar;
            tfVar.r(e);
            int i11 = 0;
            boolean z3 = false;
            while (i11 < i6) {
                wf wfVar4 = new wf();
                this.a.c().c = -1;
                this.b.q(i11);
                int i12 = i11 + 1;
                try {
                    try {
                        wfVar4.e = i12;
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
                            wfVar2 = wfVar4;
                            i8 = i11;
                            i9 = i6;
                        } catch (ConnectException e3) {
                            e = e3;
                            str2 = str4;
                            i10 = i12;
                            wfVar2 = wfVar4;
                            i8 = i11;
                            i9 = i6;
                        } catch (SocketException e4) {
                            e = e4;
                            str2 = str4;
                            i10 = i12;
                            wfVar2 = wfVar4;
                            i8 = i11;
                            i9 = i6;
                        } catch (SocketTimeoutException e5) {
                            e = e5;
                            str2 = str4;
                            i10 = i12;
                            wfVar2 = wfVar4;
                            i8 = i11;
                            i9 = i6;
                        }
                    } catch (IllegalStateException e6) {
                        e = e6;
                        str3 = str4;
                        i10 = i12;
                        wfVar2 = wfVar4;
                        i8 = i11;
                        i9 = i6;
                    } catch (ConnectException e7) {
                        e = e7;
                        str3 = str4;
                        i10 = i12;
                        wfVar2 = wfVar4;
                        i8 = i11;
                        i9 = i6;
                    } catch (SocketException e8) {
                        e = e8;
                        str3 = str4;
                        i10 = i12;
                        wfVar2 = wfVar4;
                        i8 = i11;
                        i9 = i6;
                    } catch (SocketTimeoutException e9) {
                        e = e9;
                        str3 = str4;
                        i10 = i12;
                        wfVar2 = wfVar4;
                        i8 = i11;
                        i9 = i6;
                    }
                } catch (FileNotFoundException e10) {
                    e = e10;
                    str2 = str4;
                    i10 = i12;
                    wfVar2 = wfVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (UnknownHostException e11) {
                    e = e11;
                    str2 = str4;
                    i10 = i12;
                    wfVar = wfVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (SSLException e12) {
                    e = e12;
                    str2 = str4;
                    i10 = i12;
                    wfVar = wfVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (IOException e13) {
                    e = e13;
                    str2 = str4;
                    i10 = i12;
                    wfVar = wfVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (Exception e14) {
                    e = e14;
                    str2 = str4;
                    i10 = i12;
                    wfVar = wfVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (Throwable th) {
                    th = th;
                    wfVar = wfVar4;
                    i8 = i11;
                    i9 = i6;
                }
                try {
                    z3 = this.b.d(str, bgVar, i5, i7, z, wfVar4, z2);
                    if (!z3 && this.a.c().a) {
                        this.a.c().c = -14;
                    }
                    if (!z3 && i8 == i9 - 1) {
                        StringBuilder sb3 = new StringBuilder();
                        wfVar3 = wfVar4;
                        sb3.append(wfVar3.h);
                        sb3.append("|netAvailable:");
                        sb3.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        wfVar3.h = sb3.toString();
                    } else {
                        wfVar3 = wfVar4;
                    }
                    this.a.e(wfVar3);
                    return z3;
                } catch (FileNotFoundException e15) {
                    e = e15;
                    wfVar2 = wfVar4;
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
                    wfVar2.h = sb4.toString();
                    this.a.c().c = -100;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(wfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        wfVar2.h = sb2.toString();
                    }
                    this.a.e(wfVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (IllegalStateException e16) {
                    e = e16;
                    wfVar2 = wfVar4;
                    str3 = str2;
                    wfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                    this.a.c().c = -19;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(wfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        wfVar2.h = sb2.toString();
                    }
                    this.a.e(wfVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (ConnectException e17) {
                    e = e17;
                    wfVar2 = wfVar4;
                    str3 = str2;
                    wfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -22;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(wfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        wfVar2.h = sb2.toString();
                    }
                    this.a.e(wfVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SocketException e18) {
                    e = e18;
                    wfVar2 = wfVar4;
                    str3 = str2;
                    wfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -12;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(wfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        wfVar2.h = sb2.toString();
                    }
                    this.a.e(wfVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SocketTimeoutException e19) {
                    e = e19;
                    wfVar2 = wfVar4;
                    str3 = str2;
                    wfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -13;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(wfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        wfVar2.h = sb2.toString();
                    }
                    this.a.e(wfVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (UnknownHostException e20) {
                    e = e20;
                    wfVar = wfVar4;
                    wfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -21;
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(wfVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        wfVar.h = sb.toString();
                    }
                    this.a.e(wfVar);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SSLException e21) {
                    e = e21;
                    wfVar = wfVar4;
                    if (this.a.b().e() && i8 < i9 - 1) {
                        BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                    } else {
                        wfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -20;
                    }
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(wfVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        wfVar.h = sb.toString();
                    }
                    this.a.e(wfVar);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (IOException e22) {
                    e = e22;
                    wfVar = wfVar4;
                    wfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -19;
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(wfVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        wfVar.h = sb.toString();
                    }
                    this.a.e(wfVar);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (Exception e23) {
                    e = e23;
                    wfVar = wfVar4;
                    try {
                        wfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -10;
                        BdLog.e(e.getMessage());
                        if (!z3 && i8 == i9 - 1) {
                            sb = new StringBuilder();
                            sb.append(wfVar.h);
                            sb.append("|netAvailable:");
                            sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                            wfVar.h = sb.toString();
                        }
                        this.a.e(wfVar);
                        str3 = str2;
                        str4 = str3;
                        i11 = i10;
                        i6 = i9;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!z3 && i8 == i9 - 1) {
                            wfVar.h += "|netAvailable:" + BdNetTypeUtil.isNetworkAvailableForImmediately();
                        }
                        this.a.e(wfVar);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    wfVar = wfVar4;
                    if (!z3) {
                        wfVar.h += "|netAvailable:" + BdNetTypeUtil.isNetworkAvailableForImmediately();
                    }
                    this.a.e(wfVar);
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
        eg egVar;
        wf wfVar;
        int i9;
        tf tfVar;
        tf tfVar2;
        tf tfVar3;
        tf tfVar4;
        boolean z3;
        boolean z4;
        tf tfVar5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i4 = sb.d().b().b();
            } else {
                i4 = i2;
            }
            if (i <= 0) {
                i5 = sb.d().a();
            } else {
                i5 = i;
            }
            if (i3 <= 0) {
                i6 = sb.d().c().b();
            } else {
                i6 = i3;
            }
            if (((rf) ServiceManager.getService(rf.a)).isSwitchOn()) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if (((sf) ServiceManager.getService(sf.a)).qaHttpsTest()) {
                i8 = 0;
            } else {
                i8 = i7;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i10 = 1;
            int i11 = 0;
            boolean z5 = true;
            while (!this.a.c().a && z5 && i11 < i5 + i8) {
                wf wfVar2 = new wf();
                this.a.e(wfVar2);
                eg egVar2 = new eg();
                yf b = this.a.b();
                if (i11 < i8) {
                    z = true;
                } else {
                    z = false;
                }
                egVar2.a = b.k(z);
                if (i11 < i8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                egVar2.d = z2;
                try {
                    this.c = i11;
                    wfVar2.e = i11 + 1;
                    wfVar2.v = i10;
                    a(i11);
                    tf tfVar6 = new tf(this.a);
                    this.b = tfVar6;
                    tfVar6.q(i11);
                    this.b.r(e);
                    tf tfVar7 = this.b;
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
                        tfVar7.k(z3, z4, i4, i6, wfVar2, egVar2);
                    } catch (SocketException e2) {
                        e = e2;
                        egVar = egVar2;
                        wfVar = wfVar2;
                    } catch (SocketTimeoutException e3) {
                        e = e3;
                        egVar = egVar2;
                        wfVar = wfVar2;
                    } catch (IOException e4) {
                        e = e4;
                        egVar = egVar2;
                        wfVar = wfVar2;
                    } catch (Exception e5) {
                        e = e5;
                        egVar = egVar2;
                        wfVar = wfVar2;
                    } catch (Throwable th) {
                        th = th;
                        egVar = egVar2;
                        wfVar = wfVar2;
                    }
                } catch (SocketException e6) {
                    e = e6;
                    egVar = egVar2;
                    wfVar = wfVar2;
                    i9 = i11;
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    egVar = egVar2;
                    wfVar = wfVar2;
                    i9 = i11;
                } catch (IOException e8) {
                    e = e8;
                    egVar = egVar2;
                    wfVar = wfVar2;
                    i9 = i11;
                } catch (Exception e9) {
                    e = e9;
                    egVar = egVar2;
                    wfVar = wfVar2;
                    i9 = i11;
                } catch (Throwable th2) {
                    th = th2;
                    egVar = egVar2;
                    wfVar = wfVar2;
                }
                if (this.a.c().b != 200) {
                    wfVar = wfVar2;
                    try {
                        wfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9;
                        z5 = l(this.a.c().b);
                        egVar = egVar2;
                        try {
                            try {
                                try {
                                    egVar.b = this.a.c().b;
                                    egVar.c = "faild";
                                    if (this.d <= 0 && (tfVar5 = this.b) != null) {
                                        this.d = tfVar5.i();
                                    }
                                    wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.f(wfVar);
                                    egVar.a();
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (this.d <= 0 && (tfVar4 = this.b) != null) {
                                        this.d = tfVar4.i();
                                    }
                                    wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.f(wfVar);
                                    egVar.a();
                                    throw th;
                                }
                            } catch (Exception e10) {
                                e = e10;
                            }
                        } catch (SocketException e11) {
                            e = e11;
                            wfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -12;
                            egVar.b = -12;
                            egVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(wfVar);
                            egVar.a();
                            z5 = true;
                            i11 = i9 + 1;
                            i10 = 1;
                        } catch (SocketTimeoutException e12) {
                            e = e12;
                            wfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -13;
                            egVar.b = -13;
                            egVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(wfVar);
                            egVar.a();
                            z5 = true;
                            i11 = i9 + 1;
                            i10 = 1;
                        } catch (IOException e13) {
                            e = e13;
                            this.a.c().c = -19;
                            wfVar.h = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            egVar.b = -19;
                            egVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                this.d = tfVar.i();
                            }
                            wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(wfVar);
                            egVar.a();
                            i11 = i9 + 1;
                            i10 = 1;
                        }
                    } catch (SocketException e14) {
                        e = e14;
                        egVar = egVar2;
                    } catch (SocketTimeoutException e15) {
                        e = e15;
                        egVar = egVar2;
                    } catch (IOException e16) {
                        e = e16;
                        egVar = egVar2;
                    } catch (Exception e17) {
                        e = e17;
                        egVar = egVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        egVar = egVar2;
                    }
                    i11 = i9 + 1;
                    i10 = 1;
                } else {
                    egVar = egVar2;
                    wfVar = wfVar2;
                    this.a.f(wfVar);
                    try {
                        egVar.b = 0;
                        egVar.c = DnsModel.MSG_OK;
                        if (this.d <= 0) {
                            tfVar3 = this.b;
                        }
                        wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(wfVar);
                        egVar.a();
                        return;
                    } catch (SocketException e18) {
                        e = e18;
                        wfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.c().c = -12;
                        egVar.b = -12;
                        egVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                            tfVar2 = this.b;
                        }
                        wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(wfVar);
                        egVar.a();
                        z5 = true;
                        i11 = i9 + 1;
                        i10 = 1;
                    } catch (SocketTimeoutException e19) {
                        e = e19;
                        wfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.c().c = -13;
                        egVar.b = -13;
                        egVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                            tfVar2 = this.b;
                        }
                        wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(wfVar);
                        egVar.a();
                        z5 = true;
                        i11 = i9 + 1;
                        i10 = 1;
                    } catch (IOException e20) {
                        e = e20;
                        this.a.c().c = -19;
                        wfVar.h = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        egVar.b = -19;
                        egVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0 && (tfVar = this.b) != null) {
                            this.d = tfVar.i();
                        }
                        wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(wfVar);
                        egVar.a();
                        i11 = i9 + 1;
                        i10 = 1;
                    }
                }
                e = e10;
                wfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                this.a.c().c = -10;
                BdLog.e(e.getMessage());
                egVar.b = -10;
                egVar.c = Log.getStackTraceString(e);
                if (this.d <= 0) {
                    tfVar3 = this.b;
                }
                wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                this.a.f(wfVar);
                egVar.a();
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
        eg egVar;
        wf wfVar;
        int i10;
        int i11;
        int i12;
        int i13;
        tf tfVar;
        tf tfVar2;
        boolean z3;
        tf tfVar3;
        boolean z4;
        boolean z5;
        tf tfVar4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048589, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i4 = sb.d().b().b();
            } else {
                i4 = i2;
            }
            if (i <= 0) {
                i5 = sb.d().a();
            } else {
                i5 = i;
            }
            if (i3 <= 0) {
                i6 = sb.d().c().b();
            } else {
                i6 = i3;
            }
            if (((rf) ServiceManager.getService(rf.a)).isSwitchOn()) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if (((sf) ServiceManager.getService(sf.a)).qaHttpsTest()) {
                i8 = 0;
            } else {
                i8 = i7;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i14 = 1;
            boolean z6 = true;
            int i15 = 0;
            while (!this.a.c().a && z6 && i15 < i5 + i8) {
                wf wfVar2 = new wf();
                eg egVar2 = new eg();
                yf b = this.a.b();
                if (i15 < i8) {
                    z = true;
                } else {
                    z = false;
                }
                egVar2.a = b.k(z);
                if (i15 < i8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                egVar2.d = z2;
                this.c = i15;
                int i16 = i15 + 1;
                wfVar2.e = i16;
                a(i15);
                try {
                    try {
                        try {
                            tf tfVar5 = new tf(this.a);
                            this.b = tfVar5;
                            tfVar5.q(i15);
                            this.b.r(e);
                            tf tfVar6 = this.b;
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
                                tfVar6.p(z4, z5, i4, i6, wfVar2, egVar2);
                            } catch (UnsupportedOperationException e2) {
                                e = e2;
                                egVar = egVar2;
                                wfVar = wfVar2;
                            } catch (SocketException e3) {
                                e = e3;
                                egVar = egVar2;
                                wfVar = wfVar2;
                            } catch (SocketTimeoutException e4) {
                                e = e4;
                                egVar = egVar2;
                                wfVar = wfVar2;
                            } catch (Throwable th) {
                                th = th;
                                egVar = egVar2;
                                wfVar = wfVar2;
                            }
                        } catch (UnsupportedOperationException e5) {
                            e = e5;
                            i9 = i16;
                            egVar = egVar2;
                            wfVar = wfVar2;
                            i12 = i15;
                        } catch (SocketException e6) {
                            e = e6;
                            i9 = i16;
                            egVar = egVar2;
                            wfVar = wfVar2;
                        } catch (SocketTimeoutException e7) {
                            e = e7;
                            i9 = i16;
                            egVar = egVar2;
                            wfVar = wfVar2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i9 = i16;
                        egVar = egVar2;
                        wfVar = wfVar2;
                        i12 = i15;
                    }
                } catch (UnsupportedOperationException e8) {
                    e = e8;
                    i9 = i16;
                    egVar = egVar2;
                    wfVar = wfVar2;
                    i12 = i15;
                    i13 = R.string.obfuscated_res_0x7f0f0def;
                } catch (SocketException e9) {
                    e = e9;
                    i9 = i16;
                    egVar = egVar2;
                    wfVar = wfVar2;
                    i11 = R.string.obfuscated_res_0x7f0f0def;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                    i9 = i16;
                    egVar = egVar2;
                    wfVar = wfVar2;
                    i10 = R.string.obfuscated_res_0x7f0f0def;
                }
                if (this.a.c().b != 200) {
                    wfVar = wfVar2;
                    try {
                        wfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i12;
                        z6 = l(this.a.c().b);
                        this.a.e(wfVar);
                        egVar = egVar2;
                        try {
                            try {
                                egVar.b = this.a.c().b;
                                egVar.c = "faild";
                                if (this.d <= 0 && (tfVar4 = this.b) != null) {
                                    this.d = tfVar4.i();
                                }
                                wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(wfVar);
                                egVar.a();
                            } catch (UnsupportedOperationException e11) {
                                e = e11;
                                i13 = R.string.obfuscated_res_0x7f0f0def;
                                if (i12 >= i8) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                this.a.c().c = -14;
                                zf c = this.a.c();
                                c.g = e.getMessage() + Log.getStackTraceString(e);
                                wfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                                this.a.e(wfVar);
                                egVar.b = -14;
                                egVar.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    tfVar3 = this.b;
                                }
                                wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(wfVar);
                                egVar.a();
                                z6 = z3;
                                i15 = i9;
                                i14 = 1;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    this.a.c().c = -10;
                                    zf c2 = this.a.c();
                                    c2.g = th.getMessage() + Log.getStackTraceString(th);
                                    if (i12 >= i8) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    wfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0def);
                                    BdLog.e(th.getMessage());
                                    this.a.e(wfVar);
                                    egVar.b = -10;
                                    egVar.c = Log.getStackTraceString(th);
                                    if (this.d <= 0) {
                                        tfVar3 = this.b;
                                    }
                                    wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(wfVar);
                                    egVar.a();
                                    z6 = z3;
                                    i15 = i9;
                                    i14 = 1;
                                } finally {
                                    if (this.d <= 0 && (tfVar2 = this.b) != null) {
                                        this.d = tfVar2.i();
                                    }
                                    wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(wfVar);
                                    egVar.a();
                                }
                            }
                        } catch (SocketException e12) {
                            e = e12;
                            i11 = R.string.obfuscated_res_0x7f0f0def;
                            this.a.c().c = -12;
                            zf c3 = this.a.c();
                            c3.g = e.getMessage() + Log.getStackTraceString(e);
                            wfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i11);
                            BdLog.e(e.getMessage());
                            this.a.e(wfVar);
                            egVar.b = -12;
                            egVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                tfVar = this.b;
                            }
                            wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(wfVar);
                            egVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        } catch (SocketTimeoutException e13) {
                            e = e13;
                            i10 = R.string.obfuscated_res_0x7f0f0def;
                            this.a.c().c = -13;
                            zf c4 = this.a.c();
                            c4.g = e.getMessage() + Log.getStackTraceString(e);
                            wfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i10);
                            BdLog.e(e.getMessage());
                            this.a.e(wfVar);
                            egVar.b = -13;
                            egVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                tfVar = this.b;
                            }
                            wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(wfVar);
                            egVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        }
                    } catch (UnsupportedOperationException e14) {
                        e = e14;
                        egVar = egVar2;
                    } catch (SocketException e15) {
                        e = e15;
                        egVar = egVar2;
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        egVar = egVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        egVar = egVar2;
                    }
                    i15 = i9;
                    i14 = 1;
                } else {
                    egVar = egVar2;
                    wfVar = wfVar2;
                    try {
                        egVar.b = 0;
                        egVar.c = DnsModel.MSG_OK;
                        return;
                    } catch (UnsupportedOperationException e17) {
                        e = e17;
                        i13 = R.string.obfuscated_res_0x7f0f0def;
                        if (i12 >= i8) {
                        }
                        this.a.c().c = -14;
                        zf c5 = this.a.c();
                        c5.g = e.getMessage() + Log.getStackTraceString(e);
                        wfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                        this.a.e(wfVar);
                        egVar.b = -14;
                        egVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                        }
                        wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(wfVar);
                        egVar.a();
                        z6 = z3;
                        i15 = i9;
                        i14 = 1;
                    } catch (Throwable th5) {
                        th = th5;
                        this.a.c().c = -10;
                        zf c22 = this.a.c();
                        c22.g = th.getMessage() + Log.getStackTraceString(th);
                        if (i12 >= i8) {
                        }
                        wfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0def);
                        BdLog.e(th.getMessage());
                        this.a.e(wfVar);
                        egVar.b = -10;
                        egVar.c = Log.getStackTraceString(th);
                        if (this.d <= 0) {
                        }
                        wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(wfVar);
                        egVar.a();
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
        eg egVar;
        wf wfVar;
        int i10;
        int i11;
        int i12;
        int i13;
        tf tfVar;
        tf tfVar2;
        boolean z3;
        tf tfVar3;
        boolean z4;
        boolean z5;
        tf tfVar4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048590, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i4 = sb.d().b().b();
            } else {
                i4 = i2;
            }
            if (i <= 0) {
                i5 = sb.d().a();
            } else {
                i5 = i;
            }
            if (i3 <= 0) {
                i6 = sb.d().c().b();
            } else {
                i6 = i3;
            }
            if (((rf) ServiceManager.getService(rf.a)).isSwitchOn()) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if (((sf) ServiceManager.getService(sf.a)).qaHttpsTest()) {
                i8 = 0;
            } else {
                i8 = i7;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i14 = 1;
            boolean z6 = true;
            int i15 = 0;
            while (!this.a.c().a && z6 && i15 < i5 + i8) {
                wf wfVar2 = new wf();
                eg egVar2 = new eg();
                yf b = this.a.b();
                if (i15 < i8) {
                    z = true;
                } else {
                    z = false;
                }
                egVar2.a = b.k(z);
                if (i15 < i8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                egVar2.d = z2;
                int i16 = i15 + 1;
                wfVar2.e = i16;
                this.c = i15;
                a(i15);
                try {
                    try {
                        try {
                            tf tfVar5 = new tf(this.a);
                            this.b = tfVar5;
                            tfVar5.q(i15);
                            this.b.r(e);
                            tf tfVar6 = this.b;
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
                                tfVar6.o(z4, z5, i4, i6, wfVar2, egVar2);
                            } catch (UnsupportedOperationException e2) {
                                e = e2;
                                egVar = egVar2;
                                wfVar = wfVar2;
                            } catch (SocketException e3) {
                                e = e3;
                                egVar = egVar2;
                                wfVar = wfVar2;
                            } catch (SocketTimeoutException e4) {
                                e = e4;
                                egVar = egVar2;
                                wfVar = wfVar2;
                            } catch (Throwable th) {
                                th = th;
                                egVar = egVar2;
                                wfVar = wfVar2;
                            }
                        } catch (UnsupportedOperationException e5) {
                            e = e5;
                            i9 = i16;
                            egVar = egVar2;
                            wfVar = wfVar2;
                            i12 = i15;
                        } catch (SocketException e6) {
                            e = e6;
                            i9 = i16;
                            egVar = egVar2;
                            wfVar = wfVar2;
                        } catch (SocketTimeoutException e7) {
                            e = e7;
                            i9 = i16;
                            egVar = egVar2;
                            wfVar = wfVar2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i9 = i16;
                        egVar = egVar2;
                        wfVar = wfVar2;
                        i12 = i15;
                    }
                } catch (UnsupportedOperationException e8) {
                    e = e8;
                    i9 = i16;
                    egVar = egVar2;
                    wfVar = wfVar2;
                    i12 = i15;
                    i13 = R.string.obfuscated_res_0x7f0f0def;
                } catch (SocketException e9) {
                    e = e9;
                    i9 = i16;
                    egVar = egVar2;
                    wfVar = wfVar2;
                    i11 = R.string.obfuscated_res_0x7f0f0def;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                    i9 = i16;
                    egVar = egVar2;
                    wfVar = wfVar2;
                    i10 = R.string.obfuscated_res_0x7f0f0def;
                }
                if (this.a.c().b != 200) {
                    wfVar = wfVar2;
                    try {
                        wfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i12;
                        z6 = l(this.a.c().b);
                        this.a.e(wfVar);
                        egVar = egVar2;
                        try {
                            try {
                                egVar.b = this.a.c().b;
                                egVar.c = "faild";
                                if (this.d <= 0 && (tfVar4 = this.b) != null) {
                                    this.d = tfVar4.i();
                                }
                                wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(wfVar);
                                egVar.a();
                            } catch (UnsupportedOperationException e11) {
                                e = e11;
                                i13 = R.string.obfuscated_res_0x7f0f0def;
                                if (i12 >= i8) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                this.a.c().c = -14;
                                zf c = this.a.c();
                                c.g = e.getMessage() + Log.getStackTraceString(e);
                                wfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                                this.a.e(wfVar);
                                egVar.b = -14;
                                egVar.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    tfVar3 = this.b;
                                }
                                wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(wfVar);
                                egVar.a();
                                z6 = z3;
                                i15 = i9;
                                i14 = 1;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    this.a.c().c = -10;
                                    zf c2 = this.a.c();
                                    c2.g = th.getMessage() + Log.getStackTraceString(th);
                                    if (i12 >= i8) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    wfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0def);
                                    BdLog.e(th.getMessage());
                                    this.a.e(wfVar);
                                    egVar.b = -10;
                                    egVar.c = Log.getStackTraceString(th);
                                    if (this.d <= 0) {
                                        tfVar3 = this.b;
                                    }
                                    wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(wfVar);
                                    egVar.a();
                                    z6 = z3;
                                    i15 = i9;
                                    i14 = 1;
                                } finally {
                                    if (this.d <= 0 && (tfVar2 = this.b) != null) {
                                        this.d = tfVar2.i();
                                    }
                                    wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(wfVar);
                                    egVar.a();
                                }
                            }
                        } catch (SocketException e12) {
                            e = e12;
                            i11 = R.string.obfuscated_res_0x7f0f0def;
                            this.a.c().c = -12;
                            zf c3 = this.a.c();
                            c3.g = e.getMessage() + Log.getStackTraceString(e);
                            wfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i11);
                            BdLog.e(e.getMessage());
                            this.a.e(wfVar);
                            egVar.b = -12;
                            egVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                tfVar = this.b;
                            }
                            wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(wfVar);
                            egVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        } catch (SocketTimeoutException e13) {
                            e = e13;
                            i10 = R.string.obfuscated_res_0x7f0f0def;
                            this.a.c().c = -13;
                            zf c4 = this.a.c();
                            c4.g = e.getMessage() + Log.getStackTraceString(e);
                            wfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i10);
                            BdLog.e(e.getMessage());
                            this.a.e(wfVar);
                            egVar.b = -13;
                            egVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                tfVar = this.b;
                            }
                            wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(wfVar);
                            egVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        }
                    } catch (UnsupportedOperationException e14) {
                        e = e14;
                        egVar = egVar2;
                    } catch (SocketException e15) {
                        e = e15;
                        egVar = egVar2;
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        egVar = egVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        egVar = egVar2;
                    }
                    i15 = i9;
                    i14 = 1;
                } else {
                    egVar = egVar2;
                    wfVar = wfVar2;
                    try {
                        egVar.b = 0;
                        egVar.c = DnsModel.MSG_OK;
                        return;
                    } catch (UnsupportedOperationException e17) {
                        e = e17;
                        i13 = R.string.obfuscated_res_0x7f0f0def;
                        if (i12 >= i8) {
                        }
                        this.a.c().c = -14;
                        zf c5 = this.a.c();
                        c5.g = e.getMessage() + Log.getStackTraceString(e);
                        wfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                        this.a.e(wfVar);
                        egVar.b = -14;
                        egVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                        }
                        wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(wfVar);
                        egVar.a();
                        z6 = z3;
                        i15 = i9;
                        i14 = 1;
                    } catch (Throwable th5) {
                        th = th5;
                        this.a.c().c = -10;
                        zf c22 = this.a.c();
                        c22.g = th.getMessage() + Log.getStackTraceString(th);
                        if (i12 >= i8) {
                        }
                        wfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0def);
                        BdLog.e(th.getMessage());
                        this.a.e(wfVar);
                        egVar.b = -10;
                        egVar.c = Log.getStackTraceString(th);
                        if (this.d <= 0) {
                        }
                        wfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(wfVar);
                        egVar.a();
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
