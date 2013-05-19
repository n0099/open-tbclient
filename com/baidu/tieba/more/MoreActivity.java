package com.baidu.tieba.more;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.an;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.c.al;
import com.baidu.tieba.person.PersonChangeActivity;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class MoreActivity extends com.baidu.tieba.e implements com.baidu.adp.widget.BdSwitchView.c {
    private z c = null;
    private al d = null;
    private y e = null;

    public static void a(com.baidu.tieba.e eVar, int i, an anVar) {
        Intent intent = new Intent(eVar, MoreActivity.class);
        intent.putExtra("person_change_data", anVar);
        eVar.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        b();
        d();
    }

    public void b() {
        this.c = new z(this);
        this.c.n();
    }

    public void a(Bundle bundle) {
        an anVar;
        if (bundle != null) {
            anVar = (an) bundle.getSerializable("person_change_data");
        } else {
            anVar = (an) getIntent().getSerializableExtra("person_change_data");
        }
        this.d = new al(anVar);
        this.d.a(new x(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.c.z();
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.c.u();
        if (TiebaApplication.i()) {
            if (TiebaApplication.z() == null || TiebaApplication.D() == null || TiebaApplication.D().equals("BaiduUser")) {
                this.c.r();
            } else {
                this.c.q();
            }
            this.c.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        this.c.a(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void k() {
        a_(-1);
        this.c.y();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("person_change_data", this.d.f());
        super.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view == this.c.b()) {
            if (TiebaApplication.i()) {
                com.baidu.tieba.a.a(this, 0, "goto_person", false);
                return;
            }
            String z = TiebaApplication.z();
            if ((z == null || z.length() <= 0) && com.baidu.tieba.d.k.l() <= 0) {
                LoginActivity.a(this, "goto_person", getString(R.string.login_manage_account), 1100003);
            } else {
                AccountActivity.a(this);
            }
        } else if (view == this.c.d()) {
            String z2 = TiebaApplication.z();
            if (z2 == null || z2.length() <= 0) {
                LoginActivity.a(this, "goto_person", getString(R.string.login_to_use), 1100003);
            } else {
                MsgRemindActivity.a(this);
            }
        } else if (view == this.c.e()) {
            BrowseSettingActivity.a(this);
        } else if (view == this.c.f()) {
            this.c.o();
            this.d.e();
        } else if (view == this.c.g()) {
            AboutActivity.a(this);
        } else if (view == this.c.h()) {
            c();
        } else if (view == this.c.i()) {
            String str2 = com.baidu.tieba.a.i.f;
            if (str2.indexOf("?") < 0) {
                str2 = String.valueOf(str2) + "?";
            } else if (!str2.endsWith("?") && !str2.endsWith("&")) {
                str2 = String.valueOf(str2) + "&";
            }
            if (TiebaApplication.d().ai() == 1) {
                str = String.valueOf(str2) + "night_type=1";
            } else {
                str = String.valueOf(str2) + "night_type=0";
            }
            AppsActivity.a(this, str);
        } else if (view == this.c.c()) {
            String z3 = TiebaApplication.z();
            if (z3 != null && z3.length() > 0) {
                PersonChangeActivity.a(this, WebChromeClient.STRING_DLG_TITLE_DATETIME, this.d.f());
            }
        } else if (view == this.c.a()) {
            if (this.d.d()) {
                Intent intent = new Intent();
                intent.putExtra("person_change_data", this.d.f());
                setResult(-1, intent);
            }
            finish();
        } else {
            super.onClick(view);
        }
    }

    private void c() {
        String z = TiebaApplication.z();
        if (z == null || z.length() <= 0) {
            LoginActivity.a((Activity) this, getString(R.string.login_feedback), true, 1200008);
            return;
        }
        com.baidu.tieba.a.b bVar = new com.baidu.tieba.a.b();
        bVar.a(1);
        WriteActivity.a(this, com.baidu.tieba.a.i.f(), com.baidu.tieba.a.i.e(), bVar);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case WebChromeClient.STRING_DLG_TITLE_DATETIME /* 101 */:
                    this.d.a((an) intent.getSerializableExtra("data"));
                    this.d.a(true);
                    return;
                case 1200008:
                    c();
                    return;
                default:
                    return;
            }
        }
    }

    private void d() {
        this.e = new y(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.newversion");
        registerReceiver(this.e, intentFilter);
    }

    private void m() {
        if (this.e != null) {
            unregisterReceiver(this.e);
        }
    }

    @Override // com.baidu.adp.widget.BdSwitchView.c
    public void a(View view, com.baidu.adp.widget.BdSwitchView.d dVar) {
        if (view == this.c.j()) {
            if (dVar == com.baidu.adp.widget.BdSwitchView.d.ON) {
                TiebaApplication.d().p(true);
            } else {
                TiebaApplication.d().p(false);
            }
        } else if (view == this.c.k()) {
            if (dVar == com.baidu.adp.widget.BdSwitchView.d.ON) {
                if (TiebaApplication.d().ai() != 1) {
                    TiebaApplication.d().h(1);
                    this.b = 1;
                    b(this.b);
                    new com.baidu.tieba.account.af("eyeshield").start();
                } else {
                    return;
                }
            } else if (TiebaApplication.d().ai() != 0) {
                TiebaApplication.d().h(0);
                this.b = 0;
                b(this.b);
            } else {
                return;
            }
            com.baidu.tieba.d.e.a();
        } else if (view == this.c.l()) {
            if (dVar == com.baidu.adp.widget.BdSwitchView.d.ON) {
                TiebaApplication.d().d(true);
            } else {
                TiebaApplication.d().d(false);
            }
        } else if (view == this.c.m()) {
            if (dVar == com.baidu.adp.widget.BdSwitchView.d.ON) {
                TiebaApplication.d().i(true);
            } else {
                TiebaApplication.d().i(false);
            }
        }
    }
}
