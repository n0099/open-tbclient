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
    private static LinkedHashMap<String, List<EmotionImageData>> eWz = new LinkedHashMap<>();
    private final HttpMessageListener aFT;
    private a eWy;

    /* loaded from: classes.dex */
    public interface a {
        void m(String str, List<EmotionImageData> list);

        void onFail(int i, String str);
    }

    public QueryMatchEmotionModel(e<T> eVar) {
        super(eVar);
        this.aFT = new HttpMessageListener(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003369 && (httpResponsedMessage instanceof QueryMatchEmotionResponseMessage) && QueryMatchEmotionModel.this.eWy != null) {
                    QueryMatchEmotionResponseMessage queryMatchEmotionResponseMessage = (QueryMatchEmotionResponseMessage) httpResponsedMessage;
                    if (queryMatchEmotionResponseMessage.getData() == null) {
                        QueryMatchEmotionModel.this.eWy.onFail(queryMatchEmotionResponseMessage.getError(), queryMatchEmotionResponseMessage.getErrorString());
                    } else if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof String)) {
                        String str = (String) httpResponsedMessage.getOrginalMessage().getExtra();
                        QueryMatchEmotionModel.this.eWy.m(str, queryMatchEmotionResponseMessage.getData());
                        QueryMatchEmotionModel.this.n(str, queryMatchEmotionResponseMessage.getData());
                    }
                }
            }
        };
        DY();
        this.aFT.setSelfListener(true);
        registerListener(this.aFT);
    }

    private void DY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION, TbConfig.SERVER_ADDRESS + "c/e/meme/sugQuery");
        tbHttpMessageTask.setResponsedClass(QueryMatchEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, a aVar) {
        this.eWy = aVar;
        if (this.eWy != null) {
            if (!v.v(pL(str))) {
                this.eWy.m(str, eWz.get(str));
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
        if (!TextUtils.isEmpty(str) && !v.v(list)) {
            if (eWz == null) {
                eWz = new LinkedHashMap<>();
            }
            if (!eWz.containsKey(str)) {
                if (eWz.size() > 10) {
                    Map.Entry<String, List<EmotionImageData>> next = eWz.entrySet().iterator().next();
                    if (next != null) {
                        eWz.remove(next.getKey());
                    } else {
                        eWz.clear();
                    }
                }
                eWz.put(str, list);
            }
        }
    }

    private List<EmotionImageData> pL(String str) {
        if (eWz == null || !eWz.containsKey(str)) {
            return null;
        }
        return eWz.get(str);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.aFT);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION);
        return true;
    }
}
