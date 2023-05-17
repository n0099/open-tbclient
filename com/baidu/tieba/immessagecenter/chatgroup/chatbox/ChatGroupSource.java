package com.baidu.tieba.immessagecenter.chatgroup.chatbox;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class ChatGroupSource {
    public static final /* synthetic */ ChatGroupSource[] $VALUES;
    public static /* synthetic */ Interceptable $ic = null;
    public static final ChatGroupSource GROUP_CHAT_FLOAT;
    public static final ChatGroupSource GROUP_CHAT_LIST;
    public static final ChatGroupSource GROUP_CHAT_PAGE;
    public static final ChatGroupSource GROUP_CHAT_TAB;
    public static final long MSG_CHAT_TAB_INTERVAL_DELAY = 1000;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(554324194, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/ChatGroupSource;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(554324194, "Lcom/baidu/tieba/immessagecenter/chatgroup/chatbox/ChatGroupSource;");
                return;
            }
        }
        GROUP_CHAT_PAGE = new ChatGroupSource("GROUP_CHAT_PAGE", 0);
        GROUP_CHAT_TAB = new ChatGroupSource("GROUP_CHAT_TAB", 1);
        GROUP_CHAT_LIST = new ChatGroupSource("GROUP_CHAT_LIST", 2);
        ChatGroupSource chatGroupSource = new ChatGroupSource("GROUP_CHAT_FLOAT", 3);
        GROUP_CHAT_FLOAT = chatGroupSource;
        $VALUES = new ChatGroupSource[]{GROUP_CHAT_PAGE, GROUP_CHAT_TAB, GROUP_CHAT_LIST, chatGroupSource};
    }

    public ChatGroupSource(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ChatGroupSource valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (ChatGroupSource) Enum.valueOf(ChatGroupSource.class, str);
        }
        return (ChatGroupSource) invokeL.objValue;
    }

    public static ChatGroupSource[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (ChatGroupSource[]) $VALUES.clone();
        }
        return (ChatGroupSource[]) invokeV.objValue;
    }
}
