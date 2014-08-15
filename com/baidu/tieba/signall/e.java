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
    private static final String d = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/getforumlist";
    private b a;
    private g b;
    private HttpMessage c;
    private final BdUniqueId e;
    private final HttpMessageListener f;

    public e(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.e = BdUniqueId.gen();
        this.f = new f(this, CmdConfigHttp.SIGNALL_GET_FOURMS);
        MessageManager messageManager = MessageManager.getInstance();
        this.a = new b();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, d);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.f);
    }

    public void a(g gVar) {
        this.b = gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.c != null) {
            return false;
        }
        this.c = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.c.addParam(com.baidu.tbadk.core.frameworkData.a.USER_ID, str);
        this.c.setTag(this.e);
        MessageManager.getInstance().sendMessage(this.c);
        return true;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.c != null) {
            MessageManager.getInstance().removeHttpMessage(this.e);
            this.c = null;
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
        return true;
    }
}
