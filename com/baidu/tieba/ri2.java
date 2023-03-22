package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.pq2;
import com.baidu.tieba.yc3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ri2 extends q93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements mm3<wc3<yc3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ri2 e;

        public a(ri2 ri2Var, CallbackHandler callbackHandler, String str, Context context, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ri2Var, callbackHandler, str, context, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ri2Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = context;
            this.d = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(wc3<yc3.e> wc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wc3Var) == null) {
                if (rc3.h(wc3Var)) {
                    this.e.l(this.c, this.d, this.b, this.a);
                } else {
                    rc3.q(wc3Var, this.a, this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements pq2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;

        @Override // com.baidu.tieba.pq2.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public b(ri2 ri2Var, Context context, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ri2Var, context, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = callbackHandler;
            this.c = str;
        }

        @Override // com.baidu.tieba.pq2.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                l73.f(this.a, R.string.obfuscated_res_0x7f0f0153).G();
                this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        }

        @Override // com.baidu.tieba.pq2.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                File d = ah3.d();
                File c = ah3.c();
                if (q93.b) {
                    Log.d("replaceSwanCore", "swanCoreZipFile: " + d + " swanCoreDir: " + c);
                }
                if (d.exists() && xn4.U(d.getPath(), c.getPath())) {
                    s33.M(true);
                    l73.f(this.a, R.string.obfuscated_res_0x7f0f0154).G();
                    this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    return;
                }
                l73.f(this.a, R.string.obfuscated_res_0x7f0f0153).G();
                this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ri2(q83 q83Var) {
        super(q83Var, "/swanAPI/debug/replaceSwanCore");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q83Var};
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

    @Override // com.baidu.tieba.q93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, t73Var)) == null) {
            JSONObject a2 = q93.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                l73.f(context, R.string.obfuscated_res_0x7f0f014b).G();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "params is null");
                return false;
            }
            String optString = a2.optString("url");
            String optString2 = a2.optString("cb");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                t73Var.e0().g(context, "mapp_cts_debug", new a(this, callbackHandler, optString2, context, optString));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            l73.f(context, R.string.obfuscated_res_0x7f0f0120).G();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swan core url or cb is null");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, callbackHandler) == null) {
            pq2.J(str, new b(this, context, callbackHandler, str2));
        }
    }
}
