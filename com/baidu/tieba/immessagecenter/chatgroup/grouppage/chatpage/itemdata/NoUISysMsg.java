package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata;

import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.co8;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class NoUISysMsg extends BaseSysMsg {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId ADAPTER_TYPE;
    public static final List<Integer> MSG_TYPE_LIST;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    @SerializedName("chatroom_info")
    public BaseSysMsg.ChatRoomInfo chatroomInfo;
    @Nullable
    @SerializedName("mask_info")
    public co8 maskInfo;
    @Nullable
    @SerializedName("user_to")
    public BaseSysMsg.User userTo;

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg
    public boolean isNoUISysMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(903531034, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/itemdata/NoUISysMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(903531034, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/itemdata/NoUISysMsg;");
                return;
            }
        }
        ADAPTER_TYPE = BdUniqueId.gen();
        MSG_TYPE_LIST = Arrays.asList(Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE_ALL), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_MUZZLE_ALL), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_FROZEN), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_UN_FROZEN), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_THRESHOLD_POST), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_THRESHOLD_VIEW), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_ONLY_MANAGER_CAN_TALK), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_START_EGG_RAIN));
    }

    public NoUISysMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Nullable
    public BaseSysMsg.ChatRoomInfo getChatroomInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.chatroomInfo;
        }
        return (BaseSysMsg.ChatRoomInfo) invokeV.objValue;
    }

    @Nullable
    public co8 getMaskInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.maskInfo;
        }
        return (co8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return getSysMsgType();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg, com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.yn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ADAPTER_TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Nullable
    public BaseSysMsg.User getUserTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.userTo;
        }
        return (BaseSysMsg.User) invokeV.objValue;
    }
}
