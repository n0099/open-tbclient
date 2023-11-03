package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.TbadkCore;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.network.http.BdHttpStat;
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
/* loaded from: classes9.dex */
public class za {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean e = true;
    public transient /* synthetic */ FieldHolder $fh;
    public bb a;
    public ya b;
    public int c;
    public long d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448323430, "Lcom/baidu/tieba/za;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448323430, "Lcom/baidu/tieba/za;");
        }
    }

    public final boolean l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? (i == 502 || i == 503 || i == 504 || i == 404) ? false : true : invokeI.booleanValue;
    }

    public za(bb bbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bbVar};
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
        this.a = bbVar;
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
        ya yaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (yaVar = this.b) != null) {
            yaVar.b();
        }
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ya yaVar = this.b;
            if (yaVar == null) {
                return -1L;
            }
            return yaVar.e();
        }
        return invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ya yaVar = this.b;
            if (yaVar == null) {
                return -1L;
            }
            return yaVar.h();
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
            ya yaVar = this.b;
            if (yaVar == null) {
                return -1L;
            }
            return yaVar.i();
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ya yaVar = this.b;
            if (yaVar == null) {
                return -1L;
            }
            return yaVar.l();
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ya yaVar = this.b;
            if (yaVar == null) {
                return -1L;
            }
            return yaVar.j();
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
            bb bbVar = this.a;
            if (bbVar == null) {
                return false;
            }
            return bbVar.c().a;
        }
        return invokeV.booleanValue;
    }

    public void p() {
        bb bbVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || (bbVar = this.a) == null) {
            return;
        }
        bbVar.c().a = true;
    }

    public boolean c(String str, eb ebVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i5;
        int i6;
        int i7;
        BdHttpStat bdHttpStat;
        int i8;
        int i9;
        String str2;
        int i10;
        BdHttpStat bdHttpStat2;
        String str3;
        StringBuilder sb;
        StringBuilder sb2;
        BdHttpStat bdHttpStat3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, ebVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String str4 = "responseCode:";
            if (i3 <= 0) {
                i5 = y6.d().b().b();
            } else {
                i5 = i3;
            }
            if (i <= 0) {
                i6 = y6.d().a();
            } else {
                i6 = i;
            }
            if (i4 <= 0) {
                i7 = y6.d().c().b();
            } else {
                i7 = i4;
            }
            ya yaVar = new ya(this.a);
            this.b = yaVar;
            yaVar.r(e);
            int i11 = 0;
            boolean z3 = false;
            while (i11 < i6) {
                BdHttpStat bdHttpStat4 = new BdHttpStat();
                this.a.c().c = -1;
                this.b.q(i11);
                int i12 = i11 + 1;
                try {
                    try {
                        bdHttpStat4.retry = i12;
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
                            bdHttpStat2 = bdHttpStat4;
                            i8 = i11;
                            i9 = i6;
                        } catch (ConnectException e3) {
                            e = e3;
                            str2 = str4;
                            i10 = i12;
                            bdHttpStat2 = bdHttpStat4;
                            i8 = i11;
                            i9 = i6;
                        } catch (SocketException e4) {
                            e = e4;
                            str2 = str4;
                            i10 = i12;
                            bdHttpStat2 = bdHttpStat4;
                            i8 = i11;
                            i9 = i6;
                        } catch (SocketTimeoutException e5) {
                            e = e5;
                            str2 = str4;
                            i10 = i12;
                            bdHttpStat2 = bdHttpStat4;
                            i8 = i11;
                            i9 = i6;
                        }
                    } catch (IllegalStateException e6) {
                        e = e6;
                        str3 = str4;
                        i10 = i12;
                        bdHttpStat2 = bdHttpStat4;
                        i8 = i11;
                        i9 = i6;
                    } catch (ConnectException e7) {
                        e = e7;
                        str3 = str4;
                        i10 = i12;
                        bdHttpStat2 = bdHttpStat4;
                        i8 = i11;
                        i9 = i6;
                    } catch (SocketException e8) {
                        e = e8;
                        str3 = str4;
                        i10 = i12;
                        bdHttpStat2 = bdHttpStat4;
                        i8 = i11;
                        i9 = i6;
                    } catch (SocketTimeoutException e9) {
                        e = e9;
                        str3 = str4;
                        i10 = i12;
                        bdHttpStat2 = bdHttpStat4;
                        i8 = i11;
                        i9 = i6;
                    }
                } catch (FileNotFoundException e10) {
                    e = e10;
                    str2 = str4;
                    i10 = i12;
                    bdHttpStat2 = bdHttpStat4;
                    i8 = i11;
                    i9 = i6;
                } catch (UnknownHostException e11) {
                    e = e11;
                    str2 = str4;
                    i10 = i12;
                    bdHttpStat = bdHttpStat4;
                    i8 = i11;
                    i9 = i6;
                } catch (SSLException e12) {
                    e = e12;
                    str2 = str4;
                    i10 = i12;
                    bdHttpStat = bdHttpStat4;
                    i8 = i11;
                    i9 = i6;
                } catch (IOException e13) {
                    e = e13;
                    str2 = str4;
                    i10 = i12;
                    bdHttpStat = bdHttpStat4;
                    i8 = i11;
                    i9 = i6;
                } catch (Exception e14) {
                    e = e14;
                    str2 = str4;
                    i10 = i12;
                    bdHttpStat = bdHttpStat4;
                    i8 = i11;
                    i9 = i6;
                } catch (Throwable th) {
                    th = th;
                    bdHttpStat = bdHttpStat4;
                    i8 = i11;
                    i9 = i6;
                }
                try {
                    z3 = this.b.d(str, ebVar, i5, i7, z, bdHttpStat4, z2);
                    if (!z3 && this.a.c().a) {
                        this.a.c().c = -14;
                    }
                    if (!z3 && i8 == i9 - 1) {
                        StringBuilder sb3 = new StringBuilder();
                        bdHttpStat3 = bdHttpStat4;
                        sb3.append(bdHttpStat3.exception);
                        sb3.append("|netAvailable:");
                        sb3.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bdHttpStat3.exception = sb3.toString();
                    } else {
                        bdHttpStat3 = bdHttpStat4;
                    }
                    this.a.e(bdHttpStat3);
                    return z3;
                } catch (FileNotFoundException e15) {
                    e = e15;
                    bdHttpStat2 = bdHttpStat4;
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
                    bdHttpStat2.exception = sb4.toString();
                    this.a.c().c = -100;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(bdHttpStat2.exception);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bdHttpStat2.exception = sb2.toString();
                    }
                    this.a.e(bdHttpStat2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (IllegalStateException e16) {
                    e = e16;
                    bdHttpStat2 = bdHttpStat4;
                    str3 = str2;
                    bdHttpStat2.exception = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage() + "|getcontent_illegal_error";
                    this.a.c().c = -19;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(bdHttpStat2.exception);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bdHttpStat2.exception = sb2.toString();
                    }
                    this.a.e(bdHttpStat2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (ConnectException e17) {
                    e = e17;
                    bdHttpStat2 = bdHttpStat4;
                    str3 = str2;
                    bdHttpStat2.exception = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -22;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(bdHttpStat2.exception);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bdHttpStat2.exception = sb2.toString();
                    }
                    this.a.e(bdHttpStat2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SocketException e18) {
                    e = e18;
                    bdHttpStat2 = bdHttpStat4;
                    str3 = str2;
                    bdHttpStat2.exception = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -12;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(bdHttpStat2.exception);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bdHttpStat2.exception = sb2.toString();
                    }
                    this.a.e(bdHttpStat2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SocketTimeoutException e19) {
                    e = e19;
                    bdHttpStat2 = bdHttpStat4;
                    str3 = str2;
                    bdHttpStat2.exception = str3 + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -13;
                    if (!z3 && i8 == i9 - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(bdHttpStat2.exception);
                        sb2.append("|netAvailable:");
                        sb2.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bdHttpStat2.exception = sb2.toString();
                    }
                    this.a.e(bdHttpStat2);
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (UnknownHostException e20) {
                    e = e20;
                    bdHttpStat = bdHttpStat4;
                    bdHttpStat.exception = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -21;
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(bdHttpStat.exception);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bdHttpStat.exception = sb.toString();
                    }
                    this.a.e(bdHttpStat);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (SSLException e21) {
                    e = e21;
                    bdHttpStat = bdHttpStat4;
                    if (this.a.b().e() && i8 < i9 - 1) {
                        ((TbadkCore) ServiceManager.getService(TbadkCore.SERVICE_REFERENCE)).statHttpsDownToHttp();
                    } else {
                        bdHttpStat.exception = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -20;
                    }
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(bdHttpStat.exception);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bdHttpStat.exception = sb.toString();
                    }
                    this.a.e(bdHttpStat);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (IOException e22) {
                    e = e22;
                    bdHttpStat = bdHttpStat4;
                    bdHttpStat.exception = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                    this.a.c().c = -19;
                    if (!z3 && i8 == i9 - 1) {
                        sb = new StringBuilder();
                        sb.append(bdHttpStat.exception);
                        sb.append("|netAvailable:");
                        sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                        bdHttpStat.exception = sb.toString();
                    }
                    this.a.e(bdHttpStat);
                    str3 = str2;
                    str4 = str3;
                    i11 = i10;
                    i6 = i9;
                } catch (Exception e23) {
                    e = e23;
                    bdHttpStat = bdHttpStat4;
                    try {
                        bdHttpStat.exception = "errorCode:" + String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass().getName() + "|" + e.getMessage();
                        this.a.c().c = -10;
                        BdLog.e(e.getMessage());
                        if (!z3 && i8 == i9 - 1) {
                            sb = new StringBuilder();
                            sb.append(bdHttpStat.exception);
                            sb.append("|netAvailable:");
                            sb.append(BdNetTypeUtil.isNetworkAvailableForImmediately());
                            bdHttpStat.exception = sb.toString();
                        }
                        this.a.e(bdHttpStat);
                        str3 = str2;
                        str4 = str3;
                        i11 = i10;
                        i6 = i9;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!z3 && i8 == i9 - 1) {
                            bdHttpStat.exception += "|netAvailable:" + BdNetTypeUtil.isNetworkAvailableForImmediately();
                        }
                        this.a.e(bdHttpStat);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bdHttpStat = bdHttpStat4;
                    if (!z3) {
                        bdHttpStat.exception += "|netAvailable:" + BdNetTypeUtil.isNetworkAvailableForImmediately();
                    }
                    this.a.e(bdHttpStat);
                    throw th;
                }
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x0216, code lost:
        if (r0 != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02db, code lost:
        if (r0 != null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0333, code lost:
        if (r0 != null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0335, code lost:
        r22.d = r0.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0168, code lost:
        if (r0 != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x016a, code lost:
        r22.d = r0.i();
     */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0331  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        boolean z2;
        ib ibVar;
        BdHttpStat bdHttpStat;
        int i8;
        ya yaVar;
        ya yaVar2;
        ya yaVar3;
        ya yaVar4;
        boolean z3;
        boolean z4;
        ya yaVar5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048579, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i4 = y6.d().b().b();
            } else {
                i4 = i2;
            }
            if (i <= 0) {
                i5 = y6.d().a();
            } else {
                i5 = i;
            }
            if (i3 <= 0) {
                i6 = y6.d().c().b();
            } else {
                i6 = i3;
            }
            if (((xa) ServiceManager.getService(xa.a)).qaHttpsTest()) {
                i7 = 0;
            } else {
                i7 = 2;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i9 = 1;
            int i10 = 0;
            boolean z5 = true;
            while (!this.a.c().a && z5 && i10 < i5 + i7) {
                BdHttpStat bdHttpStat2 = new BdHttpStat();
                this.a.e(bdHttpStat2);
                ib ibVar2 = new ib();
                cb b = this.a.b();
                if (i10 < i7) {
                    z = true;
                } else {
                    z = false;
                }
                ibVar2.a = b.k(z);
                if (i10 < i7) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ibVar2.d = z2;
                try {
                    this.c = i10;
                    bdHttpStat2.retry = i10 + 1;
                    bdHttpStat2.netLibFlag = i9;
                    a(i10);
                    ya yaVar6 = new ya(this.a);
                    this.b = yaVar6;
                    yaVar6.q(i10);
                    this.b.r(e);
                    ya yaVar7 = this.b;
                    if (i10 < i7) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (i10 < i9) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    i8 = i10;
                    try {
                        yaVar7.k(z3, z4, i4, i6, bdHttpStat2, ibVar2);
                    } catch (SocketException e2) {
                        e = e2;
                        ibVar = ibVar2;
                        bdHttpStat = bdHttpStat2;
                    } catch (SocketTimeoutException e3) {
                        e = e3;
                        ibVar = ibVar2;
                        bdHttpStat = bdHttpStat2;
                    } catch (IOException e4) {
                        e = e4;
                        ibVar = ibVar2;
                        bdHttpStat = bdHttpStat2;
                    } catch (Exception e5) {
                        e = e5;
                        ibVar = ibVar2;
                        bdHttpStat = bdHttpStat2;
                    } catch (Throwable th) {
                        th = th;
                        ibVar = ibVar2;
                        bdHttpStat = bdHttpStat2;
                    }
                } catch (SocketException e6) {
                    e = e6;
                    ibVar = ibVar2;
                    bdHttpStat = bdHttpStat2;
                    i8 = i10;
                } catch (SocketTimeoutException e7) {
                    e = e7;
                    ibVar = ibVar2;
                    bdHttpStat = bdHttpStat2;
                    i8 = i10;
                } catch (IOException e8) {
                    e = e8;
                    ibVar = ibVar2;
                    bdHttpStat = bdHttpStat2;
                    i8 = i10;
                } catch (Exception e9) {
                    e = e9;
                    ibVar = ibVar2;
                    bdHttpStat = bdHttpStat2;
                    i8 = i10;
                } catch (Throwable th2) {
                    th = th2;
                    ibVar = ibVar2;
                    bdHttpStat = bdHttpStat2;
                }
                if (this.a.c().b != 200) {
                    bdHttpStat = bdHttpStat2;
                    try {
                        bdHttpStat.exception = String.valueOf(this.a.c().b) + "|retryCount:" + i8;
                        z5 = l(this.a.c().b);
                        ibVar = ibVar2;
                        try {
                            try {
                                try {
                                    ibVar.b = this.a.c().b;
                                    ibVar.c = "faild";
                                    if (this.d <= 0 && (yaVar5 = this.b) != null) {
                                        this.d = yaVar5.i();
                                    }
                                    bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                                    this.a.f(bdHttpStat);
                                    ibVar.a();
                                } catch (Exception e10) {
                                    e = e10;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                if (this.d <= 0 && (yaVar3 = this.b) != null) {
                                    this.d = yaVar3.i();
                                }
                                bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                                this.a.f(bdHttpStat);
                                ibVar.a();
                                throw th;
                            }
                        } catch (SocketException e11) {
                            e = e11;
                            bdHttpStat.exception = String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -12;
                            ibVar.b = -12;
                            ibVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(bdHttpStat);
                            ibVar.a();
                            z5 = true;
                            i10 = i8 + 1;
                            i9 = 1;
                        } catch (SocketTimeoutException e12) {
                            e = e12;
                            bdHttpStat.exception = String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass() + "|" + e.getMessage();
                            this.a.c().c = -13;
                            ibVar.b = -13;
                            ibVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(bdHttpStat);
                            ibVar.a();
                            z5 = true;
                            i10 = i8 + 1;
                            i9 = 1;
                        } catch (IOException e13) {
                            e = e13;
                            this.a.c().c = -19;
                            bdHttpStat.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            ibVar.b = -19;
                            ibVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                                this.d = yaVar.i();
                            }
                            bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                            this.a.f(bdHttpStat);
                            ibVar.a();
                            i10 = i8 + 1;
                            i9 = 1;
                        }
                    } catch (SocketException e14) {
                        e = e14;
                        ibVar = ibVar2;
                    } catch (SocketTimeoutException e15) {
                        e = e15;
                        ibVar = ibVar2;
                    } catch (IOException e16) {
                        e = e16;
                        ibVar = ibVar2;
                    } catch (Exception e17) {
                        e = e17;
                        ibVar = ibVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        ibVar = ibVar2;
                        if (this.d <= 0) {
                            this.d = yaVar3.i();
                        }
                        bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(bdHttpStat);
                        ibVar.a();
                        throw th;
                    }
                    i10 = i8 + 1;
                    i9 = 1;
                } else {
                    ibVar = ibVar2;
                    bdHttpStat = bdHttpStat2;
                    this.a.f(bdHttpStat);
                    try {
                        ibVar.b = 0;
                        ibVar.c = DnsModel.MSG_OK;
                        if (this.d <= 0) {
                            yaVar4 = this.b;
                        }
                        bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(bdHttpStat);
                        ibVar.a();
                        return;
                    } catch (SocketException e18) {
                        e = e18;
                        bdHttpStat.exception = String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.c().c = -12;
                        ibVar.b = -12;
                        ibVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                            yaVar2 = this.b;
                        }
                        bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(bdHttpStat);
                        ibVar.a();
                        z5 = true;
                        i10 = i8 + 1;
                        i9 = 1;
                    } catch (SocketTimeoutException e19) {
                        e = e19;
                        bdHttpStat.exception = String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass() + "|" + e.getMessage();
                        this.a.c().c = -13;
                        ibVar.b = -13;
                        ibVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                            yaVar2 = this.b;
                        }
                        bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(bdHttpStat);
                        ibVar.a();
                        z5 = true;
                        i10 = i8 + 1;
                        i9 = 1;
                    } catch (IOException e20) {
                        e = e20;
                        this.a.c().c = -19;
                        bdHttpStat.exception = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        ibVar.b = -19;
                        ibVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0 && (yaVar = this.b) != null) {
                            this.d = yaVar.i();
                        }
                        bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                        this.a.f(bdHttpStat);
                        ibVar.a();
                        i10 = i8 + 1;
                        i9 = 1;
                    }
                }
                e = e10;
                bdHttpStat.exception = String.valueOf(this.a.c().b) + "|retryCount:" + i8 + "|" + e.getClass() + "|" + e.getMessage();
                this.a.c().c = -10;
                BdLog.e(e.getMessage());
                ibVar.b = -10;
                ibVar.c = Log.getStackTraceString(e);
                if (this.d <= 0) {
                    yaVar4 = this.b;
                }
                bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                this.a.f(bdHttpStat);
                ibVar.a();
                return;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CMP_L]}, finally: {[IGET, CMP_L, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, INVOKE, IPUT, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF, IGET, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0231, code lost:
        if (r0 != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0299, code lost:
        if (r0 != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x029b, code lost:
        r20.d = r0.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0318, code lost:
        if (r0 != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0380, code lost:
        if (r0 != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0382, code lost:
        r20.d = r0.i();
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0297  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        boolean z2;
        int i8;
        ib ibVar;
        BdHttpStat bdHttpStat;
        int i9;
        int i10;
        int i11;
        int i12;
        ya yaVar;
        boolean z3;
        ya yaVar2;
        ya yaVar3;
        boolean z4;
        boolean z5;
        ya yaVar4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048589, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i4 = y6.d().b().b();
            } else {
                i4 = i2;
            }
            if (i <= 0) {
                i5 = y6.d().a();
            } else {
                i5 = i;
            }
            if (i3 <= 0) {
                i6 = y6.d().c().b();
            } else {
                i6 = i3;
            }
            if (((xa) ServiceManager.getService(xa.a)).qaHttpsTest()) {
                i7 = 0;
            } else {
                i7 = 2;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i13 = 1;
            boolean z6 = true;
            int i14 = 0;
            while (!this.a.c().a && z6 && i14 < i5 + i7) {
                BdHttpStat bdHttpStat2 = new BdHttpStat();
                ib ibVar2 = new ib();
                cb b = this.a.b();
                if (i14 < i7) {
                    z = true;
                } else {
                    z = false;
                }
                ibVar2.a = b.k(z);
                if (i14 < i7) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ibVar2.d = z2;
                this.c = i14;
                int i15 = i14 + 1;
                bdHttpStat2.retry = i15;
                a(i14);
                try {
                    try {
                        try {
                            ya yaVar5 = new ya(this.a);
                            this.b = yaVar5;
                            yaVar5.q(i14);
                            this.b.r(e);
                            ya yaVar6 = this.b;
                            if (i14 < i7) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (i14 < i13) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            i8 = i15;
                            i11 = i14;
                            try {
                                yaVar6.p(z4, z5, i4, i6, bdHttpStat2, ibVar2);
                            } catch (UnsupportedOperationException e2) {
                                e = e2;
                                ibVar = ibVar2;
                                bdHttpStat = bdHttpStat2;
                            } catch (SocketException e3) {
                                e = e3;
                                ibVar = ibVar2;
                                bdHttpStat = bdHttpStat2;
                            } catch (SocketTimeoutException e4) {
                                e = e4;
                                ibVar = ibVar2;
                                bdHttpStat = bdHttpStat2;
                            } catch (Throwable th) {
                                th = th;
                                ibVar = ibVar2;
                                bdHttpStat = bdHttpStat2;
                            }
                        } catch (UnsupportedOperationException e5) {
                            e = e5;
                            i8 = i15;
                            ibVar = ibVar2;
                            bdHttpStat = bdHttpStat2;
                            i11 = i14;
                        } catch (SocketException e6) {
                            e = e6;
                            i8 = i15;
                            ibVar = ibVar2;
                            bdHttpStat = bdHttpStat2;
                        } catch (SocketTimeoutException e7) {
                            e = e7;
                            i8 = i15;
                            ibVar = ibVar2;
                            bdHttpStat = bdHttpStat2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i8 = i15;
                        ibVar = ibVar2;
                        bdHttpStat = bdHttpStat2;
                        i11 = i14;
                    }
                } catch (UnsupportedOperationException e8) {
                    e = e8;
                    i8 = i15;
                    ibVar = ibVar2;
                    bdHttpStat = bdHttpStat2;
                    i11 = i14;
                    i12 = R.string.obfuscated_res_0x7f0f0e61;
                } catch (SocketException e9) {
                    e = e9;
                    i8 = i15;
                    ibVar = ibVar2;
                    bdHttpStat = bdHttpStat2;
                    i10 = R.string.obfuscated_res_0x7f0f0e61;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                    i8 = i15;
                    ibVar = ibVar2;
                    bdHttpStat = bdHttpStat2;
                    i9 = R.string.obfuscated_res_0x7f0f0e61;
                }
                if (this.a.c().b != 200) {
                    bdHttpStat = bdHttpStat2;
                    try {
                        bdHttpStat.exception = String.valueOf(this.a.c().b) + "|retryCount:" + i11;
                        z6 = l(this.a.c().b);
                        this.a.e(bdHttpStat);
                        ibVar = ibVar2;
                        try {
                            try {
                                ibVar.b = this.a.c().b;
                                ibVar.c = "faild";
                                if (this.d <= 0 && (yaVar4 = this.b) != null) {
                                    this.d = yaVar4.i();
                                }
                                bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(bdHttpStat);
                                ibVar.a();
                            } catch (SocketException e11) {
                                e = e11;
                                i10 = R.string.obfuscated_res_0x7f0f0e61;
                                this.a.c().c = -12;
                                db c = this.a.c();
                                c.g = e.getMessage() + Log.getStackTraceString(e);
                                bdHttpStat.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i10);
                                BdLog.e(e.getMessage());
                                this.a.e(bdHttpStat);
                                ibVar.b = -12;
                                ibVar.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    yaVar3 = this.b;
                                }
                                bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(bdHttpStat);
                                ibVar.a();
                                z6 = true;
                                i14 = i8;
                                i13 = 1;
                            } catch (SocketTimeoutException e12) {
                                e = e12;
                                i9 = R.string.obfuscated_res_0x7f0f0e61;
                                this.a.c().c = -13;
                                db c2 = this.a.c();
                                c2.g = e.getMessage() + Log.getStackTraceString(e);
                                bdHttpStat.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                                BdLog.e(e.getMessage());
                                this.a.e(bdHttpStat);
                                ibVar.b = -13;
                                ibVar.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    yaVar3 = this.b;
                                }
                                bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(bdHttpStat);
                                ibVar.a();
                                z6 = true;
                                i14 = i8;
                                i13 = 1;
                            }
                        } catch (UnsupportedOperationException e13) {
                            e = e13;
                            i12 = R.string.obfuscated_res_0x7f0f0e61;
                            if (i11 >= i7) {
                            }
                            this.a.c().c = -14;
                            db c3 = this.a.c();
                            c3.g = e.getMessage() + Log.getStackTraceString(e);
                            bdHttpStat.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i12);
                            this.a.e(bdHttpStat);
                            ibVar.b = -14;
                            ibVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(bdHttpStat);
                            ibVar.a();
                            z6 = z3;
                            i14 = i8;
                            i13 = 1;
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                this.a.c().c = -10;
                                db c4 = this.a.c();
                                c4.g = th.getMessage() + Log.getStackTraceString(th);
                                if (i11 >= i7) {
                                }
                                bdHttpStat.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0e61);
                                BdLog.e(th.getMessage());
                                this.a.e(bdHttpStat);
                                ibVar.b = -10;
                                ibVar.c = Log.getStackTraceString(th);
                                if (this.d <= 0) {
                                }
                                bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(bdHttpStat);
                                ibVar.a();
                                z6 = z3;
                                i14 = i8;
                                i13 = 1;
                            } finally {
                                if (this.d <= 0 && (yaVar = this.b) != null) {
                                    this.d = yaVar.i();
                                }
                                bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(bdHttpStat);
                                ibVar.a();
                            }
                        }
                    } catch (UnsupportedOperationException e14) {
                        e = e14;
                        ibVar = ibVar2;
                    } catch (SocketException e15) {
                        e = e15;
                        ibVar = ibVar2;
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        ibVar = ibVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        ibVar = ibVar2;
                    }
                    i14 = i8;
                    i13 = 1;
                } else {
                    ibVar = ibVar2;
                    bdHttpStat = bdHttpStat2;
                    try {
                        ibVar.b = 0;
                        ibVar.c = DnsModel.MSG_OK;
                        return;
                    } catch (UnsupportedOperationException e17) {
                        e = e17;
                        i12 = R.string.obfuscated_res_0x7f0f0e61;
                        if (i11 >= i7) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        this.a.c().c = -14;
                        db c32 = this.a.c();
                        c32.g = e.getMessage() + Log.getStackTraceString(e);
                        bdHttpStat.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i12);
                        this.a.e(bdHttpStat);
                        ibVar.b = -14;
                        ibVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                            yaVar2 = this.b;
                        }
                        bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(bdHttpStat);
                        ibVar.a();
                        z6 = z3;
                        i14 = i8;
                        i13 = 1;
                    } catch (Throwable th5) {
                        th = th5;
                        this.a.c().c = -10;
                        db c42 = this.a.c();
                        c42.g = th.getMessage() + Log.getStackTraceString(th);
                        if (i11 >= i7) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        bdHttpStat.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0e61);
                        BdLog.e(th.getMessage());
                        this.a.e(bdHttpStat);
                        ibVar.b = -10;
                        ibVar.c = Log.getStackTraceString(th);
                        if (this.d <= 0) {
                            yaVar2 = this.b;
                        }
                        bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(bdHttpStat);
                        ibVar.a();
                        z6 = z3;
                        i14 = i8;
                        i13 = 1;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CMP_L]}, finally: {[IGET, CMP_L, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, INVOKE, IPUT, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF, IGET, INVOKE, ARITH, IPUT, IGET, INVOKE, INVOKE, IF] complete} */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0231, code lost:
        if (r0 != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0299, code lost:
        if (r0 != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x029b, code lost:
        r20.d = r0.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0318, code lost:
        if (r0 != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0380, code lost:
        if (r0 != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0382, code lost:
        r20.d = r0.i();
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0297  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        boolean z2;
        int i8;
        ib ibVar;
        BdHttpStat bdHttpStat;
        int i9;
        int i10;
        int i11;
        int i12;
        ya yaVar;
        boolean z3;
        ya yaVar2;
        ya yaVar3;
        boolean z4;
        boolean z5;
        ya yaVar4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048590, this, i, i2, i3) == null) {
            if (i2 <= 0) {
                i4 = y6.d().b().b();
            } else {
                i4 = i2;
            }
            if (i <= 0) {
                i5 = y6.d().a();
            } else {
                i5 = i;
            }
            if (i3 <= 0) {
                i6 = y6.d().c().b();
            } else {
                i6 = i3;
            }
            if (((xa) ServiceManager.getService(xa.a)).qaHttpsTest()) {
                i7 = 0;
            } else {
                i7 = 2;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i13 = 1;
            boolean z6 = true;
            int i14 = 0;
            while (!this.a.c().a && z6 && i14 < i5 + i7) {
                BdHttpStat bdHttpStat2 = new BdHttpStat();
                ib ibVar2 = new ib();
                cb b = this.a.b();
                if (i14 < i7) {
                    z = true;
                } else {
                    z = false;
                }
                ibVar2.a = b.k(z);
                if (i14 < i7) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ibVar2.d = z2;
                int i15 = i14 + 1;
                bdHttpStat2.retry = i15;
                this.c = i14;
                a(i14);
                try {
                    try {
                        try {
                            ya yaVar5 = new ya(this.a);
                            this.b = yaVar5;
                            yaVar5.q(i14);
                            this.b.r(e);
                            ya yaVar6 = this.b;
                            if (i14 < i7) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (i14 < i13) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            i8 = i15;
                            i11 = i14;
                            try {
                                yaVar6.o(z4, z5, i4, i6, bdHttpStat2, ibVar2);
                            } catch (UnsupportedOperationException e2) {
                                e = e2;
                                ibVar = ibVar2;
                                bdHttpStat = bdHttpStat2;
                            } catch (SocketException e3) {
                                e = e3;
                                ibVar = ibVar2;
                                bdHttpStat = bdHttpStat2;
                            } catch (SocketTimeoutException e4) {
                                e = e4;
                                ibVar = ibVar2;
                                bdHttpStat = bdHttpStat2;
                            } catch (Throwable th) {
                                th = th;
                                ibVar = ibVar2;
                                bdHttpStat = bdHttpStat2;
                            }
                        } catch (UnsupportedOperationException e5) {
                            e = e5;
                            i8 = i15;
                            ibVar = ibVar2;
                            bdHttpStat = bdHttpStat2;
                            i11 = i14;
                        } catch (SocketException e6) {
                            e = e6;
                            i8 = i15;
                            ibVar = ibVar2;
                            bdHttpStat = bdHttpStat2;
                        } catch (SocketTimeoutException e7) {
                            e = e7;
                            i8 = i15;
                            ibVar = ibVar2;
                            bdHttpStat = bdHttpStat2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i8 = i15;
                        ibVar = ibVar2;
                        bdHttpStat = bdHttpStat2;
                        i11 = i14;
                    }
                } catch (UnsupportedOperationException e8) {
                    e = e8;
                    i8 = i15;
                    ibVar = ibVar2;
                    bdHttpStat = bdHttpStat2;
                    i11 = i14;
                    i12 = R.string.obfuscated_res_0x7f0f0e61;
                } catch (SocketException e9) {
                    e = e9;
                    i8 = i15;
                    ibVar = ibVar2;
                    bdHttpStat = bdHttpStat2;
                    i10 = R.string.obfuscated_res_0x7f0f0e61;
                } catch (SocketTimeoutException e10) {
                    e = e10;
                    i8 = i15;
                    ibVar = ibVar2;
                    bdHttpStat = bdHttpStat2;
                    i9 = R.string.obfuscated_res_0x7f0f0e61;
                }
                if (this.a.c().b != 200) {
                    bdHttpStat = bdHttpStat2;
                    try {
                        bdHttpStat.exception = String.valueOf(this.a.c().b) + "|retryCount:" + i11;
                        z6 = l(this.a.c().b);
                        this.a.e(bdHttpStat);
                        ibVar = ibVar2;
                        try {
                            try {
                                ibVar.b = this.a.c().b;
                                ibVar.c = "faild";
                                if (this.d <= 0 && (yaVar4 = this.b) != null) {
                                    this.d = yaVar4.i();
                                }
                                bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(bdHttpStat);
                                ibVar.a();
                            } catch (SocketException e11) {
                                e = e11;
                                i10 = R.string.obfuscated_res_0x7f0f0e61;
                                this.a.c().c = -12;
                                db c = this.a.c();
                                c.g = e.getMessage() + Log.getStackTraceString(e);
                                bdHttpStat.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i10);
                                BdLog.e(e.getMessage());
                                this.a.e(bdHttpStat);
                                ibVar.b = -12;
                                ibVar.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    yaVar3 = this.b;
                                }
                                bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(bdHttpStat);
                                ibVar.a();
                                z6 = true;
                                i14 = i8;
                                i13 = 1;
                            } catch (SocketTimeoutException e12) {
                                e = e12;
                                i9 = R.string.obfuscated_res_0x7f0f0e61;
                                this.a.c().c = -13;
                                db c2 = this.a.c();
                                c2.g = e.getMessage() + Log.getStackTraceString(e);
                                bdHttpStat.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i9);
                                BdLog.e(e.getMessage());
                                this.a.e(bdHttpStat);
                                ibVar.b = -13;
                                ibVar.c = Log.getStackTraceString(e);
                                if (this.d <= 0) {
                                    yaVar3 = this.b;
                                }
                                bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(bdHttpStat);
                                ibVar.a();
                                z6 = true;
                                i14 = i8;
                                i13 = 1;
                            }
                        } catch (UnsupportedOperationException e13) {
                            e = e13;
                            i12 = R.string.obfuscated_res_0x7f0f0e61;
                            if (i11 >= i7) {
                            }
                            this.a.c().c = -14;
                            db c3 = this.a.c();
                            c3.g = e.getMessage() + Log.getStackTraceString(e);
                            bdHttpStat.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i12);
                            this.a.e(bdHttpStat);
                            ibVar.b = -14;
                            ibVar.c = Log.getStackTraceString(e);
                            if (this.d <= 0) {
                            }
                            bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                            this.a.e(bdHttpStat);
                            ibVar.a();
                            z6 = z3;
                            i14 = i8;
                            i13 = 1;
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                this.a.c().c = -10;
                                db c4 = this.a.c();
                                c4.g = th.getMessage() + Log.getStackTraceString(th);
                                if (i11 >= i7) {
                                }
                                bdHttpStat.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0e61);
                                BdLog.e(th.getMessage());
                                this.a.e(bdHttpStat);
                                ibVar.b = -10;
                                ibVar.c = Log.getStackTraceString(th);
                                if (this.d <= 0) {
                                }
                                bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(bdHttpStat);
                                ibVar.a();
                                z6 = z3;
                                i14 = i8;
                                i13 = 1;
                            } finally {
                                if (this.d <= 0 && (yaVar = this.b) != null) {
                                    this.d = yaVar.i();
                                }
                                bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                                this.a.e(bdHttpStat);
                                ibVar.a();
                            }
                        }
                    } catch (UnsupportedOperationException e14) {
                        e = e14;
                        ibVar = ibVar2;
                    } catch (SocketException e15) {
                        e = e15;
                        ibVar = ibVar2;
                    } catch (SocketTimeoutException e16) {
                        e = e16;
                        ibVar = ibVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        ibVar = ibVar2;
                    }
                    i14 = i8;
                    i13 = 1;
                } else {
                    ibVar = ibVar2;
                    bdHttpStat = bdHttpStat2;
                    try {
                        ibVar.b = 0;
                        ibVar.c = DnsModel.MSG_OK;
                        return;
                    } catch (UnsupportedOperationException e17) {
                        e = e17;
                        i12 = R.string.obfuscated_res_0x7f0f0e61;
                        if (i11 >= i7) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        this.a.c().c = -14;
                        db c32 = this.a.c();
                        c32.g = e.getMessage() + Log.getStackTraceString(e);
                        bdHttpStat.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(i12);
                        this.a.e(bdHttpStat);
                        ibVar.b = -14;
                        ibVar.c = Log.getStackTraceString(e);
                        if (this.d <= 0) {
                            yaVar2 = this.b;
                        }
                        bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(bdHttpStat);
                        ibVar.a();
                        z6 = z3;
                        i14 = i8;
                        i13 = 1;
                    } catch (Throwable th5) {
                        th = th5;
                        this.a.c().c = -10;
                        db c42 = this.a.c();
                        c42.g = th.getMessage() + Log.getStackTraceString(th);
                        if (i11 >= i7) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        bdHttpStat.exception = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.obfuscated_res_0x7f0f0e61);
                        BdLog.e(th.getMessage());
                        this.a.e(bdHttpStat);
                        ibVar.b = -10;
                        ibVar.c = Log.getStackTraceString(th);
                        if (this.d <= 0) {
                            yaVar2 = this.b;
                        }
                        bdHttpStat.allCostTime = System.currentTimeMillis() - currentTimeMillis;
                        this.a.e(bdHttpStat);
                        ibVar.a();
                        z6 = z3;
                        i14 = i8;
                        i13 = 1;
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
