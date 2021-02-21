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
public class ReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0844a {
    private BdSwipeRefreshLayout gCQ;
    private BdTypeRecyclerView jmy;
    private boolean lRY;
    private PbActivity lRi;
    private View mRootView;
    private View mmA;
    private VideoPbFragment mmh;
    private b mmk;
    private View mml;
    private c mmx;
    private MultiNestedLayout mmy;
    private com.baidu.tieba.pb.videopb.videoView.b mmz;
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
    private RecyclerView.OnScrollListener ipZ = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.dog().dqs();
                ReplyFragment.this.dog().duq();
            }
            if (ReplyFragment.this.dog() != null) {
                ReplyFragment.this.dog().onScrollStateChanged(i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.mmp = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.mmp != 0) {
                ReplyFragment.this.mml.setVisibility(8);
            }
            ReplyFragment.this.mmp = 0;
        }
    };
    private MultiNestedLayout.b mmB = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void hI(int i) {
            if (ReplyFragment.this.mmq != 1 || i == 1 || ReplyFragment.this.mmp == 0) {
                if (ReplyFragment.this.mmq != 0 || i == 0) {
                    if (ReplyFragment.this.mmq != 0 && i == 0) {
                        ReplyFragment.this.dog().Gv(8);
                    }
                } else if (ReplyFragment.this.mml.getVisibility() != 0) {
                    ReplyFragment.this.dog().Gv(0);
                }
            } else {
                ReplyFragment.this.dog().Gv(8);
                ReplyFragment.this.mml.setVisibility(0);
            }
            ReplyFragment.this.mmq = i;
        }
    };
    private final f.c fjz = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.dmx() != null && ReplyFragment.this.dmx().vn(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.dqU();
            }
        }
    };
    private CustomMessageListener jpA = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && ReplyFragment.this.dmx() != null && ReplyFragment.this.dmx().getPbData() != null && ReplyFragment.this.dmx().getPbData().dli() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = ReplyFragment.this.dmx().getPbData().dli().iterator();
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
                    if (oVar != null && ReplyFragment.this.mmx != null && ReplyFragment.this.jmy != null) {
                        ReplyFragment.this.dmx().getPbData().dli().remove(oVar);
                        if (ReplyFragment.this.mmx.getDataList() != null) {
                            ReplyFragment.this.mmx.getDataList().remove(oVar);
                        }
                        if (ReplyFragment.this.jmy.getListView2().getData() != null) {
                            ReplyFragment.this.jmy.getListView2().getData().remove(oVar);
                        }
                        ReplyFragment.this.mmx.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e lSZ = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (!ReplyFragment.this.lRM && ReplyFragment.this.drH() && ReplyFragment.this.dmx() != null) {
                    ar arVar = new ar("c13999");
                    arVar.dR("tid", ReplyFragment.this.dmx().doA());
                    arVar.dR("fid", ReplyFragment.this.dmx().getForumId());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(arVar);
                    ReplyFragment.this.lRM = true;
                }
                if (ReplyFragment.this.dmx().vm(false)) {
                    ReplyFragment.this.dqS();
                    if (ReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (ReplyFragment.this.dmx().getPbData() != null) {
                    ReplyFragment.this.drp();
                }
            }
        }
    };

    public static ReplyFragment ae(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.mmh = videoPbFragment;
        return replyFragment;
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
        this.mmk = new b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.jpA);
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.mmy = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.mmy.setScrollStateChangeListener(this.mmB);
        this.jmy = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.jmy.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mmx = new c(this, this.jmy);
        this.mmx.H(dog().duc());
        this.mmx.U(dog().dud());
        this.mmx.setOnLongClickListener(dog().due());
        this.mmx.setOnImageClickListener(this.mmk.getOnImageClickListener());
        this.mmx.setTbGestureDetector(this.mmk.duV());
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
        this.mmA = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.mmz = new com.baidu.tieba.pb.videopb.videoView.b(this.mmA);
        this.mmz.Z(dog().duc());
        this.mmz.setOnSwitchChangeListener(dog().lSQ);
        registerListener(this.jpA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(doh()).get(VideoPbViewModel.class);
        videoPbViewModel.cMS().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
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
        d(true, 0, 3, 0, videoPbViewModel.duz(), "", 1);
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
        if (this.mmz != null) {
            this.mmz.onChangeSkinType(i);
        }
        if (this.mmx != null) {
            this.mmx.notifyDataSetChanged();
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

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
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
            this.mmx.setIsFromCDN(videoPbViewModel.isFromCDN());
            this.mmx.wp(this.lOk);
            this.mmx.setData(fVar);
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
            if (this.mmz != null && this.mmA != null) {
                com.baidu.tieba.pb.data.o oVar = new com.baidu.tieba.pb.data.o(com.baidu.tieba.pb.data.o.lLF);
                cb dlg = fVar.dlg();
                oVar.lLH = dlg != null ? dlg.bnH() : 0L;
                oVar.isNew = !dmx().doC();
                oVar.lLK = doa();
                oVar.sortType = fVar.lKn;
                oVar.lLJ = fVar.dlK();
                oVar.isDynamic = fVar.dlJ();
                oVar.lLL = fVar.lKm;
                this.mmz.a(oVar);
            }
            ArrayList<PostData> dli = fVar.dli();
            if (fVar.getPage().bmF() == 0 || dli == null || dli.size() < fVar.getPage().bmE()) {
                if (y.getCount(dli) == 0 || (y.getCount(dli) == 1 && dli.get(0) != null && dli.get(0).dNF() == 1)) {
                    if (doa()) {
                        this.jot.au(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.jot.au(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (fVar.getPage().bmF() == 0) {
                        this.jot.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jot.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jot.bue();
                }
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
                    int size = (this.jmy.getData() == null && fVar.dli() == null) ? 0 : this.jmy.getData().size() - fVar.dli().size();
                    this.mmy.setMaxOffset();
                    this.jmy.setSelection(i3 > 0 ? size + i3 : 0);
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
        }
    }

    public void duY() {
        com.baidu.tieba.pb.data.f pbData = dmx().getPbData();
        if (pbData != null) {
            this.mmx.wp(dmx().doC());
            this.mmx.setData(pbData);
            this.mmx.notifyDataSetChanged();
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
    /* renamed from: dvk */
    public c duW() {
        return this.mmx;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, fVar, str, i4);
        }
    }

    public b dva() {
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
    }

    public void endLoadData() {
        if (this.jot != null) {
            this.jot.setLineGone();
            this.jot.endLoadData();
        }
        if (dog() != null && dog().mkD != null) {
            this.mmh.mkD.ckx();
        }
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

    public boolean drH() {
        if (this.jot == null || TextUtils.isEmpty(this.jot.getEndText())) {
            return false;
        }
        return this.jot.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
