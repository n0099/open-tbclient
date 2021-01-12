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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.myAttentionAndFans.message.ResponseLocalPersonListMessage;
import com.baidu.tieba.myAttentionAndFans.message.ResponseNetPersonListMessage;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class PersonListModel extends BdBaseModel<PersonListActivity> {
    public static final int CACHETIME = 604800000;
    public static final int TYPE_ALL = 0;
    public static final int TYPE_EACH = 1;
    private int bZk;
    private boolean bik;
    public CustomMessageListener customListener;
    private int hgQ;
    private int hgR;
    private String hgS;
    public HttpMessageListener httpListener;
    private a lnW;
    private PersonListActivity lof;
    private com.baidu.tbadk.coreExtra.model.a loh;
    private String mId;
    private int mSex;
    public static final BdUniqueId MYFOLLOW = BdUniqueId.gen();
    public static final BdUniqueId FOLLOWME = BdUniqueId.gen();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface a {
        void aD(String str, boolean z);

        be e(be beVar, boolean z);
    }

    public PersonListModel(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.bZk = 0;
        this.hgQ = 0;
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
                            if (PersonListModel.this.lnW != null) {
                                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                    errorString = PersonListModel.this.lof.getResources().getString(R.string.neterror);
                                } else {
                                    errorString = httpResponsedMessage.getErrorString();
                                }
                                PersonListModel.this.lnW.aD(errorString, false);
                                return;
                            }
                            return;
                        }
                        be data = ((ResponseNetPersonListMessage) httpResponsedMessage).getData();
                        if (data != null) {
                            if (!StringUtils.isNull(data.eMJ)) {
                                PersonListModel.this.hgS = data.eMJ;
                                PersonListModel.this.hgR = data.type;
                            }
                            data.type = PersonListModel.this.hgR;
                            data.eMJ = PersonListModel.this.hgS;
                        }
                        if (PersonListModel.this.lnW != null) {
                            PersonListModel.this.lnW.e(data, false);
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
                    be data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
                    if (data2 == null) {
                        if (PersonListModel.this.lnW != null) {
                            PersonListModel.this.lnW.aD("", true);
                            return;
                        }
                        return;
                    }
                    if (!StringUtils.isNull(data2.eMJ)) {
                        PersonListModel.this.hgS = data2.eMJ;
                        PersonListModel.this.hgR = data2.type;
                    }
                    data2.type = PersonListModel.this.hgR;
                    data2.eMJ = PersonListModel.this.hgS;
                    if (PersonListModel.this.lnW != null) {
                        PersonListModel.this.lnW.e(data2, true);
                    }
                }
            }
        };
        this.lof = personListActivity;
        this.loh = new com.baidu.tbadk.coreExtra.model.a(this.lof.getPageContext());
        this.loh.setLoadDataCallBack(this.mLoadDataCallBack);
        this.bik = true;
        this.mId = null;
        this.lnW = aVar;
    }

    public int getPage() {
        return this.bZk;
    }

    public void setPage(int i) {
        this.bZk = i;
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

    public void bu(boolean z) {
        this.bik = z;
    }

    public boolean bXt() {
        return this.bik;
    }

    public void bQw() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.bik) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.httpListener);
    }

    public void loadData(int i) {
        this.hgQ = i;
        this.bZk = 0;
        bXu();
    }

    public int getLoadType() {
        return this.hgQ;
    }

    public void bXu() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.bik) {
            httpMessage.setTag(FOLLOWME);
        } else {
            httpMessage.setTag(MYFOLLOW);
        }
        if (this.mId != null && !this.mId.equals(TbadkCoreApplication.getCurrentAccount())) {
            httpMessage.addParam("uid", this.mId);
        }
        hashMap.put("id", String.valueOf(this.mId));
        if (this.bZk != 0) {
            this.bZk++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.bZk));
        }
        httpMessage.addParam("tab", this.hgQ);
        hashMap.put("page", String.valueOf(this.bZk));
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

    public void NU(String str) {
        new b(str).execute(new Void[0]);
    }

    /* loaded from: classes7.dex */
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
            z zVar = new z(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ERR_URL);
            zVar.addPostData("portrait", this.mPortrait);
            return zVar.postNetData();
        }
    }
}
