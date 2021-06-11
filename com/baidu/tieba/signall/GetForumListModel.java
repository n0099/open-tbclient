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
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import d.a.n0.a3.c;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class GetForumListModel extends BdBaseModel<SignAllForumActivity> {
    public static final String l = TbConfig.SERVER_ADDRESS + "c/f/forum/getforumlist";

    /* renamed from: e  reason: collision with root package name */
    public c f20623e;

    /* renamed from: f  reason: collision with root package name */
    public b f20624f;

    /* renamed from: g  reason: collision with root package name */
    public HttpMessage f20625g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20626h;

    /* renamed from: i  reason: collision with root package name */
    public final BdUniqueId f20627i;
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
                    GetForumListModel.this.C(httpResponsedMessage);
                }
                GetForumListModel.this.f20624f.onNetError(httpResponsedMessage.getErrorString());
            } else if (error == 0) {
                GetForumListModel.this.f20623e = ((GetForumResponsed) httpResponsedMessage).listData;
                if (GetForumListModel.this.f20624f != null) {
                    if (GetForumListModel.this.f20623e != null) {
                        GetForumListModel.this.f20624f.a(GetForumListModel.this.f20623e);
                    } else {
                        String errorString = httpResponsedMessage.getErrorString();
                        if (StringUtils.isNull(errorString)) {
                            errorString = TbadkCoreApplication.getInst().getContext().getString(R.string.neterror);
                        }
                        GetForumListModel.this.f20624f.onNetError(errorString);
                    }
                }
            } else {
                GetForumListModel.this.f20624f.onNetError(httpResponsedMessage.getErrorString());
            }
            GetForumListModel.this.f20625g = null;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(c cVar);

        void onNetError(String str);
    }

    public GetForumListModel(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        this.f20623e = null;
        this.f20624f = null;
        this.f20627i = BdUniqueId.gen();
        this.k = new a(CmdConfigHttp.SIGNALL_GET_FOURMS);
        this.f20626h = signAllForumActivity.getIntent().getBooleanExtra(IntentConfig.MEMBER_BUY_SHOW, false);
        MessageManager messageManager = MessageManager.getInstance();
        this.f20623e = new c();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SIGNALL_GET_FOURMS, l);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(GetForumResponsed.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.k);
    }

    public final void C(HttpResponsedMessage httpResponsedMessage) {
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
                    d.a.m0.r.z.a.a("sign_all", httpMessage.getClientLogID(), 0, "sign_getforumlist_error", 110001, sb.toString(), new Object[0]);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean D() {
        return this.f20626h;
    }

    public void E(b bVar) {
        this.f20624f = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.f20625g != null) {
            return false;
        }
        this.f20625g = new HttpMessage(CmdConfigHttp.SIGNALL_GET_FOURMS);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        this.f20625g.addParam("user_id", currentAccountObj != null ? currentAccountObj.getID() : null);
        this.f20625g.setTag(this.f20627i);
        MessageManager.getInstance().sendMessage(this.f20625g);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        if (this.f20625g != null) {
            MessageManager.getInstance().removeHttpMessage(this.f20627i);
            this.f20625g = null;
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.SIGNALL_GET_FOURMS);
        return true;
    }

    public ResponsedMessage<?> getResponsedMessage() {
        return this.j;
    }
}
