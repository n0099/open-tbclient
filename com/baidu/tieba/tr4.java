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
/* loaded from: classes8.dex */
public class tr4 implements gh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gh6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        fh6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.gh6
    public /* synthetic */ void onDestroy() {
        fh6.b(this);
    }

    public tr4() {
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

    @Override // com.baidu.tieba.gh6
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

    public ifa c(WebView webView, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, webView, j)) == null) {
            ifa ifaVar = new ifa();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921383, Long.valueOf(j)));
            Activity a = vg6.a(webView.getContext());
            if (a != null) {
                a.finish();
            }
            ifaVar.o(CommonTbJsBridge.FINISH_TEST_ANSWER);
            return ifaVar;
        }
        return (ifa) invokeLJ.objValue;
    }

    public ifa e(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, hashMap)) == null) {
            ifa ifaVar = new ifa();
            if (hashMap == null) {
                return ifaVar;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("threadInfo", hashMap.get("threadInfo"));
                jSONObject.put("resultCode", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(webView, CommonTbJsBridge.CHANGE_POST_WALL, jSONObject);
            ifaVar.o(jSONObject.toString());
            return ifaVar;
        }
        return (ifa) invokeLL.objValue;
    }

    public ifa d(WebView webView, String str) {
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
            mt4.b(i);
            return new ifa();
        }
        return (ifa) invokeLL.objValue;
    }

    public ifa h(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, str)) == null) {
            u4a.d().f(str);
            return new ifa();
        }
        return (ifa) invokeLL.objValue;
    }

    public ifa k(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, webView, hashMap)) == null) {
            return new ifa();
        }
        return (ifa) invokeLL.objValue;
    }

    public ifa f(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, str2)) == null) {
            ifa ifaVar = new ifa();
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
                ifaVar.o(jSONObject2.toString());
                return ifaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return ifaVar;
            }
        }
        return (ifa) invokeLLL.objValue;
    }

    public ifa j(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, webView, str, str2)) == null) {
            ifa ifaVar = new ifa();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                vx5 vx5Var = new vx5();
                try {
                    vx5Var.a = URLDecoder.decode(str, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    vx5Var.a = str;
                    e.printStackTrace();
                }
                try {
                    vx5Var.b = URLDecoder.decode(str2, "utf-8");
                } catch (UnsupportedEncodingException e2) {
                    vx5Var.b = str2;
                    e2.printStackTrace();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921787, vx5Var));
            }
            return ifaVar;
        }
        return (ifa) invokeLLL.objValue;
    }

    public ifa g(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, webView)) == null) {
            ifa ifaVar = new ifa();
            zu4.c().h();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                ifaVar.o(jSONObject.toString());
            } catch (JSONException e) {
                BdLog.e(e);
            }
            return ifaVar;
        }
        return (ifa) invokeL.objValue;
    }

    public ifa i(WebView webView, int i, String str) {
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
            return new ifa();
        }
        return (ifa) invokeLIL.objValue;
    }
}
