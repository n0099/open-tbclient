package com.baidu.tieba.square.square;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.SquareModel;
import d.a.c.e.p.j;
import d.a.n0.r.f0.f;
import d.a.o0.b3.j.h;
/* loaded from: classes5.dex */
public class SquareActivity extends ProxyAdkBaseActivity<Object> implements SwipeBackLayout.c {
    public static boolean q = false;
    public NavigationBar j;
    public TbPageContext<Object> k;
    public View l;

    /* renamed from: e  reason: collision with root package name */
    public h f20848e = null;

    /* renamed from: f  reason: collision with root package name */
    public SquareModel f20849f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20850g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20851h = false;

    /* renamed from: i  reason: collision with root package name */
    public long f20852i = -1;
    public final SquareModel.a m = new b();
    public final NoNetworkView.b n = new c();
    public final View.OnKeyListener o = new d();
    public final f.g p = new e();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareActivity.this.closeActivity();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements SquareModel.a {
        public b() {
        }

        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, d.a.o0.b3.j.f fVar) {
            SquareActivity.this.f20848e.g(true, "");
            SquareActivity squareActivity = SquareActivity.this;
            squareActivity.hideLoadingView(squareActivity.f20848e.h());
            if (z && fVar != null && !fVar.g()) {
                SquareActivity.this.f20848e.l(SquareActivity.this.f20849f.F());
                SquareActivity.this.f20850g = true;
                SquareActivity.this.f20848e.i();
                SquareActivity.this.v();
            }
            if (SquareActivity.this.f20851h) {
                SquareActivity.this.f20851h = false;
                SquareActivity.this.w(true);
                if (!SquareActivity.this.f20850g) {
                    SquareActivity.this.f20848e.i();
                    SquareActivity squareActivity2 = SquareActivity.this;
                    squareActivity2.showLoadingView(squareActivity2.f20848e.h());
                }
            } else {
                if (SquareActivity.this.f20852i > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaStatic.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareActivity.this.f20852i, SquareActivity.this.f20849f.H() - SquareActivity.this.f20852i, SquareActivity.this.f20849f.J(), SquareActivity.this.f20849f.I(), currentTimeMillis - SquareActivity.this.f20849f.G());
                    SquareActivity.this.f20852i = -1L;
                }
                if (!SquareActivity.this.f20850g) {
                    if (j.z()) {
                        SquareActivity.this.f20848e.o(R.string.no_data_text);
                    } else {
                        SquareActivity.this.f20848e.o(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!j.z()) {
                SquareActivity.this.f20848e.f();
                if (SquareActivity.this.f20850g) {
                    return;
                }
                SquareActivity.this.r();
                return;
            }
            SquareActivity.this.k.showToast(str);
            SquareActivity.this.f20848e.k();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements NoNetworkView.b {
        public c() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                SquareActivity.this.w(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnKeyListener {
        public d() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            if (view instanceof ListView) {
                ListView listView = (ListView) view;
                if (keyEvent.getAction() == 0) {
                    if (i2 == 21) {
                        if (listView.getSelectedView() == null) {
                            listView.dispatchKeyEvent(new KeyEvent(0, 19));
                            return true;
                        }
                    } else if (i2 == 22 && listView.getSelectedView() == null) {
                        listView.dispatchKeyEvent(new KeyEvent(0, 20));
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements f.g {
        public e() {
        }

        @Override // d.a.n0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            SquareActivity.this.w(true);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void closeActivity() {
        if (!getIntent().getBooleanExtra("back_special", false)) {
            finish();
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            d.a.n0.r.a0.b.e(getActivity(), 1);
        } else {
            d.a.n0.r.a0.b.e(getActivity(), 2);
        }
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void disableSwipeBack() {
        setSwipeBackEnabled(false);
    }

    @Override // com.baidu.adp.widget.SwipeBackLayout.c
    public void enableSwipeBack() {
        setSwipeBackEnabled(true);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        h hVar = this.f20848e;
        if (hVar != null) {
            hVar.onChangeSkinType(i2);
            this.j.onChangeSkinType(getPageContext(), i2);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.k = getPageContext();
        this.f20852i = System.currentTimeMillis();
        this.l = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.l);
        u();
        t();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        s();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        super.onResume();
        if (q) {
            w(true);
            q = false;
        }
    }

    public final void r() {
        this.f20848e.d(this.n);
    }

    public final void s() {
        SquareModel squareModel = this.f20849f;
        if (squareModel != null) {
            squareModel.cancelLoadData();
        }
    }

    public final void t() {
        SquareModel squareModel = new SquareModel(getPageContext());
        this.f20849f = squareModel;
        squareModel.N(this.m);
        this.f20851h = true;
        w(true);
    }

    public final void u() {
        h hVar = new h(getPageContext(), this.l, this.o);
        this.f20848e = hVar;
        hVar.n(this.p);
        NavigationBar navigationBar = (NavigationBar) this.k.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.j.setTitleText(this.k.getString(R.string.ba_square));
    }

    public final void v() {
        this.f20848e.m(this.n);
    }

    public final void w(boolean z) {
        SquareModel squareModel = this.f20849f;
        if (squareModel == null) {
            return;
        }
        boolean z2 = false;
        boolean z3 = squareModel.F() == null || this.f20849f.F().g();
        boolean z4 = z;
        if (!j.z()) {
            this.f20851h = false;
            z4 = false;
            z3 = true;
        }
        if (this.f20851h) {
            z3 = true;
        } else {
            z2 = z4;
        }
        if (z3 || z2) {
            s();
            if (z2) {
                this.f20849f.M();
            } else {
                this.f20849f.L();
            }
        }
    }
}
