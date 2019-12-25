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
import com.baidu.tieba.pb.videopb.b.b;
import com.baidu.tieba.pb.videopb.c;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ReplyFragment extends BaseFragment implements a, a.InterfaceC0572a {
    private int JM;
    private BdSwipeRefreshLayout eiv;
    private BdTypeRecyclerView gnE;
    private PbActivity iBR;
    private boolean iCA;
    private VideoPbFragment iUN;
    private c iUU;
    private b iUV;
    private MultiNestedLayout iUW;
    private View iUX;
    private com.baidu.tieba.pb.videopb.videoView.b iUY;
    private View iUZ;
    private View mRootView;
    private PbListView gpB = null;
    private View dyE = null;
    private com.baidu.tieba.pb.view.a iJe = null;
    private boolean iJG = false;
    private boolean iKd = false;
    private boolean iKC = true;
    private int iIJ = 0;
    private h mPullView = null;
    private boolean izx = false;
    private int iUQ = 0;
    private int iVa = 0;
    private RecyclerView.OnScrollListener fwX = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.ckD().cmK();
                ReplyFragment.this.ckD().cqw();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.iUQ = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.iUQ != 0) {
                ReplyFragment.this.iUX.setVisibility(8);
            }
            ReplyFragment.this.iUQ = 0;
        }
    };
    private MultiNestedLayout.b iVb = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void onStateChange(int i) {
            if (ReplyFragment.this.iVa != 1 || i == 1 || ReplyFragment.this.iUQ == 0) {
                if (ReplyFragment.this.iVa != 0 || i == 0) {
                    if (ReplyFragment.this.iVa != 0 && i == 0) {
                        ReplyFragment.this.ckD().zk(8);
                    }
                } else if (ReplyFragment.this.iUX.getVisibility() != 0) {
                    ReplyFragment.this.ckD().zk(0);
                }
            } else {
                ReplyFragment.this.ckD().zk(8);
                ReplyFragment.this.iUX.setVisibility(0);
            }
            ReplyFragment.this.iVa = i;
        }
    };
    private final g.c dcr = new g.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.ciU() != null && ReplyFragment.this.ciU().pH(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.cni();
            }
        }
    };
    private final BdListView.e gDt = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (ReplyFragment.this.ciU().pG(false)) {
                    ReplyFragment.this.cng();
                    TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (ReplyFragment.this.ciU().getPbData() != null) {
                    ReplyFragment.this.cnC();
                }
            }
        }
    };

    public static ReplyFragment T(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.iUN = videoPbFragment;
        return replyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.iBR = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iUV = new b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    private void initUI() {
        this.JM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iUW = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.iUW.setScrollStateChangeListener(this.iVb);
        this.gnE = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.gnE.setLayoutManager(new LinearLayoutManager(getContext()));
        this.iUU = new c(this, this.gnE);
        this.iUU.D(ckD().cqi());
        this.iUU.P(ckD().cqj());
        this.iUU.setOnLongClickListener(ckD().cqk());
        this.iUU.setOnImageClickListener(this.iUV.getOnImageClickListener());
        this.iUU.setTbGestureDetector(this.iUV.cqT());
        this.iUX = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.gpB = new PbListView(getPageContext().getPageActivity());
        this.dyE = this.gpB.getView().findViewById(R.id.pb_more_view);
        if (this.dyE != null) {
            this.dyE.setOnClickListener(ckD().cqi());
            am.setBackgroundResource(this.dyE, R.drawable.pb_foot_more_trans_selector);
        }
        this.gpB.setLineVisible();
        this.gpB.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.gpB.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.gpB.aEZ();
        this.gnE.setOnSrollToBottomListener(this.gDt);
        this.gnE.addOnScrollListener(this.fwX);
        this.gnE.setOnTouchListener(ckD().aPD());
        if (this.mPullView == null) {
            this.mPullView = new h(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.dcr);
        }
        if (this.eiv == null) {
            this.eiv = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.eiv.setProgressView(this.mPullView);
            this.eiv.setEnabled(false);
            am.setBackgroundColor(this.eiv, R.color.cp_bg_line_e);
        }
        this.iUZ = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.iUY = new com.baidu.tieba.pb.videopb.videoView.b(this.iUZ);
        this.iUY.U(ckD().cqi());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e eVar = (e) y.b(ckE()).l(e.class);
        eVar.cqK().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
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
        d(true, 0, 3, 0, eVar.cqB(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gpB != null) {
            this.gpB.changeSkin(i);
            if (this.dyE != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.dyE);
                am.setBackgroundResource(this.dyE, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.iUY != null) {
            this.iUY.onChangeSkinType(i);
        }
        if (this.iUU != null) {
            this.iUU.notifyDataSetChanged();
        }
        if (this.iUX != null) {
            am.setBackgroundResource(this.iUX, R.drawable.personalize_tab_shadow);
        }
        am.setBackgroundColor(this.eiv, R.color.cp_bg_line_d);
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
        this.iCA = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        pU(z);
        if (ckD() != null && ckD().iTF != null) {
            this.iUN.iTF.cqR();
        }
        if (z && this.iCA) {
            cng();
            ciU().pG(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        Parcelable cmr;
        Parcelable cmr2;
        e eVar = (e) y.b(ckE()).l(e.class);
        if (z && ciU() != null && fVar != null) {
            this.izx = ciU().ckV();
            boolean isEnabled = this.eiv.isEnabled();
            if (fVar.getPage().ayz() == 0 && this.izx) {
                this.eiv.setEnabled(false);
            } else if (!isEnabled) {
                this.eiv.setEnabled(true);
                this.eiv.interruptRefresh();
            }
            this.iUU.setIsFromCDN(eVar.isFromCDN());
            this.iUU.setData(fVar);
            this.iJG = false;
            if (TbadkCoreApplication.isLogin()) {
                this.gnE.setNextPage(this.gpB);
                this.iIJ = 2;
                if (ckD() != null && ckD().iTF != null) {
                    this.iUN.iTF.bnJ();
                }
            } else {
                this.iJG = true;
                if (fVar.getPage().ayy() == 1) {
                    if (this.iJe == null) {
                        this.iJe = new com.baidu.tieba.pb.view.a(this, this);
                        this.iJe.createView();
                        this.iJe.aEZ();
                    }
                    this.gnE.setNextPage(this.iJe);
                } else {
                    this.gnE.setNextPage(this.gpB);
                }
                this.iIJ = 3;
            }
            if (this.iUY != null && this.iUZ != null) {
                k kVar = new k(k.ixe);
                bj chK = fVar.chK();
                kVar.ixg = chK != null ? chK.azv() : 0L;
                kVar.isNew = !ciU().ckV();
                kVar.ixj = cky();
                kVar.sortType = fVar.iwg;
                kVar.ixi = fVar.cil();
                kVar.isDynamic = fVar.cik();
                this.iUY.a(kVar);
            }
            ArrayList<PostData> chM = fVar.chM();
            if (fVar.getPage().ayy() == 0 || chM == null || chM.size() < fVar.getPage().ayx()) {
                if (v.getCount(chM) == 0 || (v.getCount(chM) == 1 && chM.get(0) != null && chM.get(0).cIt() == 1)) {
                    if (cky()) {
                        this.gpB.ad(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.JM);
                    } else {
                        this.gpB.ad(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.JM);
                    }
                } else {
                    if (fVar.getPage().ayy() == 0) {
                        this.gpB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.gpB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.gpB.aFa();
                }
                if (fVar.getPage().ayy() == 0 || chM == null) {
                    cnC();
                }
            } else {
                if (ciU().getIsFromMark()) {
                    if (this.iKC) {
                        endLoadData();
                        if (fVar.getPage().ayy() != 0) {
                            this.gpB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.gpB.setLineVisible();
                        this.gpB.showLoading();
                    }
                } else {
                    this.gpB.setLineVisible();
                    this.gpB.showLoading();
                }
                this.gpB.aFa();
            }
            switch (i2) {
                case 2:
                    this.gnE.setSelection(i3 > 1 ? (((this.gnE.getData() == null && fVar.chM() == null) ? 0 : this.gnE.getData().size() - fVar.chM().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1 && (cmr2 = ak.cmq().cmr()) != null) {
                        this.gnE.onRestoreInstanceState(cmr2);
                        if (v.getCount(chM) > 1 && fVar.getPage().ayy() > 0) {
                            this.gpB.endLoadData();
                            this.gpB.setText(getString(R.string.pb_load_more_without_point));
                            this.gpB.setLineGone();
                            break;
                        }
                    }
                    break;
                case 4:
                    this.iKC = false;
                    break;
                case 5:
                    this.gnE.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1 && (cmr = ak.cmq().cmr()) != null) {
                        this.gnE.onRestoreInstanceState(cmr);
                        break;
                    } else {
                        this.gnE.setSelection(0);
                        break;
                    }
                    break;
                case 8:
                    int size = (this.gnE.getData() == null && fVar.chM() == null) ? 0 : this.gnE.getData().size() - fVar.chM().size();
                    this.iUW.setMaxOffset();
                    this.gnE.setSelection(i3 > 0 ? size + i3 : 0);
                    this.gpB.endLoadData();
                    this.gpB.setText(getString(R.string.pb_load_more_without_point));
                    this.gpB.setLineGone();
                    break;
            }
            if (this.iKd) {
                cmE();
                this.iKd = false;
                if (i4 == 0) {
                    pQ(true);
                }
            }
            ckD().q(fVar);
        }
    }

    public void cra() {
        f pbData = ciU().getPbData();
        if (pbData != null) {
            this.iUU.setData(pbData);
            this.iUU.notifyDataSetChanged();
            ArrayList<PostData> chM = pbData.chM();
            if (pbData.getPage().ayy() == 0 || chM == null || chM.size() < pbData.getPage().ayx()) {
                if (v.getCount(chM) == 0 || (v.getCount(chM) == 1 && chM.get(0) != null && chM.get(0).cIt() == 1)) {
                    if (cky()) {
                        this.gpB.ad(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.JM);
                    } else {
                        this.gpB.ad(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.JM);
                    }
                } else {
                    if (pbData.getPage().ayy() == 0) {
                        this.gpB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.gpB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.gpB.aFa();
                }
            }
            ckD().q(pbData);
        }
    }

    public PbActivity ckE() {
        return this.iBR != null ? this.iBR : ckD().ckE();
    }

    public VideoPbFragment ckD() {
        if (this.iUN == null && this.iBR != null) {
            Fragment cji = this.iBR.cji();
            if (cji instanceof VideoPbFragment) {
                this.iUN = (VideoPbFragment) cji;
            }
        }
        return this.iUN;
    }

    public PbModel ciU() {
        return ckD().ciU();
    }

    public BdTypeRecyclerView getListView() {
        return this.gnE;
    }

    public boolean cky() {
        if (ciU() != null) {
            return ciU().getHostMode();
        }
        return false;
    }

    public c crb() {
        return this.iUU;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, fVar, str, i4);
        }
    }

    public b crc() {
        return this.iUV;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0572a
    public void pz(boolean z) {
        this.iCA = z;
    }

    public void pU(boolean z) {
        if (z && this.iJG) {
            this.gpB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.gnE.setNextPage(this.gpB);
            this.iIJ = 2;
        }
    }

    public void cng() {
        this.gpB.setLineVisible();
        this.gpB.startLoadData();
    }

    public void endLoadData() {
        if (this.gpB != null) {
            this.gpB.setLineGone();
            this.gpB.endLoadData();
        }
        if (ckD() != null && ckD().iTF != null) {
            this.iUN.iTF.bnJ();
        }
    }

    public void FD(String str) {
        if (this.gpB != null) {
            this.gpB.setText(str);
        }
    }

    public void FE(String str) {
        if (this.gpB != null) {
            this.gpB.ad(str, this.JM);
        }
    }

    public void cni() {
        if (this.eiv != null && this.eiv.isEnabled()) {
            this.eiv.setRefreshing(false);
        }
    }

    public void cnC() {
        if (this.iIJ != 2) {
            this.gnE.setNextPage(this.gpB);
            this.iIJ = 2;
        }
    }

    public void pQ(boolean z) {
        this.iKd = z;
    }

    public void cmE() {
        if (this.gnE == null) {
        }
    }

    public int cnj() {
        if (this.gnE != null) {
            return this.gnE.getFirstVisiblePosition();
        }
        return 0;
    }

    public int crd() {
        View childAt;
        if (this.gnE == null || this.gnE.getCount() <= 0 || (childAt = this.gnE.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int cnk() {
        if (this.gnE != null) {
            int lastVisiblePosition = this.gnE.getLastVisiblePosition();
            if (ciU() != null && ciU().getPbData() != null && lastVisiblePosition >= ciU().getPbData().chM().size()) {
                return ciU().getPbData().chM().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View cnu() {
        return this.dyE;
    }

    public int cqZ() {
        return this.iUQ;
    }

    public int cre() {
        return this.iVa;
    }

    public void zk(int i) {
        if (this.iUX != null) {
            this.iUX.setVisibility(i);
        }
    }

    public void qG(boolean z) {
        if (this.gnE != null) {
            this.gnE.setCanFling(z);
        }
    }

    public void cu(int i, int i2) {
        if (this.gnE != null && this.gnE.getLayoutManager() != null && (this.gnE.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.gnE.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }
}
