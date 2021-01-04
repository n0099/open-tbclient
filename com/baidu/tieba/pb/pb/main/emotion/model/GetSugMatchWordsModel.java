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
    private static List<String> kDr = new ArrayList();
    private a lYJ;
    private final HttpMessageListener lYK;

    /* loaded from: classes2.dex */
    public interface a {
        void ai(List<String> list);

        void onFail(int i, String str);
    }

    public GetSugMatchWordsModel(f<T> fVar) {
        super(fVar);
        this.lYK = new HttpMessageListener(1003370) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003370 && (httpResponsedMessage instanceof GetSugMatchWordsResponseMessage) && GetSugMatchWordsModel.this.lYJ != null) {
                    GetSugMatchWordsResponseMessage getSugMatchWordsResponseMessage = (GetSugMatchWordsResponseMessage) httpResponsedMessage;
                    if (!x.isEmpty(getSugMatchWordsResponseMessage.getData())) {
                        GetSugMatchWordsModel.this.lYJ.ai(getSugMatchWordsResponseMessage.getData());
                        GetSugMatchWordsModel.kDr.clear();
                        GetSugMatchWordsModel.kDr.addAll(getSugMatchWordsResponseMessage.getData());
                        return;
                    }
                    GetSugMatchWordsModel.this.lYJ.onFail(getSugMatchWordsResponseMessage.getError(), getSugMatchWordsResponseMessage.getErrorString());
                }
            }
        };
        registerTask();
        this.lYK.setSelfListener(true);
        registerListener(this.lYK);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003370, TbConfig.SERVER_ADDRESS + Config.GET_PB_SUG_MATCH_WORDS);
        tbHttpMessageTask.setResponsedClass(GetSugMatchWordsResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void b(a aVar) {
        this.lYJ = aVar;
        if (this.lYJ != null) {
            if (!x.isEmpty(kDr)) {
                this.lYJ.ai(kDr);
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
        MessageManager.getInstance().unRegisterListener(this.lYK);
        MessageManager.getInstance().unRegisterTask(1003370);
        return true;
    }
}
