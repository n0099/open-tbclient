package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ItemInfo;
/* loaded from: classes7.dex */
public final class oh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ForumWriteData a;
    public final ActivityConfig b;
    public final ItemInfo c;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof oh7) {
                oh7 oh7Var = (oh7) obj;
                return Intrinsics.areEqual(this.a, oh7Var.a) && Intrinsics.areEqual(this.b, oh7Var.b) && Intrinsics.areEqual(this.c, oh7Var.c);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ForumWriteData forumWriteData = this.a;
            int hashCode = (forumWriteData == null ? 0 : forumWriteData.hashCode()) * 31;
            ActivityConfig activityConfig = this.b;
            int hashCode2 = (hashCode + (activityConfig == null ? 0 : activityConfig.hashCode())) * 31;
            ItemInfo itemInfo = this.c;
            return hashCode2 + (itemInfo != null ? itemInfo.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "WriteButtonData(forumWriteData=" + this.a + ", activityConfig=" + this.b + ", itemInfo=" + this.c + ')';
        }
        return (String) invokeV.objValue;
    }

    public oh7(ForumWriteData forumWriteData, ActivityConfig activityConfig, ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {forumWriteData, activityConfig, itemInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = forumWriteData;
        this.b = activityConfig;
        this.c = itemInfo;
    }

    public final ActivityConfig a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (ActivityConfig) invokeV.objValue;
    }

    public final ForumWriteData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (ForumWriteData) invokeV.objValue;
    }

    public final ItemInfo c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (ItemInfo) invokeV.objValue;
    }
}
