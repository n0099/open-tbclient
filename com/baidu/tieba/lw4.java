package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.constant.WBConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class lw4 implements pw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final tw4 a;
    public final HashMap b;

    public lw4(tw4 tw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tw4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tw4Var;
        this.b = new HashMap();
        b(getClass());
        if (!this.b.isEmpty()) {
            return;
        }
        throw new IllegalStateException("No native methods found!");
    }

    @Override // com.baidu.tieba.pw4
    public void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        Object invoke;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, jSONObject, jSONObject2) == null) {
            Method method = (Method) this.b.get(str);
            if (method != null) {
                ww4 ww4Var = (ww4) method.getAnnotation(ww4.class);
                String optString = jSONObject2.optString(WBConstants.SHARE_CALLBACK_ID);
                try {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (!ww4Var.isAsync()) {
                        if (parameterTypes.length == 2) {
                            invoke = method.invoke(this, optString, jSONObject);
                        } else if (parameterTypes.length == 1) {
                            invoke = method.invoke(this, jSONObject);
                        } else if (parameterTypes.length == 0) {
                            mw4.a("native method " + getClass().getSimpleName() + ":" + ww4Var.value() + " ignored all parameters.");
                            invoke = method.invoke(this, new Object[0]);
                        } else {
                            e(str, jSONObject2, "500", "parameters too much!");
                            return;
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            d(optString, (JSONObject) invoke);
                            return;
                        }
                        return;
                    } else if (parameterTypes.length == 2) {
                        method.invoke(this, optString, jSONObject);
                        return;
                    } else if (parameterTypes.length == 1) {
                        method.invoke(this, jSONObject);
                        if (!TextUtils.isEmpty(optString)) {
                            d(optString, null);
                            return;
                        }
                        return;
                    } else if (parameterTypes.length == 0) {
                        mw4.a("native method " + getClass().getSimpleName() + ":" + ww4Var.value() + " ignored all parameters.");
                        method.invoke(this, new Object[0]);
                        if (!TextUtils.isEmpty(optString)) {
                            d(optString, null);
                            return;
                        }
                        return;
                    } else {
                        e(str, jSONObject2, "500", "parameters too much!");
                        return;
                    }
                } catch (IllegalAccessException e) {
                    mw4.a("native method call error:" + e.getMessage());
                    e(str, jSONObject2, TbEnum.SystemMessage.EVENT_ID_UPLOAD_STAT, "IllegalAccessException:" + e.getMessage());
                    return;
                } catch (InvocationTargetException e2) {
                    mw4.a("native method call error:" + e2.getMessage());
                    e(str, jSONObject2, TbEnum.SystemMessage.EVENT_ID_PLUGIN_CONFIG_SYNC, "InvocationTargetException:" + e2.getMessage());
                    return;
                } catch (Exception e3) {
                    mw4.a("native method call error:" + e3.getMessage());
                    e(str, jSONObject2, TbEnum.SystemMessage.EVENT_ID_OFFLINE_DEBUG, "Native call exception:" + e3.getMessage());
                    return;
                }
            }
            e(str, jSONObject2, "403", "method " + str + " not exists");
        }
    }

    public final void b(Class cls) {
        Method[] declaredMethods;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls) == null) {
            for (Method method : cls.getDeclaredMethods()) {
                String str = null;
                ww4 ww4Var = (ww4) method.getAnnotation(ww4.class);
                if (ww4Var != null) {
                    String value = ww4Var.value();
                    if (!TextUtils.isEmpty(value)) {
                        str = value;
                    }
                    if (ww4Var.isAsync() && !Void.TYPE.equals(method.getReturnType())) {
                        throw new IllegalArgumentException("Method with async flag should return void.");
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = method.getName();
                    }
                    method.setAccessible(true);
                    this.b.put(str, method);
                }
            }
            Class superclass = cls.getSuperclass();
            if (superclass != null && superclass != cls) {
                b(superclass);
            }
        }
    }

    public void c(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
            iw4.a(message);
        }
    }

    public void d(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, jSONObject) == null) {
            if (TextUtils.isEmpty(str)) {
                mw4.a("sendResponseToJS got empty callbackId.");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", "0");
            hashMap.put(StatConstants.KEY_EXT_ERR_MSG, "success");
            if (jSONObject != null) {
                hashMap.put("data", jSONObject);
            }
            this.a.c(uw4.k(str, hashMap));
        }
    }

    public final void e(String str, JSONObject jSONObject, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, jSONObject, str2, str3) == null) {
            String optString = jSONObject.optString(WBConstants.SHARE_CALLBACK_ID);
            if (TextUtils.isEmpty(optString)) {
                mw4.a("method " + str + " not found!");
                return;
            }
            HashMap hashMap = new HashMap(4);
            hashMap.put("errNo", str2);
            hashMap.put(StatConstants.KEY_EXT_ERR_MSG, str3);
            this.a.c(uw4.k(optString, hashMap));
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.getContext();
        }
        return (Context) invokeV.objValue;
    }
}
