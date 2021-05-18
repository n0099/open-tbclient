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
    public static final String f20849g;

    /* renamed from: h  reason: collision with root package name */
    public static TbHttpMessageTask f20850h;

    /* renamed from: e  reason: collision with root package name */
    public b f20851e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f20852f;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001600) {
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            if (statusCode != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                if (PraiseModel.this.f20851e != null) {
                    PraiseModel.this.f20851e.b(statusCode, null);
                    return;
                }
                return;
            }
            PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
            if (praiseResponseMessage.getError() == 0) {
                PraiseModel.this.f20851e.a(praiseResponseMessage.getErrMsg());
            } else if (PraiseModel.this.f20851e != null) {
                PraiseModel.this.f20851e.b(praiseResponseMessage.getError(), praiseResponseMessage.getErrMsg());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(String str);

        void b(int i2, String str);
    }

    static {
        String str = TbConfig.SERVER_ADDRESS + TbConfig.COMMON_PRAISE_URL;
        f20849g = str;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.COMMON_PRAISE_Y_OR_N, str);
        f20850h = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(PraiseResponseMessage.class);
        MessageManager.getInstance().registerTask(f20850h);
    }

    public PraiseModel(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        this.f20851e = null;
        this.f20852f = new a(CmdConfigHttp.COMMON_PRAISE_Y_OR_N);
        this.f20851e = bVar;
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
        this.f20852f.setSelfListener(true);
        this.f20852f.setTag(getUniqueId());
        registerListener(this.f20852f);
    }
}
