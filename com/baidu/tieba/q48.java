package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.ChatRoomInfoData;
import com.baidu.tieba.immessagecenter.chatgroup.data.AtInfo;
import com.baidu.tieba.immessagecenter.chatgroup.data.AtInfoMsg;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatNewMessage;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class q48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static AtInfo a(@NonNull ChatRoomInfoData.AtInfoData atInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, atInfoData)) == null) {
            AtInfo atInfo = new AtInfo();
            atInfo.setAtCountAll(atInfoData.getAtCountAll());
            atInfo.setAtAllMsgCount(atInfoData.getAtAllMsgCount());
            atInfo.setAtSingleMsgCount(atInfoData.getAtSingleMsgCount());
            atInfo.setAllMsgList(b(atInfoData.getAllMsgList()));
            atInfo.setSingleMsgList(b(atInfoData.getAllSingleList()));
            return atInfo;
        }
        return (AtInfo) invokeL.objValue;
    }

    public static List<AtInfoMsg> b(List<ChatRoomInfoData.AtMsgBaseData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (ChatRoomInfoData.AtMsgBaseData atMsgBaseData : list) {
                if (atMsgBaseData != null) {
                    AtInfoMsg atInfoMsg = new AtInfoMsg();
                    atInfoMsg.setMsgId(atMsgBaseData.getMsgId());
                    atInfoMsg.setMsgKey(atMsgBaseData.getMsgKey());
                    arrayList.add(atInfoMsg);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @NonNull
    public static List<ChatRoomInfo> c(List<ChatRoomInfoData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (ChatRoomInfoData chatRoomInfoData : list) {
                if (chatRoomInfoData != null) {
                    ChatRoomInfo chatRoomInfo = new ChatRoomInfo();
                    chatRoomInfo.setRoomId(chatRoomInfoData.getRoomId());
                    ChatRoomInfoData.ChatroomInfoBasicData chatroomInfoBasicData = chatRoomInfoData.getChatroomInfoBasicData();
                    if (chatroomInfoBasicData != null) {
                        chatRoomInfo.setForumId(String.valueOf(chatroomInfoBasicData.getForumId()));
                        chatRoomInfo.setForumName(chatroomInfoBasicData.getForumName());
                        chatRoomInfo.setName(chatroomInfoBasicData.getName());
                        chatRoomInfo.setAvatar(chatroomInfoBasicData.getAvatar());
                        chatRoomInfo.setUnreadNum(gg.e(chatroomInfoBasicData.getUnreadNum(), 0));
                    }
                    chatRoomInfo.setJumpUrl(chatRoomInfoData.getJumpUrl());
                    if (chatRoomInfoData.getAtInfoData() != null) {
                        chatRoomInfo.setAtInfo(a(chatRoomInfoData.getAtInfoData()));
                    }
                    arrayList.add(chatRoomInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void d(@NonNull ChatRoomInfo chatRoomInfo, @NonNull ChatRoomInfoData chatRoomInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, chatRoomInfo, chatRoomInfoData) == null) {
            ChatRoomInfoData.ChatroomInfoBasicData chatroomInfoBasicData = chatRoomInfoData.getChatroomInfoBasicData();
            if (chatroomInfoBasicData != null) {
                chatroomInfoBasicData.setUnreadNum(String.valueOf(chatRoomInfo.getUnreadNum()));
            }
            ChatRoomInfoData.ChatroomMEMsgInfoData chatroomMEMsgInfoData = chatRoomInfoData.getChatroomMEMsgInfoData();
            ChatNewMessage newMessage = chatRoomInfo.getNewMessage();
            if (chatroomMEMsgInfoData != null && newMessage != null) {
                chatroomMEMsgInfoData.setFromUid(gg.g(newMessage.getFromUid(), 0L));
                chatroomMEMsgInfoData.setFromName(newMessage.getFromName());
                chatroomMEMsgInfoData.setContent(newMessage.getContent());
                chatroomMEMsgInfoData.setMsgId(newMessage.getMsgId());
                if (chatRoomInfo.getAtInfo() != null && chatRoomInfo.getAtInfo().getCountAll() > 0) {
                    chatroomMEMsgInfoData.setSpecialMsg("[有人@我]");
                } else {
                    chatroomMEMsgInfoData.setSpecialMsg("");
                }
            }
        }
    }

    public static String e(@NonNull TbPageContext<?> tbPageContext, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext, str, str2)) == null) {
            String str3 = "";
            if (!StringUtils.isNull(str)) {
                str3 = "" + str + tbPageContext.getString(R.string.obfuscated_res_0x7f0f03ca);
            }
            if (!StringUtils.isNull(str2)) {
                return str3 + str2;
            }
            return str3;
        }
        return (String) invokeLLL.objValue;
    }
}
