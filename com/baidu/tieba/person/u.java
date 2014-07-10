package com.baidu.tieba.person;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.EnterGuideCenterView;
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.core.d implements View.OnClickListener, AdapterView.OnItemClickListener {
    private af f;
    public BdListView b = null;
    private ad c = null;
    private int d = -1;
    private String e = null;
    private View g = null;
    private EnterGuideCenterView h = null;
    private com.baidu.tbadk.core.view.q i = null;
    private TextView j = null;
    private ForumData k = null;
    private boolean l = false;
    private int m = 0;
    private boolean n = true;
    private final CustomMessageListener o = new v(this, 2001187);
    private HttpMessageListener p = new w(this, 1002002);
    private HttpMessageListener q = new x(this, 1002001);

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity f() {
        FragmentActivity activity = getActivity();
        if (activity instanceof PersonBarActivity) {
            return (PersonBarActivity) activity;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        c(TbadkApplication.m252getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.q);
        a(this.p);
        a(this.o);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.h != null) {
            this.h.b();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.h != null) {
            this.h.c();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.c != null) {
            this.c = null;
        }
        MessageManager.getInstance().unRegisterListener(this.p);
        MessageManager.getInstance().unRegisterListener(this.q);
        MessageManager.getInstance().unRegisterListener(this.o);
        super.onDestroyView();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.m = getArguments().getInt("page_type", 0);
        View inflate = layoutInflater.inflate(com.baidu.tieba.w.friend_fragment, viewGroup, false);
        if (f() == null) {
            return inflate;
        }
        this.f = f().w();
        this.n = f().p();
        this.g = inflate.findViewById(com.baidu.tieba.v.friend_fragment_parent);
        if (this.n) {
            this.j = f().h().a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.y.edit));
            this.j.setOnClickListener(new y(this));
            this.j.setVisibility(0);
        }
        this.c = new ad(f(), this.f.b(), this.n);
        this.c.a(new z(this));
        this.c.b(new aa(this));
        this.b = (BdListView) inflate.findViewById(com.baidu.tieba.v.my_friend_list);
        this.b.setAdapter((ListAdapter) this.c);
        this.b.setOnItemClickListener(new ab(this));
        this.i = new com.baidu.tbadk.core.view.q(f());
        this.i.a(new ac(this));
        this.b.setPullRefresh(this.i);
        this.h = (EnterGuideCenterView) inflate.findViewById(com.baidu.tieba.v.friend_guid_center_root);
        this.h.a(com.baidu.tieba.u.individual_center_like, com.baidu.tieba.u.individual_center_like_1);
        if (this.n) {
            this.h.setTipTextByString(String.format(getString(com.baidu.tieba.y.person_bar_no_personal_info), getString(com.baidu.tieba.y.you)));
        } else if (this.m == 0) {
            this.h.setTipTextByString(String.format(getString(com.baidu.tieba.y.person_bar_no_personal_info), f().o()));
        } else {
            this.h.setTipText(com.baidu.tieba.y.person_bar_no_common_info);
        }
        if (this.n) {
            a();
        }
        if (this.m == f().q()) {
            this.b.e();
        }
        return inflate;
    }

    public void a(boolean z) {
        if (this.c != null) {
            this.c.b();
            if (this.c.c()) {
                if (z) {
                    this.c.a(false);
                    this.h.b(0);
                    this.b.setVisibility(0);
                    return;
                }
                return;
            }
            this.h.b(8);
            this.b.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.f != null) {
            this.f.a(this.n, this.f.a());
        }
    }

    public void a() {
        if (this.f != null) {
            this.f.c();
        }
    }

    public void a(t tVar, boolean z) {
        if (tVar != null) {
            if (!z) {
                this.b.d();
            }
            int size = tVar.b() != null ? tVar.b().size() : 0;
            int size2 = tVar.c() != null ? tVar.c().size() : 0;
            if (f() != null) {
                f().b(size, size2);
            }
            if (this.f != null && this.c != null) {
                this.f.b().a(tVar.b());
                this.f.b().b(tVar.c());
                this.f.b().a(tVar.a());
                if (this.m == 0) {
                    this.c.a(this.f.b().b());
                } else {
                    this.c.a(this.f.b().c());
                }
                a(true);
                this.c.notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        if (isAdded()) {
            if (this.g != null && getActivity() != null) {
                ((BaseFragmentActivity) getActivity()).c().a(this.g);
            }
            if (this.h != null) {
                if (i == 1) {
                    this.h.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_d_1);
                } else {
                    this.h.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_d);
                }
            }
            if (f() != null) {
                f().h().c(i);
            }
            if (this.i != null) {
                this.i.a(i);
            }
        }
    }
}
