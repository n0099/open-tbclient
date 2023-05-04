package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class BaseChatMsg<SdkMsg extends ChatMsg> extends BaseMsg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public abstract SdkMsg createSdkMsg();

    public abstract void fromSdkMsg(@NonNull SdkMsg sdkmsg);

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.in
    public abstract /* synthetic */ BdUniqueId getType();

    public boolean needBubbleInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public BaseChatMsg() {
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

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
    @NonNull
    public SdkMsg getSdkMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (SdkMsg) super.getSdkMsg();
        }
        return (SdkMsg) invokeV.objValue;
    }

    public void setMockSenderInfo(long j, @NonNull String str, @NonNull String str2, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            CommonMsgField create = CommonMsgField.create();
            create.setUserId(j);
            create.setUserName(str);
            create.setPortrait(str2);
            create.setRole(i);
            create.setRobotRole(i2);
            create.setLevel(i3);
            setCommonMsgField(create);
        }
    }
}
