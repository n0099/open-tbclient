package com.baidu.tieba.more;

import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AboutActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.plugins.Hao123Plugin;
import java.util.Date;
/* loaded from: classes.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private d bts;
    private com.baidu.tieba.model.a btt;
    private c btu = null;
    private String btv = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + TbConfig.FUNCTION_INTRO_WEBVIEW;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(AboutActivityConfig.class, AboutActivity.class);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bts = new d(this, new a(this));
        this.bts.Uu();
        regReceiver();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bts != null) {
            this.bts.Uu();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregReceiver();
        if (this.btt != null) {
            this.btt.cancelLoadData();
        }
        if (this.bts != null) {
            this.bts.hideProgress();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bts != null) {
            this.bts.cT(i);
        }
    }

    public void checkUpdata() {
        if (this.btt == null) {
            this.btt = new com.baidu.tieba.model.a(this, new b(this));
        } else {
            this.btt.cancelLoadData();
        }
        this.btt.TW();
        if (this.bts != null) {
            this.bts.Ut();
        }
    }

    public void E(Object obj) {
        if (this.bts != null) {
            this.bts.hideProgress();
        }
        com.baidu.tbadk.coreExtra.c.g gVar = obj != null ? (com.baidu.tbadk.coreExtra.c.g) obj : null;
        if (gVar != null) {
            TbadkCoreApplication.m255getInst().setVersionData(gVar.sp());
            TbadkCoreApplication.m255getInst().refreshNewVersion(false);
            if (gVar.sp().hasNewVer()) {
                if (gVar.sp().forceUpdate()) {
                    sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.m255getInst().getApp(), gVar.sp(), gVar.so())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.m255getInst().getApp(), gVar.sp(), gVar.so()));
                    TbadkCoreApplication.m255getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(com.baidu.tieba.z.neednot_update));
            }
            if (this.bts != null) {
                this.bts.Uu();
            }
            if (!TbadkCoreApplication.m255getInst().isHao123HelperShouldOpen() && TbadkCoreApplication.m255getInst().isTiebaHelperOpen()) {
                TbadkCoreApplication.m255getInst().setTiebaHelperOpen(false);
                Hao123Plugin hao123Plugin = (Hao123Plugin) PluginCenter.gX().hc();
                if (hao123Plugin != null) {
                    hao123Plugin.closeFloating(getPageContext().getPageActivity());
                    return;
                }
                return;
            }
            return;
        }
        showToast(getResources().getString(com.baidu.tieba.z.neterror));
    }

    private void regReceiver() {
        this.btu = new c(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.btu, intentFilter);
    }

    private void unregReceiver() {
        if (this.btu != null) {
            unregisterReceiver(this.btu);
        }
    }
}
