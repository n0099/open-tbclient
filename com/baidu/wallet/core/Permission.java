package com.baidu.wallet.core;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class Permission {
    public static final /* synthetic */ Permission[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Permission NONE;
    public static final Permission READ_DEVICE;
    public static final Permission READ_NORMAL;
    public static final Permission READ_PRIVATE;
    public static final Permission WRITE;
    public transient /* synthetic */ FieldHolder $fh;
    public final int val;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1367891524, "Lcom/baidu/wallet/core/Permission;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1367891524, "Lcom/baidu/wallet/core/Permission;");
                return;
            }
        }
        NONE = new Permission("NONE", 0, 0);
        READ_NORMAL = new Permission("READ_NORMAL", 1, 1);
        READ_PRIVATE = new Permission("READ_PRIVATE", 2, 2);
        WRITE = new Permission("WRITE", 3, 4);
        Permission permission = new Permission("READ_DEVICE", 4, 8);
        READ_DEVICE = permission;
        $VALUES = new Permission[]{NONE, READ_NORMAL, READ_PRIVATE, WRITE, permission};
    }

    public Permission(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.val = i3;
    }

    public static Map<String, EnumSet<Permission>> parseDomainsConfig(@NonNull String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    hashMap.put(next, parsePermission(jSONObject.optInt(next)));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static EnumSet<Permission> parsePermission(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            EnumSet<Permission> of = EnumSet.of(NONE);
            if (READ_NORMAL.verify(i2)) {
                of.add(READ_NORMAL);
            }
            if (READ_PRIVATE.verify(i2)) {
                of.add(READ_PRIVATE);
            }
            if (WRITE.verify(i2)) {
                of.add(WRITE);
            }
            if (READ_DEVICE.verify(i2)) {
                of.add(READ_DEVICE);
            }
            return of;
        }
        return (EnumSet) invokeI.objValue;
    }

    public static Permission valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (Permission) Enum.valueOf(Permission.class, str) : (Permission) invokeL.objValue;
    }

    public static Permission[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (Permission[]) $VALUES.clone() : (Permission[]) invokeV.objValue;
    }

    public int getVal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.val : invokeV.intValue;
    }

    public boolean verify(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int i3 = this.val;
            return (i2 & i3) == i3;
        }
        return invokeI.booleanValue;
    }
}
