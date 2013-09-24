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
import com.slidingmenu.lib.R;
import java.util.Timer;
/* loaded from: classes.dex */
public class PersonThreadFragment extends BaseFragment implements AbsListView.OnScrollListener, r {

    /* renamed from: a  reason: collision with root package name */
    private v f1708a;
    private q b;
    private boolean c;
    private String d;
    private PbListView e;
    private View f;
    private com.baidu.tieba.view.ab g;
    private int h;
    private boolean i = false;
    private boolean Y = true;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_thread_fragment, viewGroup, false);
        this.f1708a = new v(inflate);
        this.f1708a.b.setText(g().getString("key_empty_view_text"));
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void a(View view, Bundle bundle) {
        this.d = g().getString("key_uid");
        this.b = new q(h(), this.d, g().getString("key_portrait_url"));
        this.f1708a.f1727a.setAdapter((ListAdapter) this.b);
        this.g = new com.baidu.tieba.view.ab(h());
        this.g.a(new t(this));
        this.f1708a.f1727a.setPullRefresh(this.g);
        this.b.a(this);
        this.f1708a.f1727a.setOnScrollListener(this);
        this.e = new PbListView(h());
        this.f = this.e.b().findViewById(R.id.pb_more_view);
        this.f1708a.f1727a.setNextPage(this.e);
    }

    @Override // com.baidu.tieba.BaseFragment
    public void b(int i) {
        super.b(i);
        if (k()) {
            TextView textView = (TextView) this.f.findViewById(R.id.pb_more_text);
            if (TiebaApplication.g().ap() == 1) {
                textView.setTextColor(i().getColor(R.color.person_post_header_uname_1));
            } else {
                textView.setTextColor(i().getColor(R.color.person_post_header_uname));
            }
            if (this.e != null) {
                this.e.a(i);
            }
            this.g.a(i);
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void o() {
        super.o();
        a();
        this.b.notifyDataSetChanged();
    }

    public void a() {
        if (!this.c) {
            this.f1708a.f1727a.setEmptyView(this.f1708a.c);
            this.b.a(true);
            this.c = true;
        }
    }

    @Override // com.baidu.tieba.person.post.r
    public void a(PersonPostThreadModel personPostThreadModel, boolean z) {
        if (k()) {
            this.f1708a.f1727a.setEmptyView(null);
            this.f1708a.c.setVisibility(8);
            if (a(personPostThreadModel)) {
                if (personPostThreadModel == null || (personPostThreadModel.post_list.size() == 0 && this.Y && (personPostThreadModel.getErrorString() == null || (personPostThreadModel.getErrorString() != null && personPostThreadModel.getErrorString().equals(""))))) {
                    if (TiebaApplication.g().ap() == 1) {
                        this.f1708a.b.setTextColor(i().getColor(R.color.person_post_header_uname_1));
                    } else {
                        this.f1708a.b.setTextColor(i().getColor(R.color.person_post_header_uname));
                    }
                    this.f1708a.f1727a.setEmptyView(this.f1708a.b);
                    return;
                }
                if (personPostThreadModel.getErrorString() != null && !personPostThreadModel.getErrorString().equals("")) {
                    UtilHelper.a((Context) h(), personPostThreadModel.getErrorString());
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
                this.f1708a.f1727a.a();
                if (z) {
                    this.i = true;
                    this.h = 0;
                    this.Y = false;
                }
            }
        }
    }

    private boolean a(PersonPostThreadModel personPostThreadModel) {
        if (personPostThreadModel == null || personPostThreadModel.hide_post == 0 || h() == null) {
            return true;
        }
        this.b = null;
        Toast.makeText(h(), (int) R.string.his_post_not_available, 1).show();
        new Timer().schedule(new u(this), 2000L);
        this.f.setVisibility(4);
        return false;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.i && i3 > 2 && this.h != i3 && i + i2 == i3) {
            this.h = i3;
            this.b.a(false);
            this.f.setVisibility(0);
            this.e.c();
        }
    }
}
