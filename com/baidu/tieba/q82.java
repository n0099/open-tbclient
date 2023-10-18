package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class q82 extends p82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean F;
    public transient /* synthetic */ FieldHolder $fh;
    public final p53 D;
    public final n62 E;

    @Override // com.baidu.tieba.t82
    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.p82
    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return 200;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948045630, "Lcom/baidu/tieba/q82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948045630, "Lcom/baidu/tieba/q82;");
                return;
            }
        }
        F = am1.a;
    }

    @Override // com.baidu.tieba.p82, com.baidu.tieba.kd4
    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            J0();
            uy2.p("startup").F(new UbcFlowEvent("aps_start_req"));
            super.D();
        }
    }

    @Override // com.baidu.tieba.p82, com.baidu.tieba.kd4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.E();
            uy2.p("startup").F(new UbcFlowEvent("aps_end_req"));
            K0();
        }
    }

    @Override // com.baidu.tieba.kd4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.F();
            if (this.n != null) {
                u0();
            }
            ih3 ih3Var = new ih3();
            ih3Var.k(10L);
            ih3Var.i(2901L);
            ih3Var.d("同步获取-> Server无包");
            t0(true, ih3Var);
        }
    }

    public mq2 I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.D.X();
        }
        return (mq2) invokeV.objValue;
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.D.k() != 1) {
            this.E.f();
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.D.k() != 1) {
            this.E.g();
            if (F) {
                Log.d("PkgSyncDownloadCallback", "PMS CS协议信息获取成功");
            }
        }
    }

    @Override // com.baidu.tieba.p82
    public PMSDownloadType k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return PMSDownloadType.SYNC;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q82(p53 p53Var) {
        super(p53Var.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {p53Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.D = p53Var;
        this.E = new n62();
    }

    public static void H0(mq2 mq2Var, ih3 ih3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, mq2Var, ih3Var) != null) || mq2Var == null) {
            return;
        }
        sc3 sc3Var = new sc3();
        sc3Var.a = ic3.n(mq2Var.H());
        sc3Var.f = mq2Var.I();
        sc3Var.c = mq2Var.U();
        sc3Var.b = "launch";
        sc3Var.e = "success";
        sc3Var.a("status", "1");
        if (ih3Var != null) {
            sc3Var.a(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, String.valueOf(ih3Var.a()));
            sc3Var.a("msg", ih3Var.g().toString());
        }
        sc3Var.d(mq2Var.t0().getString("ubc"));
        sc3Var.j(mq2Var);
        ic3.onEvent(sc3Var);
        HybridUbcFlow d = uy2.d("startup");
        if (d != null) {
            d.E("value", "na_success");
        }
    }

    @Override // com.baidu.tieba.p82, com.baidu.tieba.kd4
    public void C(je4 je4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, je4Var) == null) {
            super.C(je4Var);
            if (F) {
                Log.e("PkgSyncDownloadCallback", "onFetchError: " + je4Var.toString());
            }
            L0(je4Var);
            ih3 ih3Var = new ih3();
            ih3Var.k(10L);
            ih3Var.c(je4Var);
            if (h92.j(je4Var) && wo2.T().a(wo2.c(), this.o, ih3Var)) {
                t0(false, ih3Var);
                H0(this.D.X(), ih3Var);
            } else if (je4Var != null && je4Var.a == 1020) {
                t0(false, ih3Var);
                H0(this.D.X(), ih3Var);
            } else {
                t0(true, ih3Var);
            }
        }
    }

    @Override // com.baidu.tieba.p82
    public void w0(Throwable th) {
        ih3 ih3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, th) == null) {
            if (th instanceof PkgDownloadError) {
                PkgDownloadError pkgDownloadError = (PkgDownloadError) th;
                if (F) {
                    Log.e("PkgSyncDownloadCallback", "PkgDownloadError:  pkg:" + pkgDownloadError.getPackage() + ", message:" + pkgDownloadError.getMessage() + ", ErrCode: " + pkgDownloadError.getErrCode());
                }
                ih3Var = pkgDownloadError.getErrCode();
            } else {
                if (F) {
                    Log.e("PkgSyncDownloadCallback", "未知错误");
                }
                ih3Var = new ih3();
                ih3Var.k(10L);
                ih3Var.i(2900L);
                ih3Var.d("包下载过程未知错误");
            }
            t0(true, ih3Var);
        }
    }

    @Override // com.baidu.tieba.p82, com.baidu.tieba.kd4
    public void G(xi4 xi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, xi4Var) == null) {
            uy2.p("startup").F(new UbcFlowEvent("aps_start_download"));
            super.G(xi4Var);
        }
    }

    @Override // com.baidu.tieba.kd4
    public void H(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) {
            super.H(str, i);
            ue4 a = ue4.a(str);
            if (a == null) {
                return;
            }
            boolean b = wi4.b(a.c());
            p22.i("PkgSyncDownloadCallback", "resetCore: " + b + ";statusCode:" + i);
            if (b) {
                f23 e = f23.e();
                h23 h23Var = new h23(129);
                h23Var.f(true);
                e.h(h23Var);
            }
        }
    }

    @Override // com.baidu.tieba.kd4, com.baidu.tieba.hd4
    public void n(String str, String str2) {
        List<UbcFlowEvent> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, str, str2) == null) {
            super.n(str, str2);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 53647) {
                    if (hashCode == 54608 && str.equals("770")) {
                        c = 1;
                    }
                } else if (str.equals("670")) {
                    c = 0;
                }
                if (c != 0) {
                    if (c == 1 && (list = this.p) != null) {
                        list.add(new UbcFlowEvent(str2));
                        return;
                    }
                    return;
                }
                uy2.p("startup").F(new UbcFlowEvent(str2));
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0017 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v4, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // com.baidu.tieba.kd4
    public void I(String str, String str2, JSONObject jSONObject) {
        String jSONObject2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, str, str2, jSONObject) != null) || jSONObject == null) {
            return;
        }
        if (F) {
            String str3 = 0;
            str3 = 0;
            try {
                try {
                    jSONObject2 = jSONObject.toString(4);
                    str3 = new StringBuilder();
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONObject2 = jSONObject.toString();
                    str3 = new StringBuilder();
                }
                str3.append("onStatRecord: url:");
                str3.append(str);
                str3.append(" networkStatRecord:\n");
                str3.append(jSONObject2);
                Log.i("PkgSyncDownloadCallback", str3.toString());
            } catch (Throwable th) {
                Log.i("PkgSyncDownloadCallback", "onStatRecord: url:" + str + " networkStatRecord:\n" + str3);
                throw th;
            }
        }
        long optLong = jSONObject.optLong("stat_recode_start_time", System.currentTimeMillis());
        long optLong2 = jSONObject.optLong("dnsEndTime", optLong);
        long optLong3 = jSONObject.optLong("dnsStartTime", optLong);
        long optLong4 = jSONObject.optLong("connectedTime", optLong);
        long optLong5 = jSONObject.optLong("startTime", optLong);
        HybridUbcFlow p = uy2.p("startup");
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("pms_network_start");
        ubcFlowEvent.h(optLong5);
        p.F(ubcFlowEvent);
        UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("pms_network_conn");
        ubcFlowEvent2.h(optLong4);
        p.F(ubcFlowEvent2);
        UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("pms_dns_start");
        ubcFlowEvent3.h(optLong3);
        p.F(ubcFlowEvent3);
        UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("pms_dns_end");
        ubcFlowEvent4.h(optLong2);
        p.F(ubcFlowEvent4);
        UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("pms_network_response");
        ubcFlowEvent5.h(jSONObject.optLong("responseTime", optLong));
        p.F(ubcFlowEvent5);
        UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("pms_send_header");
        ubcFlowEvent6.h(jSONObject.optLong("sendHeaderTime", optLong));
        p.F(ubcFlowEvent6);
        UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("pms_receive_header");
        ubcFlowEvent7.h(jSONObject.optLong("receiveHeaderTime", optLong));
        p.F(ubcFlowEvent7);
        p22.i("PkgSyncDownloadCallback", "pms dns time : " + (optLong2 - optLong3));
        p22.i("PkgSyncDownloadCallback", "pms connect time : " + (optLong4 - optLong5));
    }

    public final void L0(je4 je4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, je4Var) != null) || je4Var == null) {
            return;
        }
        try {
            PMSAppInfo a = wi4.a(new JSONObject(je4Var.c));
            a.appId = a.appKey;
            o53.K().q().O0(a);
            p22.i("PkgSyncDownloadCallback", "onFetchError: pms info:" + a.toString());
        } catch (Exception e) {
            if (F) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.kd4, com.baidu.tieba.id4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, bundle, set)) == null) {
            Bundle m = super.m(bundle, set);
            if (set.contains("get_launch_id")) {
                m.putString("launch_id", this.D.X().W());
            }
            return m;
        }
        return (Bundle) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.p82
    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.v0();
            if (F) {
                Log.i("PkgSyncDownloadCallback", "onDownloadProcessComplete: ");
            }
            HybridUbcFlow p = uy2.p("startup");
            p.F(new UbcFlowEvent("aps_end_download"));
            p.E("type", "0");
            un2.d("0");
            this.p.add(new UbcFlowEvent("na_start_update_db"));
            ih3 F0 = F0();
            this.p.add(new UbcFlowEvent("na_end_update_db"));
            if (F0 == null) {
                if (F) {
                    Log.d("PkgSyncDownloadCallback", "同步获取-> DB 存储成功");
                }
                mq2 I0 = I0();
                me4 me4Var = this.l;
                if (me4Var != null && me4Var.h == 0) {
                    I0.a1(ue3.e(0));
                    I0.F(1);
                }
                me4 me4Var2 = this.l;
                if (me4Var2 != null && me4Var2.h == 1) {
                    I0.a1(ue3.e(1));
                    I0.F(1);
                }
                ke4 ke4Var = this.m;
                if (ke4Var != null && ke4Var.h == 0) {
                    I0.D0(yf2.c(0));
                    I0.F(2);
                }
                ke4 ke4Var2 = this.m;
                if (ke4Var2 != null && ke4Var2.h == 1) {
                    I0.D0(yf2.c(1));
                    I0.F(2);
                }
                pe4 pe4Var = this.q;
                if (pe4Var != null) {
                    I0.G0(pe4Var.r);
                    I0.W0(this.q.p);
                }
                s0(this.n);
                A0("main_download", "0");
                return;
            }
            if (F) {
                Log.e("PkgSyncDownloadCallback", "同步获取-> DB 存储失败");
            }
            t0(true, F0);
        }
    }
}
