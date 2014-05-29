package com.baidu.tieba.person.post;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import java.util.Timer;
/* loaded from: classes.dex */
public class s extends com.baidu.tbadk.core.d implements AbsListView.OnScrollListener, q {
    private y b;
    private p c;
    private boolean d;
    private String e;
    private com.baidu.tbadk.core.view.q f;
    private x g;
    private int h;
    private boolean i = false;
    private boolean j = true;
    private com.baidu.adp.framework.listener.b k = new t(this, MessageTypes.CMD_USER_POST_PAGE);
    private HttpMessageListener l = new u(this, CmdConfig.USER_POST_HTTP_CMD);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(this.k);
        a(this.l);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(com.baidu.tieba.w.person_thread_fragment, viewGroup, false);
        this.b = new y(inflate);
        this.b.b.setText(getArguments().getString("key_empty_view_text"));
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.e = getArguments().getString("key_uid");
        this.c = new p(getActivity(), this.e, getArguments().getString("key_portrait_url"));
        this.b.a.setAdapter((ListAdapter) this.c);
        this.f = new com.baidu.tbadk.core.view.q(getActivity());
        this.f.a(new v(this));
        this.b.a.setPullRefresh(this.f);
        this.c.a(this);
        this.b.a.setOnScrollListener(this);
        this.g = new x(this, (BaseFragmentActivity) getActivity());
        this.b.a.setNextPage(this.g);
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        if (isAdded() && this.f != null) {
            this.f.a(i);
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        a();
        if (this.c != null) {
            this.c.notifyDataSetChanged();
        }
        c(TbadkApplication.m252getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.c != null) {
            this.c.a();
        }
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        boolean z;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 18003 && intent != null && (stringExtra = intent.getStringExtra("tid")) != null && this.c != null && this.c.getCount() > 0) {
            int size = this.c.a.post_list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                } else if (!stringExtra.equals(new StringBuilder(String.valueOf(this.c.a.post_list.get(i3).thread_id)).toString())) {
                    i3++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z && intent.getIntExtra("type", -1) == 0) {
                this.c.a.post_list.remove(i3);
                this.c.notifyDataSetChanged();
            }
        }
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

    @Override // com.baidu.tieba.person.post.q
    public void a(PersonPostModel personPostModel, boolean z) {
        if (isAdded()) {
            this.b.a.setEmptyView(null);
            this.b.c.setVisibility(8);
            if (a(personPostModel)) {
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    this.b.b.setTextColor(getResources().getColor(com.baidu.tieba.s.person_post_header_uname_1));
                } else {
                    this.b.b.setTextColor(getResources().getColor(com.baidu.tieba.s.person_post_header_uname));
                }
                if (personPostModel == null || (personPostModel.post_list.size() == 0 && this.j && (personPostModel.getErrorString() == null || (personPostModel.getErrorString() != null && personPostModel.getErrorString().equals(""))))) {
                    this.b.a.setEmptyView(this.b.b);
                    return;
                }
                if (personPostModel.getErrorString() != null && !personPostModel.getErrorString().equals("")) {
                    if (personPostModel.post_list.size() == 0) {
                        this.b.a.setEmptyView(this.b.b);
                    }
                    if (personPostModel.getErrorCode() != 0) {
                        com.baidu.adp.lib.util.k.a((Context) getActivity(), personPostModel.getErrorString());
                    }
                }
                this.b.a.c();
                this.g.d();
                if (z) {
                    this.i = true;
                    this.h = 0;
                    this.j = false;
                }
            }
        }
    }

    private boolean a(PersonPostModel personPostModel) {
        if (personPostModel == null || personPostModel.hide_post == 0 || getActivity() == null) {
            return true;
        }
        this.c = null;
        com.baidu.adp.lib.util.k.b((Context) getActivity(), com.baidu.tieba.y.his_post_not_available);
        new Timer().schedule(new w(this), 2000L);
        this.g.e();
        return false;
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.i && i3 > 2 && this.h != i3 && i + i2 == i3) {
            this.h = i3;
            this.c.a(false);
            this.g.c();
        }
    }
}
