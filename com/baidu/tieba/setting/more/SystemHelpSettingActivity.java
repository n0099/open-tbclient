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
import com.baidu.tieba.e;
import com.baidu.tieba.play.t;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.model.SystemHelpSettingModel;
/* loaded from: classes3.dex */
public class SystemHelpSettingActivity extends BaseActivity<SystemHelpSettingActivity> implements BdSwitchView.a {
    private com.baidu.tbadk.core.dialog.a bXL;
    private g gQd = null;
    private SystemHelpSettingModel gQe = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gQd = new g(this);
        this.gQe = new SystemHelpSettingModel(this);
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.gQd.bxe().nU();
        } else {
            this.gQd.bxe().nV();
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true)) {
            this.gQd.bxd().nU();
        } else {
            this.gQd.bxd().nV();
        }
        this.gQd.bxf().setTip(getPageContext().getString(e.j.calc_cache_size));
        this.gQd.bxf().displayTip();
        this.gQe.a(new BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.1
            @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
            public void callback(Object... objArr) {
                Object obj = objArr[0];
                if (objArr != null && (obj instanceof MoreModel.TaskType)) {
                    if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                        SystemHelpSettingActivity.this.closeLoadingDialog();
                        SystemHelpSettingActivity.this.gQd.bxf().setTip("");
                        SystemHelpSettingActivity.this.showToast(e.j.systemhelpsetting_clear_cache_success);
                    } else if (obj == MoreModel.TaskType.GET_SIZE) {
                        SystemHelpSettingActivity.this.gQd.bxf().setTip((String) objArr[1]);
                    }
                }
            }
        });
        registerListener(new CustomMessageListener(2008016) { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                SystemHelpSettingActivity.this.closeLoadingDialog();
                SystemHelpSettingActivity.this.showToast(e.j.systemhelpsetting_clear_im_success);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gQe != null) {
            this.gQe.bvn();
        }
        bvp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gQd.onChangeSkinType(i);
    }

    private void bvp() {
        this.gQd.bxh().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gQd != null) {
            if (view == this.gQd.bxf()) {
                if (this.gQe != null) {
                    t.clearCache(getApplicationContext());
                    if (TextUtils.isEmpty(this.gQd.bxf().getTip())) {
                        showToast(e.j.no_cache_delete);
                    } else {
                        this.bXL = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cz(e.j.alert_clear_all_cache).a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.4
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                SystemHelpSettingActivity.this.showLoadingDialog(SystemHelpSettingActivity.this.getPageContext().getString(e.j.deleting));
                                SystemHelpSettingActivity.this.gQe.bvl();
                                aVar.dismiss();
                            }
                        }).b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.3
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                aVar.dismiss();
                            }
                        }).b(getPageContext()).Au();
                    }
                }
            } else if (view == this.gQd.bxg()) {
                if (this.gQe != null) {
                    this.bXL = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cz(e.j.alert_clear_cache).a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.6
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            SystemHelpSettingActivity.this.showLoadingDialog(SystemHelpSettingActivity.this.getPageContext().getString(e.j.deleting));
                            SystemHelpSettingActivity.this.gQe.bvm();
                        }
                    }).b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    }).b(getPageContext()).Au();
                }
            } else if (view == this.gQd.bxh()) {
                sendMessage(new CustomMessage(2002001, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
            }
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.gQd.bxe())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.gQe.setHeadsetModeOn(true);
                } else {
                    this.gQe.setHeadsetModeOn(false);
                }
            } else if (view == this.gQd.bxd()) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("prefs_save_paled_video", true);
                    t.mo(true);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("prefs_save_paled_video", false);
                t.mo(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bXL != null && this.bXL.isShowing()) {
            this.bXL.dismiss();
        }
        super.onDestroy();
    }
}
