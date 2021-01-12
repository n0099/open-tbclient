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
public class DetailInfoAndReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0840a {
    private int agC;
    private LinearLayoutManager eoG;
    private BdSwipeRefreshLayout gzS;
    private BdTypeRecyclerView jgC;
    private PbActivity lHZ;
    private boolean lIM;
    private View mRootView;
    private VideoPbFragment mcQ;
    private b mcS;
    private com.baidu.tieba.pb.videopb.b.b mcT;
    private View mcU;
    private LinearLayout mcV;
    private PbReplyTitleViewHolder mcW;
    private PbChildTitleViewHolder mcX;
    private PbListView jiy = null;
    private View fGq = null;
    private com.baidu.tieba.pb.view.a lQf = null;
    private boolean lQM = false;
    private boolean lRj = false;
    private boolean lRN = true;
    private int lPK = 0;
    private g mPullView = null;
    private boolean lFf = false;
    private int mcY = 0;
    private int mcZ = 0;
    private boolean lIA = false;
    private RecyclerView.OnScrollListener ikd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                DetailInfoAndReplyFragment.this.dlK().dnX();
                DetailInfoAndReplyFragment.this.dlK().drX();
            }
            if (DetailInfoAndReplyFragment.this.dlK() != null) {
                DetailInfoAndReplyFragment.this.dlK().onScrollStateChanged(i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            DetailInfoAndReplyFragment.this.dsK();
            if (recyclerView.canScrollVertically(-1)) {
                DetailInfoAndReplyFragment.this.mcY = 2;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoAndReplyFragment.this.mcY != 0) {
                DetailInfoAndReplyFragment.this.mcU.setVisibility(8);
            }
            DetailInfoAndReplyFragment.this.mcY = 0;
        }
    };
    private final f.c fhg = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.2
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (DetailInfoAndReplyFragment.this.dkd() != null && DetailInfoAndReplyFragment.this.dkd().uY(true)) {
                TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                DetailInfoAndReplyFragment.this.doz();
            }
        }
    };
    private CustomMessageListener jjF = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && DetailInfoAndReplyFragment.this.dkd() != null && DetailInfoAndReplyFragment.this.dkd().getPbData() != null && DetailInfoAndReplyFragment.this.dkd().getPbData().diP() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = DetailInfoAndReplyFragment.this.dkd().getPbData().diP().iterator();
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
                    if (oVar != null && DetailInfoAndReplyFragment.this.mcS != null && DetailInfoAndReplyFragment.this.jgC != null) {
                        DetailInfoAndReplyFragment.this.dkd().getPbData().diP().remove(oVar);
                        if (DetailInfoAndReplyFragment.this.mcS.getDataList() != null) {
                            DetailInfoAndReplyFragment.this.mcS.getDataList().remove(oVar);
                        }
                        if (DetailInfoAndReplyFragment.this.jgC.getListView2().getData() != null) {
                            DetailInfoAndReplyFragment.this.jgC.getListView2().getData().remove(oVar);
                        }
                        DetailInfoAndReplyFragment.this.mcS.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e lJN = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (DetailInfoAndReplyFragment.this.mIsLogin) {
                if (!DetailInfoAndReplyFragment.this.lIA && DetailInfoAndReplyFragment.this.dpm() && DetailInfoAndReplyFragment.this.dkd() != null) {
                    aq aqVar = new aq("c13999");
                    aqVar.dW("tid", DetailInfoAndReplyFragment.this.dkd().dme());
                    aqVar.dW("fid", DetailInfoAndReplyFragment.this.dkd().getForumId());
                    aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar);
                    DetailInfoAndReplyFragment.this.lIA = true;
                }
                if (DetailInfoAndReplyFragment.this.dkd().uX(false)) {
                    DetailInfoAndReplyFragment.this.dox();
                    if (DetailInfoAndReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(DetailInfoAndReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (DetailInfoAndReplyFragment.this.dkd().getPbData() != null) {
                    DetailInfoAndReplyFragment.this.doU();
                }
            }
        }
    };

    public static DetailInfoAndReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoAndReplyFragment detailInfoAndReplyFragment = new DetailInfoAndReplyFragment();
        detailInfoAndReplyFragment.setArguments(bundle);
        detailInfoAndReplyFragment.mcQ = videoPbFragment;
        return detailInfoAndReplyFragment;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.lHZ = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mcT = new com.baidu.tieba.pb.videopb.b.b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_detail_info_and_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mcS != null) {
            this.mcS.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.jjF);
    }

    private void initUI() {
        this.agC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jgC = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.eoG = new LinearLayoutManager(getContext()) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.4
            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
                return false;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
                return false;
            }
        };
        this.jgC.setLayoutManager(this.eoG);
        this.mcS = new b(this, this.jgC);
        this.mcS.H(dlK().drI());
        this.mcS.U(dlK().drJ());
        this.mcS.setOnLongClickListener(dlK().drK());
        this.mcS.setOnImageClickListener(this.mcT.getOnImageClickListener());
        this.mcS.setTbGestureDetector(this.mcT.dsB());
        this.mcU = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.jiy = new PbListView(getPageContext().getPageActivity());
        this.fGq = this.jiy.getView().findViewById(R.id.pb_more_view);
        if (this.fGq != null) {
            this.fGq.setOnClickListener(dlK().drI());
            ao.setBackgroundResource(this.fGq, R.drawable.pb_foot_more_trans_selector);
        }
        this.jiy.setLineVisible();
        this.jiy.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.jiy.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.jiy.btJ();
        this.jgC.setOnSrollToBottomListener(this.lJN);
        this.jgC.addOnScrollListener(this.ikd);
        this.jgC.setOnTouchListener(dlK().bFn());
        if (this.mPullView == null) {
            this.mPullView = new g(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.fhg);
        }
        if (this.gzS == null) {
            this.gzS = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.gzS.setProgressView(this.mPullView);
            this.gzS.setEnabled(false);
            ao.setBackgroundColor(this.gzS, R.color.CAM_X0205);
        }
        this.mcV = (LinearLayout) this.mRootView.findViewById(R.id.video_pb_suck_container);
        dsD();
        this.mcS.setOnSwitchChangeListener(dlK().lJE);
        registerListener(this.jjF);
    }

    private void dsD() {
        this.mcW = new PbReplyTitleViewHolder(getPageContext(), LayoutInflater.from(getContext()).inflate(R.layout.pb_reply_title_layout, (ViewGroup) null));
        this.mcW.ZS = false;
        this.mcW.W(dlK().drI());
        this.mcW.setOnSwitchChangeListener(dlK().lJE);
        this.mcW.Fj(8);
        this.mcV.addView(this.mcW.getRootView());
        this.mcX = new PbChildTitleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.pb_child_title, (ViewGroup) null));
        e eVar = new e();
        eVar.setTitle(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
        this.mcX.a(eVar);
        this.mcX.Fj(8);
        this.mcV.addView(this.mcX.getRootView());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(dlL()).get(VideoPbViewModel.class);
        videoPbViewModel.dsp().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment.5
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
        a(true, 0, 3, 0, videoPbViewModel.dsg(), "", 1, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jiy != null) {
            this.jiy.changeSkin(i);
            if (this.fGq != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.fGq);
                ao.setBackgroundResource(this.fGq, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.mcW != null) {
            this.mcW.onChangeSkinType(i);
        }
        if (this.mcX != null) {
            this.mcX.onChangeSkinType();
        }
        if (this.mcS != null) {
            this.mcS.notifyDataSetChanged();
        }
        if (this.mcU != null) {
            ao.setBackgroundResource(this.mcU, R.drawable.personalize_tab_shadow);
        }
        ao.setBackgroundColor(this.gzS, R.color.CAM_X0201);
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
        this.lIM = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        vn(z);
        if (dlK() != null && dlK().mbl != null) {
            this.mcQ.mbl.dsz();
        }
        if (z && this.lIM) {
            dox();
            dkd().uX(true);
        }
    }

    private void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4, boolean z2) {
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(dlL()).get(VideoPbViewModel.class);
        if (z && dkd() != null && fVar != null) {
            this.lFf = dkd().dmg();
            boolean isEnabled = this.gzS.isEnabled();
            if (fVar.getPage().bmn() == 0 && this.lFf) {
                this.gzS.setEnabled(false);
            } else if (!isEnabled) {
                this.gzS.setEnabled(true);
                this.gzS.interruptRefresh();
            }
            this.mcS.setIsFromCDN(videoPbViewModel.isFromCDN());
            this.mcS.vY(this.lFf);
            this.mcS.a(fVar, z2);
            this.lQM = false;
            if (TbadkCoreApplication.isLogin()) {
                this.jgC.setNextPage(this.jiy);
                this.lPK = 2;
                if (dlK() != null && dlK().mbl != null) {
                    this.mcQ.mbl.cjr();
                }
            } else {
                this.lQM = true;
                if (fVar.getPage().bmm() == 1) {
                    if (this.lQf == null) {
                        this.lQf = new com.baidu.tieba.pb.view.a(this, this);
                        this.lQf.createView();
                        this.lQf.btJ();
                    }
                    this.jgC.setNextPage(this.lQf);
                } else {
                    this.jgC.setNextPage(this.jiy);
                }
                this.lPK = 3;
            }
            if (this.mcW != null) {
                n nVar = new n(n.lCC);
                bz diN = fVar.diN();
                nVar.lCE = diN != null ? diN.bno() : 0L;
                nVar.isNew = !dkd().dmg();
                nVar.lCH = dlE();
                nVar.sortType = fVar.lBm;
                nVar.lCG = fVar.djr();
                nVar.isDynamic = fVar.djq();
                nVar.lCI = fVar.lBl;
                this.mcW.a(nVar);
            }
            ArrayList<PostData> diP = fVar.diP();
            if (fVar.getPage().bmm() == 0 || diP == null || diP.size() < fVar.getPage().bml()) {
                if (fVar.getPage().bmm() == 0) {
                    this.jiy.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                } else {
                    this.jiy.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                }
                this.jiy.btK();
                if (fVar.getPage().bmm() == 0 || diP == null) {
                    doU();
                }
            } else {
                if (dkd().getIsFromMark()) {
                    if (this.lRN) {
                        endLoadData();
                        if (fVar.getPage().bmm() != 0) {
                            this.jiy.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.jiy.setLineVisible();
                        this.jiy.showLoading();
                    }
                } else {
                    this.jiy.setLineVisible();
                    this.jiy.showLoading();
                }
                this.jiy.btK();
            }
            switch (i2) {
                case 2:
                    this.jgC.setSelection(i3 > 1 ? (((this.jgC.getData() == null && fVar.diP() == null) ? 0 : this.jgC.getData().size() - fVar.diP().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable dnF = aj.dnE().dnF();
                        if (dnF instanceof RecyclerView.SavedState) {
                            this.jgC.onRestoreInstanceState(dnF);
                            if (x.getCount(diP) > 1 && fVar.getPage().bmm() > 0) {
                                this.jiy.endLoadData();
                                this.jiy.setText(getString(R.string.pb_load_more_without_point));
                                this.jiy.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.lRN = false;
                    break;
                case 5:
                    this.jgC.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable dnF2 = aj.dnE().dnF();
                        if (dnF2 instanceof RecyclerView.SavedState) {
                            this.jgC.onRestoreInstanceState(dnF2);
                            break;
                        }
                    }
                    this.jgC.setSelection(0);
                    break;
                case 8:
                    this.jgC.setSelection(i3 > 0 ? ((this.jgC.getData() == null && fVar.diP() == null) ? 0 : this.jgC.getData().size() - fVar.diP().size()) + i3 : 0);
                    this.jiy.endLoadData();
                    this.jiy.setText(getString(R.string.pb_load_more_without_point));
                    this.jiy.setLineGone();
                    break;
            }
            if (this.lRj) {
                dnR();
                this.lRj = false;
                if (i4 == 0) {
                    vj(true);
                }
            }
            dlK().u(fVar);
            if (this.jiy != null) {
                if (fVar.getPage().bmm() == 0) {
                    this.jiy.setVisibility(8);
                } else {
                    this.jiy.setVisibility(0);
                }
            }
        }
    }

    public void dsE() {
        com.baidu.tieba.pb.data.f pbData = dkd().getPbData();
        if (pbData != null) {
            this.mcS.vY(dkd().dmg());
            this.mcS.setData(pbData);
            this.mcS.notifyDataSetChanged();
            ArrayList<PostData> diP = pbData.diP();
            if (pbData.getPage().bmm() == 0 || diP == null || diP.size() < pbData.getPage().bml()) {
                if (x.getCount(diP) == 0 || (x.getCount(diP) == 1 && diP.get(0) != null && diP.get(0).dLm() == 1)) {
                    if (dlE()) {
                        this.jiy.as(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.agC);
                    } else {
                        this.jiy.as(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.agC);
                    }
                } else {
                    if (pbData.getPage().bmm() == 0) {
                        this.jiy.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jiy.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jiy.btK();
                }
            }
            dlK().u(pbData);
        }
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbActivity dlL() {
        return this.lHZ != null ? this.lHZ : dlK().dlL();
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public VideoPbFragment dlK() {
        if (this.mcQ == null && this.lHZ != null) {
            Fragment dkp = this.lHZ.dkp();
            if (dkp instanceof VideoPbFragment) {
                this.mcQ = (VideoPbFragment) dkp;
            }
        }
        return this.mcQ;
    }

    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    public PbModel dkd() {
        return dlK().dkd();
    }

    public BdTypeRecyclerView getListView() {
        return this.jgC;
    }

    public boolean dlE() {
        if (dkd() != null) {
            return dkd().getHostMode();
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pb.videopb.fragment.BaseVideoPBReplyFragment
    /* renamed from: dsF */
    public b dsC() {
        return this.mcS;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            a(z, i, i2, i3, fVar, str, i4, false);
        }
    }

    public com.baidu.tieba.pb.videopb.b.b dsG() {
        return this.mcT;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0840a
    public void uO(boolean z) {
        this.lIM = z;
    }

    public void vn(boolean z) {
        if (z && this.lQM) {
            this.jiy.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.jgC.setNextPage(this.jiy);
            this.lPK = 2;
        }
    }

    public void dox() {
        this.jiy.setLineVisible();
        this.jiy.startLoadData();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, true));
    }

    public void endLoadData() {
        if (this.jiy != null) {
            this.jiy.setLineGone();
            this.jiy.endLoadData();
        }
        if (dlK() != null && dlK().mbl != null) {
            this.mcQ.mbl.cjr();
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921471, false));
    }

    public void OO(String str) {
        if (this.jiy != null) {
            this.jiy.setText(str);
        }
    }

    public void OP(String str) {
        if (this.jiy != null) {
            this.jiy.as(str, this.agC);
        }
    }

    public void doz() {
        if (this.gzS != null && this.gzS.isEnabled()) {
            this.gzS.setRefreshing(false);
        }
    }

    public void doU() {
        if (this.lPK != 2) {
            this.jgC.setNextPage(this.jiy);
            this.lPK = 2;
        }
    }

    public void vj(boolean z) {
        this.lRj = z;
    }

    public void dnR() {
        if (this.jgC == null) {
        }
    }

    public int doA() {
        if (this.jgC != null) {
            return this.jgC.getFirstVisiblePosition();
        }
        return 0;
    }

    public int dsH() {
        View childAt;
        if (this.jgC == null || this.jgC.getCount() <= 0 || (childAt = this.jgC.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int doB() {
        if (this.jgC != null) {
            int lastVisiblePosition = this.jgC.getLastVisiblePosition();
            if (dkd() != null && dkd().getPbData() != null && lastVisiblePosition >= dkd().getPbData().diP().size()) {
                return dkd().getPbData().diP().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View doL() {
        return this.fGq;
    }

    public int dsI() {
        return this.mcY;
    }

    public int dsJ() {
        return this.mcZ;
    }

    public void Gc(int i) {
        if (this.mcU != null) {
            this.mcU.setVisibility(i);
        }
    }

    public void we(boolean z) {
        if (this.jgC != null) {
            this.jgC.setCanFling(z);
        }
    }

    public void df(int i, int i2) {
        if (this.jgC != null && this.jgC.getLayoutManager() != null && (this.jgC.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.jgC.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsK() {
        if (this.jgC != null && this.eoG != null && this.mcS != null) {
            int headerViewsCount = this.jgC.getHeaderViewsCount() + this.mcS.dsx();
            int headerViewsCount2 = this.jgC.getHeaderViewsCount() + this.mcS.dsy();
            int findFirstVisibleItemPosition = this.eoG.findFirstVisibleItemPosition();
            if (headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) {
                this.mcW.Fj(0);
            } else {
                this.mcW.Fj(8);
            }
            if (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2) {
                this.mcX.Fj(0);
                this.mcW.Fj(8);
            } else {
                this.mcX.Fj(8);
            }
            if ((headerViewsCount >= 0 && findFirstVisibleItemPosition >= headerViewsCount) || (headerViewsCount2 >= 0 && findFirstVisibleItemPosition >= headerViewsCount2)) {
                Gc(0);
            } else {
                Gc(8);
            }
        }
    }

    public boolean dpm() {
        if (this.jiy == null || TextUtils.isEmpty(this.jiy.getEndText())) {
            return false;
        }
        return this.jiy.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
