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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
public class ReplyFragment extends BaseFragment implements a, a.InterfaceC0714a {
    private BdSwipeRefreshLayout fpF;
    private BdTypeRecyclerView hEN;
    private PbActivity keN;
    private boolean kfx;
    private VideoPbFragment kyE;
    private c kyL;
    private b kyM;
    private MultiNestedLayout kyN;
    private View kyO;
    private com.baidu.tieba.pb.videopb.videoView.b kyP;
    private View kyQ;
    private View mRootView;
    private int topMargin;
    private PbListView hGJ = null;
    private View eAd = null;
    private com.baidu.tieba.pb.view.a kmt = null;
    private boolean kmZ = false;
    private boolean knw = false;
    private boolean knV = true;
    private int klY = 0;
    private g mPullView = null;
    private boolean kcm = false;
    private int kyH = 0;
    private int kyR = 0;
    private RecyclerView.OnScrollListener gKd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.cJH().cLN();
                ReplyFragment.this.cJH().cPA();
            }
            if (ReplyFragment.this.cJH() != null) {
                ReplyFragment.this.cJH().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.kyH = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.kyH != 0) {
                ReplyFragment.this.kyO.setVisibility(8);
            }
            ReplyFragment.this.kyH = 0;
        }
    };
    private MultiNestedLayout.b kyS = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void onStateChange(int i) {
            if (ReplyFragment.this.kyR != 1 || i == 1 || ReplyFragment.this.kyH == 0) {
                if (ReplyFragment.this.kyR != 0 || i == 0) {
                    if (ReplyFragment.this.kyR != 0 && i == 0) {
                        ReplyFragment.this.cJH().BT(8);
                    }
                } else if (ReplyFragment.this.kyO.getVisibility() != 0) {
                    ReplyFragment.this.cJH().BT(0);
                }
            } else {
                ReplyFragment.this.cJH().BT(8);
                ReplyFragment.this.kyO.setVisibility(0);
            }
            ReplyFragment.this.kyR = i;
        }
    };
    private final f.c ecS = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.cIe() != null && ReplyFragment.this.cIe().rS(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.cMl();
            }
        }
    };
    private CustomMessageListener hSY = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && ReplyFragment.this.cIe() != null && ReplyFragment.this.cIe().getPbData() != null && ReplyFragment.this.cIe().getPbData().cGP() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = ReplyFragment.this.cIe().getPbData().cGP().iterator();
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
                    if (nVar != null && ReplyFragment.this.kyL != null && ReplyFragment.this.hEN != null) {
                        ReplyFragment.this.cIe().getPbData().cGP().remove(nVar);
                        if (ReplyFragment.this.kyL.getDataList() != null) {
                            ReplyFragment.this.kyL.getDataList().remove(nVar);
                        }
                        if (ReplyFragment.this.hEN.getListView2().getData() != null) {
                            ReplyFragment.this.hEN.getListView2().getData().remove(nVar);
                        }
                        ReplyFragment.this.kyL.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e kgv = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (ReplyFragment.this.cIe().rR(false)) {
                    ReplyFragment.this.cMj();
                    if (ReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (ReplyFragment.this.cIe().getPbData() != null) {
                    ReplyFragment.this.cMG();
                }
            }
        }
    };

    public static ReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.kyE = videoPbFragment;
        return replyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.keN = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.kyM = new b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.hSY);
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.kyN = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.kyN.setScrollStateChangeListener(this.kyS);
        this.hEN = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.hEN.setLayoutManager(new LinearLayoutManager(getContext()));
        this.kyL = new c(this, this.hEN);
        this.kyL.E(cJH().cPm());
        this.kyL.R(cJH().cPn());
        this.kyL.setOnLongClickListener(cJH().cPo());
        this.kyL.setOnImageClickListener(this.kyM.getOnImageClickListener());
        this.kyL.setTbGestureDetector(this.kyM.cQb());
        this.kyO = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.hGJ = new PbListView(getPageContext().getPageActivity());
        this.eAd = this.hGJ.getView().findViewById(R.id.pb_more_view);
        if (this.eAd != null) {
            this.eAd.setOnClickListener(cJH().cPm());
            an.setBackgroundResource(this.eAd, R.drawable.pb_foot_more_trans_selector);
        }
        this.hGJ.setLineVisible();
        this.hGJ.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.hGJ.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.hGJ.aXZ();
        this.hEN.setOnSrollToBottomListener(this.kgv);
        this.hEN.addOnScrollListener(this.gKd);
        this.hEN.setOnTouchListener(cJH().bja());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.ecS);
        }
        if (this.fpF == null) {
            this.fpF = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.fpF.setProgressView(this.mPullView);
            this.fpF.setEnabled(false);
            an.setBackgroundColor(this.fpF, R.color.cp_bg_line_e);
        }
        this.kyQ = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.kyP = new com.baidu.tieba.pb.videopb.videoView.b(this.kyQ);
        this.kyP.V(cJH().cPm());
        this.kyP.setOnSwitchChangeListener(cJH().kgn);
        registerListener(this.hSY);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e eVar = (e) y.b(cJI()).l(e.class);
        eVar.cPS().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
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
        d(true, 0, 3, 0, eVar.cPJ(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hGJ != null) {
            this.hGJ.changeSkin(i);
            if (this.eAd != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.eAd);
                an.setBackgroundResource(this.eAd, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.kyP != null) {
            this.kyP.onChangeSkinType(i);
        }
        if (this.kyL != null) {
            this.kyL.notifyDataSetChanged();
        }
        if (this.kyO != null) {
            an.setBackgroundResource(this.kyO, R.drawable.personalize_tab_shadow);
        }
        an.setBackgroundColor(this.fpF, R.color.cp_bg_line_d);
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
        this.kfx = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        sg(z);
        if (cJH() != null && cJH().kxj != null) {
            this.kyE.kxj.cPZ();
        }
        if (z && this.kfx) {
            cMj();
            cIe().rR(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        e eVar2 = (e) y.b(cJI()).l(e.class);
        if (z && cIe() != null && eVar != null) {
            this.kcm = cIe().cKb();
            boolean isEnabled = this.fpF.isEnabled();
            if (eVar.getPage().aRg() == 0 && this.kcm) {
                this.fpF.setEnabled(false);
            } else if (!isEnabled) {
                this.fpF.setEnabled(true);
                this.fpF.interruptRefresh();
            }
            this.kyL.setIsFromCDN(eVar2.isFromCDN());
            this.kyL.sP(this.kcm);
            this.kyL.setData(eVar);
            this.kmZ = false;
            if (TbadkCoreApplication.isLogin()) {
                this.hEN.setNextPage(this.hGJ);
                this.klY = 2;
                if (cJH() != null && cJH().kxj != null) {
                    this.kyE.kxj.bJm();
                }
            } else {
                this.kmZ = true;
                if (eVar.getPage().aRf() == 1) {
                    if (this.kmt == null) {
                        this.kmt = new com.baidu.tieba.pb.view.a(this, this);
                        this.kmt.createView();
                        this.kmt.aXZ();
                    }
                    this.hEN.setNextPage(this.kmt);
                } else {
                    this.hEN.setNextPage(this.hGJ);
                }
                this.klY = 3;
            }
            if (this.kyP != null && this.kyQ != null) {
                com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l(com.baidu.tieba.pb.data.l.jZY);
                bu cGN = eVar.cGN();
                lVar.kaa = cGN != null ? cGN.aSg() : 0L;
                lVar.isNew = !cIe().cKb();
                lVar.kad = cJC();
                lVar.sortType = eVar.jYM;
                lVar.kac = eVar.cHq();
                lVar.isDynamic = eVar.cHp();
                lVar.kae = eVar.jYL;
                this.kyP.a(lVar);
            }
            ArrayList<PostData> cGP = eVar.cGP();
            if (eVar.getPage().aRf() == 0 || cGP == null || cGP.size() < eVar.getPage().aRe()) {
                if (w.getCount(cGP) == 0 || (w.getCount(cGP) == 1 && cGP.get(0) != null && cGP.get(0).dhY() == 1)) {
                    if (cJC()) {
                        this.hGJ.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.hGJ.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (eVar.getPage().aRf() == 0) {
                        this.hGJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.hGJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.hGJ.aYa();
                }
                if (eVar.getPage().aRf() == 0 || cGP == null) {
                    cMG();
                }
            } else {
                if (cIe().getIsFromMark()) {
                    if (this.knV) {
                        endLoadData();
                        if (eVar.getPage().aRf() != 0) {
                            this.hGJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.hGJ.setLineVisible();
                        this.hGJ.showLoading();
                    }
                } else {
                    this.hGJ.setLineVisible();
                    this.hGJ.showLoading();
                }
                this.hGJ.aYa();
            }
            switch (i2) {
                case 2:
                    this.hEN.setSelection(i3 > 1 ? (((this.hEN.getData() == null && eVar.cGP() == null) ? 0 : this.hEN.getData().size() - eVar.cGP().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable cLu = ao.cLt().cLu();
                        if (cLu instanceof RecyclerView.SavedState) {
                            this.hEN.onRestoreInstanceState(cLu);
                            if (w.getCount(cGP) > 1 && eVar.getPage().aRf() > 0) {
                                this.hGJ.endLoadData();
                                this.hGJ.setText(getString(R.string.pb_load_more_without_point));
                                this.hGJ.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.knV = false;
                    break;
                case 5:
                    this.hEN.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable cLu2 = ao.cLt().cLu();
                        if (cLu2 instanceof RecyclerView.SavedState) {
                            this.hEN.onRestoreInstanceState(cLu2);
                            break;
                        }
                    }
                    this.hEN.setSelection(0);
                    break;
                case 8:
                    int size = (this.hEN.getData() == null && eVar.cGP() == null) ? 0 : this.hEN.getData().size() - eVar.cGP().size();
                    this.kyN.setMaxOffset();
                    this.hEN.setSelection(i3 > 0 ? size + i3 : 0);
                    this.hGJ.endLoadData();
                    this.hGJ.setText(getString(R.string.pb_load_more_without_point));
                    this.hGJ.setLineGone();
                    break;
            }
            if (this.knw) {
                cLH();
                this.knw = false;
                if (i4 == 0) {
                    sc(true);
                }
            }
            cJH().u(eVar);
        }
    }

    public void cQi() {
        com.baidu.tieba.pb.data.e pbData = cIe().getPbData();
        if (pbData != null) {
            this.kyL.sP(cIe().cKb());
            this.kyL.setData(pbData);
            this.kyL.notifyDataSetChanged();
            ArrayList<PostData> cGP = pbData.cGP();
            if (pbData.getPage().aRf() == 0 || cGP == null || cGP.size() < pbData.getPage().aRe()) {
                if (w.getCount(cGP) == 0 || (w.getCount(cGP) == 1 && cGP.get(0) != null && cGP.get(0).dhY() == 1)) {
                    if (cJC()) {
                        this.hGJ.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.hGJ.al(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().aRf() == 0) {
                        this.hGJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.hGJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.hGJ.aYa();
                }
            }
            cJH().u(pbData);
        }
    }

    public PbActivity cJI() {
        return this.keN != null ? this.keN : cJH().cJI();
    }

    public VideoPbFragment cJH() {
        if (this.kyE == null && this.keN != null) {
            Fragment cIq = this.keN.cIq();
            if (cIq instanceof VideoPbFragment) {
                this.kyE = (VideoPbFragment) cIq;
            }
        }
        return this.kyE;
    }

    public PbModel cIe() {
        return cJH().cIe();
    }

    public BdTypeRecyclerView getListView() {
        return this.hEN;
    }

    public boolean cJC() {
        if (cIe() != null) {
            return cIe().getHostMode();
        }
        return false;
    }

    public c cQj() {
        return this.kyL;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, eVar, str, i4);
        }
    }

    public b cQk() {
        return this.kyM;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0714a
    public void rK(boolean z) {
        this.kfx = z;
    }

    public void sg(boolean z) {
        if (z && this.kmZ) {
            this.hGJ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.hEN.setNextPage(this.hGJ);
            this.klY = 2;
        }
    }

    public void cMj() {
        this.hGJ.setLineVisible();
        this.hGJ.startLoadData();
    }

    public void endLoadData() {
        if (this.hGJ != null) {
            this.hGJ.setLineGone();
            this.hGJ.endLoadData();
        }
        if (cJH() != null && cJH().kxj != null) {
            this.kyE.kxj.bJm();
        }
    }

    public void Kb(String str) {
        if (this.hGJ != null) {
            this.hGJ.setText(str);
        }
    }

    public void Kc(String str) {
        if (this.hGJ != null) {
            this.hGJ.al(str, this.topMargin);
        }
    }

    public void cMl() {
        if (this.fpF != null && this.fpF.isEnabled()) {
            this.fpF.setRefreshing(false);
        }
    }

    public void cMG() {
        if (this.klY != 2) {
            this.hEN.setNextPage(this.hGJ);
            this.klY = 2;
        }
    }

    public void sc(boolean z) {
        this.knw = z;
    }

    public void cLH() {
        if (this.hEN == null) {
        }
    }

    public int cMm() {
        if (this.hEN != null) {
            return this.hEN.getFirstVisiblePosition();
        }
        return 0;
    }

    public int cQl() {
        View childAt;
        if (this.hEN == null || this.hEN.getCount() <= 0 || (childAt = this.hEN.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int cMn() {
        if (this.hEN != null) {
            int lastVisiblePosition = this.hEN.getLastVisiblePosition();
            if (cIe() != null && cIe().getPbData() != null && lastVisiblePosition >= cIe().getPbData().cGP().size()) {
                return cIe().getPbData().cGP().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View cMx() {
        return this.eAd;
    }

    public int cQh() {
        return this.kyH;
    }

    public int cQm() {
        return this.kyR;
    }

    public void BT(int i) {
        if (this.kyO != null) {
            this.kyO.setVisibility(i);
        }
    }

    public void sU(boolean z) {
        if (this.hEN != null) {
            this.hEN.setCanFling(z);
        }
    }

    public void cM(int i, int i2) {
        if (this.hEN != null && this.hEN.getLayoutManager() != null && (this.hEN.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.hEN.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }
}
