package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base;

import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class BaseChatMsg<SdkMsg extends ChatMsg> extends BaseMsg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public abstract SdkMsg createSdkMsg();

    public abstract void fromSdkMsg(@NonNull SdkMsg sdkmsg);

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.xn
    public abstract /* synthetic */ BdUniqueId getType();

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

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg
    @NonNull
    public SdkMsg getSdkMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (SdkMsg) super.getSdkMsg();
        }
        return (SdkMsg) invokeV.objValue;
    }
}
