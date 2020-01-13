package com.baidu.tieba.pb.pb.main.emotion.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.emotion.message.GetSugMatchWordsResponseMessage;
import java.util.ArrayList;
import java.util.List;
import tbclient.T;
/* loaded from: classes7.dex */
public class GetSugMatchWordsModel extends BdBaseModel {
    private static List<String> hwX = new ArrayList();
    private a iQs;
    private final HttpMessageListener iQt;

    /* loaded from: classes7.dex */
    public interface a {
        void onFail(int i, String str);

        void onSuccess(List<String> list);
    }

    public GetSugMatchWordsModel(e<T> eVar) {
        super(eVar);
        this.iQt = new HttpMessageListener(1003370) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003370 && (httpResponsedMessage instanceof GetSugMatchWordsResponseMessage) && GetSugMatchWordsModel.this.iQs != null) {
                    GetSugMatchWordsResponseMessage getSugMatchWordsResponseMessage = (GetSugMatchWordsResponseMessage) httpResponsedMessage;
                    if (!v.isEmpty(getSugMatchWordsResponseMessage.getData())) {
                        GetSugMatchWordsModel.this.iQs.onSuccess(getSugMatchWordsResponseMessage.getData());
                        GetSugMatchWordsModel.hwX.clear();
                        GetSugMatchWordsModel.hwX.addAll(getSugMatchWordsResponseMessage.getData());
                        return;
                    }
                    GetSugMatchWordsModel.this.iQs.onFail(getSugMatchWordsResponseMessage.getError(), getSugMatchWordsResponseMessage.getErrorString());
                }
            }
        };
        rT();
        this.iQt.setSelfListener(true);
        registerListener(this.iQt);
    }

    private void rT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003370, TbConfig.SERVER_ADDRESS + Config.GET_PB_SUG_MATCH_WORDS);
        tbHttpMessageTask.setResponsedClass(GetSugMatchWordsResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void b(a aVar) {
        this.iQs = aVar;
        if (this.iQs != null) {
            if (!v.isEmpty(hwX)) {
                this.iQs.onSuccess(hwX);
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
        MessageManager.getInstance().unRegisterListener(this.iQt);
        MessageManager.getInstance().unRegisterTask(1003370);
        return true;
    }
}
