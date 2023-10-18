package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class m73 extends q63<UnitedSchemeBaseDispatcher> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947925536, "Lcom/baidu/tieba/m73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947925536, "Lcom/baidu/tieba/m73;");
                return;
            }
        }
        b = am1.a;
    }

    public p53 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return p53.M();
        }
        return (p53) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m73(UnitedSchemeBaseDispatcher unitedSchemeBaseDispatcher, String str) {
        super(unitedSchemeBaseDispatcher, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {unitedSchemeBaseDispatcher, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeAbsDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public static JSONObject a(UnitedSchemeEntity unitedSchemeEntity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, unitedSchemeEntity, str)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            String param = unitedSchemeEntity.getParam(str);
            if (TextUtils.isEmpty(param)) {
                return null;
            }
            try {
                return new JSONObject(param);
            } catch (JSONException e) {
                if (b) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public boolean h(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str)) == null) {
            try {
                if (TextUtils.equals(this.a, str)) {
                    return d(context, unitedSchemeEntity, callbackHandler, c());
                }
                return i(context, unitedSchemeEntity, callbackHandler, str, c());
            } catch (Throwable th) {
                if (b) {
                    Log.e("SwanAppAction", Log.getStackTraceString(th));
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "execute with exception: " + Log.getStackTraceString(th));
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, p53 p53Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, p53Var)) == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(101, "not support such action ：" + unitedSchemeEntity.getUri().getPath());
            return false;
        }
        return invokeLLLLL.booleanValue;
    }
}
