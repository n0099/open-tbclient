package com.baidu.tieba.signall;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class GetForumListModel extends BdBaseModel<SignAllForumActivity> {
    private static final String gzC = TbConfig.SERVER_ADDRESS + "c/f/forum/getforumlist";
    private a gzA;
    private HttpMessage gzB;
    private boolean gzD;
    private final HttpMessageListener gzE;
    private c gzz;
    private final BdUniqueId mBdUniqueId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(c cVar);

        void ol(String str);
    }

    public GetForumListModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.gzz = null;
        this.gzA = null;
        this.mBdUniqueId = BdUniqueId.gen();
        this.gzE = new HttpMessageListener(CmdConfigHttp.SIGNALL_GET_FOURMS) { // from class: com.baidu.tieba.signall.GetForumListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001201) {
                    int error = httpResponsedMessage.getError();
                    if (!httpResponsedMessage.isSuccess()) {
                        if (error == 110001) {
                            GetForumListModel.this.j(httpResponsedMessage);
                        }
                        GetForumListModel.this.gzA.ol(httpResponsedMessage.getErrorString());
                    } else if (error == 0) {
                        GetForumListModel.this.gzz = ((GetForumResponsed) httpResponsedMessage).listData;
                        if (GetForumListModel.this.gzA != null && GetForumListModel.this.gzz != null) {
                            GetForumListModel.this.gzA.a(GetForumListModel.this.gzz);
                        } else {
                            String errorString = httpResponsedMessage.getErrorString();
                            if (StringUtils.isNull(errorString)) {
                                errorString = TbadkCoreApplication.getInst().getContext().getString(d.k.neterror);
                            }
                            GetForumListModel.this.gzA.ol(errorString);
                        }
                    } else {
                        GetForumListModel.this.gzA.ol(httpResponsedMessage.getErrorString());
                    }
                    GetForumListModel.this.gzB = null;
                }
            }
        };
        this.gzD = signAllForumActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        MessageManager messageManager = MessageManager.getInstance();
        this.gzz = new c();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, gzC);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.gzE);
    }

    public boolean btE() {
        return this.gzD;
    }

    public void a(a aVar) {
        this.gzA = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.gzB != null) {
            return false;
        }
        this.gzB = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.gzB.addParam("user_id", str);
        this.gzB.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(this.gzB);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(HttpResponsedMessage httpResponsedMessage) {
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
                    com.baidu.tbadk.core.d.a.a("sign_all", httpMessage.getClientLogID(), 0, "sign_getforumlist_error", 110001, sb.toString(), new Object[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.gzB != null) {
            MessageManager.getInstance().removeHttpMessage(this.mBdUniqueId);
            this.gzB = null;
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
        return true;
    }
}
