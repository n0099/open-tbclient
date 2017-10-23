package com.baidu.tieba.pb.pb.main.emotion.model;

import android.text.TextUtils;
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
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.emotion.message.QueryMatchEmotionResponseMessage;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tbclient.T;
/* loaded from: classes.dex */
public class QueryMatchEmotionModel extends BdBaseModel {
    private static LinkedHashMap<String, List<EmotionImageData>> eNF = new LinkedHashMap<>();
    private final HttpMessageListener aFj;
    private a eNE;

    /* loaded from: classes.dex */
    public interface a {
        void m(String str, List<EmotionImageData> list);

        void onFail(int i, String str);
    }

    public QueryMatchEmotionModel(e<T> eVar) {
        super(eVar);
        this.aFj = new HttpMessageListener(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003369 && (httpResponsedMessage instanceof QueryMatchEmotionResponseMessage) && QueryMatchEmotionModel.this.eNE != null) {
                    QueryMatchEmotionResponseMessage queryMatchEmotionResponseMessage = (QueryMatchEmotionResponseMessage) httpResponsedMessage;
                    if (queryMatchEmotionResponseMessage.getData() == null) {
                        QueryMatchEmotionModel.this.eNE.onFail(queryMatchEmotionResponseMessage.getError(), queryMatchEmotionResponseMessage.getErrorString());
                    } else if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof String)) {
                        String str = (String) httpResponsedMessage.getOrginalMessage().getExtra();
                        QueryMatchEmotionModel.this.eNE.m(str, queryMatchEmotionResponseMessage.getData());
                        QueryMatchEmotionModel.this.n(str, queryMatchEmotionResponseMessage.getData());
                    }
                }
            }
        };
        DJ();
        this.aFj.setSelfListener(true);
        registerListener(this.aFj);
    }

    private void DJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION, TbConfig.SERVER_ADDRESS + "c/e/meme/sugQuery");
        tbHttpMessageTask.setResponsedClass(QueryMatchEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, a aVar) {
        this.eNE = aVar;
        if (this.eNE != null) {
            if (!v.u(pg(str))) {
                this.eNE.m(str, eNF.get(str));
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION);
            httpMessage.addParam("sug_query", str);
            httpMessage.setExtra(str);
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && !v.u(list)) {
            if (eNF == null) {
                eNF = new LinkedHashMap<>();
            }
            if (!eNF.containsKey(str)) {
                if (eNF.size() > 10) {
                    Map.Entry<String, List<EmotionImageData>> next = eNF.entrySet().iterator().next();
                    if (next != null) {
                        eNF.remove(next.getKey());
                    } else {
                        eNF.clear();
                    }
                }
                eNF.put(str, list);
            }
        }
    }

    private List<EmotionImageData> pg(String str) {
        if (eNF == null || !eNF.containsKey(str)) {
            return null;
        }
        return eNF.get(str);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.aFj);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION);
        return true;
    }
}
