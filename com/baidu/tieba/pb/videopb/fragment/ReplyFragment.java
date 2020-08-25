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
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.videopb.MultiNestedLayout;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.c;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.pb.videopb.videoView.b;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0777a {
    private BdSwipeRefreshLayout fGi;
    private BdTypeRecyclerView hYQ;
    private PbActivity kCV;
    private boolean kDF;
    private c kXF;
    private MultiNestedLayout kXG;
    private b kXH;
    private View kXI;
    private VideoPbFragment kXq;
    private com.baidu.tieba.pb.videopb.b.b kXt;
    private View kXu;
    private View mRootView;
    private int topMargin;
    private PbListView iaL = null;
    private View eQZ = null;
    private com.baidu.tieba.pb.view.a kKX = null;
    private boolean kLD = false;
    private boolean kMa = false;
    private boolean kMA = true;
    private int kKC = 0;
    private g mPullView = null;
    private boolean kAi = false;
    private int kXy = 0;
    private int kXz = 0;
    private RecyclerView.OnScrollListener hcz = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.cYh().daq();
                ReplyFragment.this.cYh().deh();
            }
            if (ReplyFragment.this.cYh() != null) {
                ReplyFragment.this.cYh().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.kXy = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.kXy != 0) {
                ReplyFragment.this.kXu.setVisibility(8);
            }
            ReplyFragment.this.kXy = 0;
        }
    };
    private MultiNestedLayout.b kXJ = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void onStateChange(int i) {
            if (ReplyFragment.this.kXz != 1 || i == 1 || ReplyFragment.this.kXy == 0) {
                if (ReplyFragment.this.kXz != 0 || i == 0) {
                    if (ReplyFragment.this.kXz != 0 && i == 0) {
                        ReplyFragment.this.cYh().EN(8);
                    }
                } else if (ReplyFragment.this.kXu.getVisibility() != 0) {
                    ReplyFragment.this.cYh().EN(0);
                }
            } else {
                ReplyFragment.this.cYh().EN(8);
                ReplyFragment.this.kXu.setVisibility(0);
            }
            ReplyFragment.this.kXz = i;
        }
    };
    private final f.c esW = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.cWD() != null && ReplyFragment.this.cWD().tg(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.daO();
            }
        }
    };
    private CustomMessageListener inh = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && ReplyFragment.this.cWD() != null && ReplyFragment.this.cWD().getPbData() != null && ReplyFragment.this.cWD().getPbData().cVn() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = ReplyFragment.this.cWD().getPbData().cVn().iterator();
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
                    if (nVar != null && ReplyFragment.this.kXF != null && ReplyFragment.this.hYQ != null) {
                        ReplyFragment.this.cWD().getPbData().cVn().remove(nVar);
                        if (ReplyFragment.this.kXF.getDataList() != null) {
                            ReplyFragment.this.kXF.getDataList().remove(nVar);
                        }
                        if (ReplyFragment.this.hYQ.getListView2().getData() != null) {
                            ReplyFragment.this.hYQ.getListView2().getData().remove(nVar);
                        }
                        ReplyFragment.this.kXF.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e kEG = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (ReplyFragment.this.cWD().tf(false)) {
                    ReplyFragment.this.daM();
                    if (ReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (ReplyFragment.this.cWD().getPbData() != null) {
                    ReplyFragment.this.dbj();
                }
            }
        }
    };

    public static ReplyFragment ae(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.kXq = videoPbFragment;
        return replyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.kCV = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.kXt = new com.baidu.tieba.pb.videopb.b.b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.inh);
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.kXG = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.kXG.setScrollStateChangeListener(this.kXJ);
        this.hYQ = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.hYQ.setLayoutManager(new LinearLayoutManager(getContext()));
        this.kXF = new c(this, this.hYQ);
        this.kXF.F(cYh().ddS());
        this.kXF.S(cYh().ddT());
        this.kXF.setOnLongClickListener(cYh().ddU());
        this.kXF.setOnImageClickListener(this.kXt.getOnImageClickListener());
        this.kXF.setTbGestureDetector(this.kXt.deL());
        this.kXu = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.iaL = new PbListView(getPageContext().getPageActivity());
        this.eQZ = this.iaL.getView().findViewById(R.id.pb_more_view);
        if (this.eQZ != null) {
            this.eQZ.setOnClickListener(cYh().ddS());
            ap.setBackgroundResource(this.eQZ, R.drawable.pb_foot_more_trans_selector);
        }
        this.iaL.setLineVisible();
        this.iaL.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.iaL.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.iaL.bkv();
        this.hYQ.setOnSrollToBottomListener(this.kEG);
        this.hYQ.addOnScrollListener(this.hcz);
        this.hYQ.setOnTouchListener(cYh().bvH());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.esW);
        }
        if (this.fGi == null) {
            this.fGi = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.fGi.setProgressView(this.mPullView);
            this.fGi.setEnabled(false);
            ap.setBackgroundColor(this.fGi, R.color.cp_bg_line_e);
        }
        this.kXI = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.kXH = new b(this.kXI);
        this.kXH.X(cYh().ddS());
        this.kXH.setOnSwitchChangeListener(cYh().kEx);
        registerListener(this.inh);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e eVar = (e) y.b(cYi()).l(e.class);
        eVar.dez().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: p */
            public void onChanged(@Nullable Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    ReplyFragment.this.showLoadingView();
                } else {
                    ReplyFragment.this.hideLoadingView();
                }
            }
        });
        d(true, 0, 3, 0, eVar.deq(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iaL != null) {
            this.iaL.changeSkin(i);
            if (this.eQZ != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.eQZ);
                ap.setBackgroundResource(this.eQZ, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.kXH != null) {
            this.kXH.onChangeSkinType(i);
        }
        if (this.kXF != null) {
            this.kXF.notifyDataSetChanged();
        }
        if (this.kXu != null) {
            ap.setBackgroundResource(this.kXu, R.drawable.personalize_tab_shadow);
        }
        ap.setBackgroundColor(this.fGi, R.color.cp_bg_line_d);
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
        this.kDF = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        tu(z);
        if (cYh() != null && cYh().kVM != null) {
            this.kXq.kVM.deJ();
        }
        if (z && this.kDF) {
            daM();
            cWD().tf(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        e eVar = (e) y.b(cYi()).l(e.class);
        if (z && cWD() != null && fVar != null) {
            this.kAi = cWD().cYD();
            boolean isEnabled = this.fGi.isEnabled();
            if (fVar.getPage().bdv() == 0 && this.kAi) {
                this.fGi.setEnabled(false);
            } else if (!isEnabled) {
                this.fGi.setEnabled(true);
                this.fGi.interruptRefresh();
            }
            this.kXF.setIsFromCDN(eVar.isFromCDN());
            this.kXF.ue(this.kAi);
            this.kXF.setData(fVar);
            this.kLD = false;
            if (TbadkCoreApplication.isLogin()) {
                this.hYQ.setNextPage(this.iaL);
                this.kKC = 2;
                if (cYh() != null && cYh().kVM != null) {
                    this.kXq.kVM.bWq();
                }
            } else {
                this.kLD = true;
                if (fVar.getPage().bdu() == 1) {
                    if (this.kKX == null) {
                        this.kKX = new com.baidu.tieba.pb.view.a(this, this);
                        this.kKX.createView();
                        this.kKX.bkv();
                    }
                    this.hYQ.setNextPage(this.kKX);
                } else {
                    this.hYQ.setNextPage(this.iaL);
                }
                this.kKC = 3;
            }
            if (this.kXH != null && this.kXI != null) {
                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kxY);
                bw cVl = fVar.cVl();
                nVar.kya = cVl != null ? cVl.bev() : 0L;
                nVar.isNew = !cWD().cYD();
                nVar.kyd = cYb();
                nVar.sortType = fVar.kwI;
                nVar.kyc = fVar.cVP();
                nVar.isDynamic = fVar.cVO();
                nVar.kye = fVar.kwH;
                this.kXH.a(nVar);
            }
            ArrayList<PostData> cVn = fVar.cVn();
            if (fVar.getPage().bdu() == 0 || cVn == null || cVn.size() < fVar.getPage().bdt()) {
                if (com.baidu.tbadk.core.util.y.getCount(cVn) == 0 || (com.baidu.tbadk.core.util.y.getCount(cVn) == 1 && cVn.get(0) != null && cVn.get(0).dwF() == 1)) {
                    if (cYb()) {
                        this.iaL.an(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.iaL.an(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (fVar.getPage().bdu() == 0) {
                        this.iaL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.iaL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.iaL.bkw();
                }
                if (fVar.getPage().bdu() == 0 || cVn == null) {
                    dbj();
                }
            } else {
                if (cWD().getIsFromMark()) {
                    if (this.kMA) {
                        endLoadData();
                        if (fVar.getPage().bdu() != 0) {
                            this.iaL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.iaL.setLineVisible();
                        this.iaL.showLoading();
                    }
                } else {
                    this.iaL.setLineVisible();
                    this.iaL.showLoading();
                }
                this.iaL.bkw();
            }
            switch (i2) {
                case 2:
                    this.hYQ.setSelection(i3 > 1 ? (((this.hYQ.getData() == null && fVar.cVn() == null) ? 0 : this.hYQ.getData().size() - fVar.cVn().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable cZX = as.cZW().cZX();
                        if (cZX instanceof RecyclerView.SavedState) {
                            this.hYQ.onRestoreInstanceState(cZX);
                            if (com.baidu.tbadk.core.util.y.getCount(cVn) > 1 && fVar.getPage().bdu() > 0) {
                                this.iaL.endLoadData();
                                this.iaL.setText(getString(R.string.pb_load_more_without_point));
                                this.iaL.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.kMA = false;
                    break;
                case 5:
                    this.hYQ.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable cZX2 = as.cZW().cZX();
                        if (cZX2 instanceof RecyclerView.SavedState) {
                            this.hYQ.onRestoreInstanceState(cZX2);
                            break;
                        }
                    }
                    this.hYQ.setSelection(0);
                    break;
                case 8:
                    int size = (this.hYQ.getData() == null && fVar.cVn() == null) ? 0 : this.hYQ.getData().size() - fVar.cVn().size();
                    this.kXG.setMaxOffset();
                    this.hYQ.setSelection(i3 > 0 ? size + i3 : 0);
                    this.iaL.endLoadData();
                    this.iaL.setText(getString(R.string.pb_load_more_without_point));
                    this.iaL.setLineGone();
                    break;
            }
            if (this.kMa) {
                dak();
                this.kMa = false;
                if (i4 == 0) {
                    tq(true);
                }
            }
            cYh().u(fVar);
        }
    }

    public void deO() {
        com.baidu.tieba.pb.data.f pbData = cWD().getPbData();
        if (pbData != null) {
            this.kXF.ue(cWD().cYD());
            this.kXF.setData(pbData);
            this.kXF.notifyDataSetChanged();
            ArrayList<PostData> cVn = pbData.cVn();
            if (pbData.getPage().bdu() == 0 || cVn == null || cVn.size() < pbData.getPage().bdt()) {
                if (com.baidu.tbadk.core.util.y.getCount(cVn) == 0 || (com.baidu.tbadk.core.util.y.getCount(cVn) == 1 && cVn.get(0) != null && cVn.get(0).dwF() == 1)) {
                    if (cYb()) {
                        this.iaL.an(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.iaL.an(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().bdu() == 0) {
                        this.iaL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.iaL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.iaL.bkw();
                }
            }
            cYh().u(pbData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity cYi() {
        return this.kCV != null ? this.kCV : cYh().cYi();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment cYh() {
        if (this.kXq == null && this.kCV != null) {
            Fragment cWP = this.kCV.cWP();
            if (cWP instanceof VideoPbFragment) {
                this.kXq = (VideoPbFragment) cWP;
            }
        }
        return this.kXq;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel cWD() {
        return cYh().cWD();
    }

    public BdTypeRecyclerView getListView() {
        return this.hYQ;
    }

    public boolean cYb() {
        if (cWD() != null) {
            return cWD().getHostMode();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: dfa */
    public c deM() {
        return this.kXF;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, fVar, str, i4);
        }
    }

    public com.baidu.tieba.pb.videopb.b.b deQ() {
        return this.kXt;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0777a
    public void sW(boolean z) {
        this.kDF = z;
    }

    public void tu(boolean z) {
        if (z && this.kLD) {
            this.iaL.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.hYQ.setNextPage(this.iaL);
            this.kKC = 2;
        }
    }

    public void daM() {
        this.iaL.setLineVisible();
        this.iaL.startLoadData();
    }

    public void endLoadData() {
        if (this.iaL != null) {
            this.iaL.setLineGone();
            this.iaL.endLoadData();
        }
        if (cYh() != null && cYh().kVM != null) {
            this.kXq.kVM.bWq();
        }
    }

    public void NH(String str) {
        if (this.iaL != null) {
            this.iaL.setText(str);
        }
    }

    public void NI(String str) {
        if (this.iaL != null) {
            this.iaL.an(str, this.topMargin);
        }
    }

    public void daO() {
        if (this.fGi != null && this.fGi.isEnabled()) {
            this.fGi.setRefreshing(false);
        }
    }

    public void dbj() {
        if (this.kKC != 2) {
            this.hYQ.setNextPage(this.iaL);
            this.kKC = 2;
        }
    }

    public void tq(boolean z) {
        this.kMa = z;
    }

    public void dak() {
        if (this.hYQ == null) {
        }
    }

    public int daP() {
        if (this.hYQ != null) {
            return this.hYQ.getFirstVisiblePosition();
        }
        return 0;
    }

    public int deR() {
        View childAt;
        if (this.hYQ == null || this.hYQ.getCount() <= 0 || (childAt = this.hYQ.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int daQ() {
        if (this.hYQ != null) {
            int lastVisiblePosition = this.hYQ.getLastVisiblePosition();
            if (cWD() != null && cWD().getPbData() != null && lastVisiblePosition >= cWD().getPbData().cVn().size()) {
                return cWD().getPbData().cVn().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View dba() {
        return this.eQZ;
    }

    public int deS() {
        return this.kXy;
    }

    public int deT() {
        return this.kXz;
    }

    public void EN(int i) {
        if (this.kXu != null) {
            this.kXu.setVisibility(i);
        }
    }

    public void uj(boolean z) {
        if (this.hYQ != null) {
            this.hYQ.setCanFling(z);
        }
    }

    public void cX(int i, int i2) {
        if (this.hYQ != null && this.hYQ.getLayoutManager() != null && (this.hYQ.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.hYQ.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }
}
