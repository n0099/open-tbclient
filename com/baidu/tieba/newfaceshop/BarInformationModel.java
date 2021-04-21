package com.baidu.tieba.newfaceshop;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.BazhuInfoData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.newfaceshop.message.BazhuInfoResponseMessage;
/* loaded from: classes3.dex */
public class BarInformationModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f18868e;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(BarInformationModel barInformationModel, int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            BazhuInfoResponseMessage bazhuInfoResponseMessage;
            Object extra;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003357 && (httpResponsedMessage instanceof BazhuInfoResponseMessage)) {
                b bVar = null;
                if (httpResponsedMessage.getOrginalMessage() != null && (extra = httpResponsedMessage.getOrginalMessage().getExtra()) != null && (extra instanceof b)) {
                    bVar = (b) extra;
                }
                if (bVar == null || (bazhuInfoResponseMessage = (BazhuInfoResponseMessage) httpResponsedMessage) == null) {
                    return;
                }
                bVar.success(bazhuInfoResponseMessage.data);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void success(BazhuInfoData bazhuInfoData);
    }

    public BarInformationModel(TbPageContext<BaseActivity> tbPageContext) {
        super(tbPageContext);
        this.f18868e = new a(this, CmdConfigHttp.CMD_BAR_ZHU_INFORMATION);
        registerTask();
        this.f18868e.setTag(getUniqueId());
        this.f18868e.setSelfListener(true);
        registerListener(this.f18868e);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_BAR_ZHU_INFORMATION);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BAR_ZHU_INFORMATION, TbConfig.SERVER_ADDRESS + "c/e/meme/getBazhuInfo");
        tbHttpMessageTask.setResponsedClass(BazhuInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void s(b bVar) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_BAR_ZHU_INFORMATION);
        httpMessage.setExtra(bVar);
        sendMessage(httpMessage);
    }
}
