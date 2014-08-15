package com.baidu.tieba.neighbors;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.atomData.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.m;
import com.baidu.tbadk.core.view.o;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Person.DataRes;
import tbclient.Person.UserInfos;
/* loaded from: classes.dex */
public class NeighborsActivity extends BaseActivity implements x {
    private String a;
    private String b;
    private boolean c;
    private int d;
    private List<UserInfos> g;
    private boolean h;
    private View i;
    private View j;
    private View k;
    private NavigationBar l;
    private View m;
    private BdListView n;
    private l o;
    private j p;
    private o q;
    private View r;
    private TextView s;
    private m t;
    private View u;
    private View v;
    private View w;
    private View x;
    private int e = -1;
    private int f = 0;
    private HttpMessageListener y = new a(this, CmdConfigHttp.CLEAR_LOCATION_INFO);
    private HttpMessageListener z = new b(this, CmdConfigHttp.SET_PRIVATE_CMD);
    private com.baidu.adp.framework.listener.d A = new c(this, 303004);
    private com.baidu.adp.lib.c.d B = new d(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(i.class, NeighborsActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(v.neighbors_activity);
        b();
        c();
        Intent intent = getIntent();
        a(intent != null ? intent.getBooleanExtra("locating", false) : false);
    }

    private void b() {
        this.i = findViewById(u.parent);
        this.j = findViewById(u.locating_failed);
        this.k = findViewById(u.no_network);
        this.n = (BdListView) findViewById(u.neighbors_list);
        this.o = new l(this);
        this.n.setNextPage(this.o);
        this.p = new j(this);
        this.n.setAdapter((ListAdapter) this.p);
        this.n.setOnItemClickListener(this);
        this.n.setOnSrollToBottomListener(this);
        this.o.a(new e(this));
        this.q = new o(this.i, t.pic_emotion05, t.pic_emotion05_1, u.no_data_container, u.no_data_image, u.no_data_image_text);
        this.r = findViewById(u.no_data_container);
        this.s = (TextView) findViewById(u.no_data_image_text);
        this.l = (NavigationBar) findViewById(u.navigation_bar);
        this.l.a(com.baidu.tieba.x.neighbors);
        this.l.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new f(this));
        this.m = this.l.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, v.navigation_menu, this);
        View inflate = getLayoutInflater().inflate(v.neighbors_menu_layout, (ViewGroup) null);
        this.t = new m(this, inflate, this.l, getResources().getDrawable(t.bg_pull_down_right_n), null);
        this.u = inflate.findViewById(u.neighbors_menu_female);
        this.u.setOnClickListener(this);
        this.v = inflate.findViewById(u.neighbors_menu_male);
        this.v.setOnClickListener(this);
        this.w = inflate.findViewById(u.neighbors_menu_all);
        this.w.setOnClickListener(this);
        this.x = inflate.findViewById(u.neighbors_menu_clear);
        this.x.setOnClickListener(this);
    }

    private void c() {
        registerListener(this.A);
        registerListener(this.z);
        registerListener(this.y);
    }

    private void a(boolean z) {
        if (z) {
            h();
            i();
            return;
        }
        this.a = TbadkApplication.m252getInst().getLocationLat();
        this.b = TbadkApplication.m252getInst().getLocationLng();
        if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b)) {
            i();
        } else {
            b(true);
        }
    }

    private void d() {
        this.q.b(8);
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        this.n.setVisibility(0);
    }

    private void e() {
        if (this.f == 2) {
            this.s.setText(com.baidu.tieba.x.warning_no_neighbors_female);
        } else if (this.f == 1) {
            this.s.setText(com.baidu.tieba.x.warning_no_neighbors_male);
        } else {
            this.s.setText(com.baidu.tieba.x.warning_no_neighbors_all);
        }
        this.n.setVisibility(8);
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        this.q.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.n.setVisibility(8);
        this.q.b(8);
        this.k.setVisibility(8);
        this.j.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.n.setVisibility(8);
        this.q.b(8);
        this.j.setVisibility(8);
        this.k.setVisibility(0);
    }

    private void h() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
        httpMessage.addParam("opt", "location");
        httpMessage.addParam("val", String.valueOf(1));
        sendMessage(httpMessage);
    }

    private void i() {
        showLoadingDialog(getString(com.baidu.tieba.x.warning_locating));
        com.baidu.adp.lib.c.a.a().a(true, this.B);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.h = true;
        if (z) {
            showLoadingDialog(getString(com.baidu.tieba.x.warning_searching_neighbors));
        }
        RequestGetNeighborsMessage requestGetNeighborsMessage = new RequestGetNeighborsMessage(303004);
        requestGetNeighborsMessage.setParams(this.a, this.b, this.e, this.f, this.d);
        sendMessage(requestGetNeighborsMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (!this.h) {
            if (!this.c) {
                this.o.f();
                return;
            }
            this.o.e();
            this.h = true;
            b(false);
        }
    }

    private void k() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this);
        aVar.b(com.baidu.tieba.x.warning_clear_location_info);
        aVar.a(com.baidu.tieba.x.confirm, new g(this));
        aVar.b(com.baidu.tieba.x.cancel, new h(this));
        aVar.a();
        aVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        if (dataRes != null) {
            Integer num = dataRes.has_more;
            if (num == null) {
                this.c = false;
            } else {
                this.c = num.intValue() == 1;
            }
            List<UserInfos> list = dataRes.user_infos;
            if ((list == null || list.size() == 0) && this.d == 0) {
                e();
                return;
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.addAll(list);
            this.d = this.g.size();
            if (this.d == 0) {
                e();
                return;
            }
            d();
            m();
            this.p.a(this.g);
            this.p.notifyDataSetChanged();
        }
    }

    private void l() {
        this.c = false;
        this.d = 0;
        this.g = new ArrayList();
    }

    private void m() {
        if (this.g == null || this.g.size() == 0 || !this.c) {
            this.o.c();
        } else {
            this.o.d();
        }
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
        if (view == this.u) {
            this.t.dismiss();
            if (this.f != 2) {
                this.f = 2;
                l();
                b(true);
            }
        } else if (view == this.v) {
            this.t.dismiss();
            if (this.f != 1) {
                this.f = 1;
                l();
                b(true);
            }
        } else if (view == this.w) {
            this.t.dismiss();
            if (this.f != 0) {
                this.f = 0;
                l();
                b(true);
            }
        } else if (view == this.x) {
            this.t.dismiss();
            k();
        } else if (view == this.m) {
            this.t.b();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
        UserInfos item = this.p.getItem(i);
        if (item != null) {
            sendMessage(new CustomMessage(2002003, new bg(this, String.valueOf(item.user_id), item.user_name)));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().a(this.i);
        this.q.a(i);
        this.r.setBackgroundResource(i == 1 ? r.cp_bg_line_d_1 : r.cp_bg_line_d);
        this.l.c(i);
        this.t.a(this, i, getResources().getDrawable(t.bg_pull_down_right_n), getResources().getDrawable(t.bg_pull_down_right_n_1));
        getLayoutMode().a((View) this.n);
        this.o.a(i);
        this.p.notifyDataSetChanged();
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void g_() {
        j();
    }
}
