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
import d.a.c.e.p.j;
import d.a.m0.r.f0.f;
import d.a.n0.b3.j.h;
/* loaded from: classes5.dex */
public class SquareFragment extends BaseFragment {
    public static boolean p = false;
    public TbPageContext<?> j;
    public View k;

    /* renamed from: e  reason: collision with root package name */
    public h f20699e = null;

    /* renamed from: f  reason: collision with root package name */
    public SquareModel f20700f = null;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20701g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20702h = false;

    /* renamed from: i  reason: collision with root package name */
    public long f20703i = -1;
    public final SquareModel.a l = new a();
    public final NoNetworkView.b m = new b();
    public final View.OnKeyListener n = new c();
    public final f.g o = new d();

    /* loaded from: classes5.dex */
    public class a implements SquareModel.a {
        public a() {
        }

        @Override // com.baidu.tieba.square.square.SquareModel.a
        public void a(boolean z, String str, d.a.n0.b3.j.f fVar) {
            SquareFragment.this.f20699e.g(true, "");
            SquareFragment squareFragment = SquareFragment.this;
            squareFragment.hideLoadingView(squareFragment.f20699e.h());
            if (z && fVar != null && !fVar.g()) {
                SquareFragment.this.f20699e.l(SquareFragment.this.f20700f.B());
                SquareFragment.this.f20701g = true;
                SquareFragment.this.f20699e.j();
                SquareFragment.this.U0();
            }
            if (SquareFragment.this.f20702h) {
                SquareFragment.this.f20702h = false;
                SquareFragment.this.V0(true);
                if (!SquareFragment.this.f20701g) {
                    SquareFragment.this.f20699e.j();
                    SquareFragment squareFragment2 = SquareFragment.this;
                    squareFragment2.showLoadingView(squareFragment2.f20699e.h());
                }
            } else {
                if (SquareFragment.this.f20703i > -1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    TiebaStatic.page(TiebaStatic.OpKey.OP_SQUARE_ENTER, currentTimeMillis - SquareFragment.this.f20703i, SquareFragment.this.f20700f.D() - SquareFragment.this.f20703i, SquareFragment.this.f20700f.F(), SquareFragment.this.f20700f.E(), currentTimeMillis - SquareFragment.this.f20700f.C());
                    SquareFragment.this.f20703i = -1L;
                }
                if (!SquareFragment.this.f20701g) {
                    if (j.z()) {
                        SquareFragment.this.f20699e.o(R.string.no_data_text);
                    } else {
                        SquareFragment.this.f20699e.o(R.string.game_index_no_network_text);
                    }
                }
            }
            if (!j.z()) {
                SquareFragment.this.f20699e.f();
                if (SquareFragment.this.f20701g) {
                    return;
                }
                SquareFragment.this.R0();
                return;
            }
            SquareFragment.this.j.showToast(str);
            SquareFragment.this.f20699e.k();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NoNetworkView.b {
        public b() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                SquareFragment.this.V0(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnKeyListener {
        public c() {
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
    public class d implements f.g {
        public d() {
        }

        @Override // d.a.m0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            SquareFragment.this.V0(true);
        }
    }

    public final void R0() {
        this.f20699e.d(this.m);
    }

    public final void S0() {
        this.f20700f.cancelLoadData();
    }

    public final void T0() {
        h hVar = new h(this.j, getUniqueId(), this.k, this.n);
        this.f20699e = hVar;
        hVar.n(this.o);
    }

    public final void U0() {
        this.f20699e.m(this.m);
    }

    public final void V0(boolean z) {
        SquareModel squareModel = this.f20700f;
        if (squareModel == null) {
            return;
        }
        boolean z2 = false;
        boolean z3 = squareModel.B() == null || this.f20700f.B().g();
        boolean z4 = z;
        if (!j.z()) {
            this.f20702h = false;
            z4 = false;
            z3 = true;
        }
        if (this.f20702h) {
            z3 = true;
        } else {
            z2 = z4;
        }
        if (z3 || z2) {
            S0();
            if (z2) {
                this.f20700f.I();
            } else {
                this.f20700f.H();
            }
        }
    }

    public final void initData() {
        SquareModel squareModel = new SquareModel(this.j);
        this.f20700f = squareModel;
        squareModel.J(this.l);
        this.f20702h = true;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.j = getPageContext();
        this.f20703i = System.currentTimeMillis();
        T0();
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        h hVar = this.f20699e;
        if (hVar != null) {
            hVar.onChangeSkinType(i2);
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
        S0();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        V0(this.f20702h);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (p) {
            V0(true);
            p = false;
        }
    }
}
