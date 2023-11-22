package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.HttpClient;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.browser.proxy.OfflineBridgeData;
import com.baidu.tbadk.browser.proxy.OfflineWebViewHttpResMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.view.spanGroup.RequestUrlParserNetMessage;
import com.baidu.tbadk.core.view.spanGroup.UrlParserHttpResponseMessage;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import com.google.gson.JsonSyntaxException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.UrlParser.UrlParserResIdl;
/* loaded from: classes7.dex */
public class ps4 implements dj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final zt4 a;

    @Override // com.baidu.tieba.dj6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        cj6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.dj6
    public /* synthetic */ void onDestroy() {
        cj6.b(this);
    }

    /* loaded from: classes7.dex */
    public class g extends HttpClient.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView e;
        public final /* synthetic */ String f;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HashMap a;
            public final /* synthetic */ g b;

            public a(g gVar, HashMap hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, hashMap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ej6.a().d(this.b.e, "parseLink", this.a);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(ps4 ps4Var, HttpMessage httpMessage, HttpMessageTask httpMessageTask, WebView webView, String str) {
            super(httpMessage, httpMessageTask);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps4Var, httpMessage, httpMessageTask, webView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((HttpMessage) objArr2[0], (HttpMessageTask) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = webView;
            this.f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public void publishProgress(ResponsedMessage<?>... responsedMessageArr) {
            UrlParserResIdl responseData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessageArr) == null) {
                synchronized (y30.class) {
                    if (responsedMessageArr != null) {
                        if (responsedMessageArr.length > 0) {
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            JSONObject jSONObject = new JSONObject();
                            ResponsedMessage<?> responsedMessage = responsedMessageArr[0];
                            if (responsedMessage != null) {
                                try {
                                    if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestUrlParserNetMessage)) {
                                        RequestUrlParserNetMessage requestUrlParserNetMessage = (RequestUrlParserNetMessage) responsedMessage.getOrginalMessage().getExtra();
                                        jSONObject.put("originUrl", requestUrlParserNetMessage.getUrl());
                                        jSONObject.put("linkNum", requestUrlParserNetMessage.getLinkNum());
                                    }
                                } catch (Exception e) {
                                    if (TbadkApplication.getInst().isDebugMode()) {
                                        throw new JsonSyntaxException("parseLink端能力执行失败：" + e.getMessage());
                                    }
                                }
                            }
                            if ((responsedMessage instanceof UrlParserHttpResponseMessage) && (responseData = ((UrlParserHttpResponseMessage) responsedMessage).getResponseData()) != null && responseData.data != null) {
                                jSONObject.put("url_type", responseData.data.url_type);
                                jSONObject.put("status", responseData.data.status);
                                jSONObject.put("image", responseData.data.image);
                                jSONObject.put("link_from", responseData.data.link_from);
                                jSONObject.put("title", responseData.data.title);
                                jSONObject.put("price_txt", responseData.data.price_txt);
                                jSONObject.put("is_recognize", responseData.data.is_recognize);
                                jSONObject.put("description", responseData.data.description);
                                if (responseData.data.card_link_info != null) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("type", responseData.data.card_link_info.type);
                                    jSONObject2.put(EditHeadActivityConfig.IMAGE_URL, responseData.data.card_link_info.image_url);
                                    jSONObject2.put("tag_text", responseData.data.card_link_info.tag_text);
                                    jSONObject2.put("tag_color", responseData.data.card_link_info.tag_color);
                                    jSONObject2.put("title", responseData.data.card_link_info.title);
                                    jSONObject2.put(GameGuideConfigInfo.KEY_CONTENT1, responseData.data.card_link_info.content1);
                                    jSONObject2.put(GameGuideConfigInfo.KEY_CONTENT2, responseData.data.card_link_info.content2);
                                    jSONObject2.put("btn_style", responseData.data.card_link_info.btn_style);
                                    jSONObject2.put("btn_text", responseData.data.card_link_info.btn_text);
                                    jSONObject2.put("text_btn_status", responseData.data.card_link_info.text_btn_status);
                                    jSONObject2.put("url", responseData.data.card_link_info.url);
                                    jSONObject.put("card_link_info", jSONObject2);
                                }
                            }
                            if (this.e != null) {
                                linkedHashMap.put("result", jSONObject.toString());
                                linkedHashMap.put("NotificationKey", this.f);
                                SafeHandler.getInst().post(new a(this, linkedHashMap));
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a extends bu5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(ps4 ps4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps4Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bu5
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                wsa.h(this.a);
                return this.a;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements gt5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ps4 ps4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gt5
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921557, str));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends bu5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(ps4 ps4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.bu5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                wsa.b();
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements gt5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(ps4 ps4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.gt5
        public void onReturnDataInUI(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921558));
                ju4.c().a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends bu5<List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(ps4 ps4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bu5
        public List<String> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return wsa.k();
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements gt5<List<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;

        public f(ps4 ps4Var, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps4Var, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gt5
        /* renamed from: a */
        public void onReturnDataInUI(List<String> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && !ListUtils.isEmpty(list)) {
                int count = ListUtils.getCount(list);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < count; i++) {
                    jSONArray.put(list.get(i));
                }
                linkedHashMap.put("result", jSONArray.toString());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921556, Boolean.TRUE));
                if (this.a != null) {
                    ej6.a().d(this.a, SearchJsBridge.METHOD_GET_SEARCH_HISTORY, linkedHashMap);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class h extends BdAsyncTask<Object, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final String b;
        public final HashMap<String, String> c;
        public final WeakReference<WebView> d;
        public final int e;
        public final int f;
        public final long g;

        public h(String str, String str2, int i, int i2, long j, HashMap<String, String> hashMap, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), hashMap, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.e = i;
            this.f = i2;
            this.g = j;
            this.c = hashMap;
            this.d = new WeakReference<>(webView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Object... objArr) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable() && !TextUtils.isEmpty(this.a)) {
                    try {
                        NetWork netWork = new NetWork(this.a);
                        boolean z2 = false;
                        if (this.e == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        netWork.setNeedBdussForPost(z);
                        if (this.f == 1) {
                            z2 = true;
                        }
                        netWork.setNeedTbs(z2);
                        if (this.c != null && !this.c.isEmpty()) {
                            for (Map.Entry<String, String> entry : this.c.entrySet()) {
                                netWork.addPostData(entry.getKey(), entry.getValue());
                            }
                        }
                        if (CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE.equals(this.b)) {
                            return netWork.getNetString();
                        }
                        return netWork.postNetData();
                    } catch (Exception e) {
                        TbLog hybridLog = HybridLog.getInstance();
                        hybridLog.e("nativeNetworkProxy", "request Exception:" + e);
                        BdLog.e(e.getMessage());
                        return "";
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                super.onPostExecute((h) str);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("result", str);
                linkedHashMap.put("NotificationKey", this.a + this.g);
                if (this.d.get() != null) {
                    ej6.a().d(this.d.get(), "nativeNetworkProxyResult", linkedHashMap);
                }
            }
        }
    }

    public ps4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new zt4();
    }

    @Override // com.baidu.tieba.dj6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (!"CommonJSBridge".equals(str)) {
                return false;
            }
            if (SearchJsBridge.METHOD_GET_SEARCH_HISTORY.equals(str2)) {
                jsPromptResult.confirm(g(webView).a());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921556, Boolean.TRUE));
                return true;
            } else if (SearchJsBridge.METHOD_DELETE_SEARCH_HISTORY.equals(str2)) {
                try {
                    jsPromptResult.confirm(e(webView, new JSONObject(str3).optString("query")).a());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                return true;
            } else if (SearchJsBridge.METHOD_DELETE_ALL_SEARCH_HISTORY.equals(str2)) {
                jsPromptResult.confirm(d(webView).a());
                return true;
            } else if (SearchJsBridge.METHOD_OPEN_SEACH_PAGE.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(n(webView, jSONObject.optString("query"), jSONObject.optInt("sub_type")).a());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                return true;
            } else if (SearchJsBridge.GET_SEARCH_AD_COOKIE.equals(str2)) {
                jsPromptResult.confirm(f(webView).a());
                return true;
            } else {
                if (TextUtils.equals("requestByNative", str2)) {
                    try {
                        OfflineBridgeData offlineBridgeData = (OfflineBridgeData) OrmObject.objectWithJsonStr(str3, OfflineBridgeData.class);
                        offlineBridgeData.begin = System.currentTimeMillis();
                        this.a.j(webView, offlineBridgeData, offlineBridgeData.callBack);
                        jsPromptResult.confirm();
                        return true;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public final void c(JSONObject jSONObject, String str, String str2) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str, str2) == null) {
            jSONObject.put(str, str2);
        }
    }

    public osa d(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, webView)) == null) {
            osa osaVar = new osa();
            fu5.b(new c(this), new d(this));
            return osaVar;
        }
        return (osa) invokeL.objValue;
    }

    public osa f(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, webView)) == null) {
            osa osaVar = new osa();
            osaVar.o(j());
            return osaVar;
        }
        return (osa) invokeL.objValue;
    }

    public osa i(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView)) == null) {
            osa osaVar = new osa();
            fu5.b(new e(this), new f(this, webView));
            return osaVar;
        }
        return (osa) invokeL.objValue;
    }

    public osa e(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
            osa osaVar = new osa();
            fu5.b(new a(this, str), new b(this));
            return osaVar;
        }
        return (osa) invokeLL.objValue;
    }

    public osa h(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, hashMap)) == null) {
            osa osaVar = new osa();
            if (hashMap != null && hashMap.get("result") != null) {
                osaVar.o(hashMap.get("result"));
            }
            return osaVar;
        }
        return (osa) invokeLL.objValue;
    }

    public /* synthetic */ void k(WebView webView, OfflineBridgeData offlineBridgeData) {
        this.a.k(webView, offlineBridgeData, offlineBridgeData.callBack, true);
    }

    public osa g(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, webView)) == null) {
            osa osaVar = new osa();
            List<String> b2 = ju4.c().b();
            int count = ListUtils.getCount(b2);
            if (count == 0) {
                osaVar.o("");
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < count; i++) {
                jSONArray.put(b2.get(i));
            }
            osaVar.o(jSONArray.toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921556, Boolean.TRUE));
            return osaVar;
        }
        return (osa) invokeL.objValue;
    }

    public final String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                MercatorModel.MercatorData e2 = MercatorModel.d().e();
                if (e2 != null) {
                    c(jSONObject, SearchJsBridge.COOKIE_MERCATOR_LAT, e2.R());
                    c(jSONObject, SearchJsBridge.COOKIE_MERCATOR_LON, e2.S());
                    c(jSONObject, SearchJsBridge.COOKIE_MERCATOR_CITY, String.valueOf(e2.O()));
                    c(jSONObject, SearchJsBridge.COOKIE_MERCATOR_RADIUS, e2.U());
                    c(jSONObject, SearchJsBridge.COOKIE_MERCATOR_TIME, String.valueOf(e2.V()));
                }
                c(jSONObject, SearchJsBridge.COOKIE_MOD, DeviceInfoHelper.getModel());
                c(jSONObject, "ov", DeviceInfoHelper.getOsVersion());
                c(jSONObject, "os_type", String.valueOf(2));
                c(jSONObject, "net_type", String.valueOf(BdNetTypeUtil.netType()));
                c(jSONObject, "imei", TbadkCoreApplication.getInst().getImei());
                c(jSONObject, "from", TbConfig.getFrom());
                c(jSONObject, "cfrom", TbConfig.getCurrentFrom());
                c(jSONObject, "_client_version", TbConfig.getVersion());
                c(jSONObject, "CUID", TbadkCoreApplication.getInst().getCuid());
                String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
                c(jSONObject, "shoubai_cuid", cuidGalaxy2);
                c(jSONObject, "cuid_galaxy2", cuidGalaxy2);
                if (!TextUtils.isEmpty(cuidGalaxy2)) {
                    c(jSONObject, "baiduid", new String(Base64Encoder.B64Encode(cuidGalaxy2.getBytes())));
                }
            } catch (JSONException e3) {
                BdLog.e(e3);
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public osa l(WebView webView, String str, String str2, String str3, JSONObject jSONObject, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{webView, str, str2, str3, jSONObject, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            osa osaVar = new osa();
            HashMap hashMap = new HashMap();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            new h(str2 + str, str3, i, i2, currentTimeMillis, hashMap, webView).execute(new Object[0]);
            osaVar.x(str2 + str + currentTimeMillis);
            return osaVar;
        }
        return (osa) invokeCommon.objValue;
    }

    public osa m(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, webView, hashMap)) == null) {
            osa osaVar = new osa();
            if (hashMap != null && hashMap.get("result") != null) {
                osaVar.o(OfflineWebViewHttpResMsg.quote(hashMap.get("result")));
                osaVar.x(hashMap.get("NotificationKey"));
            }
            osaVar.A(true);
            return osaVar;
        }
        return (osa) invokeLL.objValue;
    }

    public osa p(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, webView, hashMap)) == null) {
            osa osaVar = new osa();
            if (hashMap != null && hashMap.get("result") != null) {
                osaVar.o(hashMap.get("result"));
                osaVar.x(hashMap.get("NotificationKey"));
            }
            return osaVar;
        }
        return (osa) invokeLL.objValue;
    }

    public osa r(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, webView, hashMap)) == null) {
            osa osaVar = new osa();
            if (hashMap != null && hashMap.get("result") != null) {
                osaVar.o(hashMap.get("result"));
                osaVar.x(hashMap.get("NotificationKey"));
            }
            osaVar.A(true);
            return osaVar;
        }
        return (osa) invokeLL.objValue;
    }

    public osa s(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, webView, hashMap)) == null) {
            osa osaVar = new osa();
            try {
                osaVar.o(new JSONArray(hashMap.get("data").toString()).toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return osaVar;
        }
        return (osa) invokeLL.objValue;
    }

    public osa n(WebView webView, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048589, this, webView, str, i)) == null) {
            osa osaVar = new osa();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("query", str);
                jSONObject.put(AdvisoryMsgBusinessExtra.SUBTYPE_KEY, i);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921559, jSONObject.toString()));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return osaVar;
        }
        return (osa) invokeLLI.objValue;
    }

    public osa o(WebView webView, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, webView, str, str2, str3)) == null) {
            osa osaVar = new osa();
            String str4 = str2 + "_" + str3 + "_" + System.currentTimeMillis();
            osaVar.x(str4);
            RequestUrlParserNetMessage requestUrlParserNetMessage = new RequestUrlParserNetMessage();
            requestUrlParserNetMessage.setParams(JavaTypesHelper.toLong(str, 0L), JavaTypesHelper.toInt(str3, 0), str2, 0);
            MessageTask findTask = MessageManager.getInstance().findTask(requestUrlParserNetMessage.getHttpMessage().getCmd());
            if (!(findTask instanceof HttpMessageTask)) {
                return osaVar;
            }
            new g(this, requestUrlParserNetMessage.getHttpMessage(), (HttpMessageTask) findTask, webView, str4).execute(new HttpMessage[0]);
            return osaVar;
        }
        return (osa) invokeLLLL.objValue;
    }

    public osa q(final WebView webView, String str, String str2, String str3, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048593, this, webView, str, str2, str3, jSONObject)) == null) {
            osa osaVar = new osa();
            final OfflineBridgeData offlineBridgeData = new OfflineBridgeData();
            offlineBridgeData.url = str;
            offlineBridgeData.type = str2;
            offlineBridgeData.module = str3;
            if (jSONObject != null) {
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
                offlineBridgeData.data = hashMap;
            }
            offlineBridgeData.begin = System.currentTimeMillis();
            SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.gs4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ps4.this.k(webView, offlineBridgeData);
                    }
                }
            });
            osaVar.x(str);
            return osaVar;
        }
        return (osa) invokeLLLLL.objValue;
    }
}
