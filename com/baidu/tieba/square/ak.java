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
    public static boolean a = false;
    private com.baidu.tbadk.core.e g;
    private NavigationBar j;
    private ay b = null;
    private au c = null;
    private boolean d = false;
    private boolean e = false;
    private long f = -1;
    private Handler h = null;
    private Runnable i = null;
    private final av k = new al(this);
    private final com.baidu.tbadk.core.view.m l = new am(this);
    private final View.OnKeyListener m = new an(this);
    private final com.baidu.adp.widget.ListView.d n = new ao(this);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.g = (com.baidu.tbadk.core.e) activity;
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
        this.f = System.currentTimeMillis();
        this.h = new Handler();
        this.i = new ap(this);
        this.b = new ay(this.g, this, this.m);
        ay ayVar = this.b;
        ayVar.a.a(this.n);
        this.b.e().setClickStatKey("sq_tb_search");
        this.j = (NavigationBar) this.g.findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.j.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.j.a(this.g.getString(com.baidu.tieba.a.k.ba_square));
        this.c = new au();
        this.c.a(this.k);
        this.e = true;
        a(this.e);
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
        this.b.i();
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (isShow()) {
            if (a) {
                a(true);
                a = false;
            }
            if (this.h != null && !this.e) {
                this.h.removeCallbacks(this.i);
                this.h.postDelayed(this.i, 0L);
                this.b.j();
            }
        }
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onPause() {
        super.onPause();
        if (this.h != null) {
            this.h.removeCallbacks(this.i);
        }
        this.b.k();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        if (this.h != null) {
            this.h.removeCallbacks(this.i);
        }
        ay ayVar = this.b;
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
    public final void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.b != null) {
            this.b.a(i);
            this.j.b(i);
        }
    }

    private void a() {
        this.c.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        boolean z2;
        boolean z3;
        if (this.c != null) {
            boolean z4 = this.c.e() == null || this.c.e().f();
            boolean z5 = z;
            if (UtilHelper.a()) {
                boolean z6 = z4;
                z2 = z5;
                z3 = z6;
            } else {
                this.e = false;
                z3 = true;
                z2 = false;
            }
            if (this.e) {
                z3 = true;
                z2 = false;
            }
            if (z3 || z2) {
                a();
                if (z2) {
                    this.c.a(1);
                } else {
                    this.c.a(0);
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
        this.h.removeCallbacks(this.i);
        this.h.postDelayed(this.i, 300L);
    }

    @Override // com.baidu.tbadk.core.d, android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
