package com.baidu.tieba.pb.pb.main.emotion.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.emotion.message.SuggestEmotionResponseMessage;
/* loaded from: classes2.dex */
public class SuggestEmotionModel extends BdBaseModel {
    private a fIe;
    private String forumId;
    private String forumName;
    private final CustomMessageListener fIf = new CustomMessageListener(2921322) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(final CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                e.im().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_SUGGEST_EMOTION);
                        httpMessage.addParam("forum_id", SuggestEmotionModel.this.forumId);
                        httpMessage.addParam("forum_name", SuggestEmotionModel.this.forumName);
                        httpMessage.addParam("has_pkg", (String) customResponsedMessage.getData());
                        SuggestEmotionModel.this.sendMessage(httpMessage);
                    }
                });
            }
        }
    };
    private final HttpMessageListener aQM = new HttpMessageListener(CmdConfigHttp.CMD_GET_SUGGEST_EMOTION) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003329 && (httpResponsedMessage instanceof SuggestEmotionResponseMessage) && SuggestEmotionModel.this.fIe != null) {
                SuggestEmotionResponseMessage suggestEmotionResponseMessage = (SuggestEmotionResponseMessage) httpResponsedMessage;
                if (suggestEmotionResponseMessage.getData() != null) {
                    SuggestEmotionModel.this.fIe.a(suggestEmotionResponseMessage.getData());
                } else {
                    SuggestEmotionModel.this.fIe.onFail(suggestEmotionResponseMessage.getError(), suggestEmotionResponseMessage.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar);

        void onFail(int i, String str);
    }

    public SuggestEmotionModel() {
        registerTask();
        this.aQM.setTag(getUniqueId());
        this.aQM.setSelfListener(true);
        registerListener(this.aQM);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_SUGGEST_EMOTION, TbConfig.SERVER_ADDRESS + "c/e/meme/suggest");
        tbHttpMessageTask.setResponsedClass(SuggestEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.fIf);
    }

    public void a(String str, String str2, a aVar) {
        this.fIe = aVar;
        this.forumId = str;
        this.forumName = str2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004612, new Integer(2921322)));
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.aQM);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_SUGGEST_EMOTION);
        MessageManager.getInstance().unRegisterListener(this.fIf);
        return true;
    }
}
