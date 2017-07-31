package com.baidu.tieba.tbadkCore;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class PraiseModel extends BdBaseModel {
    public static final int LIKE = 1;
    public static final int UN_LIKE = 0;
    private static final String baG = TbConfig.SERVER_ADDRESS + TbConfig.COMMON_PRAISE_URL;
    private static TbHttpMessageTask task = new TbHttpMessageTask(CmdConfigHttp.COMMON_PRAISE_Y_OR_N, baG);
    private final HttpMessageListener baH;
    private a ggR;

    /* loaded from: classes.dex */
    public interface a {
        void A(int i, String str);

        void hO(String str);
    }

    static {
        task.setResponsedClass(PraiseResponseMessage.class);
        MessageManager.getInstance().registerTask(task);
    }

    public PraiseModel(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.ggR = null;
        this.baH = new HttpMessageListener(CmdConfigHttp.COMMON_PRAISE_Y_OR_N) { // from class: com.baidu.tieba.tbadkCore.PraiseModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001600) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    if (statusCode != 200 || !(httpResponsedMessage instanceof PraiseResponseMessage)) {
                        if (PraiseModel.this.ggR != null) {
                            PraiseModel.this.ggR.A(statusCode, null);
                            return;
                        }
                        return;
                    }
                    PraiseResponseMessage praiseResponseMessage = (PraiseResponseMessage) httpResponsedMessage;
                    if (praiseResponseMessage.getError() == 0) {
                        PraiseModel.this.ggR.hO(praiseResponseMessage.getErrMsg());
                    } else if (PraiseModel.this.ggR != null) {
                        PraiseModel.this.ggR.A(praiseResponseMessage.getError(), praiseResponseMessage.getErrMsg());
                    }
                }
            }
        };
        this.ggR = aVar;
    }

    public void registerListener() {
        this.baH.setSelfListener(true);
        this.baH.setTag(getUniqueId());
        registerListener(this.baH);
    }

    public void a(String str, String str2, int i, String str3) {
        String str4;
        if (i == 1) {
            str4 = "unlike";
        } else {
            str4 = "like";
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.COMMON_PRAISE_Y_OR_N);
        httpMessage.addParam("st_type", str4);
        httpMessage.addParam("action", str4);
        httpMessage.addParam("post_id", str + "");
        httpMessage.addParam("thread_id", str2 + "");
        httpMessage.addParam("st_param", str3);
        sendMessage(httpMessage);
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
