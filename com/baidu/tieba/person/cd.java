package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.EnterGuideCenterView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class cd extends com.baidu.tbadk.core.d implements View.OnClickListener, AdapterView.OnItemClickListener {
    public BdListView b = null;
    private cl d = null;
    private View e = null;
    private EnterGuideCenterView f = null;
    private com.baidu.tbadk.core.view.u g = null;
    private cn h = null;
    private int i = 0;
    int c = 0;
    private boolean j = true;
    private com.baidu.tieba.data.am k = null;
    private boolean l = true;
    private boolean m = false;
    private int n = 0;
    private int o = 20;
    private final CustomMessageListener p = new ce(this, 2001186);
    private HttpMessageListener q = new cf(this, 1002000);

    /* JADX INFO: Access modifiers changed from: private */
    public PersonFriendActivity f() {
        FragmentActivity activity = getActivity();
        if (activity instanceof PersonFriendActivity) {
            return (PersonFriendActivity) activity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        c(TbadkApplication.m252getInst().getSkinType());
        if (f() != null) {
            this.h = f().w();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.d != null) {
            this.d.a();
            this.d = null;
        }
        MessageManager.getInstance().unRegisterListener(this.q);
        MessageManager.getInstance().unRegisterListener(this.p);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.q);
        a(this.p);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f != null) {
            this.f.b();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.f != null) {
            this.f.c();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.d != null) {
            this.d.a();
            this.d = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.i = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.v.friend_fragment, viewGroup, false);
        this.d = new cl(f(), f().p(), this.i, new cg(this), new ch(this));
        this.b = (BdListView) inflate.findViewById(com.baidu.tieba.u.my_friend_list);
        this.b.setOnItemClickListener(new ci(this));
        this.b.setAdapter((ListAdapter) this.d);
        this.g = new com.baidu.tbadk.core.view.u(f());
        this.g.a(new cj(this));
        this.b.setPullRefresh(this.g);
        this.f = (EnterGuideCenterView) inflate.findViewById(com.baidu.tieba.u.friend_guid_center_root);
        this.j = f().p();
        this.f.a(com.baidu.tieba.t.pic_emotion05, com.baidu.tieba.t.pic_emotion05_1);
        if (f() != null) {
            if (this.j) {
                this.f.setTipTextByString(String.format(getString(com.baidu.tieba.x.person_friend_no_personal_info), getString(com.baidu.tieba.x.you)));
            } else if (this.i == 0) {
                this.f.setTipTextByString(String.format(getString(com.baidu.tieba.x.person_friend_no_personal_info), f().o()));
            } else {
                this.f.setTipText(com.baidu.tieba.x.person_friend_no_common_info);
            }
        }
        this.e = inflate.findViewById(com.baidu.tieba.u.friend_fragment_parent);
        this.b.setOnSrollToBottomListener(new ck(this));
        if (f() != null) {
            this.h = f().w();
            if (this.j) {
                a();
            }
        }
        if (this.i == f().q()) {
            this.n = 0;
            this.b.e();
        }
        return inflate;
    }

    public void a() {
        if (this.h != null) {
            this.h.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.d != null) {
            this.d.b(true);
            this.d.notifyDataSetChanged();
        }
        this.n = this.h.b().a().d() + 1;
        this.h.a(this.j, this.h.a(), this.n, this.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        UserData userData;
        if (this.d != null && this.d.getItemViewType(this.c) == 0 && (userData = (UserData) this.d.getItem(this.c)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(f(), "enter_chat", "personlistclick", 1, new Object[0]);
            a(new CustomMessage(2002005, new com.baidu.tbadk.core.atomData.bj(f(), com.baidu.adp.lib.e.b.a(userData.getUserId(), 0L), userData.getUserName(), userData.getPortrait(), userData.getSex())));
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        if (isAdded()) {
            if (this.e != null && getActivity() != null) {
                ((BaseFragmentActivity) getActivity()).c().a(this.e);
            }
            if (this.f != null) {
                if (i == 1) {
                    this.f.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_d_1);
                } else {
                    this.f.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_d);
                }
            }
            if (this.g != null) {
                this.g.a(i);
            }
        }
    }

    public void a(com.baidu.tieba.data.am amVar, boolean z) {
        com.baidu.tieba.data.am amVar2;
        if (amVar != null) {
            this.b.d();
            if (this.h != null && f() != null) {
                if (!z) {
                    if (this.l) {
                        this.l = false;
                        if (this.i == f().q()) {
                            this.h.a(amVar);
                            amVar2 = amVar;
                        }
                    } else {
                        if (this.i == f().q()) {
                            a(amVar);
                        }
                        amVar2 = this.h.b();
                    }
                    this.k = amVar2;
                    b(amVar2);
                    c(amVar);
                }
                amVar2 = amVar;
                this.k = amVar2;
                b(amVar2);
                c(amVar);
            }
        }
    }

    public void a(com.baidu.tieba.data.am amVar) {
        if (amVar != null && this.h != null) {
            this.h.b().b().addAll(amVar.b());
            this.h.b().c().addAll(amVar.c());
            this.h.b().a(amVar.a());
        }
    }

    private void b(com.baidu.tieba.data.am amVar) {
        boolean z = true;
        if (this.d != null) {
            if (amVar != null) {
                com.baidu.tbadk.core.data.l a = amVar.a();
                if (this.i == 0) {
                    cl clVar = this.d;
                    if (a == null || a.f() != 1) {
                        z = false;
                    }
                    clVar.a(z);
                    this.d.a(amVar.b());
                } else {
                    if (amVar.c().size() < this.o) {
                        this.d.a(false);
                    } else {
                        this.d.a(true);
                    }
                    this.d.a(amVar.c());
                }
                this.d.b(false);
                this.d.b();
                this.d.notifyDataSetChanged();
                return;
            }
            this.d.a(false);
            this.d.a(new ArrayList<>());
            this.d.b(false);
            this.d.b();
            this.d.notifyDataSetChanged();
        }
    }

    private void c(com.baidu.tieba.data.am amVar) {
        if (f() != null && this.h != null) {
            if (this.i == 0) {
                if (this.h.b().b().size() == 0) {
                    if (this.k != null && this.k.b().size() > 0) {
                        this.f.b(8);
                        this.b.setVisibility(0);
                    } else {
                        this.f.b(0);
                        this.b.setVisibility(0);
                    }
                } else {
                    this.f.b(8);
                    this.b.setVisibility(0);
                }
            } else if (this.h.b().c().size() == 0) {
                if (this.k != null && this.k.c().size() > 0) {
                    this.f.b(8);
                    this.b.setVisibility(0);
                } else {
                    this.f.b(0);
                    this.b.setVisibility(0);
                }
            } else {
                this.f.b(8);
                this.b.setVisibility(0);
            }
            f().b(this.h.b().d(), this.h.b().e());
        }
    }
}
