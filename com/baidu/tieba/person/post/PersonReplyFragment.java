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
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.view.PbListView;
import com.baidu.tieba.view.bq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonReplyFragment extends BaseFragment implements AbsListView.OnScrollListener {
    private int Z;
    private View a;
    private BdListView b;
    private j c;
    private ProgressBar d;
    private TextView f;
    private bq g;
    private PbListView h;
    private View i;
    private boolean e = false;
    private boolean Y = false;
    private boolean aa = true;
    private m ab = new p(this);

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = layoutInflater.inflate(R.layout.person_reply_fragment, viewGroup, false);
        this.b = (BdListView) this.a.findViewById(R.id.listview_reply);
        this.f = (TextView) this.a.findViewById(R.id.txt_listview_emptyview);
        this.f.setText(h().getString("key_empty_view_text"));
        this.d = (ProgressBar) this.a.findViewById(R.id.person_post_progress);
        return this.a;
    }

    @Override // android.support.v4.app.Fragment
    public void a(View view, Bundle bundle) {
        this.g = new bq(i());
        this.b.setPullRefresh(this.g);
        this.g.a(new o(this));
        this.b.setOnScrollListener(this);
        this.h = new PbListView(i());
        this.b.setNextPage(this.h);
        this.i = this.h.b().findViewById(R.id.pb_more_view);
        this.i.setVisibility(8);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        super.r();
        a();
        this.c.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        super.t();
        if (this.c != null) {
            this.c.a();
        }
    }

    private void G() {
        this.c = new j(i(), h().getString("key_uid"), h().getString("key_portrait_url"));
        this.c.a(this.ab);
        this.c.a(true);
        this.b.setAdapter((ListAdapter) this.c);
    }

    public void a() {
        if (!this.e) {
            G();
            this.e = true;
        }
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        super.c(i);
        if (n()) {
            TextView textView = (TextView) this.i.findViewById(R.id.pb_more_text);
            if (i == 1) {
                textView.setTextColor(j().getColor(R.color.person_post_header_uname_1));
            } else {
                textView.setTextColor(j().getColor(R.color.person_post_header_uname));
            }
            if (this.h != null) {
                this.h.d(i);
            }
            this.g.a(i);
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.Y && i3 > 2 && this.Z != i3 && i + i2 == i3) {
            this.Z = i3;
            this.c.a(false);
            this.i.setVisibility(0);
            this.h.c();
        }
    }
}
