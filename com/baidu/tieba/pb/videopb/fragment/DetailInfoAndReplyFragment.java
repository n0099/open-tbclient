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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
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
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0774a {
    private LinearLayoutManager dEH;
    private BdSwipeRefreshLayout fJy;
    private BdTypeRecyclerView iga;
    private PbActivity kLA;
    private boolean kMl;
    private VideoPbFragment lgd;
    private b lgf;
    private com.baidu.tieba.pb.videopb.b.b lgg;
    private View lgh;
    private LinearLayout lgi;
    private au lgj;
    private l lgk;
    private View mRootView;
    private int topMargin;
    private PbListView ihW = null;
    private View eTU = null;
    private com.baidu.tieba.pb.view.a kTE = null;
    private boolean kUk = false;
    private boolean kUH = false;
    private boolean kVh = true;
    private int kTj = 0;
    private g mPullView = null;
    private boolean kIM = false;
    private int lgl = 0;
    private int lgm = 0;
    private boolean kMa = false;
    private RecyclerView.OnScrollListener hjC = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                DetailInfoAndReplyFragment.this.dbL().ddU();
                DetailInfoAndReplyFragment.this.dbL().dhM();
            }
            if (DetailInfoAndReplyFragment.this.dbL() != null) {
                DetailInfoAndReplyFragment.this.dbL().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            DetailInfoAndReplyFragment.this.diz();
            if (recyclerView.canScrollVertically(-1)) {
                DetailInfoAndReplyFragment.this.lgl = 2;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoAndReplyFragment.this.lgl != 0) {
                DetailInfoAndReplyFragment.this.lgh.setVisibility(8);
            }
            DetailInfoAndReplyFragment.this.lgl = 0;
        }
    };
    private final f.c evf = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (DetailInfoAndReplyFragment.this.dah() != null && DetailInfoAndReplyFragment.this.dah().tp(true)) {
                TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                DetailInfoAndReplyFragment.this.des();
            }
        }
    };
    private CustomMessageListener iuE = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            n nVar;
            if (customResponsedMessage != null && DetailInfoAndReplyFragment.this.dah() != null && DetailInfoAndReplyFragment.this.dah().getPbData() != null && DetailInfoAndReplyFragment.this.dah().getPbData().cYT() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = DetailInfoAndReplyFragment.this.dah().getPbData().cYT().iterator();
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
                    if (nVar != null && DetailInfoAndReplyFragment.this.lgf != null && DetailInfoAndReplyFragment.this.iga != null) {
                        DetailInfoAndReplyFragment.this.dah().getPbData().cYT().remove(nVar);
                        if (DetailInfoAndReplyFragment.this.lgf.getDataList() != null) {
                            DetailInfoAndReplyFragment.this.lgf.getDataList().remove(nVar);
                        }
                        if (DetailInfoAndReplyFragment.this.iga.getListView2().getData() != null) {
                            DetailInfoAndReplyFragment.this.iga.getListView2().getData().remove(nVar);
                        }
                        DetailInfoAndReplyFragment.this.lgf.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e kNm = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (DetailInfoAndReplyFragment.this.mIsLogin) {
                if (!DetailInfoAndReplyFragment.this.kMa && DetailInfoAndReplyFragment.this.dfg() && DetailInfoAndReplyFragment.this.dah() != null) {
                    aq aqVar = new aq("c13999");
                    aqVar.dF("tid", DetailInfoAndReplyFragment.this.dah().dcf());
                    aqVar.dF("fid", DetailInfoAndReplyFragment.this.dah().getForumId());
                    aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar);
                    DetailInfoAndReplyFragment.this.kMa = true;
                }
                if (DetailInfoAndReplyFragment.this.dah().to(false)) {
                    DetailInfoAndReplyFragment.this.deq();
                    if (DetailInfoAndReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (DetailInfoAndReplyFragment.this.dah().getPbData() != null) {
                    DetailInfoAndReplyFragment.this.deN();
                }
            }
        }
    };

    public static DetailInfoAndReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
        detailInfoAndReplyFragment.setArguments(bundle);
        detailInfoAndReplyFragment.lgd = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.kLA = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.lgg = new com.baidu.tieba.pb.videopb.b.b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.iuE);
    }

    private void initUI() {
        this.topMargin = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.iga = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.dEH = new LinearLayoutManager(getContext()) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.4
            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // android.support.v7.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        };
        this.iga.setLayoutManager(this.dEH);
        this.lgf = new b(this, this.iga);
        this.lgf.F(dbL().dhx());
        this.lgf.S(dbL().dhy());
        this.lgf.setOnLongClickListener(dbL().dhz());
        this.lgf.setOnImageClickListener(this.lgg.getOnImageClickListener());
        this.lgf.setTbGestureDetector(this.lgg.diq());
        this.lgh = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.ihW = new PbListView(getPageContext().getPageActivity());
        this.eTU = this.ihW.getView().findViewById(R.id.pb_more_view);
        if (this.eTU != null) {
            this.eTU.setOnClickListener(dbL().dhx());
            ap.setBackgroundResource(this.eTU, R.drawable.pb_foot_more_trans_selector);
        }
        this.ihW.setLineVisible();
        this.ihW.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.ihW.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.ihW.blq();
        this.iga.setOnSrollToBottomListener(this.kNm);
        this.iga.addOnScrollListener(this.hjC);
        this.iga.setOnTouchListener(dbL().bwR());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.evf);
        }
        if (this.fJy == null) {
            this.fJy = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.fJy.setProgressView(this.mPullView);
            this.fJy.setEnabled(false);
            ap.setBackgroundColor(this.fJy, R.color.cp_bg_line_e);
        }
        this.lgi = (LinearLayout) this.mRootView.findViewById(R.id.video_pb_suck_container);
        dis();
        this.lgf.setOnSwitchChangeListener(dbL().kNd);
        registerListener(this.iuE);
    }

    private void dis() {
        this.lgj = new au(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
        this.lgj.XR = false;
        this.lgj.U(dbL().dhx());
        this.lgj.setOnSwitchChangeListener(dbL().kNd);
        this.lgj.Ey(8);
        this.lgi.addView(this.lgj.getRootView());
        this.lgk = new l(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
        e eVar = new e();
        eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
        this.lgk.a(eVar);
        this.lgk.Ey(8);
        this.lgi.addView(this.lgk.getRootView());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        com.baidu.tieba.pb.videopb.e eVar = (com.baidu.tieba.pb.videopb.e) y.b(dbM()).l(com.baidu.tieba.pb.videopb.e.class);
        eVar.die().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: q */
            public void onChanged(@Nullable Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    DetailInfoAndReplyFragment.this.showLoadingView();
                } else {
                    DetailInfoAndReplyFragment.this.hideLoadingView();
                }
            }
        });
        d(true, 0, 3, 0, eVar.dhV(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ihW != null) {
            this.ihW.changeSkin(i);
            if (this.eTU != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.eTU);
                ap.setBackgroundResource(this.eTU, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.lgj != null) {
            this.lgj.onChangeSkinType(i);
        }
        if (this.lgk != null) {
            this.lgk.onChangeSkinType();
        }
        if (this.lgf != null) {
            this.lgf.notifyDataSetChanged();
        }
        if (this.lgh != null) {
            ap.setBackgroundResource(this.lgh, R.drawable.personalize_tab_shadow);
        }
        ap.setBackgroundColor(this.fJy, R.color.cp_bg_line_d);
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
        this.kMl = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        tD(z);
        if (dbL() != null && dbL().ley != null) {
            this.lgd.ley.dio();
        }
        if (z && this.kMl) {
            deq();
            dah().to(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        com.baidu.tieba.pb.videopb.e eVar = (com.baidu.tieba.pb.videopb.e) y.b(dbM()).l(com.baidu.tieba.pb.videopb.e.class);
        if (z && dah() != null && fVar != null) {
            this.kIM = dah().dch();
            boolean isEnabled = this.fJy.isEnabled();
            if (fVar.getPage().bep() == 0 && this.kIM) {
                this.fJy.setEnabled(false);
            } else if (!isEnabled) {
                this.fJy.setEnabled(true);
                this.fJy.interruptRefresh();
            }
            this.lgf.setIsFromCDN(eVar.isFromCDN());
            this.lgf.uo(this.kIM);
            this.lgf.setData(fVar);
            this.kUk = false;
            if (TbadkCoreApplication.isLogin()) {
                this.iga.setNextPage(this.ihW);
                this.kTj = 2;
                if (dbL() != null && dbL().ley != null) {
                    this.lgd.ley.bXZ();
                }
            } else {
                this.kUk = true;
                if (fVar.getPage().beo() == 1) {
                    if (this.kTE == null) {
                        this.kTE = new com.baidu.tieba.pb.view.a(this, this);
                        this.kTE.createView();
                        this.kTE.blq();
                    }
                    this.iga.setNextPage(this.kTE);
                } else {
                    this.iga.setNextPage(this.ihW);
                }
                this.kTj = 3;
            }
            if (this.lgj != null) {
                com.baidu.tieba.pb.data.n nVar = new com.baidu.tieba.pb.data.n(com.baidu.tieba.pb.data.n.kGC);
                bw cYR = fVar.cYR();
                nVar.kGE = cYR != null ? cYR.bfp() : 0L;
                nVar.isNew = !dah().dch();
                nVar.kGH = dbF();
                nVar.sortType = fVar.kFo;
                nVar.kGG = fVar.cZv();
                nVar.isDynamic = fVar.cZu();
                nVar.kGI = fVar.kFn;
                this.lgj.a(nVar);
            }
            ArrayList<PostData> cYT = fVar.cYT();
            if (fVar.getPage().beo() == 0 || cYT == null || cYT.size() < fVar.getPage().ben()) {
                if (fVar.getPage().beo() == 0) {
                    this.ihW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.ihW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.ihW.blr();
                if (fVar.getPage().beo() == 0 || cYT == null) {
                    deN();
                }
            } else {
                if (dah().getIsFromMark()) {
                    if (this.kVh) {
                        endLoadData();
                        if (fVar.getPage().beo() != 0) {
                            this.ihW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.ihW.setLineVisible();
                        this.ihW.showLoading();
                    }
                } else {
                    this.ihW.setLineVisible();
                    this.ihW.showLoading();
                }
                this.ihW.blr();
            }
            switch (i2) {
                case 2:
                    this.iga.setSelection(i3 > 1 ? (((this.iga.getData() == null && fVar.cYT() == null) ? 0 : this.iga.getData().size() - fVar.cYT().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable ddB = as.ddA().ddB();
                        if (ddB instanceof RecyclerView.SavedState) {
                            this.iga.onRestoreInstanceState(ddB);
                            if (com.baidu.tbadk.core.util.y.getCount(cYT) > 1 && fVar.getPage().beo() > 0) {
                                this.ihW.endLoadData();
                                this.ihW.setText(getString(R.string.pb_load_more_without_point));
                                this.ihW.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.kVh = false;
                    break;
                case 5:
                    this.iga.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable ddB2 = as.ddA().ddB();
                        if (ddB2 instanceof RecyclerView.SavedState) {
                            this.iga.onRestoreInstanceState(ddB2);
                            break;
                        }
                    }
                    this.iga.setSelection(0);
                    break;
                case 8:
                    this.iga.setSelection(i3 > 0 ? ((this.iga.getData() == null && fVar.cYT() == null) ? 0 : this.iga.getData().size() - fVar.cYT().size()) + i3 : 0);
                    this.ihW.endLoadData();
                    this.ihW.setText(getString(R.string.pb_load_more_without_point));
                    this.ihW.setLineGone();
                    break;
            }
            if (this.kUH) {
                ddO();
                this.kUH = false;
                if (i4 == 0) {
                    tz(true);
                }
            }
            dbL().u(fVar);
            if (this.ihW != null) {
                if (fVar.getPage().beo() == 0) {
                    this.ihW.setVisibility(8);
                } else {
                    this.ihW.setVisibility(0);
                }
            }
        }
    }

    public void dit() {
        com.baidu.tieba.pb.data.f pbData = dah().getPbData();
        if (pbData != null) {
            this.lgf.uo(dah().dch());
            this.lgf.setData(pbData);
            this.lgf.notifyDataSetChanged();
            ArrayList<PostData> cYT = pbData.cYT();
            if (pbData.getPage().beo() == 0 || cYT == null || cYT.size() < pbData.getPage().ben()) {
                if (com.baidu.tbadk.core.util.y.getCount(cYT) == 0 || (com.baidu.tbadk.core.util.y.getCount(cYT) == 1 && cYT.get(0) != null && cYT.get(0).dAD() == 1)) {
                    if (dbF()) {
                        this.ihW.an(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.ihW.an(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().beo() == 0) {
                        this.ihW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.ihW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.ihW.blr();
                }
            }
            dbL().u(pbData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity dbM() {
        return this.kLA != null ? this.kLA : dbL().dbM();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment dbL() {
        if (this.lgd == null && this.kLA != null) {
            Fragment dat = this.kLA.dat();
            if (dat instanceof VideoPbFragment) {
                this.lgd = (VideoPbFragment) dat;
            }
        }
        return this.lgd;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel dah() {
        return dbL().dah();
    }

    public BdTypeRecyclerView getListView() {
        return this.iga;
    }

    public boolean dbF() {
        if (dah() != null) {
            return dah().getHostMode();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: diu */
    public b dir() {
        return this.lgf;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, fVar, str, i4);
        }
    }

    public com.baidu.tieba.pb.videopb.b.b div() {
        return this.lgg;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0774a
    public void tf(boolean z) {
        this.kMl = z;
    }

    public void tD(boolean z) {
        if (z && this.kUk) {
            this.ihW.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.iga.setNextPage(this.ihW);
            this.kTj = 2;
        }
    }

    public void deq() {
        this.ihW.setLineVisible();
        this.ihW.startLoadData();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, true));
    }

    public void endLoadData() {
        if (this.ihW != null) {
            this.ihW.setLineGone();
            this.ihW.endLoadData();
        }
        if (dbL() != null && dbL().ley != null) {
            this.lgd.ley.bXZ();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, false));
    }

    public void Oj(String str) {
        if (this.ihW != null) {
            this.ihW.setText(str);
        }
    }

    public void Ok(String str) {
        if (this.ihW != null) {
            this.ihW.an(str, this.topMargin);
        }
    }

    public void des() {
        if (this.fJy != null && this.fJy.isEnabled()) {
            this.fJy.setRefreshing(false);
        }
    }

    public void deN() {
        if (this.kTj != 2) {
            this.iga.setNextPage(this.ihW);
            this.kTj = 2;
        }
    }

    public void tz(boolean z) {
        this.kUH = z;
    }

    public void ddO() {
        if (this.iga == null) {
        }
    }

    public int det() {
        if (this.iga != null) {
            return this.iga.getFirstVisiblePosition();
        }
        return 0;
    }

    public int diw() {
        View childAt;
        if (this.iga == null || this.iga.getCount() <= 0 || (childAt = this.iga.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int deu() {
        if (this.iga != null) {
            int lastVisiblePosition = this.iga.getLastVisiblePosition();
            if (dah() != null && dah().getPbData() != null && lastVisiblePosition >= dah().getPbData().cYT().size()) {
                return dah().getPbData().cYT().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View deE() {
        return this.eTU;
    }

    public int dix() {
        return this.lgl;
    }

    public int diy() {
        return this.lgm;
    }

    public void Fo(int i) {
        if (this.lgh != null) {
            this.lgh.setVisibility(i);
        }
    }

    public void ut(boolean z) {
        if (this.iga != null) {
            this.iga.setCanFling(z);
        }
    }

    public void da(int i, int i2) {
        if (this.iga != null && this.iga.getLayoutManager() != null && (this.iga.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.iga.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diz() {
        if (this.iga != null && this.dEH != null && this.lgf != null) {
            int headerViewsCount = this.iga.getHeaderViewsCount() + this.lgf.dim();
            int headerViewsCount2 = this.iga.getHeaderViewsCount() + this.lgf.din();
            int findFirstVisibleItemPosition = this.dEH.findFirstVisibleItemPosition();
            if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
                this.lgj.Ey(0);
            } else {
                this.lgj.Ey(8);
            }
            if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
                this.lgk.Ey(0);
                this.lgj.Ey(8);
            } else {
                this.lgk.Ey(8);
            }
            if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
                Fo(0);
            } else {
                Fo(8);
            }
        }
    }

    public boolean dfg() {
        if (this.ihW == null || TextUtils.isEmpty(this.ihW.getEndText())) {
            return false;
        }
        return this.ihW.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
