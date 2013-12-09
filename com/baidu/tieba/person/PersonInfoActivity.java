package com.baidu.tieba.person;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.CommonWebviewActivity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.account.Register2Activity;
import com.baidu.tieba.chat.ChatActivity;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.person.post.PersonPostActivity;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonInfoActivity extends BaseFragment {
    private static final String c = com.baidu.tieba.data.h.b + "mo/q/topic_page/135_1";
    private static boolean i = false;
    private BaseFragmentActivity g;
    private BroadcastReceiver d = null;

    /* renamed from: a  reason: collision with root package name */
    bj f2297a = null;
    bi b = null;
    private com.baidu.tieba.model.bx e = null;
    private Boolean f = false;
    private AlertDialog h = null;

    public static void a(Context context, String str, String str2) {
        a(context, str, str2, false);
    }

    public static void a(Context context, String str, String str2, boolean z) {
        if (str != null && str.length() > 0 && !str.equals(SocialConstants.FALSE)) {
            Intent intent = new Intent(context, SinglePersonInfoActivity.class);
            intent.putExtra("un", str);
            intent.putExtra(SocialConstants.PARAM_MEDIA_UNAME, str2);
            if (TiebaApplication.B() != null && TiebaApplication.B().equals(str)) {
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

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.g = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c(bundle);
        this.f = Boolean.valueOf(this.e.c());
        return a(layoutInflater);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        G();
        if (this.e.b() != null && this.e.b().length() > 0 && this.f.booleanValue()) {
            H();
        }
        DatabaseService.b((Boolean) true);
        if (this.e.b() != null && this.e.b().length() > 0) {
            a();
        }
    }

    private View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.person_info_main, (ViewGroup) null);
    }

    private void G() {
        if (this.f.booleanValue()) {
            this.b = null;
            this.f2297a = new bj(this.g, this, this.e);
            this.f2297a.a(new be(this));
            L();
            return;
        }
        this.f2297a = null;
        this.b = new bi(this.g, this, this.e);
    }

    private void H() {
        if (this.d == null) {
            this.d = new bf(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.broadcast.notify");
            this.g.registerReceiver(this.d, intentFilter);
        }
    }

    private void c(Bundle bundle) {
        this.e = new com.baidu.tieba.model.bx(this.g);
        if (bundle != null) {
            this.e.a(bundle.getBoolean("self", true));
            this.e.a(bundle.getString("un"));
            this.e.c(bundle.getString(SocialConstants.PARAM_MEDIA_UNAME));
            this.e.b(bundle.getBoolean("tab_page", false));
            this.e.c(bundle.getBoolean("tab_msg", false));
        } else {
            Bundle h = h();
            if (h != null) {
                this.e.a(h.getBoolean("self", true));
                this.e.a(h.getString("un"));
                this.e.c(h.getString(SocialConstants.PARAM_MEDIA_UNAME));
                this.e.b(h.getBoolean("tab_page", false));
                this.e.c(h.getBoolean("tab_msg", false));
            }
        }
        this.e.setLoadDataCallBack(new bg(this));
    }

    public void a() {
        if (this.f.booleanValue()) {
            if (this.f2297a != null) {
                this.f2297a.c(this.e);
            }
            this.e.a(true, true);
            return;
        }
        if (this.b != null) {
            this.b.c(this.e);
        }
        this.e.a(false, true);
    }

    @Override // android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        super.e(bundle);
        if (this.e != null) {
            bundle.putBoolean("self", this.e.c());
            bundle.putString("un", this.e.b());
            bundle.putString(SocialConstants.PARAM_MEDIA_UNAME, this.e.g());
            bundle.putBoolean("tab_page", this.e.j());
            bundle.putBoolean("tab_msg", this.e.k());
        }
    }

    public static void a(boolean z) {
        i = z;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        boolean z = false;
        super.r();
        if (i) {
            a();
            i = false;
        } else if (F()) {
            this.f = Boolean.valueOf(this.e.c());
            if (this.e.b() == null || this.e.b().length() <= 0) {
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this.g, "home_login_show", "loginshow", 1);
                }
                if (TiebaApplication.B() != null) {
                    this.e.a(true);
                    this.e.a(TiebaApplication.B());
                    this.e.c(TiebaApplication.G());
                    H();
                    a();
                    if (this.f2297a != null) {
                        this.f2297a.a(true);
                    } else if (this.b != null) {
                        this.b.a(true);
                    }
                } else if (this.f2297a != null) {
                    this.f2297a.a(false);
                } else if (this.b != null) {
                    this.b.a(false);
                }
            } else if (this.f.booleanValue()) {
                if (com.baidu.tieba.mention.t.a().n() != this.e.h()) {
                    this.e.a(com.baidu.tieba.mention.t.a().n());
                    z = true;
                }
                if (com.baidu.tieba.mention.t.a().q() != this.e.i()) {
                    this.e.c(com.baidu.tieba.mention.t.a().q());
                    z = true;
                }
                if (this.f2297a != null) {
                    if (z) {
                        this.f2297a.e(this.e);
                    }
                    this.f2297a.a(true);
                }
            } else if (this.b != null) {
                this.b.a(false);
            }
        }
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i2) {
        super.c(i2);
        if (this.f.booleanValue()) {
            if (this.f2297a != null) {
                this.f2297a.a(i2, this.e);
            }
        } else if (this.b != null) {
            this.b.a(i2, this.e);
        }
    }

    public Boolean a(View view, bk bkVar) {
        if (view == bkVar.o()) {
            this.g.finish();
            return true;
        } else if (view == bkVar.p()) {
            MainTabActivity.a(this.g);
            return true;
        } else if (view == bkVar.q()) {
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.e.d() != null) {
                personChangeData.setName(this.e.d().getName_show());
                personChangeData.setIntro(this.e.d().getIntro());
                personChangeData.setSex(this.e.d().getSex());
                personChangeData.setPortrait(this.e.d().getPortrait());
            }
            MoreActivity.a(this.g, 101, personChangeData);
            return true;
        } else if (view == bkVar.r()) {
            LoginActivity.a((Activity) this.g, (String) null, true, 11003);
            return true;
        } else if (view == bkVar.s()) {
            Register2Activity.a(this.g, 12007);
            return true;
        } else if (view == bkVar.t()) {
            CommonWebviewActivity.a(this.g, this.g.getString(R.string.user_icon_intro), c + "?st_type=person_user_icon", true);
            return true;
        } else if (view != bkVar.u()) {
            return false;
        } else {
            if (this.e.c()) {
                if (this.h != null) {
                    this.h.show();
                }
            } else {
                I();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (this.e != null && this.e.d() != null) {
            PersonImageActivity.a(this.g, b(this.g, this.e.d().getPortraitH()));
        }
    }

    private String b(Context context, String str) {
        return ((float) context.getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    @Override // com.baidu.tieba.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        AntiData a2;
        UserData d = this.e.d();
        if (this.f.booleanValue()) {
            if (this.f2297a != null && !a(view, this.f2297a).booleanValue()) {
                if (view == this.f2297a.f()) {
                    if (TiebaApplication.h().t()) {
                        StatService.onEvent(this.g, "personal_my_collect", "personclick", 1);
                    }
                    EditMarkActivity.a(this.g, 102);
                } else if (view == this.f2297a.g()) {
                    new com.baidu.tieba.account.ai("tb_mytieba").start();
                    EditBarActivity.a(this.g, 103, null, d != null ? d.getSex() : 0);
                } else if (view == this.f2297a.h()) {
                    PersonListActivity.a(this.g, true, TiebaApplication.B(), d != null ? d.getSex() : 0);
                } else if (view == this.f2297a.i()) {
                    PersonListActivity.a(this.g, false, TiebaApplication.B(), d != null ? d.getSex() : 0);
                } else if (view == this.f2297a.j()) {
                    if (TiebaApplication.h().t()) {
                        StatService.onEvent(this.g, "personal_my_threads", "click", 1);
                    }
                    if (this.e != null && this.e.d() != null) {
                        PersonPostActivity.a(this.g, TiebaApplication.B(), 0, this.e.d().getPortrait());
                    }
                } else if (view == this.f2297a.k()) {
                    PersonChangeData personChangeData = new PersonChangeData();
                    if (this.e.d() != null) {
                        personChangeData.setName(this.e.d().getName_show());
                        personChangeData.setIntro(this.e.d().getIntro());
                        personChangeData.setSex(this.e.d().getSex());
                        personChangeData.setPortrait(this.e.d().getPortrait());
                    }
                    PersonChangeActivity.a(this.g, 101, personChangeData, true);
                } else if (view == this.f2297a.l() && (a2 = this.e.a()) != null) {
                    AntiHelper.a(this.g, a2, AntiHelper.OperationType.ACCOUNT_RESTORE, AntiHelper.PageType.PERSON_INFO);
                }
            }
        } else if (this.b != null && !a(view, this.b).booleanValue()) {
            if (view == this.b.g()) {
                if (d != null) {
                    EditBarActivity.a(this.g, 103, d.getId(), d.getSex());
                }
            } else if (view == this.b.h()) {
                if (d != null) {
                    if (TiebaApplication.h().t()) {
                        StatService.onEvent(this.g, "personal_his_threads", "click", 1);
                    }
                    PersonPostActivity.a(this.g, d.getId(), d.getSex(), this.e.d().getPortrait());
                }
            } else if (view == this.b.i()) {
                if (d != null) {
                    PersonListActivity.a(this.g, true, d.getId(), d.getSex());
                }
            } else if (view == this.b.j()) {
                if (d != null) {
                    PersonListActivity.a(this.g, false, d.getId(), d.getSex());
                }
            } else if (view == this.b.e()) {
                if (d != null) {
                    if (TiebaApplication.B() == null || TiebaApplication.B().length() <= 0) {
                        LoginActivity.a((Activity) this.g, a(R.string.login_to_attention), true, 11035);
                    } else {
                        J();
                    }
                }
            } else if (view == this.b.f() && d != null) {
                if (TiebaApplication.B() == null || TiebaApplication.B().length() <= 0) {
                    LoginActivity.a((Activity) this.g, a(R.string.login_to_chat), true, 11028);
                } else {
                    K();
                }
            }
        }
    }

    private void J() {
        this.b.a_(this.e);
        this.e.e();
    }

    private void K() {
        if (TiebaApplication.h().t()) {
            StatService.onEvent(this.g, "enter_chat", "personclick", 1);
        }
        ChatActivity.a(this.g, this.e.d().getId(), this.e.d().getName(), this.e.d().getPortrait(), null, null);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        if (this.e.b() != null && this.e.b().length() > 0 && this.e.c() && this.d != null) {
            this.g.unregisterReceiver(this.d);
            this.d = null;
        }
        this.e.l();
        if (this.f.booleanValue()) {
            if (this.f2297a != null) {
                this.f2297a.a();
            }
        } else if (this.b != null) {
            this.b.a();
        }
        DatabaseService.b((Boolean) true);
        super.t();
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i2, int i3, Intent intent) {
        super.a(i2, i3, intent);
        if (i3 == -1) {
            if (i2 == 101) {
                a(intent);
            } else if (i2 == 11003 || i2 == 12007) {
                if (TiebaApplication.B() != null) {
                    this.e.a(true);
                    this.e.a(TiebaApplication.B());
                    this.e.c(TiebaApplication.G());
                    H();
                    a();
                }
            } else if (i2 == 11028) {
                K();
            } else if (i2 == 11035) {
                J();
            } else if (i2 == 12002) {
                if (intent != null) {
                    EditHeadActivity.a(i(), 12002, 12009, intent.getData(), TiebaApplication.F());
                }
            } else if (i2 == 12001) {
                EditHeadActivity.a(i(), 12001, 12010, null, TiebaApplication.F());
            } else if (i2 == 12010 || i2 == 12009) {
                if (this.f.booleanValue() && this.f2297a != null) {
                    this.f2297a.m();
                }
                if (this.e.d() != null) {
                    this.e.f().e(this.e.d().getPortrait());
                }
                this.e.a(false, false);
            }
        } else if (i3 == 0) {
            if (i2 == 12009) {
                com.baidu.tieba.write.bd.c(i());
            } else if (i2 == 12010) {
                com.baidu.tieba.write.bd.a(i());
            }
        }
    }

    private void a(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("person_change_data");
        if (personChangeData != null && this.e.d() != null) {
            this.e.a(personChangeData);
            if (this.f.booleanValue()) {
                if (this.f2297a != null) {
                    this.f2297a.e(this.e);
                }
            } else if (this.b != null) {
                this.b.e(this.e);
            }
            if (personChangeData.getPhotoChanged()) {
                if (this.f.booleanValue()) {
                    if (this.f2297a != null) {
                        this.f2297a.n();
                    }
                } else if (this.b != null) {
                    this.b.n();
                }
                if (this.e.d() != null) {
                    this.e.f().e(this.e.d().getPortrait());
                }
                this.e.a(false, false);
            }
        }
    }

    private void L() {
        String[] strArr = {a(R.string.hd_photo), a(R.string.take_photo), a(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.g);
        builder.setTitle(a(R.string.operation));
        builder.setItems(strArr, new bh(this));
        if (this.h == null) {
            this.h = builder.create();
            this.h.setCanceledOnTouchOutside(true);
        }
    }
}
