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
    private i dse;
    private a dsf;
    private VoiceCheckResult dsh;
    private ArrayList<com.baidu.tbadk.core.dialog.g> dsi;
    private int dsj;
    private int dsk;
    private int dsl;
    private com.baidu.tbadk.core.dialog.e dsm;
    private boolean dsg = false;
    private i.a dsn = new b(this);
    private HttpMessageListener dso = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
    private com.baidu.adp.framework.listener.a doS = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
    private CustomMessageListener dsp = new f(this, CmdConfigCustom.CMD_VOICE_CHECK);

    /* JADX INFO: Access modifiers changed from: private */
    public void azg() {
        new Handler().postDelayed(new g(this), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azh() {
        if (this.dsh.aFD()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VoicePasswordVerifyActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentBduss(), this.dsh.aFF(), 230010)));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VoiceSettingActivityConfig(getPageContext().getPageActivity(), this.dsh.aFE(), 230011)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dse = new i(this);
        this.dsf = new a();
        this.dse.a(this.dsn);
        if (this.dsf.aza()) {
            this.dse.gT(true);
            this.dse.c(this.dsf);
            b(this.dsf);
        } else {
            this.dse.gT(false);
        }
        this.dse.gU(TbadkCoreApplication.m411getInst().getLocationShared());
        this.dse.gW(TbadkCoreApplication.m411getInst().isVoiceLoginOn(TbadkCoreApplication.getCurrentAccountName()));
        registerListener(this.doS);
        registerListener(this.dso);
        registerListener(this.dsp);
        azi();
        sendMessage(new PrivateInfoNetMessage());
    }

    private void azi() {
        if (!TbadkCoreApplication.m411getInst().isVoiceLoginCanUse()) {
            this.dse.gV(false);
            return;
        }
        this.dse.gV(true);
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_VOICE_CHECK));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        this.dsj = aVar.azd();
        this.dsk = aVar.azb();
        this.dsl = aVar.AN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dse.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.dse.azr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(String str, String str2) {
        if (this.dsg) {
            if ("group".equals(str)) {
                this.dsi = mv(this.dsl);
            } else if ("post".equals(str)) {
                this.dsi = mv(this.dsk);
            } else if ("like".equals(str)) {
                this.dsi = mv(this.dsj);
            }
            if (this.dsm != null) {
                this.dsm.dismiss();
            }
            this.dsm = new com.baidu.tbadk.core.dialog.e(getPageContext());
            this.dsm.cH(str2);
            this.dsm.a(this.dsi, new h(this, str)).cH(str2);
            this.dsm.tk().tl();
        }
    }

    private ArrayList<com.baidu.tbadk.core.dialog.g> mv(int i) {
        ArrayList<com.baidu.tbadk.core.dialog.g> arrayList = new ArrayList<>();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(getPageContext().getString(n.j.info_privacy_all), "", i == 1));
        arrayList.add(new com.baidu.tbadk.core.dialog.g(getPageContext().getString(n.j.info_privacy_friend), "", i == 2));
        arrayList.add(new com.baidu.tbadk.core.dialog.g(getPageContext().getString(n.j.info_privacy_hide), "", i == 3));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azj() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_IMBLACK_LIST, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azk() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_USER_MUTE_LIST_ACTIVITY, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(String str, int i) {
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
        if (i == 230011 && i2 == -1 && this.dsh != null && !this.dsh.aFC()) {
            this.dse.gW(true);
            TbadkCoreApplication.m411getInst().setVoiceLoginOn(true);
            azi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dsm != null) {
            this.dsm.dismiss();
        }
    }
}
