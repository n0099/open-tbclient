package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import tbclient.CallRobotEntrance;
import tbclient.StyleContentInfo;
/* loaded from: classes9.dex */
public final class xw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CallRobotEntrance a;
    public final StyleContentInfo b;
    public final StyleContentInfo c;
    public final boolean d;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof xw4) {
                xw4 xw4Var = (xw4) obj;
                return Intrinsics.areEqual(this.a, xw4Var.a) && Intrinsics.areEqual(this.b, xw4Var.b) && Intrinsics.areEqual(this.c, xw4Var.c) && this.d == xw4Var.d;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            CallRobotEntrance callRobotEntrance = this.a;
            int hashCode = (((((callRobotEntrance == null ? 0 : callRobotEntrance.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            boolean z = this.d;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return hashCode + i;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "CallRobotEntranceData(robotEntrance=" + this.a + ", robotDayContentInfo=" + this.b + ", robotDarkContentInfo=" + this.c + ", isDefault=" + this.d + ')';
        }
        return (String) invokeV.objValue;
    }

    public xw4(CallRobotEntrance callRobotEntrance, StyleContentInfo robotDayContentInfo, StyleContentInfo robotDarkContentInfo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callRobotEntrance, robotDayContentInfo, robotDarkContentInfo, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(robotDayContentInfo, "robotDayContentInfo");
        Intrinsics.checkNotNullParameter(robotDarkContentInfo, "robotDarkContentInfo");
        this.a = callRobotEntrance;
        this.b = robotDayContentInfo;
        this.c = robotDarkContentInfo;
        this.d = z;
    }

    public final StyleContentInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (StyleContentInfo) invokeV.objValue;
    }

    public final StyleContentInfo b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (StyleContentInfo) invokeV.objValue;
    }

    public final CallRobotEntrance c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (CallRobotEntrance) invokeV.objValue;
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
