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
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.more.MoreActivity;
import com.baidu.tieba.person.post.PersonPostActivity;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonInfoActivity extends BaseFragment implements com.baidu.tieba.im.messageCenter.g {
    private BaseFragmentActivity h;
    private static final String c = com.baidu.tieba.data.h.b + "mo/q/topic_page/135_1";
    private static boolean ab = false;
    private BroadcastReceiver d = null;
    bm a = null;
    bl b = null;
    private com.baidu.tieba.model.bx e = null;
    private com.baidu.tieba.im.model.b f = null;
    private Boolean g = false;
    private AlertDialog i = null;
    private com.baidu.tieba.view.dialog.a Y = null;
    private AlertDialog Z = null;
    private boolean aa = false;

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
        this.h = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c(bundle);
        this.g = Boolean.valueOf(this.e.c());
        return a(layoutInflater);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void e() {
        super.e();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void c_() {
        super.c_();
        com.baidu.tieba.im.messageCenter.e.a().a(104102, this);
        com.baidu.tieba.im.messageCenter.e.a().a(104104, this);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d() {
        super.d();
        com.baidu.tieba.im.messageCenter.e.a().a(this);
        if (this.f != null) {
            this.f.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        G();
        if (this.e.b() != null && this.e.b().length() > 0 && this.g.booleanValue()) {
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
        if (this.g.booleanValue()) {
            this.b = null;
            this.a = new bm(this.h, this, this.e);
            this.a.a(new be(this));
            Q();
            return;
        }
        this.a = null;
        this.b = new bl(this.h, this, this.e);
    }

    private void H() {
        if (this.d == null) {
            this.d = new bf(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.tieba.broadcast.notify");
            this.h.registerReceiver(this.d, intentFilter);
        }
    }

    private void c(Bundle bundle) {
        this.f = new com.baidu.tieba.im.model.b();
        this.e = new com.baidu.tieba.model.bx(this.h);
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
        M();
        this.e.setLoadDataCallBack(new bg(this));
    }

    public void a() {
        if (this.g.booleanValue()) {
            if (this.a != null) {
                this.a.c(this.e);
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
        ab = z;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        boolean z = false;
        super.r();
        if (ab) {
            a();
            ab = false;
        } else if (F()) {
            this.g = Boolean.valueOf(this.e.c());
            if (this.e.b() == null || this.e.b().length() <= 0) {
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this.h, "home_login_show", "loginshow", 1);
                }
                if (TiebaApplication.B() != null) {
                    this.e.a(true);
                    this.e.a(TiebaApplication.B());
                    this.e.c(TiebaApplication.G());
                    H();
                    a();
                    if (this.a != null) {
                        this.a.a(true);
                    } else if (this.b != null) {
                        this.b.a(true);
                    }
                } else if (this.a != null) {
                    this.a.a(false);
                } else if (this.b != null) {
                    this.b.a(false);
                }
            } else if (this.g.booleanValue()) {
                if (com.baidu.tieba.mention.t.a().o() != this.e.h()) {
                    this.e.a(com.baidu.tieba.mention.t.a().o());
                    z = true;
                }
                if (com.baidu.tieba.mention.t.a().r() != this.e.i()) {
                    this.e.c(com.baidu.tieba.mention.t.a().r());
                    z = true;
                }
                if (this.a != null) {
                    if (z) {
                        this.a.e(this.e);
                    }
                    this.a.a(true);
                }
            } else if (this.b != null) {
                this.b.a(false);
            }
        }
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        super.c(i);
        if (this.g.booleanValue()) {
            if (this.a != null) {
                this.a.a(i, this.e);
            }
        } else if (this.b != null) {
            this.b.a(i, this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        String name = this.e.d() != null ? this.e.d().getName() : null;
        if (name != null) {
            if (this.Z == null) {
                J();
            }
            this.Z.setMessage(this.f.b() == 1 ? String.format(a(R.string.black_list_ensure_toremove_text), name) : String.format(a(R.string.remove_black_alert), name));
            this.Z.show();
        }
    }

    private void J() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.h);
        builder.setPositiveButton(a(R.string.confirm), new bh(this));
        builder.setNegativeButton(a(R.string.cancel), new bi(this));
        this.Z = builder.create();
    }

    private void K() {
        L();
        this.Y.b();
    }

    private void L() {
        this.Y = new com.baidu.tieba.view.dialog.a(this.h);
        this.Y.a(new Object[]{this.h.getString(this.f.b() == 1 ? R.string.delete_to_black_list : R.string.add_to_black_list), new Object[]{this.h.getString(R.string.cancel), 1}}, new bj(this)).a(R.style.dialog_ani_b2t).b(80).a();
    }

    public Boolean a(View view, bn bnVar) {
        if (view == bnVar.o()) {
            this.h.finish();
            return true;
        } else if (view == bnVar.p()) {
            MainTabActivity.a(this.h);
            return true;
        } else if (view == bnVar.q()) {
            if (this.f.b() == 2) {
                M();
                this.aa = true;
                return false;
            }
            K();
            return false;
        } else if (view == bnVar.r()) {
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.e.d() != null) {
                personChangeData.setName(this.e.d().getName_show());
                personChangeData.setIntro(this.e.d().getIntro());
                personChangeData.setSex(this.e.d().getSex());
                personChangeData.setPortrait(this.e.d().getPortrait());
            }
            MoreActivity.a(this.h, 101, personChangeData);
            return true;
        } else if (view == bnVar.s()) {
            LoginActivity.a((Activity) this.h, (String) null, true, 11003);
            return true;
        } else if (view == bnVar.t()) {
            Register2Activity.a(this.h, 12007);
            return true;
        } else if (view == bnVar.u()) {
            CommonWebviewActivity.a(this.h, this.h.getString(R.string.user_icon_intro), c + "?st_type=person_user_icon", true);
            return true;
        } else if (view != bnVar.v()) {
            return false;
        } else {
            if (this.e.c()) {
                if (this.i != null) {
                    this.i.show();
                }
            } else {
                N();
            }
            return true;
        }
    }

    private void M() {
        int a = com.baidu.adp.lib.f.b.a(this.e.b(), -1);
        if (a > 0 && !this.e.c()) {
            this.f.a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        if (this.e != null && this.e.d() != null) {
            PersonImageActivity.a(this.h, b(this.h, this.e.d().getPortraitH()));
        }
    }

    private String b(Context context, String str) {
        return ((float) context.getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    @Override // com.baidu.tieba.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        AntiData a;
        UserData d = this.e.d();
        if (this.g.booleanValue()) {
            if (this.a != null && !a(view, this.a).booleanValue()) {
                if (view == this.a.f()) {
                    if (TiebaApplication.h().t()) {
                        StatService.onEvent(this.h, "personal_my_collect", "personclick", 1);
                    }
                    EditMarkActivity.a(this.h, 102);
                } else if (view == this.a.g()) {
                    new com.baidu.tieba.account.av("tb_mytieba").start();
                    EditBarActivity.a(this.h, 103, null, d != null ? d.getSex() : 0);
                } else if (view == this.a.h()) {
                    PersonListActivity.a(this.h, true, TiebaApplication.B(), d != null ? d.getSex() : 0);
                } else if (view == this.a.i()) {
                    PersonListActivity.a(this.h, false, TiebaApplication.B(), d != null ? d.getSex() : 0);
                } else if (view == this.a.j()) {
                    if (TiebaApplication.h().t()) {
                        StatService.onEvent(this.h, "personal_my_threads", "click", 1);
                    }
                    if (this.e != null && this.e.d() != null) {
                        PersonPostActivity.a(this.h, TiebaApplication.B(), 0, this.e.d().getPortrait());
                    }
                } else if (view == this.a.k()) {
                    PersonChangeData personChangeData = new PersonChangeData();
                    if (this.e.d() != null) {
                        personChangeData.setName(this.e.d().getName_show());
                        personChangeData.setIntro(this.e.d().getIntro());
                        personChangeData.setSex(this.e.d().getSex());
                        personChangeData.setPortrait(this.e.d().getPortrait());
                    }
                    PersonChangeActivity.a(this.h, 101, personChangeData, true);
                } else if (view == this.a.l() && (a = this.e.a()) != null) {
                    AntiHelper.a(this.h, a, AntiHelper.OperationType.ACCOUNT_RESTORE, AntiHelper.PageType.PERSON_INFO);
                }
            }
        } else if (this.b != null && !a(view, this.b).booleanValue()) {
            if (view == this.b.g()) {
                if (d != null) {
                    EditBarActivity.a(this.h, 103, d.getId(), d.getSex());
                }
            } else if (view == this.b.h()) {
                if (d != null) {
                    if (TiebaApplication.h().t()) {
                        StatService.onEvent(this.h, "personal_his_threads", "click", 1);
                    }
                    PersonPostActivity.a(this.h, d.getId(), d.getSex(), this.e.d().getPortrait());
                }
            } else if (view == this.b.i()) {
                if (d != null) {
                    PersonListActivity.a(this.h, true, d.getId(), d.getSex());
                }
            } else if (view == this.b.j()) {
                if (d != null) {
                    PersonListActivity.a(this.h, false, d.getId(), d.getSex());
                }
            } else if (view == this.b.e()) {
                if (d != null) {
                    if (TiebaApplication.B() == null || TiebaApplication.B().length() <= 0) {
                        LoginActivity.a((Activity) this.h, a(R.string.login_to_attention), true, 11035);
                    } else {
                        O();
                    }
                }
            } else if (view == this.b.f()) {
                com.baidu.tieba.ao.a(this.h, "person_info_send_message");
                new com.baidu.tieba.account.av("pchat", "3").start();
                if (d != null) {
                    if (TiebaApplication.B() == null || TiebaApplication.B().length() <= 0) {
                        LoginActivity.a((Activity) this.h, a(R.string.login_to_chat), true, 11028);
                    } else {
                        P();
                    }
                }
            }
        }
    }

    private void O() {
        this.b.a_(this.e);
        this.e.e();
    }

    private void P() {
        if (TiebaApplication.h().t()) {
            StatService.onEvent(this.h, "enter_chat", "personclick", 1);
        }
        try {
            PersonalChatActivity.a(this.h, Long.parseLong(this.e.d().getId()), this.e.d().getName(), this.e.d().getPortrait(), this.e.d().getSex(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        if (this.e.b() != null && this.e.b().length() > 0 && this.e.c() && this.d != null) {
            this.h.unregisterReceiver(this.d);
            this.d = null;
        }
        this.e.l();
        if (this.g.booleanValue()) {
            if (this.a != null) {
                this.a.a();
            }
        } else if (this.b != null) {
            this.b.a();
        }
        DatabaseService.b((Boolean) true);
        super.t();
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                a(intent);
            } else if (i == 11003 || i == 12007) {
                if (TiebaApplication.B() != null) {
                    this.e.a(true);
                    this.e.a(TiebaApplication.B());
                    this.e.c(TiebaApplication.G());
                    H();
                    a();
                }
            } else if (i == 11028) {
                P();
            } else if (i == 11035) {
                O();
            } else if (i == 12002) {
                if (intent != null) {
                    EditHeadActivity.a(i(), 12002, 12009, intent.getData(), TiebaApplication.F());
                }
            } else if (i == 12001) {
                EditHeadActivity.a(i(), 12001, 12010, null, TiebaApplication.F());
            } else if (i == 12010 || i == 12009) {
                if (this.g.booleanValue() && this.a != null) {
                    this.a.m();
                }
                if (this.e.d() != null) {
                    this.e.f().e(this.e.d().getPortrait());
                }
                this.e.a(false, false);
            }
        } else if (i2 == 0) {
            if (i == 12009) {
                com.baidu.tieba.write.bd.c(i());
            } else if (i == 12010) {
                com.baidu.tieba.write.bd.a(i());
            }
        }
    }

    private void a(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("person_change_data");
        if (personChangeData != null && this.e.d() != null) {
            this.e.a(personChangeData);
            if (this.g.booleanValue()) {
                if (this.a != null) {
                    this.a.e(this.e);
                }
            } else if (this.b != null) {
                this.b.e(this.e);
            }
            if (personChangeData.getPhotoChanged()) {
                if (this.g.booleanValue()) {
                    if (this.a != null) {
                        this.a.n();
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

    private void Q() {
        String[] strArr = {a(R.string.hd_photo), a(R.string.take_photo), a(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.h);
        builder.setTitle(a(R.string.operation));
        builder.setItems(strArr, new bk(this));
        if (this.i == null) {
            this.i = builder.create();
            this.i.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.n nVar) {
        if (nVar == null) {
            this.aa = false;
            return;
        }
        if (nVar.t() == 104102 && (nVar instanceof com.baidu.tieba.im.message.bx)) {
            com.baidu.tieba.im.message.bx bxVar = (com.baidu.tieba.im.message.bx) nVar;
            com.baidu.tieba.im.message.n l = bxVar.l();
            if (l != null && (l instanceof com.baidu.tieba.im.message.at)) {
                com.baidu.tieba.im.message.at atVar = (com.baidu.tieba.im.message.at) l;
                if (atVar.b() == 10) {
                    if (atVar.c() == 1) {
                        this.f.b(1);
                    } else {
                        this.f.b(0);
                    }
                    if (bxVar.i()) {
                        a(bxVar.k());
                        return;
                    }
                    if (this.f.b() == 1) {
                        a(this.h.getString(R.string.black_list_added));
                    } else {
                        a(this.h.getString(R.string.black_list_remove_success));
                    }
                    if (this.Y != null) {
                        this.Y.c();
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (nVar.t() == 104104 && (nVar instanceof com.baidu.tieba.im.message.aw)) {
            this.f.b(((com.baidu.tieba.im.message.aw) nVar).a() ? 1 : 0);
            if (this.aa) {
                K();
            }
        }
        this.aa = false;
    }
}
