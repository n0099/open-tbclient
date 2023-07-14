package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.ChatGroupSource;
import com.baidu.tieba.immessagecenter.chatgroup.data.AtInfo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatNewMessage;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AtUserInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
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
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class xi8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Long, ChatRoomInfo> a;
    public Map<Long, ChatRoomInfo> b;
    public long c;
    public Context d;
    public ap8 e;
    public ChatGroupSource f;
    public Runnable g;
    public CustomMessageListener h;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xi8 a;

        public a(xi8 xi8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xi8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c = System.currentTimeMillis();
                this.a.q();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xi8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(xi8 xi8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xi8Var, Integer.valueOf(i)};
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
            this.a = xi8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            wo8 wo8Var;
            BaseMsg baseMsg;
            ChatRoomInfo u;
            String showContent;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921773 && (customResponsedMessage.getData() instanceof wo8) && (wo8Var = (wo8) customResponsedMessage.getData()) != null && (baseMsg = wo8Var.a) != null && (u = this.a.u(baseMsg, wo8Var.b, 0)) != null) {
                this.a.s(u);
                ChatRoomInfo chatRoomInfo = (ChatRoomInfo) this.a.b.get(Long.valueOf(u.getRoomId()));
                if (chatRoomInfo != null && chatRoomInfo.getNewMessage() != null) {
                    chatRoomInfo.setAtInfo(null);
                    chatRoomInfo.getNewMessage().resetSpecialMsg();
                    BaseMsg baseMsg2 = wo8Var.a;
                    if (baseMsg2 instanceof BaseSysMsg) {
                        BaseSysMsg baseSysMsg = (BaseSysMsg) baseMsg2;
                        chatRoomInfo.getNewMessage().setFromName(null);
                        ChatNewMessage newMessage = chatRoomInfo.getNewMessage();
                        if (baseSysMsg.getMsgConf() == null) {
                            showContent = "";
                        } else {
                            showContent = baseSysMsg.getMsgConf().getShowContent();
                        }
                        newMessage.setContent(showContent);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(Long.valueOf(chatRoomInfo.getRoomId()), chatRoomInfo);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921766, hashMap));
                }
            }
        }
    }

    public xi8(Context context, @NonNull ChatGroupSource chatGroupSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, chatGroupSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.e = new ap8();
        this.g = new a(this);
        this.h = new b(this, 2921773);
        this.d = context;
        this.f = chatGroupSource;
    }

    public void p(long j) {
        ChatRoomInfo chatRoomInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048586, this, j) == null) && (chatRoomInfo = this.b.get(Long.valueOf(j))) != null && chatRoomInfo.getNewMessage() != null) {
            chatRoomInfo.getNewMessage().resetSpecialMsg();
        }
    }

    public final List<ChatMsg> f(@NonNull ChatRoomInfo chatRoomInfo, @NonNull TreeSet<ChatMsg> treeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, chatRoomInfo, treeSet)) == null) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                ChatMsg pollLast = treeSet.pollLast();
                if (pollLast != null) {
                    ap8.c(chatRoomInfo, pollLast);
                    if (pollLast.getMsgType() == 10000) {
                        if (this.e.f(pollLast)) {
                            arrayList.add(pollLast);
                        }
                    } else {
                        arrayList.add(pollLast);
                    }
                } else {
                    return arrayList;
                }
            }
        } else {
            return (List) invokeLL.objValue;
        }
    }

    public final void o(@NonNull ChatRoomInfo chatRoomInfo, @NonNull ChatRoomInfo chatRoomInfo2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, chatRoomInfo, chatRoomInfo2) == null) {
            ChatNewMessage newMessage = chatRoomInfo.getNewMessage();
            ChatNewMessage newMessage2 = chatRoomInfo2.getNewMessage();
            if (newMessage != null && ChatNewMessage.getSpecialMsgPriority(newMessage.getSpecialType()) > ChatNewMessage.getSpecialMsgPriority(newMessage2.getSpecialType())) {
                newMessage2.setSpecialType(newMessage.getSpecialType());
                newMessage2.setSpecialMsg(newMessage.getSpecialMsg());
            }
        }
    }

    public void r(long j, int i) {
        ChatRoomInfo chatRoomInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) && (chatRoomInfo = this.b.get(Long.valueOf(j))) != null) {
            chatRoomInfo.setUnreadNum(i);
        }
    }

    @NonNull
    public List<Long> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new ArrayList(this.b.keySet());
        }
        return (List) invokeV.objValue;
    }

    public final long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f == ChatGroupSource.GROUP_CHAT_TAB) {
                return 1000L;
            }
            return TbSingleton.getInstance().getChatGroupThreadHold();
        }
        return invokeV.longValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    public void i(List<ChatRoomInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.b.clear();
            for (ChatRoomInfo chatRoomInfo : list) {
                this.b.put(Long.valueOf(chatRoomInfo.getRoomId()), chatRoomInfo);
            }
            if (MessageManager.getInstance().hasListener(2921766)) {
                MessageManager.getInstance().unRegisterListener(this.h);
            }
            MessageManager.getInstance().registerListener(this.h);
        }
    }

    public void j(long j, @NonNull TreeSet<ChatMsg> treeSet) {
        ChatRoomInfo chatRoomInfo;
        ChatMsg next;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048580, this, j, treeSet) == null) && !treeSet.isEmpty() && (chatRoomInfo = this.b.get(Long.valueOf(j))) != null) {
            List<ChatMsg> f = f(chatRoomInfo, treeSet);
            if (ListUtils.isEmpty(f)) {
                return;
            }
            int i = 0;
            ChatMsg chatMsg = f.get(0);
            if (chatMsg == null) {
                return;
            }
            chatMsg.setMsgTime(ap8.i(chatMsg));
            if (chatMsg.getMsgTime() <= chatRoomInfo.getTimestamp()) {
                return;
            }
            Iterator<ChatMsg> it = treeSet.iterator();
            while (it.hasNext() && ((next = it.next()) == null || next.getMsgTime() <= chatRoomInfo.getTimestamp())) {
                i++;
            }
            ChatRoomInfo t = t(chatMsg, j, f.size() - i);
            if (t == null) {
                return;
            }
            o(chatRoomInfo, t);
            k(t);
            l();
        }
    }

    public final void k(@NonNull ChatRoomInfo chatRoomInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, chatRoomInfo) == null) {
            if (this.a.get(Long.valueOf(chatRoomInfo.getRoomId())) != null) {
                s(chatRoomInfo);
                this.a.put(Long.valueOf(chatRoomInfo.getRoomId()), this.b.get(Long.valueOf(chatRoomInfo.getRoomId())));
            } else if (this.b.containsKey(Long.valueOf(chatRoomInfo.getRoomId()))) {
                s(chatRoomInfo);
                this.a.put(Long.valueOf(chatRoomInfo.getRoomId()), this.b.get(Long.valueOf(chatRoomInfo.getRoomId())));
            }
        }
    }

    @Nullable
    public AtInfo n(@NonNull BaseMsg baseMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, baseMsg)) == null) {
            List<AtUserInfo> atUserInfoList = baseMsg.getAtUserInfoList();
            if (atUserInfoList == null) {
                return null;
            }
            AtInfo atInfo = new AtInfo();
            for (AtUserInfo atUserInfo : atUserInfoList) {
                if (atUserInfo.getAtType() == AtUserInfo.AtType.ALL) {
                    atInfo.setAtAllMsgCount(atInfo.getAllMsgCount() + 1);
                    atInfo.setAtCountAll(atInfo.getCountAll() + 1);
                } else if (atUserInfo.getAtType() == AtUserInfo.AtType.USER && TbadkCoreApplication.getCurrentAccountId() == atUserInfo.getUid()) {
                    atInfo.setAtSingleMsgCount(atInfo.getSingleMsgCount() + 1);
                    atInfo.setAtCountAll(atInfo.getCountAll() + 1);
                }
            }
            return atInfo;
        }
        return (AtInfo) invokeL.objValue;
    }

    public final void s(@NonNull ChatRoomInfo chatRoomInfo) {
        ChatRoomInfo chatRoomInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, chatRoomInfo) == null) && (chatRoomInfo2 = this.b.get(Long.valueOf(chatRoomInfo.getRoomId()))) != null) {
            chatRoomInfo2.setUnreadNum(chatRoomInfo2.getUnreadNum() + chatRoomInfo.getUnreadNum());
            chatRoomInfo2.setNewMessage(chatRoomInfo.getNewMessage());
            if (chatRoomInfo2.getAtInfo() != null) {
                if (chatRoomInfo.getAtInfo() != null) {
                    AtInfo atInfo = chatRoomInfo2.getAtInfo();
                    AtInfo atInfo2 = chatRoomInfo.getAtInfo();
                    if (atInfo2 != null) {
                        atInfo.setAtAllMsgCount(atInfo.getAllMsgCount() + atInfo2.getAllMsgCount());
                        atInfo.setAtCountAll(atInfo.getCountAll() + atInfo2.getCountAll());
                        atInfo.setAtSingleMsgCount(atInfo.getSingleMsgCount() + atInfo2.getSingleMsgCount());
                        return;
                    }
                    return;
                }
                return;
            }
            chatRoomInfo2.setAtInfo(chatRoomInfo.getAtInfo());
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long h = h();
            long j = this.c;
            if (j == 0) {
                this.c = currentTimeMillis;
            } else if (currentTimeMillis - j >= h) {
                this.c = currentTimeMillis;
                h = 0;
            } else {
                h -= currentTimeMillis - j;
            }
            zg.a().removeCallbacks(this.g);
            zg.a().postDelayed(this.g, h);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!this.a.isEmpty()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921766, new HashMap(this.a)));
            }
            this.a.clear();
        }
    }

    @Nullable
    public final ChatRoomInfo t(@NonNull ChatMsg chatMsg, long j, int i) {
        InterceptResult invokeCommon;
        BaseMsg g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{chatMsg, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            if (chatMsg.getMsgType() == 10000) {
                g = this.e.h(chatMsg);
            } else {
                g = this.e.g(j, chatMsg);
            }
            return u(g, j, i);
        }
        return (ChatRoomInfo) invokeCommon.objValue;
    }

    public final ChatRoomInfo u(BaseMsg baseMsg, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{baseMsg, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            if (baseMsg == null) {
                return null;
            }
            long msgId = baseMsg.getSdkMsg().getMsgId();
            long msgTime = baseMsg.getSdkMsg().getMsgTime();
            ChatRoomInfo chatRoomInfo = new ChatRoomInfo();
            chatRoomInfo.setRoomId(j);
            ChatNewMessage chatNewMessage = new ChatNewMessage();
            chatNewMessage.setMsgId(String.valueOf(msgId));
            chatNewMessage.setMsgTime(String.valueOf(msgTime));
            if (baseMsg instanceof TextMsg) {
                chatNewMessage.setContent(((TextMsg) baseMsg).getText());
                chatNewMessage.setFromName(baseMsg.getSdkMsg().getNickName());
            } else if (baseMsg instanceof BaseSysMsg) {
                BaseSysMsg baseSysMsg = (BaseSysMsg) baseMsg;
                if (baseSysMsg.getMsgConf() != null) {
                    if (baseSysMsg.getMsgConf().isVisible()) {
                        chatNewMessage.setContent(baseSysMsg.getMsgConf().getShowContent());
                    }
                    if (!baseSysMsg.getMsgConf().isCountable() && i > 0) {
                        i--;
                    }
                } else {
                    chatNewMessage.setFromName(baseMsg.getSdkMsg().getNickName());
                    if (baseMsg.getThumbnailText() != null) {
                        chatNewMessage.setContent(baseMsg.getThumbnailText().toString());
                    }
                }
            } else {
                if (baseMsg.getThumbnailText() != null) {
                    chatNewMessage.setContent(baseMsg.getThumbnailText().toString());
                }
                if (baseMsg.getSdkMsg() != null) {
                    chatNewMessage.setFromName(baseMsg.getSdkMsg().getNickName());
                }
            }
            chatRoomInfo.setUnreadNum(i);
            chatRoomInfo.setNewMessage(chatNewMessage);
            AtInfo n = n(baseMsg);
            if (n != null && n.getCountAll() > 0) {
                chatNewMessage.setSpecialType(ChatNewMessage.TYPE_AT_MSG);
                chatNewMessage.setSpecialMsg(ChatNewMessage.TYPE_AT_MSG_CONTENT);
            }
            chatRoomInfo.setAtInfo(n);
            return chatRoomInfo;
        }
        return (ChatRoomInfo) invokeCommon.objValue;
    }
}
