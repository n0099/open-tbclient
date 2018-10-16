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
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.e;
import com.baidu.tieba.setting.model.AboutModel;
import java.util.Date;
/* loaded from: classes3.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private com.baidu.tieba.setting.more.a gNs;
    private AboutModel gNt;
    private a gNu = null;
    private String gNv = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + TbConfig.FUNCTION_INTRO_WEBVIEW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gNs = new com.baidu.tieba.setting.more.a(this, new c() { // from class: com.baidu.tieba.setting.more.AboutActivity.1
            @Override // com.baidu.tieba.setting.more.c
            public void tG(int i) {
                if (i == 0) {
                    AboutActivity.this.finish();
                } else if (i == 1) {
                    AboutActivity.this.checkUpdata();
                } else if (i == 2) {
                    AboutActivity.this.sendMessage(new CustomMessage(2015001, new GuildActivityConfig(AboutActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(SettingTextFunctionIntroView.gQb, true);
                    com.baidu.tbadk.browser.a.a(AboutActivity.this.getPageContext().getPageActivity(), AboutActivity.this.getPageContext().getString(e.j.function_intro), AboutActivity.this.gNv, true, false, false);
                } else if (i == 4) {
                    l.copyFile(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_FILE, l.eB(TbConfig.FATAL_ERROR_FILE));
                }
            }
        });
        this.gNs.bvp();
        aMu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gNs != null) {
            this.gNs.bvp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aMv();
        if (this.gNt != null) {
            this.gNt.cancelLoadData();
        }
        if (this.gNs != null) {
            this.gNs.aFG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gNs != null) {
            this.gNs.eS(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.gNt == null) {
            this.gNt = new AboutModel(this, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.AboutActivity.2
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    AboutActivity.this.ak(obj);
                }
            });
        } else {
            this.gNt.cancelLoadData();
        }
        this.gNt.bvh();
        if (this.gNs != null) {
            this.gNs.bvo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(Object obj) {
        if (this.gNs != null) {
            this.gNs.aFG();
        }
        com.baidu.tbadk.coreExtra.model.d dVar = obj != null ? (com.baidu.tbadk.coreExtra.model.d) obj : null;
        if (dVar != null) {
            TbadkCoreApplication.getInst().setVersionData(dVar.HM());
            TbadkCoreApplication.getInst().refreshNewVersion(false);
            if (dVar.HM().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (dVar.HM().forceUpdate()) {
                    sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), dVar.HM(), dVar.HL())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), dVar.HM(), dVar.HL()));
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(e.j.neednot_update));
            }
            if (this.gNs != null) {
                this.gNs.bvp();
                return;
            }
            return;
        }
        showToast(getResources().getString(e.j.neterror));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AboutActivity.this.gNs != null) {
                AboutActivity.this.gNs.bvp();
            }
        }
    }

    private void aMu() {
        this.gNu = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.gNu, intentFilter);
    }

    private void aMv() {
        if (this.gNu != null) {
            unregisterReceiver(this.gNu);
        }
    }
}
