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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.aj;
import com.baidu.tieba.pb.videopb.MultiNestedLayout;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.videopb.c;
import com.baidu.tieba.pb.videopb.videoView.b;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0857a {
    private int aht;
    private BdSwipeRefreshLayout gEz;
    private BdTypeRecyclerView jlj;
    private PbActivity lMD;
    private boolean lNq;
    private View mRootView;
    private c mhK;
    private MultiNestedLayout mhL;
    private b mhM;
    private View mhN;
    private VideoPbFragment mhv;
    private com.baidu.tieba.pb.videopb.b.b mhy;
    private View mhz;
    private PbListView jnf = null;
    private View fKX = null;
    private com.baidu.tieba.pb.view.a lUJ = null;
    private boolean lVq = false;
    private boolean lVN = false;
    private boolean lWr = true;
    private int lUo = 0;
    private g mPullView = null;
    private boolean lJJ = false;
    private int mhD = 0;
    private int mhE = 0;
    private boolean lNe = false;
    private RecyclerView.OnScrollListener ioM = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.dpD().drP();
                ReplyFragment.this.dpD().dvP();
            }
            if (ReplyFragment.this.dpD() != null) {
                ReplyFragment.this.dpD().onScrollStateChanged(i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.mhD = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.mhD != 0) {
                ReplyFragment.this.mhz.setVisibility(8);
            }
            ReplyFragment.this.mhD = 0;
        }
    };
    private MultiNestedLayout.b mhO = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void jl(int i) {
            if (ReplyFragment.this.mhE != 1 || i == 1 || ReplyFragment.this.mhD == 0) {
                if (ReplyFragment.this.mhE != 0 || i == 0) {
                    if (ReplyFragment.this.mhE != 0 && i == 0) {
                        ReplyFragment.this.dpD().HI(8);
                    }
                } else if (ReplyFragment.this.mhz.getVisibility() != 0) {
                    ReplyFragment.this.dpD().HI(0);
                }
            } else {
                ReplyFragment.this.dpD().HI(8);
                ReplyFragment.this.mhz.setVisibility(0);
            }
            ReplyFragment.this.mhE = i;
        }
    };
    private final f.c flR = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.dnW() != null && ReplyFragment.this.dnW().vc(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.dsr();
            }
        }
    };
    private CustomMessageListener jom = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && ReplyFragment.this.dnW() != null && ReplyFragment.this.dnW().getPbData() != null && ReplyFragment.this.dnW().getPbData().dmH() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = ReplyFragment.this.dnW().getPbData().dmH().iterator();
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
                    if (oVar != null && ReplyFragment.this.mhK != null && ReplyFragment.this.jlj != null) {
                        ReplyFragment.this.dnW().getPbData().dmH().remove(oVar);
                        if (ReplyFragment.this.mhK.getDataList() != null) {
                            ReplyFragment.this.mhK.getDataList().remove(oVar);
                        }
                        if (ReplyFragment.this.jlj.getListView2().getData() != null) {
                            ReplyFragment.this.jlj.getListView2().getData().remove(oVar);
                        }
                        ReplyFragment.this.mhK.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e lOr = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (!ReplyFragment.this.lNe && ReplyFragment.this.dte() && ReplyFragment.this.dnW() != null) {
                    aq aqVar = new aq("c13999");
                    aqVar.dX("tid", ReplyFragment.this.dnW().dpX());
                    aqVar.dX("fid", ReplyFragment.this.dnW().getForumId());
                    aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar);
                    ReplyFragment.this.lNe = true;
                }
                if (ReplyFragment.this.dnW().vb(false)) {
                    ReplyFragment.this.dsp();
                    if (ReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (ReplyFragment.this.dnW().getPbData() != null) {
                    ReplyFragment.this.dsM();
                }
            }
        }
    };

    public static ReplyFragment ae(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.mhv = videoPbFragment;
        return replyFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lMD = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mhy = new com.baidu.tieba.pb.videopb.b.b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.jom);
    }

    private void initUI() {
        this.aht = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.mhL = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.mhL.setScrollStateChangeListener(this.mhO);
        this.jlj = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.jlj.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mhK = new c(this, this.jlj);
        this.mhK.H(dpD().dvA());
        this.mhK.U(dpD().dvB());
        this.mhK.setOnLongClickListener(dpD().dvC());
        this.mhK.setOnImageClickListener(this.mhy.getOnImageClickListener());
        this.mhK.setTbGestureDetector(this.mhy.dwt());
        this.mhz = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.jnf = new PbListView(getPageContext().getPageActivity());
        this.fKX = this.jnf.getView().findViewById(R.id.pb_more_view);
        if (this.fKX != null) {
            this.fKX.setOnClickListener(dpD().dvA());
            ao.setBackgroundResource(this.fKX, R.drawable.pb_foot_more_trans_selector);
        }
        this.jnf.setLineVisible();
        this.jnf.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.jnf.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.jnf.bxD();
        this.jlj.setOnSrollToBottomListener(this.lOr);
        this.jlj.addOnScrollListener(this.ioM);
        this.jlj.setOnTouchListener(dpD().bJf());
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
        this.mhN = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.mhM = new b(this.mhN);
        this.mhM.Z(dpD().dvA());
        this.mhM.setOnSwitchChangeListener(dpD().lOi);
        registerListener(this.jom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(dpE()).get(VideoPbViewModel.class);
        videoPbViewModel.dwh().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: s */
            public void onChanged(@Nullable Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    ReplyFragment.this.showLoadingView();
                } else {
                    ReplyFragment.this.hideLoadingView();
                }
            }
        });
        d(true, 0, 3, 0, videoPbViewModel.dvY(), "", 1);
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
        if (this.mhM != null) {
            this.mhM.onChangeSkinType(i);
        }
        if (this.mhK != null) {
            this.mhK.notifyDataSetChanged();
        }
        if (this.mhz != null) {
            ao.setBackgroundResource(this.mhz, R.drawable.personalize_tab_shadow);
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
        this.lNq = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        vr(z);
        if (dpD() != null && dpD().mfQ != null) {
            this.mhv.mfQ.dwr();
        }
        if (z && this.lNq) {
            dsp();
            dnW().vb(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(dpE()).get(VideoPbViewModel.class);
        if (z && dnW() != null && fVar != null) {
            this.lJJ = dnW().dpZ();
            boolean isEnabled = this.gEz.isEnabled();
            if (fVar.getPage().bqh() == 0 && this.lJJ) {
                this.gEz.setEnabled(false);
            } else if (!isEnabled) {
                this.gEz.setEnabled(true);
                this.gEz.interruptRefresh();
            }
            this.mhK.setIsFromCDN(videoPbViewModel.isFromCDN());
            this.mhK.wc(this.lJJ);
            this.mhK.setData(fVar);
            this.lVq = false;
            if (TbadkCoreApplication.isLogin()) {
                this.jlj.setNextPage(this.jnf);
                this.lUo = 2;
                if (dpD() != null && dpD().mfQ != null) {
                    this.mhv.mfQ.cnj();
                }
            } else {
                this.lVq = true;
                if (fVar.getPage().bqg() == 1) {
                    if (this.lUJ == null) {
                        this.lUJ = new com.baidu.tieba.pb.view.a(this, this);
                        this.lUJ.createView();
                        this.lUJ.bxD();
                    }
                    this.jlj.setNextPage(this.lUJ);
                } else {
                    this.jlj.setNextPage(this.jnf);
                }
                this.lUo = 3;
            }
            if (this.mhM != null && this.mhN != null) {
                n nVar = new n(n.lHh);
                bz dmF = fVar.dmF();
                nVar.lHj = dmF != null ? dmF.bri() : 0L;
                nVar.isNew = !dnW().dpZ();
                nVar.lHm = dpx();
                nVar.sortType = fVar.lFR;
                nVar.lHl = fVar.dnj();
                nVar.isDynamic = fVar.dni();
                nVar.lHn = fVar.lFQ;
                this.mhM.a(nVar);
            }
            ArrayList<PostData> dmH = fVar.dmH();
            if (fVar.getPage().bqg() == 0 || dmH == null || dmH.size() < fVar.getPage().bqf()) {
                if (x.getCount(dmH) == 0 || (x.getCount(dmH) == 1 && dmH.get(0) != null && dmH.get(0).dPe() == 1)) {
                    if (dpx()) {
                        this.jnf.as(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.aht);
                    } else {
                        this.jnf.as(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.aht);
                    }
                } else {
                    if (fVar.getPage().bqg() == 0) {
                        this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jnf.bxE();
                }
                if (fVar.getPage().bqg() == 0 || dmH == null) {
                    dsM();
                }
            } else {
                if (dnW().getIsFromMark()) {
                    if (this.lWr) {
                        endLoadData();
                        if (fVar.getPage().bqg() != 0) {
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
                this.jnf.bxE();
            }
            switch (i2) {
                case 2:
                    this.jlj.setSelection(i3 > 1 ? (((this.jlj.getData() == null && fVar.dmH() == null) ? 0 : this.jlj.getData().size() - fVar.dmH().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable drx = aj.drw().drx();
                        if (drx instanceof RecyclerView.SavedState) {
                            this.jlj.onRestoreInstanceState(drx);
                            if (x.getCount(dmH) > 1 && fVar.getPage().bqg() > 0) {
                                this.jnf.endLoadData();
                                this.jnf.setText(getString(R.string.pb_load_more_without_point));
                                this.jnf.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.lWr = false;
                    break;
                case 5:
                    this.jlj.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable drx2 = aj.drw().drx();
                        if (drx2 instanceof RecyclerView.SavedState) {
                            this.jlj.onRestoreInstanceState(drx2);
                            break;
                        }
                    }
                    this.jlj.setSelection(0);
                    break;
                case 8:
                    int size = (this.jlj.getData() == null && fVar.dmH() == null) ? 0 : this.jlj.getData().size() - fVar.dmH().size();
                    this.mhL.setMaxOffset();
                    this.jlj.setSelection(i3 > 0 ? size + i3 : 0);
                    this.jnf.endLoadData();
                    this.jnf.setText(getString(R.string.pb_load_more_without_point));
                    this.jnf.setLineGone();
                    break;
            }
            if (this.lVN) {
                drJ();
                this.lVN = false;
                if (i4 == 0) {
                    vn(true);
                }
            }
            dpD().u(fVar);
        }
    }

    public void dww() {
        com.baidu.tieba.pb.data.f pbData = dnW().getPbData();
        if (pbData != null) {
            this.mhK.wc(dnW().dpZ());
            this.mhK.setData(pbData);
            this.mhK.notifyDataSetChanged();
            ArrayList<PostData> dmH = pbData.dmH();
            if (pbData.getPage().bqg() == 0 || dmH == null || dmH.size() < pbData.getPage().bqf()) {
                if (x.getCount(dmH) == 0 || (x.getCount(dmH) == 1 && dmH.get(0) != null && dmH.get(0).dPe() == 1)) {
                    if (dpx()) {
                        this.jnf.as(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.aht);
                    } else {
                        this.jnf.as(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.aht);
                    }
                } else {
                    if (pbData.getPage().bqg() == 0) {
                        this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jnf.bxE();
                }
            }
            dpD().u(pbData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity dpE() {
        return this.lMD != null ? this.lMD : dpD().dpE();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment dpD() {
        if (this.mhv == null && this.lMD != null) {
            Fragment doi = this.lMD.doi();
            if (doi instanceof VideoPbFragment) {
                this.mhv = (VideoPbFragment) doi;
            }
        }
        return this.mhv;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel dnW() {
        return dpD().dnW();
    }

    public BdTypeRecyclerView getListView() {
        return this.jlj;
    }

    public boolean dpx() {
        if (dnW() != null) {
            return dnW().getHostMode();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: dwI */
    public c dwu() {
        return this.mhK;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, fVar, str, i4);
        }
    }

    public com.baidu.tieba.pb.videopb.b.b dwy() {
        return this.mhy;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0857a
    public void uS(boolean z) {
        this.lNq = z;
    }

    public void vr(boolean z) {
        if (z && this.lVq) {
            this.jnf.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.jlj.setNextPage(this.jnf);
            this.lUo = 2;
        }
    }

    public void dsp() {
        this.jnf.setLineVisible();
        this.jnf.startLoadData();
    }

    public void endLoadData() {
        if (this.jnf != null) {
            this.jnf.setLineGone();
            this.jnf.endLoadData();
        }
        if (dpD() != null && dpD().mfQ != null) {
            this.mhv.mfQ.cnj();
        }
    }

    public void PW(String str) {
        if (this.jnf != null) {
            this.jnf.setText(str);
        }
    }

    public void PX(String str) {
        if (this.jnf != null) {
            this.jnf.as(str, this.aht);
        }
    }

    public void dsr() {
        if (this.gEz != null && this.gEz.isEnabled()) {
            this.gEz.setRefreshing(false);
        }
    }

    public void dsM() {
        if (this.lUo != 2) {
            this.jlj.setNextPage(this.jnf);
            this.lUo = 2;
        }
    }

    public void vn(boolean z) {
        this.lVN = z;
    }

    public void drJ() {
        if (this.jlj == null) {
        }
    }

    public int dss() {
        if (this.jlj != null) {
            return this.jlj.getFirstVisiblePosition();
        }
        return 0;
    }

    public int dwz() {
        View childAt;
        if (this.jlj == null || this.jlj.getCount() <= 0 || (childAt = this.jlj.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int dst() {
        if (this.jlj != null) {
            int lastVisiblePosition = this.jlj.getLastVisiblePosition();
            if (dnW() != null && dnW().getPbData() != null && lastVisiblePosition >= dnW().getPbData().dmH().size()) {
                return dnW().getPbData().dmH().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View dsD() {
        return this.fKX;
    }

    public int dwA() {
        return this.mhD;
    }

    public int dwB() {
        return this.mhE;
    }

    public void HI(int i) {
        if (this.mhz != null) {
            this.mhz.setVisibility(i);
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

    public boolean dte() {
        if (this.jnf == null || TextUtils.isEmpty(this.jnf.getEndText())) {
            return false;
        }
        return this.jnf.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
