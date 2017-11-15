package com.baidu.tieba.pb.pb.main.emotion.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.emotion.message.SuggestEmotionResponseMessage;
/* loaded from: classes.dex */
public class SuggestEmotionModel extends BdBaseModel {
    private final HttpMessageListener aGb = new HttpMessageListener(CmdConfigHttp.CMD_GET_SUGGEST_EMOTION) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003329 && (httpResponsedMessage instanceof SuggestEmotionResponseMessage) && SuggestEmotionModel.this.eXb != null) {
                SuggestEmotionResponseMessage suggestEmotionResponseMessage = (SuggestEmotionResponseMessage) httpResponsedMessage;
                if (suggestEmotionResponseMessage.getData() != null) {
                    SuggestEmotionModel.this.eXb.a(suggestEmotionResponseMessage.getData());
                } else {
                    SuggestEmotionModel.this.eXb.onFail(suggestEmotionResponseMessage.getError(), suggestEmotionResponseMessage.getErrorString());
                }
            }
        }
    };
    private a eXb;

    /* loaded from: classes.dex */
    public interface a {
        void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar);

        void onFail(int i, String str);
    }

    public SuggestEmotionModel() {
        Ek();
        this.aGb.setTag(getUniqueId());
        this.aGb.setSelfListener(true);
        registerListener(this.aGb);
    }

    private void Ek() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_SUGGEST_EMOTION, TbConfig.SERVER_ADDRESS + "c/e/meme/suggest");
        tbHttpMessageTask.setResponsedClass(SuggestEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, String str2, a aVar) {
        this.eXb = aVar;
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
        MessageManager.getInstance().unRegisterListener(this.aGb);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_SUGGEST_EMOTION);
        return true;
    }
}
