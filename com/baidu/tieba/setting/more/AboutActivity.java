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
    private d bZI;
    private com.baidu.tieba.setting.model.a bZJ;
    private c bZK = null;
    private String bZL = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + TbConfig.FUNCTION_INTRO_WEBVIEW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bZI = new d(this, new a(this));
        this.bZI.agk();
        regReceiver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bZI != null) {
            this.bZI.agk();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
        if (this.bZJ != null) {
            this.bZJ.cancelLoadData();
        }
        if (this.bZI != null) {
            this.bZI.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bZI != null) {
            this.bZI.dc(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.bZJ == null) {
            this.bZJ = new com.baidu.tieba.setting.model.a(this, new b(this));
        } else {
            this.bZJ.cancelLoadData();
        }
        this.bZJ.agh();
        if (this.bZI != null) {
            this.bZI.agj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(Object obj) {
        if (this.bZI != null) {
            this.bZI.hideProgress();
        }
        com.baidu.tbadk.coreExtra.c.g gVar = obj != null ? (com.baidu.tbadk.coreExtra.c.g) obj : null;
        if (gVar != null) {
            TbadkCoreApplication.m411getInst().setVersionData(gVar.vV());
            TbadkCoreApplication.m411getInst().refreshNewVersion(false);
            if (gVar.vV().hasNewVer()) {
                if (gVar.vV().forceUpdate()) {
                    sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), gVar.vV(), gVar.vU())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), gVar.vV(), gVar.vU()));
                    TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(com.baidu.tieba.y.neednot_update));
            }
            if (this.bZI != null) {
                this.bZI.agk();
                return;
            }
            return;
        }
        showToast(getResources().getString(com.baidu.tieba.y.neterror));
    }

    private void regReceiver() {
        this.bZK = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.bZK, intentFilter);
    }

    private void unregReceiver() {
        if (this.bZK != null) {
            unregisterReceiver(this.bZK);
        }
    }
}
