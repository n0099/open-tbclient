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
import d.a.c.a.f;
import java.util.ArrayList;
import java.util.List;
import tbclient.T;
/* loaded from: classes5.dex */
public class GetSugMatchWordsModel extends BdBaseModel {

    /* renamed from: g  reason: collision with root package name */
    public static List<String> f19248g = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public b f19249e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f19250f;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003370 || !(httpResponsedMessage instanceof GetSugMatchWordsResponseMessage) || GetSugMatchWordsModel.this.f19249e == null) {
                return;
            }
            GetSugMatchWordsResponseMessage getSugMatchWordsResponseMessage = (GetSugMatchWordsResponseMessage) httpResponsedMessage;
            if (!ListUtils.isEmpty(getSugMatchWordsResponseMessage.getData())) {
                GetSugMatchWordsModel.this.f19249e.onSuccess(getSugMatchWordsResponseMessage.getData());
                GetSugMatchWordsModel.f19248g.clear();
                GetSugMatchWordsModel.f19248g.addAll(getSugMatchWordsResponseMessage.getData());
                return;
            }
            GetSugMatchWordsModel.this.f19249e.onFail(getSugMatchWordsResponseMessage.getError(), getSugMatchWordsResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onFail(int i2, String str);

        void onSuccess(List<String> list);
    }

    public GetSugMatchWordsModel(f<T> fVar) {
        super(fVar);
        this.f19250f = new a(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS);
        registerTask();
        this.f19250f.setSelfListener(true);
        registerListener(this.f19250f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.f19250f);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS, TbConfig.SERVER_ADDRESS + "c/e/meme/getSugKeyWords");
        tbHttpMessageTask.setResponsedClass(GetSugMatchWordsResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void y(b bVar) {
        this.f19249e = bVar;
        if (bVar == null) {
            return;
        }
        if (!ListUtils.isEmpty(f19248g)) {
            this.f19249e.onSuccess(f19248g);
        } else {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_PB_SUG_MATCH_WORDS));
        }
    }
}
