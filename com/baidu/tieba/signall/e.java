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
    private static final String bQP = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/getforumlist";
    private b bQM;
    private g bQN;
    private HttpMessage bQO;
    private final BdUniqueId bQQ;
    private final HttpMessageListener bQR;

    public e(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.bQM = null;
        this.bQN = null;
        this.bQQ = BdUniqueId.gen();
        this.bQR = new f(this, CmdConfigHttp.SIGNALL_GET_FOURMS);
        MessageManager messageManager = MessageManager.getInstance();
        this.bQM = new b();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, bQP);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bQR);
    }

    public void a(g gVar) {
        this.bQN = gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.f
    public boolean LoadData() {
        if (this.bQO != null) {
            return false;
        }
        this.bQO = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.bQO.addParam("user_id", str);
        this.bQO.setTag(this.bQQ);
        MessageManager.getInstance().sendMessage(this.bQO);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.bQO != null) {
            MessageManager.getInstance().removeHttpMessage(this.bQQ);
            this.bQO = null;
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
        return true;
    }
}
