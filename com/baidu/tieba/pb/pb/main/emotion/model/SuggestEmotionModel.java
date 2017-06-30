package com.baidu.tieba.pb.pb.main.emotion.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.emotion.message.SuggestEmotionResponseMessage;
/* loaded from: classes.dex */
public class SuggestEmotionModel extends BdBaseModel {
    private final HttpMessageListener eFm = new e(this, CmdConfigHttp.CMD_GET_SUGGEST_EMOTION);
    private a eFo;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.pb.pb.main.emotion.data.b bVar);

        void onFail(int i, String str);
    }

    public SuggestEmotionModel() {
        DU();
        this.eFm.setTag(getUniqueId());
        this.eFm.setSelfListener(true);
        registerListener(this.eFm);
    }

    private void DU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_SUGGEST_EMOTION, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/e/meme/suggest");
        tbHttpMessageTask.setResponsedClass(SuggestEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, String str2, a aVar) {
        this.eFo = aVar;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_SUGGEST_EMOTION);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("forum_name", str2);
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.eFm);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_SUGGEST_EMOTION);
        return true;
    }
}
