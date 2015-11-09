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
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.e<SignAllForumActivity> {
    private static final String cRG = String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/forum/getforumlist";
    private c cRD;
    private a cRE;
    private HttpMessage cRF;
    private final BdUniqueId cRH;
    private final HttpMessageListener cRI;

    /* loaded from: classes.dex */
    public interface a {
        void a(c cVar);

        void hS(String str);
    }

    public f(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.cRD = null;
        this.cRE = null;
        this.cRH = BdUniqueId.gen();
        this.cRI = new g(this, CmdConfigHttp.SIGNALL_GET_FOURMS);
        MessageManager messageManager = MessageManager.getInstance();
        this.cRD = new c();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, cRG);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.cRI);
    }

    public void a(a aVar) {
        this.cRE = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        if (this.cRF != null) {
            return false;
        }
        this.cRF = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.cRF.addParam("user_id", str);
        this.cRF.setTag(this.cRH);
        MessageManager.getInstance().sendMessage(this.cRF);
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
        if (this.cRF != null) {
            MessageManager.getInstance().removeHttpMessage(this.cRH);
            this.cRF = null;
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
        return true;
    }
}
