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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.e;
import com.baidu.tieba.myAttentionAndFans.message.ResponseLocalPersonListMessage;
import com.baidu.tieba.myAttentionAndFans.message.ResponseNetPersonListMessage;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class PersonListModel extends BdBaseModel<PersonListActivity> {
    public static final int CACHETIME = 604800000;
    public static final int TYPE_ALL = 0;
    public static final int TYPE_EACH = 1;
    private int cEl;
    public CustomMessageListener customListener;
    private PersonListActivity fzF;
    private com.baidu.tbadk.coreExtra.model.a fzG;
    private int fzH;
    private int fzI;
    private String fzJ;
    private a fzy;
    public HttpMessageListener httpListener;
    private String mId;
    private boolean mIsFollow;
    private int mSex;
    public static final BdUniqueId MYFOLLOW = BdUniqueId.gen();
    public static final BdUniqueId FOLLOWME = BdUniqueId.gen();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        void Q(String str, boolean z);

        aq e(aq aqVar, boolean z);
    }

    public PersonListModel(PersonListActivity personListActivity, a aVar) {
        super(personListActivity.getPageContext());
        this.cEl = 0;
        this.fzH = 0;
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
                            if (PersonListModel.this.fzy != null) {
                                if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                                    errorString = PersonListModel.this.fzF.getResources().getString(e.j.neterror);
                                } else {
                                    errorString = httpResponsedMessage.getErrorString();
                                }
                                PersonListModel.this.fzy.Q(errorString, false);
                                return;
                            }
                            return;
                        }
                        aq data = ((ResponseNetPersonListMessage) httpResponsedMessage).getData();
                        if (data != null) {
                            if (!StringUtils.isNull(data.apd)) {
                                PersonListModel.this.fzJ = data.apd;
                                PersonListModel.this.fzI = data.type;
                            }
                            data.type = PersonListModel.this.fzI;
                            data.apd = PersonListModel.this.fzJ;
                        }
                        if (PersonListModel.this.fzy != null) {
                            PersonListModel.this.fzy.e(data, false);
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
                    aq data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
                    if (data2 == null) {
                        if (PersonListModel.this.fzy != null) {
                            PersonListModel.this.fzy.Q("", true);
                            return;
                        }
                        return;
                    }
                    if (!StringUtils.isNull(data2.apd)) {
                        PersonListModel.this.fzJ = data2.apd;
                        PersonListModel.this.fzI = data2.type;
                    }
                    data2.type = PersonListModel.this.fzI;
                    data2.apd = PersonListModel.this.fzJ;
                    if (PersonListModel.this.fzy != null) {
                        PersonListModel.this.fzy.e(data2, true);
                    }
                }
            }
        };
        this.fzF = personListActivity;
        this.fzG = new com.baidu.tbadk.coreExtra.model.a(this.fzF.getPageContext());
        this.fzG.setLoadDataCallBack(this.mLoadDataCallBack);
        this.mIsFollow = true;
        this.mId = null;
        this.fzy = aVar;
    }

    public int getPage() {
        return this.cEl;
    }

    public void setPage(int i) {
        this.cEl = i;
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

    public void jP(boolean z) {
        this.mIsFollow = z;
    }

    public boolean bbp() {
        return this.mIsFollow;
    }

    public void YT() {
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

    public void id(int i) {
        this.fzH = i;
        this.cEl = 0;
        bbq();
    }

    public int getLoadType() {
        return this.fzH;
    }

    public void bbq() {
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
        if (this.cEl != 0) {
            this.cEl++;
            httpMessage.addParam(Config.PACKAGE_NAME, String.valueOf(this.cEl));
        }
        httpMessage.addParam("tab", this.fzH);
        hashMap.put(SystemScreenshotManager.PAGE, String.valueOf(this.cEl));
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
