package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.model.SystemHelpSettingModel;
/* loaded from: classes20.dex */
public class SystemHelpSettingActivity extends BaseActivity<SystemHelpSettingActivity> implements BdSwitchView.a {
    private h lAf = null;
    private SystemHelpSettingModel lAg = null;
    private com.baidu.tbadk.core.dialog.a lAh;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lAf = new h(this);
        this.lAg = new SystemHelpSettingModel(this);
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.lAf.dgO().turnOn();
        } else {
            this.lAf.dgO().turnOff();
        }
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true)) {
            this.lAf.dgN().turnOn();
        } else {
            this.lAf.dgN().turnOff();
        }
        this.lAf.dgP().setTip(getPageContext().getString(R.string.calc_cache_size));
        this.lAf.dgP().displayTip();
        this.lAg.a(new BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.1
            @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
            public void callback(Object... objArr) {
                Object obj = objArr[0];
                if (objArr != null && (obj instanceof MoreModel.TaskType)) {
                    if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                        SystemHelpSettingActivity.this.closeLoadingDialog();
                        SystemHelpSettingActivity.this.lAf.dgP().setTip("");
                        SystemHelpSettingActivity.this.showToast(R.string.systemhelpsetting_clear_cache_success);
                    } else if (obj == MoreModel.TaskType.GET_SIZE) {
                        SystemHelpSettingActivity.this.lAf.dgP().setTip((String) objArr[1]);
                    }
                }
            }
        });
        registerListener(new CustomMessageListener(CmdConfigCustom.IM_CLEAR_MSG) { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SystemHelpSettingActivity.this.closeLoadingDialog();
                SystemHelpSettingActivity.this.showToast(R.string.systemhelpsetting_clear_im_success);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.lAg != null) {
            this.lAg.deR();
        }
        deT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lAf.onChangeSkinType(i);
    }

    private void deT() {
        this.lAf.dgR().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lAf != null) {
            if (view == this.lAf.dgP()) {
                if (this.lAg != null) {
                    CyberPlayerManager.deleteVideoCache(null);
                    if (TextUtils.isEmpty(this.lAf.dgP().getTip())) {
                        showToast(R.string.no_cache_delete);
                    } else {
                        this.lAh = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).ln(R.string.alert_clear_all_cache).a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.4
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                SystemHelpSettingActivity.this.showLoadingDialog(SystemHelpSettingActivity.this.getPageContext().getString(R.string.deleting));
                                SystemHelpSettingActivity.this.lAg.bRd();
                                aVar.dismiss();
                            }
                        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                aVar.dismiss();
                            }
                        }).b(getPageContext()).aYL();
                    }
                }
            } else if (view == this.lAf.dgQ()) {
                if (this.lAg != null) {
                    this.lAh = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).ln(R.string.alert_clear_cache).a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.6
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            SystemHelpSettingActivity.this.showLoadingDialog(SystemHelpSettingActivity.this.getPageContext().getString(R.string.deleting));
                            SystemHelpSettingActivity.this.lAg.deQ();
                        }
                    }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    }).b(getPageContext()).aYL();
                }
            } else if (view == this.lAf.dgR()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
            }
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.lAf.dgO())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.lAg.setHeadsetModeOn(true);
                } else {
                    this.lAg.setHeadsetModeOn(false);
                }
            } else if (view == this.lAf.dgN()) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lAh != null && this.lAh.isShowing()) {
            this.lAh.dismiss();
        }
        super.onDestroy();
    }
}
