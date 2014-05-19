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
import com.baidu.tieba.plugins.PluginCenterActivity;
/* loaded from: classes.dex */
public class SystemHelpSettingActivity extends BaseActivity implements com.baidu.adp.widget.BdSwitchView.c {
    private an a = null;
    private aj b = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new an(this);
        this.b = new aj(this);
        if (TbadkApplication.m252getInst().isHeadsetModeOn()) {
            this.a.b().a();
        } else {
            this.a.b().b();
        }
        if (TbadkApplication.m252getInst().getLocationShared()) {
            this.a.a().a();
        } else {
            this.a.a().b();
        }
        this.a.c().setTip(getString(com.baidu.tieba.u.calc_cache_size));
        this.a.c().b();
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
        this.a.e().a();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.c()) {
            if (this.b != null) {
                if (TextUtils.isEmpty(this.a.c().getTip())) {
                    showToast(com.baidu.tieba.u.no_cache_delete);
                } else {
                    new AlertDialog.Builder(this).setTitle(com.baidu.tieba.u.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.u.alert_clear_all_cache).setPositiveButton(com.baidu.tieba.u.alert_yes_button, new af(this)).setNegativeButton(com.baidu.tieba.u.alert_no_button, new ag(this)).create().show();
                }
            }
        } else if (view == this.a.d()) {
            new AlertDialog.Builder(this).setTitle(com.baidu.tieba.u.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.u.alert_clear_cache).setPositiveButton(com.baidu.tieba.u.alert_yes_button, new ah(this)).setNegativeButton(com.baidu.tieba.u.alert_no_button, new ai(this)).create().show();
        } else if (view == this.a.e()) {
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
            if (view.equals(this.a.b())) {
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
            }
        }
    }
}
