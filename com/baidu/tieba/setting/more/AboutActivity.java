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
import com.baidu.tieba.d;
import com.baidu.tieba.setting.model.AboutModel;
import java.util.Date;
/* loaded from: classes3.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private com.baidu.tieba.setting.more.a gtE;
    private AboutModel gtF;
    private a gtG = null;
    private String gtH = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + TbConfig.FUNCTION_INTRO_WEBVIEW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gtE = new com.baidu.tieba.setting.more.a(this, new c() { // from class: com.baidu.tieba.setting.more.AboutActivity.1
            @Override // com.baidu.tieba.setting.more.c
            public void sD(int i) {
                if (i == 0) {
                    AboutActivity.this.finish();
                } else if (i == 1) {
                    AboutActivity.this.checkUpdata();
                } else if (i == 2) {
                    AboutActivity.this.sendMessage(new CustomMessage(2015001, new GuildActivityConfig(AboutActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(SettingTextFunctionIntroView.gwl, true);
                    com.baidu.tbadk.browser.a.a(AboutActivity.this.getPageContext().getPageActivity(), AboutActivity.this.getPageContext().getString(d.k.function_intro), AboutActivity.this.gtH, true, false, false);
                } else if (i == 4) {
                    l.ac(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_FILE, l.dT(TbConfig.FATAL_ERROR_FILE));
                }
            }
        });
        this.gtE.bqo();
        aFj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gtE != null) {
            this.gtE.bqo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aFk();
        if (this.gtF != null) {
            this.gtF.cancelLoadData();
        }
        if (this.gtE != null) {
            this.gtE.ayU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gtE != null) {
            this.gtE.eu(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.gtF == null) {
            this.gtF = new AboutModel(this, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.AboutActivity.2
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    AboutActivity.this.ad(obj);
                }
            });
        } else {
            this.gtF.cancelLoadData();
        }
        this.gtF.bqg();
        if (this.gtE != null) {
            this.gtE.bqn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(Object obj) {
        if (this.gtE != null) {
            this.gtE.ayU();
        }
        com.baidu.tbadk.coreExtra.model.d dVar = obj != null ? (com.baidu.tbadk.coreExtra.model.d) obj : null;
        if (dVar != null) {
            TbadkCoreApplication.getInst().setVersionData(dVar.Ei());
            TbadkCoreApplication.getInst().refreshNewVersion(false);
            if (dVar.Ei().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (dVar.Ei().forceUpdate()) {
                    sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), dVar.Ei(), dVar.Eh())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), dVar.Ei(), dVar.Eh()));
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(d.k.neednot_update));
            }
            if (this.gtE != null) {
                this.gtE.bqo();
                return;
            }
            return;
        }
        showToast(getResources().getString(d.k.neterror));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AboutActivity.this.gtE != null) {
                AboutActivity.this.gtE.bqo();
            }
        }
    }

    private void aFj() {
        this.gtG = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.gtG, intentFilter);
    }

    private void aFk() {
        if (this.gtG != null) {
            unregisterReceiver(this.gtG);
        }
    }
}
