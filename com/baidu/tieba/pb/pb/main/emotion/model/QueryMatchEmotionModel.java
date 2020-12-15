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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.emotion.message.QueryMatchEmotionResponseMessage;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tbclient.T;
/* loaded from: classes22.dex */
public class QueryMatchEmotionModel extends BdBaseModel {
    private static LinkedHashMap<String, List<EmotionImageData>> lTB = new LinkedHashMap<>();
    private final HttpMessageListener fzg;
    private a lTA;

    /* loaded from: classes22.dex */
    public interface a {
        void n(String str, List<EmotionImageData> list);

        void onFail(int i, String str);
    }

    public QueryMatchEmotionModel(e<T> eVar) {
        super(eVar);
        this.fzg = new HttpMessageListener(1003369) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003369 && (httpResponsedMessage instanceof QueryMatchEmotionResponseMessage) && QueryMatchEmotionModel.this.lTA != null) {
                    QueryMatchEmotionResponseMessage queryMatchEmotionResponseMessage = (QueryMatchEmotionResponseMessage) httpResponsedMessage;
                    if (queryMatchEmotionResponseMessage.getData() == null) {
                        QueryMatchEmotionModel.this.lTA.onFail(queryMatchEmotionResponseMessage.getError(), queryMatchEmotionResponseMessage.getErrorString());
                    } else if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof String)) {
                        String str = (String) httpResponsedMessage.getOrginalMessage().getExtra();
                        QueryMatchEmotionModel.this.lTA.n(str, queryMatchEmotionResponseMessage.getData());
                        QueryMatchEmotionModel.this.o(str, queryMatchEmotionResponseMessage.getData());
                    }
                }
            }
        };
        registerTask();
        this.fzg.setSelfListener(true);
        registerListener(this.fzg);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003369, TbConfig.SERVER_ADDRESS + Config.GET_PB_QUERY_MATCH_EMOTION);
        tbHttpMessageTask.setResponsedClass(QueryMatchEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, a aVar) {
        this.lTA = aVar;
        if (this.lTA != null) {
            if (!y.isEmpty(QB(str))) {
                this.lTA.n(str, lTB.get(str));
                return;
            }
            HttpMessage httpMessage = new HttpMessage(1003369);
            httpMessage.addParam("sug_query", str);
            httpMessage.setExtra(str);
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && !y.isEmpty(list)) {
            if (lTB == null) {
                lTB = new LinkedHashMap<>();
            }
            if (!lTB.containsKey(str)) {
                if (lTB.size() > 10) {
                    Map.Entry<String, List<EmotionImageData>> next = lTB.entrySet().iterator().next();
                    if (next != null) {
                        lTB.remove(next.getKey());
                    } else {
                        lTB.clear();
                    }
                }
                lTB.put(str, list);
            }
        }
    }

    private List<EmotionImageData> QB(String str) {
        if (lTB == null || !lTB.containsKey(str)) {
            return null;
        }
        return lTB.get(str);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.fzg);
        MessageManager.getInstance().unRegisterTask(1003369);
        return true;
    }
}
