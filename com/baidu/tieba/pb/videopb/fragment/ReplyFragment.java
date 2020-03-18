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
public class ReplyFragment extends BaseFragment implements a, a.InterfaceC0585a {
    private BdSwipeRefreshLayout enY;
    private BdTypeRecyclerView gtH;
    private PbActivity iIO;
    private boolean iJx;
    private VideoPbFragment jbK;
    private c jbR;
    private b jbS;
    private MultiNestedLayout jbT;
    private View jbU;
    private com.baidu.tieba.pb.videopb.videoView.b jbV;
    private View jbW;
    private View mRootView;
    private int topMargin;
    private PbListView gvD = null;
    private View dDn = null;
    private com.baidu.tieba.pb.view.a iPR = null;
    private boolean iQu = false;
    private boolean iQR = false;
    private boolean iRq = true;
    private int iPw = 0;
    private h mPullView = null;
    private boolean iGx = false;
    private int jbN = 0;
    private int jbX = 0;
    private RecyclerView.OnScrollListener fDD = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.cnD().cpG();
                ReplyFragment.this.cnD().cts();
            }
            if (ReplyFragment.this.cnD() != null) {
                ReplyFragment.this.cnD().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.jbN = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.jbN != 0) {
                ReplyFragment.this.jbU.setVisibility(8);
            }
            ReplyFragment.this.jbN = 0;
        }
    };
    private MultiNestedLayout.b jbY = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void onStateChange(int i) {
            if (ReplyFragment.this.jbX != 1 || i == 1 || ReplyFragment.this.jbN == 0) {
                if (ReplyFragment.this.jbX != 0 || i == 0) {
                    if (ReplyFragment.this.jbX != 0 && i == 0) {
                        ReplyFragment.this.cnD().zD(8);
                    }
                } else if (ReplyFragment.this.jbU.getVisibility() != 0) {
                    ReplyFragment.this.cnD().zD(0);
                }
            } else {
                ReplyFragment.this.cnD().zD(8);
                ReplyFragment.this.jbU.setVisibility(0);
            }
            ReplyFragment.this.jbX = i;
        }
    };
    private final g.c dhi = new g.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.clX() != null && ReplyFragment.this.clX().qc(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.cqe();
            }
        }
    };
    private final BdListView.e gKa = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (ReplyFragment.this.clX().qb(false)) {
                    ReplyFragment.this.cqc();
                    TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (ReplyFragment.this.clX().getPbData() != null) {
                    ReplyFragment.this.cqz();
                }
            }
        }
    };

    public static ReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.jbK = videoPbFragment;
        return replyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.iIO = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.jbS = new b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jbT = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.jbT.setScrollStateChangeListener(this.jbY);
        this.gtH = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.gtH.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jbR = new c(this, this.gtH);
        this.jbR.D(cnD().cte());
        this.jbR.P(cnD().ctf());
        this.jbR.setOnLongClickListener(cnD().ctg());
        this.jbR.setOnImageClickListener(this.jbS.getOnImageClickListener());
        this.jbR.setTbGestureDetector(this.jbS.ctT());
        this.jbU = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.gvD = new PbListView(getPageContext().getPageActivity());
        this.dDn = this.gvD.getView().findViewById(R.id.pb_more_view);
        if (this.dDn != null) {
            this.dDn.setOnClickListener(cnD().cte());
            am.setBackgroundResource(this.dDn, R.drawable.pb_foot_more_trans_selector);
        }
        this.gvD.setLineVisible();
        this.gvD.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.gvD.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.gvD.aHL();
        this.gtH.setOnSrollToBottomListener(this.gKa);
        this.gtH.addOnScrollListener(this.fDD);
        this.gtH.setOnTouchListener(cnD().aSu());
        if (this.mPullView == null) {
            this.mPullView = new h(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.dhi);
        }
        if (this.enY == null) {
            this.enY = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.enY.setProgressView(this.mPullView);
            this.enY.setEnabled(false);
            am.setBackgroundColor(this.enY, R.color.cp_bg_line_e);
        }
        this.jbW = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.jbV = new com.baidu.tieba.pb.videopb.videoView.b(this.jbW);
        this.jbV.T(cnD().cte());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e eVar = (e) y.b(cnE()).l(e.class);
        eVar.ctK().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
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
        d(true, 0, 3, 0, eVar.ctB(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gvD != null) {
            this.gvD.changeSkin(i);
            if (this.dDn != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.dDn);
                am.setBackgroundResource(this.dDn, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.jbV != null) {
            this.jbV.onChangeSkinType(i);
        }
        if (this.jbR != null) {
            this.jbR.notifyDataSetChanged();
        }
        if (this.jbU != null) {
            am.setBackgroundResource(this.jbU, R.drawable.personalize_tab_shadow);
        }
        am.setBackgroundColor(this.enY, R.color.cp_bg_line_d);
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
        this.iJx = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        qp(z);
        if (cnD() != null && cnD().jas != null) {
            this.jbK.jas.ctR();
        }
        if (z && this.iJx) {
            cqc();
            clX().qb(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        e eVar2 = (e) y.b(cnE()).l(e.class);
        if (z && clX() != null && eVar != null) {
            this.iGx = clX().cnV();
            boolean isEnabled = this.enY.isEnabled();
            if (eVar.getPage().aBo() == 0 && this.iGx) {
                this.enY.setEnabled(false);
            } else if (!isEnabled) {
                this.enY.setEnabled(true);
                this.enY.interruptRefresh();
            }
            this.jbR.setIsFromCDN(eVar2.isFromCDN());
            this.jbR.qZ(this.iGx);
            this.jbR.setData(eVar);
            this.iQu = false;
            if (TbadkCoreApplication.isLogin()) {
                this.gtH.setNextPage(this.gvD);
                this.iPw = 2;
                if (cnD() != null && cnD().jas != null) {
                    this.jbK.jas.bqx();
                }
            } else {
                this.iQu = true;
                if (eVar.getPage().aBn() == 1) {
                    if (this.iPR == null) {
                        this.iPR = new com.baidu.tieba.pb.view.a(this, this);
                        this.iPR.createView();
                        this.iPR.aHL();
                    }
                    this.gtH.setNextPage(this.iPR);
                } else {
                    this.gtH.setNextPage(this.gvD);
                }
                this.iPw = 3;
            }
            if (this.jbV != null && this.jbW != null) {
                j jVar = new j(j.iEq);
                bj ckP = eVar.ckP();
                jVar.iEs = ckP != null ? ckP.aCi() : 0L;
                jVar.isNew = !clX().cnV();
                jVar.iEv = cny();
                jVar.sortType = eVar.iDq;
                jVar.iEu = eVar.clo();
                jVar.isDynamic = eVar.cln();
                this.jbV.a(jVar);
            }
            ArrayList<PostData> ckR = eVar.ckR();
            if (eVar.getPage().aBn() == 0 || ckR == null || ckR.size() < eVar.getPage().aBm()) {
                if (v.getCount(ckR) == 0 || (v.getCount(ckR) == 1 && ckR.get(0) != null && ckR.get(0).cLv() == 1)) {
                    if (cny()) {
                        this.gvD.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.gvD.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (eVar.getPage().aBn() == 0) {
                        this.gvD.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.gvD.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.gvD.aHM();
                }
                if (eVar.getPage().aBn() == 0 || ckR == null) {
                    cqz();
                }
            } else {
                if (clX().getIsFromMark()) {
                    if (this.iRq) {
                        endLoadData();
                        if (eVar.getPage().aBn() != 0) {
                            this.gvD.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.gvD.setLineVisible();
                        this.gvD.showLoading();
                    }
                } else {
                    this.gvD.setLineVisible();
                    this.gvD.showLoading();
                }
                this.gvD.aHM();
            }
            switch (i2) {
                case 2:
                    this.gtH.setSelection(i3 > 1 ? (((this.gtH.getData() == null && eVar.ckR() == null) ? 0 : this.gtH.getData().size() - eVar.ckR().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable cpn = ah.cpm().cpn();
                        if (cpn instanceof RecyclerView.SavedState) {
                            this.gtH.onRestoreInstanceState(cpn);
                            if (v.getCount(ckR) > 1 && eVar.getPage().aBn() > 0) {
                                this.gvD.endLoadData();
                                this.gvD.setText(getString(R.string.pb_load_more_without_point));
                                this.gvD.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.iRq = false;
                    break;
                case 5:
                    this.gtH.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable cpn2 = ah.cpm().cpn();
                        if (cpn2 instanceof RecyclerView.SavedState) {
                            this.gtH.onRestoreInstanceState(cpn2);
                            break;
                        }
                    }
                    this.gtH.setSelection(0);
                    break;
                case 8:
                    int size = (this.gtH.getData() == null && eVar.ckR() == null) ? 0 : this.gtH.getData().size() - eVar.ckR().size();
                    this.jbT.setMaxOffset();
                    this.gtH.setSelection(i3 > 0 ? size + i3 : 0);
                    this.gvD.endLoadData();
                    this.gvD.setText(getString(R.string.pb_load_more_without_point));
                    this.gvD.setLineGone();
                    break;
            }
            if (this.iQR) {
                cpA();
                this.iQR = false;
                if (i4 == 0) {
                    ql(true);
                }
            }
            cnD().q(eVar);
        }
    }

    public void cua() {
        com.baidu.tieba.pb.data.e pbData = clX().getPbData();
        if (pbData != null) {
            this.jbR.qZ(clX().cnV());
            this.jbR.setData(pbData);
            this.jbR.notifyDataSetChanged();
            ArrayList<PostData> ckR = pbData.ckR();
            if (pbData.getPage().aBn() == 0 || ckR == null || ckR.size() < pbData.getPage().aBm()) {
                if (v.getCount(ckR) == 0 || (v.getCount(ckR) == 1 && ckR.get(0) != null && ckR.get(0).cLv() == 1)) {
                    if (cny()) {
                        this.gvD.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.gvD.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().aBn() == 0) {
                        this.gvD.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.gvD.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.gvD.aHM();
                }
            }
            cnD().q(pbData);
        }
    }

    public PbActivity cnE() {
        return this.iIO != null ? this.iIO : cnD().cnE();
    }

    public VideoPbFragment cnD() {
        if (this.jbK == null && this.iIO != null) {
            Fragment cmj = this.iIO.cmj();
            if (cmj instanceof VideoPbFragment) {
                this.jbK = (VideoPbFragment) cmj;
            }
        }
        return this.jbK;
    }

    public PbModel clX() {
        return cnD().clX();
    }

    public BdTypeRecyclerView getListView() {
        return this.gtH;
    }

    public boolean cny() {
        if (clX() != null) {
            return clX().getHostMode();
        }
        return false;
    }

    public c cub() {
        return this.jbR;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, eVar, str, i4);
        }
    }

    public b cuc() {
        return this.jbS;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0585a
    public void pU(boolean z) {
        this.iJx = z;
    }

    public void qp(boolean z) {
        if (z && this.iQu) {
            this.gvD.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.gtH.setNextPage(this.gvD);
            this.iPw = 2;
        }
    }

    public void cqc() {
        this.gvD.setLineVisible();
        this.gvD.startLoadData();
    }

    public void endLoadData() {
        if (this.gvD != null) {
            this.gvD.setLineGone();
            this.gvD.endLoadData();
        }
        if (cnD() != null && cnD().jas != null) {
            this.jbK.jas.bqx();
        }
    }

    public void Gc(String str) {
        if (this.gvD != null) {
            this.gvD.setText(str);
        }
    }

    public void Gd(String str) {
        if (this.gvD != null) {
            this.gvD.ac(str, this.topMargin);
        }
    }

    public void cqe() {
        if (this.enY != null && this.enY.isEnabled()) {
            this.enY.setRefreshing(false);
        }
    }

    public void cqz() {
        if (this.iPw != 2) {
            this.gtH.setNextPage(this.gvD);
            this.iPw = 2;
        }
    }

    public void ql(boolean z) {
        this.iQR = z;
    }

    public void cpA() {
        if (this.gtH == null) {
        }
    }

    public int cqf() {
        if (this.gtH != null) {
            return this.gtH.getFirstVisiblePosition();
        }
        return 0;
    }

    public int cud() {
        View childAt;
        if (this.gtH == null || this.gtH.getCount() <= 0 || (childAt = this.gtH.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int cqg() {
        if (this.gtH != null) {
            int lastVisiblePosition = this.gtH.getLastVisiblePosition();
            if (clX() != null && clX().getPbData() != null && lastVisiblePosition >= clX().getPbData().ckR().size()) {
                return clX().getPbData().ckR().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View cqq() {
        return this.dDn;
    }

    public int ctZ() {
        return this.jbN;
    }

    public int cue() {
        return this.jbX;
    }

    public void zD(int i) {
        if (this.jbU != null) {
            this.jbU.setVisibility(i);
        }
    }

    public void re(boolean z) {
        if (this.gtH != null) {
            this.gtH.setCanFling(z);
        }
    }

    public void cv(int i, int i2) {
        if (this.gtH != null && this.gtH.getLayoutManager() != null && (this.gtH.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.gtH.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }
}
