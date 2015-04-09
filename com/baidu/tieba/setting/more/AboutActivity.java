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
    private d bZX;
    private com.baidu.tieba.setting.model.a bZY;
    private c bZZ = null;
    private String caa = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + TbConfig.FUNCTION_INTRO_WEBVIEW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bZX = new d(this, new a(this));
        this.bZX.agz();
        regReceiver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bZX != null) {
            this.bZX.agz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
        if (this.bZY != null) {
            this.bZY.cancelLoadData();
        }
        if (this.bZX != null) {
            this.bZX.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bZX != null) {
            this.bZX.dc(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.bZY == null) {
            this.bZY = new com.baidu.tieba.setting.model.a(this, new b(this));
        } else {
            this.bZY.cancelLoadData();
        }
        this.bZY.agw();
        if (this.bZX != null) {
            this.bZX.agy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(Object obj) {
        if (this.bZX != null) {
            this.bZX.hideProgress();
        }
        com.baidu.tbadk.coreExtra.c.g gVar = obj != null ? (com.baidu.tbadk.coreExtra.c.g) obj : null;
        if (gVar != null) {
            TbadkCoreApplication.m411getInst().setVersionData(gVar.wb());
            TbadkCoreApplication.m411getInst().refreshNewVersion(false);
            if (gVar.wb().hasNewVer()) {
                if (gVar.wb().forceUpdate()) {
                    sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), gVar.wb(), gVar.wa())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), gVar.wb(), gVar.wa()));
                    TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(com.baidu.tieba.y.neednot_update));
            }
            if (this.bZX != null) {
                this.bZX.agz();
                return;
            }
            return;
        }
        showToast(getResources().getString(com.baidu.tieba.y.neterror));
    }

    private void regReceiver() {
        this.bZZ = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.bZZ, intentFilter);
    }

    private void unregReceiver() {
        if (this.bZZ != null) {
            unregisterReceiver(this.bZZ);
        }
    }
}
