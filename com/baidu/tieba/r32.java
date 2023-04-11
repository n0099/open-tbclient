package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class r32 extends t83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.t83
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/button" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r32(r83 r83Var) {
        super(r83Var, "/swanAPI/button");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r83Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((r83) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public final s32 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            JSONObject k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                u42.c("Component-Action-Button", "params is null");
                return null;
            }
            s32 s32Var = new s32();
            try {
                s32Var.a(k);
            } catch (JSONException e) {
                e.printStackTrace();
                u42.d("Component-Action-Button", "model parse exception:", e);
            }
            return s32Var;
        }
        return (s32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.t83
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, u73 u73Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, u73Var)) == null) {
            if (r93.b) {
                Log.d("Component-Action-Button", "insert");
            }
            s32 q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                u42.c("Component-Action-Button", "model is null");
                return false;
            }
            l32 insert = new q32(context, q).insert();
            boolean a = insert.a();
            if (a) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, insert.b);
            }
            return a;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.t83
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, u73 u73Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, u73Var)) == null) {
            if (r93.b) {
                Log.d("Component-Action-Button", "remove");
            }
            s32 q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                u42.c("Component-Action-Button", "model is null");
                return false;
            }
            q32 q32Var = (q32) h42.a(q);
            if (q32Var == null) {
                String str2 = "can't find button component:#" + q.b;
                u42.c("Component-Action-Button", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            l32 B = q32Var.B();
            boolean a = B.a();
            if (a) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, B.b);
            }
            return a;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.t83
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, u73 u73Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, u73Var)) == null) {
            if (r93.b) {
                Log.d("Component-Action-Button", StickerDataChangeType.UPDATE);
            }
            s32 q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                u42.c("Component-Action-Button", "model is null");
                return false;
            }
            q32 q32Var = (q32) h42.a(q);
            if (q32Var == null) {
                String str2 = "can't find button component:#" + q.b;
                u42.c("Component-Action-Button", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            l32 update = q32Var.update((q32) q);
            boolean a = update.a();
            if (a) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, update.b);
            }
            return a;
        }
        return invokeLLLLL.booleanValue;
    }
}
