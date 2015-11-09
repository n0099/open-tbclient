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
import com.baidu.tieba.i;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.setting.im.more.i;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private i cMF;
    private a cMG;
    private VoiceCheckResult cMI;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cMJ;
    private int cMK;
    private int cML;
    private int cMM;
    private com.baidu.tbadk.core.dialog.e cMN;
    private boolean cMH = false;
    private i.a cMO = new b(this);
    private HttpMessageListener cMP = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
    private com.baidu.adp.framework.listener.a cMQ = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
    private CustomMessageListener cMR = new f(this, CmdConfigCustom.CMD_VOICE_CHECK);

    /* JADX INFO: Access modifiers changed from: private */
    public void arB() {
        new Handler().postDelayed(new g(this), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arC() {
        if (this.cMI.axF()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VoicePasswordVerifyActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentBduss(), this.cMI.axH(), 230010)));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VoiceSettingActivityConfig(getPageContext().getPageActivity(), this.cMI.axG(), 230011)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cMF = new i(this);
        this.cMG = new a();
        this.cMF.a(this.cMO);
        if (this.cMG.arv()) {
            this.cMF.fV(true);
            this.cMF.c(this.cMG);
            b(this.cMG);
        } else {
            this.cMF.fV(false);
        }
        this.cMF.fW(TbadkCoreApplication.m411getInst().getLocationShared());
        this.cMF.fY(TbadkCoreApplication.m411getInst().isVoiceLoginOn(TbadkCoreApplication.getCurrentAccountName()));
        registerListener(this.cMQ);
        registerListener(this.cMP);
        registerListener(this.cMR);
        arD();
        sendMessage(new PrivateInfoNetMessage());
    }

    private void arD() {
        if (!TbadkCoreApplication.m411getInst().isVoiceLoginCanUse()) {
            this.cMF.fX(false);
            return;
        }
        this.cMF.fX(true);
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_VOICE_CHECK));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        this.cMK = aVar.ary();
        this.cML = aVar.arw();
        this.cMM = aVar.Ac();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cMF.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.cMF.arM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bb(String str, String str2) {
        if (this.cMH) {
            if ("group".equals(str)) {
                this.cMJ = kM(this.cMM);
            } else if ("post".equals(str)) {
                this.cMJ = kM(this.cML);
            } else if ("like".equals(str)) {
                this.cMJ = kM(this.cMK);
            }
            if (this.cMN != null) {
                this.cMN.dismiss();
            }
            this.cMN = new com.baidu.tbadk.core.dialog.e(getPageContext());
            this.cMN.cw(str2);
            this.cMN.a(this.cMJ, new h(this, str)).cw(str2);
            this.cMN.sV().sW();
        }
    }

    private ArrayList<com.baidu.tbadk.core.dialog.g> kM(int i) {
        ArrayList<com.baidu.tbadk.core.dialog.g> arrayList = new ArrayList<>();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(getPageContext().getString(i.h.info_privacy_all), "", i == 1));
        arrayList.add(new com.baidu.tbadk.core.dialog.g(getPageContext().getString(i.h.info_privacy_friend), "", i == 2));
        arrayList.add(new com.baidu.tbadk.core.dialog.g(getPageContext().getString(i.h.info_privacy_hide), "", i == 3));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arE() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_IMBLACK_LIST, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arF() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_USER_MUTE_LIST_ACTIVITY, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(String str, int i) {
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
        if (i == 230011 && i2 == -1 && this.cMI != null && !this.cMI.axE()) {
            this.cMF.fY(true);
            TbadkCoreApplication.m411getInst().setVoiceLoginOn(true);
            arD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cMN != null) {
            this.cMN.dismiss();
        }
    }
}
