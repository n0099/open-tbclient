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
    private com.baidu.tbadk.core.dialog.a lRA;
    private h lRy = null;
    private SystemHelpSettingModel lRz = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lRy = new h(this);
        this.lRz = new SystemHelpSettingModel(this);
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.lRy.dsk().turnOn();
        } else {
            this.lRy.dsk().turnOff();
        }
        if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true)) {
            this.lRy.dsj().turnOn();
        } else {
            this.lRy.dsj().turnOff();
        }
        this.lRy.dsl().setTip(getPageContext().getString(R.string.calc_cache_size));
        this.lRy.dsl().displayTip();
        this.lRz.a(new BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.1
            @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
            public void callback(Object... objArr) {
                Object obj = objArr[0];
                if (objArr != null && (obj instanceof MoreModel.TaskType)) {
                    if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                        SystemHelpSettingActivity.this.closeLoadingDialog();
                        SystemHelpSettingActivity.this.lRy.dsl().setTip("");
                        SystemHelpSettingActivity.this.showToast(R.string.systemhelpsetting_clear_cache_success);
                    } else if (obj == MoreModel.TaskType.GET_SIZE) {
                        SystemHelpSettingActivity.this.lRy.dsl().setTip((String) objArr[1]);
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
        if (this.lRz != null) {
            this.lRz.dqk();
        }
        dqm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lRy.onChangeSkinType(i);
    }

    private void dqm() {
        this.lRy.dsn().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lRy != null) {
            if (view == this.lRy.dsl()) {
                if (this.lRz != null) {
                    CyberPlayerManager.deleteVideoCache(null);
                    if (TextUtils.isEmpty(this.lRy.dsl().getTip())) {
                        showToast(R.string.no_cache_delete);
                    } else {
                        this.lRA = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).nt(R.string.alert_clear_all_cache).a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.4
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                SystemHelpSettingActivity.this.showLoadingDialog(SystemHelpSettingActivity.this.getPageContext().getString(R.string.deleting));
                                SystemHelpSettingActivity.this.lRz.cbp();
                                aVar.dismiss();
                            }
                        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                aVar.dismiss();
                            }
                        }).b(getPageContext()).bhg();
                    }
                }
            } else if (view == this.lRy.dsm()) {
                if (this.lRz != null) {
                    this.lRA = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).nt(R.string.alert_clear_cache).a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.6
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            SystemHelpSettingActivity.this.showLoadingDialog(SystemHelpSettingActivity.this.getPageContext().getString(R.string.deleting));
                            SystemHelpSettingActivity.this.lRz.dqj();
                        }
                    }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    }).b(getPageContext()).bhg();
                }
            } else if (view == this.lRy.dsn()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
            }
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.lRy.dsk())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.lRz.setHeadsetModeOn(true);
                } else {
                    this.lRz.setHeadsetModeOn(false);
                }
            } else if (view == this.lRy.dsj()) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.lRA != null && this.lRA.isShowing()) {
            this.lRA.dismiss();
        }
        super.onDestroy();
    }
}
