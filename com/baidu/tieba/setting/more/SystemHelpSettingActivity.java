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
    private g gQe = null;
    private SystemHelpSettingModel gQf = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gQe = new g(this);
        this.gQf = new SystemHelpSettingModel(this);
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.gQe.bxe().nU();
        } else {
            this.gQe.bxe().nV();
        }
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("prefs_save_paled_video", true)) {
            this.gQe.bxd().nU();
        } else {
            this.gQe.bxd().nV();
        }
        this.gQe.bxf().setTip(getPageContext().getString(e.j.calc_cache_size));
        this.gQe.bxf().displayTip();
        this.gQf.a(new BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.1
            @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
            public void callback(Object... objArr) {
                Object obj = objArr[0];
                if (objArr != null && (obj instanceof MoreModel.TaskType)) {
                    if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                        SystemHelpSettingActivity.this.closeLoadingDialog();
                        SystemHelpSettingActivity.this.gQe.bxf().setTip("");
                        SystemHelpSettingActivity.this.showToast(e.j.systemhelpsetting_clear_cache_success);
                    } else if (obj == MoreModel.TaskType.GET_SIZE) {
                        SystemHelpSettingActivity.this.gQe.bxf().setTip((String) objArr[1]);
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
        if (this.gQf != null) {
            this.gQf.bvn();
        }
        bvp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gQe.onChangeSkinType(i);
    }

    private void bvp() {
        this.gQe.bxh().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gQe != null) {
            if (view == this.gQe.bxf()) {
                if (this.gQf != null) {
                    t.clearCache(getApplicationContext());
                    if (TextUtils.isEmpty(this.gQe.bxf().getTip())) {
                        showToast(e.j.no_cache_delete);
                    } else {
                        this.bXL = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cz(e.j.alert_clear_all_cache).a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.4
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                SystemHelpSettingActivity.this.showLoadingDialog(SystemHelpSettingActivity.this.getPageContext().getString(e.j.deleting));
                                SystemHelpSettingActivity.this.gQf.bvl();
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
            } else if (view == this.gQe.bxg()) {
                if (this.gQf != null) {
                    this.bXL = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity()).cz(e.j.alert_clear_cache).a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.6
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            SystemHelpSettingActivity.this.showLoadingDialog(SystemHelpSettingActivity.this.getPageContext().getString(e.j.deleting));
                            SystemHelpSettingActivity.this.gQf.bvm();
                        }
                    }).b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.setting.more.SystemHelpSettingActivity.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    }).b(getPageContext()).Au();
                }
            } else if (view == this.gQe.bxh()) {
                sendMessage(new CustomMessage(2002001, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
            }
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.a
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.gQe.bxe())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.gQf.setHeadsetModeOn(true);
                } else {
                    this.gQf.setHeadsetModeOn(false);
                }
            } else if (view == this.gQe.bxd()) {
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
