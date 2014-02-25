package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.view.PbListView;
import com.baidu.tieba.view.ct;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.j implements AbsListView.OnScrollListener {
    private View b;
    private BdListView c;
    private l d;
    private ProgressBar e;
    private TextView g;
    private ct h;
    private PbListView i;
    private View j;
    private int l;
    private boolean f = false;
    private boolean k = false;
    private boolean m = true;
    private o n = new r(this);

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.c = (BdListView) this.b.findViewById(R.id.listview_reply);
        this.g = (TextView) this.b.findViewById(R.id.txt_listview_emptyview);
        this.g.setText(getArguments().getString("key_empty_view_text"));
        this.e = (ProgressBar) this.b.findViewById(R.id.person_post_progress);
        return this.b;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.h = new ct(getActivity());
        this.c.setPullRefresh(this.h);
        this.h.a(new s(this));
        this.c.setOnScrollListener(this);
        this.i = new PbListView(getActivity());
        this.c.setNextPage(this.i);
        this.j = this.i.b().findViewById(R.id.pb_more_view);
        this.j.setVisibility(8);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        a();
        this.d.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.a();
        }
    }

    private void c() {
        this.d = new l(getActivity(), getArguments().getString("key_uid"), getArguments().getString("key_portrait_url"));
        this.d.a(this.n);
        this.d.a(true);
        this.c.setAdapter((ListAdapter) this.d);
    }

    public void a() {
        if (!this.f) {
            c();
            this.f = true;
        }
    }

    @Override // com.baidu.tieba.j
    public void c(int i) {
        super.c(i);
        if (isAdded()) {
            TextView textView = (TextView) this.j.findViewById(R.id.pb_more_text);
            if (i == 1) {
                textView.setTextColor(getResources().getColor(R.color.person_post_header_uname_1));
            } else {
                textView.setTextColor(getResources().getColor(R.color.person_post_header_uname));
            }
            if (this.i != null) {
                this.i.d(i);
            }
            this.h.a(i);
        }
    }

    @Override // com.baidu.tieba.j, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tieba.j, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.k && i3 > 2 && this.l != i3 && i + i2 == i3) {
            this.l = i3;
            this.d.a(false);
            this.j.setVisibility(0);
            this.i.c();
        }
    }
}
