package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.NoticeModifySysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.RecallSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ShareForumSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.ShareThreadSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.VoiceMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class or7 {
    public static /* synthetic */ Interceptable $ic;
    public static final SparseArray<Class<? extends BaseMsg>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948041941, "Lcom/baidu/tieba/or7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948041941, "Lcom/baidu/tieba/or7;");
                return;
            }
        }
        SparseArray<Class<? extends BaseMsg>> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(1, TextMsg.class);
        a.put(3, VoiceMsg.class);
        a.put(2, ImageMsg.class);
        a.put(101, TextGenImageMsg.class);
        a.put(7009, ShareForumSysMsg.class);
        a.put(7010, ShareThreadSysMsg.class);
        a.put(7001, NoticeModifySysMsg.class);
        f(RecallSysMsg.MSG_TYPE_LIST, RecallSysMsg.class);
    }

    @Nullable
    public static String a(List<GroupChatRoomPojo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                GroupChatRoomPojo groupChatRoomPojo = list.get(i);
                HashMap hashMap = new HashMap();
                hashMap.put("room_id", Long.valueOf(groupChatRoomPojo.getRoomId()));
                hashMap.put("msg_id", String.valueOf(groupChatRoomPojo.getLatestMsgId()));
                arrayList.add(hashMap);
            }
            if (ListUtils.isEmpty(arrayList)) {
                return null;
            }
            return DataExt.toJson(arrayList);
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(ChatMsg chatMsg) {
        InterceptResult invokeL;
        BaseSysMsg d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, chatMsg)) == null) {
            if (chatMsg == null || (d = d(chatMsg)) == null || d.getMsgConf() == null || !d.getMsgConf().isVisible()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static long e(@NonNull ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, chatMsg)) == null) {
            long millis = TimeUnit.MICROSECONDS.toMillis(chatMsg.getMsgId());
            if (millis == 0) {
                return System.currentTimeMillis();
            }
            return millis;
        }
        return invokeL.longValue;
    }

    @Nullable
    public static BaseMsg c(long j, @NonNull ChatMsg chatMsg) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65539, null, j, chatMsg)) == null) {
            if (TextUtils.isEmpty(chatMsg.getChatRoomContentExt())) {
                return null;
            }
            CommonMsgField commonMsgField = (CommonMsgField) DataExt.toEntity(chatMsg.getChatRoomContentExt(), CommonMsgField.class);
            commonMsgField.setMsgId(chatMsg.getMsgId());
            commonMsgField.setMsgKey(chatMsg.getMsgKey());
            commonMsgField.setRoomId(j);
            commonMsgField.setUserId(Long.parseLong(chatMsg.getSenderUid()));
            commonMsgField.setUserName(chatMsg.getNickName());
            commonMsgField.setPortrait(chatMsg.getPortrait());
            if (commonMsgField.getContent() == null) {
                commonMsgField.setContent(new HashMap());
            }
            BaseChatMsg baseChatMsg = (BaseChatMsg) DataExt.toEntity(commonMsgField.getContent(), a.get(commonMsgField.getType()));
            baseChatMsg.parseSdkMsg4Base(chatMsg);
            baseChatMsg.fromSdkMsg(chatMsg);
            baseChatMsg.setCommonMsgField(commonMsgField);
            baseChatMsg.setSdkMsg(chatMsg);
            return baseChatMsg;
        }
        return (BaseMsg) invokeJL.objValue;
    }

    @Nullable
    public static BaseSysMsg d(@NonNull ChatMsg chatMsg) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, chatMsg)) == null) {
            if (TextUtils.isEmpty(chatMsg.getMsgContent())) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(chatMsg.getMsgContent());
                int optInt = jSONObject.optInt(TableDefine.MessageColumns.COLUME_SERVICE_TYPE);
                String optString = jSONObject.optString("service_info");
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                BaseSysMsg baseSysMsg = (BaseSysMsg) DataExt.toEntity(optString, a.get(optInt));
                baseSysMsg.setSdkMsg(chatMsg);
                baseSysMsg.parseSdkMsg4Base(chatMsg);
                if (!baseSysMsg.isConvertToNormalMsg()) {
                    z = true;
                } else {
                    z = false;
                }
                baseSysMsg.setSysMsg(z);
                CommonMsgField commonMsgField = new CommonMsgField();
                commonMsgField.setMsgId(chatMsg.getMsgId());
                commonMsgField.setMsgKey(chatMsg.getMsgKey());
                commonMsgField.setType(optInt);
                commonMsgField.setRoomId(baseSysMsg.getRoomId());
                BaseSysMsg.User userFrom = baseSysMsg.getUserFrom();
                if (userFrom != null) {
                    commonMsgField.setUserId(userFrom.getUserId());
                    commonMsgField.setUserName(userFrom.getUsername());
                    commonMsgField.setPortrait(userFrom.getPortrait());
                    commonMsgField.setRole(userFrom.getRole());
                    commonMsgField.setLevel(userFrom.getLevel());
                }
                baseSysMsg.setCommonMsgField(commonMsgField);
                return baseSysMsg;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (BaseSysMsg) invokeL.objValue;
    }

    public static void f(@NonNull List<Integer> list, @NonNull Class<? extends BaseMsg> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, list, cls) == null) {
            for (Integer num : list) {
                a.put(num.intValue(), cls);
            }
        }
    }
}
