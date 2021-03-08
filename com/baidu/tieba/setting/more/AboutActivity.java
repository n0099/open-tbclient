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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.o;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.AboutModel;
import java.util.Date;
/* loaded from: classes7.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private com.baidu.tieba.setting.more.a nhE;
    private AboutModel nhF;
    private i nhI;
    private com.baidu.tieba.setting.more.a.a nhJ;
    private a nhG = null;
    private String nhH = com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + "mo/q/topic_page/110_1";
    private int nhK = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nhJ = new com.baidu.tieba.setting.more.a.a(this);
        this.nhE = new com.baidu.tieba.setting.more.a(this, new d() { // from class: com.baidu.tieba.setting.more.AboutActivity.1
            @Override // com.baidu.tieba.setting.more.d
            public void IJ(int i) {
                String str;
                String fileDireciory;
                if (i == 0) {
                    AboutActivity.this.finish();
                } else if (i == 1) {
                    AboutActivity.this.checkUpdata();
                } else if (i == 2) {
                    AboutActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(AboutActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SettingTextFunctionIntroView.nkJ, true);
                    com.baidu.tbadk.browser.a.startWebActivity(AboutActivity.this.getPageContext().getPageActivity(), AboutActivity.this.getPageContext().getString(R.string.function_intro), AboutActivity.this.nhH, true, false, false);
                } else if (i == 4) {
                    if (TbConfig.getDebugSwitch()) {
                        str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_DEBUG_FILE;
                    } else {
                        str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.FATAL_ERROR_FILE;
                    }
                    if (TbConfig.getDebugSwitch()) {
                        fileDireciory = o.getFileDireciory(TbConfig.FATAL_ERROR_DEBUG_FILE);
                    } else {
                        fileDireciory = o.getFileDireciory(TbConfig.FATAL_ERROR_FILE);
                    }
                    o.copyFile(str, fileDireciory);
                    o.CopyDir(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/newStat", o.getCacheDir() + "newStat", false);
                } else if (i == 5) {
                    if (AboutActivity.this.nhI == null) {
                        AboutActivity.this.nhI = new i(AboutActivity.this.getActivity());
                        AboutActivity.this.nhI.b(AboutActivity.this.getPageContext());
                    }
                    AboutActivity.this.nhI.bqz();
                } else if (i == 6) {
                    if (!ae.checkWriteExternalStorage(AboutActivity.this)) {
                        ae.d(AboutActivity.this, AboutActivity.this.nhK);
                    } else {
                        AboutActivity.this.dGM();
                    }
                }
            }
        });
        this.nhE.dGO();
        cUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nhE != null) {
            this.nhE.dGO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cUJ();
        if (this.nhF != null) {
            this.nhF.cancelLoadData();
        }
        if (this.nhE != null) {
            this.nhE.cKv();
        }
        if (this.nhI != null) {
            this.nhI.dismiss();
        }
        if (this.nhJ != null) {
            this.nhJ.dIV();
            this.nhJ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nhE != null) {
            this.nhE.qK(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == this.nhK) {
            if (ae.checkWriteExternalStorage(getActivity().getApplicationContext())) {
                dGM();
            } else {
                showToast(R.string.write_external_storage_permission_denied_fun_disable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGM() {
        if (!this.nhJ.dIW()) {
            this.nhJ.dIU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        com.baidu.tieba.lc.c.dbq().tB(true);
        if (this.nhF == null) {
            this.nhF = new AboutModel(this, new com.baidu.adp.base.e() { // from class: com.baidu.tieba.setting.more.AboutActivity.2
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    AboutActivity.this.aS(obj);
                }
            });
        } else {
            this.nhF.cancelLoadData();
        }
        this.nhF.checkUpdate();
        if (this.nhE != null) {
            this.nhE.dGN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(Object obj) {
        if (this.nhE != null) {
            this.nhE.cKv();
        }
        com.baidu.tbadk.coreExtra.model.e eVar = obj != null ? (com.baidu.tbadk.coreExtra.model.e) obj : null;
        if (eVar != null) {
            TbadkCoreApplication.getInst().setVersionData(eVar.byM());
            TbadkCoreApplication.getInst().refreshNewVersion(false);
            if (eVar.byM().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (eVar.byM().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.byM(), eVar.byL())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.byM(), eVar.byL()));
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            }
            if (this.nhE != null) {
                this.nhE.dGO();
                return;
            }
            return;
        }
        showToast(getResources().getString(R.string.neterror));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AboutActivity.this.nhE != null) {
                AboutActivity.this.nhE.dGO();
            }
        }
    }

    private void cUI() {
        this.nhG = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.nhG, intentFilter);
    }

    private void cUJ() {
        if (this.nhG != null) {
            unregisterReceiver(this.nhG);
        }
    }
}
