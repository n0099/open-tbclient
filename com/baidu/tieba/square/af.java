package com.baidu.tieba.square;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class af extends com.baidu.tbadk.core.d implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.d {
    public static boolean b = false;
    private BaseFragmentActivity h;
    private NavigationBar k;
    private au c = null;
    private aq d = null;
    private boolean e = false;
    private boolean f = false;
    private long g = -1;
    private Handler i = null;
    private Runnable j = null;
    private final ar l = new ag(this);
    private final com.baidu.tbadk.core.view.q m = new ah(this);
    private final View.OnKeyListener n = new ai(this);
    private final com.baidu.adp.widget.ListView.d o = new aj(this);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.h = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return a(layoutInflater);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.g = System.currentTimeMillis();
        a();
        f();
        g();
    }

    private View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(com.baidu.tieba.v.square_view, (ViewGroup) null);
    }

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("square_page");
        try {
            sb.append(URLEncoder.encode("|", "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
            sb.append("|");
        }
        sb.append(String.valueOf(str) + "_" + str2);
        return sb.toString();
    }

    private void f() {
        this.c = new au(this.h, this, this.n);
        this.c.a(this.o);
        this.c.c().setClickStatKey("sq_tb_search");
        this.k = (NavigationBar) this.h.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.k.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new ak(this));
        this.k.a(this.h.getString(com.baidu.tieba.x.ba_square));
    }

    private void g() {
        this.d = new aq();
        this.d.a(this.l);
        this.f = true;
        a(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.c.a(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.c.b(this.m);
    }

    public void a() {
        this.i = new Handler();
        this.j = new al(this);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onStop() {
        this.c.g();
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (d_()) {
            if (b) {
                a(true);
                b = false;
            }
            if (this.i != null && !this.f) {
                this.i.removeCallbacks(this.j);
                this.i.postDelayed(this.j, 0L);
                this.c.h();
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.i != null) {
            this.i.removeCallbacks(this.j);
        }
        this.c.i();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.i != null) {
            this.i.removeCallbacks(this.j);
        }
        this.c.j();
        j();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return true;
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
    }

    @Override // com.baidu.tbadk.core.d
    public void c(int i) {
        super.c(i);
        if (this.c != null) {
            this.c.a(i);
            this.k.c(i);
        }
    }

    private void j() {
        this.d.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        boolean z5 = false;
        if (this.d != null) {
            boolean z6 = this.d.e() == null || this.d.e().f();
            boolean z7 = z;
            if (UtilHelper.isNetOk()) {
                boolean z8 = z6;
                z2 = z7;
                z3 = z8;
            } else {
                this.f = false;
                z3 = true;
                z2 = false;
            }
            if (!this.f) {
                z4 = z3;
                z5 = z2;
            }
            if (z4 || z5) {
                j();
                if (z5) {
                    this.d.f();
                } else {
                    this.d.g();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar == null) {
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.i.removeCallbacks(this.j);
        this.i.postDelayed(this.j, 90L);
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
