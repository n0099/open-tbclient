package com.baidu.tieba.pb.pb.main.emotion.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.emotion.message.GetSugMatchWordsResponseMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.T;
/* loaded from: classes2.dex */
public class GetSugMatchWordsModel extends BdBaseModel {
    private static List<String> kyM = new ArrayList();
    private a lUe;
    private final HttpMessageListener lUf;

    /* loaded from: classes2.dex */
    public interface a {
        void ai(List<String> list);

        void onFail(int i, String str);
    }

    public GetSugMatchWordsModel(f<T> fVar) {
        super(fVar);
        this.lUf = new HttpMessageListener(1003370) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003370 && (httpResponsedMessage instanceof GetSugMatchWordsResponseMessage) && GetSugMatchWordsModel.this.lUe != null) {
                    GetSugMatchWordsResponseMessage getSugMatchWordsResponseMessage = (GetSugMatchWordsResponseMessage) httpResponsedMessage;
                    if (!x.isEmpty(getSugMatchWordsResponseMessage.getData())) {
                        GetSugMatchWordsModel.this.lUe.ai(getSugMatchWordsResponseMessage.getData());
                        GetSugMatchWordsModel.kyM.clear();
                        GetSugMatchWordsModel.kyM.addAll(getSugMatchWordsResponseMessage.getData());
                        return;
                    }
                    GetSugMatchWordsModel.this.lUe.onFail(getSugMatchWordsResponseMessage.getError(), getSugMatchWordsResponseMessage.getErrorString());
                }
            }
        };
        registerTask();
        this.lUf.setSelfListener(true);
        registerListener(this.lUf);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003370, TbConfig.SERVER_ADDRESS + Config.GET_PB_SUG_MATCH_WORDS);
        tbHttpMessageTask.setResponsedClass(GetSugMatchWordsResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void b(a aVar) {
        this.lUe = aVar;
        if (this.lUe != null) {
            if (!x.isEmpty(kyM)) {
                this.lUe.ai(kyM);
            } else {
                sendMessage(new HttpMessage(1003370));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.lUf);
        MessageManager.getInstance().unRegisterTask(1003370);
        return true;
    }
}
