package com.baidu.tieba.pb.videopb.fragment;

import android.arch.lifecycle.q;
import android.arch.lifecycle.y;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ah;
import com.baidu.tieba.pb.videopb.MultiNestedLayout;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.a;
import com.baidu.tieba.pb.videopb.b.b;
import com.baidu.tieba.pb.videopb.c;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class ReplyFragment extends BaseFragment implements a, a.InterfaceC0584a {
    private BdSwipeRefreshLayout enH;
    private BdTypeRecyclerView gtd;
    private boolean iHW;
    private PbActivity iHn;
    private VideoPbFragment jak;
    private c jar;
    private b jas;
    private MultiNestedLayout jat;
    private View jau;
    private com.baidu.tieba.pb.videopb.videoView.b jav;
    private View jaw;
    private View mRootView;
    private int topMargin;
    private PbListView guZ = null;
    private View dDa = null;
    private com.baidu.tieba.pb.view.a iOq = null;
    private boolean iOT = false;
    private boolean iPq = false;
    private boolean iPP = true;
    private int iNV = 0;
    private h mPullView = null;
    private boolean iEW = false;
    private int jan = 0;
    private int jax = 0;
    private RecyclerView.OnScrollListener fCV = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.cni().cpl();
                ReplyFragment.this.cni().csX();
            }
            if (ReplyFragment.this.cni() != null) {
                ReplyFragment.this.cni().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.jan = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.jan != 0) {
                ReplyFragment.this.jau.setVisibility(8);
            }
            ReplyFragment.this.jan = 0;
        }
    };
    private MultiNestedLayout.b jay = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void onStateChange(int i) {
            if (ReplyFragment.this.jax != 1 || i == 1 || ReplyFragment.this.jan == 0) {
                if (ReplyFragment.this.jax != 0 || i == 0) {
                    if (ReplyFragment.this.jax != 0 && i == 0) {
                        ReplyFragment.this.cni().zv(8);
                    }
                } else if (ReplyFragment.this.jau.getVisibility() != 0) {
                    ReplyFragment.this.cni().zv(0);
                }
            } else {
                ReplyFragment.this.cni().zv(8);
                ReplyFragment.this.jau.setVisibility(0);
            }
            ReplyFragment.this.jax = i;
        }
    };
    private final g.c dgV = new g.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.clC() != null && ReplyFragment.this.clC().pW(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.cpJ();
            }
        }
    };
    private final BdListView.e gIV = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (ReplyFragment.this.clC().pV(false)) {
                    ReplyFragment.this.cpH();
                    TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (ReplyFragment.this.clC().getPbData() != null) {
                    ReplyFragment.this.cqe();
                }
            }
        }
    };

    public static ReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.jak = videoPbFragment;
        return replyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.iHn = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.jas = new b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jat = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.jat.setScrollStateChangeListener(this.jay);
        this.gtd = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.gtd.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jar = new c(this, this.gtd);
        this.jar.D(cni().csJ());
        this.jar.P(cni().csK());
        this.jar.setOnLongClickListener(cni().csL());
        this.jar.setOnImageClickListener(this.jas.getOnImageClickListener());
        this.jar.setTbGestureDetector(this.jas.cty());
        this.jau = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.guZ = new PbListView(getPageContext().getPageActivity());
        this.dDa = this.guZ.getView().findViewById(R.id.pb_more_view);
        if (this.dDa != null) {
            this.dDa.setOnClickListener(cni().csJ());
            am.setBackgroundResource(this.dDa, R.drawable.pb_foot_more_trans_selector);
        }
        this.guZ.setLineVisible();
        this.guZ.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.guZ.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.guZ.aHH();
        this.gtd.setOnSrollToBottomListener(this.gIV);
        this.gtd.addOnScrollListener(this.fCV);
        this.gtd.setOnTouchListener(cni().aSq());
        if (this.mPullView == null) {
            this.mPullView = new h(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.dgV);
        }
        if (this.enH == null) {
            this.enH = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.enH.setProgressView(this.mPullView);
            this.enH.setEnabled(false);
            am.setBackgroundColor(this.enH, R.color.cp_bg_line_e);
        }
        this.jaw = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.jav = new com.baidu.tieba.pb.videopb.videoView.b(this.jaw);
        this.jav.T(cni().csJ());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e eVar = (e) y.b(cnj()).l(e.class);
        eVar.ctp().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    ReplyFragment.this.showLoadingView();
                } else {
                    ReplyFragment.this.hideLoadingView();
                }
            }
        });
        d(true, 0, 3, 0, eVar.ctg(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.guZ != null) {
            this.guZ.changeSkin(i);
            if (this.dDa != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.dDa);
                am.setBackgroundResource(this.dDa, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.jav != null) {
            this.jav.onChangeSkinType(i);
        }
        if (this.jar != null) {
            this.jar.notifyDataSetChanged();
        }
        if (this.jau != null) {
            am.setBackgroundResource(this.jau, R.drawable.personalize_tab_shadow);
        }
        am.setBackgroundColor(this.enH, R.color.cp_bg_line_d);
    }

    public void hideLoadingView() {
        if (getView() != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            hideLoadingView(viewGroup);
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                viewGroup.getChildAt(i).setVisibility(0);
            }
        }
    }

    public void showLoadingView() {
        if (getView() != null) {
            ViewGroup viewGroup = (ViewGroup) getView();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                viewGroup.getChildAt(i).setVisibility(8);
            }
            showLoadingView(viewGroup);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void showLoadingView(View view) {
        super.showLoadingView(view);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.iHW = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        qj(z);
        if (cni() != null && cni().iYR != null) {
            this.jak.iYR.ctw();
        }
        if (z && this.iHW) {
            cpH();
            clC().pV(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        e eVar2 = (e) y.b(cnj()).l(e.class);
        if (z && clC() != null && eVar != null) {
            this.iEW = clC().cnA();
            boolean isEnabled = this.enH.isEnabled();
            if (eVar.getPage().aBl() == 0 && this.iEW) {
                this.enH.setEnabled(false);
            } else if (!isEnabled) {
                this.enH.setEnabled(true);
                this.enH.interruptRefresh();
            }
            this.jar.setIsFromCDN(eVar2.isFromCDN());
            this.jar.qT(this.iEW);
            this.jar.setData(eVar);
            this.iOT = false;
            if (TbadkCoreApplication.isLogin()) {
                this.gtd.setNextPage(this.guZ);
                this.iNV = 2;
                if (cni() != null && cni().iYR != null) {
                    this.jak.iYR.bqs();
                }
            } else {
                this.iOT = true;
                if (eVar.getPage().aBk() == 1) {
                    if (this.iOq == null) {
                        this.iOq = new com.baidu.tieba.pb.view.a(this, this);
                        this.iOq.createView();
                        this.iOq.aHH();
                    }
                    this.gtd.setNextPage(this.iOq);
                } else {
                    this.gtd.setNextPage(this.guZ);
                }
                this.iNV = 3;
            }
            if (this.jav != null && this.jaw != null) {
                j jVar = new j(j.iCP);
                bj ckv = eVar.ckv();
                jVar.iCR = ckv != null ? ckv.aCf() : 0L;
                jVar.isNew = !clC().cnA();
                jVar.iCU = cnd();
                jVar.sortType = eVar.iBQ;
                jVar.iCT = eVar.ckU();
                jVar.isDynamic = eVar.ckT();
                this.jav.a(jVar);
            }
            ArrayList<PostData> ckx = eVar.ckx();
            if (eVar.getPage().aBk() == 0 || ckx == null || ckx.size() < eVar.getPage().aBj()) {
                if (v.getCount(ckx) == 0 || (v.getCount(ckx) == 1 && ckx.get(0) != null && ckx.get(0).cLb() == 1)) {
                    if (cnd()) {
                        this.guZ.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.guZ.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (eVar.getPage().aBk() == 0) {
                        this.guZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.guZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.guZ.aHI();
                }
                if (eVar.getPage().aBk() == 0 || ckx == null) {
                    cqe();
                }
            } else {
                if (clC().getIsFromMark()) {
                    if (this.iPP) {
                        endLoadData();
                        if (eVar.getPage().aBk() != 0) {
                            this.guZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.guZ.setLineVisible();
                        this.guZ.showLoading();
                    }
                } else {
                    this.guZ.setLineVisible();
                    this.guZ.showLoading();
                }
                this.guZ.aHI();
            }
            switch (i2) {
                case 2:
                    this.gtd.setSelection(i3 > 1 ? (((this.gtd.getData() == null && eVar.ckx() == null) ? 0 : this.gtd.getData().size() - eVar.ckx().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable coS = ah.coR().coS();
                        if (coS instanceof RecyclerView.SavedState) {
                            this.gtd.onRestoreInstanceState(coS);
                            if (v.getCount(ckx) > 1 && eVar.getPage().aBk() > 0) {
                                this.guZ.endLoadData();
                                this.guZ.setText(getString(R.string.pb_load_more_without_point));
                                this.guZ.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.iPP = false;
                    break;
                case 5:
                    this.gtd.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable coS2 = ah.coR().coS();
                        if (coS2 instanceof RecyclerView.SavedState) {
                            this.gtd.onRestoreInstanceState(coS2);
                            break;
                        }
                    }
                    this.gtd.setSelection(0);
                    break;
                case 8:
                    int size = (this.gtd.getData() == null && eVar.ckx() == null) ? 0 : this.gtd.getData().size() - eVar.ckx().size();
                    this.jat.setMaxOffset();
                    this.gtd.setSelection(i3 > 0 ? size + i3 : 0);
                    this.guZ.endLoadData();
                    this.guZ.setText(getString(R.string.pb_load_more_without_point));
                    this.guZ.setLineGone();
                    break;
            }
            if (this.iPq) {
                cpf();
                this.iPq = false;
                if (i4 == 0) {
                    qf(true);
                }
            }
            cni().q(eVar);
        }
    }

    public void ctF() {
        com.baidu.tieba.pb.data.e pbData = clC().getPbData();
        if (pbData != null) {
            this.jar.qT(clC().cnA());
            this.jar.setData(pbData);
            this.jar.notifyDataSetChanged();
            ArrayList<PostData> ckx = pbData.ckx();
            if (pbData.getPage().aBk() == 0 || ckx == null || ckx.size() < pbData.getPage().aBj()) {
                if (v.getCount(ckx) == 0 || (v.getCount(ckx) == 1 && ckx.get(0) != null && ckx.get(0).cLb() == 1)) {
                    if (cnd()) {
                        this.guZ.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.guZ.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().aBk() == 0) {
                        this.guZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.guZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.guZ.aHI();
                }
            }
            cni().q(pbData);
        }
    }

    public PbActivity cnj() {
        return this.iHn != null ? this.iHn : cni().cnj();
    }

    public VideoPbFragment cni() {
        if (this.jak == null && this.iHn != null) {
            Fragment clO = this.iHn.clO();
            if (clO instanceof VideoPbFragment) {
                this.jak = (VideoPbFragment) clO;
            }
        }
        return this.jak;
    }

    public PbModel clC() {
        return cni().clC();
    }

    public BdTypeRecyclerView getListView() {
        return this.gtd;
    }

    public boolean cnd() {
        if (clC() != null) {
            return clC().getHostMode();
        }
        return false;
    }

    public c ctG() {
        return this.jar;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, eVar, str, i4);
        }
    }

    public b ctH() {
        return this.jas;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0584a
    public void pO(boolean z) {
        this.iHW = z;
    }

    public void qj(boolean z) {
        if (z && this.iOT) {
            this.guZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.gtd.setNextPage(this.guZ);
            this.iNV = 2;
        }
    }

    public void cpH() {
        this.guZ.setLineVisible();
        this.guZ.startLoadData();
    }

    public void endLoadData() {
        if (this.guZ != null) {
            this.guZ.setLineGone();
            this.guZ.endLoadData();
        }
        if (cni() != null && cni().iYR != null) {
            this.jak.iYR.bqs();
        }
    }

    public void Gd(String str) {
        if (this.guZ != null) {
            this.guZ.setText(str);
        }
    }

    public void Ge(String str) {
        if (this.guZ != null) {
            this.guZ.ac(str, this.topMargin);
        }
    }

    public void cpJ() {
        if (this.enH != null && this.enH.isEnabled()) {
            this.enH.setRefreshing(false);
        }
    }

    public void cqe() {
        if (this.iNV != 2) {
            this.gtd.setNextPage(this.guZ);
            this.iNV = 2;
        }
    }

    public void qf(boolean z) {
        this.iPq = z;
    }

    public void cpf() {
        if (this.gtd == null) {
        }
    }

    public int cpK() {
        if (this.gtd != null) {
            return this.gtd.getFirstVisiblePosition();
        }
        return 0;
    }

    public int ctI() {
        View childAt;
        if (this.gtd == null || this.gtd.getCount() <= 0 || (childAt = this.gtd.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int cpL() {
        if (this.gtd != null) {
            int lastVisiblePosition = this.gtd.getLastVisiblePosition();
            if (clC() != null && clC().getPbData() != null && lastVisiblePosition >= clC().getPbData().ckx().size()) {
                return clC().getPbData().ckx().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View cpV() {
        return this.dDa;
    }

    public int ctE() {
        return this.jan;
    }

    public int ctJ() {
        return this.jax;
    }

    public void zv(int i) {
        if (this.jau != null) {
            this.jau.setVisibility(i);
        }
    }

    public void qY(boolean z) {
        if (this.gtd != null) {
            this.gtd.setCanFling(z);
        }
    }

    public void cu(int i, int i2) {
        if (this.gtd != null && this.gtd.getLayoutManager() != null && (this.gtd.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.gtd.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }
}
