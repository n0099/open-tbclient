package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.cd3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class pq3 extends u93 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> d;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;

    /* loaded from: classes5.dex */
    public class a implements qm3<ad3<cd3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ pq3 h;

        public a(pq3 pq3Var, CallbackHandler callbackHandler, Context context, String str, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pq3Var, callbackHandler, context, str, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = pq3Var;
            this.a = callbackHandler;
            this.b = context;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(ad3<cd3.e> ad3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ad3Var) == null) {
                if (!vc3.h(ad3Var)) {
                    vc3.q(ad3Var, this.a, this.h.c);
                    return;
                }
                qj3 a = er2.F().a(this.b, this.c, this.d, this.e, this.f, this.g);
                if (a != null) {
                    if (a.h() != 0) {
                        x42.c("PageTransitionAction", a.g().toString());
                        CallbackHandler callbackHandler = this.a;
                        String str = this.h.c;
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, a.a() + ":" + a.g().toString()).toString());
                        return;
                    }
                    x42.c("PageTransitionAction", "page transition fail");
                    this.a.handleSchemeDispatchCallback(this.h.c, UnitedSchemeUtility.wrapCallbackParams(1001, "execute fail").toString());
                    return;
                }
                x42.i("PageTransitionAction", "page transition success");
                this.a.handleSchemeDispatchCallback(this.h.c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948070647, "Lcom/baidu/tieba/pq3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948070647, "Lcom/baidu/tieba/pq3;");
                return;
            }
        }
        HashSet hashSet = new HashSet();
        d = hashSet;
        hashSet.add("easybrowse");
        d.add("live");
        d.add("appTab");
        d.add("browser");
        d.add(AccountConstants.LOGIN_TYPE_NATIVE_SRC_COMIC);
        d.add(AccountConstants.LOGIN_TYPE_NATIVE_SRC_NOVEL);
        d.add("imChatHN");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pq3(u83 u83Var) {
        super(u83Var, "/swanAPI/pageTransition");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u83Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.u93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, x73Var)) == null) {
            if (x73Var == null) {
                x42.c("PageTransitionAction", "runtime exception");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "null swanApp");
                return false;
            } else if (x73Var.n0()) {
                if (u93.b) {
                    Log.d("PageTransitionAction", "PageTransitionAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                String param = unitedSchemeEntity.getParam("params");
                if (TextUtils.isEmpty(param)) {
                    x42.c("PageTransitionAction", "params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
                    return false;
                }
                JSONObject d2 = xk3.d(param);
                String optString = d2.optString("cb");
                this.c = optString;
                if (TextUtils.isEmpty(optString)) {
                    x42.c("PageTransitionAction", "callback is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString2 = d2.optString("authority");
                String optString3 = d2.optString("path");
                String optString4 = d2.optString("module");
                String optString5 = d2.optString("action");
                String optString6 = d2.optString("scheme");
                k(x73Var, optString4);
                if (er2.E().a(d2)) {
                    x73Var.e0().g(context, "mapp_i_baiduapp_page_trans", new a(this, callbackHandler, context, optString2, optString3, optString4, optString5, optString6));
                } else {
                    qj3 a2 = er2.F().a(context, optString2, optString3, optString4, optString5, optString6);
                    if (a2 != null) {
                        if (a2.h() != 0) {
                            x42.c("PageTransitionAction", a2.g().toString());
                            String str = this.c;
                            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, a2.a() + ":" + a2.g().toString()).toString());
                        } else {
                            x42.c("PageTransitionAction", "page transition fail");
                            callbackHandler.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(1001, "execute fail").toString());
                        }
                    } else {
                        x42.i("PageTransitionAction", "page transition success");
                        callbackHandler.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    }
                }
                x42.i("PageTransitionAction", "callback success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(@NonNull x73 x73Var, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x73Var, str) == null) {
            ze3 ze3Var = new ze3();
            ze3Var.c = x73Var.W().T();
            ze3Var.a = "swan";
            if (rl3.G()) {
                if (d.contains(str)) {
                    ze3Var.b = str.toLowerCase();
                } else {
                    ze3Var.b = ImageViewerConfig.FROM_OTHER;
                }
            } else {
                ze3Var.b = ImageViewerConfig.FROM_OTHER;
            }
            ze3Var.a(BaseHiidoContent.HOSTID, er2.n().a());
            ze3Var.a("appid", x73Var.getAppId());
            qe3.x("1895", ze3Var);
        }
    }
}
