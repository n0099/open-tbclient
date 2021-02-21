package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
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
/* loaded from: classes8.dex */
public class SystemHelpSettingActivity extends BaseActivity<SystemHelpSettingActivity> implements BdSwitchView.a {
    private h niI = null;
    private SystemHelpSettingModel niJ = null;
    private com.baidu.tbadk.core.dialog.a niK;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.niI = new h(this);
        this.niJ = new SystemHelpSettingModel(this);
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.niI.dII().turnOn();
        } else {
            this.niI.dII().turnOff();
        }
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true)) {
            this.niI.dIH().turnOn();
        } else {
            this.niI.dIH().turnOff();
        }
        this.niI.dIJ().setTip(getPageContext().getString(R.string.calc_cache_size));
        this.niI.dIJ().displayTip();
        this.niJ.a(new BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.1
            @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
            public void callback(Object... objArr) {
                Object obj = objArr[0];
                if (objArr != null && (obj instanceof MoreModel.TaskType)) {
                    if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                        SystemHelpSettingActivity.this.closeLoadingDialog();
                        SystemHelpSettingActivity.this.niI.dIJ().setTip("");
                        SystemHelpSettingActivity.this.showToast(R.string.systemhelpsetting_clear_cache_success);
                    } else if (obj == MoreModel.TaskType.GET_SIZE) {
                        SystemHelpSettingActivity.this.niI.dIJ().setTip((String) objArr[1]);
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
        if (this.niJ != null) {
            this.niJ.dGD();
        }
        dGG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.niI.onChangeSkinType(i);
    }

    private void dGG() {
        this.niI.dIL().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.niI != null) {
            if (view == this.niI.dIJ()) {
                if (this.niJ != null) {
                    CyberPlayerManager.deleteVideoCache(null);
                    if (TextUtils.isEmpty(this.niI.dIJ().getTip())) {
                        showToast(R.string.no_cache_delete);
                    } else {
                        this.niK = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).nx(R.string.alert_clear_all_cache).a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.4
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                SystemHelpSettingActivity.this.showLoadingDialog(SystemHelpSettingActivity.this.getPageContext().getString(R.string.deleting));
                                SystemHelpSettingActivity.this.niJ.crS();
                                aVar.dismiss();
                            }
                        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                aVar.dismiss();
                            }
                        }).b(getPageContext()).bqx();
                    }
                }
            } else if (view == this.niI.dIK()) {
                if (this.niJ != null) {
                    this.niK = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).nx(R.string.alert_clear_cache).a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.6
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            SystemHelpSettingActivity.this.showLoadingDialog(SystemHelpSettingActivity.this.getPageContext().getString(R.string.deleting));
                            SystemHelpSettingActivity.this.niJ.dGC();
                        }
                    }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    }).b(getPageContext()).bqx();
                }
            } else if (view == this.niI.dIL()) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
            } else if (view == this.niI.dGW() && TbadkCoreApplication.getInst().isMainProcess(false)) {
                MessageManager.getInstance().runTask(2921514, null, null);
            }
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.niI.dII())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.niJ.setHeadsetModeOn(true);
                } else {
                    this.niJ.setHeadsetModeOn(false);
                }
            } else if (view == this.niI.dIH()) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, true);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.PREFS_SAVE_PALED_VIDEO, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.niK != null && this.niK.isShowing()) {
            this.niK.dismiss();
        }
        super.onDestroy();
    }
}
