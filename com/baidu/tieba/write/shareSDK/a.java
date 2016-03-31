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
    private BaseActivity bix;
    private final InterfaceC0088a eIN;

    /* renamed from: com.baidu.tieba.write.shareSDK.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0088a {
        void a(boolean z, PostPrefixData postPrefixData);

        void aZH();
    }

    public a(BaseActivity baseActivity, InterfaceC0088a interfaceC0088a) {
        this.bix = baseActivity;
        this.eIN = interfaceC0088a;
        aZG();
    }

    public void oR(String str) {
        if (this.bix != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD);
            httpMessage.addParam(ImageViewerConfig.FORUM_NAME, str);
            this.bix.sendMessage(httpMessage);
        }
    }

    public void aZG() {
        if (this.bix != null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/getprefix");
            tbHttpMessageTask.setResponsedClass(ForumPrefixResponsedMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
            this.bix.registerListener(new b(this, CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD));
        }
    }
}
