package com.baidu.tieba.square.square;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.SquareModel;
import d.b.c.e.p.j;
import d.b.i0.r.f0.f;
import d.b.j0.a3.j.h;
/* loaded from: classes4.dex */
public class SquareFragment extends BaseFragment {
    public static boolean p = false;
    public TbPageContext<?> j;
    public View k;

    /* renamed from: e  reason: collision with root package name */
    public h f20961e = null;

    /* renamed from: f  reason: collision with root package name */
    public SquareModel f20962f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20963g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20964h = false;
    public long i = -1;
    public final SquareModel.a l = new a();
    public final NoNetworkView.b m = new b();
    public final View.OnKeyListener n = new c();
    public final f.g o = new d();

    /* loaded from: classes4.dex */
    public class a implements SquareModel.a {
        public a() {
        }

        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, d.b.j0.a3.j.f fVar) {
            SquareFragment.this.f20961e.g(true, "");
            SquareFragment squareFragment = SquareFragment.this;
            squareFragment.hideLoadingView(squareFragment.f20961e.h());
            if (z && fVar != null && !fVar.g()) {
                SquareFragment.this.f20961e.l(SquareFragment.this.f20962f.B());
                SquareFragment.this.f20963g = true;
                SquareFragment.this.f20961e.i();
                SquareFragment.this.V0();
            }
            if (SquareFragment.this.f20964h) {
                SquareFragment.this.f20964h = false;
                SquareFragment.this.W0(true);
                if (!SquareFragment.this.f20963g) {
                    SquareFragment.this.f20961e.i();
                    SquareFragment squareFragment2 = SquareFragment.this;
                    squareFragment2.showLoadingView(squareFragment2.f20961e.h());
                }
            } else {
                if (SquareFragment.this.i > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaStatic.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.i, SquareFragment.this.f20962f.D() - SquareFragment.this.i, SquareFragment.this.f20962f.F(), SquareFragment.this.f20962f.E(), currentTimeMillis - SquareFragment.this.f20962f.C());
                    SquareFragment.this.i = -1L;
                }
                if (!SquareFragment.this.f20963g) {
                    if (j.z()) {
                        SquareFragment.this.f20961e.o(R.string.no_data_text);
                    } else {
                        SquareFragment.this.f20961e.o(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!j.z()) {
                SquareFragment.this.f20961e.f();
                if (SquareFragment.this.f20963g) {
                    return;
                }
                SquareFragment.this.S0();
                return;
            }
            SquareFragment.this.j.showToast(str);
            SquareFragment.this.f20961e.k();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements NoNetworkView.b {
        public b() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                SquareFragment.this.W0(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnKeyListener {
        public c() {
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
    public class d implements f.g {
        public d() {
        }

        @Override // d.b.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.W0(true);
        }
    }

    public final void S0() {
        this.f20961e.d(this.m);
    }

    public final void T0() {
        this.f20962f.cancelLoadData();
    }

    public final void U0() {
        h hVar = new h(this.j, getUniqueId(), this.k, this.n);
        this.f20961e = hVar;
        hVar.n(this.o);
    }

    public final void V0() {
        this.f20961e.m(this.m);
    }

    public final void W0(boolean z) {
        SquareModel squareModel = this.f20962f;
        if (squareModel == null) {
            return;
        }
        boolean z2 = false;
        boolean z3 = squareModel.B() == null || this.f20962f.B().g();
        boolean z4 = z;
        if (!j.z()) {
            this.f20964h = false;
            z4 = false;
            z3 = true;
        }
        if (this.f20964h) {
            z3 = true;
        } else {
            z2 = z4;
        }
        if (z3 || z2) {
            T0();
            if (z2) {
                this.f20962f.I();
            } else {
                this.f20962f.H();
            }
        }
    }

    public final void initData() {
        SquareModel squareModel = new SquareModel(this.j);
        this.f20962f = squareModel;
        squareModel.J(this.l);
        this.f20964h = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.j = getPageContext();
        this.i = System.currentTimeMillis();
        U0();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        h hVar = this.f20961e;
        if (hVar != null) {
            hVar.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.square_fragment_view, (ViewGroup) null);
        this.k = inflate;
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        T0();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        W0(this.f20964h);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (p) {
            W0(true);
            p = false;
        }
    }
}
