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
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SystemHelpSettingActivity extends com.baidu.tieba.f implements com.baidu.adp.widget.BdSwitchView.c {
    private ay a = null;
    private au b = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new ay(this);
        this.b = new au(this);
        if (TiebaApplication.g().ai()) {
            this.a.e().a();
        } else {
            this.a.e().b();
        }
        if (TiebaApplication.g().bd()) {
            this.a.a().a();
        } else {
            this.a.a().b();
        }
        this.a.f().setTip(getString(R.string.calc_cache_size));
        this.a.f().b();
        this.b.a(new ap(this, this));
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, SystemHelpSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.b != null) {
            this.b.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.f()) {
            if (this.b != null) {
                if (TextUtils.isEmpty(this.a.f().getTip())) {
                    showToast(R.string.no_cache_delete);
                } else {
                    new AlertDialog.Builder(this).setTitle(R.string.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(R.string.alert_clear_all_cache).setPositiveButton(R.string.alert_yes_button, new aq(this)).setNegativeButton(R.string.alert_no_button, new ar(this)).create().show();
                }
            }
        } else if (view == this.a.g()) {
            new AlertDialog.Builder(this).setTitle(R.string.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(R.string.alert_clear_cache).setPositiveButton(R.string.alert_yes_button, new as(this)).setNegativeButton(R.string.alert_no_button, new at(this)).create().show();
        }
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.a.e())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    this.b.a(true);
                } else {
                    this.b.a(false);
                }
            } else if (view.equals(this.a.a())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    TiebaApplication.g().z(true);
                } else {
                    TiebaApplication.g().z(false);
                }
            }
        }
    }
}
