package com.baidu.tieba.more;

import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AboutActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import java.util.Date;
/* loaded from: classes.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private d buO;
    private com.baidu.tieba.model.a buP;
    private c buQ = null;
    private String buR = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + TbConfig.FUNCTION_INTRO_WEBVIEW;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(AboutActivityConfig.class, AboutActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.buO = new d(this, new a(this));
        this.buO.UN();
        regReceiver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.buO != null) {
            this.buO.UN();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
        if (this.buP != null) {
            this.buP.cancelLoadData();
        }
        if (this.buO != null) {
            this.buO.hideProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.buO != null) {
            this.buO.da(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.buP == null) {
            this.buP = new com.baidu.tieba.model.a(this, new b(this));
        } else {
            this.buP.cancelLoadData();
        }
        this.buP.Up();
        if (this.buO != null) {
            this.buO.UM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(Object obj) {
        if (this.buO != null) {
            this.buO.hideProgress();
        }
        com.baidu.tbadk.coreExtra.c.g gVar = obj != null ? (com.baidu.tbadk.coreExtra.c.g) obj : null;
        if (gVar != null) {
            TbadkCoreApplication.m255getInst().setVersionData(gVar.sz());
            TbadkCoreApplication.m255getInst().refreshNewVersion(false);
            if (gVar.sz().hasNewVer()) {
                if (gVar.sz().forceUpdate()) {
                    sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.m255getInst().getApp(), gVar.sz(), gVar.sy())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.m255getInst().getApp(), gVar.sz(), gVar.sy()));
                    TbadkCoreApplication.m255getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(com.baidu.tieba.z.neednot_update));
            }
            if (this.buO != null) {
                this.buO.UN();
                return;
            }
            return;
        }
        showToast(getResources().getString(com.baidu.tieba.z.neterror));
    }

    private void regReceiver() {
        this.buQ = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.buQ, intentFilter);
    }

    private void unregReceiver() {
        if (this.buQ != null) {
            unregisterReceiver(this.buQ);
        }
    }
}
