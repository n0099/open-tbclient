package com.baidu.tieba.sharewrite;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes6.dex */
public class b {
    private BaseActivity cNd;
    private final a ivS;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, PostPrefixData postPrefixData);

        void onFailure();
    }

    public b(BaseActivity baseActivity, a aVar) {
        this.cNd = baseActivity;
        this.ivS = aVar;
        cbb();
    }

    public void Ce(String str) {
        if (this.cNd != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD);
            httpMessage.addParam(ImageViewerConfig.FORUM_NAME, str);
            this.cNd.sendMessage(httpMessage);
        }
    }

    public void cbb() {
        if (this.cNd != null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD, TbConfig.SERVER_ADDRESS + "c/f/forum/getprefix");
            tbHttpMessageTask.setResponsedClass(ForumPrefixResponsedMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
            this.cNd.registerListener(new HttpMessageListener(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD) { // from class: com.baidu.tieba.sharewrite.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (b.this.ivS != null) {
                        if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1002701) {
                            b.this.ivS.onFailure();
                            return;
                        }
                        int statusCode = httpResponsedMessage.getStatusCode();
                        int error = httpResponsedMessage.getError();
                        if (statusCode == 200 && error == 0 && (httpResponsedMessage instanceof ForumPrefixResponsedMessage)) {
                            ForumPrefixResponsedMessage forumPrefixResponsedMessage = (ForumPrefixResponsedMessage) httpResponsedMessage;
                            b.this.ivS.a(forumPrefixResponsedMessage.isHasPostpre(), forumPrefixResponsedMessage.getData());
                        }
                    }
                }
            });
        }
    }
}
