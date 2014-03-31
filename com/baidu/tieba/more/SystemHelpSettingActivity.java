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
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class SystemHelpSettingActivity extends com.baidu.tbadk.a implements com.baidu.adp.widget.BdSwitchView.c {
    private an a = null;
    private aj b = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = new an(this);
        this.b = new aj(this);
        if (TbadkApplication.j().V()) {
            this.a.d().a();
        } else {
            this.a.d().b();
        }
        TbadkApplication.j();
        if (TbadkApplication.X()) {
            this.a.a().a();
        } else {
            this.a.a().b();
        }
        this.a.e().setTip(getString(com.baidu.tieba.a.k.calc_cache_size));
        this.a.e().a();
        this.b.a(new ae(this, this));
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, SystemHelpSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.b != null) {
            this.b.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.a.a(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.a.e()) {
            if (this.b != null) {
                if (TextUtils.isEmpty(this.a.e().getTip())) {
                    showToast(com.baidu.tieba.a.k.no_cache_delete);
                } else {
                    new AlertDialog.Builder(this).setTitle(com.baidu.tieba.a.k.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.a.k.alert_clear_all_cache).setPositiveButton(com.baidu.tieba.a.k.alert_yes_button, new af(this)).setNegativeButton(com.baidu.tieba.a.k.alert_no_button, new ag(this)).create().show();
                }
            }
        } else if (view == this.a.f()) {
            new AlertDialog.Builder(this).setTitle(com.baidu.tieba.a.k.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(com.baidu.tieba.a.k.alert_clear_cache).setPositiveButton(com.baidu.tieba.a.k.alert_yes_button, new ah(this)).setNegativeButton(com.baidu.tieba.a.k.alert_no_button, new ai(this)).create().show();
        }
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public final void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null) {
            if (view.equals(this.a.d())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    aj ajVar = this.b;
                    TbadkApplication.j().d(true);
                    return;
                }
                aj ajVar2 = this.b;
                TbadkApplication.j().d(false);
            } else if (view.equals(this.a.a())) {
                if (BdSwitchView.SwitchState.ON == switchState) {
                    TbadkApplication.j();
                    TbadkApplication.e(true);
                    return;
                }
                TbadkApplication.j();
                TbadkApplication.e(false);
            }
        }
    }
}
