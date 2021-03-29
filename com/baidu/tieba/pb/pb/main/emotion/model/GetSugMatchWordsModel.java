package com.baidu.tieba.pb.pb.main.emotion.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.emotion.message.GetSugMatchWordsResponseMessage;
import d.b.b.a.f;
import java.util.ArrayList;
import java.util.List;
import tbclient.T;
/* loaded from: classes4.dex */
public class GetSugMatchWordsModel extends BdBaseModel {

    /* renamed from: g  reason: collision with root package name */
    public static List<String> f19798g = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public b f19799e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f19800f;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003370 || !(httpResponsedMessage instanceof GetSugMatchWordsResponseMessage) || GetSugMatchWordsModel.this.f19799e == null) {
                return;
            }
            GetSugMatchWordsResponseMessage getSugMatchWordsResponseMessage = (GetSugMatchWordsResponseMessage) httpResponsedMessage;
            if (!ListUtils.isEmpty(getSugMatchWordsResponseMessage.getData())) {
                GetSugMatchWordsModel.this.f19799e.onSuccess(getSugMatchWordsResponseMessage.getData());
                GetSugMatchWordsModel.f19798g.clear();
                GetSugMatchWordsModel.f19798g.addAll(getSugMatchWordsResponseMessage.getData());
                return;
            }
            GetSugMatchWordsModel.this.f19799e.onFail(getSugMatchWordsResponseMessage.getError(), getSugMatchWordsResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onFail(int i, String str);

        void onSuccess(List<String> list);
    }

    public GetSugMatchWordsModel(f<T> fVar) {
        super(fVar);
        this.f19800f = new a(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS);
        registerTask();
        this.f19800f.setSelfListener(true);
        registerListener(this.f19800f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.f19800f);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS, TbConfig.SERVER_ADDRESS + "c/e/meme/getSugKeyWords");
        tbHttpMessageTask.setResponsedClass(GetSugMatchWordsResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void u(b bVar) {
        this.f19799e = bVar;
        if (bVar == null) {
            return;
        }
        if (!ListUtils.isEmpty(f19798g)) {
            this.f19799e.onSuccess(f19798g);
        } else {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS));
        }
    }
}
