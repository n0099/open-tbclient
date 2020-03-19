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
import com.baidu.tieba.tbadkCore.data.m;
import java.util.List;
/* loaded from: classes9.dex */
public class DetailInfoFragment extends BaseFragment implements a {
    private PbListView elM;
    private BdTypeRecyclerView gtH;
    private e iFW;
    private PbActivity iIO;
    private VideoPbFragment jbK;
    private com.baidu.tieba.pb.videopb.a.a jbM;
    private String jbO;
    private String jbP;
    private int jbN = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.jbK != null) {
                DetailInfoFragment.this.jbK.cpG();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.jbK != null && !DetailInfoFragment.this.jbK.ctr()) {
                DetailInfoFragment.this.iFW.rb(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> ctI;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.jbK != null && !DetailInfoFragment.this.jbK.ctr() && ((ctI = DetailInfoFragment.this.iFW.ctI()) == null || ctI.getValue() == null || ctI.getValue().booleanValue())) {
                DetailInfoFragment.this.iFW.rb(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.jbN != 0 && DetailInfoFragment.this.jbK != null) {
                    DetailInfoFragment.this.jbK.zD(8);
                }
                DetailInfoFragment.this.jbN = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.jbK != null && DetailInfoFragment.this.jbN == 0) {
                DetailInfoFragment.this.jbK.zD(0);
            }
            DetailInfoFragment.this.jbN = 2;
        }
    };
    private CustomMessageListener gGL = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.clX() != null && DetailInfoFragment.this.clX().getPbData() != null) {
                DetailInfoFragment.this.FO((String) customResponsedMessage.getData());
                DetailInfoFragment.this.clX().coo();
                DetailInfoFragment.this.jbM.setData(DetailInfoFragment.this.clX().getPbData());
            }
        }
    };

    public static DetailInfoFragment ab(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.jbK = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.iIO = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.gGL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.iFW = (e) y.b(getFragmentActivity()).l(e.class);
        bJ(inflate);
        return inflate;
    }

    private void bJ(View view) {
        this.gtH = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.gtH.setLayoutManager(new LinearLayoutManager(getContext()));
        this.gtH.addOnScrollListener(this.mOnScrollListener);
        this.gtH.setOnTouchListener(cnD().aSu());
        this.elM = new PbListView(getContext());
        this.elM.getView();
        this.elM.setText("");
        this.elM.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.elM.setLineGone();
        this.elM.setTextColor(am.getColor(R.color.cp_cont_j));
        this.elM.setTextSize(R.dimen.tbfontsize33);
        this.elM.setNoMoreTextColorId(R.color.cp_cont_e);
        this.elM.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.elM.aHL();
        this.gtH.setNextPage(this.elM);
        this.jbM = new com.baidu.tieba.pb.videopb.a.a(this, this.gtH);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.iFW != null) {
            ctU();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gGL);
        super.onDestroy();
    }

    private void ctU() {
        com.baidu.tieba.pb.data.e ctB = this.iFW.ctB();
        if (ctB == null) {
            ctB = this.iFW.ctA();
        }
        K(ctB);
    }

    private void K(com.baidu.tieba.pb.data.e eVar) {
        if (this.iFW != null && eVar != null) {
            L(eVar);
            M(eVar);
            this.jbM.setData(eVar);
        }
    }

    private void L(com.baidu.tieba.pb.data.e eVar) {
        String str;
        String str2 = null;
        if (eVar != null) {
            if (eVar.ckP() != null) {
                str = eVar.getThreadId();
                if (eVar.ckP().getBaijiahaoData() != null) {
                    str2 = eVar.ckP().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.jbO || str2 != this.jbP) {
                ctV();
            }
            this.jbO = str;
            this.jbP = str2;
        }
    }

    private void M(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            if (v.isEmpty(eVar.clm())) {
                ctW();
                return;
            }
            ctY();
            this.elM.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void ctV() {
        if (this.gtH != null) {
            this.gtH.scrollToPosition(0);
        }
        ctY();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (eVar != null && getActivity() != null) {
            K(eVar);
        }
    }

    public PbActivity cnE() {
        return this.iIO != null ? this.iIO : this.jbK.cnE();
    }

    public VideoPbFragment cnD() {
        if (this.jbK == null && this.iIO != null) {
            Fragment cmj = this.iIO.cmj();
            if (cmj instanceof VideoPbFragment) {
                this.jbK = (VideoPbFragment) cmj;
            }
        }
        return this.jbK;
    }

    public PbModel clX() {
        return cnD().clX();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jbM != null) {
            this.jbM.notifyDataSetChanged();
        }
        if (this.elM != null) {
            this.elM.changeSkin(i);
        }
    }

    private void ctW() {
        if (this.elM != null) {
            this.elM.q(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void ctX() {
        if (this.jbM != null) {
            this.jbM.ctQ();
        }
    }

    private void ctY() {
        if (this.elM != null) {
            this.elM.aHM();
        }
    }

    public int ctZ() {
        return this.jbN;
    }

    public void re(boolean z) {
        if (this.gtH != null) {
            this.gtH.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FO(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<m> clr = clX().getPbData().clr();
            for (m mVar : clr) {
                if (TextUtils.equals(str, mVar.getAdId())) {
                    clr.remove(mVar);
                    return;
                }
            }
        }
    }
}
