package com.baidu.tieba.myAttentionAndFans;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.myAttentionAndFans.message.ResponseLocalPersonListMessage;
import com.baidu.tieba.myAttentionAndFans.message.ResponseNetPersonListMessage;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class PersonListModel extends BdBaseModel<PersonListActivity> {
    public static final int CACHETIME = 604800000;
    public static final int TYPE_ALL = 0;
    public static final int TYPE_EACH = 1;
    private int coM;
    public CustomMessageListener customListener;
    private a fjf;
    private PersonListActivity fjm;
    private com.baidu.tbadk.coreExtra.model.a fjn;
    private int fjo;
    private int fjp;
    private String fjq;
    public HttpMessageListener httpListener;
    private String mId;
    private boolean mIsFollow;
    private int mSex;
    public static final BdUniqueId MYFOLLOW = BdUniqueId.gen();
    public static final BdUniqueId FOLLOWME = BdUniqueId.gen();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void I(String str, boolean z);

        aq e(aq aqVar, boolean z);
    }

    public PersonListModel(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.coM = 0;
        this.fjo = 0;
        this.httpListener = new HttpMessageListener(CmdConfigHttp.PIC_PERSONAL_LIST) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (PersonListModel.this.fjf != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = PersonListModel.this.fjm.getResources().getString(d.j.neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            PersonListModel.this.fjf.I(errorString, false);
                            return;
                        }
                        return;
                    }
                    aq data = ((ResponseNetPersonListMessage) httpResponsedMessage).getData();
                    if (data != null) {
                        if (!StringUtils.isNull(data.agV)) {
                            PersonListModel.this.fjq = data.agV;
                            PersonListModel.this.fjp = data.type;
                        }
                        data.type = PersonListModel.this.fjp;
                        data.agV = PersonListModel.this.fjq;
                    }
                    if (PersonListModel.this.fjf != null) {
                        PersonListModel.this.fjf.e(data, false);
                    }
                }
            }
        };
        this.customListener = new CustomMessageListener(2001188) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
                    aq data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
                    if (data2 == null) {
                        if (PersonListModel.this.fjf != null) {
                            PersonListModel.this.fjf.I("", true);
                            return;
                        }
                        return;
                    }
                    if (!StringUtils.isNull(data2.agV)) {
                        PersonListModel.this.fjq = data2.agV;
                        PersonListModel.this.fjp = data2.type;
                    }
                    data2.type = PersonListModel.this.fjp;
                    data2.agV = PersonListModel.this.fjq;
                    if (PersonListModel.this.fjf != null) {
                        PersonListModel.this.fjf.e(data2, true);
                    }
                }
            }
        };
        this.fjm = personListActivity;
        this.fjn = new com.baidu.tbadk.coreExtra.model.a(this.fjm.getPageContext());
        this.fjn.setLoadDataCallBack(this.mLoadDataCallBack);
        this.mIsFollow = true;
        this.mId = null;
        this.fjf = aVar;
    }

    public int getPage() {
        return this.coM;
    }

    public void setPage(int i) {
        this.coM = i;
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

    public void iP(boolean z) {
        this.mIsFollow = z;
    }

    public boolean aWv() {
        return this.mIsFollow;
    }

    public void Tl() {
        String str;
        MessageManager messageManager = MessageManager.getInstance();
        if (this.mIsFollow) {
            str = TbConfig.SERVER_ADDRESS + "c/u/follow/followList";
        } else {
            str = TbConfig.SERVER_ADDRESS + "c/u/fans/page";
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_PERSONAL_LIST, str);
        tbHttpMessageTask.setResponsedClass(ResponseNetPersonListMessage.class);
        messageManager.registerTask(tbHttpMessageTask);
        registerListener(this.httpListener);
    }

    public void gT(int i) {
        this.fjo = i;
        this.coM = 0;
        aWw();
    }

    public int getLoadType() {
        return this.fjo;
    }

    public void aWw() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_PERSONAL_LIST);
        HashMap hashMap = new HashMap();
        if (this.mIsFollow) {
            httpMessage.setTag(FOLLOWME);
        } else {
            httpMessage.setTag(MYFOLLOW);
        }
        if (this.mId != null && !this.mId.equals(TbadkCoreApplication.getCurrentAccount())) {
            httpMessage.addParam("uid", this.mId);
        }
        hashMap.put("id", String.valueOf(this.mId));
        if (this.coM != 0) {
            this.coM++;
            httpMessage.addParam("pn", String.valueOf(this.coM));
        }
        httpMessage.addParam("tab", this.fjo);
        hashMap.put("page", String.valueOf(this.coM));
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
}
