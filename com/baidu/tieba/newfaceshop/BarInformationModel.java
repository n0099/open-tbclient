package com.baidu.tieba.newfaceshop;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.data.BazhuInfoData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.newfaceshop.message.BazhuInfoResponseMessage;
/* loaded from: classes8.dex */
public class BarInformationModel extends BdBaseModel {
    private final HttpMessageListener lBX;

    /* loaded from: classes8.dex */
    public interface a {
        void a(BazhuInfoData bazhuInfoData);
    }

    public BarInformationModel(TbPageContext<BaseActivity> tbPageContext) {
        super(tbPageContext);
        this.lBX = new HttpMessageListener(1003357) { // from class: com.baidu.tieba.newfaceshop.BarInformationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                a aVar;
                BazhuInfoResponseMessage bazhuInfoResponseMessage;
                Object extra;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003357 && (httpResponsedMessage instanceof BazhuInfoResponseMessage)) {
                    if (httpResponsedMessage.getOrginalMessage() == null || (extra = httpResponsedMessage.getOrginalMessage().getExtra()) == null || !(extra instanceof a)) {
                        aVar = null;
                    } else {
                        aVar = (a) extra;
                    }
                    if (aVar != null && (bazhuInfoResponseMessage = (BazhuInfoResponseMessage) httpResponsedMessage) != null) {
                        aVar.a(bazhuInfoResponseMessage.data);
                    }
                }
            }
        };
        registerTask();
        this.lBX.setTag(getUniqueId());
        this.lBX.setSelfListener(true);
        registerListener(this.lBX);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003357, TbConfig.SERVER_ADDRESS + Config.EMOTION_BAZHU_INFO);
        tbHttpMessageTask.setResponsedClass(BazhuInfoResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(a aVar) {
        HttpMessage httpMessage = new HttpMessage(1003357);
        httpMessage.setExtra(aVar);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(1003357);
        return true;
    }
}
