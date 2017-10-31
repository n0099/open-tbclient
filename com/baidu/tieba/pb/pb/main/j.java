package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class j {
    private BaseActivity brJ;
    private a eMR = null;
    private final HttpMessageListener eMS = new HttpMessageListener(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD) { // from class: com.baidu.tieba.pb.pb.main.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001803 && j.this.eMR != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                String errorString = httpResponsedMessage.getErrorString();
                if (!(httpResponsedMessage instanceof HideChudianPostResponseMessage)) {
                    j.this.eMR.onError(error, errorString);
                    return;
                }
                HideChudianPostResponseMessage hideChudianPostResponseMessage = (HideChudianPostResponseMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    j.this.eMR.onError(error, errorString);
                    return;
                }
                hideChudianPostResponseMessage.getResultFlag();
                j.this.eMR.k(hideChudianPostResponseMessage.getResultFlag(), hideChudianPostResponseMessage.getTemplateId());
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void k(int i, long j);

        void onError(int i, String str);
    }

    public j(PbModel pbModel, BaseActivity baseActivity) {
        this.brJ = baseActivity;
        aSo();
        this.brJ.registerListener(this.eMS);
    }

    public void a(a aVar) {
        this.eMR = aVar;
    }

    public void aSo() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/b/commit/tpointhide");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(HideChudianPostResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void co(long j) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_HIDE_CHUDIAN_HTTP_CMD);
        httpMessage.addParam("template_id", String.valueOf(j));
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
