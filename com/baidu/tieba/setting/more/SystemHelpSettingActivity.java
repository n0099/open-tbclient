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
    private com.baidu.tbadk.core.dialog.a bJv;
    private g gBo = null;
    private SystemHelpSettingModel gBp = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gBo = new g(this);
        this.gBp = new SystemHelpSettingModel(this);
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.gBo.brk().mE();
        } else {
            this.gBo.brk().mF();
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true)) {
            this.gBo.brj().mE();
        } else {
            this.gBo.brj().mF();
        }
        this.gBo.brl().setTip(getPageContext().getString(d.j.calc_cache_size));
        this.gBo.brl().displayTip();
        this.gBp.a(new BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.1
            @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
            public void callback(Object... objArr) {
                Object obj = objArr[0];
                if (objArr != null && (obj instanceof MoreModel.TaskType)) {
                    if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                        SystemHelpSettingActivity.this.closeLoadingDialog();
                        SystemHelpSettingActivity.this.gBo.brl().setTip("");
                        SystemHelpSettingActivity.this.showToast(d.j.systemhelpsetting_clear_cache_success);
                    } else if (obj == MoreModel.TaskType.GET_SIZE) {
                        SystemHelpSettingActivity.this.gBo.brl().setTip((String) objArr[1]);
                    }
                }
            }
        });
        registerListener(new CustomMessageListener(2008016) { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SystemHelpSettingActivity.this.closeLoadingDialog();
                SystemHelpSettingActivity.this.showToast(d.j.systemhelpsetting_clear_im_success);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gBp != null) {
            this.gBp.bpq();
        }
        bps();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gBo.onChangeSkinType(i);
    }

    private void bps() {
        this.gBo.brn().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gBo != null) {
            if (view == this.gBo.brl()) {
                if (this.gBp != null) {
                    s.bk(getApplicationContext());
                    if (TextUtils.isEmpty(this.gBo.brl().getTip())) {
                        showToast(d.j.no_cache_delete);
                    } else {
                        this.bJv = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cf(d.j.alert_clear_all_cache).a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.4
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                SystemHelpSettingActivity.this.showLoadingDialog(SystemHelpSettingActivity.this.getPageContext().getString(d.j.deleting));
                                SystemHelpSettingActivity.this.gBp.bpo();
                                aVar.dismiss();
                            }
                        }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                aVar.dismiss();
                            }
                        }).b(getPageContext()).xf();
                    }
                }
            } else if (view == this.gBo.brm()) {
                if (this.gBp != null) {
                    this.bJv = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cf(d.j.alert_clear_cache).a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.6
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            SystemHelpSettingActivity.this.showLoadingDialog(SystemHelpSettingActivity.this.getPageContext().getString(d.j.deleting));
                            SystemHelpSettingActivity.this.gBp.bpp();
                        }
                    }).b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    }).b(getPageContext()).xf();
                }
            } else if (view == this.gBo.brn()) {
                sendMessage(new CustomMessage(2002001, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
            }
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.gBo.brk())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.gBp.setHeadsetModeOn(true);
                } else {
                    this.gBp.setHeadsetModeOn(false);
                }
            } else if (view == this.gBo.brj()) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("prefs_save_paled_video", true);
                    s.lx(true);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("prefs_save_paled_video", false);
                s.lx(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bJv != null && this.bJv.isShowing()) {
            this.bJv.dismiss();
        }
        super.onDestroy();
    }
}
