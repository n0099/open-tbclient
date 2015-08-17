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
import com.baidu.tbadk.core.atomData.UserMuteListActivityConfig;
import com.baidu.tbadk.core.atomData.VoicePasswordVerifyActivityConfig;
import com.baidu.tbadk.core.atomData.VoiceSettingActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.i;
import com.baidu.tieba.setting.im.more.i;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private i cvn;
    private a cvo;
    private VoiceCheckResult cvq;
    private ArrayList<com.baidu.tbadk.core.dialog.g> cvr;
    private int cvs;
    private int cvt;
    private int cvu;
    private com.baidu.tbadk.core.dialog.e cvv;
    private boolean cvp = false;
    private i.a cvw = new b(this);
    private HttpMessageListener cvx = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
    private com.baidu.adp.framework.listener.a cvy = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
    private CustomMessageListener cvz = new f(this, CmdConfigCustom.CMD_VOICE_CHECK);

    /* JADX INFO: Access modifiers changed from: private */
    public void aku() {
        new Handler().postDelayed(new g(this), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akv() {
        if (this.cvq.aqg()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VoicePasswordVerifyActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentBduss(), this.cvq.aqi(), 230010)));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VoiceSettingActivityConfig(getPageContext().getPageActivity(), this.cvq.aqh(), 230011)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cvn = new i(this);
        this.cvo = new a();
        this.cvn.a(this.cvw);
        if (this.cvo.ako()) {
            this.cvn.eW(true);
            this.cvn.c(this.cvo);
            b(this.cvo);
        } else {
            this.cvn.eW(false);
        }
        this.cvn.eX(TbadkCoreApplication.m411getInst().getLocationShared());
        this.cvn.eZ(TbadkCoreApplication.m411getInst().isVoiceLoginOn(TbadkCoreApplication.getCurrentAccountName()));
        registerListener(this.cvy);
        registerListener(this.cvx);
        registerListener(this.cvz);
        akw();
        sendMessage(new PrivateInfoNetMessage());
    }

    private void akw() {
        if (!TbadkCoreApplication.m411getInst().isVoiceLoginCanUse()) {
            this.cvn.eY(false);
            return;
        }
        this.cvn.eY(true);
        sendMessage(new CustomMessage(CmdConfigCustom.CMD_VOICE_CHECK));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        this.cvs = aVar.akr();
        this.cvt = aVar.akp();
        this.cvu = aVar.Ac();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cvn.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.cvn.akF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(String str, String str2) {
        if (this.cvp) {
            if ("group".equals(str)) {
                this.cvr = jn(this.cvu);
            } else if ("post".equals(str)) {
                this.cvr = jn(this.cvt);
            } else if ("like".equals(str)) {
                this.cvr = jn(this.cvs);
            }
            if (this.cvv != null) {
                this.cvv.dismiss();
            }
            this.cvv = new com.baidu.tbadk.core.dialog.e(getPageContext());
            this.cvv.cp(str2);
            this.cvv.a(this.cvr, new h(this, str)).cp(str2);
            this.cvv.sT().sU();
        }
    }

    private ArrayList<com.baidu.tbadk.core.dialog.g> jn(int i) {
        ArrayList<com.baidu.tbadk.core.dialog.g> arrayList = new ArrayList<>();
        arrayList.add(new com.baidu.tbadk.core.dialog.g(getPageContext().getString(i.C0057i.info_privacy_all), "", i == 1));
        arrayList.add(new com.baidu.tbadk.core.dialog.g(getPageContext().getString(i.C0057i.info_privacy_friend), "", i == 2));
        arrayList.add(new com.baidu.tbadk.core.dialog.g(getPageContext().getString(i.C0057i.info_privacy_hide), "", i == 3));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akx() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_IMBLACK_LIST, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aky() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_USER_MUTE_LIST_ACTIVITY, new UserMuteListActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(String str, int i) {
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
        if (i == 230011 && i2 == -1 && this.cvq != null && !this.cvq.aqf()) {
            this.cvn.eZ(true);
            TbadkCoreApplication.m411getInst().setVoiceLoginOn(true);
            akw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cvv != null) {
            this.cvv.dismiss();
        }
    }
}
