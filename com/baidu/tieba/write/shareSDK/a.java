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
    private BaseActivity aXA;
    private final InterfaceC0089a dMN;

    /* renamed from: com.baidu.tieba.write.shareSDK.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0089a {
        void a(boolean z, PostPrefixData postPrefixData);

        void aIc();
    }

    public a(BaseActivity baseActivity, InterfaceC0089a interfaceC0089a) {
        this.aXA = baseActivity;
        this.dMN = interfaceC0089a;
        aIb();
    }

    public void nq(String str) {
        if (this.aXA != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD);
            httpMessage.addParam(ImageViewerConfig.FORUM_NAME, str);
            this.aXA.sendMessage(httpMessage);
        }
    }

    public void aIb() {
        if (this.aXA != null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/getprefix");
            tbHttpMessageTask.setResponsedClass(ForumPrefixResponsedMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
            this.aXA.registerListener(new b(this, CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD));
        }
    }
}
