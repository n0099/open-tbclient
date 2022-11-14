package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.net.URLEncoder;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class zi1 extends xi1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public aj1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zi1(Context context, Handler handler) {
        super(context, handler);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (Handler) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = context;
        this.c = aj1.a(context);
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.b.getPackageName());
                jSONObject.put("6", pj1.k(this.b));
                jSONObject.put("7", wj1.a(this.b));
                StringBuilder sb = new StringBuilder();
                sb.append("requestPolicy, param:");
                sb.append(jSONObject.toString());
                hi1.a(sb.toString());
                return c("q/1/qc", pj1.c(this.b, jSONObject, ""));
            } catch (Throwable th) {
                pj1.d(th);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String c(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject)) == null) {
            try {
                byte[] f = pj1.f();
                String b = this.c.b(str, URLEncoder.encode(Base64.encodeToString(rj1.h(f, tj1.b(qj1.a(this.b)).getBytes()), 0)));
                if (TextUtils.isEmpty(b)) {
                    return "";
                }
                String a = a(b, this.c.e(f, jSONObject.toString()));
                if (TextUtils.isEmpty(a)) {
                    return "";
                }
                JSONObject jSONObject2 = new JSONObject(a);
                jSONObject2.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                String optString = jSONObject2.optString("skey");
                String str2 = new String(rj1.e(Base64.decode(jSONObject2.optString("data").getBytes(), 0), rj1.g(Base64.decode(optString.getBytes(), 0), tj1.b(qj1.a(this.b)).getBytes())));
                StringBuilder sb = new StringBuilder();
                sb.append("requestPolicy, response:");
                sb.append(str2);
                hi1.a(sb.toString());
                return str2;
            } catch (Throwable th) {
                pj1.d(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public String d(JSONObject jSONObject, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, jSONObject, j)) == null) {
            try {
                JSONObject f = f(true, false);
                f.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_MOTIFY_BTN_CLICK, bj1.c(this.b, true, false, "login"));
                f.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_LINK_ITME_CLICK, bj1.b(this.b, "login"));
                f.put("24", "");
                f.put("73", ri1.c().f());
                if (ri1.c().i()) {
                    f.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_CLOSE_BTN_CLICK, xj1.a(this.b));
                    f.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK, bj1.h(this.b, "login"));
                    Pair<Integer, String[]> d = xj1.d(this.b);
                    if (d != null) {
                        f.put(PayUVEventType.PAY_WALLET_BANNER_SHOW, d.first);
                        String[] strArr = (String[]) d.second;
                        if (strArr.length == 4) {
                            f.put("14", strArr[0]);
                            f.put("18", strArr[1]);
                            f.put("15", strArr[2]);
                            f.put("19", strArr[3]);
                        }
                    }
                }
                return c("q/1/qmini", pj1.c(this.b, e(f, jSONObject), "1077102"));
            } catch (Throwable th) {
                pj1.d(th);
                return "";
            }
        }
        return (String) invokeLJ.objValue;
    }

    public final JSONObject e(JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, jSONObject, jSONObject2)) == null) {
            if (jSONObject == null && jSONObject2 == null) {
                return null;
            }
            if (jSONObject == null) {
                return jSONObject2;
            }
            if (jSONObject2 == null) {
                return jSONObject;
            }
            try {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.opt(next));
                }
            } catch (Throwable th) {
                pj1.d(th);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final JSONObject f(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                g(jSONObject, "21", "");
                g(jSONObject, "22", "");
                g(jSONObject, "23", "");
            } catch (Throwable th) {
                pj1.d(th);
            }
            return jSONObject;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public final void g(JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, jSONObject, str, str2) == null) && jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    jSONObject.put(str, "");
                } else {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th) {
                pj1.d(th);
            }
        }
    }

    public boolean h(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) {
            try {
                JSONObject f = f(false, true);
                f.put("24", "");
                f.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_MOTIFY_BTN_CLICK, bj1.c(this.b, false, true, "prelogin"));
                f.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_LINK_ITME_CLICK, bj1.b(this.b, "prelogin"));
                f.put(PayUVEventType.PAY_WAY_FAQ_ENTRANCE_CLICK, bj1.e(this.b, "prelogin"));
                f.put("28", bj1.g(this.b, "prelogin"));
                f.put(PayUVEventType.PAY_FULL_SPLIT_ORDER_RESULT_FAIL_AMOUNT_ITEM_CLICK, bj1.h(this.b, "prelogin"));
                f.put("55", String.valueOf(Build.VERSION.SDK_INT));
                f.put(PayUVEventType.PAY_SPLIT_ORDER_RESULT_FAIL_CLOSE_BTN_CLICK, xj1.a(this.b));
                Pair<Integer, String[]> d = xj1.d(this.b);
                if (d != null) {
                    f.put(PayUVEventType.PAY_WALLET_BANNER_SHOW, d.first);
                    String[] strArr = (String[]) d.second;
                    if (strArr.length == 4) {
                        f.put("14", strArr[0]);
                        f.put("18", strArr[1]);
                        f.put("15", strArr[2]);
                        f.put("19", strArr[3]);
                    }
                }
                JSONObject jSONObject2 = new JSONObject(c("q/1/qpre", pj1.c(this.b, e(f, jSONObject), "1077104")));
                if (jSONObject2.optInt("0", 0) == 0) {
                    ri1.c().e(this.b, jSONObject2);
                    return true;
                }
            } catch (Throwable th) {
                pj1.d(th);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public String i(JSONObject jSONObject, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, jSONObject, j)) == null) {
            try {
                return c("q/1/qv", pj1.c(this.b, e(f(true, false), jSONObject), ""));
            } catch (Throwable th) {
                pj1.d(th);
                return "";
            }
        }
        return (String) invokeLJ.objValue;
    }
}
