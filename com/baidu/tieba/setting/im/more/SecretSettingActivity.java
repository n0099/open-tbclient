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
/* loaded from: classes25.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private c lWO;
    private a lWP;
    private ArrayList<m> lWR;
    private int lWS;
    private int lWT;
    private int lWU;
    private int lWV;
    private int lWW;
    private int lWX;
    private int lWY;
    private e lWZ;
    private boolean lWQ = false;
    private c.a lXa = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dtM() {
            SecretSettingActivity.this.dtK();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dtN() {
            SecretSettingActivity.this.fV("like", SecretSettingActivity.this.getPageContext().getString(R.string.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dtO() {
            SecretSettingActivity.this.fV(TbEnum.ParamKey.GROUP, SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dtP() {
            SecretSettingActivity.this.fV("live", SecretSettingActivity.this.getPageContext().getString(R.string.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dtQ() {
            SecretSettingActivity.this.dtL();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dtR() {
            SecretSettingActivity.this.fV("reply", SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_thread_reply));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dtS() {
            SecretSettingActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PrivacyPermissionActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity())));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dtT() {
            PrivacyMarkActivityConfig privacyMarkActivityConfig = new PrivacyMarkActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity());
            privacyMarkActivityConfig.setMarkState(SecretSettingActivity.this.lWX, SecretSettingActivity.this.lWY);
            SecretSettingActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, privacyMarkActivityConfig));
            TiebaStatic.log(new aq("c14002").dF("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    };
    private HttpMessageListener lXb = new HttpMessageListener(1001506, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
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
                        SecretSettingActivity.this.lWP.bD(operation, type);
                        SecretSettingActivity.this.lWO.bF(operation, type);
                    }
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a dRa = new com.baidu.adp.framework.listener.a(1002501, CmdConfigSocket.CMD_GET_PRIVATE_INFO) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SecretSettingActivity.this.hideProgressBar();
            if (responsedMessage != null) {
                SecretSettingActivity.this.lWQ = true;
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
                    SecretSettingActivity.this.lWP.b(aVar);
                    SecretSettingActivity.this.lWP.dtE();
                    SecretSettingActivity.this.lWO.vI(true);
                    SecretSettingActivity.this.lWO.d(SecretSettingActivity.this.lWP);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.lWP);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.lWP.dtI());
                }
            }
        }
    };
    private CustomMessageListener lXc = new CustomMessageListener(2921499) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            int i = com.baidu.tbadk.core.sharedPref.b.bjf().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
            int i2 = com.baidu.tbadk.core.sharedPref.b.bjf().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
            SecretSettingActivity.this.lWX = i;
            SecretSettingActivity.this.lWY = i2;
            SecretSettingActivity.this.lWO.di(i, i2);
        }
    };
    private CustomMessageListener lXd = new CustomMessageListener(CmdConfigCustom.CMD_PRIVACY_STATUS) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.lWP.Hi(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.lWO.d(SecretSettingActivity.this.lWP);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lWO = new c(this);
        this.lWP = new a();
        this.lWO.a(this.lXa);
        if (this.lWP.dtC()) {
            this.lWO.vI(true);
            this.lWO.d(this.lWP);
            c(this.lWP);
        } else {
            this.lWO.vI(false);
        }
        registerListener(this.dRa);
        registerListener(this.lXb);
        registerListener(this.lXd);
        registerListener(this.lXc);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.lWS = aVar.dtF();
        this.lWT = aVar.dtD();
        this.lWU = aVar.dtH();
        this.lWV = aVar.dtG();
        this.lWW = aVar.dtJ();
        this.lWX = aVar.getBazhuShowInside();
        this.lWY = aVar.getBazhuShowOutside();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lWO.onChangeSkinType(i);
        if (this.lWZ != null) {
            this.lWZ.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.lWO.dtU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fV(final String str, String str2) {
        if (this.lWQ) {
            if (TbEnum.ParamKey.GROUP.equals(str)) {
                this.lWR = Hr(this.lWU);
            } else if ("post".equals(str)) {
                this.lWR = Hr(this.lWT);
            } else if ("like".equals(str)) {
                this.lWR = Hr(this.lWS);
            } else if ("live".equals(str)) {
                this.lWR = Hs(this.lWV);
            } else if ("reply".equals(str)) {
                this.lWR = Ht(this.lWW);
            }
            if (this.lWZ != null) {
                this.lWZ.dismiss();
            }
            this.lWZ = new e(getPageContext());
            this.lWZ.zX(str2);
            this.lWZ.a(this.lWR, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((m) SecretSettingActivity.this.lWR.get(i)).getTag();
                    int i2 = 0;
                    if ("showAll".equals(tag)) {
                        SecretSettingActivity.this.bE(str, 1);
                        i2 = 1;
                    } else if ("friendOnly".equals(tag)) {
                        SecretSettingActivity.this.bE(str, 2);
                        i2 = 2;
                    } else if ("hideAll".equals(tag)) {
                        SecretSettingActivity.this.bE(str, 3);
                        i2 = 3;
                    } else if ("my_fans_reply".equals(tag)) {
                        SecretSettingActivity.this.bE(str, 5);
                        i2 = 5;
                    } else if ("my_attention_reply".equals(tag)) {
                        SecretSettingActivity.this.bE(str, 6);
                        i2 = 6;
                    }
                    SecretSettingActivity.this.lWZ.refresh(i);
                    if (TbEnum.ParamKey.GROUP.equals(str)) {
                        SecretSettingActivity.this.lWU = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.lWT = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.lWS = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.lWV = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.lWW = i2;
                    }
                }
            }).zX(str2);
            this.lWZ.bid().bie();
        }
    }

    private ArrayList<m> Hr(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> Hs(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> Ht(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.all_person), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new m(getPageContext().getString(R.string.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtK() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_IMBLACK_LIST, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtL() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_USER_MUTE_LIST_ACTIVITY, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(String str, int i) {
        sendMessage(new PrivacySettingMessage(str, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.lWZ != null) {
            this.lWZ.dismiss();
        }
    }
}
