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
    private PbListView ePr;
    private BdTypeRecyclerView hcY;
    private VideoPbFragment jLW;
    private com.baidu.tieba.pb.videopb.a.a jLY;
    private String jMa;
    private String jMb;
    private e jqh;
    private PbActivity jsZ;
    private int jLZ = 0;
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 1 && DetailInfoFragment.this.jLW != null) {
                DetailInfoFragment.this.jLW.cAj();
            }
            if (i == 0 && !recyclerView.canScrollVertically(-1) && DetailInfoFragment.this.jLW != null && !DetailInfoFragment.this.jLW.cDU()) {
                DetailInfoFragment.this.jqh.sf(true);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            p<Boolean> cEl;
            super.onScrolled(recyclerView, i, i2);
            boolean canScrollVertically = recyclerView.canScrollVertically(-1);
            if (canScrollVertically && i2 > 0 && DetailInfoFragment.this.jLW != null && !DetailInfoFragment.this.jLW.cDU() && ((cEl = DetailInfoFragment.this.jqh.cEl()) == null || cEl.getValue() == null || cEl.getValue().booleanValue())) {
                DetailInfoFragment.this.jqh.sf(false);
            }
            if (!canScrollVertically) {
                if (Math.abs(i2) > 0 && DetailInfoFragment.this.jLZ != 0 && DetailInfoFragment.this.jLW != null) {
                    DetailInfoFragment.this.jLW.Ae(8);
                }
                DetailInfoFragment.this.jLZ = 0;
                return;
            }
            if (Math.abs(i2) > 0 && DetailInfoFragment.this.jLW != null && DetailInfoFragment.this.jLZ == 0) {
                DetailInfoFragment.this.jLW.Ae(0);
            }
            DetailInfoFragment.this.jLZ = 2;
        }
    };
    private CustomMessageListener hqk = new CustomMessageListener(CmdConfigCustom.DELETE_AD_FROM_FEED) { // from class: com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && DetailInfoFragment.this.cwA() != null && DetailInfoFragment.this.cwA().getPbData() != null) {
                DetailInfoFragment.this.Hy((String) customResponsedMessage.getData());
                DetailInfoFragment.this.cwA().cyR();
                DetailInfoFragment.this.jLY.setData(DetailInfoFragment.this.cwA().getPbData());
            }
        }
    };

    public static DetailInfoFragment ab(VideoPbFragment videoPbFragment) {
        Bundle bundle = new Bundle();
        DetailInfoFragment detailInfoFragment = new DetailInfoFragment();
        detailInfoFragment.setArguments(bundle);
        detailInfoFragment.jLW = videoPbFragment;
        return detailInfoFragment;
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PbActivity) {
            this.jsZ = (PbActivity) context;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        MessageManager.getInstance().registerListener(this.hqk);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_detail_info_fragment, viewGroup, false);
        this.jqh = (e) y.b(getFragmentActivity()).l(e.class);
        bP(inflate);
        return inflate;
    }

    private void bP(View view) {
        this.hcY = (BdTypeRecyclerView) view.findViewById(R.id.pb_detail_info_list);
        this.hcY.setLayoutManager(new LinearLayoutManager(getContext()));
        this.hcY.addOnScrollListener(this.mOnScrollListener);
        this.hcY.setOnTouchListener(cyg().baB());
        this.ePr = new PbListView(getContext());
        this.ePr.getView();
        this.ePr.setText("");
        this.ePr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.ePr.setLineGone();
        this.ePr.setTextColor(am.getColor(R.color.cp_cont_j));
        this.ePr.setTextSize(R.dimen.tbfontsize33);
        this.ePr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.ePr.setHeight(l.getDimens(getContext(), R.dimen.tbds182));
        this.ePr.aQa();
        this.hcY.setNextPage(this.ePr);
        this.jLY = new com.baidu.tieba.pb.videopb.a.a(this, this.hcY);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.jqh != null) {
            cEx();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hqk);
        super.onDestroy();
    }

    private void cEx() {
        com.baidu.tieba.pb.data.e cEe = this.jqh.cEe();
        if (cEe == null) {
            cEe = this.jqh.cEd();
        }
        K(cEe);
    }

    private void K(com.baidu.tieba.pb.data.e eVar) {
        if (this.jqh != null && eVar != null) {
            L(eVar);
            M(eVar);
            this.jLY.setData(eVar);
        }
    }

    private void L(com.baidu.tieba.pb.data.e eVar) {
        String str;
        String str2 = null;
        if (eVar != null) {
            if (eVar.cvr() != null) {
                str = eVar.getThreadId();
                if (eVar.cvr().getBaijiahaoData() != null) {
                    str2 = eVar.cvr().getBaijiahaoData().oriUgcNid;
                }
            } else {
                str = null;
            }
            if (str != this.jMa || str2 != this.jMb) {
                cEy();
            }
            this.jMa = str;
            this.jMb = str2;
        }
    }

    private void M(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            if (v.isEmpty(eVar.cvO())) {
                cEz();
                return;
            }
            cEB();
            this.ePr.setText(getString(R.string.recommend_no_more_data));
        }
    }

    private void cEy() {
        if (this.hcY != null) {
            this.hcY.scrollToPosition(0);
        }
        cEB();
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        if (eVar != null && getActivity() != null) {
            K(eVar);
        }
    }

    public PbActivity cyh() {
        return this.jsZ != null ? this.jsZ : this.jLW.cyh();
    }

    public VideoPbFragment cyg() {
        if (this.jLW == null && this.jsZ != null) {
            Fragment cwM = this.jsZ.cwM();
            if (cwM instanceof VideoPbFragment) {
                this.jLW = (VideoPbFragment) cwM;
            }
        }
        return this.jLW;
    }

    public PbModel cwA() {
        return cyg().cwA();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jLY != null) {
            this.jLY.notifyDataSetChanged();
        }
        if (this.ePr != null) {
            this.ePr.changeSkin(i);
        }
    }

    private void cEz() {
        if (this.ePr != null) {
            this.ePr.q(getString(R.string.no_relevant_content), R.drawable.new_pic_emotion_08, l.getDimens(TbadkApplication.getInst(), R.dimen.tbds256));
        }
    }

    public void cEA() {
        if (this.jLY != null) {
            this.jLY.cEt();
        }
    }

    private void cEB() {
        if (this.ePr != null) {
            this.ePr.aQb();
        }
    }

    public int cEC() {
        return this.jLZ;
    }

    public void si(boolean z) {
        if (this.hcY != null) {
            this.hcY.setCanFling(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hy(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<m> cvT = cwA().getPbData().cvT();
            for (m mVar : cvT) {
                if (TextUtils.equals(str, mVar.getAdId())) {
                    cvT.remove(mVar);
                    return;
                }
            }
        }
    }
}
