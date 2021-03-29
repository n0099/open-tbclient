package com.baidu.tieba.tbadkCore;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes5.dex */
public class PraiseModel extends BdBaseModel {
    public static final int LIKE = 1;
    public static final int UN_LIKE = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final String f21329g;

    /* renamed from: h  reason: collision with root package name */
    public static TbHttpMessageTask f21330h;

    /* renamed from: e  reason: collision with root package name */
    public b f21331e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f21332f;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001600) {
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            if (statusCode != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                if (PraiseModel.this.f21331e != null) {
                    PraiseModel.this.f21331e.b(statusCode, null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                PraiseModel.this.f21331e.a(praiseResponseMessage.getErrMsg());
            } else if (PraiseModel.this.f21331e != null) {
                PraiseModel.this.f21331e.b(praiseResponseMessage.getError(), praiseResponseMessage.getErrMsg());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(String str);

        void b(int i, String str);
    }

    static {
        String str = TbConfig.SERVER_ADDRESS + TbConfig.COMMON_PRAISE_URL;
        f21329g = str;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.COMMON_PRAISE_Y_OR_N, str);
        f21330h = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(PraiseResponseMessage.class);
        MessageManager.getInstance().registerTask(f21330h);
    }

    public PraiseModel(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        this.f21331e = null;
        this.f21332f = new a(CmdConfigHttp.COMMON_PRAISE_Y_OR_N);
        this.f21331e = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void registerListener() {
        this.f21332f.setSelfListener(true);
        this.f21332f.setTag(getUniqueId());
        registerListener(this.f21332f);
    }
}
