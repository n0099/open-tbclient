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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.myAttentionAndFans.message.ResponseLocalPersonListMessage;
import com.baidu.tieba.myAttentionAndFans.message.ResponseNetPersonListMessage;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class PersonListModel extends BdBaseModel<PersonListActivity> {
    public static final int CACHETIME = 604800000;
    public static final int TYPE_ALL = 0;
    public static final int TYPE_EACH = 1;
    public CustomMessageListener customListener;
    private int elY;
    public HttpMessageListener httpListener;
    private a hxH;
    private PersonListActivity hxO;
    private com.baidu.tbadk.coreExtra.model.a hxP;
    private int hxQ;
    private int hxR;
    private String hxS;
    private String mId;
    private boolean mIsFollow;
    private int mSex;
    public static final BdUniqueId MYFOLLOW = BdUniqueId.gen();
    public static final BdUniqueId FOLLOWME = BdUniqueId.gen();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface a {
        void ar(String str, boolean z);

        as e(as asVar, boolean z);
    }

    public PersonListModel(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.elY = 0;
        this.hxQ = 0;
        this.httpListener = new HttpMessageListener(CmdConfigHttp.PIC_PERSONAL_LIST) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    if (PersonListModel.this.getUniqueId().getId() == Integer.parseInt((String) ((HashMap) httpResponsedMessage.getOrginalMessage().getExtra()).get("pageid"))) {
                        int statusCode = httpResponsedMessage.getStatusCode();
                        int error = httpResponsedMessage.getError();
                        if (statusCode != 200 || error != 0) {
                            if (PersonListModel.this.hxH != null) {
                                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                    errorString = PersonListModel.this.hxO.getResources().getString(R.string.neterror);
                                } else {
                                    errorString = httpResponsedMessage.getErrorString();
                                }
                                PersonListModel.this.hxH.ar(errorString, false);
                                return;
                            }
                            return;
                        }
                        as data = ((ResponseNetPersonListMessage) httpResponsedMessage).getData();
                        if (data != null) {
                            if (!StringUtils.isNull(data.bIm)) {
                                PersonListModel.this.hxS = data.bIm;
                                PersonListModel.this.hxR = data.type;
                            }
                            data.type = PersonListModel.this.hxR;
                            data.bIm = PersonListModel.this.hxS;
                        }
                        if (PersonListModel.this.hxH != null) {
                            PersonListModel.this.hxH.e(data, false);
                        }
                    }
                }
            }
        };
        this.customListener = new CustomMessageListener(2001188) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
                    as data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
                    if (data2 == null) {
                        if (PersonListModel.this.hxH != null) {
                            PersonListModel.this.hxH.ar("", true);
                            return;
                        }
                        return;
                    }
                    if (!StringUtils.isNull(data2.bIm)) {
                        PersonListModel.this.hxS = data2.bIm;
                        PersonListModel.this.hxR = data2.type;
                    }
                    data2.type = PersonListModel.this.hxR;
                    data2.bIm = PersonListModel.this.hxS;
                    if (PersonListModel.this.hxH != null) {
                        PersonListModel.this.hxH.e(data2, true);
                    }
                }
            }
        };
        this.hxO = personListActivity;
        this.hxP = new com.baidu.tbadk.coreExtra.model.a(this.hxO.getPageContext());
        this.hxP.setLoadDataCallBack(this.mLoadDataCallBack);
        this.mIsFollow = true;
        this.mId = null;
        this.hxH = aVar;
    }

    public int getPage() {
        return this.elY;
    }

    public void setPage(int i) {
        this.elY = i;
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

    public void nA(boolean z) {
        this.mIsFollow = z;
    }

    public boolean bPq() {
        return this.mIsFollow;
    }

    public void aIO() {
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

    public void nc(int i) {
        this.hxQ = i;
        this.elY = 0;
        bPr();
    }

    public int getLoadType() {
        return this.hxQ;
    }

    public void bPr() {
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
        if (this.elY != 0) {
            this.elY++;
            httpMessage.addParam(Config.PACKAGE_NAME, String.valueOf(this.elY));
        }
        httpMessage.addParam("tab", this.hxQ);
        hashMap.put("page", String.valueOf(this.elY));
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
}
