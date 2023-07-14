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
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class y72 extends uc3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.uc3
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/coverimage" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements z72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a82 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ y72 c;

        public a(y72 y72Var, a82 a82Var, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y72Var, a82Var, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = y72Var;
            this.a = a82Var;
            this.b = callbackHandler;
        }

        @Override // com.baidu.tieba.z72
        public void a(int i, View view2, @Nullable Object obj) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, view2, obj) == null) {
                b82 b82Var = (b82) this.a.n();
                if (i == 0 || i == 1) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "loadState");
                        jSONObject.put("parentId", b82Var.d);
                        jSONObject.put("viewId", b82Var.b);
                        if (i == 1) {
                            str = "finish";
                        } else {
                            str = "error";
                        }
                        jSONObject.put("loadState", str);
                    } catch (JSONException e) {
                        v82.d("Component-Action-ImageCover", "loadState callback error", e);
                    }
                    this.c.s(this.b, jSONObject, b82Var.e);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y72(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/coverimage");
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

    @Nullable
    public final b82 r(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            JSONObject k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                v82.c("Component-Action-ImageCover", "params is null");
                return null;
            }
            b82 b82Var = new b82();
            try {
                b82Var.a(k);
            } catch (JSONException e) {
                e.printStackTrace();
                v82.d("Component-Action-ImageCover", "model parse exception:", e);
            }
            return b82Var;
        }
        return (b82) invokeL.objValue;
    }

    @Override // com.baidu.tieba.uc3
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, vb3 vb3Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, vb3Var)) == null) {
            if (sd3.b) {
                Log.d("Component-Action-ImageCover", "insert");
            }
            b82 r = r(unitedSchemeEntity);
            if (r == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                v82.c("Component-Action-ImageCover", "model is null");
                return false;
            }
            a82 a82Var = new a82(context, r);
            a82Var.e0(new a(this, a82Var, callbackHandler));
            m72 insert = a82Var.insert();
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

    @Override // com.baidu.tieba.uc3
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, vb3 vb3Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, vb3Var)) == null) {
            if (sd3.b) {
                Log.d("Component-Action-ImageCover", "remove");
            }
            b82 r = r(unitedSchemeEntity);
            if (r == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                v82.c("Component-Action-ImageCover", "model is null");
                return false;
            }
            a82 a82Var = (a82) i82.a(r);
            if (a82Var == null) {
                String str2 = "can't find imageCoverView component:#" + r.b;
                v82.c("Component-Action-ImageCover", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            m72 B = a82Var.B();
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

    @Override // com.baidu.tieba.uc3
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, vb3 vb3Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, vb3Var)) == null) {
            if (sd3.b) {
                Log.d("Component-Action-ImageCover", StickerDataChangeType.UPDATE);
            }
            b82 r = r(unitedSchemeEntity);
            if (r == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                v82.c("Component-Action-ImageCover", "model is null");
                return false;
            }
            a82 a82Var = (a82) i82.a(r);
            if (a82Var == null) {
                String str2 = "can't find imageCoverView component:#" + r.b;
                v82.c("Component-Action-ImageCover", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            m72 update = a82Var.update((a82) r);
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

    public final void s(@NonNull CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, callbackHandler, jSONObject, str) == null) {
            v82.i("Component-Action-ImageCover", "sendAsyncCallback info: " + jSONObject);
            if (!TextUtils.isEmpty(str)) {
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            }
        }
    }
}
