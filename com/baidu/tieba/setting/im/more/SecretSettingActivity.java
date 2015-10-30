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
    private i cLj;
    private a cLk;
    private VoiceCheckResult cLm;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cLn;
    private int cLo;
    private int cLp;
    private int cLq;
    private com.baidu.tbadk.core.dialog.e cLr;
    private boolean cLl = false;
    private i.a cLs = new b(this);
    private HttpMessageListener cLt = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
    private com.baidu.adp.framework.listener.a cLu = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
    private CustomMessageListener cLv = new f(this, CmdConfigCustom.CMD_VOICE_CHECK);

    /* JADX INFO: Access modifiers changed from: private */
    public void aqV() {
        new Handler().postDelayed(new g(this), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqW() {
        if (this.cLm.awP()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VoicePasswordVerifyActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentBduss(), this.cLm.awR(), 230010)));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VoiceSettingActivityConfig(getPageContext().getPageActivity(), this.cLm.awQ(), 230011)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cLj = new i(this);
        this.cLk = new a();
        this.cLj.a(this.cLs);
        if (this.cLk.aqP()) {
            this.cLj.fS(true);
            this.cLj.c(this.cLk);
            b(this.cLk);
        } else {
            this.cLj.fS(false);
        }
        this.cLj.fT(TbadkCoreApplication.m411getInst().getLocationShared());
        this.cLj.fV(TbadkCoreApplication.m411getInst().isVoiceLoginOn(TbadkCoreApplication.getCurrentAccountName()));
        registerListener(this.cLu);
        registerListener(this.cLt);
        registerListener(this.cLv);
        aqX();
        sendMessage(new PrivateInfoNetMessage());
    }

    private void aqX() {
        if (!TbadkCoreApplication.m411getInst().isVoiceLoginCanUse()) {
            this.cLj.fU(false);
            return;
        }
        this.cLj.fU(true);
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_VOICE_CHECK));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        this.cLo = aVar.aqS();
        this.cLp = aVar.aqQ();
        this.cLq = aVar.zX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cLj.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.cLj.arg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(String str, String str2) {
        if (this.cLl) {
            if ("group".equals(str)) {
                this.cLn = ky(this.cLq);
            } else if ("post".equals(str)) {
                this.cLn = ky(this.cLp);
            } else if ("like".equals(str)) {
                this.cLn = ky(this.cLo);
            }
            if (this.cLr != null) {
                this.cLr.dismiss();
            }
            this.cLr = new com.baidu.tbadk.core.dialog.e(getPageContext());
            this.cLr.cw(str2);
            this.cLr.a(this.cLn, new h(this, str)).cw(str2);
            this.cLr.sS().sT();
        }
    }

    private ArrayList<com.baidu.tbadk.core.dialog.g> ky(int i) {
        ArrayList<com.baidu.tbadk.core.dialog.g> arrayList = new ArrayList<>();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(getPageContext().getString(i.h.info_privacy_all), "", i == 1));
        arrayList.add(new com.baidu.tbadk.core.dialog.g(getPageContext().getString(i.h.info_privacy_friend), "", i == 2));
        arrayList.add(new com.baidu.tbadk.core.dialog.g(getPageContext().getString(i.h.info_privacy_hide), "", i == 3));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqY() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_IMBLACK_LIST, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqZ() {
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
        if (i == 230011 && i2 == -1 && this.cLm != null && !this.cLm.awO()) {
            this.cLj.fV(true);
            TbadkCoreApplication.m411getInst().setVoiceLoginOn(true);
            aqX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cLr != null) {
            this.cLr.dismiss();
        }
    }
}
