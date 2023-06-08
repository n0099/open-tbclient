package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.browser.core.statistics.HybridStatisticKey;
import com.baidu.tieba.quickWebView.message.WebViewCacheResHttpMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResSocketMsg;
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
/* loaded from: classes8.dex */
public class vk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, String> a;
    public boolean b;
    public final CustomMessageListener c;
    public final jb d;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(vk6 vk6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk6Var, Integer.valueOf(i)};
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
            this.a = vk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.b || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371) {
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
            vk6.u("sync return", "", mm6.a(pairArr), "", "");
            if (!QuickWebViewSwitch.getInOn()) {
                return;
            }
            if (!TbSingleton.getInstance().isUploadOffPack() && !TbSingleton.getInstance().isClearOffPack()) {
                dl6.c();
                return;
            }
            al6 al6Var = new al6();
            al6Var.setPriority(4);
            al6Var.execute(new Void[0]);
        }
    }

    /* loaded from: classes8.dex */
    public class b extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(vk6 vk6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = vk6Var;
        }

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage != null && !responsedMessage.hasError()) {
                    if (responsedMessage instanceof WebViewCacheResHttpMsg) {
                        WebViewCacheResHttpMsg webViewCacheResHttpMsg = (WebViewCacheResHttpMsg) responsedMessage;
                        this.a.v(webViewCacheResHttpMsg);
                        this.a.e(webViewCacheResHttpMsg.getModuleInfos());
                        return;
                    } else if (!(responsedMessage instanceof WebViewCacheResSocketMsg)) {
                        return;
                    } else {
                        this.a.e(((WebViewCacheResSocketMsg) responsedMessage).getModuleInfos());
                        return;
                    }
                }
                if (QuickWebViewSwitch.getInOn()) {
                    str = "1";
                } else {
                    str = "0";
                }
                vk6.u("request webCacheInfo", "error", mm6.a(Pair.create("offline_switch", str)), "", "");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final vk6 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-343545111, "Lcom/baidu/tieba/vk6$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-343545111, "Lcom/baidu/tieba/vk6$c;");
                    return;
                }
            }
            a = new vk6(null);
        }
    }

    public vk6() {
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
        this.c = new a(this, 2001371);
        this.d = new b(this, CmdConfigHttp.WEBVIEW_CACHE_INFO, 309485);
    }

    public /* synthetic */ vk6(a aVar) {
        this();
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && !TextUtils.isEmpty(str)) {
            this.a.remove(str);
        }
    }

    public String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.a.get(str);
        }
        return (String) invokeL.objValue;
    }

    public void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) && !TextUtils.isEmpty(str)) {
            this.a.put(str, str2);
        }
    }

    public static void f(String str, String str2, String str3) {
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, str2, str3) == null) {
            m().g(str);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.equals("0.0.0.0", str3)) {
                str4 = "success";
            } else {
                str4 = "error";
            }
            u("delete bundle", str4, mm6.a(Pair.create("pre_module_name", str), Pair.create("pre_version", str3)), str, str2);
        }
    }

    public static void i(File file, String str, String str2) {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65543, null, file, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
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

    public static void k(String str, kl9 kl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, kl9Var) == null) {
            String o = m().o(str);
            String c2 = kl9Var.c();
            boolean d = kl9Var.d();
            if (StringUtils.isNull(o)) {
                o = "0.0.0.0";
            }
            if (d && c2.equals(o)) {
                wk6.d().c(str);
                return;
            }
            if (d) {
                u("download bundle", "start", mm6.a(Pair.create("pre_module_name", str), Pair.create("pre_version", o)), str, c2);
            }
            if (d) {
                bl6.c(str, kl9Var);
            } else {
                f(str, c2, o);
            }
        }
    }

    public static vk6 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return c.a;
        }
        return (vk6) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.clear();
        }
    }

    public File l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new File(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath(), "bdtbNWCache");
        }
        return (File) invokeV.objValue;
    }

    public File n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new File(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath(), "bdtbWCacheTemp");
        }
        return (File) invokeV.objValue;
    }

    @NonNull
    public Set<String> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a.keySet();
        }
        return (Set) invokeV.objValue;
    }

    public void t() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!jm6.b(this.a)) {
                str = new JSONObject(this.a).toString();
            } else {
                str = "";
            }
            n95.m().B("pref_key_quick_webview_versions", str);
        }
    }

    public JSONObject x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.a.isEmpty()) {
                return null;
            }
            return new JSONObject(this.a);
        }
        return (JSONObject) invokeV.objValue;
    }

    public static void u(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65546, null, str, str2, str3, str4, str5) == null) {
            xj6 a2 = xj6.a(HybridStatisticKey.KEY_UPDATE_OFFLINE_PACK);
            a2.c("obj_type", str);
            a2.c("obj_name", str4);
            a2.c("obj_param1", str5);
            a2.c("obj_locate", str2);
            a2.c(TiebaStatic.Params.OBJ_PARAM2, str3);
            a2.d();
        }
    }

    public final void e(Map<String, kl9> map) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, map) == null) {
            JSONObject jSONObject = new JSONObject();
            if (!jm6.b(map)) {
                for (Map.Entry<String, kl9> entry : map.entrySet()) {
                    String key = entry.getKey();
                    kl9 value = entry.getValue();
                    if (value != null && !StringUtils.isNull(value.c()) && !StringUtils.isNull(value.b()) && !StringUtils.isNull(value.a())) {
                        k(key, value);
                        str = value.c();
                    } else {
                        wk6.d().c(key);
                        str = "";
                    }
                    try {
                        jSONObject.put(key, str);
                    } catch (JSONException unused) {
                    }
                }
            } else {
                wk6.d().b();
            }
            u("request webCacheInfo", "success", jSONObject.toString(), "", "");
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        h(str);
        t();
        File file = new File(l(), str);
        if (file.exists() && file.isDirectory()) {
            FileHelper.deleteFileOrDir(file);
        }
    }

    public final void v(WebViewCacheResHttpMsg webViewCacheResHttpMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, webViewCacheResHttpMsg) == null) {
            try {
                List<String> header = webViewCacheResHttpMsg.getHeader("Set-Cookie");
                if (!jm6.a(header)) {
                    for (String str : header) {
                        if (!TextUtils.isEmpty(str) && str.contains("BAIDUID=")) {
                            qx4.n(str);
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            s();
            MessageManager.getInstance().registerListener(this.d);
            MessageManager.getInstance().registerListener(this.c);
            String s = n95.m().s("pref_key_quick_webview_versions", "");
            hm6.b("newHybrid", "开始初始化，当前离线包版本号:" + s);
            r(s);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            rx9.h(309485, WebViewCacheResSocketMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.WEBVIEW_CACHE_INFO, rx9.a(TbConfig.WEBVIEW_CACHE_URL, 309485));
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

    public void r(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, str) != null) || TextUtils.isEmpty(str)) {
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
}
