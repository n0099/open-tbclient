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
    private d cev;
    private com.baidu.tieba.setting.model.a cew;
    private c cex = null;
    private String cey = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + TbConfig.FUNCTION_INTRO_WEBVIEW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cev = new d(this, new a(this));
        this.cev.ait();
        regReceiver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cev != null) {
            this.cev.ait();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
        if (this.cew != null) {
            this.cew.cancelLoadData();
        }
        if (this.cev != null) {
            this.cev.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cev != null) {
            this.cev.dl(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.cew == null) {
            this.cew = new com.baidu.tieba.setting.model.a(this, new b(this));
        } else {
            this.cew.cancelLoadData();
        }
        this.cew.aiq();
        if (this.cev != null) {
            this.cev.ais();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Object obj) {
        if (this.cev != null) {
            this.cev.hideProgress();
        }
        com.baidu.tbadk.coreExtra.c.g gVar = obj != null ? (com.baidu.tbadk.coreExtra.c.g) obj : null;
        if (gVar != null) {
            TbadkCoreApplication.m411getInst().setVersionData(gVar.wM());
            TbadkCoreApplication.m411getInst().refreshNewVersion(false);
            if (gVar.wM().hasNewVer()) {
                if (gVar.wM().forceUpdate()) {
                    sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), gVar.wM(), gVar.wL())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), gVar.wM(), gVar.wL()));
                    TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(com.baidu.tieba.t.neednot_update));
            }
            if (this.cev != null) {
                this.cev.ait();
                return;
            }
            return;
        }
        showToast(getResources().getString(com.baidu.tieba.t.neterror));
    }

    private void regReceiver() {
        this.cex = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.cex, intentFilter);
    }

    private void unregReceiver() {
        if (this.cex != null) {
            unregisterReceiver(this.cex);
        }
    }
}
