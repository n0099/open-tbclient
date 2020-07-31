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
    private VideoPbFragment kHE;
    private b kHG;
    private com.baidu.tieba.pb.videopb.b.b kHH;
    private MultiNestedLayout kHI;
    private View kHJ;
    private com.baidu.tieba.pb.videopb.videoView.b kHK;
    private View kHL;
    private PbActivity knC;
    private boolean kom;
    private View mRootView;
    private int topMargin;
    private PbListView hME = null;
    private View eGt = null;
    private com.baidu.tieba.pb.view.a kvq = null;
    private boolean kvW = false;
    private boolean kwt = false;
    private boolean kwT = true;
    private int kuV = 0;
    private g mPullView = null;
    private boolean kkO = false;
    private int kHM = 0;
    private int kHN = 0;
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
                DetailInfoAndReplyFragment.this.kHM = 2;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoAndReplyFragment.this.kHM != 0) {
                DetailInfoAndReplyFragment.this.kHJ.setVisibility(8);
            }
            DetailInfoAndReplyFragment.this.kHM = 0;
        }
    };
    private MultiNestedLayout.b kHO = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void onStateChange(int i) {
            if (DetailInfoAndReplyFragment.this.kHN != 1 || i == 1 || DetailInfoAndReplyFragment.this.kHM == 0) {
                if (DetailInfoAndReplyFragment.this.kHN != 0 || i == 0) {
                    if (DetailInfoAndReplyFragment.this.kHN != 0 && i == 0) {
                        DetailInfoAndReplyFragment.this.cNs().Ct(8);
                    }
                } else if (DetailInfoAndReplyFragment.this.kHJ.getVisibility() != 0) {
                    DetailInfoAndReplyFragment.this.cNs().Ct(0);
                }
            } else {
                DetailInfoAndReplyFragment.this.cNs().Ct(8);
                DetailInfoAndReplyFragment.this.kHJ.setVisibility(0);
            }
            DetailInfoAndReplyFragment.this.kHN = i;
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
    private CustomMessageListener hYX = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.4
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
                    if (nVar != null && DetailInfoAndReplyFragment.this.kHG != null && DetailInfoAndReplyFragment.this.hKL != null) {
                        DetailInfoAndReplyFragment.this.cLP().getPbData().cKz().remove(nVar);
                        if (DetailInfoAndReplyFragment.this.kHG.getDataList() != null) {
                            DetailInfoAndReplyFragment.this.kHG.getDataList().remove(nVar);
                        }
                        if (DetailInfoAndReplyFragment.this.hKL.getListView2().getData() != null) {
                            DetailInfoAndReplyFragment.this.hKL.getListView2().getData().remove(nVar);
                        }
                        DetailInfoAndReplyFragment.this.kHG.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e kpm = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.6
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
        detailInfoAndReplyFragment.kHE = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.knC = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.kHH = new com.baidu.tieba.pb.videopb.b.b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.hYX);
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.kHI = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.kHI.setScrollStateChangeListener(this.kHO);
        this.hKL = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.hKL.setLayoutManager(new LinearLayoutManager(getContext()));
        this.kHG = new b(this, this.hKL);
        this.kHG.E(cNs().cTa());
        this.kHG.R(cNs().cTb());
        this.kHG.setOnLongClickListener(cNs().cTc());
        this.kHG.setOnImageClickListener(this.kHH.getOnImageClickListener());
        this.kHG.setTbGestureDetector(this.kHH.cTQ());
        this.kHJ = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.hME = new PbListView(getPageContext().getPageActivity());
        this.eGt = this.hME.getView().findViewById(R.id.pb_more_view);
        if (this.eGt != null) {
            this.eGt.setOnClickListener(cNs().cTa());
            ao.setBackgroundResource(this.eGt, R.drawable.pb_foot_more_trans_selector);
        }
        this.hME.setLineVisible();
        this.hME.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.hME.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.hME.bbZ();
        this.hKL.setOnSrollToBottomListener(this.kpm);
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
        this.kHL = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.kHL.setVisibility(8);
        this.kHK = new com.baidu.tieba.pb.videopb.videoView.b(this.kHL);
        this.kHK.W(cNs().cTa());
        this.kHK.setOnSwitchChangeListener(cNs().kpe);
        this.kHG.setOnSwitchChangeListener(cNs().kpe);
        registerListener(this.hYX);
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
        if (this.hME != null) {
            this.hME.changeSkin(i);
            if (this.eGt != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.eGt);
                ao.setBackgroundResource(this.eGt, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.kHK != null) {
            this.kHK.onChangeSkinType(i);
        }
        if (this.kHG != null) {
            this.kHG.notifyDataSetChanged();
        }
        if (this.kHJ != null) {
            ao.setBackgroundResource(this.kHJ, R.drawable.personalize_tab_shadow);
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
        this.kom = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        sL(z);
        if (cNs() != null && cNs().kGd != null) {
            this.kHE.kGd.cTO();
        }
        if (z && this.kom) {
            cPW();
            cLP().sw(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        e eVar = (e) y.b(cNt()).l(e.class);
        if (z && cLP() != null && fVar != null) {
            this.kkO = cLP().cNN();
            boolean isEnabled = this.fuP.isEnabled();
            if (fVar.getPage().aVc() == 0 && this.kkO) {
                this.fuP.setEnabled(false);
            } else if (!isEnabled) {
                this.fuP.setEnabled(true);
                this.fuP.interruptRefresh();
            }
            this.kHG.setIsFromCDN(eVar.isFromCDN());
            this.kHG.tv(this.kkO);
            this.kHG.setData(fVar);
            this.kvW = false;
            if (TbadkCoreApplication.isLogin()) {
                this.hKL.setNextPage(this.hME);
                this.kuV = 2;
                if (cNs() != null && cNs().kGd != null) {
                    this.kHE.kGd.bMt();
                }
            } else {
                this.kvW = true;
                if (fVar.getPage().aVb() == 1) {
                    if (this.kvq == null) {
                        this.kvq = new com.baidu.tieba.pb.view.a(this, this);
                        this.kvq.createView();
                        this.kvq.bbZ();
                    }
                    this.hKL.setNextPage(this.kvq);
                } else {
                    this.hKL.setNextPage(this.hME);
                }
                this.kuV = 3;
            }
            if (this.kHK != null && this.kHL != null) {
                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kiE);
                bv cKx = fVar.cKx();
                nVar.kiG = cKx != null ? cKx.aWc() : 0L;
                nVar.isNew = !cLP().cNN();
                nVar.kiJ = cNn();
                nVar.sortType = fVar.khn;
                nVar.kiI = fVar.cLb();
                nVar.isDynamic = fVar.cLa();
                nVar.kiK = fVar.khm;
                this.kHK.a(nVar);
            }
            ArrayList<PostData> cKz = fVar.cKz();
            if (fVar.getPage().aVb() == 0 || cKz == null || cKz.size() < fVar.getPage().aVa()) {
                if (fVar.getPage().aVb() == 0) {
                    this.hME.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.hME.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.hME.bca();
                if (fVar.getPage().aVb() == 0 || cKz == null) {
                    cQt();
                }
            } else {
                if (cLP().getIsFromMark()) {
                    if (this.kwT) {
                        endLoadData();
                        if (fVar.getPage().aVb() != 0) {
                            this.hME.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.hME.setLineVisible();
                        this.hME.showLoading();
                    }
                } else {
                    this.hME.setLineVisible();
                    this.hME.showLoading();
                }
                this.hME.bca();
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
                                this.hME.endLoadData();
                                this.hME.setText(getString(R.string.pb_load_more_without_point));
                                this.hME.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.kwT = false;
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
                    this.kHI.setMaxOffset();
                    this.hKL.setSelection(i3 > 0 ? size + i3 : 0);
                    this.hME.endLoadData();
                    this.hME.setText(getString(R.string.pb_load_more_without_point));
                    this.hME.setLineGone();
                    break;
            }
            if (this.kwt) {
                cPu();
                this.kwt = false;
                if (i4 == 0) {
                    sH(true);
                }
            }
            cNs().u(fVar);
            if (this.hME != null) {
                if (fVar.getPage().aVb() == 0) {
                    this.hME.setVisibility(8);
                } else {
                    this.hME.setVisibility(0);
                }
            }
        }
    }

    public void cTS() {
        com.baidu.tieba.pb.data.f pbData = cLP().getPbData();
        if (pbData != null) {
            this.kHG.tv(cLP().cNN());
            this.kHG.setData(pbData);
            this.kHG.notifyDataSetChanged();
            ArrayList<PostData> cKz = pbData.cKz();
            if (pbData.getPage().aVb() == 0 || cKz == null || cKz.size() < pbData.getPage().aVa()) {
                if (x.getCount(cKz) == 0 || (x.getCount(cKz) == 1 && cKz.get(0) != null && cKz.get(0).dlh() == 1)) {
                    if (cNn()) {
                        this.hME.am(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.hME.am(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().aVb() == 0) {
                        this.hME.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.hME.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.hME.bca();
                }
            }
            cNs().u(pbData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity cNt() {
        return this.knC != null ? this.knC : cNs().cNt();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment cNs() {
        if (this.kHE == null && this.knC != null) {
            Fragment cMb = this.knC.cMb();
            if (cMb instanceof VideoPbFragment) {
                this.kHE = (VideoPbFragment) cMb;
            }
        }
        return this.kHE;
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
        return this.kHG;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, fVar, str, i4);
        }
    }

    public com.baidu.tieba.pb.videopb.b.b cTU() {
        return this.kHH;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0726a
    public void sp(boolean z) {
        this.kom = z;
    }

    public void sL(boolean z) {
        if (z && this.kvW) {
            this.hME.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.hKL.setNextPage(this.hME);
            this.kuV = 2;
        }
    }

    public void cPW() {
        this.hME.setLineVisible();
        this.hME.startLoadData();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, true));
    }

    public void endLoadData() {
        if (this.hME != null) {
            this.hME.setLineGone();
            this.hME.endLoadData();
        }
        if (cNs() != null && cNs().kGd != null) {
            this.kHE.kGd.bMt();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, false));
    }

    public void KO(String str) {
        if (this.hME != null) {
            this.hME.setText(str);
        }
    }

    public void KP(String str) {
        if (this.hME != null) {
            this.hME.am(str, this.topMargin);
        }
    }

    public void cPY() {
        if (this.fuP != null && this.fuP.isEnabled()) {
            this.fuP.setRefreshing(false);
        }
    }

    public void cQt() {
        if (this.kuV != 2) {
            this.hKL.setNextPage(this.hME);
            this.kuV = 2;
        }
    }

    public void sH(boolean z) {
        this.kwt = z;
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
        return this.kHM;
    }

    public int cTX() {
        return this.kHN;
    }

    public void Ct(int i) {
        if (this.kHJ != null) {
            this.kHJ.setVisibility(i);
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
