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
/* loaded from: classes8.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private c mYW;
    private a mYX;
    private ArrayList<m> mYZ;
    private int mZa;
    private int mZb;
    private int mZc;
    private int mZd;
    private int mZe;
    private int mZf;
    private int mZg;
    private e mZh;
    private boolean mYY = false;
    private c.a mZi = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dHN() {
            SecretSettingActivity.this.dHL();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dHO() {
            SecretSettingActivity.this.gj("like", SecretSettingActivity.this.getPageContext().getString(R.string.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dHP() {
            SecretSettingActivity.this.gj(TbEnum.ParamKey.GROUP, SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dHQ() {
            SecretSettingActivity.this.gj("live", SecretSettingActivity.this.getPageContext().getString(R.string.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dHR() {
            SecretSettingActivity.this.dHM();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dHS() {
            SecretSettingActivity.this.gj("reply", SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_thread_reply));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dHT() {
            SecretSettingActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PrivacyPermissionActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity())));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dHU() {
            PrivacyMarkActivityConfig privacyMarkActivityConfig = new PrivacyMarkActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity());
            privacyMarkActivityConfig.setMarkState(SecretSettingActivity.this.mZf, SecretSettingActivity.this.mZg);
            SecretSettingActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, privacyMarkActivityConfig));
            TiebaStatic.log(new aq("c14002").dX("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    };
    private HttpMessageListener mZj = new HttpMessageListener(1001506, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
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
                        SecretSettingActivity.this.mYX.bQ(operation, type);
                        SecretSettingActivity.this.mYW.bS(operation, type);
                    }
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a eFZ = new com.baidu.adp.framework.listener.a(1002501, CmdConfigSocket.CMD_GET_PRIVATE_INFO) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SecretSettingActivity.this.hideProgressBar();
            if (responsedMessage != null) {
                SecretSettingActivity.this.mYY = true;
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
                    SecretSettingActivity.this.mYX.b(aVar);
                    SecretSettingActivity.this.mYX.dHF();
                    SecretSettingActivity.this.mYW.xx(true);
                    SecretSettingActivity.this.mYW.d(SecretSettingActivity.this.mYX);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.mYX);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.mYX.dHJ());
                }
            }
        }
    };
    private CustomMessageListener mZk = new CustomMessageListener(2921499) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            int i = com.baidu.tbadk.core.sharedPref.b.bvq().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
            int i2 = com.baidu.tbadk.core.sharedPref.b.bvq().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
            SecretSettingActivity.this.mZf = i;
            SecretSettingActivity.this.mZg = i2;
            SecretSettingActivity.this.mYW.dn(i, i2);
        }
    };
    private CustomMessageListener mZl = new CustomMessageListener(CmdConfigCustom.CMD_PRIVACY_STATUS) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.mYX.JG(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.mYW.d(SecretSettingActivity.this.mYX);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mYW = new c(this);
        this.mYX = new a();
        this.mYW.a(this.mZi);
        if (this.mYX.dHD()) {
            this.mYW.xx(true);
            this.mYW.d(this.mYX);
            c(this.mYX);
        } else {
            this.mYW.xx(false);
        }
        registerListener(this.eFZ);
        registerListener(this.mZj);
        registerListener(this.mZl);
        registerListener(this.mZk);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.mZa = aVar.dHG();
        this.mZb = aVar.dHE();
        this.mZc = aVar.dHI();
        this.mZd = aVar.dHH();
        this.mZe = aVar.dHK();
        this.mZf = aVar.getBazhuShowInside();
        this.mZg = aVar.getBazhuShowOutside();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mYW.onChangeSkinType(i);
        if (this.mZh != null) {
            this.mZh.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.mYW.dHV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gj(final String str, String str2) {
        if (this.mYY) {
            if (TbEnum.ParamKey.GROUP.equals(str)) {
                this.mYZ = JP(this.mZc);
            } else if ("post".equals(str)) {
                this.mYZ = JP(this.mZb);
            } else if ("like".equals(str)) {
                this.mYZ = JP(this.mZa);
            } else if ("live".equals(str)) {
                this.mYZ = JQ(this.mZd);
            } else if ("reply".equals(str)) {
                this.mYZ = JR(this.mZe);
            }
            if (this.mZh != null) {
                this.mZh.dismiss();
            }
            this.mZh = new e(getPageContext());
            this.mZh.Br(str2);
            this.mZh.a(this.mYZ, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((m) SecretSettingActivity.this.mYZ.get(i)).getTag();
                    int i2 = 0;
                    if ("showAll".equals(tag)) {
                        SecretSettingActivity.this.bR(str, 1);
                        i2 = 1;
                    } else if ("friendOnly".equals(tag)) {
                        SecretSettingActivity.this.bR(str, 2);
                        i2 = 2;
                    } else if ("hideAll".equals(tag)) {
                        SecretSettingActivity.this.bR(str, 3);
                        i2 = 3;
                    } else if ("my_fans_reply".equals(tag)) {
                        SecretSettingActivity.this.bR(str, 5);
                        i2 = 5;
                    } else if ("my_attention_reply".equals(tag)) {
                        SecretSettingActivity.this.bR(str, 6);
                        i2 = 6;
                    }
                    SecretSettingActivity.this.mZh.refresh(i);
                    if (TbEnum.ParamKey.GROUP.equals(str)) {
                        SecretSettingActivity.this.mZc = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.mZb = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.mZa = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.mZd = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.mZe = i2;
                    }
                }
            }).Br(str2);
            this.mZh.bua().bub();
        }
    }

    private ArrayList<m> JP(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> JQ(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> JR(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.all_person), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new m(getPageContext().getString(R.string.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHL() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_IMBLACK_LIST, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHM() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_USER_MUTE_LIST_ACTIVITY, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(String str, int i) {
        sendMessage(new PrivacySettingMessage(str, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mZh != null) {
            this.mZh.dismiss();
        }
    }
}
