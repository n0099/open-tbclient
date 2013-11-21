package com.baidu.tieba.person.post;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.PbListView;
import com.baidu.tieba.view.bi;
import com.slidingmenu.lib.R;
import java.util.Timer;
/* loaded from: classes.dex */
public class PersonThreadFragment extends BaseFragment implements AbsListView.OnScrollListener, r {

    /* renamed from: a  reason: collision with root package name */
    private v f2248a;
    private q b;
    private boolean c;
    private String d;
    private PbListView e;
    private View f;
    private bi g;
    private int h;
    private boolean i = false;
    private boolean Y = true;

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.f2248a = new v(inflate);
        this.f2248a.b.setText(h().getString("key_empty_view_text"));
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void a(View view, Bundle bundle) {
        this.d = h().getString("key_uid");
        this.b = new q(i(), this.d, h().getString("key_portrait_url"));
        this.f2248a.f2267a.setAdapter((ListAdapter) this.b);
        this.g = new bi(i());
        this.g.a(new t(this));
        this.f2248a.f2267a.setPullRefresh(this.g);
        this.b.a(this);
        this.f2248a.f2267a.setOnScrollListener(this);
        this.e = new PbListView(i());
        this.f = this.e.b().findViewById(R.id.pb_more_view);
        this.f2248a.f2267a.setNextPage(this.e);
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        super.c(i);
        if (n()) {
            TextView textView = (TextView) this.f.findViewById(R.id.pb_more_text);
            if (TiebaApplication.g().ap() == 1) {
                textView.setTextColor(j().getColor(R.color.person_post_header_uname_1));
            } else {
                textView.setTextColor(j().getColor(R.color.person_post_header_uname));
            }
            if (this.e != null) {
                this.e.d(i);
            }
            this.g.a(i);
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        super.r();
        a();
        this.b.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        if (this.b != null) {
            this.b.a();
        }
        super.t();
    }

    public void a() {
        if (!this.c) {
            this.f2248a.f2267a.setEmptyView(this.f2248a.c);
            this.b.a(true);
            this.c = true;
        }
    }

    @Override // com.baidu.tieba.person.post.r
    public void a(PersonPostThreadModel personPostThreadModel, boolean z) {
        if (n()) {
            this.f2248a.f2267a.setEmptyView(null);
            this.f2248a.c.setVisibility(8);
            if (a(personPostThreadModel)) {
                if (TiebaApplication.g().ap() == 1) {
                    this.f2248a.b.setTextColor(j().getColor(R.color.person_post_header_uname_1));
                } else {
                    this.f2248a.b.setTextColor(j().getColor(R.color.person_post_header_uname));
                }
                if (personPostThreadModel == null || (personPostThreadModel.post_list.size() == 0 && this.Y && (personPostThreadModel.getErrorString() == null || (personPostThreadModel.getErrorString() != null && personPostThreadModel.getErrorString().equals(""))))) {
                    this.f2248a.f2267a.setEmptyView(this.f2248a.b);
                    return;
                }
                if (personPostThreadModel.getErrorString() != null && !personPostThreadModel.getErrorString().equals("")) {
                    if (personPostThreadModel.post_list.size() == 0) {
                        this.f2248a.f2267a.setEmptyView(this.f2248a.b);
                    }
                    UtilHelper.a((Context) i(), personPostThreadModel.getErrorString());
                }
                if (personPostThreadModel.post_list.size() < 20) {
                    if (UtilHelper.b()) {
                        this.i = false;
                        this.e.a(a(R.string.person_post_thread_no_more));
                        this.f.setVisibility(0);
                    } else {
                        this.f.setVisibility(8);
                    }
                }
                this.e.d();
                this.f2248a.f2267a.a();
                if (z) {
                    this.i = true;
                    this.h = 0;
                    this.Y = false;
                }
            }
        }
    }

    private boolean a(PersonPostThreadModel personPostThreadModel) {
        if (personPostThreadModel == null || personPostThreadModel.hide_post == 0 || i() == null) {
            return true;
        }
        this.b = null;
        Toast.makeText(i(), (int) R.string.his_post_not_available, 1).show();
        new Timer().schedule(new u(this), 2000L);
        this.f.setVisibility(4);
        return false;
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.i && i3 > 2 && this.h != i3 && i + i2 == i3) {
            this.h = i3;
            this.b.a(false);
            this.f.setVisibility(0);
            this.e.c();
        }
    }
}
