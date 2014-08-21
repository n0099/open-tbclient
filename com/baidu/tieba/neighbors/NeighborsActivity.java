package com.baidu.tieba.neighbors;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.n;
import com.baidu.tbadk.core.view.p;
import com.baidu.tbadk.core.view.v;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.Person.DataRes;
import tbclient.Person.UserInfos;
/* loaded from: classes.dex */
public class NeighborsActivity extends BaseActivity implements x {
    private String b;
    private String c;
    private boolean d;
    private int e;
    private List<UserInfos> h;
    private boolean i;
    private View j;
    private View k;
    private NavigationBar l;
    private View m;
    private NoNetworkView n;
    private BdListView o;
    private l p;
    private p q;
    private View r;
    private TextView s;
    private n u;
    private View v;
    private View w;
    private View x;
    private View y;
    private int f = -1;
    private int g = 0;
    private v t = null;
    private HttpMessageListener z = new a(this, CmdConfigHttp.CLEAR_LOCATION_INFO);
    private HttpMessageListener A = new c(this, CmdConfigHttp.SET_PRIVATE_CMD);
    private com.baidu.adp.framework.listener.d B = new d(this, 303004);
    private com.baidu.adp.lib.c.d C = new e(this);
    View.OnClickListener a = new f(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(k.class, NeighborsActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.v.neighbors_activity);
        c();
        d();
        Intent intent = getIntent();
        a(intent != null ? intent.getBooleanExtra("locating", false) : false);
    }

    private void c() {
        this.j = findViewById(u.parent);
        this.o = (BdListView) findViewById(u.neighbors_list);
        this.k = findViewById(u.locating_failed);
        this.n = (NoNetworkView) this.j.findViewById(u.view_no_network);
        this.n.a(new g(this));
        this.t = new v(this);
        this.t.a(new h(this));
        this.o.setPullRefresh(this.t);
        this.p = new l(this);
        this.p.a(this.a);
        this.o.setAdapter((ListAdapter) this.p);
        this.o.setOnItemClickListener(this);
        this.o.setOnSrollToBottomListener(this);
        this.q = new p(this.j, t.pic_emotion05, t.pic_emotion05_1, u.no_data_container, u.no_data_image, u.no_data_image_text);
        this.r = findViewById(u.no_data_container);
        this.s = (TextView) findViewById(u.no_data_image_text);
        this.l = (NavigationBar) findViewById(u.navigation_bar);
        this.l.a(com.baidu.tieba.x.neighbors);
        this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new i(this));
        this.m = this.l.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.v.navigation_menu, this);
        View a = com.baidu.adp.lib.e.b.a().a(this, com.baidu.tieba.v.neighbors_menu_layout, null);
        this.u = new n(this, a, this.l, getResources().getDrawable(t.bg_pull_down_right_n), null);
        this.v = a.findViewById(u.neighbors_menu_female);
        this.v.setOnClickListener(this);
        this.w = a.findViewById(u.neighbors_menu_male);
        this.w.setOnClickListener(this);
        this.x = a.findViewById(u.neighbors_menu_all);
        this.x.setOnClickListener(this);
        this.y = a.findViewById(u.neighbors_menu_clear);
        this.y.setOnClickListener(this);
    }

    private void d() {
        registerListener(this.B);
        registerListener(this.A);
        registerListener(this.z);
    }

    private void a(boolean z) {
        if (z) {
            i();
            j();
            return;
        }
        this.b = TbadkApplication.m252getInst().getLocationLat();
        this.c = TbadkApplication.m252getInst().getLocationLng();
        if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) {
            j();
        } else {
            b(true);
        }
    }

    private void e() {
        this.q.b(8);
        this.o.setVisibility(0);
    }

    private void f() {
        if (this.g == 2) {
            this.s.setText(com.baidu.tieba.x.warning_no_neighbors_female);
        } else if (this.g == 1) {
            this.s.setText(com.baidu.tieba.x.warning_no_neighbors_male);
        } else {
            this.s.setText(com.baidu.tieba.x.warning_no_neighbors_all);
        }
        this.o.setVisibility(8);
        this.k.setVisibility(8);
        this.q.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.o.setVisibility(8);
        this.q.b(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.o.setVisibility(8);
        this.q.b(8);
    }

    private void i() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    private void j() {
        if (com.baidu.adp.lib.util.j.c()) {
            showLoadingDialog(getString(com.baidu.tieba.x.warning_locating));
            com.baidu.adp.lib.c.a.a().a(true, this.C);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.i = true;
        if (z) {
            showLoadingDialog(getString(com.baidu.tieba.x.warning_searching_neighbors));
        }
        RequestGetNeighborsMessage requestGetNeighborsMessage = new RequestGetNeighborsMessage(303004);
        requestGetNeighborsMessage.setParams(this.b, this.c, this.f, this.g, this.e);
        sendMessage(requestGetNeighborsMessage);
    }

    public boolean b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (!this.i && this.d) {
            this.i = true;
            b(false);
        }
    }

    private void l() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.b(com.baidu.tieba.x.warning_clear_location_info);
        aVar.a(com.baidu.tieba.x.confirm, new j(this));
        aVar.b(com.baidu.tieba.x.cancel, new b(this));
        aVar.a();
        aVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Integer num = dataRes.has_more;
            if (num == null) {
                this.d = false;
            } else {
                this.d = num.intValue() == 1;
            }
            List<UserInfos> list = dataRes.user_infos;
            if ((list == null || list.size() == 0) && this.e == 0) {
                f();
                return;
            }
            if (this.h == null) {
                this.h = new ArrayList();
            }
            this.h.addAll(list);
            this.e = this.h.size();
            if (this.e == 0) {
                f();
                return;
            }
            e();
            this.p.a(this.h);
            this.p.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.d = false;
        this.e = 0;
        this.h = new ArrayList();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.q.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.q.b();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.v) {
            com.baidu.adp.lib.e.e.a(this.u, this);
            if (this.g != 2) {
                this.g = 2;
                m();
                b(true);
            }
        } else if (view == this.w) {
            com.baidu.adp.lib.e.e.a(this.u, this);
            if (this.g != 1) {
                this.g = 1;
                m();
                b(true);
            }
        } else if (view == this.x) {
            com.baidu.adp.lib.e.e.a(this.u, this);
            if (this.g != 0) {
                this.g = 0;
                m();
                b(true);
            }
        } else if (view == this.y) {
            com.baidu.adp.lib.e.e.a(this.u, this);
            l();
        } else if (view == this.m) {
            this.u.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.p != null) {
            this.p.a();
            this.p = null;
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        UserInfos item = this.p.getItem(i);
        if (item != null) {
            sendMessage(new CustomMessage(2002003, new bh(this, String.valueOf(item.user_id), item.user_name)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.j);
        this.q.a(i);
        this.r.setBackgroundResource(i == 1 ? r.cp_bg_line_d_1 : r.cp_bg_line_d);
        this.l.c(i);
        this.n.a(i);
        this.t.a(i);
        this.u.a(this, i, getResources().getDrawable(t.bg_pull_down_right_n), getResources().getDrawable(t.bg_pull_down_right_n_1));
        getLayoutMode().a((View) this.o);
        this.p.notifyDataSetChanged();
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void g_() {
        k();
    }
}
