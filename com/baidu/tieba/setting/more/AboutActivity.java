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
    private c dJf;
    private com.baidu.tieba.setting.model.a dJg;
    private a dJh = null;
    private String dJi = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + TbConfig.FUNCTION_INTRO_WEBVIEW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dJf = new c(this, new com.baidu.tieba.setting.more.a(this));
        this.dJf.aGI();
        Jq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dJf != null) {
            this.dJf.aGI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Ys();
        if (this.dJg != null) {
            this.dJg.cancelLoadData();
        }
        if (this.dJf != null) {
            this.dJf.Oz();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dJf != null) {
            this.dJf.ej(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.dJg == null) {
            this.dJg = new com.baidu.tieba.setting.model.a(this, new b(this));
        } else {
            this.dJg.cancelLoadData();
        }
        this.dJg.aGA();
        if (this.dJf != null) {
            this.dJf.aGH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(Object obj) {
        if (this.dJf != null) {
            this.dJf.Oz();
        }
        com.baidu.tbadk.coreExtra.d.d dVar = obj != null ? (com.baidu.tbadk.coreExtra.d.d) obj : null;
        if (dVar != null) {
            TbadkCoreApplication.m411getInst().setVersionData(dVar.zO());
            TbadkCoreApplication.m411getInst().refreshNewVersion(false);
            if (dVar.zO().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (dVar.zO().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), dVar.zO(), dVar.zN())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.m411getInst().getApp(), dVar.zO(), dVar.zN()));
                    TbadkCoreApplication.m411getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(t.j.neednot_update));
            }
            if (this.dJf != null) {
                this.dJf.aGI();
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
            if (AboutActivity.this.dJf != null) {
                AboutActivity.this.dJf.aGI();
            }
        }
    }

    private void Jq() {
        this.dJh = new a(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.dJh, intentFilter);
    }

    private void Ys() {
        if (this.dJh != null) {
            unregisterReceiver(this.dJh);
        }
    }
}
