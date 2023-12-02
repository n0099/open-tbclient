package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.AES;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class kp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kp3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)} : (byte[]) invokeI.objValue;
    }

    public kp3() {
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

    public static kp3 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a == null) {
                synchronized (kp3.class) {
                    if (a == null) {
                        a = new kp3();
                    }
                }
            }
            return a;
        }
        return (kp3) invokeV.objValue;
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

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: char */
    /* JADX WARN: Multi-variable type inference failed */
    public static String d(byte[] bArr) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (bArr[i2] > 0) {
                    i = bArr[i2];
                } else {
                    i = bArr[i2] & 255;
                }
                sb.append(i);
                sb.append(",");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public byte[] b(vp3 vp3Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, vp3Var, str)) == null) {
            if (vp3Var == null) {
                return null;
            }
            try {
                tp3 a2 = tp3.j.a();
                a2.r((byte) 23);
                byte[] i = vp3Var.i();
                if (i != null && i.length > 0 && i.length <= 32767) {
                    a2.q((short) i.length);
                    a2.o(i);
                }
                if (!TextUtils.isEmpty(str)) {
                    byte[] aesEncrypt = AES.aesEncrypt(str, vp3Var.c());
                    a2.k(aesEncrypt.length);
                    a2.j(aesEncrypt);
                }
                a2.l(zi4.e().d().longValue());
                return xp3.b(a2);
            } catch (Exception e) {
                if (!gp3.a) {
                    return null;
                }
                e.printStackTrace();
                Log.d("BDTLS", "exception=" + e.getMessage());
                return null;
            }
        }
        return (byte[]) invokeLL.objValue;
    }

    public up3 c(vp3 vp3Var, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vp3Var, bArr)) == null) {
            up3 up3Var = new up3();
            try {
                tp3 a2 = xp3.a(bArr);
                byte i = a2.i();
                if (i != 21) {
                    if (i == 23) {
                        up3Var.c(new String(AES.aesDecrypt(a2.a(), vp3Var.c())));
                        up3Var.d(1);
                    }
                } else {
                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(a2.f());
                    if (parseFrom != null) {
                        String str = new String(parseFrom.getDescription().toByteArray());
                        if (gp3.a) {
                            Log.d("BDTLS", "bdtls ubc application alert : " + str);
                        }
                        lp3.b(vp3Var, parseFrom);
                        if (1 == parseFrom.getLevel()) {
                            up3Var.d(-2);
                        } else if (TextUtils.equals(str, "down grade")) {
                            up3Var.d(2);
                        } else {
                            up3Var.d(-1);
                        }
                        if (gp3.a) {
                            if (parseFrom.getDescription() != null) {
                                if (gp3.a) {
                                    Log.d("BDTLS", "BdtlsPostRequest response alert message=" + str);
                                }
                            } else if (gp3.a) {
                                Log.d("BDTLS", "BdtlsPostRequest response alert messag=null");
                            }
                        }
                    } else {
                        up3Var.d(-1);
                    }
                }
            } catch (Exception e) {
                if (gp3.a) {
                    e.printStackTrace();
                    Log.d("BDTLS", "exception=" + e.getMessage());
                }
                up3Var.d(-1);
            }
            return up3Var;
        }
        return (up3) invokeLL.objValue;
    }

    public byte[] e(vp3 vp3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vp3Var)) == null) {
            if (vp3Var == null) {
                return null;
            }
            try {
                byte[] b = wp3.b(vp3Var, new sp3());
                if (b == null) {
                    return null;
                }
                tp3 a2 = tp3.j.a();
                a2.r((byte) 22);
                a2.q((short) b.length);
                a2.l(zi4.e().d().longValue());
                a2.o(b);
                return xp3.b(a2);
            } catch (Exception e) {
                if (gp3.a) {
                    e.printStackTrace();
                    Log.d("BDTLS", "exception=" + e.getMessage());
                }
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }
}
