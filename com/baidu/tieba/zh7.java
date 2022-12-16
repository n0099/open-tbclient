package com.baidu.tieba;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.ImageMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.VoiceMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class zh7 {
    public static /* synthetic */ Interceptable $ic;
    public static final SparseArray<Class<? extends BaseMsg>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948360032, "Lcom/baidu/tieba/zh7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948360032, "Lcom/baidu/tieba/zh7;");
                return;
            }
        }
        SparseArray<Class<? extends BaseMsg>> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(1, TextMsg.class);
        a.put(3, VoiceMsg.class);
        a.put(2, ImageMsg.class);
    }

    @Nullable
    public static BaseMsg a(long j, @NonNull ChatMsg chatMsg) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65537, null, j, chatMsg)) == null) {
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
            baseChatMsg.fromSdkMsg(chatMsg);
            baseChatMsg.setCommonMsgField(commonMsgField);
            baseChatMsg.setSdkMsg(chatMsg);
            return baseChatMsg;
        }
        return (BaseMsg) invokeJL.objValue;
    }

    @Nullable
    public static BaseSysMsg b(@NonNull ChatMsg chatMsg) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, chatMsg)) == null) {
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

    public static long c(@NonNull ChatMsg chatMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, chatMsg)) == null) {
            long millis = TimeUnit.MICROSECONDS.toMillis(chatMsg.getMsgId());
            if (millis == 0) {
                return System.currentTimeMillis();
            }
            return millis;
        }
        return invokeL.longValue;
    }
}
