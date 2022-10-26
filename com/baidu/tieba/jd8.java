package com.baidu.tieba;

import android.text.TextUtils;
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
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheReqMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResHttpMsg;
import com.baidu.tieba.quickWebView.message.WebViewCacheResSocketMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class jd8 {
    public static /* synthetic */ Interceptable $ic;
    public static jd8 f;
    public static final String g;
    public static int h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public String b;
    public Map c;
    public CustomMessageListener d;
    public qb e;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(jd8 jd8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd8Var, Integer.valueOf(i)};
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
            this.a = jd8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && !this.a.a) {
                this.a.a = true;
                if (QuickWebViewSwitch.getInOn()) {
                    if (!TbSingleton.getInstance().isUploadOffPack() && !TbSingleton.getInstance().isClearOffPack()) {
                        f fVar = new f(this.a);
                        fVar.setPriority(4);
                        fVar.execute(new Void[0]);
                        return;
                    }
                    c cVar = new c(this.a, null);
                    cVar.setPriority(4);
                    cVar.execute(new Void[0]);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(jd8 jd8Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd8Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            com.baidu.tieba.zo4.k((java.lang.String) r0.get(r2));
         */
        @Override // com.baidu.tieba.qb
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage instanceof WebViewCacheResHttpMsg) {
                WebViewCacheResHttpMsg webViewCacheResHttpMsg = (WebViewCacheResHttpMsg) responsedMessage;
                try {
                    List header = webViewCacheResHttpMsg.getHeader("Set-Cookie");
                    if (header != null && header.size() > 0) {
                        int i = 0;
                        while (true) {
                            if (i >= header.size()) {
                                break;
                            }
                            if (!TextUtils.isEmpty((CharSequence) header.get(i)) && ((String) header.get(i)).contains("BAIDUID=")) {
                                break;
                            }
                            i++;
                        }
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                Map moduleInfos = webViewCacheResHttpMsg.getModuleInfos();
                if (moduleInfos != null && moduleInfos.size() > 0) {
                    for (String str : moduleInfos.keySet()) {
                        jd8.o(str, (nd8) moduleInfos.get(str));
                    }
                    return;
                }
                kd8.a().g(true);
            } else if (responsedMessage instanceof WebViewCacheResSocketMsg) {
                Map moduleInfos2 = ((WebViewCacheResSocketMsg) responsedMessage).getModuleInfos();
                if (moduleInfos2 != null && moduleInfos2.size() > 0) {
                    for (String str2 : moduleInfos2.keySet()) {
                        jd8.o(str2, (nd8) moduleInfos2.get(str2));
                    }
                    return;
                }
                kd8.a().g(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ jd8 b;

        public c(jd8 jd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jd8Var;
            this.a = null;
        }

        public /* synthetic */ c(jd8 jd8Var, a aVar) {
            this(jd8Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            e C;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                String modName = TbSingleton.getInstance().getModName();
                if (TextUtils.isEmpty(modName) || (C = this.b.C(modName)) == null) {
                    return null;
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK_STATUS);
                this.a = netWork;
                netWork.addPostData("cuid", TbadkCoreApplication.getInst().getCuid());
                this.a.addPostData("mod_name", modName);
                NetWork netWork2 = this.a;
                if (C.a) {
                    str = "1";
                } else {
                    str = "2";
                }
                netWork2.addPostData("status", str);
                NetWork netWork3 = this.a;
                if (C.a) {
                    str2 = "";
                } else {
                    str2 = C.b;
                }
                netWork3.addPostData("fail_reason", str2);
                this.a.postNetData();
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                f fVar = new f(this.b);
                fVar.setPriority(4);
                fVar.execute(new Void[0]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final nd8 b;
        public final String c;
        public final String d;
        public final String e;
        public final boolean f;
        public NetWork g;

        public d(String str, nd8 nd8Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, nd8Var, Boolean.valueOf(z)};
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
            this.b = nd8Var;
            this.d = nd8Var.c();
            this.c = this.b.a();
            this.e = this.b.b();
            this.f = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:31:0x016e  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x01ca  */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public h doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            h r;
            HashMap hashMap;
            InputStream inputStream;
            FileInputStream fileInputStream;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, voidArr)) != null) {
                return (h) invokeL.objValue;
            }
            jd8.m(this.a);
            jd8.q().k(this.a);
            if (this.f) {
                if (!TextUtils.isEmpty(jd8.q().s(this.a))) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.a).param("obj_id", this.d));
                }
                return null;
            }
            NetWork netWork = new NetWork();
            this.g = netWork;
            netWork.setUrl(this.c);
            new File(jd8.g + "bdtbWCacheTemp/" + this.a + "/").mkdirs();
            String str2 = jd8.g + "bdtbWCacheTemp/" + this.a + "/bdtbNWCache.zip";
            if (this.g.downloadFile(str2, null, 0, 3, 0, true)) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "1"));
                try {
                    try {
                        fileInputStream = new FileInputStream(str2);
                        try {
                            String b = mj.b(fileInputStream);
                            if (StringUtils.isNull(b) || !b.toLowerCase().equals(this.e.toLowerCase())) {
                                jd8.h = 2;
                                jx4.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "md5 error");
                                jd8.m(this.a);
                                gj.e(fileInputStream);
                                return null;
                            }
                        } catch (FileNotFoundException e) {
                            e = e;
                            e.printStackTrace();
                            gj.e(fileInputStream);
                            str = jd8.g + "bdtbWCacheTemp/" + this.a + "/" + this.d + "/";
                            new File(str).mkdirs();
                            if (!zw4.b(str2, str)) {
                            }
                            jd8.m(this.a);
                            r = jd8.r(this.a, this.d);
                            if (r == null) {
                            }
                            jd8.h = 5;
                            jx4.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "bundle incomplete");
                            jd8.q().k(this.a);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = "obj_type";
                        gj.e(inputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    gj.e(inputStream);
                    throw th;
                }
                gj.e(fileInputStream);
                str = jd8.g + "bdtbWCacheTemp/" + this.a + "/" + this.d + "/";
                new File(str).mkdirs();
                if (!zw4.b(str2, str)) {
                    String str3 = jd8.g + "bdtbNWCache/" + this.a + "/" + this.d + "/";
                    new File(str3).mkdirs();
                    if (!FileHelper.CopyDir(str, str3, true)) {
                        jd8.h = 4;
                        jx4.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "write error");
                    }
                } else {
                    jd8.h = 3;
                    jx4.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "unzip error");
                }
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "2"));
                jd8.h = 1;
                jx4.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "download error");
            }
            jd8.m(this.a);
            r = jd8.r(this.a, this.d);
            if (r == null && !TextUtils.isEmpty(r.a) && (hashMap = r.b) != null && hashMap.size() != 0) {
                jd8.l(r.c, this.a);
                return r;
            }
            jd8.h = 5;
            jx4.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "bundle incomplete");
            jd8.q().k(this.a);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
                super.onPostExecute(hVar);
                if (hVar != null) {
                    jd8.q().B(this.a, hVar.c);
                    jd8.q().z();
                    kd8.a().l(this.a, hVar.b);
                    kd8.a().h(true, this.a);
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.a).param("obj_id", hVar.c));
                    return;
                }
                jd8.q().j(this.a);
                jd8.q().z();
                kd8.a().f(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e {
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

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd8 a;

        public f(jd8 jd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public g doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                g gVar = new g(null);
                for (String str : jd8.q().t()) {
                    String s = jd8.q().s(str);
                    h r = jd8.r(str, s);
                    if (r != null && !TextUtils.isEmpty(r.a) && (hashMap = r.b) != null && hashMap.size() != 0) {
                        if (gVar.a == null) {
                            gVar.a = new HashMap();
                        }
                        gVar.a.put(str, r);
                        if (gVar.b == null) {
                            gVar.b = new HashMap();
                        }
                        gVar.b.putAll(r.b);
                        jd8.l(r.c, str);
                    } else {
                        jd8.h = 5;
                        jx4.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", str, "hybridVersion", s, "hybridResult", "bundle incomplete");
                        this.a.k(str);
                    }
                }
                return gVar;
            }
            return (g) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
                if (gVar == null) {
                    jx4.a("OfflineCache", -1L, -1, "readFile", -1, "read error", new Object[0]);
                } else {
                    kd8.a().i(gVar.b);
                }
                MessageManager.getInstance().sendMessage(new WebViewCacheReqMsg("0.0.0.0"));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map a;
        public HashMap b;

        public g() {
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

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public HashMap b;
        public String c;

        public h() {
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

        public /* synthetic */ h(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947879563, "Lcom/baidu/tieba/jd8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947879563, "Lcom/baidu/tieba/jd8;");
                return;
            }
        }
        g = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
        h = 0;
    }

    public jd8() {
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
        this.d = new a(this, 2001371);
        this.e = new b(this, CmdConfigHttp.WEBVIEW_CACHE_INFO, 309485);
    }

    public static String A(boolean z, String str) {
        InterceptResult invokeZL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65538, null, z, str)) == null) {
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

    public void B(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, str, str2) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.c == null) {
            this.c = new ConcurrentHashMap();
        }
        this.c.put(str, str2);
    }

    public void j(String str) {
        Map map;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && !TextUtils.isEmpty(str) && (map = this.c) != null) {
            map.remove(str);
        }
    }

    public String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (this.c != null && !TextUtils.isEmpty(str)) {
                return (String) this.c.get(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static jd8 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (f == null) {
                synchronized (jd8.class) {
                    if (f == null) {
                        f = new jd8();
                    }
                }
            }
            return f;
        }
        return (jd8) invokeV.objValue;
    }

    public JSONObject D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Map map = this.c;
            if (map != null && !map.isEmpty()) {
                return new JSONObject(this.c);
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Map map = this.c;
            if (map != null && !map.isEmpty()) {
                return new JSONObject(this.c).toString();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.c == null) {
                this.c = new ConcurrentHashMap();
            }
            this.c.clear();
        }
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public Set t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.c == null) {
                this.c = new ConcurrentHashMap();
            }
            return this.c.keySet();
        }
        return (Set) invokeV.objValue;
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            String E = E();
            if (!TextUtils.isEmpty(E)) {
                ux4.k().y("pref_key_quick_webview_versions", E);
            }
        }
    }

    public static void l(String str, String str2) {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65547, null, str, str2) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = g + "bdtbNWCache/" + str2;
        File file = new File(str3);
        if (file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0) {
            for (String str4 : list) {
                if (!StringUtils.isNull(str4) && !str4.equals(str)) {
                    FileHelper.deleteFileOrDir(new File(str3 + "/" + str4));
                }
            }
        }
    }

    public static void m(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65548, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(g + "bdtbWCacheTemp/" + str));
    }

    public static void o(String str, nd8 nd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, nd8Var) == null) {
            if (nd8Var != null && !StringUtils.isNull(nd8Var.c()) && !StringUtils.isNull(nd8Var.b()) && !StringUtils.isNull(nd8Var.a())) {
                String s = q().s(str);
                String c2 = nd8Var.c();
                String a2 = nd8Var.a();
                boolean d2 = nd8Var.d();
                if (StringUtils.isNull(s)) {
                    s = "0.0.0.0";
                }
                if (d2 && c2.equals(s)) {
                    kd8.a().h(true, str);
                    return;
                }
                jx4.a("OfflineCache", -1L, 0, "downloadCache", 0, "", "url", a2, "hybridVersion", c2, "lastVersion", s, "type", "start", "hybridName", str, "hybridResult", "success");
                new d(str, nd8Var, true ^ d2).execute(new Void[0]);
                return;
            }
            kd8.a().h(true, str);
        }
    }

    public static h r(String str, String str2) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, str2)) == null) {
            File file = new File(g + "bdtbNWCache");
            FileInputStream fileInputStream2 = null;
            if (!file.exists() || TextUtils.isEmpty(str2)) {
                return null;
            }
            h hVar = new h(null);
            File file2 = new File(file.getAbsolutePath() + "/" + str + "/" + str2 + "/");
            hVar.a = file.getAbsolutePath();
            hVar.c = str2;
            File file3 = new File(file2, "router.json");
            try {
                if (!file3.exists()) {
                    return null;
                }
                try {
                    fileInputStream = new FileInputStream(file3);
                } catch (FileNotFoundException e2) {
                    e = e2;
                }
                try {
                    hVar.b = y(fileInputStream);
                    gj.e(fileInputStream);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    e.printStackTrace();
                    gj.e(fileInputStream2);
                    return hVar;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    gj.e(fileInputStream2);
                    throw th;
                }
                return hVar;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (h) invokeLL.objValue;
        }
    }

    public static void w(JSONObject jSONObject, HashMap hashMap) {
        String str;
        String str2;
        String str3;
        boolean z;
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, jSONObject, hashMap) == null) {
            JSONObject jSONObject2 = jSONObject;
            String str4 = "source";
            String str5 = "path";
            if (jSONObject2 != null && hashMap != null) {
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!hashMap.containsKey(next)) {
                            JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                            ArrayList arrayList = new ArrayList();
                            if (jSONObject3.has("data_urls") && (optJSONArray2 = jSONObject3.optJSONArray("data_urls")) != null) {
                                for (int i = 0; i < optJSONArray2.length(); i++) {
                                    arrayList.add(optJSONArray2.optString(i));
                                }
                            }
                            if (!jSONObject3.has("module")) {
                                str = "";
                            } else {
                                str = jSONObject3.optString("module");
                            }
                            if (!jSONObject3.has(str5)) {
                                str2 = "";
                            } else {
                                str2 = jSONObject3.optString(str5);
                            }
                            ArrayList arrayList2 = new ArrayList();
                            if (jSONObject3.has(str4) && (optJSONArray = jSONObject3.optJSONArray(str4)) != null) {
                                str3 = str4;
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    arrayList2.add(optJSONArray.optString(i2));
                                }
                            } else {
                                str3 = str4;
                            }
                            String optString = jSONObject3.optString("staticPrePath", "");
                            int optInt = jSONObject3.optInt("proxyMode");
                            kd8.a().j(next, next);
                            kd8.a().k(next, str2);
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                String str6 = (String) it.next();
                                if (!TextUtils.isEmpty(str6)) {
                                    kd8 a2 = kd8.a();
                                    String str7 = str5;
                                    a2.j(optString + "/" + str6, next);
                                    kd8 a3 = kd8.a();
                                    a3.k(optString + "/" + str6, str6);
                                    str5 = str7;
                                }
                            }
                            String str8 = str5;
                            ld8 ld8Var = new ld8();
                            ld8Var.a = arrayList;
                            ld8Var.b = str;
                            ld8Var.c = str2;
                            ld8Var.d = arrayList2;
                            if (optInt == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            ld8Var.f = z;
                            hashMap.put(next, ld8Var);
                            jSONObject2 = jSONObject;
                            str4 = str3;
                            str5 = str8;
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x004d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x004f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0051 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:21:0x0053 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:0x0005 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.io.InputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r5v1, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v14, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v15, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v16, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v17, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v21, resolved type: java.io.BufferedReader */
    /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: java.io.BufferedReader */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    public static HashMap y(InputStream inputStream) {
        InterceptResult invokeL;
        InputStreamReader inputStreamReader;
        Throwable th;
        Object obj;
        HashMap hashMap;
        Object obj2;
        Object obj3;
        Reader reader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, inputStream)) == null) {
            InputStreamReader inputStreamReader2 = null;
            try {
                if (inputStream == 0) {
                    return null;
                }
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    inputStreamReader = new InputStreamReader(inputStream);
                    try {
                        inputStream = new BufferedReader(inputStreamReader);
                        try {
                            try {
                                for (String readLine = inputStream.readLine(); readLine != null; readLine = inputStream.readLine()) {
                                    stringBuffer.append(readLine);
                                }
                                inputStream.close();
                                hashMap = new HashMap();
                                try {
                                    JSONObject jSONObject = new JSONObject(stringBuffer.toString());
                                    w(jSONObject.optJSONObject("proxyConfig"), hashMap);
                                    w(jSONObject.optJSONObject("config"), hashMap);
                                    gj.g(inputStreamReader);
                                    reader = inputStream;
                                } catch (IOException e2) {
                                    e = e2;
                                    inputStreamReader2 = inputStreamReader;
                                    obj3 = inputStream;
                                    e.printStackTrace();
                                    inputStream = obj3;
                                    gj.g(inputStreamReader2);
                                    reader = inputStream;
                                    gj.g(reader);
                                    return hashMap;
                                } catch (JSONException e3) {
                                    e = e3;
                                    inputStreamReader2 = inputStreamReader;
                                    obj2 = inputStream;
                                    e.printStackTrace();
                                    inputStream = obj2;
                                    gj.g(inputStreamReader2);
                                    reader = inputStream;
                                    gj.g(reader);
                                    return hashMap;
                                } catch (Exception e4) {
                                    e = e4;
                                    inputStreamReader2 = inputStreamReader;
                                    obj = inputStream;
                                    e.printStackTrace();
                                    inputStream = obj;
                                    gj.g(inputStreamReader2);
                                    reader = inputStream;
                                    gj.g(reader);
                                    return hashMap;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                gj.g(inputStreamReader);
                                gj.g(inputStream);
                                throw th;
                            }
                        } catch (IOException e5) {
                            e = e5;
                            hashMap = null;
                        } catch (JSONException e6) {
                            e = e6;
                            hashMap = null;
                        } catch (Exception e7) {
                            e = e7;
                            hashMap = null;
                        }
                    } catch (IOException e8) {
                        e = e8;
                        inputStream = 0;
                        hashMap = null;
                    } catch (JSONException e9) {
                        e = e9;
                        inputStream = 0;
                        hashMap = null;
                    } catch (Exception e10) {
                        e = e10;
                        inputStream = 0;
                        hashMap = null;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = 0;
                    }
                } catch (IOException e11) {
                    e = e11;
                    obj3 = null;
                    hashMap = null;
                } catch (JSONException e12) {
                    e = e12;
                    obj2 = null;
                    hashMap = null;
                } catch (Exception e13) {
                    e = e13;
                    obj = null;
                    hashMap = null;
                } catch (Throwable th4) {
                    inputStreamReader = null;
                    th = th4;
                    inputStream = 0;
                }
                gj.g(reader);
                return hashMap;
            } catch (Throwable th5) {
                inputStreamReader = inputStreamReader2;
                th = th5;
            }
        } else {
            return (HashMap) invokeL.objValue;
        }
    }

    public final e C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            e eVar = new e();
            if (TextUtils.isEmpty(str)) {
                eVar.b = "module not exit";
                return eVar;
            }
            File file = new File(g + "bdtbNWCache", str);
            String s = q().s(str);
            if (TbSingleton.getInstance().isUploadOffPack()) {
                eVar.a = false;
                if (!file.exists()) {
                    eVar.b = "bundle not exist";
                    return eVar;
                } else if (TextUtils.isEmpty(s)) {
                    eVar.b = "the local has no valid version name";
                    return eVar;
                } else {
                    String str2 = file.getAbsolutePath() + "/" + s + "/";
                    if (!new File(str2).exists()) {
                        eVar.b = "bundle not exist";
                        return eVar;
                    }
                    String str3 = file.getAbsolutePath() + "/" + s + ".zip";
                    File file2 = new File(str3);
                    if (file2.exists()) {
                        FileHelper.deleteFileOrDir(file2);
                    }
                    if (zw4.e(str2, str3)) {
                        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.URL_UPLOAD_OFFLINE_PACK);
                        netWork.addPostData("offline_pack_version", s);
                        netWork.addPostData("mod_name", str);
                        netWork.getNetContext().getRequest().mNeedBackgroundLogin = false;
                        netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                        v(netWork.uploadFile("offline_pack_file_stream", str3), eVar);
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
                k(str);
                if (!TextUtils.isEmpty(s)) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", str).param("obj_id", s));
                }
                if (file.exists() && !StringUtils.isNull(s)) {
                    if (!new File(file.getAbsolutePath(), s).exists()) {
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

    public void i() {
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            n();
            ux4.k().y("pref_key_quick_webview_versions", "");
            String str = g + "bdtbNWCache";
            File file = new File(str);
            if (file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0) {
                for (String str2 : list) {
                    if (!StringUtils.isNull(str2)) {
                        FileHelper.deleteFileOrDir(new File(str + "/" + str2));
                    }
                }
            }
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        j(str);
        ux4.k().y("pref_key_quick_webview_versions", E());
        File file = new File(g + "bdtbNWCache/" + str);
        if (file.exists() && file.isDirectory()) {
            FileHelper.deleteFileOrDir(file);
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            if (keys == null) {
                return;
            }
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

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            MessageManager.getInstance().registerListener(this.e);
            MessageManager.getInstance().registerListener(this.d);
            this.b = new File(g + "bdtbNWCache").getAbsolutePath();
            x(ux4.k().q("pref_key_quick_webview_versions", ""));
        }
    }

    public final e v(String str, e eVar) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, eVar)) == null) {
            if (StringUtils.isNull(str)) {
                eVar.b = "serve return is null";
                return eVar;
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
            return eVar;
        }
        return (e) invokeLL.objValue;
    }
}
