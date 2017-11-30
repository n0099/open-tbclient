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
    private static LinkedHashMap<String, List<EmotionImageData>> fej = new LinkedHashMap<>();
    private final HttpMessageListener aGC;
    private a fei;

    /* loaded from: classes.dex */
    public interface a {
        void l(String str, List<EmotionImageData> list);

        void onFail(int i, String str);
    }

    public QueryMatchEmotionModel(e<T> eVar) {
        super(eVar);
        this.aGC = new HttpMessageListener(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003369 && (httpResponsedMessage instanceof QueryMatchEmotionResponseMessage) && QueryMatchEmotionModel.this.fei != null) {
                    QueryMatchEmotionResponseMessage queryMatchEmotionResponseMessage = (QueryMatchEmotionResponseMessage) httpResponsedMessage;
                    if (queryMatchEmotionResponseMessage.getData() == null) {
                        QueryMatchEmotionModel.this.fei.onFail(queryMatchEmotionResponseMessage.getError(), queryMatchEmotionResponseMessage.getErrorString());
                    } else if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof String)) {
                        String str = (String) httpResponsedMessage.getOrginalMessage().getExtra();
                        QueryMatchEmotionModel.this.fei.l(str, queryMatchEmotionResponseMessage.getData());
                        QueryMatchEmotionModel.this.m(str, queryMatchEmotionResponseMessage.getData());
                    }
                }
            }
        };
        zK();
        this.aGC.setSelfListener(true);
        registerListener(this.aGC);
    }

    private void zK() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION, TbConfig.SERVER_ADDRESS + "c/e/meme/sugQuery");
        tbHttpMessageTask.setResponsedClass(QueryMatchEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, a aVar) {
        this.fei = aVar;
        if (this.fei != null) {
            if (!v.w(qc(str))) {
                this.fei.l(str, fej.get(str));
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION);
            httpMessage.addParam("sug_query", str);
            httpMessage.setExtra(str);
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && !v.w(list)) {
            if (fej == null) {
                fej = new LinkedHashMap<>();
            }
            if (!fej.containsKey(str)) {
                if (fej.size() > 10) {
                    Map.Entry<String, List<EmotionImageData>> next = fej.entrySet().iterator().next();
                    if (next != null) {
                        fej.remove(next.getKey());
                    } else {
                        fej.clear();
                    }
                }
                fej.put(str, list);
            }
        }
    }

    private List<EmotionImageData> qc(String str) {
        if (fej == null || !fej.containsKey(str)) {
            return null;
        }
        return fej.get(str);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.aGC);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION);
        return true;
    }
}
