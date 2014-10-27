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
    private static final String bKB = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/getforumlist";
    private HttpMessage bKA;
    private final BdUniqueId bKC;
    private final HttpMessageListener bKD;
    private b bKy;
    private g bKz;

    public e(Context context) {
        super(context);
        this.bKy = null;
        this.bKz = null;
        this.bKC = BdUniqueId.gen();
        this.bKD = new f(this, CmdConfigHttp.SIGNALL_GET_FOURMS);
        MessageManager messageManager = MessageManager.getInstance();
        this.bKy = new b();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, bKB);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.bKD);
    }

    public void a(g gVar) {
        this.bKz = gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.bKA != null) {
            return false;
        }
        this.bKA = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.bKA.addParam(com.baidu.tbadk.core.frameworkData.a.USER_ID, str);
        this.bKA.setTag(this.bKC);
        MessageManager.getInstance().sendMessage(this.bKA);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.bKA != null) {
            MessageManager.getInstance().removeHttpMessage(this.bKC);
            this.bKA = null;
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
        return true;
    }
}
