package com.baidu.tieba.signall;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.e<SignAllForumActivity> {
    private static final String ejd = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/getforumlist";
    private c eja;
    private a ejb;
    private HttpMessage ejc;
    private boolean eje;
    private final BdUniqueId ejf;
    private final HttpMessageListener ejg;

    /* loaded from: classes.dex */
    public interface a {
        void a(c cVar);

        void jm(String str);
    }

    public f(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.eja = null;
        this.ejb = null;
        this.ejf = BdUniqueId.gen();
        this.ejg = new g(this, CmdConfigHttp.SIGNALL_GET_FOURMS);
        this.eje = signAllForumActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        MessageManager messageManager = MessageManager.getInstance();
        this.eja = new c();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, ejd);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.ejg);
    }

    public boolean aQl() {
        return this.eje;
    }

    public void a(a aVar) {
        this.ejb = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.ejc != null) {
            return false;
        }
        this.ejc = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.ejc.addParam("user_id", str);
        this.ejc.setTag(this.ejf);
        MessageManager.getInstance().sendMessage(this.ejc);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
            HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
            try {
                Field declaredField = HttpMessage.class.getDeclaredField("mParams");
                declaredField.setAccessible(true);
                if (declaredField.get(httpMessage) instanceof HashMap) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : ((HashMap) declaredField.get(httpMessage)).entrySet()) {
                        Object value = entry.getValue();
                        sb.append("key=").append((String) entry.getKey());
                        sb.append("value=").append(value.toString());
                        sb.append("&");
                    }
                    com.baidu.tbadk.core.log.b.a("sign_all", httpMessage.getClientLogID(), 0, "sign_getforumlist_error", 110001, sb.toString(), new Object[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        if (this.ejc != null) {
            MessageManager.getInstance().removeHttpMessage(this.ejf);
            this.ejc = null;
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
        return true;
    }
}
