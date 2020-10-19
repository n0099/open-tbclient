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
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0792a {
    private LinearLayoutManager dQI;
    private BdSwipeRefreshLayout fVP;
    private BdTypeRecyclerView iuX;
    private PbActivity laM;
    private boolean lbx;
    private au lvA;
    private l lvB;
    private VideoPbFragment lvu;
    private b lvw;
    private com.baidu.tieba.pb.videopb.b.b lvx;
    private View lvy;
    private LinearLayout lvz;
    private View mRootView;
    private int topMargin;
    private PbListView iwT = null;
    private View fgc = null;
    private com.baidu.tieba.pb.view.a liR = null;
    private boolean ljx = false;
    private boolean ljU = false;
    private boolean lku = true;
    private int liw = 0;
    private g mPullView = null;
    private boolean kXX = false;
    private int lvC = 0;
    private int lvD = 0;
    private boolean lbm = false;
    private RecyclerView.OnScrollListener hyx = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                DetailInfoAndReplyFragment.this.dfu().dhD();
                DetailInfoAndReplyFragment.this.dfu().dlv();
            }
            if (DetailInfoAndReplyFragment.this.dfu() != null) {
                DetailInfoAndReplyFragment.this.dfu().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            DetailInfoAndReplyFragment.this.dmi();
            if (recyclerView.canScrollVertically(-1)) {
                DetailInfoAndReplyFragment.this.lvC = 2;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoAndReplyFragment.this.lvC != 0) {
                DetailInfoAndReplyFragment.this.lvy.setVisibility(8);
            }
            DetailInfoAndReplyFragment.this.lvC = 0;
        }
    };
    private final f.c eHp = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (DetailInfoAndReplyFragment.this.ddQ() != null && DetailInfoAndReplyFragment.this.ddQ().tW(true)) {
                TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                DetailInfoAndReplyFragment.this.dib();
            }
        }
    };
    private CustomMessageListener iJx = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && DetailInfoAndReplyFragment.this.ddQ() != null && DetailInfoAndReplyFragment.this.ddQ().getPbData() != null && DetailInfoAndReplyFragment.this.ddQ().getPbData().dcC() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = DetailInfoAndReplyFragment.this.ddQ().getPbData().dcC().iterator();
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
                    if (nVar != null && DetailInfoAndReplyFragment.this.lvw != null && DetailInfoAndReplyFragment.this.iuX != null) {
                        DetailInfoAndReplyFragment.this.ddQ().getPbData().dcC().remove(nVar);
                        if (DetailInfoAndReplyFragment.this.lvw.getDataList() != null) {
                            DetailInfoAndReplyFragment.this.lvw.getDataList().remove(nVar);
                        }
                        if (DetailInfoAndReplyFragment.this.iuX.getListView2().getData() != null) {
                            DetailInfoAndReplyFragment.this.iuX.getListView2().getData().remove(nVar);
                        }
                        DetailInfoAndReplyFragment.this.lvw.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e lcy = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (DetailInfoAndReplyFragment.this.mIsLogin) {
                if (!DetailInfoAndReplyFragment.this.lbm && DetailInfoAndReplyFragment.this.diP() && DetailInfoAndReplyFragment.this.ddQ() != null) {
                    aq aqVar = new aq("c13999");
                    aqVar.dK("tid", DetailInfoAndReplyFragment.this.ddQ().dfO());
                    aqVar.dK("fid", DetailInfoAndReplyFragment.this.ddQ().getForumId());
                    aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar);
                    DetailInfoAndReplyFragment.this.lbm = true;
                }
                if (DetailInfoAndReplyFragment.this.ddQ().tV(false)) {
                    DetailInfoAndReplyFragment.this.dhZ();
                    if (DetailInfoAndReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (DetailInfoAndReplyFragment.this.ddQ().getPbData() != null) {
                    DetailInfoAndReplyFragment.this.diw();
                }
            }
        }
    };

    public static DetailInfoAndReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
        detailInfoAndReplyFragment.setArguments(bundle);
        detailInfoAndReplyFragment.lvu = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.laM = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lvx = new com.baidu.tieba.pb.videopb.b.b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.iJx);
    }

    private void initUI() {
        this.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iuX = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.dQI = new LinearLayoutManager(getContext()) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.4
            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        };
        this.iuX.setLayoutManager(this.dQI);
        this.lvw = new b(this, this.iuX);
        this.lvw.F(dfu().dlg());
        this.lvw.S(dfu().dlh());
        this.lvw.setOnLongClickListener(dfu().dli());
        this.lvw.setOnImageClickListener(this.lvx.getOnImageClickListener());
        this.lvw.setTbGestureDetector(this.lvx.dlZ());
        this.lvy = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.iwT = new PbListView(getPageContext().getPageActivity());
        this.fgc = this.iwT.getView().findViewById(R.id.pb_more_view);
        if (this.fgc != null) {
            this.fgc.setOnClickListener(dfu().dlg());
            ap.setBackgroundResource(this.fgc, R.drawable.pb_foot_more_trans_selector);
        }
        this.iwT.setLineVisible();
        this.iwT.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.iwT.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.iwT.boa();
        this.iuX.setOnSrollToBottomListener(this.lcy);
        this.iuX.addOnScrollListener(this.hyx);
        this.iuX.setOnTouchListener(dfu().bzB());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.eHp);
        }
        if (this.fVP == null) {
            this.fVP = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.fVP.setProgressView(this.mPullView);
            this.fVP.setEnabled(false);
            ap.setBackgroundColor(this.fVP, R.color.cp_bg_line_e);
        }
        this.lvz = (LinearLayout) this.mRootView.findViewById(R.id.video_pb_suck_container);
        dmb();
        this.lvw.setOnSwitchChangeListener(dfu().lcp);
        registerListener(this.iJx);
    }

    private void dmb() {
        this.lvA = new au(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
        this.lvA.Yi = false;
        this.lvA.U(dfu().dlg());
        this.lvA.setOnSwitchChangeListener(dfu().lcp);
        this.lvA.Fe(8);
        this.lvz.addView(this.lvA.getRootView());
        this.lvB = new l(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
        e eVar = new e();
        eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
        this.lvB.a(eVar);
        this.lvB.Fe(8);
        this.lvz.addView(this.lvB.getRootView());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        com.baidu.tieba.pb.videopb.e eVar = (com.baidu.tieba.pb.videopb.e) y.b(dfv()).l(com.baidu.tieba.pb.videopb.e.class);
        eVar.dlN().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.5
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
        d(true, 0, 3, 0, eVar.dlE(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iwT != null) {
            this.iwT.changeSkin(i);
            if (this.fgc != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fgc);
                ap.setBackgroundResource(this.fgc, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.lvA != null) {
            this.lvA.onChangeSkinType(i);
        }
        if (this.lvB != null) {
            this.lvB.onChangeSkinType();
        }
        if (this.lvw != null) {
            this.lvw.notifyDataSetChanged();
        }
        if (this.lvy != null) {
            ap.setBackgroundResource(this.lvy, R.drawable.personalize_tab_shadow);
        }
        ap.setBackgroundColor(this.fVP, R.color.cp_bg_line_d);
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
        this.lbx = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        uk(z);
        if (dfu() != null && dfu().ltP != null) {
            this.lvu.ltP.dlX();
        }
        if (z && this.lbx) {
            dhZ();
            ddQ().tV(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        com.baidu.tieba.pb.videopb.e eVar = (com.baidu.tieba.pb.videopb.e) y.b(dfv()).l(com.baidu.tieba.pb.videopb.e.class);
        if (z && ddQ() != null && fVar != null) {
            this.kXX = ddQ().dfQ();
            boolean isEnabled = this.fVP.isEnabled();
            if (fVar.getPage().bgY() == 0 && this.kXX) {
                this.fVP.setEnabled(false);
            } else if (!isEnabled) {
                this.fVP.setEnabled(true);
                this.fVP.interruptRefresh();
            }
            this.lvw.setIsFromCDN(eVar.isFromCDN());
            this.lvw.uV(this.kXX);
            this.lvw.setData(fVar);
            this.ljx = false;
            if (TbadkCoreApplication.isLogin()) {
                this.iuX.setNextPage(this.iwT);
                this.liw = 2;
                if (dfu() != null && dfu().ltP != null) {
                    this.lvu.ltP.cbz();
                }
            } else {
                this.ljx = true;
                if (fVar.getPage().bgX() == 1) {
                    if (this.liR == null) {
                        this.liR = new com.baidu.tieba.pb.view.a(this, this);
                        this.liR.createView();
                        this.liR.boa();
                    }
                    this.iuX.setNextPage(this.liR);
                } else {
                    this.iuX.setNextPage(this.iwT);
                }
                this.liw = 3;
            }
            if (this.lvA != null) {
                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kVN);
                bw dcA = fVar.dcA();
                nVar.kVP = dcA != null ? dcA.bhY() : 0L;
                nVar.isNew = !ddQ().dfQ();
                nVar.kVS = dfo();
                nVar.sortType = fVar.kUz;
                nVar.kVR = fVar.dde();
                nVar.isDynamic = fVar.ddd();
                nVar.kVT = fVar.kUy;
                this.lvA.a(nVar);
            }
            ArrayList<PostData> dcC = fVar.dcC();
            if (fVar.getPage().bgX() == 0 || dcC == null || dcC.size() < fVar.getPage().bgW()) {
                if (fVar.getPage().bgX() == 0) {
                    this.iwT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.iwT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.iwT.bob();
                if (fVar.getPage().bgX() == 0 || dcC == null) {
                    diw();
                }
            } else {
                if (ddQ().getIsFromMark()) {
                    if (this.lku) {
                        endLoadData();
                        if (fVar.getPage().bgX() != 0) {
                            this.iwT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.iwT.setLineVisible();
                        this.iwT.showLoading();
                    }
                } else {
                    this.iwT.setLineVisible();
                    this.iwT.showLoading();
                }
                this.iwT.bob();
            }
            switch (i2) {
                case 2:
                    this.iuX.setSelection(i3 > 1 ? (((this.iuX.getData() == null && fVar.dcC() == null) ? 0 : this.iuX.getData().size() - fVar.dcC().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable dhk = as.dhj().dhk();
                        if (dhk instanceof RecyclerView.SavedState) {
                            this.iuX.onRestoreInstanceState(dhk);
                            if (com.baidu.tbadk.core.util.y.getCount(dcC) > 1 && fVar.getPage().bgX() > 0) {
                                this.iwT.endLoadData();
                                this.iwT.setText(getString(R.string.pb_load_more_without_point));
                                this.iwT.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.lku = false;
                    break;
                case 5:
                    this.iuX.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable dhk2 = as.dhj().dhk();
                        if (dhk2 instanceof RecyclerView.SavedState) {
                            this.iuX.onRestoreInstanceState(dhk2);
                            break;
                        }
                    }
                    this.iuX.setSelection(0);
                    break;
                case 8:
                    this.iuX.setSelection(i3 > 0 ? ((this.iuX.getData() == null && fVar.dcC() == null) ? 0 : this.iuX.getData().size() - fVar.dcC().size()) + i3 : 0);
                    this.iwT.endLoadData();
                    this.iwT.setText(getString(R.string.pb_load_more_without_point));
                    this.iwT.setLineGone();
                    break;
            }
            if (this.ljU) {
                dhx();
                this.ljU = false;
                if (i4 == 0) {
                    ug(true);
                }
            }
            dfu().u(fVar);
            if (this.iwT != null) {
                if (fVar.getPage().bgX() == 0) {
                    this.iwT.setVisibility(8);
                } else {
                    this.iwT.setVisibility(0);
                }
            }
        }
    }

    public void dmc() {
        com.baidu.tieba.pb.data.f pbData = ddQ().getPbData();
        if (pbData != null) {
            this.lvw.uV(ddQ().dfQ());
            this.lvw.setData(pbData);
            this.lvw.notifyDataSetChanged();
            ArrayList<PostData> dcC = pbData.dcC();
            if (pbData.getPage().bgX() == 0 || dcC == null || dcC.size() < pbData.getPage().bgW()) {
                if (com.baidu.tbadk.core.util.y.getCount(dcC) == 0 || (com.baidu.tbadk.core.util.y.getCount(dcC) == 1 && dcC.get(0) != null && dcC.get(0).dEp() == 1)) {
                    if (dfo()) {
                        this.iwT.ao(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.iwT.ao(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().bgX() == 0) {
                        this.iwT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.iwT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.iwT.bob();
                }
            }
            dfu().u(pbData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity dfv() {
        return this.laM != null ? this.laM : dfu().dfv();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment dfu() {
        if (this.lvu == null && this.laM != null) {
            Fragment dec = this.laM.dec();
            if (dec instanceof VideoPbFragment) {
                this.lvu = (VideoPbFragment) dec;
            }
        }
        return this.lvu;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel ddQ() {
        return dfu().ddQ();
    }

    public BdTypeRecyclerView getListView() {
        return this.iuX;
    }

    public boolean dfo() {
        if (ddQ() != null) {
            return ddQ().getHostMode();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: dmd */
    public b dma() {
        return this.lvw;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, fVar, str, i4);
        }
    }

    public com.baidu.tieba.pb.videopb.b.b dme() {
        return this.lvx;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0792a
    public void tM(boolean z) {
        this.lbx = z;
    }

    public void uk(boolean z) {
        if (z && this.ljx) {
            this.iwT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.iuX.setNextPage(this.iwT);
            this.liw = 2;
        }
    }

    public void dhZ() {
        this.iwT.setLineVisible();
        this.iwT.startLoadData();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, true));
    }

    public void endLoadData() {
        if (this.iwT != null) {
            this.iwT.setLineGone();
            this.iwT.endLoadData();
        }
        if (dfu() != null && dfu().ltP != null) {
            this.lvu.ltP.cbz();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, false));
    }

    public void OY(String str) {
        if (this.iwT != null) {
            this.iwT.setText(str);
        }
    }

    public void OZ(String str) {
        if (this.iwT != null) {
            this.iwT.ao(str, this.topMargin);
        }
    }

    public void dib() {
        if (this.fVP != null && this.fVP.isEnabled()) {
            this.fVP.setRefreshing(false);
        }
    }

    public void diw() {
        if (this.liw != 2) {
            this.iuX.setNextPage(this.iwT);
            this.liw = 2;
        }
    }

    public void ug(boolean z) {
        this.ljU = z;
    }

    public void dhx() {
        if (this.iuX == null) {
        }
    }

    public int dic() {
        if (this.iuX != null) {
            return this.iuX.getFirstVisiblePosition();
        }
        return 0;
    }

    public int dmf() {
        View childAt;
        if (this.iuX == null || this.iuX.getCount() <= 0 || (childAt = this.iuX.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int did() {
        if (this.iuX != null) {
            int lastVisiblePosition = this.iuX.getLastVisiblePosition();
            if (ddQ() != null && ddQ().getPbData() != null && lastVisiblePosition >= ddQ().getPbData().dcC().size()) {
                return ddQ().getPbData().dcC().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View din() {
        return this.fgc;
    }

    public int dmg() {
        return this.lvC;
    }

    public int dmh() {
        return this.lvD;
    }

    public void FU(int i) {
        if (this.lvy != null) {
            this.lvy.setVisibility(i);
        }
    }

    public void va(boolean z) {
        if (this.iuX != null) {
            this.iuX.setCanFling(z);
        }
    }

    public void da(int i, int i2) {
        if (this.iuX != null && this.iuX.getLayoutManager() != null && (this.iuX.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.iuX.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmi() {
        if (this.iuX != null && this.dQI != null && this.lvw != null) {
            int headerViewsCount = this.iuX.getHeaderViewsCount() + this.lvw.dlV();
            int headerViewsCount2 = this.iuX.getHeaderViewsCount() + this.lvw.dlW();
            int findFirstVisibleItemPosition = this.dQI.findFirstVisibleItemPosition();
            if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
                this.lvA.Fe(0);
            } else {
                this.lvA.Fe(8);
            }
            if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
                this.lvB.Fe(0);
                this.lvA.Fe(8);
            } else {
                this.lvB.Fe(8);
            }
            if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
                FU(0);
            } else {
                FU(8);
            }
        }
    }

    public boolean diP() {
        if (this.iwT == null || TextUtils.isEmpty(this.iwT.getEndText())) {
            return false;
        }
        return this.iwT.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
