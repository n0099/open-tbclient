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
/* loaded from: classes25.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private i mGA;
    private com.baidu.tieba.setting.more.a.a mGB;
    private com.baidu.tieba.setting.more.a mGw;
    private AboutModel mGx;
    private a mGy = null;
    private String mGz = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/topic_page/110_1";
    private int mGC = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mGB = new com.baidu.tieba.setting.more.a.a(this);
        this.mGw = new com.baidu.tieba.setting.more.a(this, new d() { // from class: com.baidu.tieba.setting.more.AboutActivity.1
            @Override // com.baidu.tieba.setting.more.d
            public void Jh(int i) {
                String str;
                String fileDireciory;
                if (i == 0) {
                    AboutActivity.this.finish();
                } else if (i == 1) {
                    AboutActivity.this.checkUpdata();
                } else if (i == 2) {
                    AboutActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(AboutActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SettingTextFunctionIntroView.mJE, true);
                    com.baidu.tbadk.browser.a.startWebActivity(AboutActivity.this.getPageContext().getPageActivity(), AboutActivity.this.getPageContext().getString(R.string.function_intro), AboutActivity.this.mGz, true, false, false);
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
                    if (AboutActivity.this.mGA == null) {
                        AboutActivity.this.mGA = new i(AboutActivity.this.getActivity());
                        AboutActivity.this.mGA.b(AboutActivity.this.getPageContext());
                    }
                    AboutActivity.this.mGA.bog();
                } else if (i == 6) {
                    if (!ae.checkWriteExternalStorage(AboutActivity.this)) {
                        ae.d(AboutActivity.this, AboutActivity.this.mGC);
                    } else {
                        AboutActivity.this.dDb();
                    }
                }
            }
        });
        this.mGw.dDd();
        cNS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mGw != null) {
            this.mGw.dDd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cNT();
        if (this.mGx != null) {
            this.mGx.cancelLoadData();
        }
        if (this.mGw != null) {
            this.mGw.cEy();
        }
        if (this.mGA != null) {
            this.mGA.dismiss();
        }
        if (this.mGB != null) {
            this.mGB.dFk();
            this.mGB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mGw != null) {
            this.mGw.rx(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == this.mGC) {
            if (ae.checkWriteExternalStorage(getActivity().getApplicationContext())) {
                dDb();
            } else {
                showToast(R.string.write_external_storage_permission_denied_fun_disable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dDb() {
        if (!this.mGB.dFl()) {
            this.mGB.dFj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        com.baidu.tieba.lc.c.cXW().sP(true);
        if (this.mGx == null) {
            this.mGx = new AboutModel(this, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.AboutActivity.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    AboutActivity.this.aQ(obj);
                }
            });
        } else {
            this.mGx.cancelLoadData();
        }
        this.mGx.dCU();
        if (this.mGw != null) {
            this.mGw.dDc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(Object obj) {
        if (this.mGw != null) {
            this.mGw.cEy();
        }
        com.baidu.tbadk.coreExtra.model.e eVar = obj != null ? (com.baidu.tbadk.coreExtra.model.e) obj : null;
        if (eVar != null) {
            TbadkCoreApplication.getInst().setVersionData(eVar.bwq());
            TbadkCoreApplication.getInst().refreshNewVersion(false);
            if (eVar.bwq().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (eVar.bwq().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.bwq(), eVar.bwp())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.bwq(), eVar.bwp()));
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            }
            if (this.mGw != null) {
                this.mGw.dDd();
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
            if (AboutActivity.this.mGw != null) {
                AboutActivity.this.mGw.dDd();
            }
        }
    }

    private void cNS() {
        this.mGy = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.mGy, intentFilter);
    }

    private void cNT() {
        if (this.mGy != null) {
            unregisterReceiver(this.mGy);
        }
    }
}
