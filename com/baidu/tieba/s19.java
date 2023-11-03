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
public final class s19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948098702, "Lcom/baidu/tieba/s19;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948098702, "Lcom/baidu/tieba/s19;");
        }
    }

    @JvmStatic
    public static final vk8 a(ChatRoomDetail.BasicInfo info) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, info)) == null) {
            Intrinsics.checkNotNullParameter(info, "info");
            vk8 vk8Var = new vk8(0L, null, 3, null);
            vk8Var.c(info.getForumId());
            vk8Var.d(info.getForumName());
            return vk8Var;
        }
        return (vk8) invokeL.objValue;
    }

    @JvmStatic
    public static final yk8 b(long j, ChatRoomDetail roomDetail) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, roomDetail)) == null) {
            Intrinsics.checkNotNullParameter(roomDetail, "roomDetail");
            yk8 yk8Var = new yk8(0L, 0, 0, null, null, 31, null);
            yk8Var.i(j);
            yk8Var.f(roomDetail.getUserInfo().getIdentityRole());
            yk8Var.j(roomDetail.getExtraInfo().getTalkThresholdLevel());
            yk8Var.g(roomDetail.getMaskInfoList());
            yk8Var.h(roomDetail.getQuickTalk());
            return yk8Var;
        }
        return (yk8) invokeJL.objValue;
    }
}
