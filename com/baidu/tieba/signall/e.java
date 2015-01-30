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
public class e extends com.baidu.adp.base.f<SignAllForumActivity> {
    private static final String bQQ = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/getforumlist";
    private b bQN;
    private g bQO;
    private HttpMessage bQP;
    private final BdUniqueId bQR;
    private final HttpMessageListener bQS;

    public e(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.bQN = null;
        this.bQO = null;
        this.bQR = BdUniqueId.gen();
        this.bQS = new f(this, CmdConfigHttp.SIGNALL_GET_FOURMS);
        MessageManager messageManager = MessageManager.getInstance();
        this.bQN = new b();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, bQQ);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bQS);
    }

    public void a(g gVar) {
        this.bQO = gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.f
    public boolean LoadData() {
        if (this.bQP != null) {
            return false;
        }
        this.bQP = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.bQP.addParam("user_id", str);
        this.bQP.setTag(this.bQR);
        MessageManager.getInstance().sendMessage(this.bQP);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.bQP != null) {
            MessageManager.getInstance().removeHttpMessage(this.bQR);
            this.bQP = null;
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
        return true;
    }
}
