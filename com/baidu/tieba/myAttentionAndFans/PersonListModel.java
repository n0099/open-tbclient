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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.myAttentionAndFans.message.ResponseFollowListSwitchMsg;
import com.baidu.tieba.myAttentionAndFans.message.ResponseLocalPersonListMessage;
import com.baidu.tieba.myAttentionAndFans.message.ResponseNetPersonListMessage;
import d.a.n0.r.q.g1;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class PersonListModel extends BdBaseModel<PersonListActivity> {
    public static final int CACHETIME = 604800000;
    public static final int SWITCH_TYPE_ALL = 1;
    public static final int SWITCH_TYPE_TIEBA = 2;
    public static final int TYPE_ALL = 0;
    public static final int TYPE_EACH = 1;
    public CustomMessageListener customListener;

    /* renamed from: e  reason: collision with root package name */
    public boolean f18558e;

    /* renamed from: f  reason: collision with root package name */
    public String f18559f;

    /* renamed from: g  reason: collision with root package name */
    public int f18560g;

    /* renamed from: h  reason: collision with root package name */
    public d f18561h;
    public HttpMessageListener httpListener;

    /* renamed from: i  reason: collision with root package name */
    public int f18562i;
    public PersonListActivity j;
    public d.a.n0.s.e.a k;
    public int l;
    public int m;
    public HttpMessageListener mFollowSwitchListener;
    public String n;
    public int o;
    public static final BdUniqueId MYFOLLOW = BdUniqueId.gen();
    public static final BdUniqueId FOLLOWME = BdUniqueId.gen();

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1002005) {
                return;
            }
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode == 200 && error == 0) {
                PersonListModel.this.K();
                return;
            }
            BdLog.e("follow switch request fail");
            if (PersonListModel.this.f18561h != null) {
                PersonListModel.this.f18561h.b("follow switch request fail", false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
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
                    if (PersonListModel.this.f18561h != null) {
                        if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                            errorString = PersonListModel.this.j.getResources().getString(R.string.neterror);
                        } else {
                            errorString = httpResponsedMessage.getErrorString();
                        }
                        PersonListModel.this.f18561h.b(errorString, false);
                        return;
                    }
                    return;
                }
                g1 data = ((ResponseNetPersonListMessage) httpResponsedMessage).getData();
                if (data != null) {
                    if (!StringUtils.isNull(data.f53814g)) {
                        PersonListModel.this.n = data.f53814g;
                        PersonListModel.this.m = data.f53815h;
                    }
                    data.f53815h = PersonListModel.this.m;
                    data.f53814g = PersonListModel.this.n;
                }
                if (PersonListModel.this.f18561h != null) {
                    PersonListModel.this.f18561h.a(data, false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
                g1 data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
                if (data2 == null) {
                    if (PersonListModel.this.f18561h != null) {
                        PersonListModel.this.f18561h.b("", true);
                        return;
                    }
                    return;
                }
                if (!StringUtils.isNull(data2.f53814g)) {
                    PersonListModel.this.n = data2.f53814g;
                    PersonListModel.this.m = data2.f53815h;
                }
                data2.f53815h = PersonListModel.this.m;
                data2.f53814g = PersonListModel.this.n;
                if (PersonListModel.this.f18561h != null) {
                    PersonListModel.this.f18561h.a(data2, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        g1 a(g1 g1Var, boolean z);

        void b(String str, boolean z);
    }

    /* loaded from: classes4.dex */
    public static class e extends BdAsyncTask<Void, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        public String f18566a;

        public e(String str) {
            this.f18566a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Void... voidArr) {
            if (this.f18566a == null) {
                return null;
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ERR_URL);
            netWork.addPostData("portrait", this.f18566a);
            return netWork.postNetData();
        }
    }

    public PersonListModel(PersonListActivity personListActivity, d dVar) {
        super(personListActivity.getPageContext());
        this.f18562i = 0;
        this.l = 0;
        this.o = 0;
        this.mFollowSwitchListener = new a(CmdConfigHttp.CMD_FOLLOW_SWITCH);
        this.httpListener = new b(CmdConfigHttp.PIC_PERSONAL_LIST);
        this.customListener = new c(2001188);
        this.j = personListActivity;
        d.a.n0.s.e.a aVar = new d.a.n0.s.e.a(personListActivity.getPageContext());
        this.k = aVar;
        aVar.k(this.mLoadDataCallBack);
        this.f18558e = true;
        this.f18559f = null;
        this.f18561h = dVar;
    }

    public boolean C() {
        return this.f18558e;
    }

    public int D() {
        return this.l;
    }

    public int E() {
        return this.f18562i;
    }

    public void F(int i2) {
        this.l = i2;
        this.f18562i = 0;
        K();
    }

    public void G() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_FOLLOW_SWITCH, TbConfig.SERVER_ADDRESS + "c/c/user/setFollowListSwitch");
        tbHttpMessageTask.setResponsedClass(ResponseFollowListSwitchMsg.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.mFollowSwitchListener);
    }

    public void H() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.f18558e) {
            str = TbConfig.SERVER_ADDRESS + "c/u/follow/followList";
        } else {
            str = TbConfig.SERVER_ADDRESS + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.httpListener);
    }

    public void I() {
        MessageManager.getInstance().unRegisterListener(this.customListener);
        MessageManager.getInstance().unRegisterListener(this.httpListener);
        MessageManager.getInstance().unRegisterListener(this.mFollowSwitchListener);
    }

    public void J(int i2) {
        this.o = i2;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FOLLOW_SWITCH);
        httpMessage.addParam("follow_list_switch", i2);
        sendMessage(httpMessage);
    }

    public void K() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        HashMap hashMap = new HashMap();
        if (this.f18558e) {
            httpMessage.setTag(FOLLOWME);
        } else {
            httpMessage.setTag(MYFOLLOW);
        }
        String str = this.f18559f;
        if (str != null && !str.equals(TbadkCoreApplication.getCurrentAccount())) {
            httpMessage.addParam("uid", this.f18559f);
        }
        hashMap.put("id", String.valueOf(this.f18559f));
        int i2 = this.f18562i;
        if (i2 != 0) {
            int i3 = i2 + 1;
            this.f18562i = i3;
            httpMessage.addParam(Config.PACKAGE_NAME, String.valueOf(i3));
        }
        httpMessage.addParam("tab", this.l);
        httpMessage.addParam("follow_list_switch", this.o);
        hashMap.put("page", String.valueOf(this.f18562i));
        hashMap.put("pageid", String.valueOf(getUniqueId().getId()));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    public void L(String str) {
        this.f18559f = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void M(boolean z) {
        this.f18558e = z;
    }

    public void N(int i2) {
        this.f18562i = i2;
    }

    public void O(String str) {
        new e(str).execute(new Void[0]);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public String getId() {
        return this.f18559f;
    }

    public int getSex() {
        return this.f18560g;
    }

    public void setSex(int i2) {
        this.f18560g = i2;
    }
}
