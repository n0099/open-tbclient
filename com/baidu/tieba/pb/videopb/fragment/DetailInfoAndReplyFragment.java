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
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0850a {
    private LinearLayoutManager eso;
    private BdSwipeRefreshLayout gEz;
    private BdTypeRecyclerView joh;
    private PbActivity lTk;
    private boolean lUa;
    private View mRootView;
    private VideoPbFragment moj;
    private b mol;
    private com.baidu.tieba.pb.videopb.b.b mom;
    private View moo;
    private LinearLayout mop;
    private PbReplyTitleViewHolder moq;
    private PbChildTitleViewHolder mor;
    private int topMargin;
    private PbListView jqc = null;
    private View fKb = null;
    private com.baidu.tieba.pb.view.a mbv = null;
    private boolean mcc = false;
    private boolean mcz = false;
    private boolean mdd = true;
    private int mba = 0;
    private g mPullView = null;
    private boolean lQm = false;
    private int mos = 0;
    private int mot = 0;
    private boolean lTO = false;
    private RecyclerView.OnScrollListener irI = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                DetailInfoAndReplyFragment.this.dop().dqB();
                DetailInfoAndReplyFragment.this.dop().duz();
            }
            if (DetailInfoAndReplyFragment.this.dop() != null) {
                DetailInfoAndReplyFragment.this.dop().onScrollStateChanged(i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            DetailInfoAndReplyFragment.this.dvn();
            if (recyclerView.canScrollVertically(-1)) {
                DetailInfoAndReplyFragment.this.mos = 2;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoAndReplyFragment.this.mos != 0) {
                DetailInfoAndReplyFragment.this.moo.setVisibility(8);
            }
            DetailInfoAndReplyFragment.this.mos = 0;
        }
    };
    private final f.c fkY = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (DetailInfoAndReplyFragment.this.dmG() != null && DetailInfoAndReplyFragment.this.dmG().vn(true)) {
                TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                DetailInfoAndReplyFragment.this.drd();
            }
        }
    };
    private CustomMessageListener jrj = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && DetailInfoAndReplyFragment.this.dmG() != null && DetailInfoAndReplyFragment.this.dmG().getPbData() != null && DetailInfoAndReplyFragment.this.dmG().getPbData().dlr() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = DetailInfoAndReplyFragment.this.dmG().getPbData().dlr().iterator();
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
                    if (oVar != null && DetailInfoAndReplyFragment.this.mol != null && DetailInfoAndReplyFragment.this.joh != null) {
                        DetailInfoAndReplyFragment.this.dmG().getPbData().dlr().remove(oVar);
                        if (DetailInfoAndReplyFragment.this.mol.getDataList() != null) {
                            DetailInfoAndReplyFragment.this.mol.getDataList().remove(oVar);
                        }
                        if (DetailInfoAndReplyFragment.this.joh.getListView2().getData() != null) {
                            DetailInfoAndReplyFragment.this.joh.getListView2().getData().remove(oVar);
                        }
                        DetailInfoAndReplyFragment.this.mol.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e lVb = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (DetailInfoAndReplyFragment.this.mIsLogin) {
                if (!DetailInfoAndReplyFragment.this.lTO && DetailInfoAndReplyFragment.this.drQ() && DetailInfoAndReplyFragment.this.dmG() != null) {
                    ar arVar = new ar("c13999");
                    arVar.dR("tid", DetailInfoAndReplyFragment.this.dmG().doJ());
                    arVar.dR("fid", DetailInfoAndReplyFragment.this.dmG().getForumId());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(arVar);
                    DetailInfoAndReplyFragment.this.lTO = true;
                }
                if (DetailInfoAndReplyFragment.this.dmG().vm(false)) {
                    DetailInfoAndReplyFragment.this.drb();
                    if (DetailInfoAndReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (DetailInfoAndReplyFragment.this.dmG().getPbData() != null) {
                    DetailInfoAndReplyFragment.this.dry();
                }
            }
        }
    };

    public static DetailInfoAndReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
        detailInfoAndReplyFragment.setArguments(bundle);
        detailInfoAndReplyFragment.moj = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lTk = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mom = new com.baidu.tieba.pb.videopb.b.b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mol != null) {
            this.mol.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.jrj);
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.joh = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.eso = new LinearLayoutManager(getContext()) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.4
            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        };
        this.joh.setLayoutManager(this.eso);
        this.mol = new b(this, this.joh);
        this.mol.I(dop().dul());
        this.mol.V(dop().dum());
        this.mol.setOnLongClickListener(dop().dun());
        this.mol.setOnImageClickListener(this.mom.getOnImageClickListener());
        this.mol.setTbGestureDetector(this.mom.dve());
        this.moo = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.jqc = new PbListView(getPageContext().getPageActivity());
        this.fKb = this.jqc.getView().findViewById(R.id.pb_more_view);
        if (this.fKb != null) {
            this.fKb.setOnClickListener(dop().dul());
            ap.setBackgroundResource(this.fKb, R.drawable.pb_foot_more_trans_selector);
        }
        this.jqc.setLineVisible();
        this.jqc.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.jqc.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.jqc.bug();
        this.joh.setOnSrollToBottomListener(this.lVb);
        this.joh.addOnScrollListener(this.irI);
        this.joh.setOnTouchListener(dop().bFK());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.fkY);
        }
        if (this.gEz == null) {
            this.gEz = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.gEz.setProgressView(this.mPullView);
            this.gEz.setEnabled(false);
            ap.setBackgroundColor(this.gEz, R.color.CAM_X0205);
        }
        this.mop = (LinearLayout) this.mRootView.findViewById(R.id.video_pb_suck_container);
        dvg();
        this.mol.setOnSwitchChangeListener(dop().lUS);
        registerListener(this.jrj);
    }

    private void dvg() {
        this.moq = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
        this.moq.abh = false;
        this.moq.X(dop().dul());
        this.moq.setOnSwitchChangeListener(dop().lUS);
        this.moq.FF(8);
        this.mop.addView(this.moq.getRootView());
        this.mor = new PbChildTitleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
        e eVar = new e();
        eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
        this.mor.a(eVar);
        this.mor.FF(8);
        this.mop.addView(this.mor.getRootView());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(doq()).get(VideoPbViewModel.class);
        videoPbViewModel.cMY().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.5
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
        a(true, 0, 3, 0, videoPbViewModel.duI(), "", 1, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jqc != null) {
            this.jqc.changeSkin(i);
            if (this.fKb != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fKb);
                ap.setBackgroundResource(this.fKb, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.moq != null) {
            this.moq.onChangeSkinType(i);
        }
        if (this.mor != null) {
            this.mor.onChangeSkinType();
        }
        if (this.mol != null) {
            this.mol.notifyDataSetChanged();
        }
        if (this.moo != null) {
            ap.setBackgroundResource(this.moo, R.drawable.personalize_tab_shadow);
        }
        ap.setBackgroundColor(this.gEz, R.color.CAM_X0201);
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
        this.lUa = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        vC(z);
        if (dop() != null && dop().mmF != null) {
            this.moj.mmF.dvc();
        }
        if (z && this.lUa) {
            drb();
            dmG().vm(true);
        }
    }

    private void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4, boolean z2) {
        final int i5;
        cb dlp;
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(doq()).get(VideoPbViewModel.class);
        if (z && dmG() != null && fVar != null) {
            this.lQm = dmG().doL();
            boolean isEnabled = this.gEz.isEnabled();
            if (fVar.getPage().bmI() == 0 && this.lQm) {
                this.gEz.setEnabled(false);
            } else if (!isEnabled) {
                this.gEz.setEnabled(true);
                this.gEz.interruptRefresh();
            }
            this.mol.setIsFromCDN(videoPbViewModel.isFromCDN());
            this.mol.wp(this.lQm);
            this.mol.a(fVar, z2);
            this.mcc = false;
            if (TbadkCoreApplication.isLogin()) {
                this.joh.setNextPage(this.jqc);
                this.mba = 2;
                if (dop() != null && dop().mmF != null) {
                    this.moj.mmF.ckD();
                }
            } else {
                this.mcc = true;
                if (fVar.getPage().bmH() == 1) {
                    if (this.mbv == null) {
                        this.mbv = new com.baidu.tieba.pb.view.a(this, this);
                        this.mbv.createView();
                        this.mbv.bug();
                    }
                    this.joh.setNextPage(this.mbv);
                } else {
                    this.joh.setNextPage(this.jqc);
                }
                this.mba = 3;
            }
            if (this.moq != null) {
                com.baidu.tieba.pb.data.o oVar = new com.baidu.tieba.pb.data.o(com.baidu.tieba.pb.data.o.lNH);
                oVar.lNJ = fVar.dlp() != null ? dlp.bnJ() : 0L;
                oVar.isNew = !dmG().doL();
                oVar.lNM = doj();
                oVar.sortType = fVar.lMp;
                oVar.lNL = fVar.dlT();
                oVar.isDynamic = fVar.dlS();
                oVar.lNN = fVar.lMo;
                this.moq.a(oVar);
            }
            ArrayList<PostData> dlr = fVar.dlr();
            if (fVar.getPage().bmH() == 0 || dlr == null || dlr.size() < fVar.getPage().bmG()) {
                if (fVar.getPage().bmH() == 0) {
                    this.jqc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.jqc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.jqc.buh();
                if (fVar.getPage().bmH() == 0 || dlr == null) {
                    dry();
                }
            } else {
                if (dmG().getIsFromMark()) {
                    if (this.mdd) {
                        endLoadData();
                        if (fVar.getPage().bmH() != 0) {
                            this.jqc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.jqc.setLineVisible();
                        this.jqc.showLoading();
                    }
                } else {
                    this.jqc.setLineVisible();
                    this.jqc.showLoading();
                }
                this.jqc.buh();
            }
            switch (i2) {
                case 2:
                    this.joh.setSelection(i3 > 1 ? (((this.joh.getData() == null && fVar.dlr() == null) ? 0 : this.joh.getData().size() - fVar.dlr().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable dqj = aj.dqi().dqj();
                        if (dqj instanceof RecyclerView.SavedState) {
                            this.joh.onRestoreInstanceState(dqj);
                            if (y.getCount(dlr) > 1 && fVar.getPage().bmH() > 0) {
                                this.jqc.endLoadData();
                                this.jqc.setText(getString(R.string.pb_load_more_without_point));
                                this.jqc.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.mdd = false;
                    break;
                case 5:
                    this.joh.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable dqj2 = aj.dqi().dqj();
                        if (dqj2 instanceof RecyclerView.SavedState) {
                            this.joh.onRestoreInstanceState(dqj2);
                            break;
                        }
                    }
                    this.joh.setSelection(0);
                    break;
                case 8:
                    this.joh.setSelection(i3 > 0 ? ((this.joh.getData() == null && fVar.dlr() == null) ? 0 : this.joh.getData().size() - fVar.dlr().size()) + i3 : 0);
                    this.jqc.endLoadData();
                    this.jqc.setText(getString(R.string.pb_load_more_without_point));
                    this.jqc.setLineGone();
                    break;
            }
            if (this.mcz) {
                dqv();
                this.mcz = false;
                if (i4 == 0) {
                    vy(true);
                }
            }
            dop().u(fVar);
            if (this.jqc != null) {
                if (fVar.getPage().bmH() == 0) {
                    this.jqc.setVisibility(8);
                } else {
                    this.jqc.setVisibility(0);
                }
            }
            if (y.getCount(this.mol.getDataList()) > 0 && videoPbViewModel.duL()) {
                videoPbViewModel.wq(false);
                String doI = dmG().doI();
                ArrayList<n> dataList = this.mol.getDataList();
                if (dataList != null) {
                    if (!au.isEmpty(doI)) {
                        i5 = 0;
                        while (i5 < dataList.size()) {
                            if (dataList.get(i5).getType() != PostData.nzd || !doI.equals(((PostData) dataList.get(i5)).getId())) {
                                i5++;
                            }
                        }
                        i5 = 0;
                    } else {
                        i5 = 0;
                        while (i5 < dataList.size()) {
                            if (dataList.get(i5).getType() != com.baidu.tieba.pb.data.o.lNH) {
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

    public void dvh() {
        com.baidu.tieba.pb.data.f pbData = dmG().getPbData();
        if (pbData != null) {
            this.mol.wp(dmG().doL());
            this.mol.setData(pbData);
            this.mol.notifyDataSetChanged();
            ArrayList<PostData> dlr = pbData.dlr();
            if (pbData.getPage().bmH() == 0 || dlr == null || dlr.size() < pbData.getPage().bmG()) {
                if (y.getCount(dlr) == 0 || (y.getCount(dlr) == 1 && dlr.get(0) != null && dlr.get(0).dNO() == 1)) {
                    if (doj()) {
                        this.jqc.av(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.jqc.av(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().bmH() == 0) {
                        this.jqc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jqc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jqc.buh();
                }
            }
            dop().u(pbData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity doq() {
        return this.lTk != null ? this.lTk : dop().doq();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment dop() {
        if (this.moj == null && this.lTk != null) {
            Fragment dmS = this.lTk.dmS();
            if (dmS instanceof VideoPbFragment) {
                this.moj = (VideoPbFragment) dmS;
            }
        }
        return this.moj;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel dmG() {
        return dop().dmG();
    }

    public BdTypeRecyclerView getListView() {
        return this.joh;
    }

    public boolean doj() {
        if (dmG() != null) {
            return dmG().getHostMode();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: dvi */
    public b dvf() {
        return this.mol;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            a(z, i, i2, i3, fVar, str, i4, false);
        }
    }

    public com.baidu.tieba.pb.videopb.b.b dvj() {
        return this.mom;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0850a
    public void vd(boolean z) {
        this.lUa = z;
    }

    public void vC(boolean z) {
        if (z && this.mcc) {
            this.jqc.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.joh.setNextPage(this.jqc);
            this.mba = 2;
        }
    }

    public void drb() {
        this.jqc.setLineVisible();
        this.jqc.startLoadData();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, true));
    }

    public void endLoadData() {
        if (this.jqc != null) {
            this.jqc.setLineGone();
            this.jqc.endLoadData();
        }
        if (dop() != null && dop().mmF != null) {
            this.moj.mmF.ckD();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, false));
    }

    public void PN(String str) {
        if (this.jqc != null) {
            this.jqc.setText(str);
        }
    }

    public void PO(String str) {
        if (this.jqc != null) {
            this.jqc.av(str, this.topMargin);
        }
    }

    public void drd() {
        if (this.gEz != null && this.gEz.isEnabled()) {
            this.gEz.setRefreshing(false);
        }
    }

    public void dry() {
        if (this.mba != 2) {
            this.joh.setNextPage(this.jqc);
            this.mba = 2;
        }
    }

    public void vy(boolean z) {
        this.mcz = z;
    }

    public void dqv() {
        if (this.joh == null) {
        }
    }

    public int dre() {
        if (this.joh != null) {
            return this.joh.getFirstVisiblePosition();
        }
        return 0;
    }

    public int dvk() {
        View childAt;
        if (this.joh == null || this.joh.getCount() <= 0 || (childAt = this.joh.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int drf() {
        if (this.joh != null) {
            int lastVisiblePosition = this.joh.getLastVisiblePosition();
            if (dmG() != null && dmG().getPbData() != null && lastVisiblePosition >= dmG().getPbData().dlr().size()) {
                return dmG().getPbData().dlr().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View drp() {
        return this.fKb;
    }

    public int dvl() {
        return this.mos;
    }

    public int dvm() {
        return this.mot;
    }

    public void Gy(int i) {
        if (this.moo != null) {
            this.moo.setVisibility(i);
        }
    }

    public void wv(boolean z) {
        if (this.joh != null) {
            this.joh.setCanFling(z);
        }
    }

    public void dd(int i, int i2) {
        if (this.joh != null && this.joh.getLayoutManager() != null && (this.joh.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.joh.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvn() {
        if (this.joh != null && this.eso != null && this.mol != null) {
            int headerViewsCount = this.joh.getHeaderViewsCount() + this.mol.duY();
            int headerViewsCount2 = this.joh.getHeaderViewsCount() + this.mol.duZ();
            int findFirstVisibleItemPosition = this.eso.findFirstVisibleItemPosition();
            if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
                this.moq.FF(0);
            } else {
                this.moq.FF(8);
            }
            if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
                this.mor.FF(0);
                this.moq.FF(8);
            } else {
                this.mor.FF(8);
            }
            if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
                Gy(0);
            } else {
                Gy(8);
            }
        }
    }

    public boolean drQ() {
        if (this.jqc == null || TextUtils.isEmpty(this.jqc.getEndText())) {
            return false;
        }
        return this.jqc.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
