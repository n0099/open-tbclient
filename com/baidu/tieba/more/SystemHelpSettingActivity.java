package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.plugins.Hao123Plugin;
import com.baidu.tieba.plugins.PluginCenterActivity;
/* loaded from: classes.dex */
public class SystemHelpSettingActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c {
    private an a = null;
    private aj b = null;
    private boolean c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new an(this);
        this.b = new aj(this);
        if (TbadkApplication.m252getInst().isHeadsetModeOn()) {
            this.a.d().a();
        } else {
            this.a.d().b();
        }
        if (TbadkApplication.m252getInst().getLocationShared()) {
            this.a.a().a();
        } else {
            this.a.a().b();
        }
        if (!TbadkApplication.m252getInst().isHao123HelperShouldOpen()) {
            this.a.c().setVisibility(8);
        }
        if (TbadkApplication.m252getInst().isTiebaHelperOpen()) {
            this.a.b().a();
        } else {
            this.a.b().b();
        }
        this.a.e().setTip(getString(com.baidu.tieba.y.calc_cache_size));
        this.a.e().b();
        this.b.a(new ae(this, this));
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, SystemHelpSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.b != null) {
            this.b.c();
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    private void a() {
        this.a.g().a();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.e()) {
            if (this.b != null) {
                if (TextUtils.isEmpty(this.a.e().getTip())) {
                    showToast(com.baidu.tieba.y.no_cache_delete);
                } else {
                    new AlertDialog.Builder(this).setTitle(com.baidu.tieba.y.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.y.alert_clear_all_cache).setPositiveButton(com.baidu.tieba.y.alert_yes_button, new af(this)).setNegativeButton(com.baidu.tieba.y.alert_no_button, new ag(this)).create().show();
                }
            }
        } else if (view == this.a.f()) {
            new AlertDialog.Builder(this).setTitle(com.baidu.tieba.y.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.y.alert_clear_cache).setPositiveButton(com.baidu.tieba.y.alert_yes_button, new ah(this)).setNegativeButton(com.baidu.tieba.y.alert_no_button, new ai(this)).create().show();
        } else if (view == this.a.g()) {
            startActivity(new Intent(this, PluginCenterActivity.class));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.a.d())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.b.a(true);
                } else {
                    this.b.a(false);
                }
            } else if (view.equals(this.a.a())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    TbadkApplication.m252getInst().setLocationShared(true);
                } else {
                    TbadkApplication.m252getInst().setLocationShared(false);
                }
            } else if (view.equals(this.a.b())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    TbadkApplication.m252getInst().setTiebaHelperOpen(true);
                    Hao123Plugin hao123Plugin = (Hao123Plugin) com.baidu.tbadk.tbplugin.m.a().b(Hao123Plugin.class);
                    if (hao123Plugin != null) {
                        hao123Plugin.openFloating(this);
                    }
                    if (TbadkApplication.isLogin() && !this.c) {
                        this.c = true;
                        new com.baidu.tieba.model.o().a(true);
                    }
                    com.baidu.tbadk.core.f.a(this, "tb_zs_setting");
                    return;
                }
                TbadkApplication.m252getInst().setTiebaHelperOpen(false);
                Hao123Plugin hao123Plugin2 = (Hao123Plugin) com.baidu.tbadk.tbplugin.m.a().b(Hao123Plugin.class);
                if (hao123Plugin2 != null) {
                    hao123Plugin2.closeFloating(this);
                }
            }
        }
    }
}
