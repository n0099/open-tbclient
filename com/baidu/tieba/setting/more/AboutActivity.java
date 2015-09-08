package com.baidu.tieba.setting.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
import java.util.Date;
/* loaded from: classes.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private c cEH;
    private com.baidu.tieba.setting.model.a cEI;
    private a cEJ = null;
    private String cEK = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + TbConfig.FUNCTION_INTRO_WEBVIEW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cEH = new c(this, new com.baidu.tieba.setting.more.a(this));
        this.cEH.aoX();
        regReceiver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cEH != null) {
            this.cEH.aoX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
        if (this.cEI != null) {
            this.cEI.cancelLoadData();
        }
        if (this.cEH != null) {
            this.cEH.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cEH != null) {
            this.cEH.dE(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.cEI == null) {
            this.cEI = new com.baidu.tieba.setting.model.a(this, new b(this));
        } else {
            this.cEI.cancelLoadData();
        }
        this.cEI.aoO();
        if (this.cEH != null) {
            this.cEH.aoW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(Object obj) {
        if (this.cEH != null) {
            this.cEH.hideProgress();
        }
        com.baidu.tbadk.coreExtra.c.e eVar = obj != null ? (com.baidu.tbadk.coreExtra.c.e) obj : null;
        if (eVar != null) {
            TbadkCoreApplication.m411getInst().setVersionData(eVar.yc());
            TbadkCoreApplication.m411getInst().refreshNewVersion(false);
            if (eVar.yc().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (eVar.yc().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), eVar.yc(), eVar.yb())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), eVar.yc(), eVar.yb()));
                    TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(i.h.neednot_update));
            }
            if (this.cEH != null) {
                this.cEH.aoX();
                return;
            }
            return;
        }
        showToast(getResources().getString(i.h.neterror));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(AboutActivity aboutActivity, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AboutActivity.this.cEH != null) {
                AboutActivity.this.cEH.aoX();
            }
        }
    }

    private void regReceiver() {
        this.cEJ = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.cEJ, intentFilter);
    }

    private void unregReceiver() {
        if (this.cEJ != null) {
            unregisterReceiver(this.cEJ);
        }
    }
}
