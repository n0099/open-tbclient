package com.baidu.tieba.square;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class SquareActivity extends BaseFragment implements AbsListView.OnScrollListener, com.baidu.tbadk.imageManager.c {
    public static boolean a = false;
    private BaseFragmentActivity f;
    private by b = null;
    private av c = null;
    private boolean d = false;
    private boolean e = false;
    private Handler g = null;
    private Runnable h = null;
    private aw i = new am(this);
    private com.baidu.tieba.view.bf Y = new an(this);
    private View.OnKeyListener Z = new ap(this);
    private com.baidu.adp.widget.ListView.b aa = new aq(this);

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Activity activity) {
        super.a(activity);
        this.f = (BaseFragmentActivity) activity;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return a(layoutInflater);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d(Bundle bundle) {
        super.d(bundle);
        a();
        G();
        H();
    }

    private View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.square_view, (ViewGroup) null);
    }

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("square_page");
        try {
            sb.append(URLEncoder.encode("|", BdUtil.UTF8));
        } catch (Exception e) {
            e.printStackTrace();
            sb.append("|");
        }
        sb.append(str + "_" + str2);
        return sb.toString();
    }

    private void G() {
        this.b = new by(this.f, this, this.Z);
        this.b.a(this.aa);
        this.b.f().setClickStatKey("sq_tb_search");
    }

    private void H() {
        this.c = new av();
        this.c.a(this.i);
        this.e = true;
        a(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        this.b.a(this.Y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.b.b(this.Y);
    }

    public void a() {
        this.g = new Handler();
        this.h = new ao(this);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void d() {
        this.b.j();
        super.d();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        super.r();
        if (F()) {
            if (a) {
                a(true);
                a = false;
            }
            if (this.g != null && !this.e) {
                this.g.removeCallbacks(this.h);
                this.g.postDelayed(this.h, 0L);
                this.b.k();
            }
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void s() {
        super.s();
        if (this.g != null) {
            this.g.removeCallbacks(this.h);
        }
        this.b.l();
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void t() {
        if (this.g != null) {
            this.g.removeCallbacks(this.h);
        }
        this.b.m();
        K();
        super.t();
    }

    @Override // com.baidu.tieba.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.square_all_cat) {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this.f, "sq_icon_category", "click", 1);
            }
            BarFolderFirstDirActivity.a(this.f, a(by.a, "all"));
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return true;
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i, j);
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        super.c(i);
        this.b.a(i);
    }

    private void K() {
        this.c.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.c != null) {
            boolean z5 = this.c.a() == null || this.c.a().g();
            boolean z6 = z;
            if (UtilHelper.b()) {
                boolean z7 = z5;
                z2 = z6;
                z3 = z7;
            } else {
                this.e = false;
                z3 = true;
                z2 = false;
            }
            if (this.e) {
                z3 = true;
            } else {
                z4 = z2;
            }
            if (z3 || z4) {
                K();
                if (z4) {
                    this.c.b();
                } else {
                    this.c.c();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        if (dVar == null) {
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.g.removeCallbacks(this.h);
        this.g.postDelayed(this.h, 300L);
    }

    @Override // com.baidu.tieba.BaseFragment, android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
