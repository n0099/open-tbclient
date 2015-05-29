package com.baidu.tieba.setting.im.more;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.IMBlackListActivityConfig;
import com.baidu.tbadk.core.atomData.VoicePasswordVerifyActivityConfig;
import com.baidu.tbadk.core.atomData.VoiceSettingActivityConfig;
import com.baidu.tbadk.core.dialog.m;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.data.VoiceCheckResult;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private i cdK;
    private a cdL;
    private VoiceCheckResult cdN;
    private ArrayList<m> cdO;
    private int cdP;
    private int cdQ;
    private int cdR;
    private boolean cdM = false;
    private l cdS = new b(this);
    private HttpMessageListener cdT = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
    private com.baidu.adp.framework.listener.a cdU = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
    private CustomMessageListener cdV = new f(this, 2001325);

    /* JADX INFO: Access modifiers changed from: private */
    public void aie() {
        new Handler().postDelayed(new g(this), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aif() {
        if (this.cdN.aoM()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VoicePasswordVerifyActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentBduss(), this.cdN.aoO(), 230010)));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VoiceSettingActivityConfig(getPageContext().getPageActivity(), this.cdN.aoN(), 230011)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cdK = new i(this);
        this.cdL = new a();
        this.cdK.a(this.cdS);
        if (this.cdL.ahZ()) {
            this.cdK.eE(true);
            this.cdK.c(this.cdL);
            b(this.cdL);
        } else {
            this.cdK.eE(false);
        }
        this.cdK.eF(TbadkCoreApplication.m411getInst().getLocationShared());
        this.cdK.eH(TbadkCoreApplication.m411getInst().isVoiceLoginOn(TbadkCoreApplication.getCurrentAccountName()));
        registerListener(this.cdU);
        registerListener(this.cdT);
        registerListener(this.cdV);
        Ag();
        sendMessage(new RequestPrivacySetting());
        aig();
    }

    private void aig() {
        if (!TbadkCoreApplication.m411getInst().isVoiceLoginCanUse()) {
            this.cdK.eG(false);
            return;
        }
        this.cdK.eG(true);
        sendMessage(new CustomMessage(2001325));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        this.cdP = aVar.aic();
        this.cdQ = aVar.aia();
        this.cdR = aVar.yR();
    }

    private void Ag() {
        MessageManager.getInstance().registerTask(zd());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.GET_PRIVATE_INFO_CMD, S("c/u/user/getPrivateInfo", 303016));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(ResponsedPrivacyHttpMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static String S(String str, int i) {
        return String.valueOf(TbConfig.SERVER_ADDRESS) + str + "?cmd=" + i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cdK.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.cdK.ain();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(String str, String str2) {
        if (this.cdM) {
            this.cdO = new ArrayList<>();
            if ("group".equals(str)) {
                this.cdO.add(new m(getPageContext().getString(t.info_privacy_all), "", this.cdR == 1));
                this.cdO.add(new m(getPageContext().getString(t.info_privacy_friend), "", this.cdR == 2));
                this.cdO.add(new m(getPageContext().getString(t.info_privacy_hide), "", this.cdR == 3));
            } else if ("post".equals(str)) {
                this.cdO.add(new m(getPageContext().getString(t.info_privacy_all), "", this.cdQ == 1));
                this.cdO.add(new m(getPageContext().getString(t.info_privacy_friend), "", this.cdQ == 2));
                this.cdO.add(new m(getPageContext().getString(t.info_privacy_hide), "", this.cdQ == 3));
            } else if ("like".equals(str)) {
                this.cdO.add(new m(getPageContext().getString(t.info_privacy_all), "", this.cdP == 1));
                this.cdO.add(new m(getPageContext().getString(t.info_privacy_friend), "", this.cdP == 2));
                this.cdO.add(new m(getPageContext().getString(t.info_privacy_hide), "", this.cdP == 3));
            }
            com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(getPageContext());
            iVar.cp(str2);
            iVar.a(this.cdO, new h(this, str, iVar)).cp(str2);
            iVar.rO().rP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aih() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    private SocketMessageTask zd() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303016);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(ResponsedPrivacySocketMessage.class);
        socketMessageTask.j(false);
        return socketMessageTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(String str, int i) {
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage(str, i);
        privacySettingMessage.addParam("opt", str);
        privacySettingMessage.addParam("val", String.valueOf(i));
        sendMessage(privacySettingMessage);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 230010 && i2 == -1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VoiceSettingActivityConfig(getPageContext().getPageActivity(), intent.getStringExtra(VoicePasswordVerifyActivityConfig.AUTH_SID), 230011)));
        }
        if (i == 230011 && i2 == -1 && this.cdN != null && !this.cdN.aoL()) {
            this.cdK.eH(true);
            TbadkCoreApplication.m411getInst().setVoiceLoginOn(true);
            aig();
        }
    }
}
