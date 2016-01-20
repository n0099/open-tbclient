package com.baidu.tieba.write.shareSDK;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class a {
    private BaseActivity bbA;
    private final InterfaceC0085a dUm;

    /* renamed from: com.baidu.tieba.write.shareSDK.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0085a {
        void a(boolean z, PostPrefixData postPrefixData);

        void aKx();
    }

    public a(BaseActivity baseActivity, InterfaceC0085a interfaceC0085a) {
        this.bbA = baseActivity;
        this.dUm = interfaceC0085a;
        aKw();
    }

    public void np(String str) {
        if (this.bbA != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD);
            httpMessage.addParam(ImageViewerConfig.FORUM_NAME, str);
            this.bbA.sendMessage(httpMessage);
        }
    }

    public void aKw() {
        if (this.bbA != null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/getprefix");
            tbHttpMessageTask.setResponsedClass(ForumPrefixResponsedMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
            this.bbA.registerListener(new b(this, CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD));
        }
    }
}
