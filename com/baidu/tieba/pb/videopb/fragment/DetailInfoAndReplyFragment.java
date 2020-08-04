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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.videopb.MultiNestedLayout;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.a.b;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0726a {
    private BdSwipeRefreshLayout fuP;
    private BdTypeRecyclerView hKL;
    private VideoPbFragment kHG;
    private b kHI;
    private com.baidu.tieba.pb.videopb.b.b kHJ;
    private MultiNestedLayout kHK;
    private View kHL;
    private com.baidu.tieba.pb.videopb.videoView.b kHM;
    private View kHN;
    private PbActivity knE;
    private boolean koo;
    private View mRootView;
    private int topMargin;
    private PbListView hMG = null;
    private View eGt = null;
    private com.baidu.tieba.pb.view.a kvs = null;
    private boolean kvY = false;
    private boolean kwv = false;
    private boolean kwV = true;
    private int kuX = 0;
    private g mPullView = null;
    private boolean kkQ = false;
    private int kHO = 0;
    private int kHP = 0;
    private RecyclerView.OnScrollListener gPJ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                DetailInfoAndReplyFragment.this.cNs().cPA();
                DetailInfoAndReplyFragment.this.cNs().cTp();
            }
            if (DetailInfoAndReplyFragment.this.cNs() != null) {
                DetailInfoAndReplyFragment.this.cNs().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                DetailInfoAndReplyFragment.this.kHO = 2;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoAndReplyFragment.this.kHO != 0) {
                DetailInfoAndReplyFragment.this.kHL.setVisibility(8);
            }
            DetailInfoAndReplyFragment.this.kHO = 0;
        }
    };
    private MultiNestedLayout.b kHQ = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void onStateChange(int i) {
            if (DetailInfoAndReplyFragment.this.kHP != 1 || i == 1 || DetailInfoAndReplyFragment.this.kHO == 0) {
                if (DetailInfoAndReplyFragment.this.kHP != 0 || i == 0) {
                    if (DetailInfoAndReplyFragment.this.kHP != 0 && i == 0) {
                        DetailInfoAndReplyFragment.this.cNs().Ct(8);
                    }
                } else if (DetailInfoAndReplyFragment.this.kHL.getVisibility() != 0) {
                    DetailInfoAndReplyFragment.this.cNs().Ct(0);
                }
            } else {
                DetailInfoAndReplyFragment.this.cNs().Ct(8);
                DetailInfoAndReplyFragment.this.kHL.setVisibility(0);
            }
            DetailInfoAndReplyFragment.this.kHP = i;
        }
    };
    private final f.c ejc = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (DetailInfoAndReplyFragment.this.cLP() != null && DetailInfoAndReplyFragment.this.cLP().sx(true)) {
                TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                DetailInfoAndReplyFragment.this.cPY();
            }
        }
    };
    private CustomMessageListener hYZ = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && DetailInfoAndReplyFragment.this.cLP() != null && DetailInfoAndReplyFragment.this.cLP().getPbData() != null && DetailInfoAndReplyFragment.this.cLP().getPbData().cKz() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = DetailInfoAndReplyFragment.this.cLP().getPbData().cKz().iterator();
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
                    if (nVar != null && DetailInfoAndReplyFragment.this.kHI != null && DetailInfoAndReplyFragment.this.hKL != null) {
                        DetailInfoAndReplyFragment.this.cLP().getPbData().cKz().remove(nVar);
                        if (DetailInfoAndReplyFragment.this.kHI.getDataList() != null) {
                            DetailInfoAndReplyFragment.this.kHI.getDataList().remove(nVar);
                        }
                        if (DetailInfoAndReplyFragment.this.hKL.getListView2().getData() != null) {
                            DetailInfoAndReplyFragment.this.hKL.getListView2().getData().remove(nVar);
                        }
                        DetailInfoAndReplyFragment.this.kHI.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e kpo = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (DetailInfoAndReplyFragment.this.mIsLogin) {
                if (DetailInfoAndReplyFragment.this.cLP().sw(false)) {
                    DetailInfoAndReplyFragment.this.cPW();
                    if (DetailInfoAndReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (DetailInfoAndReplyFragment.this.cLP().getPbData() != null) {
                    DetailInfoAndReplyFragment.this.cQt();
                }
            }
        }
    };

    public static DetailInfoAndReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
        detailInfoAndReplyFragment.setArguments(bundle);
        detailInfoAndReplyFragment.kHG = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.knE = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.kHJ = new com.baidu.tieba.pb.videopb.b.b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.hYZ);
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.kHK = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.kHK.setScrollStateChangeListener(this.kHQ);
        this.hKL = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.hKL.setLayoutManager(new LinearLayoutManager(getContext()));
        this.kHI = new b(this, this.hKL);
        this.kHI.E(cNs().cTa());
        this.kHI.R(cNs().cTb());
        this.kHI.setOnLongClickListener(cNs().cTc());
        this.kHI.setOnImageClickListener(this.kHJ.getOnImageClickListener());
        this.kHI.setTbGestureDetector(this.kHJ.cTQ());
        this.kHL = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.hMG = new PbListView(getPageContext().getPageActivity());
        this.eGt = this.hMG.getView().findViewById(R.id.pb_more_view);
        if (this.eGt != null) {
            this.eGt.setOnClickListener(cNs().cTa());
            ao.setBackgroundResource(this.eGt, R.drawable.pb_foot_more_trans_selector);
        }
        this.hMG.setLineVisible();
        this.hMG.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.hMG.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.hMG.bbZ();
        this.hKL.setOnSrollToBottomListener(this.kpo);
        this.hKL.addOnScrollListener(this.gPJ);
        this.hKL.setOnTouchListener(cNs().bmU());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.ejc);
        }
        if (this.fuP == null) {
            this.fuP = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.fuP.setProgressView(this.mPullView);
            this.fuP.setEnabled(false);
            ao.setBackgroundColor(this.fuP, R.color.cp_bg_line_e);
        }
        this.kHN = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.kHN.setVisibility(8);
        this.kHM = new com.baidu.tieba.pb.videopb.videoView.b(this.kHN);
        this.kHM.W(cNs().cTa());
        this.kHM.setOnSwitchChangeListener(cNs().kpg);
        this.kHI.setOnSwitchChangeListener(cNs().kpg);
        registerListener(this.hYZ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e eVar = (e) y.b(cNt()).l(e.class);
        eVar.cTH().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: n */
            public void onChanged(@Nullable Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    DetailInfoAndReplyFragment.this.showLoadingView();
                } else {
                    DetailInfoAndReplyFragment.this.hideLoadingView();
                }
            }
        });
        d(true, 0, 3, 0, eVar.cTy(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hMG != null) {
            this.hMG.changeSkin(i);
            if (this.eGt != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.eGt);
                ao.setBackgroundResource(this.eGt, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.kHM != null) {
            this.kHM.onChangeSkinType(i);
        }
        if (this.kHI != null) {
            this.kHI.notifyDataSetChanged();
        }
        if (this.kHL != null) {
            ao.setBackgroundResource(this.kHL, R.drawable.personalize_tab_shadow);
        }
        ao.setBackgroundColor(this.fuP, R.color.cp_bg_line_d);
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
        this.koo = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        sL(z);
        if (cNs() != null && cNs().kGf != null) {
            this.kHG.kGf.cTO();
        }
        if (z && this.koo) {
            cPW();
            cLP().sw(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        e eVar = (e) y.b(cNt()).l(e.class);
        if (z && cLP() != null && fVar != null) {
            this.kkQ = cLP().cNN();
            boolean isEnabled = this.fuP.isEnabled();
            if (fVar.getPage().aVc() == 0 && this.kkQ) {
                this.fuP.setEnabled(false);
            } else if (!isEnabled) {
                this.fuP.setEnabled(true);
                this.fuP.interruptRefresh();
            }
            this.kHI.setIsFromCDN(eVar.isFromCDN());
            this.kHI.tv(this.kkQ);
            this.kHI.setData(fVar);
            this.kvY = false;
            if (TbadkCoreApplication.isLogin()) {
                this.hKL.setNextPage(this.hMG);
                this.kuX = 2;
                if (cNs() != null && cNs().kGf != null) {
                    this.kHG.kGf.bMt();
                }
            } else {
                this.kvY = true;
                if (fVar.getPage().aVb() == 1) {
                    if (this.kvs == null) {
                        this.kvs = new com.baidu.tieba.pb.view.a(this, this);
                        this.kvs.createView();
                        this.kvs.bbZ();
                    }
                    this.hKL.setNextPage(this.kvs);
                } else {
                    this.hKL.setNextPage(this.hMG);
                }
                this.kuX = 3;
            }
            if (this.kHM != null && this.kHN != null) {
                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kiG);
                bv cKx = fVar.cKx();
                nVar.kiI = cKx != null ? cKx.aWc() : 0L;
                nVar.isNew = !cLP().cNN();
                nVar.kiL = cNn();
                nVar.sortType = fVar.khp;
                nVar.kiK = fVar.cLb();
                nVar.isDynamic = fVar.cLa();
                nVar.kiM = fVar.kho;
                this.kHM.a(nVar);
            }
            ArrayList<PostData> cKz = fVar.cKz();
            if (fVar.getPage().aVb() == 0 || cKz == null || cKz.size() < fVar.getPage().aVa()) {
                if (fVar.getPage().aVb() == 0) {
                    this.hMG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.hMG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.hMG.bca();
                if (fVar.getPage().aVb() == 0 || cKz == null) {
                    cQt();
                }
            } else {
                if (cLP().getIsFromMark()) {
                    if (this.kwV) {
                        endLoadData();
                        if (fVar.getPage().aVb() != 0) {
                            this.hMG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.hMG.setLineVisible();
                        this.hMG.showLoading();
                    }
                } else {
                    this.hMG.setLineVisible();
                    this.hMG.showLoading();
                }
                this.hMG.bca();
            }
            switch (i2) {
                case 2:
                    this.hKL.setSelection(i3 > 1 ? (((this.hKL.getData() == null && fVar.cKz() == null) ? 0 : this.hKL.getData().size() - fVar.cKz().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable cPh = as.cPg().cPh();
                        if (cPh instanceof RecyclerView.SavedState) {
                            this.hKL.onRestoreInstanceState(cPh);
                            if (x.getCount(cKz) > 1 && fVar.getPage().aVb() > 0) {
                                this.hMG.endLoadData();
                                this.hMG.setText(getString(R.string.pb_load_more_without_point));
                                this.hMG.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.kwV = false;
                    break;
                case 5:
                    this.hKL.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable cPh2 = as.cPg().cPh();
                        if (cPh2 instanceof RecyclerView.SavedState) {
                            this.hKL.onRestoreInstanceState(cPh2);
                            break;
                        }
                    }
                    this.hKL.setSelection(0);
                    break;
                case 8:
                    int size = (this.hKL.getData() == null && fVar.cKz() == null) ? 0 : this.hKL.getData().size() - fVar.cKz().size();
                    this.kHK.setMaxOffset();
                    this.hKL.setSelection(i3 > 0 ? size + i3 : 0);
                    this.hMG.endLoadData();
                    this.hMG.setText(getString(R.string.pb_load_more_without_point));
                    this.hMG.setLineGone();
                    break;
            }
            if (this.kwv) {
                cPu();
                this.kwv = false;
                if (i4 == 0) {
                    sH(true);
                }
            }
            cNs().u(fVar);
            if (this.hMG != null) {
                if (fVar.getPage().aVb() == 0) {
                    this.hMG.setVisibility(8);
                } else {
                    this.hMG.setVisibility(0);
                }
            }
        }
    }

    public void cTS() {
        com.baidu.tieba.pb.data.f pbData = cLP().getPbData();
        if (pbData != null) {
            this.kHI.tv(cLP().cNN());
            this.kHI.setData(pbData);
            this.kHI.notifyDataSetChanged();
            ArrayList<PostData> cKz = pbData.cKz();
            if (pbData.getPage().aVb() == 0 || cKz == null || cKz.size() < pbData.getPage().aVa()) {
                if (x.getCount(cKz) == 0 || (x.getCount(cKz) == 1 && cKz.get(0) != null && cKz.get(0).dli() == 1)) {
                    if (cNn()) {
                        this.hMG.am(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.hMG.am(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().aVb() == 0) {
                        this.hMG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.hMG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.hMG.bca();
                }
            }
            cNs().u(pbData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity cNt() {
        return this.knE != null ? this.knE : cNs().cNt();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment cNs() {
        if (this.kHG == null && this.knE != null) {
            Fragment cMb = this.knE.cMb();
            if (cMb instanceof VideoPbFragment) {
                this.kHG = (VideoPbFragment) cMb;
            }
        }
        return this.kHG;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel cLP() {
        return cNs().cLP();
    }

    public BdTypeRecyclerView getListView() {
        return this.hKL;
    }

    public boolean cNn() {
        if (cLP() != null) {
            return cLP().getHostMode();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: cTT */
    public b cTR() {
        return this.kHI;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, fVar, str, i4);
        }
    }

    public com.baidu.tieba.pb.videopb.b.b cTU() {
        return this.kHJ;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0726a
    public void sp(boolean z) {
        this.koo = z;
    }

    public void sL(boolean z) {
        if (z && this.kvY) {
            this.hMG.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.hKL.setNextPage(this.hMG);
            this.kuX = 2;
        }
    }

    public void cPW() {
        this.hMG.setLineVisible();
        this.hMG.startLoadData();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, true));
    }

    public void endLoadData() {
        if (this.hMG != null) {
            this.hMG.setLineGone();
            this.hMG.endLoadData();
        }
        if (cNs() != null && cNs().kGf != null) {
            this.kHG.kGf.bMt();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, false));
    }

    public void KO(String str) {
        if (this.hMG != null) {
            this.hMG.setText(str);
        }
    }

    public void KP(String str) {
        if (this.hMG != null) {
            this.hMG.am(str, this.topMargin);
        }
    }

    public void cPY() {
        if (this.fuP != null && this.fuP.isEnabled()) {
            this.fuP.setRefreshing(false);
        }
    }

    public void cQt() {
        if (this.kuX != 2) {
            this.hKL.setNextPage(this.hMG);
            this.kuX = 2;
        }
    }

    public void sH(boolean z) {
        this.kwv = z;
    }

    public void cPu() {
        if (this.hKL == null) {
        }
    }

    public int cPZ() {
        if (this.hKL != null) {
            return this.hKL.getFirstVisiblePosition();
        }
        return 0;
    }

    public int cTV() {
        View childAt;
        if (this.hKL == null || this.hKL.getCount() <= 0 || (childAt = this.hKL.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int cQa() {
        if (this.hKL != null) {
            int lastVisiblePosition = this.hKL.getLastVisiblePosition();
            if (cLP() != null && cLP().getPbData() != null && lastVisiblePosition >= cLP().getPbData().cKz().size()) {
                return cLP().getPbData().cKz().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View cQk() {
        return this.eGt;
    }

    public int cTW() {
        return this.kHO;
    }

    public int cTX() {
        return this.kHP;
    }

    public void Ct(int i) {
        if (this.kHL != null) {
            this.kHL.setVisibility(i);
        }
    }

    public void tA(boolean z) {
        if (this.hKL != null) {
            this.hKL.setCanFling(z);
        }
    }

    public void cP(int i, int i2) {
        if (this.hKL != null && this.hKL.getLayoutManager() != null && (this.hKL.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.hKL.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }
}
