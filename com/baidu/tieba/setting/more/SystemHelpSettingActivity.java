package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.d;
import com.baidu.tieba.play.s;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.model.SystemHelpSettingModel;
/* loaded from: classes3.dex */
public class SystemHelpSettingActivity extends BaseActivity<SystemHelpSettingActivity> implements BdSwitchView.a {
    private com.baidu.tbadk.core.dialog.a bGM;
    private g gwn = null;
    private SystemHelpSettingModel gwo = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gwn = new g(this);
        this.gwo = new SystemHelpSettingModel(this);
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.gwn.bsg().mC();
        } else {
            this.gwn.bsg().mD();
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true)) {
            this.gwn.bsf().mC();
        } else {
            this.gwn.bsf().mD();
        }
        this.gwn.bsh().setTip(getPageContext().getString(d.k.calc_cache_size));
        this.gwn.bsh().displayTip();
        this.gwo.a(new BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.1
            @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
            public void callback(Object... objArr) {
                Object obj = objArr[0];
                if (objArr != null && (obj instanceof MoreModel.TaskType)) {
                    if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                        SystemHelpSettingActivity.this.closeLoadingDialog();
                        SystemHelpSettingActivity.this.gwn.bsh().setTip("");
                        SystemHelpSettingActivity.this.showToast(d.k.systemhelpsetting_clear_cache_success);
                    } else if (obj == MoreModel.TaskType.GET_SIZE) {
                        SystemHelpSettingActivity.this.gwn.bsh().setTip((String) objArr[1]);
                    }
                }
            }
        });
        registerListener(new CustomMessageListener(2008016) { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SystemHelpSettingActivity.this.closeLoadingDialog();
                SystemHelpSettingActivity.this.showToast(d.k.systemhelpsetting_clear_im_success);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gwo != null) {
            this.gwo.bqm();
        }
        bqo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gwn.onChangeSkinType(i);
    }

    private void bqo() {
        this.gwn.bsj().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gwn != null) {
            if (view == this.gwn.bsh()) {
                if (this.gwo != null) {
                    s.bj(getApplicationContext());
                    if (TextUtils.isEmpty(this.gwn.bsh().getTip())) {
                        showToast(d.k.no_cache_delete);
                    } else {
                        this.bGM = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cc(d.k.alert_clear_all_cache).a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.4
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                SystemHelpSettingActivity.this.showLoadingDialog(SystemHelpSettingActivity.this.getPageContext().getString(d.k.deleting));
                                SystemHelpSettingActivity.this.gwo.bqk();
                                aVar.dismiss();
                            }
                        }).b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                aVar.dismiss();
                            }
                        }).b(getPageContext()).xa();
                    }
                }
            } else if (view == this.gwn.bsi()) {
                if (this.gwo != null) {
                    this.bGM = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cc(d.k.alert_clear_cache).a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.6
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            SystemHelpSettingActivity.this.showLoadingDialog(SystemHelpSettingActivity.this.getPageContext().getString(d.k.deleting));
                            SystemHelpSettingActivity.this.gwo.bql();
                        }
                    }).b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    }).b(getPageContext()).xa();
                }
            } else if (view == this.gwn.bsj()) {
                sendMessage(new CustomMessage(2002001, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
            }
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.gwn.bsg())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.gwo.setHeadsetModeOn(true);
                } else {
                    this.gwo.setHeadsetModeOn(false);
                }
            } else if (view == this.gwn.bsf()) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("prefs_save_paled_video", true);
                    s.lC(true);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("prefs_save_paled_video", false);
                s.lC(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bGM != null && this.bGM.isShowing()) {
            this.bGM.dismiss();
        }
        super.onDestroy();
    }
}
