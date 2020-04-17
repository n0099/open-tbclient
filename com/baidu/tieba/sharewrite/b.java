package com.baidu.tieba.sharewrite;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class b {
    private final a kHC;
    private BaseActivity mActivity;

    /* loaded from: classes11.dex */
    public interface a {
        void a(boolean z, PostPrefixData postPrefixData);

        void onFailure();
    }

    public b(BaseActivity baseActivity, a aVar) {
        this.mActivity = baseActivity;
        this.kHC = aVar;
        cSF();
    }

    public void Kk(String str) {
        if (this.mActivity != null) {
            HttpMessage httpMessage = new HttpMessage(1002701);
            httpMessage.addParam("fname", str);
            this.mActivity.sendMessage(httpMessage);
        }
    }

    public void cSF() {
        if (this.mActivity != null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002701, TbConfig.SERVER_ADDRESS + Config.SHARE_GET_FORUM_PREFIX_URL);
            tbHttpMessageTask.setResponsedClass(ForumPrefixResponsedMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
            this.mActivity.registerListener(new HttpMessageListener(1002701) { // from class: com.baidu.tieba.sharewrite.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (b.this.kHC != null) {
                        if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1002701) {
                            b.this.kHC.onFailure();
                            return;
                        }
                        int statusCode = httpResponsedMessage.getStatusCode();
                        int error = httpResponsedMessage.getError();
                        if (statusCode == 200 && error == 0 && (httpResponsedMessage instanceof ForumPrefixResponsedMessage)) {
                            ForumPrefixResponsedMessage forumPrefixResponsedMessage = (ForumPrefixResponsedMessage) httpResponsedMessage;
                            b.this.kHC.a(forumPrefixResponsedMessage.isHasPostpre(), forumPrefixResponsedMessage.getData());
                        }
                    }
                }
            });
        }
    }
}
