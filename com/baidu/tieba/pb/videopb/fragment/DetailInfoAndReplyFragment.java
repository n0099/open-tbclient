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
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.data.n;
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
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0824a {
    private int aht;
    private LinearLayoutManager etu;
    private BdSwipeRefreshLayout gEz;
    private BdTypeRecyclerView jlj;
    private PbActivity lME;
    private boolean lNr;
    private View mRootView;
    private View mhA;
    private LinearLayout mhB;
    private PbReplyTitleViewHolder mhC;
    private PbChildTitleViewHolder mhD;
    private VideoPbFragment mhw;
    private b mhy;
    private com.baidu.tieba.pb.videopb.b.b mhz;
    private PbListView jnf = null;
    private View fKX = null;
    private com.baidu.tieba.pb.view.a lUK = null;
    private boolean lVr = false;
    private boolean lVO = false;
    private boolean lWs = true;
    private int lUp = 0;
    private g mPullView = null;
    private boolean lJK = false;
    private int mhE = 0;
    private int mhF = 0;
    private boolean lNf = false;
    private RecyclerView.OnScrollListener ioM = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                DetailInfoAndReplyFragment.this.dpC().drO();
                DetailInfoAndReplyFragment.this.dpC().dvO();
            }
            if (DetailInfoAndReplyFragment.this.dpC() != null) {
                DetailInfoAndReplyFragment.this.dpC().onScrollStateChanged(i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            DetailInfoAndReplyFragment.this.dwB();
            if (recyclerView.canScrollVertically(-1)) {
                DetailInfoAndReplyFragment.this.mhE = 2;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoAndReplyFragment.this.mhE != 0) {
                DetailInfoAndReplyFragment.this.mhA.setVisibility(8);
            }
            DetailInfoAndReplyFragment.this.mhE = 0;
        }
    };
    private final f.c flR = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (DetailInfoAndReplyFragment.this.dnV() != null && DetailInfoAndReplyFragment.this.dnV().vc(true)) {
                TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                DetailInfoAndReplyFragment.this.dsq();
            }
        }
    };
    private CustomMessageListener jom = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && DetailInfoAndReplyFragment.this.dnV() != null && DetailInfoAndReplyFragment.this.dnV().getPbData() != null && DetailInfoAndReplyFragment.this.dnV().getPbData().dmG() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = DetailInfoAndReplyFragment.this.dnV().getPbData().dmG().iterator();
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
                    if (oVar != null && DetailInfoAndReplyFragment.this.mhy != null && DetailInfoAndReplyFragment.this.jlj != null) {
                        DetailInfoAndReplyFragment.this.dnV().getPbData().dmG().remove(oVar);
                        if (DetailInfoAndReplyFragment.this.mhy.getDataList() != null) {
                            DetailInfoAndReplyFragment.this.mhy.getDataList().remove(oVar);
                        }
                        if (DetailInfoAndReplyFragment.this.jlj.getListView2().getData() != null) {
                            DetailInfoAndReplyFragment.this.jlj.getListView2().getData().remove(oVar);
                        }
                        DetailInfoAndReplyFragment.this.mhy.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e lOs = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (DetailInfoAndReplyFragment.this.mIsLogin) {
                if (!DetailInfoAndReplyFragment.this.lNf && DetailInfoAndReplyFragment.this.dtd() && DetailInfoAndReplyFragment.this.dnV() != null) {
                    aq aqVar = new aq("c13999");
                    aqVar.dX("tid", DetailInfoAndReplyFragment.this.dnV().dpW());
                    aqVar.dX("fid", DetailInfoAndReplyFragment.this.dnV().getForumId());
                    aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar);
                    DetailInfoAndReplyFragment.this.lNf = true;
                }
                if (DetailInfoAndReplyFragment.this.dnV().vb(false)) {
                    DetailInfoAndReplyFragment.this.dso();
                    if (DetailInfoAndReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (DetailInfoAndReplyFragment.this.dnV().getPbData() != null) {
                    DetailInfoAndReplyFragment.this.dsL();
                }
            }
        }
    };

    public static DetailInfoAndReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
        detailInfoAndReplyFragment.setArguments(bundle);
        detailInfoAndReplyFragment.mhw = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lME = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mhz = new com.baidu.tieba.pb.videopb.b.b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mhy != null) {
            this.mhy.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.jom);
    }

    private void initUI() {
        this.aht = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jlj = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.etu = new LinearLayoutManager(getContext()) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.4
            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        };
        this.jlj.setLayoutManager(this.etu);
        this.mhy = new b(this, this.jlj);
        this.mhy.H(dpC().dvz());
        this.mhy.U(dpC().dvA());
        this.mhy.setOnLongClickListener(dpC().dvB());
        this.mhy.setOnImageClickListener(this.mhz.getOnImageClickListener());
        this.mhy.setTbGestureDetector(this.mhz.dws());
        this.mhA = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.jnf = new PbListView(getPageContext().getPageActivity());
        this.fKX = this.jnf.getView().findViewById(R.id.pb_more_view);
        if (this.fKX != null) {
            this.fKX.setOnClickListener(dpC().dvz());
            ao.setBackgroundResource(this.fKX, R.drawable.pb_foot_more_trans_selector);
        }
        this.jnf.setLineVisible();
        this.jnf.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.jnf.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.jnf.bxC();
        this.jlj.setOnSrollToBottomListener(this.lOs);
        this.jlj.addOnScrollListener(this.ioM);
        this.jlj.setOnTouchListener(dpC().bJe());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.flR);
        }
        if (this.gEz == null) {
            this.gEz = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.gEz.setProgressView(this.mPullView);
            this.gEz.setEnabled(false);
            ao.setBackgroundColor(this.gEz, R.color.CAM_X0205);
        }
        this.mhB = (LinearLayout) this.mRootView.findViewById(R.id.video_pb_suck_container);
        dwu();
        this.mhy.setOnSwitchChangeListener(dpC().lOj);
        registerListener(this.jom);
    }

    private void dwu() {
        this.mhC = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
        this.mhC.ZU = false;
        this.mhC.W(dpC().dvz());
        this.mhC.setOnSwitchChangeListener(dpC().lOj);
        this.mhC.GP(8);
        this.mhB.addView(this.mhC.getRootView());
        this.mhD = new PbChildTitleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
        e eVar = new e();
        eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
        this.mhD.a(eVar);
        this.mhD.GP(8);
        this.mhB.addView(this.mhD.getRootView());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(dpD()).get(VideoPbViewModel.class);
        videoPbViewModel.dwg().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: s */
            public void onChanged(@Nullable Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    DetailInfoAndReplyFragment.this.showLoadingView();
                } else {
                    DetailInfoAndReplyFragment.this.hideLoadingView();
                }
            }
        });
        a(true, 0, 3, 0, videoPbViewModel.dvX(), "", 1, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jnf != null) {
            this.jnf.changeSkin(i);
            if (this.fKX != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fKX);
                ao.setBackgroundResource(this.fKX, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.mhC != null) {
            this.mhC.onChangeSkinType(i);
        }
        if (this.mhD != null) {
            this.mhD.onChangeSkinType();
        }
        if (this.mhy != null) {
            this.mhy.notifyDataSetChanged();
        }
        if (this.mhA != null) {
            ao.setBackgroundResource(this.mhA, R.drawable.personalize_tab_shadow);
        }
        ao.setBackgroundColor(this.gEz, R.color.CAM_X0201);
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
        this.lNr = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        vr(z);
        if (dpC() != null && dpC().mfR != null) {
            this.mhw.mfR.dwq();
        }
        if (z && this.lNr) {
            dso();
            dnV().vb(true);
        }
    }

    private void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4, boolean z2) {
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(dpD()).get(VideoPbViewModel.class);
        if (z && dnV() != null && fVar != null) {
            this.lJK = dnV().dpY();
            boolean isEnabled = this.gEz.isEnabled();
            if (fVar.getPage().bqg() == 0 && this.lJK) {
                this.gEz.setEnabled(false);
            } else if (!isEnabled) {
                this.gEz.setEnabled(true);
                this.gEz.interruptRefresh();
            }
            this.mhy.setIsFromCDN(videoPbViewModel.isFromCDN());
            this.mhy.wc(this.lJK);
            this.mhy.a(fVar, z2);
            this.lVr = false;
            if (TbadkCoreApplication.isLogin()) {
                this.jlj.setNextPage(this.jnf);
                this.lUp = 2;
                if (dpC() != null && dpC().mfR != null) {
                    this.mhw.mfR.cni();
                }
            } else {
                this.lVr = true;
                if (fVar.getPage().bqf() == 1) {
                    if (this.lUK == null) {
                        this.lUK = new com.baidu.tieba.pb.view.a(this, this);
                        this.lUK.createView();
                        this.lUK.bxC();
                    }
                    this.jlj.setNextPage(this.lUK);
                } else {
                    this.jlj.setNextPage(this.jnf);
                }
                this.lUp = 3;
            }
            if (this.mhC != null) {
                n nVar = new n(n.lHi);
                bz dmE = fVar.dmE();
                nVar.lHk = dmE != null ? dmE.brh() : 0L;
                nVar.isNew = !dnV().dpY();
                nVar.lHn = dpw();
                nVar.sortType = fVar.lFS;
                nVar.lHm = fVar.dni();
                nVar.isDynamic = fVar.dnh();
                nVar.lHo = fVar.lFR;
                this.mhC.a(nVar);
            }
            ArrayList<PostData> dmG = fVar.dmG();
            if (fVar.getPage().bqf() == 0 || dmG == null || dmG.size() < fVar.getPage().bqe()) {
                if (fVar.getPage().bqf() == 0) {
                    this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.jnf.bxD();
                if (fVar.getPage().bqf() == 0 || dmG == null) {
                    dsL();
                }
            } else {
                if (dnV().getIsFromMark()) {
                    if (this.lWs) {
                        endLoadData();
                        if (fVar.getPage().bqf() != 0) {
                            this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.jnf.setLineVisible();
                        this.jnf.showLoading();
                    }
                } else {
                    this.jnf.setLineVisible();
                    this.jnf.showLoading();
                }
                this.jnf.bxD();
            }
            switch (i2) {
                case 2:
                    this.jlj.setSelection(i3 > 1 ? (((this.jlj.getData() == null && fVar.dmG() == null) ? 0 : this.jlj.getData().size() - fVar.dmG().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable drw = aj.drv().drw();
                        if (drw instanceof RecyclerView.SavedState) {
                            this.jlj.onRestoreInstanceState(drw);
                            if (x.getCount(dmG) > 1 && fVar.getPage().bqf() > 0) {
                                this.jnf.endLoadData();
                                this.jnf.setText(getString(R.string.pb_load_more_without_point));
                                this.jnf.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.lWs = false;
                    break;
                case 5:
                    this.jlj.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable drw2 = aj.drv().drw();
                        if (drw2 instanceof RecyclerView.SavedState) {
                            this.jlj.onRestoreInstanceState(drw2);
                            break;
                        }
                    }
                    this.jlj.setSelection(0);
                    break;
                case 8:
                    this.jlj.setSelection(i3 > 0 ? ((this.jlj.getData() == null && fVar.dmG() == null) ? 0 : this.jlj.getData().size() - fVar.dmG().size()) + i3 : 0);
                    this.jnf.endLoadData();
                    this.jnf.setText(getString(R.string.pb_load_more_without_point));
                    this.jnf.setLineGone();
                    break;
            }
            if (this.lVO) {
                drI();
                this.lVO = false;
                if (i4 == 0) {
                    vn(true);
                }
            }
            dpC().u(fVar);
            if (this.jnf != null) {
                if (fVar.getPage().bqf() == 0) {
                    this.jnf.setVisibility(8);
                } else {
                    this.jnf.setVisibility(0);
                }
            }
        }
    }

    public void dwv() {
        com.baidu.tieba.pb.data.f pbData = dnV().getPbData();
        if (pbData != null) {
            this.mhy.wc(dnV().dpY());
            this.mhy.setData(pbData);
            this.mhy.notifyDataSetChanged();
            ArrayList<PostData> dmG = pbData.dmG();
            if (pbData.getPage().bqf() == 0 || dmG == null || dmG.size() < pbData.getPage().bqe()) {
                if (x.getCount(dmG) == 0 || (x.getCount(dmG) == 1 && dmG.get(0) != null && dmG.get(0).dPd() == 1)) {
                    if (dpw()) {
                        this.jnf.as(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.aht);
                    } else {
                        this.jnf.as(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.aht);
                    }
                } else {
                    if (pbData.getPage().bqf() == 0) {
                        this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jnf.bxD();
                }
            }
            dpC().u(pbData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity dpD() {
        return this.lME != null ? this.lME : dpC().dpD();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment dpC() {
        if (this.mhw == null && this.lME != null) {
            Fragment doh = this.lME.doh();
            if (doh instanceof VideoPbFragment) {
                this.mhw = (VideoPbFragment) doh;
            }
        }
        return this.mhw;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel dnV() {
        return dpC().dnV();
    }

    public BdTypeRecyclerView getListView() {
        return this.jlj;
    }

    public boolean dpw() {
        if (dnV() != null) {
            return dnV().getHostMode();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: dww */
    public b dwt() {
        return this.mhy;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            a(z, i, i2, i3, fVar, str, i4, false);
        }
    }

    public com.baidu.tieba.pb.videopb.b.b dwx() {
        return this.mhz;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0824a
    public void uS(boolean z) {
        this.lNr = z;
    }

    public void vr(boolean z) {
        if (z && this.lVr) {
            this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.jlj.setNextPage(this.jnf);
            this.lUp = 2;
        }
    }

    public void dso() {
        this.jnf.setLineVisible();
        this.jnf.startLoadData();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, true));
    }

    public void endLoadData() {
        if (this.jnf != null) {
            this.jnf.setLineGone();
            this.jnf.endLoadData();
        }
        if (dpC() != null && dpC().mfR != null) {
            this.mhw.mfR.cni();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, false));
    }

    public void PX(String str) {
        if (this.jnf != null) {
            this.jnf.setText(str);
        }
    }

    public void PY(String str) {
        if (this.jnf != null) {
            this.jnf.as(str, this.aht);
        }
    }

    public void dsq() {
        if (this.gEz != null && this.gEz.isEnabled()) {
            this.gEz.setRefreshing(false);
        }
    }

    public void dsL() {
        if (this.lUp != 2) {
            this.jlj.setNextPage(this.jnf);
            this.lUp = 2;
        }
    }

    public void vn(boolean z) {
        this.lVO = z;
    }

    public void drI() {
        if (this.jlj == null) {
        }
    }

    public int dsr() {
        if (this.jlj != null) {
            return this.jlj.getFirstVisiblePosition();
        }
        return 0;
    }

    public int dwy() {
        View childAt;
        if (this.jlj == null || this.jlj.getCount() <= 0 || (childAt = this.jlj.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int dss() {
        if (this.jlj != null) {
            int lastVisiblePosition = this.jlj.getLastVisiblePosition();
            if (dnV() != null && dnV().getPbData() != null && lastVisiblePosition >= dnV().getPbData().dmG().size()) {
                return dnV().getPbData().dmG().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View dsC() {
        return this.fKX;
    }

    public int dwz() {
        return this.mhE;
    }

    public int dwA() {
        return this.mhF;
    }

    public void HI(int i) {
        if (this.mhA != null) {
            this.mhA.setVisibility(i);
        }
    }

    public void wi(boolean z) {
        if (this.jlj != null) {
            this.jlj.setCanFling(z);
        }
    }

    public void df(int i, int i2) {
        if (this.jlj != null && this.jlj.getLayoutManager() != null && (this.jlj.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.jlj.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwB() {
        if (this.jlj != null && this.etu != null && this.mhy != null) {
            int headerViewsCount = this.jlj.getHeaderViewsCount() + this.mhy.dwo();
            int headerViewsCount2 = this.jlj.getHeaderViewsCount() + this.mhy.dwp();
            int findFirstVisibleItemPosition = this.etu.findFirstVisibleItemPosition();
            if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
                this.mhC.GP(0);
            } else {
                this.mhC.GP(8);
            }
            if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
                this.mhD.GP(0);
                this.mhC.GP(8);
            } else {
                this.mhD.GP(8);
            }
            if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
                HI(0);
            } else {
                HI(8);
            }
        }
    }

    public boolean dtd() {
        if (this.jnf == null || TextUtils.isEmpty(this.jnf.getEndText())) {
            return false;
        }
        return this.jnf.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
