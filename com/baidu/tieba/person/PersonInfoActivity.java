package com.baidu.tieba.person;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.account.Register2Activity;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.zeus.WebChromeClient;
/* loaded from: classes.dex */
public class PersonInfoActivity extends com.baidu.tieba.e {
    ba c = null;
    private com.baidu.tieba.c.bf d = null;
    private BroadcastReceiver e = null;

    public static void a(Context context, String str, String str2) {
        a(context, str, str2, false);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (str != null && str.length() > 0 && !str.equals("0")) {
            Intent intent = new Intent(context, PersonInfoActivity.class);
            intent.putExtra("un", str);
            intent.putExtra("name", str2);
            if (TiebaApplication.z() != null && TiebaApplication.z().equals(str)) {
                intent.putExtra("self", true);
            } else {
                intent.putExtra("self", false);
            }
            intent.putExtra("tab_page", false);
            if (z) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        c();
        if (this.d.d() != null && this.d.d().length() > 0 && this.d.e()) {
            d();
        }
        com.baidu.tieba.d.k.b((Boolean) true);
        if (this.d.d() != null && this.d.d().length() > 0) {
            b();
        }
    }

    private void c() {
        this.c = new ba(this, this.d);
        this.c.a(new ax(this));
    }

    private void d() {
        if (this.e == null) {
            this.e = new ay(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.broadcast.notify");
            registerReceiver(this.e, intentFilter);
        }
    }

    private void a(Bundle bundle) {
        this.d = new com.baidu.tieba.c.bf(this);
        if (bundle != null) {
            this.d.a(bundle.getBoolean("self", true));
            this.d.b(bundle.getString("un"));
            this.d.c(bundle.getString("name"));
            this.d.b(bundle.getBoolean("tab_page", false));
            this.d.c(bundle.getBoolean("tab_msg", false));
        } else {
            Intent intent = getIntent();
            this.d.a(intent.getBooleanExtra("self", true));
            this.d.b(intent.getStringExtra("un"));
            this.d.c(intent.getStringExtra("name"));
            this.d.b(intent.getBooleanExtra("tab_page", false));
            this.d.c(intent.getBooleanExtra("tab_msg", false));
        }
        this.d.a(new az(this));
    }

    public void b() {
        this.c.e(this.d);
        if (this.d.e()) {
            this.d.a(true, true);
        } else {
            this.d.a(false, true);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("self", this.d.e());
        bundle.putString("un", this.d.d());
        bundle.putString("name", this.d.i());
        bundle.putBoolean("tab_page", this.d.n());
        bundle.putBoolean("tab_msg", this.d.o());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        boolean z = false;
        super.onResume();
        if (this.d.d() == null || this.d.d().length() <= 0) {
            if (TiebaApplication.z() != null) {
                this.d.a(true);
                this.d.b(TiebaApplication.z());
                this.d.c(TiebaApplication.D());
                d();
                b();
                this.c.a(true);
                return;
            }
            this.c.a(false);
        } else if (this.d.e()) {
            if (TiebaApplication.d().ab() != this.d.j()) {
                this.d.a(TiebaApplication.d().ab());
                z = true;
            }
            if (TiebaApplication.d().Z() != this.d.m()) {
                this.d.c(TiebaApplication.d().Z());
                z = true;
            }
            if (TiebaApplication.d().aa() != this.d.k()) {
                this.d.b(TiebaApplication.d().aa());
                z = true;
            }
            if (z) {
                this.c.a(this.d);
            }
            this.c.a(true);
        } else {
            this.c.a(false);
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
        super.k();
        a_(-1);
        this.c.a();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.c.d()) {
            finish();
        } else if (view == this.c.e()) {
            String z = TiebaApplication.z();
            if ((z != null && z.length() > 0) || TiebaApplication.d().aj() >= 3) {
                MainTabActivity.a(this, "goto_home");
            } else {
                MainTabActivity.a(this, "goto_recommend");
            }
        } else if (view == this.c.f()) {
            this.c.f(this.d);
            this.d.g();
        } else if (view == this.c.g()) {
            com.baidu.tieba.a.an anVar = new com.baidu.tieba.a.an();
            if (this.d.f() != null) {
                anVar.b(this.d.f().d());
                anVar.a(this.d.f().h());
                anVar.a(this.d.f().i());
                anVar.c(this.d.f().e());
            }
            MoreActivity.a(this, WebChromeClient.STRING_DLG_TITLE_DATETIME, anVar);
        } else if (view == this.c.h()) {
            if (this.d.e()) {
                new com.baidu.tieba.account.af("mention").start();
                MentionActivity.a(this, (int) WebChromeClient.STRING_DLG_TITLE_TIME);
            }
        } else if (view == this.c.i()) {
            if (this.d.e()) {
                if (TiebaApplication.d().n()) {
                    StatService.onEvent(this, "personal_my_collect", "personclick", 1);
                }
                EditMarkActivity.a(this, (int) WebChromeClient.STRING_DLG_TITLE_WEEK);
            }
        } else if (view == this.c.j()) {
            if (this.d.e()) {
                new com.baidu.tieba.account.af("tb_mytieba").start();
                EditBarActivity.a(this, 103, null);
            } else if (this.d.f() != null) {
                EditBarActivity.a(this, 103, this.d.f().a());
            }
        } else if (view == this.c.k()) {
            if (this.d.e()) {
                PersonListActivity.a(this, true, TiebaApplication.z());
            } else if (this.d.f() != null) {
                PersonListActivity.a(this, true, this.d.f().a());
            }
        } else if (view == this.c.l()) {
            if (this.d.e()) {
                PersonListActivity.a(this, false, TiebaApplication.z());
            } else if (this.d.f() != null) {
                PersonListActivity.a(this, false, this.d.f().a());
            }
        } else if (view == this.c.m()) {
            if (this.d.e()) {
                startActivity(new Intent(this, MyPostActivity.class));
            }
        } else if (view == this.c.n()) {
            if (TiebaApplication.d().n()) {
                StatService.onEvent(this, "personal_lbs_post", "personclick", 1);
            }
            PersonLbsActivity.a(this, this.d.d());
        } else if (view == this.c.o()) {
            LoginActivity.a((Activity) this, (String) null, true, 1100003);
        } else if (view == this.c.p()) {
            Register2Activity.a(this, 1200007);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.d.d() != null && this.d.d().length() > 0 && this.d.e() && this.e != null) {
            unregisterReceiver(this.e);
        }
        this.d.p();
        this.c.c();
        com.baidu.tieba.d.k.b((Boolean) true);
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                a(intent);
            } else if ((i == 1100003 || i == 1200007) && TiebaApplication.z() != null) {
                this.d.a(true);
                this.d.b(TiebaApplication.z());
                this.d.c(TiebaApplication.D());
                d();
                b();
            }
        }
    }

    private void a(Intent intent) {
        com.baidu.tieba.a.an anVar = (com.baidu.tieba.a.an) intent.getSerializableExtra("person_change_data");
        if (anVar != null && this.d.f() != null) {
            this.d.a(anVar);
            this.c.a(this.d);
            if (anVar.d()) {
                this.c.b();
                if (this.d.f() != null) {
                    this.d.h().d(this.d.f().e());
                }
                this.d.a(false, false);
            }
        }
    }
}
