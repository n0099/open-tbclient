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
    private com.baidu.tieba.setting.more.a gVI;
    private AboutModel gVJ;
    private a gVK = null;
    private String gVL = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + TbConfig.FUNCTION_INTRO_WEBVIEW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gVI = new com.baidu.tieba.setting.more.a(this, new c() { // from class: com.baidu.tieba.setting.more.AboutActivity.1
            @Override // com.baidu.tieba.setting.more.c
            public void ut(int i) {
                if (i == 0) {
                    AboutActivity.this.finish();
                } else if (i == 1) {
                    AboutActivity.this.checkUpdata();
                } else if (i == 2) {
                    AboutActivity.this.sendMessage(new CustomMessage(2015001, new GuildActivityConfig(AboutActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(SettingTextFunctionIntroView.gYq, true);
                    com.baidu.tbadk.browser.a.a(AboutActivity.this.getPageContext().getPageActivity(), AboutActivity.this.getPageContext().getString(e.j.function_intro), AboutActivity.this.gVL, true, false, false);
                } else if (i == 4) {
                    l.copyFile(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_FILE, l.eT(TbConfig.FATAL_ERROR_FILE));
                }
            }
        });
        this.gVI.bwE();
        aNK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gVI != null) {
            this.gVI.bwE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aNL();
        if (this.gVJ != null) {
            this.gVJ.cancelLoadData();
        }
        if (this.gVI != null) {
            this.gVI.aGO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gVI != null) {
            this.gVI.fu(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.gVJ == null) {
            this.gVJ = new AboutModel(this, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.AboutActivity.2
                @Override // com.baidu.adp.base.d
                public void m(Object obj) {
                    AboutActivity.this.aj(obj);
                }
            });
        } else {
            this.gVJ.cancelLoadData();
        }
        this.gVJ.bww();
        if (this.gVI != null) {
            this.gVI.bwD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(Object obj) {
        if (this.gVI != null) {
            this.gVI.aGO();
        }
        com.baidu.tbadk.coreExtra.model.d dVar = obj != null ? (com.baidu.tbadk.coreExtra.model.d) obj : null;
        if (dVar != null) {
            TbadkCoreApplication.getInst().setVersionData(dVar.Jc());
            TbadkCoreApplication.getInst().refreshNewVersion(false);
            if (dVar.Jc().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (dVar.Jc().forceUpdate()) {
                    sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), dVar.Jc(), dVar.Jb())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), dVar.Jc(), dVar.Jb()));
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(e.j.neednot_update));
            }
            if (this.gVI != null) {
                this.gVI.bwE();
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
            if (AboutActivity.this.gVI != null) {
                AboutActivity.this.gVI.bwE();
            }
        }
    }

    private void aNK() {
        this.gVK = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.gVK, intentFilter);
    }

    private void aNL() {
        if (this.gVK != null) {
            unregisterReceiver(this.gVK);
        }
    }
}
