package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.chatmessage.messages.AdvisoryMsgBusinessExtra;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.browser.proxy.OfflineBridgeData;
import com.baidu.tbadk.browser.proxy.OfflineWebViewHttpResMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class oy4 implements zl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ez4 a;

    @Override // com.baidu.tieba.zl6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        yl6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.zl6
    public /* synthetic */ void onDestroy() {
        yl6.b(this);
    }

    /* loaded from: classes7.dex */
    public class a extends nx5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(oy4 oy4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy4Var, str};
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
        @Override // com.baidu.tieba.nx5
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                a1a.h(this.a);
                return this.a;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements rw5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(oy4 oy4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy4Var};
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
        @Override // com.baidu.tieba.rw5
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921557, str));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends nx5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(oy4 oy4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.nx5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a1a.b();
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements rw5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(oy4 oy4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oy4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.rw5
        public void onReturnDataInUI(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921558));
                lz4.c().a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends BdAsyncTask<Object, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final String b;
        public final HashMap<String, String> c;
        public final WeakReference<WebView> d;

        public e(String str, String str2, HashMap<String, String> hashMap, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, hashMap, webView};
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
            this.b = str2;
            this.c = hashMap;
            this.d = new WeakReference<>(webView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable() && !TextUtils.isEmpty(this.a)) {
                    try {
                        NetWork netWork = new NetWork(this.a);
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
                        tr8 hybridLog = HybridLog.getInstance();
                        hybridLog.b("nativeNetworkProxy", "request Exception:" + e);
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
                super.onPostExecute((e) str);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("result", str);
                linkedHashMap.put("NotificationKey", this.a);
                if (this.d.get() != null) {
                    am6.a().d(this.d.get(), "nativeNetworkProxyResult", linkedHashMap);
                }
            }
        }
    }

    public oy4() {
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
        this.a = new ez4();
    }

    @Override // com.baidu.tieba.zl6
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
                    jsPromptResult.confirm(l(webView, jSONObject.optString("query"), jSONObject.optInt("sub_type")).a());
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

    public t0a d(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, webView)) == null) {
            t0a t0aVar = new t0a();
            rx5.b(new c(this), new d(this));
            return t0aVar;
        }
        return (t0a) invokeL.objValue;
    }

    public t0a f(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, webView)) == null) {
            t0a t0aVar = new t0a();
            t0aVar.o(h());
            return t0aVar;
        }
        return (t0a) invokeL.objValue;
    }

    public t0a e(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
            t0a t0aVar = new t0a();
            rx5.b(new a(this, str), new b(this));
            return t0aVar;
        }
        return (t0a) invokeLL.objValue;
    }

    public /* synthetic */ void i(WebView webView, OfflineBridgeData offlineBridgeData) {
        this.a.k(webView, offlineBridgeData, offlineBridgeData.callBack, true);
    }

    public t0a g(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, webView)) == null) {
            t0a t0aVar = new t0a();
            List<String> b2 = lz4.c().b();
            int count = ListUtils.getCount(b2);
            if (count == 0) {
                t0aVar.o("");
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < count; i++) {
                jSONArray.put(b2.get(i));
            }
            t0aVar.o(jSONArray.toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921556, Boolean.TRUE));
            return t0aVar;
        }
        return (t0a) invokeL.objValue;
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                MercatorModel.MercatorData e2 = MercatorModel.d().e();
                if (e2 != null) {
                    c(jSONObject, SearchJsBridge.COOKIE_MERCATOR_LAT, e2.X());
                    c(jSONObject, SearchJsBridge.COOKIE_MERCATOR_LON, e2.Y());
                    c(jSONObject, SearchJsBridge.COOKIE_MERCATOR_CITY, String.valueOf(e2.U()));
                    c(jSONObject, SearchJsBridge.COOKIE_MERCATOR_RADIUS, e2.a0());
                    c(jSONObject, SearchJsBridge.COOKIE_MERCATOR_TIME, String.valueOf(e2.b0()));
                }
                c(jSONObject, SearchJsBridge.COOKIE_MOD, yi.g());
                c(jSONObject, "ov", yi.k());
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

    public t0a j(WebView webView, String str, String str2, String str3, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048585, this, webView, str, str2, str3, jSONObject)) == null) {
            t0a t0aVar = new t0a();
            HashMap hashMap = new HashMap();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
            }
            new e(str + str2, str3, hashMap, webView).execute(new Object[0]);
            t0aVar.x(str + str2);
            return t0aVar;
        }
        return (t0a) invokeLLLLL.objValue;
    }

    public t0a m(final WebView webView, String str, String str2, String str3, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048588, this, webView, str, str2, str3, jSONObject)) == null) {
            t0a t0aVar = new t0a();
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
            xg.a().post(new Runnable() { // from class: com.baidu.tieba.fy4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        oy4.this.i(webView, offlineBridgeData);
                    }
                }
            });
            t0aVar.x(str);
            return t0aVar;
        }
        return (t0a) invokeLLLLL.objValue;
    }

    public t0a k(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, webView, hashMap)) == null) {
            t0a t0aVar = new t0a();
            if (hashMap != null && hashMap.get("result") != null) {
                t0aVar.o(OfflineWebViewHttpResMsg.quote(hashMap.get("result")));
                t0aVar.x(hashMap.get("NotificationKey"));
            }
            t0aVar.A(true);
            return t0aVar;
        }
        return (t0a) invokeLL.objValue;
    }

    public t0a n(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, webView, hashMap)) == null) {
            t0a t0aVar = new t0a();
            if (hashMap != null && hashMap.get("result") != null) {
                t0aVar.o(hashMap.get("result"));
                t0aVar.x(hashMap.get("NotificationKey"));
            }
            t0aVar.A(true);
            return t0aVar;
        }
        return (t0a) invokeLL.objValue;
    }

    public t0a o(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, webView, hashMap)) == null) {
            t0a t0aVar = new t0a();
            try {
                t0aVar.o(new JSONArray(hashMap.get("data").toString()).toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return t0aVar;
        }
        return (t0a) invokeLL.objValue;
    }

    public t0a l(WebView webView, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048587, this, webView, str, i)) == null) {
            t0a t0aVar = new t0a();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("query", str);
                jSONObject.put(AdvisoryMsgBusinessExtra.SUBTYPE_KEY, i);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921559, jSONObject.toString()));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return t0aVar;
        }
        return (t0a) invokeLLI.objValue;
    }
}
