package com.baidu.tieba.signall;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
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
/* loaded from: classes18.dex */
public class GetForumListModel extends BdBaseModel<SignAllForumActivity> {
    private static final String lEl = TbConfig.SERVER_ADDRESS + Config.GET_FORUM_LIST;
    private ResponsedMessage<?> iaY;
    private c lEi;
    private a lEj;
    private HttpMessage lEk;
    private boolean lEm;
    private final HttpMessageListener lEn;
    private final BdUniqueId mBdUniqueId;

    /* loaded from: classes18.dex */
    public interface a {
        void HM(String str);

        void a(c cVar);
    }

    public GetForumListModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.lEi = null;
        this.lEj = null;
        this.mBdUniqueId = BdUniqueId.gen();
        this.lEn = new HttpMessageListener(1001201) { // from class: com.baidu.tieba.signall.GetForumListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001201) {
                    int error = httpResponsedMessage.getError();
                    GetForumListModel.this.iaY = httpResponsedMessage;
                    if (!httpResponsedMessage.isSuccess()) {
                        if (error == 110001) {
                            GetForumListModel.this.d(httpResponsedMessage);
                        }
                        GetForumListModel.this.lEj.HM(httpResponsedMessage.getErrorString());
                    } else if (error == 0) {
                        GetForumListModel.this.lEi = ((GetForumResponsed) httpResponsedMessage).listData;
                        if (GetForumListModel.this.lEj != null) {
                            if (GetForumListModel.this.lEi != null) {
                                GetForumListModel.this.lEj.a(GetForumListModel.this.lEi);
                            } else {
                                String errorString = httpResponsedMessage.getErrorString();
                                if (StringUtils.isNull(errorString)) {
                                    errorString = TbadkCoreApplication.getInst().getContext().getString(R.string.neterror);
                                }
                                GetForumListModel.this.lEj.HM(errorString);
                            }
                        }
                    } else {
                        GetForumListModel.this.lEj.HM(httpResponsedMessage.getErrorString());
                    }
                    GetForumListModel.this.lEk = null;
                }
            }
        };
        this.lEm = signAllForumActivity.getIntent().getBooleanExtra("member_buy_show", false);
        MessageManager messageManager = MessageManager.getInstance();
        this.lEi = new c();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001201, lEl);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.lEn);
    }

    public boolean diH() {
        return this.lEm;
    }

    public void a(a aVar) {
        this.lEj = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lEk != null) {
            return false;
        }
        this.lEk = new HttpMessage(1001201);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.lEk.addParam("user_id", str);
        this.lEk.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(this.lEk);
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
        if (this.lEk != null) {
            MessageManager.getInstance().removeHttpMessage(this.mBdUniqueId);
            this.lEk = null;
        }
        MessageManager.getInstance().unRegisterTask(1001201);
        return true;
    }

    public ResponsedMessage<?> chB() {
        return this.iaY;
    }
}
