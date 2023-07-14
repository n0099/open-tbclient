package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.tieba.ah3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qf3 extends uf3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements oq3<yg3<ah3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ tf3 b;
        public final /* synthetic */ by1 c;
        public final /* synthetic */ qf3 d;

        public a(qf3 qf3Var, CallbackHandler callbackHandler, tf3 tf3Var, by1 by1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qf3Var, callbackHandler, tf3Var, by1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = qf3Var;
            this.a = callbackHandler;
            this.b = tf3Var;
            this.c = by1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(yg3<ah3.e> yg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                if (!tg3.h(yg3Var)) {
                    tg3.q(yg3Var, this.a, this.b.e);
                    this.b.k = null;
                } else {
                    tf3 tf3Var = this.b;
                    tf3Var.m = false;
                    this.d.m(this.a, (SwanAppSlaveManager) this.c, tf3Var);
                }
                if (this.c.x(this.b)) {
                    this.d.o();
                    return;
                }
                v82.c("insertWebView", "insert webview widget fail");
                this.a.handleSchemeDispatchCallback(this.b.e, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qf3(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/insertWebView");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sc3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((sc3) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            if (sd3.b) {
                Log.d("InsertWebViewAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            tf3 h = tf3.h(unitedSchemeEntity);
            if (!h.isValid()) {
                v82.c("insertWebView", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (!TextUtils.isEmpty(h.j) && l(h.j, h.n)) {
                v82.c("insertWebView", "params is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else {
                by1 by1Var = (by1) ix2.T().A(h.c);
                if (by1Var == null) {
                    v82.c("insertWebView", "viewManager is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                if (TextUtils.equals(h.l, "quickPass")) {
                    vb3Var.e0().g(context, "scope_webview_extra_operation", new a(this, callbackHandler, h, by1Var));
                } else if (!by1Var.x(h)) {
                    v82.c("insertWebView", "insert webview widget fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else {
                    o();
                }
                v82.i("insertWebView", "insert webview widget success");
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o() {
        eb2 U;
        db2 o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (U = ix2.T().U()) != null && (o = U.o()) != null) {
            v82.i("insertWebView", "disable navigationStyle custom");
            o.m3();
        }
    }
}
