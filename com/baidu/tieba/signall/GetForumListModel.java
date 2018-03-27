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
    private static final String gRV = TbConfig.SERVER_ADDRESS + "c/f/forum/getforumlist";
    private c gRS;
    private a gRT;
    private HttpMessage gRU;
    private boolean gRW;
    private final HttpMessageListener gRX;
    private final BdUniqueId mBdUniqueId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(c cVar);

        void nr(String str);
    }

    public GetForumListModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.gRS = null;
        this.gRT = null;
        this.mBdUniqueId = BdUniqueId.gen();
        this.gRX = new HttpMessageListener(CmdConfigHttp.SIGNALL_GET_FOURMS) { // from class: com.baidu.tieba.signall.GetForumListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001201) {
                    int error = httpResponsedMessage.getError();
                    if (!httpResponsedMessage.isSuccess()) {
                        if (error == 110001) {
                            GetForumListModel.this.j(httpResponsedMessage);
                        }
                        GetForumListModel.this.gRT.nr(httpResponsedMessage.getErrorString());
                    } else if (error == 0) {
                        GetForumListModel.this.gRS = ((GetForumResponsed) httpResponsedMessage).listData;
                        if (GetForumListModel.this.gRT != null && GetForumListModel.this.gRS != null) {
                            GetForumListModel.this.gRT.a(GetForumListModel.this.gRS);
                        } else {
                            String errorString = httpResponsedMessage.getErrorString();
                            if (StringUtils.isNull(errorString)) {
                                errorString = TbadkCoreApplication.getInst().getContext().getString(d.j.neterror);
                            }
                            GetForumListModel.this.gRT.nr(errorString);
                        }
                    } else {
                        GetForumListModel.this.gRT.nr(httpResponsedMessage.getErrorString());
                    }
                    GetForumListModel.this.gRU = null;
                }
            }
        };
        this.gRW = signAllForumActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        MessageManager messageManager = MessageManager.getInstance();
        this.gRS = new c();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, gRV);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.gRX);
    }

    public boolean btx() {
        return this.gRW;
    }

    public void a(a aVar) {
        this.gRT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.gRU != null) {
            return false;
        }
        this.gRU = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.gRU.addParam("user_id", str);
        this.gRU.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(this.gRU);
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
        if (this.gRU != null) {
            MessageManager.getInstance().removeHttpMessage(this.mBdUniqueId);
            this.gRU = null;
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
        return true;
    }
}
