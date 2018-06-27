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
import com.baidu.tbadk.core.data.ar;
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
    private int cmY;
    public CustomMessageListener customListener;
    private a fiT;
    private PersonListActivity fja;
    private com.baidu.tbadk.coreExtra.model.a fjb;
    private int fjc;
    private int fjd;
    private String fje;
    public HttpMessageListener httpListener;
    private String mId;
    private boolean mIsFollow;
    private int mSex;
    public static final BdUniqueId MYFOLLOW = BdUniqueId.gen();
    public static final BdUniqueId FOLLOWME = BdUniqueId.gen();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void J(String str, boolean z);

        ar e(ar arVar, boolean z);
    }

    public PersonListModel(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.cmY = 0;
        this.fjc = 0;
        this.httpListener = new HttpMessageListener(CmdConfigHttp.PIC_PERSONAL_LIST) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                String errorString;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002004 && (httpResponsedMessage instanceof ResponseNetPersonListMessage)) {
                    int statusCode = httpResponsedMessage.getStatusCode();
                    int error = httpResponsedMessage.getError();
                    if (statusCode != 200 || error != 0) {
                        if (PersonListModel.this.fiT != null) {
                            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                errorString = PersonListModel.this.fja.getResources().getString(d.k.neterror);
                            } else {
                                errorString = httpResponsedMessage.getErrorString();
                            }
                            PersonListModel.this.fiT.J(errorString, false);
                            return;
                        }
                        return;
                    }
                    ar data = ((ResponseNetPersonListMessage) httpResponsedMessage).getData();
                    if (data != null) {
                        if (!StringUtils.isNull(data.ahB)) {
                            PersonListModel.this.fje = data.ahB;
                            PersonListModel.this.fjd = data.type;
                        }
                        data.type = PersonListModel.this.fjd;
                        data.ahB = PersonListModel.this.fje;
                    }
                    if (PersonListModel.this.fiT != null) {
                        PersonListModel.this.fiT.e(data, false);
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
                    if (data2 == null) {
                        if (PersonListModel.this.fiT != null) {
                            PersonListModel.this.fiT.J("", true);
                            return;
                        }
                        return;
                    }
                    if (!StringUtils.isNull(data2.ahB)) {
                        PersonListModel.this.fje = data2.ahB;
                        PersonListModel.this.fjd = data2.type;
                    }
                    data2.type = PersonListModel.this.fjd;
                    data2.ahB = PersonListModel.this.fje;
                    if (PersonListModel.this.fiT != null) {
                        PersonListModel.this.fiT.e(data2, true);
                    }
                }
            }
        };
        this.fja = personListActivity;
        this.fjb = new com.baidu.tbadk.coreExtra.model.a(this.fja.getPageContext());
        this.fjb.setLoadDataCallBack(this.mLoadDataCallBack);
        this.mIsFollow = true;
        this.mId = null;
        this.fiT = aVar;
    }

    public int getPage() {
        return this.cmY;
    }

    public void setPage(int i) {
        this.cmY = i;
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

    public void jd(boolean z) {
        this.mIsFollow = z;
    }

    public boolean aTY() {
        return this.mIsFollow;
    }

    public void Td() {
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

    public void gN(int i) {
        this.fjc = i;
        this.cmY = 0;
        aYa();
    }

    public int getLoadType() {
        return this.fjc;
    }

    public void aYa() {
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
        if (this.cmY != 0) {
            this.cmY++;
            httpMessage.addParam("pn", String.valueOf(this.cmY));
        }
        httpMessage.addParam("tab", this.fjc);
        hashMap.put("page", String.valueOf(this.cmY));
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
