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
public class j72 extends gc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gc3
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/coverview" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j72(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/coverview");
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
                super((ec3) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public final p72 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            JSONObject k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                h82.c("Component-Action-CoverView", "params is null");
                return null;
            }
            p72 p72Var = new p72();
            try {
                p72Var.a(k);
            } catch (JSONException e) {
                e.printStackTrace();
                h82.d("Component-Action-CoverView", "model parse exception:", e);
            }
            return p72Var;
        }
        return (p72) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gc3
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, hb3 hb3Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, hb3Var)) == null) {
            if (ed3.b) {
                Log.d("Component-Action-CoverView", "insert");
            }
            p72 q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                h82.c("Component-Action-CoverView", "model is null");
                return false;
            }
            y62 insert = new o72(context, q).insert();
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

    @Override // com.baidu.tieba.gc3
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, hb3 hb3Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, hb3Var)) == null) {
            if (ed3.b) {
                Log.d("Component-Action-CoverView", "remove");
            }
            p72 q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                h82.c("Component-Action-CoverView", "model is null");
                return false;
            }
            o72 o72Var = (o72) u72.a(q);
            if (o72Var == null) {
                String str2 = "can't find coverView component:#" + q.b;
                h82.c("Component-Action-CoverView", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            y62 B = o72Var.B();
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

    @Override // com.baidu.tieba.gc3
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, hb3 hb3Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, hb3Var)) == null) {
            if (ed3.b) {
                Log.d("Component-Action-CoverView", StickerDataChangeType.UPDATE);
            }
            p72 q = q(unitedSchemeEntity);
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                h82.c("Component-Action-CoverView", "model is null");
                return false;
            }
            o72 o72Var = (o72) u72.a(q);
            if (o72Var == null) {
                String str2 = "can't find coverView component:#" + q.b;
                h82.c("Component-Action-CoverView", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            y62 update = o72Var.update((o72) q);
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
