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
import com.baidu.tieba.tbadkCore.data.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class ReplyFragment extends BaseFragment implements a, a.InterfaceC0698a {
    private BdSwipeRefreshLayout feu;
    private BdTypeRecyclerView hrX;
    private boolean jLM;
    private PbActivity jLc;
    private VideoPbFragment keQ;
    private c keX;
    private b keY;
    private MultiNestedLayout keZ;
    private View kfa;
    private com.baidu.tieba.pb.videopb.videoView.b kfb;
    private View kfc;
    private View mRootView;
    private int topMargin;
    private PbListView htT = null;
    private View erl = null;
    private com.baidu.tieba.pb.view.a jSD = null;
    private boolean jTj = false;
    private boolean jTG = false;
    private boolean jUf = true;
    private int jSi = 0;
    private g mPullView = null;
    private boolean jIC = false;
    private int keT = 0;
    private int kfd = 0;
    private RecyclerView.OnScrollListener gxp = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.cFr().cHw();
                ReplyFragment.this.cFr().cLj();
            }
            if (ReplyFragment.this.cFr() != null) {
                ReplyFragment.this.cFr().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.keT = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.keT != 0) {
                ReplyFragment.this.kfa.setVisibility(8);
            }
            ReplyFragment.this.keT = 0;
        }
    };
    private MultiNestedLayout.b kfe = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void onStateChange(int i) {
            if (ReplyFragment.this.kfd != 1 || i == 1 || ReplyFragment.this.keT == 0) {
                if (ReplyFragment.this.kfd != 0 || i == 0) {
                    if (ReplyFragment.this.kfd != 0 && i == 0) {
                        ReplyFragment.this.cFr().AR(8);
                    }
                } else if (ReplyFragment.this.kfa.getVisibility() != 0) {
                    ReplyFragment.this.cFr().AR(0);
                }
            } else {
                ReplyFragment.this.cFr().AR(8);
                ReplyFragment.this.kfa.setVisibility(0);
            }
            ReplyFragment.this.kfd = i;
        }
    };
    private final f.c dVt = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.cDO() != null && ReplyFragment.this.cDO().rF(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.cHU();
            }
        }
    };
    private CustomMessageListener hFL = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && ReplyFragment.this.cDO() != null && ReplyFragment.this.cDO().getPbData() != null && ReplyFragment.this.cDO().getPbData().cCA() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = ReplyFragment.this.cDO().getPbData().cCA().iterator();
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
                    if (nVar != null && ReplyFragment.this.keX != null && ReplyFragment.this.hrX != null) {
                        ReplyFragment.this.cDO().getPbData().cCA().remove(nVar);
                        if (ReplyFragment.this.keX.getDataList() != null) {
                            ReplyFragment.this.keX.getDataList().remove(nVar);
                        }
                        if (ReplyFragment.this.hrX.getListView2().getData() != null) {
                            ReplyFragment.this.hrX.getListView2().getData().remove(nVar);
                        }
                        ReplyFragment.this.keX.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e jMK = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (ReplyFragment.this.cDO().rE(false)) {
                    ReplyFragment.this.cHS();
                    if (ReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (ReplyFragment.this.cDO().getPbData() != null) {
                    ReplyFragment.this.cIp();
                }
            }
        }
    };

    public static ReplyFragment ab(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.keQ = videoPbFragment;
        return replyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.jLc = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.keY = new b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.hFL);
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.keZ = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.keZ.setScrollStateChangeListener(this.kfe);
        this.hrX = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.hrX.setLayoutManager(new LinearLayoutManager(getContext()));
        this.keX = new c(this, this.hrX);
        this.keX.D(cFr().cKV());
        this.keX.Q(cFr().cKW());
        this.keX.setOnLongClickListener(cFr().cKX());
        this.keX.setOnImageClickListener(this.keY.getOnImageClickListener());
        this.keX.setTbGestureDetector(this.keY.cLK());
        this.kfa = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.htT = new PbListView(getPageContext().getPageActivity());
        this.erl = this.htT.getView().findViewById(R.id.pb_more_view);
        if (this.erl != null) {
            this.erl.setOnClickListener(cFr().cKV());
            am.setBackgroundResource(this.erl, R.drawable.pb_foot_more_trans_selector);
        }
        this.htT.setLineVisible();
        this.htT.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.htT.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.htT.aWf();
        this.hrX.setOnSrollToBottomListener(this.jMK);
        this.hrX.addOnScrollListener(this.gxp);
        this.hrX.setOnTouchListener(cFr().bgN());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.dVt);
        }
        if (this.feu == null) {
            this.feu = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.feu.setProgressView(this.mPullView);
            this.feu.setEnabled(false);
            am.setBackgroundColor(this.feu, R.color.cp_bg_line_e);
        }
        this.kfc = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.kfb = new com.baidu.tieba.pb.videopb.videoView.b(this.kfc);
        this.kfb.U(cFr().cKV());
        this.kfb.setOnSwitchChangeListener(cFr().jMC);
        registerListener(this.hFL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e eVar = (e) y.b(cFs()).l(e.class);
        eVar.cLB().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
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
        d(true, 0, 3, 0, eVar.cLs(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.htT != null) {
            this.htT.changeSkin(i);
            if (this.erl != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.erl);
                am.setBackgroundResource(this.erl, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.kfb != null) {
            this.kfb.onChangeSkinType(i);
        }
        if (this.keX != null) {
            this.keX.notifyDataSetChanged();
        }
        if (this.kfa != null) {
            am.setBackgroundResource(this.kfa, R.drawable.personalize_tab_shadow);
        }
        am.setBackgroundColor(this.feu, R.color.cp_bg_line_d);
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
        this.jLM = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        rS(z);
        if (cFr() != null && cFr().kdw != null) {
            this.keQ.kdw.cLI();
        }
        if (z && this.jLM) {
            cHS();
            cDO().rE(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        e eVar2 = (e) y.b(cFs()).l(e.class);
        if (z && cDO() != null && eVar != null) {
            this.jIC = cDO().cFL();
            boolean isEnabled = this.feu.isEnabled();
            if (eVar.getPage().aPu() == 0 && this.jIC) {
                this.feu.setEnabled(false);
            } else if (!isEnabled) {
                this.feu.setEnabled(true);
                this.feu.interruptRefresh();
            }
            this.keX.setIsFromCDN(eVar2.isFromCDN());
            this.keX.sB(this.jIC);
            this.keX.setData(eVar);
            this.jTj = false;
            if (TbadkCoreApplication.isLogin()) {
                this.hrX.setNextPage(this.htT);
                this.jSi = 2;
                if (cFr() != null && cFr().kdw != null) {
                    this.keQ.kdw.bGh();
                }
            } else {
                this.jTj = true;
                if (eVar.getPage().aPt() == 1) {
                    if (this.jSD == null) {
                        this.jSD = new com.baidu.tieba.pb.view.a(this, this);
                        this.jSD.createView();
                        this.jSD.aWf();
                    }
                    this.hrX.setNextPage(this.jSD);
                } else {
                    this.hrX.setNextPage(this.htT);
                }
                this.jSi = 3;
            }
            if (this.kfb != null && this.kfc != null) {
                com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l(com.baidu.tieba.pb.data.l.jGo);
                bk cCy = eVar.cCy();
                lVar.jGq = cCy != null ? cCy.aQo() : 0L;
                lVar.isNew = !cDO().cFL();
                lVar.jGt = cFm();
                lVar.sortType = eVar.jFc;
                lVar.jGs = eVar.cDa();
                lVar.isDynamic = eVar.cCZ();
                lVar.jGu = eVar.jFb;
                this.kfb.a(lVar);
            }
            ArrayList<PostData> cCA = eVar.cCA();
            if (eVar.getPage().aPt() == 0 || cCA == null || cCA.size() < eVar.getPage().aPs()) {
                if (v.getCount(cCA) == 0 || (v.getCount(cCA) == 1 && cCA.get(0) != null && cCA.get(0).ddJ() == 1)) {
                    if (cFm()) {
                        this.htT.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.htT.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (eVar.getPage().aPt() == 0) {
                        this.htT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.htT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.htT.aWg();
                }
                if (eVar.getPage().aPt() == 0 || cCA == null) {
                    cIp();
                }
            } else {
                if (cDO().getIsFromMark()) {
                    if (this.jUf) {
                        endLoadData();
                        if (eVar.getPage().aPt() != 0) {
                            this.htT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.htT.setLineVisible();
                        this.htT.showLoading();
                    }
                } else {
                    this.htT.setLineVisible();
                    this.htT.showLoading();
                }
                this.htT.aWg();
            }
            switch (i2) {
                case 2:
                    this.hrX.setSelection(i3 > 1 ? (((this.hrX.getData() == null && eVar.cCA() == null) ? 0 : this.hrX.getData().size() - eVar.cCA().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable cHd = ao.cHc().cHd();
                        if (cHd instanceof RecyclerView.SavedState) {
                            this.hrX.onRestoreInstanceState(cHd);
                            if (v.getCount(cCA) > 1 && eVar.getPage().aPt() > 0) {
                                this.htT.endLoadData();
                                this.htT.setText(getString(R.string.pb_load_more_without_point));
                                this.htT.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.jUf = false;
                    break;
                case 5:
                    this.hrX.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable cHd2 = ao.cHc().cHd();
                        if (cHd2 instanceof RecyclerView.SavedState) {
                            this.hrX.onRestoreInstanceState(cHd2);
                            break;
                        }
                    }
                    this.hrX.setSelection(0);
                    break;
                case 8:
                    int size = (this.hrX.getData() == null && eVar.cCA() == null) ? 0 : this.hrX.getData().size() - eVar.cCA().size();
                    this.keZ.setMaxOffset();
                    this.hrX.setSelection(i3 > 0 ? size + i3 : 0);
                    this.htT.endLoadData();
                    this.htT.setText(getString(R.string.pb_load_more_without_point));
                    this.htT.setLineGone();
                    break;
            }
            if (this.jTG) {
                cHq();
                this.jTG = false;
                if (i4 == 0) {
                    rO(true);
                }
            }
            cFr().t(eVar);
        }
    }

    public void cLR() {
        com.baidu.tieba.pb.data.e pbData = cDO().getPbData();
        if (pbData != null) {
            this.keX.sB(cDO().cFL());
            this.keX.setData(pbData);
            this.keX.notifyDataSetChanged();
            ArrayList<PostData> cCA = pbData.cCA();
            if (pbData.getPage().aPt() == 0 || cCA == null || cCA.size() < pbData.getPage().aPs()) {
                if (v.getCount(cCA) == 0 || (v.getCount(cCA) == 1 && cCA.get(0) != null && cCA.get(0).ddJ() == 1)) {
                    if (cFm()) {
                        this.htT.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.htT.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().aPt() == 0) {
                        this.htT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.htT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.htT.aWg();
                }
            }
            cFr().t(pbData);
        }
    }

    public PbActivity cFs() {
        return this.jLc != null ? this.jLc : cFr().cFs();
    }

    public VideoPbFragment cFr() {
        if (this.keQ == null && this.jLc != null) {
            Fragment cEa = this.jLc.cEa();
            if (cEa instanceof VideoPbFragment) {
                this.keQ = (VideoPbFragment) cEa;
            }
        }
        return this.keQ;
    }

    public PbModel cDO() {
        return cFr().cDO();
    }

    public BdTypeRecyclerView getListView() {
        return this.hrX;
    }

    public boolean cFm() {
        if (cDO() != null) {
            return cDO().getHostMode();
        }
        return false;
    }

    public c cLS() {
        return this.keX;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, eVar, str, i4);
        }
    }

    public b cLT() {
        return this.keY;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0698a
    public void rx(boolean z) {
        this.jLM = z;
    }

    public void rS(boolean z) {
        if (z && this.jTj) {
            this.htT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.hrX.setNextPage(this.htT);
            this.jSi = 2;
        }
    }

    public void cHS() {
        this.htT.setLineVisible();
        this.htT.startLoadData();
    }

    public void endLoadData() {
        if (this.htT != null) {
            this.htT.setLineGone();
            this.htT.endLoadData();
        }
        if (cFr() != null && cFr().kdw != null) {
            this.keQ.kdw.bGh();
        }
    }

    public void Jz(String str) {
        if (this.htT != null) {
            this.htT.setText(str);
        }
    }

    public void JA(String str) {
        if (this.htT != null) {
            this.htT.al(str, this.topMargin);
        }
    }

    public void cHU() {
        if (this.feu != null && this.feu.isEnabled()) {
            this.feu.setRefreshing(false);
        }
    }

    public void cIp() {
        if (this.jSi != 2) {
            this.hrX.setNextPage(this.htT);
            this.jSi = 2;
        }
    }

    public void rO(boolean z) {
        this.jTG = z;
    }

    public void cHq() {
        if (this.hrX == null) {
        }
    }

    public int cHV() {
        if (this.hrX != null) {
            return this.hrX.getFirstVisiblePosition();
        }
        return 0;
    }

    public int cLU() {
        View childAt;
        if (this.hrX == null || this.hrX.getCount() <= 0 || (childAt = this.hrX.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int cHW() {
        if (this.hrX != null) {
            int lastVisiblePosition = this.hrX.getLastVisiblePosition();
            if (cDO() != null && cDO().getPbData() != null && lastVisiblePosition >= cDO().getPbData().cCA().size()) {
                return cDO().getPbData().cCA().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View cIg() {
        return this.erl;
    }

    public int cLQ() {
        return this.keT;
    }

    public int cLV() {
        return this.kfd;
    }

    public void AR(int i) {
        if (this.kfa != null) {
            this.kfa.setVisibility(i);
        }
    }

    public void sG(boolean z) {
        if (this.hrX != null) {
            this.hrX.setCanFling(z);
        }
    }

    public void cG(int i, int i2) {
        if (this.hrX != null && this.hrX.getLayoutManager() != null && (this.hrX.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.hrX.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }
}
