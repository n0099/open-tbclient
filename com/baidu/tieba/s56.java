package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.async.BdRunnable;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.util.WebviewHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class s56 {
    public static /* synthetic */ Interceptable $ic;
    public static final String b;
    public static final String c;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* loaded from: classes8.dex */
    public interface b {
        void a(JSONObject jSONObject);
    }

    /* loaded from: classes8.dex */
    public class a extends BdRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map c;
        public final /* synthetic */ String d;
        public final /* synthetic */ s56 e;

        /* renamed from: com.baidu.tieba.s56$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0475a extends BdRunnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject c;
            public final /* synthetic */ a d;

            public C0475a(a aVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = aVar;
                this.c = jSONObject;
            }

            @Override // com.baidu.browser.core.async.BdRunnable
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.d.e.a.a(this.c);
                }
            }
        }

        public a(s56 s56Var, Map map, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s56Var, map, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = s56Var;
            this.c = map;
            this.d = str;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.baidu.tieba.s56.a(com.baidu.tieba.s56, java.util.Map):java.util.Map
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
            	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
            	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // com.baidu.browser.core.async.BdRunnable
        public void c() {
            /*
                r4 = this;
                com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tieba.s56.a.$ic
                if (r0 != 0) goto L74
            L4:
                java.lang.String r0 = "application/json; charset=utf-8"
                okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)
                org.json.JSONObject r1 = new org.json.JSONObject
                r1.<init>()
                com.baidu.tieba.s56 r2 = r4.e     // Catch: org.json.JSONException -> L1e
                java.util.Map r3 = r4.c     // Catch: org.json.JSONException -> L1e
                com.baidu.tieba.s56.a(r2, r3)     // Catch: org.json.JSONException -> L1e
                com.baidu.tieba.s56 r2 = r4.e     // Catch: org.json.JSONException -> L1e
                java.util.Map r3 = r4.c     // Catch: org.json.JSONException -> L1e
                com.baidu.tieba.s56.b(r2, r3, r1)     // Catch: org.json.JSONException -> L1e
                goto L22
            L1e:
                r2 = move-exception
                r2.printStackTrace()
            L22:
                okhttp3.OkHttpClient r2 = new okhttp3.OkHttpClient
                r2.<init>()
                java.lang.String r1 = java.lang.String.valueOf(r1)
                okhttp3.RequestBody r0 = okhttp3.RequestBody.create(r0, r1)
                okhttp3.Request$Builder r1 = new okhttp3.Request$Builder
                r1.<init>()
                java.lang.String r3 = r4.d
                okhttp3.Request$Builder r1 = r1.url(r3)
                okhttp3.Request$Builder r0 = r1.post(r0)
                okhttp3.Request r0 = r0.build()
                r1 = 0
                okhttp3.Call r0 = r2.newCall(r0)     // Catch: java.io.IOException -> L4c
                okhttp3.Response r1 = r0.execute()     // Catch: java.io.IOException -> L4c
                goto L50
            L4c:
                r0 = move-exception
                r0.printStackTrace()
            L50:
                okhttp3.ResponseBody r0 = r1.body()     // Catch: org.json.JSONException -> L6a java.io.IOException -> L6f
                java.lang.String r0 = r0.string()     // Catch: org.json.JSONException -> L6a java.io.IOException -> L6f
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L6a java.io.IOException -> L6f
                r1.<init>(r0)     // Catch: org.json.JSONException -> L6a java.io.IOException -> L6f
                com.baidu.tieba.fw r0 = com.baidu.tieba.fw.f()     // Catch: org.json.JSONException -> L6a java.io.IOException -> L6f
                com.baidu.tieba.s56$a$a r2 = new com.baidu.tieba.s56$a$a     // Catch: org.json.JSONException -> L6a java.io.IOException -> L6f
                r2.<init>(r4, r1)     // Catch: org.json.JSONException -> L6a java.io.IOException -> L6f
                r0.h(r2)     // Catch: org.json.JSONException -> L6a java.io.IOException -> L6f
                goto L73
            L6a:
                r0 = move-exception
                r0.printStackTrace()
                goto L73
            L6f:
                r0 = move-exception
                r0.printStackTrace()
            L73:
                return
            L74:
                r2 = r0
                r3 = 1048576(0x100000, float:1.469368E-39)
                com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeV(r3, r4)
                if (r0 == 0) goto L4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.s56.a.c():void");
        }
    }

    static {
        InterceptResult invokeClinit;
        String str;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948102453, "Lcom/baidu/tieba/s56;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948102453, "Lcom/baidu/tieba/s56;");
                return;
            }
        }
        if (GlobalBuildConfig.isDebug()) {
            str = "http://";
        } else {
            str = "https://";
        }
        b = str;
        c = b + "afdconf.baidu.com/afd/download";
    }

    public s56(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = bVar;
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static /* synthetic */ java.util.Map a(com.baidu.tieba.s56 r0, java.util.Map r1) {
        /*
            r0.d(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.s56.a(com.baidu.tieba.s56, java.util.Map):java.util.Map");
    }

    public void g(Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, map, str) == null) {
            fw.f().g(new a(this, map, str));
        }
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    public static /* synthetic */ org.json.JSONObject b(com.baidu.tieba.s56 r0, java.util.Map r1, org.json.JSONObject r2) throws org.json.JSONException {
        /*
            r0.f(r1, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tieba.s56.b(com.baidu.tieba.s56, java.util.Map, org.json.JSONObject):org.json.JSONObject");
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (BdNetTypeUtil.isWifiNet()) {
                return UtilHelper.getWifiMac(TbadkCoreApplication.getInst().getApp());
            }
            return UtilHelper.getGprsIpAddress();
        }
        return (String) invokeV.objValue;
    }

    public final Map<String, String> d(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            map.put("_client_version", TbConfig.getVersion());
            map.put("uid", TbadkCoreApplication.getCurrentAccount());
            map.put("cuid", TbadkCoreApplication.getInst().getCuidGalaxy2());
            map.put("ua", WebviewHelper.getGlobalUserAgent());
            String e = kk0.c().e(false);
            if (!TextUtils.isEmpty(e)) {
                map.put("model", e);
            }
            String h = kk0.c().h(false);
            if (!TextUtils.isEmpty(h)) {
                map.put(HttpRequest.OS_VERSION, h);
            }
            String b2 = kk0.c().b(false);
            if (!TextUtils.isEmpty(b2)) {
                map.put("imei", b2);
            }
            String a2 = kk0.c().a(false);
            if (!TextUtils.isEmpty(a2)) {
                map.put(HttpRequest.ANDROID_ID, a2);
            }
            map.put(HttpRequest.CLIENT_TYPE, "2");
            map.put("nt", String.valueOf(BdNetTypeUtil.netType()));
            map.put("ip", e());
            map.put("ssl", "1");
            return map;
        }
        return (Map) invokeL.objValue;
    }

    public final JSONObject f(Map<String, String> map, JSONObject jSONObject) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, jSONObject)) == null) {
            if (g29.f(map)) {
                return jSONObject;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.putOpt(entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
