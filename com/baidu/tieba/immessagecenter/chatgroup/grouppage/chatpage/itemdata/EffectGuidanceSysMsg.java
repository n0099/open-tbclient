package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.Action;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.ChatMsgProcessor;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.AbilityEffectItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes6.dex */
public class EffectGuidanceSysMsg extends NoUISysMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId ADAPTER_TYPE;
    public static final int MSG_TYPE = 7019;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("one_key_conversation")
    public AbilityEffectItem oneKeyConversation;

    /* loaded from: classes6.dex */
    public class a implements Action.a<BaseMsg> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EffectGuidanceSysMsg a;

        public a(EffectGuidanceSysMsg effectGuidanceSysMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {effectGuidanceSysMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = effectGuidanceSysMsg;
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.Action.a
        @WorkerThread
        public void a(@NonNull Action.Op op, @Nullable BaseMsg baseMsg, @NonNull ChatMsgProcessor.j jVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, op, baseMsg, jVar) == null) && baseMsg != null) {
                baseMsg.getCommonMsgField().setAbilityEffectItem(this.a.oneKeyConversation);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-960577114, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/itemdata/EffectGuidanceSysMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-960577114, "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/chatpage/itemdata/EffectGuidanceSysMsg;");
                return;
            }
        }
        ADAPTER_TYPE = BdUniqueId.gen();
    }

    public EffectGuidanceSysMsg() {
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

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.NoUISysMsg, com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
    public int getMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return getSysMsgType();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.NoUISysMsg, com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysMsg, com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.bn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ADAPTER_TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg
    @Nullable
    public Action provideAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BaseSysMsg.a objMsgInfo = getObjMsgInfo();
            if (objMsgInfo == null) {
                return null;
            }
            return Action.a(objMsgInfo.a(), objMsgInfo.b(), Action.Op.UPDATE, new a(this));
        }
        return (Action) invokeV.objValue;
    }
}
