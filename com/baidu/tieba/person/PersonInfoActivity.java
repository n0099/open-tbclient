package com.baidu.tieba.person;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
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
import com.baidu.tieba.util.DatabaseService;
import com.baidu.zeus.WebChromeClient;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonInfoActivity extends com.baidu.tieba.g {
    private BroadcastReceiver c = null;

    /* renamed from: a  reason: collision with root package name */
    bi f1593a = null;
    bh b = null;
    private com.baidu.tieba.model.bm d = null;
    private Boolean e = false;

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
        this.e = Boolean.valueOf(this.d.b());
        d();
        if (this.d.a() != null && this.d.a().length() > 0 && this.e.booleanValue()) {
            k();
        }
        DatabaseService.b((Boolean) true);
        if (this.d.a() != null && this.d.a().length() > 0) {
            c();
        }
    }

    private void d() {
        if (this.e.booleanValue()) {
            this.b = null;
            this.f1593a = new bi(this, this.d);
            this.f1593a.a(new ay(this));
            return;
        }
        this.f1593a = null;
        this.b = new bh(this, this.d);
    }

    private void k() {
        if (this.c == null) {
            this.c = new az(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.broadcast.notify");
            registerReceiver(this.c, intentFilter);
        }
    }

    private void a(Bundle bundle) {
        this.d = new com.baidu.tieba.model.bm(this);
        if (bundle != null) {
            this.d.a(bundle.getBoolean("self", true));
            this.d.a(bundle.getString("un"));
            this.d.b(bundle.getString("name"));
            this.d.c(bundle.getBoolean("tab_page", false));
            this.d.d(bundle.getBoolean("tab_msg", false));
            this.d.b(bundle.getBoolean("showBack", false));
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.d.a(intent.getBooleanExtra("self", true));
                this.d.a(intent.getStringExtra("un"));
                this.d.b(intent.getStringExtra("name"));
                this.d.c(intent.getBooleanExtra("tab_page", false));
                this.d.d(intent.getBooleanExtra("tab_msg", false));
                this.d.b(intent.getBooleanExtra("showBack", false));
            }
        }
        this.d.setLoadDataCallBack(new ba(this));
    }

    public boolean b() {
        if (this.d != null) {
            return this.d.d();
        }
        return false;
    }

    public void c() {
        if (this.e.booleanValue()) {
            if (this.f1593a != null) {
                this.f1593a.f(this.d);
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
        bundle.putString("name", this.d.g());
        bundle.putBoolean("tab_page", this.d.j());
        bundle.putBoolean("tab_msg", this.d.k());
        bundle.putBoolean("showBack", this.d.d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        boolean z = false;
        super.onResume();
        this.e = Boolean.valueOf(this.d.b());
        if (this.d.a() == null || this.d.a().length() <= 0) {
            if (TiebaApplication.g().u()) {
                StatService.onEvent(this, "home_login_show", "loginshow", 1);
            }
            if (TiebaApplication.E() != null) {
                this.d.a(true);
                this.d.a(TiebaApplication.E());
                this.d.b(TiebaApplication.I());
                k();
                c();
                if (this.f1593a != null) {
                    this.f1593a.a(true);
                } else if (this.b != null) {
                    this.b.a(true);
                }
            } else if (this.f1593a != null) {
                this.f1593a.a(false);
            } else if (this.b != null) {
                this.b.a(false);
            }
        } else if (this.e.booleanValue()) {
            if (com.baidu.tieba.mention.r.a().i() != this.d.h()) {
                this.d.a(com.baidu.tieba.mention.r.a().i());
                z = true;
            }
            if (com.baidu.tieba.mention.r.a().k() != this.d.i()) {
                this.d.c(com.baidu.tieba.mention.r.a().k());
                z = true;
            }
            if (this.f1593a != null) {
                if (z) {
                    this.f1593a.d(this.d);
                }
                this.f1593a.a(true);
            }
        } else if (this.b != null) {
            this.b.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        if (this.e.booleanValue()) {
            if (this.f1593a != null) {
                this.f1593a.a(i, this.d);
            }
        } else if (this.b != null) {
            this.b.a(i, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void i() {
        super.i();
        d(-1);
        if (this.e.booleanValue()) {
            if (this.f1593a != null) {
                this.f1593a.b();
            }
        } else if (this.b != null) {
            this.b.b();
        }
    }

    public Boolean a(View view, bj bjVar) {
        if (view == bjVar.k()) {
            finish();
            return true;
        } else if (view == bjVar.l()) {
            MainTabActivity.a(this);
            return true;
        } else if (view == bjVar.m()) {
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.d.c() != null) {
                personChangeData.setName(this.d.c().getName_show());
                personChangeData.setIntro(this.d.c().getIntro());
                personChangeData.setSex(this.d.c().getSex());
                personChangeData.setPortrait(this.d.c().getPortrait());
            }
            MoreActivity.a(this, WebChromeClient.STRING_DLG_TITLE_DATETIME, personChangeData);
            return true;
        } else if (view == bjVar.n()) {
            LoginActivity.a((Activity) this, (String) null, true, 11003);
            return true;
        } else if (view != bjVar.o()) {
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
            if (this.f1593a != null && !a(view, this.f1593a).booleanValue()) {
                if (view == this.f1593a.d()) {
                    if (TiebaApplication.g().u()) {
                        StatService.onEvent(this, "personal_my_collect", "personclick", 1);
                    }
                    EditMarkActivity.a(this, (int) WebChromeClient.STRING_DLG_TITLE_WEEK);
                } else if (view == this.f1593a.e()) {
                    new com.baidu.tieba.account.ag("tb_mytieba").start();
                    EditBarActivity.a(this, 103, null, c != null ? c.getSex() : 0);
                } else if (view == this.f1593a.f()) {
                    PersonListActivity.a(this, true, TiebaApplication.E(), c != null ? c.getSex() : 0);
                } else if (view == this.f1593a.g()) {
                    PersonListActivity.a(this, false, TiebaApplication.E(), c != null ? c.getSex() : 0);
                } else if (view == this.f1593a.h()) {
                    startActivity(new Intent(this, MyPostActivity.class));
                } else if (view == this.f1593a.i()) {
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
                    MyPostActivity.a(this, c.getId(), c.getSex());
                    if (TiebaApplication.g().u()) {
                        StatService.onEvent(this, "personal_his_threads", "click", 1);
                    }
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
                this.d.e();
            } else if (view == this.b.e() && c != null) {
                if (this.d.a() == null || this.d.a().length() <= 0) {
                    LoginActivity.a((Activity) this, getString(R.string.login_to_chat), true, 11028);
                } else {
                    l();
                }
            }
        }
    }

    private void l() {
        if (TiebaApplication.g().u()) {
            StatService.onEvent(this, "enter_chat", "personclick", 1);
        }
        ChatActivity.a(this, this.d.c().getId(), this.d.c().getName(), this.d.c().getPortrait(), null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        if (this.d.a() != null && this.d.a().length() > 0 && this.d.b() && this.c != null) {
            unregisterReceiver(this.c);
        }
        this.d.l();
        if (this.e.booleanValue()) {
            if (this.f1593a != null) {
                this.f1593a.c();
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
                if (TiebaApplication.E() != null) {
                    this.d.a(true);
                    this.d.a(TiebaApplication.E());
                    this.d.b(TiebaApplication.I());
                    k();
                    c();
                }
            } else if (i == 11028) {
                l();
            }
        }
    }

    private void a(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("person_change_data");
        if (personChangeData != null && this.d.c() != null) {
            this.d.a(personChangeData);
            if (this.e.booleanValue()) {
                if (this.f1593a != null) {
                    this.f1593a.d(this.d);
                }
            } else if (this.b != null) {
                this.b.d(this.d);
            }
            if (personChangeData.getPhotoChanged()) {
                if (this.e.booleanValue()) {
                    if (this.f1593a != null) {
                        this.f1593a.j();
                    }
                } else if (this.b != null) {
                    this.b.j();
                }
                if (this.d.c() != null) {
                    this.d.f().e(this.d.c().getPortrait());
                }
                this.d.a(false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        SharedPreferences sharedPreferences = TiebaApplication.g().getSharedPreferences("settings", 0);
        if (!sharedPreferences.getBoolean("key_show_tip_send_message", false)) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.b(R.id.guest_btn_send_message).a(WebChromeClient.STRING_DLG_BTN_SET).a(true);
            bf bfVar = new bf(this);
            gVar.a(bfVar).a(new bg(this));
            gVar.a().a(this);
            sharedPreferences.edit().putBoolean("key_show_tip_send_message", true).commit();
        }
    }
}
