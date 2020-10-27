package com.baidu.tieba.pb.videopb.fragment;

import android.arch.lifecycle.q;
import android.arch.lifecycle.y;
import android.content.Context;
import android.graphics.Rect;
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
import com.baidu.tbadk.core.util.aq;
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
import com.baidu.tieba.pb.videopb.a.b;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0807a {
    private LinearLayoutManager dZe;
    private BdSwipeRefreshLayout gfT;
    private BdTypeRecyclerView iHt;
    private VideoPbFragment lHS;
    private b lHU;
    private com.baidu.tieba.pb.videopb.b.b lHV;
    private View lHW;
    private LinearLayout lHX;
    private au lHY;
    private l lHZ;
    private boolean lnW;
    private PbActivity lnl;
    private View mRootView;
    private int topMargin;
    private PbListView iJp = null;
    private View foB = null;
    private com.baidu.tieba.pb.view.a lvu = null;
    private boolean lwa = false;
    private boolean lwx = false;
    private boolean lwX = true;
    private int luZ = 0;
    private g mPullView = null;
    private boolean lkw = false;
    private int lIa = 0;
    private int lIb = 0;
    private boolean lnL = false;
    private RecyclerView.OnScrollListener hKT = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                DetailInfoAndReplyFragment.this.diB().dkK();
                DetailInfoAndReplyFragment.this.diB().doD();
            }
            if (DetailInfoAndReplyFragment.this.diB() != null) {
                DetailInfoAndReplyFragment.this.diB().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            DetailInfoAndReplyFragment.this.dpq();
            if (recyclerView.canScrollVertically(-1)) {
                DetailInfoAndReplyFragment.this.lIa = 2;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoAndReplyFragment.this.lIa != 0) {
                DetailInfoAndReplyFragment.this.lHW.setVisibility(8);
            }
            DetailInfoAndReplyFragment.this.lIa = 0;
        }
    };
    private final f.c ePL = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (DetailInfoAndReplyFragment.this.dgX() != null && DetailInfoAndReplyFragment.this.dgX().un(true)) {
                TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                DetailInfoAndReplyFragment.this.dli();
            }
        }
    };
    private CustomMessageListener iVT = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && DetailInfoAndReplyFragment.this.dgX() != null && DetailInfoAndReplyFragment.this.dgX().getPbData() != null && DetailInfoAndReplyFragment.this.dgX().getPbData().dfK() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = DetailInfoAndReplyFragment.this.dgX().getPbData().dfK().iterator();
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
                    if (nVar != null && DetailInfoAndReplyFragment.this.lHU != null && DetailInfoAndReplyFragment.this.iHt != null) {
                        DetailInfoAndReplyFragment.this.dgX().getPbData().dfK().remove(nVar);
                        if (DetailInfoAndReplyFragment.this.lHU.getDataList() != null) {
                            DetailInfoAndReplyFragment.this.lHU.getDataList().remove(nVar);
                        }
                        if (DetailInfoAndReplyFragment.this.iHt.getListView2().getData() != null) {
                            DetailInfoAndReplyFragment.this.iHt.getListView2().getData().remove(nVar);
                        }
                        DetailInfoAndReplyFragment.this.lHU.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e lpb = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (DetailInfoAndReplyFragment.this.mIsLogin) {
                if (!DetailInfoAndReplyFragment.this.lnL && DetailInfoAndReplyFragment.this.dlW() && DetailInfoAndReplyFragment.this.dgX() != null) {
                    aq aqVar = new aq("c13999");
                    aqVar.dR("tid", DetailInfoAndReplyFragment.this.dgX().diV());
                    aqVar.dR("fid", DetailInfoAndReplyFragment.this.dgX().getForumId());
                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar);
                    DetailInfoAndReplyFragment.this.lnL = true;
                }
                if (DetailInfoAndReplyFragment.this.dgX().um(false)) {
                    DetailInfoAndReplyFragment.this.dlg();
                    if (DetailInfoAndReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (DetailInfoAndReplyFragment.this.dgX().getPbData() != null) {
                    DetailInfoAndReplyFragment.this.dlD();
                }
            }
        }
    };

    public static DetailInfoAndReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
        detailInfoAndReplyFragment.setArguments(bundle);
        detailInfoAndReplyFragment.lHS = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lnl = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lHV = new com.baidu.tieba.pb.videopb.b.b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.iVT);
    }

    private void initUI() {
        this.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iHt = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.dZe = new LinearLayoutManager(getContext()) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.4
            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        };
        this.iHt.setLayoutManager(this.dZe);
        this.lHU = new b(this, this.iHt);
        this.lHU.F(diB().doo());
        this.lHU.S(diB().dop());
        this.lHU.setOnLongClickListener(diB().doq());
        this.lHU.setOnImageClickListener(this.lHV.getOnImageClickListener());
        this.lHU.setTbGestureDetector(this.lHV.dph());
        this.lHW = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.iJp = new PbListView(getPageContext().getPageActivity());
        this.foB = this.iJp.getView().findViewById(R.id.pb_more_view);
        if (this.foB != null) {
            this.foB.setOnClickListener(diB().doo());
            ap.setBackgroundResource(this.foB, R.drawable.pb_foot_more_trans_selector);
        }
        this.iJp.setLineVisible();
        this.iJp.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.iJp.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.iJp.bpT();
        this.iHt.setOnSrollToBottomListener(this.lpb);
        this.iHt.addOnScrollListener(this.hKT);
        this.iHt.setOnTouchListener(diB().bBu());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.ePL);
        }
        if (this.gfT == null) {
            this.gfT = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.gfT.setProgressView(this.mPullView);
            this.gfT.setEnabled(false);
            ap.setBackgroundColor(this.gfT, R.color.cp_bg_line_e);
        }
        this.lHX = (LinearLayout) this.mRootView.findViewById(R.id.video_pb_suck_container);
        dpj();
        this.lHU.setOnSwitchChangeListener(diB().loS);
        registerListener(this.iVT);
    }

    private void dpj() {
        this.lHY = new au(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
        this.lHY.Yj = false;
        this.lHY.U(diB().doo());
        this.lHY.setOnSwitchChangeListener(diB().loS);
        this.lHY.Fx(8);
        this.lHX.addView(this.lHY.getRootView());
        this.lHZ = new l(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
        e eVar = new e();
        eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
        this.lHZ.a(eVar);
        this.lHZ.Fx(8);
        this.lHX.addView(this.lHZ.getRootView());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        com.baidu.tieba.pb.videopb.e eVar = (com.baidu.tieba.pb.videopb.e) y.b(diC()).l(com.baidu.tieba.pb.videopb.e.class);
        eVar.doV().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    DetailInfoAndReplyFragment.this.showLoadingView();
                } else {
                    DetailInfoAndReplyFragment.this.hideLoadingView();
                }
            }
        });
        d(true, 0, 3, 0, eVar.doM(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iJp != null) {
            this.iJp.changeSkin(i);
            if (this.foB != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.foB);
                ap.setBackgroundResource(this.foB, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.lHY != null) {
            this.lHY.onChangeSkinType(i);
        }
        if (this.lHZ != null) {
            this.lHZ.onChangeSkinType();
        }
        if (this.lHU != null) {
            this.lHU.notifyDataSetChanged();
        }
        if (this.lHW != null) {
            ap.setBackgroundResource(this.lHW, R.drawable.personalize_tab_shadow);
        }
        ap.setBackgroundColor(this.gfT, R.color.cp_bg_line_d);
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
        this.lnW = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        uB(z);
        if (diB() != null && diB().lGn != null) {
            this.lHS.lGn.dpf();
        }
        if (z && this.lnW) {
            dlg();
            dgX().um(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        com.baidu.tieba.pb.videopb.e eVar = (com.baidu.tieba.pb.videopb.e) y.b(diC()).l(com.baidu.tieba.pb.videopb.e.class);
        if (z && dgX() != null && fVar != null) {
            this.lkw = dgX().diX();
            boolean isEnabled = this.gfT.isEnabled();
            if (fVar.getPage().biR() == 0 && this.lkw) {
                this.gfT.setEnabled(false);
            } else if (!isEnabled) {
                this.gfT.setEnabled(true);
                this.gfT.interruptRefresh();
            }
            this.lHU.setIsFromCDN(eVar.isFromCDN());
            this.lHU.vm(this.lkw);
            this.lHU.setData(fVar);
            this.lwa = false;
            if (TbadkCoreApplication.isLogin()) {
                this.iHt.setNextPage(this.iJp);
                this.luZ = 2;
                if (diB() != null && diB().lGn != null) {
                    this.lHS.lGn.ceD();
                }
            } else {
                this.lwa = true;
                if (fVar.getPage().biQ() == 1) {
                    if (this.lvu == null) {
                        this.lvu = new com.baidu.tieba.pb.view.a(this, this);
                        this.lvu.createView();
                        this.lvu.bpT();
                    }
                    this.iHt.setNextPage(this.lvu);
                } else {
                    this.iHt.setNextPage(this.iJp);
                }
                this.luZ = 3;
            }
            if (this.lHY != null) {
                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lim);
                bw dfI = fVar.dfI();
                nVar.lio = dfI != null ? dfI.bjR() : 0L;
                nVar.isNew = !dgX().diX();
                nVar.lir = div();
                nVar.sortType = fVar.lgY;
                nVar.liq = fVar.dgm();
                nVar.isDynamic = fVar.dgl();
                nVar.lis = fVar.lgX;
                this.lHY.a(nVar);
            }
            ArrayList<PostData> dfK = fVar.dfK();
            if (fVar.getPage().biQ() == 0 || dfK == null || dfK.size() < fVar.getPage().biP()) {
                if (fVar.getPage().biQ() == 0) {
                    this.iJp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.iJp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.iJp.bpU();
                if (fVar.getPage().biQ() == 0 || dfK == null) {
                    dlD();
                }
            } else {
                if (dgX().getIsFromMark()) {
                    if (this.lwX) {
                        endLoadData();
                        if (fVar.getPage().biQ() != 0) {
                            this.iJp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.iJp.setLineVisible();
                        this.iJp.showLoading();
                    }
                } else {
                    this.iJp.setLineVisible();
                    this.iJp.showLoading();
                }
                this.iJp.bpU();
            }
            switch (i2) {
                case 2:
                    this.iHt.setSelection(i3 > 1 ? (((this.iHt.getData() == null && fVar.dfK() == null) ? 0 : this.iHt.getData().size() - fVar.dfK().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable dkr = as.dkq().dkr();
                        if (dkr instanceof RecyclerView.SavedState) {
                            this.iHt.onRestoreInstanceState(dkr);
                            if (com.baidu.tbadk.core.util.y.getCount(dfK) > 1 && fVar.getPage().biQ() > 0) {
                                this.iJp.endLoadData();
                                this.iJp.setText(getString(R.string.pb_load_more_without_point));
                                this.iJp.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.lwX = false;
                    break;
                case 5:
                    this.iHt.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable dkr2 = as.dkq().dkr();
                        if (dkr2 instanceof RecyclerView.SavedState) {
                            this.iHt.onRestoreInstanceState(dkr2);
                            break;
                        }
                    }
                    this.iHt.setSelection(0);
                    break;
                case 8:
                    this.iHt.setSelection(i3 > 0 ? ((this.iHt.getData() == null && fVar.dfK() == null) ? 0 : this.iHt.getData().size() - fVar.dfK().size()) + i3 : 0);
                    this.iJp.endLoadData();
                    this.iJp.setText(getString(R.string.pb_load_more_without_point));
                    this.iJp.setLineGone();
                    break;
            }
            if (this.lwx) {
                dkE();
                this.lwx = false;
                if (i4 == 0) {
                    ux(true);
                }
            }
            diB().u(fVar);
            if (this.iJp != null) {
                if (fVar.getPage().biQ() == 0) {
                    this.iJp.setVisibility(8);
                } else {
                    this.iJp.setVisibility(0);
                }
            }
        }
    }

    public void dpk() {
        com.baidu.tieba.pb.data.f pbData = dgX().getPbData();
        if (pbData != null) {
            this.lHU.vm(dgX().diX());
            this.lHU.setData(pbData);
            this.lHU.notifyDataSetChanged();
            ArrayList<PostData> dfK = pbData.dfK();
            if (pbData.getPage().biQ() == 0 || dfK == null || dfK.size() < pbData.getPage().biP()) {
                if (com.baidu.tbadk.core.util.y.getCount(dfK) == 0 || (com.baidu.tbadk.core.util.y.getCount(dfK) == 1 && dfK.get(0) != null && dfK.get(0).dHx() == 1)) {
                    if (div()) {
                        this.iJp.ao(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.iJp.ao(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().biQ() == 0) {
                        this.iJp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.iJp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.iJp.bpU();
                }
            }
            diB().u(pbData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity diC() {
        return this.lnl != null ? this.lnl : diB().diC();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment diB() {
        if (this.lHS == null && this.lnl != null) {
            Fragment dhj = this.lnl.dhj();
            if (dhj instanceof VideoPbFragment) {
                this.lHS = (VideoPbFragment) dhj;
            }
        }
        return this.lHS;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel dgX() {
        return diB().dgX();
    }

    public BdTypeRecyclerView getListView() {
        return this.iHt;
    }

    public boolean div() {
        if (dgX() != null) {
            return dgX().getHostMode();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: dpl */
    public b dpi() {
        return this.lHU;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, fVar, str, i4);
        }
    }

    public com.baidu.tieba.pb.videopb.b.b dpm() {
        return this.lHV;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0807a
    public void ud(boolean z) {
        this.lnW = z;
    }

    public void uB(boolean z) {
        if (z && this.lwa) {
            this.iJp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.iHt.setNextPage(this.iJp);
            this.luZ = 2;
        }
    }

    public void dlg() {
        this.iJp.setLineVisible();
        this.iJp.startLoadData();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, true));
    }

    public void endLoadData() {
        if (this.iJp != null) {
            this.iJp.setLineGone();
            this.iJp.endLoadData();
        }
        if (diB() != null && diB().lGn != null) {
            this.lHS.lGn.ceD();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, false));
    }

    public void Pw(String str) {
        if (this.iJp != null) {
            this.iJp.setText(str);
        }
    }

    public void Px(String str) {
        if (this.iJp != null) {
            this.iJp.ao(str, this.topMargin);
        }
    }

    public void dli() {
        if (this.gfT != null && this.gfT.isEnabled()) {
            this.gfT.setRefreshing(false);
        }
    }

    public void dlD() {
        if (this.luZ != 2) {
            this.iHt.setNextPage(this.iJp);
            this.luZ = 2;
        }
    }

    public void ux(boolean z) {
        this.lwx = z;
    }

    public void dkE() {
        if (this.iHt == null) {
        }
    }

    public int dlj() {
        if (this.iHt != null) {
            return this.iHt.getFirstVisiblePosition();
        }
        return 0;
    }

    public int dpn() {
        View childAt;
        if (this.iHt == null || this.iHt.getCount() <= 0 || (childAt = this.iHt.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int dlk() {
        if (this.iHt != null) {
            int lastVisiblePosition = this.iHt.getLastVisiblePosition();
            if (dgX() != null && dgX().getPbData() != null && lastVisiblePosition >= dgX().getPbData().dfK().size()) {
                return dgX().getPbData().dfK().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View dlu() {
        return this.foB;
    }

    public int dpo() {
        return this.lIa;
    }

    public int dpp() {
        return this.lIb;
    }

    public void Gn(int i) {
        if (this.lHW != null) {
            this.lHW.setVisibility(i);
        }
    }

    public void vr(boolean z) {
        if (this.iHt != null) {
            this.iHt.setCanFling(z);
        }
    }

    public void dc(int i, int i2) {
        if (this.iHt != null && this.iHt.getLayoutManager() != null && (this.iHt.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.iHt.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpq() {
        if (this.iHt != null && this.dZe != null && this.lHU != null) {
            int headerViewsCount = this.iHt.getHeaderViewsCount() + this.lHU.dpd();
            int headerViewsCount2 = this.iHt.getHeaderViewsCount() + this.lHU.dpe();
            int findFirstVisibleItemPosition = this.dZe.findFirstVisibleItemPosition();
            if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
                this.lHY.Fx(0);
            } else {
                this.lHY.Fx(8);
            }
            if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
                this.lHZ.Fx(0);
                this.lHY.Fx(8);
            } else {
                this.lHZ.Fx(8);
            }
            if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
                Gn(0);
            } else {
                Gn(8);
            }
        }
    }

    public boolean dlW() {
        if (this.iJp == null || TextUtils.isEmpty(this.iJp.getEndText())) {
            return false;
        }
        return this.iJp.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
