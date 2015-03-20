package com.baidu.tieba.setting.im.more;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.IMBlackListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.q;
/* loaded from: classes.dex */
public class SecretSettingActivity extends BaseActivity<SecretSettingActivity> {
    private g bZj;
    private a bZk;
    private boolean bZl = false;
    private j bZm = new b(this);
    private HttpMessageListener bZn = new c(this, CmdConfigHttp.SET_PRIVATE_CMD, true);
    private com.baidu.adp.framework.listener.a bZo = new e(this, CmdConfigHttp.GET_PRIVATE_INFO_CMD, 303016);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bZj = new g(this);
        this.bZk = new a();
        this.bZj.a(this.bZm);
        if (this.bZk.afV()) {
            this.bZj.ep(true);
            this.bZj.b(this.bZk);
        } else {
            this.bZj.ep(false);
        }
        this.bZj.eq(TbadkCoreApplication.m411getInst().getLocationShared());
        registerListener(this.bZo);
        registerListener(this.bZn);
        zn();
        sendMessage(new RequestPrivacySetting());
    }

    private void zn() {
        MessageManager.getInstance().registerTask(yk());
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.GET_PRIVATE_INFO_CMD, R("c/u/user/getPrivateInfo", 303016));
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(ResponsedPrivacyHttpMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static String R(String str, int i) {
        return String.valueOf(TbConfig.SERVER_ADDRESS) + str + "?cmd=" + i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bZj.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onResourceRecycle() {
        super.onResourceRecycle();
        this.bZj.agf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(String str, String str2) {
        if (this.bZl) {
            com.baidu.tbadk.core.dialog.e eVar = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
            eVar.a(getResources().getStringArray(q.privacy_setting_config), new f(this, str)).cb(str2);
            eVar.d(getPageContext()).rg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aga() {
        sendMessage(new CustomMessage(2008001, new IMBlackListActivityConfig(getPageContext().getPageActivity())));
    }

    private SocketMessageTask yk() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303016);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(ResponsedPrivacySocketMessage.class);
        socketMessageTask.j(false);
        return socketMessageTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(String str, int i) {
        PrivacySettingMessage privacySettingMessage = new PrivacySettingMessage(str, i);
        privacySettingMessage.addParam("opt", str);
        privacySettingMessage.addParam("val", String.valueOf(i));
        sendMessage(privacySettingMessage);
    }
}
