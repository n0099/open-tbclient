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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
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
public class bm extends com.baidu.tbadk.core.d {
    private static final String b = String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/topic_page/135_1";
    private static boolean q = false;
    private BaseFragmentActivity f;
    private aj k;
    private List<View> m;
    private af n;
    private ab o;
    private ab p;
    private com.baidu.tieba.model.av c = null;
    private com.baidu.tieba.model.e d = null;
    private Boolean e = false;
    private PersonChangeData g = null;
    private AlertDialog h = null;
    private com.baidu.tbadk.core.dialog.d i = null;
    private AlertDialog j = null;
    private boolean l = false;
    private final com.baidu.adp.framework.listener.b r = new bn(this, 0);
    private final com.baidu.adp.framework.listener.b s = new bq(this, MessageTypes.CMD_MESSAGE_NOTIFY_LOCAL);

    public boolean a() {
        return this.l;
    }

    public void a(boolean z) {
        this.l = z;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a(bundle);
        this.e = Boolean.valueOf(this.c.g());
        l();
        return a(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.c.o();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        MessageManager.getInstance().registerListener(MessageTypes.CMD_UPDATE_MASK_INFO, this.r);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        MessageManager.getInstance().unRegisterListener(this.r);
        if (this.d != null) {
            this.d.cancelLoadData();
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
        if (this.c.f() != null && this.c.f().length() > 0 && this.e.booleanValue()) {
            j();
        }
        com.baidu.tieba.util.k.b((Boolean) true);
        if (this.c.f() != null && this.c.f().length() > 0) {
            h();
        }
        this.g = new PersonChangeData();
    }

    private View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(com.baidu.tieba.w.person_center_view, (ViewGroup) null);
    }

    private void i() {
        this.k = new aj(this.f, this);
        w();
        this.k.setScrollToBottomListener(new br(this));
        this.k.setExpandListRefreshListener(new bs(this));
        this.k.setLoadMoreOnClickListener(new bt(this));
    }

    private void j() {
        MessageManager.getInstance().registerListener(this.s);
    }

    private void k() {
        MessageManager.getInstance().unRegisterListener(this.s);
    }

    private void a(Bundle bundle) {
        this.d = new com.baidu.tieba.model.e();
        this.c = new com.baidu.tieba.model.av(this.f);
        this.c.d();
        if (getActivity() instanceof BaseFragmentActivity) {
            this.d.setUniqueId(((BaseFragmentActivity) getActivity()).getUniqueId());
            this.c.setUniqueId(((BaseFragmentActivity) getActivity()).getUniqueId());
        }
        this.c.a(new bu(this));
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
        this.c.setLoadDataCallBack(new bv(this));
    }

    private void l() {
        this.m = null;
        this.m = new ArrayList();
        if (this.e.booleanValue()) {
            this.o = new ab(this.f, this, 1);
        } else {
            this.o = new ab(this.f, this, 3);
        }
        this.p = new ab(this.f, this, 2);
        this.m.add(this.o);
        this.m.add(this.p);
        this.n = new af(this.f, this);
        this.n.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.a((Context) this.f, 270.0f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.m = null;
        this.m = new ArrayList();
        if (this.c.g()) {
            this.o.a(this.c, 1);
        } else {
            this.o.a(this.c, 3);
        }
        this.p.a(this.c, 2);
        this.m.add(this.o);
        this.m.add(this.p);
    }

    public List<View> f() {
        return this.m;
    }

    public af g() {
        return this.n;
    }

    public void h() {
        if (this.k != null) {
            this.k.d();
        }
        this.c.a(false, true, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.c.a(true, true, 2);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.c != null) {
            bundle.putBoolean("self", this.c.g());
            bundle.putString("un", this.c.f());
            bundle.putString("name", this.c.k());
            bundle.putBoolean("tab_page", this.c.m());
            bundle.putBoolean("tab_msg", this.c.n());
        }
    }

    public static void c(boolean z) {
        q = z;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        boolean z = false;
        super.onResume();
        if (q) {
            h();
            q = false;
        } else if (d_()) {
            this.e = Boolean.valueOf(this.c.g());
            if (this.c.f() == null || this.c.f().length() <= 0) {
                TiebaStatic.eventStat(this.f, "home_login_show", "loginshow", 1, new Object[0]);
                if (TbadkApplication.getCurrentAccount() != null) {
                    this.c.b(true);
                    this.c.a(TbadkApplication.getCurrentAccount());
                    this.c.c(TbadkApplication.getCurrentAccountName());
                    j();
                    h();
                    return;
                }
                return;
            }
            if (this.e.booleanValue()) {
                if (com.baidu.tbadk.coreExtra.messageCenter.a.a().m() != this.c.l()) {
                    this.c.a(com.baidu.tbadk.coreExtra.messageCenter.a.a().m());
                    z = true;
                }
                if (z && this.c.l() > 0) {
                    this.c.a(this.c.l());
                    this.n.a(true);
                }
            }
            this.o.b();
            this.k.b();
            this.k.g();
            this.n.b();
            this.k.j();
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        this.k.a(i);
        this.n.a(i);
        this.o.a(i);
        this.p.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        String format;
        String userName = this.c.h() != null ? this.c.h().getUserName() : null;
        if (userName != null) {
            if (this.j == null) {
                p();
            }
            if (this.d.a() == 1) {
                format = String.format(getString(com.baidu.tieba.y.black_list_ensure_toremove_text), userName);
            } else {
                format = String.format(getString(com.baidu.tieba.y.remove_black_alert), userName);
            }
            this.j.setMessage(format);
            this.j.show();
        }
    }

    private void p() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f);
        builder.setPositiveButton(getString(com.baidu.tieba.y.confirm), new bw(this));
        builder.setNegativeButton(getString(com.baidu.tieba.y.cancel), new bx(this));
        this.j = builder.create();
    }

    private void q() {
        r();
        this.i.b();
    }

    private void r() {
        this.i = new com.baidu.tbadk.core.dialog.d(this.f);
        this.i.a(new Object[]{this.f.getString(this.d.a() == 1 ? com.baidu.tieba.y.delete_to_black_list : com.baidu.tieba.y.add_to_black_list), new Object[]{this.f.getString(com.baidu.tieba.y.cancel), 1}}, new bo(this)).a(com.baidu.tbadk.core.dialog.f.a).b(80).a();
    }

    private void s() {
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.c != null && this.c.h() != null) {
            PersonImageActivity.a(this.f, a(this.f, this.c.h().getPortraitH()));
        }
    }

