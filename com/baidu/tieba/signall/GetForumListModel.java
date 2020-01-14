package com.baidu.tieba.signall;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.NetWorkErr;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.webkit.internal.ETAG;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class GetForumListModel extends BdBaseModel<SignAllForumActivity> {
    private static final String jXq = TbConfig.SERVER_ADDRESS + Config.GET_FORUM_LIST;
    private c jXn;
    private a jXo;
    private HttpMessage jXp;
    private boolean jXr;
    private final HttpMessageListener jXs;
    private final BdUniqueId mBdUniqueId;

    /* loaded from: classes9.dex */
    public interface a {
        void CK(String str);

        void a(c cVar);
    }

    public GetForumListModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.jXn = null;
        this.jXo = null;
        this.mBdUniqueId = BdUniqueId.gen();
        this.jXs = new HttpMessageListener(1001201) { // from class: com.baidu.tieba.signall.GetForumListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001201) {
                    int error = httpResponsedMessage.getError();
                    if (!httpResponsedMessage.isSuccess()) {
                        if (error == 110001) {
                            GetForumListModel.this.d(httpResponsedMessage);
                        }
                        GetForumListModel.this.jXo.CK(httpResponsedMessage.getErrorString());
                    } else if (error == 0) {
                        GetForumListModel.this.jXn = ((GetForumResponsed) httpResponsedMessage).listData;
                        if (GetForumListModel.this.jXo != null && GetForumListModel.this.jXn != null) {
                            GetForumListModel.this.jXo.a(GetForumListModel.this.jXn);
                        } else {
                            String errorString = httpResponsedMessage.getErrorString();
                            if (StringUtils.isNull(errorString)) {
                                errorString = TbadkCoreApplication.getInst().getContext().getString(R.string.neterror);
                            }
                            GetForumListModel.this.jXo.CK(errorString);
                        }
                    } else {
                        GetForumListModel.this.jXo.CK(httpResponsedMessage.getErrorString());
                    }
                    GetForumListModel.this.jXp = null;
                }
            }
        };
        this.jXr = signAllForumActivity.getIntent().getBooleanExtra("member_buy_show", false);
        MessageManager messageManager = MessageManager.getInstance();
        this.jXn = new c();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001201, jXq);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.jXs);
    }

    public boolean cHl() {
        return this.jXr;
    }

    public void a(a aVar) {
        this.jXo = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.jXp != null) {
            return false;
        }
        this.jXp = new HttpMessage(1001201);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.jXp.addParam("user_id", str);
        this.jXp.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(this.jXp);
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
                    com.baidu.tbadk.core.d.a.a("sign_all", httpMessage.getClientLogID(), 0, "sign_getforumlist_error", NetWorkErr.GET_FORUM_LIST_ERROR, sb.toString(), new Object[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.jXp != null) {
            MessageManager.getInstance().removeHttpMessage(this.mBdUniqueId);
            this.jXp = null;
        }
        MessageManager.getInstance().unRegisterTask(1001201);
        return true;
    }
}
