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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.myAttentionAndFans.message.ResponseLocalPersonListMessage;
import com.baidu.tieba.myAttentionAndFans.message.ResponseNetPersonListMessage;
import java.util.HashMap;
/* loaded from: classes23.dex */
public class PersonListModel extends BdBaseModel<PersonListActivity> {
    public static final int CACHETIME = 604800000;
    public static final int TYPE_ALL = 0;
    public static final int TYPE_EACH = 1;
    private boolean biQ;
    public CustomMessageListener customListener;
    private int gQL;
    private int gQN;
    private int gQO;
    private String gQP;
    public HttpMessageListener httpListener;
    private PersonListActivity kZE;
    private com.baidu.tbadk.coreExtra.model.a kZF;
    private a kZw;
    private String mId;
    private int mSex;
    public static final BdUniqueId MYFOLLOW = BdUniqueId.gen();
    public static final BdUniqueId FOLLOWME = BdUniqueId.gen();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public interface a {
        void aB(String str, boolean z);

        bc e(bc bcVar, boolean z);
    }

    public PersonListModel(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.gQL = 0;
        this.gQN = 0;
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
                            if (PersonListModel.this.kZw != null) {
                                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                    errorString = PersonListModel.this.kZE.getResources().getString(R.string.neterror);
                                } else {
                                    errorString = httpResponsedMessage.getErrorString();
                                }
                                PersonListModel.this.kZw.aB(errorString, false);
                                return;
                            }
                            return;
                        }
                        bc data = ((ResponseNetPersonListMessage) httpResponsedMessage).getData();
                        if (data != null) {
                            if (!StringUtils.isNull(data.eCn)) {
                                PersonListModel.this.gQP = data.eCn;
                                PersonListModel.this.gQO = data.type;
                            }
                            data.type = PersonListModel.this.gQO;
                            data.eCn = PersonListModel.this.gQP;
                        }
                        if (PersonListModel.this.kZw != null) {
                            PersonListModel.this.kZw.e(data, false);
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
                    bc data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
                    if (data2 == null) {
                        if (PersonListModel.this.kZw != null) {
                            PersonListModel.this.kZw.aB("", true);
                            return;
                        }
                        return;
                    }
                    if (!StringUtils.isNull(data2.eCn)) {
                        PersonListModel.this.gQP = data2.eCn;
                        PersonListModel.this.gQO = data2.type;
                    }
                    data2.type = PersonListModel.this.gQO;
                    data2.eCn = PersonListModel.this.gQP;
                    if (PersonListModel.this.kZw != null) {
                        PersonListModel.this.kZw.e(data2, true);
                    }
                }
            }
        };
        this.kZE = personListActivity;
        this.kZF = new com.baidu.tbadk.coreExtra.model.a(this.kZE.getPageContext());
        this.kZF.setLoadDataCallBack(this.mLoadDataCallBack);
        this.biQ = true;
        this.mId = null;
        this.kZw = aVar;
    }

    public int getPage() {
        return this.gQL;
    }

    public void setPage(int i) {
        this.gQL = i;
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

    public void mD(boolean z) {
        this.biQ = z;
    }

    public boolean bVC() {
        return this.biQ;
    }

    public void bOG() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.biQ) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.httpListener);
    }

    public void tW(int i) {
        this.gQN = i;
        this.gQL = 0;
        bVD();
    }

    public int getLoadType() {
        return this.gQN;
    }

    public void bVD() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.biQ) {
            httpMessage.setTag(FOLLOWME);
        } else {
            httpMessage.setTag(MYFOLLOW);
        }
        if (this.mId != null && !this.mId.equals(TbadkCoreApplication.getCurrentAccount())) {
            httpMessage.addParam("uid", this.mId);
        }
        hashMap.put("id", String.valueOf(this.mId));
        if (this.gQL != 0) {
            this.gQL++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.gQL));
        }
        httpMessage.addParam("tab", this.gQN);
        hashMap.put("page", String.valueOf(this.gQL));
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

    public void OT(String str) {
        new b(str).execute(new Void[0]);
    }

    /* loaded from: classes23.dex */
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
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ERR_URL);
            aaVar.addPostData("portrait", this.mPortrait);
            return aaVar.postNetData();
        }
    }
}
