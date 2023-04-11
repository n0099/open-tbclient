package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class ys9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public VersionData a;
    public final ClientUpdateInfo b;
    public final String c;
    public final boolean d;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ys9) {
                ys9 ys9Var = (ys9) obj;
                return Intrinsics.areEqual(this.a, ys9Var.a) && Intrinsics.areEqual(this.b, ys9Var.b) && Intrinsics.areEqual(this.c, ys9Var.c) && this.d == ys9Var.d;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int hashCode = this.a.hashCode() * 31;
            ClientUpdateInfo clientUpdateInfo = this.b;
            int hashCode2 = (((hashCode + (clientUpdateInfo == null ? 0 : clientUpdateInfo.hashCode())) * 31) + this.c.hashCode()) * 31;
            boolean z = this.d;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return hashCode2 + i;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "LcUpdateDataWrapper(versionData=" + this.a + ", updateInfo=" + this.b + ", apkMd5Rsa=" + this.c + ", isUserUpdate=" + this.d + ')';
        }
        return (String) invokeV.objValue;
    }

    public ys9(VersionData versionData, ClientUpdateInfo clientUpdateInfo, String apkMd5Rsa, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {versionData, clientUpdateInfo, apkMd5Rsa, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(versionData, "versionData");
        Intrinsics.checkNotNullParameter(apkMd5Rsa, "apkMd5Rsa");
        this.a = versionData;
        this.b = clientUpdateInfo;
        this.c = apkMd5Rsa;
        this.d = z;
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final ClientUpdateInfo b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (ClientUpdateInfo) invokeV.objValue;
    }

    public final VersionData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (VersionData) invokeV.objValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }
}
