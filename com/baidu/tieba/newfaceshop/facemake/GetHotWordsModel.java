package com.baidu.tieba.newfaceshop.facemake;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.newfaceshop.FaceBaseModel;
import java.util.List;
/* loaded from: classes8.dex */
public class GetHotWordsModel extends FaceBaseModel {
    private a ltO;
    private final HttpMessageListener ltP = new HttpMessageListener(1003352) { // from class: com.baidu.tieba.newfaceshop.facemake.GetHotWordsModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003352 && (httpResponsedMessage instanceof GetHotWordsMessage) && GetHotWordsModel.this.ltO != null) {
                GetHotWordsMessage getHotWordsMessage = (GetHotWordsMessage) httpResponsedMessage;
                if (getHotWordsMessage.getData() != null) {
                    GetHotWordsModel.this.ltO.ai(getHotWordsMessage.getData());
                } else {
                    GetHotWordsModel.this.ltO.onFail(getHotWordsMessage.getError(), getHotWordsMessage.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes8.dex */
    public interface a {
        void ai(List<String> list);

        void onFail(int i, String str);
    }

    public GetHotWordsModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.ltP.setTag(getUniqueId());
        this.ltP.setSelfListener(true);
        registerListener(this.ltP);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003352, TbConfig.SERVER_ADDRESS + Config.GET_FACE_MAKE_HOT_WORDS);
        tbHttpMessageTask.setResponsedClass(GetHotWordsMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(a aVar) {
        this.ltO = aVar;
        sendMessage(new HttpMessage(1003352));
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.ltP);
        MessageManager.getInstance().unRegisterTask(1003352);
        return true;
    }
}
