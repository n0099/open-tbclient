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
/* loaded from: classes8.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private com.baidu.tieba.setting.more.a nfA;
    private AboutModel nfB;
    private i nfE;
    private com.baidu.tieba.setting.more.a.a nfF;
    private a nfC = null;
    private String nfD = com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW + "mo/q/topic_page/110_1";
    private int nfG = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nfF = new com.baidu.tieba.setting.more.a.a(this);
        this.nfA = new com.baidu.tieba.setting.more.a(this, new d() { // from class: com.baidu.tieba.setting.more.AboutActivity.1
            @Override // com.baidu.tieba.setting.more.d
            public void IF(int i) {
                String str;
                String fileDireciory;
                if (i == 0) {
                    AboutActivity.this.finish();
                } else if (i == 1) {
                    AboutActivity.this.checkUpdata();
                } else if (i == 2) {
                    AboutActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(AboutActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SettingTextFunctionIntroView.niF, true);
                    com.baidu.tbadk.browser.a.startWebActivity(AboutActivity.this.getPageContext().getPageActivity(), AboutActivity.this.getPageContext().getString(R.string.function_intro), AboutActivity.this.nfD, true, false, false);
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
                    if (AboutActivity.this.nfE == null) {
                        AboutActivity.this.nfE = new i(AboutActivity.this.getActivity());
                        AboutActivity.this.nfE.b(AboutActivity.this.getPageContext());
                    }
                    AboutActivity.this.nfE.bqx();
                } else if (i == 6) {
                    if (!ae.checkWriteExternalStorage(AboutActivity.this)) {
                        ae.d(AboutActivity.this, AboutActivity.this.nfG);
                    } else {
                        AboutActivity.this.dGE();
                    }
                }
            }
        });
        this.nfA.dGG();
        cUB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.nfA != null) {
            this.nfA.dGG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cUC();
        if (this.nfB != null) {
            this.nfB.cancelLoadData();
        }
        if (this.nfA != null) {
            this.nfA.cKp();
        }
        if (this.nfE != null) {
            this.nfE.dismiss();
        }
        if (this.nfF != null) {
            this.nfF.dIN();
            this.nfF = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.nfA != null) {
            this.nfA.qJ(i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == this.nfG) {
            if (ae.checkWriteExternalStorage(getActivity().getApplicationContext())) {
                dGE();
            } else {
                showToast(R.string.write_external_storage_permission_denied_fun_disable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGE() {
        if (!this.nfF.dIO()) {
            this.nfF.dIM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        com.baidu.tieba.lc.c.dbh().tB(true);
        if (this.nfB == null) {
            this.nfB = new AboutModel(this, new com.baidu.adp.base.e() { // from class: com.baidu.tieba.setting.more.AboutActivity.2
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    AboutActivity.this.aQ(obj);
                }
            });
        } else {
            this.nfB.cancelLoadData();
        }
        this.nfB.checkUpdate();
        if (this.nfA != null) {
            this.nfA.dGF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(Object obj) {
        if (this.nfA != null) {
            this.nfA.cKp();
        }
        com.baidu.tbadk.coreExtra.model.e eVar = obj != null ? (com.baidu.tbadk.coreExtra.model.e) obj : null;
        if (eVar != null) {
            TbadkCoreApplication.getInst().setVersionData(eVar.byJ());
            TbadkCoreApplication.getInst().refreshNewVersion(false);
            if (eVar.byJ().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (eVar.byJ().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.byJ(), eVar.byI())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.byJ(), eVar.byI()));
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            }
            if (this.nfA != null) {
                this.nfA.dGG();
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
            if (AboutActivity.this.nfA != null) {
                AboutActivity.this.nfA.dGG();
            }
        }
    }

    private void cUB() {
        this.nfC = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.nfC, intentFilter);
    }

    private void cUC() {
        if (this.nfC != null) {
            unregisterReceiver(this.nfC);
        }
    }
}
