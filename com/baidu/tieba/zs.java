package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdptask.bdtls.AES;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zs {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zs a;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)} : (byte[]) invokeI.objValue;
    }

    public zs() {
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

    public static zs c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (zs.class) {
                    if (a == null) {
                        a = new zs();
                    }
                }
            }
            return a;
        }
        return (zs) invokeV.objValue;
    }

    public static int a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            if (bArr == null) {
                return 0;
            }
            int i = 0;
            for (byte b : bArr) {
                i = (i << 8) | (b & 255);
            }
            return i;
        }
        return invokeL.intValue;
    }

    public qs b(rs rsVar, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, rsVar, bArr)) == null) {
            qs qsVar = new qs();
            try {
                ps a2 = us.a(bArr);
                byte i = a2.i();
                if (i != 21) {
                    if (i == 23) {
                        qsVar.c(new String(AES.aesDecrypt(a2.p(), rsVar.q())));
                        qsVar.b(1);
                    }
                } else {
                    fs a3 = fs.a(a2.o());
                    if (a3 != null) {
                        String b = a3.b();
                        DebugTrace debugTrace = DebugTrace.a;
                        debugTrace.a("bdtls ubc application alert : " + b);
                        if (1 == a3.d()) {
                            qsVar.b(-2);
                        } else if (TextUtils.equals(b, "down grade")) {
                            qsVar.b(2);
                        } else {
                            qsVar.b(-1);
                        }
                        if (es.c.h().c()) {
                            if (a3.b() != null) {
                                DebugTrace debugTrace2 = DebugTrace.a;
                                debugTrace2.a("BdtlsPostRequest response alert message=" + b);
                            } else {
                                DebugTrace.a.a("BdtlsPostRequest response alert messag=null");
                            }
                        }
                    } else {
                        qsVar.b(-1);
                    }
                }
            } catch (Exception e) {
                DebugTrace debugTrace3 = DebugTrace.a;
                debugTrace3.a("exception=" + e.getMessage());
                qsVar.b(-1);
            }
            return qsVar;
        }
        return (qs) invokeLL.objValue;
    }

    public byte[] e(rs rsVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rsVar)) == null) {
            if (rsVar == null) {
                return null;
            }
            try {
                byte[] b = ts.b(rsVar, new ns());
                if (b == null) {
                    return null;
                }
                ps a2 = ps.i.a();
                a2.a((byte) 22);
                a2.c((short) b.length);
                a2.j(b);
                return us.b(a2);
            } catch (Exception e) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("exception=" + e.getMessage());
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public byte[] f(rs rsVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rsVar, str)) == null) {
            if (rsVar == null) {
                return null;
            }
            try {
                ps a2 = ps.i.a();
                a2.a((byte) 23);
                byte[] r = rsVar.r();
                if (r != null && r.length > 0 && r.length <= 32767) {
                    a2.c((short) r.length);
                    a2.j(r);
                }
                if (!TextUtils.isEmpty(str)) {
                    byte[] aesEncrypt = AES.aesEncrypt(str, rsVar.q());
                    a2.b(aesEncrypt.length);
                    a2.l(aesEncrypt);
                }
                return us.b(a2);
            } catch (Exception e) {
                DebugTrace debugTrace = DebugTrace.a;
                debugTrace.a("exception=" + e.getMessage());
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }
}
