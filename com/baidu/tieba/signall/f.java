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
public class f extends com.baidu.adp.base.e<SignAllForumActivity> {
    private static final String cAs = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/getforumlist";
    private c cAp;
    private a cAq;
    private HttpMessage cAr;
    private final BdUniqueId cAt;
    private final HttpMessageListener cAu;

    /* loaded from: classes.dex */
    public interface a {
        void a(c cVar);

        void hD(String str);
    }

    public f(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.cAp = null;
        this.cAq = null;
        this.cAt = BdUniqueId.gen();
        this.cAu = new g(this, CmdConfigHttp.SIGNALL_GET_FOURMS);
        MessageManager messageManager = MessageManager.getInstance();
        this.cAp = new c();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, cAs);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.cAu);
    }

    public void a(a aVar) {
        this.cAq = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.cAr != null) {
            return false;
        }
        this.cAr = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.cAr.addParam("user_id", str);
        this.cAr.setTag(this.cAt);
        MessageManager.getInstance().sendMessage(this.cAr);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.cAr != null) {
            MessageManager.getInstance().removeHttpMessage(this.cAt);
            this.cAr = null;
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
        return true;
    }
}
