package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.DataExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class ReMsgInfo extends BaseInfo<IChatRoomEnterListener.ReMsgInfo> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String content;
    public long msgId;
    public String msgKey;
    public int msgType;
    public String nickname;
    public int sdkMsgType;
    public long uid;
    public String url;

    public ReMsgInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public static ReMsgInfo create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new ReMsgInfo();
        }
        return (ReMsgInfo) invokeV.objValue;
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.content;
        }
        return (String) invokeV.objValue;
    }

    public long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.msgId;
        }
        return invokeV.longValue;
    }

    public String getMsgKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.msgKey;
        }
        return (String) invokeV.objValue;
    }

    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.msgType;
        }
        return invokeV.intValue;
    }

    public String getNickname() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.nickname;
        }
        return (String) invokeV.objValue;
    }

    public int getSdkMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.sdkMsgType;
        }
        return invokeV.intValue;
    }

    public long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.uid;
        }
        return invokeV.longValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.url;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static ReMsgInfo create(@NonNull BaseMsg baseMsg, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, baseMsg, str)) == null) {
            ReMsgInfo reMsgInfo = new ReMsgInfo();
            CommonMsgField commonMsgField = baseMsg.getCommonMsgField();
            reMsgInfo.msgType = commonMsgField.getType();
            reMsgInfo.sdkMsgType = 0;
            reMsgInfo.uid = commonMsgField.getUserId();
            reMsgInfo.nickname = commonMsgField.getUserName();
            reMsgInfo.msgId = commonMsgField.getMsgId();
            reMsgInfo.msgKey = commonMsgField.getMsgKey();
            reMsgInfo.content = str;
            return reMsgInfo;
        }
        return (ReMsgInfo) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseInfo
    @NonNull
    public IChatRoomEnterListener.ReMsgInfo createSdkInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            IChatRoomEnterListener.ReMsgInfo reMsgInfo = new IChatRoomEnterListener.ReMsgInfo();
            reMsgInfo.msgType = String.valueOf(this.sdkMsgType);
            reMsgInfo.bdUk = BIMManager.getBdUKFromBdUid(String.valueOf(this.uid));
            reMsgInfo.nickName = this.nickname;
            reMsgInfo.msgId = String.valueOf(this.msgId);
            reMsgInfo.msgKey = this.msgKey;
            reMsgInfo.url = this.url;
            reMsgInfo.content = this.content;
            HashMap hashMap = new HashMap();
            hashMap.put("msg_type", Integer.valueOf(this.msgType));
            reMsgInfo.ext = DataExt.toJson(hashMap);
            return reMsgInfo;
        }
        return (IChatRoomEnterListener.ReMsgInfo) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseInfo
    public void fromSdkInfo(@NonNull IChatRoomEnterListener.ReMsgInfo reMsgInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, reMsgInfo) == null) {
            this.msgType = ((Long) DataExt.toMap(reMsgInfo.ext).get("msg_type")).intValue();
            this.sdkMsgType = Integer.parseInt(reMsgInfo.msgType);
            this.uid = Long.parseLong(BIMManager.getBdUidFromBdUK(reMsgInfo.bdUk));
            this.nickname = reMsgInfo.nickName;
            this.msgId = Long.parseLong(reMsgInfo.msgId);
            this.msgKey = reMsgInfo.msgKey;
            this.url = reMsgInfo.url;
            this.content = reMsgInfo.content;
        }
    }
}
