package com.baidu.tieba.wallet;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes5.dex */
public class CurrencySwitchModel extends BdBaseModel {
    public OnPostDataCallBack mCallBack;
    public final HttpMessageListener mSwitchCurrencyListener;

    /* loaded from: classes5.dex */
    public interface OnPostDataCallBack {
        void callback(boolean z, int i2, String str);
    }

    public CurrencySwitchModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mSwitchCurrencyListener = new HttpMessageListener(CmdConfigHttp.CMD_CURRENCY_SWITCH_REQUEST) { // from class: com.baidu.tieba.wallet.CurrencySwitchModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || !(httpResponsedMessage instanceof CurrencySwitchResponseMessage)) {
                    return;
                }
                CurrencySwitchResponseMessage currencySwitchResponseMessage = (CurrencySwitchResponseMessage) httpResponsedMessage;
                if (CurrencySwitchModel.this.mCallBack != null) {
                    CurrencySwitchModel.this.mCallBack.callback(currencySwitchResponseMessage.isSwitchSuccess(), currencySwitchResponseMessage.getError(), currencySwitchResponseMessage.getTipMessage());
                }
            }
        };
        registerPostCurrencySwitchTask();
        MessageManager.getInstance().registerListener(this.mSwitchCurrencyListener);
    }

    private void registerPostCurrencySwitchTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CURRENCY_SWITCH_REQUEST, TbConfig.SERVER_ADDRESS + TbConfig.URL_SWITCH_YY_CURRENCY);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(CurrencySwitchResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_CURRENCY_SWITCH_REQUEST);
        MessageManager.getInstance().unRegisterListener(this.mSwitchCurrencyListener);
    }

    public void sendSwitchRequest() {
        MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_CURRENCY_SWITCH_REQUEST));
    }

    public void setOnPostDataCallBack(OnPostDataCallBack onPostDataCallBack) {
        this.mCallBack = onPostDataCallBack;
    }
}
