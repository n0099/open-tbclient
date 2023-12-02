package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.data.SmallTailThemeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class os4 implements qj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.qj6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        pj6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.qj6
    public /* synthetic */ void onDestroy() {
        pj6.b(this);
    }

    public os4() {
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

    @Override // com.baidu.tieba.qj6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (CommonTbJsBridge.COMPLETE_TASK.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(f(webView, jSONObject.optString("activityId"), jSONObject.optString("missionId")).a());
                    return true;
                } catch (JSONException e) {
                    BdLog.e(e);
                    return false;
                }
            } else if (CommonTbJsBridge.FINISH_TEST_ANSWER.equals(str2)) {
                try {
                    jsPromptResult.confirm(c(webView, new JSONObject(str3).optLong("testId")).a());
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return false;
                }
            } else {
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public fxa c(WebView webView, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, webView, j)) == null) {
            fxa fxaVar = new fxa();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921383, Long.valueOf(j)));
            Activity a = fj6.a(webView.getContext());
            if (a != null) {
                a.finish();
            }
            fxaVar.o(CommonTbJsBridge.FINISH_TEST_ANSWER);
            return fxaVar;
        }
        return (fxa) invokeLJ.objValue;
    }

    public fxa e(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, hashMap)) == null) {
            fxa fxaVar = new fxa();
            if (hashMap == null) {
                return fxaVar;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("threadInfo", hashMap.get("threadInfo"));
                jSONObject.put("resultCode", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(webView, CommonTbJsBridge.CHANGE_POST_WALL, jSONObject);
            fxaVar.o(jSONObject.toString());
            return fxaVar;
        }
        return (fxa) invokeLL.objValue;
    }

    public fxa d(WebView webView, String str) {
        int i;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, str)) == null) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                i = -1;
            }
            iu4.b(i);
            return new fxa();
        }
        return (fxa) invokeLL.objValue;
    }

    public fxa h(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, str)) == null) {
            xma.d().f(str);
            return new fxa();
        }
        return (fxa) invokeLL.objValue;
    }

    public fxa k(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, webView, hashMap)) == null) {
            return new fxa();
        }
        return (fxa) invokeLL.objValue;
    }

    public fxa f(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, str2)) == null) {
            fxa fxaVar = new fxa();
            int i = 0;
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(str, str2);
                    CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
                    completeTaskReqMsg.completeId = jSONObject.toString();
                    completeTaskReqMsg.setNetType(NetMessage.NetType.HTTP);
                    MessageManager.getInstance().sendMessage(completeTaskReqMsg);
                    i = 1;
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", i);
                fxaVar.o(jSONObject2.toString());
                return fxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return fxaVar;
            }
        }
        return (fxa) invokeLLL.objValue;
    }

    public fxa j(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, webView, str, str2)) == null) {
            fxa fxaVar = new fxa();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                b06 b06Var = new b06();
                try {
                    b06Var.a = URLDecoder.decode(str, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    b06Var.a = str;
                    e.printStackTrace();
                }
                try {
                    b06Var.b = URLDecoder.decode(str2, "utf-8");
                } catch (UnsupportedEncodingException e2) {
                    b06Var.b = str2;
                    e2.printStackTrace();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921787, b06Var));
            }
            return fxaVar;
        }
        return (fxa) invokeLLL.objValue;
    }

    public fxa g(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, webView)) == null) {
            fxa fxaVar = new fxa();
            vv4.c().h();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                fxaVar.o(jSONObject.toString());
            } catch (JSONException e) {
                BdLog.e(e);
            }
            return fxaVar;
        }
        return (fxa) invokeL.objValue;
    }

    public fxa i(WebView webView, int i, String str) {
        InterceptResult invokeLIL;
        SmallTailThemeData smallTailThemeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, i, str)) == null) {
            if (i == 1) {
                smallTailThemeData = new SmallTailThemeData();
                smallTailThemeData.setPropsId(str);
            } else {
                smallTailThemeData = null;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921748, smallTailThemeData));
            return new fxa();
        }
        return (fxa) invokeLIL.objValue;
    }
}
