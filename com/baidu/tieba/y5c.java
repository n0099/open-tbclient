package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class y5c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences a;

    public y5c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                Context createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
                SharedPreferences sharedPreferences = createDeviceProtectedStorageContext.getSharedPreferences("move_to_de_records", 0);
                if (!sharedPreferences.getBoolean(str, false) && createDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str)) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean(str, true);
                    edit.apply();
                }
                context = createDeviceProtectedStorageContext;
            }
            this.a = context.getSharedPreferences(str, 0);
            return;
        }
        throw new NullPointerException("context is null!");
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences != null && sharedPreferences.contains(str) && (edit = this.a.edit()) != null) {
                return edit.remove(str).commit();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean b(String str, String str2) {
        InterceptResult invokeLL;
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            SharedPreferences sharedPreferences = this.a;
            if (sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
                return edit.putString(str, str2).commit();
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
