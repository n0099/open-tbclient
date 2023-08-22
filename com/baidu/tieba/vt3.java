package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.ig3;
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
/* loaded from: classes8.dex */
public class vt3 extends ad3 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> d;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;

    /* loaded from: classes8.dex */
    public class a implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ vt3 h;

        public a(vt3 vt3Var, CallbackHandler callbackHandler, Context context, String str, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vt3Var, callbackHandler, context, str, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = vt3Var;
            this.a = callbackHandler;
            this.b = context;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (!bg3.h(gg3Var)) {
                    bg3.q(gg3Var, this.a, this.h.c);
                    return;
                }
                wm3 a = ku2.F().a(this.b, this.c, this.d, this.e, this.f, this.g);
                if (a != null) {
                    if (a.h() != 0) {
                        d82.c("PageTransitionAction", a.g().toString());
                        CallbackHandler callbackHandler = this.a;
                        String str = this.h.c;
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, a.a() + ":" + a.g().toString()).toString());
                        return;
                    }
                    d82.c("PageTransitionAction", "page transition fail");
                    this.a.handleSchemeDispatchCallback(this.h.c, UnitedSchemeUtility.wrapCallbackParams(1001, "execute fail").toString());
                    return;
                }
                d82.i("PageTransitionAction", "page transition success");
                this.a.handleSchemeDispatchCallback(this.h.c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948252276, "Lcom/baidu/tieba/vt3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948252276, "Lcom/baidu/tieba/vt3;");
                return;
            }
        }
        HashSet hashSet = new HashSet();
        d = hashSet;
        hashSet.add("easybrowse");
        d.add("live");
        d.add("appTab");
        d.add("browser");
        d.add("comic");
        d.add("novel");
        d.add("imChatHN");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vt3(ac3 ac3Var) {
        super(ac3Var, "/swanAPI/pageTransition");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ac3Var};
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

    @Override // com.baidu.tieba.ad3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, db3Var)) == null) {
            if (db3Var == null) {
                d82.c("PageTransitionAction", "runtime exception");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "null swanApp");
                return false;
            } else if (db3Var.n0()) {
                if (ad3.b) {
                    Log.d("PageTransitionAction", "PageTransitionAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                String param = unitedSchemeEntity.getParam("params");
                if (TextUtils.isEmpty(param)) {
                    d82.c("PageTransitionAction", "params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
                    return false;
                }
                JSONObject d2 = do3.d(param);
                String optString = d2.optString("cb");
                this.c = optString;
                if (TextUtils.isEmpty(optString)) {
                    d82.c("PageTransitionAction", "callback is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString2 = d2.optString("authority");
                String optString3 = d2.optString("path");
                String optString4 = d2.optString("module");
                String optString5 = d2.optString("action");
                String optString6 = d2.optString("scheme");
                k(db3Var, optString4);
                if (ku2.E().a(d2)) {
                    db3Var.e0().g(context, "mapp_i_baiduapp_page_trans", new a(this, callbackHandler, context, optString2, optString3, optString4, optString5, optString6));
                } else {
                    wm3 a2 = ku2.F().a(context, optString2, optString3, optString4, optString5, optString6);
                    if (a2 != null) {
                        if (a2.h() != 0) {
                            d82.c("PageTransitionAction", a2.g().toString());
                            String str = this.c;
                            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, a2.a() + ":" + a2.g().toString()).toString());
                        } else {
                            d82.c("PageTransitionAction", "page transition fail");
                            callbackHandler.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(1001, "execute fail").toString());
                        }
                    } else {
                        d82.i("PageTransitionAction", "page transition success");
                        callbackHandler.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    }
                }
                d82.i("PageTransitionAction", "callback success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(@NonNull db3 db3Var, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, db3Var, str) == null) {
            fi3 fi3Var = new fi3();
            fi3Var.c = db3Var.W().T();
            fi3Var.a = "swan";
            if (xo3.G()) {
                if (d.contains(str)) {
                    fi3Var.b = str.toLowerCase();
                } else {
                    fi3Var.b = "other";
                }
            } else {
                fi3Var.b = "other";
            }
            fi3Var.a(BaseHiidoContent.HOSTID, ku2.n().a());
            fi3Var.a("appid", db3Var.getAppId());
            wh3.x("1895", fi3Var);
        }
    }
}
