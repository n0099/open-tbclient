package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class sq2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Activity> mActivityRef;
    public CallbackHandler mCallbackHandler;
    public Context mContext;
    public i52 mJsContainer;
    public UnitedSchemeMainDispatcher mMainDispatcher;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948159989, "Lcom/baidu/tieba/sq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948159989, "Lcom/baidu/tieba/sq2;");
                return;
            }
        }
        DEBUG = vm1.a;
    }

    public Context getDispatchContext() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WeakReference<Activity> weakReference = this.mActivityRef;
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            if (activity == null) {
                return this.mContext;
            }
            return activity;
        }
        return (Context) invokeV.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public sq2(Context context, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, CallbackHandler callbackHandler, i52 i52Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, unitedSchemeMainDispatcher, callbackHandler, i52Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mMainDispatcher = unitedSchemeMainDispatcher;
        this.mCallbackHandler = callbackHandler;
        this.mJsContainer = i52Var;
        if (DEBUG) {
            if (context == null || unitedSchemeMainDispatcher == null) {
                throw new IllegalArgumentException("any of context, dispatcher objects can't be null.");
            }
        }
    }

    public void setActivityRef(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && activity != null) {
            this.mActivityRef = new WeakReference<>(activity);
        }
    }

    public void setCallbackHandler(CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, callbackHandler) == null) {
            this.mCallbackHandler = callbackHandler;
        }
    }
}
