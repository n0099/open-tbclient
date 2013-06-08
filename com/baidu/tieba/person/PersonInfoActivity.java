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
import com.baidu.tieba.chat.ChatActivity;
import com.baidu.tieba.chat.ChatListActivity;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonInfoActivity extends com.baidu.tieba.e {
    ba c = null;
    private com.baidu.tieba.c.bi d = null;
    private BroadcastReceiver e = null;
    private long f = 0;

    public static void a(Context context, String str, String str2) {
        a(context, str, str2, false);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (str != null && str.length() > 0 && !str.equals("0")) {
            Intent intent = new Intent(context, PersonInfoActivity.class);
            intent.putExtra("un", str);
            intent.putExtra("name", str2);
            if (TiebaApplication.B() != null && TiebaApplication.B().equals(str)) {
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
        if (this.d.e()) {
            if (!this.d.o() && !this.d.p()) {
                a(R.drawable.tips_center_recentchat, 1);
                return;
            }
            return;
        }
        a(R.drawable.tips_center_chat, 2);
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
        this.d = new com.baidu.tieba.c.bi(this);
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
        this.c.f(this.d);
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
        bundle.putBoolean("tab_page", this.d.o());
        bundle.putBoolean("tab_msg", this.d.p());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        boolean z = false;
        super.onResume();
        if (this.d.d() == null || this.d.d().length() <= 0) {
            if (TiebaApplication.B() != null) {
                this.d.a(true);
                this.d.b(TiebaApplication.B());
                this.d.c(TiebaApplication.F());
                d();
                b();
                this.c.a(true);
                return;
            }
            this.c.a(false);
        } else if (this.d.e()) {
            if (TiebaApplication.d().Y()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f > 30000) {
                    TiebaApplication.d().Z();
                    this.f = currentTimeMillis;
                }
            }
            if (TiebaApplication.d().ad() != this.d.j()) {
                this.d.a(TiebaApplication.d().ad());
                z = true;
            }
            if (TiebaApplication.d().ab() != this.d.n()) {
                this.d.d(TiebaApplication.d().ab());
                z = true;
            }
            if (TiebaApplication.d().ac() != this.d.l()) {
                this.d.c(TiebaApplication.d().ac());
                z = true;
            }
            if (TiebaApplication.d().ae() != this.d.k()) {
                this.d.b(TiebaApplication.d().ae());
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
        this.c.a(i, this.d);
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
            String B = TiebaApplication.B();
            if ((B != null && B.length() > 0) || TiebaApplication.d().as() >= 3) {
                MainTabActivity.a(this, "goto_home");
            } else {
                MainTabActivity.a(this, "goto_recommend");
            }
        } else if (view == this.c.f()) {
            this.c.g(this.d);
            this.d.g();
        } else if (view == this.c.g()) {
            com.baidu.tieba.a.ao aoVar = new com.baidu.tieba.a.ao();
            if (this.d.f() != null) {
                aoVar.b(this.d.f().d());
                aoVar.a(this.d.f().j());
                aoVar.a(this.d.f().k());
                aoVar.c(this.d.f().e());
            }
            MoreActivity.a(this, WebChromeClient.STRING_DLG_TITLE_DATETIME, aoVar);
        } else if (view == this.c.h()) {
            if (this.d.e()) {
                new com.baidu.tieba.account.af("mention").start();
                MentionActivity.a(this, (int) WebChromeClient.STRING_DLG_TITLE_TIME);
            }
        } else if (view == this.c.i()) {
            if (this.d.e()) {
                if (TiebaApplication.d().o()) {
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
                PersonListActivity.a(this, true, TiebaApplication.B());
            } else if (this.d.f() != null) {
                PersonListActivity.a(this, true, this.d.f().a());
            }
        } else if (view == this.c.l()) {
            if (this.d.e()) {
                PersonListActivity.a(this, false, TiebaApplication.B());
            } else if (this.d.f() != null) {
                PersonListActivity.a(this, false, this.d.f().a());
            }
        } else if (view == this.c.m()) {
            if (this.d.e()) {
                startActivity(new Intent(this, MyPostActivity.class));
            }
        } else if (view == this.c.n()) {
            if (TiebaApplication.d().o()) {
                StatService.onEvent(this, "personal_lbs_post", "personclick", 1);
            }
            PersonLbsActivity.a(this, this.d.d());
        } else if (view == this.c.o()) {
            LoginActivity.a((Activity) this, (String) null, true, 1100003);
        } else if (view == this.c.p()) {
            Register2Activity.a(this, 1200007);
        } else if (view == this.c.q()) {
            if (this.d.e()) {
                if (TiebaApplication.d().o()) {
                    StatService.onEvent(this, "enter_chatlist", "personclick", 1);
                }
                ChatListActivity.a(this);
            } else if (this.d.f() != null) {
                if (this.d.d() == null || this.d.d().length() <= 0) {
                    LoginActivity.a((Activity) this, getString(R.string.login_to_chat), true, 1100028);
                } else {
                    m();
                }
            }
        }
    }

    private void m() {
        if (TiebaApplication.d().o()) {
            StatService.onEvent(this, "enter_chat", "personclick", 1);
        }
        ChatActivity.a(this, this.d.f().a(), this.d.f().c(), this.d.f().e(), null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.d.d() != null && this.d.d().length() > 0 && this.d.e() && this.e != null) {
            unregisterReceiver(this.e);
        }
        this.d.q();
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
            } else if (i == 1100003 || i == 1200007) {
                if (TiebaApplication.B() != null) {
                    this.d.a(true);
                    this.d.b(TiebaApplication.B());
                    this.d.c(TiebaApplication.F());
                    d();
                    b();
                }
            } else if (i == 1100028) {
                m();
            }
        }
    }

    private void a(Intent intent) {
        com.baidu.tieba.a.ao aoVar = (com.baidu.tieba.a.ao) intent.getSerializableExtra("person_change_data");
        if (aoVar != null && this.d.f() != null) {
            this.d.a(aoVar);
            this.c.a(this.d);
            if (aoVar.d()) {
                this.c.b();
                if (this.d.f() != null) {
                    this.d.h().d(this.d.f().e());
                }
                this.d.a(false, false);
            }
        }
    }
}
