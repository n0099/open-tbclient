package com.baidu.tieba.setting.im.more;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.IMBlackListActivityConfig;
import com.baidu.tbadk.core.dialog.e;
import com.baidu.tbadk.core.dialog.m;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.tieba.setting.PrivacyPermissionActivityConfig;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.setting.im.more.c;
import java.util.ArrayList;
/* loaded from: classes26.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private c mEW;
    private a mEX;
    private ArrayList<m> mEZ;
    private int mFa;
    private int mFb;
    private int mFc;
    private int mFe;
    private int mFf;
    private int mFg;
    private int mFh;
    private e mFi;
    private boolean mEY = false;
    private c.a mFj = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dDh() {
            SecretSettingActivity.this.dDf();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dDi() {
            SecretSettingActivity.this.gh("like", SecretSettingActivity.this.getPageContext().getString(R.string.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dDj() {
            SecretSettingActivity.this.gh(TbEnum.ParamKey.GROUP, SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dDk() {
            SecretSettingActivity.this.gh("live", SecretSettingActivity.this.getPageContext().getString(R.string.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dDl() {
            SecretSettingActivity.this.dDg();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dDm() {
            SecretSettingActivity.this.gh("reply", SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_thread_reply));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dDn() {
            SecretSettingActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PrivacyPermissionActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity())));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dDo() {
            PrivacyMarkActivityConfig privacyMarkActivityConfig = new PrivacyMarkActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity());
            privacyMarkActivityConfig.setMarkState(SecretSettingActivity.this.mFg, SecretSettingActivity.this.mFh);
            SecretSettingActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, privacyMarkActivityConfig));
            TiebaStatic.log(new aq("c14002").dR("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    };
    private HttpMessageListener mFk = new HttpMessageListener(1001506, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null) {
                SecretSettingActivity.this.hideProgressBar();
                if (httpResponsedMessage.getOrginalMessage() instanceof PrivacySettingMessage) {
                    PrivacySettingMessage privacySettingMessage = (PrivacySettingMessage) httpResponsedMessage.getOrginalMessage();
                    String operation = privacySettingMessage.getOperation();
                    int type = privacySettingMessage.getType();
                    if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                        SecretSettingActivity.this.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? SecretSettingActivity.this.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        return;
                    }
                    SecretSettingActivity.this.showToast(R.string.success);
                    if (!TextUtils.equals("location", operation)) {
                        SecretSettingActivity.this.mEX.bH(operation, type);
                        SecretSettingActivity.this.mEW.bJ(operation, type);
                    }
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a ers = new com.baidu.adp.framework.listener.a(1002501, CmdConfigSocket.CMD_GET_PRIVATE_INFO) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SecretSettingActivity.this.hideProgressBar();
            if (responsedMessage != null) {
                SecretSettingActivity.this.mEY = true;
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    SecretSettingActivity.this.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? SecretSettingActivity.this.getResources().getString(R.string.neterror) : responsedMessage.getErrorString());
                    return;
                }
                a aVar = null;
                if (responsedMessage instanceof ResponsedPrivacyHttpMessage) {
                    aVar = ((ResponsedPrivacyHttpMessage) responsedMessage).getPrivacyData();
                }
                if (responsedMessage instanceof ResponsedPrivacySocketMessage) {
                    aVar = ((ResponsedPrivacySocketMessage) responsedMessage).getPrivacyData();
                }
                if (aVar != null) {
                    SecretSettingActivity.this.mEX.b(aVar);
                    SecretSettingActivity.this.mEX.dCZ();
                    SecretSettingActivity.this.mEW.wP(true);
                    SecretSettingActivity.this.mEW.d(SecretSettingActivity.this.mEX);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.mEX);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.mEX.dDd());
                }
            }
        }
    };
    private CustomMessageListener mFl = new CustomMessageListener(2921499) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            int i = com.baidu.tbadk.core.sharedPref.b.bqh().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
            int i2 = com.baidu.tbadk.core.sharedPref.b.bqh().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
            SecretSettingActivity.this.mFg = i;
            SecretSettingActivity.this.mFh = i2;
            SecretSettingActivity.this.mEW.dm(i, i2);
        }
    };
    private CustomMessageListener mFm = new CustomMessageListener(CmdConfigCustom.CMD_PRIVACY_STATUS) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.mEX.Iu(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.mEW.d(SecretSettingActivity.this.mEX);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mEW = new c(this);
        this.mEX = new a();
        this.mEW.a(this.mFj);
        if (this.mEX.dCX()) {
            this.mEW.wP(true);
            this.mEW.d(this.mEX);
            c(this.mEX);
        } else {
            this.mEW.wP(false);
        }
        registerListener(this.ers);
        registerListener(this.mFk);
        registerListener(this.mFm);
        registerListener(this.mFl);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.mFa = aVar.dDa();
        this.mFb = aVar.dCY();
        this.mFc = aVar.dDc();
        this.mFe = aVar.dDb();
        this.mFf = aVar.dDe();
        this.mFg = aVar.getBazhuShowInside();
        this.mFh = aVar.getBazhuShowOutside();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mEW.onChangeSkinType(i);
        if (this.mFi != null) {
            this.mFi.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.mEW.dDp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gh(final String str, String str2) {
        if (this.mEY) {
            if (TbEnum.ParamKey.GROUP.equals(str)) {
                this.mEZ = ID(this.mFc);
            } else if ("post".equals(str)) {
                this.mEZ = ID(this.mFb);
            } else if ("like".equals(str)) {
                this.mEZ = ID(this.mFa);
            } else if ("live".equals(str)) {
                this.mEZ = IE(this.mFe);
            } else if ("reply".equals(str)) {
                this.mEZ = IF(this.mFf);
            }
            if (this.mFi != null) {
                this.mFi.dismiss();
            }
            this.mFi = new e(getPageContext());
            this.mFi.Bq(str2);
            this.mFi.a(this.mEZ, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((m) SecretSettingActivity.this.mEZ.get(i)).getTag();
                    int i2 = 0;
                    if ("showAll".equals(tag)) {
                        SecretSettingActivity.this.bI(str, 1);
                        i2 = 1;
                    } else if ("friendOnly".equals(tag)) {
                        SecretSettingActivity.this.bI(str, 2);
                        i2 = 2;
                    } else if ("hideAll".equals(tag)) {
                        SecretSettingActivity.this.bI(str, 3);
                        i2 = 3;
                    } else if ("my_fans_reply".equals(tag)) {
                        SecretSettingActivity.this.bI(str, 5);
                        i2 = 5;
                    } else if ("my_attention_reply".equals(tag)) {
                        SecretSettingActivity.this.bI(str, 6);
                        i2 = 6;
                    }
                    SecretSettingActivity.this.mFi.refresh(i);
                    if (TbEnum.ParamKey.GROUP.equals(str)) {
                        SecretSettingActivity.this.mFc = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.mFb = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.mFa = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.mFe = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.mFf = i2;
                    }
                }
            }).Bq(str2);
            this.mFi.bpf().bpg();
        }
    }

    private ArrayList<m> ID(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> IE(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> IF(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.all_person), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new m(getPageContext().getString(R.string.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDf() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_IMBLACK_LIST, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDg() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_USER_MUTE_LIST_ACTIVITY, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(String str, int i) {
        sendMessage(new PrivacySettingMessage(str, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mFi != null) {
            this.mFi.dismiss();
        }
    }
}
