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
import com.baidu.tbadk.core.data.by;
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
import com.baidu.tieba.pb.videopb.c;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.pb.videopb.videoView.b;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes22.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0840a {
    private int agU;
    private BdSwipeRefreshLayout gtA;
    private BdTypeRecyclerView iYW;
    private PbActivity lHp;
    private boolean lIc;
    private View mRootView;
    private MultiNestedLayout mcA;
    private b mcB;
    private View mcC;
    private VideoPbFragment mck;
    private com.baidu.tieba.pb.videopb.b.b mcn;
    private View mco;
    private c mcz;
    private PbListView jaS = null;
    private View fBr = null;
    private com.baidu.tieba.pb.view.a lPy = null;
    private boolean lQe = false;
    private boolean lQB = false;
    private boolean lRf = true;
    private int lPd = 0;
    private g mPullView = null;
    private boolean lEx = false;
    private int mcs = 0;
    private int mct = 0;
    private boolean lHQ = false;
    private RecyclerView.OnScrollListener icm = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.dpQ().dsc();
                ReplyFragment.this.dpQ().dvZ();
            }
            if (ReplyFragment.this.dpQ() != null) {
                ReplyFragment.this.dpQ().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.mcs = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.mcs != 0) {
                ReplyFragment.this.mco.setVisibility(8);
            }
            ReplyFragment.this.mcs = 0;
        }
    };
    private MultiNestedLayout.b mcD = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void jq(int i) {
            if (ReplyFragment.this.mct != 1 || i == 1 || ReplyFragment.this.mcs == 0) {
                if (ReplyFragment.this.mct != 0 || i == 0) {
                    if (ReplyFragment.this.mct != 0 && i == 0) {
                        ReplyFragment.this.dpQ().HP(8);
                    }
                } else if (ReplyFragment.this.mco.getVisibility() != 0) {
                    ReplyFragment.this.dpQ().HP(0);
                }
            } else {
                ReplyFragment.this.dpQ().HP(8);
                ReplyFragment.this.mco.setVisibility(0);
            }
            ReplyFragment.this.mct = i;
        }
    };
    private final f.c fci = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.dol() != null && ReplyFragment.this.dol().vb(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.dsC();
            }
        }
    };
    private CustomMessageListener jqi = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && ReplyFragment.this.dol() != null && ReplyFragment.this.dol().getPbData() != null && ReplyFragment.this.dol().getPbData().dmW() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = ReplyFragment.this.dol().getPbData().dmW().iterator();
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
                    if (nVar != null && ReplyFragment.this.mcz != null && ReplyFragment.this.iYW != null) {
                        ReplyFragment.this.dol().getPbData().dmW().remove(nVar);
                        if (ReplyFragment.this.mcz.getDataList() != null) {
                            ReplyFragment.this.mcz.getDataList().remove(nVar);
                        }
                        if (ReplyFragment.this.iYW.getListView2().getData() != null) {
                            ReplyFragment.this.iYW.getListView2().getData().remove(nVar);
                        }
                        ReplyFragment.this.mcz.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e lJd = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (!ReplyFragment.this.lHQ && ReplyFragment.this.dtp() && ReplyFragment.this.dol() != null) {
                    ar arVar = new ar("c13999");
                    arVar.dY("tid", ReplyFragment.this.dol().dqk());
                    arVar.dY("fid", ReplyFragment.this.dol().getForumId());
                    arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(arVar);
                    ReplyFragment.this.lHQ = true;
                }
                if (ReplyFragment.this.dol().va(false)) {
                    ReplyFragment.this.dsA();
                    if (ReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (ReplyFragment.this.dol().getPbData() != null) {
                    ReplyFragment.this.dsX();
                }
            }
        }
    };

    public static ReplyFragment ae(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.mck = videoPbFragment;
        return replyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lHp = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mcn = new com.baidu.tieba.pb.videopb.b.b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.jqi);
    }

    private void initUI() {
        this.agU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.mcA = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.mcA.setScrollStateChangeListener(this.mcD);
        this.iYW = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.iYW.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mcz = new c(this, this.iYW);
        this.mcz.F(dpQ().dvK());
        this.mcz.S(dpQ().dvL());
        this.mcz.setOnLongClickListener(dpQ().dvM());
        this.mcz.setOnImageClickListener(this.mcn.getOnImageClickListener());
        this.mcz.setTbGestureDetector(this.mcn.dwD());
        this.mco = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.jaS = new PbListView(getPageContext().getPageActivity());
        this.fBr = this.jaS.getView().findViewById(R.id.pb_more_view);
        if (this.fBr != null) {
            this.fBr.setOnClickListener(dpQ().dvK());
            ap.setBackgroundResource(this.fBr, R.drawable.pb_foot_more_trans_selector);
        }
        this.jaS.setLineVisible();
        this.jaS.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.jaS.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.jaS.bvh();
        this.iYW.setOnSrollToBottomListener(this.lJd);
        this.iYW.addOnScrollListener(this.icm);
        this.iYW.setOnTouchListener(dpQ().bGL());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.fci);
        }
        if (this.gtA == null) {
            this.gtA = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.gtA.setProgressView(this.mPullView);
            this.gtA.setEnabled(false);
            ap.setBackgroundColor(this.gtA, R.color.CAM_X0205);
        }
        this.mcC = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.mcB = new b(this.mcC);
        this.mcB.X(dpQ().dvK());
        this.mcB.setOnSwitchChangeListener(dpQ().lIU);
        registerListener(this.jqi);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e eVar = (e) y.b(dpR()).l(e.class);
        eVar.dwr().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
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
        d(true, 0, 3, 0, eVar.dwi(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jaS != null) {
            this.jaS.changeSkin(i);
            if (this.fBr != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fBr);
                ap.setBackgroundResource(this.fBr, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.mcB != null) {
            this.mcB.onChangeSkinType(i);
        }
        if (this.mcz != null) {
            this.mcz.notifyDataSetChanged();
        }
        if (this.mco != null) {
            ap.setBackgroundResource(this.mco, R.drawable.personalize_tab_shadow);
        }
        ap.setBackgroundColor(this.gtA, R.color.CAM_X0201);
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
        this.lIc = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        vq(z);
        if (dpQ() != null && dpQ().maF != null) {
            this.mck.maF.dwB();
        }
        if (z && this.lIc) {
            dsA();
            dol().va(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        e eVar = (e) y.b(dpR()).l(e.class);
        if (z && dol() != null && fVar != null) {
            this.lEx = dol().dqm();
            boolean isEnabled = this.gtA.isEnabled();
            if (fVar.getPage().bnG() == 0 && this.lEx) {
                this.gtA.setEnabled(false);
            } else if (!isEnabled) {
                this.gtA.setEnabled(true);
                this.gtA.interruptRefresh();
            }
            this.mcz.setIsFromCDN(eVar.isFromCDN());
            this.mcz.wb(this.lEx);
            this.mcz.setData(fVar);
            this.lQe = false;
            if (TbadkCoreApplication.isLogin()) {
                this.iYW.setNextPage(this.jaS);
                this.lPd = 2;
                if (dpQ() != null && dpQ().maF != null) {
                    this.mck.maF.cku();
                }
            } else {
                this.lQe = true;
                if (fVar.getPage().bnF() == 1) {
                    if (this.lPy == null) {
                        this.lPy = new com.baidu.tieba.pb.view.a(this, this);
                        this.lPy.createView();
                        this.lPy.bvh();
                    }
                    this.iYW.setNextPage(this.lPy);
                } else {
                    this.iYW.setNextPage(this.jaS);
                }
                this.lPd = 3;
            }
            if (this.mcB != null && this.mcC != null) {
                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.lCc);
                by dmU = fVar.dmU();
                nVar.lCe = dmU != null ? dmU.boG() : 0L;
                nVar.isNew = !dol().dqm();
                nVar.lCh = dpK();
                nVar.sortType = fVar.lAM;
                nVar.lCg = fVar.dnz();
                nVar.isDynamic = fVar.dny();
                nVar.lCi = fVar.lAL;
                this.mcB.a(nVar);
            }
            ArrayList<PostData> dmW = fVar.dmW();
            if (fVar.getPage().bnF() == 0 || dmW == null || dmW.size() < fVar.getPage().bnE()) {
                if (com.baidu.tbadk.core.util.y.getCount(dmW) == 0 || (com.baidu.tbadk.core.util.y.getCount(dmW) == 1 && dmW.get(0) != null && dmW.get(0).dPh() == 1)) {
                    if (dpK()) {
                        this.jaS.aq(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.agU);
                    } else {
                        this.jaS.aq(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.agU);
                    }
                } else {
                    if (fVar.getPage().bnF() == 0) {
                        this.jaS.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jaS.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jaS.bvi();
                }
                if (fVar.getPage().bnF() == 0 || dmW == null) {
                    dsX();
                }
            } else {
                if (dol().getIsFromMark()) {
                    if (this.lRf) {
                        endLoadData();
                        if (fVar.getPage().bnF() != 0) {
                            this.jaS.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.jaS.setLineVisible();
                        this.jaS.showLoading();
                    }
                } else {
                    this.jaS.setLineVisible();
                    this.jaS.showLoading();
                }
                this.jaS.bvi();
            }
            switch (i2) {
                case 2:
                    this.iYW.setSelection(i3 > 1 ? (((this.iYW.getData() == null && fVar.dmW() == null) ? 0 : this.iYW.getData().size() - fVar.dmW().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable drK = as.drJ().drK();
                        if (drK instanceof RecyclerView.SavedState) {
                            this.iYW.onRestoreInstanceState(drK);
                            if (com.baidu.tbadk.core.util.y.getCount(dmW) > 1 && fVar.getPage().bnF() > 0) {
                                this.jaS.endLoadData();
                                this.jaS.setText(getString(R.string.pb_load_more_without_point));
                                this.jaS.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.lRf = false;
                    break;
                case 5:
                    this.iYW.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable drK2 = as.drJ().drK();
                        if (drK2 instanceof RecyclerView.SavedState) {
                            this.iYW.onRestoreInstanceState(drK2);
                            break;
                        }
                    }
                    this.iYW.setSelection(0);
                    break;
                case 8:
                    int size = (this.iYW.getData() == null && fVar.dmW() == null) ? 0 : this.iYW.getData().size() - fVar.dmW().size();
                    this.mcA.setMaxOffset();
                    this.iYW.setSelection(i3 > 0 ? size + i3 : 0);
                    this.jaS.endLoadData();
                    this.jaS.setText(getString(R.string.pb_load_more_without_point));
                    this.jaS.setLineGone();
                    break;
            }
            if (this.lQB) {
                drW();
                this.lQB = false;
                if (i4 == 0) {
                    vm(true);
                }
            }
            dpQ().u(fVar);
        }
    }

    public void dwG() {
        com.baidu.tieba.pb.data.f pbData = dol().getPbData();
        if (pbData != null) {
            this.mcz.wb(dol().dqm());
            this.mcz.setData(pbData);
            this.mcz.notifyDataSetChanged();
            ArrayList<PostData> dmW = pbData.dmW();
            if (pbData.getPage().bnF() == 0 || dmW == null || dmW.size() < pbData.getPage().bnE()) {
                if (com.baidu.tbadk.core.util.y.getCount(dmW) == 0 || (com.baidu.tbadk.core.util.y.getCount(dmW) == 1 && dmW.get(0) != null && dmW.get(0).dPh() == 1)) {
                    if (dpK()) {
                        this.jaS.aq(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.agU);
                    } else {
                        this.jaS.aq(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.agU);
                    }
                } else {
                    if (pbData.getPage().bnF() == 0) {
                        this.jaS.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jaS.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jaS.bvi();
                }
            }
            dpQ().u(pbData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity dpR() {
        return this.lHp != null ? this.lHp : dpQ().dpR();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment dpQ() {
        if (this.mck == null && this.lHp != null) {
            Fragment dox = this.lHp.dox();
            if (dox instanceof VideoPbFragment) {
                this.mck = (VideoPbFragment) dox;
            }
        }
        return this.mck;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel dol() {
        return dpQ().dol();
    }

    public BdTypeRecyclerView getListView() {
        return this.iYW;
    }

    public boolean dpK() {
        if (dol() != null) {
            return dol().getHostMode();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: dwS */
    public c dwE() {
        return this.mcz;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, fVar, str, i4);
        }
    }

    public com.baidu.tieba.pb.videopb.b.b dwI() {
        return this.mcn;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0840a
    public void uR(boolean z) {
        this.lIc = z;
    }

    public void vq(boolean z) {
        if (z && this.lQe) {
            this.jaS.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.iYW.setNextPage(this.jaS);
            this.lPd = 2;
        }
    }

    public void dsA() {
        this.jaS.setLineVisible();
        this.jaS.startLoadData();
    }

    public void endLoadData() {
        if (this.jaS != null) {
            this.jaS.setLineGone();
            this.jaS.endLoadData();
        }
        if (dpQ() != null && dpQ().maF != null) {
            this.mck.maF.cku();
        }
    }

    public void Qr(String str) {
        if (this.jaS != null) {
            this.jaS.setText(str);
        }
    }

    public void Qs(String str) {
        if (this.jaS != null) {
            this.jaS.aq(str, this.agU);
        }
    }

    public void dsC() {
        if (this.gtA != null && this.gtA.isEnabled()) {
            this.gtA.setRefreshing(false);
        }
    }

    public void dsX() {
        if (this.lPd != 2) {
            this.iYW.setNextPage(this.jaS);
            this.lPd = 2;
        }
    }

    public void vm(boolean z) {
        this.lQB = z;
    }

    public void drW() {
        if (this.iYW == null) {
        }
    }

    public int dsD() {
        if (this.iYW != null) {
            return this.iYW.getFirstVisiblePosition();
        }
        return 0;
    }

    public int dwJ() {
        View childAt;
        if (this.iYW == null || this.iYW.getCount() <= 0 || (childAt = this.iYW.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int dsE() {
        if (this.iYW != null) {
            int lastVisiblePosition = this.iYW.getLastVisiblePosition();
            if (dol() != null && dol().getPbData() != null && lastVisiblePosition >= dol().getPbData().dmW().size()) {
                return dol().getPbData().dmW().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View dsO() {
        return this.fBr;
    }

    public int dwK() {
        return this.mcs;
    }

    public int dwL() {
        return this.mct;
    }

    public void HP(int i) {
        if (this.mco != null) {
            this.mco.setVisibility(i);
        }
    }

    public void wh(boolean z) {
        if (this.iYW != null) {
            this.iYW.setCanFling(z);
        }
    }

    public void dj(int i, int i2) {
        if (this.iYW != null && this.iYW.getLayoutManager() != null && (this.iYW.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.iYW.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    public boolean dtp() {
        if (this.jaS == null || TextUtils.isEmpty(this.jaS.getEndText())) {
            return false;
        }
        return this.jaS.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
