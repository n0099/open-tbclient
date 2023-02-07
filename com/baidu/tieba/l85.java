package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedGroupChatListCompleteMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class l85 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l85 l;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedList<ImMessageCenterPojo> a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public int h;
    public boolean i;
    public int j;
    public final CustomMessageListener k;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l85 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l85 l85Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l85Var, Integer.valueOf(i)};
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
            this.a = l85Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001120) {
                this.a.y(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016002) {
                this.a.x(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.v(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.a.A(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                this.a.w(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() != 2016010) {
                if (customResponsedMessage.getCmd() != 2016011) {
                    if (customResponsedMessage.getCmd() != 2008024) {
                        if (customResponsedMessage.getCmd() == 2921767) {
                            this.a.u(customResponsedMessage);
                            return;
                        }
                        return;
                    }
                    this.a.z();
                    return;
                }
                this.a.B();
            } else {
                this.a.C();
            }
        }
    }

    public l85() {
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
        this.a = new LinkedList<>();
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = false;
        this.h = 0;
        this.i = false;
        this.j = 0;
        this.k = new a(this, 0);
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            NewsRemindMessage newsRemindMessage = new NewsRemindMessage();
            newsRemindMessage.setMsgAgreeCount(this.b);
            newsRemindMessage.setMsgAtCount(this.c);
            newsRemindMessage.setMsgReplyCount(this.d);
            newsRemindMessage.setMsgFansCount(this.e);
            newsRemindMessage.setMsgCount(this.f);
            newsRemindMessage.setHasMsgRemind(this.g);
            newsRemindMessage.setChatCount(this.h);
            newsRemindMessage.setHasChatRemind(this.i);
            MessageManager.getInstance().dispatchResponsedMessage(newsRemindMessage);
        }
    }

    public final void p(ResponsedGroupChatListCompleteMessage responsedGroupChatListCompleteMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, responsedGroupChatListCompleteMessage) == null) && responsedGroupChatListCompleteMessage.getType() == 4) {
            if (responsedGroupChatListCompleteMessage.isHasUnreadMsg()) {
                this.i = true;
            } else {
                this.i = false;
            }
            if (!TbSingleton.getInstance().isChatTabPage()) {
                F();
            }
        }
    }

    public final void q(ResponsedGroupChatListCompleteMessage responsedGroupChatListCompleteMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, responsedGroupChatListCompleteMessage) == null) && responsedGroupChatListCompleteMessage.getType() == 5) {
            j(this.a);
            F();
        }
    }

    public final void w(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, customResponsedMessage) == null) {
            this.a.clear();
            j(this.a);
            F();
        }
    }

    public static l85 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (l == null) {
                synchronized (l85.class) {
                    if (l == null) {
                        l = new l85();
                    }
                }
            }
            return l;
        }
        return (l85) invokeV.objValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            k(this.b, this.c, this.d, this.e, this.j);
            j(this.a);
            F();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            k(this.b, this.c, this.d, this.e, this.j);
            j(this.a);
            F();
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.clear();
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = false;
            this.h = 0;
            this.i = false;
            this.j = 0;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921764, Boolean.TRUE));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.j = 0;
            k(this.b, this.c, this.d, this.e, 0);
            j(this.a);
            F();
        }
    }

    public final void A(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            return;
        }
        ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
        List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
        if (responsedMemoryListMessage.getType() != 1 || data == null) {
            return;
        }
        this.a.clear();
        for (ImMessageCenterPojo imMessageCenterPojo : data) {
            if (imMessageCenterPojo != null && l(imMessageCenterPojo)) {
                this.a.add(imMessageCenterPojo);
            }
        }
        j(this.a);
        F();
    }

    public final void o(ResponsedGroupChatListCompleteMessage responsedGroupChatListCompleteMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, responsedGroupChatListCompleteMessage) == null) && responsedGroupChatListCompleteMessage.getType() == 3) {
            String gid = responsedGroupChatListCompleteMessage.getGid();
            if (TextUtils.isEmpty(gid)) {
                return;
            }
            Iterator<ImMessageCenterPojo> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ImMessageCenterPojo next = it.next();
                if (gid.equals(next.getGid())) {
                    this.a.remove(next);
                    break;
                }
            }
            j(this.a);
            F();
        }
    }

    public final void r(ResponsedGroupChatListCompleteMessage responsedGroupChatListCompleteMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, responsedGroupChatListCompleteMessage) == null) && responsedGroupChatListCompleteMessage.getType() == 2) {
            String gid = responsedGroupChatListCompleteMessage.getGid();
            if (TextUtils.isEmpty(gid)) {
                return;
            }
            Iterator<ImMessageCenterPojo> it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ImMessageCenterPojo next = it.next();
                if (gid.equals(next.getGid())) {
                    next.setUnread_count(0);
                    break;
                }
            }
            j(this.a);
            F();
        }
    }

    public final void v(CustomResponsedMessage<?> customResponsedMessage) {
        MemoryChangedMessage memoryChangedMessage;
        ImMessageCenterPojo data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage) && (data = (memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage).getData()) != null && !TextUtils.isEmpty(data.getGid())) {
            if (memoryChangedMessage.getType() == 1) {
                D(this.a, data);
                if (l(data)) {
                    this.a.add(data);
                }
            } else if (memoryChangedMessage.getType() == 2) {
                D(this.a, data);
            }
            j(this.a);
            F();
        }
    }

    public final void D(LinkedList<ImMessageCenterPojo> linkedList, ImMessageCenterPojo imMessageCenterPojo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, linkedList, imMessageCenterPojo) == null) && linkedList != null && linkedList.size() > 0 && imMessageCenterPojo != null) {
            Iterator<ImMessageCenterPojo> it = linkedList.iterator();
            while (it.hasNext()) {
                ImMessageCenterPojo next = it.next();
                if (next != null && next.getGid() == imMessageCenterPojo.getGid()) {
                    it.remove();
                }
            }
        }
    }

    public final void j(List<ImMessageCenterPojo> list) {
        int unread_count;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, list) != null) || list == null) {
            return;
        }
        boolean z = false;
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        for (int i3 = 0; i3 < list.size(); i3++) {
            ImMessageCenterPojo imMessageCenterPojo = list.get(i3);
            if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getLast_content()) && imMessageCenterPojo.getUnread_count() > 0) {
                if (imMessageCenterPojo.getCustomGroupType() != -4 && imMessageCenterPojo.getCustomGroupType() != -7) {
                    if (imMessageCenterPojo.getCustomGroupType() == 2) {
                        if (m85.d().v()) {
                            PersonalSettingItemData a2 = ym7.j().a(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                            if (a2 != null) {
                                if (a2.isAcceptNotify()) {
                                    unread_count = imMessageCenterPojo.getUnread_count();
                                }
                            } else {
                                unread_count = imMessageCenterPojo.getUnread_count();
                            }
                            i += unread_count;
                        }
                    } else if (imMessageCenterPojo.getCustomGroupType() == 4) {
                        if (imMessageCenterPojo.getUserType() == 4) {
                            if (m85.d().v()) {
                                OfficialSettingItemData a3 = xm7.j().a(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
                                if (a3 != null) {
                                    if (a3.isAcceptNotify()) {
                                        unread_count = imMessageCenterPojo.getUnread_count();
                                    }
                                } else {
                                    unread_count = imMessageCenterPojo.getUnread_count();
                                }
                                i += unread_count;
                            }
                        }
                    } else if (imMessageCenterPojo.getCustomGroupType() != -8) {
                        if (imMessageCenterPojo.getCustomGroupType() == 9 && um7.b().d(Long.valueOf(dh.g(imMessageCenterPojo.getGid(), 0L))) && imMessageCenterPojo.getUnread_count() > 0) {
                            i2 += imMessageCenterPojo.getUnread_count();
                        }
                    }
                }
                z2 = true;
            }
        }
        if (m85.d().f() == 0) {
            i = 0;
            i2 = 0;
        }
        if (i > 0 || i2 > 0) {
            z = z2;
        }
        this.h = i;
        this.i = z;
    }

    public final void k(int i, int i2, int i3, int i4, int i5) {
        boolean z;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            boolean z2 = false;
            if (i <= 0 && i2 <= 0 && i3 <= 0 && i4 <= 0 && i5 <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (i > 0) {
                i6 = i + 0;
            } else {
                i6 = 0;
            }
            if (i2 > 0) {
                i6 += i2;
            }
            if (i3 > 0) {
                i6 += i3;
            }
            if (i4 > 0) {
                i6 += i4;
            }
            if (i5 > 0 && !p35.m().i("key_question_msg_no_remind", false)) {
                i6 += i5;
            }
            if (m85.d().f() == 0) {
                i6 = 0;
            }
            if (i6 > 0) {
                z2 = z;
            }
            this.g = z2;
            this.f = i6;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.j = i5;
        }
    }

    public final boolean l(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && ((!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || !TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) && imMessageCenterPojo.getLast_content_time() != 0)) {
                if (imMessageCenterPojo.getCustomGroupType() == -4) {
                    return true;
                }
                if ((imMessageCenterPojo.getCustomGroupType() == 4 && imMessageCenterPojo.getUserType() == 4) || imMessageCenterPojo.getCustomGroupType() == -8 || imMessageCenterPojo.getCustomGroupType() == -7) {
                    return true;
                }
                if (imMessageCenterPojo.getCustomGroupType() == 2 && (imMessageCenterPojo.getIsFriend() == 1 || imMessageCenterPojo.getIsFriend() == 2 || 1 == imMessageCenterPojo.getShowOutOfStranger())) {
                    if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                        return false;
                    }
                    return true;
                } else if (imMessageCenterPojo.getCustomGroupType() == 9 && imMessageCenterPojo.getIs_hidden() == 0 && (!TextUtils.isEmpty(imMessageCenterPojo.getNameShow()) || !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void n(ResponsedGroupChatListCompleteMessage responsedGroupChatListCompleteMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, responsedGroupChatListCompleteMessage) == null) && responsedGroupChatListCompleteMessage.getType() == 1) {
            List<ImMessageCenterPojo> listInfo = responsedGroupChatListCompleteMessage.getListInfo();
            if (ListUtils.isEmpty(listInfo)) {
                return;
            }
            for (ImMessageCenterPojo imMessageCenterPojo : listInfo) {
                if (this.a.contains(imMessageCenterPojo)) {
                    this.a.remove(imMessageCenterPojo);
                }
            }
            for (ImMessageCenterPojo imMessageCenterPojo2 : listInfo) {
                if (imMessageCenterPojo2 != null && l(imMessageCenterPojo2)) {
                    this.a.add(imMessageCenterPojo2);
                }
            }
            j(this.a);
            F();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            E();
            MessageManager.getInstance().registerStickyMode(2921002);
            MessageManager.getInstance().registerListener(2001120, this.k);
            MessageManager.getInstance().registerListener(2016002, this.k);
            MessageManager.getInstance().registerListener(2016004, this.k);
            MessageManager.getInstance().registerListener(2016001, this.k);
            MessageManager.getInstance().registerListener(2016007, this.k);
            MessageManager.getInstance().registerListener(2016011, this.k);
            MessageManager.getInstance().registerListener(2016010, this.k);
            MessageManager.getInstance().registerListener(2008024, this.k);
            MessageManager.getInstance().registerListener(2921767, this.k);
            t();
        }
    }

    public final void u(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof ResponsedGroupChatListCompleteMessage)) {
            return;
        }
        ResponsedGroupChatListCompleteMessage responsedGroupChatListCompleteMessage = (ResponsedGroupChatListCompleteMessage) customResponsedMessage;
        int type = responsedGroupChatListCompleteMessage.getType();
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type != 4) {
                        if (type == 5) {
                            q(responsedGroupChatListCompleteMessage);
                            return;
                        }
                        return;
                    }
                    p(responsedGroupChatListCompleteMessage);
                    return;
                }
                o(responsedGroupChatListCompleteMessage);
                return;
            }
            r(responsedGroupChatListCompleteMessage);
            return;
        }
        n(responsedGroupChatListCompleteMessage);
    }

    public final void x(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void y(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, responsedMessage) != null) || responsedMessage == null) {
            return;
        }
        if (!(responsedMessage instanceof NewsNotifyMessage)) {
            BdLog.e("transform error");
            return;
        }
        NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
        k(newsNotifyMessage.getMsgAgree(), newsNotifyMessage.getMsgAtme(), newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgFans(), newsNotifyMessage.getMsgInvitation());
        F();
    }
}
