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
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.person.post.PersonPostModel;
import com.baidu.tieba.view.PbListView;
import java.util.List;
/* loaded from: classes.dex */
public class k extends com.baidu.tbadk.core.d implements AbsListView.OnScrollListener {
    private View b;
    private BdListView c;
    private g d;
    private ProgressBar e;
    private TextView g;
    private com.baidu.tbadk.core.view.q h;
    private PbListView i;
    private View j;
    private int l;
    private boolean f = false;
    private boolean k = false;
    private boolean m = true;
    private f n = new l(this);
    private com.baidu.adp.framework.listener.b o = new m(this, MessageTypes.CMD_USER_POST_PAGE);
    private HttpMessageListener p = new n(this, CmdConfig.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(this.o);
        a(this.p);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = layoutInflater.inflate(com.baidu.tieba.w.person_reply_fragment, viewGroup, false);
        this.c = (BdListView) this.b.findViewById(com.baidu.tieba.v.listview_reply);
        this.g = (TextView) this.b.findViewById(com.baidu.tieba.v.txt_listview_emptyview);
        this.g.setText(getArguments().getString("key_empty_view_text"));
        this.e = (ProgressBar) this.b.findViewById(com.baidu.tieba.v.person_post_progress);
        return this.b;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.h = new com.baidu.tbadk.core.view.q(getActivity());
        this.c.setPullRefresh(this.h);
        this.h.a(new o(this));
        this.c.setOnScrollListener(this);
        this.i = new PbListView(getActivity());
        this.c.setNextPage(this.i);
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
    public void onResume() {
        super.onResume();
        a();
        this.d.notifyDataSetChanged();
        c(TbadkApplication.m252getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.a();
        }
    }

    private void f() {
        this.d = new g(getActivity(), getArguments().getString("key_uid"), getArguments().getString("key_portrait_url"));
        this.d.a(this.n);
        this.d.a(true);
        this.c.setAdapter((ListAdapter) this.d);
    }

    public void a() {
        if (!this.f) {
            f();
            this.f = true;
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
            this.d.a(false);
            this.j.setVisibility(0);
            this.i.d();
        }
    }
}
