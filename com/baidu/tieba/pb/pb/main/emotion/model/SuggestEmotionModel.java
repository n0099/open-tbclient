package com.baidu.tieba.pb.pb.main.emotion.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.pb.main.emotion.message.SuggestEmotionResponseMessage;
import d.a.c.e.m.e;
/* loaded from: classes3.dex */
public class SuggestEmotionModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public c f19971e;

    /* renamed from: f  reason: collision with root package name */
    public String f19972f;

    /* renamed from: g  reason: collision with root package name */
    public String f19973g;

    /* renamed from: h  reason: collision with root package name */
    public final CustomMessageListener f19974h = new a(2921322);

    /* renamed from: i  reason: collision with root package name */
    public final HttpMessageListener f19975i = new b(CmdConfigHttp.CMD_GET_SUGGEST_EMOTION);

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {

        /* renamed from: com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0218a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f19977e;

            public RunnableC0218a(CustomResponsedMessage customResponsedMessage) {
                this.f19977e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_SUGGEST_EMOTION);
                httpMessage.addParam("forum_id", SuggestEmotionModel.this.f19972f);
                httpMessage.addParam("forum_name", SuggestEmotionModel.this.f19973g);
                httpMessage.addParam("has_pkg", (String) this.f19977e.getData());
                SuggestEmotionModel.this.sendMessage(httpMessage);
            }
        }

        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                e.a().post(new RunnableC0218a(customResponsedMessage));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003329 || !(httpResponsedMessage instanceof SuggestEmotionResponseMessage) || SuggestEmotionModel.this.f19971e == null) {
                return;
            }
            SuggestEmotionResponseMessage suggestEmotionResponseMessage = (SuggestEmotionResponseMessage) httpResponsedMessage;
            if (suggestEmotionResponseMessage.getData() != null) {
                SuggestEmotionModel.this.f19971e.a(suggestEmotionResponseMessage.getData());
            } else {
                SuggestEmotionModel.this.f19971e.onFail(suggestEmotionResponseMessage.getError(), suggestEmotionResponseMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(d.a.j0.d2.k.e.a1.e.a aVar);

        void onFail(int i2, String str);
    }

    public SuggestEmotionModel() {
        registerTask();
        this.f19975i.setTag(getUniqueId());
        this.f19975i.setSelfListener(true);
        registerListener(this.f19975i);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterListener(this.f19975i);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_SUGGEST_EMOTION);
        MessageManager.getInstance().unRegisterListener(this.f19974h);
        return true;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_SUGGEST_EMOTION, TbConfig.SERVER_ADDRESS + "c/e/meme/suggest");
        tbHttpMessageTask.setResponsedClass(SuggestEmotionResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.f19974h);
    }

    public void v(String str, String str2, c cVar) {
        this.f19971e = cVar;
        this.f19972f = str;
        this.f19973g = str2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004612, new Integer(2921322)));
    }
}
