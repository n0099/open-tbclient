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
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0843a {
    private LinearLayoutManager eqM;
    private BdSwipeRefreshLayout gCC;
    private BdTypeRecyclerView jmj;
    private PbActivity lQT;
    private boolean lRJ;
    private View mRootView;
    private VideoPbFragment mlS;
    private b mlU;
    private com.baidu.tieba.pb.videopb.b.b mlV;
    private View mlW;
    private LinearLayout mlX;
    private PbReplyTitleViewHolder mlY;
    private PbChildTitleViewHolder mlZ;
    private int topMargin;
    private PbListView jof = null;
    private View fIC = null;
    private com.baidu.tieba.pb.view.a lZb = null;
    private boolean lZI = false;
    private boolean mag = false;
    private boolean maM = true;
    private int lYG = 0;
    private g mPullView = null;
    private boolean lNV = false;
    private int mma = 0;
    private int mmb = 0;
    private boolean lRx = false;
    private RecyclerView.OnScrollListener ipL = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                DetailInfoAndReplyFragment.this.dnZ().dql();
                DetailInfoAndReplyFragment.this.dnZ().duj();
            }
            if (DetailInfoAndReplyFragment.this.dnZ() != null) {
                DetailInfoAndReplyFragment.this.dnZ().onScrollStateChanged(i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            DetailInfoAndReplyFragment.this.duX();
            if (recyclerView.canScrollVertically(-1)) {
                DetailInfoAndReplyFragment.this.mma = 2;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoAndReplyFragment.this.mma != 0) {
                DetailInfoAndReplyFragment.this.mlW.setVisibility(8);
            }
            DetailInfoAndReplyFragment.this.mma = 0;
        }
    };
    private final f.c fjz = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (DetailInfoAndReplyFragment.this.dmq() != null && DetailInfoAndReplyFragment.this.dmq().vn(true)) {
                TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                DetailInfoAndReplyFragment.this.dqN();
            }
        }
    };
    private CustomMessageListener jpm = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && DetailInfoAndReplyFragment.this.dmq() != null && DetailInfoAndReplyFragment.this.dmq().getPbData() != null && DetailInfoAndReplyFragment.this.dmq().getPbData().dlb() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = DetailInfoAndReplyFragment.this.dmq().getPbData().dlb().iterator();
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
                    if (oVar != null && DetailInfoAndReplyFragment.this.mlU != null && DetailInfoAndReplyFragment.this.jmj != null) {
                        DetailInfoAndReplyFragment.this.dmq().getPbData().dlb().remove(oVar);
                        if (DetailInfoAndReplyFragment.this.mlU.getDataList() != null) {
                            DetailInfoAndReplyFragment.this.mlU.getDataList().remove(oVar);
                        }
                        if (DetailInfoAndReplyFragment.this.jmj.getListView2().getData() != null) {
                            DetailInfoAndReplyFragment.this.jmj.getListView2().getData().remove(oVar);
                        }
                        DetailInfoAndReplyFragment.this.mlU.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e lSK = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (DetailInfoAndReplyFragment.this.mIsLogin) {
                if (!DetailInfoAndReplyFragment.this.lRx && DetailInfoAndReplyFragment.this.drA() && DetailInfoAndReplyFragment.this.dmq() != null) {
                    ar arVar = new ar("c13999");
                    arVar.dR("tid", DetailInfoAndReplyFragment.this.dmq().dot());
                    arVar.dR("fid", DetailInfoAndReplyFragment.this.dmq().getForumId());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(arVar);
                    DetailInfoAndReplyFragment.this.lRx = true;
                }
                if (DetailInfoAndReplyFragment.this.dmq().vm(false)) {
                    DetailInfoAndReplyFragment.this.dqL();
                    if (DetailInfoAndReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (DetailInfoAndReplyFragment.this.dmq().getPbData() != null) {
                    DetailInfoAndReplyFragment.this.dri();
                }
            }
        }
    };

    public static DetailInfoAndReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
        detailInfoAndReplyFragment.setArguments(bundle);
        detailInfoAndReplyFragment.mlS = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lQT = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mlV = new com.baidu.tieba.pb.videopb.b.b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mlU != null) {
            this.mlU.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.jpm);
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jmj = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
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
        this.jmj.setLayoutManager(this.eqM);
        this.mlU = new b(this, this.jmj);
        this.mlU.H(dnZ().dtV());
        this.mlU.U(dnZ().dtW());
        this.mlU.setOnLongClickListener(dnZ().dtX());
        this.mlU.setOnImageClickListener(this.mlV.getOnImageClickListener());
        this.mlU.setTbGestureDetector(this.mlV.duO());
        this.mlW = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.jof = new PbListView(getPageContext().getPageActivity());
        this.fIC = this.jof.getView().findViewById(R.id.pb_more_view);
        if (this.fIC != null) {
            this.fIC.setOnClickListener(dnZ().dtV());
            ap.setBackgroundResource(this.fIC, R.drawable.pb_foot_more_trans_selector);
        }
        this.jof.setLineVisible();
        this.jof.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.jof.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.jof.bud();
        this.jmj.setOnSrollToBottomListener(this.lSK);
        this.jmj.addOnScrollListener(this.ipL);
        this.jmj.setOnTouchListener(dnZ().bFG());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.fjz);
        }
        if (this.gCC == null) {
            this.gCC = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.gCC.setProgressView(this.mPullView);
            this.gCC.setEnabled(false);
            ap.setBackgroundColor(this.gCC, R.color.CAM_X0205);
        }
        this.mlX = (LinearLayout) this.mRootView.findViewById(R.id.video_pb_suck_container);
        duQ();
        this.mlU.setOnSwitchChangeListener(dnZ().lSB);
        registerListener(this.jpm);
    }

    private void duQ() {
        this.mlY = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
        this.mlY.ZO = false;
        this.mlY.W(dnZ().dtV());
        this.mlY.setOnSwitchChangeListener(dnZ().lSB);
        this.mlY.FC(8);
        this.mlX.addView(this.mlY.getRootView());
        this.mlZ = new PbChildTitleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
        e eVar = new e();
        eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
        this.mlZ.a(eVar);
        this.mlZ.FC(8);
        this.mlX.addView(this.mlZ.getRootView());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(doa()).get(VideoPbViewModel.class);
        videoPbViewModel.cML().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.5
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
        a(true, 0, 3, 0, videoPbViewModel.dus(), "", 1, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jof != null) {
            this.jof.changeSkin(i);
            if (this.fIC != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fIC);
                ap.setBackgroundResource(this.fIC, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.mlY != null) {
            this.mlY.onChangeSkinType(i);
        }
        if (this.mlZ != null) {
            this.mlZ.onChangeSkinType();
        }
        if (this.mlU != null) {
            this.mlU.notifyDataSetChanged();
        }
        if (this.mlW != null) {
            ap.setBackgroundResource(this.mlW, R.drawable.personalize_tab_shadow);
        }
        ap.setBackgroundColor(this.gCC, R.color.CAM_X0201);
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
        this.lRJ = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        vC(z);
        if (dnZ() != null && dnZ().mko != null) {
            this.mlS.mko.duM();
        }
        if (z && this.lRJ) {
            dqL();
            dmq().vm(true);
        }
    }

    private void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4, boolean z2) {
        final int i5;
        cb dkZ;
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(doa()).get(VideoPbViewModel.class);
        if (z && dmq() != null && fVar != null) {
            this.lNV = dmq().dov();
            boolean isEnabled = this.gCC.isEnabled();
            if (fVar.getPage().bmG() == 0 && this.lNV) {
                this.gCC.setEnabled(false);
            } else if (!isEnabled) {
                this.gCC.setEnabled(true);
                this.gCC.interruptRefresh();
            }
            this.mlU.setIsFromCDN(videoPbViewModel.isFromCDN());
            this.mlU.wp(this.lNV);
            this.mlU.a(fVar, z2);
            this.lZI = false;
            if (TbadkCoreApplication.isLogin()) {
                this.jmj.setNextPage(this.jof);
                this.lYG = 2;
                if (dnZ() != null && dnZ().mko != null) {
                    this.mlS.mko.ckq();
                }
            } else {
                this.lZI = true;
                if (fVar.getPage().bmF() == 1) {
                    if (this.lZb == null) {
                        this.lZb = new com.baidu.tieba.pb.view.a(this, this);
                        this.lZb.createView();
                        this.lZb.bud();
                    }
                    this.jmj.setNextPage(this.lZb);
                } else {
                    this.jmj.setNextPage(this.jof);
                }
                this.lYG = 3;
            }
            if (this.mlY != null) {
                com.baidu.tieba.pb.data.o oVar = new com.baidu.tieba.pb.data.o(com.baidu.tieba.pb.data.o.lLq);
                oVar.lLs = fVar.dkZ() != null ? dkZ.bnH() : 0L;
                oVar.isNew = !dmq().dov();
                oVar.lLv = dnT();
                oVar.sortType = fVar.lJZ;
                oVar.lLu = fVar.dlD();
                oVar.isDynamic = fVar.dlC();
                oVar.lLw = fVar.lJY;
                this.mlY.a(oVar);
            }
            ArrayList<PostData> dlb = fVar.dlb();
            if (fVar.getPage().bmF() == 0 || dlb == null || dlb.size() < fVar.getPage().bmE()) {
                if (fVar.getPage().bmF() == 0) {
                    this.jof.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.jof.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.jof.bue();
                if (fVar.getPage().bmF() == 0 || dlb == null) {
                    dri();
                }
            } else {
                if (dmq().getIsFromMark()) {
                    if (this.maM) {
                        endLoadData();
                        if (fVar.getPage().bmF() != 0) {
                            this.jof.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.jof.setLineVisible();
                        this.jof.showLoading();
                    }
                } else {
                    this.jof.setLineVisible();
                    this.jof.showLoading();
                }
                this.jof.bue();
            }
            switch (i2) {
                case 2:
                    this.jmj.setSelection(i3 > 1 ? (((this.jmj.getData() == null && fVar.dlb() == null) ? 0 : this.jmj.getData().size() - fVar.dlb().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable dpT = aj.dpS().dpT();
                        if (dpT instanceof RecyclerView.SavedState) {
                            this.jmj.onRestoreInstanceState(dpT);
                            if (y.getCount(dlb) > 1 && fVar.getPage().bmF() > 0) {
                                this.jof.endLoadData();
                                this.jof.setText(getString(R.string.pb_load_more_without_point));
                                this.jof.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.maM = false;
                    break;
                case 5:
                    this.jmj.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable dpT2 = aj.dpS().dpT();
                        if (dpT2 instanceof RecyclerView.SavedState) {
                            this.jmj.onRestoreInstanceState(dpT2);
                            break;
                        }
                    }
                    this.jmj.setSelection(0);
                    break;
                case 8:
                    this.jmj.setSelection(i3 > 0 ? ((this.jmj.getData() == null && fVar.dlb() == null) ? 0 : this.jmj.getData().size() - fVar.dlb().size()) + i3 : 0);
                    this.jof.endLoadData();
                    this.jof.setText(getString(R.string.pb_load_more_without_point));
                    this.jof.setLineGone();
                    break;
            }
            if (this.mag) {
                dqf();
                this.mag = false;
                if (i4 == 0) {
                    vy(true);
                }
            }
            dnZ().u(fVar);
            if (this.jof != null) {
                if (fVar.getPage().bmF() == 0) {
                    this.jof.setVisibility(8);
                } else {
                    this.jof.setVisibility(0);
                }
            }
            if (y.getCount(this.mlU.getDataList()) > 0 && videoPbViewModel.duv()) {
                videoPbViewModel.wq(false);
                String dos = dmq().dos();
                ArrayList<n> dataList = this.mlU.getDataList();
                if (dataList != null) {
                    if (!au.isEmpty(dos)) {
                        i5 = 0;
                        while (i5 < dataList.size()) {
                            if (dataList.get(i5).getType() != PostData.nwy || !dos.equals(((PostData) dataList.get(i5)).getId())) {
                                i5++;
                            }
                        }
                        i5 = 0;
                    } else {
                        i5 = 0;
                        while (i5 < dataList.size()) {
                            if (dataList.get(i5).getType() != com.baidu.tieba.pb.data.o.lLq) {
                                i5++;
                            }
                        }
                        i5 = 0;
                    }
                    if (i5 != 0) {
                        com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.7
                            @Override // java.lang.Runnable
                            public void run() {
                                DetailInfoAndReplyFragment.this.dc(i5, UtilHelper.getDimenPixelSize(R.dimen.tbds120));
                            }
                        });
                    }
                }
            }
        }
    }

    public void duR() {
        com.baidu.tieba.pb.data.f pbData = dmq().getPbData();
        if (pbData != null) {
            this.mlU.wp(dmq().dov());
            this.mlU.setData(pbData);
            this.mlU.notifyDataSetChanged();
            ArrayList<PostData> dlb = pbData.dlb();
            if (pbData.getPage().bmF() == 0 || dlb == null || dlb.size() < pbData.getPage().bmE()) {
                if (y.getCount(dlb) == 0 || (y.getCount(dlb) == 1 && dlb.get(0) != null && dlb.get(0).dNx() == 1)) {
                    if (dnT()) {
                        this.jof.au(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.jof.au(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().bmF() == 0) {
                        this.jof.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jof.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jof.bue();
                }
            }
            dnZ().u(pbData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity doa() {
        return this.lQT != null ? this.lQT : dnZ().doa();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment dnZ() {
        if (this.mlS == null && this.lQT != null) {
            Fragment dmC = this.lQT.dmC();
            if (dmC instanceof VideoPbFragment) {
                this.mlS = (VideoPbFragment) dmC;
            }
        }
        return this.mlS;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel dmq() {
        return dnZ().dmq();
    }

    public BdTypeRecyclerView getListView() {
        return this.jmj;
    }

    public boolean dnT() {
        if (dmq() != null) {
            return dmq().getHostMode();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: duS */
    public b duP() {
        return this.mlU;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            a(z, i, i2, i3, fVar, str, i4, false);
        }
    }

    public com.baidu.tieba.pb.videopb.b.b duT() {
        return this.mlV;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0843a
    public void vd(boolean z) {
        this.lRJ = z;
    }

    public void vC(boolean z) {
        if (z && this.lZI) {
            this.jof.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.jmj.setNextPage(this.jof);
            this.lYG = 2;
        }
    }

    public void dqL() {
        this.jof.setLineVisible();
        this.jof.startLoadData();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, true));
    }

    public void endLoadData() {
        if (this.jof != null) {
            this.jof.setLineGone();
            this.jof.endLoadData();
        }
        if (dnZ() != null && dnZ().mko != null) {
            this.mlS.mko.ckq();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, false));
    }

    public void PG(String str) {
        if (this.jof != null) {
            this.jof.setText(str);
        }
    }

    public void PH(String str) {
        if (this.jof != null) {
            this.jof.au(str, this.topMargin);
        }
    }

    public void dqN() {
        if (this.gCC != null && this.gCC.isEnabled()) {
            this.gCC.setRefreshing(false);
        }
    }

    public void dri() {
        if (this.lYG != 2) {
            this.jmj.setNextPage(this.jof);
            this.lYG = 2;
        }
    }

    public void vy(boolean z) {
        this.mag = z;
    }

    public void dqf() {
        if (this.jmj == null) {
        }
    }

    public int dqO() {
        if (this.jmj != null) {
            return this.jmj.getFirstVisiblePosition();
        }
        return 0;
    }

    public int duU() {
        View childAt;
        if (this.jmj == null || this.jmj.getCount() <= 0 || (childAt = this.jmj.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int dqP() {
        if (this.jmj != null) {
            int lastVisiblePosition = this.jmj.getLastVisiblePosition();
            if (dmq() != null && dmq().getPbData() != null && lastVisiblePosition >= dmq().getPbData().dlb().size()) {
                return dmq().getPbData().dlb().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View dqZ() {
        return this.fIC;
    }

    public int duV() {
        return this.mma;
    }

    public int duW() {
        return this.mmb;
    }

    public void Gv(int i) {
        if (this.mlW != null) {
            this.mlW.setVisibility(i);
        }
    }

    public void wv(boolean z) {
        if (this.jmj != null) {
            this.jmj.setCanFling(z);
        }
    }

    public void dc(int i, int i2) {
        if (this.jmj != null && this.jmj.getLayoutManager() != null && (this.jmj.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.jmj.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duX() {
        if (this.jmj != null && this.eqM != null && this.mlU != null) {
            int headerViewsCount = this.jmj.getHeaderViewsCount() + this.mlU.duI();
            int headerViewsCount2 = this.jmj.getHeaderViewsCount() + this.mlU.duJ();
            int findFirstVisibleItemPosition = this.eqM.findFirstVisibleItemPosition();
            if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
                this.mlY.FC(0);
            } else {
                this.mlY.FC(8);
            }
            if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
                this.mlZ.FC(0);
                this.mlY.FC(8);
            } else {
                this.mlZ.FC(8);
            }
            if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
                Gv(0);
            } else {
                Gv(8);
            }
        }
    }

    public boolean drA() {
        if (this.jof == null || TextUtils.isEmpty(this.jof.getEndText())) {
            return false;
        }
        return this.jof.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
