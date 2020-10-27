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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.videopb.MultiNestedLayout;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.b.b;
import com.baidu.tieba.pb.videopb.c;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0807a {
    private BdSwipeRefreshLayout gfT;
    private BdTypeRecyclerView iHt;
    private VideoPbFragment lHS;
    private b lHV;
    private View lHW;
    private c lIh;
    private MultiNestedLayout lIi;
    private com.baidu.tieba.pb.videopb.videoView.b lIj;
    private View lIk;
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
    private RecyclerView.OnScrollListener hKT = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.diB().dkK();
                ReplyFragment.this.diB().doD();
            }
            if (ReplyFragment.this.diB() != null) {
                ReplyFragment.this.diB().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.lIa = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.lIa != 0) {
                ReplyFragment.this.lHW.setVisibility(8);
            }
            ReplyFragment.this.lIa = 0;
        }
    };
    private MultiNestedLayout.b lIl = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void iM(int i) {
            if (ReplyFragment.this.lIb != 1 || i == 1 || ReplyFragment.this.lIa == 0) {
                if (ReplyFragment.this.lIb != 0 || i == 0) {
                    if (ReplyFragment.this.lIb != 0 && i == 0) {
                        ReplyFragment.this.diB().Gn(8);
                    }
                } else if (ReplyFragment.this.lHW.getVisibility() != 0) {
                    ReplyFragment.this.diB().Gn(0);
                }
            } else {
                ReplyFragment.this.diB().Gn(8);
                ReplyFragment.this.lHW.setVisibility(0);
            }
            ReplyFragment.this.lIb = i;
        }
    };
    private final f.c ePL = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.dgX() != null && ReplyFragment.this.dgX().un(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.dli();
            }
        }
    };
    private CustomMessageListener iVT = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && ReplyFragment.this.dgX() != null && ReplyFragment.this.dgX().getPbData() != null && ReplyFragment.this.dgX().getPbData().dfK() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = ReplyFragment.this.dgX().getPbData().dfK().iterator();
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
                    if (nVar != null && ReplyFragment.this.lIh != null && ReplyFragment.this.iHt != null) {
                        ReplyFragment.this.dgX().getPbData().dfK().remove(nVar);
                        if (ReplyFragment.this.lIh.getDataList() != null) {
                            ReplyFragment.this.lIh.getDataList().remove(nVar);
                        }
                        if (ReplyFragment.this.iHt.getListView2().getData() != null) {
                            ReplyFragment.this.iHt.getListView2().getData().remove(nVar);
                        }
                        ReplyFragment.this.lIh.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e lpb = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (!ReplyFragment.this.lnL && ReplyFragment.this.dlW() && ReplyFragment.this.dgX() != null) {
                    aq aqVar = new aq("c13999");
                    aqVar.dR("tid", ReplyFragment.this.dgX().diV());
                    aqVar.dR("fid", ReplyFragment.this.dgX().getForumId());
                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar);
                    ReplyFragment.this.lnL = true;
                }
                if (ReplyFragment.this.dgX().um(false)) {
                    ReplyFragment.this.dlg();
                    if (ReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (ReplyFragment.this.dgX().getPbData() != null) {
                    ReplyFragment.this.dlD();
                }
            }
        }
    };

    public static ReplyFragment ae(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.lHS = videoPbFragment;
        return replyFragment;
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
        this.lHV = new b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.iVT);
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lIi = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.lIi.setScrollStateChangeListener(this.lIl);
        this.iHt = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.iHt.setLayoutManager(new LinearLayoutManager(getContext()));
        this.lIh = new c(this, this.iHt);
        this.lIh.F(diB().doo());
        this.lIh.S(diB().dop());
        this.lIh.setOnLongClickListener(diB().doq());
        this.lIh.setOnImageClickListener(this.lHV.getOnImageClickListener());
        this.lIh.setTbGestureDetector(this.lHV.dph());
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
        this.lIk = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.lIj = new com.baidu.tieba.pb.videopb.videoView.b(this.lIk);
        this.lIj.X(diB().doo());
        this.lIj.setOnSwitchChangeListener(diB().loS);
        registerListener(this.iVT);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e eVar = (e) y.b(diC()).l(e.class);
        eVar.doV().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    ReplyFragment.this.showLoadingView();
                } else {
                    ReplyFragment.this.hideLoadingView();
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
        if (this.lIj != null) {
            this.lIj.onChangeSkinType(i);
        }
        if (this.lIh != null) {
            this.lIh.notifyDataSetChanged();
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
        e eVar = (e) y.b(diC()).l(e.class);
        if (z && dgX() != null && fVar != null) {
            this.lkw = dgX().diX();
            boolean isEnabled = this.gfT.isEnabled();
            if (fVar.getPage().biR() == 0 && this.lkw) {
                this.gfT.setEnabled(false);
            } else if (!isEnabled) {
                this.gfT.setEnabled(true);
                this.gfT.interruptRefresh();
            }
            this.lIh.setIsFromCDN(eVar.isFromCDN());
            this.lIh.vm(this.lkw);
            this.lIh.setData(fVar);
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
            if (this.lIj != null && this.lIk != null) {
                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lim);
                bw dfI = fVar.dfI();
                nVar.lio = dfI != null ? dfI.bjR() : 0L;
                nVar.isNew = !dgX().diX();
                nVar.lir = div();
                nVar.sortType = fVar.lgY;
                nVar.liq = fVar.dgm();
                nVar.isDynamic = fVar.dgl();
                nVar.lis = fVar.lgX;
                this.lIj.a(nVar);
            }
            ArrayList<PostData> dfK = fVar.dfK();
            if (fVar.getPage().biQ() == 0 || dfK == null || dfK.size() < fVar.getPage().biP()) {
                if (com.baidu.tbadk.core.util.y.getCount(dfK) == 0 || (com.baidu.tbadk.core.util.y.getCount(dfK) == 1 && dfK.get(0) != null && dfK.get(0).dHx() == 1)) {
                    if (div()) {
                        this.iJp.ao(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.iJp.ao(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (fVar.getPage().biQ() == 0) {
                        this.iJp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.iJp.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.iJp.bpU();
                }
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
                    int size = (this.iHt.getData() == null && fVar.dfK() == null) ? 0 : this.iHt.getData().size() - fVar.dfK().size();
                    this.lIi.setMaxOffset();
                    this.iHt.setSelection(i3 > 0 ? size + i3 : 0);
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
        }
    }

    public void dpk() {
        com.baidu.tieba.pb.data.f pbData = dgX().getPbData();
        if (pbData != null) {
            this.lIh.vm(dgX().diX());
            this.lIh.setData(pbData);
            this.lIh.notifyDataSetChanged();
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
    /* renamed from: dpw */
    public c dpi() {
        return this.lIh;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, fVar, str, i4);
        }
    }

    public b dpm() {
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
    }

    public void endLoadData() {
        if (this.iJp != null) {
            this.iJp.setLineGone();
            this.iJp.endLoadData();
        }
        if (diB() != null && diB().lGn != null) {
            this.lHS.lGn.ceD();
        }
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

    public boolean dlW() {
        if (this.iJp == null || TextUtils.isEmpty(this.iJp.getEndText())) {
            return false;
        }
        return this.iJp.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
