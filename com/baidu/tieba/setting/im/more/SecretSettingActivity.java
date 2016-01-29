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
    private i dIi;
    private a dIj;
    private VoiceCheckResult dIl;
    private ArrayList<com.baidu.tbadk.core.dialog.h> dIm;
    private int dIn;
    private int dIo;
    private int dIp;
    private com.baidu.tbadk.core.dialog.f dIq;
    private boolean dIk = false;
    private i.a dIr = new b(this);
    private HttpMessageListener dIs = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
    private com.baidu.adp.framework.listener.a dEl = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
    private CustomMessageListener dIt = new f(this, CmdConfigCustom.CMD_VOICE_CHECK);

    /* JADX INFO: Access modifiers changed from: private */
    public void aGn() {
        new Handler().postDelayed(new g(this), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGo() {
        if (this.dIl.aMI()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VoicePasswordVerifyActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentBduss(), this.dIl.aMK(), 230010)));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VoiceSettingActivityConfig(getPageContext().getPageActivity(), this.dIl.aMJ(), 230011)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dIi = new i(this);
        this.dIj = new a();
        this.dIi.a(this.dIr);
        if (this.dIj.aGh()) {
            this.dIi.ht(true);
            this.dIi.c(this.dIj);
            b(this.dIj);
        } else {
            this.dIi.ht(false);
        }
        this.dIi.hu(TbadkCoreApplication.m411getInst().getLocationShared());
        this.dIi.hw(TbadkCoreApplication.m411getInst().isVoiceLoginOn(TbadkCoreApplication.getCurrentAccountName()));
        registerListener(this.dEl);
        registerListener(this.dIs);
        registerListener(this.dIt);
        aGp();
        sendMessage(new PrivateInfoNetMessage());
    }

    private void aGp() {
        if (!TbadkCoreApplication.m411getInst().isVoiceLoginCanUse()) {
            this.dIi.hv(false);
            return;
        }
        this.dIi.hv(true);
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_VOICE_CHECK));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        this.dIn = aVar.aGk();
        this.dIo = aVar.aGi();
        this.dIp = aVar.Cd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dIi.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.dIi.aGy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(String str, String str2) {
        if (this.dIk) {
            if ("group".equals(str)) {
                this.dIm = nH(this.dIp);
            } else if ("post".equals(str)) {
                this.dIm = nH(this.dIo);
            } else if ("like".equals(str)) {
                this.dIm = nH(this.dIn);
            }
            if (this.dIq != null) {
                this.dIq.dismiss();
            }
            this.dIq = new com.baidu.tbadk.core.dialog.f(getPageContext());
            this.dIq.cG(str2);
            this.dIq.a(this.dIm, new h(this, str)).cG(str2);
            this.dIq.uo().up();
        }
    }

    private ArrayList<com.baidu.tbadk.core.dialog.h> nH(int i) {
        ArrayList<com.baidu.tbadk.core.dialog.h> arrayList = new ArrayList<>();
        arrayList.add(new com.baidu.tbadk.core.dialog.h(getPageContext().getString(t.j.info_privacy_all), "", i == 1));
        arrayList.add(new com.baidu.tbadk.core.dialog.h(getPageContext().getString(t.j.info_privacy_friend), "", i == 2));
        arrayList.add(new com.baidu.tbadk.core.dialog.h(getPageContext().getString(t.j.info_privacy_hide), "", i == 3));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGq() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_IMBLACK_LIST, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGr() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_USER_MUTE_LIST_ACTIVITY, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(String str, int i) {
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
        if (i == 230011 && i2 == -1 && this.dIl != null && !this.dIl.aMH()) {
            this.dIi.hw(true);
            TbadkCoreApplication.m411getInst().setVoiceLoginOn(true);
            aGp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dIq != null) {
            this.dIq.dismiss();
        }
    }
}
