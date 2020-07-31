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
    private static final String lEj = TbConfig.SERVER_ADDRESS + Config.GET_FORUM_LIST;
    private ResponsedMessage<?> iaW;
    private c lEg;
    private a lEh;
    private HttpMessage lEi;
    private boolean lEk;
    private final HttpMessageListener lEl;
    private final BdUniqueId mBdUniqueId;

    /* loaded from: classes18.dex */
    public interface a {
        void HM(String str);

        void a(c cVar);
    }

    public GetForumListModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.lEg = null;
        this.lEh = null;
        this.mBdUniqueId = BdUniqueId.gen();
        this.lEl = new HttpMessageListener(1001201) { // from class: com.baidu.tieba.signall.GetForumListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001201) {
                    int error = httpResponsedMessage.getError();
                    GetForumListModel.this.iaW = httpResponsedMessage;
                    if (!httpResponsedMessage.isSuccess()) {
                        if (error == 110001) {
                            GetForumListModel.this.d(httpResponsedMessage);
                        }
                        GetForumListModel.this.lEh.HM(httpResponsedMessage.getErrorString());
                    } else if (error == 0) {
                        GetForumListModel.this.lEg = ((GetForumResponsed) httpResponsedMessage).listData;
                        if (GetForumListModel.this.lEh != null) {
                            if (GetForumListModel.this.lEg != null) {
                                GetForumListModel.this.lEh.a(GetForumListModel.this.lEg);
                            } else {
                                String errorString = httpResponsedMessage.getErrorString();
                                if (StringUtils.isNull(errorString)) {
                                    errorString = TbadkCoreApplication.getInst().getContext().getString(R.string.neterror);
                                }
                                GetForumListModel.this.lEh.HM(errorString);
                            }
                        }
                    } else {
                        GetForumListModel.this.lEh.HM(httpResponsedMessage.getErrorString());
                    }
                    GetForumListModel.this.lEi = null;
                }
            }
        };
        this.lEk = signAllForumActivity.getIntent().getBooleanExtra("member_buy_show", false);
        MessageManager messageManager = MessageManager.getInstance();
        this.lEg = new c();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001201, lEj);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.lEl);
    }

    public boolean diH() {
        return this.lEk;
    }

    public void a(a aVar) {
        this.lEh = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lEi != null) {
            return false;
        }
        this.lEi = new HttpMessage(1001201);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.lEi.addParam("user_id", str);
        this.lEi.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(this.lEi);
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
        if (this.lEi != null) {
            MessageManager.getInstance().removeHttpMessage(this.mBdUniqueId);
            this.lEi = null;
        }
        MessageManager.getInstance().unRegisterTask(1001201);
        return true;
    }

    public ResponsedMessage<?> chB() {
        return this.iaW;
    }
}
