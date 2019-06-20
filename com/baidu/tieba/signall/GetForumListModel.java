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
import com.baidu.tieba.R;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class GetForumListModel extends BdBaseModel<SignAllForumActivity> {
    private static final String iQw = TbConfig.SERVER_ADDRESS + "c/f/forum/getforumlist";
    private c iQt;
    private a iQu;
    private HttpMessage iQv;
    private boolean iQx;
    private final HttpMessageListener iQy;
    private final BdUniqueId mBdUniqueId;

    /* loaded from: classes6.dex */
    public interface a {
        void a(c cVar);

        void yo(String str);
    }

    public GetForumListModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.iQt = null;
        this.iQu = null;
        this.mBdUniqueId = BdUniqueId.gen();
        this.iQy = new HttpMessageListener(CmdConfigHttp.SIGNALL_GET_FOURMS) { // from class: com.baidu.tieba.signall.GetForumListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001201) {
                    int error = httpResponsedMessage.getError();
                    if (!httpResponsedMessage.isSuccess()) {
                        if (error == 110001) {
                            GetForumListModel.this.d(httpResponsedMessage);
                        }
                        GetForumListModel.this.iQu.yo(httpResponsedMessage.getErrorString());
                    } else if (error == 0) {
                        GetForumListModel.this.iQt = ((GetForumResponsed) httpResponsedMessage).listData;
                        if (GetForumListModel.this.iQu != null && GetForumListModel.this.iQt != null) {
                            GetForumListModel.this.iQu.a(GetForumListModel.this.iQt);
                        } else {
                            String errorString = httpResponsedMessage.getErrorString();
                            if (StringUtils.isNull(errorString)) {
                                errorString = TbadkCoreApplication.getInst().getContext().getString(R.string.neterror);
                            }
                            GetForumListModel.this.iQu.yo(errorString);
                        }
                    } else {
                        GetForumListModel.this.iQu.yo(httpResponsedMessage.getErrorString());
                    }
                    GetForumListModel.this.iQv = null;
                }
            }
        };
        this.iQx = signAllForumActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        MessageManager messageManager = MessageManager.getInstance();
        this.iQt = new c();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, iQw);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.iQy);
    }

    public boolean ckl() {
        return this.iQx;
    }

    public void a(a aVar) {
        this.iQu = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.iQv != null) {
            return false;
        }
        this.iQv = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.iQv.addParam("user_id", str);
        this.iQv.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(this.iQv);
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
                    com.baidu.tbadk.core.d.a.a("sign_all", httpMessage.getClientLogID(), 0, "sign_getforumlist_error", 110001, sb.toString(), new Object[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.iQv != null) {
            MessageManager.getInstance().removeHttpMessage(this.mBdUniqueId);
            this.iQv = null;
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
        return true;
    }
}
