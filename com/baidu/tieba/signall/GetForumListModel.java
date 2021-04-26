package com.baidu.tieba.signall;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import d.a.j0.z2.c;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class GetForumListModel extends BdBaseModel<SignAllForumActivity> {
    public static final String l = TbConfig.SERVER_ADDRESS + "c/f/forum/getforumlist";

    /* renamed from: e  reason: collision with root package name */
    public c f21382e;

    /* renamed from: f  reason: collision with root package name */
    public b f21383f;

    /* renamed from: g  reason: collision with root package name */
    public HttpMessage f21384g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21385h;

    /* renamed from: i  reason: collision with root package name */
    public final BdUniqueId f21386i;
    public ResponsedMessage<?> j;
    public final HttpMessageListener k;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001201) {
                return;
            }
            int error = httpResponsedMessage.getError();
            GetForumListModel.this.j = httpResponsedMessage;
            if (!httpResponsedMessage.isSuccess()) {
                if (error == 110001) {
                    GetForumListModel.this.y(httpResponsedMessage);
                }
                GetForumListModel.this.f21383f.onNetError(httpResponsedMessage.getErrorString());
            } else if (error == 0) {
                GetForumListModel.this.f21382e = ((GetForumResponsed) httpResponsedMessage).listData;
                if (GetForumListModel.this.f21383f != null) {
                    if (GetForumListModel.this.f21382e != null) {
                        GetForumListModel.this.f21383f.a(GetForumListModel.this.f21382e);
                    } else {
                        String errorString = httpResponsedMessage.getErrorString();
                        if (StringUtils.isNull(errorString)) {
                            errorString = TbadkCoreApplication.getInst().getContext().getString(R.string.neterror);
                        }
                        GetForumListModel.this.f21383f.onNetError(errorString);
                    }
                }
            } else {
                GetForumListModel.this.f21383f.onNetError(httpResponsedMessage.getErrorString());
            }
            GetForumListModel.this.f21384g = null;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(c cVar);

        void onNetError(String str);
    }

    public GetForumListModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.f21382e = null;
        this.f21383f = null;
        this.f21386i = BdUniqueId.gen();
        this.k = new a(CmdConfigHttp.SIGNALL_GET_FOURMS);
        this.f21385h = signAllForumActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        MessageManager messageManager = MessageManager.getInstance();
        this.f21382e = new c();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, l);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.k);
    }

    public void A(b bVar) {
        this.f21383f = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.f21384g != null) {
            return false;
        }
        this.f21384g = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        this.f21384g.addParam("user_id", currentAccountObj != null ? currentAccountObj.getID() : null);
        this.f21384g.setTag(this.f21386i);
        MessageManager.getInstance().sendMessage(this.f21384g);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.f21384g != null) {
            MessageManager.getInstance().removeHttpMessage(this.f21386i);
            this.f21384g = null;
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
        return true;
    }

    public ResponsedMessage<?> getResponsedMessage() {
        return this.j;
    }

    public final void y(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && (httpResponsedMessage.getOrginalMessage() instanceof HttpMessage)) {
            HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
            try {
                Field declaredField = HttpMessage.class.getDeclaredField("mParams");
                declaredField.setAccessible(true);
                if (declaredField.get(httpMessage) instanceof HashMap) {
                    StringBuilder sb = new StringBuilder();
                    for (Map.Entry entry : ((HashMap) declaredField.get(httpMessage)).entrySet()) {
                        Object value = entry.getValue();
                        sb.append("key=");
                        sb.append((String) entry.getKey());
                        sb.append("value=");
                        sb.append(value.toString());
                        sb.append("&");
                    }
                    d.a.i0.r.z.a.a("sign_all", httpMessage.getClientLogID(), 0, "sign_getforumlist_error", NetWorkErr.GET_FORUM_LIST_ERROR, sb.toString(), new Object[0]);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean z() {
        return this.f21385h;
    }
}
