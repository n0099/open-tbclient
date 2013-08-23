package com.baidu.tieba.more;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.model.MoreModel;
import com.baidu.tieba.person.PersonChangeActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.NetWorkCore;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MoreActivity extends com.baidu.tieba.g implements com.baidu.adp.widget.BdSwitchView.c {

    /* renamed from: a  reason: collision with root package name */
    private aa f1428a = null;
    private MoreModel b = null;
    private z c = null;

    public static void a(com.baidu.tieba.g gVar, int i, PersonChangeData personChangeData) {
        Intent intent = new Intent(gVar, MoreActivity.class);
        intent.putExtra("person_change_data", personChangeData);
        gVar.startActivityForResult(intent, i);
    }

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, MoreActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        b();
        k();
    }

    public void b() {
        this.f1428a = new aa(this);
        this.f1428a.q();
    }

    public void a(Bundle bundle) {
        PersonChangeData personChangeData;
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("person_change_data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("person_change_data");
        }
        this.b = new MoreModel(personChangeData);
        this.b.setLoadDataCallBack(new y(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f1428a.E();
        l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f1428a.x();
        this.f1428a.y();
        if (TiebaApplication.p()) {
            if (TiebaApplication.E() == null || TiebaApplication.I() == null || TiebaApplication.I().equals("BaiduUser")) {
                this.f1428a.u();
            } else {
                this.f1428a.t();
            }
            this.f1428a.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        this.f1428a.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void i() {
        d(-1);
        this.f1428a.D();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("person_change_data", this.b.c());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view == this.f1428a.c()) {
            if (TiebaApplication.p()) {
                com.baidu.tieba.c.a(this, 0, 4, false);
                return;
            }
            String E = TiebaApplication.E();
            if ((E == null || E.length() <= 0) && DatabaseService.m() <= 0) {
                LoginActivity.a(this, 1, getString(R.string.login_manage_account), 11003);
            } else {
                AccountActivity.a(this);
            }
        } else if (view == this.f1428a.e()) {
            String E2 = TiebaApplication.E();
            if (E2 == null || E2.length() <= 0) {
                LoginActivity.a(this, 4, getString(R.string.login_to_use), 11003);
            } else {
                MsgRemindActivity.a(this);
            }
        } else if (view == this.f1428a.f()) {
            SignRemindActivity.a(this);
        } else if (view == this.f1428a.g()) {
            BrowseSettingActivity.a(this);
        } else if (view == this.f1428a.h()) {
            this.f1428a.r();
            this.b.b();
        } else if (view == this.f1428a.i()) {
            AboutActivity.a(this);
        } else if (view == this.f1428a.j()) {
            d();
        } else if (view == this.f1428a.k()) {
            String str2 = com.baidu.tieba.data.g.g;
            if (str2.indexOf("?") < 0) {
                str2 = String.valueOf(str2) + "?";
            } else if (!str2.endsWith("?") && !str2.endsWith("&")) {
                str2 = String.valueOf(str2) + "&";
            }
            if (TiebaApplication.g().an() == 1) {
                str = String.valueOf(str2) + "night_type=1";
            } else {
                str = String.valueOf(str2) + "night_type=0";
            }
            AppsActivity.a(this, str);
        } else if (view == this.f1428a.d()) {
            String E3 = TiebaApplication.E();
            if (E3 != null && E3.length() > 0) {
                PersonChangeActivity.a(this, WebChromeClient.STRING_DLG_TITLE_DATETIME, this.b.c(), false);
            }
        } else if (view == this.f1428a.b()) {
            c();
            finish();
        } else {
            super.onClick(view);
        }
    }

    @Override // com.baidu.tieba.g, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            c();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void c() {
        if (this.b.a()) {
            Intent intent = new Intent();
            intent.putExtra("person_change_data", this.b.c());
            setResult(-1, intent);
        }
    }

    private void d() {
        String E = TiebaApplication.E();
        if (E == null || E.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_feedback), true, 12008);
            return;
        }
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        WriteActivity.a(this, com.baidu.tieba.data.g.h(), com.baidu.tieba.data.g.g(), antiData);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case WebChromeClient.STRING_DLG_TITLE_DATETIME /* 101 */:
                    this.b.a((PersonChangeData) intent.getSerializableExtra("data"));
                    this.b.a(true);
                    return;
                case 12008:
                    d();
                    return;
                default:
                    return;
            }
        }
    }

    private void k() {
        this.c = new z(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.newversion");
        registerReceiver(this.c, intentFilter);
    }

    private void l() {
        if (this.c != null) {
            unregisterReceiver(this.c);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.f1428a.l()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().r(true);
            } else {
                TiebaApplication.g().r(false);
            }
        } else if (view == this.f1428a.m()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TiebaApplication.g().an() != 1) {
                    TiebaApplication.g().g(1);
                    this.i = 1;
                    a(this.i);
                    new com.baidu.tieba.account.ag("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.g().an() != 0) {
                TiebaApplication.g().g(0);
                this.i = 0;
                a(this.i);
            } else {
                return;
            }
            com.baidu.tieba.util.e.a();
        } else if (view == this.f1428a.n()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().d(true);
            } else {
                TiebaApplication.g().d(false);
            }
        } else if (view == this.f1428a.o()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.g().j(true);
            } else {
                TiebaApplication.g().j(false);
            }
        } else if (view == this.f1428a.p()) {
            boolean z = NetWorkCore.b(this) == NetWorkCore.NetworkState.WIFI;
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (!TiebaApplication.g().aR()) {
                    TiebaApplication.g().a(true, z);
                }
            } else if (TiebaApplication.g().aR()) {
                TiebaApplication.g().a(false, z);
            }
        }
    }
}
