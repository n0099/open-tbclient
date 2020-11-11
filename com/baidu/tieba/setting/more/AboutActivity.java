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
/* loaded from: classes26.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private com.baidu.tieba.setting.more.a mFY;
    private AboutModel mFZ;
    private a mGa = null;
    private String mGb = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/topic_page/110_1";
    private i mGc;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFY = new com.baidu.tieba.setting.more.a(this, new d() { // from class: com.baidu.tieba.setting.more.AboutActivity.1
            @Override // com.baidu.tieba.setting.more.d
            public void IG(int i) {
                String str;
                String fileDireciory;
                if (i == 0) {
                    AboutActivity.this.finish();
                } else if (i == 1) {
                    AboutActivity.this.checkUpdata();
                } else if (i == 2) {
                    AboutActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(AboutActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SettingTextFunctionIntroView.mJf, true);
                    com.baidu.tbadk.browser.a.startWebActivity(AboutActivity.this.getPageContext().getPageActivity(), AboutActivity.this.getPageContext().getString(R.string.function_intro), AboutActivity.this.mGb, true, false, false);
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
                    if (AboutActivity.this.mGc == null) {
                        AboutActivity.this.mGc = new i(AboutActivity.this.getActivity());
                        AboutActivity.this.mGc.b(AboutActivity.this.getPageContext());
                    }
                    AboutActivity.this.mGc.bpc();
                }
            }
        });
        this.mFY.dDy();
        cOm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mFY != null) {
            this.mFY.dDy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cOn();
        if (this.mFZ != null) {
            this.mFZ.cancelLoadData();
        }
        if (this.mFY != null) {
            this.mFY.cET();
        }
        if (this.mGc != null) {
            this.mGc.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.mFY != null) {
            this.mFY.qZ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        com.baidu.tieba.lc.c.cYA().sM(true);
        if (this.mFZ == null) {
            this.mFZ = new AboutModel(this, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.AboutActivity.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    AboutActivity.this.aP(obj);
                }
            });
        } else {
            this.mFZ.cancelLoadData();
        }
        this.mFZ.dDq();
        if (this.mFY != null) {
            this.mFY.dDx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(Object obj) {
        if (this.mFY != null) {
            this.mFY.cET();
        }
        com.baidu.tbadk.coreExtra.model.e eVar = obj != null ? (com.baidu.tbadk.coreExtra.model.e) obj : null;
        if (eVar != null) {
            TbadkCoreApplication.getInst().setVersionData(eVar.bxa());
            TbadkCoreApplication.getInst().refreshNewVersion(false);
            if (eVar.bxa().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (eVar.bxa().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.bxa(), eVar.bwZ())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.bxa(), eVar.bwZ()));
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            }
            if (this.mFY != null) {
                this.mFY.dDy();
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
            if (AboutActivity.this.mFY != null) {
                AboutActivity.this.mFY.dDy();
            }
        }
    }

    private void cOm() {
        this.mGa = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.mGa, intentFilter);
    }

    private void cOn() {
        if (this.mGa != null) {
            unregisterReceiver(this.mGa);
        }
    }
}
