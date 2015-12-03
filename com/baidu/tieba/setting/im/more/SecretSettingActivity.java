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
import com.baidu.tieba.n;
import com.baidu.tieba.setting.UserMuteListActivityConfig;
import com.baidu.tieba.setting.im.more.i;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private i dkW;
    private a dkX;
    private VoiceCheckResult dkZ;
    private ArrayList<com.baidu.tbadk.core.dialog.g> dla;
    private int dlb;
    private int dlc;
    private int dld;
    private com.baidu.tbadk.core.dialog.e dle;
    private boolean dkY = false;
    private i.a dlf = new b(this);
    private HttpMessageListener dlg = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
    private com.baidu.adp.framework.listener.a dlh = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
    private CustomMessageListener dli = new f(this, CmdConfigCustom.CMD_VOICE_CHECK);

    /* JADX INFO: Access modifiers changed from: private */
    public void awZ() {
        new Handler().postDelayed(new g(this), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axa() {
        if (this.dkZ.aDq()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VoicePasswordVerifyActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentBduss(), this.dkZ.aDs(), 230010)));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VoiceSettingActivityConfig(getPageContext().getPageActivity(), this.dkZ.aDr(), 230011)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dkW = new i(this);
        this.dkX = new a();
        this.dkW.a(this.dlf);
        if (this.dkX.awT()) {
            this.dkW.gL(true);
            this.dkW.c(this.dkX);
            b(this.dkX);
        } else {
            this.dkW.gL(false);
        }
        this.dkW.gM(TbadkCoreApplication.m411getInst().getLocationShared());
        this.dkW.gO(TbadkCoreApplication.m411getInst().isVoiceLoginOn(TbadkCoreApplication.getCurrentAccountName()));
        registerListener(this.dlh);
        registerListener(this.dlg);
        registerListener(this.dli);
        axb();
        sendMessage(new PrivateInfoNetMessage());
    }

    private void axb() {
        if (!TbadkCoreApplication.m411getInst().isVoiceLoginCanUse()) {
            this.dkW.gN(false);
            return;
        }
        this.dkW.gN(true);
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_VOICE_CHECK));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        this.dlb = aVar.awW();
        this.dlc = aVar.awU();
        this.dld = aVar.AX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dkW.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.dkW.axk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(String str, String str2) {
        if (this.dkY) {
            if ("group".equals(str)) {
                this.dla = lU(this.dld);
            } else if ("post".equals(str)) {
                this.dla = lU(this.dlc);
            } else if ("like".equals(str)) {
                this.dla = lU(this.dlb);
            }
            if (this.dle != null) {
                this.dle.dismiss();
            }
            this.dle = new com.baidu.tbadk.core.dialog.e(getPageContext());
            this.dle.cE(str2);
            this.dle.a(this.dla, new h(this, str)).cE(str2);
            this.dle.tA().tB();
        }
    }

    private ArrayList<com.baidu.tbadk.core.dialog.g> lU(int i) {
        ArrayList<com.baidu.tbadk.core.dialog.g> arrayList = new ArrayList<>();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(getPageContext().getString(n.i.info_privacy_all), "", i == 1));
        arrayList.add(new com.baidu.tbadk.core.dialog.g(getPageContext().getString(n.i.info_privacy_friend), "", i == 2));
        arrayList.add(new com.baidu.tbadk.core.dialog.g(getPageContext().getString(n.i.info_privacy_hide), "", i == 3));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axc() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_IMBLACK_LIST, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axd() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_USER_MUTE_LIST_ACTIVITY, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(String str, int i) {
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
        if (i == 230011 && i2 == -1 && this.dkZ != null && !this.dkZ.aDp()) {
            this.dkW.gO(true);
            TbadkCoreApplication.m411getInst().setVoiceLoginOn(true);
            axb();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dle != null) {
            this.dle.dismiss();
        }
    }
}
