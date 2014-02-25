package com.baidu.tieba.square;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.by;
import com.slidingmenu.lib.R;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class am extends com.baidu.tieba.j implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.d {
    public static boolean b = false;
    private com.baidu.tieba.k g;
    private ba c = null;
    private aw d = null;
    private boolean e = false;
    private boolean f = false;
    private Handler h = null;
    private Runnable i = null;
    private ax j = new an(this);
    private by k = new ao(this);
    private View.OnKeyListener l = new ap(this);
    private com.baidu.adp.widget.ListView.b m = new aq(this);

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.g = (com.baidu.tieba.k) activity;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return a(layoutInflater);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a();
        c();
        d();
    }

    private View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.square_view, (ViewGroup) null);
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

    private void c() {
        this.c = new ba(this.g, this, this.l);
        this.c.a(this.m);
        this.c.f().setClickStatKey("sq_tb_search");
    }

    private void d() {
        this.d = new aw();
        this.d.a(this.j);
        this.f = true;
        a(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.c.a(this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.c.b(this.k);
    }

    public void a() {
        this.h = new Handler();
        this.i = new ar(this);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onStop() {
        this.c.j();
        super.onStop();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (b()) {
            if (b) {
                a(true);
                b = false;
            }
            if (this.h != null && !this.f) {
                this.h.removeCallbacks(this.i);
                this.h.postDelayed(this.i, 0L);
                this.c.k();
            }
        }
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.h != null) {
            this.h.removeCallbacks(this.i);
        }
        this.c.l();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.h != null) {
            this.h.removeCallbacks(this.i);
        }
        this.c.m();
        g();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.j, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return true;
    }

    @Override // com.baidu.tieba.j, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
    }

    @Override // com.baidu.tieba.j
    public void c(int i) {
        super.c(i);
        if (this.c != null) {
            this.c.a(i);
        }
    }

    private void g() {
        this.d.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        boolean z5 = false;
        if (this.d != null) {
            boolean z6 = this.d.a() == null || this.d.a().g();
            boolean z7 = z;
            if (UtilHelper.b()) {
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
                g();
                if (z5) {
                    this.d.b();
                } else {
                    this.d.c();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar == null) {
        }
    }

    @Override // com.baidu.tieba.j, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.h.removeCallbacks(this.i);
        this.h.postDelayed(this.i, 300L);
    }

    @Override // com.baidu.tieba.j, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
