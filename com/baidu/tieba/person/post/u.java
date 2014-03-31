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
    private x a;
    private r b;
    private boolean c;
    private String d;
    private PbListView e;
    private View f;
    private com.baidu.tbadk.core.view.q g;
    private int h;
    private boolean i = false;
    private boolean j = true;

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(com.baidu.tieba.a.i.person_thread_fragment, viewGroup, false);
        this.a = new x(inflate);
        this.a.b.setText(getArguments().getString("key_empty_view_text"));
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        this.d = getArguments().getString("key_uid");
        FragmentActivity activity = getActivity();
        String str = this.d;
        getArguments().getString("key_portrait_url");
        this.b = new r(activity, str);
        this.a.a.setAdapter((ListAdapter) this.b);
        this.g = new com.baidu.tbadk.core.view.q(getActivity());
        this.g.a(new v(this));
        this.a.a.setPullRefresh(this.g);
        this.b.a(this);
        this.a.a.setOnScrollListener(this);
        this.e = new PbListView(getActivity());
        this.f = this.e.b().findViewById(com.baidu.tieba.a.h.pb_more_view);
        this.a.a.setNextPage(this.e);
    }

    @Override // com.baidu.tbadk.core.d
    public final void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.f != null) {
                TextView textView = (TextView) this.f.findViewById(com.baidu.tieba.a.h.pb_more_text);
                if (TbadkApplication.j().l() == 1) {
                    textView.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_header_uname_1));
                } else {
                    textView.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_header_uname));
                }
            }
            if (this.e != null) {
                this.e.c(i);
            }
            if (this.g != null) {
                this.g.a(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (!this.c) {
            this.a.a.setEmptyView(this.a.c);
            if (this.b != null) {
                this.b.a(true);
            }
            this.c = true;
        }
        if (this.b != null) {
            this.b.notifyDataSetChanged();
        }
        onChangeSkinType(TbadkApplication.j().l());
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        if (this.b != null) {
            this.b.a();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tieba.person.post.s
    public final void a(PersonPostThreadModel personPostThreadModel, boolean z) {
        boolean z2;
        if (isAdded()) {
            this.a.a.setEmptyView(null);
            this.a.c.setVisibility(8);
            if (personPostThreadModel == null || personPostThreadModel.hide_post == 0 || getActivity() == null) {
                z2 = true;
            } else {
                this.b = null;
                com.baidu.adp.lib.util.i.b((Context) getActivity(), com.baidu.tieba.a.k.his_post_not_available);
                new Timer().schedule(new w(this), 2000L);
                this.f.setVisibility(4);
                z2 = false;
            }
            if (z2) {
                if (TbadkApplication.j().l() == 1) {
                    this.a.b.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_header_uname_1));
                } else {
                    this.a.b.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_header_uname));
                }
                if (personPostThreadModel == null || (personPostThreadModel.post_list.size() == 0 && this.j && (personPostThreadModel.getErrorString() == null || (personPostThreadModel.getErrorString() != null && personPostThreadModel.getErrorString().equals(""))))) {
                    this.a.a.setEmptyView(this.a.b);
                    return;
                }
                if (personPostThreadModel.getErrorString() != null && !personPostThreadModel.getErrorString().equals("")) {
                    if (personPostThreadModel.post_list.size() == 0) {
                        this.a.a.setEmptyView(this.a.b);
                    }
                    com.baidu.adp.lib.util.i.a((Context) getActivity(), personPostThreadModel.getErrorString());
                }
                if (personPostThreadModel.post_list.size() < 20) {
                    if (UtilHelper.a()) {
                        this.i = false;
                        this.e.a(getString(com.baidu.tieba.a.k.person_post_thread_no_more));
                        this.f.setVisibility(0);
                    } else {
                        this.f.setVisibility(8);
                    }
                }
                this.e.e();
                this.a.a.b();
                if (z) {
                    this.i = true;
                    this.h = 0;
                    this.j = false;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.i && i3 > 2 && this.h != i3 && i + i2 == i3) {
            this.h = i3;
            this.b.a(false);
            this.f.setVisibility(0);
            this.e.d();
        }
    }
}
