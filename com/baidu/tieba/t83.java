package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class t83 extends r93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.r93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u73 u73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u73Var)) == null) {
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @NonNull
    public abstract String j();

    public abstract boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, u73 u73Var);

    public abstract boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, u73 u73Var);

    public abstract boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, u73 u73Var);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t83(r83 r83Var, String str) {
        super(r83Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r83Var, str};
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

    @Override // com.baidu.tieba.r93
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, u73 u73Var) {
        InterceptResult invokeLLLLL;
        boolean n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, u73Var)) == null) {
            String l = l("insert");
            String l2 = l(StickerDataChangeType.UPDATE);
            String l3 = l("remove");
            if (TextUtils.equals(l, str)) {
                n = m(context, unitedSchemeEntity, callbackHandler, str, u73Var);
            } else if (TextUtils.equals(l2, str)) {
                n = p(context, unitedSchemeEntity, callbackHandler, str, u73Var);
            } else if (TextUtils.equals(l3, str)) {
                n = o(context, unitedSchemeEntity, callbackHandler, str, u73Var);
            } else {
                n = n(context, unitedSchemeEntity, callbackHandler, str, u73Var);
            }
            u42.b("AbsSwanAppWidget", "subAction = " + str + " ; handle result = " + n);
            return n;
        }
        return invokeLLLLL.booleanValue;
    }

    public JSONObject k(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                u42.c("AbsSwanAppWidget", "getParamsJSONObject entity is null");
                return null;
            }
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                u42.c("AbsSwanAppWidget", "getParamsJSONObject paramsJson is empty");
                return null;
            }
            try {
                return new JSONObject(param);
            } catch (JSONException e) {
                u42.c("AbsSwanAppWidget", "getParamsJSONObject exception = " + e.getMessage());
                if (!r93.b) {
                    return null;
                }
                e.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public final String l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return j() + "/" + str;
        }
        return (String) invokeL.objValue;
    }

    public boolean n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, u73 u73Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048582, this, context, unitedSchemeEntity, callbackHandler, str, u73Var)) == null) {
            return super.i(context, unitedSchemeEntity, callbackHandler, str, u73Var);
        }
        return invokeLLLLL.booleanValue;
    }
}
