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
    private i cdL;
    private a cdM;
    private VoiceCheckResult cdO;
    private ArrayList<m> cdP;
    private int cdQ;
    private int cdR;
    private int cdS;
    private boolean cdN = false;
    private l cdT = new b(this);
    private HttpMessageListener cdU = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
    private com.baidu.adp.framework.listener.a cdV = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);
    private CustomMessageListener cdW = new f(this, 2001325);

    /* JADX INFO: Access modifiers changed from: private */
    public void aif() {
        new Handler().postDelayed(new g(this), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aig() {
        if (this.cdO.aoN()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VoicePasswordVerifyActivityConfig(getPageContext().getPageActivity(), TbadkCoreApplication.getCurrentBduss(), this.cdO.aoP(), 230010)));
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VoiceSettingActivityConfig(getPageContext().getPageActivity(), this.cdO.aoO(), 230011)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cdL = new i(this);
        this.cdM = new a();
        this.cdL.a(this.cdT);
        if (this.cdM.aia()) {
            this.cdL.eE(true);
            this.cdL.c(this.cdM);
            b(this.cdM);
        } else {
            this.cdL.eE(false);
        }
        this.cdL.eF(TbadkCoreApplication.m411getInst().getLocationShared());
        this.cdL.eH(TbadkCoreApplication.m411getInst().isVoiceLoginOn(TbadkCoreApplication.getCurrentAccountName()));
        registerListener(this.cdV);
        registerListener(this.cdU);
        registerListener(this.cdW);
        Ah();
        sendMessage(new RequestPrivacySetting());
        aih();
    }

    private void aih() {
        if (!TbadkCoreApplication.m411getInst().isVoiceLoginCanUse()) {
            this.cdL.eG(false);
            return;
        }
        this.cdL.eG(true);
        sendMessage(new CustomMessage(2001325));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        this.cdQ = aVar.aid();
        this.cdR = aVar.aib();
        this.cdS = aVar.yS();
    }

    private void Ah() {
        MessageManager.getInstance().registerTask(ze());
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
        this.cdL.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.cdL.aio();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(String str, String str2) {
        if (this.cdN) {
            this.cdP = new ArrayList<>();
            if ("group".equals(str)) {
                this.cdP.add(new m(getPageContext().getString(t.info_privacy_all), "", this.cdS == 1));
                this.cdP.add(new m(getPageContext().getString(t.info_privacy_friend), "", this.cdS == 2));
                this.cdP.add(new m(getPageContext().getString(t.info_privacy_hide), "", this.cdS == 3));
            } else if ("post".equals(str)) {
                this.cdP.add(new m(getPageContext().getString(t.info_privacy_all), "", this.cdR == 1));
                this.cdP.add(new m(getPageContext().getString(t.info_privacy_friend), "", this.cdR == 2));
                this.cdP.add(new m(getPageContext().getString(t.info_privacy_hide), "", this.cdR == 3));
            } else if ("like".equals(str)) {
                this.cdP.add(new m(getPageContext().getString(t.info_privacy_all), "", this.cdQ == 1));
                this.cdP.add(new m(getPageContext().getString(t.info_privacy_friend), "", this.cdQ == 2));
                this.cdP.add(new m(getPageContext().getString(t.info_privacy_hide), "", this.cdQ == 3));
            }
            com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(getPageContext());
            iVar.cp(str2);
            iVar.a(this.cdP, new h(this, str, iVar)).cp(str2);
            iVar.rO().rP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aii() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    private SocketMessageTask ze() {
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
        if (i == 230011 && i2 == -1 && this.cdO != null && !this.cdO.aoM()) {
            this.cdL.eH(true);
            TbadkCoreApplication.m411getInst().setVoiceLoginOn(true);
            aih();
        }
    }
}
