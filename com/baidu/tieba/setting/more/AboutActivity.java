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
    private c cLI;
    private com.baidu.tieba.setting.model.a cLJ;
    private a cLK = null;
    private String cLL = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + TbConfig.FUNCTION_INTRO_WEBVIEW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cLI = new c(this, new com.baidu.tieba.setting.more.a(this));
        this.cLI.arp();
        regReceiver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cLI != null) {
            this.cLI.arp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
        if (this.cLJ != null) {
            this.cLJ.cancelLoadData();
        }
        if (this.cLI != null) {
            this.cLI.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cLI != null) {
            this.cLI.dF(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.cLJ == null) {
            this.cLJ = new com.baidu.tieba.setting.model.a(this, new b(this));
        } else {
            this.cLJ.cancelLoadData();
        }
        this.cLJ.arg();
        if (this.cLI != null) {
            this.cLI.aro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(Object obj) {
        if (this.cLI != null) {
            this.cLI.hideProgress();
        }
        com.baidu.tbadk.coreExtra.d.d dVar = obj != null ? (com.baidu.tbadk.coreExtra.d.d) obj : null;
        if (dVar != null) {
            TbadkCoreApplication.m411getInst().setVersionData(dVar.xM());
            TbadkCoreApplication.m411getInst().refreshNewVersion(false);
            if (dVar.xM().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (dVar.xM().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), dVar.xM(), dVar.xL())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), dVar.xM(), dVar.xL()));
                    TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(i.h.neednot_update));
            }
            if (this.cLI != null) {
                this.cLI.arp();
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
            if (AboutActivity.this.cLI != null) {
                AboutActivity.this.cLI.arp();
            }
        }
    }

    private void regReceiver() {
        this.cLK = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.cLK, intentFilter);
    }

    private void unregReceiver() {
        if (this.cLK != null) {
            unregisterReceiver(this.cLK);
        }
    }
}
