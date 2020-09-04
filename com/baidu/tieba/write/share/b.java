package com.baidu.tieba.write.share;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private HttpMessageListener mHttpMessageListener = new HttpMessageListener(CmdConfigHttp.CMD_CHECK_SHARE_SDK) { // from class: com.baidu.tieba.write.share.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof CheckResponse) {
                c checkResponseData = ((CheckResponse) httpResponsedMessage).getCheckResponseData();
                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    httpResponsedMessage.setErrorString(TbadkCoreApplication.getInst().getString(R.string.share_sdk_check_no_resp));
                }
                if (b.this.mQj != null) {
                    b.this.mQj.a(checkResponseData, httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private BdUniqueId mPageId;
    private a mQj;

    public b(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
        init();
    }

    private void init() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerTask(dGL());
        this.mHttpMessageListener.setTag(this.mPageId);
        messageManager.registerListener(this.mHttpMessageListener);
    }

    private HttpMessageTask dGL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CHECK_SHARE_SDK, TbConfig.CHECK_SHARE_SDK_URL);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setRetry(3);
        tbHttpMessageTask.setResponsedClass(CheckResponse.class);
        return tbHttpMessageTask;
    }

    public void a(a aVar) {
        this.mQj = aVar;
    }

    public void gh(String str, String str2) {
        if (StringUtils.isNull(str)) {
            if (this.mQj != null) {
                this.mQj.a(null, -2112, TbadkCoreApplication.getInst().getString(R.string.check_share_sdk_appkey_null));
                return;
            }
            return;
        }
        MessageManager.getInstance().removeHttpMessage(this.mPageId);
        CheckRequest checkRequest = new CheckRequest();
        checkRequest.setTag(this.mPageId);
        checkRequest.setAppkey(str);
        checkRequest.setAppletsKey(str2);
        MessageManager.getInstance().sendMessage(checkRequest);
    }
}
