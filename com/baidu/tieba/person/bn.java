package com.baidu.tieba.person;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.act.EditHeadActivity;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.person.post.PersonPostActivity;
import com.baidu.tieba.util.AntiHelper;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class bn extends com.baidu.tbadk.core.d {
    private static final String b = String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/topic_page/135_1";
    private static boolean r = false;
    private com.baidu.tbadk.core.e f;
    private ak l;
    private List<View> n;
    private ag o;
    private ab p;
    private ab q;
    private com.baidu.tieba.model.av c = null;
    private com.baidu.tieba.model.e d = null;
    private Boolean e = false;
    private PersonChangeData g = null;
    private AlertDialog h = null;
    private com.baidu.tbadk.core.dialog.d i = null;
    private AlertDialog j = null;
    private boolean k = false;
    private boolean m = false;
    private final com.baidu.adp.framework.c.g s = new bo(this, 0);
    private final com.baidu.adp.framework.c.g t = new br(this, 2001124);

    public final boolean a() {
        return this.m;
    }

    public final void a(boolean z) {
        this.m = z;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f = (com.baidu.tbadk.core.e) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = new com.baidu.tieba.model.e();
        this.c = new com.baidu.tieba.model.av(this.f);
        this.c.c();
        if (getActivity() instanceof com.baidu.tbadk.core.e) {
            this.d.setUniqueId(((com.baidu.tbadk.core.e) getActivity()).a());
            this.c.setUniqueId(((com.baidu.tbadk.core.e) getActivity()).a());
        }
        this.c.a(new bv(this));
        if (bundle != null) {
            this.c.b(bundle.getBoolean("self", true));
            this.c.a(bundle.getString("un"));
            this.c.c(bundle.getString("name"));
            this.c.c(bundle.getBoolean("tab_page", false));
            this.c.d(bundle.getBoolean("tab_msg", false));
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.c.b(arguments.getBoolean("self", true));
                this.c.a(arguments.getString("un"));
                this.c.c(arguments.getString("name"));
                this.c.c(arguments.getBoolean("tab_page", false));
                this.c.d(arguments.getBoolean("tab_msg", false));
            }
        }
        i();
        this.c.setLoadDataCallBack(new bw(this));
        this.e = Boolean.valueOf(this.c.f());
        this.n = null;
        this.n = new ArrayList();
        if (this.e.booleanValue()) {
            this.p = new ab(this.f, this, 1);
        } else {
            this.p = new ab(this.f, this, 3);
        }
        this.q = new ab(this.f, this, 2);
        this.n.add(this.p);
        this.n.add(this.q);
        this.o = new ag(this.f, this);
        this.o.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.i.a((Context) this.f, 270.0f)));
        return layoutInflater.inflate(com.baidu.tieba.a.i.person_center_view, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.c.n();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onStart() {
        super.onStart();
        com.baidu.adp.framework.c.a().a(104102, this.s);
        com.baidu.adp.framework.c.a().a(104104, this.s);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onStop() {
        super.onStop();
        com.baidu.adp.framework.c.a().b(this.s);
        if (this.d != null) {
            this.d.cancelLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.l = new ak(this.f, this);
        String[] strArr = {getString(com.baidu.tieba.a.k.hd_photo), getString(com.baidu.tieba.a.k.take_photo), getString(com.baidu.tieba.a.k.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f);
        builder.setTitle(getString(com.baidu.tieba.a.k.operation));
        builder.setItems(strArr, new bq(this));
        if (this.h == null) {
            this.h = builder.create();
            this.h.setCanceledOnTouchOutside(true);
        }
        this.l.setScrollToBottomListener(new bs(this));
        this.l.setExpandListRefreshListener(new bt(this));
        this.l.setLoadMoreOnClickListener(new bu(this));
        if (this.c.e() != null && this.c.e().length() > 0 && this.e.booleanValue()) {
            g();
        }
        com.baidu.tieba.util.k.a((Boolean) true);
        if (this.c.e() != null && this.c.e().length() > 0) {
            f();
        }
        this.g = new PersonChangeData();
    }

    private void g() {
        com.baidu.adp.framework.c.a().a(this.t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(bn bnVar) {
        bnVar.n = null;
        bnVar.n = new ArrayList();
        if (bnVar.c.f()) {
            bnVar.p.a(bnVar.c, 1);
        } else {
            bnVar.p.a(bnVar.c, 3);
        }
        bnVar.q.a(bnVar.c, 2);
        bnVar.n.add(bnVar.p);
        bnVar.n.add(bnVar.q);
    }

    public final List<View> b() {
        return this.n;
    }

    public final ag e() {
        return this.o;
    }

    public final void f() {
        if (this.l != null) {
            this.l.c();
        }
        this.c.a(true, true, 1);
    }

    @Override // android.support.v4.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.c != null) {
            bundle.putBoolean("self", this.c.f());
            bundle.putString("un", this.c.e());
            bundle.putString("name", this.c.j());
            bundle.putBoolean("tab_page", this.c.l());
            bundle.putBoolean("tab_msg", this.c.m());
        }
    }

    public static void c(boolean z) {
        r = true;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        boolean z = false;
        super.onResume();
        if (r) {
            f();
            r = false;
        } else if (c_()) {
            this.e = Boolean.valueOf(this.c.f());
            if (this.c.e() == null || this.c.e().length() <= 0) {
                TiebaStatic.a(this.f, "home_login_show", "loginshow", 1, new Object[0]);
                if (TbadkApplication.E() != null) {
                    this.c.b(true);
                    this.c.a(TbadkApplication.E());
                    this.c.c(TbadkApplication.O());
                    g();
                    f();
                    return;
                }
                return;
            }
            if (this.e.booleanValue()) {
                if (com.baidu.tbadk.coreExtra.messageCenter.a.a().k() != this.c.k()) {
                    this.c.a(com.baidu.tbadk.coreExtra.messageCenter.a.a().k());
                    z = true;
                }
                if (z && this.c.k() > 0) {
                    this.c.a(this.c.k());
                    this.o.a(true);
                }
            }
            this.p.a();
            this.l.a();
            this.l.e();
            this.o.a();
            this.l.h();
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void c(int i) {
        this.l.a(i);
        this.o.a(i);
        this.p.a(i);
        this.q.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(bn bnVar) {
        String userName = bnVar.c.g() != null ? bnVar.c.g().getUserName() : null;
        if (userName != null) {
            if (bnVar.j == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(bnVar.f);
                builder.setPositiveButton(bnVar.getString(com.baidu.tieba.a.k.confirm), new bx(bnVar));
                builder.setNegativeButton(bnVar.getString(com.baidu.tieba.a.k.cancel), new by(bnVar));
                bnVar.j = builder.create();
            }
            bnVar.j.setMessage(bnVar.d.a() == 1 ? String.format(bnVar.getString(com.baidu.tieba.a.k.black_list_ensure_toremove_text), userName) : String.format(bnVar.getString(com.baidu.tieba.a.k.remove_black_alert), userName));
            bnVar.j.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.i = new com.baidu.tbadk.core.dialog.d(this.f);
        this.i.a(new Object[]{this.f.getString(this.d.a() == 1 ? com.baidu.tieba.a.k.delete_to_black_list : com.baidu.tieba.a.k.add_to_black_list), new Object[]{this.f.getString(com.baidu.tieba.a.k.cancel), 1}}, new bp(this)).a(com.baidu.tbadk.core.dialog.f.a).b(80).a();
        this.i.b();
    }

    private void i() {
        int a = com.baidu.adp.lib.f.b.a(this.c.e(), -1);
        if (a > 0 && !this.c.f()) {
            this.d.a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.c != null && this.c.g() != null) {
            String portraitH = this.c.g().getPortraitH();
            PersonImageActivity.a(this.f, ((float) this.f.getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + portraitH : "http://himg.baidu.com/sys/portraitl/item/" + portraitH);
        }
    }

    private void k() {
        TiebaStatic.a(this.f, "enter_chat", "personclick", 1, new Object[0]);
        try {
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001005, new com.baidu.tbadk.core.b.ah(this.f, Long.parseLong(this.c.g().getUserId()), this.c.g().getUserName(), this.c.g().getPortrait(), this.c.g().getSex())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        if (this.c != null) {
            if (this.c.e() != null && this.c.e().length() > 0 && this.c.f()) {
                com.baidu.adp.framework.c.a().b(this.t);
            }
            this.c.n();
        }
        com.baidu.tieba.util.k.a((Boolean) true);
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("person_change_data");
                if (personChangeData == null || this.c.g() == null) {
                    return;
                }
                this.c.a(personChangeData);
                if (personChangeData.getPhotoChanged()) {
                    if (this.g != null) {
                        this.g.setPhotoChanged(true);
                    }
                    r.a(true);
                    if (this.c.g() != null) {
                        this.c.i();
                        com.baidu.tbadk.imageManager.e.a().a(this.c.g().getPortrait());
                    }
                }
                f();
            } else if (i == 11003 || i == 12007) {
                if (TbadkApplication.E() != null) {
                    this.c.b(true);
                    this.c.a(TbadkApplication.E());
                    this.c.c(TbadkApplication.O());
                    g();
                    f();
                }
            } else if (i == 11028) {
                k();
            } else if (i == 11035) {
                this.c.h();
            } else if (i == 12002) {
                if (intent != null) {
                    EditHeadActivity.a(getActivity(), 12002, 12009, intent.getData(), TbadkApplication.N());
                }
            } else if (i == 12001) {
                EditHeadActivity.a(getActivity(), 12001, 12010, null, TbadkApplication.N());
            } else if (i == 12010 || i == 12009) {
                if (this.g != null) {
                    this.g.setPhotoChanged(true);
                }
                r.a(true);
                if (this.c.g() != null) {
                    this.c.i();
                    com.baidu.tbadk.imageManager.e.a().a(this.c.g().getPortrait());
                }
                f();
            }
        } else if (i2 == 0) {
            if (i == 12009) {
                com.baidu.tbadk.core.util.az.b(getActivity());
            } else if (i == 12010) {
                com.baidu.tbadk.core.util.az.a(getActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(bn bnVar, com.baidu.adp.framework.message.f fVar) {
        if (fVar != null) {
            if (!(fVar instanceof NewsNotifyMessage)) {
                com.baidu.adp.lib.util.f.b("transform error");
                return;
            }
            int d = ((NewsNotifyMessage) fVar).d();
            if (bnVar.c == null || d <= 0) {
                return;
            }
            bnVar.c.a(d);
            bnVar.o.a(true);
            bnVar.o.a();
            bnVar.l.h();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == this.o.getBackBtn().getId()) {
            this.f.finish();
        } else if (view.getId() == this.o.getEditBtn().getId()) {
            if (!this.c.f()) {
                if (this.d.a() == 2) {
                    i();
                    this.k = true;
                    return;
                }
                h();
                return;
            }
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.c.g() != null) {
                personChangeData.setName(this.c.g().getName_show());
                personChangeData.setIntro(this.c.g().getIntro());
                personChangeData.setSex(this.c.g().getSex());
                personChangeData.setPortrait(this.c.g().getPortrait());
            }
            PersonChangeActivity.a(this.f, 101, personChangeData, true);
            com.baidu.tbadk.core.g.a(this.f, "person_editprofile_click");
        } else if (view.getId() == this.p.getAttentionBtn().getId()) {
            if (this.c.g() != null) {
                if (TbadkApplication.E() == null || TbadkApplication.E().length() <= 0) {
                    LoginActivity.a((Activity) this.f, this.f.getResources().getString(com.baidu.tieba.a.k.login_to_attention), true, 11035);
                } else if (!this.c.f()) {
                    this.c.h();
                } else {
                    AntiHelper.a(this.f, this.c.d(), AntiHelper.OperationType.ACCOUNT_RESTORE, AntiHelper.PageType.PERSON_INFO);
                }
            }
        } else if (view.getId() == this.p.getSendBtn().getId()) {
            if (this.c.g() != null) {
                if (TbadkApplication.E() == null || TbadkApplication.E().length() <= 0) {
                    LoginActivity.a((Activity) this.f, this.f.getResources().getString(com.baidu.tieba.a.k.login_to_chat), true, 11028);
                } else if (!this.c.f()) {
                    k();
                }
            }
        } else if (view.getId() == this.p.getUserIcon().getId()) {
            if (this.c.g() != null) {
                if (this.c.f()) {
                    if (this.h != null) {
                        this.h.show();
                        return;
                    }
                    return;
                }
                j();
            }
        } else if (view.getId() == this.p.getUserIconView1().getId() || view.getId() == this.p.getUserIconView2().getId()) {
            if (this.c.g() != null) {
                TbWebViewActivity.b(this.f, this.f.getString(com.baidu.tieba.a.k.user_icon_intro), String.valueOf(b) + "?st_type=person_user_icon");
            }
        } else if (view.getId() == this.o.getAttentionId()) {
            if (this.c != null && this.c.g() != null) {
                if (this.c.f()) {
                    com.baidu.tbadk.core.g.a(this.f, "person_self_attentionper_click");
                } else {
                    com.baidu.tbadk.core.g.a(this.f, "person_guid_attentionper_click");
                }
                PersonListActivity.a(this.f, true, this.c.g().getUserId(), this.c.g() != null ? this.c.g().getSex() : 0);
            }
        } else if (view.getId() == this.o.getPostId()) {
            if (this.c != null && this.c.g() != null) {
                if (this.c.f()) {
                    com.baidu.tbadk.core.g.a(this.f, "person_self_thread_click");
                } else {
                    com.baidu.tbadk.core.g.a(this.f, "person_guid_thread_click");
                }
                PersonPostActivity.a(this.f, this.c.g().getUserId(), this.c.g().getSex(), this.c.g().getPortrait());
            }
        } else if (view.getId() == this.o.getFansId()) {
            if (this.c != null && this.c.g() != null) {
                if (this.c.f()) {
                    com.baidu.tbadk.core.g.a(this.f, "person_self_attentionme_click");
                } else {
                    com.baidu.tbadk.core.g.a(this.f, "person_guid_attentionme_click");
                }
                this.o.a(false);
                this.o.a();
                this.l.h();
                PersonListActivity.a(this.f, false, this.c.g().getUserId(), this.c.g() != null ? this.c.g().getSex() : 0);
            }
        } else if (view.getId() == this.o.getForumId()) {
            if (this.c != null && this.c.g() != null) {
                if (this.c.f()) {
                    EditBarActivity.a(this.f, 103, null, this.c.g() != null ? this.c.g().getSex() : 0);
                    com.baidu.tbadk.core.g.a(this.f, "person_self_attentionbar_click");
                    return;
                }
                EditBarActivity.a(this.f, 103, this.c.g().getUserId(), this.c.g() != null ? this.c.g().getSex() : 0);
                com.baidu.tbadk.core.g.a(this.f, "person_guid_attentionbar_click");
            }
        } else if (view.getId() == this.p.getUserVipView() && this.c.g() != null) {
            TbWebViewActivity.a(this.f, getString(com.baidu.tieba.a.k.member_benefits), String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/topic_page/tbeannote");
        }
    }
}
