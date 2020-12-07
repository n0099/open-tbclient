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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
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
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0840a {
    private int agU;
    private LinearLayoutManager ekp;
    private BdSwipeRefreshLayout gty;
    private BdTypeRecyclerView iYU;
    private PbActivity lHn;
    private boolean lIa;
    private View mRootView;
    private VideoPbFragment mci;
    private b mck;
    private com.baidu.tieba.pb.videopb.b.b mcl;
    private View mcm;
    private LinearLayout mcn;
    private au mco;
    private l mcp;
    private PbListView jaQ = null;
    private View fBr = null;
    private com.baidu.tieba.pb.view.a lPw = null;
    private boolean lQc = false;
    private boolean lQz = false;
    private boolean lRd = true;
    private int lPb = 0;
    private g mPullView = null;
    private boolean lEv = false;
    private int mcq = 0;
    private int mcr = 0;
    private boolean lHO = false;
    private RecyclerView.OnScrollListener ick = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                DetailInfoAndReplyFragment.this.dpP().dsb();
                DetailInfoAndReplyFragment.this.dpP().dvY();
            }
            if (DetailInfoAndReplyFragment.this.dpP() != null) {
                DetailInfoAndReplyFragment.this.dpP().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            DetailInfoAndReplyFragment.this.dwL();
            if (recyclerView.canScrollVertically(-1)) {
                DetailInfoAndReplyFragment.this.mcq = 2;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoAndReplyFragment.this.mcq != 0) {
                DetailInfoAndReplyFragment.this.mcm.setVisibility(8);
            }
            DetailInfoAndReplyFragment.this.mcq = 0;
        }
    };
    private final f.c fci = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (DetailInfoAndReplyFragment.this.dok() != null && DetailInfoAndReplyFragment.this.dok().vb(true)) {
                TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                DetailInfoAndReplyFragment.this.dsB();
            }
        }
    };
    private CustomMessageListener jqg = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && DetailInfoAndReplyFragment.this.dok() != null && DetailInfoAndReplyFragment.this.dok().getPbData() != null && DetailInfoAndReplyFragment.this.dok().getPbData().dmV() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = DetailInfoAndReplyFragment.this.dok().getPbData().dmV().iterator();
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
                    if (nVar != null && DetailInfoAndReplyFragment.this.mck != null && DetailInfoAndReplyFragment.this.iYU != null) {
                        DetailInfoAndReplyFragment.this.dok().getPbData().dmV().remove(nVar);
                        if (DetailInfoAndReplyFragment.this.mck.getDataList() != null) {
                            DetailInfoAndReplyFragment.this.mck.getDataList().remove(nVar);
                        }
                        if (DetailInfoAndReplyFragment.this.iYU.getListView2().getData() != null) {
                            DetailInfoAndReplyFragment.this.iYU.getListView2().getData().remove(nVar);
                        }
                        DetailInfoAndReplyFragment.this.mck.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e lJb = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (DetailInfoAndReplyFragment.this.mIsLogin) {
                if (!DetailInfoAndReplyFragment.this.lHO && DetailInfoAndReplyFragment.this.dto() && DetailInfoAndReplyFragment.this.dok() != null) {
                    ar arVar = new ar("c13999");
                    arVar.dY("tid", DetailInfoAndReplyFragment.this.dok().dqj());
                    arVar.dY("fid", DetailInfoAndReplyFragment.this.dok().getForumId());
                    arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(arVar);
                    DetailInfoAndReplyFragment.this.lHO = true;
                }
                if (DetailInfoAndReplyFragment.this.dok().va(false)) {
                    DetailInfoAndReplyFragment.this.dsz();
                    if (DetailInfoAndReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (DetailInfoAndReplyFragment.this.dok().getPbData() != null) {
                    DetailInfoAndReplyFragment.this.dsW();
                }
            }
        }
    };

    public static DetailInfoAndReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
        detailInfoAndReplyFragment.setArguments(bundle);
        detailInfoAndReplyFragment.mci = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lHn = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mcl = new com.baidu.tieba.pb.videopb.b.b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.jqg);
    }

    private void initUI() {
        this.agU = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iYU = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.ekp = new LinearLayoutManager(getContext()) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.4
            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        };
        this.iYU.setLayoutManager(this.ekp);
        this.mck = new b(this, this.iYU);
        this.mck.F(dpP().dvJ());
        this.mck.S(dpP().dvK());
        this.mck.setOnLongClickListener(dpP().dvL());
        this.mck.setOnImageClickListener(this.mcl.getOnImageClickListener());
        this.mck.setTbGestureDetector(this.mcl.dwC());
        this.mcm = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.jaQ = new PbListView(getPageContext().getPageActivity());
        this.fBr = this.jaQ.getView().findViewById(R.id.pb_more_view);
        if (this.fBr != null) {
            this.fBr.setOnClickListener(dpP().dvJ());
            ap.setBackgroundResource(this.fBr, R.drawable.pb_foot_more_trans_selector);
        }
        this.jaQ.setLineVisible();
        this.jaQ.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.jaQ.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.jaQ.bvh();
        this.iYU.setOnSrollToBottomListener(this.lJb);
        this.iYU.addOnScrollListener(this.ick);
        this.iYU.setOnTouchListener(dpP().bGL());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.fci);
        }
        if (this.gty == null) {
            this.gty = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.gty.setProgressView(this.mPullView);
            this.gty.setEnabled(false);
            ap.setBackgroundColor(this.gty, R.color.CAM_X0205);
        }
        this.mcn = (LinearLayout) this.mRootView.findViewById(R.id.video_pb_suck_container);
        dwE();
        this.mck.setOnSwitchChangeListener(dpP().lIS);
        registerListener(this.jqg);
    }

    private void dwE() {
        this.mco = new au(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
        this.mco.Zl = false;
        this.mco.U(dpP().dvJ());
        this.mco.setOnSwitchChangeListener(dpP().lIS);
        this.mco.GX(8);
        this.mcn.addView(this.mco.getRootView());
        this.mcp = new l(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
        e eVar = new e();
        eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
        this.mcp.a(eVar);
        this.mcp.GX(8);
        this.mcn.addView(this.mcp.getRootView());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        com.baidu.tieba.pb.videopb.e eVar = (com.baidu.tieba.pb.videopb.e) y.b(dpQ()).l(com.baidu.tieba.pb.videopb.e.class);
        eVar.dwq().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.5
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
        a(true, 0, 3, 0, eVar.dwh(), "", 1, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jaQ != null) {
            this.jaQ.changeSkin(i);
            if (this.fBr != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fBr);
                ap.setBackgroundResource(this.fBr, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.mco != null) {
            this.mco.onChangeSkinType(i);
        }
        if (this.mcp != null) {
            this.mcp.onChangeSkinType();
        }
        if (this.mck != null) {
            this.mck.notifyDataSetChanged();
        }
        if (this.mcm != null) {
            ap.setBackgroundResource(this.mcm, R.drawable.personalize_tab_shadow);
        }
        ap.setBackgroundColor(this.gty, R.color.CAM_X0201);
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
        this.lIa = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        vq(z);
        if (dpP() != null && dpP().maD != null) {
            this.mci.maD.dwA();
        }
        if (z && this.lIa) {
            dsz();
            dok().va(true);
        }
    }

    private void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4, boolean z2) {
        com.baidu.tieba.pb.videopb.e eVar = (com.baidu.tieba.pb.videopb.e) y.b(dpQ()).l(com.baidu.tieba.pb.videopb.e.class);
        if (z && dok() != null && fVar != null) {
            this.lEv = dok().dql();
            boolean isEnabled = this.gty.isEnabled();
            if (fVar.getPage().bnG() == 0 && this.lEv) {
                this.gty.setEnabled(false);
            } else if (!isEnabled) {
                this.gty.setEnabled(true);
                this.gty.interruptRefresh();
            }
            this.mck.setIsFromCDN(eVar.isFromCDN());
            this.mck.wb(this.lEv);
            this.mck.a(fVar, z2);
            this.lQc = false;
            if (TbadkCoreApplication.isLogin()) {
                this.iYU.setNextPage(this.jaQ);
                this.lPb = 2;
                if (dpP() != null && dpP().maD != null) {
                    this.mci.maD.ckt();
                }
            } else {
                this.lQc = true;
                if (fVar.getPage().bnF() == 1) {
                    if (this.lPw == null) {
                        this.lPw = new com.baidu.tieba.pb.view.a(this, this);
                        this.lPw.createView();
                        this.lPw.bvh();
                    }
                    this.iYU.setNextPage(this.lPw);
                } else {
                    this.iYU.setNextPage(this.jaQ);
                }
                this.lPb = 3;
            }
            if (this.mco != null) {
                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lCa);
                by dmT = fVar.dmT();
                nVar.lCc = dmT != null ? dmT.boG() : 0L;
                nVar.isNew = !dok().dql();
                nVar.lCf = dpJ();
                nVar.sortType = fVar.lAK;
                nVar.lCe = fVar.dny();
                nVar.isDynamic = fVar.dnx();
                nVar.lCg = fVar.lAJ;
                this.mco.a(nVar);
            }
            ArrayList<PostData> dmV = fVar.dmV();
            if (fVar.getPage().bnF() == 0 || dmV == null || dmV.size() < fVar.getPage().bnE()) {
                if (fVar.getPage().bnF() == 0) {
                    this.jaQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.jaQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.jaQ.bvi();
                if (fVar.getPage().bnF() == 0 || dmV == null) {
                    dsW();
                }
            } else {
                if (dok().getIsFromMark()) {
                    if (this.lRd) {
                        endLoadData();
                        if (fVar.getPage().bnF() != 0) {
                            this.jaQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.jaQ.setLineVisible();
                        this.jaQ.showLoading();
                    }
                } else {
                    this.jaQ.setLineVisible();
                    this.jaQ.showLoading();
                }
                this.jaQ.bvi();
            }
            switch (i2) {
                case 2:
                    this.iYU.setSelection(i3 > 1 ? (((this.iYU.getData() == null && fVar.dmV() == null) ? 0 : this.iYU.getData().size() - fVar.dmV().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable drJ = as.drI().drJ();
                        if (drJ instanceof RecyclerView.SavedState) {
                            this.iYU.onRestoreInstanceState(drJ);
                            if (com.baidu.tbadk.core.util.y.getCount(dmV) > 1 && fVar.getPage().bnF() > 0) {
                                this.jaQ.endLoadData();
                                this.jaQ.setText(getString(R.string.pb_load_more_without_point));
                                this.jaQ.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.lRd = false;
                    break;
                case 5:
                    this.iYU.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable drJ2 = as.drI().drJ();
                        if (drJ2 instanceof RecyclerView.SavedState) {
                            this.iYU.onRestoreInstanceState(drJ2);
                            break;
                        }
                    }
                    this.iYU.setSelection(0);
                    break;
                case 8:
                    this.iYU.setSelection(i3 > 0 ? ((this.iYU.getData() == null && fVar.dmV() == null) ? 0 : this.iYU.getData().size() - fVar.dmV().size()) + i3 : 0);
                    this.jaQ.endLoadData();
                    this.jaQ.setText(getString(R.string.pb_load_more_without_point));
                    this.jaQ.setLineGone();
                    break;
            }
            if (this.lQz) {
                drV();
                this.lQz = false;
                if (i4 == 0) {
                    vm(true);
                }
            }
            dpP().u(fVar);
            if (this.jaQ != null) {
                if (fVar.getPage().bnF() == 0) {
                    this.jaQ.setVisibility(8);
                } else {
                    this.jaQ.setVisibility(0);
                }
            }
        }
    }

    public void dwF() {
        com.baidu.tieba.pb.data.f pbData = dok().getPbData();
        if (pbData != null) {
            this.mck.wb(dok().dql());
            this.mck.setData(pbData);
            this.mck.notifyDataSetChanged();
            ArrayList<PostData> dmV = pbData.dmV();
            if (pbData.getPage().bnF() == 0 || dmV == null || dmV.size() < pbData.getPage().bnE()) {
                if (com.baidu.tbadk.core.util.y.getCount(dmV) == 0 || (com.baidu.tbadk.core.util.y.getCount(dmV) == 1 && dmV.get(0) != null && dmV.get(0).dPg() == 1)) {
                    if (dpJ()) {
                        this.jaQ.aq(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.agU);
                    } else {
                        this.jaQ.aq(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.agU);
                    }
                } else {
                    if (pbData.getPage().bnF() == 0) {
                        this.jaQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jaQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jaQ.bvi();
                }
            }
            dpP().u(pbData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity dpQ() {
        return this.lHn != null ? this.lHn : dpP().dpQ();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment dpP() {
        if (this.mci == null && this.lHn != null) {
            Fragment dow = this.lHn.dow();
            if (dow instanceof VideoPbFragment) {
                this.mci = (VideoPbFragment) dow;
            }
        }
        return this.mci;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel dok() {
        return dpP().dok();
    }

    public BdTypeRecyclerView getListView() {
        return this.iYU;
    }

    public boolean dpJ() {
        if (dok() != null) {
            return dok().getHostMode();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: dwG */
    public b dwD() {
        return this.mck;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            a(z, i, i2, i3, fVar, str, i4, false);
        }
    }

    public com.baidu.tieba.pb.videopb.b.b dwH() {
        return this.mcl;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0840a
    public void uR(boolean z) {
        this.lIa = z;
    }

    public void vq(boolean z) {
        if (z && this.lQc) {
            this.jaQ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.iYU.setNextPage(this.jaQ);
            this.lPb = 2;
        }
    }

    public void dsz() {
        this.jaQ.setLineVisible();
        this.jaQ.startLoadData();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, true));
    }

    public void endLoadData() {
        if (this.jaQ != null) {
            this.jaQ.setLineGone();
            this.jaQ.endLoadData();
        }
        if (dpP() != null && dpP().maD != null) {
            this.mci.maD.ckt();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, false));
    }

    public void Qr(String str) {
        if (this.jaQ != null) {
            this.jaQ.setText(str);
        }
    }

    public void Qs(String str) {
        if (this.jaQ != null) {
            this.jaQ.aq(str, this.agU);
        }
    }

    public void dsB() {
        if (this.gty != null && this.gty.isEnabled()) {
            this.gty.setRefreshing(false);
        }
    }

    public void dsW() {
        if (this.lPb != 2) {
            this.iYU.setNextPage(this.jaQ);
            this.lPb = 2;
        }
    }

    public void vm(boolean z) {
        this.lQz = z;
    }

    public void drV() {
        if (this.iYU == null) {
        }
    }

    public int dsC() {
        if (this.iYU != null) {
            return this.iYU.getFirstVisiblePosition();
        }
        return 0;
    }

    public int dwI() {
        View childAt;
        if (this.iYU == null || this.iYU.getCount() <= 0 || (childAt = this.iYU.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int dsD() {
        if (this.iYU != null) {
            int lastVisiblePosition = this.iYU.getLastVisiblePosition();
            if (dok() != null && dok().getPbData() != null && lastVisiblePosition >= dok().getPbData().dmV().size()) {
                return dok().getPbData().dmV().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View dsN() {
        return this.fBr;
    }

    public int dwJ() {
        return this.mcq;
    }

    public int dwK() {
        return this.mcr;
    }

    public void HP(int i) {
        if (this.mcm != null) {
            this.mcm.setVisibility(i);
        }
    }

    public void wh(boolean z) {
        if (this.iYU != null) {
            this.iYU.setCanFling(z);
        }
    }

    public void dj(int i, int i2) {
        if (this.iYU != null && this.iYU.getLayoutManager() != null && (this.iYU.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.iYU.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwL() {
        if (this.iYU != null && this.ekp != null && this.mck != null) {
            int headerViewsCount = this.iYU.getHeaderViewsCount() + this.mck.dwy();
            int headerViewsCount2 = this.iYU.getHeaderViewsCount() + this.mck.dwz();
            int findFirstVisibleItemPosition = this.ekp.findFirstVisibleItemPosition();
            if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
                this.mco.GX(0);
            } else {
                this.mco.GX(8);
            }
            if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
                this.mcp.GX(0);
                this.mco.GX(8);
            } else {
                this.mcp.GX(8);
            }
            if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
                HP(0);
            } else {
                HP(8);
            }
        }
    }

    public boolean dto() {
        if (this.jaQ == null || TextUtils.isEmpty(this.jaQ.getEndText())) {
            return false;
        }
        return this.jaQ.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
