package com.baidu.tieba.person.post;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.view.PbListView;
import java.util.Timer;
/* loaded from: classes.dex */
public final class u extends com.baidu.tbadk.core.d implements AbsListView.OnScrollListener, s {
    private x b;
    private r c;
    private boolean d;
    private String e;
    private PbListView f;
    private View g;
    private com.baidu.tbadk.core.view.q h;
    private int i;
    private boolean j = false;
    private boolean k = true;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(com.baidu.tieba.a.i.person_thread_fragment, viewGroup, false);
        this.b = new x(inflate);
        this.b.b.setText(getArguments().getString("key_empty_view_text"));
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        this.e = getArguments().getString("key_uid");
        FragmentActivity activity = getActivity();
        String str = this.e;
        getArguments().getString("key_portrait_url");
        this.c = new r(activity, str);
        this.b.a.setAdapter((ListAdapter) this.c);
        this.h = new com.baidu.tbadk.core.view.q(getActivity());
        this.h.a(new v(this));
        this.b.a.setPullRefresh(this.h);
        this.c.a(this);
        this.b.a.setOnScrollListener(this);
        this.f = new PbListView(getActivity());
        this.g = this.f.b().findViewById(com.baidu.tieba.a.h.pb_more_view);
        this.b.a.setNextPage(this.f);
    }

    @Override // com.baidu.tbadk.core.d
    public final void c(int i) {
        super.c(i);
        if (isAdded()) {
            if (this.g != null) {
                TextView textView = (TextView) this.g.findViewById(com.baidu.tieba.a.h.pb_more_text);
                if (TbadkApplication.j().l() == 1) {
                    textView.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_header_uname_1));
                } else {
                    textView.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_header_uname));
                }
            }
            if (this.f != null) {
                this.f.c(i);
            }
            if (this.h != null) {
                this.h.a(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (!this.d) {
            this.b.a.setEmptyView(this.b.c);
            if (this.c != null) {
                this.c.a(true);
            }
            this.d = true;
        }
        if (this.c != null) {
            this.c.notifyDataSetChanged();
        }
        c(TbadkApplication.j().l());
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        if (this.c != null) {
            this.c.a();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.person.post.s
    public final void a(PersonPostThreadModel personPostThreadModel, boolean z) {
        boolean z2;
        if (isAdded()) {
            this.b.a.setEmptyView(null);
            this.b.c.setVisibility(8);
            if (personPostThreadModel == null || personPostThreadModel.hide_post == 0 || getActivity() == null) {
                z2 = true;
            } else {
                this.c = null;
                com.baidu.adp.lib.util.i.b((Context) getActivity(), com.baidu.tieba.a.k.his_post_not_available);
                new Timer().schedule(new w(this), 2000L);
                this.g.setVisibility(4);
                z2 = false;
            }
            if (z2) {
                if (TbadkApplication.j().l() == 1) {
                    this.b.b.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_header_uname_1));
                } else {
                    this.b.b.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_header_uname));
                }
                if (personPostThreadModel == null || (personPostThreadModel.post_list.size() == 0 && this.k && (personPostThreadModel.getErrorString() == null || (personPostThreadModel.getErrorString() != null && personPostThreadModel.getErrorString().equals(""))))) {
                    this.b.a.setEmptyView(this.b.b);
                    return;
                }
                if (personPostThreadModel.getErrorString() != null && !personPostThreadModel.getErrorString().equals("")) {
                    if (personPostThreadModel.post_list.size() == 0) {
                        this.b.a.setEmptyView(this.b.b);
                    }
                    com.baidu.adp.lib.util.i.a((Context) getActivity(), personPostThreadModel.getErrorString());
                }
                if (personPostThreadModel.post_list.size() < 20) {
                    if (UtilHelper.a()) {
                        this.j = false;
                        this.f.a(getString(com.baidu.tieba.a.k.person_post_thread_no_more));
                        this.g.setVisibility(0);
                    } else {
                        this.g.setVisibility(8);
                    }
                }
                this.f.e();
                this.b.a.b();
                if (z) {
                    this.j = true;
                    this.i = 0;
                    this.k = false;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.j && i3 > 2 && this.i != i3 && i + i2 == i3) {
            this.i = i3;
            this.c.a(false);
            this.g.setVisibility(0);
            this.f.d();
        }
    }
}
