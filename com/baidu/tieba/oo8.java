package com.baidu.tieba;

import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class oo8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948039089, "Lcom/baidu/tieba/oo8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948039089, "Lcom/baidu/tieba/oo8;");
        }
    }

    @JvmStatic
    public static final x78 a(ChatRoomDetail.BasicInfo info) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, info)) == null) {
            Intrinsics.checkNotNullParameter(info, "info");
            x78 x78Var = new x78(0L, null, 3, null);
            x78Var.c(info.getForumId());
            x78Var.d(info.getForumName());
            return x78Var;
        }
        return (x78) invokeL.objValue;
    }

    @JvmStatic
    public static final a88 b(long j, ChatRoomDetail roomDetail) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65538, null, j, roomDetail)) == null) {
            Intrinsics.checkNotNullParameter(roomDetail, "roomDetail");
            a88 a88Var = new a88(0L, 0, 0, null, null, 31, null);
            a88Var.i(j);
            a88Var.f(roomDetail.getUserInfo().getIdentityRole());
            a88Var.j(roomDetail.getExtraInfo().getTalkThresholdLevel());
            a88Var.g(roomDetail.getMaskInfoList());
            a88Var.h(roomDetail.getQuickTalk());
            return a88Var;
        }
        return (a88) invokeJL.objValue;
    }
}
