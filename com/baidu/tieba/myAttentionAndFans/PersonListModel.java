package com.baidu.tieba.myAttentionAndFans;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.myAttentionAndFans.message.ResponseLocalPersonListMessage;
import com.baidu.tieba.myAttentionAndFans.message.ResponseNetPersonListMessage;
import d.a.j0.r.q.g1;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class PersonListModel extends BdBaseModel<PersonListActivity> {
    public static final int CACHETIME = 604800000;
    public static final int TYPE_ALL = 0;
    public static final int TYPE_EACH = 1;
    public CustomMessageListener customListener;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18488e;

    /* renamed from: f  reason: collision with root package name */
    public String f18489f;

    /* renamed from: g  reason: collision with root package name */
    public int f18490g;

    /* renamed from: h  reason: collision with root package name */
    public c f18491h;
    public HttpMessageListener httpListener;

    /* renamed from: i  reason: collision with root package name */
    public int f18492i;
    public PersonListActivity j;
    public d.a.j0.s.e.a k;
    public int l;
    public int m;
    public String n;
    public static final BdUniqueId MYFOLLOW = BdUniqueId.gen();
    public static final BdUniqueId FOLLOWME = BdUniqueId.gen();

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            String errorString;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                if (PersonListModel.this.getUniqueId().getId() != Integer.parseInt((String) ((HashMap) httpResponsedMessage.getOrginalMessage().getExtra()).get("pageid"))) {
                    return;
                }
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (statusCode != 200 || error != 0) {
                    if (PersonListModel.this.f18491h != null) {
                        if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                            errorString = PersonListModel.this.j.getResources().getString(R.string.neterror);
                        } else {
                            errorString = httpResponsedMessage.getErrorString();
                        }
                        PersonListModel.this.f18491h.b(errorString, false);
                        return;
                    }
                    return;
                }
                g1 data = ((ResponseNetPersonListMessage) httpResponsedMessage).getData();
                if (data != null) {
                    if (!StringUtils.isNull(data.f49987g)) {
                        PersonListModel.this.n = data.f49987g;
                        PersonListModel.this.m = data.f49988h;
                    }
                    data.f49988h = PersonListModel.this.m;
                    data.f49987g = PersonListModel.this.n;
                }
                if (PersonListModel.this.f18491h != null) {
                    PersonListModel.this.f18491h.a(data, false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
                g1 data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
                if (data2 == null) {
                    if (PersonListModel.this.f18491h != null) {
                        PersonListModel.this.f18491h.b("", true);
                        return;
                    }
                    return;
                }
                if (!StringUtils.isNull(data2.f49987g)) {
                    PersonListModel.this.n = data2.f49987g;
                    PersonListModel.this.m = data2.f49988h;
                }
                data2.f49988h = PersonListModel.this.m;
                data2.f49987g = PersonListModel.this.n;
                if (PersonListModel.this.f18491h != null) {
                    PersonListModel.this.f18491h.a(data2, true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        g1 a(g1 g1Var, boolean z);

        void b(String str, boolean z);
    }

    /* loaded from: classes3.dex */
    public static class d extends BdAsyncTask<Void, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        public String f18495a;

        public d(String str) {
            this.f18495a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void... voidArr) {
            if (this.f18495a == null) {
                return null;
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ERR_URL);
            netWork.addPostData("portrait", this.f18495a);
            return netWork.postNetData();
        }
    }

    public PersonListModel(PersonListActivity personListActivity, c cVar) {
        super(personListActivity.getPageContext());
        this.f18492i = 0;
        this.l = 0;
        this.httpListener = new a(CmdConfigHttp.PIC_PERSONAL_LIST);
        this.customListener = new b(2001188);
        this.j = personListActivity;
        d.a.j0.s.e.a aVar = new d.a.j0.s.e.a(personListActivity.getPageContext());
        this.k = aVar;
        aVar.k(this.mLoadDataCallBack);
        this.f18488e = true;
        this.f18489f = null;
        this.f18491h = cVar;
    }

    public int A() {
        return this.f18492i;
    }

    public void B(int i2) {
        this.l = i2;
        this.f18492i = 0;
        E();
    }

    public void C() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.f18488e) {
            str = TbConfig.SERVER_ADDRESS + "c/u/follow/followList";
        } else {
            str = TbConfig.SERVER_ADDRESS + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.httpListener);
    }

    public void D() {
        MessageManager.getInstance().unRegisterListener(this.customListener);
        MessageManager.getInstance().unRegisterListener(this.httpListener);
    }

    public void E() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        HashMap hashMap = new HashMap();
        if (this.f18488e) {
            httpMessage.setTag(FOLLOWME);
        } else {
            httpMessage.setTag(MYFOLLOW);
        }
        String str = this.f18489f;
        if (str != null && !str.equals(TbadkCoreApplication.getCurrentAccount())) {
            httpMessage.addParam("uid", this.f18489f);
        }
        hashMap.put("id", String.valueOf(this.f18489f));
        int i2 = this.f18492i;
        if (i2 != 0) {
            int i3 = i2 + 1;
            this.f18492i = i3;
            httpMessage.addParam(Config.PACKAGE_NAME, String.valueOf(i3));
        }
        httpMessage.addParam("tab", this.l);
        hashMap.put("page", String.valueOf(this.f18492i));
        hashMap.put("pageid", String.valueOf(getUniqueId().getId()));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    public void F(String str) {
        this.f18489f = str;
    }

    public void G(boolean z) {
        this.f18488e = z;
    }

    public void H(int i2) {
        this.f18492i = i2;
    }

    public void I(String str) {
        new d(str).execute(new Void[0]);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String getId() {
        return this.f18489f;
    }

    public int getSex() {
        return this.f18490g;
    }

    public void setSex(int i2) {
        this.f18490g = i2;
    }

    public boolean y() {
        return this.f18488e;
    }

    public int z() {
        return this.l;
    }
}
