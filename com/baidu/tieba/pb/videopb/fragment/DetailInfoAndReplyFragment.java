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
import com.baidu.tbadk.core.data.bx;
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
/* loaded from: classes21.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0824a {
    private LinearLayoutManager edo;
    private BdSwipeRefreshLayout glp;
    private BdTypeRecyclerView iOd;
    private VideoPbFragment lOe;
    private b lOg;
    private com.baidu.tieba.pb.videopb.b.b lOh;
    private View lOi;
    private LinearLayout lOj;
    private au lOk;
    private l lOl;
    private PbActivity ltC;
    private boolean lun;
    private View mRootView;
    private int topMargin;
    private PbListView iPZ = null;
    private View ftG = null;
    private com.baidu.tieba.pb.view.a lBJ = null;
    private boolean lCp = false;
    private boolean lCM = false;
    private boolean lDm = true;
    private int lBo = 0;
    private g mPullView = null;
    private boolean lqM = false;
    private int lOm = 0;
    private int lOn = 0;
    private boolean luc = false;
    private RecyclerView.OnScrollListener hRq = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                DetailInfoAndReplyFragment.this.dkA().dmK();
                DetailInfoAndReplyFragment.this.dkA().dqF();
            }
            if (DetailInfoAndReplyFragment.this.dkA() != null) {
                DetailInfoAndReplyFragment.this.dkA().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            DetailInfoAndReplyFragment.this.drs();
            if (recyclerView.canScrollVertically(-1)) {
                DetailInfoAndReplyFragment.this.lOm = 2;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoAndReplyFragment.this.lOm != 0) {
                DetailInfoAndReplyFragment.this.lOi.setVisibility(8);
            }
            DetailInfoAndReplyFragment.this.lOm = 0;
        }
    };
    private final f.c eUM = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (DetailInfoAndReplyFragment.this.diV() != null && DetailInfoAndReplyFragment.this.diV().uz(true)) {
                TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                DetailInfoAndReplyFragment.this.dnj();
            }
        }
    };
    private CustomMessageListener jcD = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && DetailInfoAndReplyFragment.this.diV() != null && DetailInfoAndReplyFragment.this.diV().getPbData() != null && DetailInfoAndReplyFragment.this.diV().getPbData().dhJ() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = DetailInfoAndReplyFragment.this.diV().getPbData().dhJ().iterator();
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
                    if (nVar != null && DetailInfoAndReplyFragment.this.lOg != null && DetailInfoAndReplyFragment.this.iOd != null) {
                        DetailInfoAndReplyFragment.this.diV().getPbData().dhJ().remove(nVar);
                        if (DetailInfoAndReplyFragment.this.lOg.getDataList() != null) {
                            DetailInfoAndReplyFragment.this.lOg.getDataList().remove(nVar);
                        }
                        if (DetailInfoAndReplyFragment.this.iOd.getListView2().getData() != null) {
                            DetailInfoAndReplyFragment.this.iOd.getListView2().getData().remove(nVar);
                        }
                        DetailInfoAndReplyFragment.this.lOg.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e lvo = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (DetailInfoAndReplyFragment.this.mIsLogin) {
                if (!DetailInfoAndReplyFragment.this.luc && DetailInfoAndReplyFragment.this.dnY() && DetailInfoAndReplyFragment.this.diV() != null) {
                    ar arVar = new ar("c13999");
                    arVar.dR("tid", DetailInfoAndReplyFragment.this.diV().dkU());
                    arVar.dR("fid", DetailInfoAndReplyFragment.this.diV().getForumId());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(arVar);
                    DetailInfoAndReplyFragment.this.luc = true;
                }
                if (DetailInfoAndReplyFragment.this.diV().uy(false)) {
                    DetailInfoAndReplyFragment.this.dnh();
                    if (DetailInfoAndReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (DetailInfoAndReplyFragment.this.diV().getPbData() != null) {
                    DetailInfoAndReplyFragment.this.dnF();
                }
            }
        }
    };

    public static DetailInfoAndReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
        detailInfoAndReplyFragment.setArguments(bundle);
        detailInfoAndReplyFragment.lOe = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.ltC = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lOh = new com.baidu.tieba.pb.videopb.b.b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.jcD);
    }

    private void initUI() {
        this.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iOd = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.edo = new LinearLayoutManager(getContext()) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.4
            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        };
        this.iOd.setLayoutManager(this.edo);
        this.lOg = new b(this, this.iOd);
        this.lOg.F(dkA().dqq());
        this.lOg.S(dkA().dqr());
        this.lOg.setOnLongClickListener(dkA().dqs());
        this.lOg.setOnImageClickListener(this.lOh.getOnImageClickListener());
        this.lOg.setTbGestureDetector(this.lOh.drj());
        this.lOi = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.iPZ = new PbListView(getPageContext().getPageActivity());
        this.ftG = this.iPZ.getView().findViewById(R.id.pb_more_view);
        if (this.ftG != null) {
            this.ftG.setOnClickListener(dkA().dqq());
            ap.setBackgroundResource(this.ftG, R.drawable.pb_foot_more_trans_selector);
        }
        this.iPZ.setLineVisible();
        this.iPZ.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.iPZ.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.iPZ.brI();
        this.iOd.setOnSrollToBottomListener(this.lvo);
        this.iOd.addOnScrollListener(this.hRq);
        this.iOd.setOnTouchListener(dkA().bDk());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.eUM);
        }
        if (this.glp == null) {
            this.glp = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.glp.setProgressView(this.mPullView);
            this.glp.setEnabled(false);
            ap.setBackgroundColor(this.glp, R.color.CAM_X0205);
        }
        this.lOj = (LinearLayout) this.mRootView.findViewById(R.id.video_pb_suck_container);
        drl();
        this.lOg.setOnSwitchChangeListener(dkA().lvf);
        registerListener(this.jcD);
    }

    private void drl() {
        this.lOk = new au(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
        this.lOk.Yo = false;
        this.lOk.U(dkA().dqq());
        this.lOk.setOnSwitchChangeListener(dkA().lvf);
        this.lOk.Gi(8);
        this.lOj.addView(this.lOk.getRootView());
        this.lOl = new l(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
        e eVar = new e();
        eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
        this.lOl.a(eVar);
        this.lOl.Gi(8);
        this.lOj.addView(this.lOl.getRootView());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        com.baidu.tieba.pb.videopb.e eVar = (com.baidu.tieba.pb.videopb.e) y.b(dkB()).l(com.baidu.tieba.pb.videopb.e.class);
        eVar.dqX().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.5
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
        a(true, 0, 3, 0, eVar.dqO(), "", 1, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iPZ != null) {
            this.iPZ.changeSkin(i);
            if (this.ftG != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.ftG);
                ap.setBackgroundResource(this.ftG, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.lOk != null) {
            this.lOk.onChangeSkinType(i);
        }
        if (this.lOl != null) {
            this.lOl.onChangeSkinType();
        }
        if (this.lOg != null) {
            this.lOg.notifyDataSetChanged();
        }
        if (this.lOi != null) {
            ap.setBackgroundResource(this.lOi, R.drawable.personalize_tab_shadow);
        }
        ap.setBackgroundColor(this.glp, R.color.CAM_X0201);
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
        this.lun = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        uN(z);
        if (dkA() != null && dkA().lMB != null) {
            this.lOe.lMB.drh();
        }
        if (z && this.lun) {
            dnh();
            diV().uy(true);
        }
    }

    private void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4, boolean z2) {
        com.baidu.tieba.pb.videopb.e eVar = (com.baidu.tieba.pb.videopb.e) y.b(dkB()).l(com.baidu.tieba.pb.videopb.e.class);
        if (z && diV() != null && fVar != null) {
            this.lqM = diV().dkW();
            boolean isEnabled = this.glp.isEnabled();
            if (fVar.getPage().bkt() == 0 && this.lqM) {
                this.glp.setEnabled(false);
            } else if (!isEnabled) {
                this.glp.setEnabled(true);
                this.glp.interruptRefresh();
            }
            this.lOg.setIsFromCDN(eVar.isFromCDN());
            this.lOg.vy(this.lqM);
            this.lOg.a(fVar, z2);
            this.lCp = false;
            if (TbadkCoreApplication.isLogin()) {
                this.iOd.setNextPage(this.iPZ);
                this.lBo = 2;
                if (dkA() != null && dkA().lMB != null) {
                    this.lOe.lMB.cgz();
                }
            } else {
                this.lCp = true;
                if (fVar.getPage().bks() == 1) {
                    if (this.lBJ == null) {
                        this.lBJ = new com.baidu.tieba.pb.view.a(this, this);
                        this.lBJ.createView();
                        this.lBJ.brI();
                    }
                    this.iOd.setNextPage(this.lBJ);
                } else {
                    this.iOd.setNextPage(this.iPZ);
                }
                this.lBo = 3;
            }
            if (this.lOk != null) {
                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.loE);
                bx dhH = fVar.dhH();
                nVar.loG = dhH != null ? dhH.blt() : 0L;
                nVar.isNew = !diV().dkW();
                nVar.loJ = dku();
                nVar.sortType = fVar.lnl;
                nVar.loI = fVar.dil();
                nVar.isDynamic = fVar.dik();
                nVar.loK = fVar.lnk;
                this.lOk.a(nVar);
            }
            ArrayList<PostData> dhJ = fVar.dhJ();
            if (fVar.getPage().bks() == 0 || dhJ == null || dhJ.size() < fVar.getPage().bkr()) {
                if (fVar.getPage().bks() == 0) {
                    this.iPZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.iPZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.iPZ.brJ();
                if (fVar.getPage().bks() == 0 || dhJ == null) {
                    dnF();
                }
            } else {
                if (diV().getIsFromMark()) {
                    if (this.lDm) {
                        endLoadData();
                        if (fVar.getPage().bks() != 0) {
                            this.iPZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.iPZ.setLineVisible();
                        this.iPZ.showLoading();
                    }
                } else {
                    this.iPZ.setLineVisible();
                    this.iPZ.showLoading();
                }
                this.iPZ.brJ();
            }
            switch (i2) {
                case 2:
                    this.iOd.setSelection(i3 > 1 ? (((this.iOd.getData() == null && fVar.dhJ() == null) ? 0 : this.iOd.getData().size() - fVar.dhJ().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable dms = as.dmr().dms();
                        if (dms instanceof RecyclerView.SavedState) {
                            this.iOd.onRestoreInstanceState(dms);
                            if (com.baidu.tbadk.core.util.y.getCount(dhJ) > 1 && fVar.getPage().bks() > 0) {
                                this.iPZ.endLoadData();
                                this.iPZ.setText(getString(R.string.pb_load_more_without_point));
                                this.iPZ.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.lDm = false;
                    break;
                case 5:
                    this.iOd.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable dms2 = as.dmr().dms();
                        if (dms2 instanceof RecyclerView.SavedState) {
                            this.iOd.onRestoreInstanceState(dms2);
                            break;
                        }
                    }
                    this.iOd.setSelection(0);
                    break;
                case 8:
                    this.iOd.setSelection(i3 > 0 ? ((this.iOd.getData() == null && fVar.dhJ() == null) ? 0 : this.iOd.getData().size() - fVar.dhJ().size()) + i3 : 0);
                    this.iPZ.endLoadData();
                    this.iPZ.setText(getString(R.string.pb_load_more_without_point));
                    this.iPZ.setLineGone();
                    break;
            }
            if (this.lCM) {
                dmE();
                this.lCM = false;
                if (i4 == 0) {
                    uJ(true);
                }
            }
            dkA().u(fVar);
            if (this.iPZ != null) {
                if (fVar.getPage().bks() == 0) {
                    this.iPZ.setVisibility(8);
                } else {
                    this.iPZ.setVisibility(0);
                }
            }
        }
    }

    public void drm() {
        com.baidu.tieba.pb.data.f pbData = diV().getPbData();
        if (pbData != null) {
            this.lOg.vy(diV().dkW());
            this.lOg.setData(pbData);
            this.lOg.notifyDataSetChanged();
            ArrayList<PostData> dhJ = pbData.dhJ();
            if (pbData.getPage().bks() == 0 || dhJ == null || dhJ.size() < pbData.getPage().bkr()) {
                if (com.baidu.tbadk.core.util.y.getCount(dhJ) == 0 || (com.baidu.tbadk.core.util.y.getCount(dhJ) == 1 && dhJ.get(0) != null && dhJ.get(0).dJQ() == 1)) {
                    if (dku()) {
                        this.iPZ.ap(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.iPZ.ap(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().bks() == 0) {
                        this.iPZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.iPZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.iPZ.brJ();
                }
            }
            dkA().u(pbData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity dkB() {
        return this.ltC != null ? this.ltC : dkA().dkB();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment dkA() {
        if (this.lOe == null && this.ltC != null) {
            Fragment djh = this.ltC.djh();
            if (djh instanceof VideoPbFragment) {
                this.lOe = (VideoPbFragment) djh;
            }
        }
        return this.lOe;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel diV() {
        return dkA().diV();
    }

    public BdTypeRecyclerView getListView() {
        return this.iOd;
    }

    public boolean dku() {
        if (diV() != null) {
            return diV().getHostMode();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: drn */
    public b drk() {
        return this.lOg;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            a(z, i, i2, i3, fVar, str, i4, false);
        }
    }

    public com.baidu.tieba.pb.videopb.b.b dro() {
        return this.lOh;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0824a
    public void up(boolean z) {
        this.lun = z;
    }

    public void uN(boolean z) {
        if (z && this.lCp) {
            this.iPZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.iOd.setNextPage(this.iPZ);
            this.lBo = 2;
        }
    }

    public void dnh() {
        this.iPZ.setLineVisible();
        this.iPZ.startLoadData();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, true));
    }

    public void endLoadData() {
        if (this.iPZ != null) {
            this.iPZ.setLineGone();
            this.iPZ.endLoadData();
        }
        if (dkA() != null && dkA().lMB != null) {
            this.lOe.lMB.cgz();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, false));
    }

    public void Pj(String str) {
        if (this.iPZ != null) {
            this.iPZ.setText(str);
        }
    }

    public void Pk(String str) {
        if (this.iPZ != null) {
            this.iPZ.ap(str, this.topMargin);
        }
    }

    public void dnj() {
        if (this.glp != null && this.glp.isEnabled()) {
            this.glp.setRefreshing(false);
        }
    }

    public void dnF() {
        if (this.lBo != 2) {
            this.iOd.setNextPage(this.iPZ);
            this.lBo = 2;
        }
    }

    public void uJ(boolean z) {
        this.lCM = z;
    }

    public void dmE() {
        if (this.iOd == null) {
        }
    }

    public int dnk() {
        if (this.iOd != null) {
            return this.iOd.getFirstVisiblePosition();
        }
        return 0;
    }

    public int drp() {
        View childAt;
        if (this.iOd == null || this.iOd.getCount() <= 0 || (childAt = this.iOd.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int dnl() {
        if (this.iOd != null) {
            int lastVisiblePosition = this.iOd.getLastVisiblePosition();
            if (diV() != null && diV().getPbData() != null && lastVisiblePosition >= diV().getPbData().dhJ().size()) {
                return diV().getPbData().dhJ().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View dnw() {
        return this.ftG;
    }

    public int drq() {
        return this.lOm;
    }

    public int drr() {
        return this.lOn;
    }

    public void GY(int i) {
        if (this.lOi != null) {
            this.lOi.setVisibility(i);
        }
    }

    public void vD(boolean z) {
        if (this.iOd != null) {
            this.iOd.setCanFling(z);
        }
    }

    public void de(int i, int i2) {
        if (this.iOd != null && this.iOd.getLayoutManager() != null && (this.iOd.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.iOd.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drs() {
        if (this.iOd != null && this.edo != null && this.lOg != null) {
            int headerViewsCount = this.iOd.getHeaderViewsCount() + this.lOg.drf();
            int headerViewsCount2 = this.iOd.getHeaderViewsCount() + this.lOg.drg();
            int findFirstVisibleItemPosition = this.edo.findFirstVisibleItemPosition();
            if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
                this.lOk.Gi(0);
            } else {
                this.lOk.Gi(8);
            }
            if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
                this.lOl.Gi(0);
                this.lOk.Gi(8);
            } else {
                this.lOl.Gi(8);
            }
            if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
                GY(0);
            } else {
                GY(8);
            }
        }
    }

    public boolean dnY() {
        if (this.iPZ == null || TextUtils.isEmpty(this.iPZ.getEndText())) {
            return false;
        }
        return this.iPZ.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
