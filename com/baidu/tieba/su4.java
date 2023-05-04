package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class su4 implements xf6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.xf6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        wf6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.xf6
    public /* synthetic */ void onDestroy() {
        wf6.b(this);
    }

    public su4() {
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

    @Override // com.baidu.tieba.xf6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (CommonTbJsBridge.GAME_PUSH.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(c(webView, jSONObject.optString("gameId"), jSONObject.optString("gameName"), jSONObject.optString("gameTime"), jSONObject.optString("gameType")).a());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return true;
            } else if (CommonTbJsBridge.GAME_PUSH_STATUS.equals(str2)) {
                jsPromptResult.confirm(d(webView).a());
                return true;
            } else {
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public hq9 c(WebView webView, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2, str3, str4)) == null) {
            hq9 hq9Var = new hq9();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gameId", str);
                jSONObject.put("gameName", str2);
                jSONObject.put("gameTime", str3);
                jSONObject.put("gameType", str4);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921404, jSONObject2));
                return hq9Var;
            }
            hq9Var.p();
            return hq9Var;
        }
        return (hq9) invokeLLLLL.objValue;
    }

    public hq9 d(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, webView)) == null) {
            hq9 hq9Var = new hq9();
            String s = f55.m().s("key_match_id_list_football", "");
            String s2 = f55.m().s("key_match_id_list_basketball", "");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("football", PreferencesUtil.LEFT_MOUNT + s + PreferencesUtil.RIGHT_MOUNT);
                jSONObject.put("basketball", PreferencesUtil.LEFT_MOUNT + s2 + PreferencesUtil.RIGHT_MOUNT);
                hq9Var.o(jSONObject.toString());
            } catch (JSONException e) {
                BdLog.e(e);
            }
            return hq9Var;
        }
        return (hq9) invokeL.objValue;
    }

    public hq9 e(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, webView, str, str2)) == null) {
            hq9 hq9Var = new hq9();
            if (!str.equals(CommonTbJsBridge.KEY_GROUP_CHAT_CREATE) && !str.equals(CommonTbJsBridge.KEY_GROUP_CHAT_DISSLOVE) && !str.equals(CommonTbJsBridge.KEY_GROUP_CHAT_MANAGE)) {
                if (CommonTbJsBridge.KEY_GROUP_CHAT_CHANGE_NAME.equals(str)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921779, str2));
                } else if (CommonTbJsBridge.KEY_GROUP_CHAT_CHANGE_AVATAR.equals(str)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921780, str2));
                } else if (CommonTbJsBridge.KEY_SPRING_FESTIVAL_PICK_FORUM.equals(str)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.TRUE));
                } else if ("showFunnySprite".equals(str)) {
                    try {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921797, Integer.valueOf(new JSONObject(str2).optInt("spriteShowType"))));
                    } catch (JSONException e) {
                        dj8 defaultLog = DefaultLog.getInstance();
                        defaultLog.b("SpriteTip", "JSONException:" + e);
                    }
                } else if (CommonTbJsBridge.KEY_GROUP_CHAT_NOTIFY_REFTESH.equals(str)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921795, str2));
                } else {
                    boolean z = false;
                    if ("pbFirstFloorWebViewRefresh".equalsIgnoreCase(str)) {
                        if (webView instanceof MonitorWebView) {
                            try {
                                JSONObject jSONObject = new JSONObject(str2);
                                ((MonitorWebView) webView).q(jSONObject.optInt("success", 0), jSONObject.optDouble("height", 0.0d));
                            } catch (Exception unused) {
                                ((MonitorWebView) webView).q(0, webView.getContentHeight());
                            }
                        }
                    } else if ("setGroupChatBubble".equals(str)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921799, str2));
                    } else if ("officialPushMsgStatus".equals(str)) {
                        try {
                            int optInt = new JSONObject(str2).optInt("status");
                            if (optInt == 1) {
                                z = true;
                            }
                            f55.m().w("official_push_switch", z);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921754, Integer.valueOf(optInt)));
                        } catch (JSONException e2) {
                            dj8 defaultLog2 = DefaultLog.getInstance();
                            defaultLog2.b("officialPushMsgStatus", "JSONException:" + e2);
                        }
                    }
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921778));
            }
            return hq9Var;
        }
        return (hq9) invokeLLL.objValue;
    }
}
