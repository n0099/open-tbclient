package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.imMessageCenter.chatgroup.data.ChatNewMessage;
import com.baidu.tieba.imMessageCenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes5.dex */
public class qg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Long, ChatRoomInfo> a;
    public Map<Long, ChatRoomInfo> b;
    public long c;
    public Runnable d;
    public CustomMessageListener e;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qg7 a;

        public a(qg7 qg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qg7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qg7 qg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var, Integer.valueOf(i)};
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
            this.a = qg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921773 && (customResponsedMessage.getData() instanceof yh7)) {
                yh7 yh7Var = (yh7) customResponsedMessage.getData();
                ChatRoomInfo p = this.a.p(yh7Var.a, yh7Var.b, 0);
                if (p == null) {
                    return;
                }
                this.a.n(p);
                ChatRoomInfo chatRoomInfo = (ChatRoomInfo) this.a.b.get(Long.valueOf(p.getRoomId()));
                if (chatRoomInfo != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(Long.valueOf(chatRoomInfo.getRoomId()), chatRoomInfo);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921766, hashMap));
                }
            }
        }
    }

    public qg7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.b = new HashMap();
        this.d = new a(this);
        this.e = new b(this, 2921773);
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long chatGroupThreadHold = TbSingleton.getInstance().getChatGroupThreadHold();
            long j = this.c;
            if (j == 0) {
                this.c = currentTimeMillis;
            } else if (currentTimeMillis - j >= chatGroupThreadHold) {
                this.c = currentTimeMillis;
                chatGroupThreadHold = 0;
            } else {
                chatGroupThreadHold = currentTimeMillis - j;
            }
            ah.a().removeCallbacks(this.d);
            ah.a().postDelayed(this.d, chatGroupThreadHold);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!this.a.isEmpty()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921766, new HashMap(this.a)));
            }
            this.a.clear();
        }
    }

    public final List<ChatMsg> e(@NonNull TreeSet<ChatMsg> treeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, treeSet)) == null) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                ChatMsg pollLast = treeSet.pollLast();
                if (pollLast != null) {
                    if (pollLast.getMsgType() != 10000) {
                        arrayList.add(pollLast);
                    }
                } else {
                    return arrayList;
                }
            }
        } else {
            return (List) invokeL.objValue;
        }
    }

    @NonNull
    public List<Long> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new ArrayList(this.b.keySet());
        }
        return (List) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
        }
    }

    public void g(List<ChatRoomInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.b.clear();
            for (ChatRoomInfo chatRoomInfo : list) {
                this.b.put(Long.valueOf(chatRoomInfo.getRoomId()), chatRoomInfo);
            }
            if (MessageManager.getInstance().hasListener(2921766)) {
                MessageManager.getInstance().unRegisterListener(this.e);
            }
            MessageManager.getInstance().registerListener(this.e);
        }
    }

    public void h(long j, @NonNull TreeSet<ChatMsg> treeSet) {
        ChatRoomInfo chatRoomInfo;
        ChatMsg chatMsg;
        ChatMsg next;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048579, this, j, treeSet) == null) && !treeSet.isEmpty() && (chatRoomInfo = this.b.get(Long.valueOf(j))) != null) {
            List<ChatMsg> e = e(treeSet);
            if (ListUtils.isEmpty(e) || (chatMsg = e.get(e.size() - 1)) == null) {
                return;
            }
            chatMsg.setMsgTime(zh7.c(chatMsg));
            if (chatMsg.getMsgTime() <= chatRoomInfo.getTimestamp()) {
                return;
            }
            int i = 0;
            Iterator<ChatMsg> it = treeSet.iterator();
            while (it.hasNext() && ((next = it.next()) == null || next.getMsgTime() <= chatRoomInfo.getTimestamp())) {
                i++;
            }
            ChatRoomInfo o = o(chatMsg, j, e.size() - i);
            if (o == null) {
                return;
            }
            i(o);
            j();
        }
    }

    public final void i(@NonNull ChatRoomInfo chatRoomInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, chatRoomInfo) == null) {
            if (this.a.get(Long.valueOf(chatRoomInfo.getRoomId())) != null) {
                n(chatRoomInfo);
                this.a.put(Long.valueOf(chatRoomInfo.getRoomId()), this.b.get(Long.valueOf(chatRoomInfo.getRoomId())));
            } else if (this.b.containsKey(Long.valueOf(chatRoomInfo.getRoomId()))) {
                n(chatRoomInfo);
                this.a.put(Long.valueOf(chatRoomInfo.getRoomId()), this.b.get(Long.valueOf(chatRoomInfo.getRoomId())));
            }
        }
    }

    public void m(long j, int i) {
        ChatRoomInfo chatRoomInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) && (chatRoomInfo = this.b.get(Long.valueOf(j))) != null) {
            chatRoomInfo.setUnreadNum(i);
        }
    }

    public final void n(@NonNull ChatRoomInfo chatRoomInfo) {
        ChatRoomInfo chatRoomInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, chatRoomInfo) == null) && (chatRoomInfo2 = this.b.get(Long.valueOf(chatRoomInfo.getRoomId()))) != null) {
            chatRoomInfo2.setUnreadNum(chatRoomInfo2.getUnreadNum() + chatRoomInfo.getUnreadNum());
            chatRoomInfo2.setNewMessage(chatRoomInfo.getNewMessage());
        }
    }

    @Nullable
    public final ChatRoomInfo o(@NonNull ChatMsg chatMsg, long j, int i) {
        InterceptResult invokeCommon;
        BaseMsg a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{chatMsg, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            if (chatMsg.getMsgType() == 10000) {
                a2 = zh7.b(chatMsg);
            } else {
                a2 = zh7.a(j, chatMsg);
            }
            return p(a2, j, i);
        }
        return (ChatRoomInfo) invokeCommon.objValue;
    }

    public final ChatRoomInfo p(@NonNull BaseMsg baseMsg, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{baseMsg, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            if (baseMsg != null && baseMsg.getSdkMsg() != null) {
                long msgId = baseMsg.getSdkMsg().getMsgId();
                long msgTime = baseMsg.getSdkMsg().getMsgTime();
                ChatRoomInfo chatRoomInfo = new ChatRoomInfo();
                chatRoomInfo.setRoomId(j);
                chatRoomInfo.setUnreadNum(i);
                ChatNewMessage chatNewMessage = new ChatNewMessage();
                chatNewMessage.setMsgId(String.valueOf(msgId));
                chatNewMessage.setMsgTime(String.valueOf(msgTime));
                if (baseMsg instanceof TextMsg) {
                    chatNewMessage.setContent(((TextMsg) baseMsg).getText());
                } else {
                    chatNewMessage.setContent(baseMsg.getThumbnailText().toString());
                }
                chatNewMessage.setFromName(baseMsg.getSdkMsg().getNickName());
                chatRoomInfo.setNewMessage(chatNewMessage);
                return chatRoomInfo;
            }
            return null;
        }
        return (ChatRoomInfo) invokeCommon.objValue;
    }
}
