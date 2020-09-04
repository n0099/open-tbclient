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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.pb.pb.main.l;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.b.b;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0777a {
    private LinearLayoutManager dCG;
    private BdSwipeRefreshLayout fGm;
    private BdTypeRecyclerView hYW;
    private boolean kDM;
    private PbActivity kDc;
    private b kXA;
    private View kXB;
    private LinearLayout kXC;
    private au kXD;
    private l kXE;
    private VideoPbFragment kXx;
    private com.baidu.tieba.pb.videopb.a.b kXz;
    private View mRootView;
    private int topMargin;
    private PbListView iaR = null;
    private View eRd = null;
    private com.baidu.tieba.pb.view.a kLe = null;
    private boolean kLK = false;
    private boolean kMh = false;
    private boolean kMH = true;
    private int kKJ = 0;
    private g mPullView = null;
    private boolean kAp = false;
    private int kXF = 0;
    private int kXG = 0;
    private RecyclerView.OnScrollListener hcD = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                DetailInfoAndReplyFragment.this.cYi().dar();
                DetailInfoAndReplyFragment.this.cYi().dei();
            }
            if (DetailInfoAndReplyFragment.this.cYi() != null) {
                DetailInfoAndReplyFragment.this.cYi().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            DetailInfoAndReplyFragment.this.deV();
            if (recyclerView.canScrollVertically(-1)) {
                DetailInfoAndReplyFragment.this.kXF = 2;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoAndReplyFragment.this.kXF != 0) {
                DetailInfoAndReplyFragment.this.kXB.setVisibility(8);
            }
            DetailInfoAndReplyFragment.this.kXF = 0;
        }
    };
    private final f.c eta = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (DetailInfoAndReplyFragment.this.cWE() != null && DetailInfoAndReplyFragment.this.cWE().ti(true)) {
                TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                DetailInfoAndReplyFragment.this.daP();
            }
        }
    };
    private CustomMessageListener inn = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && DetailInfoAndReplyFragment.this.cWE() != null && DetailInfoAndReplyFragment.this.cWE().getPbData() != null && DetailInfoAndReplyFragment.this.cWE().getPbData().cVo() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = DetailInfoAndReplyFragment.this.cWE().getPbData().cVo().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            nVar = null;
                            break;
                        }
                        PostData next = it.next();
                        if ((next instanceof n) && str.equals(((n) next).getAdId())) {
                            nVar = (n) next;
                            break;
                        }
                    }
                    if (nVar != null && DetailInfoAndReplyFragment.this.kXz != null && DetailInfoAndReplyFragment.this.hYW != null) {
                        DetailInfoAndReplyFragment.this.cWE().getPbData().cVo().remove(nVar);
                        if (DetailInfoAndReplyFragment.this.kXz.getDataList() != null) {
                            DetailInfoAndReplyFragment.this.kXz.getDataList().remove(nVar);
                        }
                        if (DetailInfoAndReplyFragment.this.hYW.getListView2().getData() != null) {
                            DetailInfoAndReplyFragment.this.hYW.getListView2().getData().remove(nVar);
                        }
                        DetailInfoAndReplyFragment.this.kXz.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e kEN = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (DetailInfoAndReplyFragment.this.mIsLogin) {
                if (DetailInfoAndReplyFragment.this.cWE().th(false)) {
                    DetailInfoAndReplyFragment.this.daN();
                    if (DetailInfoAndReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (DetailInfoAndReplyFragment.this.cWE().getPbData() != null) {
                    DetailInfoAndReplyFragment.this.dbk();
                }
            }
        }
    };

    public static DetailInfoAndReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
        detailInfoAndReplyFragment.setArguments(bundle);
        detailInfoAndReplyFragment.kXx = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.kDc = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.kXA = new b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.inn);
    }

    private void initUI() {
        this.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.hYW = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.dCG = new LinearLayoutManager(getContext());
        this.hYW.setLayoutManager(this.dCG);
        this.kXz = new com.baidu.tieba.pb.videopb.a.b(this, this.hYW);
        this.kXz.F(cYi().ddT());
        this.kXz.S(cYi().ddU());
        this.kXz.setOnLongClickListener(cYi().ddV());
        this.kXz.setOnImageClickListener(this.kXA.getOnImageClickListener());
        this.kXz.setTbGestureDetector(this.kXA.deM());
        this.kXB = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.iaR = new PbListView(getPageContext().getPageActivity());
        this.eRd = this.iaR.getView().findViewById(R.id.pb_more_view);
        if (this.eRd != null) {
            this.eRd.setOnClickListener(cYi().ddT());
            ap.setBackgroundResource(this.eRd, R.drawable.pb_foot_more_trans_selector);
        }
        this.iaR.setLineVisible();
        this.iaR.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.iaR.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.iaR.bkv();
        this.hYW.setOnSrollToBottomListener(this.kEN);
        this.hYW.addOnScrollListener(this.hcD);
        this.hYW.setOnTouchListener(cYi().bvI());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.eta);
        }
        if (this.fGm == null) {
            this.fGm = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.fGm.setProgressView(this.mPullView);
            this.fGm.setEnabled(false);
            ap.setBackgroundColor(this.fGm, R.color.cp_bg_line_e);
        }
        this.kXC = (LinearLayout) this.mRootView.findViewById(R.id.video_pb_suck_container);
        deO();
        this.kXz.setOnSwitchChangeListener(cYi().kEE);
        registerListener(this.inn);
    }

    private void deO() {
        this.kXD = new au(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
        this.kXD.Xz = false;
        this.kXD.U(cYi().ddT());
        this.kXD.setOnSwitchChangeListener(cYi().kEE);
        this.kXD.DX(8);
        this.kXC.addView(this.kXD.getRootView());
        this.kXE = new l(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
        e eVar = new e();
        eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
        this.kXE.a(eVar);
        this.kXE.DX(8);
        this.kXC.addView(this.kXE.getRootView());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        com.baidu.tieba.pb.videopb.e eVar = (com.baidu.tieba.pb.videopb.e) y.b(cYj()).l(com.baidu.tieba.pb.videopb.e.class);
        eVar.deA().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: p */
            public void onChanged(@Nullable Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    DetailInfoAndReplyFragment.this.showLoadingView();
                } else {
                    DetailInfoAndReplyFragment.this.hideLoadingView();
                }
            }
        });
        d(true, 0, 3, 0, eVar.der(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iaR != null) {
            this.iaR.changeSkin(i);
            if (this.eRd != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.eRd);
                ap.setBackgroundResource(this.eRd, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.kXD != null) {
            this.kXD.onChangeSkinType(i);
        }
        if (this.kXE != null) {
            this.kXE.onChangeSkinType();
        }
        if (this.kXz != null) {
            this.kXz.notifyDataSetChanged();
        }
        if (this.kXB != null) {
            ap.setBackgroundResource(this.kXB, R.drawable.personalize_tab_shadow);
        }
        ap.setBackgroundColor(this.fGm, R.color.cp_bg_line_d);
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
        this.kDM = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        tw(z);
        if (cYi() != null && cYi().kVT != null) {
            this.kXx.kVT.deK();
        }
        if (z && this.kDM) {
            daN();
            cWE().th(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        com.baidu.tieba.pb.videopb.e eVar = (com.baidu.tieba.pb.videopb.e) y.b(cYj()).l(com.baidu.tieba.pb.videopb.e.class);
        if (z && cWE() != null && fVar != null) {
            this.kAp = cWE().cYE();
            boolean isEnabled = this.fGm.isEnabled();
            if (fVar.getPage().bdv() == 0 && this.kAp) {
                this.fGm.setEnabled(false);
            } else if (!isEnabled) {
                this.fGm.setEnabled(true);
                this.fGm.interruptRefresh();
            }
            this.kXz.setIsFromCDN(eVar.isFromCDN());
            this.kXz.ug(this.kAp);
            this.kXz.setData(fVar);
            this.kLK = false;
            if (TbadkCoreApplication.isLogin()) {
                this.hYW.setNextPage(this.iaR);
                this.kKJ = 2;
                if (cYi() != null && cYi().kVT != null) {
                    this.kXx.kVT.bWr();
                }
            } else {
                this.kLK = true;
                if (fVar.getPage().bdu() == 1) {
                    if (this.kLe == null) {
                        this.kLe = new com.baidu.tieba.pb.view.a(this, this);
                        this.kLe.createView();
                        this.kLe.bkv();
                    }
                    this.hYW.setNextPage(this.kLe);
                } else {
                    this.hYW.setNextPage(this.iaR);
                }
                this.kKJ = 3;
            }
            if (this.kXD != null) {
                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kyf);
                bw cVm = fVar.cVm();
                nVar.kyh = cVm != null ? cVm.bev() : 0L;
                nVar.isNew = !cWE().cYE();
                nVar.kyk = cYc();
                nVar.sortType = fVar.kwP;
                nVar.kyj = fVar.cVQ();
                nVar.isDynamic = fVar.cVP();
                nVar.kyl = fVar.kwO;
                this.kXD.a(nVar);
            }
            ArrayList<PostData> cVo = fVar.cVo();
            if (fVar.getPage().bdu() == 0 || cVo == null || cVo.size() < fVar.getPage().bdt()) {
                if (fVar.getPage().bdu() == 0) {
                    this.iaR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.iaR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.iaR.bkw();
                if (fVar.getPage().bdu() == 0 || cVo == null) {
                    dbk();
                }
            } else {
                if (cWE().getIsFromMark()) {
                    if (this.kMH) {
                        endLoadData();
                        if (fVar.getPage().bdu() != 0) {
                            this.iaR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.iaR.setLineVisible();
                        this.iaR.showLoading();
                    }
                } else {
                    this.iaR.setLineVisible();
                    this.iaR.showLoading();
                }
                this.iaR.bkw();
            }
            switch (i2) {
                case 2:
                    this.hYW.setSelection(i3 > 1 ? (((this.hYW.getData() == null && fVar.cVo() == null) ? 0 : this.hYW.getData().size() - fVar.cVo().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable cZY = as.cZX().cZY();
                        if (cZY instanceof RecyclerView.SavedState) {
                            this.hYW.onRestoreInstanceState(cZY);
                            if (com.baidu.tbadk.core.util.y.getCount(cVo) > 1 && fVar.getPage().bdu() > 0) {
                                this.iaR.endLoadData();
                                this.iaR.setText(getString(R.string.pb_load_more_without_point));
                                this.iaR.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.kMH = false;
                    break;
                case 5:
                    this.hYW.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable cZY2 = as.cZX().cZY();
                        if (cZY2 instanceof RecyclerView.SavedState) {
                            this.hYW.onRestoreInstanceState(cZY2);
                            break;
                        }
                    }
                    this.hYW.setSelection(0);
                    break;
                case 8:
                    this.hYW.setSelection(i3 > 0 ? ((this.hYW.getData() == null && fVar.cVo() == null) ? 0 : this.hYW.getData().size() - fVar.cVo().size()) + i3 : 0);
                    this.iaR.endLoadData();
                    this.iaR.setText(getString(R.string.pb_load_more_without_point));
                    this.iaR.setLineGone();
                    break;
            }
            if (this.kMh) {
                dal();
                this.kMh = false;
                if (i4 == 0) {
                    ts(true);
                }
            }
            cYi().u(fVar);
            if (this.iaR != null) {
                if (fVar.getPage().bdu() == 0) {
                    this.iaR.setVisibility(8);
                } else {
                    this.iaR.setVisibility(0);
                }
            }
        }
    }

    public void deP() {
        com.baidu.tieba.pb.data.f pbData = cWE().getPbData();
        if (pbData != null) {
            this.kXz.ug(cWE().cYE());
            this.kXz.setData(pbData);
            this.kXz.notifyDataSetChanged();
            ArrayList<PostData> cVo = pbData.cVo();
            if (pbData.getPage().bdu() == 0 || cVo == null || cVo.size() < pbData.getPage().bdt()) {
                if (com.baidu.tbadk.core.util.y.getCount(cVo) == 0 || (com.baidu.tbadk.core.util.y.getCount(cVo) == 1 && cVo.get(0) != null && cVo.get(0).dwK() == 1)) {
                    if (cYc()) {
                        this.iaR.an(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.iaR.an(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().bdu() == 0) {
                        this.iaR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.iaR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.iaR.bkw();
                }
            }
            cYi().u(pbData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity cYj() {
        return this.kDc != null ? this.kDc : cYi().cYj();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment cYi() {
        if (this.kXx == null && this.kDc != null) {
            Fragment cWQ = this.kDc.cWQ();
            if (cWQ instanceof VideoPbFragment) {
                this.kXx = (VideoPbFragment) cWQ;
            }
        }
        return this.kXx;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel cWE() {
        return cYi().cWE();
    }

    public BdTypeRecyclerView getListView() {
        return this.hYW;
    }

    public boolean cYc() {
        if (cWE() != null) {
            return cWE().getHostMode();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: deQ */
    public com.baidu.tieba.pb.videopb.a.b deN() {
        return this.kXz;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, fVar, str, i4);
        }
    }

    public b deR() {
        return this.kXA;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0777a
    public void sY(boolean z) {
        this.kDM = z;
    }

    public void tw(boolean z) {
        if (z && this.kLK) {
            this.iaR.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.hYW.setNextPage(this.iaR);
            this.kKJ = 2;
        }
    }

    public void daN() {
        this.iaR.setLineVisible();
        this.iaR.startLoadData();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, true));
    }

    public void endLoadData() {
        if (this.iaR != null) {
            this.iaR.setLineGone();
            this.iaR.endLoadData();
        }
        if (cYi() != null && cYi().kVT != null) {
            this.kXx.kVT.bWr();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, false));
    }

    public void NI(String str) {
        if (this.iaR != null) {
            this.iaR.setText(str);
        }
    }

    public void NJ(String str) {
        if (this.iaR != null) {
            this.iaR.an(str, this.topMargin);
        }
    }

    public void daP() {
        if (this.fGm != null && this.fGm.isEnabled()) {
            this.fGm.setRefreshing(false);
        }
    }

    public void dbk() {
        if (this.kKJ != 2) {
            this.hYW.setNextPage(this.iaR);
            this.kKJ = 2;
        }
    }

    public void ts(boolean z) {
        this.kMh = z;
    }

    public void dal() {
        if (this.hYW == null) {
        }
    }

    public int daQ() {
        if (this.hYW != null) {
            return this.hYW.getFirstVisiblePosition();
        }
        return 0;
    }

    public int deS() {
        View childAt;
        if (this.hYW == null || this.hYW.getCount() <= 0 || (childAt = this.hYW.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int daR() {
        if (this.hYW != null) {
            int lastVisiblePosition = this.hYW.getLastVisiblePosition();
            if (cWE() != null && cWE().getPbData() != null && lastVisiblePosition >= cWE().getPbData().cVo().size()) {
                return cWE().getPbData().cVo().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View dbb() {
        return this.eRd;
    }

    public int deT() {
        return this.kXF;
    }

    public int deU() {
        return this.kXG;
    }

    public void EN(int i) {
        if (this.kXB != null) {
            this.kXB.setVisibility(i);
        }
    }

    public void ul(boolean z) {
        if (this.hYW != null) {
            this.hYW.setCanFling(z);
        }
    }

    public void cX(int i, int i2) {
        if (this.hYW != null && this.hYW.getLayoutManager() != null && (this.hYW.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.hYW.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deV() {
        if (this.hYW != null && this.dCG != null && this.kXz != null) {
            int headerViewsCount = this.hYW.getHeaderViewsCount() + this.kXz.deI();
            int headerViewsCount2 = this.hYW.getHeaderViewsCount() + this.kXz.deJ();
            int findFirstVisibleItemPosition = this.dCG.findFirstVisibleItemPosition();
            if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
                this.kXD.DX(0);
            } else {
                this.kXD.DX(8);
            }
            if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
                this.kXE.DX(0);
                this.kXD.DX(8);
            } else {
                this.kXE.DX(8);
            }
            if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
                EN(0);
            } else {
                EN(8);
            }
        }
    }
}
