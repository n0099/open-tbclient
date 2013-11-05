package com.baidu.tieba.person;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.account.Register2Activity;
import com.baidu.tieba.chat.ChatActivity;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.model.bw;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.person.post.PersonPostActivity;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonInfoActivity extends com.baidu.tieba.j {
    private BroadcastReceiver c = null;

    /* renamed from: a  reason: collision with root package name */
    bj f2161a = null;
    bi b = null;
    private bw d = null;
    private Boolean e = false;

    public static void a(Context context, String str, String str2) {
        a(context, str, str2, false);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (str != null && str.length() > 0 && !str.equals(SocialConstants.FALSE)) {
            Intent intent = new Intent(context, PersonInfoActivity.class);
            intent.putExtra("un", str);
            intent.putExtra(SocialConstants.PARAM_MEDIA_UNAME, str2);
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
            this.f2161a = new bj(this, this.d);
            this.f2161a.a(new az(this));
            return;
        }
        this.f2161a = null;
        this.b = new bi(this, this.d);
    }

    private void d() {
        if (this.c == null) {
            this.c = new ba(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.broadcast.notify");
            registerReceiver(this.c, intentFilter);
        }
    }

    private void a(Bundle bundle) {
        this.d = new bw(this);
        if (bundle != null) {
            this.d.a(bundle.getBoolean("self", true));
            this.d.a(bundle.getString("un"));
            this.d.b(bundle.getString(SocialConstants.PARAM_MEDIA_UNAME));
            this.d.b(bundle.getBoolean("tab_page", false));
            this.d.c(bundle.getBoolean("tab_msg", false));
        } else {
            Intent intent = getIntent();
            if (intent != null) {
                this.d.a(intent.getBooleanExtra("self", true));
                this.d.a(intent.getStringExtra("un"));
                this.d.b(intent.getStringExtra(SocialConstants.PARAM_MEDIA_UNAME));
                this.d.b(intent.getBooleanExtra("tab_page", false));
                this.d.c(intent.getBooleanExtra("tab_msg", false));
            }
        }
        this.d.setLoadDataCallBack(new bb(this));
    }

    public void b() {
        if (this.e.booleanValue()) {
            if (this.f2161a != null) {
                this.f2161a.f(this.d);
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
        bundle.putString(SocialConstants.PARAM_MEDIA_UNAME, this.d.f());
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
                this.d.b(TiebaApplication.H());
                d();
                b();
                if (this.f2161a != null) {
                    this.f2161a.a(true);
                } else if (this.b != null) {
                    this.b.a(true);
                }
            } else if (this.f2161a != null) {
                this.f2161a.a(false);
            } else if (this.b != null) {
                this.b.a(false);
            }
        } else if (this.e.booleanValue()) {
            if (com.baidu.tieba.mention.t.a().n() != this.d.g()) {
                this.d.a(com.baidu.tieba.mention.t.a().n());
                z = true;
            }
            if (com.baidu.tieba.mention.t.a().q() != this.d.h()) {
                this.d.c(com.baidu.tieba.mention.t.a().q());
                z = true;
            }
            if (this.f2161a != null) {
                if (z) {
                    this.f2161a.d(this.d);
                }
                this.f2161a.a(true);
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
            if (this.f2161a != null) {
                this.f2161a.a(i, this.d);
            }
        } else if (this.b != null) {
            this.b.a(i, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void k() {
        super.k();
        c(-1);
        if (this.e.booleanValue()) {
            if (this.f2161a != null) {
                this.f2161a.a();
            }
        } else if (this.b != null) {
            this.b.a();
        }
    }

    public Boolean a(View view, bk bkVar) {
        if (view == bkVar.m()) {
            finish();
            return true;
        } else if (view == bkVar.n()) {
            MainTabActivity.a(this);
            return true;
        } else if (view == bkVar.o()) {
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.d.c() != null) {
                personChangeData.setName(this.d.c().getName_show());
                personChangeData.setIntro(this.d.c().getIntro());
                personChangeData.setSex(this.d.c().getSex());
                personChangeData.setPortrait(this.d.c().getPortrait());
            }
            MoreActivity.a(this, 101, personChangeData);
            return true;
        } else if (view == bkVar.p()) {
            LoginActivity.a((Activity) this, (String) null, true, 11003);
            return true;
        } else if (view != bkVar.q()) {
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
            if (this.f2161a != null && !a(view, this.f2161a).booleanValue()) {
                if (view == this.f2161a.f()) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this, "personal_my_collect", "personclick", 1);
                    }
                    EditMarkActivity.a(this, 102);
                } else if (view == this.f2161a.g()) {
                    new com.baidu.tieba.account.ah("tb_mytieba").start();
                    EditBarActivity.a(this, 103, null, c != null ? c.getSex() : 0);
                } else if (view == this.f2161a.h()) {
                    PersonListActivity.a(this, true, TiebaApplication.C(), c != null ? c.getSex() : 0);
                } else if (view == this.f2161a.i()) {
                    PersonListActivity.a(this, false, TiebaApplication.C(), c != null ? c.getSex() : 0);
                } else if (view == this.f2161a.j()) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this, "personal_my_threads", "click", 1);
                    }
                    if (this.d != null && this.d.c() != null) {
                        PersonPostActivity.a(this, TiebaApplication.C(), 0, this.d.c().getPortrait());
                    }
                } else if (view == this.f2161a.k()) {
                    PersonChangeData personChangeData = new PersonChangeData();
                    if (this.d.c() != null) {
                        personChangeData.setName(this.d.c().getName_show());
                        personChangeData.setIntro(this.d.c().getIntro());
                        personChangeData.setSex(this.d.c().getSex());
                        personChangeData.setPortrait(this.d.c().getPortrait());
                    }
                    PersonChangeActivity.a(this, 101, personChangeData, true);
                }
            }
        } else if (this.b != null && !a(view, this.b).booleanValue()) {
            if (view == this.b.h()) {
                if (c != null) {
                    EditBarActivity.a(this, 103, c.getId(), c.getSex());
                }
            } else if (view == this.b.i()) {
                if (c != null) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this, "personal_his_threads", "click", 1);
                    }
                    PersonPostActivity.a(this, c.getId(), c.getSex(), this.d.c().getPortrait());
                }
            } else if (view == this.b.j()) {
                if (c != null) {
                    PersonListActivity.a(this, true, c.getId(), c.getSex());
                }
            } else if (view == this.b.k()) {
                if (c != null) {
                    PersonListActivity.a(this, false, c.getId(), c.getSex());
                }
            } else if (view == this.b.f()) {
                this.b.c(this.d);
                this.d.d();
            } else if (view == this.b.g() && c != null) {
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
            if (this.f2161a != null) {
                this.f2161a.e();
            }
        } else if (this.b != null) {
            this.b.e();
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
                    this.d.b(TiebaApplication.H());
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
                if (this.f2161a != null) {
                    this.f2161a.d(this.d);
                }
            } else if (this.b != null) {
                this.b.d(this.d);
            }
            if (personChangeData.getPhotoChanged()) {
                if (this.e.booleanValue()) {
                    if (this.f2161a != null) {
                        this.f2161a.l();
                    }
                } else if (this.b != null) {
                    this.b.l();
                }
                if (this.d.c() != null) {
                    this.d.e().e(this.d.c().getPortrait());
                }
                this.d.a(false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (!com.baidu.tieba.sharedPref.b.a().a("key_show_tip_send_message", false)) {
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.b(R.id.guest_btn_send_message).a(150).a(true);
            bg bgVar = new bg(this);
            gVar.a(bgVar).a(new bh(this));
            gVar.a().a(this);
            com.baidu.tieba.sharedPref.b.a().b("key_show_tip_send_message", true);
        }
    }
}
