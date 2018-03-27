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
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.d;
import com.baidu.tieba.setting.model.AboutModel;
import java.util.Date;
/* loaded from: classes3.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private com.baidu.tieba.setting.more.a gMd;
    private AboutModel gMe;
    private a gMf = null;
    private String gMg = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + TbConfig.FUNCTION_INTRO_WEBVIEW;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gMd = new com.baidu.tieba.setting.more.a(this, new c() { // from class: com.baidu.tieba.setting.more.AboutActivity.1
            @Override // com.baidu.tieba.setting.more.c
            public void uQ(int i) {
                if (i == 0) {
                    AboutActivity.this.finish();
                } else if (i == 1) {
                    AboutActivity.this.checkUpdata();
                } else if (i == 2) {
                    AboutActivity.this.sendMessage(new CustomMessage(2015001, new GuildActivityConfig(AboutActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean(g.gOE, true);
                    com.baidu.tbadk.browser.b.a(AboutActivity.this.getPageContext().getPageActivity(), AboutActivity.this.getPageContext().getString(d.j.function_intro), AboutActivity.this.gMg, true, false, false);
                } else if (i == 4) {
                    k.Y(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_FILE, k.dB(TbConfig.FATAL_ERROR_FILE));
                }
            }
        });
        this.gMd.bqi();
        aFq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gMd != null) {
            this.gMd.bqi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        aFr();
        if (this.gMe != null) {
            this.gMe.cancelLoadData();
        }
        if (this.gMd != null) {
            this.gMd.azU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gMd != null) {
            this.gMd.hr(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.gMe == null) {
            this.gMe = new AboutModel(this, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.AboutActivity.2
                @Override // com.baidu.adp.base.d
                public void ak(Object obj) {
                    AboutActivity.this.bf(obj);
                }
            });
        } else {
            this.gMe.cancelLoadData();
        }
        this.gMe.bqa();
        if (this.gMd != null) {
            this.gMd.bqh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(Object obj) {
        if (this.gMd != null) {
            this.gMd.azU();
        }
        com.baidu.tbadk.coreExtra.model.d dVar = obj != null ? (com.baidu.tbadk.coreExtra.model.d) obj : null;
        if (dVar != null) {
            TbadkCoreApplication.getInst().setVersionData(dVar.HV());
            TbadkCoreApplication.getInst().refreshNewVersion(false);
            if (dVar.HV().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (dVar.HV().forceUpdate()) {
                    sendMessage(new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), dVar.HV(), dVar.HU())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage(2002001, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), dVar.HV(), dVar.HU()));
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(d.j.neednot_update));
            }
            if (this.gMd != null) {
                this.gMd.bqi();
                return;
            }
            return;
        }
        showToast(getResources().getString(d.j.neterror));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AboutActivity.this.gMd != null) {
                AboutActivity.this.gMd.bqi();
            }
        }
    }

    private void aFq() {
        this.gMf = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.gMf, intentFilter);
    }

    private void aFr() {
        if (this.gMf != null) {
            unregisterReceiver(this.gMf);
        }
    }
}
