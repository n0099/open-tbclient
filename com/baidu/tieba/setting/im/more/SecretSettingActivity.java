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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.tieba.setting.PrivacyPermissionActivityConfig;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.setting.im.more.c;
import java.util.ArrayList;
/* loaded from: classes26.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private ArrayList<m> mTB;
    private int mTC;
    private int mTD;
    private int mTE;
    private int mTF;
    private int mTG;
    private int mTH;
    private int mTI;
    private e mTJ;
    private c mTy;
    private a mTz;
    private boolean mTA = false;
    private c.a mTK = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dHX() {
            SecretSettingActivity.this.dHV();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dHY() {
            SecretSettingActivity.this.gm("like", SecretSettingActivity.this.getPageContext().getString(R.string.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dHZ() {
            SecretSettingActivity.this.gm(TbEnum.ParamKey.GROUP, SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dIa() {
            SecretSettingActivity.this.gm("live", SecretSettingActivity.this.getPageContext().getString(R.string.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dIb() {
            SecretSettingActivity.this.dHW();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dIc() {
            SecretSettingActivity.this.gm("reply", SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_thread_reply));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dId() {
            SecretSettingActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PrivacyPermissionActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity())));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dIe() {
            PrivacyMarkActivityConfig privacyMarkActivityConfig = new PrivacyMarkActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity());
            privacyMarkActivityConfig.setMarkState(SecretSettingActivity.this.mTH, SecretSettingActivity.this.mTI);
            SecretSettingActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, privacyMarkActivityConfig));
            TiebaStatic.log(new ar("c14002").dY("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    };
    private HttpMessageListener mTL = new HttpMessageListener(1001506, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
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
                        SecretSettingActivity.this.mTz.bJ(operation, type);
                        SecretSettingActivity.this.mTy.bL(operation, type);
                    }
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a ewJ = new com.baidu.adp.framework.listener.a(1002501, CmdConfigSocket.CMD_GET_PRIVATE_INFO) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SecretSettingActivity.this.hideProgressBar();
            if (responsedMessage != null) {
                SecretSettingActivity.this.mTA = true;
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
                    SecretSettingActivity.this.mTz.b(aVar);
                    SecretSettingActivity.this.mTz.dHP();
                    SecretSettingActivity.this.mTy.xw(true);
                    SecretSettingActivity.this.mTy.d(SecretSettingActivity.this.mTz);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.mTz);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.mTz.dHT());
                }
            }
        }
    };
    private CustomMessageListener mTM = new CustomMessageListener(2921499) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            int i = com.baidu.tbadk.core.sharedPref.b.bsO().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
            int i2 = com.baidu.tbadk.core.sharedPref.b.bsO().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
            SecretSettingActivity.this.mTH = i;
            SecretSettingActivity.this.mTI = i2;
            SecretSettingActivity.this.mTy.dr(i, i2);
        }
    };
    private CustomMessageListener mTN = new CustomMessageListener(CmdConfigCustom.CMD_PRIVACY_STATUS) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.mTz.JM(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.mTy.d(SecretSettingActivity.this.mTz);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTy = new c(this);
        this.mTz = new a();
        this.mTy.a(this.mTK);
        if (this.mTz.dHN()) {
            this.mTy.xw(true);
            this.mTy.d(this.mTz);
            c(this.mTz);
        } else {
            this.mTy.xw(false);
        }
        registerListener(this.ewJ);
        registerListener(this.mTL);
        registerListener(this.mTN);
        registerListener(this.mTM);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.mTC = aVar.dHQ();
        this.mTD = aVar.dHO();
        this.mTE = aVar.dHS();
        this.mTF = aVar.dHR();
        this.mTG = aVar.dHU();
        this.mTH = aVar.getBazhuShowInside();
        this.mTI = aVar.getBazhuShowOutside();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mTy.onChangeSkinType(i);
        if (this.mTJ != null) {
            this.mTJ.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.mTy.dIf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gm(final String str, String str2) {
        if (this.mTA) {
            if (TbEnum.ParamKey.GROUP.equals(str)) {
                this.mTB = JV(this.mTE);
            } else if ("post".equals(str)) {
                this.mTB = JV(this.mTD);
            } else if ("like".equals(str)) {
                this.mTB = JV(this.mTC);
            } else if ("live".equals(str)) {
                this.mTB = JW(this.mTF);
            } else if ("reply".equals(str)) {
                this.mTB = JX(this.mTG);
            }
            if (this.mTJ != null) {
                this.mTJ.dismiss();
            }
            this.mTJ = new e(getPageContext());
            this.mTJ.Bs(str2);
            this.mTJ.a(this.mTB, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((m) SecretSettingActivity.this.mTB.get(i)).getTag();
                    int i2 = 0;
                    if ("showAll".equals(tag)) {
                        SecretSettingActivity.this.bK(str, 1);
                        i2 = 1;
                    } else if ("friendOnly".equals(tag)) {
                        SecretSettingActivity.this.bK(str, 2);
                        i2 = 2;
                    } else if ("hideAll".equals(tag)) {
                        SecretSettingActivity.this.bK(str, 3);
                        i2 = 3;
                    } else if ("my_fans_reply".equals(tag)) {
                        SecretSettingActivity.this.bK(str, 5);
                        i2 = 5;
                    } else if ("my_attention_reply".equals(tag)) {
                        SecretSettingActivity.this.bK(str, 6);
                        i2 = 6;
                    }
                    SecretSettingActivity.this.mTJ.refresh(i);
                    if (TbEnum.ParamKey.GROUP.equals(str)) {
                        SecretSettingActivity.this.mTE = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.mTD = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.mTC = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.mTF = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.mTG = i2;
                    }
                }
            }).Bs(str2);
            this.mTJ.bry().brz();
        }
    }

    private ArrayList<m> JV(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> JW(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> JX(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.all_person), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new m(getPageContext().getString(R.string.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHV() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_IMBLACK_LIST, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dHW() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_USER_MUTE_LIST_ACTIVITY, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(String str, int i) {
        sendMessage(new PrivacySettingMessage(str, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.mTJ != null) {
            this.mTJ.dismiss();
        }
    }
}
