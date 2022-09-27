package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class oz1 extends k43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements pz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz1 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ oz1 c;

        public a(oz1 oz1Var, qz1 qz1Var, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oz1Var, qz1Var, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oz1Var;
            this.a = qz1Var;
            this.b = callbackHandler;
        }

        @Override // com.baidu.tieba.pz1
        public void a(int i, View view2, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, view2, obj) == null) {
                rz1 rz1Var = (rz1) this.a.n();
                if (i == 0 || i == 1) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "loadState");
                        jSONObject.put("parentId", rz1Var.d);
                        jSONObject.put("viewId", rz1Var.b);
                        jSONObject.put("loadState", i == 1 ? "finish" : "error");
                    } catch (JSONException e) {
                        l02.d("Component-Action-ImageCover", "loadState callback error", e);
                    }
                    this.c.s(this.b, jSONObject, rz1Var.e);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oz1(i43 i43Var) {
        super(i43Var, "/swanAPI/coverimage");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i43Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i43) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.k43
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/coverimage" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k43
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, l33 l33Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, l33Var)) == null) {
            if (i53.b) {
                Log.d("Component-Action-ImageCover", "insert");
            }
            rz1 r = r(unitedSchemeEntity);
            if (r == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                l02.c("Component-Action-ImageCover", "model is null");
                return false;
            }
            qz1 qz1Var = new qz1(context, r);
            qz1Var.e0(new a(this, qz1Var, callbackHandler));
            cz1 insert = qz1Var.insert();
            boolean a2 = insert.a();
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, insert.b);
            }
            return a2;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.k43
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, l33 l33Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, l33Var)) == null) {
            if (i53.b) {
                Log.d("Component-Action-ImageCover", "remove");
            }
            rz1 r = r(unitedSchemeEntity);
            if (r == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                l02.c("Component-Action-ImageCover", "model is null");
                return false;
            }
            qz1 qz1Var = (qz1) yz1.a(r);
            if (qz1Var == null) {
                String str2 = "can't find imageCoverView component:#" + r.b;
                l02.c("Component-Action-ImageCover", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            cz1 B = qz1Var.B();
            boolean a2 = B.a();
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, B.b);
            }
            return a2;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.k43
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, l33 l33Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, l33Var)) == null) {
            if (i53.b) {
                Log.d("Component-Action-ImageCover", "update");
            }
            rz1 r = r(unitedSchemeEntity);
            if (r == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                l02.c("Component-Action-ImageCover", "model is null");
                return false;
            }
            qz1 qz1Var = (qz1) yz1.a(r);
            if (qz1Var == null) {
                String str2 = "can't find imageCoverView component:#" + r.b;
                l02.c("Component-Action-ImageCover", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            cz1 update = qz1Var.update((qz1) r);
            boolean a2 = update.a();
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, update.b);
            }
            return a2;
        }
        return invokeLLLLL.booleanValue;
    }

    @Nullable
    public final rz1 r(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            JSONObject k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                l02.c("Component-Action-ImageCover", "params is null");
                return null;
            }
            rz1 rz1Var = new rz1();
            try {
                rz1Var.a(k);
            } catch (JSONException e) {
                e.printStackTrace();
                l02.d("Component-Action-ImageCover", "model parse exception:", e);
            }
            return rz1Var;
        }
        return (rz1) invokeL.objValue;
    }

    public final void s(@NonNull CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, callbackHandler, jSONObject, str) == null) {
            l02.i("Component-Action-ImageCover", "sendAsyncCallback info: " + jSONObject);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }
}
