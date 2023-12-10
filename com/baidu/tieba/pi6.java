package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.browser.core.statistics.HybridStatisticKey;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.quickWebView.message.WebViewCacheResHttpMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResSocketMsg;
import com.baidu.tieba.si6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class pi6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, String> a;
    public boolean b;
    public boolean c;
    public final CustomMessageListener d;
    public final NetMessageListener e;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(pi6 pi6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.b || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921815) {
                return;
            }
            this.a.b = true;
            Pair[] pairArr = new Pair[1];
            if (QuickWebViewSwitch.getInOn()) {
                str = "1";
            } else {
                str = "0";
            }
            pairArr[0] = Pair.create("offline_switch", str);
            pi6.y("sync return", "", mk6.a(pairArr), "", "");
            if (!QuickWebViewSwitch.getInOn()) {
                return;
            }
            if (!TbSingleton.getInstance().isUploadOffPack() && !TbSingleton.getInstance().isClearOffPack()) {
                zi6.c();
                return;
            }
            wi6 wi6Var = new wi6();
            wi6Var.setPriority(4);
            wi6Var.execute(new Void[0]);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pi6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(pi6 pi6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi6Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pi6Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage != null && !responsedMessage.hasError()) {
                    if (responsedMessage instanceof WebViewCacheResHttpMsg) {
                        WebViewCacheResHttpMsg webViewCacheResHttpMsg = (WebViewCacheResHttpMsg) responsedMessage;
                        this.a.z(webViewCacheResHttpMsg);
                        this.a.f(webViewCacheResHttpMsg.getModuleInfos());
                    } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                        this.a.f(((WebViewCacheResSocketMsg) responsedMessage).getModuleInfos());
                    }
                    this.a.c = true;
                    return;
                }
                if (QuickWebViewSwitch.getInOn()) {
                    str = "1";
                } else {
                    str = "0";
                }
                pi6.y("request webCacheInfo", "error", mk6.a(Pair.create("offline_switch", str)), "", "");
                TbLog hybridLog = HybridLog.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("离线包接口获取失败");
                if (responsedMessage != null) {
                    str2 = responsedMessage.getErrorString();
                } else {
                    str2 = "返回数据为空";
                }
                sb.append(str2);
                hybridLog.e("Offline", sb.toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final pi6 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-517167059, "Lcom/baidu/tieba/pi6$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-517167059, "Lcom/baidu/tieba/pi6$c;");
                    return;
                }
            }
            a = new pi6(null);
        }
    }

    public pi6() {
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
        this.a = new ConcurrentHashMap();
        this.b = false;
        this.c = false;
        this.d = new a(this, 2921815);
        this.e = new b(this, CmdConfigHttp.WEBVIEW_CACHE_INFO, 309485);
    }

    public void s() {
        si6 si6Var;
        tf1<si6.a> tf1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (tf1Var = (si6Var = new si6()).a) != null && !jk6.a(tf1Var.getList())) {
            for (si6.a aVar : si6Var.a.getList()) {
                u(aVar.getKey(), aVar.getData());
            }
        }
    }

    public /* synthetic */ pi6(a aVar) {
        this();
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.a.remove(str);
        }
    }

    public String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.a.get(str);
        }
        return (String) invokeL.objValue;
    }

    public void A(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && !TextUtils.isEmpty(str)) {
            this.a.put(str, str2);
        }
    }

    public static void g(String str, String str2, String str3) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, str2, str3) == null) {
            n().h(str);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.equals("0.0.0.0", str3)) {
                str4 = "success";
            } else {
                str4 = "error";
            }
            y("delete bundle", str4, mk6.a(Pair.create("pre_module_name", str), Pair.create("pre_version", str3)), str, str2);
        }
    }

    public static void j(File file, String str, String str2) {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65544, null, file, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file2 = new File(file, str2);
            if (file2.exists() && file2.isDirectory() && (list = file2.list()) != null && list.length != 0) {
                for (String str3 : list) {
                    if (!StringUtils.isNull(str3) && !str3.equals(str)) {
                        FileHelper.deleteFileOrDir(new File(file2, str3));
                    }
                }
            }
        }
    }

    public static void l(String str, yga ygaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, ygaVar) == null) {
            String p = n().p(str);
            String c2 = ygaVar.c();
            boolean d = ygaVar.d();
            if (StringUtils.isNull(p)) {
                p = "0.0.0.0";
            }
            if (d && StringHelper.compareVersion(p, c2) > -1) {
                qi6.e().c(str);
                return;
            }
            if (d) {
                y("download bundle", "start", mk6.a(Pair.create("pre_module_name", str), Pair.create("pre_version", p)), str, c2);
            }
            if (d) {
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i("Offline", "根据离线包配置下载离线包：" + str + " " + c2 + " " + p);
                qi6.e().d(str);
                xi6.c(str, ygaVar);
                return;
            }
            TbLog hybridLog2 = HybridLog.getInstance();
            hybridLog2.e("Offline", "根据离线包配置移除本地离线包：" + str + " " + c2 + " " + p);
            g(str, c2, p);
        }
    }

    public static pi6 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return c.a;
        }
        return (pi6) invokeV.objValue;
    }

    public JSONObject B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a.isEmpty()) {
                return null;
            }
            return new JSONObject(this.a);
        }
        return (JSONObject) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a.clear();
        }
    }

    public File m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new File(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath(), "bdtbNWCache");
        }
        return (File) invokeV.objValue;
    }

    public File o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return new File(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath(), "bdtbWCacheTemp");
        }
        return (File) invokeV.objValue;
    }

    @NonNull
    public Set<String> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a.keySet();
        }
        return (Set) invokeV.objValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public void x() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (!jk6.b(this.a)) {
                str = new JSONObject(this.a).toString();
            } else {
                str = "";
            }
            SharedPrefHelper.getInstance().putString("pref_key_quick_webview_versions", str);
        }
    }

    public static void u(String str, yga ygaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, ygaVar) == null) {
            String p = n().p(str);
            if (StringUtils.isNull(p)) {
                p = "0.0.0.0";
            }
            String c2 = ygaVar.c();
            if (c2.equals(p)) {
                qi6.e().c(str);
            } else if (StringHelper.compareVersion(p, c2) == -1) {
                qi6.e().d(str);
                xi6.c(str, ygaVar);
            }
        }
    }

    public static void y(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65548, null, str, str2, str3, str4, str5) == null) {
            ph6 a2 = ph6.a(HybridStatisticKey.KEY_UPDATE_OFFLINE_PACK);
            a2.c("obj_type", str);
            a2.c("obj_name", str4);
            a2.c("obj_param1", str5);
            a2.c("obj_locate", str2);
            a2.c(TiebaStatic.Params.OBJ_PARAM2, str3);
            a2.d();
        }
    }

    public final void f(Map<String, yga> map) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            JSONObject jSONObject = new JSONObject();
            if (!jk6.b(map)) {
                for (Map.Entry<String, yga> entry : map.entrySet()) {
                    String key = entry.getKey();
                    yga value = entry.getValue();
                    if (value != null && !StringUtils.isNull(value.c()) && !StringUtils.isNull(value.b()) && !StringUtils.isNull(value.a())) {
                        l(key, value);
                        str = value.c();
                    } else {
                        qi6.e().c(key);
                        str = "";
                    }
                    try {
                        jSONObject.put(key, str);
                    } catch (JSONException unused) {
                    }
                }
            } else {
                qi6.e().b();
            }
            y("request webCacheInfo", "success", jSONObject.toString(), "", "");
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        qi6.e().i(str);
        i(str);
        x();
        File file = new File(m(), str);
        TbLog hybridLog = HybridLog.getInstance();
        hybridLog.e("Offline", "移除本地离线包：" + str + " " + this.a + " " + file);
        if (file.exists() && file.isDirectory()) {
            FileHelper.deleteFileOrDir(file);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            w();
            MessageManager.getInstance().registerListener(this.e);
            MessageManager.getInstance().registerListener(this.d);
            String string = SharedPrefHelper.getInstance().getString("pref_key_quick_webview_versions", "");
            TbLog hybridLog = HybridLog.getInstance();
            hybridLog.i("Offline", "离线包模块开始初始化，当前离线包版本号:" + string);
            v(string);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            wva.h(309485, WebViewCacheResSocketMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.WEBVIEW_CACHE_INFO, wva.a(TbConfig.WEBVIEW_CACHE_URL, 309485));
            tbHttpMessageTask.setResponsedClass(WebViewCacheResHttpMsg.class);
            if (TbSingleton.getInstance().isDebugToolMode()) {
                if (MessageManager.getInstance().findTask(tbHttpMessageTask.getCmd()) == null) {
                    MessageManager.getInstance().registerTask(tbHttpMessageTask);
                    return;
                }
                return;
            }
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.a.clear();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                    this.a.put(next, optString);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final void z(WebViewCacheResHttpMsg webViewCacheResHttpMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, webViewCacheResHttpMsg) == null) {
            try {
                List<String> header = webViewCacheResHttpMsg.getHeader("Set-Cookie");
                if (!jk6.a(header)) {
                    for (String str : header) {
                        if (!TextUtils.isEmpty(str) && str.contains("BAIDUID=")) {
                            BrowserHelper.setAdCookie(str);
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
