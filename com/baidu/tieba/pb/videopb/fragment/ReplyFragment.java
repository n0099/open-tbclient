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
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.k;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ak;
import com.baidu.tieba.pb.videopb.MultiNestedLayout;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.a;
import com.baidu.tieba.pb.videopb.c;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.pb.videopb.videoView.b;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class ReplyFragment extends BaseFragment implements a, a.InterfaceC0577a {
    private BdSwipeRefreshLayout ejj;
    private BdTypeRecyclerView gqN;
    private PbActivity iFv;
    private boolean iGe;
    private View iYA;
    private b iYB;
    private View iYC;
    private VideoPbFragment iYq;
    private c iYx;
    private com.baidu.tieba.pb.videopb.b.b iYy;
    private MultiNestedLayout iYz;
    private View mRootView;
    private int topMargin;
    private PbListView gsK = null;
    private View dyM = null;
    private com.baidu.tieba.pb.view.a iMI = null;
    private boolean iNk = false;
    private boolean iNH = false;
    private boolean iOg = true;
    private int iMn = 0;
    private h mPullView = null;
    private boolean iDb = false;
    private int iYt = 0;
    private int iYD = 0;
    private RecyclerView.OnScrollListener fAi = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.clL().cnR();
                ReplyFragment.this.clL().crD();
            }
            if (ReplyFragment.this.clL() != null) {
                ReplyFragment.this.clL().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.iYt = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.iYt != 0) {
                ReplyFragment.this.iYA.setVisibility(8);
            }
            ReplyFragment.this.iYt = 0;
        }
    };
    private MultiNestedLayout.b iYE = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void onStateChange(int i) {
            if (ReplyFragment.this.iYD != 1 || i == 1 || ReplyFragment.this.iYt == 0) {
                if (ReplyFragment.this.iYD != 0 || i == 0) {
                    if (ReplyFragment.this.iYD != 0 && i == 0) {
                        ReplyFragment.this.clL().zp(8);
                    }
                } else if (ReplyFragment.this.iYA.getVisibility() != 0) {
                    ReplyFragment.this.clL().zp(0);
                }
            } else {
                ReplyFragment.this.clL().zp(8);
                ReplyFragment.this.iYA.setVisibility(0);
            }
            ReplyFragment.this.iYD = i;
        }
    };
    private final g.c dcC = new g.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.ckc() != null && ReplyFragment.this.ckc().pT(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.cop();
            }
        }
    };
    private final BdListView.e gGI = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (ReplyFragment.this.ckc().pS(false)) {
                    ReplyFragment.this.con();
                    TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (ReplyFragment.this.ckc().getPbData() != null) {
                    ReplyFragment.this.coJ();
                }
            }
        }
    };

    public static ReplyFragment T(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.iYq = videoPbFragment;
        return replyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.iFv = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iYy = new com.baidu.tieba.pb.videopb.b.b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iYz = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.iYz.setScrollStateChangeListener(this.iYE);
        this.gqN = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.gqN.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iYx = new c(this, this.gqN);
        this.iYx.C(clL().crp());
        this.iYx.O(clL().crq());
        this.iYx.setOnLongClickListener(clL().crr());
        this.iYx.setOnImageClickListener(this.iYy.getOnImageClickListener());
        this.iYx.setTbGestureDetector(this.iYy.csa());
        this.iYA = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.gsK = new PbListView(getPageContext().getPageActivity());
        this.dyM = this.gsK.getView().findViewById(R.id.pb_more_view);
        if (this.dyM != null) {
            this.dyM.setOnClickListener(clL().crp());
            am.setBackgroundResource(this.dyM, R.drawable.pb_foot_more_trans_selector);
        }
        this.gsK.setLineVisible();
        this.gsK.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.gsK.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.gsK.aFs();
        this.gqN.setOnSrollToBottomListener(this.gGI);
        this.gqN.addOnScrollListener(this.fAi);
        this.gqN.setOnTouchListener(clL().aPW());
        if (this.mPullView == null) {
            this.mPullView = new h(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.dcC);
        }
        if (this.ejj == null) {
            this.ejj = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.ejj.setProgressView(this.mPullView);
            this.ejj.setEnabled(false);
            am.setBackgroundColor(this.ejj, R.color.cp_bg_line_e);
        }
        this.iYC = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.iYB = new b(this.iYC);
        this.iYB.T(clL().crp());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e eVar = (e) y.b(clM()).l(e.class);
        eVar.crR().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
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
        d(true, 0, 3, 0, eVar.crI(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gsK != null) {
            this.gsK.changeSkin(i);
            if (this.dyM != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.dyM);
                am.setBackgroundResource(this.dyM, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.iYB != null) {
            this.iYB.onChangeSkinType(i);
        }
        if (this.iYx != null) {
            this.iYx.notifyDataSetChanged();
        }
        if (this.iYA != null) {
            am.setBackgroundResource(this.iYA, R.drawable.personalize_tab_shadow);
        }
        am.setBackgroundColor(this.ejj, R.color.cp_bg_line_d);
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
        this.iGe = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        qg(z);
        if (clL() != null && clL().iXi != null) {
            this.iYq.iXi.crY();
        }
        if (z && this.iGe) {
            con();
            ckc().pS(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        e eVar = (e) y.b(clM()).l(e.class);
        if (z && ckc() != null && fVar != null) {
            this.iDb = ckc().cmd();
            boolean isEnabled = this.ejj.isEnabled();
            if (fVar.getPage().ayS() == 0 && this.iDb) {
                this.ejj.setEnabled(false);
            } else if (!isEnabled) {
                this.ejj.setEnabled(true);
                this.ejj.interruptRefresh();
            }
            this.iYx.setIsFromCDN(eVar.isFromCDN());
            this.iYx.setData(fVar);
            this.iNk = false;
            if (TbadkCoreApplication.isLogin()) {
                this.gqN.setNextPage(this.gsK);
                this.iMn = 2;
                if (clL() != null && clL().iXi != null) {
                    this.iYq.iXi.boJ();
                }
            } else {
                this.iNk = true;
                if (fVar.getPage().ayR() == 1) {
                    if (this.iMI == null) {
                        this.iMI = new com.baidu.tieba.pb.view.a(this, this);
                        this.iMI.createView();
                        this.iMI.aFs();
                    }
                    this.gqN.setNextPage(this.iMI);
                } else {
                    this.gqN.setNextPage(this.gsK);
                }
                this.iMn = 3;
            }
            if (this.iYB != null && this.iYC != null) {
                k kVar = new k(k.iAI);
                bj ciS = fVar.ciS();
                kVar.iAK = ciS != null ? ciS.azO() : 0L;
                kVar.isNew = !ckc().cmd();
                kVar.iAN = clG();
                kVar.sortType = fVar.izK;
                kVar.iAM = fVar.cjt();
                kVar.isDynamic = fVar.cjs();
                this.iYB.a(kVar);
            }
            ArrayList<PostData> ciU = fVar.ciU();
            if (fVar.getPage().ayR() == 0 || ciU == null || ciU.size() < fVar.getPage().ayQ()) {
                if (v.getCount(ciU) == 0 || (v.getCount(ciU) == 1 && ciU.get(0) != null && ciU.get(0).cJx() == 1)) {
                    if (clG()) {
                        this.gsK.ae(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.gsK.ae(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (fVar.getPage().ayR() == 0) {
                        this.gsK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.gsK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.gsK.aFt();
                }
                if (fVar.getPage().ayR() == 0 || ciU == null) {
                    coJ();
                }
            } else {
                if (ckc().getIsFromMark()) {
                    if (this.iOg) {
                        endLoadData();
                        if (fVar.getPage().ayR() != 0) {
                            this.gsK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.gsK.setLineVisible();
                        this.gsK.showLoading();
                    }
                } else {
                    this.gsK.setLineVisible();
                    this.gsK.showLoading();
                }
                this.gsK.aFt();
            }
            switch (i2) {
                case 2:
                    this.gqN.setSelection(i3 > 1 ? (((this.gqN.getData() == null && fVar.ciU() == null) ? 0 : this.gqN.getData().size() - fVar.ciU().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable cny = ak.cnx().cny();
                        if (cny instanceof RecyclerView.SavedState) {
                            this.gqN.onRestoreInstanceState(cny);
                            if (v.getCount(ciU) > 1 && fVar.getPage().ayR() > 0) {
                                this.gsK.endLoadData();
                                this.gsK.setText(getString(R.string.pb_load_more_without_point));
                                this.gsK.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.iOg = false;
                    break;
                case 5:
                    this.gqN.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable cny2 = ak.cnx().cny();
                        if (cny2 instanceof RecyclerView.SavedState) {
                            this.gqN.onRestoreInstanceState(cny2);
                            break;
                        }
                    }
                    this.gqN.setSelection(0);
                    break;
                case 8:
                    int size = (this.gqN.getData() == null && fVar.ciU() == null) ? 0 : this.gqN.getData().size() - fVar.ciU().size();
                    this.iYz.setMaxOffset();
                    this.gqN.setSelection(i3 > 0 ? size + i3 : 0);
                    this.gsK.endLoadData();
                    this.gsK.setText(getString(R.string.pb_load_more_without_point));
                    this.gsK.setLineGone();
                    break;
            }
            if (this.iNH) {
                cnL();
                this.iNH = false;
                if (i4 == 0) {
                    qc(true);
                }
            }
            clL().q(fVar);
        }
    }

    public void csh() {
        f pbData = ckc().getPbData();
        if (pbData != null) {
            this.iYx.setData(pbData);
            this.iYx.notifyDataSetChanged();
            ArrayList<PostData> ciU = pbData.ciU();
            if (pbData.getPage().ayR() == 0 || ciU == null || ciU.size() < pbData.getPage().ayQ()) {
                if (v.getCount(ciU) == 0 || (v.getCount(ciU) == 1 && ciU.get(0) != null && ciU.get(0).cJx() == 1)) {
                    if (clG()) {
                        this.gsK.ae(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.gsK.ae(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().ayR() == 0) {
                        this.gsK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.gsK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.gsK.aFt();
                }
            }
            clL().q(pbData);
        }
    }

    public PbActivity clM() {
        return this.iFv != null ? this.iFv : clL().clM();
    }

    public VideoPbFragment clL() {
        if (this.iYq == null && this.iFv != null) {
            Fragment ckq = this.iFv.ckq();
            if (ckq instanceof VideoPbFragment) {
                this.iYq = (VideoPbFragment) ckq;
            }
        }
        return this.iYq;
    }

    public PbModel ckc() {
        return clL().ckc();
    }

    public BdTypeRecyclerView getListView() {
        return this.gqN;
    }

    public boolean clG() {
        if (ckc() != null) {
            return ckc().getHostMode();
        }
        return false;
    }

    public c csi() {
        return this.iYx;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, fVar, str, i4);
        }
    }

    public com.baidu.tieba.pb.videopb.b.b csj() {
        return this.iYy;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0577a
    public void pL(boolean z) {
        this.iGe = z;
    }

    public void qg(boolean z) {
        if (z && this.iNk) {
            this.gsK.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.gqN.setNextPage(this.gsK);
            this.iMn = 2;
        }
    }

    public void con() {
        this.gsK.setLineVisible();
        this.gsK.startLoadData();
    }

    public void endLoadData() {
        if (this.gsK != null) {
            this.gsK.setLineGone();
            this.gsK.endLoadData();
        }
        if (clL() != null && clL().iXi != null) {
            this.iYq.iXi.boJ();
        }
    }

    public void FN(String str) {
        if (this.gsK != null) {
            this.gsK.setText(str);
        }
    }

    public void FO(String str) {
        if (this.gsK != null) {
            this.gsK.ae(str, this.topMargin);
        }
    }

    public void cop() {
        if (this.ejj != null && this.ejj.isEnabled()) {
            this.ejj.setRefreshing(false);
        }
    }

    public void coJ() {
        if (this.iMn != 2) {
            this.gqN.setNextPage(this.gsK);
            this.iMn = 2;
        }
    }

    public void qc(boolean z) {
        this.iNH = z;
    }

    public void cnL() {
        if (this.gqN == null) {
        }
    }

    public int coq() {
        if (this.gqN != null) {
            return this.gqN.getFirstVisiblePosition();
        }
        return 0;
    }

    public int csk() {
        View childAt;
        if (this.gqN == null || this.gqN.getCount() <= 0 || (childAt = this.gqN.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int cor() {
        if (this.gqN != null) {
            int lastVisiblePosition = this.gqN.getLastVisiblePosition();
            if (ckc() != null && ckc().getPbData() != null && lastVisiblePosition >= ckc().getPbData().ciU().size()) {
                return ckc().getPbData().ciU().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View coB() {
        return this.dyM;
    }

    public int csg() {
        return this.iYt;
    }

    public int csl() {
        return this.iYD;
    }

    public void zp(int i) {
        if (this.iYA != null) {
            this.iYA.setVisibility(i);
        }
    }

    public void qT(boolean z) {
        if (this.gqN != null) {
            this.gqN.setCanFling(z);
        }
    }

    public void ct(int i, int i2) {
        if (this.gqN != null && this.gqN.getLayoutManager() != null && (this.gqN.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.gqN.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }
}
