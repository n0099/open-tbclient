package com.baidu.tieba.newfaceshop.facemake;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.newfaceshop.FaceBaseModel;
import java.util.List;
/* loaded from: classes4.dex */
public class GetHotWordsModel extends FaceBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public b f19252e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f19253f = new a(CmdConfigHttp.CMD_GET_FACE_MAKE_HOT_WORDS);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003352 || !(httpResponsedMessage instanceof GetHotWordsMessage) || GetHotWordsModel.this.f19252e == null) {
                return;
            }
            GetHotWordsMessage getHotWordsMessage = (GetHotWordsMessage) httpResponsedMessage;
            if (getHotWordsMessage.getData() != null) {
                GetHotWordsModel.this.f19252e.onSuccess(getHotWordsMessage.getData());
            } else {
                GetHotWordsModel.this.f19252e.onFail(getHotWordsMessage.getError(), getHotWordsMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onFail(int i, String str);

        void onSuccess(List<String> list);
    }

    public GetHotWordsModel() {
        setUniqueId(BdUniqueId.gen());
        registerTask();
        this.f19253f.setTag(getUniqueId());
        this.f19253f.setSelfListener(true);
        registerListener(this.f19253f);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.f19253f);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_FACE_MAKE_HOT_WORDS);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FACE_MAKE_HOT_WORDS, TbConfig.SERVER_ADDRESS + "c/e/meme/getHotWords");
        tbHttpMessageTask.setResponsedClass(GetHotWordsMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void t(b bVar) {
        this.f19252e = bVar;
        sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_FACE_MAKE_HOT_WORDS));
    }
}
