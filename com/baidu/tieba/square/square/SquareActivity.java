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
import d.b.c.e.p.j;
import d.b.h0.r.f0.f;
import d.b.i0.a3.j.h;
/* loaded from: classes4.dex */
public class SquareActivity extends ProxyAdkBaseActivity<Object> implements SwipeBackLayout.c {
    public static boolean q = false;
    public NavigationBar j;
    public TbPageContext<Object> k;
    public View l;

    /* renamed from: e  reason: collision with root package name */
    public h f20944e = null;

    /* renamed from: f  reason: collision with root package name */
    public SquareModel f20945f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20946g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20947h = false;
    public long i = -1;
    public final SquareModel.a m = new b();
    public final NoNetworkView.b n = new c();
    public final View.OnKeyListener o = new d();
    public final f.g p = new e();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareActivity.this.closeActivity();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SquareModel.a {
        public b() {
        }

        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, d.b.i0.a3.j.f fVar) {
            SquareActivity.this.f20944e.g(true, "");
            SquareActivity squareActivity = SquareActivity.this;
            squareActivity.hideLoadingView(squareActivity.f20944e.h());
            if (z && fVar != null && !fVar.g()) {
                SquareActivity.this.f20944e.l(SquareActivity.this.f20945f.B());
                SquareActivity.this.f20946g = true;
                SquareActivity.this.f20944e.i();
                SquareActivity.this.w();
            }
            if (SquareActivity.this.f20947h) {
                SquareActivity.this.f20947h = false;
                SquareActivity.this.x(true);
                if (!SquareActivity.this.f20946g) {
                    SquareActivity.this.f20944e.i();
                    SquareActivity squareActivity2 = SquareActivity.this;
                    squareActivity2.showLoadingView(squareActivity2.f20944e.h());
                }
            } else {
                if (SquareActivity.this.i > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaStatic.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareActivity.this.i, SquareActivity.this.f20945f.D() - SquareActivity.this.i, SquareActivity.this.f20945f.F(), SquareActivity.this.f20945f.E(), currentTimeMillis - SquareActivity.this.f20945f.C());
                    SquareActivity.this.i = -1L;
                }
                if (!SquareActivity.this.f20946g) {
                    if (j.z()) {
                        SquareActivity.this.f20944e.o(R.string.no_data_text);
                    } else {
                        SquareActivity.this.f20944e.o(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!j.z()) {
                SquareActivity.this.f20944e.f();
                if (SquareActivity.this.f20946g) {
                    return;
                }
                SquareActivity.this.r();
                return;
            }
            SquareActivity.this.k.showToast(str);
            SquareActivity.this.f20944e.k();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements NoNetworkView.b {
        public c() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                SquareActivity.this.x(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnKeyListener {
        public d() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (view instanceof ListView) {
                ListView listView = (ListView) view;
                if (keyEvent.getAction() == 0) {
                    if (i == 21) {
                        if (listView.getSelectedView() == null) {
                            listView.dispatchKeyEvent(new KeyEvent(0, 19));
                            return true;
                        }
                    } else if (i == 22 && listView.getSelectedView() == null) {
                        listView.dispatchKeyEvent(new KeyEvent(0, 20));
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements f.g {
        public e() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            SquareActivity.this.x(true);
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
            d.b.h0.r.a0.b.e(getActivity(), 1);
        } else {
            d.b.h0.r.a0.b.e(getActivity(), 2);
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
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        h hVar = this.f20944e;
        if (hVar != null) {
            hVar.onChangeSkinType(i);
            this.j.onChangeSkinType(getPageContext(), i);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.k = getPageContext();
        this.i = System.currentTimeMillis();
        this.l = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.square_view, (ViewGroup) null);
        getPageContext().getPageActivity().setContentView(this.l);
        v();
        u();
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
            x(true);
            q = false;
        }
    }

    public final void r() {
        this.f20944e.d(this.n);
    }

    public final void s() {
        SquareModel squareModel = this.f20945f;
        if (squareModel != null) {
            squareModel.cancelLoadData();
        }
    }

    public final void u() {
        SquareModel squareModel = new SquareModel(getPageContext());
        this.f20945f = squareModel;
        squareModel.J(this.m);
        this.f20947h = true;
        x(true);
    }

    public final void v() {
        h hVar = new h(getPageContext(), this.l, this.o);
        this.f20944e = hVar;
        hVar.n(this.p);
        NavigationBar navigationBar = (NavigationBar) this.k.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.j = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        this.j.setTitleText(this.k.getString(R.string.ba_square));
    }

    public final void w() {
        this.f20944e.m(this.n);
    }

    public final void x(boolean z) {
        SquareModel squareModel = this.f20945f;
        if (squareModel == null) {
            return;
        }
        boolean z2 = false;
        boolean z3 = squareModel.B() == null || this.f20945f.B().g();
        boolean z4 = z;
        if (!j.z()) {
            this.f20947h = false;
            z4 = false;
            z3 = true;
        }
        if (this.f20947h) {
            z3 = true;
        } else {
            z2 = z4;
        }
        if (z3 || z2) {
            s();
            if (z2) {
                this.f20945f.I();
            } else {
                this.f20945f.H();
            }
        }
    }
}
