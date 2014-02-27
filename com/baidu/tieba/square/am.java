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
public final class am extends com.baidu.tieba.j implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.d {
    public static boolean b = false;
    private com.baidu.tieba.k h;
    private ba c = null;
    private aw d = null;
    private boolean e = false;
    private boolean f = false;
    private long g = -1;
    private Handler i = null;
    private Runnable j = null;
    private ax k = new an(this);
    private by l = new ao(this);
    private View.OnKeyListener m = new ap(this);
    private com.baidu.adp.widget.ListView.b n = new aq(this);

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.h = (com.baidu.tieba.k) activity;
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.square_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.g = System.currentTimeMillis();
        this.i = new Handler();
        this.j = new ar(this);
        this.c = new ba(this.h, this, this.m);
        ba baVar = this.c;
        baVar.a.a(this.n);
        this.c.e().setClickStatKey("sq_tb_search");
        this.d = new aw();
        this.d.a(this.k);
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

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onStop() {
        this.c.i();
        super.onStop();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onResume() {
        super.onResume();
        if (d()) {
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

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onPause() {
        super.onPause();
        if (this.i != null) {
            this.i.removeCallbacks(this.j);
        }
        this.c.k();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public final void onDestroy() {
        if (this.i != null) {
            this.i.removeCallbacks(this.j);
        }
        ba baVar = this.c;
        a();
        super.onDestroy();
    }

    @Override // com.baidu.tieba.j, android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        return true;
    }

    @Override // com.baidu.tieba.j, android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
    }

    @Override // com.baidu.tieba.j
    public final void c(int i) {
        super.c(i);
        if (this.c != null) {
            this.c.a(i);
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
            boolean z4 = this.d.e() == null || this.d.e().g();
            boolean z5 = z;
            if (UtilHelper.b()) {
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

    @Override // com.baidu.tieba.j, android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        this.i.removeCallbacks(this.j);
        this.i.postDelayed(this.j, 300L);
    }

    @Override // com.baidu.tieba.j, android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
