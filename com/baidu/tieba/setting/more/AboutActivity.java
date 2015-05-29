package com.baidu.tieba.setting.more;

import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import java.util.Date;
/* loaded from: classes.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private d ceu;
    private com.baidu.tieba.setting.model.a cev;
    private c cew = null;
    private String cex = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + TbConfig.FUNCTION_INTRO_WEBVIEW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ceu = new d(this, new a(this));
        this.ceu.ais();
        regReceiver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ceu != null) {
            this.ceu.ais();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
        if (this.cev != null) {
            this.cev.cancelLoadData();
        }
        if (this.ceu != null) {
            this.ceu.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ceu != null) {
            this.ceu.dl(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.cev == null) {
            this.cev = new com.baidu.tieba.setting.model.a(this, new b(this));
        } else {
            this.cev.cancelLoadData();
        }
        this.cev.aip();
        if (this.ceu != null) {
            this.ceu.air();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Object obj) {
        if (this.ceu != null) {
            this.ceu.hideProgress();
        }
        com.baidu.tbadk.coreExtra.c.g gVar = obj != null ? (com.baidu.tbadk.coreExtra.c.g) obj : null;
        if (gVar != null) {
            TbadkCoreApplication.m411getInst().setVersionData(gVar.wL());
            TbadkCoreApplication.m411getInst().refreshNewVersion(false);
            if (gVar.wL().hasNewVer()) {
                if (gVar.wL().forceUpdate()) {
                    sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), gVar.wL(), gVar.wK())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), gVar.wL(), gVar.wK()));
                    TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(com.baidu.tieba.t.neednot_update));
            }
            if (this.ceu != null) {
                this.ceu.ais();
                return;
            }
            return;
        }
        showToast(getResources().getString(com.baidu.tieba.t.neterror));
    }

    private void regReceiver() {
        this.cew = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.cew, intentFilter);
    }

    private void unregReceiver() {
        if (this.cew != null) {
            unregisterReceiver(this.cew);
        }
    }
}
