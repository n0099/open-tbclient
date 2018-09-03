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
import com.baidu.tieba.f;
import com.baidu.tieba.myAttentionAndFans.message.ResponseLocalPersonListMessage;
import com.baidu.tieba.myAttentionAndFans.message.ResponseNetPersonListMessage;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class PersonListModel extends BdBaseModel<PersonListActivity> {
    public static final int CACHETIME = 604800000;
    public static final int TYPE_ALL = 0;
    public static final int TYPE_EACH = 1;
    private int coJ;
    public CustomMessageListener customListener;
    private a fiZ;
    private PersonListActivity fjg;
    private com.baidu.tbadk.coreExtra.model.a fjh;
    private int fji;
    private int fjj;
    private String fjk;
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
        this.coJ = 0;
        this.fji = 0;
        this.httpListener = new HttpMessageListener(CmdConfigHttp.PIC_PERSONAL_LIST) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (PersonListModel.this.fiZ != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = PersonListModel.this.fjg.getResources().getString(f.j.neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            PersonListModel.this.fiZ.I(errorString, false);
                            return;
                        }
                        return;
                    }
                    aq data = ((ResponseNetPersonListMessage) httpResponsedMessage).getData();
                    if (data != null) {
                        if (!StringUtils.isNull(data.agV)) {
                            PersonListModel.this.fjk = data.agV;
                            PersonListModel.this.fjj = data.type;
                        }
                        data.type = PersonListModel.this.fjj;
                        data.agV = PersonListModel.this.fjk;
                    }
                    if (PersonListModel.this.fiZ != null) {
                        PersonListModel.this.fiZ.e(data, false);
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
                        if (PersonListModel.this.fiZ != null) {
                            PersonListModel.this.fiZ.I("", true);
                            return;
                        }
                        return;
                    }
                    if (!StringUtils.isNull(data2.agV)) {
                        PersonListModel.this.fjk = data2.agV;
                        PersonListModel.this.fjj = data2.type;
                    }
                    data2.type = PersonListModel.this.fjj;
                    data2.agV = PersonListModel.this.fjk;
                    if (PersonListModel.this.fiZ != null) {
                        PersonListModel.this.fiZ.e(data2, true);
                    }
                }
            }
        };
        this.fjg = personListActivity;
        this.fjh = new com.baidu.tbadk.coreExtra.model.a(this.fjg.getPageContext());
        this.fjh.setLoadDataCallBack(this.mLoadDataCallBack);
        this.mIsFollow = true;
        this.mId = null;
        this.fiZ = aVar;
    }

    public int getPage() {
        return this.coJ;
    }

    public void setPage(int i) {
        this.coJ = i;
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

    public boolean aWr() {
        return this.mIsFollow;
    }

    public void To() {
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

    public void gS(int i) {
        this.fji = i;
        this.coJ = 0;
        aWs();
    }

    public int getLoadType() {
        return this.fji;
    }

    public void aWs() {
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
        if (this.coJ != 0) {
            this.coJ++;
            httpMessage.addParam("pn", String.valueOf(this.coJ));
        }
        httpMessage.addParam("tab", this.fji);
        hashMap.put("page", String.valueOf(this.coJ));
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
