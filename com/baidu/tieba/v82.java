package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class v82 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v82(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/remoteDebug");
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

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            h82.i("RemoteDebugAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ed3
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, hb3 hb3Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, hb3Var)) == null) {
            h82.i("RemoteDebugAction", "handleSubAction subAction: " + str);
            if (!y82.d()) {
                h82.c("RemoteDebugAction", "Can't invoke this action outside Remote Debug mode");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            SwanAppActivity w = gb3.K().w();
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -279631955) {
                if (hashCode == 1013845168 && str.equals("/swanAPI/remoteDebug/reload")) {
                    c = 0;
                }
            } else if (str.equals("/swanAPI/remoteDebug/shutdown")) {
                c = 1;
            }
            if (c != 0) {
                if (c != 1) {
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, hb3Var);
                }
                if (w != null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        w.finishAndRemoveTask();
                    } else {
                        w.finish();
                    }
                    System.exit(0);
                }
                return true;
            }
            h82.i("RemoteDebugAction", "Remote Debug reload");
            if (w != null) {
                Intent intent = w.getIntent();
                y82.f();
                gb3.K().n(new String[0]);
                gb3.K().l(intent.getExtras(), "update_tag_by_remote_debug");
            }
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
