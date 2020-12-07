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
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.AboutModel;
import java.util.Date;
/* loaded from: classes26.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private AboutModel mUA;
    private i mUD;
    private com.baidu.tieba.setting.more.a.a mUE;
    private com.baidu.tieba.setting.more.a mUz;
    private a mUB = null;
    private String mUC = com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + "mo/q/topic_page/110_1";
    private int mUF = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUE = new com.baidu.tieba.setting.more.a.a(this);
        this.mUz = new com.baidu.tieba.setting.more.a(this, new d() { // from class: com.baidu.tieba.setting.more.AboutActivity.1
            @Override // com.baidu.tieba.setting.more.d
            public void JY(int i) {
                String str;
                String fileDireciory;
                if (i == 0) {
                    AboutActivity.this.finish();
                } else if (i == 1) {
                    AboutActivity.this.checkUpdata();
                } else if (i == 2) {
                    AboutActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(AboutActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SettingTextFunctionIntroView.mXF, true);
                    com.baidu.tbadk.browser.a.startWebActivity(AboutActivity.this.getPageContext().getPageActivity(), AboutActivity.this.getPageContext().getString(R.string.function_intro), AboutActivity.this.mUC, true, false, false);
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
                    n.CopyDir(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/newStat", n.getCacheDir() + "newStat", false);
                } else if (i == 5) {
                    if (AboutActivity.this.mUD == null) {
                        AboutActivity.this.mUD = new i(AboutActivity.this.getActivity());
                        AboutActivity.this.mUD.b(AboutActivity.this.getPageContext());
                    }
                    AboutActivity.this.mUD.brv();
                } else if (i == 6) {
                    if (!ae.checkWriteExternalStorage(AboutActivity.this)) {
                        ae.d(AboutActivity.this, AboutActivity.this.mUF);
                    } else {
                        AboutActivity.this.dIm();
                    }
                }
            }
        });
        this.mUz.dIo();
        cTg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mUz != null) {
            this.mUz.dIo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cTh();
        if (this.mUA != null) {
            this.mUA.cancelLoadData();
        }
        if (this.mUz != null) {
            this.mUz.cJL();
        }
        if (this.mUD != null) {
            this.mUD.dismiss();
        }
        if (this.mUE != null) {
            this.mUE.dKv();
            this.mUE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mUz != null) {
            this.mUz.rY(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == this.mUF) {
            if (ae.checkWriteExternalStorage(getActivity().getApplicationContext())) {
                dIm();
            } else {
                showToast(R.string.write_external_storage_permission_denied_fun_disable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIm() {
        if (!this.mUE.dKw()) {
            this.mUE.dKu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        com.baidu.tieba.lc.c.ddh().tr(true);
        if (this.mUA == null) {
            this.mUA = new AboutModel(this, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.AboutActivity.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    AboutActivity.this.aQ(obj);
                }
            });
        } else {
            this.mUA.cancelLoadData();
        }
        this.mUA.dIf();
        if (this.mUz != null) {
            this.mUz.dIn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(Object obj) {
        if (this.mUz != null) {
            this.mUz.cJL();
        }
        com.baidu.tbadk.coreExtra.model.e eVar = obj != null ? (com.baidu.tbadk.coreExtra.model.e) obj : null;
        if (eVar != null) {
            TbadkCoreApplication.getInst().setVersionData(eVar.bzQ());
            TbadkCoreApplication.getInst().refreshNewVersion(false);
            if (eVar.bzQ().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (eVar.bzQ().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.bzQ(), eVar.bzP())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.bzQ(), eVar.bzP()));
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            }
            if (this.mUz != null) {
                this.mUz.dIo();
                return;
            }
            return;
        }
        showToast(getResources().getString(R.string.neterror));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AboutActivity.this.mUz != null) {
                AboutActivity.this.mUz.dIo();
            }
        }
    }

    private void cTg() {
        this.mUB = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.mUB, intentFilter);
    }

    private void cTh() {
        if (this.mUB != null) {
            unregisterReceiver(this.mUB);
        }
    }
}
