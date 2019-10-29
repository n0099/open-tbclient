package com.baidu.tieba.pb.pb.main.emotion.model;

import android.text.TextUtils;
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
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.emotion.message.QueryMatchEmotionResponseMessage;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tbclient.T;
/* loaded from: classes4.dex */
public class QueryMatchEmotionModel extends BdBaseModel {
    private static LinkedHashMap<String, List<EmotionImageData>> hYJ = new LinkedHashMap<>();
    private final HttpMessageListener cJz;
    private a hYI;

    /* loaded from: classes4.dex */
    public interface a {
        void o(String str, List<EmotionImageData> list);

        void onFail(int i, String str);
    }

    public QueryMatchEmotionModel(e<T> eVar) {
        super(eVar);
        this.cJz = new HttpMessageListener(1003369) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003369 && (httpResponsedMessage instanceof QueryMatchEmotionResponseMessage) && QueryMatchEmotionModel.this.hYI != null) {
                    QueryMatchEmotionResponseMessage queryMatchEmotionResponseMessage = (QueryMatchEmotionResponseMessage) httpResponsedMessage;
                    if (queryMatchEmotionResponseMessage.getData() == null) {
                        QueryMatchEmotionModel.this.hYI.onFail(queryMatchEmotionResponseMessage.getError(), queryMatchEmotionResponseMessage.getErrorString());
                    } else if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof String)) {
                        String str = (String) httpResponsedMessage.getOrginalMessage().getExtra();
                        QueryMatchEmotionModel.this.hYI.o(str, queryMatchEmotionResponseMessage.getData());
                        QueryMatchEmotionModel.this.p(str, queryMatchEmotionResponseMessage.getData());
                    }
                }
            }
        };
        registerTask();
        this.cJz.setSelfListener(true);
        registerListener(this.cJz);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003369, TbConfig.SERVER_ADDRESS + Config.GET_PB_QUERY_MATCH_EMOTION);
        tbHttpMessageTask.setResponsedClass(QueryMatchEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, a aVar) {
        this.hYI = aVar;
        if (this.hYI != null) {
            if (!v.isEmpty(Bc(str))) {
                this.hYI.o(str, hYJ.get(str));
                return;
            }
            HttpMessage httpMessage = new HttpMessage(1003369);
            httpMessage.addParam("sug_query", str);
            httpMessage.setExtra(str);
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && !v.isEmpty(list)) {
            if (hYJ == null) {
                hYJ = new LinkedHashMap<>();
            }
            if (!hYJ.containsKey(str)) {
                if (hYJ.size() > 10) {
                    Map.Entry<String, List<EmotionImageData>> next = hYJ.entrySet().iterator().next();
                    if (next != null) {
                        hYJ.remove(next.getKey());
                    } else {
                        hYJ.clear();
                    }
                }
                hYJ.put(str, list);
            }
        }
    }

    private List<EmotionImageData> Bc(String str) {
        if (hYJ == null || !hYJ.containsKey(str)) {
            return null;
        }
        return hYJ.get(str);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.cJz);
        MessageManager.getInstance().unRegisterTask(1003369);
        return true;
    }
}
