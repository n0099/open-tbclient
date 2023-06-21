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
public class vf {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean e = true;
    public transient /* synthetic */ FieldHolder $fh;
    public yf a;
    public uf b;
    public int c;
    public long d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448319741, "Lcom/baidu/tieba/vf;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448319741, "Lcom/baidu/tieba/vf;");
        }
    }

    public final boolean l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? (i == 502 || i == 503 || i == 504 || i == 404) ? false : true : invokeI.booleanValue;
    }

    public vf(yf yfVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yfVar};
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
        this.a = yfVar;
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
        uf ufVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (ufVar = this.b) != null) {
            ufVar.b();
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            uf ufVar = this.b;
            if (ufVar == null) {
                return -1L;
            }
            return ufVar.e();
        }
        return invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            uf ufVar = this.b;
            if (ufVar == null) {
                return -1L;
            }
            return ufVar.h();
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
            uf ufVar = this.b;
            if (ufVar == null) {
                return -1L;
            }
            return ufVar.i();
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            uf ufVar = this.b;
            if (ufVar == null) {
                return -1L;
            }
            return ufVar.l();
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            uf ufVar = this.b;
            if (ufVar == null) {
                return -1L;
            }
            return ufVar.j();
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
            yf yfVar = this.a;
            if (yfVar == null) {
                return false;
            }
            return yfVar.c().a;
        }
        return invokeV.booleanValue;
    }

    public void p() {
        yf yfVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || (yfVar = this.a) == null) {
            return;
        }
        yfVar.c().a = true;
    }

    public boolean c(String str, cg cgVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        int i7;
        xf xfVar;
        int i8;
        int i9;
        String str2;
        int i10;
        xf xfVar2;
        String str3;
        StringBuilder sb;
        StringBuilder sb2;
        xf xfVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, cgVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
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
            uf ufVar = new uf(this.a);
            this.b = ufVar;
            ufVar.r(e);
            int i11 = 0;
            boolean z3 = false;
            while (i11 < i6) {
                xf xfVar4 = new xf();
                this.a.c().c = -1;
                this.b.q(i11);
                int i12 = i11 + 1;
                try {
                    try {
                        xfVar4.e = i12;
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
                            xfVar2 = xfVar4;
                            i8 = i11;
                            i9 = i6;
                        } catch (ConnectException e3) {
                            e = e3;
                            str2 = str4;
                            i10 = i12;
                            xfVar2 = xfVar4;
                            i8 = i11;
                            i9 = i6;
                        } catch (SocketException e4) {
                            e = e4;
                            str2 = str4;
                            i10 = i12;
                            xfVar2 = xfVar4;
                            i8 = i11;
                            i9 = i6;
                        } catch (SocketTimeoutException e5) {
                            e = e5;
                            str2 = str4;
                            i10 = i12;
                            xfVar2 = xfVar4;
                            i8 = i11;
                            i9 = i6;
                        }
                    } catch (IllegalStateException e6) {
                        e = e6;
                        str3 = str4;
                        i10 = i12;
                        xfVar2 = xfVar4;
                        i8 = i11;
                        i9 = i6;
                    } catch (ConnectException e7) {
                        e = e7;
                        str3 = str4;
                        i10 = i12;
                        xfVar2 = xfVar4;
                        i8 = i11;
                        i9 = i6;
                    } catch (SocketException e8) {
                        e = e8;
                        str3 = str4;
                        i10 = i12;
                        xfVar2 = xfVar4;
                        i8 = i11;
                        i9 = i6;
                    } catch (SocketTimeoutException e9) {
                        e = e9;
                        str3 = str4;
                        i10 = i12;
                        xfVar2 = xfVar4;
                        i8 = i11;
                        i9 = i6;
                    }
                } catch (FileNotFoundException e10) {
                    e = e10;
                    str2 = str4;
                    i10 = i12;
                    xfVar2 = xfVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (UnknownHostException e11) {
                    e = e11;
                    str2 = str4;
                    i10 = i12;
                    xfVar = xfVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (SSLException e12) {
                    e = e12;
                    str2 = str4;
                    i10 = i12;
                    xfVar = xfVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (IOException e13) {
                    e = e13;
                    str2 = str4;
                    i10 = i12;
                    xfVar = xfVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (Exception e14) {
                    e = e14;
                    str2 = str4;
                    i10 = i12;
                    xfVar = xfVar4;
                    i8 = i11;
                    i9 = i6;
                } catch (Throwable th) {
                    th = th;
                    xfVar = xfVar4;
                    i8 = i11;
                    i9 = i6;
                }
                try {
                    z3 = this.b.d(str, cgVar, i5, i7, z, xfVar4, z2);
                    if (!z3 && this.a.c().a) {
                        this.a.c().c = -14;
                    }
                    if (!z3 && i8 == i9 - 1) {
                        StringBuilder sb3 = new StringBuilder();
                        xfVar3 = xfVar4;
                        sb3.append(xfVar3.h);
                        sb3.append("|netAvailable:");
                        sb3.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        xfVar3.h = sb3.toString();
                    } else {
                        xfVar3 = xfVar4;
                    }
                    this.a.e(xfVar3);
                    return z3;
                } catch (FileNotFoundException e15) {
                    e = e15;
                    xfVar2 = xfVar4;
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
                    xfVar2.h = sb4.toString();
                    this.a.c().c = -100;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(xfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        xfVar2.h = sb2.toString();
                    }
                    this.a.e(xfVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (IllegalStateException e16) {
                    e = e16;
                    xfVar2 = xfVar4;
                    str3 = str2;
                    xfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                    this.a.c().c = -19;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(xfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        xfVar2.h = sb2.toString();
                    }
                    this.a.e(xfVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (ConnectException e17) {
                    e = e17;
                    xfVar2 = xfVar4;
                    str3 = str2;
                    xfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -22;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(xfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        xfVar2.h = sb2.toString();
                    }
                    this.a.e(xfVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SocketException e18) {
                    e = e18;
                    xfVar2 = xfVar4;
                    str3 = str2;
                    xfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -12;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(xfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        xfVar2.h = sb2.toString();
                    }
                    this.a.e(xfVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SocketTimeoutException e19) {
                    e = e19;
                    xfVar2 = xfVar4;
                    str3 = str2;
                    xfVar2.h = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -13;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(xfVar2.h);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        xfVar2.h = sb2.toString();
                    }
                    this.a.e(xfVar2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (UnknownHostException e20) {
                    e = e20;
                    xfVar = xfVar4;
                    xfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -21;
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(xfVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        xfVar.h = sb.toString();
                    }
                    this.a.e(xfVar);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SSLException e21) {
                    e = e21;
                    xfVar = xfVar4;
                    if (this.a.b().e() && i8 < i9 - 1) {
                        BdStatisticsManager.getInstance().eventStat(null, "c13429", "", 1, "obj_type", "1");
                    } else {
                        xfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -20;
                    }
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(xfVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        xfVar.h = sb.toString();
                    }
                    this.a.e(xfVar);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (IOException e22) {
                    e = e22;
                    xfVar = xfVar4;
                    xfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -19;
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(xfVar.h);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        xfVar.h = sb.toString();
                    }
                    this.a.e(xfVar);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (Exception e23) {
                    e = e23;
                    xfVar = xfVar4;
                    try {
                        xfVar.h = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -10;
                        BdLog.e(e.getMessage());
                        if (!z3 && i8 == i9 - 1) {
                            sb = new StringBuilder();
                            sb.append(xfVar.h);
                            sb.append("|netAvailable:");
                            sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                            xfVar.h = sb.toString();
                        }
                        this.a.e(xfVar);
                        str3 = str2;
                        str4 = str3;
                        i11 = i10;
                        i6 = i9;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!z3 && i8 == i9 - 1) {
                            xfVar.h += "|netAvailable:" + BdNetTypeUtil.isNetworkAvailableForImmediately();
                        }
                        this.a.e(xfVar);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    xfVar = xfVar4;
                    if (!z3) {
                        xfVar.h += "|netAvailable:" + BdNetTypeUtil.isNetworkAvailableForImmediately();
                    }
                    this.a.e(xfVar);
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
        fg fgVar;
        xf xfVar;
        int i9;
        uf ufVar;
        uf ufVar2;
        uf ufVar3;
        uf ufVar4;
        boolean z3;
        boolean z4;
        uf ufVar5;
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
            if (((sf) ServiceManager.getService(sf.a)).isSwitchOn()) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if (((tf) ServiceManager.getService(tf.a)).qaHttpsTest()) {
                i8 = 0;
            } else {
                i8 = i7;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i10 = 1;
            int i11 = 0;
            boolean z5 = true;
            while (!this.a.c().a && z5 && i11 < i5 + i8) {
                xf xfVar2 = new xf();
                this.a.e(xfVar2);
                fg fgVar2 = new fg();
                zf b = this.a.b();
                if (i11 < i8) {
                    z = true;
                } else {
                    z = false;
                }
                fgVar2.a = b.k(z);
                if (i11 < i8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                fgVar2.d = z2;
                try {
                    this.c = i11;
                    xfVar2.e = i11 + 1;
                    xfVar2.v = i10;
                    a(i11);
                    uf ufVar6 = new uf(this.a);
                    this.b = ufVar6;
                    ufVar6.q(i11);
                    this.b.r(e);
                    uf ufVar7 = this.b;
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
                        ufVar7.k(z3, z4, i4, i6, xfVar2, fgVar2);
                    } catch (SocketException e2) {
                        e = e2;
                        fgVar = fgVar2;
                        xfVar = xfVar2;
                    } catch (SocketTimeoutException e3) {
                        e = e3;
                        fgVar = fgVar2;
                        xfVar = xfVar2;
                    } catch (IOException e4) {
                        e = e4;
                        fgVar = fgVar2;
                        xfVar = xfVar2;
                    } catch (Exception e5) {
                        e = e5;
                        fgVar = fgVar2;
                        xfVar = xfVar2;
                    } catch (Throwable th) {
                        th = th;
                        fgVar = fgVar2;
                        xfVar = xfVar2;
                    }
                } catch (SocketException e6) {
                    e = e6;
                    fgVar = fgVar2;
                    xfVar = xfVar2;
                    i9 = i11;
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    fgVar = fgVar2;
                    xfVar = xfVar2;
                    i9 = i11;
                } catch (IOException e8) {
                    e = e8;
                    fgVar = fgVar2;
                    xfVar = xfVar2;
                    i9 = i11;
                } catch (Exception e9) {
                    e = e9;
                    fgVar = fgVar2;
                    xfVar = xfVar2;
                    i9 = i11;
                } catch (Throwable th2) {
                    th = th2;
                    fgVar = fgVar2;
                    xfVar = xfVar2;
                }
                if (this.a.c().b != 200) {
                    xfVar = xfVar2;
                    try {
                        xfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9;
                        z5 = l(this.a.c().b);
                        fgVar = fgVar2;
                        try {
                            try {
                                try {
                                    fgVar.b = this.a.c().b;
                                    fgVar.c = "faild";
                                    if (this.d <= 0 && (ufVar5 = this.b) != null) {
                                        this.d = ufVar5.i();
                                    }
                                    xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.f(xfVar);
                                    fgVar.a();
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (this.d <= 0 && (ufVar4 = this.b) != null) {
                                        this.d = ufVar4.i();
                                    }
                                    xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.f(xfVar);
                                    fgVar.a();
                                    throw th;
                                }
                            } catch (Exception e10) {
                                e = e10;
                            }
                        } catch (SocketException e11) {
                            e = e11;
                            xfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -12;
                            fgVar.b = -12;
                            fgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(xfVar);
                            fgVar.a();
                            z5 = true;
                            i11 = i9 + 1;
                            i10 = 1;
                        } catch (SocketTimeoutException e12) {
                            e = e12;
                            xfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -13;
                            fgVar.b = -13;
                            fgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(xfVar);
                            fgVar.a();
                            z5 = true;
                            i11 = i9 + 1;
                            i10 = 1;
                        } catch (IOException e13) {
                            e = e13;
                            this.a.c().c = -19;
                            xfVar.h = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            fgVar.b = -19;
                            fgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                this.d = ufVar.i();
                            }
                            xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(xfVar);
                            fgVar.a();
                            i11 = i9 + 1;
                            i10 = 1;
                        }
                    } catch (SocketException e14) {
                        e = e14;
                        fgVar = fgVar2;
                    } catch (SocketTimeoutException e15) {
                        e = e15;
                        fgVar = fgVar2;
                    } catch (IOException e16) {
                        e = e16;
                        fgVar = fgVar2;
                    } catch (Exception e17) {
                        e = e17;
                        fgVar = fgVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        fgVar = fgVar2;
                    }
                    i11 = i9 + 1;
                    i10 = 1;
                } else {
                    fgVar = fgVar2;
                    xfVar = xfVar2;
                    this.a.f(xfVar);
                    try {
                        fgVar.b = 0;
                        fgVar.c = DnsModel.MSG_OK;
                        if (this.d <= 0) {
                            ufVar3 = this.b;
                        }
                        xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(xfVar);
                        fgVar.a();
                        return;
                    } catch (SocketException e18) {
                        e = e18;
                        xfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.c().c = -12;
                        fgVar.b = -12;
                        fgVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                            ufVar2 = this.b;
                        }
                        xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(xfVar);
                        fgVar.a();
                        z5 = true;
                        i11 = i9 + 1;
                        i10 = 1;
                    } catch (SocketTimeoutException e19) {
                        e = e19;
                        xfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.c().c = -13;
                        fgVar.b = -13;
                        fgVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                            ufVar2 = this.b;
                        }
                        xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(xfVar);
                        fgVar.a();
                        z5 = true;
                        i11 = i9 + 1;
                        i10 = 1;
                    } catch (IOException e20) {
                        e = e20;
                        this.a.c().c = -19;
                        xfVar.h = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        fgVar.b = -19;
                        fgVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0 && (ufVar = this.b) != null) {
                            this.d = ufVar.i();
                        }
                        xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(xfVar);
                        fgVar.a();
                        i11 = i9 + 1;
                        i10 = 1;
                    }
                }
                e = e10;
                xfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i9 + "|" + e.getClass() + "|" + e.getMessage();
                this.a.c().c = -10;
                BdLog.e(e.getMessage());
                fgVar.b = -10;
                fgVar.c = Log.getStackTraceString(e);
                if (this.d <= 0) {
                    ufVar3 = this.b;
                }
                xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                this.a.f(xfVar);
                fgVar.a();
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
        fg fgVar;
        xf xfVar;
        int i10;
        int i11;
        int i12;
        int i13;
        uf ufVar;
        uf ufVar2;
        boolean z3;
        uf ufVar3;
        boolean z4;
        boolean z5;
        uf ufVar4;
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
            if (((sf) ServiceManager.getService(sf.a)).isSwitchOn()) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if (((tf) ServiceManager.getService(tf.a)).qaHttpsTest()) {
                i8 = 0;
            } else {
                i8 = i7;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i14 = 1;
            boolean z6 = true;
            int i15 = 0;
            while (!this.a.c().a && z6 && i15 < i5 + i8) {
                xf xfVar2 = new xf();
                fg fgVar2 = new fg();
                zf b = this.a.b();
                if (i15 < i8) {
                    z = true;
                } else {
                    z = false;
                }
                fgVar2.a = b.k(z);
                if (i15 < i8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                fgVar2.d = z2;
                this.c = i15;
                int i16 = i15 + 1;
                xfVar2.e = i16;
                a(i15);
                try {
                    try {
                        try {
                            uf ufVar5 = new uf(this.a);
                            this.b = ufVar5;
                            ufVar5.q(i15);
                            this.b.r(e);
                            uf ufVar6 = this.b;
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
                                ufVar6.p(z4, z5, i4, i6, xfVar2, fgVar2);
                            } catch (UnsupportedOperationException e2) {
                                e = e2;
                                fgVar = fgVar2;
                                xfVar = xfVar2;
                            } catch (SocketException e3) {
                                e = e3;
                                fgVar = fgVar2;
                                xfVar = xfVar2;
                            } catch (SocketTimeoutException e4) {
                                e = e4;
                                fgVar = fgVar2;
                                xfVar = xfVar2;
                            } catch (Throwable th) {
                                th = th;
                                fgVar = fgVar2;
                                xfVar = xfVar2;
                            }
                        } catch (UnsupportedOperationException e5) {
                            e = e5;
                            i9 = i16;
                            fgVar = fgVar2;
                            xfVar = xfVar2;
                            i12 = i15;
                        } catch (SocketException e6) {
                            e = e6;
                            i9 = i16;
                            fgVar = fgVar2;
                            xfVar = xfVar2;
                        } catch (SocketTimeoutException e7) {
                            e = e7;
                            i9 = i16;
                            fgVar = fgVar2;
                            xfVar = xfVar2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i9 = i16;
                        fgVar = fgVar2;
                        xfVar = xfVar2;
                        i12 = i15;
                    }
                } catch (UnsupportedOperationException e8) {
                    e = e8;
                    i9 = i16;
                    fgVar = fgVar2;
                    xfVar = xfVar2;
                    i12 = i15;
                    i13 = R.string.obfuscated_res_0x7f0f0df3;
                } catch (SocketException e9) {
                    e = e9;
                    i9 = i16;
                    fgVar = fgVar2;
                    xfVar = xfVar2;
                    i11 = R.string.obfuscated_res_0x7f0f0df3;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                    i9 = i16;
                    fgVar = fgVar2;
                    xfVar = xfVar2;
                    i10 = R.string.obfuscated_res_0x7f0f0df3;
                }
                if (this.a.c().b != 200) {
                    xfVar = xfVar2;
                    try {
                        xfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i12;
                        z6 = l(this.a.c().b);
                        this.a.e(xfVar);
                        fgVar = fgVar2;
                        try {
                            try {
                                fgVar.b = this.a.c().b;
                                fgVar.c = "faild";
                                if (this.d <= 0 && (ufVar4 = this.b) != null) {
                                    this.d = ufVar4.i();
                                }
                                xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(xfVar);
                                fgVar.a();
                            } catch (UnsupportedOperationException e11) {
                                e = e11;
                                i13 = R.string.obfuscated_res_0x7f0f0df3;
                                if (i12 >= i8) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                this.a.c().c = -14;
                                ag c = this.a.c();
                                c.g = e.getMessage() + Log.getStackTraceString(e);
                                xfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                                this.a.e(xfVar);
                                fgVar.b = -14;
                                fgVar.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    ufVar3 = this.b;
                                }
                                xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(xfVar);
                                fgVar.a();
                                z6 = z3;
                                i15 = i9;
                                i14 = 1;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    this.a.c().c = -10;
                                    ag c2 = this.a.c();
                                    c2.g = th.getMessage() + Log.getStackTraceString(th);
                                    if (i12 >= i8) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    xfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0df3);
                                    BdLog.e(th.getMessage());
                                    this.a.e(xfVar);
                                    fgVar.b = -10;
                                    fgVar.c = Log.getStackTraceString(th);
                                    if (this.d <= 0) {
                                        ufVar3 = this.b;
                                    }
                                    xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(xfVar);
                                    fgVar.a();
                                    z6 = z3;
                                    i15 = i9;
                                    i14 = 1;
                                } finally {
                                    if (this.d <= 0 && (ufVar2 = this.b) != null) {
                                        this.d = ufVar2.i();
                                    }
                                    xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(xfVar);
                                    fgVar.a();
                                }
                            }
                        } catch (SocketException e12) {
                            e = e12;
                            i11 = R.string.obfuscated_res_0x7f0f0df3;
                            this.a.c().c = -12;
                            ag c3 = this.a.c();
                            c3.g = e.getMessage() + Log.getStackTraceString(e);
                            xfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i11);
                            BdLog.e(e.getMessage());
                            this.a.e(xfVar);
                            fgVar.b = -12;
                            fgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                ufVar = this.b;
                            }
                            xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(xfVar);
                            fgVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        } catch (SocketTimeoutException e13) {
                            e = e13;
                            i10 = R.string.obfuscated_res_0x7f0f0df3;
                            this.a.c().c = -13;
                            ag c4 = this.a.c();
                            c4.g = e.getMessage() + Log.getStackTraceString(e);
                            xfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i10);
                            BdLog.e(e.getMessage());
                            this.a.e(xfVar);
                            fgVar.b = -13;
                            fgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                ufVar = this.b;
                            }
                            xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(xfVar);
                            fgVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        }
                    } catch (UnsupportedOperationException e14) {
                        e = e14;
                        fgVar = fgVar2;
                    } catch (SocketException e15) {
                        e = e15;
                        fgVar = fgVar2;
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        fgVar = fgVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        fgVar = fgVar2;
                    }
                    i15 = i9;
                    i14 = 1;
                } else {
                    fgVar = fgVar2;
                    xfVar = xfVar2;
                    try {
                        fgVar.b = 0;
                        fgVar.c = DnsModel.MSG_OK;
                        return;
                    } catch (UnsupportedOperationException e17) {
                        e = e17;
                        i13 = R.string.obfuscated_res_0x7f0f0df3;
                        if (i12 >= i8) {
                        }
                        this.a.c().c = -14;
                        ag c5 = this.a.c();
                        c5.g = e.getMessage() + Log.getStackTraceString(e);
                        xfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                        this.a.e(xfVar);
                        fgVar.b = -14;
                        fgVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                        }
                        xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(xfVar);
                        fgVar.a();
                        z6 = z3;
                        i15 = i9;
                        i14 = 1;
                    } catch (Throwable th5) {
                        th = th5;
                        this.a.c().c = -10;
                        ag c22 = this.a.c();
                        c22.g = th.getMessage() + Log.getStackTraceString(th);
                        if (i12 >= i8) {
                        }
                        xfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0df3);
                        BdLog.e(th.getMessage());
                        this.a.e(xfVar);
                        fgVar.b = -10;
                        fgVar.c = Log.getStackTraceString(th);
                        if (this.d <= 0) {
                        }
                        xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(xfVar);
                        fgVar.a();
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
        fg fgVar;
        xf xfVar;
        int i10;
        int i11;
        int i12;
        int i13;
        uf ufVar;
        uf ufVar2;
        boolean z3;
        uf ufVar3;
        boolean z4;
        boolean z5;
        uf ufVar4;
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
            if (((sf) ServiceManager.getService(sf.a)).isSwitchOn()) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if (((tf) ServiceManager.getService(tf.a)).qaHttpsTest()) {
                i8 = 0;
            } else {
                i8 = i7;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i14 = 1;
            boolean z6 = true;
            int i15 = 0;
            while (!this.a.c().a && z6 && i15 < i5 + i8) {
                xf xfVar2 = new xf();
                fg fgVar2 = new fg();
                zf b = this.a.b();
                if (i15 < i8) {
                    z = true;
                } else {
                    z = false;
                }
                fgVar2.a = b.k(z);
                if (i15 < i8) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                fgVar2.d = z2;
                int i16 = i15 + 1;
                xfVar2.e = i16;
                this.c = i15;
                a(i15);
                try {
                    try {
                        try {
                            uf ufVar5 = new uf(this.a);
                            this.b = ufVar5;
                            ufVar5.q(i15);
                            this.b.r(e);
                            uf ufVar6 = this.b;
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
                                ufVar6.o(z4, z5, i4, i6, xfVar2, fgVar2);
                            } catch (UnsupportedOperationException e2) {
                                e = e2;
                                fgVar = fgVar2;
                                xfVar = xfVar2;
                            } catch (SocketException e3) {
                                e = e3;
                                fgVar = fgVar2;
                                xfVar = xfVar2;
                            } catch (SocketTimeoutException e4) {
                                e = e4;
                                fgVar = fgVar2;
                                xfVar = xfVar2;
                            } catch (Throwable th) {
                                th = th;
                                fgVar = fgVar2;
                                xfVar = xfVar2;
                            }
                        } catch (UnsupportedOperationException e5) {
                            e = e5;
                            i9 = i16;
                            fgVar = fgVar2;
                            xfVar = xfVar2;
                            i12 = i15;
                        } catch (SocketException e6) {
                            e = e6;
                            i9 = i16;
                            fgVar = fgVar2;
                            xfVar = xfVar2;
                        } catch (SocketTimeoutException e7) {
                            e = e7;
                            i9 = i16;
                            fgVar = fgVar2;
                            xfVar = xfVar2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i9 = i16;
                        fgVar = fgVar2;
                        xfVar = xfVar2;
                        i12 = i15;
                    }
                } catch (UnsupportedOperationException e8) {
                    e = e8;
                    i9 = i16;
                    fgVar = fgVar2;
                    xfVar = xfVar2;
                    i12 = i15;
                    i13 = R.string.obfuscated_res_0x7f0f0df3;
                } catch (SocketException e9) {
                    e = e9;
                    i9 = i16;
                    fgVar = fgVar2;
                    xfVar = xfVar2;
                    i11 = R.string.obfuscated_res_0x7f0f0df3;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                    i9 = i16;
                    fgVar = fgVar2;
                    xfVar = xfVar2;
                    i10 = R.string.obfuscated_res_0x7f0f0df3;
                }
                if (this.a.c().b != 200) {
                    xfVar = xfVar2;
                    try {
                        xfVar.h = String.valueOf(this.a.c().b) + "|retryCount:" + i12;
                        z6 = l(this.a.c().b);
                        this.a.e(xfVar);
                        fgVar = fgVar2;
                        try {
                            try {
                                fgVar.b = this.a.c().b;
                                fgVar.c = "faild";
                                if (this.d <= 0 && (ufVar4 = this.b) != null) {
                                    this.d = ufVar4.i();
                                }
                                xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(xfVar);
                                fgVar.a();
                            } catch (UnsupportedOperationException e11) {
                                e = e11;
                                i13 = R.string.obfuscated_res_0x7f0f0df3;
                                if (i12 >= i8) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                this.a.c().c = -14;
                                ag c = this.a.c();
                                c.g = e.getMessage() + Log.getStackTraceString(e);
                                xfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                                this.a.e(xfVar);
                                fgVar.b = -14;
                                fgVar.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    ufVar3 = this.b;
                                }
                                xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(xfVar);
                                fgVar.a();
                                z6 = z3;
                                i15 = i9;
                                i14 = 1;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    this.a.c().c = -10;
                                    ag c2 = this.a.c();
                                    c2.g = th.getMessage() + Log.getStackTraceString(th);
                                    if (i12 >= i8) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    xfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0df3);
                                    BdLog.e(th.getMessage());
                                    this.a.e(xfVar);
                                    fgVar.b = -10;
                                    fgVar.c = Log.getStackTraceString(th);
                                    if (this.d <= 0) {
                                        ufVar3 = this.b;
                                    }
                                    xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(xfVar);
                                    fgVar.a();
                                    z6 = z3;
                                    i15 = i9;
                                    i14 = 1;
                                } finally {
                                    if (this.d <= 0 && (ufVar2 = this.b) != null) {
                                        this.d = ufVar2.i();
                                    }
                                    xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.e(xfVar);
                                    fgVar.a();
                                }
                            }
                        } catch (SocketException e12) {
                            e = e12;
                            i11 = R.string.obfuscated_res_0x7f0f0df3;
                            this.a.c().c = -12;
                            ag c3 = this.a.c();
                            c3.g = e.getMessage() + Log.getStackTraceString(e);
                            xfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i11);
                            BdLog.e(e.getMessage());
                            this.a.e(xfVar);
                            fgVar.b = -12;
                            fgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                ufVar = this.b;
                            }
                            xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(xfVar);
                            fgVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        } catch (SocketTimeoutException e13) {
                            e = e13;
                            i10 = R.string.obfuscated_res_0x7f0f0df3;
                            this.a.c().c = -13;
                            ag c4 = this.a.c();
                            c4.g = e.getMessage() + Log.getStackTraceString(e);
                            xfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i10);
                            BdLog.e(e.getMessage());
                            this.a.e(xfVar);
                            fgVar.b = -13;
                            fgVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                ufVar = this.b;
                            }
                            xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(xfVar);
                            fgVar.a();
                            z6 = true;
                            i15 = i9;
                            i14 = 1;
                        }
                    } catch (UnsupportedOperationException e14) {
                        e = e14;
                        fgVar = fgVar2;
                    } catch (SocketException e15) {
                        e = e15;
                        fgVar = fgVar2;
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        fgVar = fgVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        fgVar = fgVar2;
                    }
                    i15 = i9;
                    i14 = 1;
                } else {
                    fgVar = fgVar2;
                    xfVar = xfVar2;
                    try {
                        fgVar.b = 0;
                        fgVar.c = DnsModel.MSG_OK;
                        return;
                    } catch (UnsupportedOperationException e17) {
                        e = e17;
                        i13 = R.string.obfuscated_res_0x7f0f0df3;
                        if (i12 >= i8) {
                        }
                        this.a.c().c = -14;
                        ag c5 = this.a.c();
                        c5.g = e.getMessage() + Log.getStackTraceString(e);
                        xfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i13);
                        this.a.e(xfVar);
                        fgVar.b = -14;
                        fgVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                        }
                        xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(xfVar);
                        fgVar.a();
                        z6 = z3;
                        i15 = i9;
                        i14 = 1;
                    } catch (Throwable th5) {
                        th = th5;
                        this.a.c().c = -10;
                        ag c22 = this.a.c();
                        c22.g = th.getMessage() + Log.getStackTraceString(th);
                        if (i12 >= i8) {
                        }
                        xfVar.h = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0df3);
                        BdLog.e(th.getMessage());
                        this.a.e(xfVar);
                        fgVar.b = -10;
                        fgVar.c = Log.getStackTraceString(th);
                        if (this.d <= 0) {
                        }
                        xfVar.f = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(xfVar);
                        fgVar.a();
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
