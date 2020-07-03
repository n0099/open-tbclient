package com.baidu.tieba.pb.pb.main.emotion.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.emotion.message.GetSugMatchWordsResponseMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.T;
/* loaded from: classes9.dex */
public class GetSugMatchWordsModel extends BdBaseModel {
    private static List<String> iRe = new ArrayList();
    private a kqk;
    private final HttpMessageListener kql;

    /* loaded from: classes9.dex */
    public interface a {
        void aX(List<String> list);

        void onFail(int i, String str);
    }

    public GetSugMatchWordsModel(e<T> eVar) {
        super(eVar);
        this.kql = new HttpMessageListener(1003370) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003370 && (httpResponsedMessage instanceof GetSugMatchWordsResponseMessage) && GetSugMatchWordsModel.this.kqk != null) {
                    GetSugMatchWordsResponseMessage getSugMatchWordsResponseMessage = (GetSugMatchWordsResponseMessage) httpResponsedMessage;
                    if (!w.isEmpty(getSugMatchWordsResponseMessage.getData())) {
                        GetSugMatchWordsModel.this.kqk.aX(getSugMatchWordsResponseMessage.getData());
                        GetSugMatchWordsModel.iRe.clear();
                        GetSugMatchWordsModel.iRe.addAll(getSugMatchWordsResponseMessage.getData());
                        return;
                    }
                    GetSugMatchWordsModel.this.kqk.onFail(getSugMatchWordsResponseMessage.getError(), getSugMatchWordsResponseMessage.getErrorString());
                }
            }
        };
        xp();
        this.kql.setSelfListener(true);
        registerListener(this.kql);
    }

    private void xp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003370, TbConfig.SERVER_ADDRESS + Config.GET_PB_SUG_MATCH_WORDS);
        tbHttpMessageTask.setResponsedClass(GetSugMatchWordsResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void b(a aVar) {
        this.kqk = aVar;
        if (this.kqk != null) {
            if (!w.isEmpty(iRe)) {
                this.kqk.aX(iRe);
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
        MessageManager.getInstance().unRegisterListener(this.kql);
        MessageManager.getInstance().unRegisterTask(1003370);
        return true;
    }
}
