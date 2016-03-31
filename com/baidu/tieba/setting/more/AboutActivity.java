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
import com.baidu.tieba.t;
import java.util.Date;
/* loaded from: classes.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private com.baidu.tieba.setting.model.a ebA;
    private a ebB = null;
    private String ebC = String.valueOf(com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW) + TbConfig.FUNCTION_INTRO_WEBVIEW;
    private c ebz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ebz = new c(this, new com.baidu.tieba.setting.more.a(this));
        this.ebz.aNs();
        KL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ebz != null) {
            this.ebz.aNs();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        abL();
        if (this.ebA != null) {
            this.ebA.cancelLoadData();
        }
        if (this.ebz != null) {
            this.ebz.Qo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ebz != null) {
            this.ebz.em(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.ebA == null) {
            this.ebA = new com.baidu.tieba.setting.model.a(this, new b(this));
        } else {
            this.ebA.cancelLoadData();
        }
        this.ebA.aNk();
        if (this.ebz != null) {
            this.ebz.aNr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(Object obj) {
        if (this.ebz != null) {
            this.ebz.Qo();
        }
        com.baidu.tbadk.coreExtra.d.d dVar = obj != null ? (com.baidu.tbadk.coreExtra.d.d) obj : null;
        if (dVar != null) {
            TbadkCoreApplication.m411getInst().setVersionData(dVar.Ar());
            TbadkCoreApplication.m411getInst().refreshNewVersion(false);
            if (dVar.Ar().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (dVar.Ar().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), dVar.Ar(), dVar.Aq())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), dVar.Ar(), dVar.Aq()));
                    TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(t.j.neednot_update));
            }
            if (this.ebz != null) {
                this.ebz.aNs();
                return;
            }
            return;
        }
        showToast(getResources().getString(t.j.neterror));
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
            if (AboutActivity.this.ebz != null) {
                AboutActivity.this.ebz.aNs();
            }
        }
    }

    private void KL() {
        this.ebB = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.ebB, intentFilter);
    }

    private void abL() {
        if (this.ebB != null) {
            unregisterReceiver(this.ebB);
        }
    }
}
