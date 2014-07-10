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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.act.EditHeadActivity;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.person.post.PersonPostActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class cr extends com.baidu.tbadk.core.d {
    private static final String d = String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/topic_page/135_1";
    private static boolean r = false;
    private BaseFragmentActivity h;
    private az l;
    private List<View> n;
    private ao o;
    private ak p;
    private ak q;
    private com.baidu.tieba.model.au e = null;
    private com.baidu.tieba.model.c f = null;
    private Boolean g = false;
    private PersonChangeData i = null;
    private AlertDialog j = null;
    private AlertDialog k = null;
    private boolean m = false;
    private final com.baidu.adp.framework.listener.b s = new cs(this, 0);
    final com.baidu.adp.framework.listener.b b = new cv(this, 304102);
    final CustomMessageListener c = new cw(this, 2001178);

    public boolean a() {
        return this.m;
    }

    public void a(boolean z) {
        this.m = z;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.h = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a(bundle);
        this.g = Boolean.valueOf(this.e.i());
        j();
        return a(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.o != null) {
            this.o.a();
        }
        this.e.p();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        MessageManager.getInstance().registerListener(104102, this.s);
        MessageManager.getInstance().registerListener(this.b);
        MessageManager.getInstance().registerListener(this.c);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        MessageManager.getInstance().unRegisterListener(this.s);
        MessageManager.getInstance().unRegisterListener(this.b);
        MessageManager.getInstance().unRegisterListener(this.c);
        if (this.f != null) {
            this.f.cancelLoadData();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        i();
        com.baidu.tieba.util.k.b((Boolean) true);
        if (this.e.h() != null && this.e.h().length() > 0) {
            h();
        }
        this.i = new PersonChangeData();
    }

    private View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(com.baidu.tieba.w.person_center_view, (ViewGroup) null);
    }

    private void i() {
        this.l = new az(this.h, this);
        s();
        this.l.setScrollToBottomListener(new cx(this));
        this.l.setExpandListRefreshListener(new cy(this));
        this.l.setLoadMoreOnClickListener(new cz(this));
    }

    private void a(Bundle bundle) {
        this.f = new com.baidu.tieba.model.c();
        this.e = new com.baidu.tieba.model.au(this.h);
        this.e.f();
        if (getActivity() instanceof BaseFragmentActivity) {
            this.f.setUniqueId(((BaseFragmentActivity) getActivity()).getUniqueId());
            this.e.setUniqueId(((BaseFragmentActivity) getActivity()).getUniqueId());
        }
        this.e.a(new da(this));
        if (bundle != null) {
            this.e.d(bundle.getString(com.baidu.tbadk.core.frameworkData.a.FROM));
            this.e.b(bundle.getBoolean("self", true));
            this.e.a(bundle.getString("un"));
            this.e.c(bundle.getString("name"));
            this.e.c(bundle.getBoolean("tab_page", false));
            this.e.d(bundle.getBoolean("tab_msg", false));
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.e.b(arguments.getBoolean("self", true));
                this.e.a(arguments.getString("un"));
                this.e.c(arguments.getString("name"));
                this.e.c(arguments.getBoolean("tab_page", false));
                this.e.d(arguments.getBoolean("tab_msg", false));
                this.e.d(arguments.getString("from_forum"));
            }
        }
        this.e.setLoadDataCallBack(new db(this));
    }

    private void j() {
        this.n = null;
        this.n = new ArrayList();
        if (this.g.booleanValue()) {
            this.p = new ak(this.h, this, 1);
        } else {
            this.p = new ak(this.h, this, 3);
        }
        this.q = new ak(this.h, this, 2);
        this.n.add(this.p);
        this.n.add(this.q);
        this.o = new ao(this.h, this);
        this.o.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.j.a((Context) this.h, 270.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.n = null;
        this.n = new ArrayList();
        if (this.e.i()) {
            this.p.a(this.e, 1);
        } else {
            this.p.a(this.e, 3);
        }
        this.q.a(this.e, 2);
        this.n.add(this.p);
        this.n.add(this.q);
    }

    public List<View> f() {
        return this.n;
    }

    public ao g() {
        return this.o;
    }

    public void h() {
        if (this.l != null) {
            this.l.d();
        }
        this.e.a(false, true, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.e.a(true, true, 2);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.e != null) {
            bundle.putBoolean("self", this.e.i());
            bundle.putString("un", this.e.h());
            bundle.putString("name", this.e.m());
            bundle.putBoolean("tab_page", this.e.n());
            bundle.putBoolean("tab_msg", this.e.o());
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.FROM, this.e.q());
        }
    }

    public static void c(boolean z) {
        r = z;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (r) {
            h();
            r = false;
        } else if (d_()) {
            this.g = Boolean.valueOf(this.e.i());
            if (this.e.h() == null || this.e.h().length() <= 0) {
                TiebaStatic.eventStat(this.h, "home_login_show", "loginshow", 1, new Object[0]);
                if (TbadkApplication.getCurrentAccount() != null) {
                    this.e.b(true);
                    this.e.a(TbadkApplication.getCurrentAccount());
                    this.e.c(TbadkApplication.getCurrentAccountName());
                    h();
                    return;
                }
                return;
            }
            this.p.b();
            this.l.b();
            this.o.b();
            this.l.g();
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        this.l.a(i);
        this.o.a(i);
        this.p.a(i);
        this.q.a(i);
    }

    private void m() {
        String format;
        String userName = this.e.j() != null ? this.e.j().getUserName() : null;
        if (userName != null) {
            if (this.k == null) {
                n();
            }
            if (this.f.a() == 1) {
                format = String.format(getString(com.baidu.tieba.y.black_list_ensure_toremove_text), userName);
            } else {
                format = String.format(getString(com.baidu.tieba.y.remove_black_alert), userName);
            }
            this.k.setMessage(format);
            this.k.show();
        }
    }

    private void n() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.h);
        builder.setPositiveButton(getString(com.baidu.tieba.y.confirm), new dc(this));
        builder.setNegativeButton(getString(com.baidu.tieba.y.cancel), new ct(this));
        this.k = builder.create();
    }

    private void o() {
        if (this.e != null && this.e.a() != null && this.f != null) {
            this.l.a(this.e.a().g() == 1, this.f.a() == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.e != null && this.e.j() != null) {
            PersonImageActivity.a(this.h, a(this.h, this.e.j().getPortraitH()));
        }
    }

    private String a(Context context, String str) {
        return ((float) context.getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void q() {
        this.e.k();
    }

    private void r() {
        TiebaStatic.eventStat(this.h, "enter_chat", "personclick", 1, new Object[0]);
        try {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new com.baidu.tbadk.core.atomData.bc(this.h, Long.parseLong(this.e.j().getUserId()), this.e.j().getUserName(), this.e.j().getPortrait(), this.e.j().getSex())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.e != null) {
            this.e.p();
        }
        com.baidu.tieba.util.k.b((Boolean) true);
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 101) {
                a(intent);
            } else if (i == 11003 || i == 12007) {
                if (TbadkApplication.getCurrentAccount() != null) {
                    this.e.b(true);
                    this.e.a(TbadkApplication.getCurrentAccount());
                    this.e.c(TbadkApplication.getCurrentAccountName());
                    h();
                }
            } else if (i == 11028) {
                r();
            } else if (i == 11035) {
                q();
            } else if (i == 12002) {
                if (intent != null) {
                    EditHeadActivity.a(getActivity(), 12002, 12009, intent.getData(), TbadkApplication.getCurrentAccountObj());
                }
            } else if (i == 12001) {
                EditHeadActivity.a(getActivity(), 12001, 12010, null, TbadkApplication.getCurrentAccountObj());
            } else if (i == 12010 || i == 12009) {
                if (this.i != null) {
                    this.i.setPhotoChanged(true);
                }
                m.a(true);
                if (this.e.j() != null) {
                    this.e.l().e(this.e.j().getPortrait());
                }
                h();
            } else if (i == 18003 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.e != null && this.e.e()) {
                int size = this.e.b().post_list.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        z = false;
                        break;
                    } else if (stringExtra.equals(new StringBuilder(String.valueOf(this.e.b().post_list.get(i3).thread_id)).toString())) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    this.e.b().post_list.remove(i3);
                    this.l.a(this.e);
                }
            }
        } else if (i2 == 0) {
            if (i == 12009) {
                com.baidu.tbadk.core.util.bj.c(getActivity());
            } else if (i == 12010) {
                com.baidu.tbadk.core.util.bj.a(getActivity());
            }
        }
    }

    private void a(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("person_change_data");
        if (personChangeData != null && this.e.j() != null) {
            this.e.a(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.i != null) {
                    this.i.setPhotoChanged(true);
                }
                m.a(true);
                if (this.e.j() != null) {
                    this.e.l().e(this.e.j().getPortrait());
                }
            }
            h();
        }
    }

    private void s() {
        String[] strArr = {getString(com.baidu.tieba.y.hd_photo), getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.h);
        builder.setTitle(getString(com.baidu.tieba.y.operation));
        builder.setItems(strArr, new cu(this));
        if (this.j == null) {
            this.j = builder.create();
            this.j.setCanceledOnTouchOutside(true);
        }
    }

    private boolean d(int i) {
        int e;
        if (this.e == null || this.e.j() == null || this.e.j().getPersonPrivate() == null) {
            return false;
        }
        switch (i) {
            case 2:
                e = this.e.j().getPersonPrivate().b();
                break;
            case 3:
                e = this.e.j().getPersonPrivate().c();
                break;
            case 4:
                e = this.e.j().getPersonPrivate().d();
                break;
            case 5:
                e = this.e.j().getPersonPrivate().e();
                break;
            default:
                e = 1;
                break;
        }
        if (this.e != null && this.e.a() != null && this.e.a().g() != 1 && e == 2) {
            this.h.c(com.baidu.tieba.y.private_friend_open);
            return false;
        } else if (e == 3) {
            this.h.c(com.baidu.tieba.y.private_hide);
            return false;
        } else {
            return true;
        }
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.l.getBackBtn().getId()) {
            this.h.finish();
        } else if (view.getId() == this.l.getEditBtn().getId()) {
            if (!this.e.i()) {
                o();
                return;
            }
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.e.j() != null) {
                personChangeData.setName(this.e.j().getName_show());
                personChangeData.setIntro(this.e.j().getIntro());
                personChangeData.setSex(this.e.j().getSex());
                personChangeData.setPortrait(this.e.j().getPortrait());
            }
            PersonChangeActivity.a(this.h, 101, personChangeData, true);
            com.baidu.tbadk.core.f.a(this.h, "person_editprofile_click");
        } else if (view.getId() == this.p.getUserIcon().getId()) {
            if (this.e.j() != null) {
                if (this.e.i()) {
                    if (this.j != null) {
                        this.j.show();
                        return;
                    }
                    return;
                }
                p();
            }
        } else if (view.getId() == this.p.getUserIconView1().getId() || view.getId() == this.p.getUserIconView2().getId()) {
            if (this.e.j() != null) {
                TbWebViewActivity.startActivity(this.h, this.h.getString(com.baidu.tieba.y.user_icon_intro), String.valueOf(d) + "?st_type=person_user_icon");
            }
        } else if (view.getId() == this.o.getGroupId()) {
            if (this.e != null && this.e.j() != null) {
                if (this.e.i()) {
                    com.baidu.tbadk.core.f.a(this.h, "person_self_group_click");
                } else if (d(3)) {
                    com.baidu.tbadk.core.f.a(this.h, "person_guid_group_click");
                } else {
                    return;
                }
                if (this.e != null && this.e.j() != null) {
                    a(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ba(this.h, this.e.h(), this.e.j().getSex())));
                }
            }
        } else if (view.getId() == this.o.getPostId()) {
            if (this.e != null && this.e.j() != null) {
                if (this.e.i()) {
                    com.baidu.tbadk.core.f.a(this.h, "person_self_thread_click");
                } else if (d(4)) {
                    com.baidu.tbadk.core.f.a(this.h, "person_guid_thread_click");
                } else {
                    return;
                }
                PersonPostActivity.a(this.h, this.e.j().getUserId(), this.e.j().getSex(), this.e.j().getPortrait());
            }
        } else if (view.getId() == this.o.getFriendId()) {
            if (this.e != null && this.e.j() != null) {
                if (this.e.i()) {
                    com.baidu.tbadk.core.f.a(this.h, "person_self_friend_click");
                } else if (d(5)) {
                    com.baidu.tbadk.core.f.a(this.h, "person_guid_friend_click");
                } else {
                    return;
                }
                this.o.b();
                this.l.g();
                a(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.az(this.h, this.e.h(), this.e.j().getSex())));
            }
        } else if (view.getId() == this.o.getForumId()) {
            if (this.e != null && this.e.j() != null) {
                if (this.e.i()) {
                    com.baidu.tbadk.core.f.a(this.h, "person_self_attentionbar_click");
                } else if (d(2)) {
                    com.baidu.tbadk.core.f.a(this.h, "person_guid_attentionbar_click");
                } else {
                    return;
                }
                a(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.ay(this.h, this.e.h(), this.e.j().getSex())));
            }
        } else if (view.getId() == this.p.getUserVipView()) {
            if (this.e.j() != null) {
                TbWebViewActivity.startActivityWithCookie(this.h, getString(com.baidu.tieba.y.member_benefits), String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/tbeanmall?_client_version=" + TbConfig.getVersion());
            }
        } else if (view.getId() == this.l.getBlackBtn().getId()) {
            this.l.h();
            m();
        } else if (view.getId() == this.l.getFriendBtn().getId()) {
            this.l.h();
            if (this.e != null && this.e.j() != null) {
                com.baidu.tbadk.newFriends.a.a().a(this.e.j().getUserIdLong());
            }
        }
    }
}
