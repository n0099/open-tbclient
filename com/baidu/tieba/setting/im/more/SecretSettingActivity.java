package com.baidu.tieba.setting.im.more;

import android.net.http.Headers;
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
import com.baidu.tieba.setting.ForbiddenForumActivityConfig;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import com.baidu.tieba.setting.PrivacyPermissionActivityConfig;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.setting.im.more.c;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private ArrayList<m> neB;
    private int neC;
    private int neD;
    private int neE;
    private int neF;
    private int neG;
    private int neH;
    private int neI;
    private e neJ;
    private c ney;
    private a nez;
    private boolean neA = false;
    private c.a neK = new c.a() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.1
        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dGo() {
            SecretSettingActivity.this.dGm();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dGp() {
            SecretSettingActivity.this.gq("like", SecretSettingActivity.this.getPageContext().getString(R.string.my_attention_bar));
            TiebaStatic.log("c12514");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void onBackPressed() {
            SecretSettingActivity.this.finish();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dGq() {
            SecretSettingActivity.this.gq(TbEnum.ParamKey.GROUP, SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_attention_group));
            TiebaStatic.log("c10652");
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dGr() {
            SecretSettingActivity.this.gq("live", SecretSettingActivity.this.getPageContext().getString(R.string.ala_setting_security_mylive));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dGs() {
            SecretSettingActivity.this.dGn();
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dGt() {
            SecretSettingActivity.this.gq("reply", SecretSettingActivity.this.getPageContext().getString(R.string.privacy_setting_thread_reply));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dGu() {
            SecretSettingActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PrivacyPermissionActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity())));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dGv() {
            PrivacyMarkActivityConfig privacyMarkActivityConfig = new PrivacyMarkActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity());
            privacyMarkActivityConfig.setMarkState(SecretSettingActivity.this.neH, SecretSettingActivity.this.neI);
            SecretSettingActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, privacyMarkActivityConfig));
            TiebaStatic.log(new ar("c14002").dR("uid", TbadkCoreApplication.getCurrentAccount()));
        }

        @Override // com.baidu.tieba.setting.im.more.c.a
        public void dGw() {
            SecretSettingActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbiddenForumActivityConfig(SecretSettingActivity.this.getPageContext().getPageActivity())));
        }
    };
    private HttpMessageListener neL = new HttpMessageListener(1001506, true) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.2
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
                    if (!TextUtils.equals(Headers.LOCATION, operation)) {
                        SecretSettingActivity.this.nez.bR(operation, type);
                        SecretSettingActivity.this.ney.bT(operation, type);
                    }
                }
            }
        }
    };
    private com.baidu.adp.framework.listener.a eDt = new com.baidu.adp.framework.listener.a(1002501, CmdConfigSocket.CMD_GET_PRIVATE_INFO) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.3
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            SecretSettingActivity.this.hideProgressBar();
            if (responsedMessage != null) {
                SecretSettingActivity.this.neA = true;
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
                    SecretSettingActivity.this.nez.b(aVar);
                    SecretSettingActivity.this.nez.dGg();
                    SecretSettingActivity.this.ney.xM(true);
                    SecretSettingActivity.this.ney.d(SecretSettingActivity.this.nez);
                    SecretSettingActivity.this.c(SecretSettingActivity.this.nez);
                    TbadkCoreApplication.getInst().setLocationShared(SecretSettingActivity.this.nez.dGk());
                }
            }
        }
    };
    private CustomMessageListener neM = new CustomMessageListener(2921499) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            int i = com.baidu.tbadk.core.sharedPref.b.brQ().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
            int i2 = com.baidu.tbadk.core.sharedPref.b.brQ().getInt(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
            SecretSettingActivity.this.neH = i;
            SecretSettingActivity.this.neI = i2;
            SecretSettingActivity.this.ney.dl(i, i2);
        }
    };
    private CustomMessageListener neN = new CustomMessageListener(CmdConfigCustom.CMD_PRIVACY_STATUS) { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                SecretSettingActivity.this.nez.It(((Integer) customResponsedMessage.getData()).intValue());
                SecretSettingActivity.this.ney.d(SecretSettingActivity.this.nez);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ney = new c(this);
        this.nez = new a();
        this.ney.a(this.neK);
        if (this.nez.dGe()) {
            this.ney.xM(true);
            this.ney.d(this.nez);
            c(this.nez);
        } else {
            this.ney.xM(false);
        }
        registerListener(this.eDt);
        registerListener(this.neL);
        registerListener(this.neN);
        registerListener(this.neM);
        sendMessage(new PrivateInfoNetMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(a aVar) {
        this.neC = aVar.dGh();
        this.neD = aVar.dGf();
        this.neE = aVar.dGj();
        this.neF = aVar.dGi();
        this.neG = aVar.dGl();
        this.neH = aVar.getBazhuShowInside();
        this.neI = aVar.getBazhuShowOutside();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ney.onChangeSkinType(i);
        if (this.neJ != null) {
            this.neJ.onChangeSkinType();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.ney.dGx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gq(final String str, String str2) {
        if (this.neA) {
            if (TbEnum.ParamKey.GROUP.equals(str)) {
                this.neB = IC(this.neE);
            } else if ("post".equals(str)) {
                this.neB = IC(this.neD);
            } else if ("like".equals(str)) {
                this.neB = IC(this.neC);
            } else if ("live".equals(str)) {
                this.neB = ID(this.neF);
            } else if ("reply".equals(str)) {
                this.neB = IE(this.neG);
            }
            if (this.neJ != null) {
                this.neJ.dismiss();
            }
            this.neJ = new e(getPageContext());
            this.neJ.Aw(str2);
            this.neJ.a(this.neB, new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.setting.im.more.SecretSettingActivity.5
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    SecretSettingActivity.this.showProgressBar();
                    String tag = ((m) SecretSettingActivity.this.neB.get(i)).getTag();
                    int i2 = 0;
                    if ("showAll".equals(tag)) {
                        SecretSettingActivity.this.bS(str, 1);
                        i2 = 1;
                    } else if ("friendOnly".equals(tag)) {
                        SecretSettingActivity.this.bS(str, 2);
                        i2 = 2;
                    } else if ("hideAll".equals(tag)) {
                        SecretSettingActivity.this.bS(str, 3);
                        i2 = 3;
                    } else if ("my_fans_reply".equals(tag)) {
                        SecretSettingActivity.this.bS(str, 5);
                        i2 = 5;
                    } else if ("my_attention_reply".equals(tag)) {
                        SecretSettingActivity.this.bS(str, 6);
                        i2 = 6;
                    }
                    SecretSettingActivity.this.neJ.refresh(i);
                    if (TbEnum.ParamKey.GROUP.equals(str)) {
                        SecretSettingActivity.this.neE = i2;
                    } else if ("post".equals(str)) {
                        SecretSettingActivity.this.neD = i2;
                    } else if ("like".equals(str)) {
                        SecretSettingActivity.this.neC = i2;
                    } else if ("live".equals(str)) {
                        SecretSettingActivity.this.neF = i2;
                    } else if ("reply".equals(str)) {
                        SecretSettingActivity.this.neG = i2;
                    }
                }
            }).Aw(str2);
            this.neJ.bqA().bqB();
        }
    }

    private ArrayList<m> IC(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_friend), "", i == 2, "friendOnly"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> ID(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_all), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.info_privacy_hide), "", i == 3, "hideAll"));
        return arrayList;
    }

    private ArrayList<m> IE(int i) {
        ArrayList<m> arrayList = new ArrayList<>();
        arrayList.add(new m(getPageContext().getString(R.string.all_person), "", i == 1, "showAll"));
        arrayList.add(new m(getPageContext().getString(R.string.my_fans), "", i == 5, "my_fans_reply"));
        arrayList.add(new m(getPageContext().getString(R.string.my_attentions), "", i == 6, "my_attention_reply"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGm() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_IMBLACK_LIST, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGn() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_USER_MUTE_LIST_ACTIVITY, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS(String str, int i) {
        sendMessage(new PrivacySettingMessage(str, i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.neJ != null) {
            this.neJ.dismiss();
        }
    }
}
