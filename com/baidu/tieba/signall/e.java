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
    private static final String bPg = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/getforumlist";
    private b bPd;
    private g bPe;
    private HttpMessage bPf;
    private final BdUniqueId bPh;
    private final HttpMessageListener bPi;

    public e(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.bPd = null;
        this.bPe = null;
        this.bPh = BdUniqueId.gen();
        this.bPi = new f(this, CmdConfigHttp.SIGNALL_GET_FOURMS);
        MessageManager messageManager = MessageManager.getInstance();
        this.bPd = new b();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, bPg);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bPi);
    }

    public void a(g gVar) {
        this.bPe = gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.f
    public boolean LoadData() {
        if (this.bPf != null) {
            return false;
        }
        this.bPf = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.bPf.addParam("user_id", str);
        this.bPf.setTag(this.bPh);
        MessageManager.getInstance().sendMessage(this.bPf);
        return true;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.bPf != null) {
            MessageManager.getInstance().removeHttpMessage(this.bPh);
            this.bPf = null;
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
        return true;
    }
}
