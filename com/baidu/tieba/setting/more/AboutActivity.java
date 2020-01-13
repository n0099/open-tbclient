package com.baidu.tieba.setting.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.UpdateDialogConfig;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.AboutModel;
import java.util.Date;
/* loaded from: classes11.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private com.baidu.tieba.setting.more.a jQF;
    private AboutModel jQG;
    private a jQH = null;
    private String jQI = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/topic_page/110_1";
    private i jQJ;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jQF = new com.baidu.tieba.setting.more.a(this, new d() { // from class: com.baidu.tieba.setting.more.AboutActivity.1
            @Override // com.baidu.tieba.setting.more.d
            public void Bt(int i) {
                String str;
                String fileDireciory;
                if (i == 0) {
                    AboutActivity.this.finish();
                } else if (i == 1) {
                    AboutActivity.this.checkUpdata();
                } else if (i == 2) {
                    AboutActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(AboutActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SettingTextFunctionIntroView.jTz, true);
                    com.baidu.tbadk.browser.a.startWebActivity(AboutActivity.this.getPageContext().getPageActivity(), AboutActivity.this.getPageContext().getString(R.string.function_intro), AboutActivity.this.jQI, true, false, false);
                } else if (i == 4) {
                    if (TbConfig.getDebugSwitch()) {
                        str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_DEBUG_FILE;
                    } else {
                        str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_FILE;
                    }
                    if (TbConfig.getDebugSwitch()) {
                        fileDireciory = m.getFileDireciory(TbConfig.FATAL_ERROR_DEBUG_FILE);
                    } else {
                        fileDireciory = m.getFileDireciory(TbConfig.FATAL_ERROR_FILE);
                    }
                    m.copyFile(str, fileDireciory);
                    m.CopyDir(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/newStat", m.getCacheDir() + "/newStat", false);
                } else if (i == 5) {
                    if (AboutActivity.this.jQJ == null) {
                        AboutActivity.this.jQJ = new i(AboutActivity.this.getActivity());
                        AboutActivity.this.jQJ.b(AboutActivity.this.getPageContext());
                    }
                    AboutActivity.this.jQJ.aCp();
                }
            }
        });
        this.jQF.cDH();
        bQe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jQF != null) {
            this.jQF.cDH();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bQf();
        if (this.jQG != null) {
            this.jQG.cancelLoadData();
        }
        if (this.jQF != null) {
            this.jQF.bIj();
        }
        if (this.jQJ != null) {
            this.jQJ.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jQF != null) {
            this.jQF.lM(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.jQG == null) {
            this.jQG = new AboutModel(this, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.AboutActivity.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    AboutActivity.this.ay(obj);
                }
            });
        } else {
            this.jQG.cancelLoadData();
        }
        this.jQG.cDz();
        if (this.jQF != null) {
            this.jQF.cDG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay(Object obj) {
        if (this.jQF != null) {
            this.jQF.bIj();
        }
        com.baidu.tbadk.coreExtra.model.d dVar = obj != null ? (com.baidu.tbadk.coreExtra.model.d) obj : null;
        if (dVar != null) {
            TbadkCoreApplication.getInst().setVersionData(dVar.aJt());
            TbadkCoreApplication.getInst().refreshNewVersion(false);
            if (dVar.aJt().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (dVar.aJt().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), dVar.aJt(), dVar.aJs())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), dVar.aJt(), dVar.aJs()));
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(R.string.neednot_update));
            }
            if (this.jQF != null) {
                this.jQF.cDH();
                return;
            }
            return;
        }
        showToast(getResources().getString(R.string.neterror));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AboutActivity.this.jQF != null) {
                AboutActivity.this.jQF.cDH();
            }
        }
    }

    private void bQe() {
        this.jQH = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.jQH, intentFilter);
    }

    private void bQf() {
        if (this.jQH != null) {
            unregisterReceiver(this.jQH);
        }
    }
}
