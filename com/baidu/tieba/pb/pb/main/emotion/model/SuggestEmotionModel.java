package com.baidu.tieba.pb.pb.main.emotion.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.emotion.message.SuggestEmotionResponseMessage;
/* loaded from: classes9.dex */
public class SuggestEmotionModel extends BdBaseModel {
    private String forumId;
    private String forumName;
    private a iTP;
    private final CustomMessageListener iTQ = new CustomMessageListener(CmdConfigCustom.CMD_PB_GET_LOCAL_EMOTIONS) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(final CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                e.gx().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HttpMessage httpMessage = new HttpMessage(1003329);
                        httpMessage.addParam("forum_id", SuggestEmotionModel.this.forumId);
                        httpMessage.addParam("forum_name", SuggestEmotionModel.this.forumName);
                        httpMessage.addParam("has_pkg", (String) customResponsedMessage.getData());
                        SuggestEmotionModel.this.sendMessage(httpMessage);
                    }
                });
            }
        }
    };
    private final HttpMessageListener dBg = new HttpMessageListener(1003329) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003329 && (httpResponsedMessage instanceof SuggestEmotionResponseMessage) && SuggestEmotionModel.this.iTP != null) {
                SuggestEmotionResponseMessage suggestEmotionResponseMessage = (SuggestEmotionResponseMessage) httpResponsedMessage;
                if (suggestEmotionResponseMessage.getData() != null) {
                    SuggestEmotionModel.this.iTP.a(suggestEmotionResponseMessage.getData());
                } else {
                    SuggestEmotionModel.this.iTP.onFail(suggestEmotionResponseMessage.getError(), suggestEmotionResponseMessage.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void a(com.baidu.tieba.pb.pb.main.emotion.a.a aVar);

        void onFail(int i, String str);
    }

    public SuggestEmotionModel() {
        tj();
        this.dBg.setTag(getUniqueId());
        this.dBg.setSelfListener(true);
        registerListener(this.dBg);
    }

    private void tj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003329, TbConfig.SERVER_ADDRESS + Config.GET_PB_SUGGEST_EMOTION);
        tbHttpMessageTask.setResponsedClass(SuggestEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.iTQ);
    }

    public void a(String str, String str2, a aVar) {
        this.iTP = aVar;
        this.forumId = str;
        this.forumName = str2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_SEND_LOCAL_EMOTIONS, new Integer((int) CmdConfigCustom.CMD_PB_GET_LOCAL_EMOTIONS)));
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.dBg);
        MessageManager.getInstance().unRegisterTask(1003329);
        MessageManager.getInstance().unRegisterListener(this.iTQ);
        return true;
    }
}
