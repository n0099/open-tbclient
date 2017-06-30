package com.baidu.tieba.pb.pb.main.emotion.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.emotion.message.SearchEmotionResponseMessage;
/* loaded from: classes.dex */
public class SearchEmotionModel extends BdBaseModel {
    private a eES;
    private final HttpMessageListener eFm = new d(this, CmdConfigHttp.CMD_SEARCH_PB_EMOTION);

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.pb.pb.main.emotion.data.a aVar);

        void onFail(int i, String str);
    }

    public SearchEmotionModel() {
        DU();
        this.eFm.setTag(getUniqueId());
        this.eFm.setSelfListener(true);
        registerListener(this.eFm);
    }

    private void DU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SEARCH_PB_EMOTION, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/meme/search");
        tbHttpMessageTask.setResponsedClass(SearchEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, int i, int i2, a aVar) {
        this.eES = aVar;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_SEARCH_PB_EMOTION);
        httpMessage.addParam("kw", str);
        httpMessage.addParam("pn", i);
        httpMessage.addParam(LegoListActivityConfig.RN, i2);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.eFm);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_SEARCH_PB_EMOTION);
        this.eES = null;
        return true;
    }
}
