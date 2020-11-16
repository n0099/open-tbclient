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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
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
/* loaded from: classes21.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0824a {
    private BdSwipeRefreshLayout glp;
    private BdTypeRecyclerView iOd;
    private VideoPbFragment lOe;
    private b lOh;
    private View lOi;
    private c lOt;
    private MultiNestedLayout lOu;
    private com.baidu.tieba.pb.videopb.videoView.b lOv;
    private View lOw;
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
    private RecyclerView.OnScrollListener hRq = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.dkA().dmK();
                ReplyFragment.this.dkA().dqF();
            }
            if (ReplyFragment.this.dkA() != null) {
                ReplyFragment.this.dkA().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.lOm = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.lOm != 0) {
                ReplyFragment.this.lOi.setVisibility(8);
            }
            ReplyFragment.this.lOm = 0;
        }
    };
    private MultiNestedLayout.b lOx = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void iS(int i) {
            if (ReplyFragment.this.lOn != 1 || i == 1 || ReplyFragment.this.lOm == 0) {
                if (ReplyFragment.this.lOn != 0 || i == 0) {
                    if (ReplyFragment.this.lOn != 0 && i == 0) {
                        ReplyFragment.this.dkA().GY(8);
                    }
                } else if (ReplyFragment.this.lOi.getVisibility() != 0) {
                    ReplyFragment.this.dkA().GY(0);
                }
            } else {
                ReplyFragment.this.dkA().GY(8);
                ReplyFragment.this.lOi.setVisibility(0);
            }
            ReplyFragment.this.lOn = i;
        }
    };
    private final f.c eUM = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.diV() != null && ReplyFragment.this.diV().uz(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.dnj();
            }
        }
    };
    private CustomMessageListener jcD = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && ReplyFragment.this.diV() != null && ReplyFragment.this.diV().getPbData() != null && ReplyFragment.this.diV().getPbData().dhJ() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = ReplyFragment.this.diV().getPbData().dhJ().iterator();
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
                    if (nVar != null && ReplyFragment.this.lOt != null && ReplyFragment.this.iOd != null) {
                        ReplyFragment.this.diV().getPbData().dhJ().remove(nVar);
                        if (ReplyFragment.this.lOt.getDataList() != null) {
                            ReplyFragment.this.lOt.getDataList().remove(nVar);
                        }
                        if (ReplyFragment.this.iOd.getListView2().getData() != null) {
                            ReplyFragment.this.iOd.getListView2().getData().remove(nVar);
                        }
                        ReplyFragment.this.lOt.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e lvo = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (!ReplyFragment.this.luc && ReplyFragment.this.dnY() && ReplyFragment.this.diV() != null) {
                    ar arVar = new ar("c13999");
                    arVar.dR("tid", ReplyFragment.this.diV().dkU());
                    arVar.dR("fid", ReplyFragment.this.diV().getForumId());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(arVar);
                    ReplyFragment.this.luc = true;
                }
                if (ReplyFragment.this.diV().uy(false)) {
                    ReplyFragment.this.dnh();
                    if (ReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (ReplyFragment.this.diV().getPbData() != null) {
                    ReplyFragment.this.dnF();
                }
            }
        }
    };

    public static ReplyFragment ae(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.lOe = videoPbFragment;
        return replyFragment;
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
        this.lOh = new b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.jcD);
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.lOu = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.lOu.setScrollStateChangeListener(this.lOx);
        this.iOd = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.iOd.setLayoutManager(new LinearLayoutManager(getContext()));
        this.lOt = new c(this, this.iOd);
        this.lOt.F(dkA().dqq());
        this.lOt.S(dkA().dqr());
        this.lOt.setOnLongClickListener(dkA().dqs());
        this.lOt.setOnImageClickListener(this.lOh.getOnImageClickListener());
        this.lOt.setTbGestureDetector(this.lOh.drj());
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
        this.lOw = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.lOv = new com.baidu.tieba.pb.videopb.videoView.b(this.lOw);
        this.lOv.X(dkA().dqq());
        this.lOv.setOnSwitchChangeListener(dkA().lvf);
        registerListener(this.jcD);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e eVar = (e) y.b(dkB()).l(e.class);
        eVar.dqX().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
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
        d(true, 0, 3, 0, eVar.dqO(), "", 1);
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
        if (this.lOv != null) {
            this.lOv.onChangeSkinType(i);
        }
        if (this.lOt != null) {
            this.lOt.notifyDataSetChanged();
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

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        e eVar = (e) y.b(dkB()).l(e.class);
        if (z && diV() != null && fVar != null) {
            this.lqM = diV().dkW();
            boolean isEnabled = this.glp.isEnabled();
            if (fVar.getPage().bkt() == 0 && this.lqM) {
                this.glp.setEnabled(false);
            } else if (!isEnabled) {
                this.glp.setEnabled(true);
                this.glp.interruptRefresh();
            }
            this.lOt.setIsFromCDN(eVar.isFromCDN());
            this.lOt.vy(this.lqM);
            this.lOt.setData(fVar);
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
            if (this.lOv != null && this.lOw != null) {
                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.loE);
                bx dhH = fVar.dhH();
                nVar.loG = dhH != null ? dhH.blt() : 0L;
                nVar.isNew = !diV().dkW();
                nVar.loJ = dku();
                nVar.sortType = fVar.lnl;
                nVar.loI = fVar.dil();
                nVar.isDynamic = fVar.dik();
                nVar.loK = fVar.lnk;
                this.lOv.a(nVar);
            }
            ArrayList<PostData> dhJ = fVar.dhJ();
            if (fVar.getPage().bks() == 0 || dhJ == null || dhJ.size() < fVar.getPage().bkr()) {
                if (com.baidu.tbadk.core.util.y.getCount(dhJ) == 0 || (com.baidu.tbadk.core.util.y.getCount(dhJ) == 1 && dhJ.get(0) != null && dhJ.get(0).dJQ() == 1)) {
                    if (dku()) {
                        this.iPZ.ap(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.iPZ.ap(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (fVar.getPage().bks() == 0) {
                        this.iPZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.iPZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.iPZ.brJ();
                }
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
                    int size = (this.iOd.getData() == null && fVar.dhJ() == null) ? 0 : this.iOd.getData().size() - fVar.dhJ().size();
                    this.lOu.setMaxOffset();
                    this.iOd.setSelection(i3 > 0 ? size + i3 : 0);
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
        }
    }

    public void drm() {
        com.baidu.tieba.pb.data.f pbData = diV().getPbData();
        if (pbData != null) {
            this.lOt.vy(diV().dkW());
            this.lOt.setData(pbData);
            this.lOt.notifyDataSetChanged();
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
    /* renamed from: dry */
    public c drk() {
        return this.lOt;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, fVar, str, i4);
        }
    }

    public b dro() {
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
    }

    public void endLoadData() {
        if (this.iPZ != null) {
            this.iPZ.setLineGone();
            this.iPZ.endLoadData();
        }
        if (dkA() != null && dkA().lMB != null) {
            this.lOe.lMB.cgz();
        }
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

    public boolean dnY() {
        if (this.iPZ == null || TextUtils.isEmpty(this.iPZ.getEndText())) {
            return false;
        }
        return this.iPZ.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
