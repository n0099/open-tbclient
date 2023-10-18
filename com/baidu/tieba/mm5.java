package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestPassFriendMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class mm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65536, null, j, str) == null) {
            RequestPassFriendMessage requestPassFriendMessage = new RequestPassFriendMessage();
            requestPassFriendMessage.setFriendId(j, str);
            MessageManager.getInstance().sendMessage(requestPassFriendMessage);
        }
    }
}
