package com.baidu.tieba;

import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class t19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948128493, "Lcom/baidu/tieba/t19;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948128493, "Lcom/baidu/tieba/t19;");
        }
    }

    @JvmStatic
    public static final wk8 a(ChatRoomDetail.BasicInfo info) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, info)) == null) {
            Intrinsics.checkNotNullParameter(info, "info");
            wk8 wk8Var = new wk8(0L, null, 3, null);
            wk8Var.c(info.getForumId());
            wk8Var.d(info.getForumName());
            return wk8Var;
        }
        return (wk8) invokeL.objValue;
    }

    @JvmStatic
    public static final zk8 b(long j, ChatRoomDetail roomDetail) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, roomDetail)) == null) {
            Intrinsics.checkNotNullParameter(roomDetail, "roomDetail");
            zk8 zk8Var = new zk8(0L, 0, 0, null, null, 31, null);
            zk8Var.i(j);
            zk8Var.f(roomDetail.getUserInfo().getIdentityRole());
            zk8Var.j(roomDetail.getExtraInfo().getTalkThresholdLevel());
            zk8Var.g(roomDetail.getMaskInfoList());
            zk8Var.h(roomDetail.getQuickTalk());
            return zk8Var;
        }
        return (zk8) invokeJL.objValue;
    }
}
