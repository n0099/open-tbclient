package com.baidu.tieba.tbadkCore;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class PraiseModel extends BdBaseModel {
    public static final int LIKE = 1;
    public static final int UN_LIKE = 0;
    private static final String gjN = TbConfig.SERVER_ADDRESS + TbConfig.COMMON_PRAISE_URL;
    private static TbHttpMessageTask task = new TbHttpMessageTask(1001600, gjN);
    private final HttpMessageListener gjO;
    private a nvX;

    /* loaded from: classes.dex */
    public interface a {
        void Fb(String str);

        void onLoadFailed(int i, String str);
    }

    static {
        task.setResponsedClass(PraiseResponseMessage.class);
        MessageManager.getInstance().registerTask(task);
    }

    public PraiseModel(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.nvX = null;
        this.gjO = new HttpMessageListener(1001600) { // from class: com.baidu.tieba.tbadkCore.PraiseModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    if (statusCode != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                        if (PraiseModel.this.nvX != null) {
                            PraiseModel.this.nvX.onLoadFailed(statusCode, null);
                            return;
                        }
                        return;
                    }
                    PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
                    if (praiseResponseMessage.getError() == 0) {
                        PraiseModel.this.nvX.Fb(praiseResponseMessage.getErrMsg());
                    } else if (PraiseModel.this.nvX != null) {
                        PraiseModel.this.nvX.onLoadFailed(praiseResponseMessage.getError(), praiseResponseMessage.getErrMsg());
                    }
                }
            }
        };
        this.nvX = aVar;
    }

    public void registerListener() {
        this.gjO.setSelfListener(true);
        this.gjO.setTag(getUniqueId());
        registerListener(this.gjO);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
