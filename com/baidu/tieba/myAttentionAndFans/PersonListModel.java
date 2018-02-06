package com.baidu.tieba.myAttentionAndFans;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.myAttentionAndFans.message.RequestLocalPersonListMessage;
import com.baidu.tieba.myAttentionAndFans.message.ResponseLocalPersonListMessage;
import com.baidu.tieba.myAttentionAndFans.message.ResponseNetPersonListMessage;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class PersonListModel extends BdBaseModel<PersonListActivity> {
    public static final int CACHETIME = 604800000;
    public static final int TYPE_ALL = 0;
    public static final int TYPE_EACH = 1;
    private int cLw;
    public CustomMessageListener customListener;
    private a fxM;
    private PersonListActivity fxT;
    private com.baidu.tbadk.coreExtra.model.a fxU;
    private int fxV;
    public HttpMessageListener httpListener;
    private String mId;
    private boolean mIsFollow;
    private int mSex;
    public static final BdUniqueId MYFOLLOW = BdUniqueId.gen();
    public static final BdUniqueId FOLLOWME = BdUniqueId.gen();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void N(String str, boolean z);

        aq d(aq aqVar, boolean z);
    }

    public PersonListModel(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.cLw = 0;
        this.fxV = 0;
        this.httpListener = new HttpMessageListener(CmdConfigHttp.PIC_PERSONAL_LIST) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (PersonListModel.this.fxM != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = PersonListModel.this.fxT.getResources().getString(d.j.neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            PersonListModel.this.fxM.N(errorString, false);
                            return;
                        }
                        return;
                    }
                    aq data = ((ResponseNetPersonListMessage) httpResponsedMessage).getData();
                    if (PersonListModel.this.fxM != null) {
                        PersonListModel.this.fxM.d(data, false);
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
                    if (data2 != null) {
                        if (PersonListModel.this.fxM != null) {
                            PersonListModel.this.fxM.d(data2, true);
                        }
                    } else if (PersonListModel.this.fxM != null) {
                        PersonListModel.this.fxM.N("", true);
                    }
                }
            }
        };
        this.fxT = personListActivity;
        this.fxU = new com.baidu.tbadk.coreExtra.model.a(this.fxT.getPageContext());
        this.fxU.setLoadDataCallBack(this.mLoadDataCallBack);
        this.mIsFollow = true;
        this.mId = null;
        this.fxM = aVar;
    }

    public int getPage() {
        return this.cLw;
    }

    public void setPage(int i) {
        this.cLw = i;
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

    public void jm(boolean z) {
        this.mIsFollow = z;
    }

    public boolean aTA() {
        return this.mIsFollow;
    }

    public void WM() {
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

    public void jI(int i) {
        this.fxV = i;
        this.cLw = 0;
        aXA();
    }

    public int getLoadType() {
        return this.fxV;
    }

    public void aXA() {
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
        if (this.cLw != 0) {
            this.cLw++;
            httpMessage.addParam("pn", String.valueOf(this.cLw));
        }
        httpMessage.addParam("tab", this.fxV);
        hashMap.put(WBPageConstants.ParamKey.PAGE, String.valueOf(this.cLw));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    public void aXB() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001188, new e());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.customListener);
    }

    public void aXC() {
        RequestLocalPersonListMessage requestLocalPersonListMessage = new RequestLocalPersonListMessage();
        requestLocalPersonListMessage.setFollow(this.mIsFollow);
        requestLocalPersonListMessage.setUid(this.mId);
        sendMessage(requestLocalPersonListMessage);
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
