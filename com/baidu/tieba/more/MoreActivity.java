package com.baidu.tieba.more;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
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
    private aa f1393a = null;
    private MoreModel b = null;
    private z c = null;

    public static void a(com.baidu.tieba.g gVar, int i, PersonChangeData personChangeData) {
        Intent intent = new Intent(gVar, MoreActivity.class);
        intent.putExtra("person_change_data", personChangeData);
        gVar.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        b();
        d();
    }

    public void b() {
        this.f1393a = new aa(this);
        this.f1393a.q();
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
        this.f1393a.E();
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f1393a.x();
        this.f1393a.y();
        if (TiebaApplication.n()) {
            if (TiebaApplication.E() == null || TiebaApplication.I() == null || TiebaApplication.I().equals("BaiduUser")) {
                this.f1393a.u();
            } else {
                this.f1393a.t();
            }
            this.f1393a.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        this.f1393a.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void i() {
        d(-1);
        this.f1393a.D();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("person_change_data", this.b.c());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view == this.f1393a.c()) {
            if (TiebaApplication.n()) {
                com.baidu.tieba.c.a(this, 0, "goto_person", false);
                return;
            }
            String E = TiebaApplication.E();
            if ((E == null || E.length() <= 0) && DatabaseService.o() <= 0) {
                LoginActivity.a(this, "goto_person", getString(R.string.login_manage_account), 11003);
            } else {
                AccountActivity.a(this);
            }
        } else if (view == this.f1393a.e()) {
            String E2 = TiebaApplication.E();
            if (E2 == null || E2.length() <= 0) {
                LoginActivity.a(this, "goto_person", getString(R.string.login_to_use), 11003);
            } else {
                MsgRemindActivity.a(this);
            }
        } else if (view == this.f1393a.f()) {
            SignRemindActivity.a(this);
        } else if (view == this.f1393a.g()) {
            BrowseSettingActivity.a(this);
        } else if (view == this.f1393a.h()) {
            this.f1393a.r();
            this.b.b();
        } else if (view == this.f1393a.i()) {
            AboutActivity.a(this);
        } else if (view == this.f1393a.j()) {
            c();
        } else if (view == this.f1393a.k()) {
            String str2 = com.baidu.tieba.data.g.g;
            if (str2.indexOf("?") < 0) {
                str2 = String.valueOf(str2) + "?";
            } else if (!str2.endsWith("?") && !str2.endsWith("&")) {
                str2 = String.valueOf(str2) + "&";
            }
            if (TiebaApplication.f().au() == 1) {
                str = String.valueOf(str2) + "night_type=1";
            } else {
                str = String.valueOf(str2) + "night_type=0";
            }
            AppsActivity.a(this, str);
        } else if (view == this.f1393a.d()) {
            String E3 = TiebaApplication.E();
            if (E3 != null && E3.length() > 0) {
                PersonChangeActivity.a(this, WebChromeClient.STRING_DLG_TITLE_DATETIME, this.b.c());
            }
        } else if (view == this.f1393a.b()) {
            if (this.b.a()) {
                Intent intent = new Intent();
                intent.putExtra("person_change_data", this.b.c());
                setResult(-1, intent);
            }
            finish();
        } else {
            super.onClick(view);
        }
    }

    private void c() {
        String E = TiebaApplication.E();
        if (E == null || E.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_feedback), true, 12008);
            return;
        }
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        WriteActivity.a(this, com.baidu.tieba.data.g.g(), com.baidu.tieba.data.g.f(), antiData);
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
                    c();
                    return;
                default:
                    return;
            }
        }
    }

    private void d() {
        this.c = new z(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.newversion");
        registerReceiver(this.c, intentFilter);
    }

    private void k() {
        if (this.c != null) {
            unregisterReceiver(this.c);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, BdSwitchView.SwitchState switchState) {
        if (view == this.f1393a.l()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.f().s(true);
            } else {
                TiebaApplication.f().s(false);
            }
        } else if (view == this.f1393a.m()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                if (TiebaApplication.f().au() != 1) {
                    TiebaApplication.f().h(1);
                    this.i = 1;
                    a(this.i);
                    new com.baidu.tieba.account.ag("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.f().au() != 0) {
                TiebaApplication.f().h(0);
                this.i = 0;
                a(this.i);
            } else {
                return;
            }
            com.baidu.tieba.util.e.a();
        } else if (view == this.f1393a.n()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.f().d(true);
            } else {
                TiebaApplication.f().d(false);
            }
        } else if (view == this.f1393a.o()) {
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.f().k(true);
            } else {
                TiebaApplication.f().k(false);
            }
        } else if (view == this.f1393a.p()) {
            boolean z = NetWorkCore.a(this) == NetWorkCore.NetworkState.WIFI;
            if (switchState == BdSwitchView.SwitchState.ON) {
                TiebaApplication.f().a(true, z);
            } else {
                TiebaApplication.f().a(false, z);
            }
        }
    }
}
