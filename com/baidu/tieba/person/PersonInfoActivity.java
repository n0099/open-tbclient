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
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.mention.MentionActivity;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonInfoActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    bb f1304a = null;
    private com.baidu.tieba.model.bi b = null;
    private BroadcastReceiver c = null;
    private long d = 0;

    public static void a(Context context, String str, String str2) {
        a(context, str, str2, false);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (str != null && str.length() > 0 && !str.equals("0")) {
            Intent intent = new Intent(context, PersonInfoActivity.class);
            intent.putExtra("un", str);
            intent.putExtra("name", str2);
            if (TiebaApplication.E() != null && TiebaApplication.E().equals(str)) {
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
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        c();
        if (this.b.a() != null && this.b.a().length() > 0 && this.b.b()) {
            d();
        }
        DatabaseService.b((Boolean) true);
        if (this.b.a() != null && this.b.a().length() > 0) {
            b();
        }
        if (this.b.b()) {
            if (!this.b.l() && !this.b.m()) {
                a(R.drawable.tips_center_recentchat, 1);
                return;
            }
            return;
        }
        a(R.drawable.tips_center_chat, 2);
    }

    private void c() {
        this.f1304a = new bb(this, this.b);
        this.f1304a.a(new ay(this));
    }

    private void d() {
        if (this.c == null) {
            this.c = new az(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.broadcast.notify");
            registerReceiver(this.c, intentFilter);
        }
    }

    private void a(Bundle bundle) {
        this.b = new com.baidu.tieba.model.bi(this);
        if (bundle != null) {
            this.b.a(bundle.getBoolean("self", true));
            this.b.a(bundle.getString("un"));
            this.b.b(bundle.getString("name"));
            this.b.b(bundle.getBoolean("tab_page", false));
            this.b.c(bundle.getBoolean("tab_msg", false));
        } else {
            Intent intent = getIntent();
            this.b.a(intent.getBooleanExtra("self", true));
            this.b.a(intent.getStringExtra("un"));
            this.b.b(intent.getStringExtra("name"));
            this.b.b(intent.getBooleanExtra("tab_page", false));
            this.b.c(intent.getBooleanExtra("tab_msg", false));
        }
        this.b.setLoadDataCallBack(new ba(this));
    }

    public void b() {
        this.f1304a.f(this.b);
        if (this.b.b()) {
            this.b.a(true, true);
        } else {
            this.b.a(false, true);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("self", this.b.b());
        bundle.putString("un", this.b.a());
        bundle.putString("name", this.b.f());
        bundle.putBoolean("tab_page", this.b.l());
        bundle.putBoolean("tab_msg", this.b.m());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        boolean z = false;
        super.onResume();
        if (this.b.a() == null || this.b.a().length() <= 0) {
            if (TiebaApplication.E() != null) {
                this.b.a(true);
                this.b.a(TiebaApplication.E());
                this.b.b(TiebaApplication.H());
                d();
                b();
                this.f1304a.a(true);
                return;
            }
            this.f1304a.a(false);
        } else if (this.b.b()) {
            if (TiebaApplication.f().aa()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.d > 30000) {
                    TiebaApplication.f().ab();
                    this.d = currentTimeMillis;
                }
            }
            if (TiebaApplication.f().af() != this.b.g()) {
                this.b.a(TiebaApplication.f().af());
                z = true;
            }
            if (TiebaApplication.f().ad() != this.b.k()) {
                this.b.d(TiebaApplication.f().ad());
                z = true;
            }
            if (TiebaApplication.f().ae() != this.b.i()) {
                this.b.c(TiebaApplication.f().ae());
                z = true;
            }
            if (TiebaApplication.f().ag() != this.b.h()) {
                this.b.b(TiebaApplication.f().ag());
                z = true;
            }
            if (z) {
                this.f1304a.a(this.b);
            }
            this.f1304a.a(true);
        } else {
            this.f1304a.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        this.f1304a.a(i, this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void k() {
        super.k();
        c(-1);
        this.f1304a.a();
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f1304a.d()) {
            finish();
        } else if (view == this.f1304a.e()) {
            MainTabActivity.a(this);
        } else if (view == this.f1304a.f()) {
            this.f1304a.g(this.b);
            this.b.d();
        } else if (view == this.f1304a.g()) {
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.b.c() != null) {
                personChangeData.setName(this.b.c().getName_show());
                personChangeData.setIntro(this.b.c().getIntro());
                personChangeData.setSex(this.b.c().getSex());
                personChangeData.setPortrait(this.b.c().getPortrait());
            }
            MoreActivity.a(this, WebChromeClient.STRING_DLG_TITLE_DATETIME, personChangeData);
        } else if (view == this.f1304a.h()) {
            if (this.b.b()) {
                new com.baidu.tieba.account.af("mention").start();
                MentionActivity.a(this, (int) WebChromeClient.STRING_DLG_TITLE_TIME);
            }
        } else if (view == this.f1304a.i()) {
            if (this.b.b()) {
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this, "personal_my_collect", "personclick", 1);
                }
                EditMarkActivity.a(this, (int) WebChromeClient.STRING_DLG_TITLE_WEEK);
            }
        } else if (view == this.f1304a.j()) {
            if (this.b.b()) {
                new com.baidu.tieba.account.af("tb_mytieba").start();
                EditBarActivity.a(this, 103, null);
            } else if (this.b.c() != null) {
                EditBarActivity.a(this, 103, this.b.c().getId());
            }
        } else if (view == this.f1304a.k()) {
            if (this.b.b()) {
                PersonListActivity.a(this, true, TiebaApplication.E());
            } else if (this.b.c() != null) {
                PersonListActivity.a(this, true, this.b.c().getId());
            }
        } else if (view == this.f1304a.l()) {
            if (this.b.b()) {
                PersonListActivity.a(this, false, TiebaApplication.E());
            } else if (this.b.c() != null) {
                PersonListActivity.a(this, false, this.b.c().getId());
            }
        } else if (view == this.f1304a.m()) {
            if (this.b.b()) {
                startActivity(new Intent(this, MyPostActivity.class));
            } else if (this.b.c() != null) {
                MyPostActivity.a(this, this.b.c().getId());
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this, "personal_his_threads", "click", 1);
                }
            }
        } else if (view == this.f1304a.n()) {
            if (TiebaApplication.f().t()) {
                StatService.onEvent(this, "personal_lbs_post", "personclick", 1);
            }
            PersonLbsActivity.a(this, this.b.a());
        } else if (view == this.f1304a.o()) {
            LoginActivity.a((Activity) this, (String) null, true, 1100003);
        } else if (view == this.f1304a.p()) {
            Register2Activity.a(this, 1200007);
        } else if (view == this.f1304a.q()) {
            if (this.b.b()) {
                if (TiebaApplication.f().t()) {
                    StatService.onEvent(this, "enter_chatlist", "personclick", 1);
                }
                ChatListActivity.a(this);
            } else if (this.b.c() != null) {
                if (this.b.a() == null || this.b.a().length() <= 0) {
                    LoginActivity.a((Activity) this, getString(R.string.login_to_chat), true, 1100028);
                } else {
                    m();
                }
            }
        }
    }

    private void m() {
        if (TiebaApplication.f().t()) {
            StatService.onEvent(this, "enter_chat", "personclick", 1);
        }
        ChatActivity.a(this, this.b.c().getId(), this.b.c().getName(), this.b.c().getPortrait(), null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        if (this.b.a() != null && this.b.a().length() > 0 && this.b.b() && this.c != null) {
            unregisterReceiver(this.c);
        }
        this.b.n();
        this.f1304a.c();
        DatabaseService.b((Boolean) true);
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                a(intent);
            } else if (i == 1100003 || i == 1200007) {
                if (TiebaApplication.E() != null) {
                    this.b.a(true);
                    this.b.a(TiebaApplication.E());
                    this.b.b(TiebaApplication.H());
                    d();
                    b();
                }
            } else if (i == 1100028) {
                m();
            }
        }
    }

    private void a(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("person_change_data");
        if (personChangeData != null && this.b.c() != null) {
            this.b.a(personChangeData);
            this.f1304a.a(this.b);
            if (personChangeData.getPhotoChanged()) {
                this.f1304a.b();
                if (this.b.c() != null) {
                    this.b.e().d(this.b.c().getPortrait());
                }
                this.b.a(false, false);
            }
        }
    }
}
