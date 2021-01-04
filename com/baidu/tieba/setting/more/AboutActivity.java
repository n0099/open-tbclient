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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.AboutModel;
import java.util.Date;
/* loaded from: classes8.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private com.baidu.tieba.setting.more.a mZX;
    private AboutModel mZY;
    private i nab;
    private com.baidu.tieba.setting.more.a.a nac;
    private a mZZ = null;
    private String naa = com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + "mo/q/topic_page/110_1";
    private int nad = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nac = new com.baidu.tieba.setting.more.a.a(this);
        this.mZX = new com.baidu.tieba.setting.more.a(this, new d() { // from class: com.baidu.tieba.setting.more.AboutActivity.1
            @Override // com.baidu.tieba.setting.more.d
            public void JS(int i) {
                String str;
                String fileDireciory;
                if (i == 0) {
                    AboutActivity.this.finish();
                } else if (i == 1) {
                    AboutActivity.this.checkUpdata();
                } else if (i == 2) {
                    AboutActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(AboutActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SettingTextFunctionIntroView.ndc, true);
                    com.baidu.tbadk.browser.a.startWebActivity(AboutActivity.this.getPageContext().getPageActivity(), AboutActivity.this.getPageContext().getString(R.string.function_intro), AboutActivity.this.naa, true, false, false);
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
                    if (AboutActivity.this.nab == null) {
                        AboutActivity.this.nab = new i(AboutActivity.this.getActivity());
                        AboutActivity.this.nab.b(AboutActivity.this.getPageContext());
                    }
                    AboutActivity.this.nab.btX();
                } else if (i == 6) {
                    if (!ad.checkWriteExternalStorage(AboutActivity.this)) {
                        ad.d(AboutActivity.this, AboutActivity.this.nad);
                    } else {
                        AboutActivity.this.dIc();
                    }
                }
            }
        });
        this.mZX.dIe();
        cWn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mZX != null) {
            this.mZX.dIe();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cWo();
        if (this.mZY != null) {
            this.mZY.cancelLoadData();
        }
        if (this.mZX != null) {
            this.mZX.cMM();
        }
        if (this.nab != null) {
            this.nab.dismiss();
        }
        if (this.nac != null) {
            this.nac.dKl();
            this.nac = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mZX != null) {
            this.mZX.sk(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == this.nad) {
            if (ad.checkWriteExternalStorage(getActivity().getApplicationContext())) {
                dIc();
            } else {
                showToast(R.string.write_external_storage_permission_denied_fun_disable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dIc() {
        if (!this.nac.dKm()) {
            this.nac.dKk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        com.baidu.tieba.lc.c.dcT().ts(true);
        if (this.mZY == null) {
            this.mZY = new AboutModel(this, new com.baidu.adp.base.e() { // from class: com.baidu.tieba.setting.more.AboutActivity.2
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    AboutActivity.this.aQ(obj);
                }
            });
        } else {
            this.mZY.cancelLoadData();
        }
        this.mZY.checkUpdate();
        if (this.mZX != null) {
            this.mZX.dId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(Object obj) {
        if (this.mZX != null) {
            this.mZX.cMM();
        }
        com.baidu.tbadk.coreExtra.model.e eVar = obj != null ? (com.baidu.tbadk.coreExtra.model.e) obj : null;
        if (eVar != null) {
            TbadkCoreApplication.getInst().setVersionData(eVar.bCk());
            TbadkCoreApplication.getInst().refreshNewVersion(false);
            if (eVar.bCk().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (eVar.bCk().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.bCk(), eVar.bCj())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.bCk(), eVar.bCj()));
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            }
            if (this.mZX != null) {
                this.mZX.dIe();
                return;
            }
            return;
        }
        showToast(getResources().getString(R.string.neterror));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AboutActivity.this.mZX != null) {
                AboutActivity.this.mZX.dIe();
            }
        }
    }

    private void cWn() {
        this.mZZ = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.mZZ, intentFilter);
    }

    private void cWo() {
        if (this.mZZ != null) {
            unregisterReceiver(this.mZZ);
        }
    }
}
