package com.baidu.tieba;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class jk3 extends kk3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<String> f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947886135, "Lcom/baidu/tieba/jk3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947886135, "Lcom/baidu/tieba/jk3;");
                return;
            }
        }
        g = ms1.a;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && g) {
            IllegalAccessException illegalAccessException = new IllegalAccessException("read only allowed");
            Log.i("IpcReadOnlySP", illegalAccessException.toString());
            illegalAccessException.printStackTrace();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jk3(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = new HashSet();
    }

    @Override // com.baidu.tieba.kk3, com.baidu.tieba.pk3, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (j(str)) {
                return super.getBoolean(str, z);
            }
            return c(str, z);
        }
        return invokeLZ.booleanValue;
    }

    @Override // com.baidu.tieba.kk3, com.baidu.tieba.pk3, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, f)) == null) {
            if (j(str)) {
                return super.getFloat(str, f);
            }
            return d(str, f);
        }
        return invokeLF.floatValue;
    }

    @Override // com.baidu.tieba.kk3, com.baidu.tieba.pk3, android.content.SharedPreferences
    public int getInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i)) == null) {
            if (j(str)) {
                return super.getInt(str, i);
            }
            return e(str, i);
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.kk3, com.baidu.tieba.pk3, android.content.SharedPreferences
    public long getLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, str, j)) == null) {
            if (j(str)) {
                return super.getLong(str, j);
            }
            return f(str, j);
        }
        return invokeLJ.longValue;
    }

    @Override // com.baidu.tieba.kk3, com.baidu.tieba.pk3, android.content.SharedPreferences
    public String getString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            if (j(str)) {
                return super.getString(str, str2);
            }
            return h(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.kk3, com.baidu.tieba.pk3, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, str, z)) == null) {
            if (!i() && !j(str)) {
                k();
            } else {
                super.putBoolean(str, z);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLZ.objValue;
    }

    @Override // com.baidu.tieba.kk3, com.baidu.tieba.pk3, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, f)) == null) {
            if (!i() && !j(str)) {
                k();
            } else {
                super.putFloat(str, f);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLF.objValue;
    }

    @Override // com.baidu.tieba.kk3, com.baidu.tieba.pk3, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, str, i)) == null) {
            if (!i() && !j(str)) {
                k();
            } else {
                super.putInt(str, i);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.kk3, com.baidu.tieba.pk3, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, str, j)) == null) {
            if (!i() && !j(str)) {
                k();
            } else {
                super.putLong(str, j);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLJ.objValue;
    }

    @Override // com.baidu.tieba.kk3, com.baidu.tieba.pk3, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            if (!i() && !j(str)) {
                k();
            } else {
                super.putString(str, str2);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.pk3, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, set)) == null) {
            if (!i() && !j(str)) {
                k();
            } else {
                super.putStringSet(str, set);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeLL.objValue;
    }

    public boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return this.f.contains(str);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.pk3, com.baidu.tieba.es4, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onSharedPreferenceChangeListener) == null) {
            if (i()) {
                super.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            } else {
                k();
            }
        }
    }

    @Override // com.baidu.tieba.kk3, com.baidu.tieba.pk3, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (!i() && !j(str)) {
                k();
            } else {
                super.remove(str);
            }
            return this;
        }
        return (SharedPreferences.Editor) invokeL.objValue;
    }

    @Override // com.baidu.tieba.pk3, com.baidu.tieba.es4, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onSharedPreferenceChangeListener) == null) {
            if (i()) {
                super.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            } else {
                k();
            }
        }
    }
}
