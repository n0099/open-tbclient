package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes7.dex */
public class j {
    private BaseFragmentActivity gpB;
    private a iDO = null;
    private final HttpMessageListener iDP = new HttpMessageListener(1001803) { // from class: com.baidu.tieba.pb.pb.main.j.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001803 && j.this.iDO != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                String errorString = httpResponsedMessage.getErrorString();
                if (!(httpResponsedMessage instanceof HideChudianPostResponseMessage)) {
                    j.this.iDO.onError(error, errorString);
                    return;
                }
                HideChudianPostResponseMessage hideChudianPostResponseMessage = (HideChudianPostResponseMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    j.this.iDO.onError(error, errorString);
                    return;
                }
                hideChudianPostResponseMessage.getResultFlag();
                j.this.iDO.z(hideChudianPostResponseMessage.getResultFlag(), hideChudianPostResponseMessage.getTemplateId());
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void onError(int i, String str);

        void z(int i, long j);
    }

    public j(PbModel pbModel, BaseFragmentActivity baseFragmentActivity) {
        this.gpB = baseFragmentActivity;
        ckL();
        this.gpB.registerListener(this.iDP);
    }

    public void a(a aVar) {
        this.iDO = aVar;
    }

    public void ckL() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001803, TbConfig.SERVER_ADDRESS + Config.HIDE_TPOINT_POST);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(HideChudianPostResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void et(long j) {
        HttpMessage httpMessage = new HttpMessage(1001803);
        httpMessage.addParam("template_id", String.valueOf(j));
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
