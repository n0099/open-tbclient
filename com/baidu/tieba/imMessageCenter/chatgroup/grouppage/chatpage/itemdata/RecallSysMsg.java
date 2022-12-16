package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes4.dex */
public class RecallSysMsg extends BaseSysMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId ADAPTER_TYPE;
    public static final int MSG_TYPE = 7002;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("recall_msgid")
    public long recallMsgId;
    @SerializedName("recall_msgkey")
    public String recallMsgKey;
    @SerializedName("user_to")
    public BaseSysMsg.User userTo;

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg
    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? MSG_TYPE : invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(801193374, "Lcom/baidu/tieba/imMessageCenter/chatgroup/grouppage/chatpage/itemdata/RecallSysMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(801193374, "Lcom/baidu/tieba/imMessageCenter/chatgroup/grouppage/chatpage/itemdata/RecallSysMsg;");
                return;
            }
        }
        ADAPTER_TYPE = BdUniqueId.gen();
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

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseSysMsg, com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.xn
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

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseSysMsg
    @Nullable
    public BaseMsg tryCreateRecalledMsgShadow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            CommonMsgField commonMsgField = new CommonMsgField();
            commonMsgField.setMsgId(this.recallMsgId);
            commonMsgField.setMsgKey(this.recallMsgKey);
            BaseMsg baseMsg = new BaseMsg(this) { // from class: com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.RecallSysMsg.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RecallSysMsg this$0;

                @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg
                public int getMsgType() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                        return 0;
                    }
                    return invokeV2.intValue;
                }

                @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg
                @NonNull
                public CharSequence getThumbnailText() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "" : (CharSequence) invokeV2.objValue;
                }

                @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.xn
                public BdUniqueId getType() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return null;
                    }
                    return (BdUniqueId) invokeV2.objValue;
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }
            };
            baseMsg.setCommonMsgField(commonMsgField);
            return baseMsg;
        }
        return (BaseMsg) invokeV.objValue;
    }
}
