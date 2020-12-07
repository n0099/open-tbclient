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
    private boolean blr;
    public CustomMessageListener customListener;
    private int gZF;
    private int gZH;
    private int gZI;
    private String gZJ;
    public HttpMessageListener httpListener;
    private a lnm;
    private PersonListActivity lnu;
    private com.baidu.tbadk.coreExtra.model.a lnv;
    private String mId;
    private int mSex;
    public static final BdUniqueId MYFOLLOW = BdUniqueId.gen();
    public static final BdUniqueId FOLLOWME = BdUniqueId.gen();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public interface a {
        void aC(String str, boolean z);

        be e(be beVar, boolean z);
    }

    public PersonListModel(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.gZF = 0;
        this.gZH = 0;
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
                            if (PersonListModel.this.lnm != null) {
                                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                    errorString = PersonListModel.this.lnu.getResources().getString(R.string.neterror);
                                } else {
                                    errorString = httpResponsedMessage.getErrorString();
                                }
                                PersonListModel.this.lnm.aC(errorString, false);
                                return;
                            }
                            return;
                        }
                        be data = ((ResponseNetPersonListMessage) httpResponsedMessage).getData();
                        if (data != null) {
                            if (!StringUtils.isNull(data.eHD)) {
                                PersonListModel.this.gZJ = data.eHD;
                                PersonListModel.this.gZI = data.type;
                            }
                            data.type = PersonListModel.this.gZI;
                            data.eHD = PersonListModel.this.gZJ;
                        }
                        if (PersonListModel.this.lnm != null) {
                            PersonListModel.this.lnm.e(data, false);
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
                        if (PersonListModel.this.lnm != null) {
                            PersonListModel.this.lnm.aC("", true);
                            return;
                        }
                        return;
                    }
                    if (!StringUtils.isNull(data2.eHD)) {
                        PersonListModel.this.gZJ = data2.eHD;
                        PersonListModel.this.gZI = data2.type;
                    }
                    data2.type = PersonListModel.this.gZI;
                    data2.eHD = PersonListModel.this.gZJ;
                    if (PersonListModel.this.lnm != null) {
                        PersonListModel.this.lnm.e(data2, true);
                    }
                }
            }
        };
        this.lnu = personListActivity;
        this.lnv = new com.baidu.tbadk.coreExtra.model.a(this.lnu.getPageContext());
        this.lnv.setLoadDataCallBack(this.mLoadDataCallBack);
        this.blr = true;
        this.mId = null;
        this.lnm = aVar;
    }

    public int getPage() {
        return this.gZF;
    }

    public void setPage(int i) {
        this.gZF = i;
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

    public void mZ(boolean z) {
        this.blr = z;
    }

    public boolean bYE() {
        return this.blr;
    }

    public void bRK() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.blr) {
            str = TbConfig.SERVER_ADDRESS + Config.GET_FOLLOW_ADDRESS;
        } else {
            str = TbConfig.SERVER_ADDRESS + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1002004, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.httpListener);
    }

    public void uY(int i) {
        this.gZH = i;
        this.gZF = 0;
        bYF();
    }

    public int getLoadType() {
        return this.gZH;
    }

    public void bYF() {
        HttpMessage httpMessage = new HttpMessage(1002004);
        HashMap hashMap = new HashMap();
        if (this.blr) {
            httpMessage.setTag(FOLLOWME);
        } else {
            httpMessage.setTag(MYFOLLOW);
        }
        if (this.mId != null && !this.mId.equals(TbadkCoreApplication.getCurrentAccount())) {
            httpMessage.addParam("uid", this.mId);
        }
        hashMap.put("id", String.valueOf(this.mId));
        if (this.gZF != 0) {
            this.gZF++;
            httpMessage.addParam(com.baidu.mobstat.Config.PACKAGE_NAME, String.valueOf(this.gZF));
        }
        httpMessage.addParam("tab", this.gZH);
        hashMap.put("page", String.valueOf(this.gZF));
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

    public void Px(String str) {
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
