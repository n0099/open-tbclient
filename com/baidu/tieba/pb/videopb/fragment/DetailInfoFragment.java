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
import d.b.b.e.p.l;
import d.b.i0.c2.h.e;
import d.b.i0.c3.h0.o;
import java.util.List;
/* loaded from: classes5.dex */
public class DetailInfoFragment extends BaseFragment implements d.b.i0.c2.o.a {

    /* renamed from: e  reason: collision with root package name */
    public PbActivity f20082e;

    /* renamed from: f  reason: collision with root package name */
    public VideoPbFragment f20083f;

    /* renamed from: g  reason: collision with root package name */
    public BdTypeRecyclerView f20084g;

    /* renamed from: h  reason: collision with root package name */
    public PbListView f20085h;
    public VideoPbViewModel i;
    public d.b.i0.c2.o.f.a j;
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
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.f20083f != null) {
                DetailInfoFragment.this.f20083f.V3();
            }
            if (i != 0 || recyclerView.canScrollVertically(-1) || DetailInfoFragment.this.f20083f == null || DetailInfoFragment.this.f20083f.z3()) {
                return;
            }
            DetailInfoFragment.this.i.t(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            MutableLiveData<Boolean> e2;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.f20083f != null && !DetailInfoFragment.this.f20083f.z3() && ((e2 = DetailInfoFragment.this.i.e()) == null || e2.getValue() == null || e2.getValue().booleanValue())) {
                DetailInfoFragment.this.i.t(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.k != 0 && DetailInfoFragment.this.f20083f != null) {
                    DetailInfoFragment.this.f20083f.l4(8);
                }
                DetailInfoFragment.this.k = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.f20083f != null && DetailInfoFragment.this.k == 0) {
                DetailInfoFragment.this.f20083f.l4(0);
            }
            DetailInfoFragment.this.k = 2;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || DetailInfoFragment.this.L() == null || DetailInfoFragment.this.L().y0() == null) {
                return;
            }
            DetailInfoFragment.this.L().y0().a();
            DetailInfoFragment.this.L().V0();
            DetailInfoFragment.this.j.n(DetailInfoFragment.this.L().y0());
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || DetailInfoFragment.this.L() == null || DetailInfoFragment.this.L().y0() == null) {
                return;
            }
            DetailInfoFragment.this.L0((String) customResponsedMessage.getData());
            DetailInfoFragment.this.L().V0();
            DetailInfoFragment.this.j.n(DetailInfoFragment.this.L().y0());
        }
    }

    public static DetailInfoFragment Q0(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.f20083f = videoPbFragment;
        return detailInfoFragment;
    }

    public VideoPbFragment I() {
        PbActivity pbActivity;
        if (this.f20083f == null && (pbActivity = this.f20082e) != null) {
            Fragment findFragment = pbActivity.findFragment();
            if (findFragment instanceof VideoPbFragment) {
                this.f20083f = (VideoPbFragment) findFragment;
            }
        }
        return this.f20083f;
    }

    public final void K0(e eVar) {
        if (this.i == null || eVar == null) {
            return;
        }
        T0(eVar);
        R0(eVar);
        this.j.n(eVar);
    }

    public PbModel L() {
        return I().L();
    }

    public final void L0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        List<o> U = L().y0().U();
        for (o oVar : U) {
            if (TextUtils.equals(str, oVar.A0())) {
                U.remove(oVar);
                return;
            }
        }
    }

    public int M0() {
        return this.k;
    }

    public final void N0() {
        PbListView pbListView = this.f20085h;
        if (pbListView != null) {
            pbListView.j();
        }
    }

    public final void O0(View view) {
        BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.f20084g = bdTypeRecyclerView;
        bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f20084g.addOnScrollListener(this.n);
        this.f20084g.setOnTouchListener(I().Y2());
        PbListView pbListView = new PbListView(getContext());
        this.f20085h = pbListView;
        pbListView.b();
        this.f20085h.A("");
        this.f20085h.o(R.color.CAM_X0205);
        this.f20085h.v();
        this.f20085h.C(SkinManager.getColor(R.color.CAM_X0107));
        this.f20085h.E(R.dimen.tbfontsize33);
        this.f20085h.y(R.color.CAM_X0110);
        this.f20085h.r(l.g(getContext(), R.dimen.tbds182));
        this.f20085h.q();
        this.f20084g.setNextPage(this.f20085h);
        this.j = new d.b.i0.c2.o.f.a(this, this.f20084g);
        this.f20083f.b4(8);
    }

    public PbActivity P() {
        PbActivity pbActivity = this.f20082e;
        return pbActivity != null ? pbActivity : this.f20083f.P();
    }

    public void P0() {
        e y0 = L().y0();
        if (y0 == null) {
            return;
        }
        this.j.n(y0);
        this.j.l();
    }

    public final void R0(e eVar) {
        if (eVar == null) {
            return;
        }
        if (ListUtils.isEmpty(eVar.f())) {
            X0();
            return;
        }
        N0();
        this.f20085h.A(getString(R.string.recommend_no_more_data));
    }

    public final void S0() {
        e c2 = this.i.c();
        if (c2 == null) {
            c2 = this.i.d();
        }
        K0(c2);
    }

    public final void T0(e eVar) {
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

    public void U0(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView = this.f20084g;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setCanFling(z);
        }
    }

    public void V0() {
        d.b.i0.c2.o.f.a aVar = this.j;
        if (aVar != null) {
            aVar.m();
        }
    }

    public final void W0() {
        BdTypeRecyclerView bdTypeRecyclerView = this.f20084g;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.scrollToPosition(0);
        }
        N0();
    }

    public final void X0() {
        PbListView pbListView = this.f20085h;
        if (pbListView != null) {
            pbListView.G(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.g(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.i == null) {
            return;
        }
        S0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.f20082e = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        d.b.i0.c2.o.f.a aVar = this.j;
        if (aVar != null) {
            aVar.l();
        }
        PbListView pbListView = this.f20085h;
        if (pbListView != null) {
            pbListView.d(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.p);
        this.o.setSelfListener(true);
        if (P() != null) {
            this.o.setTag(P().getUniqueId());
        } else if (getPageContext() != null) {
            this.o.setTag(getPageContext().getUniqueId());
        }
        this.o.setPriority(-1);
        MessageManager.getInstance().registerListener(this.o);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.i = (VideoPbViewModel) ViewModelProviders.of(getFragmentActivity()).get(VideoPbViewModel.class);
        O0(inflate);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.p);
        MessageManager.getInstance().unRegisterListener(this.o);
        super.onDestroy();
    }

    @Override // d.b.i0.c2.o.a
    public void t0(boolean z, int i, int i2, int i3, e eVar, String str, int i4) {
        if (eVar == null || getActivity() == null) {
            return;
        }
        K0(eVar);
    }
}
