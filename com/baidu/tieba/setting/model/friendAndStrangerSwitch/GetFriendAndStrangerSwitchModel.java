package com.baidu.tieba.setting.model.friendAndStrangerSwitch;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.ox4;
import com.baidu.tieba.r9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class GetFriendAndStrangerSwitchModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static int FRIEND_AND_STRANGER_MASK_TYPE = -1;
    public static int FRIEND_PRIVATE_MESSAGE_PUSH_TYPE = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public HttpMessageListener a;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GetFriendAndStrangerSwitchModel getFriendAndStrangerSwitchModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {getFriendAndStrangerSwitchModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof GetFriendAndStrangerSwitchResMsg)) {
                GetFriendAndStrangerSwitchResMsg getFriendAndStrangerSwitchResMsg = (GetFriendAndStrangerSwitchResMsg) httpResponsedMessage;
                int i = getFriendAndStrangerSwitchResMsg.mMaskType;
                if (i > -1) {
                    GetFriendAndStrangerSwitchModel.FRIEND_AND_STRANGER_MASK_TYPE = i;
                    ox4 k = ox4.k();
                    k.w(TbadkCoreApplication.getCurrentAccount() + "key_friend_type", getFriendAndStrangerSwitchResMsg.mMaskType);
                }
                int i2 = getFriendAndStrangerSwitchResMsg.mPushType;
                if (i2 > -1) {
                    GetFriendAndStrangerSwitchModel.FRIEND_PRIVATE_MESSAGE_PUSH_TYPE = i2;
                    ox4 k2 = ox4.k();
                    k2.w(TbadkCoreApplication.getCurrentAccount() + "key_friend_private_message_type", getFriendAndStrangerSwitchResMsg.mPushType);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1499880418, "Lcom/baidu/tieba/setting/model/friendAndStrangerSwitch/GetFriendAndStrangerSwitchModel;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1499880418, "Lcom/baidu/tieba/setting/model/friendAndStrangerSwitch/GetFriendAndStrangerSwitchModel;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetFriendAndStrangerSwitchModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a aVar = new a(this, CmdConfigHttp.CMD_GET_FRIEND_AND_STRANGER_MSG_SWITCH);
        this.a = aVar;
        registerListener(aVar);
        loadData();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_FRIEND_AND_STRANGER_MSG_SWITCH));
            return false;
        }
        return invokeV.booleanValue;
    }
}
