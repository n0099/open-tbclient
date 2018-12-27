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
import com.baidu.tieba.e;
import com.baidu.webkit.internal.ETAG;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class GetForumListModel extends BdBaseModel<SignAllForumActivity> {
    private static final String hfd = TbConfig.SERVER_ADDRESS + "c/f/forum/getforumlist";
    private c hfa;
    private a hfb;
    private HttpMessage hfc;
    private boolean hfe;
    private final HttpMessageListener hff;
    private final BdUniqueId mBdUniqueId;

    /* loaded from: classes3.dex */
    public interface a {
        void a(c cVar);

        void qe(String str);
    }

    public GetForumListModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.hfa = null;
        this.hfb = null;
        this.mBdUniqueId = BdUniqueId.gen();
        this.hff = new HttpMessageListener(CmdConfigHttp.SIGNALL_GET_FOURMS) { // from class: com.baidu.tieba.signall.GetForumListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001201) {
                    int error = httpResponsedMessage.getError();
                    if (!httpResponsedMessage.isSuccess()) {
                        if (error == 110001) {
                            GetForumListModel.this.d(httpResponsedMessage);
                        }
                        GetForumListModel.this.hfb.qe(httpResponsedMessage.getErrorString());
                    } else if (error == 0) {
                        GetForumListModel.this.hfa = ((GetForumResponsed) httpResponsedMessage).listData;
                        if (GetForumListModel.this.hfb != null && GetForumListModel.this.hfa != null) {
                            GetForumListModel.this.hfb.a(GetForumListModel.this.hfa);
                        } else {
                            String errorString = httpResponsedMessage.getErrorString();
                            if (StringUtils.isNull(errorString)) {
                                errorString = TbadkCoreApplication.getInst().getContext().getString(e.j.neterror);
                            }
                            GetForumListModel.this.hfb.qe(errorString);
                        }
                    } else {
                        GetForumListModel.this.hfb.qe(httpResponsedMessage.getErrorString());
                    }
                    GetForumListModel.this.hfc = null;
                }
            }
        };
        this.hfe = signAllForumActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        MessageManager messageManager = MessageManager.getInstance();
        this.hfa = new c();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, hfd);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.hff);
    }

    public boolean bAH() {
        return this.hfe;
    }

    public void a(a aVar) {
        this.hfb = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.hfc != null) {
            return false;
        }
        this.hfc = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.hfc.addParam("user_id", str);
        this.hfc.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(this.hfc);
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
                        sb.append(ETAG.ITEM_SEPARATOR);
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
        if (this.hfc != null) {
            MessageManager.getInstance().removeHttpMessage(this.mBdUniqueId);
            this.hfc = null;
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
        return true;
    }
}
