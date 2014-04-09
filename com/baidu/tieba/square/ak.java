package com.baidu.tieba.square;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public final class ak extends com.baidu.tbadk.core.d implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.d {
    public static boolean b = false;
    private com.baidu.tbadk.core.e h;
    private NavigationBar k;
    private ay c = null;
    private au d = null;
    private boolean e = false;
    private boolean f = false;
    private long g = -1;
    private Handler i = null;
    private Runnable j = null;
    private final av l = new al(this);
    private final com.baidu.tbadk.core.view.m m = new am(this);
    private final View.OnKeyListener n = new an(this);
    private final com.baidu.adp.widget.ListView.d o = new ao(this);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.h = (com.baidu.tbadk.core.e) activity;
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.baidu.tieba.a.i.square_view, (ViewGroup) null);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.g = System.currentTimeMillis();
        this.i = new Handler();
        this.j = new ap(this);
        this.c = new ay(this.h, this, this.n);
        ay ayVar = this.c;
        ayVar.a.a(this.o);
        this.c.e().setClickStatKey("sq_tb_search");
        this.k = (NavigationBar) this.h.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.k.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.k.a(this.h.getString(com.baidu.tieba.a.k.ba_square));
        this.d = new au();
        this.d.a(this.l);
        this.f = true;
        a(this.f);
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

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onStop() {
        this.c.i();
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (c_()) {
            if (b) {
                a(true);
                b = false;
            }
            if (this.i != null && !this.f) {
                this.i.removeCallbacks(this.j);
                this.i.postDelayed(this.j, 0L);
                this.c.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onPause() {
        super.onPause();
        if (this.i != null) {
            this.i.removeCallbacks(this.j);
        }
        this.c.k();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        if (this.i != null) {
            this.i.removeCallbacks(this.j);
        }
        ay ayVar = this.c;
        a();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.d, android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        return true;
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
    }

    @Override // com.baidu.tbadk.core.d
    public final void c(int i) {
        super.c(i);
        if (this.c != null) {
            this.c.a(i);
            this.k.b(i);
        }
    }

    private void a() {
        this.d.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        boolean z2;
        boolean z3;
        if (this.d != null) {
            boolean z4 = this.d.e() == null || this.d.e().f();
            boolean z5 = z;
            if (UtilHelper.a()) {
                boolean z6 = z4;
                z2 = z5;
                z3 = z6;
            } else {
                this.f = false;
                z3 = true;
                z2 = false;
            }
            if (this.f) {
                z3 = true;
                z2 = false;
            }
            if (z3 || z2) {
                a();
                if (z2) {
                    this.d.a(1);
                } else {
                    this.d.a(0);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar == null) {
        }
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        this.i.removeCallbacks(this.j);
        this.i.postDelayed(this.j, 300L);
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
