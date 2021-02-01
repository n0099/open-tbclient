package com.baidu.tieba.pb.videopb.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.aj;
import com.baidu.tieba.pb.videopb.MultiNestedLayout;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.videopb.b.b;
import com.baidu.tieba.pb.videopb.c;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0843a {
    private BdSwipeRefreshLayout gCC;
    private BdTypeRecyclerView jmj;
    private PbActivity lQT;
    private boolean lRJ;
    private View mRootView;
    private VideoPbFragment mlS;
    private b mlV;
    private View mlW;
    private c mmi;
    private MultiNestedLayout mmj;
    private com.baidu.tieba.pb.videopb.videoView.b mmk;
    private View mml;
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
    private RecyclerView.OnScrollListener ipL = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.dnZ().dql();
                ReplyFragment.this.dnZ().duj();
            }
            if (ReplyFragment.this.dnZ() != null) {
                ReplyFragment.this.dnZ().onScrollStateChanged(i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.mma = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.mma != 0) {
                ReplyFragment.this.mlW.setVisibility(8);
            }
            ReplyFragment.this.mma = 0;
        }
    };
    private MultiNestedLayout.b mmm = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void hI(int i) {
            if (ReplyFragment.this.mmb != 1 || i == 1 || ReplyFragment.this.mma == 0) {
                if (ReplyFragment.this.mmb != 0 || i == 0) {
                    if (ReplyFragment.this.mmb != 0 && i == 0) {
                        ReplyFragment.this.dnZ().Gv(8);
                    }
                } else if (ReplyFragment.this.mlW.getVisibility() != 0) {
                    ReplyFragment.this.dnZ().Gv(0);
                }
            } else {
                ReplyFragment.this.dnZ().Gv(8);
                ReplyFragment.this.mlW.setVisibility(0);
            }
            ReplyFragment.this.mmb = i;
        }
    };
    private final f.c fjz = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.dmq() != null && ReplyFragment.this.dmq().vn(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.dqN();
            }
        }
    };
    private CustomMessageListener jpm = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && ReplyFragment.this.dmq() != null && ReplyFragment.this.dmq().getPbData() != null && ReplyFragment.this.dmq().getPbData().dlb() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = ReplyFragment.this.dmq().getPbData().dlb().iterator();
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
                    if (oVar != null && ReplyFragment.this.mmi != null && ReplyFragment.this.jmj != null) {
                        ReplyFragment.this.dmq().getPbData().dlb().remove(oVar);
                        if (ReplyFragment.this.mmi.getDataList() != null) {
                            ReplyFragment.this.mmi.getDataList().remove(oVar);
                        }
                        if (ReplyFragment.this.jmj.getListView2().getData() != null) {
                            ReplyFragment.this.jmj.getListView2().getData().remove(oVar);
                        }
                        ReplyFragment.this.mmi.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e lSK = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (!ReplyFragment.this.lRx && ReplyFragment.this.drA() && ReplyFragment.this.dmq() != null) {
                    ar arVar = new ar("c13999");
                    arVar.dR("tid", ReplyFragment.this.dmq().dot());
                    arVar.dR("fid", ReplyFragment.this.dmq().getForumId());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(arVar);
                    ReplyFragment.this.lRx = true;
                }
                if (ReplyFragment.this.dmq().vm(false)) {
                    ReplyFragment.this.dqL();
                    if (ReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (ReplyFragment.this.dmq().getPbData() != null) {
                    ReplyFragment.this.dri();
                }
            }
        }
    };

    public static ReplyFragment ae(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.mlS = videoPbFragment;
        return replyFragment;
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
        this.mlV = new b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.jpm);
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.mmj = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.mmj.setScrollStateChangeListener(this.mmm);
        this.jmj = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.jmj.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mmi = new c(this, this.jmj);
        this.mmi.H(dnZ().dtV());
        this.mmi.U(dnZ().dtW());
        this.mmi.setOnLongClickListener(dnZ().dtX());
        this.mmi.setOnImageClickListener(this.mlV.getOnImageClickListener());
        this.mmi.setTbGestureDetector(this.mlV.duO());
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
        this.mml = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.mmk = new com.baidu.tieba.pb.videopb.videoView.b(this.mml);
        this.mmk.Z(dnZ().dtV());
        this.mmk.setOnSwitchChangeListener(dnZ().lSB);
        registerListener(this.jpm);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(doa()).get(VideoPbViewModel.class);
        videoPbViewModel.cML().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    ReplyFragment.this.showLoadingView();
                } else {
                    ReplyFragment.this.hideLoadingView();
                }
            }
        });
        d(true, 0, 3, 0, videoPbViewModel.dus(), "", 1);
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
        if (this.mmk != null) {
            this.mmk.onChangeSkinType(i);
        }
        if (this.mmi != null) {
            this.mmi.notifyDataSetChanged();
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

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
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
            this.mmi.setIsFromCDN(videoPbViewModel.isFromCDN());
            this.mmi.wp(this.lNV);
            this.mmi.setData(fVar);
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
            if (this.mmk != null && this.mml != null) {
                com.baidu.tieba.pb.data.o oVar = new com.baidu.tieba.pb.data.o(com.baidu.tieba.pb.data.o.lLq);
                cb dkZ = fVar.dkZ();
                oVar.lLs = dkZ != null ? dkZ.bnH() : 0L;
                oVar.isNew = !dmq().dov();
                oVar.lLv = dnT();
                oVar.sortType = fVar.lJZ;
                oVar.lLu = fVar.dlD();
                oVar.isDynamic = fVar.dlC();
                oVar.lLw = fVar.lJY;
                this.mmk.a(oVar);
            }
            ArrayList<PostData> dlb = fVar.dlb();
            if (fVar.getPage().bmF() == 0 || dlb == null || dlb.size() < fVar.getPage().bmE()) {
                if (y.getCount(dlb) == 0 || (y.getCount(dlb) == 1 && dlb.get(0) != null && dlb.get(0).dNx() == 1)) {
                    if (dnT()) {
                        this.jof.au(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.jof.au(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (fVar.getPage().bmF() == 0) {
                        this.jof.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jof.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jof.bue();
                }
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
                    int size = (this.jmj.getData() == null && fVar.dlb() == null) ? 0 : this.jmj.getData().size() - fVar.dlb().size();
                    this.mmj.setMaxOffset();
                    this.jmj.setSelection(i3 > 0 ? size + i3 : 0);
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
        }
    }

    public void duR() {
        com.baidu.tieba.pb.data.f pbData = dmq().getPbData();
        if (pbData != null) {
            this.mmi.wp(dmq().dov());
            this.mmi.setData(pbData);
            this.mmi.notifyDataSetChanged();
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
    /* renamed from: dvd */
    public c duP() {
        return this.mmi;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, fVar, str, i4);
        }
    }

    public b duT() {
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
    }

    public void endLoadData() {
        if (this.jof != null) {
            this.jof.setLineGone();
            this.jof.endLoadData();
        }
        if (dnZ() != null && dnZ().mko != null) {
            this.mlS.mko.ckq();
        }
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

    public boolean drA() {
        if (this.jof == null || TextUtils.isEmpty(this.jof.getEndText())) {
            return false;
        }
        return this.jof.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
