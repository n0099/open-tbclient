package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.messageCenter.SignManager;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.mutiprocess.event.TopToastEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class tx4 implements qk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.qk6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        pk6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.qk6
    public /* synthetic */ void onDestroy() {
        pk6.b(this);
    }

    public tx4() {
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

    @Override // com.baidu.tieba.qk6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (CommonTbJsBridge.TOAST_POPUPVIEW.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(f(webView, jSONObject.optInt(RecordVideoActivityConfig.SHOW_TYPE), jSONObject.optInt("ahead_type"), jSONObject.optString("message"), jSONObject.optString("btn_text"), jSONObject.optInt("toast_duration"), jSONObject.optString("schema"), jSONObject.optString("token"), jSONObject.optDouble(NativeConstants.OPACITY), jSONObject.optString(BigdayActivityConfig.IMG_URL), jSONObject.optString("url"), jSONObject.optInt("mission_id"), jSONObject.optString("btn_color"), jSONObject.optString("message_color"), jSONObject.optString("btn_text_color"), jSONObject.optInt("status"), jSONObject.optInt(CommonTbJsBridge.FINISH_THIS_PAGE)).a());
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            } else if (CommonTbJsBridge.SHOW_TIP_TOAST.equals(str2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    jsPromptResult.confirm(g(webView, jSONObject2.optString("content"), jSONObject2.optString(GameAssistConstKt.KEY_LINKURL), jSONObject2.optString("key"), jSONObject2.optInt("maxTimes"), jSONObject2.optInt(CommonTbJsBridge.FINISH_THIS_PAGE)).a());
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            } else if (CommonTbJsBridge.GET_MODAL_DATA.equals(str2)) {
                try {
                    try {
                        jsPromptResult.confirm(e(webView, new JSONObject(str3).optString("url")).a());
                        return false;
                    } catch (JSONException e3) {
                        e = e3;
                        BdLog.e(e);
                        return false;
                    }
                } catch (JSONException e4) {
                    e = e4;
                }
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public final void c(String str) {
        TbPageContext<?> d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && !bi.isEmpty(str) && (d = d(TbadkCoreApplication.getInst().getCurrentActivity())) != null) {
            UrlManager.getInstance().dealOneLink(d, new String[]{str});
        }
    }

    public final TbPageContext d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
            if (activity instanceof BaseActivity) {
                return ((BaseActivity) activity).getPageContext();
            }
            if (activity instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) activity).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeL.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:3|4|5|(5:7|(1:11)|13|14|15)(5:20|(2:22|23)|13|14|15)|12|13|14|15) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0059, code lost:
        com.baidu.adp.lib.util.BdLog.e(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public kca e(WebView webView, String str) {
        InterceptResult invokeLL;
        String signInfo;
        JSONObject newGodDataJson;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
            kca kcaVar = new kca();
            JSONObject jSONObject = null;
            int i = 0;
            try {
                signInfo = SignManager.getInstance().getSignInfo();
                newGodDataJson = TbSingleton.getInstance().getNewGodDataJson();
            } catch (Exception e) {
                BdLog.e(e);
            }
            if (!bi.isEmpty(str)) {
                int indexOf = str.indexOf(WebViewActivityConfig.TAG_NEW_GOD_INVITE);
                if (newGodDataJson != null && indexOf != -1) {
                    jSONObject = newGodDataJson;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", i);
                jSONObject2.put(SourceConstant.SOURCE_USER_INFO, jSONObject);
                kcaVar.o(jSONObject2.toString());
                return kcaVar;
            }
            if (!TextUtils.isEmpty(signInfo)) {
                jSONObject = new JSONObject(signInfo);
            }
            JSONObject jSONObject22 = new JSONObject();
            jSONObject22.put("resultCode", i);
            jSONObject22.put(SourceConstant.SOURCE_USER_INFO, jSONObject);
            kcaVar.o(jSONObject22.toString());
            return kcaVar;
            i = 1;
            JSONObject jSONObject222 = new JSONObject();
            jSONObject222.put("resultCode", i);
            jSONObject222.put(SourceConstant.SOURCE_USER_INFO, jSONObject);
            kcaVar.o(jSONObject222.toString());
            return kcaVar;
        }
        return (kca) invokeLL.objValue;
    }

    public kca f(WebView webView, int i, int i2, String str, String str2, int i3, String str3, String str4, double d, String str5, String str6, int i4, String str7, String str8, String str9, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{webView, Integer.valueOf(i), Integer.valueOf(i2), str, str2, Integer.valueOf(i3), str3, str4, Double.valueOf(d), str5, str6, Integer.valueOf(i4), str7, str8, str9, Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            kca kcaVar = new kca();
            gu4 gu4Var = new gu4();
            gu4Var.c = i;
            gu4Var.d = i2;
            gu4Var.e = str;
            gu4Var.f = str2;
            gu4Var.i = i3;
            gu4Var.l = str3;
            gu4Var.n = d;
            gu4Var.j = str5;
            gu4Var.k = str6;
            gu4Var.b = i4;
            gu4Var.o = str7;
            gu4Var.p = str8;
            gu4Var.q = str9;
            if (i == gu4.y) {
                t45.h(TbadkCoreApplication.getInst().getCurrentActivity(), gu4Var).j();
            } else if (i == gu4.z) {
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                m05 m05Var = new m05(currentActivity);
                if (currentActivity != null) {
                    m05Var.d(currentActivity, gu4Var);
                    m05Var.i();
                }
            } else if (i == gu4.A) {
                if (i2 == gu4.E) {
                    if (!UtilHelper.dealOneScheme(TbadkCoreApplication.getInst().getCurrentActivity(), gu4Var.l) && !bi.isEmpty(gu4Var.k)) {
                        c(gu4Var.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                    }
                } else if (i2 == gu4.F && !bi.isEmpty(str6)) {
                    c(gu4Var.k + TbWebViewActivityConfig.JUMP_PARAMS_PAGE_TYPE);
                }
            } else if (i == gu4.C) {
                Activity a = fk6.a(webView.getContext());
                if (i6 == 1 && a != null) {
                    a.finish();
                }
                MutiProcessManager.publishEvent(new TopToastEvent(i5, str, 1500));
            } else if (i == gu4.D) {
                Activity a2 = fk6.a(webView.getContext());
                if (i6 == 1 && a2 != null) {
                    a2.finish();
                }
                if (!TextUtils.isEmpty(str)) {
                    BdToastData bdToastData = new BdToastData();
                    bdToastData.parserJson(str);
                    BdToastHelper.toast(bdToastData);
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeCommon.objValue;
    }

    public kca g(WebView webView, String str, String str2, String str3, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{webView, str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            kca kcaVar = new kca();
            Activity a = fk6.a(webView.getContext());
            int i3 = 0;
            boolean z = false;
            boolean z2 = false;
            i3 = 0;
            if (!TextUtils.isEmpty(str) && a != null) {
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = "showToast_" + str3;
                    int i4 = SharedPrefHelper.getInstance().getInt(str4, 0);
                    if (i4 < i) {
                        SharedPrefHelper.getInstance().putInt(str4, i4);
                        Intent intent = a.getIntent();
                        if (i2 == 1) {
                            z = true;
                        }
                        MutiProcessManager.publishEvent(new TipEvent(intent, str, str2, z));
                    }
                } else {
                    Intent intent2 = a.getIntent();
                    if (i2 == 1) {
                        z2 = true;
                    }
                    MutiProcessManager.publishEvent(new TipEvent(intent2, str, str2, z2));
                }
                if (i2 == 1) {
                    a.finish();
                }
                i3 = 1;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i3);
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeCommon.objValue;
    }
}
