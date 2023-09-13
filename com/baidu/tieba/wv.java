package com.baidu.tieba;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wv extends ContextWrapper {
    public static /* synthetic */ Interceptable $ic;
    public static wv b;
    public transient /* synthetic */ FieldHolder $fh;
    public cw a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wv() {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static synchronized wv a() {
        InterceptResult invokeV;
        wv wvVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (wv.class) {
                if (b == null) {
                    b = new wv();
                }
                wvVar = b;
            }
            return wvVar;
        }
        return (wv) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            super.attachBaseContext(context);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.content.ContextWrapper, android.content.Context
    public cw getResources() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a == null) {
                this.a = new cw(super.getResources(), getAssets(), super.getResources().getDisplayMetrics(), super.getResources().getConfiguration());
            }
            return this.a;
        }
        return (cw) invokeV.objValue;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i)) == null) {
            if (mw.c(this)) {
                return yv.a(str, this);
            }
            return super.getSharedPreferences(str, i);
        }
        return (SharedPreferences) invokeLI.objValue;
    }
}
