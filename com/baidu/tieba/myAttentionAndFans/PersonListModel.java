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
import com.baidu.tbadk.core.data.ar;
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
    private int cku;
    public CustomMessageListener customListener;
    private a feX;
    private PersonListActivity ffe;
    private com.baidu.tbadk.coreExtra.model.a fff;
    private int ffg;
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

        ar d(ar arVar, boolean z);
    }

    public PersonListModel(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.cku = 0;
        this.ffg = 0;
        this.httpListener = new HttpMessageListener(CmdConfigHttp.PIC_PERSONAL_LIST) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (PersonListModel.this.feX != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = PersonListModel.this.ffe.getResources().getString(d.k.neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            PersonListModel.this.feX.I(errorString, false);
                            return;
                        }
                        return;
                    }
                    ar data = ((ResponseNetPersonListMessage) httpResponsedMessage).getData();
                    if (PersonListModel.this.feX != null) {
                        PersonListModel.this.feX.d(data, false);
                    }
                }
            }
        };
        this.customListener = new CustomMessageListener(2001188) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
                    ar data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
                    if (data2 != null) {
                        if (PersonListModel.this.feX != null) {
                            PersonListModel.this.feX.d(data2, true);
                        }
                    } else if (PersonListModel.this.feX != null) {
                        PersonListModel.this.feX.I("", true);
                    }
                }
            }
        };
        this.ffe = personListActivity;
        this.fff = new com.baidu.tbadk.coreExtra.model.a(this.ffe.getPageContext());
        this.fff.setLoadDataCallBack(this.mLoadDataCallBack);
        this.mIsFollow = true;
        this.mId = null;
        this.feX = aVar;
    }

    public int getPage() {
        return this.cku;
    }

    public void setPage(int i) {
        this.cku = i;
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

    public void iU(boolean z) {
        this.mIsFollow = z;
    }

    public boolean aTr() {
        return this.mIsFollow;
    }

    public void SH() {
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

    public void gO(int i) {
        this.ffg = i;
        this.cku = 0;
        aXr();
    }

    public int getLoadType() {
        return this.ffg;
    }

    public void aXr() {
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
        if (this.cku != 0) {
            this.cku++;
            httpMessage.addParam("pn", String.valueOf(this.cku));
        }
        httpMessage.addParam("tab", this.ffg);
        hashMap.put(WBPageConstants.ParamKey.PAGE, String.valueOf(this.cku));
        httpMessage.setExtra(hashMap);
        sendMessage(httpMessage);
    }

    public void aXs() {
        com.baidu.tbadk.task.a aVar = new com.baidu.tbadk.task.a(2001188, new e());
        aVar.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aVar);
        registerListener(this.customListener);
    }

    public void aXt() {
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
