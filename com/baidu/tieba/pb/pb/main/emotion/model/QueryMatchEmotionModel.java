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
/* loaded from: classes4.dex */
public class QueryMatchEmotionModel extends BdBaseModel {
    private static LinkedHashMap<String, List<EmotionImageData>> hzh = new LinkedHashMap<>();
    private final HttpMessageListener cnc;
    private a hzg;

    /* loaded from: classes4.dex */
    public interface a {
        void onFail(int i, String str);

        void p(String str, List<EmotionImageData> list);
    }

    public QueryMatchEmotionModel(e<T> eVar) {
        super(eVar);
        this.cnc = new HttpMessageListener(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION) { // from class: com.baidu.tieba.pb.pb.main.emotion.model.QueryMatchEmotionModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003369 && (httpResponsedMessage instanceof QueryMatchEmotionResponseMessage) && QueryMatchEmotionModel.this.hzg != null) {
                    QueryMatchEmotionResponseMessage queryMatchEmotionResponseMessage = (QueryMatchEmotionResponseMessage) httpResponsedMessage;
                    if (queryMatchEmotionResponseMessage.getData() == null) {
                        QueryMatchEmotionModel.this.hzg.onFail(queryMatchEmotionResponseMessage.getError(), queryMatchEmotionResponseMessage.getErrorString());
                    } else if (httpResponsedMessage.getOrginalMessage() != null && (httpResponsedMessage.getOrginalMessage().getExtra() instanceof String)) {
                        String str = (String) httpResponsedMessage.getOrginalMessage().getExtra();
                        QueryMatchEmotionModel.this.hzg.p(str, queryMatchEmotionResponseMessage.getData());
                        QueryMatchEmotionModel.this.q(str, queryMatchEmotionResponseMessage.getData());
                    }
                }
            }
        };
        registerTask();
        this.cnc.setSelfListener(true);
        registerListener(this.cnc);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION, TbConfig.SERVER_ADDRESS + "c/e/meme/sugQuery");
        tbHttpMessageTask.setResponsedClass(QueryMatchEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void a(String str, a aVar) {
        this.hzg = aVar;
        if (this.hzg != null) {
            if (!v.T(Af(str))) {
                this.hzg.p(str, hzh.get(str));
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION);
            httpMessage.addParam("sug_query", str);
            httpMessage.setExtra(str);
            sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str, List<EmotionImageData> list) {
        if (!TextUtils.isEmpty(str) && !v.T(list)) {
            if (hzh == null) {
                hzh = new LinkedHashMap<>();
            }
            if (!hzh.containsKey(str)) {
                if (hzh.size() > 10) {
                    Map.Entry<String, List<EmotionImageData>> next = hzh.entrySet().iterator().next();
                    if (next != null) {
                        hzh.remove(next.getKey());
                    } else {
                        hzh.clear();
                    }
                }
                hzh.put(str, list);
            }
        }
    }

    private List<EmotionImageData> Af(String str) {
        if (hzh == null || !hzh.containsKey(str)) {
            return null;
        }
        return hzh.get(str);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.cnc);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION);
        return true;
    }
}
