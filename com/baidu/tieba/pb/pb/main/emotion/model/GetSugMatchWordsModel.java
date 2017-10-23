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
/* loaded from: classes.dex */
public class GetSugMatchWordsModel extends BdBaseModel {
    private static List<String> dte = new ArrayList();
    private a eMV;
    private final HttpMessageListener eMW;

    /* loaded from: classes.dex */
    public interface a {
        void A(List<String> list);

        void onFail(int i, String str);
    }

    public GetSugMatchWordsModel(e<T> eVar) {
        super(eVar);
        this.eMW = new HttpMessageListener(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003370 && (httpResponsedMessage instanceof GetSugMatchWordsResponseMessage) && GetSugMatchWordsModel.this.eMV != null) {
                    GetSugMatchWordsResponseMessage getSugMatchWordsResponseMessage = (GetSugMatchWordsResponseMessage) httpResponsedMessage;
                    if (!v.u(getSugMatchWordsResponseMessage.getData())) {
                        GetSugMatchWordsModel.this.eMV.A(getSugMatchWordsResponseMessage.getData());
                        GetSugMatchWordsModel.dte.clear();
                        GetSugMatchWordsModel.dte.addAll(getSugMatchWordsResponseMessage.getData());
                        return;
                    }
                    GetSugMatchWordsModel.this.eMV.onFail(getSugMatchWordsResponseMessage.getError(), getSugMatchWordsResponseMessage.getErrorString());
                }
            }
        };
        DJ();
        this.eMW.setSelfListener(true);
        registerListener(this.eMW);
    }

    private void DJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS, TbConfig.SERVER_ADDRESS + "c/e/meme/getSugKeyWords");
        tbHttpMessageTask.setResponsedClass(GetSugMatchWordsResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void b(a aVar) {
        this.eMV = aVar;
        if (this.eMV != null) {
            if (!v.u(dte)) {
                this.eMV.A(dte);
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
        MessageManager.getInstance().unRegisterListener(this.eMW);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS);
        return true;
    }
}
