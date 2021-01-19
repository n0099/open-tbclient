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
import com.baidu.tieba.pb.videopb.b.b;
import com.baidu.tieba.pb.videopb.c;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.o;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class ReplyFragment extends BaseVideoPBReplyFragment implements com.baidu.tieba.pb.videopb.a, a.InterfaceC0840a {
    private int agC;
    private BdSwipeRefreshLayout gzS;
    private BdTypeRecyclerView jgC;
    private PbActivity lHZ;
    private boolean lIM;
    private View mRootView;
    private VideoPbFragment mcQ;
    private b mcT;
    private View mcU;
    private c mdf;
    private MultiNestedLayout mdg;
    private com.baidu.tieba.pb.videopb.videoView.b mdh;
    private View mdi;
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
    private RecyclerView.OnScrollListener ikd = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.dlK().dnX();
                ReplyFragment.this.dlK().drX();
            }
            if (ReplyFragment.this.dlK() != null) {
                ReplyFragment.this.dlK().onScrollStateChanged(i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.mcY = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.mcY != 0) {
                ReplyFragment.this.mcU.setVisibility(8);
            }
            ReplyFragment.this.mcY = 0;
        }
    };
    private MultiNestedLayout.b mdj = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void hF(int i) {
            if (ReplyFragment.this.mcZ != 1 || i == 1 || ReplyFragment.this.mcY == 0) {
                if (ReplyFragment.this.mcZ != 0 || i == 0) {
                    if (ReplyFragment.this.mcZ != 0 && i == 0) {
                        ReplyFragment.this.dlK().Gc(8);
                    }
                } else if (ReplyFragment.this.mcU.getVisibility() != 0) {
                    ReplyFragment.this.dlK().Gc(0);
                }
            } else {
                ReplyFragment.this.dlK().Gc(8);
                ReplyFragment.this.mcU.setVisibility(0);
            }
            ReplyFragment.this.mcZ = i;
        }
    };
    private final f.c fhg = new f.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.dkd() != null && ReplyFragment.this.dkd().uY(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.doz();
            }
        }
    };
    private CustomMessageListener jjF = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            o oVar;
            if (customResponsedMessage != null && ReplyFragment.this.dkd() != null && ReplyFragment.this.dkd().getPbData() != null && ReplyFragment.this.dkd().getPbData().diP() != null) {
                String str = (String) customResponsedMessage.getData();
                if (!TextUtils.isEmpty(str)) {
                    Iterator<PostData> it = ReplyFragment.this.dkd().getPbData().diP().iterator();
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
                    if (oVar != null && ReplyFragment.this.mdf != null && ReplyFragment.this.jgC != null) {
                        ReplyFragment.this.dkd().getPbData().diP().remove(oVar);
                        if (ReplyFragment.this.mdf.getDataList() != null) {
                            ReplyFragment.this.mdf.getDataList().remove(oVar);
                        }
                        if (ReplyFragment.this.jgC.getListView2().getData() != null) {
                            ReplyFragment.this.jgC.getListView2().getData().remove(oVar);
                        }
                        ReplyFragment.this.mdf.notifyDataSetChanged();
                    }
                }
            }
        }
    };
    private final BdListView.e lJN = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (!ReplyFragment.this.lIA && ReplyFragment.this.dpm() && ReplyFragment.this.dkd() != null) {
                    aq aqVar = new aq("c13999");
                    aqVar.dW("tid", ReplyFragment.this.dkd().dme());
                    aqVar.dW("fid", ReplyFragment.this.dkd().getForumId());
                    aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
                    TiebaStatic.log(aqVar);
                    ReplyFragment.this.lIA = true;
                }
                if (ReplyFragment.this.dkd().uX(false)) {
                    ReplyFragment.this.dox();
                    if (ReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (ReplyFragment.this.dkd().getPbData() != null) {
                    ReplyFragment.this.doU();
                }
            }
        }
    };

    public static ReplyFragment ae(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.mcQ = videoPbFragment;
        return replyFragment;
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
        this.mcT = new b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.jjF);
    }

    private void initUI() {
        this.agC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.mdg = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.mdg.setScrollStateChangeListener(this.mdj);
        this.jgC = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.jgC.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mdf = new c(this, this.jgC);
        this.mdf.H(dlK().drI());
        this.mdf.U(dlK().drJ());
        this.mdf.setOnLongClickListener(dlK().drK());
        this.mdf.setOnImageClickListener(this.mcT.getOnImageClickListener());
        this.mdf.setTbGestureDetector(this.mcT.dsB());
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
        this.mdi = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.mdh = new com.baidu.tieba.pb.videopb.videoView.b(this.mdi);
        this.mdh.Z(dlK().drI());
        this.mdh.setOnSwitchChangeListener(dlK().lJE);
        registerListener(this.jjF);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(dlL()).get(VideoPbViewModel.class);
        videoPbViewModel.dsp().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
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
        d(true, 0, 3, 0, videoPbViewModel.dsg(), "", 1);
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
        if (this.mdh != null) {
            this.mdh.onChangeSkinType(i);
        }
        if (this.mdf != null) {
            this.mdf.notifyDataSetChanged();
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

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
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
            this.mdf.setIsFromCDN(videoPbViewModel.isFromCDN());
            this.mdf.vY(this.lFf);
            this.mdf.setData(fVar);
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
            if (this.mdh != null && this.mdi != null) {
                n nVar = new n(n.lCC);
                bz diN = fVar.diN();
                nVar.lCE = diN != null ? diN.bno() : 0L;
                nVar.isNew = !dkd().dmg();
                nVar.lCH = dlE();
                nVar.sortType = fVar.lBm;
                nVar.lCG = fVar.djr();
                nVar.isDynamic = fVar.djq();
                nVar.lCI = fVar.lBl;
                this.mdh.a(nVar);
            }
            ArrayList<PostData> diP = fVar.diP();
            if (fVar.getPage().bmm() == 0 || diP == null || diP.size() < fVar.getPage().bml()) {
                if (x.getCount(diP) == 0 || (x.getCount(diP) == 1 && diP.get(0) != null && diP.get(0).dLm() == 1)) {
                    if (dlE()) {
                        this.jiy.as(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.agC);
                    } else {
                        this.jiy.as(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.agC);
                    }
                } else {
                    if (fVar.getPage().bmm() == 0) {
                        this.jiy.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.jiy.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.jiy.btK();
                }
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
                    int size = (this.jgC.getData() == null && fVar.diP() == null) ? 0 : this.jgC.getData().size() - fVar.diP().size();
                    this.mdg.setMaxOffset();
                    this.jgC.setSelection(i3 > 0 ? size + i3 : 0);
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
        }
    }

    public void dsE() {
        com.baidu.tieba.pb.data.f pbData = dkd().getPbData();
        if (pbData != null) {
            this.mdf.vY(dkd().dmg());
            this.mdf.setData(pbData);
            this.mdf.notifyDataSetChanged();
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
    /* renamed from: dsQ */
    public c dsC() {
        return this.mdf;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, fVar, str, i4);
        }
    }

    public b dsG() {
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
    }

    public void endLoadData() {
        if (this.jiy != null) {
            this.jiy.setLineGone();
            this.jiy.endLoadData();
        }
        if (dlK() != null && dlK().mbl != null) {
            this.mcQ.mbl.cjr();
        }
    }

    public void OP(String str) {
        if (this.jiy != null) {
            this.jiy.setText(str);
        }
    }

    public void OQ(String str) {
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

    public boolean dpm() {
        if (this.jiy == null || TextUtils.isEmpty(this.jiy.getEndText())) {
            return false;
        }
        return this.jiy.getEndText().equals(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
    }
}
