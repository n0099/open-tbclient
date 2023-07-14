package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.mutiprocess.HybridNotify.HybridNotifyEvent;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.browser.webview.monitor.MonitorWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qy4 implements in6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.in6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        hn6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.in6
    public /* synthetic */ void onDestroy() {
        hn6.b(this);
    }

    public qy4() {
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

    @Override // com.baidu.tieba.in6
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
                jsPromptResult.confirm(e(webView).a());
                return true;
            } else {
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public qda c(WebView webView, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2, str3, str4)) == null) {
            qda qdaVar = new qda();
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
                return qdaVar;
            }
            qdaVar.p();
            return qdaVar;
        }
        return (qda) invokeLLLLL.objValue;
    }

    @NonNull
    public qda d(WebView webView, @NonNull String str, @Nullable String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, webView, str, str2)) == null) {
            qda qdaVar = new qda();
            qdaVar.y(0);
            qdaVar.o(xz5.b().c(str, str2));
            return qdaVar;
        }
        return (qda) invokeLLL.objValue;
    }

    public qda e(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, webView)) == null) {
            qda qdaVar = new qda();
            String w = da5.p().w("key_match_id_list_football", "");
            String w2 = da5.p().w("key_match_id_list_basketball", "");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("football", PreferencesUtil.LEFT_MOUNT + w + PreferencesUtil.RIGHT_MOUNT);
                jSONObject.put("basketball", PreferencesUtil.LEFT_MOUNT + w2 + PreferencesUtil.RIGHT_MOUNT);
                qdaVar.o(jSONObject.toString());
            } catch (JSONException e) {
                BdLog.e(e);
            }
            return qdaVar;
        }
        return (qda) invokeL.objValue;
    }

    public qda f(WebView webView, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{webView, str, str2, Boolean.valueOf(z)})) == null) {
            qda qdaVar = new qda();
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
                        h29 defaultLog = DefaultLog.getInstance();
                        defaultLog.b("SpriteTip", "JSONException:" + e);
                    }
                } else if (CommonTbJsBridge.KEY_GROUP_CHAT_NOTIFY_REFTESH.equals(str)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921795, str2));
                } else {
                    boolean z2 = false;
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
                                z2 = true;
                            }
                            da5.p().A("official_push_switch", z2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921754, Integer.valueOf(optInt)));
                        } catch (JSONException e2) {
                            h29 defaultLog2 = DefaultLog.getInstance();
                            defaultLog2.b("officialPushMsgStatus", "JSONException:" + e2);
                        }
                    } else if ("changeOftenForumList".equals(str)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921811, str2));
                    }
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921778));
            }
            uz4.a().b(str, str2);
            HybridNotifyEvent hybridNotifyEvent = new HybridNotifyEvent();
            hybridNotifyEvent.key = str;
            hybridNotifyEvent.data = str2;
            wq5.i(hybridNotifyEvent);
            if (z) {
                try {
                    jn6.a().g(str, new JSONObject(str2), webView);
                } catch (Exception e3) {
                    h29 hybridLog = HybridLog.getInstance();
                    hybridLog.b("NotifyDataChanged", "H5通知H5异常:" + e3);
                }
            }
            return qdaVar;
        }
        return (qda) invokeCommon.objValue;
    }
}
