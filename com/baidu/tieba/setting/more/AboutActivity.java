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
    private c cND;
    private com.baidu.tieba.setting.model.a cNE;
    private a cNF = null;
    private String cNG = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + TbConfig.FUNCTION_INTRO_WEBVIEW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cND = new c(this, new com.baidu.tieba.setting.more.a(this));
        this.cND.arX();
        regReceiver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cND != null) {
            this.cND.arX();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
        if (this.cNE != null) {
            this.cNE.cancelLoadData();
        }
        if (this.cND != null) {
            this.cND.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cND != null) {
            this.cND.dF(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.cNE == null) {
            this.cNE = new com.baidu.tieba.setting.model.a(this, new b(this));
        } else {
            this.cNE.cancelLoadData();
        }
        this.cNE.arO();
        if (this.cND != null) {
            this.cND.arW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(Object obj) {
        if (this.cND != null) {
            this.cND.hideProgress();
        }
        com.baidu.tbadk.coreExtra.d.d dVar = obj != null ? (com.baidu.tbadk.coreExtra.d.d) obj : null;
        if (dVar != null) {
            TbadkCoreApplication.m411getInst().setVersionData(dVar.xO());
            TbadkCoreApplication.m411getInst().refreshNewVersion(false);
            if (dVar.xO().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (dVar.xO().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), dVar.xO(), dVar.xN())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), dVar.xO(), dVar.xN()));
                    TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(i.h.neednot_update));
            }
            if (this.cND != null) {
                this.cND.arX();
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
            if (AboutActivity.this.cND != null) {
                AboutActivity.this.cND.arX();
            }
        }
    }

    private void regReceiver() {
        this.cNF = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.cNF, intentFilter);
    }

    private void unregReceiver() {
        if (this.cNF != null) {
            unregisterReceiver(this.cNF);
        }
    }
}
