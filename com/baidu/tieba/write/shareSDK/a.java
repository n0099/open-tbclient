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
    private BaseActivity bek;
    private final InterfaceC0081a eZE;

    /* renamed from: com.baidu.tieba.write.shareSDK.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0081a {
        void a(boolean z, PostPrefixData postPrefixData);

        void bbT();
    }

    public a(BaseActivity baseActivity, InterfaceC0081a interfaceC0081a) {
        this.bek = baseActivity;
        this.eZE = interfaceC0081a;
        bbS();
    }

    public void pf(String str) {
        if (this.bek != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD);
            httpMessage.addParam(ImageViewerConfig.FORUM_NAME, str);
            this.bek.sendMessage(httpMessage);
        }
    }

    public void bbS() {
        if (this.bek != null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/getprefix");
            tbHttpMessageTask.setResponsedClass(ForumPrefixResponsedMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
            this.bek.registerListener(new b(this, CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD));
        }
    }
}
