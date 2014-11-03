package com.baidu.tieba.signall;

import android.content.Context;
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
public class e extends com.baidu.adp.base.e {
    private static final String bKQ = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/getforumlist";
    private b bKN;
    private g bKO;
    private HttpMessage bKP;
    private final BdUniqueId bKR;
    private final HttpMessageListener bKS;

    public e(Context context) {
        super(context);
        this.bKN = null;
        this.bKO = null;
        this.bKR = BdUniqueId.gen();
        this.bKS = new f(this, CmdConfigHttp.SIGNALL_GET_FOURMS);
        MessageManager messageManager = MessageManager.getInstance();
        this.bKN = new b();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, bKQ);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bKS);
    }

    public void a(g gVar) {
        this.bKO = gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.bKP != null) {
            return false;
        }
        this.bKP = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.bKP.addParam(com.baidu.tbadk.core.frameworkData.a.USER_ID, str);
        this.bKP.setTag(this.bKR);
        MessageManager.getInstance().sendMessage(this.bKP);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bKP != null) {
            MessageManager.getInstance().removeHttpMessage(this.bKR);
            this.bKP = null;
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
        return true;
    }
}
