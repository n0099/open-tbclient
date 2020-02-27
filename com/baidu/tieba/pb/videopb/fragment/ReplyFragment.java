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
    private BdSwipeRefreshLayout ens;
    private BdTypeRecyclerView gsO;
    private PbActivity iGZ;
    private boolean iHI;
    private VideoPbFragment iZW;
    private c jad;
    private b jae;
    private MultiNestedLayout jaf;
    private View jag;
    private com.baidu.tieba.pb.videopb.videoView.b jah;
    private View jai;
    private View mRootView;
    private int topMargin;
    private PbListView guL = null;
    private View dCM = null;
    private com.baidu.tieba.pb.view.a iOc = null;
    private boolean iOF = false;
    private boolean iPc = false;
    private boolean iPB = true;
    private int iNH = 0;
    private h mPullView = null;
    private boolean iEI = false;
    private int iZZ = 0;
    private int jaj = 0;
    private RecyclerView.OnScrollListener fCG = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.cnf().cpi();
                ReplyFragment.this.cnf().csU();
            }
            if (ReplyFragment.this.cnf() != null) {
                ReplyFragment.this.cnf().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.iZZ = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.iZZ != 0) {
                ReplyFragment.this.jag.setVisibility(8);
            }
            ReplyFragment.this.iZZ = 0;
        }
    };
    private MultiNestedLayout.b jak = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void onStateChange(int i) {
            if (ReplyFragment.this.jaj != 1 || i == 1 || ReplyFragment.this.iZZ == 0) {
                if (ReplyFragment.this.jaj != 0 || i == 0) {
                    if (ReplyFragment.this.jaj != 0 && i == 0) {
                        ReplyFragment.this.cnf().zv(8);
                    }
                } else if (ReplyFragment.this.jag.getVisibility() != 0) {
                    ReplyFragment.this.cnf().zv(0);
                }
            } else {
                ReplyFragment.this.cnf().zv(8);
                ReplyFragment.this.jag.setVisibility(0);
            }
            ReplyFragment.this.jaj = i;
        }
    };
    private final g.c dgH = new g.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.clz() != null && ReplyFragment.this.clz().pW(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.cpG();
            }
        }
    };
    private final BdListView.e gIH = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (ReplyFragment.this.clz().pV(false)) {
                    ReplyFragment.this.cpE();
                    TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (ReplyFragment.this.clz().getPbData() != null) {
                    ReplyFragment.this.cqb();
                }
            }
        }
    };

    public static ReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.iZW = videoPbFragment;
        return replyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.iGZ = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.jae = new b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jaf = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.jaf.setScrollStateChangeListener(this.jak);
        this.gsO = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.gsO.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jad = new c(this, this.gsO);
        this.jad.D(cnf().csG());
        this.jad.P(cnf().csH());
        this.jad.setOnLongClickListener(cnf().csI());
        this.jad.setOnImageClickListener(this.jae.getOnImageClickListener());
        this.jad.setTbGestureDetector(this.jae.ctv());
        this.jag = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.guL = new PbListView(getPageContext().getPageActivity());
        this.dCM = this.guL.getView().findViewById(R.id.pb_more_view);
        if (this.dCM != null) {
            this.dCM.setOnClickListener(cnf().csG());
            am.setBackgroundResource(this.dCM, R.drawable.pb_foot_more_trans_selector);
        }
        this.guL.setLineVisible();
        this.guL.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.guL.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.guL.aHE();
        this.gsO.setOnSrollToBottomListener(this.gIH);
        this.gsO.addOnScrollListener(this.fCG);
        this.gsO.setOnTouchListener(cnf().aSn());
        if (this.mPullView == null) {
            this.mPullView = new h(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.dgH);
        }
        if (this.ens == null) {
            this.ens = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.ens.setProgressView(this.mPullView);
            this.ens.setEnabled(false);
            am.setBackgroundColor(this.ens, R.color.cp_bg_line_e);
        }
        this.jai = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.jah = new com.baidu.tieba.pb.videopb.videoView.b(this.jai);
        this.jah.T(cnf().csG());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e eVar = (e) y.b(cng()).l(e.class);
        eVar.ctm().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
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
        d(true, 0, 3, 0, eVar.ctd(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.guL != null) {
            this.guL.changeSkin(i);
            if (this.dCM != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.dCM);
                am.setBackgroundResource(this.dCM, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.jah != null) {
            this.jah.onChangeSkinType(i);
        }
        if (this.jad != null) {
            this.jad.notifyDataSetChanged();
        }
        if (this.jag != null) {
            am.setBackgroundResource(this.jag, R.drawable.personalize_tab_shadow);
        }
        am.setBackgroundColor(this.ens, R.color.cp_bg_line_d);
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
        this.iHI = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        qj(z);
        if (cnf() != null && cnf().iYD != null) {
            this.iZW.iYD.ctt();
        }
        if (z && this.iHI) {
            cpE();
            clz().pV(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        e eVar2 = (e) y.b(cng()).l(e.class);
        if (z && clz() != null && eVar != null) {
            this.iEI = clz().cnx();
            boolean isEnabled = this.ens.isEnabled();
            if (eVar.getPage().aBj() == 0 && this.iEI) {
                this.ens.setEnabled(false);
            } else if (!isEnabled) {
                this.ens.setEnabled(true);
                this.ens.interruptRefresh();
            }
            this.jad.setIsFromCDN(eVar2.isFromCDN());
            this.jad.qT(this.iEI);
            this.jad.setData(eVar);
            this.iOF = false;
            if (TbadkCoreApplication.isLogin()) {
                this.gsO.setNextPage(this.guL);
                this.iNH = 2;
                if (cnf() != null && cnf().iYD != null) {
                    this.iZW.iYD.bqp();
                }
            } else {
                this.iOF = true;
                if (eVar.getPage().aBi() == 1) {
                    if (this.iOc == null) {
                        this.iOc = new com.baidu.tieba.pb.view.a(this, this);
                        this.iOc.createView();
                        this.iOc.aHE();
                    }
                    this.gsO.setNextPage(this.iOc);
                } else {
                    this.gsO.setNextPage(this.guL);
                }
                this.iNH = 3;
            }
            if (this.jah != null && this.jai != null) {
                j jVar = new j(j.iCB);
                bj cks = eVar.cks();
                jVar.iCD = cks != null ? cks.aCd() : 0L;
                jVar.isNew = !clz().cnx();
                jVar.iCG = cna();
                jVar.sortType = eVar.iBC;
                jVar.iCF = eVar.ckR();
                jVar.isDynamic = eVar.ckQ();
                this.jah.a(jVar);
            }
            ArrayList<PostData> cku = eVar.cku();
            if (eVar.getPage().aBi() == 0 || cku == null || cku.size() < eVar.getPage().aBh()) {
                if (v.getCount(cku) == 0 || (v.getCount(cku) == 1 && cku.get(0) != null && cku.get(0).cKY() == 1)) {
                    if (cna()) {
                        this.guL.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.guL.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (eVar.getPage().aBi() == 0) {
                        this.guL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.guL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.guL.aHF();
                }
                if (eVar.getPage().aBi() == 0 || cku == null) {
                    cqb();
                }
            } else {
                if (clz().getIsFromMark()) {
                    if (this.iPB) {
                        endLoadData();
                        if (eVar.getPage().aBi() != 0) {
                            this.guL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.guL.setLineVisible();
                        this.guL.showLoading();
                    }
                } else {
                    this.guL.setLineVisible();
                    this.guL.showLoading();
                }
                this.guL.aHF();
            }
            switch (i2) {
                case 2:
                    this.gsO.setSelection(i3 > 1 ? (((this.gsO.getData() == null && eVar.cku() == null) ? 0 : this.gsO.getData().size() - eVar.cku().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable coP = ah.coO().coP();
                        if (coP instanceof RecyclerView.SavedState) {
                            this.gsO.onRestoreInstanceState(coP);
                            if (v.getCount(cku) > 1 && eVar.getPage().aBi() > 0) {
                                this.guL.endLoadData();
                                this.guL.setText(getString(R.string.pb_load_more_without_point));
                                this.guL.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.iPB = false;
                    break;
                case 5:
                    this.gsO.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable coP2 = ah.coO().coP();
                        if (coP2 instanceof RecyclerView.SavedState) {
                            this.gsO.onRestoreInstanceState(coP2);
                            break;
                        }
                    }
                    this.gsO.setSelection(0);
                    break;
                case 8:
                    int size = (this.gsO.getData() == null && eVar.cku() == null) ? 0 : this.gsO.getData().size() - eVar.cku().size();
                    this.jaf.setMaxOffset();
                    this.gsO.setSelection(i3 > 0 ? size + i3 : 0);
                    this.guL.endLoadData();
                    this.guL.setText(getString(R.string.pb_load_more_without_point));
                    this.guL.setLineGone();
                    break;
            }
            if (this.iPc) {
                cpc();
                this.iPc = false;
                if (i4 == 0) {
                    qf(true);
                }
            }
            cnf().q(eVar);
        }
    }

    public void ctC() {
        com.baidu.tieba.pb.data.e pbData = clz().getPbData();
        if (pbData != null) {
            this.jad.qT(clz().cnx());
            this.jad.setData(pbData);
            this.jad.notifyDataSetChanged();
            ArrayList<PostData> cku = pbData.cku();
            if (pbData.getPage().aBi() == 0 || cku == null || cku.size() < pbData.getPage().aBh()) {
                if (v.getCount(cku) == 0 || (v.getCount(cku) == 1 && cku.get(0) != null && cku.get(0).cKY() == 1)) {
                    if (cna()) {
                        this.guL.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.guL.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().aBi() == 0) {
                        this.guL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.guL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.guL.aHF();
                }
            }
            cnf().q(pbData);
        }
    }

    public PbActivity cng() {
        return this.iGZ != null ? this.iGZ : cnf().cng();
    }

    public VideoPbFragment cnf() {
        if (this.iZW == null && this.iGZ != null) {
            Fragment clL = this.iGZ.clL();
            if (clL instanceof VideoPbFragment) {
                this.iZW = (VideoPbFragment) clL;
            }
        }
        return this.iZW;
    }

    public PbModel clz() {
        return cnf().clz();
    }

    public BdTypeRecyclerView getListView() {
        return this.gsO;
    }

    public boolean cna() {
        if (clz() != null) {
            return clz().getHostMode();
        }
        return false;
    }

    public c ctD() {
        return this.jad;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, eVar, str, i4);
        }
    }

    public b ctE() {
        return this.jae;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0584a
    public void pO(boolean z) {
        this.iHI = z;
    }

    public void qj(boolean z) {
        if (z && this.iOF) {
            this.guL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.gsO.setNextPage(this.guL);
            this.iNH = 2;
        }
    }

    public void cpE() {
        this.guL.setLineVisible();
        this.guL.startLoadData();
    }

    public void endLoadData() {
        if (this.guL != null) {
            this.guL.setLineGone();
            this.guL.endLoadData();
        }
        if (cnf() != null && cnf().iYD != null) {
            this.iZW.iYD.bqp();
        }
    }

    public void Gc(String str) {
        if (this.guL != null) {
            this.guL.setText(str);
        }
    }

    public void Gd(String str) {
        if (this.guL != null) {
            this.guL.ac(str, this.topMargin);
        }
    }

    public void cpG() {
        if (this.ens != null && this.ens.isEnabled()) {
            this.ens.setRefreshing(false);
        }
    }

    public void cqb() {
        if (this.iNH != 2) {
            this.gsO.setNextPage(this.guL);
            this.iNH = 2;
        }
    }

    public void qf(boolean z) {
        this.iPc = z;
    }

    public void cpc() {
        if (this.gsO == null) {
        }
    }

    public int cpH() {
        if (this.gsO != null) {
            return this.gsO.getFirstVisiblePosition();
        }
        return 0;
    }

    public int ctF() {
        View childAt;
        if (this.gsO == null || this.gsO.getCount() <= 0 || (childAt = this.gsO.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int cpI() {
        if (this.gsO != null) {
            int lastVisiblePosition = this.gsO.getLastVisiblePosition();
            if (clz() != null && clz().getPbData() != null && lastVisiblePosition >= clz().getPbData().cku().size()) {
                return clz().getPbData().cku().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View cpS() {
        return this.dCM;
    }

    public int ctB() {
        return this.iZZ;
    }

    public int ctG() {
        return this.jaj;
    }

    public void zv(int i) {
        if (this.jag != null) {
            this.jag.setVisibility(i);
        }
    }

    public void qY(boolean z) {
        if (this.gsO != null) {
            this.gsO.setCanFling(z);
        }
    }

    public void cu(int i, int i2) {
        if (this.gsO != null && this.gsO.getLayoutManager() != null && (this.gsO.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.gsO.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }
}
