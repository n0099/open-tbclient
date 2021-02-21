package com.baidu.tieba.pb.videopb.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbChildTitleViewHolder;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbReplyTitleViewHolder;
import com.baidu.tieba.pb.pb.main.aj;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.videopb.a.b;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0844a {
    private LinearLayoutManager eqM;
    private BdSwipeRefreshLayout gCQ;
    private BdTypeRecyclerView jmy;
    private boolean lRY;
    private PbActivity lRi;
    private View mRootView;
    private VideoPbFragment mmh;
    private b mmj;
    private com.baidu.tieba.pb.videopb.b.b mmk;
    private View mml;
    private LinearLayout mmm;
    private PbReplyTitleViewHolder mmn;
    private PbChildTitleViewHolder mmo;
    private int topMargin;
    private PbListView jot = null;
    private View fIC = null;
    private com.baidu.tieba.pb.view.a lZq = null;
    private boolean lZX = false;
    private boolean maw = false;
    private boolean mbb = true;
    private int lYV = 0;
    private g mPullView = null;
    private boolean lOk = false;
    private int mmp = 0;
    private int mmq = 0;
    private boolean lRM = false;
    private RecyclerView.OnScrollListener ipZ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                DetailInfoAndReplyFragment.this.dog().dqs();
                DetailInfoAndReplyFragment.this.dog().duq();
            }
            if (DetailInfoAndReplyFragment.this.dog() != null) {
                DetailInfoAndReplyFragment.this.dog().onScrollStateChanged(i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            DetailInfoAndReplyFragment.this.dve();
            if (recyclerView.canScrollVertically(-1)) {
                DetailInfoAndReplyFragment.this.mmp = 2;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoAndReplyFragment.this.mmp != 0) {
                DetailInfoAndReplyFragment.this.mml.setVisibility(8);
            }
            DetailInfoAndReplyFragment.this.mmp = 0;
        }
    };
    private final f.c fjz = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (DetailInfoAndReplyFragment.this.dmx() != null && DetailInfoAndReplyFragment.this.dmx().vn(true)) {
                TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                DetailInfoAndReplyFragment.this.dqU();
            }
        }
    };
    private CustomMessageListener jpA = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && DetailInfoAndReplyFragment.this.dmx() != null && DetailInfoAndReplyFragment.this.dmx().getPbData() != null && DetailInfoAndReplyFragment.this.dmx().getPbData().dli() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = DetailInfoAndReplyFragment.this.dmx().getPbData().dli().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            oVar = null;
                            break;
                        }
                        PostData next = it.next();
                        if ((next instanceof o) && str.equals(((o) next).getAdId())) {
                            oVar = (o) next;
                            break;
                        }
                    }
                    if (oVar != null && DetailInfoAndReplyFragment.this.mmj != null && DetailInfoAndReplyFragment.this.jmy != null) {
                        DetailInfoAndReplyFragment.this.dmx().getPbData().dli().remove(oVar);
                        if (DetailInfoAndReplyFragment.this.mmj.getDataList() != null) {
                            DetailInfoAndReplyFragment.this.mmj.getDataList().remove(oVar);
                        }
                        if (DetailInfoAndReplyFragment.this.jmy.getListView2().getData() != null) {
                            DetailInfoAndReplyFragment.this.jmy.getListView2().getData().remove(oVar);
                        }
                        DetailInfoAndReplyFragment.this.mmj.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e lSZ = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (DetailInfoAndReplyFragment.this.mIsLogin) {
                if (!DetailInfoAndReplyFragment.this.lRM && DetailInfoAndReplyFragment.this.drH() && DetailInfoAndReplyFragment.this.dmx() != null) {
                    ar arVar = new ar("c13999");
                    arVar.dR("tid", DetailInfoAndReplyFragment.this.dmx().doA());
                    arVar.dR("fid", DetailInfoAndReplyFragment.this.dmx().getForumId());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(arVar);
                    DetailInfoAndReplyFragment.this.lRM = true;
                }
                if (DetailInfoAndReplyFragment.this.dmx().vm(false)) {
                    DetailInfoAndReplyFragment.this.dqS();
                    if (DetailInfoAndReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (DetailInfoAndReplyFragment.this.dmx().getPbData() != null) {
                    DetailInfoAndReplyFragment.this.drp();
                }
            }
        }
    };

    public static DetailInfoAndReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
        detailInfoAndReplyFragment.setArguments(bundle);
        detailInfoAndReplyFragment.mmh = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lRi = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mmk = new com.baidu.tieba.pb.videopb.b.b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mmj != null) {
            this.mmj.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.jpA);
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jmy = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.eqM = new LinearLayoutManager(getContext()) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.4
            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        };
        this.jmy.setLayoutManager(this.eqM);
        this.mmj = new b(this, this.jmy);
        this.mmj.H(dog().duc());
        this.mmj.U(dog().dud());
        this.mmj.setOnLongClickListener(dog().due());
        this.mmj.setOnImageClickListener(this.mmk.getOnImageClickListener());
        this.mmj.setTbGestureDetector(this.mmk.duV());
        this.mml = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.jot = new PbListView(getPageContext().getPageActivity());
        this.fIC = this.jot.getView().findViewById(R.id.pb_more_view);
        if (this.fIC != null) {
            this.fIC.setOnClickListener(dog().duc());
            ap.setBackgroundResource(this.fIC, R.drawable.pb_foot_more_trans_selector);
        }
        this.jot.setLineVisible();
        this.jot.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.jot.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.jot.bud();
        this.jmy.setOnSrollToBottomListener(this.lSZ);
        this.jmy.addOnScrollListener(this.ipZ);
        this.jmy.setOnTouchListener(dog().bFG());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.fjz);
        }
        if (this.gCQ == null) {
            this.gCQ = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.gCQ.setProgressView(this.mPullView);
            this.gCQ.setEnabled(false);
            ap.setBackgroundColor(this.gCQ, R.color.CAM_X0205);
        }
        this.mmm = (LinearLayout) this.mRootView.findViewById(R.id.video_pb_suck_container);
        duX();
        this.mmj.setOnSwitchChangeListener(dog().lSQ);
        registerListener(this.jpA);
    }

    private void duX() {
        this.mmn = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
        this.mmn.ZO = false;
        this.mmn.W(dog().duc());
        this.mmn.setOnSwitchChangeListener(dog().lSQ);
        this.mmn.FC(8);
        this.mmm.addView(this.mmn.getRootView());
        this.mmo = new PbChildTitleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
        e eVar = new e();
        eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
        this.mmo.a(eVar);
        this.mmo.FC(8);
        this.mmm.addView(this.mmo.getRootView());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(doh()).get(VideoPbViewModel.class);
        videoPbViewModel.cMS().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    DetailInfoAndReplyFragment.this.showLoadingView();
                } else {
                    DetailInfoAndReplyFragment.this.hideLoadingView();
                }
            }
        });
        a(true, 0, 3, 0, videoPbViewModel.duz(), "", 1, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jot != null) {
            this.jot.changeSkin(i);
            if (this.fIC != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fIC);
                ap.setBackgroundResource(this.fIC, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.mmn != null) {
            this.mmn.onChangeSkinType(i);
        }
        if (this.mmo != null) {
            this.mmo.onChangeSkinType();
        }
        if (this.mmj != null) {
            this.mmj.notifyDataSetChanged();
        }
        if (this.mml != null) {
            ap.setBackgroundResource(this.mml, R.drawable.personalize_tab_shadow);
        }
        ap.setBackgroundColor(this.gCQ, R.color.CAM_X0201);
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.lRY = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        vC(z);
        if (dog() != null && dog().mkD != null) {
            this.mmh.mkD.duT();
        }
        if (z && this.lRY) {
            dqS();
            dmx().vm(true);
        }
    }

    private void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4, boolean z2) {
        final int i5;
        cb dlg;
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(doh()).get(VideoPbViewModel.class);
        if (z && dmx() != null && fVar != null) {
            this.lOk = dmx().doC();
            boolean isEnabled = this.gCQ.isEnabled();
            if (fVar.getPage().bmG() == 0 && this.lOk) {
                this.gCQ.setEnabled(false);
            } else if (!isEnabled) {
                this.gCQ.setEnabled(true);
                this.gCQ.interruptRefresh();
            }
            this.mmj.setIsFromCDN(videoPbViewModel.isFromCDN());
            this.mmj.wp(this.lOk);
            this.mmj.a(fVar, z2);
            this.lZX = false;
            if (TbadkCoreApplication.isLogin()) {
                this.jmy.setNextPage(this.jot);
                this.lYV = 2;
                if (dog() != null && dog().mkD != null) {
                    this.mmh.mkD.ckx();
                }
            } else {
                this.lZX = true;
                if (fVar.getPage().bmF() == 1) {
                    if (this.lZq == null) {
                        this.lZq = new com.baidu.tieba.pb.view.a(this, this);
                        this.lZq.createView();
                        this.lZq.bud();
                    }
                    this.jmy.setNextPage(this.lZq);
                } else {
                    this.jmy.setNextPage(this.jot);
                }
                this.lYV = 3;
            }
            if (this.mmn != null) {
                com.baidu.tieba.pb.data.o oVar = new com.baidu.tieba.pb.data.o(com.baidu.tieba.pb.data.o.lLF);
                oVar.lLH = fVar.dlg() != null ? dlg.bnH() : 0L;
                oVar.isNew = !dmx().doC();
                oVar.lLK = doa();
                oVar.sortType = fVar.lKn;
                oVar.lLJ = fVar.dlK();
                oVar.isDynamic = fVar.dlJ();
                oVar.lLL = fVar.lKm;
                this.mmn.a(oVar);
            }
            ArrayList<PostData> dli = fVar.dli();
            if (fVar.getPage().bmF() == 0 || dli == null || dli.size() < fVar.getPage().bmE()) {
                if (fVar.getPage().bmF() == 0) {
                    this.jot.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.jot.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.jot.bue();
                if (fVar.getPage().bmF() == 0 || dli == null) {
                    drp();
                }
            } else {
                if (dmx().getIsFromMark()) {
                    if (this.mbb) {
                        endLoadData();
                        if (fVar.getPage().bmF() != 0) {
                            this.jot.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.jot.setLineVisible();
                        this.jot.showLoading();
                    }
                } else {
                    this.jot.setLineVisible();
                    this.jot.showLoading();
                }
                this.jot.bue();
            }
            switch (i2) {
                case 2:
                    this.jmy.setSelection(i3 > 1 ? (((this.jmy.getData() == null && fVar.dli() == null) ? 0 : this.jmy.getData().size() - fVar.dli().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable dqa = aj.dpZ().dqa();
                        if (dqa instanceof RecyclerView.SavedState) {
                            this.jmy.onRestoreInstanceState(dqa);
                            if (y.getCount(dli) > 1 && fVar.getPage().bmF() > 0) {
                                this.jot.endLoadData();
                                this.jot.setText(getString(R.string.pb_load_more_without_point));
                                this.jot.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.mbb = false;
                    break;
                case 5:
                    this.jmy.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable dqa2 = aj.dpZ().dqa();
                        if (dqa2 instanceof RecyclerView.SavedState) {
                            this.jmy.onRestoreInstanceState(dqa2);
                            break;
                        }
                    }
                    this.jmy.setSelection(0);
                    break;
                case 8:
                    this.jmy.setSelection(i3 > 0 ? ((this.jmy.getData() == null && fVar.dli() == null) ? 0 : this.jmy.getData().size() - fVar.dli().size()) + i3 : 0);
                    this.jot.endLoadData();
                    this.jot.setText(getString(R.string.pb_load_more_without_point));
                    this.jot.setLineGone();
                    break;
            }
            if (this.maw) {
                dqm();
                this.maw = false;
                if (i4 == 0) {
                    vy(true);
                }
            }
            dog().u(fVar);
            if (this.jot != null) {
                if (fVar.getPage().bmF() == 0) {
                    this.jot.setVisibility(8);
                } else {
                    this.jot.setVisibility(0);
                }
            }
            if (y.getCount(this.mmj.getDataList()) > 0 && videoPbViewModel.duC()) {
                videoPbViewModel.wq(false);
                String doz = dmx().doz();
                ArrayList<n> dataList = this.mmj.getDataList();
                if (dataList != null) {
                    if (!au.isEmpty(doz)) {
                        i5 = 0;
                        while (i5 < dataList.size()) {
                            if (dataList.get(i5).getType() != PostData.nwY || !doz.equals(((PostData) dataList.get(i5)).getId())) {
                                i5++;
                            }
                        }
                        i5 = 0;
                    } else {
                        i5 = 0;
                        while (i5 < dataList.size()) {
                            if (dataList.get(i5).getType() != com.baidu.tieba.pb.data.o.lLF) {
                                i5++;
                            }
                        }
                        i5 = 0;
                    }
                    if (i5 != 0) {
                        com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.7
                            @Override // java.lang.Runnable
                            public void run() {
                                DetailInfoAndReplyFragment.this.dd(i5, UtilHelper.getDimenPixelSize(R.dimen.tbds120));
                            }
                        });
                    }
                }
            }
        }
    }

    public void duY() {
        com.baidu.tieba.pb.data.f pbData = dmx().getPbData();
        if (pbData != null) {
            this.mmj.wp(dmx().doC());
            this.mmj.setData(pbData);
            this.mmj.notifyDataSetChanged();
            ArrayList<PostData> dli = pbData.dli();
            if (pbData.getPage().bmF() == 0 || dli == null || dli.size() < pbData.getPage().bmE()) {
                if (y.getCount(dli) == 0 || (y.getCount(dli) == 1 && dli.get(0) != null && dli.get(0).dNF() == 1)) {
                    if (doa()) {
                        this.jot.au(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.jot.au(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().bmF() == 0) {
                        this.jot.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jot.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jot.bue();
                }
            }
            dog().u(pbData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity doh() {
        return this.lRi != null ? this.lRi : dog().doh();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment dog() {
        if (this.mmh == null && this.lRi != null) {
            Fragment dmJ = this.lRi.dmJ();
            if (dmJ instanceof VideoPbFragment) {
                this.mmh = (VideoPbFragment) dmJ;
            }
        }
        return this.mmh;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel dmx() {
        return dog().dmx();
    }

    public BdTypeRecyclerView getListView() {
        return this.jmy;
    }

    public boolean doa() {
        if (dmx() != null) {
            return dmx().getHostMode();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: duZ */
    public b duW() {
        return this.mmj;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            a(z, i, i2, i3, fVar, str, i4, false);
        }
    }

    public com.baidu.tieba.pb.videopb.b.b dva() {
        return this.mmk;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0844a
    public void vd(boolean z) {
        this.lRY = z;
    }

    public void vC(boolean z) {
        if (z && this.lZX) {
            this.jot.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.jmy.setNextPage(this.jot);
            this.lYV = 2;
        }
    }

    public void dqS() {
        this.jot.setLineVisible();
        this.jot.startLoadData();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, true));
    }

    public void endLoadData() {
        if (this.jot != null) {
            this.jot.setLineGone();
            this.jot.endLoadData();
        }
        if (dog() != null && dog().mkD != null) {
            this.mmh.mkD.ckx();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, false));
    }

    public void PH(String str) {
        if (this.jot != null) {
            this.jot.setText(str);
        }
    }

    public void PI(String str) {
        if (this.jot != null) {
            this.jot.au(str, this.topMargin);
        }
    }

    public void dqU() {
        if (this.gCQ != null && this.gCQ.isEnabled()) {
            this.gCQ.setRefreshing(false);
        }
    }

    public void drp() {
        if (this.lYV != 2) {
            this.jmy.setNextPage(this.jot);
            this.lYV = 2;
        }
    }

    public void vy(boolean z) {
        this.maw = z;
    }

    public void dqm() {
        if (this.jmy == null) {
        }
    }

    public int dqV() {
        if (this.jmy != null) {
            return this.jmy.getFirstVisiblePosition();
        }
        return 0;
    }

    public int dvb() {
        View childAt;
        if (this.jmy == null || this.jmy.getCount() <= 0 || (childAt = this.jmy.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int dqW() {
        if (this.jmy != null) {
            int lastVisiblePosition = this.jmy.getLastVisiblePosition();
            if (dmx() != null && dmx().getPbData() != null && lastVisiblePosition >= dmx().getPbData().dli().size()) {
                return dmx().getPbData().dli().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View drg() {
        return this.fIC;
    }

    public int dvc() {
        return this.mmp;
    }

    public int dvd() {
        return this.mmq;
    }

    public void Gv(int i) {
        if (this.mml != null) {
            this.mml.setVisibility(i);
        }
    }

    public void wv(boolean z) {
        if (this.jmy != null) {
            this.jmy.setCanFling(z);
        }
    }

    public void dd(int i, int i2) {
        if (this.jmy != null && this.jmy.getLayoutManager() != null && (this.jmy.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.jmy.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dve() {
        if (this.jmy != null && this.eqM != null && this.mmj != null) {
            int headerViewsCount = this.jmy.getHeaderViewsCount() + this.mmj.duP();
            int headerViewsCount2 = this.jmy.getHeaderViewsCount() + this.mmj.duQ();
            int findFirstVisibleItemPosition = this.eqM.findFirstVisibleItemPosition();
            if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
                this.mmn.FC(0);
            } else {
                this.mmn.FC(8);
            }
            if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
                this.mmo.FC(0);
                this.mmn.FC(8);
            } else {
                this.mmo.FC(8);
            }
            if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
                Gv(0);
            } else {
                Gv(8);
            }
        }
    }

    public boolean drH() {
        if (this.jot == null || TextUtils.isEmpty(this.jot.getEndText())) {
            return false;
        }
        return this.jot.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
