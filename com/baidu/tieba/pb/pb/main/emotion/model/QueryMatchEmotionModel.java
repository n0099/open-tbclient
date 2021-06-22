package com.baidu.tieba.pb.pb.main.emotion.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.pb.pb.main.emotion.message.QueryMatchEmotionResponseMessage;
import d.a.c.a.f;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import tbclient.T;
/* loaded from: classes5.dex */
public class QueryMatchEmotionModel extends BdBaseModel {

    /* renamed from: g  reason: collision with root package name */
    public static LinkedHashMap<String, List<EmotionImageData>> f19334g = new LinkedHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public b f19335e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f19336f;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003369 || !(httpResponsedMessage instanceof QueryMatchEmotionResponseMessage) || QueryMatchEmotionModel.this.f19335e == null) {
                return;
            }
            QueryMatchEmotionResponseMessage queryMatchEmotionResponseMessage = (QueryMatchEmotionResponseMessage) httpResponsedMessage;
            if (queryMatchEmotionResponseMessage.getData() == null) {
                QueryMatchEmotionModel.this.f19335e.onFail(queryMatchEmotionResponseMessage.getError(), queryMatchEmotionResponseMessage.getErrorString());
            } else if (httpResponsedMessage.getOrginalMessage() == null || !(httpResponsedMessage.getOrginalMessage().getExtra() instanceof String)) {
            } else {
                String str = (String) httpResponsedMessage.getOrginalMessage().getExtra();
                QueryMatchEmotionModel.this.f19335e.a(str, queryMatchEmotionResponseMessage.getData());
                QueryMatchEmotionModel.this.A(str, queryMatchEmotionResponseMessage.getData());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(String str, List<EmotionImageData> list);

        void onFail(int i2, String str);
    }

    public QueryMatchEmotionModel(f<T> fVar) {
        super(fVar);
        this.f19336f = new a(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION);
        registerTask();
        this.f19336f.setSelfListener(true);
        registerListener(this.f19336f);
    }

    public final void A(String str, List<EmotionImageData> list) {
        if (TextUtils.isEmpty(str) || ListUtils.isEmpty(list)) {
            return;
        }
        if (f19334g == null) {
            f19334g = new LinkedHashMap<>();
        }
        if (f19334g.containsKey(str)) {
            return;
        }
        if (f19334g.size() > 10) {
            Map.Entry<String, List<EmotionImageData>> next = f19334g.entrySet().iterator().next();
            if (next != null) {
                f19334g.remove(next.getKey());
            } else {
                f19334g.clear();
            }
        }
        f19334g.put(str, list);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.f19336f);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION, TbConfig.SERVER_ADDRESS + "c/e/meme/sugQuery");
        tbHttpMessageTask.setResponsedClass(QueryMatchEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final List<EmotionImageData> y(String str) {
        LinkedHashMap<String, List<EmotionImageData>> linkedHashMap = f19334g;
        if (linkedHashMap == null || !linkedHashMap.containsKey(str)) {
            return null;
        }
        return f19334g.get(str);
    }

    public void z(String str, b bVar) {
        this.f19335e = bVar;
        if (bVar == null) {
            return;
        }
        if (!ListUtils.isEmpty(y(str))) {
            this.f19335e.a(str, f19334g.get(str));
            return;
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_PB_QUERY_MATCH_EMOTION);
        httpMessage.addParam("sug_query", str);
        httpMessage.setExtra(str);
        sendMessage(httpMessage);
    }
}
