package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata;

import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.Action;
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
public class RecallSysMsg extends BaseSysMsg {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId ADAPTER_TYPE;
    public static final List<Integer> MSG_TYPE_LIST;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("recall_msgid")
    public long recallMsgId;
    @SerializedName("recall_msgkey")
    public String recallMsgKey;
    @SerializedName("user_to")
    public BaseSysMsg.User userTo;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2058149474, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/itemdata/RecallSysMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2058149474, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/itemdata/RecallSysMsg;");
                return;
            }
        }
        ADAPTER_TYPE = BdUniqueId.gen();
        MSG_TYPE_LIST = Arrays.asList(Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_RECALL_MSG), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_RECALL_MSG_PERSONAL));
    }

    public RecallSysMsg() {
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

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return getSysMsgType();
        }
        return invokeV.intValue;
    }

    public long getRecallMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.recallMsgId;
        }
        return invokeV.longValue;
    }

    public String getRecallMsgKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.recallMsgKey;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg, com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.xn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ADAPTER_TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public BaseSysMsg.User getUserTo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.userTo;
        }
        return (BaseSysMsg.User) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
    @Nullable
    public Action provideAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return Action.a(this.recallMsgId, this.recallMsgKey, Action.Op.DELETE, null);
        }
        return (Action) invokeV.objValue;
    }
}
