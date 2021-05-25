package com.baidu.tieba.pb.videopb.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import d.a.c.e.p.l;
import d.a.n0.e2.h.e;
import d.a.n0.e2.o.h;
import d.a.n0.e3.h0.o;
import java.util.List;
/* loaded from: classes5.dex */
public class DetailInfoFragment extends BaseFragment implements h {

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f19475e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPbFragment f19476f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f19477g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f19478h;

    /* renamed from: i  reason: collision with root package name */
    public VideoPbViewModel f19479i;
    public d.a.n0.e2.o.m.a j;
    public String l;
    public String m;
    public int k = 0;
    public RecyclerView.OnScrollListener n = new a();
    public CustomMessageListener o = new b(2016488);
    public CustomMessageListener p = new c(2016331);

    /* loaded from: classes5.dex */
    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 1 && DetailInfoFragment.this.f19476f != null) {
                DetailInfoFragment.this.f19476f.k4();
            }
            if (i2 != 0 || recyclerView.canScrollVertically(-1) || DetailInfoFragment.this.f19476f == null || DetailInfoFragment.this.f19476f.F3()) {
                return;
            }
            DetailInfoFragment.this.f19479i.t(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            MutableLiveData<Boolean> e2;
            super.onScrolled(recyclerView, i2, i3);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i3 > 0 && DetailInfoFragment.this.f19476f != null && !DetailInfoFragment.this.f19476f.F3() && ((e2 = DetailInfoFragment.this.f19479i.e()) == null || e2.getValue() == null || e2.getValue().booleanValue())) {
                DetailInfoFragment.this.f19479i.t(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i3) > 0 && DetailInfoFragment.this.k != 0 && DetailInfoFragment.this.f19476f != null) {
                    DetailInfoFragment.this.f19476f.A4(8);
                }
                DetailInfoFragment.this.k = 0;
                return;
            }
            if (Math.abs(i3) > 0 && DetailInfoFragment.this.f19476f != null && DetailInfoFragment.this.k == 0) {
                DetailInfoFragment.this.f19476f.A4(0);
            }
            DetailInfoFragment.this.k = 2;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || DetailInfoFragment.this.z() == null || DetailInfoFragment.this.z().y0() == null) {
                return;
            }
            DetailInfoFragment.this.z().y0().a();
            DetailInfoFragment.this.z().V0();
            DetailInfoFragment.this.j.n(DetailInfoFragment.this.z().y0());
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || DetailInfoFragment.this.z() == null || DetailInfoFragment.this.z().y0() == null) {
                return;
            }
            DetailInfoFragment.this.K0((String) customResponsedMessage.getData());
            DetailInfoFragment.this.z().V0();
            DetailInfoFragment.this.j.n(DetailInfoFragment.this.z().y0());
        }
    }

    public static DetailInfoFragment P0(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.f19476f = videoPbFragment;
        return detailInfoFragment;
    }

    public PbActivity A() {
        PbActivity pbActivity = this.f19475e;
        return pbActivity != null ? pbActivity : this.f19476f.A();
    }

    public final void J0(e eVar) {
        if (this.f19479i == null || eVar == null) {
            return;
        }
        S0(eVar);
        Q0(eVar);
        this.j.n(eVar);
    }

    public final void K0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<o> V = z().y0().V();
        for (o oVar : V) {
            if (TextUtils.equals(str, oVar.D0())) {
                V.remove(oVar);
                return;
            }
        }
    }

    public int L0() {
        return this.k;
    }

    public final void M0() {
        PbListView pbListView = this.f19478h;
        if (pbListView != null) {
            pbListView.j();
        }
    }

    public final void N0(View view) {
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.f19477g = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f19477g.addOnScrollListener(this.n);
        this.f19477g.setOnTouchListener(w().b3());
        PbListView pbListView = new PbListView(getContext());
        this.f19478h = pbListView;
        pbListView.b();
        this.f19478h.A("");
        this.f19478h.o(R.color.CAM_X0205);
        this.f19478h.v();
        this.f19478h.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f19478h.E(R.dimen.tbfontsize33);
        this.f19478h.y(R.color.CAM_X0110);
        this.f19478h.r(l.g(getContext(), R.dimen.tbds182));
        this.f19478h.q();
        if (!d.a.m0.c1.b.e.d()) {
            this.f19477g.setNextPage(this.f19478h);
        }
        this.j = new d.a.n0.e2.o.m.a(this, this.f19477g);
        if (z() == null || z().Y0()) {
            return;
        }
        this.f19476f.q4(8);
    }

    public void O0() {
        e y0 = z().y0();
        if (y0 == null) {
            return;
        }
        this.j.n(y0);
        this.j.l();
    }

    public final void Q0(e eVar) {
        if (eVar == null) {
            return;
        }
        if (TbSingleton.getInstance().isBrowseMode()) {
            M0();
        } else if (ListUtils.isEmpty(eVar.f())) {
            X0();
        } else {
            M0();
            this.f19478h.A(getString(R.string.recommend_no_more_data));
        }
    }

    public final void R0() {
        e c2 = this.f19479i.c();
        if (c2 == null) {
            c2 = this.f19479i.d();
        }
        J0(c2);
    }

    public final void S0(e eVar) {
        String str;
        if (eVar == null) {
            return;
        }
        if (eVar.L() != null) {
            String N = eVar.N();
            str = eVar.L().V() != null ? eVar.L().V().oriUgcNid : null;
            r1 = N;
        } else {
            str = null;
        }
        if (r1 != this.l || str != this.m) {
            W0();
        }
        this.l = r1;
        this.m = str;
    }

    public void T0(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f19477g;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setCanFling(z);
        }
    }

    public void U0() {
        if (z() == null || z().y0() == null) {
            return;
        }
        J0(z().y0());
    }

    public void V0() {
        d.a.n0.e2.o.m.a aVar = this.j;
        if (aVar != null) {
            aVar.m();
        }
    }

    public final void W0() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f19477g;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
        M0();
    }

    public final void X0() {
        PbListView pbListView = this.f19478h;
        if (pbListView != null) {
            pbListView.G(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.g(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f19479i == null) {
            return;
        }
        R0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.f19475e = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.n0.e2.o.m.a aVar = this.j;
        if (aVar != null) {
            aVar.l();
        }
        PbListView pbListView = this.f19478h;
        if (pbListView != null) {
            pbListView.d(i2);
        }
        if (d.a.m0.c1.b.e.d()) {
            SkinManager.setBackgroundColor(this.f19477g, R.color.CAM_X0202);
            return;
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f19477g;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setBackgroundResource(0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.p);
        this.o.setSelfListener(true);
        if (A() != null) {
            this.o.setTag(A().getUniqueId());
        } else if (getPageContext() != null) {
            this.o.setTag(getPageContext().getUniqueId());
        }
        this.o.setPriority(-1);
        MessageManager.getInstance().registerListener(this.o);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.f19479i = (VideoPbViewModel) ViewModelProviders.of(getFragmentActivity()).get(VideoPbViewModel.class);
        N0(inflate);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.p);
        MessageManager.getInstance().unRegisterListener(this.o);
        super.onDestroy();
    }

    public VideoPbFragment w() {
        PbActivity pbActivity;
        if (this.f19476f == null && (pbActivity = this.f19475e) != null) {
            Fragment findFragment = pbActivity.findFragment();
            if (findFragment instanceof VideoPbFragment) {
                this.f19476f = (VideoPbFragment) findFragment;
            }
        }
        return this.f19476f;
    }

    @Override // d.a.n0.e2.o.h
    public void w0(boolean z, int i2, int i3, int i4, e eVar, String str, int i5) {
        if (eVar == null || getActivity() == null) {
            return;
        }
        J0(eVar);
    }

    public PbModel z() {
        return w().z();
    }
}
