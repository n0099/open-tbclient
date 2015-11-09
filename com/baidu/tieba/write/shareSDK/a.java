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
    private BaseActivity aSm;
    private final InterfaceC0080a dnH;

    /* renamed from: com.baidu.tieba.write.shareSDK.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0080a {
        void a(boolean z, PostPrefixData postPrefixData);

        void aCF();
    }

    public a(BaseActivity baseActivity, InterfaceC0080a interfaceC0080a) {
        this.aSm = baseActivity;
        this.dnH = interfaceC0080a;
        aCE();
    }

    public void mv(String str) {
        if (this.aSm != null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD);
            httpMessage.addParam(ImageViewerConfig.FORUM_NAME, str);
            this.aSm.sendMessage(httpMessage);
        }
    }

    public void aCE() {
        if (this.aSm != null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/getprefix");
            tbHttpMessageTask.setResponsedClass(ForumPrefixResponsedMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
            this.aSm.registerListener(new b(this, CmdConfigHttp.SHARE_GET_FORUM_PROFIX_HTTP_CMD));
        }
    }
}
