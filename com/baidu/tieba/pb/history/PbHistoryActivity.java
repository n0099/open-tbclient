package com.baidu.tieba.pb.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bc;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.List;
/* loaded from: classes.dex */
public class PbHistoryActivity extends BaseActivity {
    private RelativeLayout a;
    private NavigationBar b;
    private TextView c;
    private BdListView d;
    private g e;
    private FrameLayout f;
    private View g;
    private CustomMessageListener h = new a(this, 2001190);
    private CustomMessageListener i = new b(this, 2001191);

    static {
        TbadkApplication.m252getInst().RegisterIntent(bc.class, PbHistoryActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = (RelativeLayout) LayoutInflater.from(this).inflate(v.pb_history_activity, (ViewGroup) null);
        setContentView(this.a);
        this.f = (FrameLayout) this.a.findViewById(u.container);
        this.b = (NavigationBar) findViewById(u.view_navigation_bar);
        this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.b.a(x.my_history);
        this.c = this.b.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(x.delete_all_user_chat));
        this.c.setOnClickListener(new c(this));
        this.c.setVisibility(8);
        this.d = (BdListView) findViewById(u.list);
        this.e = new g();
        this.d.setAdapter((ListAdapter) this.e);
        this.d.setOnItemClickListener(new f(this));
        registerListener(this.h);
        registerListener(this.i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.c(i);
        getLayoutMode().a((View) this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        sendMessage(new RequestPbHistoryReadMessage());
    }

    private void b() {
        this.c.setVisibility(8);
        if (this.g == null) {
            LayoutInflater.from(this).inflate(v.pb_history_no_data_view, this.f);
            this.g = this.f.findViewById(u.no_data_container);
            getLayoutMode().a(this.g);
        }
    }

    private void c() {
        this.c.setVisibility(0);
        if (this.g != null) {
            this.f.removeView(this.g);
            this.g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<ak> list) {
        if (this.e != null) {
            this.e.a(list);
        }
        if (list == null || list.size() == 0) {
            b();
        } else {
            c();
        }
    }
}
