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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ao;
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
public class ReplyFragment extends BaseFragment implements a, a.InterfaceC0697a {
    private BdSwipeRefreshLayout fej;
    private BdTypeRecyclerView hrM;
    private PbActivity jJW;
    private boolean jKG;
    private VideoPbFragment kdJ;
    private c kdQ;
    private b kdR;
    private MultiNestedLayout kdS;
    private View kdT;
    private com.baidu.tieba.pb.videopb.videoView.b kdU;
    private View kdV;
    private View mRootView;
    private int topMargin;
    private PbListView htI = null;
    private View erl = null;
    private com.baidu.tieba.pb.view.a jRx = null;
    private boolean jSd = false;
    private boolean jSA = false;
    private boolean jSZ = true;
    private int jRc = 0;
    private g mPullView = null;
    private boolean jHw = false;
    private int kdM = 0;
    private int kdW = 0;
    private RecyclerView.OnScrollListener gxe = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.cFb().cHg();
                ReplyFragment.this.cFb().cKT();
            }
            if (ReplyFragment.this.cFb() != null) {
                ReplyFragment.this.cFb().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.kdM = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.kdM != 0) {
                ReplyFragment.this.kdT.setVisibility(8);
            }
            ReplyFragment.this.kdM = 0;
        }
    };
    private MultiNestedLayout.b kdX = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void onStateChange(int i) {
            if (ReplyFragment.this.kdW != 1 || i == 1 || ReplyFragment.this.kdM == 0) {
                if (ReplyFragment.this.kdW != 0 || i == 0) {
                    if (ReplyFragment.this.kdW != 0 && i == 0) {
                        ReplyFragment.this.cFb().AP(8);
                    }
                } else if (ReplyFragment.this.kdT.getVisibility() != 0) {
                    ReplyFragment.this.cFb().AP(0);
                }
            } else {
                ReplyFragment.this.cFb().AP(8);
                ReplyFragment.this.kdT.setVisibility(0);
            }
            ReplyFragment.this.kdW = i;
        }
    };
    private final f.c dVt = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.cDy() != null && ReplyFragment.this.cDy().rF(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.cHE();
            }
        }
    };
    private final BdListView.e jLE = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (ReplyFragment.this.cDy().rE(false)) {
                    ReplyFragment.this.cHC();
                    if (ReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (ReplyFragment.this.cDy().getPbData() != null) {
                    ReplyFragment.this.cHZ();
                }
            }
        }
    };

    public static ReplyFragment ab(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.kdJ = videoPbFragment;
        return replyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.jJW = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.kdR = new b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.kdS = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.kdS.setScrollStateChangeListener(this.kdX);
        this.hrM = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.hrM.setLayoutManager(new LinearLayoutManager(getContext()));
        this.kdQ = new c(this, this.hrM);
        this.kdQ.D(cFb().cKF());
        this.kdQ.Q(cFb().cKG());
        this.kdQ.setOnLongClickListener(cFb().cKH());
        this.kdQ.setOnImageClickListener(this.kdR.getOnImageClickListener());
        this.kdQ.setTbGestureDetector(this.kdR.cLu());
        this.kdT = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.htI = new PbListView(getPageContext().getPageActivity());
        this.erl = this.htI.getView().findViewById(R.id.pb_more_view);
        if (this.erl != null) {
            this.erl.setOnClickListener(cFb().cKF());
            am.setBackgroundResource(this.erl, R.drawable.pb_foot_more_trans_selector);
        }
        this.htI.setLineVisible();
        this.htI.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.htI.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.htI.aWe();
        this.hrM.setOnSrollToBottomListener(this.jLE);
        this.hrM.addOnScrollListener(this.gxe);
        this.hrM.setOnTouchListener(cFb().bgM());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.dVt);
        }
        if (this.fej == null) {
            this.fej = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.fej.setProgressView(this.mPullView);
            this.fej.setEnabled(false);
            am.setBackgroundColor(this.fej, R.color.cp_bg_line_e);
        }
        this.kdV = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.kdU = new com.baidu.tieba.pb.videopb.videoView.b(this.kdV);
        this.kdU.U(cFb().cKF());
        this.kdU.setOnSwitchChangeListener(cFb().jLw);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e eVar = (e) y.b(cFc()).l(e.class);
        eVar.cLl().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
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
        d(true, 0, 3, 0, eVar.cLc(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.htI != null) {
            this.htI.changeSkin(i);
            if (this.erl != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.erl);
                am.setBackgroundResource(this.erl, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.kdU != null) {
            this.kdU.onChangeSkinType(i);
        }
        if (this.kdQ != null) {
            this.kdQ.notifyDataSetChanged();
        }
        if (this.kdT != null) {
            am.setBackgroundResource(this.kdT, R.drawable.personalize_tab_shadow);
        }
        am.setBackgroundColor(this.fej, R.color.cp_bg_line_d);
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
        this.jKG = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        rS(z);
        if (cFb() != null && cFb().kcq != null) {
            this.kdJ.kcq.cLs();
        }
        if (z && this.jKG) {
            cHC();
            cDy().rE(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        e eVar2 = (e) y.b(cFc()).l(e.class);
        if (z && cDy() != null && eVar != null) {
            this.jHw = cDy().cFv();
            boolean isEnabled = this.fej.isEnabled();
            if (eVar.getPage().aPu() == 0 && this.jHw) {
                this.fej.setEnabled(false);
            } else if (!isEnabled) {
                this.fej.setEnabled(true);
                this.fej.interruptRefresh();
            }
            this.kdQ.setIsFromCDN(eVar2.isFromCDN());
            this.kdQ.sB(this.jHw);
            this.kdQ.setData(eVar);
            this.jSd = false;
            if (TbadkCoreApplication.isLogin()) {
                this.hrM.setNextPage(this.htI);
                this.jRc = 2;
                if (cFb() != null && cFb().kcq != null) {
                    this.kdJ.kcq.bGf();
                }
            } else {
                this.jSd = true;
                if (eVar.getPage().aPt() == 1) {
                    if (this.jRx == null) {
                        this.jRx = new com.baidu.tieba.pb.view.a(this, this);
                        this.jRx.createView();
                        this.jRx.aWe();
                    }
                    this.hrM.setNextPage(this.jRx);
                } else {
                    this.hrM.setNextPage(this.htI);
                }
                this.jRc = 3;
            }
            if (this.kdU != null && this.kdV != null) {
                com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l(com.baidu.tieba.pb.data.l.jFi);
                bk cCi = eVar.cCi();
                lVar.jFk = cCi != null ? cCi.aQo() : 0L;
                lVar.isNew = !cDy().cFv();
                lVar.jFn = cEW();
                lVar.sortType = eVar.jDW;
                lVar.jFm = eVar.cCK();
                lVar.isDynamic = eVar.cCJ();
                lVar.jFo = eVar.jDV;
                this.kdU.a(lVar);
            }
            ArrayList<PostData> cCk = eVar.cCk();
            if (eVar.getPage().aPt() == 0 || cCk == null || cCk.size() < eVar.getPage().aPs()) {
                if (v.getCount(cCk) == 0 || (v.getCount(cCk) == 1 && cCk.get(0) != null && cCk.get(0).ddu() == 1)) {
                    if (cEW()) {
                        this.htI.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.htI.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (eVar.getPage().aPt() == 0) {
                        this.htI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.htI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.htI.aWf();
                }
                if (eVar.getPage().aPt() == 0 || cCk == null) {
                    cHZ();
                }
            } else {
                if (cDy().getIsFromMark()) {
                    if (this.jSZ) {
                        endLoadData();
                        if (eVar.getPage().aPt() != 0) {
                            this.htI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.htI.setLineVisible();
                        this.htI.showLoading();
                    }
                } else {
                    this.htI.setLineVisible();
                    this.htI.showLoading();
                }
                this.htI.aWf();
            }
            switch (i2) {
                case 2:
                    this.hrM.setSelection(i3 > 1 ? (((this.hrM.getData() == null && eVar.cCk() == null) ? 0 : this.hrM.getData().size() - eVar.cCk().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable cGN = ao.cGM().cGN();
                        if (cGN instanceof RecyclerView.SavedState) {
                            this.hrM.onRestoreInstanceState(cGN);
                            if (v.getCount(cCk) > 1 && eVar.getPage().aPt() > 0) {
                                this.htI.endLoadData();
                                this.htI.setText(getString(R.string.pb_load_more_without_point));
                                this.htI.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.jSZ = false;
                    break;
                case 5:
                    this.hrM.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable cGN2 = ao.cGM().cGN();
                        if (cGN2 instanceof RecyclerView.SavedState) {
                            this.hrM.onRestoreInstanceState(cGN2);
                            break;
                        }
                    }
                    this.hrM.setSelection(0);
                    break;
                case 8:
                    int size = (this.hrM.getData() == null && eVar.cCk() == null) ? 0 : this.hrM.getData().size() - eVar.cCk().size();
                    this.kdS.setMaxOffset();
                    this.hrM.setSelection(i3 > 0 ? size + i3 : 0);
                    this.htI.endLoadData();
                    this.htI.setText(getString(R.string.pb_load_more_without_point));
                    this.htI.setLineGone();
                    break;
            }
            if (this.jSA) {
                cHa();
                this.jSA = false;
                if (i4 == 0) {
                    rO(true);
                }
            }
            cFb().t(eVar);
        }
    }

    public void cLB() {
        com.baidu.tieba.pb.data.e pbData = cDy().getPbData();
        if (pbData != null) {
            this.kdQ.sB(cDy().cFv());
            this.kdQ.setData(pbData);
            this.kdQ.notifyDataSetChanged();
            ArrayList<PostData> cCk = pbData.cCk();
            if (pbData.getPage().aPt() == 0 || cCk == null || cCk.size() < pbData.getPage().aPs()) {
                if (v.getCount(cCk) == 0 || (v.getCount(cCk) == 1 && cCk.get(0) != null && cCk.get(0).ddu() == 1)) {
                    if (cEW()) {
                        this.htI.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.htI.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().aPt() == 0) {
                        this.htI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.htI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.htI.aWf();
                }
            }
            cFb().t(pbData);
        }
    }

    public PbActivity cFc() {
        return this.jJW != null ? this.jJW : cFb().cFc();
    }

    public VideoPbFragment cFb() {
        if (this.kdJ == null && this.jJW != null) {
            Fragment cDK = this.jJW.cDK();
            if (cDK instanceof VideoPbFragment) {
                this.kdJ = (VideoPbFragment) cDK;
            }
        }
        return this.kdJ;
    }

    public PbModel cDy() {
        return cFb().cDy();
    }

    public BdTypeRecyclerView getListView() {
        return this.hrM;
    }

    public boolean cEW() {
        if (cDy() != null) {
            return cDy().getHostMode();
        }
        return false;
    }

    public c cLC() {
        return this.kdQ;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, eVar, str, i4);
        }
    }

    public b cLD() {
        return this.kdR;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0697a
    public void rx(boolean z) {
        this.jKG = z;
    }

    public void rS(boolean z) {
        if (z && this.jSd) {
            this.htI.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.hrM.setNextPage(this.htI);
            this.jRc = 2;
        }
    }

    public void cHC() {
        this.htI.setLineVisible();
        this.htI.startLoadData();
    }

    public void endLoadData() {
        if (this.htI != null) {
            this.htI.setLineGone();
            this.htI.endLoadData();
        }
        if (cFb() != null && cFb().kcq != null) {
            this.kdJ.kcq.bGf();
        }
    }

    public void Jy(String str) {
        if (this.htI != null) {
            this.htI.setText(str);
        }
    }

    public void Jz(String str) {
        if (this.htI != null) {
            this.htI.al(str, this.topMargin);
        }
    }

    public void cHE() {
        if (this.fej != null && this.fej.isEnabled()) {
            this.fej.setRefreshing(false);
        }
    }

    public void cHZ() {
        if (this.jRc != 2) {
            this.hrM.setNextPage(this.htI);
            this.jRc = 2;
        }
    }

    public void rO(boolean z) {
        this.jSA = z;
    }

    public void cHa() {
        if (this.hrM == null) {
        }
    }

    public int cHF() {
        if (this.hrM != null) {
            return this.hrM.getFirstVisiblePosition();
        }
        return 0;
    }

    public int cLE() {
        View childAt;
        if (this.hrM == null || this.hrM.getCount() <= 0 || (childAt = this.hrM.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int cHG() {
        if (this.hrM != null) {
            int lastVisiblePosition = this.hrM.getLastVisiblePosition();
            if (cDy() != null && cDy().getPbData() != null && lastVisiblePosition >= cDy().getPbData().cCk().size()) {
                return cDy().getPbData().cCk().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View cHQ() {
        return this.erl;
    }

    public int cLA() {
        return this.kdM;
    }

    public int cLF() {
        return this.kdW;
    }

    public void AP(int i) {
        if (this.kdT != null) {
            this.kdT.setVisibility(i);
        }
    }

    public void sG(boolean z) {
        if (this.hrM != null) {
            this.hrM.setCanFling(z);
        }
    }

    public void cG(int i, int i2) {
        if (this.hrM != null && this.hrM.getLayoutManager() != null && (this.hrM.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.hrM.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }
}
