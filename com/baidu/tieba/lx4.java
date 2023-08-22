package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.browser.UegTbJsBridge;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.novel.ReadRecordsData;
import com.baidu.tbadk.switchs.OpenJsSdkSwitch;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.h5power.DescriptionTableInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class lx4 implements vl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.vl6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        ul6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.vl6
    public /* synthetic */ void onDestroy() {
        ul6.b(this);
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;

        public a(lx4 lx4Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lx4Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921817, this.a));
            }
        }
    }

    public lx4() {
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

    @Override // com.baidu.tieba.vl6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (TextUtils.equals(CommonTbJsBridge.GET_APIS, str2)) {
                jsPromptResult.confirm(e(webView));
                return true;
            } else if (UegTbJsBridge.METHOD_CALL_NATIVE_SMS.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    c(webView, jSONObject.optString("phoneNumber"), jSONObject.optString("content"));
                    jsPromptResult.confirm("1");
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                return true;
            } else if (UegTbJsBridge.METHOD_RECORD_NOVEL_INFO.equals(str2)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str3);
                    n(webView, jSONObject2.optString("bookProgress"), jSONObject2.optString(TbEnum.ParamKey.GID), jSONObject2.optString("lastReadChapterId"), jSONObject2.optString("lastReadChapterIndex"), jSONObject2.optString("lastReadChapterName"));
                    jsPromptResult.confirm("1");
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
                return true;
            } else if (UegTbJsBridge.METHOD_NOVEL_PAY_RESULT_TO_CLIENT.equals(str2)) {
                try {
                    g(webView, new JSONObject(str3).optBoolean("isPaySuccess"));
                    jsPromptResult.confirm("1");
                } catch (JSONException e3) {
                    BdLog.e(e3);
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public sga c(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2)) == null) {
            sga sgaVar = new sga();
            Context a2 = kl6.a(webView.getContext());
            if (a2 == null) {
                a2 = webView.getContext();
            }
            UtilHelper.smsTo(a2, str, str2);
            return sgaVar;
        }
        return (sga) invokeLLL.objValue;
    }

    public sga d(WebView webView, int i, long j, long j2, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{webView, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), str, str2})) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("count", i);
                jSONObject.put("beginMsgId", j);
                jSONObject.put("endMsgId", j2);
                jSONObject.put("chatType", str);
                jSONObject.put("chatId", str2);
            } catch (JSONException e) {
                BdLog.e(e);
            }
            lg.c(new a(this, jSONObject));
            return new sga();
        }
        return (sga) invokeCommon.objValue;
    }

    public final String e(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, webView)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", 0);
                jSONObject.put("message", webView.getContext().getString(R.string.scheme_action_status_ok));
                if (OpenJsSdkSwitch.isOn()) {
                    jSONObject.put("data", new JSONArray(DescriptionTableInfo.getDescriptionTable()));
                } else {
                    jSONObject.put("data", new JSONArray());
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                BdLog.e(e);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public final sga f(HashMap<String, Object> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hashMap)) == null) {
            sga sgaVar = new sga();
            try {
                sgaVar.o(DataExt.toJson(hashMap));
                return sgaVar;
            } catch (Exception e) {
                BdLog.e(e);
                return sgaVar;
            }
        }
        return (sga) invokeL.objValue;
    }

    public sga m(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, webView)) == null) {
            return new sga();
        }
        return (sga) invokeL.objValue;
    }

    public sga g(WebView webView, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, webView, z)) == null) {
            sga sgaVar = new sga();
            if (z) {
                or5.c();
            }
            return sgaVar;
        }
        return (sga) invokeLZ.objValue;
    }

    public sga h(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            return f(hashMap);
        }
        return (sga) invokeLL.objValue;
    }

    public sga i(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            return f(hashMap);
        }
        return (sga) invokeLL.objValue;
    }

    public sga j(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, webView, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            sga sgaVar = new sga();
            try {
                sgaVar.o(DataExt.toJson(hashMap));
            } catch (Exception e) {
                BdLog.e(e);
            }
            return sgaVar;
        }
        return (sga) invokeLL.objValue;
    }

    public sga k(WebView webView, ArrayList<String> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, webView, arrayList)) == null) {
            sga sgaVar = new sga();
            Context a2 = kl6.a(webView.getContext());
            if (a2 == null) {
                a2 = webView.getContext();
            }
            if (arrayList != null) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    Glide.with(a2).asBitmap().load(it.next()).diskCacheStrategy(DiskCacheStrategy.ALL).preload();
                }
            }
            return sgaVar;
        }
        return (sga) invokeLL.objValue;
    }

    public sga l(WebView webView, ArrayList<String> arrayList) {
        InterceptResult invokeLL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, webView, arrayList)) == null) {
            if (arrayList != null) {
                Iterator<String> it = arrayList.iterator();
                c = 65535;
                while (it.hasNext()) {
                    String a2 = dy5.a(it.next());
                    if (a2 != null) {
                        if (!dy5.d(webView.getContext(), a2, null)) {
                            c = 2;
                        }
                    } else {
                        c = 1;
                    }
                }
            } else {
                c = 65535;
            }
            sga sgaVar = new sga();
            if (c == 65535) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", 0);
                    sgaVar.o(jSONObject.toString());
                    return sgaVar;
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            } else if (c == 1) {
                sgaVar.r("url不支持预热");
            } else if (c == 2) {
                sgaVar.r("预热池已存在该url");
            } else {
                sgaVar.r("其它错误");
            }
            return sgaVar;
        }
        return (sga) invokeLL.objValue;
    }

    public sga n(WebView webView, String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{webView, str, str2, str3, str4, str5})) == null) {
            sga sgaVar = new sga();
            ReadRecordsData readRecordsData = new ReadRecordsData(str, str2, str3, str4, str5);
            readRecordsData.P(true);
            or5.d(str2, readRecordsData);
            return sgaVar;
        }
        return (sga) invokeCommon.objValue;
    }

    public sga o(WebView webView, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, webView, str, str2, str3)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msg", str);
                jSONObject.put("chatType", str2);
                jSONObject.put("chatId", str3);
            } catch (JSONException e) {
                BdLog.e(e);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921816, jSONObject));
            return new sga();
        }
        return (sga) invokeLLLL.objValue;
    }
}
