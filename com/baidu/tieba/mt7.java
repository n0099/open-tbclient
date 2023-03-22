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
/* loaded from: classes5.dex */
public class mt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Long, ChatRoomInfo> a;
    public Map<Long, ChatRoomInfo> b;
    public long c;
    public Context d;
    public kx7 e;
    public Runnable f;
    public CustomMessageListener g;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mt7 a;

        public a(mt7 mt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mt7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.m();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mt7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(mt7 mt7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mt7Var, Integer.valueOf(i)};
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
            this.a = mt7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            hx7 hx7Var;
            BaseMsg baseMsg;
            ChatRoomInfo q;
            String showContent;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921773 || !(customResponsedMessage.getData() instanceof hx7) || (hx7Var = (hx7) customResponsedMessage.getData()) == null || (baseMsg = hx7Var.a) == null || (q = this.a.q(baseMsg, hx7Var.b, 0)) == null) {
                return;
            }
            this.a.o(q);
            ChatRoomInfo chatRoomInfo = (ChatRoomInfo) this.a.b.get(Long.valueOf(q.getRoomId()));
            if (chatRoomInfo != null && chatRoomInfo.getNewMessage() != null) {
                chatRoomInfo.setAtInfo(null);
                BaseMsg baseMsg2 = hx7Var.a;
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

    public mt7(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.e = new kx7();
        this.f = new a(this);
        this.g = new b(this, 2921773);
        this.d = context;
    }

    public void g(List<ChatRoomInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.b.clear();
            for (ChatRoomInfo chatRoomInfo : list) {
                this.b.put(Long.valueOf(chatRoomInfo.getRoomId()), chatRoomInfo);
            }
            if (MessageManager.getInstance().hasListener(2921766)) {
                MessageManager.getInstance().unRegisterListener(this.g);
            }
            MessageManager.getInstance().registerListener(this.g);
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
                    if (pollLast.getMsgType() == 10000) {
                        if (this.e.c(pollLast)) {
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
            MessageManager.getInstance().unRegisterListener(this.g);
        }
    }

    public void h(long j, @NonNull TreeSet<ChatMsg> treeSet) {
        ChatRoomInfo chatRoomInfo;
        ChatMsg next;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJL(1048579, this, j, treeSet) == null) && !treeSet.isEmpty() && (chatRoomInfo = this.b.get(Long.valueOf(j))) != null) {
            List<ChatMsg> e = e(treeSet);
            if (ListUtils.isEmpty(e)) {
                return;
            }
            int i = 0;
            ChatMsg chatMsg = e.get(0);
            if (chatMsg == null) {
                return;
            }
            chatMsg.setMsgTime(kx7.f(chatMsg));
            if (chatMsg.getMsgTime() <= chatRoomInfo.getTimestamp()) {
                return;
            }
            Iterator<ChatMsg> it = treeSet.iterator();
            while (it.hasNext() && ((next = it.next()) == null || next.getMsgTime() <= chatRoomInfo.getTimestamp())) {
                i++;
            }
            ChatRoomInfo p = p(chatMsg, j, e.size() - i);
            if (p == null) {
                return;
            }
            i(p);
            j();
        }
    }

    public final void i(@NonNull ChatRoomInfo chatRoomInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, chatRoomInfo) == null) {
            if (this.a.get(Long.valueOf(chatRoomInfo.getRoomId())) != null) {
                o(chatRoomInfo);
                this.a.put(Long.valueOf(chatRoomInfo.getRoomId()), this.b.get(Long.valueOf(chatRoomInfo.getRoomId())));
            } else if (this.b.containsKey(Long.valueOf(chatRoomInfo.getRoomId()))) {
                o(chatRoomInfo);
                this.a.put(Long.valueOf(chatRoomInfo.getRoomId()), this.b.get(Long.valueOf(chatRoomInfo.getRoomId())));
            }
        }
    }

    @Nullable
    public AtInfo l(@NonNull BaseMsg baseMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, baseMsg)) == null) {
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

    public final void o(@NonNull ChatRoomInfo chatRoomInfo) {
        ChatRoomInfo chatRoomInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, chatRoomInfo) == null) && (chatRoomInfo2 = this.b.get(Long.valueOf(chatRoomInfo.getRoomId()))) != null) {
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
            jg.a().removeCallbacks(this.f);
            jg.a().postDelayed(this.f, chatGroupThreadHold);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!this.a.isEmpty()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921766, new HashMap(this.a)));
            }
            this.a.clear();
        }
    }

    public void n(long j, int i) {
        ChatRoomInfo chatRoomInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) && (chatRoomInfo = this.b.get(Long.valueOf(j))) != null) {
            chatRoomInfo.setUnreadNum(i);
        }
    }

    @Nullable
    public final ChatRoomInfo p(@NonNull ChatMsg chatMsg, long j, int i) {
        InterceptResult invokeCommon;
        BaseMsg d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{chatMsg, Long.valueOf(j), Integer.valueOf(i)})) == null) {
            if (chatMsg.getMsgType() == 10000) {
                d = this.e.e(chatMsg);
            } else {
                d = this.e.d(j, chatMsg);
            }
            return q(d, j, i);
        }
        return (ChatRoomInfo) invokeCommon.objValue;
    }

    public final ChatRoomInfo q(BaseMsg baseMsg, long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{baseMsg, Long.valueOf(j), Integer.valueOf(i)})) == null) {
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
            chatRoomInfo.setAtInfo(l(baseMsg));
            return chatRoomInfo;
        }
        return (ChatRoomInfo) invokeCommon.objValue;
    }
}
