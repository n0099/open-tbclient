package com.baidubce.services.bos.model;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class CannedAccessControlList {
    public static final /* synthetic */ CannedAccessControlList[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CannedAccessControlList Private;
    public static final CannedAccessControlList PublicRead;
    public static final CannedAccessControlList PublicReadWrite;
    public transient /* synthetic */ FieldHolder $fh;
    public final String cannedAclHeader;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(688563829, "Lcom/baidubce/services/bos/model/CannedAccessControlList;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(688563829, "Lcom/baidubce/services/bos/model/CannedAccessControlList;");
                return;
            }
        }
        Private = new CannedAccessControlList("Private", 0, PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE);
        PublicRead = new CannedAccessControlList("PublicRead", 1, "public-read");
        CannedAccessControlList cannedAccessControlList = new CannedAccessControlList("PublicReadWrite", 2, "public-read-write");
        PublicReadWrite = cannedAccessControlList;
        $VALUES = new CannedAccessControlList[]{Private, PublicRead, cannedAccessControlList};
    }

    public CannedAccessControlList(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.cannedAclHeader = str2;
    }

    public static CannedAccessControlList valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CannedAccessControlList) Enum.valueOf(CannedAccessControlList.class, str) : (CannedAccessControlList) invokeL.objValue;
    }

    public static CannedAccessControlList[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CannedAccessControlList[]) $VALUES.clone() : (CannedAccessControlList[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.cannedAclHeader : (String) invokeV.objValue;
    }
}
