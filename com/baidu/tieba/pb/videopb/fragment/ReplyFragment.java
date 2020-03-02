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
    private BdSwipeRefreshLayout ent;
    private BdTypeRecyclerView gsQ;
    private boolean iHK;
    private PbActivity iHb;
    private VideoPbFragment iZY;
    private c jaf;
    private b jag;
    private MultiNestedLayout jah;
    private View jai;
    private com.baidu.tieba.pb.videopb.videoView.b jaj;
    private View jak;
    private View mRootView;
    private int topMargin;
    private PbListView guN = null;
    private View dCN = null;
    private com.baidu.tieba.pb.view.a iOe = null;
    private boolean iOH = false;
    private boolean iPe = false;
    private boolean iPD = true;
    private int iNJ = 0;
    private h mPullView = null;
    private boolean iEK = false;
    private int jab = 0;
    private int jal = 0;
    private RecyclerView.OnScrollListener fCI = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.cnh().cpk();
                ReplyFragment.this.cnh().csW();
            }
            if (ReplyFragment.this.cnh() != null) {
                ReplyFragment.this.cnh().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.jab = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.jab != 0) {
                ReplyFragment.this.jai.setVisibility(8);
            }
            ReplyFragment.this.jab = 0;
        }
    };
    private MultiNestedLayout.b jam = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void onStateChange(int i) {
            if (ReplyFragment.this.jal != 1 || i == 1 || ReplyFragment.this.jab == 0) {
                if (ReplyFragment.this.jal != 0 || i == 0) {
                    if (ReplyFragment.this.jal != 0 && i == 0) {
                        ReplyFragment.this.cnh().zv(8);
                    }
                } else if (ReplyFragment.this.jai.getVisibility() != 0) {
                    ReplyFragment.this.cnh().zv(0);
                }
            } else {
                ReplyFragment.this.cnh().zv(8);
                ReplyFragment.this.jai.setVisibility(0);
            }
            ReplyFragment.this.jal = i;
        }
    };
    private final g.c dgI = new g.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.clB() != null && ReplyFragment.this.clB().pW(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.cpI();
            }
        }
    };
    private final BdListView.e gIJ = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (ReplyFragment.this.clB().pV(false)) {
                    ReplyFragment.this.cpG();
                    TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                } else if (ReplyFragment.this.clB().getPbData() != null) {
                    ReplyFragment.this.cqd();
                }
            }
        }
    };

    public static ReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.iZY = videoPbFragment;
        return replyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.iHb = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.jag = new b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jah = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.jah.setScrollStateChangeListener(this.jam);
        this.gsQ = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.gsQ.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jaf = new c(this, this.gsQ);
        this.jaf.D(cnh().csI());
        this.jaf.P(cnh().csJ());
        this.jaf.setOnLongClickListener(cnh().csK());
        this.jaf.setOnImageClickListener(this.jag.getOnImageClickListener());
        this.jaf.setTbGestureDetector(this.jag.ctx());
        this.jai = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.guN = new PbListView(getPageContext().getPageActivity());
        this.dCN = this.guN.getView().findViewById(R.id.pb_more_view);
        if (this.dCN != null) {
            this.dCN.setOnClickListener(cnh().csI());
            am.setBackgroundResource(this.dCN, R.drawable.pb_foot_more_trans_selector);
        }
        this.guN.setLineVisible();
        this.guN.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.guN.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.guN.aHG();
        this.gsQ.setOnSrollToBottomListener(this.gIJ);
        this.gsQ.addOnScrollListener(this.fCI);
        this.gsQ.setOnTouchListener(cnh().aSp());
        if (this.mPullView == null) {
            this.mPullView = new h(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.dgI);
        }
        if (this.ent == null) {
            this.ent = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.ent.setProgressView(this.mPullView);
            this.ent.setEnabled(false);
            am.setBackgroundColor(this.ent, R.color.cp_bg_line_e);
        }
        this.jak = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.jaj = new com.baidu.tieba.pb.videopb.videoView.b(this.jak);
        this.jaj.T(cnh().csI());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e eVar = (e) y.b(cni()).l(e.class);
        eVar.cto().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
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
        d(true, 0, 3, 0, eVar.ctf(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.guN != null) {
            this.guN.changeSkin(i);
            if (this.dCN != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.dCN);
                am.setBackgroundResource(this.dCN, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.jaj != null) {
            this.jaj.onChangeSkinType(i);
        }
        if (this.jaf != null) {
            this.jaf.notifyDataSetChanged();
        }
        if (this.jai != null) {
            am.setBackgroundResource(this.jai, R.drawable.personalize_tab_shadow);
        }
        am.setBackgroundColor(this.ent, R.color.cp_bg_line_d);
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
        this.iHK = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        qj(z);
        if (cnh() != null && cnh().iYF != null) {
            this.iZY.iYF.ctv();
        }
        if (z && this.iHK) {
            cpG();
            clB().pV(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        e eVar2 = (e) y.b(cni()).l(e.class);
        if (z && clB() != null && eVar != null) {
            this.iEK = clB().cnz();
            boolean isEnabled = this.ent.isEnabled();
            if (eVar.getPage().aBl() == 0 && this.iEK) {
                this.ent.setEnabled(false);
            } else if (!isEnabled) {
                this.ent.setEnabled(true);
                this.ent.interruptRefresh();
            }
            this.jaf.setIsFromCDN(eVar2.isFromCDN());
            this.jaf.qT(this.iEK);
            this.jaf.setData(eVar);
            this.iOH = false;
            if (TbadkCoreApplication.isLogin()) {
                this.gsQ.setNextPage(this.guN);
                this.iNJ = 2;
                if (cnh() != null && cnh().iYF != null) {
                    this.iZY.iYF.bqr();
                }
            } else {
                this.iOH = true;
                if (eVar.getPage().aBk() == 1) {
                    if (this.iOe == null) {
                        this.iOe = new com.baidu.tieba.pb.view.a(this, this);
                        this.iOe.createView();
                        this.iOe.aHG();
                    }
                    this.gsQ.setNextPage(this.iOe);
                } else {
                    this.gsQ.setNextPage(this.guN);
                }
                this.iNJ = 3;
            }
            if (this.jaj != null && this.jak != null) {
                j jVar = new j(j.iCD);
                bj cku = eVar.cku();
                jVar.iCF = cku != null ? cku.aCf() : 0L;
                jVar.isNew = !clB().cnz();
                jVar.iCI = cnc();
                jVar.sortType = eVar.iBE;
                jVar.iCH = eVar.ckT();
                jVar.isDynamic = eVar.ckS();
                this.jaj.a(jVar);
            }
            ArrayList<PostData> ckw = eVar.ckw();
            if (eVar.getPage().aBk() == 0 || ckw == null || ckw.size() < eVar.getPage().aBj()) {
                if (v.getCount(ckw) == 0 || (v.getCount(ckw) == 1 && ckw.get(0) != null && ckw.get(0).cLa() == 1)) {
                    if (cnc()) {
                        this.guN.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.guN.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (eVar.getPage().aBk() == 0) {
                        this.guN.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.guN.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.guN.aHH();
                }
                if (eVar.getPage().aBk() == 0 || ckw == null) {
                    cqd();
                }
            } else {
                if (clB().getIsFromMark()) {
                    if (this.iPD) {
                        endLoadData();
                        if (eVar.getPage().aBk() != 0) {
                            this.guN.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.guN.setLineVisible();
                        this.guN.showLoading();
                    }
                } else {
                    this.guN.setLineVisible();
                    this.guN.showLoading();
                }
                this.guN.aHH();
            }
            switch (i2) {
                case 2:
                    this.gsQ.setSelection(i3 > 1 ? (((this.gsQ.getData() == null && eVar.ckw() == null) ? 0 : this.gsQ.getData().size() - eVar.ckw().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable coR = ah.coQ().coR();
                        if (coR instanceof RecyclerView.SavedState) {
                            this.gsQ.onRestoreInstanceState(coR);
                            if (v.getCount(ckw) > 1 && eVar.getPage().aBk() > 0) {
                                this.guN.endLoadData();
                                this.guN.setText(getString(R.string.pb_load_more_without_point));
                                this.guN.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.iPD = false;
                    break;
                case 5:
                    this.gsQ.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable coR2 = ah.coQ().coR();
                        if (coR2 instanceof RecyclerView.SavedState) {
                            this.gsQ.onRestoreInstanceState(coR2);
                            break;
                        }
                    }
                    this.gsQ.setSelection(0);
                    break;
                case 8:
                    int size = (this.gsQ.getData() == null && eVar.ckw() == null) ? 0 : this.gsQ.getData().size() - eVar.ckw().size();
                    this.jah.setMaxOffset();
                    this.gsQ.setSelection(i3 > 0 ? size + i3 : 0);
                    this.guN.endLoadData();
                    this.guN.setText(getString(R.string.pb_load_more_without_point));
                    this.guN.setLineGone();
                    break;
            }
            if (this.iPe) {
                cpe();
                this.iPe = false;
                if (i4 == 0) {
                    qf(true);
                }
            }
            cnh().q(eVar);
        }
    }

    public void ctE() {
        com.baidu.tieba.pb.data.e pbData = clB().getPbData();
        if (pbData != null) {
            this.jaf.qT(clB().cnz());
            this.jaf.setData(pbData);
            this.jaf.notifyDataSetChanged();
            ArrayList<PostData> ckw = pbData.ckw();
            if (pbData.getPage().aBk() == 0 || ckw == null || ckw.size() < pbData.getPage().aBj()) {
                if (v.getCount(ckw) == 0 || (v.getCount(ckw) == 1 && ckw.get(0) != null && ckw.get(0).cLa() == 1)) {
                    if (cnc()) {
                        this.guN.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.guN.ac(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().aBk() == 0) {
                        this.guN.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.guN.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.guN.aHH();
                }
            }
            cnh().q(pbData);
        }
    }

    public PbActivity cni() {
        return this.iHb != null ? this.iHb : cnh().cni();
    }

    public VideoPbFragment cnh() {
        if (this.iZY == null && this.iHb != null) {
            Fragment clN = this.iHb.clN();
            if (clN instanceof VideoPbFragment) {
                this.iZY = (VideoPbFragment) clN;
            }
        }
        return this.iZY;
    }

    public PbModel clB() {
        return cnh().clB();
    }

    public BdTypeRecyclerView getListView() {
        return this.gsQ;
    }

    public boolean cnc() {
        if (clB() != null) {
            return clB().getHostMode();
        }
        return false;
    }

    public c ctF() {
        return this.jaf;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, eVar, str, i4);
        }
    }

    public b ctG() {
        return this.jag;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0584a
    public void pO(boolean z) {
        this.iHK = z;
    }

    public void qj(boolean z) {
        if (z && this.iOH) {
            this.guN.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.gsQ.setNextPage(this.guN);
            this.iNJ = 2;
        }
    }

    public void cpG() {
        this.guN.setLineVisible();
        this.guN.startLoadData();
    }

    public void endLoadData() {
        if (this.guN != null) {
            this.guN.setLineGone();
            this.guN.endLoadData();
        }
        if (cnh() != null && cnh().iYF != null) {
            this.iZY.iYF.bqr();
        }
    }

    public void Gc(String str) {
        if (this.guN != null) {
            this.guN.setText(str);
        }
    }

    public void Gd(String str) {
        if (this.guN != null) {
            this.guN.ac(str, this.topMargin);
        }
    }

    public void cpI() {
        if (this.ent != null && this.ent.isEnabled()) {
            this.ent.setRefreshing(false);
        }
    }

    public void cqd() {
        if (this.iNJ != 2) {
            this.gsQ.setNextPage(this.guN);
            this.iNJ = 2;
        }
    }

    public void qf(boolean z) {
        this.iPe = z;
    }

    public void cpe() {
        if (this.gsQ == null) {
        }
    }

    public int cpJ() {
        if (this.gsQ != null) {
            return this.gsQ.getFirstVisiblePosition();
        }
        return 0;
    }

    public int ctH() {
        View childAt;
        if (this.gsQ == null || this.gsQ.getCount() <= 0 || (childAt = this.gsQ.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int cpK() {
        if (this.gsQ != null) {
            int lastVisiblePosition = this.gsQ.getLastVisiblePosition();
            if (clB() != null && clB().getPbData() != null && lastVisiblePosition >= clB().getPbData().ckw().size()) {
                return clB().getPbData().ckw().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View cpU() {
        return this.dCN;
    }

    public int ctD() {
        return this.jab;
    }

    public int ctI() {
        return this.jal;
    }

    public void zv(int i) {
        if (this.jai != null) {
            this.jai.setVisibility(i);
        }
    }

    public void qY(boolean z) {
        if (this.gsQ != null) {
            this.gsQ.setCanFling(z);
        }
    }

    public void cu(int i, int i2) {
        if (this.gsQ != null && this.gsQ.getLayoutManager() != null && (this.gsQ.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.gsQ.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }
}
