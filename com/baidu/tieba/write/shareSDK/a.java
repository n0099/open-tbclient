package com.baidu.tieba.write.shareSDK;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class a {
    private final c cAb;
    private BaseActivity mActivity;

    public a(BaseActivity baseActivity, c cVar) {
        this.mActivity = baseActivity;
        this.cAb = cVar;
        asr();
    }

    public void kb(String str) {
        if (this.mActivity != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD);
            httpMessage.addParam(ImageViewerConfig.FORUM_NAME, str);
            this.mActivity.sendMessage(httpMessage);
        }
    }

    public void asr() {
        if (this.mActivity != null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/getprefix");
            tbHttpMessageTask.setResponsedClass(ForumPrefixResponsedMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
            this.mActivity.registerListener(new b(this, CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD));
        }
    }
}
