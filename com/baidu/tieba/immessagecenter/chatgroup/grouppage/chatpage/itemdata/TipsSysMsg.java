package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbEnum;
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
public class TipsSysMsg extends BaseSysMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId ADAPTER_TYPE;
    public static final int MSG_CONTENT_TYPE_SYSTEM_MANAGER_TIPS = -7014;
    public static final List<Integer> MSG_TYPE_LIST;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("msg_content")
    public String msgContent;
    @SerializedName("managerTips")
    public String tips;
    @Nullable
    @SerializedName("user_to")
    public BaseSysMsg.User userTo;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1482201705, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/itemdata/TipsSysMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1482201705, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/itemdata/TipsSysMsg;");
                return;
            }
        }
        ADAPTER_TYPE = BdUniqueId.gen();
        MSG_TYPE_LIST = Arrays.asList(-7014, Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_CURRENCY_TIPS), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_TIPS));
    }

    @NonNull
    public String getTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (-7014 == getSysMsgType()) {
                if (TextUtils.isEmpty(this.tips)) {
                    return "";
                }
                return this.tips;
            } else if (7017 == getSysMsgType()) {
                if (TextUtils.isEmpty(this.msgContent)) {
                    return "";
                }
                return this.msgContent;
            } else if (getMsgConf() == null) {
                return "";
            } else {
                return getMsgConf().getLowVersionContent();
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg
    public boolean isIgnore() {
        InterceptResult invokeV;
        BaseSysMsg.User user;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (getSysMsgType() == -7014) {
                return false;
            }
            if (getSysMsgType() == 7017 && (user = this.userTo) != null) {
                return !TextUtils.equals(String.valueOf(user.getUserId()), TbadkCoreApplication.getCurrentAccount());
            }
            if (getMsgConf() != null && getMsgConf().getLowVersionType() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public TipsSysMsg() {
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

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg, com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.wn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ADAPTER_TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
