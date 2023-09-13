package com.baidu.tts;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import org.chromium.net.NetError;
/* loaded from: classes9.dex */
public class x1 extends d2<x1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public q1 b;
    public r1 c;

    public x1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = w0.a("TtsParams", str);
        this.b = new q1(str);
        this.c = new r1(str);
    }

    public int a(n0 n0Var, String str) {
        InterceptResult invokeLL;
        boolean z;
        q0 q0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, n0Var, str)) == null) {
            q1 q1Var = this.b;
            t1 t1Var = q1Var.b;
            u1 u1Var = q1Var.a;
            int ordinal = n0Var.ordinal();
            if (ordinal != 31) {
                if (ordinal != 32) {
                    if (ordinal != 70) {
                        if (ordinal != 71) {
                            if (ordinal != 81) {
                                if (ordinal != 82) {
                                    k0 k0Var = null;
                                    switch (ordinal) {
                                        case 4:
                                            u1Var.q = str;
                                            return 0;
                                        case 35:
                                            try {
                                                float parseFloat = Float.parseFloat(str);
                                                q1 q1Var2 = this.b;
                                                q1Var2.a.a = parseFloat;
                                                q1Var2.b.a = parseFloat;
                                                return 0;
                                            } catch (NumberFormatException unused) {
                                                u0 u0Var = u0.F0;
                                                break;
                                            }
                                        case 36:
                                            try {
                                                this.b.a.a = Float.parseFloat(str);
                                                return 0;
                                            } catch (NumberFormatException unused2) {
                                                u0 u0Var2 = u0.F0;
                                                break;
                                            }
                                        case 37:
                                            try {
                                                this.b.b.a = Float.parseFloat(str);
                                                return 0;
                                            } catch (NumberFormatException unused3) {
                                                u0 u0Var3 = u0.F0;
                                                break;
                                            }
                                        case 38:
                                            t1Var.getClass();
                                            t1Var.w = Boolean.parseBoolean(str);
                                            return 0;
                                        case 39:
                                            try {
                                                float parseFloat2 = Float.parseFloat(str);
                                                q1 q1Var3 = this.b;
                                                q1Var3.a.c = parseFloat2;
                                                q1Var3.b.c = parseFloat2;
                                                return 0;
                                            } catch (NumberFormatException unused4) {
                                                u0 u0Var4 = u0.F0;
                                                break;
                                            }
                                        case 40:
                                            try {
                                                float parseFloat3 = Float.parseFloat(str);
                                                q1 q1Var4 = this.b;
                                                q1Var4.a.b = parseFloat3;
                                                q1Var4.b.b = parseFloat3;
                                                return 0;
                                            } catch (NumberFormatException unused5) {
                                                u0 u0Var5 = u0.F0;
                                                break;
                                            }
                                        case 41:
                                            u1Var.d = str;
                                            t1Var.d = str;
                                            return 0;
                                        case 42:
                                            j0 a = j0.a(str);
                                            u1Var.getClass();
                                            if (a != null) {
                                                u1Var.i = a;
                                                return 0;
                                            }
                                            u0 u0Var6 = u0.F0;
                                            break;
                                        case 43:
                                            k0[] values = k0.values();
                                            int i = 0;
                                            while (true) {
                                                if (i < 5) {
                                                    k0 k0Var2 = values[i];
                                                    if (k0Var2.a.equals(str)) {
                                                        k0Var = k0Var2;
                                                    } else {
                                                        i++;
                                                    }
                                                }
                                            }
                                            u1Var.j = k0Var;
                                            return 0;
                                        case 44:
                                            try {
                                                this.c.e = Float.parseFloat(str);
                                                return 0;
                                            } catch (NumberFormatException unused6) {
                                                u0 u0Var7 = u0.F0;
                                                break;
                                            }
                                        case 45:
                                            try {
                                                this.c.h = Integer.parseInt(str);
                                                return 0;
                                            } catch (NumberFormatException unused7) {
                                                u0 u0Var8 = u0.F0;
                                                break;
                                            }
                                        case 46:
                                            try {
                                                int parseInt = Integer.parseInt(str);
                                                r1 r1Var = this.c;
                                                r1Var.f = parseInt;
                                                r1Var.h = -1;
                                                return 0;
                                            } catch (NumberFormatException unused8) {
                                                u0 u0Var9 = u0.F0;
                                                break;
                                            }
                                        case 47:
                                            try {
                                                int parseInt2 = Integer.parseInt(str);
                                                r1 r1Var2 = this.c;
                                                r1Var2.g = parseInt2;
                                                r1Var2.h = -1;
                                                return 0;
                                            } catch (NumberFormatException unused9) {
                                                u0 u0Var10 = u0.F0;
                                                break;
                                            }
                                        case 48:
                                            u1Var.h = str;
                                            t1Var.r = str;
                                            return 0;
                                        case 49:
                                            try {
                                                u1Var.k = Integer.parseInt(str);
                                                return 0;
                                            } catch (NumberFormatException unused10) {
                                                u0 u0Var11 = u0.F0;
                                                break;
                                            }
                                        case 50:
                                            t1Var.i = str;
                                            return 0;
                                        case 51:
                                            t1Var.j = str;
                                            t1Var.x = null;
                                            return 0;
                                        case 52:
                                            t1Var.x = str;
                                            t1Var.j = null;
                                            return 0;
                                        case 55:
                                            t1Var.l = str;
                                            return 0;
                                        case 85:
                                            u1Var.r = str;
                                            return 0;
                                        case 91:
                                            u1Var.u = str;
                                            return 0;
                                        default:
                                            boolean z2 = true;
                                            switch (ordinal) {
                                                case 26:
                                                    try {
                                                        q0Var = q0.valueOf(str);
                                                    } catch (Exception unused11) {
                                                        q0Var = q0.a;
                                                    }
                                                    this.b.c = q0Var;
                                                    return 0;
                                                case 27:
                                                    try {
                                                        int parseInt3 = Integer.parseInt(str);
                                                        if (parseInt3 != 0 && parseInt3 != 1) {
                                                            u0 u0Var12 = u0.F0;
                                                            break;
                                                        }
                                                        q1 q1Var5 = this.b;
                                                        if (parseInt3 != 1) {
                                                            z2 = false;
                                                        }
                                                        q1Var5.d = z2;
                                                        return 0;
                                                    } catch (NumberFormatException unused12) {
                                                        u0 u0Var13 = u0.F0;
                                                        break;
                                                    }
                                                case 28:
                                                    try {
                                                        this.c.i = Integer.parseInt(str);
                                                        return 0;
                                                    } catch (NumberFormatException unused13) {
                                                        u0 u0Var14 = u0.F0;
                                                        break;
                                                    }
                                                default:
                                                    switch (ordinal) {
                                                        case 57:
                                                            t1Var.p = str;
                                                            return 0;
                                                        case 58:
                                                            t1Var.getClass();
                                                            try {
                                                                Long.parseLong(str);
                                                                return 0;
                                                            } catch (Exception e) {
                                                                LoggerProxy.d(t1Var.y, e.getMessage());
                                                                u0 u0Var15 = u0.F0;
                                                                break;
                                                            }
                                                        case 59:
                                                            try {
                                                                long parseLong = Long.parseLong(str);
                                                                q1 q1Var6 = this.b;
                                                                q1Var6.a.e = parseLong;
                                                                q1Var6.b.e = parseLong;
                                                                return 0;
                                                            } catch (NumberFormatException unused14) {
                                                                u0 u0Var16 = u0.F0;
                                                                break;
                                                            }
                                                        case 60:
                                                            t1Var.getClass();
                                                            try {
                                                                Long.parseLong(str);
                                                                t1Var.h = str;
                                                                return 0;
                                                            } catch (Exception e2) {
                                                                LoggerProxy.d(t1Var.y, e2.getMessage());
                                                                u0 u0Var17 = u0.F0;
                                                                break;
                                                            }
                                                        default:
                                                            switch (ordinal) {
                                                                case 73:
                                                                    try {
                                                                        t1Var.t = Float.parseFloat(str);
                                                                        return 0;
                                                                    } catch (NumberFormatException unused15) {
                                                                        u0 u0Var18 = u0.F0;
                                                                        break;
                                                                    }
                                                                case 74:
                                                                    u1Var.n = str;
                                                                    return 0;
                                                                case 75:
                                                                    u1Var.p = str;
                                                                    return 0;
                                                                default:
                                                                    switch (ordinal) {
                                                                        case 87:
                                                                            u1Var.g = str;
                                                                            t1Var.g = str;
                                                                            return 0;
                                                                        case 88:
                                                                            u1Var.s = str;
                                                                            return 0;
                                                                        case 89:
                                                                            u1Var.t = str;
                                                                            return 0;
                                                                        default:
                                                                            switch (ordinal) {
                                                                                case 93:
                                                                                    u1Var.v = str;
                                                                                    return 0;
                                                                                case 94:
                                                                                    t1Var.getClass();
                                                                                    if (str == null) {
                                                                                        return 0;
                                                                                    }
                                                                                    t1Var.f = str;
                                                                                    return 0;
                                                                                case 95:
                                                                                    t1Var.getClass();
                                                                                    return 0;
                                                                                case 96:
                                                                                    try {
                                                                                        int parseInt4 = Integer.parseInt(str);
                                                                                        if (parseInt4 != 0 && parseInt4 != 1) {
                                                                                            u0 u0Var19 = u0.F0;
                                                                                            break;
                                                                                        }
                                                                                        q1 q1Var7 = this.b;
                                                                                        if (parseInt4 != 1) {
                                                                                            z2 = false;
                                                                                        }
                                                                                        q1Var7.e = z2;
                                                                                        return 0;
                                                                                    } catch (NumberFormatException unused16) {
                                                                                        u0 u0Var20 = u0.F0;
                                                                                        break;
                                                                                    }
                                                                                case 97:
                                                                                    this.b.f = str;
                                                                                    return 0;
                                                                                case 98:
                                                                                    t1Var.getClass();
                                                                                    try {
                                                                                        Long.parseLong(str);
                                                                                        t1Var.v = str;
                                                                                        return 0;
                                                                                    } catch (Exception e3) {
                                                                                        LoggerProxy.d(t1Var.y, e3.getMessage());
                                                                                        u0 u0Var21 = u0.F0;
                                                                                        return 0;
                                                                                    }
                                                                                default:
                                                                                    switch (ordinal) {
                                                                                        case 100:
                                                                                            try {
                                                                                                int parseInt5 = Integer.parseInt(str);
                                                                                                if (parseInt5 >= -20 && parseInt5 <= 19) {
                                                                                                    k2.b = Integer.valueOf(parseInt5);
                                                                                                    return 0;
                                                                                                }
                                                                                                u0 u0Var22 = u0.F0;
                                                                                                break;
                                                                                            } catch (NumberFormatException unused17) {
                                                                                                u0 u0Var23 = u0.F0;
                                                                                                break;
                                                                                            }
                                                                                            break;
                                                                                        case 101:
                                                                                            k2.c = str;
                                                                                            return 0;
                                                                                        case 102:
                                                                                            try {
                                                                                                float parseFloat4 = Float.parseFloat(str);
                                                                                                if (parseFloat4 >= 0.0f && parseFloat4 <= 1.0f) {
                                                                                                    t1Var.z = parseFloat4;
                                                                                                    return 0;
                                                                                                }
                                                                                                u0 u0Var24 = u0.F0;
                                                                                                break;
                                                                                            } catch (NumberFormatException unused18) {
                                                                                                u0 u0Var25 = u0.F0;
                                                                                                break;
                                                                                            }
                                                                                            break;
                                                                                        case 103:
                                                                                            try {
                                                                                                int parseInt6 = Integer.parseInt(str);
                                                                                                if (parseInt6 != 0 && parseInt6 != 1) {
                                                                                                    u0 u0Var26 = u0.F0;
                                                                                                    break;
                                                                                                }
                                                                                                z2 = false;
                                                                                                u1Var.w = z2;
                                                                                                return 0;
                                                                                            } catch (NumberFormatException unused19) {
                                                                                                u0 u0Var27 = u0.F0;
                                                                                                break;
                                                                                            }
                                                                                            break;
                                                                                        default:
                                                                                            return 0;
                                                                                    }
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                                } else {
                                    int i2 = (int) 4000;
                                    try {
                                        int parseInt7 = Integer.parseInt(str);
                                        if (parseInt7 >= 200 && parseInt7 <= 6000) {
                                            i2 = parseInt7;
                                        } else {
                                            String str2 = this.a;
                                            LoggerProxy.e(str2, "ONLINE_REQUEST_TIMEOUT not effect " + str);
                                        }
                                    } catch (NumberFormatException unused20) {
                                        String str3 = this.a;
                                        LoggerProxy.e(str3, "ONLINE_REQUEST_TIMEOUT not effect " + str);
                                    }
                                    this.b.a.o = i2;
                                    return 0;
                                }
                            } else {
                                t1Var.getClass();
                                try {
                                    Long.parseLong(str);
                                    t1Var.u = str;
                                    return 0;
                                } catch (Exception e4) {
                                    LoggerProxy.d(t1Var.y, e4.getMessage());
                                    u0 u0Var28 = u0.F0;
                                    return 0;
                                }
                            }
                        } else {
                            u1Var.m = str;
                            return 0;
                        }
                    } else {
                        u1Var.l = str;
                        return 0;
                    }
                } else {
                    t1Var.s = str;
                    return 0;
                }
            } else {
                if (str != null) {
                    z = str.matches("^[0-9]{1,20}$");
                } else {
                    z = false;
                }
                if (z) {
                    t1Var.q = str;
                    return 0;
                }
                u0 u0Var29 = u0.F0;
            }
            return NetError.ERR_CACHE_RACE;
        }
        return invokeLL.intValue;
    }

    public q1 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (q1) invokeV.objValue;
    }

    public r1 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (r1) invokeV.objValue;
    }
}
