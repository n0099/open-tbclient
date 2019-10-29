package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class h {
    private a hOK = null;
    private final HttpMessageListener hOL = new HttpMessageListener(1001803) { // from class: com.baidu.tieba.pb.pb.main.h.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001803 && h.this.hOK != null) {
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                String errorString = httpResponsedMessage.getErrorString();
                if (!(httpResponsedMessage instanceof HideChudianPostResponseMessage)) {
                    h.this.hOK.onError(error, errorString);
                    return;
                }
                HideChudianPostResponseMessage hideChudianPostResponseMessage = (HideChudianPostResponseMessage) httpResponsedMessage;
                if (statusCode != 200 || error != 0) {
                    h.this.hOK.onError(error, errorString);
                    return;
                }
                hideChudianPostResponseMessage.getResultFlag();
                h.this.hOK.v(hideChudianPostResponseMessage.getResultFlag(), hideChudianPostResponseMessage.getTemplateId());
            }
        }
    };
    private BaseActivity mActivity;

    /* loaded from: classes4.dex */
    public interface a {
        void onError(int i, String str);

        void v(int i, long j);
    }

    public h(PbModel pbModel, BaseActivity baseActivity) {
        this.mActivity = baseActivity;
        bTl();
        this.mActivity.registerListener(this.hOL);
    }

    public void a(a aVar) {
        this.hOK = aVar;
    }

    public void bTl() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001803, TbConfig.SERVER_ADDRESS + Config.HIDE_TPOINT_POST);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(HideChudianPostResponseMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public void dJ(long j) {
        HttpMessage httpMessage = new HttpMessage(1001803);
        httpMessage.addParam("template_id", String.valueOf(j));
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
