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
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.person.post.PersonPostActivity;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.TbWebViewActivity;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class cm extends com.baidu.tieba.j implements com.baidu.tieba.im.messageCenter.g {
    private static final String b = String.valueOf(com.baidu.tieba.data.i.b) + "mo/q/topic_page/135_1";
    private static boolean s = false;
    private com.baidu.tieba.k f;
    private bj m;
    private List<View> o;
    private bg p;
    private bc q;
    private bc r;
    private com.baidu.tieba.model.bp c = null;
    private com.baidu.tieba.im.model.b d = null;
    private Boolean e = false;
    private PersonChangeData g = null;
    private AlertDialog h = null;
    private com.baidu.tieba.view.dialog.d i = null;
    private cw j = null;
    private AlertDialog k = null;
    private boolean l = false;
    private boolean n = false;

    public boolean a() {
        return this.n;
    }

    public void a(boolean z) {
        this.n = z;
    }

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

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f = (com.baidu.tieba.k) activity;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a(bundle);
        this.e = Boolean.valueOf(this.c.e());
        i();
        return a(layoutInflater);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        com.baidu.tieba.im.messageCenter.e.a().a(104102, this);
        com.baidu.tieba.im.messageCenter.e.a().a(104104, this);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.im.messageCenter.e.a().a(this);
        if (this.d != null) {
            this.d.cancelLoadData();
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        f();
        if (this.c.d() != null && this.c.d().length() > 0 && this.e.booleanValue()) {
            g();
        }
        DatabaseService.b((Boolean) true);
        if (this.c.d() != null && this.c.d().length() > 0) {
            e();
        }
        this.g = new PersonChangeData();
    }

    private View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.person_center_view, (ViewGroup) null);
    }

    private void f() {
        this.m = new bj(this.f, this);
        t();
        this.m.setScrollToBottomListener(new cn(this));
        this.m.setCoverListRefreshListener(new co(this));
        this.m.setLoadMoreOnClickListener(new cp(this));
    }

    private void g() {
        this.j = new cw(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(-124, this.j);
    }

    private void h() {
        com.baidu.tieba.im.messageCenter.e.a().a(this.j);
    }

    private void a(Bundle bundle) {
        this.d = new com.baidu.tieba.im.model.b();
        this.c = new com.baidu.tieba.model.bp(this.f);
        this.c.a(new cq(this));
        if (bundle != null) {
            this.c.b(bundle.getBoolean("self", true));
            this.c.a(bundle.getString("un"));
            this.c.c(bundle.getString(SocialConstants.PARAM_MEDIA_UNAME));
            this.c.c(bundle.getBoolean("tab_page", false));
            this.c.d(bundle.getBoolean("tab_msg", false));
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.c.b(arguments.getBoolean("self", true));
                this.c.a(arguments.getString("un"));
                this.c.c(arguments.getString(SocialConstants.PARAM_MEDIA_UNAME));
                this.c.c(arguments.getBoolean("tab_page", false));
                this.c.d(arguments.getBoolean("tab_msg", false));
            }
        }
        p();
        this.c.setLoadDataCallBack(new cr(this));
    }

    private void i() {
        this.o = null;
        this.o = new ArrayList();
        if (this.e.booleanValue()) {
            this.q = new bc(this.f, this, 1);
        } else {
            this.q = new bc(this.f, this, 3);
        }
        this.r = new bc(this.f, this, 2);
        this.o.add(this.q);
        this.o.add(this.r);
        this.p = new bg(this.f, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.o = null;
        this.o = new ArrayList();
        if (this.c.e()) {
            this.q.a(this.c, 1);
        } else {
            this.q.a(this.c, 3);
        }
        this.r.a(this.c, 2);
        this.o.add(this.q);
        this.o.add(this.r);
    }

    public List<View> c() {
        return this.o;
    }

    public bg d() {
        return this.p;
    }

    public void e() {
        if (this.m != null) {
            this.m.d();
        }
        this.c.a(true, true, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.c.a(false, true, 2);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.c != null) {
            bundle.putBoolean("self", this.c.e());
            bundle.putString("un", this.c.d());
            bundle.putString(SocialConstants.PARAM_MEDIA_UNAME, this.c.i());
            bundle.putBoolean("tab_page", this.c.k());
            bundle.putBoolean("tab_msg", this.c.l());
        }
    }

    public static void b(boolean z) {
        s = z;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onResume() {
        boolean z = false;
        super.onResume();
        if (s) {
            e();
            s = false;
        } else if (b()) {
            this.e = Boolean.valueOf(this.c.e());
            if (this.c.d() == null || this.c.d().length() <= 0) {
                com.baidu.tieba.util.cb.a(this.f, "home_login_show", "loginshow", 1, new Object[0]);
                if (TiebaApplication.A() != null) {
                    this.c.b(true);
                    this.c.a(TiebaApplication.A());
                    this.c.c(TiebaApplication.F());
                    g();
                    e();
                }
            } else if (this.e.booleanValue()) {
                if (com.baidu.tieba.mention.v.a().o() != this.c.j()) {
                    this.c.a(com.baidu.tieba.mention.v.a().o());
                    z = true;
                }
                if (z && this.c.j() > 0) {
                    this.c.a(this.c.j());
                    this.p.a(true);
                    this.p.b();
                    this.m.i();
                }
            }
        }
    }

    @Override // com.baidu.tieba.j
    public void c(int i) {
        this.m.a(i);
        this.p.a(i);
        this.q.a(i);
        this.r.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        String format;
        String userName = this.c.f() != null ? this.c.f().getUserName() : null;
        if (userName != null) {
            if (this.k == null) {
                m();
            }
            if (this.d.b() == 1) {
                format = String.format(getString(R.string.black_list_ensure_toremove_text), userName);
            } else {
                format = String.format(getString(R.string.remove_black_alert), userName);
            }
            this.k.setMessage(format);
            this.k.show();
        }
    }

    private void m() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f);
        builder.setPositiveButton(getString(R.string.confirm), new cs(this));
        builder.setNegativeButton(getString(R.string.cancel), new ct(this));
        this.k = builder.create();
    }

    private void n() {
        o();
        this.i.b();
    }

    private void o() {
        this.i = new com.baidu.tieba.view.dialog.d(this.f);
        this.i.a(new Object[]{this.f.getString(this.d.b() == 1 ? R.string.delete_to_black_list : R.string.add_to_black_list), new Object[]{this.f.getString(R.string.cancel), 1}}, new cu(this)).a(R.style.dialog_ani_b2t).b(80).a();
    }

    private void p() {
        int a = com.baidu.adp.lib.f.b.a(this.c.d(), -1);
        if (a > 0 && !this.c.e()) {
            this.d.a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.c != null && this.c.f() != null) {
            PersonImageActivity.a(this.f, a(this.f, this.c.f().getPortraitH()));
        }
    }

    private String a(Context context, String str) {
        return ((float) context.getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void r() {
        this.c.g();
    }

    private void s() {
        com.baidu.tieba.util.cb.a(this.f, "enter_chat", "personclick", 1, new Object[0]);
        try {
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001002, new com.baidu.tieba.a.c(this.f, Long.parseLong(this.c.f().getUserId()), this.c.f().getUserName(), this.c.f().getPortrait(), this.c.f().getSex())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.c != null) {
            if (this.c.d() != null && this.c.d().length() > 0 && this.c.e()) {
                h();
            }
            this.c.m();
        }
        DatabaseService.b((Boolean) true);
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                a(intent);
            } else if (i == 11003 || i == 12007) {
                if (TiebaApplication.A() != null) {
                    this.c.b(true);
                    this.c.a(TiebaApplication.A());
                    this.c.c(TiebaApplication.F());
                    g();
                    e();
                }
            } else if (i == 11028) {
                s();
            } else if (i == 11035) {
                r();
            } else if (i == 12002) {
                if (intent != null) {
                    EditHeadActivity.a(getActivity(), 12002, 12009, intent.getData(), TiebaApplication.E());
                }
            } else if (i == 12001) {
                EditHeadActivity.a(getActivity(), 12001, 12010, null, TiebaApplication.E());
            } else if (i == 12010 || i == 12009) {
                if (this.g != null) {
                    this.g.setPhotoChanged(true);
                }
                ai.a(true);
                if (this.c.f() != null) {
                    this.c.h().e(this.c.f().getPortrait());
                }
                e();
            }
        } else if (i2 == 0) {
            if (i == 12009) {
                com.baidu.tieba.write.bz.d(getActivity());
            } else if (i == 12010) {
                com.baidu.tieba.write.bz.a(getActivity());
            }
        }
    }

    private void a(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("person_change_data");
        if (personChangeData != null && this.c.f() != null) {
            this.c.a(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.g != null) {
                    this.g.setPhotoChanged(true);
                }
                ai.a(true);
                if (this.c.f() != null) {
                    this.c.h().e(this.c.f().getPortrait());
                }
            }
            e();
        }
    }

    private void t() {
        String[] strArr = {getString(R.string.hd_photo), getString(R.string.take_photo), getString(R.string.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(strArr, new cv(this));
        if (this.h == null) {
            this.h = builder.create();
            this.h.setCanceledOnTouchOutside(true);
        }
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar == null) {
            this.l = false;
            return;
        }
        if (sVar.w() == 104102 && (sVar instanceof com.baidu.tieba.im.message.cx)) {
            com.baidu.tieba.im.message.cx cxVar = (com.baidu.tieba.im.message.cx) sVar;
            com.baidu.tieba.im.message.s o = cxVar.o();
            if (o != null && (o instanceof com.baidu.tieba.im.message.bj)) {
                com.baidu.tieba.im.message.bj bjVar = (com.baidu.tieba.im.message.bj) o;
                if (bjVar.b() == 10) {
                    if (bjVar.c() == 1) {
                        this.d.b(1);
                    } else {
                        this.d.b(0);
                    }
                    if (cxVar.l()) {
                        a(cxVar.n());
                        return;
                    }
                    if (this.d.b() == 1) {
                        a(this.f.getString(R.string.black_list_added));
                    } else {
                        a(this.f.getString(R.string.black_list_remove_success));
                    }
                    if (this.i != null) {
                        this.i.c();
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (sVar.w() == 104104 && (sVar instanceof com.baidu.tieba.im.message.bo)) {
            this.d.b(((com.baidu.tieba.im.message.bo) sVar).a() ? 1 : 0);
            if (this.l) {
                n();
            }
        }
        this.l = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.im.message.s sVar) {
        if (sVar != null) {
            if (!(sVar instanceof com.baidu.tieba.im.message.v)) {
                com.baidu.adp.lib.util.f.b("transform error");
                return;
            }
            int c = ((com.baidu.tieba.im.message.v) sVar).c();
            if (this.c != null && c > 0) {
                this.c.a(c);
                this.p.a(true);
                this.p.b();
                this.m.i();
            }
        }
    }

    @Override // com.baidu.tieba.j, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.p.getBackBtn().getId()) {
            this.f.finish();
        } else if (view.getId() == this.p.getEditBtn().getId()) {
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.c.f() != null) {
                personChangeData.setName(this.c.f().getName_show());
                personChangeData.setIntro(this.c.f().getIntro());
                personChangeData.setSex(this.c.f().getSex());
                personChangeData.setPortrait(this.c.f().getPortrait());
            }
            PersonChangeActivity.a(this.f, SocialAPIErrorCodes.ERROR_INVALID_CLIENT_ID, personChangeData, true);
            com.baidu.tieba.ai.a(this.f, "person_editprofile_click");
        } else if (view.getId() == this.q.getAttentionBtn().getId()) {
            if (this.c.f() != null) {
                if (TiebaApplication.A() == null || TiebaApplication.A().length() <= 0) {
                    LoginActivity.a((Activity) this.f, this.f.getResources().getString(R.string.login_to_attention), true, 11035);
                } else if (!this.c.e()) {
                    r();
                } else {
                    AntiHelper.a(this.f, this.c.c(), AntiHelper.OperationType.ACCOUNT_RESTORE, AntiHelper.PageType.PERSON_INFO);
                }
            }
        } else if (view.getId() == this.q.getSendBtn().getId()) {
            if (this.c.f() != null) {
                if (TiebaApplication.A() == null || TiebaApplication.A().length() <= 0) {
                    LoginActivity.a((Activity) this.f, this.f.getResources().getString(R.string.login_to_chat), true, 11028);
                } else if (!this.c.e()) {
                    s();
                }
            }
        } else if (view.getId() == this.q.getUserIcon().getId()) {
            if (this.c.f() != null) {
                if (this.c.e()) {
                    if (this.h != null) {
                        this.h.show();
                        return;
                    }
                    return;
                }
                q();
            }
        } else if (view.getId() == this.q.getUserIconView1().getId() || view.getId() == this.q.getUserIconView2().getId()) {
            if (this.c.f() != null) {
                TbWebViewActivity.b(this.f, this.f.getString(R.string.user_icon_intro), String.valueOf(b) + "?st_type=person_user_icon");
            }
        } else if (view.getId() == this.p.getAttentionId()) {
            if (this.c != null && this.c.f() != null) {
                if (this.c.e()) {
                    com.baidu.tieba.ai.a(this.f, "person_self_attentionper_click");
                } else {
                    com.baidu.tieba.ai.a(this.f, "person_guid_attentionper_click");
                }
                PersonListActivity.a(this.f, true, this.c.f().getUserId(), this.c.f() != null ? this.c.f().getSex() : 0);
            }
        } else if (view.getId() == this.p.getPostId()) {
            if (this.c != null && this.c.f() != null) {
                if (this.c.e()) {
                    com.baidu.tieba.ai.a(this.f, "person_self_thread_click");
                } else {
                    com.baidu.tieba.ai.a(this.f, "person_guid_thread_click");
                }
                PersonPostActivity.a(this.f, this.c.f().getUserId(), this.c.f().getSex(), this.c.f().getPortrait());
            }
        } else if (view.getId() == this.p.getFansId()) {
            if (this.c != null && this.c.f() != null) {
                if (this.c.e()) {
                    com.baidu.tieba.ai.a(this.f, "person_self_attentionme_click");
                } else {
                    com.baidu.tieba.ai.a(this.f, "person_guid_attentionme_click");
                }
                this.p.a(false);
                this.p.b();
                this.m.i();
                PersonListActivity.a(this.f, false, this.c.f().getUserId(), this.c.f() != null ? this.c.f().getSex() : 0);
            }
        } else if (view.getId() == this.p.getForumId() && this.c != null && this.c.f() != null) {
            if (this.c.e()) {
                EditBarActivity.a(this.f, 103, null, this.c.f() != null ? this.c.f().getSex() : 0);
                com.baidu.tieba.ai.a(this.f, "person_self_attentionbar_click");
                return;
            }
            EditBarActivity.a(this.f, 103, this.c.f().getUserId(), this.c.f() != null ? this.c.f().getSex() : 0);
            com.baidu.tieba.ai.a(this.f, "person_guid_attentionbar_click");
        }
    }
}
