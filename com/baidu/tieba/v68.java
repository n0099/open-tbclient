package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.message.ResponseCheckUserMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tieba.im.message.ResponseGetMaskInfoMessage;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.push.PushResponseMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessage;
import com.baidu.tieba.im.pushNotify.PushNotifyMessageDecoder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class v68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends hb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public SocketResponsedMessage c(SocketResponsedMessage socketResponsedMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage)) == null) {
                if (socketResponsedMessage instanceof PushNotifyMessageDecoder) {
                    PushNotifyMessageDecoder pushNotifyMessageDecoder = (PushNotifyMessageDecoder) socketResponsedMessage;
                    if (pushNotifyMessageDecoder.getMsgList() != null) {
                        Iterator<PushNotifyMessage> it = pushNotifyMessageDecoder.getMsgList().iterator();
                        while (it.hasNext()) {
                            MessageManager.getInstance().dispatchResponsedMessageToUI(it.next());
                        }
                    }
                }
                return socketResponsedMessage;
            }
            return (SocketResponsedMessage) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.ResponsedMessage' to match base method */
        @Override // com.baidu.tieba.eb
        public /* bridge */ /* synthetic */ SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
            SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
            c(socketResponsedMessage2);
            return socketResponsedMessage2;
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            b();
            c();
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            w68.b(104102, ResponseUpdateMaskInfoMessage.class, false);
            w68.b(202003, ResponsePullMessage.class, false).f(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
            w68.b(202009, PushResponseMessage.class, false);
            w68.b(202006, PushNotifyMessageDecoder.class, false);
            w68.b(104103, ResponseGetMaskInfoMessage.class, false);
            w68.b(304100, ResponseAddFriendMessage.class, false);
            w68.b(304102, ResponseDeleteFriendMessage.class, false);
            w68.b(304103, ResponseApplyMessage.class, false);
            w68.b(104104, ResponseCheckUserMaskMessage.class, false);
            MessageManager.getInstance().registerStickyMode(2001120);
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            MessageManager.getInstance().addResponsedMessageRule(new a(202006));
            MessageManager.getInstance().addResponsedMessageRule(new aa8());
            MessageManager.getInstance().addResponsedMessageRule(new ea8());
            MessageManager.getInstance().addMessageRule(new z98());
            return true;
        }
        return invokeV.booleanValue;
    }
}
