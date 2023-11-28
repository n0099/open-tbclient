package com.baidu.tieba;

import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.ISharePrefsWrapper;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
/* loaded from: classes6.dex */
public class j91 implements ISharePrefsWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.nps.interfa.ISharePrefsWrapper
    public Set<String> getStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, set)) == null) {
            return null;
        }
        return (Set) invokeLL.objValue;
    }

    @Override // com.baidu.nps.interfa.ISharePrefsWrapper
    public void putStringSet(String str, Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, set) == null) {
        }
    }

    @Override // com.baidu.nps.interfa.ISharePrefsWrapper
    public void remove(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    public j91() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final SharedPreferences a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ContextHolder.getApplicationContext().getSharedPreferences("nps_frame", 0);
        }
        return (SharedPreferences) invokeV.objValue;
    }

    @Override // com.baidu.nps.interfa.ISharePrefsWrapper
    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            return a().getBoolean(str, z);
        }
        return invokeLZ.booleanValue;
    }

    @Override // com.baidu.nps.interfa.ISharePrefsWrapper
    public float getFloat(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, str, f)) == null) {
            return a().getFloat(str, f);
        }
        return invokeLF.floatValue;
    }

    @Override // com.baidu.nps.interfa.ISharePrefsWrapper
    public int getInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i)) == null) {
            return a().getInt(str, i);
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.nps.interfa.ISharePrefsWrapper
    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, str, j)) == null) {
            return a().getLong(str, j);
        }
        return invokeLJ.longValue;
    }

    @Override // com.baidu.nps.interfa.ISharePrefsWrapper
    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            return a().getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.nps.interfa.ISharePrefsWrapper
    public void putBoolean(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
            a().edit().putBoolean(str, z).commit();
        }
    }

    @Override // com.baidu.nps.interfa.ISharePrefsWrapper
    public void putFloat(String str, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, f) == null) {
            a().edit().putFloat(str, f).commit();
        }
    }

    @Override // com.baidu.nps.interfa.ISharePrefsWrapper
    public void putInt(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, str, i) == null) {
            a().edit().putInt(str, i).commit();
        }
    }

    @Override // com.baidu.nps.interfa.ISharePrefsWrapper
    public void putLong(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048586, this, str, j) == null) {
            a().edit().putLong(str, j).commit();
        }
    }

    @Override // com.baidu.nps.interfa.ISharePrefsWrapper
    public void putString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            a().edit().putString(str, str2).commit();
        }
    }
}
