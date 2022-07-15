package com.baidu.tieba.wallet;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d9;
import com.repackage.pi;
/* loaded from: classes4.dex */
public class CurrencySwitchModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isSending;
    public OnPostDataCallBack mCallBack;
    public final HttpMessageListener mSwitchCurrencyListener;

    /* loaded from: classes4.dex */
    public interface OnPostDataCallBack {
        void callback(boolean z, int i, String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurrencySwitchModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSwitchCurrencyListener = new HttpMessageListener(this, CmdConfigHttp.CMD_CURRENCY_SWITCH_REQUEST) { // from class: com.baidu.tieba.wallet.CurrencySwitchModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CurrencySwitchModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && (httpResponsedMessage instanceof CurrencySwitchResponseMessage)) {
                    this.this$0.isSending = false;
                    CurrencySwitchResponseMessage currencySwitchResponseMessage = (CurrencySwitchResponseMessage) httpResponsedMessage;
                    if (this.this$0.mCallBack != null) {
                        this.this$0.mCallBack.callback(currencySwitchResponseMessage.isSwitchSuccess(), currencySwitchResponseMessage.getError(), currencySwitchResponseMessage.getTipMessage());
                    }
                }
            }
        };
        registerPostCurrencySwitchTask();
        MessageManager.getInstance().registerListener(this.mSwitchCurrencyListener);
    }

    private void registerPostCurrencySwitchTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CURRENCY_SWITCH_REQUEST, TbConfig.SERVER_ADDRESS + TbConfig.URL_SWITCH_YY_CURRENCY);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setResponsedClass(CurrencySwitchResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.isSending = false;
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_CURRENCY_SWITCH_REQUEST);
            MessageManager.getInstance().unRegisterListener(this.mSwitchCurrencyListener);
        }
    }

    public void sendSwitchRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.isSending) {
                pi.N(TbadkCoreApplication.getInst().getContext(), R.string.obfuscated_res_0x7f0f159b);
                return;
            }
            this.isSending = true;
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_CURRENCY_SWITCH_REQUEST));
        }
    }

    public void setOnPostDataCallBack(OnPostDataCallBack onPostDataCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onPostDataCallBack) == null) {
            this.mCallBack = onPostDataCallBack;
        }
    }
}
