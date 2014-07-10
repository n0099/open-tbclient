package com.baidu.tieba.person.post;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.view.EnterGuideCenterView;
import com.baidu.tieba.person.post.PersonPostModel;
import com.baidu.tieba.view.PbListView;
import java.util.List;
/* loaded from: classes.dex */
public class l extends com.baidu.tbadk.core.d implements AbsListView.OnScrollListener {
    private View c;
    private BdListView d;
    private h e;
    private ProgressBar f;
    private com.baidu.tbadk.core.view.q h;
    private PbListView i;
    private View j;
    private int l;
    private boolean g = false;
    EnterGuideCenterView b = null;
    private boolean k = false;
    private boolean m = true;
    private g n = new m(this);
    private com.baidu.adp.framework.listener.b o = new n(this, 303002);
    private HttpMessageListener p = new o(this, 1001503);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(this.o);
        a(this.p);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = layoutInflater.inflate(com.baidu.tieba.w.person_reply_fragment, viewGroup, false);
        this.d = (BdListView) this.c.findViewById(com.baidu.tieba.v.listview_reply);
        this.b = (EnterGuideCenterView) this.c.findViewById(com.baidu.tieba.v.reply_guid_center_root);
        this.b.setTipTextByString(getArguments().getString("key_empty_view_text"));
        this.f = (ProgressBar) this.c.findViewById(com.baidu.tieba.v.person_post_progress);
        return this.c;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.h = new com.baidu.tbadk.core.view.q(getActivity());
        this.d.setPullRefresh(this.h);
        this.h.a(new p(this));
        this.d.setOnScrollListener(this);
        this.i = new PbListView(getActivity());
        this.d.setNextPage(this.i);
        this.j = this.i.b().findViewById(com.baidu.tieba.v.pb_more_view);
        this.j.setVisibility(8);
    }

    public static int a(List<PersonPostModel.PostList> list) {
        if (list == null) {
            return 0;
        }
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += list.get(i2).content.length;
        }
        return i;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.b != null) {
            this.b.b();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.b != null) {
            this.b.c();
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        a();
        this.e.notifyDataSetChanged();
        c(TbadkApplication.m252getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.e != null) {
            this.e.a();
        }
    }

    private void f() {
        this.e = new h(getActivity(), getArguments().getString("key_uid"), getArguments().getString("key_portrait_url"));
        this.e.a(this.n);
        this.e.a(true);
        this.d.setAdapter((ListAdapter) this.e);
    }

    public void a() {
        if (!this.g) {
            f();
            this.g = true;
        }
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        if (isAdded()) {
            if (this.j != null) {
                TextView textView = (TextView) this.j.findViewById(com.baidu.tieba.v.pb_more_text);
                if (i == 1) {
                    textView.setTextColor(getResources().getColor(com.baidu.tieba.s.person_post_header_uname_1));
                } else {
                    textView.setTextColor(getResources().getColor(com.baidu.tieba.s.person_post_header_uname));
                }
            }
            if (this.b != null) {
                if (i == 1) {
                    this.b.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_d_1);
                } else {
                    this.b.setBackgroundResource(com.baidu.tieba.s.cp_bg_line_d);
                }
            }
            if (this.i != null) {
                this.i.d(i);
            }
            this.h.a(i);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.k && i3 > 2 && this.l != i3 && i + i2 == i3) {
            this.l = i3;
            this.e.a(false);
            this.j.setVisibility(0);
            this.i.d();
        }
    }
}
