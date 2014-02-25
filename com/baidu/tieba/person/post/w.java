package com.baidu.tieba.person.post;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.PbListView;
import com.baidu.tieba.view.ct;
import com.slidingmenu.lib.R;
import java.util.Timer;
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.j implements AbsListView.OnScrollListener, u {
    private z b;
    private t c;
    private boolean d;
    private String e;
    private PbListView f;
    private View g;
    private ct h;
    private int i;
    private boolean j = false;
    private boolean k = true;

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.b = new z(inflate);
        this.b.b.setText(getArguments().getString("key_empty_view_text"));
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.e = getArguments().getString("key_uid");
        this.c = new t(getActivity(), this.e, getArguments().getString("key_portrait_url"));
        this.b.a.setAdapter((ListAdapter) this.c);
        this.h = new ct(getActivity());
        this.h.a(new x(this));
        this.b.a.setPullRefresh(this.h);
        this.c.a(this);
        this.b.a.setOnScrollListener(this);
        this.f = new PbListView(getActivity());
        this.g = this.f.b().findViewById(R.id.pb_more_view);
        this.b.a.setNextPage(this.f);
    }

    @Override // com.baidu.tieba.j
    public void c(int i) {
        super.c(i);
        if (isAdded()) {
            TextView textView = (TextView) this.g.findViewById(R.id.pb_more_text);
            if (TiebaApplication.g().al() == 1) {
                textView.setTextColor(getResources().getColor(R.color.person_post_header_uname_1));
            } else {
                textView.setTextColor(getResources().getColor(R.color.person_post_header_uname));
            }
            if (this.f != null) {
                this.f.d(i);
            }
            this.h.a(i);
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        a();
        if (this.c != null) {
            this.c.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.c != null) {
            this.c.a();
        }
        super.onDestroy();
    }

    public void a() {
        if (!this.d) {
            this.b.a.setEmptyView(this.b.c);
            if (this.c != null) {
                this.c.a(true);
            }
            this.d = true;
        }
    }

    @Override // com.baidu.tieba.person.post.u
    public void a(PersonPostThreadModel personPostThreadModel, boolean z) {
        if (isAdded()) {
            this.b.a.setEmptyView(null);
            this.b.c.setVisibility(8);
            if (a(personPostThreadModel)) {
                if (TiebaApplication.g().al() == 1) {
                    this.b.b.setTextColor(getResources().getColor(R.color.person_post_header_uname_1));
                } else {
                    this.b.b.setTextColor(getResources().getColor(R.color.person_post_header_uname));
                }
                if (personPostThreadModel == null || (personPostThreadModel.post_list.size() == 0 && this.k && (personPostThreadModel.getErrorString() == null || (personPostThreadModel.getErrorString() != null && personPostThreadModel.getErrorString().equals(""))))) {
                    this.b.a.setEmptyView(this.b.b);
                    return;
                }
                if (personPostThreadModel.getErrorString() != null && !personPostThreadModel.getErrorString().equals("")) {
                    if (personPostThreadModel.post_list.size() == 0) {
                        this.b.a.setEmptyView(this.b.b);
                    }
                    BdUtilHelper.a((Context) getActivity(), personPostThreadModel.getErrorString());
                }
                if (personPostThreadModel.post_list.size() < 20) {
                    if (UtilHelper.b()) {
                        this.j = false;
                        this.f.a(getString(R.string.person_post_thread_no_more));
                        this.g.setVisibility(0);
                    } else {
                        this.g.setVisibility(8);
                    }
                }
                this.f.d();
                this.b.a.a();
                if (z) {
                    this.j = true;
                    this.i = 0;
                    this.k = false;
                }
            }
        }
    }

    private boolean a(PersonPostThreadModel personPostThreadModel) {
        if (personPostThreadModel == null || personPostThreadModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.c = null;
        BdUtilHelper.b((Context) getActivity(), (int) R.string.his_post_not_available);
        new Timer().schedule(new y(this), 2000L);
        this.g.setVisibility(4);
        return false;
    }

    @Override // com.baidu.tieba.j, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tieba.j, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.j && i3 > 2 && this.i != i3 && i + i2 == i3) {
            this.i = i3;
            this.c.a(false);
            this.g.setVisibility(0);
            this.f.c();
        }
    }
}
