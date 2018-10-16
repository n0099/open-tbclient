package com.baidu.tieba.pb.pb.main.emotion.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.emotion.message.GetSugMatchWordsResponseMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.T;
/* loaded from: classes6.dex */
public class GetSugMatchWordsModel extends BdBaseModel {
    private static List<String> eGt = new ArrayList();
    private a fXg;
    private final HttpMessageListener fXh;

    /* loaded from: classes6.dex */
    public interface a {
        void Q(List<String> list);

        void onFail(int i, String str);
    }

    public GetSugMatchWordsModel(e<T> eVar) {
        super(eVar);
        this.fXh = new HttpMessageListener(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003370 && (httpResponsedMessage instanceof GetSugMatchWordsResponseMessage) && GetSugMatchWordsModel.this.fXg != null) {
                    GetSugMatchWordsResponseMessage getSugMatchWordsResponseMessage = (GetSugMatchWordsResponseMessage) httpResponsedMessage;
                    if (!v.J(getSugMatchWordsResponseMessage.getData())) {
                        GetSugMatchWordsModel.this.fXg.Q(getSugMatchWordsResponseMessage.getData());
                        GetSugMatchWordsModel.eGt.clear();
                        GetSugMatchWordsModel.eGt.addAll(getSugMatchWordsResponseMessage.getData());
                        return;
                    }
                    GetSugMatchWordsModel.this.fXg.onFail(getSugMatchWordsResponseMessage.getError(), getSugMatchWordsResponseMessage.getErrorString());
                }
            }
        };
        registerTask();
        this.fXh.setSelfListener(true);
        registerListener(this.fXh);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS, TbConfig.SERVER_ADDRESS + "c/e/meme/getSugKeyWords");
        tbHttpMessageTask.setResponsedClass(GetSugMatchWordsResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void b(a aVar) {
        this.fXg = aVar;
        if (this.fXg != null) {
            if (!v.J(eGt)) {
                this.fXg.Q(eGt);
            } else {
                sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.fXh);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS);
        return true;
    }
}
