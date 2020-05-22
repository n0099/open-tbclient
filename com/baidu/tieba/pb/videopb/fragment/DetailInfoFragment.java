package com.baidu.tieba.pb.videopb.fragment;

import android.arch.lifecycle.p;
import android.arch.lifecycle.y;
import android.content.Context;
import android.os.Bundle;
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
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pb.videopb.a;
import com.baidu.tieba.pb.videopb.e;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.List;
/* loaded from: classes9.dex */
public class DetailInfoFragment extends BaseFragment implements a {
    private PbListView fbY;
    private BdTypeRecyclerView hrM;
    private e jGQ;
    private PbActivity jJW;
    private VideoPbFragment kdJ;
    private com.baidu.tieba.pb.videopb.a.a kdL;
    private String kdN;
    private String kdO;
    private int kdM = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.kdJ != null) {
                DetailInfoFragment.this.kdJ.cHg();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.kdJ != null && !DetailInfoFragment.this.kdJ.cKS()) {
                DetailInfoFragment.this.jGQ.sD(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> cLj;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.kdJ != null && !DetailInfoFragment.this.kdJ.cKS() && ((cLj = DetailInfoFragment.this.jGQ.cLj()) == null || cLj.getValue() == null || cLj.getValue().booleanValue())) {
                DetailInfoFragment.this.jGQ.sD(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.kdM != 0 && DetailInfoFragment.this.kdJ != null) {
                    DetailInfoFragment.this.kdJ.AP(8);
                }
                DetailInfoFragment.this.kdM = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.kdJ != null && DetailInfoFragment.this.kdM == 0) {
                DetailInfoFragment.this.kdJ.AP(0);
            }
            DetailInfoFragment.this.kdM = 2;
        }
    };
    private CustomMessageListener hEY = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.cDy() != null && DetailInfoFragment.this.cDy().getPbData() != null) {
                DetailInfoFragment.this.Jj((String) customResponsedMessage.getData());
                DetailInfoFragment.this.cDy().cFO();
                DetailInfoFragment.this.kdL.setData(DetailInfoFragment.this.cDy().getPbData());
            }
        }
    };

    public static DetailInfoFragment aa(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.kdJ = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.jJW = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.hEY);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.jGQ = (e) y.b(getFragmentActivity()).l(e.class);
        bP(inflate);
        return inflate;
    }

    private void bP(View view) {
        this.hrM = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.hrM.setLayoutManager(new LinearLayoutManager(getContext()));
        this.hrM.addOnScrollListener(this.mOnScrollListener);
        this.hrM.setOnTouchListener(cFb().bgM());
        this.fbY = new PbListView(getContext());
        this.fbY.getView();
        this.fbY.setText("");
        this.fbY.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.fbY.setLineGone();
        this.fbY.setTextColor(am.getColor(R.color.cp_cont_j));
        this.fbY.setTextSize(R.dimen.tbfontsize33);
        this.fbY.setNoMoreTextColorId(R.color.cp_cont_e);
        this.fbY.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.fbY.aWe();
        this.hrM.setNextPage(this.fbY);
        this.kdL = new com.baidu.tieba.pb.videopb.a.a(this, this.hrM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.jGQ != null) {
            cLv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hEY);
        super.onDestroy();
    }

    private void cLv() {
        com.baidu.tieba.pb.data.e cLc = this.jGQ.cLc();
        if (cLc == null) {
            cLc = this.jGQ.cLb();
        }
        M(cLc);
    }

    private void M(com.baidu.tieba.pb.data.e eVar) {
        if (this.jGQ != null && eVar != null) {
            N(eVar);
            O(eVar);
            this.kdL.setData(eVar);
        }
    }

    private void N(com.baidu.tieba.pb.data.e eVar) {
        String str;
        String str2 = null;
        if (eVar != null) {
            if (eVar.cCi() != null) {
                str = eVar.getThreadId();
                if (eVar.cCi().getBaijiahaoData() != null) {
                    str2 = eVar.cCi().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.kdN || str2 != this.kdO) {
                cLw();
            }
            this.kdN = str;
            this.kdO = str2;
        }
    }

    private void O(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            if (v.isEmpty(eVar.cCI())) {
                cLx();
                return;
            }
            cLz();
            this.fbY.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void cLw() {
        if (this.hrM != null) {
            this.hrM.scrollToPosition(0);
        }
        cLz();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (eVar != null && getActivity() != null) {
            M(eVar);
        }
    }

    public PbActivity cFc() {
        return this.jJW != null ? this.jJW : this.kdJ.cFc();
    }

    public VideoPbFragment cFb() {
        if (this.kdJ == null && this.jJW != null) {
            Fragment cDK = this.jJW.cDK();
            if (cDK instanceof VideoPbFragment) {
                this.kdJ = (VideoPbFragment) cDK;
            }
        }
        return this.kdJ;
    }

    public PbModel cDy() {
        return cFb().cDy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kdL != null) {
            this.kdL.notifyDataSetChanged();
        }
        if (this.fbY != null) {
            this.fbY.changeSkin(i);
        }
    }

    private void cLx() {
        if (this.fbY != null) {
            this.fbY.s(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void cLy() {
        if (this.kdL != null) {
            this.kdL.cLr();
        }
    }

    private void cLz() {
        if (this.fbY != null) {
            this.fbY.aWf();
        }
    }

    public int cLA() {
        return this.kdM;
    }

    public void sG(boolean z) {
        if (this.hrM != null) {
            this.hrM.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jj(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<n> cCN = cDy().getPbData().cCN();
            for (n nVar : cCN) {
                if (TextUtils.equals(str, nVar.getAdId())) {
                    cCN.remove(nVar);
                    return;
                }
            }
        }
    }
}
