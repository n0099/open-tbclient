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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ah;
import com.baidu.tieba.pb.videopb.MultiNestedLayout;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.a;
import com.baidu.tieba.pb.videopb.b.b;
import com.baidu.tieba.pb.videopb.c;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class ReplyFragment extends BaseFragment implements a, a.InterfaceC0623a {
    private BdSwipeRefreshLayout eRw;
    private BdTypeRecyclerView hcS;
    private VideoPbFragment jLS;
    private c jLZ;
    private b jMa;
    private MultiNestedLayout jMb;
    private View jMc;
    private com.baidu.tieba.pb.videopb.videoView.b jMd;
    private View jMe;
    private PbActivity jsV;
    private boolean jtE;
    private View mRootView;
    private int topMargin;
    private PbListView heO = null;
    private View ecU = null;
    private com.baidu.tieba.pb.view.a jAa = null;
    private boolean jAD = false;
    private boolean jBa = false;
    private boolean jBz = true;
    private int jzF = 0;
    private h mPullView = null;
    private boolean jqE = false;
    private int jLV = 0;
    private int jMf = 0;
    private RecyclerView.OnScrollListener gii = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1) {
                ReplyFragment.this.cyj().cAm();
                ReplyFragment.this.cyj().cDY();
            }
            if (ReplyFragment.this.cyj() != null) {
                ReplyFragment.this.cyj().onScrollStateChanged(i);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (recyclerView.canScrollVertically(-1)) {
                ReplyFragment.this.jLV = 2;
                return;
            }
            if (Math.abs(i2) > 0 && ReplyFragment.this.jLV != 0) {
                ReplyFragment.this.jMc.setVisibility(8);
            }
            ReplyFragment.this.jLV = 0;
        }
    };
    private MultiNestedLayout.b jMg = new MultiNestedLayout.b() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.2
        @Override // com.baidu.tieba.pb.videopb.MultiNestedLayout.b
        public void onStateChange(int i) {
            if (ReplyFragment.this.jMf != 1 || i == 1 || ReplyFragment.this.jLV == 0) {
                if (ReplyFragment.this.jMf != 0 || i == 0) {
                    if (ReplyFragment.this.jMf != 0 && i == 0) {
                        ReplyFragment.this.cyj().Ae(8);
                    }
                } else if (ReplyFragment.this.jMc.getVisibility() != 0) {
                    ReplyFragment.this.cyj().Ae(0);
                }
            } else {
                ReplyFragment.this.cyj().Ae(8);
                ReplyFragment.this.jMc.setVisibility(0);
            }
            ReplyFragment.this.jMf = i;
        }
    };
    private final g.c dHd = new g.c() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.3
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (ReplyFragment.this.cwD() != null && ReplyFragment.this.cwD().rg(true)) {
                TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
            } else {
                ReplyFragment.this.cAK();
            }
        }
    };
    private final BdListView.e juB = new BdListView.e() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ReplyFragment.this.mIsLogin) {
                if (ReplyFragment.this.cwD().rf(false)) {
                    ReplyFragment.this.cAI();
                    if (ReplyFragment.this.getPageContext() != null) {
                        TiebaStatic.eventStat(ReplyFragment.this.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                    }
                } else if (ReplyFragment.this.cwD().getPbData() != null) {
                    ReplyFragment.this.cBf();
                }
            }
        }
    };

    public static ReplyFragment ac(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        ReplyFragment replyFragment = new ReplyFragment();
        replyFragment.setArguments(bundle);
        replyFragment.jLS = videoPbFragment;
        return replyFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.jsV = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.needLogStayDuration = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.jMa = new b(this);
        this.mRootView = layoutInflater.inflate(R.layout.pb_reply_fragment, (ViewGroup) null);
        initUI();
        return this.mRootView;
    }

    private void initUI() {
        this.topMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jMb = (MultiNestedLayout) this.mRootView.findViewById(R.id.multi_nested_layout);
        this.jMb.setScrollStateChangeListener(this.jMg);
        this.hcS = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.video_pb_reply_list);
        this.hcS.setLayoutManager(new LinearLayoutManager(getContext()));
        this.jLZ = new c(this, this.hcS);
        this.jLZ.E(cyj().cDK());
        this.jLZ.Q(cyj().cDL());
        this.jLZ.setOnLongClickListener(cyj().cDM());
        this.jLZ.setOnImageClickListener(this.jMa.getOnImageClickListener());
        this.jLZ.setTbGestureDetector(this.jMa.cEz());
        this.jMc = this.mRootView.findViewById(R.id.reply_pager_title_shadow);
        this.heO = new PbListView(getPageContext().getPageActivity());
        this.ecU = this.heO.getView().findViewById(R.id.pb_more_view);
        if (this.ecU != null) {
            this.ecU.setOnClickListener(cyj().cDK());
            am.setBackgroundResource(this.ecU, R.drawable.pb_foot_more_trans_selector);
        }
        this.heO.setLineVisible();
        this.heO.setBackground(R.drawable.pb_foot_more_trans_selector);
        this.heO.setContainerBackgroundColorResId(R.drawable.pb_foot_more_trans_selector);
        this.heO.aQd();
        this.hcS.setOnSrollToBottomListener(this.juB);
        this.hcS.addOnScrollListener(this.gii);
        this.hcS.setOnTouchListener(cyj().baD());
        if (this.mPullView == null) {
            this.mPullView = new h(getPageContext());
            this.mPullView.createView();
            this.mPullView.setListPullRefreshListener(this.dHd);
        }
        if (this.eRw == null) {
            this.eRw = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.pb_video_pull_refresh_layout);
            this.eRw.setProgressView(this.mPullView);
            this.eRw.setEnabled(false);
            am.setBackgroundColor(this.eRw, R.color.cp_bg_line_e);
        }
        this.jMe = this.mRootView.findViewById(R.id.video_pb_reply_all_title);
        this.jMd = new com.baidu.tieba.pb.videopb.videoView.b(this.jMe);
        this.jMd.U(cyj().cDK());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        e eVar = (e) y.b(cyk()).l(e.class);
        eVar.cEq().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.fragment.ReplyFragment.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                if (bool != null && bool.booleanValue()) {
                    ReplyFragment.this.showLoadingView();
                } else {
                    ReplyFragment.this.hideLoadingView();
                }
            }
        });
        d(true, 0, 3, 0, eVar.cEh(), "", 1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.heO != null) {
            this.heO.changeSkin(i);
            if (this.ecU != null) {
                getBaseFragmentActivity().getLayoutMode().onModeChanged(this.ecU);
                am.setBackgroundResource(this.ecU, R.drawable.pb_foot_more_trans_selector);
            }
        }
        if (this.jMd != null) {
            this.jMd.onChangeSkinType(i);
        }
        if (this.jLZ != null) {
            this.jLZ.notifyDataSetChanged();
        }
        if (this.jMc != null) {
            am.setBackgroundResource(this.jMc, R.drawable.personalize_tab_shadow);
        }
        am.setBackgroundColor(this.eRw, R.color.cp_bg_line_d);
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
        this.jtE = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        rt(z);
        if (cyj() != null && cyj().jKA != null) {
            this.jLS.jKA.cEx();
        }
        if (z && this.jtE) {
            cAI();
            cwD().rf(true);
        }
    }

    private void d(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        e eVar2 = (e) y.b(cyk()).l(e.class);
        if (z && cwD() != null && eVar != null) {
            this.jqE = cwD().cyB();
            boolean isEnabled = this.eRw.isEnabled();
            if (eVar.getPage().aJB() == 0 && this.jqE) {
                this.eRw.setEnabled(false);
            } else if (!isEnabled) {
                this.eRw.setEnabled(true);
                this.eRw.interruptRefresh();
            }
            this.jLZ.setIsFromCDN(eVar2.isFromCDN());
            this.jLZ.sd(this.jqE);
            this.jLZ.setData(eVar);
            this.jAD = false;
            if (TbadkCoreApplication.isLogin()) {
                this.hcS.setNextPage(this.heO);
                this.jzF = 2;
                if (cyj() != null && cyj().jKA != null) {
                    this.jLS.jKA.bzU();
                }
            } else {
                this.jAD = true;
                if (eVar.getPage().aJA() == 1) {
                    if (this.jAa == null) {
                        this.jAa = new com.baidu.tieba.pb.view.a(this, this);
                        this.jAa.createView();
                        this.jAa.aQd();
                    }
                    this.hcS.setNextPage(this.jAa);
                } else {
                    this.hcS.setNextPage(this.heO);
                }
                this.jzF = 3;
            }
            if (this.jMd != null && this.jMe != null) {
                j jVar = new j(j.jow);
                bj cvu = eVar.cvu();
                jVar.joy = cvu != null ? cvu.aKv() : 0L;
                jVar.isNew = !cwD().cyB();
                jVar.joB = cye();
                jVar.sortType = eVar.jnw;
                jVar.joA = eVar.cvT();
                jVar.isDynamic = eVar.cvS();
                this.jMd.a(jVar);
            }
            ArrayList<PostData> cvw = eVar.cvw();
            if (eVar.getPage().aJA() == 0 || cvw == null || cvw.size() < eVar.getPage().aJz()) {
                if (v.getCount(cvw) == 0 || (v.getCount(cvw) == 1 && cvw.get(0) != null && cvw.get(0).cWr() == 1)) {
                    if (cye()) {
                        this.heO.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.heO.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (eVar.getPage().aJA() == 0) {
                        this.heO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.heO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.heO.aQe();
                }
                if (eVar.getPage().aJA() == 0 || cvw == null) {
                    cBf();
                }
            } else {
                if (cwD().getIsFromMark()) {
                    if (this.jBz) {
                        endLoadData();
                        if (eVar.getPage().aJA() != 0) {
                            this.heO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_load_more));
                        }
                    } else {
                        this.heO.setLineVisible();
                        this.heO.showLoading();
                    }
                } else {
                    this.heO.setLineVisible();
                    this.heO.showLoading();
                }
                this.heO.aQe();
            }
            switch (i2) {
                case 2:
                    this.hcS.setSelection(i3 > 1 ? (((this.hcS.getData() == null && eVar.cvw() == null) ? 0 : this.hcS.getData().size() - eVar.cvw().size()) + i3) - 2 : 0);
                    break;
                case 3:
                    if (i4 == 1) {
                        Parcelable czT = ah.czS().czT();
                        if (czT instanceof RecyclerView.SavedState) {
                            this.hcS.onRestoreInstanceState(czT);
                            if (v.getCount(cvw) > 1 && eVar.getPage().aJA() > 0) {
                                this.heO.endLoadData();
                                this.heO.setText(getString(R.string.pb_load_more_without_point));
                                this.heO.setLineGone();
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    this.jBz = false;
                    break;
                case 5:
                    this.hcS.setSelection(0);
                    break;
                case 6:
                    if (i4 == 1) {
                        Parcelable czT2 = ah.czS().czT();
                        if (czT2 instanceof RecyclerView.SavedState) {
                            this.hcS.onRestoreInstanceState(czT2);
                            break;
                        }
                    }
                    this.hcS.setSelection(0);
                    break;
                case 8:
                    int size = (this.hcS.getData() == null && eVar.cvw() == null) ? 0 : this.hcS.getData().size() - eVar.cvw().size();
                    this.jMb.setMaxOffset();
                    this.hcS.setSelection(i3 > 0 ? size + i3 : 0);
                    this.heO.endLoadData();
                    this.heO.setText(getString(R.string.pb_load_more_without_point));
                    this.heO.setLineGone();
                    break;
            }
            if (this.jBa) {
                cAg();
                this.jBa = false;
                if (i4 == 0) {
                    rp(true);
                }
            }
            cyj().q(eVar);
        }
    }

    public void cEG() {
        com.baidu.tieba.pb.data.e pbData = cwD().getPbData();
        if (pbData != null) {
            this.jLZ.sd(cwD().cyB());
            this.jLZ.setData(pbData);
            this.jLZ.notifyDataSetChanged();
            ArrayList<PostData> cvw = pbData.cvw();
            if (pbData.getPage().aJA() == 0 || cvw == null || cvw.size() < pbData.getPage().aJz()) {
                if (v.getCount(cvw) == 0 || (v.getCount(cvw) == 1 && cvw.get(0) != null && cvw.get(0).cWr() == 1)) {
                    if (cye()) {
                        this.heO.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_host_reply), this.topMargin);
                    } else {
                        this.heO.ak(TbadkCoreApplication.getInst().getResources().getString(R.string.pb_no_replay), this.topMargin);
                    }
                } else {
                    if (pbData.getPage().aJA() == 0) {
                        this.heO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more));
                    } else {
                        this.heO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.load_more));
                    }
                    this.heO.aQe();
                }
            }
            cyj().q(pbData);
        }
    }

    public PbActivity cyk() {
        return this.jsV != null ? this.jsV : cyj().cyk();
    }

    public VideoPbFragment cyj() {
        if (this.jLS == null && this.jsV != null) {
            Fragment cwP = this.jsV.cwP();
            if (cwP instanceof VideoPbFragment) {
                this.jLS = (VideoPbFragment) cwP;
            }
        }
        return this.jLS;
    }

    public PbModel cwD() {
        return cyj().cwD();
    }

    public BdTypeRecyclerView getListView() {
        return this.hcS;
    }

    public boolean cye() {
        if (cwD() != null) {
            return cwD().getHostMode();
        }
        return false;
    }

    public c cEH() {
        return this.jLZ;
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (getActivity() != null) {
            d(z, i, i2, i3, eVar, str, i4);
        }
    }

    public b cEI() {
        return this.jMa;
    }

    @Override // com.baidu.tieba.pb.view.a.InterfaceC0623a
    public void qY(boolean z) {
        this.jtE = z;
    }

    public void rt(boolean z) {
        if (z && this.jAD) {
            this.heO.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.click_load_more));
            this.hcS.setNextPage(this.heO);
            this.jzF = 2;
        }
    }

    public void cAI() {
        this.heO.setLineVisible();
        this.heO.startLoadData();
    }

    public void endLoadData() {
        if (this.heO != null) {
            this.heO.setLineGone();
            this.heO.endLoadData();
        }
        if (cyj() != null && cyj().jKA != null) {
            this.jLS.jKA.bzU();
        }
    }

    public void HK(String str) {
        if (this.heO != null) {
            this.heO.setText(str);
        }
    }

    public void HL(String str) {
        if (this.heO != null) {
            this.heO.ak(str, this.topMargin);
        }
    }

    public void cAK() {
        if (this.eRw != null && this.eRw.isEnabled()) {
            this.eRw.setRefreshing(false);
        }
    }

    public void cBf() {
        if (this.jzF != 2) {
            this.hcS.setNextPage(this.heO);
            this.jzF = 2;
        }
    }

    public void rp(boolean z) {
        this.jBa = z;
    }

    public void cAg() {
        if (this.hcS == null) {
        }
    }

    public int cAL() {
        if (this.hcS != null) {
            return this.hcS.getFirstVisiblePosition();
        }
        return 0;
    }

    public int cEJ() {
        View childAt;
        if (this.hcS == null || this.hcS.getCount() <= 0 || (childAt = this.hcS.getChildAt(0)) == null) {
            return 0;
        }
        return childAt.getTop();
    }

    public int cAM() {
        if (this.hcS != null) {
            int lastVisiblePosition = this.hcS.getLastVisiblePosition();
            if (cwD() != null && cwD().getPbData() != null && lastVisiblePosition >= cwD().getPbData().cvw().size()) {
                return cwD().getPbData().cvw().size() - 2;
            }
            return lastVisiblePosition;
        }
        return 0;
    }

    public View cAW() {
        return this.ecU;
    }

    public int cEF() {
        return this.jLV;
    }

    public int cEK() {
        return this.jMf;
    }

    public void Ae(int i) {
        if (this.jMc != null) {
            this.jMc.setVisibility(i);
        }
    }

    public void si(boolean z) {
        if (this.hcS != null) {
            this.hcS.setCanFling(z);
        }
    }

    public void cB(int i, int i2) {
        if (this.hcS != null && this.hcS.getLayoutManager() != null && (this.hcS.getLayoutManager() instanceof LinearLayoutManager)) {
            ((LinearLayoutManager) this.hcS.getLayoutManager()).scrollToPositionWithOffset(i, i2);
        }
    }
}
