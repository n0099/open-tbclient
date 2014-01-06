package com.baidu.tieba.person;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
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
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.person.post.PersonPostActivity;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonInfoActivity extends BaseFragment implements com.baidu.tieba.im.messageCenter.g {
    private BaseFragmentActivity g;
    private static final String c = com.baidu.tieba.data.h.b + "mo/q/topic_page/135_1";
    private static boolean ac = false;
    bt a = null;
    bs b = null;
    private com.baidu.tieba.model.bx d = null;
    private com.baidu.tieba.im.model.b e = null;
    private Boolean f = false;
    private PersonChangeData h = null;
    private AlertDialog i = null;
    private com.baidu.tieba.view.dialog.a Y = null;
    private br Z = null;
    private AlertDialog aa = null;
    private boolean ab = false;

    public static void a(Context context, String str, String str2) {
        Intent intent;
        if (str != null && str.length() > 0 && !str.equals(SocialConstants.FALSE)) {
            if (TiebaApplication.A() != null && TiebaApplication.A().equals(str)) {
                intent = new Intent(context, SingleMyPersonInfoActivity.class);
                intent.putExtra("self", true);
            } else {
                intent = new Intent(context, SinglePersonInfoActivity.class);
                intent.putExtra("self", false);
            }
            intent.putExtra("un", str);
            intent.putExtra(SocialConstants.PARAM_MEDIA_UNAME, str2);
            intent.putExtra("tab_page", false);
            if (!(context instanceof Activity)) {
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
        this.f = Boolean.valueOf(this.d.c());
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
        if (this.e != null) {
            this.e.cancelLoadData();
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
        if (this.d.b() != null && this.d.b().length() > 0 && this.f.booleanValue()) {
            H();
        }
        DatabaseService.b((Boolean) true);
        if (this.d.b() != null && this.d.b().length() > 0) {
            a();
        }
        this.h = new PersonChangeData();
    }

    private View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.person_info_main, (ViewGroup) null);
    }

    private void G() {
        if (this.f.booleanValue()) {
            this.b = null;
            this.a = new bt(this.g, this, this.d);
            this.a.a(new bl(this));
            R();
            return;
        }
        this.a = null;
        this.b = new bs(this.g, this, this.d);
    }

    private void H() {
        this.Z = new br(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(-124, this.Z);
    }

    private void I() {
        com.baidu.tieba.im.messageCenter.e.a().a(this.Z);
    }

    private void c(Bundle bundle) {
        this.e = new com.baidu.tieba.im.model.b();
        this.d = new com.baidu.tieba.model.bx(this.g);
        if (bundle != null) {
            this.d.a(bundle.getBoolean("self", true));
            this.d.a(bundle.getString("un"));
            this.d.c(bundle.getString(SocialConstants.PARAM_MEDIA_UNAME));
            this.d.b(bundle.getBoolean("tab_page", false));
            this.d.c(bundle.getBoolean("tab_msg", false));
        } else {
            Bundle h = h();
            if (h != null) {
                this.d.a(h.getBoolean("self", true));
                this.d.a(h.getString("un"));
                this.d.c(h.getString(SocialConstants.PARAM_MEDIA_UNAME));
                this.d.b(h.getBoolean("tab_page", false));
                this.d.c(h.getBoolean("tab_msg", false));
            }
        }
        N();
        this.d.setLoadDataCallBack(new bm(this));
    }

    public void a() {
        if (this.f.booleanValue()) {
            if (this.a != null) {
                this.a.c(this.d);
            }
            this.d.a(true, true);
            return;
        }
        if (this.b != null) {
            this.b.c(this.d);
        }
        this.d.a(false, true);
    }

    @Override // android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        super.e(bundle);
        if (this.d != null) {
            bundle.putBoolean("self", this.d.c());
            bundle.putString("un", this.d.b());
            bundle.putString(SocialConstants.PARAM_MEDIA_UNAME, this.d.g());
            bundle.putBoolean("tab_page", this.d.i());
            bundle.putBoolean("tab_msg", this.d.j());
        }
    }

    public static void a(boolean z) {
        ac = z;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        boolean z = false;
        super.r();
        if (ac) {
            a();
            ac = false;
        } else if (F()) {
            this.f = Boolean.valueOf(this.d.c());
            if (this.d.b() == null || this.d.b().length() <= 0) {
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.g, "home_login_show", "loginshow", 1);
                }
                if (TiebaApplication.A() != null) {
                    this.d.a(true);
                    this.d.a(TiebaApplication.A());
                    this.d.c(TiebaApplication.G());
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
            } else if (this.f.booleanValue()) {
                if (com.baidu.tieba.mention.s.a().o() != this.d.h()) {
                    this.d.a(com.baidu.tieba.mention.s.a().o());
                    z = true;
                }
                if (this.a != null) {
                    if (z) {
                        this.a.e(this.d);
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
        if (this.f.booleanValue()) {
            if (this.a != null) {
                this.a.a(i, this.d);
            }
        } else if (this.b != null) {
            this.b.a(i, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        String name = this.d.d() != null ? this.d.d().getName() : null;
        if (name != null) {
            if (this.aa == null) {
                K();
            }
            this.aa.setMessage(this.e.b() == 1 ? String.format(a(R.string.black_list_ensure_toremove_text), name) : String.format(a(R.string.remove_black_alert), name));
            this.aa.show();
        }
    }

    private void K() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.g);
        builder.setPositiveButton(a(R.string.confirm), new bn(this));
        builder.setNegativeButton(a(R.string.cancel), new bo(this));
        this.aa = builder.create();
    }

    private void L() {
        M();
        this.Y.b();
    }

    private void M() {
        this.Y = new com.baidu.tieba.view.dialog.a(this.g);
        this.Y.a(new Object[]{this.g.getString(this.e.b() == 1 ? R.string.delete_to_black_list : R.string.add_to_black_list), new Object[]{this.g.getString(R.string.cancel), 1}}, new bp(this)).a(R.style.dialog_ani_b2t).b(80).a();
    }

    public Boolean a(View view, bu buVar) {
        if (view == buVar.o()) {
            this.g.finish();
            return true;
        } else if (view == buVar.p()) {
            MainTabActivity.a(this.g);
            return true;
        } else if (view == buVar.q()) {
            if (this.e.b() == 2) {
                N();
                this.ab = true;
                return false;
            }
            L();
            return false;
        } else if (view == buVar.r()) {
            LoginActivity.a((Activity) this.g, (String) null, true, 11003);
            return true;
        } else if (view == buVar.s()) {
            Register2Activity.a(this.g, 12007);
            return true;
        } else if (view == buVar.t()) {
            CommonWebviewActivity.a(this.g, this.g.getString(R.string.user_icon_intro), c + "?st_type=person_user_icon", true);
            return true;
        } else if (view != buVar.u()) {
            return false;
        } else {
            if (this.d.c()) {
                if (this.i != null) {
                    this.i.show();
                }
            } else {
                O();
            }
            return true;
        }
    }

    private void N() {
        int a = com.baidu.adp.lib.f.b.a(this.d.b(), -1);
        if (a > 0 && !this.d.c()) {
            this.e.a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (this.d != null && this.d.d() != null) {
            PersonImageActivity.a(this.g, b(this.g, this.d.d().getPortraitH()));
        }
    }

    private String b(Context context, String str) {
        return ((float) context.getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    @Override // com.baidu.tieba.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        AntiData a;
        UserData d = this.d.d();
        if (this.f.booleanValue()) {
            if (this.a != null && !a(view, this.a).booleanValue()) {
                if (view == this.a.l()) {
                    String A = TiebaApplication.A();
                    if ((A == null || A.length() <= 0) && DatabaseService.m() <= 0) {
                        LoginActivity.a(this.g, 1, a(R.string.login_manage_account), 11003);
                    } else {
                        AccountActivity.a(this.g);
                    }
                } else if (view == this.a.f()) {
                    new com.baidu.tieba.account.av("tb_mytieba").start();
                    EditBarActivity.a(this.g, 103, null, d != null ? d.getSex() : 0);
                } else if (view == this.a.g()) {
                    PersonListActivity.a(this.g, true, TiebaApplication.A(), d != null ? d.getSex() : 0);
                } else if (view == this.a.h()) {
                    PersonListActivity.a(this.g, false, TiebaApplication.A(), d != null ? d.getSex() : 0);
                } else if (view == this.a.i()) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this.g, "personal_my_threads", "click", 1);
                    }
                    if (this.d != null && this.d.d() != null) {
                        PersonPostActivity.a(this.g, TiebaApplication.A(), 0, this.d.d().getPortrait());
                    }
                } else if (view == this.a.j()) {
                    PersonChangeData personChangeData = new PersonChangeData();
                    if (this.d.d() != null) {
                        personChangeData.setName(this.d.d().getName_show());
                        personChangeData.setIntro(this.d.d().getIntro());
                        personChangeData.setSex(this.d.d().getSex());
                        personChangeData.setPortrait(this.d.d().getPortrait());
                    }
                    PersonChangeActivity.a(this.g, 101, personChangeData, true);
                } else if (view == this.a.k() && (a = this.d.a()) != null) {
                    AntiHelper.a(this.g, a, AntiHelper.OperationType.ACCOUNT_RESTORE, AntiHelper.PageType.PERSON_INFO);
                }
            }
        } else if (this.b != null && !a(view, this.b).booleanValue()) {
            if (view == this.b.g()) {
                if (d != null) {
                    EditBarActivity.a(this.g, 103, d.getId(), d.getSex());
                }
            } else if (view == this.b.h()) {
                if (d != null) {
                    if (TiebaApplication.g().s()) {
                        StatService.onEvent(this.g, "personal_his_threads", "click", 1);
                    }
                    PersonPostActivity.a(this.g, d.getId(), d.getSex(), this.d.d().getPortrait());
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
                    if (TiebaApplication.A() == null || TiebaApplication.A().length() <= 0) {
                        LoginActivity.a((Activity) this.g, a(R.string.login_to_attention), true, 11035);
                    } else {
                        P();
                    }
                }
            } else if (view == this.b.f()) {
                com.baidu.tieba.ap.a(this.g, "person_info_send_message");
                new com.baidu.tieba.account.av("pchat", "3").start();
                if (d != null) {
                    if (TiebaApplication.A() == null || TiebaApplication.A().length() <= 0) {
                        LoginActivity.a((Activity) this.g, a(R.string.login_to_chat), true, 11028);
                    } else {
                        Q();
                    }
                }
            }
        }
    }

    private void P() {
        this.b.a_(this.d);
        this.d.e();
    }

    private void Q() {
        if (TiebaApplication.g().s()) {
            StatService.onEvent(this.g, "enter_chat", "personclick", 1);
        }
        try {
            PersonalChatActivity.a(this.g, Long.parseLong(this.d.d().getId()), this.d.d().getName(), this.d.d().getPortrait(), this.d.d().getSex(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        if (this.d != null) {
            if (this.d.b() != null && this.d.b().length() > 0 && this.d.c()) {
                I();
            }
            this.d.k();
        }
        if (this.f.booleanValue()) {
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
                if (TiebaApplication.A() != null) {
                    this.d.a(true);
                    this.d.a(TiebaApplication.A());
                    this.d.c(TiebaApplication.G());
                    H();
                    a();
                }
            } else if (i == 11028) {
                Q();
            } else if (i == 11035) {
                P();
            } else if (i == 12002) {
                if (intent != null) {
                    EditHeadActivity.a(i(), 12002, 12009, intent.getData(), TiebaApplication.F());
                }
            } else if (i == 12001) {
                EditHeadActivity.a(i(), 12001, 12010, null, TiebaApplication.F());
            } else if (i == 12010 || i == 12009) {
                if (this.h != null) {
                    this.h.setPhotoChanged(true);
                }
                MoreDiscoveryActivity.a(true);
                if (this.f.booleanValue() && this.a != null) {
                    this.a.m();
                }
                if (this.d.d() != null) {
                    this.d.f().e(this.d.d().getPortrait());
                }
                this.d.a(false, false);
            }
        } else if (i2 == 0) {
            if (i == 12009) {
                com.baidu.tieba.write.bb.c(i());
            } else if (i == 12010) {
                com.baidu.tieba.write.bb.a(i());
            }
        }
    }

    private void a(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("person_change_data");
        if (personChangeData != null && this.d.d() != null) {
            this.d.a(personChangeData);
            if (this.f.booleanValue()) {
                if (this.a != null) {
                    this.a.e(this.d);
                }
            } else if (this.b != null) {
                this.b.e(this.d);
            }
            if (personChangeData.getPhotoChanged()) {
                if (this.h != null) {
                    this.h.setPhotoChanged(true);
                }
                MoreDiscoveryActivity.a(true);
                if (this.f.booleanValue()) {
                    if (this.a != null) {
                        this.a.n();
                    }
                } else if (this.b != null) {
                    this.b.n();
                }
                if (this.d.d() != null) {
                    this.d.f().e(this.d.d().getPortrait());
                }
                this.d.a(false, false);
            }
        }
    }

    private void R() {
        String[] strArr = {a(R.string.hd_photo), a(R.string.take_photo), a(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.g);
        builder.setTitle(a(R.string.operation));
        builder.setItems(strArr, new bq(this));
        if (this.i == null) {
            this.i = builder.create();
            this.i.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.o oVar) {
        if (oVar == null) {
            this.ab = false;
            return;
        }
        if (oVar.u() == 104102 && (oVar instanceof com.baidu.tieba.im.message.ca)) {
            com.baidu.tieba.im.message.ca caVar = (com.baidu.tieba.im.message.ca) oVar;
            com.baidu.tieba.im.message.o l = caVar.l();
            if (l != null && (l instanceof com.baidu.tieba.im.message.aw)) {
                com.baidu.tieba.im.message.aw awVar = (com.baidu.tieba.im.message.aw) l;
                if (awVar.b() == 10) {
                    if (awVar.c() == 1) {
                        this.e.b(1);
                    } else {
                        this.e.b(0);
                    }
                    if (caVar.i()) {
                        a(caVar.k());
                        return;
                    }
                    if (this.e.b() == 1) {
                        a(this.g.getString(R.string.black_list_added));
                    } else {
                        a(this.g.getString(R.string.black_list_remove_success));
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
        } else if (oVar.u() == 104104 && (oVar instanceof com.baidu.tieba.im.message.az)) {
            this.e.b(((com.baidu.tieba.im.message.az) oVar).a() ? 1 : 0);
            if (this.ab) {
                L();
            }
        }
        this.ab = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.im.message.o oVar) {
        if (oVar != null) {
            if (!(oVar instanceof com.baidu.tieba.im.message.r)) {
                com.baidu.adp.lib.h.e.a("transform error");
                return;
            }
            int c2 = ((com.baidu.tieba.im.message.r) oVar).c();
            if (this.d != null) {
                this.d.a(c2);
            }
            if (this.a != null) {
                this.a.e(this.d);
            }
        }
    }
}
