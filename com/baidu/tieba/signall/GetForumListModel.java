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
    private static final String lVP = TbConfig.SERVER_ADDRESS + Config.GET_FORUM_LIST;
    private c lVM;
    private a lVN;
    private HttpMessage lVO;
    private boolean lVQ;
    private final HttpMessageListener lVR;
    private final BdUniqueId mBdUniqueId;
    private ResponsedMessage<?> mResponsedMessage;

    /* loaded from: classes18.dex */
    public interface a {
        void KE(String str);

        void a(c cVar);
    }

    public GetForumListModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.lVM = null;
        this.lVN = null;
        this.mBdUniqueId = BdUniqueId.gen();
        this.lVR = new HttpMessageListener(1001201) { // from class: com.baidu.tieba.signall.GetForumListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001201) {
                    int error = httpResponsedMessage.getError();
                    GetForumListModel.this.mResponsedMessage = httpResponsedMessage;
                    if (!httpResponsedMessage.isSuccess()) {
                        if (error == 110001) {
                            GetForumListModel.this.d(httpResponsedMessage);
                        }
                        GetForumListModel.this.lVN.KE(httpResponsedMessage.getErrorString());
                    } else if (error == 0) {
                        GetForumListModel.this.lVM = ((GetForumResponsed) httpResponsedMessage).listData;
                        if (GetForumListModel.this.lVN != null) {
                            if (GetForumListModel.this.lVM != null) {
                                GetForumListModel.this.lVN.a(GetForumListModel.this.lVM);
                            } else {
                                String errorString = httpResponsedMessage.getErrorString();
                                if (StringUtils.isNull(errorString)) {
                                    errorString = TbadkCoreApplication.getInst().getContext().getString(R.string.neterror);
                                }
                                GetForumListModel.this.lVN.KE(errorString);
                            }
                        }
                    } else {
                        GetForumListModel.this.lVN.KE(httpResponsedMessage.getErrorString());
                    }
                    GetForumListModel.this.lVO = null;
                }
            }
        };
        this.lVQ = signAllForumActivity.getIntent().getBooleanExtra("member_buy_show", false);
        MessageManager messageManager = MessageManager.getInstance();
        this.lVM = new c();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1001201, lVP);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.lVR);
    }

    public boolean duc() {
        return this.lVQ;
    }

    public void a(a aVar) {
        this.lVN = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.lVO != null) {
            return false;
        }
        this.lVO = new HttpMessage(1001201);
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        String str = null;
        if (currentAccountObj != null) {
            str = currentAccountObj.getID();
        }
        this.lVO.addParam("user_id", str);
        this.lVO.setTag(this.mBdUniqueId);
        MessageManager.getInstance().sendMessage(this.lVO);
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
        if (this.lVO != null) {
            MessageManager.getInstance().removeHttpMessage(this.mBdUniqueId);
            this.lVO = null;
        }
        MessageManager.getInstance().unRegisterTask(1001201);
        return true;
    }

    public ResponsedMessage<?> getResponsedMessage() {
        return this.mResponsedMessage;
    }
}
