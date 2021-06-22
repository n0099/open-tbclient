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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PluginCenterActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.model.MoreModel;
import com.baidu.tieba.setting.model.SystemHelpSettingModel;
import d.a.n0.r.s.a;
import d.a.o0.w2.c.h;
/* loaded from: classes5.dex */
public class SystemHelpSettingActivity extends BaseActivity<SystemHelpSettingActivity> implements BdSwitchView.b {
    public d.a.n0.r.s.a mBdAlertDialog;
    public h mView = null;
    public SystemHelpSettingModel mModel = null;

    /* loaded from: classes5.dex */
    public class a extends BaseActivity<SystemHelpSettingActivity>.LoadDataCallBack {
        public a() {
            super();
        }

        @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
        public void callback(Object... objArr) {
            Object obj = objArr[0];
            if (objArr == null || !(obj instanceof MoreModel.TaskType)) {
                return;
            }
            if (obj == MoreModel.TaskType.DO_CACHE_CLEAR) {
                SystemHelpSettingActivity.this.closeLoadingDialog();
                SystemHelpSettingActivity.this.mView.e().setTip("");
                SystemHelpSettingActivity.this.showToast(R.string.systemhelpsetting_clear_cache_success);
            } else if (obj == MoreModel.TaskType.GET_SIZE) {
                SystemHelpSettingActivity.this.mView.e().setTip((String) objArr[1]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SystemHelpSettingActivity.this.closeLoadingDialog();
            SystemHelpSettingActivity.this.showToast(R.string.systemhelpsetting_clear_im_success);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            SystemHelpSettingActivity systemHelpSettingActivity = SystemHelpSettingActivity.this;
            systemHelpSettingActivity.showLoadingDialog(systemHelpSettingActivity.getPageContext().getString(R.string.deleting));
            SystemHelpSettingActivity.this.mModel.A();
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {
        public f() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
            SystemHelpSettingActivity systemHelpSettingActivity = SystemHelpSettingActivity.this;
            systemHelpSettingActivity.showLoadingDialog(systemHelpSettingActivity.getPageContext().getString(R.string.deleting));
            SystemHelpSettingActivity.this.mModel.B();
        }
    }

    private void goBaiduWallet() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2001351, new IntentConfig(getPageContext().getPageActivity())));
    }

    private void refreshNew() {
        this.mView.k().i();
    }

    @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
    public void OnSwitchStateChange(View view, BdSwitchView.SwitchState switchState) {
        if (view == null) {
            return;
        }
        if (view.equals(this.mView.i())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.mModel.D(true);
            } else {
                this.mModel.D(false);
            }
        } else if (view == this.mView.l()) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                d.a.n0.r.d0.b.j().t("prefs_save_paled_video", true);
            } else {
                d.a.n0.r.d0.b.j().t("prefs_save_paled_video", false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mView.onChangeSkinType(i2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar = this.mView;
        if (hVar == null) {
            return;
        }
        if (view == hVar.e()) {
            if (this.mModel != null) {
                CyberPlayerManager.deleteVideoCache(null);
                if (TextUtils.isEmpty(this.mView.e().getTip())) {
                    showToast(R.string.no_cache_delete);
                } else {
                    this.mBdAlertDialog = new d.a.n0.r.s.a(getPageContext().getPageActivity()).setMessageId(R.string.alert_clear_all_cache).setPositiveButton(R.string.alert_yes_button, new d()).setNegativeButton(R.string.cancel, new c()).create(getPageContext()).show();
                }
            }
        } else if (view == this.mView.f()) {
            if (this.mModel == null) {
                return;
            }
            this.mBdAlertDialog = new d.a.n0.r.s.a(getPageContext().getPageActivity()).setMessageId(R.string.alert_clear_cache).setPositiveButton(R.string.alert_yes_button, new f()).setNegativeButton(R.string.cancel, new e()).create(getPageContext()).show();
        } else if (view == this.mView.k()) {
            sendMessage(new CustomMessage(2002001, new PluginCenterActivityConfig(getPageContext().getPageActivity())));
        } else if (view == this.mView.h() && TbadkCoreApplication.getInst().isMainProcess(false)) {
            MessageManager.getInstance().runTask(2921514, null, null);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mView = new h(this);
        this.mModel = new SystemHelpSettingModel(this);
        if (TbadkCoreApplication.getInst().isHeadsetModeOn()) {
            this.mView.i().i();
        } else {
            this.mView.i().f();
        }
        if (d.a.n0.r.d0.b.j().g("prefs_save_paled_video", true)) {
            this.mView.l().i();
        } else {
            this.mView.l().f();
        }
        this.mView.e().setTip(getPageContext().getString(R.string.calc_cache_size));
        this.mView.e().b();
        this.mModel.E(new a());
        registerListener(new b(2008016));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        d.a.n0.r.s.a aVar = this.mBdAlertDialog;
        if (aVar != null && aVar.isShowing()) {
            this.mBdAlertDialog.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        SystemHelpSettingModel systemHelpSettingModel = this.mModel;
        if (systemHelpSettingModel != null) {
            systemHelpSettingModel.C();
        }
        refreshNew();
    }
}
