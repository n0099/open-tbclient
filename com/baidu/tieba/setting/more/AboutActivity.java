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
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.AboutModel;
import java.util.Date;
/* loaded from: classes25.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private com.baidu.tieba.setting.more.a lXP;
    private AboutModel lXQ;
    private a lXR = null;
    private String lXS = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/topic_page/110_1";
    private i lXT;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lXP = new com.baidu.tieba.setting.more.a(this, new d() { // from class: com.baidu.tieba.setting.more.AboutActivity.1
            @Override // com.baidu.tieba.setting.more.d
            public void Hu(int i) {
                String str;
                String fileDireciory;
                if (i == 0) {
                    AboutActivity.this.finish();
                } else if (i == 1) {
                    AboutActivity.this.checkUpdata();
                } else if (i == 2) {
                    AboutActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(AboutActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SettingTextFunctionIntroView.maU, true);
                    com.baidu.tbadk.browser.a.startWebActivity(AboutActivity.this.getPageContext().getPageActivity(), AboutActivity.this.getPageContext().getString(R.string.function_intro), AboutActivity.this.lXS, true, false, false);
                } else if (i == 4) {
                    if (TbConfig.getDebugSwitch()) {
                        str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_DEBUG_FILE;
                    } else {
                        str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_FILE;
                    }
                    if (TbConfig.getDebugSwitch()) {
                        fileDireciory = n.getFileDireciory(TbConfig.FATAL_ERROR_DEBUG_FILE);
                    } else {
                        fileDireciory = n.getFileDireciory(TbConfig.FATAL_ERROR_FILE);
                    }
                    n.copyFile(str, fileDireciory);
                    n.CopyDir(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/newStat", n.getCacheDir() + "/newStat", false);
                } else if (i == 5) {
                    if (AboutActivity.this.lXT == null) {
                        AboutActivity.this.lXT = new i(AboutActivity.this.getActivity());
                        AboutActivity.this.lXT.b(AboutActivity.this.getPageContext());
                    }
                    AboutActivity.this.lXT.bia();
                }
            }
        });
        this.lXP.dud();
        cEV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lXP != null) {
            this.lXP.dud();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cEW();
        if (this.lXQ != null) {
            this.lXQ.cancelLoadData();
        }
        if (this.lXP != null) {
            this.lXP.cvO();
        }
        if (this.lXT != null) {
            this.lXT.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lXP != null) {
            this.lXP.qg(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.lXQ == null) {
            this.lXQ = new AboutModel(this, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.AboutActivity.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    AboutActivity.this.aL(obj);
                }
            });
        } else {
            this.lXQ.cancelLoadData();
        }
        this.lXQ.dtV();
        if (this.lXP != null) {
            this.lXP.duc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(Object obj) {
        if (this.lXP != null) {
            this.lXP.cvO();
        }
        com.baidu.tbadk.coreExtra.model.e eVar = obj != null ? (com.baidu.tbadk.coreExtra.model.e) obj : null;
        if (eVar != null) {
            TbadkCoreApplication.getInst().setVersionData(eVar.bpX());
            TbadkCoreApplication.getInst().refreshNewVersion(false);
            if (eVar.bpX().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (eVar.bpX().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.bpX(), eVar.bpW())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.bpX(), eVar.bpW()));
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(R.string.neednot_update));
            }
            if (this.lXP != null) {
                this.lXP.dud();
                return;
            }
            return;
        }
        showToast(getResources().getString(R.string.neterror));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AboutActivity.this.lXP != null) {
                AboutActivity.this.lXP.dud();
            }
        }
    }

    private void cEV() {
        this.lXR = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.lXR, intentFilter);
    }

    private void cEW() {
        if (this.lXR != null) {
            unregisterReceiver(this.lXR);
        }
    }
}
