package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l13 extends wd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k13 c;
    public o13 d;
    public n13 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l13(wc3 wc3Var) {
        super(wc3Var, "/swanAPI/vrvideo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wc3Var};
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

    @Override // com.baidu.tieba.wd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, zb3Var)) == null) {
            z82.b("VrVideoPlayerAction", "handle entity: ", unitedSchemeEntity);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wd3
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, zb3 zb3Var) {
        InterceptResult invokeLLLLL;
        char c;
        boolean c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, zb3Var)) == null) {
            z82.b("VrVideoPlayerAction", "handleSubAction subAction : " + str + "params : ", wd3.a(unitedSchemeEntity, "params"));
            int hashCode = str.hashCode();
            if (hashCode != 533456719) {
                if (hashCode != 1626770505) {
                    if (hashCode == 1722535054 && str.equals("/swanAPI/vrvideo/update")) {
                        c = 1;
                    }
                    c = 65535;
                } else {
                    if (str.equals("/swanAPI/vrvideo/remove")) {
                        c = 2;
                    }
                    c = 65535;
                }
            } else {
                if (str.equals("/swanAPI/vrvideo/open")) {
                    c = 0;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        c2 = false;
                    } else {
                        if (this.e == null) {
                            this.e = new n13("/swanAPI/vrvideo/remove");
                        }
                        c2 = this.e.c(context, unitedSchemeEntity, callbackHandler, zb3Var);
                    }
                } else {
                    if (this.d == null) {
                        this.d = new o13("/swanAPI/vrvideo/update");
                    }
                    c2 = this.d.c(context, unitedSchemeEntity, callbackHandler, zb3Var);
                }
            } else {
                if (this.c == null) {
                    this.c = new k13("/swanAPI/vrvideo/open");
                }
                c2 = this.c.c(context, unitedSchemeEntity, callbackHandler, zb3Var);
            }
            if (!c2 && !super.i(context, unitedSchemeEntity, callbackHandler, str, zb3Var)) {
                return false;
            }
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
