package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.R;
import com.baidu.tieba.play.s;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.model.SystemHelpSettingModel;
/* loaded from: classes13.dex */
public class SystemHelpSettingActivity extends BaseActivity<SystemHelpSettingActivity> implements BdSwitchView.a {
    private h lsN = null;
    private SystemHelpSettingModel lsO = null;
    private com.baidu.tbadk.core.dialog.a lsP;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lsN = new h(this);
        this.lsO = new SystemHelpSettingModel(this);
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.lsN.ddH().turnOn();
        } else {
            this.lsN.ddH().turnOff();
        }
        if (com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true)) {
            this.lsN.ddG().turnOn();
        } else {
            this.lsN.ddG().turnOff();
        }
        this.lsN.ddI().setTip(getPageContext().getString(R.string.calc_cache_size));
        this.lsN.ddI().displayTip();
        this.lsO.a(new BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.1
            @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
            public void callback(Object... objArr) {
                Object obj = objArr[0];
                if (objArr != null && (obj instanceof MoreModel.TaskType)) {
                    if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                        SystemHelpSettingActivity.this.closeLoadingDialog();
                        SystemHelpSettingActivity.this.lsN.ddI().setTip("");
                        SystemHelpSettingActivity.this.showToast(R.string.systemhelpsetting_clear_cache_success);
                    } else if (obj == MoreModel.TaskType.GET_SIZE) {
                        SystemHelpSettingActivity.this.lsN.ddI().setTip((String) objArr[1]);
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
        if (this.lsO != null) {
            this.lsO.dbK();
        }
        dbM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lsN.onChangeSkinType(i);
    }

    private void dbM() {
        this.lsN.ddK().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lsN != null) {
            if (view == this.lsN.ddI()) {
                if (this.lsO != null) {
                    s.clearCache(getApplicationContext());
                    if (TextUtils.isEmpty(this.lsN.ddI().getTip())) {
                        showToast(R.string.no_cache_delete);
                    } else {
                        this.lsP = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).kT(R.string.alert_clear_all_cache).a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.4
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                SystemHelpSettingActivity.this.showLoadingDialog(SystemHelpSettingActivity.this.getPageContext().getString(R.string.deleting));
                                SystemHelpSettingActivity.this.lsO.bNS();
                                aVar.dismiss();
                            }
                        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                aVar.dismiss();
                            }
                        }).b(getPageContext()).aUN();
                    }
                }
            } else if (view == this.lsN.ddJ()) {
                if (this.lsO != null) {
                    this.lsP = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).kT(R.string.alert_clear_cache).a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.6
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            SystemHelpSettingActivity.this.showLoadingDialog(SystemHelpSettingActivity.this.getPageContext().getString(R.string.deleting));
                            SystemHelpSettingActivity.this.lsO.dbJ();
                        }
                    }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    }).b(getPageContext()).aUN();
                }
            } else if (view == this.lsN.ddK()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
            }
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.lsN.ddH())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.lsO.setHeadsetModeOn(true);
                } else {
                    this.lsO.setHeadsetModeOn(false);
                }
            } else if (view == this.lsN.ddG()) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
                    s.tL(true);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, false);
                s.tL(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lsP != null && this.lsP.isShowing()) {
            this.lsP.dismiss();
        }
        super.onDestroy();
    }
}
