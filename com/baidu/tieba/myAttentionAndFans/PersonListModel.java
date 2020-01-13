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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.myAttentionAndFans.message.ResponseLocalPersonListMessage;
import com.baidu.tieba.myAttentionAndFans.message.ResponseNetPersonListMessage;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class PersonListModel extends BdBaseModel<PersonListActivity> {
    public static final int CACHETIME = 604800000;
    public static final int TYPE_ALL = 0;
    public static final int TYPE_EACH = 1;
    private boolean aom;
    public CustomMessageListener customListener;
    private int eHY;
    private int eIa;
    private int eIb;
    private String eIc;
    public HttpMessageListener httpListener;
    private a ipX;
    private PersonListActivity iqf;
    private com.baidu.tbadk.coreExtra.model.a iqg;
    private String mId;
    private int mSex;
    public static final BdUniqueId MYFOLLOW = BdUniqueId.gen();
    public static final BdUniqueId FOLLOWME = BdUniqueId.gen();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public interface a {
        void Y(String str, boolean z);

        av e(av avVar, boolean z);
    }

    public PersonListModel(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.eHY = 0;
        this.eIa = 0;
        this.httpListener = new HttpMessageListener(1002004) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    if (PersonListModel.this.getUniqueId().getId() == Integer.parseInt((String) ((HashMap) httpResponsedMessage.getOrginalMessage().getExtra()).get("pageid"))) {
                        int statusCode = httpResponsedMessage.getStatusCode();
                        int error = httpResponsedMessage.getError();
                        if (statusCode != 200 || error != 0) {
                            if (PersonListModel.this.ipX != null) {
                                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                    errorString = PersonListModel.this.iqf.getResources().getString(R.string.neterror);
                                } else {
                                    errorString = httpResponsedMessage.getErrorString();
                                }
                                PersonListModel.this.ipX.Y(errorString, false);
                                return;
                            }
                            return;
                        }
                        av data = ((ResponseNetPersonListMessage) httpResponsedMessage).getData();
                        if (data != null) {
                            if (!StringUtils.isNull(data.cMd)) {
                                PersonListModel.this.eIc = data.cMd;
                                PersonListModel.this.eIb = data.type;
                            }
                            data.type = PersonListModel.this.eIb;
                            data.cMd = PersonListModel.this.eIc;
                        }
                        if (PersonListModel.this.ipX != null) {
                            PersonListModel.this.ipX.e(data, false);
                        }
                    }
                }
            }
        };
        this.customListener = new CustomMessageListener(CmdConfigCustom.CMD_READ_PERSON_LIST) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
                    av data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
                    if (data2 == null) {
                        if (PersonListModel.this.ipX != null) {
                            PersonListModel.this.ipX.Y("", true);
                            return;
                        }
                        return;
                    }
                    if (!StringUtils.isNull(data2.cMd)) {
                        PersonListModel.this.eIc = data2.cMd;
                        PersonListModel.this.eIb = data2.type;
                    }
                    data2.type = PersonListModel.this.eIb;
                    data2.cMd = PersonListModel.this.eIc;
                    if (PersonListModel.this.ipX != null) {
                        PersonListModel.this.ipX.e(data2, true);
                    }
                }
            }
        };
        this.iqf = personListActivity;
        this.iqg = new com.baidu.tbadk.coreExtra.model.a(this.iqf.getPageContext());
        this.iqg.setLoadDataCallBack(this.mLoadDataCallBack);
        this.aom = true;
        this.mId = null;
        this.ipX = aVar;
    }

    public int getPage() {
        return this.eHY;
    }

    public void setPage(int i) {
        this.eHY = i;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getId() {
        return this.mId;
    }

    public void setSex(int i) {
        this.mSex = i;
    }

    public int getSex() {
        return this.mSex;
    }

    public void iC(boolean z) {
        this.aom = z;
    }

    public boolean bez() {
        return this.aom;
    }

    public void aZL() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.aom) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.httpListener);
    }

    public void oo(int i) {
        this.eIa = i;
        this.eHY = 0;
        beA();
    }

    public int getLoadType() {
        return this.eIa;
    }

    public void beA() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.aom) {
            httpMessage.setTag(FOLLOWME);
        } else {
            httpMessage.setTag(MYFOLLOW);
        }
        if (this.mId != null && !this.mId.equals(TbadkCoreApplication.getCurrentAccount())) {
            httpMessage.addParam("uid", this.mId);
        }
        hashMap.put("id", String.valueOf(this.mId));
        if (this.eHY != 0) {
            this.eHY++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.eHY));
        }
        httpMessage.addParam("tab", this.eIa);
        hashMap.put("page", String.valueOf(this.eHY));
        hashMap.put("pageid", String.valueOf(getUniqueId().getId()));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    public void removeListener() {
        MessageManager.getInstance().unRegisterListener(this.customListener);
        MessageManager.getInstance().unRegisterListener(this.httpListener);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void EW(String str) {
        new b(str).execute(new Void[0]);
    }

    /* loaded from: classes8.dex */
    public static class b extends BdAsyncTask<Void, Void, String> {
        private String mPortrait;

        public b(String str) {
            this.mPortrait = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Void... voidArr) {
            if (this.mPortrait == null) {
                return null;
            }
            x xVar = new x(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ERR_URL);
            xVar.addPostData("portrait", this.mPortrait);
            return xVar.postNetData();
        }
    }
}
