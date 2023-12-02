package com.baidu.tieba;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class y49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948280331, "Lcom/baidu/tieba/y49;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948280331, "Lcom/baidu/tieba/y49;");
        }
    }

    @JvmStatic
    public static final String a(List<? extends GroupChatRoomPojo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Intrinsics.checkNotNull(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                GroupChatRoomPojo groupChatRoomPojo = list.get(i);
                HashMap hashMap = new HashMap();
                hashMap.put("room_id", Long.valueOf(groupChatRoomPojo.getRoomId()));
                hashMap.put("msg_id", String.valueOf(groupChatRoomPojo.getLatestMsgId()));
                hashMap.put("time", Long.valueOf(groupChatRoomPojo.getLastExitChatRoomTime()));
                arrayList.add(hashMap);
            }
            if (ListUtils.isEmpty(arrayList)) {
                return null;
            }
            return DataExt.toJson(arrayList);
        }
        return (String) invokeL.objValue;
    }
}
