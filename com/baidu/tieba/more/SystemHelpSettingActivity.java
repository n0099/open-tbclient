package com.baidu.tieba.more;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class SystemHelpSettingActivity extends com.baidu.tieba.j implements com.baidu.adp.widget.BdSwitchView.c {

    /* renamed from: a  reason: collision with root package name */
    private ax f2061a = null;
    private at b = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2061a = new ax(this);
        this.b = new at();
        if (TiebaApplication.h().ak()) {
            this.f2061a.a().a();
        } else {
            this.f2061a.a().b();
        }
        this.b.setLoadDataCallBack(new ao(this));
    }

    public static void a(Context context) {
        context.startActivity(new Intent(context, SystemHelpSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f2061a.a(i);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f2061a.e()) {
            if (this.b != null) {
                new AlertDialog.Builder(this).setTitle(R.string.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(R.string.alert_clear_all_cache).setPositiveButton(R.string.alert_yes_button, new aq(this)).setNegativeButton(R.string.alert_no_button, new ap(this)).create().show();
            }
        } else if (view == this.f2061a.f()) {
            new AlertDialog.Builder(this).setTitle(R.string.alerm_title).setIcon((Drawable) null).setCancelable(false).setMessage(R.string.alert_clear_cache).setPositiveButton(R.string.alert_yes_button, new as(this)).setNegativeButton(R.string.alert_no_button, new ar(this)).create().show();
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view != null && view.equals(this.f2061a.a())) {
            if (BdSwitchView.SwitchState.ON == switchState) {
                this.b.a(true);
            } else {
                this.b.a(false);
            }
        }
    }
}
