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
    private View a;
    private BdListView b;
    private j c;
    private ProgressBar d;
    private TextView f;
    private com.baidu.tbadk.core.view.q g;
    private PbListView h;
    private View i;
    private int k;
    private boolean e = false;
    private boolean j = false;
    private boolean l = true;
    private m m = new p(this);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(com.baidu.tieba.a.i.person_reply_fragment, viewGroup, false);
        this.b = (BdListView) this.a.findViewById(com.baidu.tieba.a.h.listview_reply);
        this.f = (TextView) this.a.findViewById(com.baidu.tieba.a.h.txt_listview_emptyview);
        this.f.setText(getArguments().getString("key_empty_view_text"));
        this.d = (ProgressBar) this.a.findViewById(com.baidu.tieba.a.h.person_post_progress);
        return this.a;
    }

    @Override // android.support.v4.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        this.g = new com.baidu.tbadk.core.view.q(getActivity());
        this.b.setPullRefresh(this.g);
        this.g.a(new q(this));
        this.b.setOnScrollListener(this);
        this.h = new PbListView(getActivity());
        this.b.setNextPage(this.h);
        this.i = this.h.b().findViewById(com.baidu.tieba.a.h.pb_more_view);
        this.i.setVisibility(8);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (!this.e) {
            FragmentActivity activity = getActivity();
            String string = getArguments().getString("key_uid");
            getArguments().getString("key_portrait_url");
            this.c = new j(activity, string);
            this.c.a(this.m);
            this.c.a(true);
            this.b.setAdapter((ListAdapter) this.c);
            this.e = true;
        }
        this.c.notifyDataSetChanged();
        onChangeSkinType(TbadkApplication.j().l());
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.a();
        }
    }

    @Override // com.baidu.tbadk.core.d
    public final void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (isAdded()) {
            if (this.i != null) {
                TextView textView = (TextView) this.i.findViewById(com.baidu.tieba.a.h.pb_more_text);
                if (i == 1) {
                    textView.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_header_uname_1));
                } else {
                    textView.setTextColor(getResources().getColor(com.baidu.tieba.a.e.person_post_header_uname));
                }
            }
            if (this.h != null) {
                this.h.c(i);
            }
            this.g.a(i);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.j && i3 > 2 && this.k != i3 && i + i2 == i3) {
            this.k = i3;
            this.c.a(false);
            this.i.setVisibility(0);
            this.h.d();
        }
    }
}
