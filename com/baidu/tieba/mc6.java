package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.QuickWebViewSwitch;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class mc6 {
    public static /* synthetic */ Interceptable $ic;
    public static final String g;
    public static int h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public Map<String, String> c;
    public final Set<String> d;
    public final CustomMessageListener e;
    public final za f;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mc6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(mc6 mc6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mc6Var, Integer.valueOf(i)};
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
            this.a = mc6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2001371 || this.a.a) {
                return;
            }
            this.a.a = true;
            if (QuickWebViewSwitch.getInOn()) {
                if (!TbSingleton.getInstance().isUploadOffPack() && !TbSingleton.getInstance().isClearOffPack()) {
                    sc6 sc6Var = new sc6();
                    sc6Var.setPriority(4);
                    sc6Var.execute(new Void[0]);
                    return;
                }
                c cVar = new c(this.a, null);
                cVar.setPriority(4);
                cVar.execute(new Void[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(mc6 mc6Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mc6Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
            com.baidu.tieba.gt4.n(r0.get(r2));
         */
        @Override // com.baidu.tieba.za
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage instanceof WebViewCacheResHttpMsg) {
                WebViewCacheResHttpMsg webViewCacheResHttpMsg = (WebViewCacheResHttpMsg) responsedMessage;
                try {
                    List<String> header = webViewCacheResHttpMsg.getHeader("Set-Cookie");
                    if (header != null && header.size() > 0) {
                        int i = 0;
                        while (true) {
                            if (i >= header.size()) {
                                break;
                            }
                            if (!TextUtils.isEmpty(header.get(i)) && header.get(i).contains("BAIDUID=")) {
                                break;
                            }
                            i++;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Map<String, h09> moduleInfos = webViewCacheResHttpMsg.getModuleInfos();
                if (moduleInfos != null && moduleInfos.size() > 0) {
                    for (String str : moduleInfos.keySet()) {
                        mc6.f(str, moduleInfos.get(str));
                    }
                    return;
                }
                pc6.b().h(true);
            } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                Map<String, h09> moduleInfos2 = ((WebViewCacheResSocketMsg) responsedMessage).getModuleInfos();
                if (moduleInfos2 != null && moduleInfos2.size() > 0) {
                    for (String str2 : moduleInfos2.keySet()) {
                        mc6.f(str2, moduleInfos2.get(str2));
                    }
                    return;
                }
                pc6.b().h(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<Void, Void, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mc6 a;

        public c(mc6 mc6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mc6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mc6Var;
        }

        public /* synthetic */ c(mc6 mc6Var, a aVar) {
            this(mc6Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                String modName = TbSingleton.getInstance().getModName();
                if (!TextUtils.isEmpty(modName)) {
                    e v = this.a.v(modName);
                    NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK_STATUS);
                    netWork.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
                    netWork.addPostData("mod_name", modName);
                    if (v.a) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    netWork.addPostData("status", str);
                    if (v.a) {
                        str2 = "";
                    } else {
                        str2 = v.b;
                    }
                    netWork.addPostData("fail_reason", str2);
                    netWork.postNetData();
                    return null;
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
                sc6 sc6Var = new sc6();
                sc6Var.setPriority(4);
                sc6Var.execute(new Void[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public static final mc6 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-608595607, "Lcom/baidu/tieba/mc6$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-608595607, "Lcom/baidu/tieba/mc6$d;");
                    return;
                }
            }
            a = new mc6(null);
        }
    }

    /* loaded from: classes5.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;

        public e() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947967913, "Lcom/baidu/tieba/mc6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947967913, "Lcom/baidu/tieba/mc6;");
                return;
            }
        }
        g = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
        h = 0;
    }

    public mc6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.d = new HashSet();
        this.e = new a(this, 2001371);
        this.f = new b(this, CmdConfigHttp.WEBVIEW_CACHE_INFO, 309485);
    }

    public /* synthetic */ mc6(a aVar) {
        this();
    }

    public static boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (!QuickWebViewSwitch.getInOn()) {
                return true;
            }
            try {
                return "0".equals(Uri.parse(str).getQueryParameter("useOfflinePackage"));
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void e(String str) {
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !TextUtils.isEmpty(str) && (map = this.c) != null) {
            map.remove(str);
        }
    }

    public String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (this.c != null && !TextUtils.isEmpty(str)) {
                return this.c.get(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public synchronized boolean l(String str) {
        InterceptResult invokeL;
        boolean contains;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            synchronized (this) {
                contains = this.d.contains(str);
            }
            return contains;
        }
        return invokeL.booleanValue;
    }

    public synchronized void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            synchronized (this) {
                this.d.add(str);
            }
        }
    }

    public synchronized void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            synchronized (this) {
                this.d.remove(str);
            }
        }
    }

    @NonNull
    public static String t(boolean z, @Nullable String str) {
        InterceptResult invokeZL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65546, null, z, str)) == null) {
            if (z) {
                str2 = "none";
            } else {
                str2 = "0.0.0.0";
            }
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            return str;
        }
        return (String) invokeZL.objValue;
    }

    public void u(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, str, str2) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.c == null) {
            this.c = new ConcurrentHashMap();
        }
        this.c.put(str, str2);
    }

    public static void f(String str, h09 h09Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, h09Var) == null) {
            if (h09Var != null && !StringUtils.isNull(h09Var.c()) && !StringUtils.isNull(h09Var.b()) && !StringUtils.isNull(h09Var.a())) {
                String i = h().i(str);
                String c2 = h09Var.c();
                String a2 = h09Var.a();
                boolean d2 = h09Var.d();
                if (StringUtils.isNull(i)) {
                    i = "0.0.0.0";
                }
                if (d2 && c2.equals(i)) {
                    pc6.b().i(true, str);
                    return;
                }
                b35.a("OfflineCache", -1L, 0, "downloadCache", 0, "", "url", a2, "hybridVersion", c2, "lastVersion", i, "type", "start", "hybridName", str, "hybridResult", "success");
                if (!h().l(str)) {
                    pd6.b("lt-log", "downloadCacheZip :" + str);
                    h().p(str);
                    new qc6(str, h09Var, true ^ d2).execute(new Void[0]);
                    return;
                }
                return;
            }
            pc6.b().i(true, str);
        }
    }

    public static mc6 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return d.a;
        }
        return (mc6) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public Set<String> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.c == null) {
                this.c = new ConcurrentHashMap();
            }
            return this.c.keySet();
        }
        return (Set) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            String w = w();
            if (!TextUtils.isEmpty(w)) {
                m35.m().B("pref_key_quick_webview_versions", w);
            }
        }
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Map<String, String> map = this.c;
            if (map != null && !map.isEmpty()) {
                return new JSONObject(this.c).toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q();
            MessageManager.getInstance().registerListener(this.f);
            MessageManager.getInstance().registerListener(this.e);
            this.b = new File(g + "bdtbNWCache").getAbsolutePath();
            o(m35.m().s("pref_key_quick_webview_versions", ""));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            jb9.h(309485, WebViewCacheResSocketMsg.class, false, false);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.WEBVIEW_CACHE_INFO, jb9.a(TbConfig.WEBVIEW_CACHE_URL, 309485));
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

    public final void n(String str, e eVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, eVar) == null) {
            if (StringUtils.isNull(str)) {
                eVar.b = "serve return is null";
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("error_code") == 0) {
                    z = true;
                } else {
                    z = false;
                }
                eVar.a = z;
                eVar.b = jSONObject.optString(GameCodeGetResponseMsg.PARAM_ERROR_MSG);
            } catch (JSONException e2) {
                eVar.b = "parse json exception";
                BdLog.e(e2);
            }
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(optString)) {
                    if (this.c == null) {
                        this.c = new ConcurrentHashMap();
                    }
                    this.c.put(next, optString);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final e v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            e eVar = new e();
            if (TextUtils.isEmpty(str)) {
                eVar.b = "module not exit";
                return eVar;
            }
            File file = new File(g + "bdtbNWCache", str);
            String i = h().i(str);
            if (TbSingleton.getInstance().isUploadOffPack()) {
                eVar.a = false;
                if (!file.exists()) {
                    eVar.b = "bundle not exist";
                    return eVar;
                } else if (TextUtils.isEmpty(i)) {
                    eVar.b = "the local has no valid version name";
                    return eVar;
                } else {
                    String str2 = file.getAbsolutePath() + "/" + i + "/";
                    if (!new File(str2).exists()) {
                        eVar.b = "bundle not exist";
                        return eVar;
                    }
                    String str3 = file.getAbsolutePath() + "/" + i + ".zip";
                    File file2 = new File(str3);
                    if (file2.exists()) {
                        FileHelper.deleteFileOrDir(file2);
                    }
                    if (u25.e(str2, str3)) {
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK);
                        netWork.addPostData("offline_pack_version", i);
                        netWork.addPostData("mod_name", str);
                        netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                        netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                        n(netWork.uploadFile("offline_pack_file_stream", str3), eVar);
                        if (!eVar.a) {
                            return eVar;
                        }
                    } else {
                        eVar.b = "zip bundle error";
                        return eVar;
                    }
                }
            } else {
                eVar.a = true;
            }
            if (TbSingleton.getInstance().isClearOffPack()) {
                rc6.a(str);
                if (!TextUtils.isEmpty(i)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", str).param("obj_id", i));
                }
                if (file.exists() && !StringUtils.isNull(i)) {
                    if (!new File(file.getAbsolutePath(), i).exists()) {
                        return eVar;
                    }
                    eVar.b = "delete fail";
                    eVar.a = false;
                }
            }
            return eVar;
        }
        return (e) invokeL.objValue;
    }
}
