package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tieba.ew2;
import com.baidu.tieba.fw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class z82 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b92 c;
    public ExecutorService d;
    public int e;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ File b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ z82 e;

        public a(z82 z82Var, Context context, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z82Var, context, file, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = z82Var;
            this.a = context;
            this.b = file;
            this.c = unitedSchemeEntity;
            this.d = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z82 z82Var = this.e;
                z82Var.q(this.a, z82Var.c.b, this.e.c.c, this.b, this.c, this.d);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ File d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ CallbackHandler f;
        public final /* synthetic */ z82 g;

        public b(z82 z82Var, Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z82Var, context, str, str2, file, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = z82Var;
            this.a = context;
            this.b = str;
            this.c = str2;
            this.d = file;
            this.e = unitedSchemeEntity;
            this.f = callbackHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.g.q(this.a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z82(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/wirelessdebuglaunch");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                if (ed3.b) {
                    Log.e("WirelessDebugAction", "url encode fail", e);
                    return str;
                }
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                b92 e = b92.e(optParamsAsJo);
                this.c = e;
                if (e != null && !e.d()) {
                    l(context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
                if (ed3.b) {
                    Log.e("WirelessDebugAction", "Wireless Debug params is invalid");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            h82.c("WirelessDebugAction", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler) == null) {
            File b2 = a92.b();
            if (b2.exists()) {
                b2.delete();
            }
            this.d = Executors.newFixedThreadPool(4);
            this.e = 0;
            JSONArray jSONArray = this.c.g;
            if (jSONArray != null && jSONArray.length() > 0) {
                int length = this.c.g.length();
                for (int i = 0; i < length; i++) {
                    String a2 = this.c.a(i);
                    if (TextUtils.isEmpty(a2)) {
                        int i2 = this.e + 1;
                        this.e = i2;
                        if (i2 >= length) {
                            h82.c("WirelessDebugAction", "Hosts are invalid");
                            p(context, "404");
                        }
                    } else {
                        this.d.execute(new b(this, context, a2, this.c.c(i), b2, unitedSchemeEntity, callbackHandler));
                    }
                }
                return;
            }
            ExecutorUtilsExt.postOnSerial(new a(this, context, b2, unitedSchemeEntity, callbackHandler), "WirelessDebugAction");
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ew2.a W = gb3.K().q().W();
            ki3 ki3Var = new ki3();
            ki3Var.j(W);
            ki3Var.a = ai3.n(W.G());
            ki3Var.b = "launch";
            ki3Var.c = "adb-debug";
            ki3Var.e = DownloadStatisticConstants.UBC_VALUE_DOWNLOAD_FAIL;
            ai3.onEvent(ki3Var);
        }
    }

    public final fw2.a o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (fw2.a) ((fw2.a) ((fw2.a) new fw2.a().v0(this.c.a)).A0(false)).P0(this.c.d);
        }
        return (fw2.a) invokeV.objValue;
    }

    public final void p(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) {
            String string = vj3.a().getString("errorURL", "");
            if (TextUtils.isEmpty(string)) {
                za3.g(context, "IPs are invalid ：" + str).G();
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(SchemeConfig.getSchemeHead());
            sb.append("://v1/easybrowse/open?url=");
            sb.append(m(string + "?" + str));
            SchemeRouter.invoke(context, sb.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b9, code lost:
        if (r6 >= r4.c.g.length()) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(Context context, String str, String str2, File file, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, str, str2, file, unitedSchemeEntity, callbackHandler}) == null) {
            try {
                Response executeSync = li4.g().getRequest().url(str).connectionTimeout(1500).build().executeSync();
                if (executeSync != null && executeSync.code() == 200 && executeSync.body() != null) {
                    or4.a(executeSync.body().byteStream(), file);
                    Intent g1 = fw2.g1(context, o());
                    g1.putExtra(PrefetchEvent.EVENT_DATA_DEBUG_PRELOAD, this.c.e);
                    g1.putExtra("slavePreload", this.c.f);
                    g1.putExtra("extraWSUrl", str2);
                    context.startActivity(g1);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    if (this.d != null) {
                        this.d.shutdownNow();
                        this.d = null;
                    }
                    if (!ProcessUtils.isMainProcess()) {
                        if (ed3.b) {
                            Log.d("WirelessDebugAction", "Suicide for reload.");
                        }
                        c92.d();
                    }
                }
                if (executeSync != null) {
                    executeSync.close();
                }
            } catch (IOException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                synchronized (this) {
                    if (this.c.g != null) {
                        int i = this.e + 1;
                        this.e = i;
                    }
                    h82.c("WirelessDebugAction", "Host IPs are invalid");
                    p(context, "404");
                    n();
                }
            }
        }
    }
}
