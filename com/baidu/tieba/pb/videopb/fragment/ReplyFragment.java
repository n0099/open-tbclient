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
public class ReplyFragment extends BaseFragment implements a, a.InterfaceC0644a {
    private BdSwipeRefreshLayout eRB;
    private BdTypeRecyclerView hcY;
    private VideoPbFragment jLW;
    private c jMd;
    private b jMe;
    private MultiNestedLayout jMf;
    private View jMg;
    private com.baidu.tieba.pb.videopb.videoView.b jMh;
    private View jMi;
    private PbActivity jsZ;
    private boolean jtI;
    private View mRootView;
    private int topMargin;
    private PbListView heU = null;
    private View ecZ = null;
    private com.baidu.tieba.pb.view.a jAe = null;
    private boolean jAH = false;
    private boolean jBe = false;
    private boolean jBD = true;
    private int jzJ = 0;
    private h mPullView = null;
    private boolean jqI = false;
    private int jLZ = 0;
    private int jMj = 0;
    private RecyclerView.OnScrollListener gio = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.cyh().cAk();
                ReplyFragment.this.cyh().cDW();
            }
            if (ReplyFragment.this.cyh() != null) {
                ReplyFragment.this.cyh().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.jLZ = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.jLZ != 0) {
                ReplyFragment.this.jMg.setVisibility(8);
            }
            ReplyFragment.this.jLZ = 0;
        }
    };
    private MultiNestedLayout.b jMk = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void onStateChange(int i) {
            if (ReplyFragment.this.jMj != 1 || i == 1 || ReplyFragment.this.jLZ == 0) {
                if (ReplyFragment.this.jMj != 0 || i == 0) {
                    if (ReplyFragment.this.jMj != 0 && i == 0) {
                        ReplyFragment.this.cyh().Ae(8);
                    }
                } else if (ReplyFragment.this.jMg.getVisibility() != 0) {
                    ReplyFragment.this.cyh().Ae(0);
                }
            } else {
                ReplyFragment.this.cyh().Ae(8);
                ReplyFragment.this.jMg.setVisibility(0);
            }
            ReplyFragment.this.jMj = i;
        }
    };
    private final g.c dHh = new g.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.cwB() != null && ReplyFragment.this.cwB().rg(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.cAI();
            }
        }
    };
    private final BdListView.e juF = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (ReplyFragment.this.cwB().rf(false)) {
                    ReplyFragment.this.cAG();
                    if (ReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (ReplyFragment.this.cwB().getPbData() != null) {
                    ReplyFragment.this.cBd();
                }
            }
        }
    };

    public static ReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.jLW = videoPbFragment;
        return replyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.jsZ = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.jMe = new b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jMf = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.jMf.setScrollStateChangeListener(this.jMk);
        this.hcY = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.hcY.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jMd = new c(this, this.hcY);
        this.jMd.E(cyh().cDI());
        this.jMd.Q(cyh().cDJ());
        this.jMd.setOnLongClickListener(cyh().cDK());
        this.jMd.setOnImageClickListener(this.jMe.getOnImageClickListener());
        this.jMd.setTbGestureDetector(this.jMe.cEx());
        this.jMg = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.heU = new PbListView(getPageContext().getPageActivity());
        this.ecZ = this.heU.getView().findViewById(R.id.pb_more_view);
        if (this.ecZ != null) {
            this.ecZ.setOnClickListener(cyh().cDI());
            am.setBackgroundResource(this.ecZ, R.drawable.pb_foot_more_trans_selector);
        }
        this.heU.setLineVisible();
        this.heU.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.heU.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.heU.aQa();
        this.hcY.setOnSrollToBottomListener(this.juF);
        this.hcY.addOnScrollListener(this.gio);
        this.hcY.setOnTouchListener(cyh().baB());
        if (this.mPullView == null) {
            this.mPullView = new h(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.dHh);
        }
        if (this.eRB == null) {
            this.eRB = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.eRB.setProgressView(this.mPullView);
            this.eRB.setEnabled(false);
            am.setBackgroundColor(this.eRB, R.color.cp_bg_line_e);
        }
        this.jMi = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.jMh = new com.baidu.tieba.pb.videopb.videoView.b(this.jMi);
        this.jMh.U(cyh().cDI());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e eVar = (e) y.b(cyi()).l(e.class);
        eVar.cEo().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
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
        d(true, 0, 3, 0, eVar.cEf(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.heU != null) {
            this.heU.changeSkin(i);
            if (this.ecZ != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.ecZ);
                am.setBackgroundResource(this.ecZ, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.jMh != null) {
            this.jMh.onChangeSkinType(i);
        }
        if (this.jMd != null) {
            this.jMd.notifyDataSetChanged();
        }
        if (this.jMg != null) {
            am.setBackgroundResource(this.jMg, R.drawable.personalize_tab_shadow);
        }
        am.setBackgroundColor(this.eRB, R.color.cp_bg_line_d);
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
        this.jtI = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        rt(z);
        if (cyh() != null && cyh().jKE != null) {
            this.jLW.jKE.cEv();
        }
        if (z && this.jtI) {
            cAG();
            cwB().rf(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        e eVar2 = (e) y.b(cyi()).l(e.class);
        if (z && cwB() != null && eVar != null) {
            this.jqI = cwB().cyz();
            boolean isEnabled = this.eRB.isEnabled();
            if (eVar.getPage().aJz() == 0 && this.jqI) {
                this.eRB.setEnabled(false);
            } else if (!isEnabled) {
                this.eRB.setEnabled(true);
                this.eRB.interruptRefresh();
            }
            this.jMd.setIsFromCDN(eVar2.isFromCDN());
            this.jMd.sd(this.jqI);
            this.jMd.setData(eVar);
            this.jAH = false;
            if (TbadkCoreApplication.isLogin()) {
                this.hcY.setNextPage(this.heU);
                this.jzJ = 2;
                if (cyh() != null && cyh().jKE != null) {
                    this.jLW.jKE.bzS();
                }
            } else {
                this.jAH = true;
                if (eVar.getPage().aJy() == 1) {
                    if (this.jAe == null) {
                        this.jAe = new com.baidu.tieba.pb.view.a(this, this);
                        this.jAe.createView();
                        this.jAe.aQa();
                    }
                    this.hcY.setNextPage(this.jAe);
                } else {
                    this.hcY.setNextPage(this.heU);
                }
                this.jzJ = 3;
            }
            if (this.jMh != null && this.jMi != null) {
                j jVar = new j(j.joA);
                bj cvs = eVar.cvs();
                jVar.joC = cvs != null ? cvs.aKt() : 0L;
                jVar.isNew = !cwB().cyz();
                jVar.joF = cyc();
                jVar.sortType = eVar.jnA;
                jVar.joE = eVar.cvR();
                jVar.isDynamic = eVar.cvQ();
                this.jMh.a(jVar);
            }
            ArrayList<PostData> cvu = eVar.cvu();
            if (eVar.getPage().aJy() == 0 || cvu == null || cvu.size() < eVar.getPage().aJx()) {
                if (v.getCount(cvu) == 0 || (v.getCount(cvu) == 1 && cvu.get(0) != null && cvu.get(0).cWp() == 1)) {
                    if (cyc()) {
                        this.heU.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.heU.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (eVar.getPage().aJy() == 0) {
                        this.heU.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.heU.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.heU.aQb();
                }
                if (eVar.getPage().aJy() == 0 || cvu == null) {
                    cBd();
                }
            } else {
                if (cwB().getIsFromMark()) {
                    if (this.jBD) {
                        endLoadData();
                        if (eVar.getPage().aJy() != 0) {
                            this.heU.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.heU.setLineVisible();
                        this.heU.showLoading();
                    }
                } else {
                    this.heU.setLineVisible();
                    this.heU.showLoading();
                }
                this.heU.aQb();
            }
            switch (i2) {
                case 2:
                    this.hcY.setSelection(i3 > 1 ? (((this.hcY.getData() == null && eVar.cvu() == null) ? 0 : this.hcY.getData().size() - eVar.cvu().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable czR = ah.czQ().czR();
                        if (czR instanceof RecyclerView.SavedState) {
                            this.hcY.onRestoreInstanceState(czR);
                            if (v.getCount(cvu) > 1 && eVar.getPage().aJy() > 0) {
                                this.heU.endLoadData();
                                this.heU.setText(getString(R.string.pb_load_more_without_point));
                                this.heU.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.jBD = false;
                    break;
                case 5:
                    this.hcY.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable czR2 = ah.czQ().czR();
                        if (czR2 instanceof RecyclerView.SavedState) {
                            this.hcY.onRestoreInstanceState(czR2);
                            break;
                        }
                    }
                    this.hcY.setSelection(0);
                    break;
                case 8:
                    int size = (this.hcY.getData() == null && eVar.cvu() == null) ? 0 : this.hcY.getData().size() - eVar.cvu().size();
                    this.jMf.setMaxOffset();
                    this.hcY.setSelection(i3 > 0 ? size + i3 : 0);
                    this.heU.endLoadData();
                    this.heU.setText(getString(R.string.pb_load_more_without_point));
                    this.heU.setLineGone();
                    break;
            }
            if (this.jBe) {
                cAe();
                this.jBe = false;
                if (i4 == 0) {
                    rp(true);
                }
            }
            cyh().q(eVar);
        }
    }

    public void cEE() {
        com.baidu.tieba.pb.data.e pbData = cwB().getPbData();
        if (pbData != null) {
            this.jMd.sd(cwB().cyz());
            this.jMd.setData(pbData);
            this.jMd.notifyDataSetChanged();
            ArrayList<PostData> cvu = pbData.cvu();
            if (pbData.getPage().aJy() == 0 || cvu == null || cvu.size() < pbData.getPage().aJx()) {
                if (v.getCount(cvu) == 0 || (v.getCount(cvu) == 1 && cvu.get(0) != null && cvu.get(0).cWp() == 1)) {
                    if (cyc()) {
                        this.heU.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.heU.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().aJy() == 0) {
                        this.heU.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.heU.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.heU.aQb();
                }
            }
            cyh().q(pbData);
        }
    }

    public PbActivity cyi() {
        return this.jsZ != null ? this.jsZ : cyh().cyi();
    }

    public VideoPbFragment cyh() {
        if (this.jLW == null && this.jsZ != null) {
            Fragment cwN = this.jsZ.cwN();
            if (cwN instanceof VideoPbFragment) {
                this.jLW = (VideoPbFragment) cwN;
            }
        }
        return this.jLW;
    }

    public PbModel cwB() {
        return cyh().cwB();
    }

    public BdTypeRecyclerView getListView() {
        return this.hcY;
    }

    public boolean cyc() {
        if (cwB() != null) {
            return cwB().getHostMode();
        }
        return false;
    }

    public c cEF() {
        return this.jMd;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, eVar, str, i4);
        }
    }

    public b cEG() {
        return this.jMe;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0644a
    public void qY(boolean z) {
        this.jtI = z;
    }

    public void rt(boolean z) {
        if (z && this.jAH) {
            this.heU.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.hcY.setNextPage(this.heU);
            this.jzJ = 2;
        }
    }

    public void cAG() {
        this.heU.setLineVisible();
        this.heU.startLoadData();
    }

    public void endLoadData() {
        if (this.heU != null) {
            this.heU.setLineGone();
            this.heU.endLoadData();
        }
        if (cyh() != null && cyh().jKE != null) {
            this.jLW.jKE.bzS();
        }
    }

    public void HN(String str) {
        if (this.heU != null) {
            this.heU.setText(str);
        }
    }

    public void HO(String str) {
        if (this.heU != null) {
            this.heU.ak(str, this.topMargin);
        }
    }

    public void cAI() {
        if (this.eRB != null && this.eRB.isEnabled()) {
            this.eRB.setRefreshing(false);
        }
    }

    public void cBd() {
        if (this.jzJ != 2) {
            this.hcY.setNextPage(this.heU);
            this.jzJ = 2;
        }
    }

    public void rp(boolean z) {
        this.jBe = z;
    }

    public void cAe() {
        if (this.hcY == null) {
        }
    }

    public int cAJ() {
        if (this.hcY != null) {
            return this.hcY.getFirstVisiblePosition();
        }
        return 0;
    }

    public int cEH() {
        View childAt;
        if (this.hcY == null || this.hcY.getCount() <= 0 || (childAt = this.hcY.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int cAK() {
        if (this.hcY != null) {
            int lastVisiblePosition = this.hcY.getLastVisiblePosition();
            if (cwB() != null && cwB().getPbData() != null && lastVisiblePosition >= cwB().getPbData().cvu().size()) {
                return cwB().getPbData().cvu().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View cAU() {
        return this.ecZ;
    }

    public int cED() {
        return this.jLZ;
    }

    public int cEI() {
        return this.jMj;
    }

    public void Ae(int i) {
        if (this.jMg != null) {
            this.jMg.setVisibility(i);
        }
    }

    public void si(boolean z) {
        if (this.hcY != null) {
            this.hcY.setCanFling(z);
        }
    }

    public void cB(int i, int i2) {
        if (this.hcY != null && this.hcY.getLayoutManager() != null && (this.hcY.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.hcY.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }
}