    private String a(Context context, String str) {
        return ((float) context.getResources().getDisplayMetrics().densityDpi) > 240.0f ? "http://himg.baidu.com/sys/portraith/item/" + str : "http://himg.baidu.com/sys/portraitl/item/" + str;
    }

    private void u() {
        this.c.i();
    }

    private void v() {
        TiebaStatic.eventStat(this.f, "enter_chat", "personclick", 1, new Object[0]);
        try {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003005, new com.baidu.tbadk.core.atomData.au(this.f, Long.parseLong(this.c.h().getUserId()), this.c.h().getUserName(), this.c.h().getPortrait(), this.c.h().getSex())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.c != null) {
            if (this.c.f() != null && this.c.f().length() > 0 && this.c.g()) {
                k();
            }
            this.c.o();
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
                    this.c.b(true);
                    this.c.a(TbadkApplication.getCurrentAccount());
                    this.c.c(TbadkApplication.getCurrentAccountName());
                    j();
                    h();
                }
            } else if (i == 11028) {
                v();
            } else if (i == 11035) {
                u();
            } else if (i == 12002) {
                if (intent != null) {
                    EditHeadActivity.a(getActivity(), 12002, 12009, intent.getData(), TbadkApplication.getCurrentAccountObj());
                }
            } else if (i == 12001) {
                EditHeadActivity.a(getActivity(), 12001, 12010, null, TbadkApplication.getCurrentAccountObj());
            } else if (i == 12010 || i == 12009) {
                if (this.g != null) {
                    this.g.setPhotoChanged(true);
                }
                r.a(true);
                if (this.c.h() != null) {
                    this.c.j().e(this.c.h().getPortrait());
                }
                h();
            } else if (i == 18003 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.c != null && this.c.c()) {
                int size = this.c.a().post_list.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        z = false;
                        break;
                    } else if (stringExtra.equals(new StringBuilder(String.valueOf(this.c.a().post_list.get(i3).thread_id)).toString())) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z && intent.getIntExtra("type", -1) == 0) {
                    this.c.a().post_list.remove(i3);
                    this.k.a(this.c);
                }
            }
        } else if (i2 == 0) {
            if (i == 12009) {
                com.baidu.tbadk.core.util.bb.c(getActivity());
            } else if (i == 12010) {
                com.baidu.tbadk.core.util.bb.a(getActivity());
            }
        }
    }

    private void a(Intent intent) {
        PersonChangeData personChangeData = (PersonChangeData) intent.getSerializableExtra("person_change_data");
        if (personChangeData != null && this.c.h() != null) {
            this.c.a(personChangeData);
            if (personChangeData.getPhotoChanged()) {
                if (this.g != null) {
                    this.g.setPhotoChanged(true);
                }
                r.a(true);
                if (this.c.h() != null) {
                    this.c.j().e(this.c.h().getPortrait());
                }
            }
            h();
        }
    }

    private void w() {
        String[] strArr = {getString(com.baidu.tieba.y.hd_photo), getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f);
        builder.setTitle(getString(com.baidu.tieba.y.operation));
        builder.setItems(strArr, new bp(this));
        if (this.h == null) {
            this.h = builder.create();
            this.h.setCanceledOnTouchOutside(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null) {
            if (!(responsedMessage instanceof NewsNotifyMessage)) {
                BdLog.e("transform error");
                return;
            }
            int msgFans = ((NewsNotifyMessage) responsedMessage).getMsgFans();
            if (this.c != null && msgFans > 0) {
                this.c.a(msgFans);
                this.n.a(true);
                this.n.b();
                this.k.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.n.getBackBtn().getId()) {
            this.f.finish();
        } else if (view.getId() == this.n.getEditBtn().getId()) {
            if (!this.c.g()) {
                s();
                return;
            }
            PersonChangeData personChangeData = new PersonChangeData();
            if (this.c.h() != null) {
                personChangeData.setName(this.c.h().getName_show());
                personChangeData.setIntro(this.c.h().getIntro());
                personChangeData.setSex(this.c.h().getSex());
                personChangeData.setPortrait(this.c.h().getPortrait());
            }
            PersonChangeActivity.a(this.f, 101, personChangeData, true);
            com.baidu.tbadk.core.f.a(this.f, "person_editprofile_click");
        } else if (view.getId() == this.o.getAttentionBtn().getId()) {
            if (this.c.h() != null) {
                if (TbadkApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccount().length() <= 0) {
                    LoginActivity.a((Activity) this.f, this.f.getResources().getString(com.baidu.tieba.y.login_to_attention), true, 11035);
                } else if (!this.c.g()) {
                    u();
                } else {
                    AntiHelper.a(this.f, this.c.e(), AntiHelper.OperationType.ACCOUNT_RESTORE, AntiHelper.PageType.PERSON_INFO);
                }
            }
        } else if (view.getId() == this.o.getSendBtn().getId()) {
            if (this.c.h() != null) {
                if (TbadkApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccount().length() <= 0) {
                    LoginActivity.a((Activity) this.f, this.f.getResources().getString(com.baidu.tieba.y.login_to_chat), true, 11028);
                } else if (!this.c.g()) {
                    v();
                }
            }
        } else if (view.getId() == this.o.getUserIcon().getId()) {
            if (this.c.h() != null) {
                if (this.c.g()) {
                    if (this.h != null) {
                        this.h.show();
                        return;
                    }
                    return;
                }
                t();
            }
        } else if (view.getId() == this.o.getUserIconView1().getId() || view.getId() == this.o.getUserIconView2().getId()) {
            if (this.c.h() != null) {
                TbWebViewActivity.b(this.f, this.f.getString(com.baidu.tieba.y.user_icon_intro), String.valueOf(b) + "?st_type=person_user_icon");
            }
        } else if (view.getId() == this.n.getAttentionId()) {
            if (this.c != null && this.c.h() != null) {
                if (this.c.g()) {
                    com.baidu.tbadk.core.f.a(this.f, "person_self_attentionper_click");
                } else {
                    com.baidu.tbadk.core.f.a(this.f, "person_guid_attentionper_click");
                }
                PersonListActivity.a(this.f, true, this.c.h().getUserId(), this.c.h() != null ? this.c.h().getSex() : 0);
            }
        } else if (view.getId() == this.n.getPostId()) {
            if (this.c != null && this.c.h() != null) {
                if (this.c.g()) {
                    com.baidu.tbadk.core.f.a(this.f, "person_self_thread_click");
                } else {
                    com.baidu.tbadk.core.f.a(this.f, "person_guid_thread_click");
                }
                PersonPostActivity.a(this.f, this.c.h().getUserId(), this.c.h().getSex(), this.c.h().getPortrait());
            }
        } else if (view.getId() == this.n.getFansId()) {
            if (this.c != null && this.c.h() != null) {
                if (this.c.g()) {
                    com.baidu.tbadk.core.f.a(this.f, "person_self_attentionme_click");
                } else {
                    com.baidu.tbadk.core.f.a(this.f, "person_guid_attentionme_click");
                }
                this.n.a(false);
                this.n.b();
                this.k.j();
                PersonListActivity.a(this.f, false, this.c.h().getUserId(), this.c.h() != null ? this.c.h().getSex() : 0);
            }
        } else if (view.getId() == this.n.getForumId()) {
            if (this.c != null && this.c.h() != null) {
                if (this.c.g()) {
                    EditBarActivity.a(this.f, 103, null, this.c.h() != null ? this.c.h().getSex() : 0);
                    com.baidu.tbadk.core.f.a(this.f, "person_self_attentionbar_click");
                    return;
                }
                EditBarActivity.a(this.f, 103, this.c.h().getUserId(), this.c.h() != null ? this.c.h().getSex() : 0);
                com.baidu.tbadk.core.f.a(this.f, "person_guid_attentionbar_click");
            }
        } else if (view.getId() == this.o.getUserVipView() && this.c.h() != null) {
            TbWebViewActivity.a(this.f, getString(com.baidu.tieba.y.member_benefits), String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/tbeanmall?_client_version=" + TbConfig.getVersion());
        }
    }
}
