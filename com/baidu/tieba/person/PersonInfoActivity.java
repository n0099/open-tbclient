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
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.person.post.PersonPostActivity;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonInfoActivity extends com.baidu.tieba.j {
    private BroadcastReceiver c = null;

    /* renamed from: a  reason: collision with root package name */
    bh f1643a = null;
    bg b = null;
    private com.baidu.tieba.model.bo d = null;
    private Boolean e = false;

    public static void a(Context context, String str, String str2) {
        a(context, str, str2, false);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (str != null && str.length() > 0 && !str.equals("0")) {
            Intent intent = new Intent(context, PersonInfoActivity.class);
            intent.putExtra("un", str);
            intent.putExtra("name", str2);
            if (TiebaApplication.C() != null && TiebaApplication.C().equals(str)) {
                intent.putExtra("self", true);
            } else {
                intent.putExtra("self", false);
            }
            intent.putExtra("tab_page", false);
            if (z || !(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(bundle);
        this.e = Boolean.valueOf(this.d.b());
        c();
        if (this.d.a() != null && this.d.a().length() > 0 && this.e.booleanValue()) {
            d();
        }
        DatabaseService.b((Boolean) true);
        if (this.d.a() != null && this.d.a().length() > 0) {
            b();
        }
    }

    private void c() {
        if (this.e.booleanValue()) {
            this.b = null;
            this.f1643a = new bh(this, this.d);
            this.f1643a.a(new ax(this));
            return;
        }
        this.f1643a = null;
        this.b = new bg(this, this.d);
    }

    private void d() {
        if (this.c == null) {
            this.c = new ay(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.broadcast.notify");
            registerReceiver(this.c, intentFilter);
        }
    }

    private void a(Bundle bundle) {
        this.d = new com.baidu.tieba.model.bo(this);
        if (bundle != null) {
            this.d.a(bundle.getBoolean("self", true));
            this.d.a(bundle.getString("un"));
            this.d.b(bundle.getString("name"));
            this.d.b(bundle.getBoolean("tab_page", false));
            this.d.c(bundle.getBoolean("tab_msg", false));
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.d.a(intent.getBooleanExtra("self", true));
                this.d.a(intent.getStringExtra("un"));
                this.d.b(intent.getStringExtra("name"));
                this.d.b(intent.getBooleanExtra("tab_page", false));
                this.d.c(intent.getBooleanExtra("tab_msg", false));
            }
        }
        this.d.setLoadDataCallBack(new az(this));
    }

    public void b() {
        if (this.e.booleanValue()) {
            if (this.f1643a != null) {
                this.f1643a.f(this.d);
            }
            this.d.a(true, true);
            return;
        }
        if (this.b != null) {
            this.b.f(this.d);
        }
        this.d.a(false, true);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("self", this.d.b());
        bundle.putString("un", this.d.a());
        bundle.putString("name", this.d.f());
        bundle.putBoolean("tab_page", this.d.i());
        bundle.putBoolean("tab_msg", this.d.j());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        boolean z = false;
        super.onResume();
        this.e = Boolean.valueOf(this.d.b());
        if (this.d.a() == null || this.d.a().length() <= 0) {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this, "home_login_show", "loginshow", 1);
            }
            if (TiebaApplication.C() != null) {
                this.d.a(true);
                this.d.a(TiebaApplication.C());
                this.d.b(TiebaApplication.G());
                d();
                b();
                if (this.f1643a != null) {
                    this.f1643a.a(true);
                } else if (this.b != null) {
                    this.b.a(true);
                }
            } else if (this.f1643a != null) {
                this.f1643a.a(false);
            } else if (this.b != null) {
                this.b.a(false);
            }
        } else if (this.e.booleanValue()) {
            if (com.baidu.tieba.mention.s.a().k() != this.d.g()) {
                this.d.a(com.baidu.tieba.mention.s.a().k());
                z = true;
            }
            if (com.baidu.tieba.mention.s.a().m() != this.d.h()) {
                this.d.c(com.baidu.tieba.mention.s.a().m());
                z = true;
            }
            if (this.f1643a != null) {
                if (z) {
                    this.f1643a.d(this.d);
                }
                this.f1643a.a(true);
            }
        } else if (this.b != null) {
            this.b.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        if (this.e.booleanValue()) {
            if (this.f1643a != null) {
                this.f1643a.a(i, this.d);
            }
        } else if (this.b != null) {
            this.b.a(i, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void j() {
        super.j();
        d(-1);
        if (this.e.booleanValue()) {
            if (this.f1643a != null) {
                this.f1643a.b();
            }
        } else if (this.b != null) {
            this.b.b();
        }
    }

    public Boolean a(View view, bi biVar) {
        if (view == biVar.k()) {
            finish();
            return true;
        } else if (view == biVar.l()) {
            MainTabActivity.a(this);
            return true;
        } else if (view == biVar.m()) {
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.d.c() != null) {
                personChangeData.setName(this.d.c().getName_show());
                personChangeData.setIntro(this.d.c().getIntro());
                personChangeData.setSex(this.d.c().getSex());
                personChangeData.setPortrait(this.d.c().getPortrait());
            }
            MoreActivity.a(this, WebChromeClient.STRING_DLG_TITLE_DATETIME, personChangeData);
            return true;
        } else if (view == biVar.n()) {
            LoginActivity.a((Activity) this, (String) null, true, 11003);
            return true;
        } else if (view != biVar.o()) {
            return false;
        } else {
            Register2Activity.a(this, 12007);
            return true;
        }
    }

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        UserData c = this.d.c();
        if (this.e.booleanValue()) {
            if (this.f1643a != null && !a(view, this.f1643a).booleanValue()) {
                if (view == this.f1643a.d()) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this, "personal_my_collect", "personclick", 1);
                    }
                    EditMarkActivity.a(this, (int) WebChromeClient.STRING_DLG_TITLE_WEEK);
                } else if (view == this.f1643a.e()) {
                    new com.baidu.tieba.account.ag("tb_mytieba").start();
                    EditBarActivity.a(this, 103, null, c != null ? c.getSex() : 0);
                } else if (view == this.f1643a.f()) {
                    PersonListActivity.a(this, true, TiebaApplication.C(), c != null ? c.getSex() : 0);
                } else if (view == this.f1643a.g()) {
                    PersonListActivity.a(this, false, TiebaApplication.C(), c != null ? c.getSex() : 0);
                } else if (view == this.f1643a.h()) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this, "personal_my_threads", "click", 1);
                    }
                    if (this.d != null && this.d.c() != null) {
                        PersonPostActivity.a(this, TiebaApplication.C(), 0, this.d.c().getPortrait());
                    }
                } else if (view == this.f1643a.i()) {
                    PersonChangeData personChangeData = new PersonChangeData();
                    if (this.d.c() != null) {
                        personChangeData.setName(this.d.c().getName_show());
                        personChangeData.setIntro(this.d.c().getIntro());
                        personChangeData.setSex(this.d.c().getSex());
                        personChangeData.setPortrait(this.d.c().getPortrait());
                    }
                    PersonChangeActivity.a(this, WebChromeClient.STRING_DLG_TITLE_DATETIME, personChangeData, true);
                }
            }
        } else if (this.b != null && !a(view, this.b).booleanValue()) {
            if (view == this.b.f()) {
                if (c != null) {
                    EditBarActivity.a(this, 103, c.getId(), c.getSex());
                }
            } else if (view == this.b.g()) {
                if (c != null) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this, "personal_his_threads", "click", 1);
                    }
                    PersonPostActivity.a(this, c.getId(), c.getSex(), this.d.c().getPortrait());
                }
            } else if (view == this.b.h()) {
                if (c != null) {
                    PersonListActivity.a(this, true, c.getId(), c.getSex());
                }
            } else if (view == this.b.i()) {
                if (c != null) {
                    PersonListActivity.a(this, false, c.getId(), c.getSex());
                }
            } else if (view == this.b.d()) {
                this.b.c(this.d);
                this.d.d();
            } else if (view == this.b.e() && c != null) {
                if (this.d.a() == null || this.d.a().length() <= 0) {
                    LoginActivity.a((Activity) this, getString(R.string.login_to_chat), true, 11028);
                } else {
                    e();
                }
            }
        }
    }

    private void e() {
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this, "enter_chat", "personclick", 1);
        }
        ChatActivity.a(this, this.d.c().getId(), this.d.c().getName(), this.d.c().getPortrait(), null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        if (this.d.a() != null && this.d.a().length() > 0 && this.d.b() && this.c != null) {
            unregisterReceiver(this.c);
        }
        this.d.k();
        if (this.e.booleanValue()) {
            if (this.f1643a != null) {
                this.f1643a.c();
            }
        } else if (this.b != null) {
            this.b.c();
        }
        DatabaseService.b((Boolean) true);
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                a(intent);
            } else if (i == 11003 || i == 12007) {
                if (TiebaApplication.C() != null) {
                    this.d.a(true);
                    this.d.a(TiebaApplication.C());
                    this.d.b(TiebaApplication.G());
                    d();
                    b();
                }
            } else if (i == 11028) {
                e();
            }
        }
    }

    private void a(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("person_change_data");
        if (personChangeData != null && this.d.c() != null) {
            this.d.a(personChangeData);
            if (this.e.booleanValue()) {
                if (this.f1643a != null) {
                    this.f1643a.d(this.d);
                }
            } else if (this.b != null) {
                this.b.d(this.d);
            }
            if (personChangeData.getPhotoChanged()) {
                if (this.e.booleanValue()) {
                    if (this.f1643a != null) {
                        this.f1643a.j();
                    }
                } else if (this.b != null) {
                    this.b.j();
                }
                if (this.d.c() != null) {
                    this.d.e().e(this.d.c().getPortrait());
                }
                this.d.a(false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (!com.baidu.tieba.sharedPref.b.a().a("key_show_tip_send_message", false)) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.b(R.id.guest_btn_send_message).a(WebChromeClient.STRING_DLG_BTN_SET).a(true);
            be beVar = new be(this);
            gVar.a(beVar).a(new bf(this));
            gVar.a().a(this);
            com.baidu.tieba.sharedPref.b.a().b("key_show_tip_send_message", true);
        }
    }
}
