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
/* loaded from: classes20.dex */
public class AboutActivity extends BaseActivity<AboutActivity> {
    private i lOA;
    private com.baidu.tieba.setting.more.a lOw;
    private AboutModel lOx;
    private a lOy = null;
    private String lOz = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/topic_page/110_1";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lOw = new com.baidu.tieba.setting.more.a(this, new d() { // from class: com.baidu.tieba.setting.more.AboutActivity.1
            @Override // com.baidu.tieba.setting.more.d
            public void GR(int i) {
                String str;
                String fileDireciory;
                if (i == 0) {
                    AboutActivity.this.finish();
                } else if (i == 1) {
                    AboutActivity.this.checkUpdata();
                } else if (i == 2) {
                    AboutActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(AboutActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SettingTextFunctionIntroView.lRv, true);
                    com.baidu.tbadk.browser.a.startWebActivity(AboutActivity.this.getPageContext().getPageActivity(), AboutActivity.this.getPageContext().getString(R.string.function_intro), AboutActivity.this.lOz, true, false, false);
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
                    if (AboutActivity.this.lOA == null) {
                        AboutActivity.this.lOA = new i(AboutActivity.this.getActivity());
                        AboutActivity.this.lOA.b(AboutActivity.this.getPageContext());
                    }
                    AboutActivity.this.lOA.bhg();
                }
            }
        });
        this.lOw.dqm();
        cBn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lOw != null) {
            this.lOw.dqm();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cBo();
        if (this.lOx != null) {
            this.lOx.cancelLoadData();
        }
        if (this.lOw != null) {
            this.lOw.csy();
        }
        if (this.lOA != null) {
            this.lOA.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lOw != null) {
            this.lOw.pT(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.lOx == null) {
            this.lOx = new AboutModel(this, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.AboutActivity.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    AboutActivity.this.aJ(obj);
                }
            });
        } else {
            this.lOx.cancelLoadData();
        }
        this.lOx.dqe();
        if (this.lOw != null) {
            this.lOw.dql();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(Object obj) {
        if (this.lOw != null) {
            this.lOw.csy();
        }
        com.baidu.tbadk.coreExtra.model.e eVar = obj != null ? (com.baidu.tbadk.coreExtra.model.e) obj : null;
        if (eVar != null) {
            TbadkCoreApplication.getInst().setVersionData(eVar.bpc());
            TbadkCoreApplication.getInst().refreshNewVersion(false);
            if (eVar.bpc().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (eVar.bpc().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.bpc(), eVar.bpb())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), eVar.bpc(), eVar.bpb()));
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(R.string.neednot_update));
            }
            if (this.lOw != null) {
                this.lOw.dqm();
                return;
            }
            return;
        }
        showToast(getResources().getString(R.string.neterror));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (AboutActivity.this.lOw != null) {
                AboutActivity.this.lOw.dqm();
            }
        }
    }

    private void cBn() {
        this.lOy = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.lOy, intentFilter);
    }

    private void cBo() {
        if (this.lOy != null) {
            unregisterReceiver(this.lOy);
        }
    }
}
