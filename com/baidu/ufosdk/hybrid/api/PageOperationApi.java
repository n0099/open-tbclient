package com.baidu.ufosdk.hybrid.api;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.b;
import com.baidu.ufosdk.hybrid.base.WebLoaderActivity;
import com.baidu.ufosdk.o;
import com.baidu.ufosdk.p;
import com.baidu.ufosdk.q1;
import com.baidu.ufosdk.ui.BdShimmerView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PageOperationApi implements IBridgeApi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public PageOperationApi() {
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

    public static void a(Context context, String str, JSONObject jSONObject, o oVar) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, context, str, jSONObject, oVar) == null) {
            Intent a = b.a(context, 0);
            if (str.contains("helpCenter")) {
                a.putExtra("page_category", 0);
            } else if (str.contains("imConfig")) {
                a.putExtra("page_category", 1);
            } else if (str.contains("postview")) {
                a.putExtra("page_category", 2);
            } else if (str.contains("report")) {
                a.putExtra("page_category", 5);
            }
            a.putExtra("third_url", str);
            if (jSONObject.has("titlebar")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("titlebar");
                int optInt = jSONObject2.optInt(RemoteMessageConst.Notification.VISIBILITY, 1);
                String optString = jSONObject2.optString("title", "");
                a.putExtra("titlebar_visbility", optInt);
                a.putExtra("titlebar_title", optString);
            }
            context.startActivity(a);
            oVar.a((JSONObject) null);
        }
    }

    public static void dismissShimmer(Context context, p pVar, o oVar) {
        BdShimmerView bdShimmerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, pVar, oVar) == null) {
            try {
                if ((context instanceof WebLoaderActivity) && (bdShimmerView = ((WebLoaderActivity) context).x) != null) {
                    bdShimmerView.setVisibility(8);
                }
                oVar.a((JSONObject) null);
            } catch (Exception e) {
                oVar.a("10102", "Unknow Exception!");
                e.printStackTrace();
            }
        }
    }

    public static void finish(Context context, p pVar, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, pVar, oVar) == null) {
            try {
                if (context instanceof WebLoaderActivity) {
                    ((WebLoaderActivity) context).finish();
                }
                oVar.a((JSONObject) null);
            } catch (Exception e) {
                oVar.a("10102", "Unknow Exception!");
                e.printStackTrace();
            }
        }
    }

    public static void postSuccess(Context context, p pVar, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, context, pVar, oVar) == null) {
            try {
                finish(context, pVar, oVar);
            } catch (Exception e) {
                oVar.a("10102", "Unknow Exception!");
                e.printStackTrace();
            }
        }
    }

    public static void openWebLoader(Context context, p pVar, o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, pVar, oVar) == null) {
            try {
                JSONObject jSONObject = new JSONObject(pVar.d);
                jSONObject.optInt("from", -1);
                int optInt = jSONObject.optInt("into", -1);
                String optString = jSONObject.optString("url", "");
                if (!TextUtils.isEmpty(optString)) {
                    a(context, optString, jSONObject, oVar);
                } else if (optInt != -1) {
                    Intent a = b.a(context, optInt);
                    if (optInt == 2 && q1.a()) {
                        a.putExtra("showProblem", 1);
                    }
                    context.startActivity(a);
                    oVar.a((JSONObject) null);
                } else {
                    oVar.a("10101", "into: " + optInt);
                }
            } catch (Exception e) {
                oVar.a("10102", "Unknow Exception!");
                e.printStackTrace();
            }
        }
    }
}
