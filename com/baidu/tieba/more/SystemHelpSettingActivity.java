package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginHelper;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.Hao123Plugin;
import com.baidu.tieba.plugins.PluginCenterActivity;
/* loaded from: classes.dex */
public class SystemHelpSettingActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c {
    private ay bsG = null;
    private av bsH = null;
    private boolean bsI;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bsG = new ay(this);
        this.bsH = new av(this);
        if (TbadkApplication.m251getInst().isHeadsetModeOn()) {
            this.bsG.VA().gN();
        } else {
            this.bsG.VA().gO();
        }
        if (!TbadkApplication.m251getInst().isHao123HelperShouldOpen()) {
            this.bsG.Vz().setVisibility(8);
        }
        this.bsG.VB().setTip(getString(com.baidu.tieba.y.calc_cache_size));
        this.bsG.VB().qj();
        this.bsH.a(new ao(this, this));
        registerListener(new ap(this, 2008016));
    }

    public static void ae(Context context) {
        context.startActivity(new Intent(context, SystemHelpSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bsH != null) {
            this.bsH.Vx();
        }
        if (TbadkApplication.m251getInst().isTiebaHelperOpen()) {
            this.bsG.Vy().gN();
        } else {
            this.bsG.Vy().gO();
        }
        Ud();
        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_HAO123);
        if (pluginByName != null && !pluginByName.checkEnable()) {
            this.bsG.Vy().gO();
            TbadkApplication.m251getInst().setTiebaHelperOpen(false);
            Hao123Plugin hao123Plugin = (Hao123Plugin) pluginByName.getClassInstance(Hao123Plugin.class);
            if (hao123Plugin != null) {
                hao123Plugin.closeFloating(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bsG.onChangeSkinType(i);
    }

    private void Ud() {
        this.bsG.VD().refresh();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bsG.VB()) {
            if (this.bsH != null) {
                if (TextUtils.isEmpty(this.bsG.VB().getTip())) {
                    showToast(com.baidu.tieba.y.no_cache_delete);
                } else {
                    new AlertDialog.Builder(this).setTitle(com.baidu.tieba.y.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.y.alert_clear_all_cache).setPositiveButton(com.baidu.tieba.y.alert_yes_button, new aq(this)).setNegativeButton(com.baidu.tieba.y.alert_no_button, new ar(this)).create().show();
                }
            }
        } else if (view == this.bsG.VC()) {
            new AlertDialog.Builder(this).setTitle(com.baidu.tieba.y.alert_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.y.alert_clear_cache).setPositiveButton(com.baidu.tieba.y.alert_yes_button, new as(this)).setNegativeButton(com.baidu.tieba.y.alert_no_button, new at(this)).create().show();
        } else if (view == this.bsG.VD()) {
            startActivity(new Intent(this, PluginCenterActivity.class));
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        Hao123Plugin hao123Plugin;
        Hao123Plugin hao123Plugin2;
        Hao123Plugin hao123Plugin3;
        if (view != null) {
            if (view.equals(this.bsG.VA())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.bsH.setHeadsetModeOn(true);
                } else {
                    this.bsH.setHeadsetModeOn(false);
                }
            } else if (view.equals(this.bsG.Vy())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    if (!PluginHelper.isHao123CanUse(this)) {
                        this.bsG.Vy().gO();
                        Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_HAO123);
                        TbadkApplication.m251getInst().setTiebaHelperOpen(false);
                        if (pluginByName != null && (hao123Plugin3 = (Hao123Plugin) pluginByName.getClassInstance(Hao123Plugin.class)) != null) {
                            hao123Plugin3.closeFloating(this);
                            return;
                        }
                        return;
                    }
                    TbadkApplication.m251getInst().setTiebaHelperOpen(true);
                    Plugin pluginByName2 = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_HAO123);
                    if (pluginByName2 != null && (hao123Plugin2 = (Hao123Plugin) pluginByName2.getClassInstance(Hao123Plugin.class)) != null) {
                        hao123Plugin2.openFloating(this);
                    }
                    if (TbadkApplication.isLogin() && !this.bsI) {
                        this.bsI = true;
                        new au(this, null).execute(new Void[0]);
                    }
                    com.baidu.tbadk.core.i.l(this, "tb_zs_setting");
                    return;
                }
                TbadkApplication.m251getInst().setTiebaHelperOpen(false);
                Plugin pluginByName3 = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_HAO123);
                if (pluginByName3 != null && pluginByName3.checkEnable() && (hao123Plugin = (Hao123Plugin) pluginByName3.getClassInstance(Hao123Plugin.class)) != null) {
                    hao123Plugin.closeFloating(this);
                }
            }
        }
    }
}
