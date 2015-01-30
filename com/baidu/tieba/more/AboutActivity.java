package com.baidu.tieba.more;

import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AboutActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import java.util.Date;
/* loaded from: classes.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private d buP;
    private com.baidu.tieba.model.a buQ;
    private c buR = null;
    private String buS = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + TbConfig.FUNCTION_INTRO_WEBVIEW;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(AboutActivityConfig.class, AboutActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.buP = new d(this, new a(this));
        this.buP.US();
        regReceiver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.buP != null) {
            this.buP.US();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
        if (this.buQ != null) {
            this.buQ.cancelLoadData();
        }
        if (this.buP != null) {
            this.buP.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.buP != null) {
            this.buP.da(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.buQ == null) {
            this.buQ = new com.baidu.tieba.model.a(this, new b(this));
        } else {
            this.buQ.cancelLoadData();
        }
        this.buQ.Uu();
        if (this.buP != null) {
            this.buP.UR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(Object obj) {
        if (this.buP != null) {
            this.buP.hideProgress();
        }
        com.baidu.tbadk.coreExtra.c.g gVar = obj != null ? (com.baidu.tbadk.coreExtra.c.g) obj : null;
        if (gVar != null) {
            TbadkCoreApplication.m255getInst().setVersionData(gVar.sF());
            TbadkCoreApplication.m255getInst().refreshNewVersion(false);
            if (gVar.sF().hasNewVer()) {
                if (gVar.sF().forceUpdate()) {
                    sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.m255getInst().getApp(), gVar.sF(), gVar.sE())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.m255getInst().getApp(), gVar.sF(), gVar.sE()));
                    TbadkCoreApplication.m255getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(com.baidu.tieba.z.neednot_update));
            }
            if (this.buP != null) {
                this.buP.US();
                return;
            }
            return;
        }
        showToast(getResources().getString(com.baidu.tieba.z.neterror));
    }

    private void regReceiver() {
        this.buR = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.buR, intentFilter);
    }

    private void unregReceiver() {
        if (this.buR != null) {
            unregisterReceiver(this.buR);
        }
    }
}
