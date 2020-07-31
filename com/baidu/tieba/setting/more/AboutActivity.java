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
    private com.baidu.tieba.setting.more.a lxg;
    private AboutModel lxh;
    private a lxi = null;
    private String lxj = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/topic_page/110_1";
    private i lxk;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lxg = new com.baidu.tieba.setting.more.a(this, new d() { // from class: com.baidu.tieba.setting.more.AboutActivity.1
            @Override // com.baidu.tieba.setting.more.d
            public void Eu(int i) {
                String str;
                String fileDireciory;
                if (i == 0) {
                    AboutActivity.this.finish();
                } else if (i == 1) {
                    AboutActivity.this.checkUpdata();
                } else if (i == 2) {
                    AboutActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(AboutActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_ABOUT_PAGE, false)));
                } else if (i == 3) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SettingTextFunctionIntroView.lAc, true);
                    com.baidu.tbadk.browser.a.startWebActivity(AboutActivity.this.getPageContext().getPageActivity(), AboutActivity.this.getPageContext().getString(R.string.function_intro), AboutActivity.this.lxj, true, false, false);
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
                    if (AboutActivity.this.lxk == null) {
                        AboutActivity.this.lxk = new i(AboutActivity.this.getActivity());
                        AboutActivity.this.lxk.b(AboutActivity.this.getPageContext());
                    }
                    AboutActivity.this.lxk.aYL();
                }
            }
        });
        this.lxg.deT();
        cqv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lxg != null) {
            this.lxg.deT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cqw();
        if (this.lxh != null) {
            this.lxh.cancelLoadData();
        }
        if (this.lxg != null) {
            this.lxg.chU();
        }
        if (this.lxk != null) {
            this.lxk.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.lxg != null) {
            this.lxg.nI(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdata() {
        if (this.lxh == null) {
            this.lxh = new AboutModel(this, new com.baidu.adp.base.d() { // from class: com.baidu.tieba.setting.more.AboutActivity.2
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    AboutActivity.this.aH(obj);
                }
            });
        } else {
            this.lxh.cancelLoadData();
        }
        this.lxh.deL();
        if (this.lxg != null) {
            this.lxg.deS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(Object obj) {
        if (this.lxg != null) {
            this.lxg.chU();
        }
        com.baidu.tbadk.coreExtra.model.d dVar = obj != null ? (com.baidu.tbadk.coreExtra.model.d) obj : null;
        if (dVar != null) {
            TbadkCoreApplication.getInst().setVersionData(dVar.bgr());
            TbadkCoreApplication.getInst().refreshNewVersion(false);
            if (dVar.bgr().hasNewVer() && TbConfig.COULD_UPDATE) {
                if (dVar.bgr().forceUpdate()) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), dVar.bgr(), dVar.bgq())));
                } else {
                    Long valueOf = Long.valueOf(new Date().getTime());
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UpdateDialogConfig(TbadkCoreApplication.getInst().getApp(), dVar.bgr(), dVar.bgq()));
                    TbadkCoreApplication.getInst().setUpdateNotifyTime(valueOf.longValue());
                    sendMessage(customMessage);
                }
            } else {
                showToast(getResources().getString(R.string.neednot_update));
            }
            if (this.lxg != null) {
                this.lxg.deT();
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
            if (AboutActivity.this.lxg != null) {
                AboutActivity.this.lxg.deT();
            }
        }
    }

    private void cqv() {
        this.lxi = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionNewVersion());
        registerReceiver(this.lxi, intentFilter);
    }

    private void cqw() {
        if (this.lxi != null) {
            unregisterReceiver(this.lxi);
        }
    }
}
