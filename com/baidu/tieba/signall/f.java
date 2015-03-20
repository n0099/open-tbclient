package com.baidu.tieba.signall;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f<SignAllForumActivity> {
    private static final String cdK = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/getforumlist";
    private c cdH;
    private h cdI;
    private HttpMessage cdJ;
    private final BdUniqueId cdL;
    private final HttpMessageListener cdM;

    public f(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.cdH = null;
        this.cdI = null;
        this.cdL = BdUniqueId.gen();
        this.cdM = new g(this, CmdConfigHttp.SIGNALL_GET_FOURMS);
        MessageManager messageManager = MessageManager.getInstance();
        this.cdH = new c();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, cdK);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.cdM);
    }

    public void a(h hVar) {
        this.cdI = hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.f
    public boolean LoadData() {
        if (this.cdJ != null) {
            return false;
        }
        this.cdJ = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.cdJ.addParam("user_id", str);
        this.cdJ.setTag(this.cdL);
        MessageManager.getInstance().sendMessage(this.cdJ);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.cdJ != null) {
            MessageManager.getInstance().removeHttpMessage(this.cdL);
            this.cdJ = null;
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
        return true;
    }
}
