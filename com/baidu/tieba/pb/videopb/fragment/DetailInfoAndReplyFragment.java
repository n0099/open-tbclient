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
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0822a {
    private LinearLayoutManager eeV;
    private BdSwipeRefreshLayout glI;
    private BdTypeRecyclerView iNq;
    private VideoPbFragment lNO;
    private b lNQ;
    private com.baidu.tieba.pb.videopb.b.b lNR;
    private View lNS;
    private LinearLayout lNT;
    private au lNU;
    private l lNV;
    private boolean ltX;
    private PbActivity ltl;
    private View mRootView;
    private int topMargin;
    private PbListView iPm = null;
    private View fuw = null;
    private com.baidu.tieba.pb.view.a lBr = null;
    private boolean lBX = false;
    private boolean lCu = false;
    private boolean lCU = true;
    private int lAW = 0;
    private g mPullView = null;
    private boolean lqx = false;
    private int lNW = 0;
    private int lNX = 0;
    private boolean ltM = false;
    private RecyclerView.OnScrollListener hQQ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                DetailInfoAndReplyFragment.this.dld().dnm();
                DetailInfoAndReplyFragment.this.dld().drf();
            }
            if (DetailInfoAndReplyFragment.this.dld() != null) {
                DetailInfoAndReplyFragment.this.dld().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            DetailInfoAndReplyFragment.this.drS();
            if (recyclerView.canScrollVertically(-1)) {
                DetailInfoAndReplyFragment.this.lNW = 2;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoAndReplyFragment.this.lNW != 0) {
                DetailInfoAndReplyFragment.this.lNS.setVisibility(8);
            }
            DetailInfoAndReplyFragment.this.lNW = 0;
        }
    };
    private final f.c eVA = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (DetailInfoAndReplyFragment.this.djz() != null && DetailInfoAndReplyFragment.this.djz().uw(true)) {
                TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                DetailInfoAndReplyFragment.this.dnL();
            }
        }
    };
    private CustomMessageListener jbQ = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && DetailInfoAndReplyFragment.this.djz() != null && DetailInfoAndReplyFragment.this.djz().getPbData() != null && DetailInfoAndReplyFragment.this.djz().getPbData().dim() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = DetailInfoAndReplyFragment.this.djz().getPbData().dim().iterator();
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
                    if (nVar != null && DetailInfoAndReplyFragment.this.lNQ != null && DetailInfoAndReplyFragment.this.iNq != null) {
                        DetailInfoAndReplyFragment.this.djz().getPbData().dim().remove(nVar);
                        if (DetailInfoAndReplyFragment.this.lNQ.getDataList() != null) {
                            DetailInfoAndReplyFragment.this.lNQ.getDataList().remove(nVar);
                        }
                        if (DetailInfoAndReplyFragment.this.iNq.getListView2().getData() != null) {
                            DetailInfoAndReplyFragment.this.iNq.getListView2().getData().remove(nVar);
                        }
                        DetailInfoAndReplyFragment.this.lNQ.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e luY = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (DetailInfoAndReplyFragment.this.mIsLogin) {
                if (!DetailInfoAndReplyFragment.this.ltM && DetailInfoAndReplyFragment.this.doz() && DetailInfoAndReplyFragment.this.djz() != null) {
                    aq aqVar = new aq("c13999");
                    aqVar.dR("tid", DetailInfoAndReplyFragment.this.djz().dlx());
                    aqVar.dR("fid", DetailInfoAndReplyFragment.this.djz().getForumId());
                    aqVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar);
                    DetailInfoAndReplyFragment.this.ltM = true;
                }
                if (DetailInfoAndReplyFragment.this.djz().uv(false)) {
                    DetailInfoAndReplyFragment.this.dnJ();
                    if (DetailInfoAndReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (DetailInfoAndReplyFragment.this.djz().getPbData() != null) {
                    DetailInfoAndReplyFragment.this.dog();
                }
            }
        }
    };

    public static DetailInfoAndReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
        detailInfoAndReplyFragment.setArguments(bundle);
        detailInfoAndReplyFragment.lNO = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.ltl = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lNR = new com.baidu.tieba.pb.videopb.b.b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.jbQ);
    }

    private void initUI() {
        this.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iNq = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.eeV = new LinearLayoutManager(getContext()) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.4
            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        };
        this.iNq.setLayoutManager(this.eeV);
        this.lNQ = new b(this, this.iNq);
        this.lNQ.G(dld().dqQ());
        this.lNQ.T(dld().dqR());
        this.lNQ.setOnLongClickListener(dld().dqS());
        this.lNQ.setOnImageClickListener(this.lNR.getOnImageClickListener());
        this.lNQ.setTbGestureDetector(this.lNR.drJ());
        this.lNS = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.iPm = new PbListView(getPageContext().getPageActivity());
        this.fuw = this.iPm.getView().findViewById(R.id.pb_more_view);
        if (this.fuw != null) {
            this.fuw.setOnClickListener(dld().dqQ());
            ap.setBackgroundResource(this.fuw, R.drawable.pb_foot_more_trans_selector);
        }
        this.iPm.setLineVisible();
        this.iPm.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.iPm.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.iPm.bst();
        this.iNq.setOnSrollToBottomListener(this.luY);
        this.iNq.addOnScrollListener(this.hQQ);
        this.iNq.setOnTouchListener(dld().bDT());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.eVA);
        }
        if (this.glI == null) {
            this.glI = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.glI.setProgressView(this.mPullView);
            this.glI.setEnabled(false);
            ap.setBackgroundColor(this.glI, R.color.cp_bg_line_e);
        }
        this.lNT = (LinearLayout) this.mRootView.findViewById(R.id.video_pb_suck_container);
        drL();
        this.lNQ.setOnSwitchChangeListener(dld().luP);
        registerListener(this.jbQ);
    }

    private void drL() {
        this.lNU = new au(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
        this.lNU.Yj = false;
        this.lNU.V(dld().dqQ());
        this.lNU.setOnSwitchChangeListener(dld().luP);
        this.lNU.FK(8);
        this.lNT.addView(this.lNU.getRootView());
        this.lNV = new l(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
        e eVar = new e();
        eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
        this.lNV.a(eVar);
        this.lNV.FK(8);
        this.lNT.addView(this.lNV.getRootView());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        com.baidu.tieba.pb.videopb.e eVar = (com.baidu.tieba.pb.videopb.e) y.b(dle()).l(com.baidu.tieba.pb.videopb.e.class);
        eVar.drx().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.5
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
        d(true, 0, 3, 0, eVar.dro(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iPm != null) {
            this.iPm.changeSkin(i);
            if (this.fuw != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fuw);
                ap.setBackgroundResource(this.fuw, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.lNU != null) {
            this.lNU.onChangeSkinType(i);
        }
        if (this.lNV != null) {
            this.lNV.onChangeSkinType();
        }
        if (this.lNQ != null) {
            this.lNQ.notifyDataSetChanged();
        }
        if (this.lNS != null) {
            ap.setBackgroundResource(this.lNS, R.drawable.personalize_tab_shadow);
        }
        ap.setBackgroundColor(this.glI, R.color.cp_bg_line_d);
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
        this.ltX = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        uK(z);
        if (dld() != null && dld().lMj != null) {
            this.lNO.lMj.drH();
        }
        if (z && this.ltX) {
            dnJ();
            djz().uv(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        com.baidu.tieba.pb.videopb.e eVar = (com.baidu.tieba.pb.videopb.e) y.b(dle()).l(com.baidu.tieba.pb.videopb.e.class);
        if (z && djz() != null && fVar != null) {
            this.lqx = djz().dlz();
            boolean isEnabled = this.glI.isEnabled();
            if (fVar.getPage().blr() == 0 && this.lqx) {
                this.glI.setEnabled(false);
            } else if (!isEnabled) {
                this.glI.setEnabled(true);
                this.glI.interruptRefresh();
            }
            this.lNQ.setIsFromCDN(eVar.isFromCDN());
            this.lNQ.vv(this.lqx);
            this.lNQ.setData(fVar);
            this.lBX = false;
            if (TbadkCoreApplication.isLogin()) {
                this.iNq.setNextPage(this.iPm);
                this.lAW = 2;
                if (dld() != null && dld().lMj != null) {
                    this.lNO.lMj.chg();
                }
            } else {
                this.lBX = true;
                if (fVar.getPage().blq() == 1) {
                    if (this.lBr == null) {
                        this.lBr = new com.baidu.tieba.pb.view.a(this, this);
                        this.lBr.createView();
                        this.lBr.bst();
                    }
                    this.iNq.setNextPage(this.lBr);
                } else {
                    this.iNq.setNextPage(this.iPm);
                }
                this.lAW = 3;
            }
            if (this.lNU != null) {
                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lol);
                bw dik = fVar.dik();
                nVar.loo = dik != null ? dik.bmr() : 0L;
                nVar.isNew = !djz().dlz();
                nVar.lor = dkX();
                nVar.sortType = fVar.lmU;
                nVar.loq = fVar.diO();
                nVar.isDynamic = fVar.diN();
                nVar.los = fVar.lmT;
                this.lNU.a(nVar);
            }
            ArrayList<PostData> dim = fVar.dim();
            if (fVar.getPage().blq() == 0 || dim == null || dim.size() < fVar.getPage().blp()) {
                if (fVar.getPage().blq() == 0) {
                    this.iPm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.iPm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.iPm.bsu();
                if (fVar.getPage().blq() == 0 || dim == null) {
                    dog();
                }
            } else {
                if (djz().getIsFromMark()) {
                    if (this.lCU) {
                        endLoadData();
                        if (fVar.getPage().blq() != 0) {
                            this.iPm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.iPm.setLineVisible();
                        this.iPm.showLoading();
                    }
                } else {
                    this.iPm.setLineVisible();
                    this.iPm.showLoading();
                }
                this.iPm.bsu();
            }
            switch (i2) {
                case 2:
                    this.iNq.setSelection(i3 > 1 ? (((this.iNq.getData() == null && fVar.dim() == null) ? 0 : this.iNq.getData().size() - fVar.dim().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable dmT = as.dmS().dmT();
                        if (dmT instanceof RecyclerView.SavedState) {
                            this.iNq.onRestoreInstanceState(dmT);
                            if (com.baidu.tbadk.core.util.y.getCount(dim) > 1 && fVar.getPage().blq() > 0) {
                                this.iPm.endLoadData();
                                this.iPm.setText(getString(R.string.pb_load_more_without_point));
                                this.iPm.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.lCU = false;
                    break;
                case 5:
                    this.iNq.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable dmT2 = as.dmS().dmT();
                        if (dmT2 instanceof RecyclerView.SavedState) {
                            this.iNq.onRestoreInstanceState(dmT2);
                            break;
                        }
                    }
                    this.iNq.setSelection(0);
                    break;
                case 8:
                    this.iNq.setSelection(i3 > 0 ? ((this.iNq.getData() == null && fVar.dim() == null) ? 0 : this.iNq.getData().size() - fVar.dim().size()) + i3 : 0);
                    this.iPm.endLoadData();
                    this.iPm.setText(getString(R.string.pb_load_more_without_point));
                    this.iPm.setLineGone();
                    break;
            }
            if (this.lCu) {
                dng();
                this.lCu = false;
                if (i4 == 0) {
                    uG(true);
                }
            }
            dld().u(fVar);
            if (this.iPm != null) {
                if (fVar.getPage().blq() == 0) {
                    this.iPm.setVisibility(8);
                } else {
                    this.iPm.setVisibility(0);
                }
            }
        }
    }

    public void drM() {
        com.baidu.tieba.pb.data.f pbData = djz().getPbData();
        if (pbData != null) {
            this.lNQ.vv(djz().dlz());
            this.lNQ.setData(pbData);
            this.lNQ.notifyDataSetChanged();
            ArrayList<PostData> dim = pbData.dim();
            if (pbData.getPage().blq() == 0 || dim == null || dim.size() < pbData.getPage().blp()) {
                if (com.baidu.tbadk.core.util.y.getCount(dim) == 0 || (com.baidu.tbadk.core.util.y.getCount(dim) == 1 && dim.get(0) != null && dim.get(0).dJZ() == 1)) {
                    if (dkX()) {
                        this.iPm.aq(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.iPm.aq(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().blq() == 0) {
                        this.iPm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.iPm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.iPm.bsu();
                }
            }
            dld().u(pbData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity dle() {
        return this.ltl != null ? this.ltl : dld().dle();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment dld() {
        if (this.lNO == null && this.ltl != null) {
            Fragment djL = this.ltl.djL();
            if (djL instanceof VideoPbFragment) {
                this.lNO = (VideoPbFragment) djL;
            }
        }
        return this.lNO;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel djz() {
        return dld().djz();
    }

    public BdTypeRecyclerView getListView() {
        return this.iNq;
    }

    public boolean dkX() {
        if (djz() != null) {
            return djz().getHostMode();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: drN */
    public b drK() {
        return this.lNQ;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, fVar, str, i4);
        }
    }

    public com.baidu.tieba.pb.videopb.b.b drO() {
        return this.lNR;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0822a
    public void um(boolean z) {
        this.ltX = z;
    }

    public void uK(boolean z) {
        if (z && this.lBX) {
            this.iPm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.iNq.setNextPage(this.iPm);
            this.lAW = 2;
        }
    }

    public void dnJ() {
        this.iPm.setLineVisible();
        this.iPm.startLoadData();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, true));
    }

    public void endLoadData() {
        if (this.iPm != null) {
            this.iPm.setLineGone();
            this.iPm.endLoadData();
        }
        if (dld() != null && dld().lMj != null) {
            this.lNO.lMj.chg();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, false));
    }

    public void PN(String str) {
        if (this.iPm != null) {
            this.iPm.setText(str);
        }
    }

    public void PO(String str) {
        if (this.iPm != null) {
            this.iPm.aq(str, this.topMargin);
        }
    }

    public void dnL() {
        if (this.glI != null && this.glI.isEnabled()) {
            this.glI.setRefreshing(false);
        }
    }

    public void dog() {
        if (this.lAW != 2) {
            this.iNq.setNextPage(this.iPm);
            this.lAW = 2;
        }
    }

    public void uG(boolean z) {
        this.lCu = z;
    }

    public void dng() {
        if (this.iNq == null) {
        }
    }

    public int dnM() {
        if (this.iNq != null) {
            return this.iNq.getFirstVisiblePosition();
        }
        return 0;
    }

    public int drP() {
        View childAt;
        if (this.iNq == null || this.iNq.getCount() <= 0 || (childAt = this.iNq.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int dnN() {
        if (this.iNq != null) {
            int lastVisiblePosition = this.iNq.getLastVisiblePosition();
            if (djz() != null && djz().getPbData() != null && lastVisiblePosition >= djz().getPbData().dim().size()) {
                return djz().getPbData().dim().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View dnX() {
        return this.fuw;
    }

    public int drQ() {
        return this.lNW;
    }

    public int drR() {
        return this.lNX;
    }

    public void GA(int i) {
        if (this.lNS != null) {
            this.lNS.setVisibility(i);
        }
    }

    public void vA(boolean z) {
        if (this.iNq != null) {
            this.iNq.setCanFling(z);
        }
    }

    public void de(int i, int i2) {
        if (this.iNq != null && this.iNq.getLayoutManager() != null && (this.iNq.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.iNq.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drS() {
        if (this.iNq != null && this.eeV != null && this.lNQ != null) {
            int headerViewsCount = this.iNq.getHeaderViewsCount() + this.lNQ.drF();
            int headerViewsCount2 = this.iNq.getHeaderViewsCount() + this.lNQ.drG();
            int findFirstVisibleItemPosition = this.eeV.findFirstVisibleItemPosition();
            if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
                this.lNU.FK(0);
            } else {
                this.lNU.FK(8);
            }
            if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
                this.lNV.FK(0);
                this.lNU.FK(8);
            } else {
                this.lNV.FK(8);
            }
            if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
                GA(0);
            } else {
                GA(8);
            }
        }
    }

    public boolean doz() {
        if (this.iPm == null || TextUtils.isEmpty(this.iPm.getEndText())) {
            return false;
        }
        return this.iPm.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
