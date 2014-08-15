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
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.act.EditHeadActivity;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.data.PersonChangeData;
import com.baidu.tieba.person.post.PersonPostActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ct extends com.baidu.tbadk.core.d {
    private static final String d = String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/topic_page/135_1";
    private static boolean r = false;
    private BaseFragmentActivity h;
    private bd l;
    private List<View> n;
    private an o;
    private aj p;
    private aj q;
    private com.baidu.tieba.model.av e = null;
    private com.baidu.tieba.model.d f = null;
    private Boolean g = false;
    private PersonChangeData i = null;
    private AlertDialog j = null;
    private AlertDialog k = null;
    private boolean m = false;
    private final CustomMessageListener s = new cu(this, 2001178);
    private final com.baidu.adp.framework.listener.d t = new da(this, 304103);
    private final com.baidu.adp.framework.listener.d u = new db(this, 0);
    private final com.baidu.adp.framework.listener.d v = new dc(this, 2001124);
    final com.baidu.adp.framework.listener.d b = new dd(this, 304102);
    final CustomMessageListener c = new de(this, 2001178);

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
        this.g = Boolean.valueOf(this.e.j());
        m();
        return a(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.e.q();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        MessageManager.getInstance().registerListener(104102, this.u);
        MessageManager.getInstance().registerListener(this.b);
        MessageManager.getInstance().registerListener(this.c);
        MessageManager.getInstance().registerListener(this.t);
        MessageManager.getInstance().registerListener(this.s);
        this.o.a();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        MessageManager.getInstance().unRegisterListener(this.u);
        MessageManager.getInstance().unRegisterListener(this.b);
        MessageManager.getInstance().unRegisterListener(this.c);
        MessageManager.getInstance().registerListener(this.t);
        if (this.f != null) {
            this.f.cancelLoadData();
        }
        this.o.b();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        j();
        if (this.e.i() != null && this.e.i().length() > 0 && this.g.booleanValue()) {
            k();
        }
        com.baidu.tieba.util.k.b((Boolean) true);
        if (this.e.i() != null && this.e.i().length() > 0) {
            this.e.a(true, true, 1);
        }
        this.i = new PersonChangeData();
    }

    private View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(com.baidu.tieba.v.person_center_view, (ViewGroup) null);
    }

    private void j() {
        this.l = new bd(this.h, this);
        v();
        this.l.setScrollToBottomListener(new df(this));
        this.l.setExpandListRefreshListener(new dg(this));
        this.l.setLoadMoreOnClickListener(new dh(this));
    }

    private void k() {
        MessageManager.getInstance().registerListener(this.v);
    }

    private void l() {
        MessageManager.getInstance().unRegisterListener(this.v);
        MessageManager.getInstance().unRegisterListener(this.s);
    }

    private void a(Bundle bundle) {
        this.f = new com.baidu.tieba.model.d();
        this.e = new com.baidu.tieba.model.av(this.h);
        this.e.g();
        if (getActivity() instanceof BaseFragmentActivity) {
            this.f.setUniqueId(((BaseFragmentActivity) getActivity()).getUniqueId());
            this.e.setUniqueId(((BaseFragmentActivity) getActivity()).getUniqueId());
        }
        this.e.a(new cv(this));
        if (bundle != null) {
            this.e.e(bundle.getString(com.baidu.tbadk.core.frameworkData.a.FROM));
            this.e.b(bundle.getBoolean("self", true));
            this.e.b(bundle.getString("un"));
            this.e.d(bundle.getString("name"));
            this.e.c(bundle.getBoolean("tab_page", false));
            this.e.d(bundle.getBoolean("tab_msg", false));
            this.e.a(bundle.getString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE));
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.e.b(arguments.getBoolean("self", true));
                this.e.b(arguments.getString("un"));
                this.e.d(arguments.getString("name"));
                this.e.c(arguments.getBoolean("tab_page", false));
                this.e.d(arguments.getBoolean("tab_msg", false));
                this.e.e(arguments.getString("from_forum"));
                this.e.a(arguments.getString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE));
            }
        }
        this.e.setLoadDataCallBack(new cw(this));
    }

    private void m() {
        this.n = null;
        this.n = new ArrayList();
        if (this.g.booleanValue()) {
            this.p = new aj(this.h, this, 1);
        } else {
            this.p = new aj(this.h, this, 3);
        }
        this.q = new aj(this.h, this, 2);
        this.n.add(this.p);
        this.n.add(this.q);
        this.o = new an(this.h, this, this.e);
        this.o.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.j.a((Context) this.h, 270.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.n = null;
        this.n = new ArrayList();
        if (this.e.j()) {
            this.p.a(this.e, 1);
        } else {
            this.p.a(this.e, 3);
        }
        this.q.a(this.e, 2);
        this.n.add(this.p);
        this.n.add(this.q);
    }

    public com.baidu.tieba.model.av f() {
        return this.e;
    }

    public List<View> g() {
        return this.n;
    }

    public an h() {
        return this.o;
    }

    public void i() {
        if (this.l != null) {
            this.l.c();
        }
        this.e.a(false, true, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.e.a(false, true, 2);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.e != null) {
            bundle.putBoolean("self", this.e.j());
            bundle.putString("un", this.e.i());
            bundle.putString("name", this.e.m());
            bundle.putBoolean("tab_page", this.e.o());
            bundle.putBoolean("tab_msg", this.e.p());
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.FROM, this.e.r());
            bundle.putString(com.baidu.tbadk.core.frameworkData.a.ST_TYPE, this.e.d());
        }
    }

    public static void c(boolean z) {
        r = z;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        boolean z = false;
        super.onResume();
        if (r) {
            i();
            r = false;
        } else if (d_()) {
            this.g = Boolean.valueOf(this.e.j());
            if (this.e.i() == null || this.e.i().length() <= 0) {
                TiebaStatic.eventStat(this.h, "home_login_show", "loginshow", 1, new Object[0]);
                if (TbadkApplication.getCurrentAccount() != null) {
                    this.e.b(true);
                    this.e.b(TbadkApplication.getCurrentAccount());
                    this.e.d(TbadkApplication.getCurrentAccountName());
                    k();
                    i();
                    return;
                }
                return;
            }
            if (this.g.booleanValue()) {
                if (com.baidu.tbadk.coreExtra.messageCenter.a.a().q() != this.e.n()) {
                    this.e.a(com.baidu.tbadk.coreExtra.messageCenter.a.a().q());
                    z = true;
                }
                if (z && this.e.n() > 0) {
                    this.e.a(this.e.n());
                    this.o.a(true);
                }
            }
            this.p.b();
            this.o.d();
            this.l.f();
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        this.l.a(i);
        this.o.a(i);
        this.p.a(i);
        this.q.a(i);
    }

    private void p() {
        String format;
        String userName = this.e.k() != null ? this.e.k().getUserName() : null;
        if (userName != null) {
            if (this.k == null) {
                q();
            }
            if (this.f.a() == 1) {
                format = String.format(getString(com.baidu.tieba.x.block_chat_ensure_toremove_text), userName);
            } else {
                format = String.format(getString(com.baidu.tieba.x.block_chat_message_alert), userName);
            }
            this.k.setMessage(format);
            com.baidu.adp.lib.e.d.a(this.k, this.h);
        }
    }

    private void q() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.h);
        builder.setPositiveButton(getString(com.baidu.tieba.x.confirm), new cx(this));
        builder.setNegativeButton(getString(com.baidu.tieba.x.cancel), new cy(this));
        this.k = builder.create();
    }

    private void r() {
        if (this.e != null && this.e.a() != null && this.f != null) {
            this.l.a(this.e.a().g() == 1, this.f.a() == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.e != null && this.e.k() != null) {
            PersonImageActivity.a(this.h, a(this.h, this.e.k().getPortraitH()));
        }
    }

    private String a(Context context, String str) {
        return ((float) context.getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void t() {
        this.e.l();
    }

    private void u() {
        TiebaStatic.eventStat(this.h, "enter_chat", "personclick", 1, new Object[0]);
        try {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new com.baidu.tbadk.core.atomData.bj(this.h, Long.parseLong(this.e.k().getUserId()), this.e.k().getUserName(), this.e.k().getPortrait(), this.e.k().getSex())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.e != null) {
            if (this.e.i() != null && this.e.i().length() > 0 && this.e.j()) {
                l();
            }
            this.e.q();
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
                    this.e.b(TbadkApplication.getCurrentAccount());
                    this.e.d(TbadkApplication.getCurrentAccountName());
                    k();
                    i();
                }
            } else if (i == 11028) {
                u();
            } else if (i == 11035) {
                t();
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
                if (this.e.k() != null) {
                    com.baidu.tbadk.imageManager.e.a().a(this.e.k().getPortrait());
                }
                i();
            } else if (i == 18005 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.e != null && this.e.f()) {
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
                com.baidu.tbadk.core.util.ax.c(getActivity());
            } else if (i == 12010) {
                com.baidu.tbadk.core.util.ax.a(getActivity());
            }
        }
    }

    private void a(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("person_change_data");
        if (personChangeData != null && this.e.k() != null) {
            this.e.a(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.i != null) {
                    this.i.setPhotoChanged(true);
                }
                m.a(true);
                if (this.e.k() != null) {
                    com.baidu.tbadk.imageManager.e.a().a(this.e.k().getPortrait());
                }
            }
            i();
        }
    }

    private void v() {
        String[] strArr = {getString(com.baidu.tieba.x.hd_photo), getString(com.baidu.tieba.x.take_photo), getString(com.baidu.tieba.x.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.h);
        builder.setTitle(getString(com.baidu.tieba.x.operation));
        builder.setItems(strArr, new cz(this));
        if (this.j == null) {
            this.j = builder.create();
            this.j.setCanceledOnTouchOutside(true);
        }
    }

    private boolean d(int i) {
        int e;
        if (this.e == null || this.e.k() == null || this.e.k().getPersonPrivate() == null) {
            return false;
        }
        switch (i) {
            case 2:
                e = this.e.k().getPersonPrivate().b();
                break;
            case 3:
                e = this.e.k().getPersonPrivate().c();
                break;
            case 4:
                e = this.e.k().getPersonPrivate().d();
                break;
            case 5:
                e = this.e.k().getPersonPrivate().e();
                break;
            default:
                e = 1;
                break;
        }
        if (this.e != null && this.e.a() != null && this.e.a().g() != 1 && e == 2) {
            this.h.c(com.baidu.tieba.x.private_friend_open);
            return false;
        } else if (e == 3) {
            this.h.c(com.baidu.tieba.x.private_hide);
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            int msgFans = ((NewsNotifyMessage) responsedMessage).getMsgFans();
            if (this.e != null && msgFans > 0) {
                this.e.a(msgFans);
                this.o.a(true);
                this.o.d();
                this.l.f();
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.l.getBackBtn().getId()) {
            this.h.finish();
        } else if (view.getId() == this.l.getEditBtn().getId()) {
            if (!this.e.j()) {
                r();
                return;
            }
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.e.k() != null) {
                personChangeData.setName(this.e.k().getName_show());
                personChangeData.setIntro(this.e.k().getIntro());
                personChangeData.setSex(this.e.k().getSex());
                personChangeData.setPortrait(this.e.k().getPortrait());
            }
            PersonChangeActivity.a(this.h, 101, personChangeData, true);
            com.baidu.tbadk.core.f.a(this.h, "person_editprofile_click");
        } else if (view.getId() == this.p.getUserIcon().getId()) {
            if (this.e.k() != null) {
                if (this.e.j()) {
                    if (this.j != null) {
                        this.j.show();
                        return;
                    }
                    return;
                }
                s();
            }
        } else if (view.getId() == this.p.getUserIconView1().getId() || view.getId() == this.p.getUserIconView2().getId()) {
            if (this.e.k() != null) {
                TbWebViewActivity.startActivity(this.h, this.h.getString(com.baidu.tieba.x.user_icon_intro), String.valueOf(d) + "?st_type=person_user_icon");
            }
        } else if (view == this.o.getGroupView()) {
            if (this.e != null && this.e.k() != null) {
                if (this.e.j()) {
                    com.baidu.tbadk.core.f.a(this.h, "person_self_group_click");
                } else if (d(3)) {
                    com.baidu.tbadk.core.f.a(this.h, "person_guid_group_click");
                } else {
                    return;
                }
                if (this.e != null && this.e.k() != null) {
                    a(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bf(this.h, this.e.i(), this.e.k().getSex())));
                }
            }
        } else if (view == this.o.getPostView()) {
            if (this.e != null && this.e.k() != null) {
                if (this.e.j()) {
                    com.baidu.tbadk.core.f.a(this.h, "person_self_thread_click");
                } else if (d(4)) {
                    com.baidu.tbadk.core.f.a(this.h, "person_guid_thread_click");
                } else {
                    return;
                }
                PersonPostActivity.a(this.h, this.e.k().getUserId(), this.e.k().getSex(), this.e.k().getPortrait());
            }
        } else if (view == this.o.getFriendView()) {
            if (this.e != null && this.e.k() != null) {
                if (this.e.j()) {
                    com.baidu.tbadk.core.f.a(this.h, "person_self_friend_click");
                } else if (d(5)) {
                    com.baidu.tbadk.core.f.a(this.h, "person_guid_friend_click");
                } else {
                    return;
                }
                this.o.d();
                this.l.f();
                a(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.be(this.h, this.e.i(), this.e.k().getSex())));
            }
        } else if (view == this.o.getForumView()) {
            if (this.e != null && this.e.k() != null) {
                if (this.e.j()) {
                    com.baidu.tbadk.core.f.a(this.h, "person_self_attentionbar_click");
                } else if (d(2)) {
                    com.baidu.tbadk.core.f.a(this.h, "person_guid_attentionbar_click");
                } else {
                    return;
                }
                a(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bd(this.h, this.e.i(), this.e.k().getSex())));
            }
        } else if (view == this.o.getAttentionView()) {
            if (this.e != null && this.e.k() != null) {
                if (this.e.j()) {
                    com.baidu.tbadk.core.f.a(this.h, "person_self_attentionper_click");
                } else {
                    com.baidu.tbadk.core.f.a(this.h, "person_guid_attentionper_click");
                }
                UserData k = this.e.k();
                a(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bh(this.h, true, k.getUserId(), k.getSex())));
            }
        } else if (view == this.o.getFansView()) {
            if (this.e != null && this.e.k() != null) {
                if (this.e.j()) {
                    com.baidu.tbadk.core.f.a(this.h, "person_self_attentionme_click");
                } else {
                    com.baidu.tbadk.core.f.a(this.h, "person_guid_attentionme_click");
                }
                this.o.a(false);
                this.o.d();
                this.l.f();
                UserData k2 = this.e.k();
                a(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bh(this.h, false, k2.getUserId(), k2.getSex())));
            }
        } else if (view.getId() == this.p.getUserVipView()) {
            if (this.e.k() != null) {
                TbWebViewActivity.startActivityWithCookie(this.h, getString(com.baidu.tieba.x.member_benefits), String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/tbeanmall?_client_version=" + TbConfig.getVersion());
            }
        } else if (view.getId() == this.l.getBlackBtn().getId()) {
            this.l.g();
            p();
        } else if (view.getId() == this.l.getFriendBtn().getId()) {
            this.l.g();
            if (this.e != null && this.e.k() != null) {
                com.baidu.tbadk.newFriends.a.a().a(this.e.k().getUserIdLong());
            }
        }
    }
}
