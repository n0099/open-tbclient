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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.EnterGuideCenterView;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.core.d implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ae f;
    public BdListView b = null;
    private ac c = null;
    private int d = -1;
    private String e = null;
    private View g = null;
    private EnterGuideCenterView h = null;
    private com.baidu.tbadk.core.view.u i = null;
    private TextView j = null;
    private ForumData k = null;
    private boolean l = false;
    private int m = 0;
    private boolean n = true;
    private final CustomMessageListener o = new u(this, 2001187);
    private HttpMessageListener p = new v(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
    private HttpMessageListener q = new w(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);

    /* JADX INFO: Access modifiers changed from: private */
    public PersonBarActivity g() {
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
        View inflate = layoutInflater.inflate(com.baidu.tieba.v.friend_fragment, viewGroup, false);
        if (g() == null) {
            return inflate;
        }
        this.f = g().w();
        this.n = g().p();
        this.g = inflate.findViewById(com.baidu.tieba.u.friend_fragment_parent);
        if (this.n) {
            this.j = g().h().a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getResources().getString(com.baidu.tieba.x.edit));
            this.j.setOnClickListener(new x(this));
            this.j.setVisibility(0);
        }
        this.c = new ac(g(), this.f.b(), this.n);
        this.c.a(new y(this));
        this.c.b(new z(this));
        this.b = (BdListView) inflate.findViewById(com.baidu.tieba.u.my_friend_list);
        this.b.setAdapter((ListAdapter) this.c);
        this.b.setOnItemClickListener(new aa(this));
        this.i = new com.baidu.tbadk.core.view.u(g());
        this.i.a(new ab(this));
        this.b.setPullRefresh(this.i);
        this.h = (EnterGuideCenterView) inflate.findViewById(com.baidu.tieba.u.friend_guid_center_root);
        this.h.a(com.baidu.tieba.t.pic_emotion05, com.baidu.tieba.t.pic_emotion05_1);
        if (this.n) {
            this.h.setTipTextByString(String.format(getString(com.baidu.tieba.x.person_bar_no_personal_info), getString(com.baidu.tieba.x.you)));
        } else if (this.m == 0) {
            this.h.setTipTextByString(String.format(getString(com.baidu.tieba.x.person_bar_no_personal_info), g().o()));
        } else {
            this.h.setTipText(com.baidu.tieba.x.person_bar_no_common_info);
        }
        if (this.n) {
            f();
        }
        if (this.m == g().q()) {
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

    public ac a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f != null) {
            this.f.a(this.n, this.f.a());
        }
    }

    public void f() {
        if (this.f != null) {
            this.f.c();
        }
    }

    public void a(s sVar, boolean z) {
        if (sVar != null) {
            if (!z) {
                this.b.d();
            }
            int size = sVar.c() != null ? sVar.c().size() : 0;
            int size2 = sVar.d() != null ? sVar.d().size() : 0;
            if (g() != null) {
                g().b(size, size2);
            }
            if (this.f != null && this.c != null) {
                this.f.b().a(sVar.c());
                this.f.b().b(sVar.d());
                this.f.b().a(sVar.a());
                this.f.b().b(sVar.b());
                if (this.m == 0) {
                    this.c.a(this.f.b().c());
                } else {
                    this.c.a(this.f.b().d());
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
                    this.h.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_d_1);
                } else {
                    this.h.setBackgroundResource(com.baidu.tieba.r.cp_bg_line_d);
                }
            }
            if (g() != null) {
                g().h().c(i);
            }
            if (this.i != null) {
                this.i.a(i);
            }
            if (this.c != null) {
                this.c.notifyDataSetChanged();
            }
        }
    }
}
