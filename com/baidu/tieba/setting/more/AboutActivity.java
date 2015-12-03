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
import com.baidu.tieba.n;
import java.util.Date;
/* loaded from: classes.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private c dlU;
    private com.baidu.tieba.setting.model.a dlV;
    private a dlW = null;
    private String dlX = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + TbConfig.FUNCTION_INTRO_WEBVIEW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dlU = new c(this, new com.baidu.tieba.setting.more.a(this));
        this.dlU.axv();
        regReceiver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dlU != null) {
            this.dlU.axv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
        if (this.dlV != null) {
            this.dlV.cancelLoadData();
        }
        if (this.dlU != null) {
            this.dlU.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dlU != null) {
            this.dlU.dU(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.dlV == null) {
            this.dlV = new com.baidu.tieba.setting.model.a(this, new b(this));
        } else {
            this.dlV.cancelLoadData();
        }
        this.dlV.axm();
        if (this.dlU != null) {
            this.dlU.axu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(Object obj) {
        if (this.dlU != null) {
            this.dlU.hideProgress();
        }
        com.baidu.tbadk.coreExtra.d.d dVar = obj != null ? (com.baidu.tbadk.coreExtra.d.d) obj : null;
        if (dVar != null) {
            TbadkCoreApplication.m411getInst().setVersionData(dVar.yK());
            TbadkCoreApplication.m411getInst().refreshNewVersion(false);
            if (dVar.yK().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (dVar.yK().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), dVar.yK(), dVar.yJ())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), dVar.yK(), dVar.yJ()));
                    TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(n.i.neednot_update));
            }
            if (this.dlU != null) {
                this.dlU.axv();
                return;
            }
            return;
        }
        showToast(getResources().getString(n.i.neterror));
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
            if (AboutActivity.this.dlU != null) {
                AboutActivity.this.dlU.axv();
            }
        }
    }

    private void regReceiver() {
        this.dlW = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.dlW, intentFilter);
    }

    private void unregReceiver() {
        if (this.dlW != null) {
            unregisterReceiver(this.dlW);
        }
    }
}
