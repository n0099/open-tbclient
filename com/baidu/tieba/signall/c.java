package com.baidu.tieba.signall;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.base.b {
    private static final String d = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/getforumlist";
    private a a;
    private HttpMessage c;
    private e b = null;
    private HttpMessageListener e = new d(this, 1004001);

    public c() {
        this.a = null;
        MessageManager messageManager = MessageManager.getInstance();
        this.a = new a();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1004001, d);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        messageManager.registerListener(this.e);
    }

    public void a(e eVar) {
        this.b = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.b
    public boolean LoadData() {
        if (this.c != null) {
            return false;
        }
        this.c = new HttpMessage(1004001);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.c.addParam(com.baidu.tbadk.core.frameworkData.a.USER_ID, str);
        this.c.setTag(1004001);
        MessageManager.getInstance().sendMessage(this.c);
        return true;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        if (this.c != null) {
            MessageManager.getInstance().removeHttpMessage(1004001);
            this.c = null;
        }
        MessageManager.getInstance().unRegisterListener(this.e);
        MessageManager.getInstance().unRegisterTask(1004001);
        return true;
    }
}
