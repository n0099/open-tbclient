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
    private PbListView ePm;
    private BdTypeRecyclerView hcS;
    private VideoPbFragment jLS;
    private com.baidu.tieba.pb.videopb.a.a jLU;
    private String jLW;
    private String jLX;
    private e jqd;
    private PbActivity jsV;
    private int jLV = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.jLS != null) {
                DetailInfoFragment.this.jLS.cAm();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.jLS != null && !DetailInfoFragment.this.jLS.cDX()) {
                DetailInfoFragment.this.jqd.sf(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> cEo;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.jLS != null && !DetailInfoFragment.this.jLS.cDX() && ((cEo = DetailInfoFragment.this.jqd.cEo()) == null || cEo.getValue() == null || cEo.getValue().booleanValue())) {
                DetailInfoFragment.this.jqd.sf(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.jLV != 0 && DetailInfoFragment.this.jLS != null) {
                    DetailInfoFragment.this.jLS.Ae(8);
                }
                DetailInfoFragment.this.jLV = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.jLS != null && DetailInfoFragment.this.jLV == 0) {
                DetailInfoFragment.this.jLS.Ae(0);
            }
            DetailInfoFragment.this.jLV = 2;
        }
    };
    private CustomMessageListener hqe = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.cwD() != null && DetailInfoFragment.this.cwD().getPbData() != null) {
                DetailInfoFragment.this.Hv((String) customResponsedMessage.getData());
                DetailInfoFragment.this.cwD().cyU();
                DetailInfoFragment.this.jLU.setData(DetailInfoFragment.this.cwD().getPbData());
            }
        }
    };

    public static DetailInfoFragment ab(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.jLS = videoPbFragment;
        return detailInfoFragment;
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
        MessageManager.getInstance().registerListener(this.hqe);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.jqd = (e) y.b(getFragmentActivity()).l(e.class);
        bP(inflate);
        return inflate;
    }

    private void bP(View view) {
        this.hcS = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.hcS.setLayoutManager(new LinearLayoutManager(getContext()));
        this.hcS.addOnScrollListener(this.mOnScrollListener);
        this.hcS.setOnTouchListener(cyj().baD());
        this.ePm = new PbListView(getContext());
        this.ePm.getView();
        this.ePm.setText("");
        this.ePm.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePm.setLineGone();
        this.ePm.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePm.setTextSize(R.dimen.tbfontsize33);
        this.ePm.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePm.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ePm.aQd();
        this.hcS.setNextPage(this.ePm);
        this.jLU = new com.baidu.tieba.pb.videopb.a.a(this, this.hcS);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.jqd != null) {
            cEA();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hqe);
        super.onDestroy();
    }

    private void cEA() {
        com.baidu.tieba.pb.data.e cEh = this.jqd.cEh();
        if (cEh == null) {
            cEh = this.jqd.cEg();
        }
        K(cEh);
    }

    private void K(com.baidu.tieba.pb.data.e eVar) {
        if (this.jqd != null && eVar != null) {
            L(eVar);
            M(eVar);
            this.jLU.setData(eVar);
        }
    }

    private void L(com.baidu.tieba.pb.data.e eVar) {
        String str;
        String str2 = null;
        if (eVar != null) {
            if (eVar.cvu() != null) {
                str = eVar.getThreadId();
                if (eVar.cvu().getBaijiahaoData() != null) {
                    str2 = eVar.cvu().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.jLW || str2 != this.jLX) {
                cEB();
            }
            this.jLW = str;
            this.jLX = str2;
        }
    }

    private void M(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            if (v.isEmpty(eVar.cvR())) {
                cEC();
                return;
            }
            cEE();
            this.ePm.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void cEB() {
        if (this.hcS != null) {
            this.hcS.scrollToPosition(0);
        }
        cEE();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (eVar != null && getActivity() != null) {
            K(eVar);
        }
    }

    public PbActivity cyk() {
        return this.jsV != null ? this.jsV : this.jLS.cyk();
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jLU != null) {
            this.jLU.notifyDataSetChanged();
        }
        if (this.ePm != null) {
            this.ePm.changeSkin(i);
        }
    }

    private void cEC() {
        if (this.ePm != null) {
            this.ePm.q(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void cED() {
        if (this.jLU != null) {
            this.jLU.cEw();
        }
    }

    private void cEE() {
        if (this.ePm != null) {
            this.ePm.aQe();
        }
    }

    public int cEF() {
        return this.jLV;
    }

    public void si(boolean z) {
        if (this.hcS != null) {
            this.hcS.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hv(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<m> cvW = cwD().getPbData().cvW();
            for (m mVar : cvW) {
                if (TextUtils.equals(str, mVar.getAdId())) {
                    cvW.remove(mVar);
                    return;
                }
            }
        }
    }
}
