package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.FilterUEGPersonMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.immessagecenter.mention.FeedData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class mo7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        boolean a(ChatMessage chatMessage, ImMessageCenterPojo imMessageCenterPojo);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(String str, List<CommonMsgPojo> list);

        void b(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z);
    }

    /* loaded from: classes5.dex */
    public interface c {
        boolean a(String str);
    }

    public static boolean a(ChatMessage chatMessage, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, chatMessage, i)) == null) {
            if (chatMessage.getMsgType() == 11) {
                return false;
            }
            if (i == 4) {
                return hs7.v(chatMessage);
            }
            if (chatMessage.getUserInfo() == null || chatMessage.getUserInfo().getUserId() == null || !chatMessage.getUserInfo().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static CommonMsgPojo b(List<CommonMsgPojo> list, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, list, j)) == null) {
            for (CommonMsgPojo commonMsgPojo : list) {
                if (commonMsgPojo.getMid() == j) {
                    return commonMsgPojo;
                }
            }
            return null;
        }
        return (CommonMsgPojo) invokeLJ.objValue;
    }

    public static void c(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("agree");
            int optInt2 = jSONObject.optInt("replyme");
            jSONObject.optInt(FeedData.TYPE_ZAN);
            int optInt3 = jSONObject.optInt("fans");
            int optInt4 = jSONObject.optInt("gift");
            int optInt5 = jSONObject.optInt("godfeed");
            int optInt6 = jSONObject.optInt("atme");
            int optInt7 = jSONObject.optInt("feed");
            int i = 0;
            if (jSONObject.optInt("is_invite") == 1) {
                z = true;
            } else {
                z = false;
            }
            int optInt8 = jSONObject.optInt("new_invite_num");
            m35.m().z(m35.q("msg_tab_entrance_invitation_answer_unread_num"), optInt8);
            if (z && !m35.m().i(m35.q("msg_tab_entrance_invitation_answer"), false)) {
                m35.m().w(m35.q("msg_tab_entrance_invitation_answer"), true);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921726, Boolean.TRUE));
            }
            if (optInt7 > 0) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2012118));
            }
            if (optInt5 > 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016324, Integer.valueOf(optInt5)));
            }
            if (optInt >= 0 && optInt2 >= 0 && optInt3 >= 0 && optInt6 >= 0 && optInt4 >= 0) {
                if (k85.d().f() > 0) {
                    i = optInt4;
                }
                if (currentAccount != null && currentAccount.length() > 0) {
                    int w = i85.h0().w();
                    int v = i85.h0().v();
                    i85.h0().k0(jSONObject);
                    i85.h0().e0(optInt8);
                    i85.h0().U(optInt, optInt2, optInt6, w, optInt3, v, i);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void d(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, b bVar, c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{groupMsgData, imMessageCenterPojo, bVar, cVar, Boolean.valueOf(z)}) == null) {
            e(groupMsgData, imMessageCenterPojo, bVar, cVar, z, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0216  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, b bVar, c cVar, boolean z, a aVar) {
        ImMessageCenterPojo imMessageCenterPojo2;
        boolean z2;
        int i;
        String str;
        boolean z3;
        boolean z4;
        Iterator<ChatMessage> it;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{groupMsgData, imMessageCenterPojo, bVar, cVar, Boolean.valueOf(z), aVar}) == null) {
            a aVar2 = aVar;
            String valueOf = String.valueOf(groupMsgData.getGroupInfo().getGroupId());
            int customType = groupMsgData.getGroupInfo().getCustomType();
            int userType = groupMsgData.getGroupInfo().getUserType();
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage != null && listMessage.size() > 0) {
                LinkedList linkedList = new LinkedList();
                LinkedList linkedList2 = new LinkedList();
                if (imMessageCenterPojo == null) {
                    imMessageCenterPojo2 = new ImMessageCenterPojo();
                    imMessageCenterPojo2.setCustomGroupType(customType);
                    imMessageCenterPojo2.setGid(valueOf);
                } else {
                    imMessageCenterPojo2 = imMessageCenterPojo;
                }
                imMessageCenterPojo2.setUserType(userType);
                int unread_count = imMessageCenterPojo2.getUnread_count();
                long pulled_msgId = imMessageCenterPojo2.getPulled_msgId();
                long last_rid = imMessageCenterPojo2.getLast_rid();
                Iterator<ChatMessage> it2 = listMessage.iterator();
                CommonMsgPojo commonMsgPojo = null;
                while (it2.hasNext()) {
                    ChatMessage next = it2.next();
                    if (pulled_msgId < next.getMsgId()) {
                        pulled_msgId = next.getMsgId();
                    }
                    if (aVar2 != null && aVar2.a(next, imMessageCenterPojo2)) {
                        it = it2;
                        j = pulled_msgId;
                    } else {
                        next.setLocalData(new MsgLocalData());
                        it = it2;
                        next.getLocalData().setStatus((short) 3);
                        CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(next);
                        commonMsgPojo2.setCustomGroupType(customType);
                        j = pulled_msgId;
                        if (next.getMsgType() == 31) {
                            CommonMsgPojo b2 = b(linkedList, commonMsgPojo2.getIllegalMsgId());
                            if (b2 != null) {
                                linkedList.remove(b2);
                                if (b2.getRid() > last_rid) {
                                    unread_count--;
                                }
                                if (commonMsgPojo != null && commonMsgPojo.getMid() == b2.getMid()) {
                                    if (linkedList.isEmpty()) {
                                        commonMsgPojo = null;
                                    } else {
                                        commonMsgPojo2 = (CommonMsgPojo) linkedList.getLast();
                                        commonMsgPojo = commonMsgPojo2;
                                    }
                                }
                            } else {
                                linkedList2.add(commonMsgPojo2);
                            }
                        } else {
                            if (a(next, customType)) {
                                commonMsgPojo2.setRead_flag(0);
                            } else {
                                if (commonMsgPojo2.getRid() > last_rid) {
                                    unread_count++;
                                }
                                commonMsgPojo2.setRead_flag(1);
                            }
                            linkedList.add(commonMsgPojo2);
                            if (commonMsgPojo != null && commonMsgPojo.getRid() >= commonMsgPojo2.getRid()) {
                            }
                            commonMsgPojo = commonMsgPojo2;
                        }
                    }
                    aVar2 = aVar;
                    it2 = it;
                    pulled_msgId = j;
                }
                if (commonMsgPojo != null) {
                    commonMsgPojo.checkRidAndSelf();
                }
                if (cVar != null && cVar.a(valueOf)) {
                    unread_count = 0;
                }
                imMessageCenterPojo2.setUnread_count(unread_count);
                imMessageCenterPojo2.setPulled_msgId(pulled_msgId);
                if ((customType == 2 || customType == 4) && commonMsgPojo != null && commonMsgPojo.getPrivateOtherUser_infoObj() != null) {
                    String portrait = commonMsgPojo.getPrivateOtherUser_infoObj().getPortrait();
                    String userName = commonMsgPojo.getPrivateOtherUser_infoObj().getUserName();
                    if (!TextUtils.isEmpty(portrait)) {
                        imMessageCenterPojo2.setGroup_head(portrait);
                    }
                    if (!TextUtils.isEmpty(userName)) {
                        imMessageCenterPojo2.setGroup_name(userName);
                    }
                    imMessageCenterPojo2.setNameShow(commonMsgPojo.getPrivateOtherUser_infoObj().getName_show());
                    imMessageCenterPojo2.setBjhAvatar(commonMsgPojo.getPrivateOtherUser_infoObj().getImBjhAvatar());
                }
                if (commonMsgPojo != null && commonMsgPojo.getRid() >= last_rid) {
                    if (commonMsgPojo.getRid() > last_rid) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    UserData user_infoObj = commonMsgPojo.getUser_infoObj();
                    if (user_infoObj != null) {
                        str = user_infoObj.getName_show();
                        if (TbadkCoreApplication.isLogin()) {
                            String currentAccount = TbadkCoreApplication.getCurrentAccount();
                            if (!TextUtils.isEmpty(currentAccount) && currentAccount.equals(String.valueOf(user_infoObj.getUserId()))) {
                                z3 = true;
                                String B = hs7.B(commonMsgPojo.getMsg_type(), commonMsgPojo.getContent());
                                imMessageCenterPojo2.setLastContentRawData(commonMsgPojo.getContent());
                                imMessageCenterPojo2.setLast_rid(commonMsgPojo.getRid());
                                imMessageCenterPojo2.setSid(commonMsgPojo.getSid());
                                imMessageCenterPojo2.setLastTaskId(commonMsgPojo.getTaskId());
                                MessageUtils.makeNewTaskId(imMessageCenterPojo2, linkedList);
                                imMessageCenterPojo2.setLastServiceId(commonMsgPojo.getServiceId());
                                MessageUtils.makeNewServiceId(imMessageCenterPojo2, linkedList);
                                imMessageCenterPojo2.setLast_content(B);
                                imMessageCenterPojo2.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                                imMessageCenterPojo2.setLast_user_name(str);
                                imMessageCenterPojo2.setPushIds(commonMsgPojo.getPushIds());
                                if (imMessageCenterPojo2.getUnread_count() > 0 || z3 || z2) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    imMessageCenterPojo2.setIs_hidden(0);
                                }
                                imMessageCenterPojo2.setIsFriend(commonMsgPojo.getIsFriend());
                                imMessageCenterPojo2.setFollowStatus(commonMsgPojo.getFollowStatus());
                                imMessageCenterPojo2.setSend_status(3);
                                BdLog.i("send message status 3");
                            }
                        }
                    } else {
                        str = "";
                    }
                    z3 = false;
                    String B2 = hs7.B(commonMsgPojo.getMsg_type(), commonMsgPojo.getContent());
                    imMessageCenterPojo2.setLastContentRawData(commonMsgPojo.getContent());
                    imMessageCenterPojo2.setLast_rid(commonMsgPojo.getRid());
                    imMessageCenterPojo2.setSid(commonMsgPojo.getSid());
                    imMessageCenterPojo2.setLastTaskId(commonMsgPojo.getTaskId());
                    MessageUtils.makeNewTaskId(imMessageCenterPojo2, linkedList);
                    imMessageCenterPojo2.setLastServiceId(commonMsgPojo.getServiceId());
                    MessageUtils.makeNewServiceId(imMessageCenterPojo2, linkedList);
                    imMessageCenterPojo2.setLast_content(B2);
                    imMessageCenterPojo2.setLast_content_time(commonMsgPojo.getCreate_time() * 1000);
                    imMessageCenterPojo2.setLast_user_name(str);
                    imMessageCenterPojo2.setPushIds(commonMsgPojo.getPushIds());
                    if (imMessageCenterPojo2.getUnread_count() > 0) {
                        z4 = false;
                        if (z4) {
                        }
                        imMessageCenterPojo2.setIsFriend(commonMsgPojo.getIsFriend());
                        imMessageCenterPojo2.setFollowStatus(commonMsgPojo.getFollowStatus());
                        imMessageCenterPojo2.setSend_status(3);
                        BdLog.i("send message status 3");
                    }
                    z4 = true;
                    if (z4) {
                    }
                    imMessageCenterPojo2.setIsFriend(commonMsgPojo.getIsFriend());
                    imMessageCenterPojo2.setFollowStatus(commonMsgPojo.getFollowStatus());
                    imMessageCenterPojo2.setSend_status(3);
                    BdLog.i("send message status 3");
                } else {
                    z2 = false;
                }
                if (z) {
                    i = 0;
                } else if (unread_count > 0) {
                    i = 1;
                } else {
                    i = 2;
                }
                if (bVar != null) {
                    bVar.a(valueOf, linkedList);
                    bVar.b(imMessageCenterPojo2, i, z2);
                }
                if (!linkedList2.isEmpty()) {
                    MessageManager.getInstance().sendMessageFromBackground(new FilterUEGPersonMessage(linkedList2));
                }
            }
        }
    }
}
