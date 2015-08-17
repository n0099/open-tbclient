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
    private c cwk;
    private com.baidu.tieba.setting.model.a cwl;
    private a cwm = null;
    private String cwn = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + TbConfig.FUNCTION_INTRO_WEBVIEW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cwk = new c(this, new com.baidu.tieba.setting.more.a(this));
        this.cwk.akQ();
        regReceiver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cwk != null) {
            this.cwk.akQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
        if (this.cwl != null) {
            this.cwl.cancelLoadData();
        }
        if (this.cwk != null) {
            this.cwk.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cwk != null) {
            this.cwk.dw(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.cwl == null) {
            this.cwl = new com.baidu.tieba.setting.model.a(this, new b(this));
        } else {
            this.cwl.cancelLoadData();
        }
        this.cwl.akH();
        if (this.cwk != null) {
            this.cwk.akP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(Object obj) {
        if (this.cwk != null) {
            this.cwk.hideProgress();
        }
        com.baidu.tbadk.coreExtra.c.e eVar = obj != null ? (com.baidu.tbadk.coreExtra.c.e) obj : null;
        if (eVar != null) {
            TbadkCoreApplication.m411getInst().setVersionData(eVar.xV());
            TbadkCoreApplication.m411getInst().refreshNewVersion(false);
            if (eVar.xV().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (eVar.xV().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), eVar.xV(), eVar.xU())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), eVar.xV(), eVar.xU()));
                    TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(i.C0057i.neednot_update));
            }
            if (this.cwk != null) {
                this.cwk.akQ();
                return;
            }
            return;
        }
        showToast(getResources().getString(i.C0057i.neterror));
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
            if (AboutActivity.this.cwk != null) {
                AboutActivity.this.cwk.akQ();
            }
        }
    }

    private void regReceiver() {
        this.cwm = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.cwm, intentFilter);
    }

    private void unregReceiver() {
        if (this.cwm != null) {
            unregisterReceiver(this.cwm);
        }
    }
}
