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
    private c cMh;
    private com.baidu.tieba.setting.model.a cMi;
    private a cMj = null;
    private String cMk = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + TbConfig.FUNCTION_INTRO_WEBVIEW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cMh = new c(this, new com.baidu.tieba.setting.more.a(this));
        this.cMh.arr();
        regReceiver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cMh != null) {
            this.cMh.arr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
        if (this.cMi != null) {
            this.cMi.cancelLoadData();
        }
        if (this.cMh != null) {
            this.cMh.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cMh != null) {
            this.cMh.dF(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.cMi == null) {
            this.cMi = new com.baidu.tieba.setting.model.a(this, new b(this));
        } else {
            this.cMi.cancelLoadData();
        }
        this.cMi.ari();
        if (this.cMh != null) {
            this.cMh.arq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(Object obj) {
        if (this.cMh != null) {
            this.cMh.hideProgress();
        }
        com.baidu.tbadk.coreExtra.d.d dVar = obj != null ? (com.baidu.tbadk.coreExtra.d.d) obj : null;
        if (dVar != null) {
            TbadkCoreApplication.m411getInst().setVersionData(dVar.xJ());
            TbadkCoreApplication.m411getInst().refreshNewVersion(false);
            if (dVar.xJ().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (dVar.xJ().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), dVar.xJ(), dVar.xI())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), dVar.xJ(), dVar.xI()));
                    TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(i.h.neednot_update));
            }
            if (this.cMh != null) {
                this.cMh.arr();
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
            if (AboutActivity.this.cMh != null) {
                AboutActivity.this.cMh.arr();
            }
        }
    }

    private void regReceiver() {
        this.cMj = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.cMj, intentFilter);
    }

    private void unregReceiver() {
        if (this.cMj != null) {
            unregisterReceiver(this.cMj);
        }
    }
}
