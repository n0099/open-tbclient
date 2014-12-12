package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SystemHelpSettingActivityConfig;
import com.baidu.tbadk.core.message.Hao123UpdateInitMessage;
import com.baidu.tbadk.plugins.Hao123Plugin;
import com.baidu.tieba.plugins.PluginCenterActivity;
/* loaded from: classes.dex */
public class SystemHelpSettingActivity extends BaseActivity<SystemHelpSettingActivity> implements com.baidu.adp.widget.BdSwitchView.c {
    private aw bwr = null;
    private at bws = null;
    private boolean bwt;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(SystemHelpSettingActivityConfig.class, SystemHelpSettingActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bwr = new aw(this);
        this.bws = new at(this);
        if (TbadkCoreApplication.m255getInst().isHeadsetModeOn()) {
            this.bwr.VS().iK();
        } else {
            this.bwr.VS().iL();
        }
        if (!TbadkCoreApplication.m255getInst().isHao123HelperShouldOpen()) {
            this.bwr.VR().setVisibility(8);
        }
        this.bwr.VT().setTip(getPageContext().getString(com.baidu.tieba.z.calc_cache_size));
        this.bwr.VT().tE();
        this.bws.a(new an(this, this));
        registerListener(new ao(this, 2008016));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bws != null) {
            this.bws.VP();
        }
        if (TbadkCoreApplication.m255getInst().isTiebaHelperOpen()) {
            this.bwr.VQ().iK();
        } else {
            this.bwr.VQ().iL();
        }
        Uu();
        if (((Hao123Plugin) PluginCenter.gX().hc()) == null) {
            this.bwr.VQ().iL();
            TbadkCoreApplication.m255getInst().setTiebaHelperOpen(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bwr.onChangeSkinType(i);
    }

    private void Uu() {
        this.bwr.VV().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bwr.VT()) {
            if (this.bws != null) {
                if (TextUtils.isEmpty(this.bwr.VT().getTip())) {
                    showToast(com.baidu.tieba.z.no_cache_delete);
                } else {
                    new AlertDialog.Builder(getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.z.alert_clear_all_cache).setPositiveButton(com.baidu.tieba.z.alert_yes_button, new ap(this)).setNegativeButton(com.baidu.tieba.z.alert_no_button, new aq(this)).create().show();
                }
            }
        } else if (view == this.bwr.VU()) {
            new AlertDialog.Builder(getPageContext().getPageActivity()).setTitle(com.baidu.tieba.z.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.z.alert_clear_cache).setPositiveButton(com.baidu.tieba.z.alert_yes_button, new ar(this)).setNegativeButton(com.baidu.tieba.z.alert_no_button, new as(this)).create().show();
        } else if (view == this.bwr.VV()) {
            startActivity(new Intent(getPageContext().getPageActivity(), PluginCenterActivity.class));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.bwr.VS())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.bws.setHeadsetModeOn(true);
                } else {
                    this.bws.setHeadsetModeOn(false);
                }
            } else if (view.equals(this.bwr.VQ())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    TbadkCoreApplication.m255getInst().setTiebaHelperOpen(true);
                    Hao123Plugin hao123Plugin = (Hao123Plugin) PluginCenter.gX().hc();
                    if (hao123Plugin != null) {
                        hao123Plugin.openFloating(getPageContext().getPageActivity());
                    }
                    if (TbadkCoreApplication.isLogin() && !this.bwt) {
                        this.bwt = true;
                        MessageManager.getInstance().dispatchResponsedMessage(new Hao123UpdateInitMessage());
                    }
                    com.baidu.tbadk.core.i.B(getPageContext().getPageActivity(), "tb_zs_setting");
                    return;
                }
                TbadkCoreApplication.m255getInst().setTiebaHelperOpen(false);
                Hao123Plugin hao123Plugin2 = (Hao123Plugin) PluginCenter.gX().hc();
                if (hao123Plugin2 != null) {
                    hao123Plugin2.closeFloating(getPageContext().getPageActivity());
                }
            }
        }
    }
}
