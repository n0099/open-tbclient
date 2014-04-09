package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.view.PbListView;
/* loaded from: classes.dex */
public final class o extends com.baidu.tbadk.core.d implements AbsListView.OnScrollListener {
    private View b;
    private BdListView c;
    private j d;
    private ProgressBar e;
    private TextView g;
    private com.baidu.tbadk.core.view.q h;
    private PbListView i;
    private View j;
    private int l;
    private boolean f = false;
    private boolean k = false;
    private boolean m = true;
    private m n = new p(this);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(com.baidu.tieba.a.i.person_reply_fragment, viewGroup, false);
        this.c = (BdListView) this.b.findViewById(com.baidu.tieba.a.h.listview_reply);
        this.g = (TextView) this.b.findViewById(com.baidu.tieba.a.h.txt_listview_emptyview);
        this.g.setText(getArguments().getString("key_empty_view_text"));
        this.e = (ProgressBar) this.b.findViewById(com.baidu.tieba.a.h.person_post_progress);
        return this.b;
    }

    @Override // android.support.v4.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        this.h = new com.baidu.tbadk.core.view.q(getActivity());
        this.c.setPullRefresh(this.h);
        this.h.a(new q(this));
        this.c.setOnScrollListener(this);
        this.i = new PbListView(getActivity());
        this.c.setNextPage(this.i);
        this.j = this.i.b().findViewById(com.baidu.tieba.a.h.pb_more_view);
        this.j.setVisibility(8);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (!this.f) {
            FragmentActivity activity = getActivity();
            String string = getArguments().getString("key_uid");
            getArguments().getString("key_portrait_url");
            this.d = new j(activity, string);
            this.d.a(this.n);
            this.d.a(true);
            this.c.setAdapter((ListAdapter) this.d);
            this.f = true;
        }
        this.d.notifyDataSetChanged();
        c(TbadkApplication.j().l());
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.a();
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void c(int i) {
        super.c(i);
        if (isAdded()) {
            if (this.j != null) {
                TextView textView = (TextView) this.j.findViewById(com.baidu.tieba.a.h.pb_more_text);
                if (i == 1) {
                    textView.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_header_uname_1));
                } else {
                    textView.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_header_uname));
                }
            }
            if (this.i != null) {
                this.i.c(i);
            }
            this.h.a(i);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.k && i3 > 2 && this.l != i3 && i + i2 == i3) {
            this.l = i3;
            this.d.a(false);
            this.j.setVisibility(0);
            this.i.d();
        }
    }
}
