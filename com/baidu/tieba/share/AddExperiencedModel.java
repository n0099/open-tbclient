package com.baidu.tieba.share;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.pb.data.ContriInfo;
import d.b.c.e.m.e;
/* loaded from: classes4.dex */
public class AddExperiencedModel extends BdBaseModel {
    public static final int DELAY_TIME = 2000;
    public static int MAX_ADD_ADVANCED = 6;
    public static int MAX_ADD_NORMAL = 3;
    public static String USELESS_FORUM_ID = "24981790";

    /* renamed from: e  reason: collision with root package name */
    public c f20796e;

    /* renamed from: f  reason: collision with root package name */
    public ContriInfo f20797f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f20798g;

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f20799h;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AddExperiencedModel.this.f20796e != null) {
                AddExperiencedModel.this.f20796e.a(AddExperiencedModel.this.f20797f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public b(int i, boolean z) {
            super(i, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AddExperiencedResponseMessage)) {
                AddExperiencedModel.this.f20797f = ((AddExperiencedResponseMessage) httpResponsedMessage).getContriInfo();
                e.a().postDelayed(AddExperiencedModel.this.f20798g, 2000L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(ContriInfo contriInfo);
    }

    public AddExperiencedModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f20798g = new a();
        this.f20799h = new b(CmdConfigHttp.CMD_ADD_EXPERIENCED, true);
        registerTask();
        registerListener(this.f20799h);
    }

    public static boolean x(String str) {
        return d.b.c.e.m.b.f(str, 0L) > 0 && !USELESS_FORUM_ID.equals(str);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        e.a().removeCallbacks(this.f20798g);
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_EXPERIENCED, TbConfig.SERVER_ADDRESS + TbConfig.URL_ADD_EXPERIENCED);
        tbHttpMessageTask.setResponsedClass(AddExperiencedResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void w(String str, String str2) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_ADD_EXPERIENCED);
        httpMessage.addParam("forum_id", str);
        httpMessage.addParam("thread_id", str2);
        sendMessage(httpMessage);
    }
}
