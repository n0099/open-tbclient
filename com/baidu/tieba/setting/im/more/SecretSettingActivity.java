package com.baidu.tieba.setting.im.more;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.IMBlackListActivityConfig;
import com.baidu.tbadk.core.atomData.VoicePasswordVerifyActivityConfig;
import com.baidu.tbadk.core.atomData.VoiceSettingActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.setting.im.more.i;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private i eaC;
    private a eaD;
    private VoiceCheckResult eaF;
    private ArrayList<com.baidu.tbadk.core.dialog.h> eaG;
    private int eaH;
    private int eaI;
    private int eaJ;
    private com.baidu.tbadk.core.dialog.f eaK;
    private boolean eaE = false;
    private i.a eaL = new b(this);
    private HttpMessageListener eaM = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
    private com.baidu.adp.framework.listener.a cIL = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
    private CustomMessageListener eaN = new f(this, CmdConfigCustom.CMD_VOICE_CHECK);

    /* JADX INFO: Access modifiers changed from: private */
    public void aMX() {
        new Handler().postDelayed(new g(this), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMY() {
        if (this.eaF.aTI()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VoicePasswordVerifyActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentBduss(), this.eaF.aTK(), 230010)));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VoiceSettingActivityConfig(getPageContext().getPageActivity(), this.eaF.aTJ(), 230011)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eaC = new i(this);
        this.eaD = new a();
        this.eaC.a(this.eaL);
        if (this.eaD.aMR()) {
            this.eaC.ih(true);
            this.eaC.c(this.eaD);
            b(this.eaD);
        } else {
            this.eaC.ih(false);
        }
        this.eaC.ii(TbadkCoreApplication.m411getInst().getLocationShared());
        this.eaC.ik(TbadkCoreApplication.m411getInst().isVoiceLoginOn(TbadkCoreApplication.getCurrentAccountName()));
        registerListener(this.cIL);
        registerListener(this.eaM);
        registerListener(this.eaN);
        aMZ();
        sendMessage(new PrivateInfoNetMessage());
    }

    private void aMZ() {
        if (!TbadkCoreApplication.m411getInst().isVoiceLoginCanUse()) {
            this.eaC.ij(false);
            return;
        }
        this.eaC.ij(true);
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_VOICE_CHECK));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        this.eaH = aVar.aMU();
        this.eaI = aVar.aMS();
        this.eaJ = aVar.CI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eaC.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.eaC.aNi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(String str, String str2) {
        if (this.eaE) {
            if ("group".equals(str)) {
                this.eaG = oM(this.eaJ);
            } else if ("post".equals(str)) {
                this.eaG = oM(this.eaI);
            } else if ("like".equals(str)) {
                this.eaG = oM(this.eaH);
            }
            if (this.eaK != null) {
                this.eaK.dismiss();
            }
            this.eaK = new com.baidu.tbadk.core.dialog.f(getPageContext());
            this.eaK.cE(str2);
            this.eaK.a(this.eaG, new h(this, str)).cE(str2);
            this.eaK.ut().uu();
        }
    }

    private ArrayList<com.baidu.tbadk.core.dialog.h> oM(int i) {
        ArrayList<com.baidu.tbadk.core.dialog.h> arrayList = new ArrayList<>();
        arrayList.add(new com.baidu.tbadk.core.dialog.h(getPageContext().getString(t.j.info_privacy_all), "", i == 1));
        arrayList.add(new com.baidu.tbadk.core.dialog.h(getPageContext().getString(t.j.info_privacy_friend), "", i == 2));
        arrayList.add(new com.baidu.tbadk.core.dialog.h(getPageContext().getString(t.j.info_privacy_hide), "", i == 3));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNa() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_IMBLACK_LIST, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNb() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_USER_MUTE_LIST_ACTIVITY, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(String str, int i) {
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage(str, i);
        privacySettingMessage.addParam("opt", str);
        privacySettingMessage.addParam("val", String.valueOf(i));
        sendMessage(privacySettingMessage);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 230010 && i2 == -1) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VoiceSettingActivityConfig(getPageContext().getPageActivity(), intent.getStringExtra(VoicePasswordVerifyActivityConfig.AUTH_SID), 230011)));
        }
        if (i == 230011 && i2 == -1 && this.eaF != null && !this.eaF.aTH()) {
            this.eaC.ik(true);
            TbadkCoreApplication.m411getInst().setVoiceLoginOn(true);
            aMZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eaK != null) {
            this.eaK.dismiss();
        }
    }
}
